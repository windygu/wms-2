package org.dddml.wms.domain.documenttype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface DocumentTypeStateQueryRepository
{
    DocumentTypeState get(String id);

    Iterable<DocumentTypeState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<DocumentTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<DocumentTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    DocumentTypeState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    DocumentTypeState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<DocumentTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

