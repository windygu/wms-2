package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class PhysicalInventoryLineStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<PhysicalInventoryLineStateEventIdFlattenedDto>
{


    @Override
    protected PhysicalInventoryLineStateEventIdFlattenedDto newDto() {
        return new PhysicalInventoryLineStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return PhysicalInventoryLineStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(PhysicalInventoryLineStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("physicalInventoryDocumentNumber".equals(fieldName)) {
            dto.setPhysicalInventoryDocumentNumber((String) objVal);
            return;
        }
        if ("lineNumber".equals(fieldName)) {
            dto.setLineNumber((String) objVal);
            return;
        }
        if ("physicalInventoryVersion".equals(fieldName)) {
            dto.setPhysicalInventoryVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(PhysicalInventoryLineStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("physicalInventoryDocumentNumber".equals(fieldName)) {
            Object objVal = dto.getPhysicalInventoryDocumentNumber();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("lineNumber".equals(fieldName)) {
            Object objVal = dto.getLineNumber();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("physicalInventoryVersion".equals(fieldName)) {
            Object objVal = dto.getPhysicalInventoryVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = PhysicalInventoryLineStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

