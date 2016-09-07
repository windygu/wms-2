package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class UserRoleMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<UserRoleMvoStateEventIdFlattenedDto>
{


    @Override
    protected UserRoleMvoStateEventIdFlattenedDto newDto() {
        return new UserRoleMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return UserRoleMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(UserRoleMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("userRoleIdUserId".equals(fieldName)) {
            dto.setUserRoleIdUserId((String) objVal);
            return;
        }
        if ("userRoleIdRoleId".equals(fieldName)) {
            dto.setUserRoleIdRoleId((String) objVal);
            return;
        }
        if ("userVersion".equals(fieldName)) {
            dto.setUserVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(UserRoleMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("userRoleIdUserId".equals(fieldName)) {
            Object objVal = dto.getUserRoleIdUserId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("userRoleIdRoleId".equals(fieldName)) {
            Object objVal = dto.getUserRoleIdRoleId();
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
        String type = UserRoleMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

