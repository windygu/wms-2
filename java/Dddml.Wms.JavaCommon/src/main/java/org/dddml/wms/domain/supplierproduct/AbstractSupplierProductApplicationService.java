package org.dddml.wms.domain.supplierproduct;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractSupplierProductApplicationService implements SupplierProductApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private SupplierProductStateRepository stateRepository;

    protected SupplierProductStateRepository getStateRepository() {
        return stateRepository;
    }

    private SupplierProductStateQueryRepository stateQueryRepository;

    protected SupplierProductStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<SupplierProductAggregate, SupplierProductState> aggregateEventListener;

    public AggregateEventListener<SupplierProductAggregate, SupplierProductState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<SupplierProductAggregate, SupplierProductState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractSupplierProductApplicationService(EventStore eventStore, SupplierProductStateRepository stateRepository, SupplierProductStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(SupplierProductCommand.CreateSupplierProduct c) {
        update(c, ar -> ar.create(c));
    }

    public void when(SupplierProductCommand.MergePatchSupplierProduct c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public SupplierProductState get(SupplierProductId id) {
        SupplierProductState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<SupplierProductState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<SupplierProductState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<SupplierProductState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<SupplierProductState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public SupplierProductStateEvent getStateEvent(SupplierProductId supplierProductId, long version) {
        SupplierProductStateEvent e = (SupplierProductStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(supplierProductId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(supplierProductId, 0);
        }
        return e;
    }

    public SupplierProductState getHistoryState(SupplierProductId supplierProductId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractSupplierProductStateEvent.class, toEventStoreAggregateId(supplierProductId), version - 1);
        return new AbstractSupplierProductState.SimpleSupplierProductState(eventStream.getEvents());
    }


    public SupplierProductAggregate getSupplierProductAggregate(SupplierProductState state)
    {
        return new AbstractSupplierProductAggregate.SimpleSupplierProductAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(SupplierProductId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(SupplierProductCommand c, Consumer<SupplierProductAggregate> action)
    {
        SupplierProductId aggregateId = c.getSupplierProductId();
        SupplierProductState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        SupplierProductAggregate aggregate = getSupplierProductAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, SupplierProductAggregate aggregate, SupplierProductState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(SupplierProductStateEvent.SupplierProductStateCreated stateCreated) {
        SupplierProductId aggregateId = stateCreated.getStateEventId().getSupplierProductId();
        SupplierProductState state = new AbstractSupplierProductState.SimpleSupplierProductState();
        state.setSupplierProductId(aggregateId);

        SupplierProductAggregate aggregate = getSupplierProductAggregate(state);
        ((AbstractSupplierProductAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(SupplierProductCommand command, EventStoreAggregateId eventStoreAggregateId, SupplierProductState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(SupplierProductState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractSupplierProductStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleSupplierProductApplicationService extends AbstractSupplierProductApplicationService 
    {
        public SimpleSupplierProductApplicationService(EventStore eventStore, SupplierProductStateRepository stateRepository, SupplierProductStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

