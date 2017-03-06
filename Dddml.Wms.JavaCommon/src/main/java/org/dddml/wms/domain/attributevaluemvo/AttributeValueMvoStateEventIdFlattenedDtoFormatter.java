package org.dddml.wms.domain.attributevaluemvo;

import org.dddml.wms.domain.attribute.AttributeValueIdDto;
import org.dddml.wms.domain.attribute.*;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class AttributeValueMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<AttributeValueMvoStateEventIdFlattenedDto>
{


    @Override
    protected AttributeValueMvoStateEventIdFlattenedDto newDto() {
        return new AttributeValueMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return AttributeValueMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(AttributeValueMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("attributeValueIdAttributeId".equals(fieldName)) {
            dto.setAttributeValueIdAttributeId((String) objVal);
            return;
        }
        if ("attributeValueIdValue".equals(fieldName)) {
            dto.setAttributeValueIdValue((String) objVal);
            return;
        }
        if ("attributeVersion".equals(fieldName)) {
            dto.setAttributeVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(AttributeValueMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("attributeValueIdAttributeId".equals(fieldName)) {
            Object objVal = dto.getAttributeValueIdAttributeId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("attributeValueIdValue".equals(fieldName)) {
            Object objVal = dto.getAttributeValueIdValue();
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
        String type = AttributeValueMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

