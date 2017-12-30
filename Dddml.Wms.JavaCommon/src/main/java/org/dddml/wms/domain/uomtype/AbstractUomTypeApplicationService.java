package org.dddml.wms.domain.uomtype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractUomTypeApplicationService implements UomTypeApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private UomTypeStateRepository stateRepository;

    protected UomTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private UomTypeStateQueryRepository stateQueryRepository;

    protected UomTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<UomTypeAggregate, UomTypeState> aggregateEventListener;

    public AggregateEventListener<UomTypeAggregate, UomTypeState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<UomTypeAggregate, UomTypeState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractUomTypeApplicationService(EventStore eventStore, UomTypeStateRepository stateRepository, UomTypeStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(UomTypeCommand.CreateUomType c) {
        update(c, ar -> ar.create(c));
    }

    public void when(UomTypeCommand.MergePatchUomType c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(UomTypeCommand.DeleteUomType c) {
        update(c, ar -> ar.delete(c));
    }

    public UomTypeState get(String id) {
        UomTypeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<UomTypeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<UomTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<UomTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<UomTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public UomTypeStateEvent getStateEvent(String uomTypeId, long version) {
        UomTypeStateEvent e = (UomTypeStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(uomTypeId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(uomTypeId, 0);
        }
        return e;
    }

    public UomTypeState getHistoryState(String uomTypeId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractUomTypeStateEvent.class, toEventStoreAggregateId(uomTypeId), version - 1);
        return new AbstractUomTypeState.SimpleUomTypeState(eventStream.getEvents());
    }


    public UomTypeAggregate getUomTypeAggregate(UomTypeState state)
    {
        return new AbstractUomTypeAggregate.SimpleUomTypeAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(UomTypeCommand c, Consumer<UomTypeAggregate> action)
    {
        String aggregateId = c.getUomTypeId();
        UomTypeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        UomTypeAggregate aggregate = getUomTypeAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, UomTypeAggregate aggregate, UomTypeState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(UomTypeStateEvent.UomTypeStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getUomTypeId();
        UomTypeState state = new AbstractUomTypeState.SimpleUomTypeState();
        state.setUomTypeId(aggregateId);

        UomTypeAggregate aggregate = getUomTypeAggregate(state);
        ((AbstractUomTypeAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(UomTypeCommand command, EventStoreAggregateId eventStoreAggregateId, UomTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(UomTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractUomTypeStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleUomTypeApplicationService extends AbstractUomTypeApplicationService 
    {
        public SimpleUomTypeApplicationService(EventStore eventStore, UomTypeStateRepository stateRepository, UomTypeStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

