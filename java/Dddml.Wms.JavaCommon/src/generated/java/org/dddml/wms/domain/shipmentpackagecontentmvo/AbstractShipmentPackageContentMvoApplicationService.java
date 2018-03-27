package org.dddml.wms.domain.shipmentpackagecontentmvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentPackageContentMvoApplicationService implements ShipmentPackageContentMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private ShipmentPackageContentMvoStateRepository stateRepository;

    protected ShipmentPackageContentMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private ShipmentPackageContentMvoStateQueryRepository stateQueryRepository;

    protected ShipmentPackageContentMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<ShipmentPackageContentMvoAggregate, ShipmentPackageContentMvoState> aggregateEventListener;

    public AggregateEventListener<ShipmentPackageContentMvoAggregate, ShipmentPackageContentMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<ShipmentPackageContentMvoAggregate, ShipmentPackageContentMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractShipmentPackageContentMvoApplicationService(EventStore eventStore, ShipmentPackageContentMvoStateRepository stateRepository, ShipmentPackageContentMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ShipmentPackageContentMvoCommand.CreateShipmentPackageContentMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(ShipmentPackageContentMvoCommand.MergePatchShipmentPackageContentMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(ShipmentPackageContentMvoCommand.DeleteShipmentPackageContentMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public ShipmentPackageContentMvoState get(ShipmentPackageContentId id) {
        ShipmentPackageContentMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<ShipmentPackageContentMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<ShipmentPackageContentMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentPackageContentMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentPackageContentMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public ShipmentPackageContentMvoStateEvent getStateEvent(ShipmentPackageContentId shipmentPackageContentId, long version) {
        ShipmentPackageContentMvoStateEvent e = (ShipmentPackageContentMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(shipmentPackageContentId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(shipmentPackageContentId, 0);
        }
        return e;
    }

    public ShipmentPackageContentMvoState getHistoryState(ShipmentPackageContentId shipmentPackageContentId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractShipmentPackageContentMvoStateEvent.class, toEventStoreAggregateId(shipmentPackageContentId), version - 1);
        return new AbstractShipmentPackageContentMvoState.SimpleShipmentPackageContentMvoState(eventStream.getEvents());
    }


    public ShipmentPackageContentMvoAggregate getShipmentPackageContentMvoAggregate(ShipmentPackageContentMvoState state)
    {
        return new AbstractShipmentPackageContentMvoAggregate.SimpleShipmentPackageContentMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(ShipmentPackageContentId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ShipmentPackageContentMvoCommand c, Consumer<ShipmentPackageContentMvoAggregate> action)
    {
        ShipmentPackageContentId aggregateId = c.getShipmentPackageContentId();
        ShipmentPackageContentMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        ShipmentPackageContentMvoAggregate aggregate = getShipmentPackageContentMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getShipmentPackageVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ShipmentPackageContentMvoAggregate aggregate, ShipmentPackageContentMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(ShipmentPackageContentMvoStateEvent.ShipmentPackageContentMvoStateCreated stateCreated) {
        ShipmentPackageContentId aggregateId = stateCreated.getShipmentPackageContentMvoEventId().getShipmentPackageContentId();
        ShipmentPackageContentMvoState state = new AbstractShipmentPackageContentMvoState.SimpleShipmentPackageContentMvoState();
        state.setShipmentPackageContentId(aggregateId);

        ShipmentPackageContentMvoAggregate aggregate = getShipmentPackageContentMvoAggregate(state);
        ((AbstractShipmentPackageContentMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getShipmentPackageContentMvoEventId().getShipmentPackageVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(ShipmentPackageContentMvoCommand command, EventStoreAggregateId eventStoreAggregateId, ShipmentPackageContentMvoState state)
    {
        boolean repeated = false;
        if (command.getShipmentPackageVersion() == null) { command.setShipmentPackageVersion(ShipmentPackageContentMvoState.VERSION_NULL); }
        if (state.getShipmentPackageVersion() != null && state.getShipmentPackageVersion() > command.getShipmentPackageVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractShipmentPackageContentMvoStateEvent.class, eventStoreAggregateId, command.getShipmentPackageVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleShipmentPackageContentMvoApplicationService extends AbstractShipmentPackageContentMvoApplicationService 
    {
        public SimpleShipmentPackageContentMvoApplicationService(EventStore eventStore, ShipmentPackageContentMvoStateRepository stateRepository, ShipmentPackageContentMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

