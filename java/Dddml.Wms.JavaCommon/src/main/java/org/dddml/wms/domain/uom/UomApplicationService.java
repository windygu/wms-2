package org.dddml.wms.domain.uom;

import org.dddml.support.criterion.Criterion;

import java.util.List;
import java.util.Map;

public interface UomApplicationService {
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

    UomStateEvent getStateEvent(String uomId, long version);

    UomState getHistoryState(String uomId, long version);

}

