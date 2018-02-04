package org.dddml.wms.domain.inoutlinemvo;

import org.dddml.wms.domain.inout.InOutLineIdDto;
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.domain.*;
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
        if ("inOutLineIdLineNumber".equals(fieldName)) {
            dto.setInOutLineIdLineNumber((String) objVal);
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
        if ("inOutLineIdLineNumber".equals(fieldName)) {
            Object objVal = dto.getInOutLineIdLineNumber();
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
        Class clazz = org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(type);
        if (clazz == null) {
            throw new RuntimeException("ERROR! CANNOT get the class from CLASS_MAP!");
        }
        return clazz;
    }

}

