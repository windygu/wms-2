package org.dddml.wms.domain.damagereason;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class DamageReasonStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<DamageReasonStateEventIdFlattenedDto>
{


    @Override
    protected DamageReasonStateEventIdFlattenedDto newDto() {
        return new DamageReasonStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return DamageReasonStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(DamageReasonStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("damageReasonId".equals(fieldName)) {
            dto.setDamageReasonId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(DamageReasonStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("damageReasonId".equals(fieldName)) {
            Object objVal = dto.getDamageReasonId();
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
        String type = DamageReasonStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

