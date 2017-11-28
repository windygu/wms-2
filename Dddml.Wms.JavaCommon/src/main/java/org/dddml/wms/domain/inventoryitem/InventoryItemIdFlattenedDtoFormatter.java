package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class InventoryItemIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<InventoryItemIdFlattenedDto>
{


    @Override
    protected InventoryItemIdFlattenedDto newDto() {
        return new InventoryItemIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return InventoryItemIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(InventoryItemIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("productId".equals(fieldName)) {
            dto.setProductId((String) objVal);
            return;
        }
        if ("locatorId".equals(fieldName)) {
            dto.setLocatorId((String) objVal);
            return;
        }
        if ("attributeSetInstance".equals(fieldName)) {
            dto.setAttributeSetInstance((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(InventoryItemIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("productId".equals(fieldName)) {
            Object objVal = dto.getProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("locatorId".equals(fieldName)) {
            Object objVal = dto.getLocatorId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("attributeSetInstance".equals(fieldName)) {
            Object objVal = dto.getAttributeSetInstance();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = InventoryItemIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

