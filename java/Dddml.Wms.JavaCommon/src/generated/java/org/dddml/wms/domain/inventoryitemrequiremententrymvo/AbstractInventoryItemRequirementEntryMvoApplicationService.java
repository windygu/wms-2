package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryItemRequirementEntryMvoApplicationService implements InventoryItemRequirementEntryMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private InventoryItemRequirementEntryMvoStateRepository stateRepository;

    protected InventoryItemRequirementEntryMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private InventoryItemRequirementEntryMvoStateQueryRepository stateQueryRepository;

    protected InventoryItemRequirementEntryMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<InventoryItemRequirementEntryMvoAggregate, InventoryItemRequirementEntryMvoState> aggregateEventListener;

    public AggregateEventListener<InventoryItemRequirementEntryMvoAggregate, InventoryItemRequirementEntryMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<InventoryItemRequirementEntryMvoAggregate, InventoryItemRequirementEntryMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractInventoryItemRequirementEntryMvoApplicationService(EventStore eventStore, InventoryItemRequirementEntryMvoStateRepository stateRepository, InventoryItemRequirementEntryMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(InventoryItemRequirementEntryMvoCommand.CreateInventoryItemRequirementEntryMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(InventoryItemRequirementEntryMvoCommand.MergePatchInventoryItemRequirementEntryMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public InventoryItemRequirementEntryMvoState get(InventoryItemRequirementEntryId id) {
        InventoryItemRequirementEntryMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<InventoryItemRequirementEntryMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<InventoryItemRequirementEntryMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InventoryItemRequirementEntryMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InventoryItemRequirementEntryMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public InventoryItemRequirementEntryMvoStateEvent getStateEvent(InventoryItemRequirementEntryId inventoryItemRequirementEntryId, long version) {
        InventoryItemRequirementEntryMvoStateEvent e = (InventoryItemRequirementEntryMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(inventoryItemRequirementEntryId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(inventoryItemRequirementEntryId, 0);
        }
        return e;
    }

    public InventoryItemRequirementEntryMvoState getHistoryState(InventoryItemRequirementEntryId inventoryItemRequirementEntryId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractInventoryItemRequirementEntryMvoStateEvent.class, toEventStoreAggregateId(inventoryItemRequirementEntryId), version - 1);
        return new AbstractInventoryItemRequirementEntryMvoState.SimpleInventoryItemRequirementEntryMvoState(eventStream.getEvents());
    }


    public InventoryItemRequirementEntryMvoAggregate getInventoryItemRequirementEntryMvoAggregate(InventoryItemRequirementEntryMvoState state)
    {
        return new AbstractInventoryItemRequirementEntryMvoAggregate.SimpleInventoryItemRequirementEntryMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(InventoryItemRequirementEntryId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(InventoryItemRequirementEntryMvoCommand c, Consumer<InventoryItemRequirementEntryMvoAggregate> action)
    {
        InventoryItemRequirementEntryId aggregateId = c.getInventoryItemRequirementEntryId();
        InventoryItemRequirementEntryMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        InventoryItemRequirementEntryMvoAggregate aggregate = getInventoryItemRequirementEntryMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getInventoryItemRequirementVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, InventoryItemRequirementEntryMvoAggregate aggregate, InventoryItemRequirementEntryMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(InventoryItemRequirementEntryMvoStateEvent.InventoryItemRequirementEntryMvoStateCreated stateCreated) {
        InventoryItemRequirementEntryId aggregateId = stateCreated.getInventoryItemRequirementEntryMvoEventId().getInventoryItemRequirementEntryId();
        InventoryItemRequirementEntryMvoState state = new AbstractInventoryItemRequirementEntryMvoState.SimpleInventoryItemRequirementEntryMvoState();
        state.setInventoryItemRequirementEntryId(aggregateId);

        InventoryItemRequirementEntryMvoAggregate aggregate = getInventoryItemRequirementEntryMvoAggregate(state);
        ((AbstractInventoryItemRequirementEntryMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getInventoryItemRequirementEntryMvoEventId().getInventoryItemRequirementVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(InventoryItemRequirementEntryMvoCommand command, EventStoreAggregateId eventStoreAggregateId, InventoryItemRequirementEntryMvoState state)
    {
        boolean repeated = false;
        if (command.getInventoryItemRequirementVersion() == null) { command.setInventoryItemRequirementVersion(InventoryItemRequirementEntryMvoState.VERSION_NULL); }
        if (state.getInventoryItemRequirementVersion() != null && state.getInventoryItemRequirementVersion() > command.getInventoryItemRequirementVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractInventoryItemRequirementEntryMvoStateEvent.class, eventStoreAggregateId, command.getInventoryItemRequirementVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleInventoryItemRequirementEntryMvoApplicationService extends AbstractInventoryItemRequirementEntryMvoApplicationService 
    {
        public SimpleInventoryItemRequirementEntryMvoApplicationService(EventStore eventStore, InventoryItemRequirementEntryMvoStateRepository stateRepository, InventoryItemRequirementEntryMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

