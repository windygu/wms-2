package org.dddml.wms.domain.product;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ProductApplicationService
{
    void when(ProductCommand.CreateProduct c);

    void when(ProductCommand.MergePatchProduct c);

    ProductState get(String id);

    Iterable<ProductState> getAll(Integer firstResult, Integer maxResults);

    Iterable<ProductState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ProductState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ProductState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    ProductEvent getEvent(String productId, long version);

    ProductState getHistoryState(String productId, long version);

    GoodIdentificationState getGoodIdentification(String productId, String goodIdentificationTypeId);

    Iterable<GoodIdentificationState> getGoodIdentifications(String productId);

}

