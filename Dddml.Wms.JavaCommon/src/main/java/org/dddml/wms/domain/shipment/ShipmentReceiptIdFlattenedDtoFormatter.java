package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class ShipmentReceiptIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<ShipmentReceiptIdFlattenedDto>
{


    @Override
    protected ShipmentReceiptIdFlattenedDto newDto() {
        return new ShipmentReceiptIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return ShipmentReceiptIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(ShipmentReceiptIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("shipmentId".equals(fieldName)) {
            dto.setShipmentId((String) objVal);
            return;
        }
        if ("receiptSeqId".equals(fieldName)) {
            dto.setReceiptSeqId((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(ShipmentReceiptIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("shipmentId".equals(fieldName)) {
            Object objVal = dto.getShipmentId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("receiptSeqId".equals(fieldName)) {
            Object objVal = dto.getReceiptSeqId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = ShipmentReceiptIdFlattenedDto.propertyTypeMap.get(fieldName);
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

