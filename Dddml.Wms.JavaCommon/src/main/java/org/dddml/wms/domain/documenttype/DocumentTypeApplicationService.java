package org.dddml.wms.domain.documenttype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface DocumentTypeApplicationService
{
    void when(DocumentTypeCommand.CreateDocumentType c);

    void when(DocumentTypeCommand.MergePatchDocumentType c);

    void when(DocumentTypeCommand.DeleteDocumentType c);

    DocumentTypeState get(String id);

    Iterable<DocumentTypeState> getAll(Integer firstResult, Integer maxResults);

    Iterable<DocumentTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<DocumentTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<DocumentTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    DocumentTypeStateEvent getStateEvent(String documentTypeId, long version);

    DocumentTypeState getHistoryState(String documentTypeId, long version);

}

