package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class InventoryItemStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<InventoryItemStateEventIdFlattenedDto>
{


    @Override
    protected InventoryItemStateEventIdFlattenedDto newDto() {
        return new InventoryItemStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return InventoryItemStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(InventoryItemStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("inventoryItemIdProductId".equals(fieldName)) {
            dto.setInventoryItemIdProductId((String) objVal);
            return;
        }
        if ("inventoryItemIdLocatorId".equals(fieldName)) {
            dto.setInventoryItemIdLocatorId((String) objVal);
            return;
        }
        if ("inventoryItemIdAttributeSetInstanceId".equals(fieldName)) {
            dto.setInventoryItemIdAttributeSetInstanceId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(InventoryItemStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("inventoryItemIdProductId".equals(fieldName)) {
            Object objVal = dto.getInventoryItemIdProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryItemIdLocatorId".equals(fieldName)) {
            Object objVal = dto.getInventoryItemIdLocatorId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryItemIdAttributeSetInstanceId".equals(fieldName)) {
            Object objVal = dto.getInventoryItemIdAttributeSetInstanceId();
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
        String type = InventoryItemStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        if (clazz == null) {
            throw new RuntimeException("ERROR! ReflectUtils.CLASS_MAP.get(type) == null");
        }
        return clazz;
    }

}

