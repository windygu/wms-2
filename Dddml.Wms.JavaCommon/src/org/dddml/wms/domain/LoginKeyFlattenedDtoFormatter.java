package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class LoginKeyFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<LoginKeyFlattenedDto>
{


    @Override
    protected LoginKeyFlattenedDto newDto() {
        return new LoginKeyFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return LoginKeyFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(LoginKeyFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("loginProvider".equals(fieldName)) {
            dto.setLoginProvider((String) objVal);
            return;
        }
        if ("providerKey".equals(fieldName)) {
            dto.setProviderKey((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(LoginKeyFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("loginProvider".equals(fieldName)) {
            Object objVal = dto.getLoginProvider();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("providerKey".equals(fieldName)) {
            Object objVal = dto.getProviderKey();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = LoginKeyFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

