package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class PhysicalInventoryStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<PhysicalInventoryStateEventIdFlattenedDto>
{


    @Override
    protected PhysicalInventoryStateEventIdFlattenedDto newDto() {
        return new PhysicalInventoryStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return PhysicalInventoryStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(PhysicalInventoryStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("documentNumber".equals(fieldName)) {
            dto.setDocumentNumber((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(PhysicalInventoryStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("documentNumber".equals(fieldName)) {
            Object objVal = dto.getDocumentNumber();
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
        String type = PhysicalInventoryStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

