package org.dddml.wms.domain.goodidentificationtype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractGoodIdentificationTypeApplicationService implements GoodIdentificationTypeApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private GoodIdentificationTypeStateRepository stateRepository;

    protected GoodIdentificationTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private GoodIdentificationTypeStateQueryRepository stateQueryRepository;

    protected GoodIdentificationTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<GoodIdentificationTypeAggregate, GoodIdentificationTypeState> aggregateEventListener;

    public AggregateEventListener<GoodIdentificationTypeAggregate, GoodIdentificationTypeState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<GoodIdentificationTypeAggregate, GoodIdentificationTypeState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractGoodIdentificationTypeApplicationService(EventStore eventStore, GoodIdentificationTypeStateRepository stateRepository, GoodIdentificationTypeStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(GoodIdentificationTypeCommand.CreateGoodIdentificationType c) {
        update(c, ar -> ar.create(c));
    }

    public void when(GoodIdentificationTypeCommand.MergePatchGoodIdentificationType c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(GoodIdentificationTypeCommand.DeleteGoodIdentificationType c) {
        update(c, ar -> ar.delete(c));
    }

    public GoodIdentificationTypeState get(String id) {
        GoodIdentificationTypeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<GoodIdentificationTypeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<GoodIdentificationTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<GoodIdentificationTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<GoodIdentificationTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public GoodIdentificationTypeEvent getEvent(String goodIdentificationTypeId, long version) {
        GoodIdentificationTypeEvent e = (GoodIdentificationTypeEvent)getEventStore().getEvent(toEventStoreAggregateId(goodIdentificationTypeId), version);
        if (e != null)
        { ((GoodIdentificationTypeEvent.SqlGoodIdentificationTypeEvent)e).setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(goodIdentificationTypeId, 0);
        }
        return e;
    }

    public GoodIdentificationTypeState getHistoryState(String goodIdentificationTypeId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractGoodIdentificationTypeEvent.class, toEventStoreAggregateId(goodIdentificationTypeId), version - 1);
        return new AbstractGoodIdentificationTypeState.SimpleGoodIdentificationTypeState(eventStream.getEvents());
    }


    public GoodIdentificationTypeAggregate getGoodIdentificationTypeAggregate(GoodIdentificationTypeState state)
    {
        return new AbstractGoodIdentificationTypeAggregate.SimpleGoodIdentificationTypeAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(GoodIdentificationTypeCommand c, Consumer<GoodIdentificationTypeAggregate> action)
    {
        String aggregateId = c.getGoodIdentificationTypeId();
        GoodIdentificationTypeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        GoodIdentificationTypeAggregate aggregate = getGoodIdentificationTypeAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, GoodIdentificationTypeAggregate aggregate, GoodIdentificationTypeState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(GoodIdentificationTypeEvent.GoodIdentificationTypeStateCreated stateCreated) {
        String aggregateId = ((GoodIdentificationTypeEvent.SqlGoodIdentificationTypeEvent)stateCreated).getGoodIdentificationTypeEventId().getGoodIdentificationTypeId();
        GoodIdentificationTypeState state = new AbstractGoodIdentificationTypeState.SimpleGoodIdentificationTypeState();
        state.setGoodIdentificationTypeId(aggregateId);

        GoodIdentificationTypeAggregate aggregate = getGoodIdentificationTypeAggregate(state);
        ((AbstractGoodIdentificationTypeAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((GoodIdentificationTypeEvent.SqlGoodIdentificationTypeEvent)stateCreated).getGoodIdentificationTypeEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(GoodIdentificationTypeCommand command, EventStoreAggregateId eventStoreAggregateId, GoodIdentificationTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(GoodIdentificationTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractGoodIdentificationTypeEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleGoodIdentificationTypeApplicationService extends AbstractGoodIdentificationTypeApplicationService 
    {
        public SimpleGoodIdentificationTypeApplicationService(EventStore eventStore, GoodIdentificationTypeStateRepository stateRepository, GoodIdentificationTypeStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

