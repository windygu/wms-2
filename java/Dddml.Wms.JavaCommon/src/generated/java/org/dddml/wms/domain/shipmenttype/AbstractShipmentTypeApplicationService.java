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

    public AbstractShipmentTypeApplicationService(ShipmentTypeStateRepository stateRepository, ShipmentTypeStateQueryRepository stateQueryRepository) {
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ShipmentTypeCommand.CreateShipmentType c) {
        update(c, s -> {
        // //////////////////////////
        throwOnConcurrencyConflict(s, c);
        s.setParentTypeId(c.getParentTypeId());
        s.setHasTable(c.getHasTable());
        s.setDescription(c.getDescription());
        s.setActive(c.getActive());
        s.setCreatedBy(c.getRequesterId());
        s.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        s.setCommandId(c.getCommandId());
        // //////////////////////////
        });
    }

    public void when(ShipmentTypeCommand.MergePatchShipmentType c) {
        update(c, s -> {
        // //////////////////////////////////
        throwOnConcurrencyConflict(s, c);
        if (c.getParentTypeId() == null) {
            if (c.getIsPropertyParentTypeIdRemoved() != null && c.getIsPropertyParentTypeIdRemoved()) {
                s.setParentTypeId(null);
            }
        } else {
            s.setParentTypeId(c.getParentTypeId());
        }
        if (c.getHasTable() == null) {
            if (c.getIsPropertyHasTableRemoved() != null && c.getIsPropertyHasTableRemoved()) {
                s.setHasTable(null);
            }
        } else {
            s.setHasTable(c.getHasTable());
        }
        if (c.getDescription() == null) {
            if (c.getIsPropertyDescriptionRemoved() != null && c.getIsPropertyDescriptionRemoved()) {
                s.setDescription(null);
            }
        } else {
            s.setDescription(c.getDescription());
        }
        if (c.getActive() == null) {
            if (c.getIsPropertyActiveRemoved() != null && c.getIsPropertyActiveRemoved()) {
                s.setActive(null);
            }
        } else {
            s.setActive(c.getActive());
        }
        s.setUpdatedBy(c.getRequesterId());
        s.setUpdatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        s.setCommandId(c.getCommandId());
        // //////////////////////////////////
        });
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

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ShipmentTypeCommand c, Consumer<ShipmentTypeState> action)
    {
        String aggregateId = c.getShipmentTypeId();
        ShipmentTypeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        ShipmentTypeCommand.throwOnInvalidStateTransition(state, c);
        action.accept(state);
        persist(eventStoreAggregateId, c.getVersion(), state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ShipmentTypeState state) {
        getStateRepository().save(state);
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

    protected static void throwOnConcurrencyConflict(ShipmentTypeState s, ShipmentTypeCommand c) {
        Long stateVersion = s.getVersion();
        Long commandVersion = c.getVersion();
        if (commandVersion == null) { commandVersion = ShipmentTypeState.VERSION_NULL; }
        if (!(stateVersion == null && commandVersion.equals(ShipmentTypeState.VERSION_NULL)) && !commandVersion.equals(stateVersion)) {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and command version (%2$s)", stateVersion, commandVersion);
        }
    }

    public static class SimpleShipmentTypeApplicationService extends AbstractShipmentTypeApplicationService 
    {
        public SimpleShipmentTypeApplicationService(ShipmentTypeStateRepository stateRepository, ShipmentTypeStateQueryRepository stateQueryRepository)
        {
            super(stateRepository, stateQueryRepository);
        }
    }

}

