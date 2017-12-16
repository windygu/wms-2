package org.dddml.wms.domain.productcategory;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractProductCategoryApplicationService implements ProductCategoryApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private ProductCategoryStateRepository stateRepository;

    protected ProductCategoryStateRepository getStateRepository() {
        return stateRepository;
    }

    private ProductCategoryStateQueryRepository stateQueryRepository;

    protected ProductCategoryStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<ProductCategoryAggregate, ProductCategoryState> aggregateEventListener;

    public AggregateEventListener<ProductCategoryAggregate, ProductCategoryState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<ProductCategoryAggregate, ProductCategoryState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractProductCategoryApplicationService(EventStore eventStore, ProductCategoryStateRepository stateRepository, ProductCategoryStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ProductCategoryCommand.CreateProductCategory c) {
        update(c, ar -> ar.create(c));
    }

    public void when(ProductCategoryCommand.MergePatchProductCategory c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(ProductCategoryCommand.DeleteProductCategory c) {
        update(c, ar -> ar.delete(c));
    }

    public ProductCategoryState get(String id) {
        ProductCategoryState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<ProductCategoryState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<ProductCategoryState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ProductCategoryState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ProductCategoryState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public ProductCategoryStateEvent getStateEvent(String productCategoryId, long version) {
        ProductCategoryStateEvent e = (ProductCategoryStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(productCategoryId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(productCategoryId, 0);
        }
        return e;
    }

    public ProductCategoryState getHistoryState(String productCategoryId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractProductCategoryStateEvent.class, toEventStoreAggregateId(productCategoryId), version - 1);
        return new AbstractProductCategoryState.SimpleProductCategoryState(eventStream.getEvents());
    }

    public Iterable<ProductCategoryState> getProductCategoryIdToProductCategories(String productCategoryId) {
        Iterable<ProductCategoryState> states = getStateQueryRepository().getProductCategoryIdToProductCategories(productCategoryId);
		return states;
    }


    public ProductCategoryAggregate getProductCategoryAggregate(ProductCategoryState state)
    {
        return new AbstractProductCategoryAggregate.SimpleProductCategoryAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ProductCategoryCommand c, Consumer<ProductCategoryAggregate> action)
    {
        String aggregateId = c.getProductCategoryId();
        ProductCategoryState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        ProductCategoryAggregate aggregate = getProductCategoryAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ProductCategoryAggregate aggregate, ProductCategoryState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(ProductCategoryStateEvent.ProductCategoryStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getProductCategoryId();
        ProductCategoryState state = new AbstractProductCategoryState.SimpleProductCategoryState();
        state.setProductCategoryId(aggregateId);

        ProductCategoryAggregate aggregate = getProductCategoryAggregate(state);
        ((AbstractProductCategoryAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(ProductCategoryCommand command, EventStoreAggregateId eventStoreAggregateId, ProductCategoryState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(ProductCategoryState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractProductCategoryStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleProductCategoryApplicationService extends AbstractProductCategoryApplicationService 
    {
        public SimpleProductCategoryApplicationService(EventStore eventStore, ProductCategoryStateRepository stateRepository, ProductCategoryStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

