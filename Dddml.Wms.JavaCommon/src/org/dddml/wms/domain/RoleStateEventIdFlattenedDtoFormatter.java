package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class RoleStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<RoleStateEventIdFlattenedDto>
{


    @Override
    protected RoleStateEventIdFlattenedDto newDto() {
        return new RoleStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return RoleStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(RoleStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("roleId".equals(fieldName)) {
            dto.setRoleId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(RoleStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("roleId".equals(fieldName)) {
            Object objVal = dto.getRoleId();
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
        String type = RoleStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

