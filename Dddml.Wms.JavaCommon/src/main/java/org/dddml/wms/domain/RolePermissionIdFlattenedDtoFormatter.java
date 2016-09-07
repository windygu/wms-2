package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class RolePermissionIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<RolePermissionIdFlattenedDto>
{


    @Override
    protected RolePermissionIdFlattenedDto newDto() {
        return new RolePermissionIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return RolePermissionIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(RolePermissionIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("roleId".equals(fieldName)) {
            dto.setRoleId((String) objVal);
            return;
        }
        if ("permissionId".equals(fieldName)) {
            dto.setPermissionId((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(RolePermissionIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("roleId".equals(fieldName)) {
            Object objVal = dto.getRoleId();
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
        String type = RolePermissionIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

