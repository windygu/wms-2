package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class DayPlanStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<DayPlanStateEventIdFlattenedDto>
{


    @Override
    protected DayPlanStateEventIdFlattenedDto newDto() {
        return new DayPlanStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return DayPlanStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(DayPlanStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
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
        if ("day".equals(fieldName)) {
            dto.setDay((Integer) objVal);
            return;
        }
        if ("personVersion".equals(fieldName)) {
            dto.setPersonVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(DayPlanStateEventIdFlattenedDto dto, String fieldName) {
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
        if ("day".equals(fieldName)) {
            Object objVal = dto.getDay();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("personVersion".equals(fieldName)) {
            Object objVal = dto.getPersonVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = DayPlanStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

