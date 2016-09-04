package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class MonthPlanMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<MonthPlanMvoStateEventIdFlattenedDto>
{


    @Override
    protected MonthPlanMvoStateEventIdFlattenedDto newDto() {
        return new MonthPlanMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return MonthPlanMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(MonthPlanMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("monthPlanIdPersonalNameFirstName".equals(fieldName)) {
            dto.setMonthPlanIdPersonalNameFirstName((String) objVal);
            return;
        }
        if ("monthPlanIdPersonalNameLastName".equals(fieldName)) {
            dto.setMonthPlanIdPersonalNameLastName((String) objVal);
            return;
        }
        if ("monthPlanIdYear".equals(fieldName)) {
            dto.setMonthPlanIdYear((Integer) objVal);
            return;
        }
        if ("monthPlanIdMonth".equals(fieldName)) {
            dto.setMonthPlanIdMonth((Integer) objVal);
            return;
        }
        if ("personVersion".equals(fieldName)) {
            dto.setPersonVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(MonthPlanMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("monthPlanIdPersonalNameFirstName".equals(fieldName)) {
            Object objVal = dto.getMonthPlanIdPersonalNameFirstName();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("monthPlanIdPersonalNameLastName".equals(fieldName)) {
            Object objVal = dto.getMonthPlanIdPersonalNameLastName();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("monthPlanIdYear".equals(fieldName)) {
            Object objVal = dto.getMonthPlanIdYear();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("monthPlanIdMonth".equals(fieldName)) {
            Object objVal = dto.getMonthPlanIdMonth();
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
        String type = MonthPlanMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

