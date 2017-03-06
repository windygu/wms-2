package org.dddml.wms.domain.attributeusemvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeUseMvoStateQueryRepository
{
    AttributeUseMvoState get(AttributeSetAttributeUseId id);

    Iterable<AttributeUseMvoState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<AttributeUseMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<AttributeUseMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    AttributeUseMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    AttributeUseMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<AttributeUseMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

