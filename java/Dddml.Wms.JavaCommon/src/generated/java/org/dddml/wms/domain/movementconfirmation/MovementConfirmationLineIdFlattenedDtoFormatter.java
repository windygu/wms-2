package org.dddml.wms.domain.movementconfirmation;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class MovementConfirmationLineIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<MovementConfirmationLineIdFlattenedDto>
{


    @Override
    protected MovementConfirmationLineIdFlattenedDto newDto() {
        return new MovementConfirmationLineIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return MovementConfirmationLineIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(MovementConfirmationLineIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("movementConfirmationDocumentNumber".equals(fieldName)) {
            dto.setMovementConfirmationDocumentNumber((String) objVal);
            return;
        }
        if ("lineNumber".equals(fieldName)) {
            dto.setLineNumber((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(MovementConfirmationLineIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("movementConfirmationDocumentNumber".equals(fieldName)) {
            Object objVal = dto.getMovementConfirmationDocumentNumber();
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
        String type = MovementConfirmationLineIdFlattenedDto.propertyTypeMap.get(fieldName);
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
