package org.dddml.wms.domain.productcategorymember;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractProductCategoryMemberApplicationService implements ProductCategoryMemberApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private ProductCategoryMemberStateRepository stateRepository;

    protected ProductCategoryMemberStateRepository getStateRepository() {
        return stateRepository;
    }

    private ProductCategoryMemberStateQueryRepository stateQueryRepository;

    protected ProductCategoryMemberStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<ProductCategoryMemberAggregate, ProductCategoryMemberState> aggregateEventListener;

    public AggregateEventListener<ProductCategoryMemberAggregate, ProductCategoryMemberState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<ProductCategoryMemberAggregate, ProductCategoryMemberState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractProductCategoryMemberApplicationService(EventStore eventStore, ProductCategoryMemberStateRepository stateRepository, ProductCategoryMemberStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ProductCategoryMemberCommand.CreateProductCategoryMember c) {
        update(c, ar -> ar.create(c));
    }

    public void when(ProductCategoryMemberCommand.MergePatchProductCategoryMember c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public ProductCategoryMemberState get(ProductCategoryMemberId id) {
        ProductCategoryMemberState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<ProductCategoryMemberState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<ProductCategoryMemberState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ProductCategoryMemberState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ProductCategoryMemberState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public ProductCategoryMemberEvent getEvent(ProductCategoryMemberId productCategoryMemberId, long version) {
        ProductCategoryMemberEvent e = (ProductCategoryMemberEvent)getEventStore().getEvent(toEventStoreAggregateId(productCategoryMemberId), version);
        if (e != null) {
            ((ProductCategoryMemberEvent.SqlProductCategoryMemberEvent)e).setEventReadOnly(true); 
        } else if (version == -1) {
            return getEvent(productCategoryMemberId, 0);
        }
        return e;
    }

    public ProductCategoryMemberState getHistoryState(ProductCategoryMemberId productCategoryMemberId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractProductCategoryMemberEvent.class, toEventStoreAggregateId(productCategoryMemberId), version - 1);
        return new AbstractProductCategoryMemberState.SimpleProductCategoryMemberState(eventStream.getEvents());
    }


    public ProductCategoryMemberAggregate getProductCategoryMemberAggregate(ProductCategoryMemberState state)
    {
        return new AbstractProductCategoryMemberAggregate.SimpleProductCategoryMemberAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(ProductCategoryMemberId aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ProductCategoryMemberCommand c, Consumer<ProductCategoryMemberAggregate> action)
    {
        ProductCategoryMemberId aggregateId = c.getProductCategoryMemberId();
        ProductCategoryMemberState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        ProductCategoryMemberAggregate aggregate = getProductCategoryMemberAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ProductCategoryMemberAggregate aggregate, ProductCategoryMemberState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(ProductCategoryMemberEvent.ProductCategoryMemberStateCreated stateCreated) {
        ProductCategoryMemberId aggregateId = ((ProductCategoryMemberEvent.SqlProductCategoryMemberEvent)stateCreated).getProductCategoryMemberEventId().getProductCategoryMemberId();
        ProductCategoryMemberState state = new AbstractProductCategoryMemberState.SimpleProductCategoryMemberState();
        state.setProductCategoryMemberId(aggregateId);

        ProductCategoryMemberAggregate aggregate = getProductCategoryMemberAggregate(state);
        ((AbstractProductCategoryMemberAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((ProductCategoryMemberEvent.SqlProductCategoryMemberEvent)stateCreated).getProductCategoryMemberEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(ProductCategoryMemberCommand command, EventStoreAggregateId eventStoreAggregateId, ProductCategoryMemberState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(ProductCategoryMemberState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractProductCategoryMemberEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleProductCategoryMemberApplicationService extends AbstractProductCategoryMemberApplicationService 
    {
        public SimpleProductCategoryMemberApplicationService(EventStore eventStore, ProductCategoryMemberStateRepository stateRepository, ProductCategoryMemberStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

