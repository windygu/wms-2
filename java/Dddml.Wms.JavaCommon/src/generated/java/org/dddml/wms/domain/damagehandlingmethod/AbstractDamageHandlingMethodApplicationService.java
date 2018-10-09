package org.dddml.wms.domain.damagehandlingmethod;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractDamageHandlingMethodApplicationService implements DamageHandlingMethodApplicationService
{
    private DamageHandlingMethodStateRepository stateRepository;

    protected DamageHandlingMethodStateRepository getStateRepository() {
        return stateRepository;
    }

    private DamageHandlingMethodStateQueryRepository stateQueryRepository;

    protected DamageHandlingMethodStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    public AbstractDamageHandlingMethodApplicationService(DamageHandlingMethodStateRepository stateRepository, DamageHandlingMethodStateQueryRepository stateQueryRepository) {
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(DamageHandlingMethodCommand.CreateDamageHandlingMethod c) {
        update(c, s -> {
        // //////////////////////////
        throwOnConcurrencyConflict(s, c);
        ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setDescription(c.getDescription());
        ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setSequenceId(c.getSequenceId());
        ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setActive(c.getActive());
        ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setDeleted(false);
        ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setCreatedBy(c.getRequesterId());
        ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setCommandId(c.getCommandId());
        // //////////////////////////
        });
    }

    public void when(DamageHandlingMethodCommand.MergePatchDamageHandlingMethod c) {
        update(c, s -> {
        // //////////////////////////////////
        throwOnConcurrencyConflict(s, c);
        if (c.getDescription() == null) {
            if (c.getIsPropertyDescriptionRemoved() != null && c.getIsPropertyDescriptionRemoved()) {
                ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setDescription(null);
            }
        } else {
            ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setDescription(c.getDescription());
        }
        if (c.getSequenceId() == null) {
            if (c.getIsPropertySequenceIdRemoved() != null && c.getIsPropertySequenceIdRemoved()) {
                ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setSequenceId(null);
            }
        } else {
            ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setSequenceId(c.getSequenceId());
        }
        if (c.getActive() == null) {
            if (c.getIsPropertyActiveRemoved() != null && c.getIsPropertyActiveRemoved()) {
                ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setActive(null);
            }
        } else {
            ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setActive(c.getActive());
        }
        ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setUpdatedBy(c.getRequesterId());
        ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setUpdatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        ((DamageHandlingMethodState.SqlDamageHandlingMethodState)s).setCommandId(c.getCommandId());
        // //////////////////////////////////
        });
    }

    public void when(DamageHandlingMethodCommand.DeleteDamageHandlingMethod c) {
        update(c, s -> {
        throwOnConcurrencyConflict(s, c);
        // ///////////////////////////////////
        //todo
        // ///////////////////////////////////
        });
    }

    public DamageHandlingMethodState get(String id) {
        DamageHandlingMethodState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<DamageHandlingMethodState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<DamageHandlingMethodState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<DamageHandlingMethodState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<DamageHandlingMethodState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
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

    protected void update(DamageHandlingMethodCommand c, Consumer<DamageHandlingMethodState> action)
    {
        String aggregateId = c.getDamageHandlingMethodId();
        DamageHandlingMethodState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        DamageHandlingMethodCommand.throwOnInvalidStateTransition(state, c);
        action.accept(state);
        persist(eventStoreAggregateId, c.getVersion(), state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, DamageHandlingMethodState state) {
        getStateRepository().save(state);
    }

    protected boolean isRepeatedCommand(DamageHandlingMethodCommand command, EventStoreAggregateId eventStoreAggregateId, DamageHandlingMethodState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(DamageHandlingMethodState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() == command.getVersion() + 1)
        {
            if (command.getCommandId() != null && command.getCommandId().equals(state.getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    protected static void throwOnConcurrencyConflict(DamageHandlingMethodState s, DamageHandlingMethodCommand c) {
        Long stateVersion = s.getVersion();
        Long commandVersion = c.getVersion();
        if (commandVersion == null) { commandVersion = DamageHandlingMethodState.VERSION_NULL; }
        if (!(stateVersion == null && commandVersion.equals(DamageHandlingMethodState.VERSION_NULL)) && !commandVersion.equals(stateVersion)) {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and command version (%2$s)", stateVersion, commandVersion);
        }
    }

    public static class SimpleDamageHandlingMethodApplicationService extends AbstractDamageHandlingMethodApplicationService 
    {
        public SimpleDamageHandlingMethodApplicationService(DamageHandlingMethodStateRepository stateRepository, DamageHandlingMethodStateQueryRepository stateQueryRepository)
        {
            super(stateRepository, stateQueryRepository);
        }
    }

}

