package org.dddml.wms.domain.supplierproduct;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class SupplierProductStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<SupplierProductStateEventIdFlattenedDto>
{


    @Override
    protected SupplierProductStateEventIdFlattenedDto newDto() {
        return new SupplierProductStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return SupplierProductStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(SupplierProductStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("supplierProductIdProductId".equals(fieldName)) {
            dto.setSupplierProductIdProductId((String) objVal);
            return;
        }
        if ("supplierProductIdPartyId".equals(fieldName)) {
            dto.setSupplierProductIdPartyId((String) objVal);
            return;
        }
        if ("supplierProductIdCurrencyUomId".equals(fieldName)) {
            dto.setSupplierProductIdCurrencyUomId((String) objVal);
            return;
        }
        if ("supplierProductIdMinimumOrderQuantity".equals(fieldName)) {
            dto.setSupplierProductIdMinimumOrderQuantity((java.math.BigDecimal) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(SupplierProductStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("supplierProductIdProductId".equals(fieldName)) {
            Object objVal = dto.getSupplierProductIdProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("supplierProductIdPartyId".equals(fieldName)) {
            Object objVal = dto.getSupplierProductIdPartyId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("supplierProductIdCurrencyUomId".equals(fieldName)) {
            Object objVal = dto.getSupplierProductIdCurrencyUomId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("supplierProductIdMinimumOrderQuantity".equals(fieldName)) {
            Object objVal = dto.getSupplierProductIdMinimumOrderQuantity();
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
        String type = SupplierProductStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

