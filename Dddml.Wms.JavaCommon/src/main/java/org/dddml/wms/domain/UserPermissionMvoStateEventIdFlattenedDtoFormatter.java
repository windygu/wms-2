package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class UserPermissionMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<UserPermissionMvoStateEventIdFlattenedDto>
{


    @Override
    protected UserPermissionMvoStateEventIdFlattenedDto newDto() {
        return new UserPermissionMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return UserPermissionMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(UserPermissionMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("userPermissionIdUserId".equals(fieldName)) {
            dto.setUserPermissionIdUserId((String) objVal);
            return;
        }
        if ("userPermissionIdPermissionId".equals(fieldName)) {
            dto.setUserPermissionIdPermissionId((String) objVal);
            return;
        }
        if ("userVersion".equals(fieldName)) {
            dto.setUserVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(UserPermissionMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("userPermissionIdUserId".equals(fieldName)) {
            Object objVal = dto.getUserPermissionIdUserId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("userPermissionIdPermissionId".equals(fieldName)) {
            Object objVal = dto.getUserPermissionIdPermissionId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("userVersion".equals(fieldName)) {
            Object objVal = dto.getUserVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = UserPermissionMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

