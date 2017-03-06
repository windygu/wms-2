package org.dddml.wms.domain.attributesetinstanceextensionfieldmvo;

import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.AttributeSetInstanceExtensionFieldIdDto;
import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.*;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class AttributeSetInstanceExtensionFieldMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<AttributeSetInstanceExtensionFieldMvoStateEventIdFlattenedDto>
{


    @Override
    protected AttributeSetInstanceExtensionFieldMvoStateEventIdFlattenedDto newDto() {
        return new AttributeSetInstanceExtensionFieldMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return AttributeSetInstanceExtensionFieldMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(AttributeSetInstanceExtensionFieldMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("attributeSetInstanceExtensionFieldIdGroupId".equals(fieldName)) {
            dto.setAttributeSetInstanceExtensionFieldIdGroupId((String) objVal);
            return;
        }
        if ("attributeSetInstanceExtensionFieldIdIndex".equals(fieldName)) {
            dto.setAttributeSetInstanceExtensionFieldIdIndex((String) objVal);
            return;
        }
        if ("attrSetInstEFGroupVersion".equals(fieldName)) {
            dto.setAttrSetInstEFGroupVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(AttributeSetInstanceExtensionFieldMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("attributeSetInstanceExtensionFieldIdGroupId".equals(fieldName)) {
            Object objVal = dto.getAttributeSetInstanceExtensionFieldIdGroupId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("attributeSetInstanceExtensionFieldIdIndex".equals(fieldName)) {
            Object objVal = dto.getAttributeSetInstanceExtensionFieldIdIndex();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("attrSetInstEFGroupVersion".equals(fieldName)) {
            Object objVal = dto.getAttrSetInstEFGroupVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = AttributeSetInstanceExtensionFieldMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

