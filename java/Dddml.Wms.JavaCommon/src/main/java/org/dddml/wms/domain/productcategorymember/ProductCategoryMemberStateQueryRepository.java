package org.dddml.wms.domain.productcategorymember;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface ProductCategoryMemberStateQueryRepository
{
    ProductCategoryMemberState get(ProductCategoryMemberId id);

    Iterable<ProductCategoryMemberState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<ProductCategoryMemberState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ProductCategoryMemberState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    ProductCategoryMemberState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    ProductCategoryMemberState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<ProductCategoryMemberState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

