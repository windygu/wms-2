package org.dddml.wms.domain.product;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractProductApplicationService implements ProductApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private ProductStateRepository stateRepository;

    protected ProductStateRepository getStateRepository() {
        return stateRepository;
    }

    private ProductStateQueryRepository stateQueryRepository;

    protected ProductStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<ProductAggregate, ProductState> aggregateEventListener;

    public AggregateEventListener<ProductAggregate, ProductState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<ProductAggregate, ProductState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractProductApplicationService(EventStore eventStore, ProductStateRepository stateRepository, ProductStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ProductCommand.CreateProduct c) {
        update(c, ar -> ar.create(c));
    }

    public void when(ProductCommand.MergePatchProduct c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public ProductState get(String id) {
        ProductState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<ProductState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<ProductState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ProductState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ProductState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public ProductEvent getEvent(String productId, long version) {
        ProductEvent e = (ProductEvent)getEventStore().getEvent(toEventStoreAggregateId(productId), version);
        if (e != null)
        { e.setEventReadOnly(true); }
        else if (version == -1)
        {
            return getEvent(productId, 0);
        }
        return e;
    }

    public ProductState getHistoryState(String productId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractProductEvent.class, toEventStoreAggregateId(productId), version - 1);
        return new AbstractProductState.SimpleProductState(eventStream.getEvents());
    }

    public GoodIdentificationState getGoodIdentification(String productId, String goodIdentificationTypeId) {
        return getStateQueryRepository().getGoodIdentification(productId, goodIdentificationTypeId);
    }

    public Iterable<GoodIdentificationState> getGoodIdentifications(String productId) {
        return getStateQueryRepository().getGoodIdentifications(productId);
    }


    public ProductAggregate getProductAggregate(ProductState state)
    {
        return new AbstractProductAggregate.SimpleProductAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ProductCommand c, Consumer<ProductAggregate> action)
    {
        String aggregateId = c.getProductId();
        ProductState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        ProductAggregate aggregate = getProductAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ProductAggregate aggregate, ProductState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(ProductEvent.ProductStateCreated stateCreated) {
        String aggregateId = stateCreated.getProductEventId().getProductId();
        ProductState state = new AbstractProductState.SimpleProductState();
        state.setProductId(aggregateId);

        ProductAggregate aggregate = getProductAggregate(state);
        ((AbstractProductAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getProductEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(ProductCommand command, EventStoreAggregateId eventStoreAggregateId, ProductState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(ProductState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractProductEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleProductApplicationService extends AbstractProductApplicationService 
    {
        public SimpleProductApplicationService(EventStore eventStore, ProductStateRepository stateRepository, ProductStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

