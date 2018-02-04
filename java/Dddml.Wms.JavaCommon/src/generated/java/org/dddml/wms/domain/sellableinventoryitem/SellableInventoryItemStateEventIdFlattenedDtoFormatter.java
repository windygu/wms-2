package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class SellableInventoryItemStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<SellableInventoryItemStateEventIdFlattenedDto>
{


    @Override
    protected SellableInventoryItemStateEventIdFlattenedDto newDto() {
        return new SellableInventoryItemStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return SellableInventoryItemStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(SellableInventoryItemStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("sellableInventoryItemIdProductId".equals(fieldName)) {
            dto.setSellableInventoryItemIdProductId((String) objVal);
            return;
        }
        if ("sellableInventoryItemIdLocatorId".equals(fieldName)) {
            dto.setSellableInventoryItemIdLocatorId((String) objVal);
            return;
        }
        if ("sellableInventoryItemIdAttributeSetInstanceId".equals(fieldName)) {
            dto.setSellableInventoryItemIdAttributeSetInstanceId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(SellableInventoryItemStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("sellableInventoryItemIdProductId".equals(fieldName)) {
            Object objVal = dto.getSellableInventoryItemIdProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("sellableInventoryItemIdLocatorId".equals(fieldName)) {
            Object objVal = dto.getSellableInventoryItemIdLocatorId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("sellableInventoryItemIdAttributeSetInstanceId".equals(fieldName)) {
            Object objVal = dto.getSellableInventoryItemIdAttributeSetInstanceId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("version".equals(fieldName)) {
            Object objVal = dto.getVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = SellableInventoryItemStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(type);
        if (clazz == null) {
            throw new RuntimeException("ERROR! CANNOT get the class from CLASS_MAP!");
        }
        return clazz;
    }

}

