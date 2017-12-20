package org.dddml.wms.domain.movement;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class MovementLineIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<MovementLineIdFlattenedDto>
{


    @Override
    protected MovementLineIdFlattenedDto newDto() {
        return new MovementLineIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return MovementLineIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(MovementLineIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("movementDocumentNumber".equals(fieldName)) {
            dto.setMovementDocumentNumber((String) objVal);
            return;
        }
        if ("lineNumber".equals(fieldName)) {
            dto.setLineNumber((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(MovementLineIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("movementDocumentNumber".equals(fieldName)) {
            Object objVal = dto.getMovementDocumentNumber();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("lineNumber".equals(fieldName)) {
            Object objVal = dto.getLineNumber();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = MovementLineIdFlattenedDto.propertyTypeMap.get(fieldName);
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

