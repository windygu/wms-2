package org.dddml.wms.domain.physicalinventorylinemvo;

import org.dddml.wms.domain.physicalinventory.PhysicalInventoryLineIdDto;
import org.dddml.wms.domain.physicalinventory.*;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class PhysicalInventoryLineMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<PhysicalInventoryLineMvoStateEventIdFlattenedDto>
{


    @Override
    protected PhysicalInventoryLineMvoStateEventIdFlattenedDto newDto() {
        return new PhysicalInventoryLineMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return PhysicalInventoryLineMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(PhysicalInventoryLineMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("physicalInventoryLineIdPhysicalInventoryDocumentNumber".equals(fieldName)) {
            dto.setPhysicalInventoryLineIdPhysicalInventoryDocumentNumber((String) objVal);
            return;
        }
        if ("physicalInventoryLineIdLineNumber".equals(fieldName)) {
            dto.setPhysicalInventoryLineIdLineNumber((String) objVal);
            return;
        }
        if ("physicalInventoryVersion".equals(fieldName)) {
            dto.setPhysicalInventoryVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(PhysicalInventoryLineMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("physicalInventoryLineIdPhysicalInventoryDocumentNumber".equals(fieldName)) {
            Object objVal = dto.getPhysicalInventoryLineIdPhysicalInventoryDocumentNumber();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("physicalInventoryLineIdLineNumber".equals(fieldName)) {
            Object objVal = dto.getPhysicalInventoryLineIdLineNumber();
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
        String type = PhysicalInventoryLineMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(type);
        if (clazz == null) {
            throw new RuntimeException("ERROR! CANNOT get the class from CLASS_MAP!");
        }
        return clazz;
    }

}

