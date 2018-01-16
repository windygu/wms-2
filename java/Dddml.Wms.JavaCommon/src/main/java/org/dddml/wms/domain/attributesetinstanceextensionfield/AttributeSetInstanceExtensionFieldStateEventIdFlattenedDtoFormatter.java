package org.dddml.wms.domain.attributesetinstanceextensionfield;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class AttributeSetInstanceExtensionFieldStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<AttributeSetInstanceExtensionFieldStateEventIdFlattenedDto>
{


    @Override
    protected AttributeSetInstanceExtensionFieldStateEventIdFlattenedDto newDto() {
        return new AttributeSetInstanceExtensionFieldStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return AttributeSetInstanceExtensionFieldStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(AttributeSetInstanceExtensionFieldStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("name".equals(fieldName)) {
            dto.setName((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(AttributeSetInstanceExtensionFieldStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("name".equals(fieldName)) {
            Object objVal = dto.getName();
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
        String type = AttributeSetInstanceExtensionFieldStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

