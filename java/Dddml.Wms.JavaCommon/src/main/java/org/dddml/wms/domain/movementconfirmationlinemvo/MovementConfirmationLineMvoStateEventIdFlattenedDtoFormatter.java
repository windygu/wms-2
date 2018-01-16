package org.dddml.wms.domain.movementconfirmationlinemvo;

import org.dddml.wms.domain.movementconfirmation.MovementConfirmationLineIdDto;
import org.dddml.wms.domain.movementconfirmation.*;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class MovementConfirmationLineMvoStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<MovementConfirmationLineMvoStateEventIdFlattenedDto>
{


    @Override
    protected MovementConfirmationLineMvoStateEventIdFlattenedDto newDto() {
        return new MovementConfirmationLineMvoStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return MovementConfirmationLineMvoStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(MovementConfirmationLineMvoStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("movementConfirmationLineIdMovementConfirmationDocumentNumber".equals(fieldName)) {
            dto.setMovementConfirmationLineIdMovementConfirmationDocumentNumber((String) objVal);
            return;
        }
        if ("movementConfirmationLineIdLineNumber".equals(fieldName)) {
            dto.setMovementConfirmationLineIdLineNumber((String) objVal);
            return;
        }
        if ("movementConfirmationVersion".equals(fieldName)) {
            dto.setMovementConfirmationVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(MovementConfirmationLineMvoStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("movementConfirmationLineIdMovementConfirmationDocumentNumber".equals(fieldName)) {
            Object objVal = dto.getMovementConfirmationLineIdMovementConfirmationDocumentNumber();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("movementConfirmationLineIdLineNumber".equals(fieldName)) {
            Object objVal = dto.getMovementConfirmationLineIdLineNumber();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("movementConfirmationVersion".equals(fieldName)) {
            Object objVal = dto.getMovementConfirmationVersion();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = MovementConfirmationLineMvoStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

