package org.dddml.wms.domain;

import java.util.*;
import org.dddml.wms.specialization.*;

public class InOutLineMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<InOutLineMvoStateEventIdFlattenedDto>
{


    @Override
    protected InOutLineMvoStateEventIdFlattenedDto newDto() {
        return new InOutLineMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return InOutLineMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(InOutLineMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("inOutLineIdInOutDocumentNumber".equals(fieldName)) {
            dto.setInOutLineIdInOutDocumentNumber((String) objVal);
            return;
        }
        if ("inOutLineIdSkuIdProductId".equals(fieldName)) {
            dto.setInOutLineIdSkuIdProductId((String) objVal);
            return;
        }
        if ("inOutLineIdSkuIdAttributeSetInstanceId".equals(fieldName)) {
            dto.setInOutLineIdSkuIdAttributeSetInstanceId((String) objVal);
            return;
        }
        if ("inOutVersion".equals(fieldName)) {
            dto.setInOutVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(InOutLineMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("inOutLineIdInOutDocumentNumber".equals(fieldName)) {
            Object objVal = dto.getInOutLineIdInOutDocumentNumber();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inOutLineIdSkuIdProductId".equals(fieldName)) {
            Object objVal = dto.getInOutLineIdSkuIdProductId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("inOutLineIdSkuIdAttributeSetInstanceId".equals(fieldName)) {
            Object objVal = dto.getInOutLineIdSkuIdAttributeSetInstanceId();
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
        String type = InOutLineMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

