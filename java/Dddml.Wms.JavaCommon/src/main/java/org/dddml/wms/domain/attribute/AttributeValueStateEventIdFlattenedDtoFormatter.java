package org.dddml.wms.domain.attribute;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class AttributeValueStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<AttributeValueStateEventIdFlattenedDto>
{


    @Override
    protected AttributeValueStateEventIdFlattenedDto newDto() {
        return new AttributeValueStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return AttributeValueStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(AttributeValueStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("attributeId".equals(fieldName)) {
            dto.setAttributeId((String) objVal);
            return;
        }
        if ("value".equals(fieldName)) {
            dto.setValue((String) objVal);
            return;
        }
        if ("attributeVersion".equals(fieldName)) {
            dto.setAttributeVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(AttributeValueStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("attributeId".equals(fieldName)) {
            Object objVal = dto.getAttributeId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("value".equals(fieldName)) {
            Object objVal = dto.getValue();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("attributeVersion".equals(fieldName)) {
            Object objVal = dto.getAttributeVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = AttributeValueStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

