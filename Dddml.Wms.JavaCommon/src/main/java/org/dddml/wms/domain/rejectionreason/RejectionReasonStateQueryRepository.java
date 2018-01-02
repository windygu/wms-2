package org.dddml.wms.domain.rejectionreason;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface RejectionReasonStateQueryRepository
{
    RejectionReasonState get(String id);

    Iterable<RejectionReasonState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<RejectionReasonState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<RejectionReasonState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    RejectionReasonState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    RejectionReasonState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<RejectionReasonState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

