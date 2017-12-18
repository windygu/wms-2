package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import org.dddml.wms.domain.inventoryitemrequirement.InventoryItemRequirementEntryIdDto;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class InventoryItemRequirementEntryMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<InventoryItemRequirementEntryMvoStateEventIdFlattenedDto>
{


    @Override
    protected InventoryItemRequirementEntryMvoStateEventIdFlattenedDto newDto() {
        return new InventoryItemRequirementEntryMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return InventoryItemRequirementEntryMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(InventoryItemRequirementEntryMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("inventoryItemRequirementEntryIdInventoryItemRequirementIdProductId".equals(fieldName)) {
            dto.setInventoryItemRequirementEntryIdInventoryItemRequirementIdProductId((String) objVal);
            return;
        }
        if ("inventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId".equals(fieldName)) {
            dto.setInventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId((String) objVal);
            return;
        }
        if ("inventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId".equals(fieldName)) {
            dto.setInventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId((String) objVal);
            return;
        }
        if ("inventoryItemRequirementEntryIdEntrySeqId".equals(fieldName)) {
            dto.setInventoryItemRequirementEntryIdEntrySeqId((Long) objVal);
            return;
        }
        if ("inventoryItemRequirementVersion".equals(fieldName)) {
            dto.setInventoryItemRequirementVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(InventoryItemRequirementEntryMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("inventoryItemRequirementEntryIdInventoryItemRequirementIdProductId".equals(fieldName)) {
            Object objVal = dto.getInventoryItemRequirementEntryIdInventoryItemRequirementIdProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId".equals(fieldName)) {
            Object objVal = dto.getInventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId".equals(fieldName)) {
            Object objVal = dto.getInventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryItemRequirementEntryIdEntrySeqId".equals(fieldName)) {
            Object objVal = dto.getInventoryItemRequirementEntryIdEntrySeqId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryItemRequirementVersion".equals(fieldName)) {
            Object objVal = dto.getInventoryItemRequirementVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = InventoryItemRequirementEntryMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

