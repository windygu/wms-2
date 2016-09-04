package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class TeamStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<TeamStateEventIdFlattenedDto>
{


    @Override
    protected TeamStateEventIdFlattenedDto newDto() {
        return new TeamStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return TeamStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(TeamStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("teamName".equals(fieldName)) {
            dto.setTeamName((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(TeamStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("teamName".equals(fieldName)) {
            Object objVal = dto.getTeamName();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("version".equals(fieldName)) {
            Object objVal = dto.getVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = TeamStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

