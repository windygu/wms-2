package org.dddml.wms.domain.lot;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface LotApplicationService
{
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

    LotEvent getEvent(String lotId, long version);

    LotState getHistoryState(String lotId, long version);

}

