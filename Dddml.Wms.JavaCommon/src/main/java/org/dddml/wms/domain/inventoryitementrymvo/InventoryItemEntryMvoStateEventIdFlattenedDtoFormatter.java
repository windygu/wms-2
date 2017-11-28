package org.dddml.wms.domain.inventoryitementrymvo;

import org.dddml.wms.domain.inventoryitem.InventoryItemEntryIdDto;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class InventoryItemEntryMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<InventoryItemEntryMvoStateEventIdFlattenedDto>
{


    @Override
    protected InventoryItemEntryMvoStateEventIdFlattenedDto newDto() {
        return new InventoryItemEntryMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return InventoryItemEntryMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(InventoryItemEntryMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("inventoryItemEntryIdInventoryItemIdProductId".equals(fieldName)) {
            dto.setInventoryItemEntryIdInventoryItemIdProductId((String) objVal);
            return;
        }
        if ("inventoryItemEntryIdInventoryItemIdLocatorId".equals(fieldName)) {
            dto.setInventoryItemEntryIdInventoryItemIdLocatorId((String) objVal);
            return;
        }
        if ("inventoryItemEntryIdInventoryItemIdAttributeSetInstance".equals(fieldName)) {
            dto.setInventoryItemEntryIdInventoryItemIdAttributeSetInstance((String) objVal);
            return;
        }
        if ("inventoryItemEntryIdEntrySeqId".equals(fieldName)) {
            dto.setInventoryItemEntryIdEntrySeqId((Long) objVal);
            return;
        }
        if ("inventoryItemVersion".equals(fieldName)) {
            dto.setInventoryItemVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(InventoryItemEntryMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("inventoryItemEntryIdInventoryItemIdProductId".equals(fieldName)) {
            Object objVal = dto.getInventoryItemEntryIdInventoryItemIdProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryItemEntryIdInventoryItemIdLocatorId".equals(fieldName)) {
            Object objVal = dto.getInventoryItemEntryIdInventoryItemIdLocatorId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryItemEntryIdInventoryItemIdAttributeSetInstance".equals(fieldName)) {
            Object objVal = dto.getInventoryItemEntryIdInventoryItemIdAttributeSetInstance();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryItemEntryIdEntrySeqId".equals(fieldName)) {
            Object objVal = dto.getInventoryItemEntryIdEntrySeqId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryItemVersion".equals(fieldName)) {
            Object objVal = dto.getInventoryItemVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = InventoryItemEntryMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

