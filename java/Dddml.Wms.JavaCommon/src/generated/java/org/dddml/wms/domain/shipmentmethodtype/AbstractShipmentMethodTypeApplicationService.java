package org.dddml.wms.domain.shipmentmethodtype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentMethodTypeApplicationService implements ShipmentMethodTypeApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private ShipmentMethodTypeStateRepository stateRepository;

    protected ShipmentMethodTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private ShipmentMethodTypeStateQueryRepository stateQueryRepository;

    protected ShipmentMethodTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<ShipmentMethodTypeAggregate, ShipmentMethodTypeState> aggregateEventListener;

    public AggregateEventListener<ShipmentMethodTypeAggregate, ShipmentMethodTypeState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<ShipmentMethodTypeAggregate, ShipmentMethodTypeState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractShipmentMethodTypeApplicationService(EventStore eventStore, ShipmentMethodTypeStateRepository stateRepository, ShipmentMethodTypeStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ShipmentMethodTypeCommand.CreateShipmentMethodType c) {
        update(c, ar -> ar.create(c));
    }

    public void when(ShipmentMethodTypeCommand.MergePatchShipmentMethodType c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(ShipmentMethodTypeCommand.DeleteShipmentMethodType c) {
        update(c, ar -> ar.delete(c));
    }

    public ShipmentMethodTypeState get(String id) {
        ShipmentMethodTypeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<ShipmentMethodTypeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<ShipmentMethodTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentMethodTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentMethodTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public ShipmentMethodTypeEvent getEvent(String shipmentMethodTypeId, long version) {
        ShipmentMethodTypeEvent e = (ShipmentMethodTypeEvent)getEventStore().getEvent(toEventStoreAggregateId(shipmentMethodTypeId), version);
        if (e != null) {
            ((ShipmentMethodTypeEvent.SqlShipmentMethodTypeEvent)e).setEventReadOnly(true); 
        } else if (version == -1) {
            return getEvent(shipmentMethodTypeId, 0);
        }
        return e;
    }

    public ShipmentMethodTypeState getHistoryState(String shipmentMethodTypeId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractShipmentMethodTypeEvent.class, toEventStoreAggregateId(shipmentMethodTypeId), version - 1);
        return new AbstractShipmentMethodTypeState.SimpleShipmentMethodTypeState(eventStream.getEvents());
    }


    public ShipmentMethodTypeAggregate getShipmentMethodTypeAggregate(ShipmentMethodTypeState state)
    {
        return new AbstractShipmentMethodTypeAggregate.SimpleShipmentMethodTypeAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ShipmentMethodTypeCommand c, Consumer<ShipmentMethodTypeAggregate> action)
    {
        String aggregateId = c.getShipmentMethodTypeId();
        ShipmentMethodTypeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        ShipmentMethodTypeAggregate aggregate = getShipmentMethodTypeAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ShipmentMethodTypeAggregate aggregate, ShipmentMethodTypeState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(ShipmentMethodTypeEvent.ShipmentMethodTypeStateCreated stateCreated) {
        String aggregateId = ((ShipmentMethodTypeEvent.SqlShipmentMethodTypeEvent)stateCreated).getShipmentMethodTypeEventId().getShipmentMethodTypeId();
        ShipmentMethodTypeState state = new AbstractShipmentMethodTypeState.SimpleShipmentMethodTypeState();
        state.setShipmentMethodTypeId(aggregateId);

        ShipmentMethodTypeAggregate aggregate = getShipmentMethodTypeAggregate(state);
        ((AbstractShipmentMethodTypeAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((ShipmentMethodTypeEvent.SqlShipmentMethodTypeEvent)stateCreated).getShipmentMethodTypeEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(ShipmentMethodTypeCommand command, EventStoreAggregateId eventStoreAggregateId, ShipmentMethodTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(ShipmentMethodTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractShipmentMethodTypeEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleShipmentMethodTypeApplicationService extends AbstractShipmentMethodTypeApplicationService 
    {
        public SimpleShipmentMethodTypeApplicationService(EventStore eventStore, ShipmentMethodTypeStateRepository stateRepository, ShipmentMethodTypeStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

