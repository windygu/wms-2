package org.dddml.wms.domain.attributeset;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class AttributeUseStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<AttributeUseStateEventIdFlattenedDto>
{


    @Override
    protected AttributeUseStateEventIdFlattenedDto newDto() {
        return new AttributeUseStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return AttributeUseStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(AttributeUseStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("attributeSetId".equals(fieldName)) {
            dto.setAttributeSetId((String) objVal);
            return;
        }
        if ("attributeId".equals(fieldName)) {
            dto.setAttributeId((String) objVal);
            return;
        }
        if ("attributeSetVersion".equals(fieldName)) {
            dto.setAttributeSetVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(AttributeUseStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("attributeSetId".equals(fieldName)) {
            Object objVal = dto.getAttributeSetId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("attributeId".equals(fieldName)) {
            Object objVal = dto.getAttributeId();
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
        String type = AttributeUseStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

