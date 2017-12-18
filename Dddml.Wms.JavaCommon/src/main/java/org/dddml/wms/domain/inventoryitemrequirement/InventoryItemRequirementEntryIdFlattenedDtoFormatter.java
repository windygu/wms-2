package org.dddml.wms.domain.inventoryitemrequirement;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class InventoryItemRequirementEntryIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<InventoryItemRequirementEntryIdFlattenedDto>
{


    @Override
    protected InventoryItemRequirementEntryIdFlattenedDto newDto() {
        return new InventoryItemRequirementEntryIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return InventoryItemRequirementEntryIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(InventoryItemRequirementEntryIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("inventoryItemRequirementIdProductId".equals(fieldName)) {
            dto.setInventoryItemRequirementIdProductId((String) objVal);
            return;
        }
        if ("inventoryItemRequirementIdLocatorId".equals(fieldName)) {
            dto.setInventoryItemRequirementIdLocatorId((String) objVal);
            return;
        }
        if ("inventoryItemRequirementIdAttributeSetInstanceId".equals(fieldName)) {
            dto.setInventoryItemRequirementIdAttributeSetInstanceId((String) objVal);
            return;
        }
        if ("entrySeqId".equals(fieldName)) {
            dto.setEntrySeqId((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(InventoryItemRequirementEntryIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("inventoryItemRequirementIdProductId".equals(fieldName)) {
            Object objVal = dto.getInventoryItemRequirementIdProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryItemRequirementIdLocatorId".equals(fieldName)) {
            Object objVal = dto.getInventoryItemRequirementIdLocatorId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryItemRequirementIdAttributeSetInstanceId".equals(fieldName)) {
            Object objVal = dto.getInventoryItemRequirementIdAttributeSetInstanceId();
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
        String type = InventoryItemRequirementEntryIdFlattenedDto.propertyTypeMap.get(fieldName);
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

