package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class InOutLineStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<InOutLineStateEventIdFlattenedDto>
{


    @Override
    protected InOutLineStateEventIdFlattenedDto newDto() {
        return new InOutLineStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return InOutLineStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(InOutLineStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("inOutDocumentNumber".equals(fieldName)) {
            dto.setInOutDocumentNumber((String) objVal);
            return;
        }
        if ("skuIdProductId".equals(fieldName)) {
            dto.setSkuIdProductId((String) objVal);
            return;
        }
        if ("skuIdAttributeSetInstanceId".equals(fieldName)) {
            dto.setSkuIdAttributeSetInstanceId((String) objVal);
            return;
        }
        if ("inOutVersion".equals(fieldName)) {
            dto.setInOutVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(InOutLineStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("inOutDocumentNumber".equals(fieldName)) {
            Object objVal = dto.getInOutDocumentNumber();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("skuIdProductId".equals(fieldName)) {
            Object objVal = dto.getSkuIdProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("skuIdAttributeSetInstanceId".equals(fieldName)) {
            Object objVal = dto.getSkuIdAttributeSetInstanceId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inOutVersion".equals(fieldName)) {
            Object objVal = dto.getInOutVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = InOutLineStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

