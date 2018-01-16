package org.dddml.wms.domain.damagereason;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractDamageReasonApplicationService implements DamageReasonApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private DamageReasonStateRepository stateRepository;

    protected DamageReasonStateRepository getStateRepository() {
        return stateRepository;
    }

    private DamageReasonStateQueryRepository stateQueryRepository;

    protected DamageReasonStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<DamageReasonAggregate, DamageReasonState> aggregateEventListener;

    public AggregateEventListener<DamageReasonAggregate, DamageReasonState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<DamageReasonAggregate, DamageReasonState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractDamageReasonApplicationService(EventStore eventStore, DamageReasonStateRepository stateRepository, DamageReasonStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(DamageReasonCommand.CreateDamageReason c) {
        update(c, ar -> ar.create(c));
    }

    public void when(DamageReasonCommand.MergePatchDamageReason c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(DamageReasonCommand.DeleteDamageReason c) {
        update(c, ar -> ar.delete(c));
    }

    public DamageReasonState get(String id) {
        DamageReasonState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<DamageReasonState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<DamageReasonState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<DamageReasonState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<DamageReasonState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public DamageReasonStateEvent getStateEvent(String damageReasonId, long version) {
        DamageReasonStateEvent e = (DamageReasonStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(damageReasonId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(damageReasonId, 0);
        }
        return e;
    }

    public DamageReasonState getHistoryState(String damageReasonId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractDamageReasonStateEvent.class, toEventStoreAggregateId(damageReasonId), version - 1);
        return new AbstractDamageReasonState.SimpleDamageReasonState(eventStream.getEvents());
    }


    public DamageReasonAggregate getDamageReasonAggregate(DamageReasonState state)
    {
        return new AbstractDamageReasonAggregate.SimpleDamageReasonAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(DamageReasonCommand c, Consumer<DamageReasonAggregate> action)
    {
        String aggregateId = c.getDamageReasonId();
        DamageReasonState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        DamageReasonAggregate aggregate = getDamageReasonAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, DamageReasonAggregate aggregate, DamageReasonState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(DamageReasonStateEvent.DamageReasonStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getDamageReasonId();
        DamageReasonState state = new AbstractDamageReasonState.SimpleDamageReasonState();
        state.setDamageReasonId(aggregateId);

        DamageReasonAggregate aggregate = getDamageReasonAggregate(state);
        ((AbstractDamageReasonAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(DamageReasonCommand command, EventStoreAggregateId eventStoreAggregateId, DamageReasonState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(DamageReasonState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractDamageReasonStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleDamageReasonApplicationService extends AbstractDamageReasonApplicationService 
    {
        public SimpleDamageReasonApplicationService(EventStore eventStore, DamageReasonStateRepository stateRepository, DamageReasonStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

