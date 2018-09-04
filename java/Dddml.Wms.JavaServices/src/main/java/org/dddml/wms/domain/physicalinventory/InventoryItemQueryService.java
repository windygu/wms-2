package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.inventoryitem.InventoryItemState;

import java.util.List;

/**
 * Created by yangjiefeng on 2018/9/4.
 */
public interface InventoryItemQueryService {

    List<InventoryItemState> getInventoryItems(String warehouseId, String locatorIdPattern, String productIdPattern);

}
