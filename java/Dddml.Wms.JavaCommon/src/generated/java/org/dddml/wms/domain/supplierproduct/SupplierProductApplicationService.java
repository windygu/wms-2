package org.dddml.wms.domain.supplierproduct;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface SupplierProductApplicationService
{
    void when(SupplierProductCommand.CreateSupplierProduct c);

    void when(SupplierProductCommand.MergePatchSupplierProduct c);

    SupplierProductState get(SupplierProductId id);

    Iterable<SupplierProductState> getAll(Integer firstResult, Integer maxResults);

    Iterable<SupplierProductState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<SupplierProductState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<SupplierProductState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    SupplierProductStateEvent getStateEvent(SupplierProductId supplierProductId, long version);

    SupplierProductState getHistoryState(SupplierProductId supplierProductId, long version);

}

