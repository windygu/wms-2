package org.dddml.wms.domain.pickwave;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PickwaveApplicationService
{
    void when(PickwaveCommand.CreatePickwave c);

    void when(PickwaveCommand.MergePatchPickwave c);

    void when(PickwaveCommand.DeletePickwave c);

    PickwaveState get(Long id);

    Iterable<PickwaveState> getAll(Integer firstResult, Integer maxResults);

    Iterable<PickwaveState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PickwaveState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PickwaveState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    PickwaveStateEvent getStateEvent(Long pickwaveId, long version);

    PickwaveState getHistoryState(Long pickwaveId, long version);

}

