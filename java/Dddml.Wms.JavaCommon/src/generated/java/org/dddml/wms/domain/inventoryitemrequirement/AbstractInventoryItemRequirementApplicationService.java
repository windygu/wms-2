package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInventoryItemRequirementApplicationService implements InventoryItemRequirementApplicationService
{
    private InventoryItemRequirementStateRepository stateRepository;

    protected InventoryItemRequirementStateRepository getStateRepository() {
        return stateRepository;
    }

    private InventoryItemRequirementStateQueryRepository stateQueryRepository;

    protected InventoryItemRequirementStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<InventoryItemRequirementAggregate, InventoryItemRequirementState> aggregateEventListener;

    public AggregateEventListener<InventoryItemRequirementAggregate, InventoryItemRequirementState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<InventoryItemRequirementAggregate, InventoryItemRequirementState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractInventoryItemRequirementApplicationService(InventoryItemRequirementStateRepository stateRepository, InventoryItemRequirementStateQueryRepository stateQueryRepository) {
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(InventoryItemRequirementCommand.CreateInventoryItemRequirement c) {
        update(c, ar -> ar.create(c));
    }

    public void when(InventoryItemRequirementCommand.MergePatchInventoryItemRequirement c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public InventoryItemRequirementState get(InventoryItemId id) {
        InventoryItemRequirementState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<InventoryItemRequirementState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<InventoryItemRequirementState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InventoryItemRequirementState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InventoryItemRequirementState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public InventoryItemRequirementEntryState getInventoryItemRequirementEntry(InventoryItemId inventoryItemRequirementId, Long entrySeqId) {
        return getStateQueryRepository().getInventoryItemRequirementEntry(inventoryItemRequirementId, entrySeqId);
    }


    public InventoryItemRequirementAggregate getInventoryItemRequirementAggregate(InventoryItemRequirementState state)
    {
        return new AbstractInventoryItemRequirementAggregate.SimpleInventoryItemRequirementAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(InventoryItemId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(InventoryItemRequirementCommand c, Consumer<InventoryItemRequirementAggregate> action)
    {
        InventoryItemId aggregateId = c.getInventoryItemRequirementId();
        InventoryItemRequirementState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        InventoryItemRequirementAggregate aggregate = getInventoryItemRequirementAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, InventoryItemRequirementAggregate aggregate, InventoryItemRequirementState state) {
        getStateRepository().save(state);
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(InventoryItemRequirementStateEvent.InventoryItemRequirementStateCreated stateCreated) {
        InventoryItemId aggregateId = stateCreated.getInventoryItemRequirementEventId().getInventoryItemRequirementId();
        InventoryItemRequirementState state = new AbstractInventoryItemRequirementState.SimpleInventoryItemRequirementState();
        state.setInventoryItemRequirementId(aggregateId);

        InventoryItemRequirementAggregate aggregate = getInventoryItemRequirementAggregate(state);
        ((AbstractInventoryItemRequirementAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getInventoryItemRequirementEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(InventoryItemRequirementCommand command, EventStoreAggregateId eventStoreAggregateId, InventoryItemRequirementState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(InventoryItemRequirementState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() == command.getVersion() + 1)
        {
            if (command.getCommandId() != null && command.getCommandId().equals(state.getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleInventoryItemRequirementApplicationService extends AbstractInventoryItemRequirementApplicationService 
    {
        public SimpleInventoryItemRequirementApplicationService(InventoryItemRequirementStateRepository stateRepository, InventoryItemRequirementStateQueryRepository stateQueryRepository)
        {
            super(stateRepository, stateQueryRepository);
        }
    }

}

