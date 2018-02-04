package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class SellableInventoryItemEntryStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<SellableInventoryItemEntryStateEventIdFlattenedDto>
{


    @Override
    protected SellableInventoryItemEntryStateEventIdFlattenedDto newDto() {
        return new SellableInventoryItemEntryStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return SellableInventoryItemEntryStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(SellableInventoryItemEntryStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
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
        if ("entrySeqId".equals(fieldName)) {
            dto.setEntrySeqId((Long) objVal);
            return;
        }
        if ("sellableInventoryItemVersion".equals(fieldName)) {
            dto.setSellableInventoryItemVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(SellableInventoryItemEntryStateEventIdFlattenedDto dto, String fieldName) {
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
        if ("entrySeqId".equals(fieldName)) {
            Object objVal = dto.getEntrySeqId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("sellableInventoryItemVersion".equals(fieldName)) {
            Object objVal = dto.getSellableInventoryItemVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = SellableInventoryItemEntryStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

