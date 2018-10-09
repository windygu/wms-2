package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentPackageApplicationService implements ShipmentPackageApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private ShipmentPackageStateRepository stateRepository;

    protected ShipmentPackageStateRepository getStateRepository() {
        return stateRepository;
    }

    private ShipmentPackageStateQueryRepository stateQueryRepository;

    protected ShipmentPackageStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<ShipmentPackageAggregate, ShipmentPackageState> aggregateEventListener;

    public AggregateEventListener<ShipmentPackageAggregate, ShipmentPackageState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<ShipmentPackageAggregate, ShipmentPackageState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractShipmentPackageApplicationService(EventStore eventStore, ShipmentPackageStateRepository stateRepository, ShipmentPackageStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ShipmentPackageCommand.CreateShipmentPackage c) {
        update(c, ar -> ar.create(c));
    }

    public void when(ShipmentPackageCommand.MergePatchShipmentPackage c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(ShipmentPackageCommand.DeleteShipmentPackage c) {
        update(c, ar -> ar.delete(c));
    }

    public ShipmentPackageState get(ShipmentPackageId id) {
        ShipmentPackageState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<ShipmentPackageState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<ShipmentPackageState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentPackageState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentPackageState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public ShipmentPackageEvent getEvent(ShipmentPackageId shipmentPackageId, long version) {
        ShipmentPackageEvent e = (ShipmentPackageEvent)getEventStore().getEvent(toEventStoreAggregateId(shipmentPackageId), version);
        if (e != null) {
            ((ShipmentPackageEvent.SqlShipmentPackageEvent)e).setEventReadOnly(true); 
        } else if (version == -1) {
            return getEvent(shipmentPackageId, 0);
        }
        return e;
    }

    public ShipmentPackageState getHistoryState(ShipmentPackageId shipmentPackageId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractShipmentPackageEvent.class, toEventStoreAggregateId(shipmentPackageId), version - 1);
        return new AbstractShipmentPackageState.SimpleShipmentPackageState(eventStream.getEvents());
    }

    public ShipmentPackageContentState getShipmentPackageContent(ShipmentPackageId shipmentPackageId, String shipmentItemSeqId) {
        return getStateQueryRepository().getShipmentPackageContent(shipmentPackageId, shipmentItemSeqId);
    }

    public Iterable<ShipmentPackageContentState> getShipmentPackageContents(ShipmentPackageId shipmentPackageId, Criterion filter, List<String> orders) {
        return getStateQueryRepository().getShipmentPackageContents(shipmentPackageId, filter, orders);
    }


    public ShipmentPackageAggregate getShipmentPackageAggregate(ShipmentPackageState state)
    {
        return new AbstractShipmentPackageAggregate.SimpleShipmentPackageAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(ShipmentPackageId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ShipmentPackageCommand c, Consumer<ShipmentPackageAggregate> action)
    {
        ShipmentPackageId aggregateId = c.getShipmentPackageId();
        ShipmentPackageState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        ShipmentPackageAggregate aggregate = getShipmentPackageAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ShipmentPackageAggregate aggregate, ShipmentPackageState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(ShipmentPackageEvent.ShipmentPackageStateCreated stateCreated) {
        ShipmentPackageId aggregateId = ((ShipmentPackageEvent.SqlShipmentPackageEvent)stateCreated).getShipmentPackageEventId().getShipmentPackageId();
        ShipmentPackageState.SqlShipmentPackageState state = new AbstractShipmentPackageState.SimpleShipmentPackageState();
        state.setShipmentPackageId(aggregateId);

        ShipmentPackageAggregate aggregate = getShipmentPackageAggregate(state);
        ((AbstractShipmentPackageAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((ShipmentPackageEvent.SqlShipmentPackageEvent)stateCreated).getShipmentPackageEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(ShipmentPackageCommand command, EventStoreAggregateId eventStoreAggregateId, ShipmentPackageState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(ShipmentPackageState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractShipmentPackageEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleShipmentPackageApplicationService extends AbstractShipmentPackageApplicationService 
    {
        public SimpleShipmentPackageApplicationService(EventStore eventStore, ShipmentPackageStateRepository stateRepository, ShipmentPackageStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

