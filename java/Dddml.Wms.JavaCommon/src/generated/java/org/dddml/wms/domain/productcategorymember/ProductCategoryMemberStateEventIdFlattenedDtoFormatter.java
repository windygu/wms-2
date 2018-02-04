package org.dddml.wms.domain.productcategorymember;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class ProductCategoryMemberStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<ProductCategoryMemberStateEventIdFlattenedDto>
{


    @Override
    protected ProductCategoryMemberStateEventIdFlattenedDto newDto() {
        return new ProductCategoryMemberStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return ProductCategoryMemberStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(ProductCategoryMemberStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("productCategoryMemberIdProductCategoryId".equals(fieldName)) {
            dto.setProductCategoryMemberIdProductCategoryId((String) objVal);
            return;
        }
        if ("productCategoryMemberIdProductId".equals(fieldName)) {
            dto.setProductCategoryMemberIdProductId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(ProductCategoryMemberStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("productCategoryMemberIdProductCategoryId".equals(fieldName)) {
            Object objVal = dto.getProductCategoryMemberIdProductCategoryId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("productCategoryMemberIdProductId".equals(fieldName)) {
            Object objVal = dto.getProductCategoryMemberIdProductId();
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
        String type = ProductCategoryMemberStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

