package org.dddml.wms.domain.uomtype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractUomTypeApplicationService implements UomTypeApplicationService
{
    private UomTypeStateRepository stateRepository;

    protected UomTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private UomTypeStateQueryRepository stateQueryRepository;

    protected UomTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    public AbstractUomTypeApplicationService(UomTypeStateRepository stateRepository, UomTypeStateQueryRepository stateQueryRepository) {
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(UomTypeCommand.CreateUomType c) {
        update(c, s -> {
        // //////////////////////////
        throwOnConcurrencyConflict(s, c);
        ((UomTypeState.SqlUomTypeState)s).setParentTypeId(c.getParentTypeId());
        ((UomTypeState.SqlUomTypeState)s).setHasTable(c.getHasTable());
        ((UomTypeState.SqlUomTypeState)s).setDescription(c.getDescription());
        ((UomTypeState.SqlUomTypeState)s).setActive(c.getActive());
        ((UomTypeState.SqlUomTypeState)s).setDeleted(false);
        ((UomTypeState.SqlUomTypeState)s).setCreatedBy(c.getRequesterId());
        ((UomTypeState.SqlUomTypeState)s).setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        ((UomTypeState.SqlUomTypeState)s).setCommandId(c.getCommandId());
        // //////////////////////////
        });
    }

    public void when(UomTypeCommand.MergePatchUomType c) {
        update(c, s -> {
        // //////////////////////////////////
        throwOnConcurrencyConflict(s, c);
        if (c.getParentTypeId() == null) {
            if (c.getIsPropertyParentTypeIdRemoved() != null && c.getIsPropertyParentTypeIdRemoved()) {
                ((UomTypeState.SqlUomTypeState)s).setParentTypeId(null);
            }
        } else {
            ((UomTypeState.SqlUomTypeState)s).setParentTypeId(c.getParentTypeId());
        }
        if (c.getHasTable() == null) {
            if (c.getIsPropertyHasTableRemoved() != null && c.getIsPropertyHasTableRemoved()) {
                ((UomTypeState.SqlUomTypeState)s).setHasTable(null);
            }
        } else {
            ((UomTypeState.SqlUomTypeState)s).setHasTable(c.getHasTable());
        }
        if (c.getDescription() == null) {
            if (c.getIsPropertyDescriptionRemoved() != null && c.getIsPropertyDescriptionRemoved()) {
                ((UomTypeState.SqlUomTypeState)s).setDescription(null);
            }
        } else {
            ((UomTypeState.SqlUomTypeState)s).setDescription(c.getDescription());
        }
        if (c.getActive() == null) {
            if (c.getIsPropertyActiveRemoved() != null && c.getIsPropertyActiveRemoved()) {
                ((UomTypeState.SqlUomTypeState)s).setActive(null);
            }
        } else {
            ((UomTypeState.SqlUomTypeState)s).setActive(c.getActive());
        }
        ((UomTypeState.SqlUomTypeState)s).setUpdatedBy(c.getRequesterId());
        ((UomTypeState.SqlUomTypeState)s).setUpdatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        ((UomTypeState.SqlUomTypeState)s).setCommandId(c.getCommandId());
        // //////////////////////////////////
        });
    }

    public void when(UomTypeCommand.DeleteUomType c) {
        update(c, s -> {
        throwOnConcurrencyConflict(s, c);
        // ///////////////////////////////////
        //todo
        // ///////////////////////////////////
        });
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

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(UomTypeCommand c, Consumer<UomTypeState> action)
    {
        String aggregateId = c.getUomTypeId();
        UomTypeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        UomTypeCommand.throwOnInvalidStateTransition(state, c);
        action.accept(state);
        persist(eventStoreAggregateId, c.getVersion(), state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, UomTypeState state) {
        getStateRepository().save(state);
    }

    protected boolean isRepeatedCommand(UomTypeCommand command, EventStoreAggregateId eventStoreAggregateId, UomTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(UomTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() == command.getVersion() + 1)
        {
            if (command.getCommandId() != null && command.getCommandId().equals(state.getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    protected static void throwOnConcurrencyConflict(UomTypeState s, UomTypeCommand c) {
        Long stateVersion = s.getVersion();
        Long commandVersion = c.getVersion();
        if (commandVersion == null) { commandVersion = UomTypeState.VERSION_NULL; }
        if (!(stateVersion == null && commandVersion.equals(UomTypeState.VERSION_NULL)) && !commandVersion.equals(stateVersion)) {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and command version (%2$s)", stateVersion, commandVersion);
        }
    }

    public static class SimpleUomTypeApplicationService extends AbstractUomTypeApplicationService 
    {
        public SimpleUomTypeApplicationService(UomTypeStateRepository stateRepository, UomTypeStateQueryRepository stateQueryRepository)
        {
            super(stateRepository, stateQueryRepository);
        }
    }

}

