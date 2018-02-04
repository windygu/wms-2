package org.dddml.wms.domain.attribute;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class AttributeAliasIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<AttributeAliasIdFlattenedDto>
{


    @Override
    protected AttributeAliasIdFlattenedDto newDto() {
        return new AttributeAliasIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return AttributeAliasIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(AttributeAliasIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("attributeId".equals(fieldName)) {
            dto.setAttributeId((String) objVal);
            return;
        }
        if ("code".equals(fieldName)) {
            dto.setCode((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(AttributeAliasIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("attributeId".equals(fieldName)) {
            Object objVal = dto.getAttributeId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("code".equals(fieldName)) {
            Object objVal = dto.getCode();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = AttributeAliasIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(type);
        if (clazz == null) {
            throw new RuntimeException("ERROR! CANNOT get the class from CLASS_MAP!");
        }
        return clazz;
    }

}

