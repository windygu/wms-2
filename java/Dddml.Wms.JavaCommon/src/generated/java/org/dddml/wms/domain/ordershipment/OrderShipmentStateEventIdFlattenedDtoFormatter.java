package org.dddml.wms.domain.ordershipment;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class OrderShipmentStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<OrderShipmentStateEventIdFlattenedDto>
{


    @Override
    protected OrderShipmentStateEventIdFlattenedDto newDto() {
        return new OrderShipmentStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return OrderShipmentStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(OrderShipmentStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("orderShipmentIdOrderId".equals(fieldName)) {
            dto.setOrderShipmentIdOrderId((String) objVal);
            return;
        }
        if ("orderShipmentIdOrderItemSeqId".equals(fieldName)) {
            dto.setOrderShipmentIdOrderItemSeqId((String) objVal);
            return;
        }
        if ("orderShipmentIdShipmentId".equals(fieldName)) {
            dto.setOrderShipmentIdShipmentId((String) objVal);
            return;
        }
        if ("orderShipmentIdShipmentItemSeqId".equals(fieldName)) {
            dto.setOrderShipmentIdShipmentItemSeqId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(OrderShipmentStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("orderShipmentIdOrderId".equals(fieldName)) {
            Object objVal = dto.getOrderShipmentIdOrderId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("orderShipmentIdOrderItemSeqId".equals(fieldName)) {
            Object objVal = dto.getOrderShipmentIdOrderItemSeqId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("orderShipmentIdShipmentId".equals(fieldName)) {
            Object objVal = dto.getOrderShipmentIdShipmentId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("orderShipmentIdShipmentItemSeqId".equals(fieldName)) {
            Object objVal = dto.getOrderShipmentIdShipmentItemSeqId();
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
        String type = OrderShipmentStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

