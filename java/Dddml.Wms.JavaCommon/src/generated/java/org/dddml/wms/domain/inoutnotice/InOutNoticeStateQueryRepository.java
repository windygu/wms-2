package org.dddml.wms.domain.inoutnotice;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InOutNoticeStateQueryRepository
{
    InOutNoticeState get(String id);

    Iterable<InOutNoticeState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<InOutNoticeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InOutNoticeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    InOutNoticeState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    InOutNoticeState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<InOutNoticeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

