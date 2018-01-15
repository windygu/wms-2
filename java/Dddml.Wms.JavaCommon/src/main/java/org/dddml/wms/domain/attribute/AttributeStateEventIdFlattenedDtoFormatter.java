package org.dddml.wms.domain.attribute;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class AttributeStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<AttributeStateEventIdFlattenedDto>
{


    @Override
    protected AttributeStateEventIdFlattenedDto newDto() {
        return new AttributeStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return AttributeStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(AttributeStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("attributeId".equals(fieldName)) {
            dto.setAttributeId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(AttributeStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("attributeId".equals(fieldName)) {
            Object objVal = dto.getAttributeId();
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
        String type = AttributeStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

