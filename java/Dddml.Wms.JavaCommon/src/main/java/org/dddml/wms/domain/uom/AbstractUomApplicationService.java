package org.dddml.wms.domain.uom;

import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.AbstractStateEvent;
import org.dddml.wms.specialization.*;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public abstract class AbstractUomApplicationService implements UomApplicationService {

    private EventStore eventStore;

    protected EventStore getEventStore() {
        return eventStore;
    }

    private UomStateRepository stateRepository;

    protected UomStateRepository getStateRepository() {
        return stateRepository;
    }

    private UomStateQueryRepository stateQueryRepository;

    protected UomStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<UomAggregate, UomState> aggregateEventListener;

    public AggregateEventListener<UomAggregate, UomState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<UomAggregate, UomState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractUomApplicationService(EventStore eventStore, UomStateRepository stateRepository, UomStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(UomCommand.CreateUom c) {
        update(c, ar -> ar.create(c));
    }

    public void when(UomCommand.MergePatchUom c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(UomCommand.DeleteUom c) {
        update(c, ar -> ar.delete(c));
    }

    public UomState get(String id) {
        UomState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<UomState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<UomState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<UomState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<UomState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public UomStateEvent getStateEvent(String uomId, long version) {
        UomStateEvent e = (UomStateEvent) getEventStore().getStateEvent(toEventStoreAggregateId(uomId), version);
        if (e != null) {
            e.setStateEventReadOnly(true);
        } else if (version == -1) {
            return getStateEvent(uomId, 0);
        }
        return e;
    }

    public UomState getHistoryState(String uomId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractUomStateEvent.class, toEventStoreAggregateId(uomId), version - 1);
        return new AbstractUomState.SimpleUomState(eventStream.getEvents());
    }


    public UomAggregate getUomAggregate(UomState state) {
        return new AbstractUomAggregate.SimpleUomAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId) {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(UomCommand c, Consumer<UomAggregate> action) {
        String aggregateId = c.getUomId();
        UomState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) {
            return;
        }

        UomAggregate aggregate = getUomAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, UomAggregate aggregate, UomState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version,
                aggregate.getChanges(), (events) -> {
                    getStateRepository().save(state);
                });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(UomStateEvent.UomStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getUomId();
        UomState state = new AbstractUomState.SimpleUomState();
        state.setUomId(aggregateId);

        UomAggregate aggregate = getUomAggregate(state);
        ((AbstractUomAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(UomCommand command, EventStoreAggregateId eventStoreAggregateId, UomState state) {
        boolean repeated = false;
        if (command.getVersion() == null) {
            command.setVersion(UomState.VERSION_NULL);
        }
        if (state.getVersion() != null && state.getVersion() > command.getVersion()) {
            Event lastEvent = getEventStore().findLastEvent(AbstractUomStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
                    && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId())) {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleUomApplicationService extends AbstractUomApplicationService {
        public SimpleUomApplicationService(EventStore eventStore, UomStateRepository stateRepository, UomStateQueryRepository stateQueryRepository) {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

