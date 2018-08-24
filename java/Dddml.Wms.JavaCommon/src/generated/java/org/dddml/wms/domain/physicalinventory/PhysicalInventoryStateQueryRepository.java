package org.dddml.wms.domain.physicalinventory;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public interface PhysicalInventoryStateQueryRepository
{
    PhysicalInventoryState get(String id);

    Iterable<PhysicalInventoryState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<PhysicalInventoryState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PhysicalInventoryState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    PhysicalInventoryState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    PhysicalInventoryState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<PhysicalInventoryState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    PhysicalInventoryLineState getPhysicalInventoryLine(String physicalInventoryDocumentNumber, InventoryItemId inventoryItemId);

    Iterable<PhysicalInventoryLineState> getPhysicalInventoryLines(String physicalInventoryDocumentNumber, Criterion filter, List<String> orders);

}

