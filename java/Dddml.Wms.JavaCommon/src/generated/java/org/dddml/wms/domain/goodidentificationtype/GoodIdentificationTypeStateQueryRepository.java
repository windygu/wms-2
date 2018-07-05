package org.dddml.wms.domain.goodidentificationtype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface GoodIdentificationTypeStateQueryRepository
{
    GoodIdentificationTypeState get(String id);

    Iterable<GoodIdentificationTypeState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<GoodIdentificationTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<GoodIdentificationTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    GoodIdentificationTypeState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    GoodIdentificationTypeState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<GoodIdentificationTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

