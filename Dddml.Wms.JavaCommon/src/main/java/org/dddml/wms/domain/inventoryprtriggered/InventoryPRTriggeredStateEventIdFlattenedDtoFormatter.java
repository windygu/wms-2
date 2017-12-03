package org.dddml.wms.domain.inventoryprtriggered;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class InventoryPRTriggeredStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<InventoryPRTriggeredStateEventIdFlattenedDto>
{


    @Override
    protected InventoryPRTriggeredStateEventIdFlattenedDto newDto() {
        return new InventoryPRTriggeredStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return InventoryPRTriggeredStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(InventoryPRTriggeredStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("inventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId".equals(fieldName)) {
            dto.setInventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId((String) objVal);
            return;
        }
        if ("inventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId".equals(fieldName)) {
            dto.setInventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId((String) objVal);
            return;
        }
        if ("inventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId".equals(fieldName)) {
            dto.setInventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId((String) objVal);
            return;
        }
        if ("inventoryPRTriggeredIdSourceEntryIdEntrySeqId".equals(fieldName)) {
            dto.setInventoryPRTriggeredIdSourceEntryIdEntrySeqId((Long) objVal);
            return;
        }
        if ("inventoryPRTriggeredIdInventoryPostingRuleId".equals(fieldName)) {
            dto.setInventoryPRTriggeredIdInventoryPostingRuleId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(InventoryPRTriggeredStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("inventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId".equals(fieldName)) {
            Object objVal = dto.getInventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId".equals(fieldName)) {
            Object objVal = dto.getInventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId".equals(fieldName)) {
            Object objVal = dto.getInventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryPRTriggeredIdSourceEntryIdEntrySeqId".equals(fieldName)) {
            Object objVal = dto.getInventoryPRTriggeredIdSourceEntryIdEntrySeqId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inventoryPRTriggeredIdInventoryPostingRuleId".equals(fieldName)) {
            Object objVal = dto.getInventoryPRTriggeredIdInventoryPostingRuleId();
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
        String type = InventoryPRTriggeredStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

