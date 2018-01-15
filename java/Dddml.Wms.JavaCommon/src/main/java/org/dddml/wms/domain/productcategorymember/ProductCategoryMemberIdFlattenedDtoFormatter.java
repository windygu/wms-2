package org.dddml.wms.domain.productcategorymember;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class ProductCategoryMemberIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<ProductCategoryMemberIdFlattenedDto>
{


    @Override
    protected ProductCategoryMemberIdFlattenedDto newDto() {
        return new ProductCategoryMemberIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return ProductCategoryMemberIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(ProductCategoryMemberIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("productCategoryId".equals(fieldName)) {
            dto.setProductCategoryId((String) objVal);
            return;
        }
        if ("productId".equals(fieldName)) {
            dto.setProductId((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(ProductCategoryMemberIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("productCategoryId".equals(fieldName)) {
            Object objVal = dto.getProductCategoryId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("productId".equals(fieldName)) {
            Object objVal = dto.getProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = ProductCategoryMemberIdFlattenedDto.propertyTypeMap.get(fieldName);
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

