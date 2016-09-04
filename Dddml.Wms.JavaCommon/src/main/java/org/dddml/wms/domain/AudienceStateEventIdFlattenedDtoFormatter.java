package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class AudienceStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<AudienceStateEventIdFlattenedDto>
{


    @Override
    protected AudienceStateEventIdFlattenedDto newDto() {
        return new AudienceStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return AudienceStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(AudienceStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("clientId".equals(fieldName)) {
            dto.setClientId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(AudienceStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("clientId".equals(fieldName)) {
            Object objVal = dto.getClientId();
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
        String type = AudienceStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

