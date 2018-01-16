package org.dddml.wms.domain.shipmentreceiptmvo;

import org.dddml.wms.domain.shipment.ShipmentReceiptIdDto;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class ShipmentReceiptMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<ShipmentReceiptMvoStateEventIdFlattenedDto>
{


    @Override
    protected ShipmentReceiptMvoStateEventIdFlattenedDto newDto() {
        return new ShipmentReceiptMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return ShipmentReceiptMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(ShipmentReceiptMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("shipmentReceiptIdShipmentId".equals(fieldName)) {
            dto.setShipmentReceiptIdShipmentId((String) objVal);
            return;
        }
        if ("shipmentReceiptIdReceiptSeqId".equals(fieldName)) {
            dto.setShipmentReceiptIdReceiptSeqId((String) objVal);
            return;
        }
        if ("shipmentVersion".equals(fieldName)) {
            dto.setShipmentVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(ShipmentReceiptMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("shipmentReceiptIdShipmentId".equals(fieldName)) {
            Object objVal = dto.getShipmentReceiptIdShipmentId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("shipmentReceiptIdReceiptSeqId".equals(fieldName)) {
            Object objVal = dto.getShipmentReceiptIdReceiptSeqId();
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
        String type = ShipmentReceiptMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

