package org.dddml.wms.domain.lot;

import org.dddml.wms.specialization.AbstractIdFlattenedDtoFormatter;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.ReflectUtils;

public class LotStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<LotStateEventIdFlattenedDto> {


    @Override
    protected LotStateEventIdFlattenedDto newDto() {
        return new LotStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return LotStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(LotStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("lotId".equals(fieldName)) {
            dto.setLotId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(LotStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("lotId".equals(fieldName)) {
            Object objVal = dto.getLotId();
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
        String type = LotStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if (type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        if (clazz == null) {
            throw new RuntimeException("ERROR! ReflectUtils.CLASS_MAP.get(type) == null");
        }
        return clazz;
    }

}

