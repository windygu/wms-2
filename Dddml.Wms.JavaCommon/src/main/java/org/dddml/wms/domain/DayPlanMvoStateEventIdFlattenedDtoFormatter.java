package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class DayPlanMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<DayPlanMvoStateEventIdFlattenedDto>
{


    @Override
    protected DayPlanMvoStateEventIdFlattenedDto newDto() {
        return new DayPlanMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return DayPlanMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(DayPlanMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("dayPlanIdPersonalNameFirstName".equals(fieldName)) {
            dto.setDayPlanIdPersonalNameFirstName((String) objVal);
            return;
        }
        if ("dayPlanIdPersonalNameLastName".equals(fieldName)) {
            dto.setDayPlanIdPersonalNameLastName((String) objVal);
            return;
        }
        if ("dayPlanIdYear".equals(fieldName)) {
            dto.setDayPlanIdYear((Integer) objVal);
            return;
        }
        if ("dayPlanIdMonth".equals(fieldName)) {
            dto.setDayPlanIdMonth((Integer) objVal);
            return;
        }
        if ("dayPlanIdDay".equals(fieldName)) {
            dto.setDayPlanIdDay((Integer) objVal);
            return;
        }
        if ("personVersion".equals(fieldName)) {
            dto.setPersonVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(DayPlanMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("dayPlanIdPersonalNameFirstName".equals(fieldName)) {
            Object objVal = dto.getDayPlanIdPersonalNameFirstName();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("dayPlanIdPersonalNameLastName".equals(fieldName)) {
            Object objVal = dto.getDayPlanIdPersonalNameLastName();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("dayPlanIdYear".equals(fieldName)) {
            Object objVal = dto.getDayPlanIdYear();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("dayPlanIdMonth".equals(fieldName)) {
            Object objVal = dto.getDayPlanIdMonth();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("dayPlanIdDay".equals(fieldName)) {
            Object objVal = dto.getDayPlanIdDay();
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
        String type = DayPlanMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

