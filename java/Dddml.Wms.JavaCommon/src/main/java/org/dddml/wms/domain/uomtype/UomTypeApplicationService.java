package org.dddml.wms.domain.uomtype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface UomTypeApplicationService
{
    void when(UomTypeCommand.CreateUomType c);

    void when(UomTypeCommand.MergePatchUomType c);

    void when(UomTypeCommand.DeleteUomType c);

    UomTypeState get(String id);

    Iterable<UomTypeState> getAll(Integer firstResult, Integer maxResults);

    Iterable<UomTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<UomTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<UomTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    UomTypeStateEvent getStateEvent(String uomTypeId, long version);

    UomTypeState getHistoryState(String uomTypeId, long version);

}

