package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class LocatorStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<LocatorStateEventIdFlattenedDto>
{


    @Override
    protected LocatorStateEventIdFlattenedDto newDto() {
        return new LocatorStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return LocatorStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(LocatorStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("locatorId".equals(fieldName)) {
            dto.setLocatorId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(LocatorStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("locatorId".equals(fieldName)) {
            Object objVal = dto.getLocatorId();
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
        String type = LocatorStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

