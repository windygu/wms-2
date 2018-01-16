package org.dddml.wms.domain.order;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class OrderItemIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<OrderItemIdFlattenedDto>
{


    @Override
    protected OrderItemIdFlattenedDto newDto() {
        return new OrderItemIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return OrderItemIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(OrderItemIdFlattenedDto dto, String fieldName, String fieldValue) {
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
    }

    @Override
    protected String getFieldStringValue(OrderItemIdFlattenedDto dto, String fieldName) {
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
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = OrderItemIdFlattenedDto.propertyTypeMap.get(fieldName);
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

