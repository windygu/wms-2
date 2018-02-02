package org.dddml.wms.domain.warehouse;

/**
 * Created by yangjiefeng on 2018/2/2.
 */
public class WarehouseUtils {

    public static String getInTransitLocatorId(String warehouseId) {
        if (warehouseId == null) {
            throw new IllegalArgumentException("Null warehouseId.");
        }
        return warehouseId + "-IN_TRANSIT";
    }

    public static String getReceivingLocatorId(String warehouseId) {
        if (warehouseId == null) {
            throw new IllegalArgumentException("Null warehouseId.");
        }
        return warehouseId + "-RECEIVING_AREA";
    }

}
