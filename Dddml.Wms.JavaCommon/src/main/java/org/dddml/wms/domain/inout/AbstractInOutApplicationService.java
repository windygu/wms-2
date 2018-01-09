package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractInOutApplicationService implements InOutApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private InOutStateRepository stateRepository;

    protected InOutStateRepository getStateRepository() {
        return stateRepository;
    }

    private InOutStateQueryRepository stateQueryRepository;

    protected InOutStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<InOutAggregate, InOutState> aggregateEventListener;

    public AggregateEventListener<InOutAggregate, InOutState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<InOutAggregate, InOutState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractInOutApplicationService(EventStore eventStore, InOutStateRepository stateRepository, InOutStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(InOutCommand.CreateInOut c) {
        update(c, ar -> ar.create(c));
    }

    public void when(InOutCommand.MergePatchInOut c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(InOutCommands.Complete c) {
        update(c, ar -> ar.complete(c.getVersion(), c.getCommandId(), c.getRequesterId()));
    }

    public void when(InOutCommands.Close c) {
        update(c, ar -> ar.close(c.getVersion(), c.getCommandId(), c.getRequesterId()));
    }

    public void when(InOutCommands.Void c) {
        update(c, ar -> ar._void(c.getVersion(), c.getCommandId(), c.getRequesterId()));
    }

    public void when(InOutCommands.Reverse c) {
        update(c, ar -> ar.reverse(c.getVersion(), c.getCommandId(), c.getRequesterId()));
    }

    public void when(InOutCommands.DocumentAction c) {
        update(c, ar -> ar.documentAction(c.getValue(), c.getVersion(), c.getCommandId(), c.getRequesterId()));
    }

    public InOutState get(String id) {
        InOutState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<InOutState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<InOutState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InOutState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<InOutState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public InOutStateEvent getStateEvent(String documentNumber, long version) {
        InOutStateEvent e = (InOutStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(documentNumber), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(documentNumber, 0);
        }
        return e;
    }

    public InOutState getHistoryState(String documentNumber, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractInOutStateEvent.class, toEventStoreAggregateId(documentNumber), version - 1);
        return new AbstractInOutState.SimpleInOutState(eventStream.getEvents());
    }

    public InOutLineState getInOutLine(String inOutDocumentNumber, String lineNumber) {
        return getStateQueryRepository().getInOutLine(inOutDocumentNumber, lineNumber);
    }


    public InOutAggregate getInOutAggregate(InOutState state)
    {
        return new AbstractInOutAggregate.SimpleInOutAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(InOutCommand c, Consumer<InOutAggregate> action)
    {
        String aggregateId = c.getDocumentNumber();
        InOutState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        InOutAggregate aggregate = getInOutAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, InOutAggregate aggregate, InOutState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(InOutStateEvent.InOutStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getDocumentNumber();
        InOutState state = new AbstractInOutState.SimpleInOutState();
        state.setDocumentNumber(aggregateId);

        InOutAggregate aggregate = getInOutAggregate(state);
        ((AbstractInOutAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(InOutCommand command, EventStoreAggregateId eventStoreAggregateId, InOutState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(InOutState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractInOutStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleInOutApplicationService extends AbstractInOutApplicationService 
    {
        public SimpleInOutApplicationService(EventStore eventStore, InOutStateRepository stateRepository, InOutStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

