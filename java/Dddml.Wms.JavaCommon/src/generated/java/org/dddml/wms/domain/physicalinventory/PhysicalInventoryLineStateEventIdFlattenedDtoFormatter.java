package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class PhysicalInventoryLineStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<PhysicalInventoryLineStateEventIdFlattenedDto>
{


    @Override
    protected PhysicalInventoryLineStateEventIdFlattenedDto newDto() {
        return new PhysicalInventoryLineStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return PhysicalInventoryLineStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(PhysicalInventoryLineStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("physicalInventoryDocumentNumber".equals(fieldName)) {
            dto.setPhysicalInventoryDocumentNumber((String) objVal);
            return;
        }
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
        if ("physicalInventoryVersion".equals(fieldName)) {
            dto.setPhysicalInventoryVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(PhysicalInventoryLineStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("physicalInventoryDocumentNumber".equals(fieldName)) {
            Object objVal = dto.getPhysicalInventoryDocumentNumber();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
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
        if ("physicalInventoryVersion".equals(fieldName)) {
            Object objVal = dto.getPhysicalInventoryVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = PhysicalInventoryLineStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

