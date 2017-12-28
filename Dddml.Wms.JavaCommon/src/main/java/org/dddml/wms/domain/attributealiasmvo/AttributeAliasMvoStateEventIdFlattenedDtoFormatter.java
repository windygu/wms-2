package org.dddml.wms.domain.attributealiasmvo;

import org.dddml.wms.domain.attribute.AttributeAliasIdDto;
import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class AttributeAliasMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<AttributeAliasMvoStateEventIdFlattenedDto>
{


    @Override
    protected AttributeAliasMvoStateEventIdFlattenedDto newDto() {
        return new AttributeAliasMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return AttributeAliasMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(AttributeAliasMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("attributeAliasIdAttributeId".equals(fieldName)) {
            dto.setAttributeAliasIdAttributeId((String) objVal);
            return;
        }
        if ("attributeAliasIdCode".equals(fieldName)) {
            dto.setAttributeAliasIdCode((String) objVal);
            return;
        }
        if ("attributeVersion".equals(fieldName)) {
            dto.setAttributeVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(AttributeAliasMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("attributeAliasIdAttributeId".equals(fieldName)) {
            Object objVal = dto.getAttributeAliasIdAttributeId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("attributeAliasIdCode".equals(fieldName)) {
            Object objVal = dto.getAttributeAliasIdCode();
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
        String type = AttributeAliasMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

