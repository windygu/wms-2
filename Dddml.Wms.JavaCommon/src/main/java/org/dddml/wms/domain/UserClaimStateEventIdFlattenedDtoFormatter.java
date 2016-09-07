package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class UserClaimStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<UserClaimStateEventIdFlattenedDto>
{


    @Override
    protected UserClaimStateEventIdFlattenedDto newDto() {
        return new UserClaimStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return UserClaimStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(UserClaimStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("userId".equals(fieldName)) {
            dto.setUserId((String) objVal);
            return;
        }
        if ("claimId".equals(fieldName)) {
            dto.setClaimId((Integer) objVal);
            return;
        }
        if ("userVersion".equals(fieldName)) {
            dto.setUserVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(UserClaimStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("userId".equals(fieldName)) {
            Object objVal = dto.getUserId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("claimId".equals(fieldName)) {
            Object objVal = dto.getClaimId();
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
        String type = UserClaimStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

