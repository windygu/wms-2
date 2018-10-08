package org.dddml.wms.domain.warehouse;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractWarehouseApplicationService implements WarehouseApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private WarehouseStateRepository stateRepository;

    protected WarehouseStateRepository getStateRepository() {
        return stateRepository;
    }

    private WarehouseStateQueryRepository stateQueryRepository;

    protected WarehouseStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<WarehouseAggregate, WarehouseState> aggregateEventListener;

    public AggregateEventListener<WarehouseAggregate, WarehouseState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<WarehouseAggregate, WarehouseState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractWarehouseApplicationService(EventStore eventStore, WarehouseStateRepository stateRepository, WarehouseStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(WarehouseCommand.CreateWarehouse c) {
        update(c, ar -> ar.create(c));
    }

    public void when(WarehouseCommand.MergePatchWarehouse c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(WarehouseCommand.DeleteWarehouse c) {
        update(c, ar -> ar.delete(c));
    }

    public WarehouseState get(String id) {
        WarehouseState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<WarehouseState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<WarehouseState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<WarehouseState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<WarehouseState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public WarehouseEvent getEvent(String warehouseId, long version) {
        WarehouseEvent e = (WarehouseEvent)getEventStore().getEvent(toEventStoreAggregateId(warehouseId), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(warehouseId, 0);
        }
        return e;
    }

    public WarehouseState getHistoryState(String warehouseId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractWarehouseEvent.class, toEventStoreAggregateId(warehouseId), version - 1);
        return new AbstractWarehouseState.SimpleWarehouseState(eventStream.getEvents());
    }


    public WarehouseAggregate getWarehouseAggregate(WarehouseState state)
    {
        return new AbstractWarehouseAggregate.SimpleWarehouseAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(WarehouseCommand c, Consumer<WarehouseAggregate> action)
    {
        String aggregateId = c.getWarehouseId();
        WarehouseState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        WarehouseAggregate aggregate = getWarehouseAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, WarehouseAggregate aggregate, WarehouseState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(WarehouseEvent.WarehouseStateCreated stateCreated) {
        String aggregateId = ((WarehouseEvent.SqlWarehouseEvent)stateCreated).getWarehouseEventId().getWarehouseId();
        WarehouseState state = new AbstractWarehouseState.SimpleWarehouseState();
        state.setWarehouseId(aggregateId);

        WarehouseAggregate aggregate = getWarehouseAggregate(state);
        ((AbstractWarehouseAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((WarehouseEvent.SqlWarehouseEvent)stateCreated).getWarehouseEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(WarehouseCommand command, EventStoreAggregateId eventStoreAggregateId, WarehouseState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(WarehouseState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractWarehouseEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleWarehouseApplicationService extends AbstractWarehouseApplicationService 
    {
        public SimpleWarehouseApplicationService(EventStore eventStore, WarehouseStateRepository stateRepository, WarehouseStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

