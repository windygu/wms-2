package org.dddml.wms.domain.documenttype;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractDocumentTypeApplicationService implements DocumentTypeApplicationService
{
    private DocumentTypeStateRepository stateRepository;

    protected DocumentTypeStateRepository getStateRepository() {
        return stateRepository;
    }

    private DocumentTypeStateQueryRepository stateQueryRepository;

    protected DocumentTypeStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    public AbstractDocumentTypeApplicationService(DocumentTypeStateRepository stateRepository, DocumentTypeStateQueryRepository stateQueryRepository) {
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(DocumentTypeCommand.CreateDocumentType c) {
        update(c, s -> {
        // //////////////////////////
        throwOnConcurrencyConflict(s, c);
        ((DocumentTypeState.SqlDocumentTypeState)s).setDescription(c.getDescription());
        ((DocumentTypeState.SqlDocumentTypeState)s).setParentDocumentTypeId(c.getParentDocumentTypeId());
        ((DocumentTypeState.SqlDocumentTypeState)s).setActive(c.getActive());
        ((DocumentTypeState.SqlDocumentTypeState)s).setDeleted(false);
        ((DocumentTypeState.SqlDocumentTypeState)s).setCreatedBy(c.getRequesterId());
        ((DocumentTypeState.SqlDocumentTypeState)s).setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        ((DocumentTypeState.SqlDocumentTypeState)s).setCommandId(c.getCommandId());
        // //////////////////////////
        });
    }

    public void when(DocumentTypeCommand.MergePatchDocumentType c) {
        update(c, s -> {
        // //////////////////////////////////
        throwOnConcurrencyConflict(s, c);
        if (c.getDescription() == null) {
            if (c.getIsPropertyDescriptionRemoved() != null && c.getIsPropertyDescriptionRemoved()) {
                ((DocumentTypeState.SqlDocumentTypeState)s).setDescription(null);
            }
        } else {
            ((DocumentTypeState.SqlDocumentTypeState)s).setDescription(c.getDescription());
        }
        if (c.getParentDocumentTypeId() == null) {
            if (c.getIsPropertyParentDocumentTypeIdRemoved() != null && c.getIsPropertyParentDocumentTypeIdRemoved()) {
                ((DocumentTypeState.SqlDocumentTypeState)s).setParentDocumentTypeId(null);
            }
        } else {
            ((DocumentTypeState.SqlDocumentTypeState)s).setParentDocumentTypeId(c.getParentDocumentTypeId());
        }
        if (c.getActive() == null) {
            if (c.getIsPropertyActiveRemoved() != null && c.getIsPropertyActiveRemoved()) {
                ((DocumentTypeState.SqlDocumentTypeState)s).setActive(null);
            }
        } else {
            ((DocumentTypeState.SqlDocumentTypeState)s).setActive(c.getActive());
        }
        ((DocumentTypeState.SqlDocumentTypeState)s).setUpdatedBy(c.getRequesterId());
        ((DocumentTypeState.SqlDocumentTypeState)s).setUpdatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        ((DocumentTypeState.SqlDocumentTypeState)s).setCommandId(c.getCommandId());
        // //////////////////////////////////
        });
    }

    public void when(DocumentTypeCommand.DeleteDocumentType c) {
        update(c, s -> {
        throwOnConcurrencyConflict(s, c);
        // ///////////////////////////////////
        //todo
        // ///////////////////////////////////
        });
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

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId)
    {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(DocumentTypeCommand c, Consumer<DocumentTypeState> action)
    {
        String aggregateId = c.getDocumentTypeId();
        DocumentTypeState state = getStateRepository().get(aggregateId, false);
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);

        boolean repeated = isRepeatedCommand(c, eventStoreAggregateId, state);
        if (repeated) { return; }

        DocumentTypeCommand.throwOnInvalidStateTransition(state, c);
        action.accept(state);
        persist(eventStoreAggregateId, c.getVersion(), state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, DocumentTypeState state) {
        getStateRepository().save(state);
    }

    protected boolean isRepeatedCommand(DocumentTypeCommand command, EventStoreAggregateId eventStoreAggregateId, DocumentTypeState state)
    {
        boolean repeated = false;
        if (command.getVersion() == null) { command.setVersion(DocumentTypeState.VERSION_NULL); }
        if (state.getVersion() != null && state.getVersion() == command.getVersion() + 1)
        {
            if (command.getCommandId() != null && command.getCommandId().equals(state.getCommandId()))
            {
                repeated = true;
            }
        }
        return repeated;
    }

    protected static void throwOnConcurrencyConflict(DocumentTypeState s, DocumentTypeCommand c) {
        Long stateVersion = s.getVersion();
        Long commandVersion = c.getVersion();
        if (commandVersion == null) { commandVersion = DocumentTypeState.VERSION_NULL; }
        if (!(stateVersion == null && commandVersion.equals(DocumentTypeState.VERSION_NULL)) && !commandVersion.equals(stateVersion)) {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and command version (%2$s)", stateVersion, commandVersion);
        }
    }

    public static class SimpleDocumentTypeApplicationService extends AbstractDocumentTypeApplicationService 
    {
        public SimpleDocumentTypeApplicationService(DocumentTypeStateRepository stateRepository, DocumentTypeStateQueryRepository stateQueryRepository)
        {
            super(stateRepository, stateQueryRepository);
        }
    }

}

