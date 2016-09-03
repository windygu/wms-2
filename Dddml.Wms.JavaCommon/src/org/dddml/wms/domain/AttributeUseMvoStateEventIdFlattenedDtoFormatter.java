package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class AttributeUseMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<AttributeUseMvoStateEventIdFlattenedDto>
{


    @Override
    protected AttributeUseMvoStateEventIdFlattenedDto newDto() {
        return new AttributeUseMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return AttributeUseMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(AttributeUseMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("attributeSetAttributeUseIdAttributeSetId".equals(fieldName)) {
            dto.setAttributeSetAttributeUseIdAttributeSetId((String) objVal);
            return;
        }
        if ("attributeSetAttributeUseIdAttributeId".equals(fieldName)) {
            dto.setAttributeSetAttributeUseIdAttributeId((String) objVal);
            return;
        }
        if ("attributeSetVersion".equals(fieldName)) {
            dto.setAttributeSetVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(AttributeUseMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("attributeSetAttributeUseIdAttributeSetId".equals(fieldName)) {
            Object objVal = dto.getAttributeSetAttributeUseIdAttributeSetId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("attributeSetAttributeUseIdAttributeId".equals(fieldName)) {
            Object objVal = dto.getAttributeSetAttributeUseIdAttributeId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("attributeSetVersion".equals(fieldName)) {
            Object objVal = dto.getAttributeSetVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = AttributeUseMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

