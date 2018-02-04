package org.dddml.wms.domain.inventoryitemrequirement;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class InventoryItemRequirementStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<InventoryItemRequirementStateEventIdFlattenedDto>
{


    @Override
    protected InventoryItemRequirementStateEventIdFlattenedDto newDto() {
        return new InventoryItemRequirementStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return InventoryItemRequirementStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(InventoryItemRequirementStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
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
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(InventoryItemRequirementStateEventIdFlattenedDto dto, String fieldName) {
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
        if ("version".equals(fieldName)) {
            Object objVal = dto.getVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = InventoryItemRequirementStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

