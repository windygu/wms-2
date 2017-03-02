package org.dddml.wms.domain;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class SkuIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<SkuIdFlattenedDto>
{


    @Override
    protected SkuIdFlattenedDto newDto() {
        return new SkuIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return SkuIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(SkuIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("productId".equals(fieldName)) {
            dto.setProductId((String) objVal);
            return;
        }
        if ("attributeSetInstanceId".equals(fieldName)) {
            dto.setAttributeSetInstanceId((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(SkuIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("productId".equals(fieldName)) {
            Object objVal = dto.getProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("attributeSetInstanceId".equals(fieldName)) {
            Object objVal = dto.getAttributeSetInstanceId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = SkuIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

