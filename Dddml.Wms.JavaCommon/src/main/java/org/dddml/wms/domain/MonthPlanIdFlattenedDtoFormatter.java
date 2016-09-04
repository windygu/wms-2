package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class MonthPlanIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<MonthPlanIdFlattenedDto>
{


    @Override
    protected MonthPlanIdFlattenedDto newDto() {
        return new MonthPlanIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return MonthPlanIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(MonthPlanIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("personalNameFirstName".equals(fieldName)) {
            dto.setPersonalNameFirstName((String) objVal);
            return;
        }
        if ("personalNameLastName".equals(fieldName)) {
            dto.setPersonalNameLastName((String) objVal);
            return;
        }
        if ("year".equals(fieldName)) {
            dto.setYear((Integer) objVal);
            return;
        }
        if ("month".equals(fieldName)) {
            dto.setMonth((Integer) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(MonthPlanIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("personalNameFirstName".equals(fieldName)) {
            Object objVal = dto.getPersonalNameFirstName();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("personalNameLastName".equals(fieldName)) {
            Object objVal = dto.getPersonalNameLastName();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("year".equals(fieldName)) {
            Object objVal = dto.getYear();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("month".equals(fieldName)) {
            Object objVal = dto.getMonth();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = MonthPlanIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

