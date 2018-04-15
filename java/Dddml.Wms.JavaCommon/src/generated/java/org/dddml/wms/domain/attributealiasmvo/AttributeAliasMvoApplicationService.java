package org.dddml.wms.domain.attributealiasmvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface AttributeAliasMvoApplicationService
{
    void when(AttributeAliasMvoCommand.CreateAttributeAliasMvo c);

    void when(AttributeAliasMvoCommand.MergePatchAttributeAliasMvo c);

    void when(AttributeAliasMvoCommand.DeleteAttributeAliasMvo c);

    AttributeAliasMvoState get(AttributeAliasId id);

    Iterable<AttributeAliasMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<AttributeAliasMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<AttributeAliasMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<AttributeAliasMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    AttributeAliasMvoEvent getEvent(AttributeAliasId attributeAliasId, long version);

    AttributeAliasMvoState getHistoryState(AttributeAliasId attributeAliasId, long version);

}

