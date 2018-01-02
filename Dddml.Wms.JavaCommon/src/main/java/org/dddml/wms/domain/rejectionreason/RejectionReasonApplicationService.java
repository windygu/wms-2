package org.dddml.wms.domain.rejectionreason;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface RejectionReasonApplicationService
{
    void when(RejectionReasonCommand.CreateRejectionReason c);

    void when(RejectionReasonCommand.MergePatchRejectionReason c);

    void when(RejectionReasonCommand.DeleteRejectionReason c);

    RejectionReasonState get(String id);

    Iterable<RejectionReasonState> getAll(Integer firstResult, Integer maxResults);

    Iterable<RejectionReasonState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<RejectionReasonState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<RejectionReasonState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    RejectionReasonStateEvent getStateEvent(String rejectionReasonId, long version);

    RejectionReasonState getHistoryState(String rejectionReasonId, long version);

}

