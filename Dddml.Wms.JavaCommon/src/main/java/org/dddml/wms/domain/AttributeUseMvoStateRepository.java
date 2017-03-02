package org.dddml.wms.domain;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeUseMvoStateRepository
{
    AttributeUseMvoState get(AttributeSetAttributeUseId id);

    AttributeUseMvoState get(AttributeSetAttributeUseId id, boolean nullAllowed);

    Iterable<AttributeUseMvoState> getAll(Integer firstResult, Integer maxResults);
    
    void save(AttributeUseMvoState state);
    
    Iterable<AttributeUseMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<AttributeUseMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    AttributeUseMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    AttributeUseMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<AttributeUseMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

