package org.dddml.wms.domain.product;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ProductStateQueryRepository
{
    ProductState get(String id);

    Iterable<ProductState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<ProductState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ProductState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    ProductState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    ProductState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<ProductState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    GoodIdentificationState getGoodIdentification(String productId, String goodIdentificationTypeId);

    Iterable<GoodIdentificationState> getGoodIdentifications(String productId);

}

