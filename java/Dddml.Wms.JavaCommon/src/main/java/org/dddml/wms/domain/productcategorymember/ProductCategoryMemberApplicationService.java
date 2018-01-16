package org.dddml.wms.domain.productcategorymember;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ProductCategoryMemberApplicationService
{
    void when(ProductCategoryMemberCommand.CreateProductCategoryMember c);

    void when(ProductCategoryMemberCommand.MergePatchProductCategoryMember c);

    ProductCategoryMemberState get(ProductCategoryMemberId id);

    Iterable<ProductCategoryMemberState> getAll(Integer firstResult, Integer maxResults);

    Iterable<ProductCategoryMemberState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ProductCategoryMemberState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ProductCategoryMemberState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ProductCategoryMemberStateEvent getStateEvent(ProductCategoryMemberId productCategoryMemberId, long version);

    ProductCategoryMemberState getHistoryState(ProductCategoryMemberId productCategoryMemberId, long version);

}

