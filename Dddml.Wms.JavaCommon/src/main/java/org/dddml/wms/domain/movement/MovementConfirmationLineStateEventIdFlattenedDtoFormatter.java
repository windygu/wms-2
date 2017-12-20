package org.dddml.wms.domain.movement;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class MovementConfirmationLineStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<MovementConfirmationLineStateEventIdFlattenedDto>
{


    @Override
    protected MovementConfirmationLineStateEventIdFlattenedDto newDto() {
        return new MovementConfirmationLineStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return MovementConfirmationLineStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(MovementConfirmationLineStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
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
        if ("movementVersion".equals(fieldName)) {
            dto.setMovementVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(MovementConfirmationLineStateEventIdFlattenedDto dto, String fieldName) {
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
        if ("movementVersion".equals(fieldName)) {
            Object objVal = dto.getMovementVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = MovementConfirmationLineStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

