package org.dddml.wms.domain.uom;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface UomApplicationService
{
    void when(UomCommand.CreateUom c);

    void when(UomCommand.MergePatchUom c);

    void when(UomCommand.DeleteUom c);

    UomState get(String id);

    Iterable<UomState> getAll(Integer firstResult, Integer maxResults);

    Iterable<UomState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<UomState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<UomState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    UomEvent getEvent(String uomId, long version);

    UomState getHistoryState(String uomId, long version);

}

