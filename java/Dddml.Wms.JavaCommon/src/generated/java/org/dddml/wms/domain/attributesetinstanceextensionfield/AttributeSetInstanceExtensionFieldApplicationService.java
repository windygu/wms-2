package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface AttributeSetInstanceExtensionFieldApplicationService
{
    void when(AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField c);

    void when(AttributeSetInstanceExtensionFieldCommand.MergePatchAttributeSetInstanceExtensionField c);

    void when(AttributeSetInstanceExtensionFieldCommand.DeleteAttributeSetInstanceExtensionField c);

    AttributeSetInstanceExtensionFieldState get(String id);

    Iterable<AttributeSetInstanceExtensionFieldState> getAll(Integer firstResult, Integer maxResults);

    Iterable<AttributeSetInstanceExtensionFieldState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<AttributeSetInstanceExtensionFieldState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<AttributeSetInstanceExtensionFieldState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    AttributeSetInstanceExtensionFieldEvent getEvent(String name, long version);

    AttributeSetInstanceExtensionFieldState getHistoryState(String name, long version);

}

