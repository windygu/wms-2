package org.dddml.wms.domain.documenttype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractDocumentTypeApplicationService implements DocumentTypeApplicationService
{

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private DocumentTypeStateRepository stateRepository;

    protected DocumentTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private DocumentTypeStateQueryRepository stateQueryRepository;

    protected DocumentTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<DocumentTypeAggregate, DocumentTypeState> aggregateEventListener;

    public AggregateEventListener<DocumentTypeAggregate, DocumentTypeState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<DocumentTypeAggregate, DocumentTypeState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractDocumentTypeApplicationService(EventStore eventStore, DocumentTypeStateRepository stateRepository, DocumentTypeStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(DocumentTypeCommand.CreateDocumentType c) {
        update(c, ar -> ar.create(c));
    }

    public void when(DocumentTypeCommand.MergePatchDocumentType c) {
        update(c, ar -> ar.mergePatch(c));
    }

    public void when(DocumentTypeCommand.DeleteDocumentType c) {
        update(c, ar -> ar.delete(c));
    }

    public DocumentTypeState get(String id) {
        DocumentTypeState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<DocumentTypeState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<DocumentTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<DocumentTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<DocumentTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public DocumentTypeStateEvent getStateEvent(String documentTypeId, long version) {
        DocumentTypeStateEvent e = (DocumentTypeStateEvent)getEventStore().getStateEvent(toEventStoreAggregateId(documentTypeId), version);
        if (e != null)
        { e.setStateEventReadOnly(true); }
        else if (version == -1)
        {
            return getStateEvent(documentTypeId, 0);
        }
        return e;
    }

    public DocumentTypeState getHistoryState(String documentTypeId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractDocumentTypeStateEvent.class, toEventStoreAggregateId(documentTypeId), version - 1);
        return new AbstractDocumentTypeState.SimpleDocumentTypeState(eventStream.getEvents());
    }


    public DocumentTypeAggregate getDocumentTypeAggregate(DocumentTypeState state)
    {
        return new AbstractDocumentTypeAggregate.SimpleDocumentTypeAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(DocumentTypeCommand c, Consumer<DocumentTypeAggregate> action)
    {
        String aggregateId = c.getDocumentTypeId();
        DocumentTypeState state = getStateRepository().get(aggregateId, false);
        DocumentTypeAggregate aggregate = getDocumentTypeAggregate(state);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, DocumentTypeAggregate aggregate, DocumentTypeState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { getStateRepository().save(state); });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    public void initialize(DocumentTypeStateEvent.DocumentTypeStateCreated stateCreated) {
        String aggregateId = stateCreated.getStateEventId().getDocumentTypeId();
        DocumentTypeState state = new AbstractDocumentTypeState.SimpleDocumentTypeState();
        state.setDocumentTypeId(aggregateId);

        DocumentTypeAggregate aggregate = getDocumentTypeAggregate(state);
        ((AbstractDocumentTypeAggregate) aggregate).apply(stateCreated);

        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        persist(eventStoreAggregateId, stateCreated.getStateEventId().getVersion(), aggregate, state);
    }

    protected boolean isRepeatedCommand(DocumentTypeCommand command, EventStoreAggregateId eventStoreAggregateId, DocumentTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(DocumentTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() > command.getVersion())
        {
            Event lastEvent = getEventStore().findLastEvent(AbstractDocumentTypeStateEvent.class, eventStoreAggregateId, command.getVersion());
            if (lastEvent != null && lastEvent instanceof AbstractStateEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractStateEvent) lastEvent).getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    public static class SimpleDocumentTypeApplicationService extends AbstractDocumentTypeApplicationService 
    {
        public SimpleDocumentTypeApplicationService(EventStore eventStore, DocumentTypeStateRepository stateRepository, DocumentTypeStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

