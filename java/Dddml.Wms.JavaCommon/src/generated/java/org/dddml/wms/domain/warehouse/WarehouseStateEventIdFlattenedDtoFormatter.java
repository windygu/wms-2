package org.dddml.wms.domain.warehouse;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class WarehouseStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<WarehouseStateEventIdFlattenedDto>
{


    @Override
    protected WarehouseStateEventIdFlattenedDto newDto() {
        return new WarehouseStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return WarehouseStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(WarehouseStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("warehouseId".equals(fieldName)) {
            dto.setWarehouseId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(WarehouseStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("warehouseId".equals(fieldName)) {
            Object objVal = dto.getWarehouseId();
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
        String type = WarehouseStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

