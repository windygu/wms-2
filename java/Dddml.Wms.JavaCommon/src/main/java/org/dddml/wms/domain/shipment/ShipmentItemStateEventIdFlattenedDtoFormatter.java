package org.dddml.wms.domain.shipment;

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
        if ("shipmentId".equals(fieldName)) {
            dto.setShipmentId((String) objVal);
            return;
        }
        if ("shipmentItemSeqId".equals(fieldName)) {
            dto.setShipmentItemSeqId((String) objVal);
            return;
        }
        if ("shipmentVersion".equals(fieldName)) {
            dto.setShipmentVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(ShipmentItemStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("shipmentId".equals(fieldName)) {
            Object objVal = dto.getShipmentId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("shipmentItemSeqId".equals(fieldName)) {
            Object objVal = dto.getShipmentItemSeqId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("shipmentVersion".equals(fieldName)) {
            Object objVal = dto.getShipmentVersion();
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

