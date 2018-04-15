package org.dddml.wms.domain.contactmech;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ContactMechApplicationService
{
    void when(ContactMechCommand.CreateContactMech c);

    void when(ContactMechCommand.MergePatchContactMech c);

    void when(ContactMechCommand.DeleteContactMech c);

    ContactMechState get(String id);

    Iterable<ContactMechState> getAll(Integer firstResult, Integer maxResults);

    Iterable<ContactMechState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ContactMechState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ContactMechState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ContactMechEvent getEvent(String contactMechId, long version);

    ContactMechState getHistoryState(String contactMechId, long version);

}

