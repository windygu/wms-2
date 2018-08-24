package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPhysicalInventoryApplicationService implements PhysicalInventoryApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private PhysicalInventoryStateRepository stateRepository;

    protected PhysicalInventoryStateRepository getStateRepository() {
        return stateRepository;
    }

    private PhysicalInventoryStateQueryRepository stateQueryRepository;

    protected PhysicalInventoryStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<PhysicalInventoryAggregate, PhysicalInventoryState> aggregateEventListener;

    public AggregateEventListener<PhysicalInventoryAggregate, PhysicalInventoryState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<PhysicalInventoryAggregate, PhysicalInventoryState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractPhysicalInventoryApplicationService(EventStore eventStore, PhysicalInventoryStateRepository stateRepository, PhysicalInventoryStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(PhysicalInventoryCommand.CreatePhysicalInventory c) {
        update(c, ar -> ar.create(c));
    }

    public void when(PhysicalInventoryCommand.MergePatchPhysicalInventory c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(PhysicalInventoryCommands.CountItem c) {
        update(c, ar -> ar.countItem(c.getLocatorId(), c.getProductId(), c.getAttributeSetInstance(), c.getCountedQuantity(), c.getVersion(), c.getCommandId(), c.getRequesterId()));
    }

    public void when(PhysicalInventoryCommands.DocumentAction c) {
        update(c, ar -> ar.documentAction(c.getValue(), c.getVersion(), c.getCommandId(), c.getRequesterId()));
    }

    public PhysicalInventoryState get(String id) {
        PhysicalInventoryState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<PhysicalInventoryState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<PhysicalInventoryState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PhysicalInventoryState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PhysicalInventoryState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public PhysicalInventoryEvent getEvent(String documentNumber, long version) {
        PhysicalInventoryEvent e = (PhysicalInventoryEvent)getEventStore().getEvent(toEventStoreAggregateId(documentNumber), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(documentNumber, 0);
        }
        return e;
    }

    public PhysicalInventoryState getHistoryState(String documentNumber, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractPhysicalInventoryEvent.class, toEventStoreAggregateId(documentNumber), version - 1);
        return new AbstractPhysicalInventoryState.SimplePhysicalInventoryState(eventStream.getEvents());
    }

    public PhysicalInventoryLineState getPhysicalInventoryLine(String physicalInventoryDocumentNumber, InventoryItemId inventoryItemId) {
        return getStateQueryRepository().getPhysicalInventoryLine(physicalInventoryDocumentNumber, inventoryItemId);
    }

    public Iterable<PhysicalInventoryLineState> getPhysicalInventoryLines(String physicalInventoryDocumentNumber, Criterion filter, List<String> orders) {
        return getStateQueryRepository().getPhysicalInventoryLines(physicalInventoryDocumentNumber, filter, orders);
    }


    public PhysicalInventoryAggregate getPhysicalInventoryAggregate(PhysicalInventoryState state)
    {
        return new AbstractPhysicalInventoryAggregate.SimplePhysicalInventoryAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(PhysicalInventoryCommand c, Consumer<PhysicalInventoryAggregate> action)
    {
        String aggregateId = c.getDocumentNumber();
        PhysicalInventoryState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        PhysicalInventoryAggregate aggregate = getPhysicalInventoryAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, PhysicalInventoryAggregate aggregate, PhysicalInventoryState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(PhysicalInventoryEvent.PhysicalInventoryStateCreated stateCreated) {
        String aggregateId = stateCreated.getPhysicalInventoryEventId().getDocumentNumber();
        PhysicalInventoryState state = new AbstractPhysicalInventoryState.SimplePhysicalInventoryState();
        state.setDocumentNumber(aggregateId);

        PhysicalInventoryAggregate aggregate = getPhysicalInventoryAggregate(state);
        ((AbstractPhysicalInventoryAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getPhysicalInventoryEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(PhysicalInventoryCommand command, EventStoreAggregateId eventStoreAggregateId, PhysicalInventoryState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(PhysicalInventoryState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractPhysicalInventoryEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimplePhysicalInventoryApplicationService extends AbstractPhysicalInventoryApplicationService 
    {
        public SimplePhysicalInventoryApplicationService(EventStore eventStore, PhysicalInventoryStateRepository stateRepository, PhysicalInventoryStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

