package org.dddml.wms.domain.shipmenttype;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class ShipmentTypeStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<ShipmentTypeStateEventIdFlattenedDto>
{


    @Override
    protected ShipmentTypeStateEventIdFlattenedDto newDto() {
        return new ShipmentTypeStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return ShipmentTypeStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(ShipmentTypeStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("shipmentTypeId".equals(fieldName)) {
            dto.setShipmentTypeId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(ShipmentTypeStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("shipmentTypeId".equals(fieldName)) {
            Object objVal = dto.getShipmentTypeId();
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
        String type = ShipmentTypeStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

