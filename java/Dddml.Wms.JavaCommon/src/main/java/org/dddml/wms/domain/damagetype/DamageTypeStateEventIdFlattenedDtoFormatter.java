package org.dddml.wms.domain.damagetype;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class DamageTypeStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<DamageTypeStateEventIdFlattenedDto>
{


    @Override
    protected DamageTypeStateEventIdFlattenedDto newDto() {
        return new DamageTypeStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return DamageTypeStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(DamageTypeStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("damageTypeId".equals(fieldName)) {
            dto.setDamageTypeId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(DamageTypeStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("damageTypeId".equals(fieldName)) {
            Object objVal = dto.getDamageTypeId();
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
        String type = DamageTypeStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

