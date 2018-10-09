package org.dddml.wms.domain.damagetype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractDamageTypeApplicationService implements DamageTypeApplicationService
{
    private DamageTypeStateRepository stateRepository;

    protected DamageTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private DamageTypeStateQueryRepository stateQueryRepository;

    protected DamageTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    public AbstractDamageTypeApplicationService(DamageTypeStateRepository stateRepository, DamageTypeStateQueryRepository stateQueryRepository) {
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(DamageTypeCommand.CreateDamageType c) {
        update(c, s -> {
        // //////////////////////////
        throwOnConcurrencyConflict(s, c);
        ((DamageTypeState.SqlDamageTypeState)s).setDescription(c.getDescription());
        ((DamageTypeState.SqlDamageTypeState)s).setSequenceId(c.getSequenceId());
        ((DamageTypeState.SqlDamageTypeState)s).setDefaultHandlingMethodId(c.getDefaultHandlingMethodId());
        ((DamageTypeState.SqlDamageTypeState)s).setActive(c.getActive());
        ((DamageTypeState.SqlDamageTypeState)s).setDeleted(false);
        ((DamageTypeState.SqlDamageTypeState)s).setCreatedBy(c.getRequesterId());
        ((DamageTypeState.SqlDamageTypeState)s).setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        ((DamageTypeState.SqlDamageTypeState)s).setCommandId(c.getCommandId());
        // //////////////////////////
        });
    }

    public void when(DamageTypeCommand.MergePatchDamageType c) {
        update(c, s -> {
        // //////////////////////////////////
        throwOnConcurrencyConflict(s, c);
        if (c.getDescription() == null) {
            if (c.getIsPropertyDescriptionRemoved() != null && c.getIsPropertyDescriptionRemoved()) {
                ((DamageTypeState.SqlDamageTypeState)s).setDescription(null);
            }
        } else {
            ((DamageTypeState.SqlDamageTypeState)s).setDescription(c.getDescription());
        }
        if (c.getSequenceId() == null) {
            if (c.getIsPropertySequenceIdRemoved() != null && c.getIsPropertySequenceIdRemoved()) {
                ((DamageTypeState.SqlDamageTypeState)s).setSequenceId(null);
            }
        } else {
            ((DamageTypeState.SqlDamageTypeState)s).setSequenceId(c.getSequenceId());
        }
        if (c.getDefaultHandlingMethodId() == null) {
            if (c.getIsPropertyDefaultHandlingMethodIdRemoved() != null && c.getIsPropertyDefaultHandlingMethodIdRemoved()) {
                ((DamageTypeState.SqlDamageTypeState)s).setDefaultHandlingMethodId(null);
            }
        } else {
            ((DamageTypeState.SqlDamageTypeState)s).setDefaultHandlingMethodId(c.getDefaultHandlingMethodId());
        }
        if (c.getActive() == null) {
            if (c.getIsPropertyActiveRemoved() != null && c.getIsPropertyActiveRemoved()) {
                ((DamageTypeState.SqlDamageTypeState)s).setActive(null);
            }
        } else {
            ((DamageTypeState.SqlDamageTypeState)s).setActive(c.getActive());
        }
        ((DamageTypeState.SqlDamageTypeState)s).setUpdatedBy(c.getRequesterId());
        ((DamageTypeState.SqlDamageTypeState)s).setUpdatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        ((DamageTypeState.SqlDamageTypeState)s).setCommandId(c.getCommandId());
        // //////////////////////////////////
        });
    }

    public void when(DamageTypeCommand.DeleteDamageType c) {
        update(c, s -> {
        throwOnConcurrencyConflict(s, c);
        // ///////////////////////////////////
        //todo
        // ///////////////////////////////////
        });
    }

    public DamageTypeState get(String id) {
        DamageTypeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<DamageTypeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<DamageTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<DamageTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<DamageTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
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

    protected void update(DamageTypeCommand c, Consumer<DamageTypeState> action)
    {
        String aggregateId = c.getDamageTypeId();
        DamageTypeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        DamageTypeCommand.throwOnInvalidStateTransition(state, c);
        action.accept(state);
        persist(eventStoreAggregateId, c.getVersion(), state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, DamageTypeState state) {
        getStateRepository().save(state);
    }

    protected boolean isRepeatedCommand(DamageTypeCommand command, EventStoreAggregateId eventStoreAggregateId, DamageTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(DamageTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() == command.getVersion() + 1)
        {
            if (command.getCommandId() != null && command.getCommandId().equals(state.getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    protected static void throwOnConcurrencyConflict(DamageTypeState s, DamageTypeCommand c) {
        Long stateVersion = s.getVersion();
        Long commandVersion = c.getVersion();
        if (commandVersion == null) { commandVersion = DamageTypeState.VERSION_NULL; }
        if (!(stateVersion == null && commandVersion.equals(DamageTypeState.VERSION_NULL)) && !commandVersion.equals(stateVersion)) {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and command version (%2$s)", stateVersion, commandVersion);
        }
    }

    public static class SimpleDamageTypeApplicationService extends AbstractDamageTypeApplicationService 
    {
        public SimpleDamageTypeApplicationService(DamageTypeStateRepository stateRepository, DamageTypeStateQueryRepository stateQueryRepository)
        {
            super(stateRepository, stateQueryRepository);
        }
    }

}

