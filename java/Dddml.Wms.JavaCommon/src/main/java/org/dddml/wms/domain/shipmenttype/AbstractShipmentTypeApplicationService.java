package org.dddml.wms.domain.shipmenttype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractShipmentTypeApplicationService implements ShipmentTypeApplicationService
{
    private ShipmentTypeStateRepository stateRepository;

    protected ShipmentTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private ShipmentTypeStateQueryRepository stateQueryRepository;

    protected ShipmentTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<ShipmentTypeAggregate, ShipmentTypeState> aggregateEventListener;

    public AggregateEventListener<ShipmentTypeAggregate, ShipmentTypeState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<ShipmentTypeAggregate, ShipmentTypeState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractShipmentTypeApplicationService(ShipmentTypeStateRepository stateRepository, ShipmentTypeStateQueryRepository stateQueryRepository) {
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ShipmentTypeCommand.CreateShipmentType c) {
        update(c, ar -> ar.create(c));
    }

    public void when(ShipmentTypeCommand.MergePatchShipmentType c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public ShipmentTypeState get(String id) {
        ShipmentTypeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<ShipmentTypeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<ShipmentTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipmentTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }


    public ShipmentTypeAggregate getShipmentTypeAggregate(ShipmentTypeState state)
    {
        return new AbstractShipmentTypeAggregate.SimpleShipmentTypeAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ShipmentTypeCommand c, Consumer<ShipmentTypeAggregate> action)
    {
        String aggregateId = c.getShipmentTypeId();
        ShipmentTypeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        ShipmentTypeAggregate aggregate = getShipmentTypeAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ShipmentTypeAggregate aggregate, ShipmentTypeState state) {
        getStateRepository().save(state);
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(ShipmentTypeStateEvent.ShipmentTypeStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getShipmentTypeId();
        ShipmentTypeState state = new AbstractShipmentTypeState.SimpleShipmentTypeState();
        state.setShipmentTypeId(aggregateId);

        ShipmentTypeAggregate aggregate = getShipmentTypeAggregate(state);
        ((AbstractShipmentTypeAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(ShipmentTypeCommand command, EventStoreAggregateId eventStoreAggregateId, ShipmentTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(ShipmentTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() == command.getVersion() + 1)
        {
            if (command.getCommandId() != null && command.getCommandId().equals(state.getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleShipmentTypeApplicationService extends AbstractShipmentTypeApplicationService 
    {
        public SimpleShipmentTypeApplicationService(ShipmentTypeStateRepository stateRepository, ShipmentTypeStateQueryRepository stateQueryRepository)
        {
            super(stateRepository, stateQueryRepository);
        }
    }

}

