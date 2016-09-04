package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class UserClaimMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<UserClaimMvoStateEventIdFlattenedDto>
{


    @Override
    protected UserClaimMvoStateEventIdFlattenedDto newDto() {
        return new UserClaimMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return UserClaimMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(UserClaimMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("userClaimIdUserId".equals(fieldName)) {
            dto.setUserClaimIdUserId((String) objVal);
            return;
        }
        if ("userClaimIdClaimId".equals(fieldName)) {
            dto.setUserClaimIdClaimId((Integer) objVal);
            return;
        }
        if ("userVersion".equals(fieldName)) {
            dto.setUserVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(UserClaimMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("userClaimIdUserId".equals(fieldName)) {
            Object objVal = dto.getUserClaimIdUserId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("userClaimIdClaimId".equals(fieldName)) {
            Object objVal = dto.getUserClaimIdClaimId();
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
        String type = UserClaimMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

