package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class YearPlanMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<YearPlanMvoStateEventIdFlattenedDto>
{


    @Override
    protected YearPlanMvoStateEventIdFlattenedDto newDto() {
        return new YearPlanMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return YearPlanMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(YearPlanMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("yearPlanIdPersonalNameFirstName".equals(fieldName)) {
            dto.setYearPlanIdPersonalNameFirstName((String) objVal);
            return;
        }
        if ("yearPlanIdPersonalNameLastName".equals(fieldName)) {
            dto.setYearPlanIdPersonalNameLastName((String) objVal);
            return;
        }
        if ("yearPlanIdYear".equals(fieldName)) {
            dto.setYearPlanIdYear((Integer) objVal);
            return;
        }
        if ("personVersion".equals(fieldName)) {
            dto.setPersonVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(YearPlanMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("yearPlanIdPersonalNameFirstName".equals(fieldName)) {
            Object objVal = dto.getYearPlanIdPersonalNameFirstName();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("yearPlanIdPersonalNameLastName".equals(fieldName)) {
            Object objVal = dto.getYearPlanIdPersonalNameLastName();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("yearPlanIdYear".equals(fieldName)) {
            Object objVal = dto.getYearPlanIdYear();
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
        String type = YearPlanMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

