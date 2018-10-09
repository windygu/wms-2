package org.dddml.wms.domain.contactmech;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractContactMechApplicationService implements ContactMechApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private ContactMechStateRepository stateRepository;

    protected ContactMechStateRepository getStateRepository() {
        return stateRepository;
    }

    private ContactMechStateQueryRepository stateQueryRepository;

    protected ContactMechStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<ContactMechAggregate, ContactMechState> aggregateEventListener;

    public AggregateEventListener<ContactMechAggregate, ContactMechState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<ContactMechAggregate, ContactMechState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractContactMechApplicationService(EventStore eventStore, ContactMechStateRepository stateRepository, ContactMechStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ContactMechCommand.CreateContactMech c) {
        update(c, ar -> ar.create(c));
    }

    public void when(ContactMechCommand.MergePatchContactMech c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(ContactMechCommand.DeleteContactMech c) {
        update(c, ar -> ar.delete(c));
    }

    public ContactMechState get(String id) {
        ContactMechState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<ContactMechState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<ContactMechState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ContactMechState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ContactMechState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public ContactMechEvent getEvent(String contactMechId, long version) {
        ContactMechEvent e = (ContactMechEvent)getEventStore().getEvent(toEventStoreAggregateId(contactMechId), version);
        if (e != null) {
            ((ContactMechEvent.SqlContactMechEvent)e).setEventReadOnly(true); 
        } else if (version == -1) {
            return getEvent(contactMechId, 0);
        }
        return e;
    }

    public ContactMechState getHistoryState(String contactMechId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractContactMechEvent.class, toEventStoreAggregateId(contactMechId), version - 1);
        return new AbstractContactMechState.SimpleContactMechState(eventStream.getEvents());
    }


    public ContactMechAggregate getContactMechAggregate(ContactMechState state)
    {
        return new AbstractContactMechAggregate.SimpleContactMechAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ContactMechCommand c, Consumer<ContactMechAggregate> action)
    {
        String aggregateId = c.getContactMechId();
        ContactMechState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        ContactMechAggregate aggregate = getContactMechAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ContactMechAggregate aggregate, ContactMechState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(ContactMechEvent.ContactMechStateCreated stateCreated) {
        String aggregateId = ((ContactMechEvent.SqlContactMechEvent)stateCreated).getContactMechEventId().getContactMechId();
        ContactMechState.SqlContactMechState state = new AbstractContactMechState.SimpleContactMechState();
        state.setContactMechId(aggregateId);

        ContactMechAggregate aggregate = getContactMechAggregate(state);
        ((AbstractContactMechAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, ((ContactMechEvent.SqlContactMechEvent)stateCreated).getContactMechEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(ContactMechCommand command, EventStoreAggregateId eventStoreAggregateId, ContactMechState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(ContactMechState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().getEvent(AbstractContactMechEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleContactMechApplicationService extends AbstractContactMechApplicationService 
    {
        public SimpleContactMechApplicationService(EventStore eventStore, ContactMechStateRepository stateRepository, ContactMechStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

