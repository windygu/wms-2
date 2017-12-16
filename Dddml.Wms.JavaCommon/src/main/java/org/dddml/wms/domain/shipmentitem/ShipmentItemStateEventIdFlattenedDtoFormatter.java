package org.dddml.wms.domain.shipmentitem;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class ShipmentItemStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<ShipmentItemStateEventIdFlattenedDto>
{


    @Override
    protected ShipmentItemStateEventIdFlattenedDto newDto() {
        return new ShipmentItemStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return ShipmentItemStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(ShipmentItemStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("shipmentItemIdShipmentId".equals(fieldName)) {
            dto.setShipmentItemIdShipmentId((String) objVal);
            return;
        }
        if ("shipmentItemIdShipmentItemSeqId".equals(fieldName)) {
            dto.setShipmentItemIdShipmentItemSeqId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(ShipmentItemStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("shipmentItemIdShipmentId".equals(fieldName)) {
            Object objVal = dto.getShipmentItemIdShipmentId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("shipmentItemIdShipmentItemSeqId".equals(fieldName)) {
            Object objVal = dto.getShipmentItemIdShipmentItemSeqId();
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
        String type = ShipmentItemStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

