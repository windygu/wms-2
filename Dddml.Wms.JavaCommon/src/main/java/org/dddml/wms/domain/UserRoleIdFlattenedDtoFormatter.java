package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class UserRoleIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<UserRoleIdFlattenedDto>
{


    @Override
    protected UserRoleIdFlattenedDto newDto() {
        return new UserRoleIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return UserRoleIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(UserRoleIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("userId".equals(fieldName)) {
            dto.setUserId((String) objVal);
            return;
        }
        if ("roleId".equals(fieldName)) {
            dto.setRoleId((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(UserRoleIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("userId".equals(fieldName)) {
            Object objVal = dto.getUserId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("roleId".equals(fieldName)) {
            Object objVal = dto.getRoleId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = UserRoleIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

