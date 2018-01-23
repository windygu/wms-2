package org.dddml.wms.domain.lot;

import org.dddml.support.criterion.Criterion;

import java.util.List;
import java.util.Map;

public interface LotApplicationService {
    void when(LotCommand.CreateLot c);

    void when(LotCommand.MergePatchLot c);

    void when(LotCommand.DeleteLot c);

    LotState get(String id);

    Iterable<LotState> getAll(Integer firstResult, Integer maxResults);

    Iterable<LotState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<LotState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<LotState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    LotStateEvent getStateEvent(String lotId, long version);

    LotState getHistoryState(String lotId, long version);

}

