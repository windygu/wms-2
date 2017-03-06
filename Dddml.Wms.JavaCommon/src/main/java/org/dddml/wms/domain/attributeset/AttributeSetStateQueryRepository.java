package org.dddml.wms.domain.attributeset;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeSetStateQueryRepository
{
    AttributeSetState get(String id);

    Iterable<AttributeSetState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<AttributeSetState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<AttributeSetState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    AttributeSetState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    AttributeSetState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<AttributeSetState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    AttributeUseState getAttributeUse(String attributeSetId, String attributeId);

}

