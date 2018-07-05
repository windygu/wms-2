package org.dddml.wms.domain.goodidentificationmvo;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractGoodIdentificationMvoApplicationService implements GoodIdentificationMvoApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private GoodIdentificationMvoStateRepository stateRepository;

    protected GoodIdentificationMvoStateRepository getStateRepository() {
        return stateRepository;
    }

    private GoodIdentificationMvoStateQueryRepository stateQueryRepository;

    protected GoodIdentificationMvoStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<GoodIdentificationMvoAggregate, GoodIdentificationMvoState> aggregateEventListener;

    public AggregateEventListener<GoodIdentificationMvoAggregate, GoodIdentificationMvoState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<GoodIdentificationMvoAggregate, GoodIdentificationMvoState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractGoodIdentificationMvoApplicationService(EventStore eventStore, GoodIdentificationMvoStateRepository stateRepository, GoodIdentificationMvoStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(GoodIdentificationMvoCommand.CreateGoodIdentificationMvo c) {
        update(c, ar -> ar.create(c));
    }

    public void when(GoodIdentificationMvoCommand.MergePatchGoodIdentificationMvo c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(GoodIdentificationMvoCommand.DeleteGoodIdentificationMvo c) {
        update(c, ar -> ar.delete(c));
    }

    public GoodIdentificationMvoState get(ProductGoodIdentificationId id) {
        GoodIdentificationMvoState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<GoodIdentificationMvoState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<GoodIdentificationMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<GoodIdentificationMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<GoodIdentificationMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public GoodIdentificationMvoEvent getEvent(ProductGoodIdentificationId productGoodIdentificationId, long version) {
        GoodIdentificationMvoEvent e = (GoodIdentificationMvoEvent)getEventStore().getEvent(toEventStoreAggregateId(productGoodIdentificationId), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(productGoodIdentificationId, 0);
        }
        return e;
    }

    public GoodIdentificationMvoState getHistoryState(ProductGoodIdentificationId productGoodIdentificationId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractGoodIdentificationMvoEvent.class, toEventStoreAggregateId(productGoodIdentificationId), version - 1);
        return new AbstractGoodIdentificationMvoState.SimpleGoodIdentificationMvoState(eventStream.getEvents());
    }


    public GoodIdentificationMvoAggregate getGoodIdentificationMvoAggregate(GoodIdentificationMvoState state)
    {
        return new AbstractGoodIdentificationMvoAggregate.SimpleGoodIdentificationMvoAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(ProductGoodIdentificationId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(GoodIdentificationMvoCommand c, Consumer<GoodIdentificationMvoAggregate> action)
    {
        ProductGoodIdentificationId aggregateId = c.getProductGoodIdentificationId();
        GoodIdentificationMvoState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        GoodIdentificationMvoAggregate aggregate = getGoodIdentificationMvoAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getProductVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, GoodIdentificationMvoAggregate aggregate, GoodIdentificationMvoState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(GoodIdentificationMvoEvent.GoodIdentificationMvoStateCreated stateCreated) {
        ProductGoodIdentificationId aggregateId = stateCreated.getGoodIdentificationMvoEventId().getProductGoodIdentificationId();
        GoodIdentificationMvoState state = new AbstractGoodIdentificationMvoState.SimpleGoodIdentificationMvoState();
        state.setProductGoodIdentificationId(aggregateId);

        GoodIdentificationMvoAggregate aggregate = getGoodIdentificationMvoAggregate(state);
        ((AbstractGoodIdentificationMvoAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getGoodIdentificationMvoEventId().getProductVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(GoodIdentificationMvoCommand command, EventStoreAggregateId eventStoreAggregateId, GoodIdentificationMvoState state)
    {
        boolean repeated = false;
        if (command.getProductVersion() == null) { command.setProductVersion(GoodIdentificationMvoState.VERSION_NULL); }
        if (state.getProductVersion() != null && state.getProductVersion() > command.getProductVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractGoodIdentificationMvoEvent.class, eventStoreAggregateId, command.getProductVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleGoodIdentificationMvoApplicationService extends AbstractGoodIdentificationMvoApplicationService 
    {
        public SimpleGoodIdentificationMvoApplicationService(EventStore eventStore, GoodIdentificationMvoStateRepository stateRepository, GoodIdentificationMvoStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

