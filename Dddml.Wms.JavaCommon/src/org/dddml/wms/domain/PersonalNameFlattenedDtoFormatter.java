package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class PersonalNameFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<PersonalNameFlattenedDto>
{


    @Override
    protected PersonalNameFlattenedDto newDto() {
        return new PersonalNameFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return PersonalNameFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(PersonalNameFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("firstName".equals(fieldName)) {
            dto.setFirstName((String) objVal);
            return;
        }
        if ("lastName".equals(fieldName)) {
            dto.setLastName((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(PersonalNameFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("firstName".equals(fieldName)) {
            Object objVal = dto.getFirstName();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("lastName".equals(fieldName)) {
            Object objVal = dto.getLastName();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = PersonalNameFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

