package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class ShipmentStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<ShipmentStateEventIdFlattenedDto>
{


    @Override
    protected ShipmentStateEventIdFlattenedDto newDto() {
        return new ShipmentStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return ShipmentStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(ShipmentStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("shipmentId".equals(fieldName)) {
            dto.setShipmentId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(ShipmentStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("shipmentId".equals(fieldName)) {
            Object objVal = dto.getShipmentId();
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
        String type = ShipmentStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

