package org.dddml.wms.domain.uomconversion;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractUomConversionApplicationService implements UomConversionApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private UomConversionStateRepository stateRepository;

    protected UomConversionStateRepository getStateRepository() {
        return stateRepository;
    }

    private UomConversionStateQueryRepository stateQueryRepository;

    protected UomConversionStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<UomConversionAggregate, UomConversionState> aggregateEventListener;

    public AggregateEventListener<UomConversionAggregate, UomConversionState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<UomConversionAggregate, UomConversionState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractUomConversionApplicationService(EventStore eventStore, UomConversionStateRepository stateRepository, UomConversionStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(UomConversionCommand.CreateUomConversion c) {
        update(c, ar -> ar.create(c));
    }

    public void when(UomConversionCommand.MergePatchUomConversion c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(UomConversionCommand.DeleteUomConversion c) {
        update(c, ar -> ar.delete(c));
    }

    public UomConversionState get(UomConversionId id) {
        UomConversionState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<UomConversionState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<UomConversionState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<UomConversionState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<UomConversionState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public UomConversionStateEvent getStateEvent(UomConversionId uomConversionId, long version) {
        UomConversionStateEvent e = (UomConversionStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(uomConversionId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(uomConversionId, 0);
        }
        return e;
    }

    public UomConversionState getHistoryState(UomConversionId uomConversionId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractUomConversionStateEvent.class, toEventStoreAggregateId(uomConversionId), version - 1);
        return new AbstractUomConversionState.SimpleUomConversionState(eventStream.getEvents());
    }


    public UomConversionAggregate getUomConversionAggregate(UomConversionState state)
    {
        return new AbstractUomConversionAggregate.SimpleUomConversionAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(UomConversionId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(UomConversionCommand c, Consumer<UomConversionAggregate> action)
    {
        UomConversionId aggregateId = c.getUomConversionId();
        UomConversionState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        UomConversionAggregate aggregate = getUomConversionAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, UomConversionAggregate aggregate, UomConversionState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(UomConversionStateEvent.UomConversionStateCreated stateCreated) {
        UomConversionId aggregateId = stateCreated.getUomConversionEventId().getUomConversionId();
        UomConversionState state = new AbstractUomConversionState.SimpleUomConversionState();
        state.setUomConversionId(aggregateId);

        UomConversionAggregate aggregate = getUomConversionAggregate(state);
        ((AbstractUomConversionAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getUomConversionEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(UomConversionCommand command, EventStoreAggregateId eventStoreAggregateId, UomConversionState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(UomConversionState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractUomConversionStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleUomConversionApplicationService extends AbstractUomConversionApplicationService 
    {
        public SimpleUomConversionApplicationService(EventStore eventStore, UomConversionStateRepository stateRepository, UomConversionStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

