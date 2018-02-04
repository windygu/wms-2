package org.dddml.wms.domain.ordershipment;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class OrderShipmentIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<OrderShipmentIdFlattenedDto>
{


    @Override
    protected OrderShipmentIdFlattenedDto newDto() {
        return new OrderShipmentIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return OrderShipmentIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(OrderShipmentIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("orderId".equals(fieldName)) {
            dto.setOrderId((String) objVal);
            return;
        }
        if ("orderItemSeqId".equals(fieldName)) {
            dto.setOrderItemSeqId((String) objVal);
            return;
        }
        if ("shipmentId".equals(fieldName)) {
            dto.setShipmentId((String) objVal);
            return;
        }
        if ("shipmentItemSeqId".equals(fieldName)) {
            dto.setShipmentItemSeqId((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(OrderShipmentIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("orderId".equals(fieldName)) {
            Object objVal = dto.getOrderId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("orderItemSeqId".equals(fieldName)) {
            Object objVal = dto.getOrderItemSeqId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
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
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = OrderShipmentIdFlattenedDto.propertyTypeMap.get(fieldName);
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

