package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class InventoryItemEntryIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<InventoryItemEntryIdFlattenedDto>
{


    @Override
    protected InventoryItemEntryIdFlattenedDto newDto() {
        return new InventoryItemEntryIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return InventoryItemEntryIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(InventoryItemEntryIdFlattenedDto dto, String fieldName, String fieldValue) {
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
        if ("entrySeqId".equals(fieldName)) {
            dto.setEntrySeqId((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(InventoryItemEntryIdFlattenedDto dto, String fieldName) {
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
        if ("entrySeqId".equals(fieldName)) {
            Object objVal = dto.getEntrySeqId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = InventoryItemEntryIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

