package org.dddml.wms.domain.supplierproduct;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class SupplierProductIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<SupplierProductIdFlattenedDto>
{


    @Override
    protected SupplierProductIdFlattenedDto newDto() {
        return new SupplierProductIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return SupplierProductIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(SupplierProductIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("productId".equals(fieldName)) {
            dto.setProductId((String) objVal);
            return;
        }
        if ("partyId".equals(fieldName)) {
            dto.setPartyId((String) objVal);
            return;
        }
        if ("currencyUomId".equals(fieldName)) {
            dto.setCurrencyUomId((String) objVal);
            return;
        }
        if ("minimumOrderQuantity".equals(fieldName)) {
            dto.setMinimumOrderQuantity((java.math.BigDecimal) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(SupplierProductIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("productId".equals(fieldName)) {
            Object objVal = dto.getProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("partyId".equals(fieldName)) {
            Object objVal = dto.getPartyId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("currencyUomId".equals(fieldName)) {
            Object objVal = dto.getCurrencyUomId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("minimumOrderQuantity".equals(fieldName)) {
            Object objVal = dto.getMinimumOrderQuantity();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = SupplierProductIdFlattenedDto.propertyTypeMap.get(fieldName);
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

