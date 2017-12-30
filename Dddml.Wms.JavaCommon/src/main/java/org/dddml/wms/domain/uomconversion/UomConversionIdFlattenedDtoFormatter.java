package org.dddml.wms.domain.uomconversion;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class UomConversionIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<UomConversionIdFlattenedDto>
{


    @Override
    protected UomConversionIdFlattenedDto newDto() {
        return new UomConversionIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return UomConversionIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(UomConversionIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("uomId".equals(fieldName)) {
            dto.setUomId((String) objVal);
            return;
        }
        if ("uomIdTo".equals(fieldName)) {
            dto.setUomIdTo((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(UomConversionIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("uomId".equals(fieldName)) {
            Object objVal = dto.getUomId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("uomIdTo".equals(fieldName)) {
            Object objVal = dto.getUomIdTo();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = UomConversionIdFlattenedDto.propertyTypeMap.get(fieldName);
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

