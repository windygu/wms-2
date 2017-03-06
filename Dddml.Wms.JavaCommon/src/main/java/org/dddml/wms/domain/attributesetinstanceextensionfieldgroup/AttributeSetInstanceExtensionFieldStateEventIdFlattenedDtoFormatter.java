package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;

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
        if ("groupId".equals(fieldName)) {
            dto.setGroupId((String) objVal);
            return;
        }
        if ("index".equals(fieldName)) {
            dto.setIndex((String) objVal);
            return;
        }
        if ("attributeSetInstanceExtensionFieldGroupVersion".equals(fieldName)) {
            dto.setAttributeSetInstanceExtensionFieldGroupVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(AttributeSetInstanceExtensionFieldStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("groupId".equals(fieldName)) {
            Object objVal = dto.getGroupId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("index".equals(fieldName)) {
            Object objVal = dto.getIndex();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("attributeSetInstanceExtensionFieldGroupVersion".equals(fieldName)) {
            Object objVal = dto.getAttributeSetInstanceExtensionFieldGroupVersion();
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
        return clazz;
    }

}

