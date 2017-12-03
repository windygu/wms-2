package org.dddml.wms.domain.inventoryprtriggered;

import org.dddml.wms.domain.inventoryitem.InventoryItemEntryIdDto;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class InventoryPRTriggeredIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<InventoryPRTriggeredIdFlattenedDto>
{


    @Override
    protected InventoryPRTriggeredIdFlattenedDto newDto() {
        return new InventoryPRTriggeredIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return InventoryPRTriggeredIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(InventoryPRTriggeredIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("sourceEntryIdInventoryItemIdProductId".equals(fieldName)) {
            dto.setSourceEntryIdInventoryItemIdProductId((String) objVal);
            return;
        }
        if ("sourceEntryIdInventoryItemIdLocatorId".equals(fieldName)) {
            dto.setSourceEntryIdInventoryItemIdLocatorId((String) objVal);
            return;
        }
        if ("sourceEntryIdInventoryItemIdAttributeSetInstanceId".equals(fieldName)) {
            dto.setSourceEntryIdInventoryItemIdAttributeSetInstanceId((String) objVal);
            return;
        }
        if ("sourceEntryIdEntrySeqId".equals(fieldName)) {
            dto.setSourceEntryIdEntrySeqId((Long) objVal);
            return;
        }
        if ("inventoryPostingRuleId".equals(fieldName)) {
            dto.setInventoryPostingRuleId((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(InventoryPRTriggeredIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("sourceEntryIdInventoryItemIdProductId".equals(fieldName)) {
            Object objVal = dto.getSourceEntryIdInventoryItemIdProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("sourceEntryIdInventoryItemIdLocatorId".equals(fieldName)) {
            Object objVal = dto.getSourceEntryIdInventoryItemIdLocatorId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("sourceEntryIdInventoryItemIdAttributeSetInstanceId".equals(fieldName)) {
            Object objVal = dto.getSourceEntryIdInventoryItemIdAttributeSetInstanceId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("sourceEntryIdEntrySeqId".equals(fieldName)) {
            Object objVal = dto.getSourceEntryIdEntrySeqId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryPostingRuleId".equals(fieldName)) {
            Object objVal = dto.getInventoryPostingRuleId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = InventoryPRTriggeredIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

