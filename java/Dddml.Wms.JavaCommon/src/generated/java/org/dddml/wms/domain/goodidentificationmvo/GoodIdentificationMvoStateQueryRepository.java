package org.dddml.wms.domain.goodidentificationmvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface GoodIdentificationMvoStateQueryRepository
{
    GoodIdentificationMvoState get(ProductGoodIdentificationId id);

    Iterable<GoodIdentificationMvoState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<GoodIdentificationMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<GoodIdentificationMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    GoodIdentificationMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    GoodIdentificationMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<GoodIdentificationMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

