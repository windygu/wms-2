package org.dddml.wms.domain.orderitemmvo;

import org.dddml.wms.domain.order.OrderItemIdDto;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class OrderItemMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<OrderItemMvoStateEventIdFlattenedDto>
{


    @Override
    protected OrderItemMvoStateEventIdFlattenedDto newDto() {
        return new OrderItemMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return OrderItemMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(OrderItemMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("orderItemIdOrderId".equals(fieldName)) {
            dto.setOrderItemIdOrderId((String) objVal);
            return;
        }
        if ("orderItemIdOrderItemSeqId".equals(fieldName)) {
            dto.setOrderItemIdOrderItemSeqId((String) objVal);
            return;
        }
        if ("orderVersion".equals(fieldName)) {
            dto.setOrderVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(OrderItemMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("orderItemIdOrderId".equals(fieldName)) {
            Object objVal = dto.getOrderItemIdOrderId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("orderItemIdOrderItemSeqId".equals(fieldName)) {
            Object objVal = dto.getOrderItemIdOrderItemSeqId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("orderVersion".equals(fieldName)) {
            Object objVal = dto.getOrderVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = OrderItemMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

