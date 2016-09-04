package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class UserLoginMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<UserLoginMvoStateEventIdFlattenedDto>
{


    @Override
    protected UserLoginMvoStateEventIdFlattenedDto newDto() {
        return new UserLoginMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return UserLoginMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(UserLoginMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("userLoginIdUserId".equals(fieldName)) {
            dto.setUserLoginIdUserId((String) objVal);
            return;
        }
        if ("userLoginIdLoginKeyLoginProvider".equals(fieldName)) {
            dto.setUserLoginIdLoginKeyLoginProvider((String) objVal);
            return;
        }
        if ("userLoginIdLoginKeyProviderKey".equals(fieldName)) {
            dto.setUserLoginIdLoginKeyProviderKey((String) objVal);
            return;
        }
        if ("userVersion".equals(fieldName)) {
            dto.setUserVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(UserLoginMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("userLoginIdUserId".equals(fieldName)) {
            Object objVal = dto.getUserLoginIdUserId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("userLoginIdLoginKeyLoginProvider".equals(fieldName)) {
            Object objVal = dto.getUserLoginIdLoginKeyLoginProvider();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("userLoginIdLoginKeyProviderKey".equals(fieldName)) {
            Object objVal = dto.getUserLoginIdLoginKeyProviderKey();
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
        String type = UserLoginMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

