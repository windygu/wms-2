package org.dddml.wms.domain;

import org.dddml.wms.specialization.AbstractIdFlattenedDtoFormatter;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.ReflectUtils;

/**
 * Created by Yang on 2016/9/3.
 */
public class AttributeSetStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<AttributeSetStateEventIdFlattenedDto>
{

    @Override
    protected AttributeSetStateEventIdFlattenedDto newDto() {
        return new AttributeSetStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return AttributeSetStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(AttributeSetStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("attributeSetId".equals(fieldName)) {
            dto.setAttributeSetId((String) objVal);
            return;
        }
        //// TODO: 2016/9/3
        //if ("xxx".equals(fieldName)) { ...
    }

    @Override
    protected String getFieldStringValue(AttributeSetStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("attributeSetId".equals(fieldName)) {
            Object objVal = dto.getAttributeSetId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        //// TODO: 2016/9/3
        //if ("xxx".equals(fieldName)) { ...
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = AttributeSetStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}
