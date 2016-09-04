package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class UserClaimIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<UserClaimIdFlattenedDto>
{


    @Override
    protected UserClaimIdFlattenedDto newDto() {
        return new UserClaimIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return UserClaimIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(UserClaimIdFlattenedDto dto, String fieldName, String fieldValue) {
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
    }

    @Override
    protected String getFieldStringValue(UserClaimIdFlattenedDto dto, String fieldName) {
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
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = UserClaimIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

