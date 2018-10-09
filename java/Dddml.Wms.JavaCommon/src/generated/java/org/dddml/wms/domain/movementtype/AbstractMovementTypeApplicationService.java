package org.dddml.wms.domain.movementtype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractMovementTypeApplicationService implements MovementTypeApplicationService
{
    private MovementTypeStateRepository stateRepository;

    protected MovementTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private MovementTypeStateQueryRepository stateQueryRepository;

    protected MovementTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    public AbstractMovementTypeApplicationService(MovementTypeStateRepository stateRepository, MovementTypeStateQueryRepository stateQueryRepository) {
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(MovementTypeCommand.CreateMovementType c) {
        update(c, s -> {
        // //////////////////////////
        throwOnConcurrencyConflict(s, c);
        ((MovementTypeState.SqlMovementTypeState)s).setDescription(c.getDescription());
        ((MovementTypeState.SqlMovementTypeState)s).setActive(c.getActive());
        ((MovementTypeState.SqlMovementTypeState)s).setDeleted(false);
        ((MovementTypeState.SqlMovementTypeState)s).setCreatedBy(c.getRequesterId());
        ((MovementTypeState.SqlMovementTypeState)s).setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        ((MovementTypeState.SqlMovementTypeState)s).setCommandId(c.getCommandId());
        // //////////////////////////
        });
    }

    public void when(MovementTypeCommand.MergePatchMovementType c) {
        update(c, s -> {
        // //////////////////////////////////
        throwOnConcurrencyConflict(s, c);
        if (c.getDescription() == null) {
            if (c.getIsPropertyDescriptionRemoved() != null && c.getIsPropertyDescriptionRemoved()) {
                ((MovementTypeState.SqlMovementTypeState)s).setDescription(null);
            }
        } else {
            ((MovementTypeState.SqlMovementTypeState)s).setDescription(c.getDescription());
        }
        if (c.getActive() == null) {
            if (c.getIsPropertyActiveRemoved() != null && c.getIsPropertyActiveRemoved()) {
                ((MovementTypeState.SqlMovementTypeState)s).setActive(null);
            }
        } else {
            ((MovementTypeState.SqlMovementTypeState)s).setActive(c.getActive());
        }
        ((MovementTypeState.SqlMovementTypeState)s).setUpdatedBy(c.getRequesterId());
        ((MovementTypeState.SqlMovementTypeState)s).setUpdatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        ((MovementTypeState.SqlMovementTypeState)s).setCommandId(c.getCommandId());
        // //////////////////////////////////
        });
    }

    public void when(MovementTypeCommand.DeleteMovementType c) {
        update(c, s -> {
        throwOnConcurrencyConflict(s, c);
        // ///////////////////////////////////
        //todo
        // ///////////////////////////////////
        });
    }

    public MovementTypeState get(String id) {
        MovementTypeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<MovementTypeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<MovementTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<MovementTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<MovementTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
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

    protected void update(MovementTypeCommand c, Consumer<MovementTypeState> action)
    {
        String aggregateId = c.getMovementTypeId();
        MovementTypeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        MovementTypeCommand.throwOnInvalidStateTransition(state, c);
        action.accept(state);
        persist(eventStoreAggregateId, c.getVersion(), state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, MovementTypeState state) {
        getStateRepository().save(state);
    }

    protected boolean isRepeatedCommand(MovementTypeCommand command, EventStoreAggregateId eventStoreAggregateId, MovementTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(MovementTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() == command.getVersion() + 1)
        {
            if (command.getCommandId() != null && command.getCommandId().equals(state.getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    protected static void throwOnConcurrencyConflict(MovementTypeState s, MovementTypeCommand c) {
        Long stateVersion = s.getVersion();
        Long commandVersion = c.getVersion();
        if (commandVersion == null) { commandVersion = MovementTypeState.VERSION_NULL; }
        if (!(stateVersion == null && commandVersion.equals(MovementTypeState.VERSION_NULL)) && !commandVersion.equals(stateVersion)) {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and command version (%2$s)", stateVersion, commandVersion);
        }
    }

    public static class SimpleMovementTypeApplicationService extends AbstractMovementTypeApplicationService 
    {
        public SimpleMovementTypeApplicationService(MovementTypeStateRepository stateRepository, MovementTypeStateQueryRepository stateQueryRepository)
        {
            super(stateRepository, stateQueryRepository);
        }
    }

}

