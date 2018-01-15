package org.dddml.wms.domain.party;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractPartyApplicationService implements PartyApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private PartyStateRepository stateRepository;

    protected PartyStateRepository getStateRepository() {
        return stateRepository;
    }

    private PartyStateQueryRepository stateQueryRepository;

    protected PartyStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<PartyAggregate, PartyState> aggregateEventListener;

    public AggregateEventListener<PartyAggregate, PartyState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<PartyAggregate, PartyState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractPartyApplicationService(EventStore eventStore, PartyStateRepository stateRepository, PartyStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(PartyCommand.CreateParty c) {
        update(c, ar -> ar.create(c));
    }

    public void when(PartyCommand.MergePatchParty c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(PartyCommand.DeleteParty c) {
        update(c, ar -> ar.delete(c));
    }

    public PartyState get(String id) {
        PartyState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<PartyState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<PartyState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PartyState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<PartyState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public Iterable<PartyState> getAll(Class<? extends PartyState> stateType, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(stateType, firstResult, maxResults);
    }

    public Iterable<PartyState> get(Class<? extends PartyState> stateType, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(stateType, filter, orders, firstResult, maxResults);
    }

    public Iterable<PartyState> get(Class<? extends PartyState> stateType, Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(stateType, filter, orders, firstResult, maxResults);
    }

    public Iterable<PartyState> getByProperty(Class<? extends PartyState> stateType, String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(stateType, propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Class<? extends PartyState> stateType, Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(stateType, filter);
    }

    public long getCount(Class<? extends PartyState> stateType, Criterion filter) {
        return getStateQueryRepository().getCount(stateType, filter);
    }

    public PartyStateEvent getStateEvent(String partyId, long version) {
        PartyStateEvent e = (PartyStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(partyId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(partyId, 0);
        }
        return e;
    }

    public PartyState getHistoryState(String partyId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractPartyStateEvent.class, toEventStoreAggregateId(partyId), version - 1);
        return new AbstractPartyState.SimplePartyState(eventStream.getEvents());
    }


    public PartyAggregate getPartyAggregate(PartyState state)
    {
        return new AbstractPartyAggregate.SimplePartyAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(PartyCommand c, Consumer<PartyAggregate> action)
    {
        String aggregateId = c.getPartyId();
        Class<? extends PartyState> stateType = getStateType(c);
        PartyState state = getStateRepository().get(stateType, aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        PartyAggregate aggregate = getPartyAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, PartyAggregate aggregate, PartyState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(PartyStateEvent.PartyStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getPartyId();
        PartyState state = new AbstractPartyState.SimplePartyState();
        state.setPartyId(aggregateId);

        PartyAggregate aggregate = getPartyAggregate(state);
        ((AbstractPartyAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    public void initialize(OrganizationStateEvent.OrganizationStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getPartyId();
        OrganizationState state = new AbstractOrganizationState.SimpleOrganizationState();
        state.setPartyId(aggregateId);

        PartyAggregate aggregate = getPartyAggregate(state);
        ((AbstractPartyAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected Class<? extends PartyState> getStateType(PartyCommand c) {
        Class<? extends PartyState> clazz = PartyState.class;
        String discriminatorVal = null;
        if (c instanceof PartyCommand.CreateOrMergePatchParty) {
            discriminatorVal = ((PartyCommand.CreateOrMergePatchParty) c).getPartyTypeId();
        } else if (c instanceof PartyCommand.DeleteParty) {
            discriminatorVal = ((PartyCommand.DeleteParty) c).getPartyTypeId();
        }
        if (discriminatorVal != null) {
            switch (discriminatorVal) {
                case PartyTypeIds.PARTY:
                    clazz = PartyState.class;
                    break;
                case PartyTypeIds.ORGANIZATION:
                    clazz = OrganizationState.class;
                    break;
            }
        }
        return clazz;
    }

    protected boolean isRepeatedCommand(PartyCommand command, EventStoreAggregateId eventStoreAggregateId, PartyState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(PartyState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractPartyStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimplePartyApplicationService extends AbstractPartyApplicationService 
    {
        public SimplePartyApplicationService(EventStore eventStore, PartyStateRepository stateRepository, PartyStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

