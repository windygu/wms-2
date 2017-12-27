package org.dddml.wms.domain.organization;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class OrganizationStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<OrganizationStateEventIdFlattenedDto>
{


    @Override
    protected OrganizationStateEventIdFlattenedDto newDto() {
        return new OrganizationStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return OrganizationStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(OrganizationStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("partyId".equals(fieldName)) {
            dto.setPartyId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(OrganizationStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("partyId".equals(fieldName)) {
            Object objVal = dto.getPartyId();
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
        String type = OrganizationStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

