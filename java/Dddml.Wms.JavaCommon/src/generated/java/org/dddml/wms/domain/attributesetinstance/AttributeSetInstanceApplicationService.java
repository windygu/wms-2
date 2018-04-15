package org.dddml.wms.domain.attributesetinstance;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface AttributeSetInstanceApplicationService
{
    String createWithoutId(AttributeSetInstanceCommand.CreateAttributeSetInstance c);

    void when(AttributeSetInstanceCommand.CreateAttributeSetInstance c);

    AttributeSetInstanceState get(String id);

    Iterable<AttributeSetInstanceState> getAll(Integer firstResult, Integer maxResults);

    Iterable<AttributeSetInstanceState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<AttributeSetInstanceState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<AttributeSetInstanceState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    AttributeSetInstanceEvent getEvent(String attributeSetInstanceId, long version);

    AttributeSetInstanceState getHistoryState(String attributeSetInstanceId, long version);

}

