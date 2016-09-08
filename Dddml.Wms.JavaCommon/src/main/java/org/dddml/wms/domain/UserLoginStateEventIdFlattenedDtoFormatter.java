package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class UserLoginStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<UserLoginStateEventIdFlattenedDto>
{


    @Override
    protected UserLoginStateEventIdFlattenedDto newDto() {
        return new UserLoginStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return UserLoginStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(UserLoginStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("userId".equals(fieldName)) {
            dto.setUserId((String) objVal);
            return;
        }
        if ("loginKeyLoginProvider".equals(fieldName)) {
            dto.setLoginKeyLoginProvider((String) objVal);
            return;
        }
        if ("loginKeyProviderKey".equals(fieldName)) {
            dto.setLoginKeyProviderKey((String) objVal);
            return;
        }
        if ("userVersion".equals(fieldName)) {
            dto.setUserVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(UserLoginStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("userId".equals(fieldName)) {
            Object objVal = dto.getUserId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("loginKeyLoginProvider".equals(fieldName)) {
            Object objVal = dto.getLoginKeyLoginProvider();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("loginKeyProviderKey".equals(fieldName)) {
            Object objVal = dto.getLoginKeyProviderKey();
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
        String type = UserLoginStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

