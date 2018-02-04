package org.dddml.wms.domain.sellableinventoryitementrymvo;

import org.dddml.wms.domain.sellableinventoryitem.SellableInventoryItemEntryIdDto;
import org.dddml.wms.domain.sellableinventoryitem.*;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class SellableInventoryItemEntryMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<SellableInventoryItemEntryMvoStateEventIdFlattenedDto>
{


    @Override
    protected SellableInventoryItemEntryMvoStateEventIdFlattenedDto newDto() {
        return new SellableInventoryItemEntryMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return SellableInventoryItemEntryMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(SellableInventoryItemEntryMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("sellableInventoryItemEntryIdSellableInventoryItemIdProductId".equals(fieldName)) {
            dto.setSellableInventoryItemEntryIdSellableInventoryItemIdProductId((String) objVal);
            return;
        }
        if ("sellableInventoryItemEntryIdSellableInventoryItemIdLocatorId".equals(fieldName)) {
            dto.setSellableInventoryItemEntryIdSellableInventoryItemIdLocatorId((String) objVal);
            return;
        }
        if ("sellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId".equals(fieldName)) {
            dto.setSellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId((String) objVal);
            return;
        }
        if ("sellableInventoryItemEntryIdEntrySeqId".equals(fieldName)) {
            dto.setSellableInventoryItemEntryIdEntrySeqId((Long) objVal);
            return;
        }
        if ("sellableInventoryItemVersion".equals(fieldName)) {
            dto.setSellableInventoryItemVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(SellableInventoryItemEntryMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("sellableInventoryItemEntryIdSellableInventoryItemIdProductId".equals(fieldName)) {
            Object objVal = dto.getSellableInventoryItemEntryIdSellableInventoryItemIdProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("sellableInventoryItemEntryIdSellableInventoryItemIdLocatorId".equals(fieldName)) {
            Object objVal = dto.getSellableInventoryItemEntryIdSellableInventoryItemIdLocatorId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("sellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId".equals(fieldName)) {
            Object objVal = dto.getSellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("sellableInventoryItemEntryIdEntrySeqId".equals(fieldName)) {
            Object objVal = dto.getSellableInventoryItemEntryIdEntrySeqId();
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
        String type = SellableInventoryItemEntryMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

