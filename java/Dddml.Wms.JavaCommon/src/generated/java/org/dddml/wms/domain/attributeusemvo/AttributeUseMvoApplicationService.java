package org.dddml.wms.domain.attributeusemvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface AttributeUseMvoApplicationService
{
    void when(AttributeUseMvoCommand.CreateAttributeUseMvo c);

    void when(AttributeUseMvoCommand.MergePatchAttributeUseMvo c);

    void when(AttributeUseMvoCommand.DeleteAttributeUseMvo c);

    AttributeUseMvoState get(AttributeSetAttributeUseId id);

    Iterable<AttributeUseMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<AttributeUseMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<AttributeUseMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<AttributeUseMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    AttributeUseMvoEvent getEvent(AttributeSetAttributeUseId attributeSetAttributeUseId, long version);

    AttributeUseMvoState getHistoryState(AttributeSetAttributeUseId attributeSetAttributeUseId, long version);

}

