package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class PermissionStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<PermissionStateEventIdFlattenedDto>
{


    @Override
    protected PermissionStateEventIdFlattenedDto newDto() {
        return new PermissionStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return PermissionStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(PermissionStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("permissionId".equals(fieldName)) {
            dto.setPermissionId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(PermissionStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("permissionId".equals(fieldName)) {
            Object objVal = dto.getPermissionId();
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
        String type = PermissionStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

