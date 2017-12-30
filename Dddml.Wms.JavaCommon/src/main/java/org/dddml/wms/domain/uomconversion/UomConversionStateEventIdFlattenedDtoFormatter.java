package org.dddml.wms.domain.uomconversion;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class UomConversionStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<UomConversionStateEventIdFlattenedDto>
{


    @Override
    protected UomConversionStateEventIdFlattenedDto newDto() {
        return new UomConversionStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return UomConversionStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(UomConversionStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("uomConversionIdUomId".equals(fieldName)) {
            dto.setUomConversionIdUomId((String) objVal);
            return;
        }
        if ("uomConversionIdUomIdTo".equals(fieldName)) {
            dto.setUomConversionIdUomIdTo((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(UomConversionStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("uomConversionIdUomId".equals(fieldName)) {
            Object objVal = dto.getUomConversionIdUomId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("uomConversionIdUomIdTo".equals(fieldName)) {
            Object objVal = dto.getUomConversionIdUomIdTo();
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
        String type = UomConversionStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

