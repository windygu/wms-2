package org.dddml.wms.domain.productcategory;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class ProductCategoryStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<ProductCategoryStateEventIdFlattenedDto>
{


    @Override
    protected ProductCategoryStateEventIdFlattenedDto newDto() {
        return new ProductCategoryStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return ProductCategoryStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(ProductCategoryStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("productCategoryId".equals(fieldName)) {
            dto.setProductCategoryId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(ProductCategoryStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("productCategoryId".equals(fieldName)) {
            Object objVal = dto.getProductCategoryId();
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
        String type = ProductCategoryStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

