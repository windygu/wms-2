package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class RolePermissionStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<RolePermissionStateEventIdFlattenedDto>
{


    @Override
    protected RolePermissionStateEventIdFlattenedDto newDto() {
        return new RolePermissionStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return RolePermissionStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(RolePermissionStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("idRoleId".equals(fieldName)) {
            dto.setIdRoleId((String) objVal);
            return;
        }
        if ("idPermissionId".equals(fieldName)) {
            dto.setIdPermissionId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(RolePermissionStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("idRoleId".equals(fieldName)) {
            Object objVal = dto.getIdRoleId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("idPermissionId".equals(fieldName)) {
            Object objVal = dto.getIdPermissionId();
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
        String type = RolePermissionStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

