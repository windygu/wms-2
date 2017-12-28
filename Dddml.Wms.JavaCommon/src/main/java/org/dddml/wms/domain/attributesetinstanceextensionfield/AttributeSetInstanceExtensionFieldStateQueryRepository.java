package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface AttributeSetInstanceExtensionFieldStateQueryRepository
{
    AttributeSetInstanceExtensionFieldState get(String id);

    Iterable<AttributeSetInstanceExtensionFieldState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<AttributeSetInstanceExtensionFieldState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<AttributeSetInstanceExtensionFieldState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    AttributeSetInstanceExtensionFieldState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    AttributeSetInstanceExtensionFieldState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<AttributeSetInstanceExtensionFieldState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

