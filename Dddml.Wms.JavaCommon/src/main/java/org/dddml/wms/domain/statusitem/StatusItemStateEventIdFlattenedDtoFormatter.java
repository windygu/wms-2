package org.dddml.wms.domain.statusitem;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class StatusItemStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<StatusItemStateEventIdFlattenedDto>
{


    @Override
    protected StatusItemStateEventIdFlattenedDto newDto() {
        return new StatusItemStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return StatusItemStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(StatusItemStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("statusId".equals(fieldName)) {
            dto.setStatusId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(StatusItemStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("statusId".equals(fieldName)) {
            Object objVal = dto.getStatusId();
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
        String type = StatusItemStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        if (clazz == null) {
            throw new RuntimeException("ERROR! ReflectUtils.CLASS_MAP.get(type) == null");
        }
        return clazz;
    }

}

