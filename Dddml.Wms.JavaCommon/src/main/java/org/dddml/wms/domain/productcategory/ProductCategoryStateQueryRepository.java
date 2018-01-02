package org.dddml.wms.domain.productcategory;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ProductCategoryStateQueryRepository
{
    ProductCategoryState get(String id);

    Iterable<ProductCategoryState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<ProductCategoryState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ProductCategoryState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    ProductCategoryState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    ProductCategoryState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<ProductCategoryState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    Iterable<ProductCategoryState> getChildProductCategories(String productCategoryId);

}

