package org.dddml.wms.domain.documenttype;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class DocumentTypeStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<DocumentTypeStateEventIdFlattenedDto>
{


    @Override
    protected DocumentTypeStateEventIdFlattenedDto newDto() {
        return new DocumentTypeStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return DocumentTypeStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(DocumentTypeStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("documentTypeId".equals(fieldName)) {
            dto.setDocumentTypeId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(DocumentTypeStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("documentTypeId".equals(fieldName)) {
            Object objVal = dto.getDocumentTypeId();
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
        String type = DocumentTypeStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
        if(type == null) {
            throw new IllegalArgumentException(String.format("The field name \"%1$s\" is NOT right.", fieldName));
        }
        Class clazz = ReflectUtils.CLASS_MAP.get(type);
        return clazz;
    }

}

