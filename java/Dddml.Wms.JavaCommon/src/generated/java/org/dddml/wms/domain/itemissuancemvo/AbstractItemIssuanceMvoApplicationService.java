package org.dddml.wms.domain.itemissuancemvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractItemIssuanceMvoApplicationService implements ItemIssuanceMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private ItemIssuanceMvoStateRepository stateRepository;

    protected ItemIssuanceMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private ItemIssuanceMvoStateQueryRepository stateQueryRepository;

    protected ItemIssuanceMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<ItemIssuanceMvoAggregate, ItemIssuanceMvoState> aggregateEventListener;

    public AggregateEventListener<ItemIssuanceMvoAggregate, ItemIssuanceMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<ItemIssuanceMvoAggregate, ItemIssuanceMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractItemIssuanceMvoApplicationService(EventStore eventStore, ItemIssuanceMvoStateRepository stateRepository, ItemIssuanceMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ItemIssuanceMvoCommand.CreateItemIssuanceMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(ItemIssuanceMvoCommand.MergePatchItemIssuanceMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(ItemIssuanceMvoCommand.DeleteItemIssuanceMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public ItemIssuanceMvoState get(ShipmentItemIssuanceId id) {
        ItemIssuanceMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<ItemIssuanceMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<ItemIssuanceMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ItemIssuanceMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ItemIssuanceMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public ItemIssuanceMvoStateEvent getStateEvent(ShipmentItemIssuanceId shipmentItemIssuanceId, long version) {
        ItemIssuanceMvoStateEvent e = (ItemIssuanceMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(shipmentItemIssuanceId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(shipmentItemIssuanceId, 0);
        }
        return e;
    }

    public ItemIssuanceMvoState getHistoryState(ShipmentItemIssuanceId shipmentItemIssuanceId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractItemIssuanceMvoStateEvent.class, toEventStoreAggregateId(shipmentItemIssuanceId), version - 1);
        return new AbstractItemIssuanceMvoState.SimpleItemIssuanceMvoState(eventStream.getEvents());
    }


    public ItemIssuanceMvoAggregate getItemIssuanceMvoAggregate(ItemIssuanceMvoState state)
    {
        return new AbstractItemIssuanceMvoAggregate.SimpleItemIssuanceMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(ShipmentItemIssuanceId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ItemIssuanceMvoCommand c, Consumer<ItemIssuanceMvoAggregate> action)
    {
        ShipmentItemIssuanceId aggregateId = c.getShipmentItemIssuanceId();
        ItemIssuanceMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        ItemIssuanceMvoAggregate aggregate = getItemIssuanceMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getShipmentVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ItemIssuanceMvoAggregate aggregate, ItemIssuanceMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(ItemIssuanceMvoStateEvent.ItemIssuanceMvoStateCreated stateCreated) {
        ShipmentItemIssuanceId aggregateId = stateCreated.getItemIssuanceMvoEventId().getShipmentItemIssuanceId();
        ItemIssuanceMvoState state = new AbstractItemIssuanceMvoState.SimpleItemIssuanceMvoState();
        state.setShipmentItemIssuanceId(aggregateId);

        ItemIssuanceMvoAggregate aggregate = getItemIssuanceMvoAggregate(state);
        ((AbstractItemIssuanceMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getItemIssuanceMvoEventId().getShipmentVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(ItemIssuanceMvoCommand command, EventStoreAggregateId eventStoreAggregateId, ItemIssuanceMvoState state)
    {
        boolean repeated = false;
        if (command.getShipmentVersion() == null) { command.setShipmentVersion(ItemIssuanceMvoState.VERSION_NULL); }
        if (state.getShipmentVersion() != null && state.getShipmentVersion() > command.getShipmentVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractItemIssuanceMvoStateEvent.class, eventStoreAggregateId, command.getShipmentVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleItemIssuanceMvoApplicationService extends AbstractItemIssuanceMvoApplicationService 
    {
        public SimpleItemIssuanceMvoApplicationService(EventStore eventStore, ItemIssuanceMvoStateRepository stateRepository, ItemIssuanceMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

