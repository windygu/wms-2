package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class UserRoleStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<UserRoleStateEventIdFlattenedDto>
{


    @Override
    protected UserRoleStateEventIdFlattenedDto newDto() {
        return new UserRoleStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return UserRoleStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(UserRoleStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
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
        if ("userVersion".equals(fieldName)) {
            dto.setUserVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(UserRoleStateEventIdFlattenedDto dto, String fieldName) {
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
        if ("userVersion".equals(fieldName)) {
            Object objVal = dto.getUserVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = UserRoleStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

