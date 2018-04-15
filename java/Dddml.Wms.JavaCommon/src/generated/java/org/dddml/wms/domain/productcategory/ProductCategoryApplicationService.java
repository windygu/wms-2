package org.dddml.wms.domain.productcategory;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ProductCategoryApplicationService
{
    void when(ProductCategoryCommand.CreateProductCategory c);

    void when(ProductCategoryCommand.MergePatchProductCategory c);

    void when(ProductCategoryCommand.DeleteProductCategory c);

    ProductCategoryState get(String id);

    Iterable<ProductCategoryState> getAll(Integer firstResult, Integer maxResults);

    Iterable<ProductCategoryState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ProductCategoryState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ProductCategoryState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ProductCategoryEvent getEvent(String productCategoryId, long version);

    ProductCategoryState getHistoryState(String productCategoryId, long version);

    Iterable<ProductCategoryState> getChildProductCategories(String productCategoryId);

}

