package org.dddml.wms.domain.inoutlinemvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInOutLineMvoApplicationService implements InOutLineMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private InOutLineMvoStateRepository stateRepository;

    protected InOutLineMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private InOutLineMvoStateQueryRepository stateQueryRepository;

    protected InOutLineMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<InOutLineMvoAggregate, InOutLineMvoState> aggregateEventListener;

    public AggregateEventListener<InOutLineMvoAggregate, InOutLineMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<InOutLineMvoAggregate, InOutLineMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractInOutLineMvoApplicationService(EventStore eventStore, InOutLineMvoStateRepository stateRepository, InOutLineMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(InOutLineMvoCommand.CreateInOutLineMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(InOutLineMvoCommand.MergePatchInOutLineMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(InOutLineMvoCommand.DeleteInOutLineMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public InOutLineMvoState get(InOutLineId id) {
        InOutLineMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<InOutLineMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<InOutLineMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InOutLineMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InOutLineMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public InOutLineMvoStateEvent getStateEvent(InOutLineId inOutLineId, long version) {
        InOutLineMvoStateEvent e = (InOutLineMvoStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(inOutLineId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(inOutLineId, 0);
        }
        return e;
    }

    public InOutLineMvoState getHistoryState(InOutLineId inOutLineId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractInOutLineMvoStateEvent.class, toEventStoreAggregateId(inOutLineId), version - 1);
        return new AbstractInOutLineMvoState.SimpleInOutLineMvoState(eventStream.getEvents());
    }


    public InOutLineMvoAggregate getInOutLineMvoAggregate(InOutLineMvoState state)
    {
        return new AbstractInOutLineMvoAggregate.SimpleInOutLineMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(InOutLineId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(InOutLineMvoCommand c, Consumer<InOutLineMvoAggregate> action)
    {
        InOutLineId aggregateId = c.getInOutLineId();
        InOutLineMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        InOutLineMvoAggregate aggregate = getInOutLineMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getInOutVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, InOutLineMvoAggregate aggregate, InOutLineMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(InOutLineMvoStateEvent.InOutLineMvoStateCreated stateCreated) {
        InOutLineId aggregateId = stateCreated.getStateEventId().getInOutLineId();
        InOutLineMvoState state = new AbstractInOutLineMvoState.SimpleInOutLineMvoState();
        state.setInOutLineId(aggregateId);

        InOutLineMvoAggregate aggregate = getInOutLineMvoAggregate(state);
        ((AbstractInOutLineMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getInOutVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(InOutLineMvoCommand command, EventStoreAggregateId eventStoreAggregateId, InOutLineMvoState state)
    {
        boolean repeated = false;
        if (command.getInOutVersion() == null) { command.setInOutVersion(InOutLineMvoState.VERSION_NULL); }
        if (state.getInOutVersion() != null && state.getInOutVersion() > command.getInOutVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractInOutLineMvoStateEvent.class, eventStoreAggregateId, command.getInOutVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleInOutLineMvoApplicationService extends AbstractInOutLineMvoApplicationService 
    {
        public SimpleInOutLineMvoApplicationService(EventStore eventStore, InOutLineMvoStateRepository stateRepository, InOutLineMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

