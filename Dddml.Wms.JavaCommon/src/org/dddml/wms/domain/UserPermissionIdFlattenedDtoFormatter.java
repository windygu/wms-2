package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class UserPermissionIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<UserPermissionIdFlattenedDto>
{


    @Override
    protected UserPermissionIdFlattenedDto newDto() {
        return new UserPermissionIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return UserPermissionIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(UserPermissionIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("userId".equals(fieldName)) {
            dto.setUserId((String) objVal);
            return;
        }
        if ("permissionId".equals(fieldName)) {
            dto.setPermissionId((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(UserPermissionIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("userId".equals(fieldName)) {
            Object objVal = dto.getUserId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("permissionId".equals(fieldName)) {
            Object objVal = dto.getPermissionId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = UserPermissionIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

