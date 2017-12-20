package org.dddml.wms.domain.movementlinemvo;

import org.dddml.wms.domain.movement.MovementLineIdDto;
import org.dddml.wms.domain.movement.*;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class MovementLineMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<MovementLineMvoStateEventIdFlattenedDto>
{


    @Override
    protected MovementLineMvoStateEventIdFlattenedDto newDto() {
        return new MovementLineMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return MovementLineMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(MovementLineMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("movementLineIdMovementDocumentNumber".equals(fieldName)) {
            dto.setMovementLineIdMovementDocumentNumber((String) objVal);
            return;
        }
        if ("movementLineIdLineNumber".equals(fieldName)) {
            dto.setMovementLineIdLineNumber((String) objVal);
            return;
        }
        if ("movementVersion".equals(fieldName)) {
            dto.setMovementVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(MovementLineMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("movementLineIdMovementDocumentNumber".equals(fieldName)) {
            Object objVal = dto.getMovementLineIdMovementDocumentNumber();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("movementLineIdLineNumber".equals(fieldName)) {
            Object objVal = dto.getMovementLineIdLineNumber();
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
        String type = MovementLineMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

