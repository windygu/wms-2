package org.dddml.wms.domain;

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
        if ("organizationId".equals(fieldName)) {
            dto.setOrganizationId((String) objVal);
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
        if ("organizationId".equals(fieldName)) {
            Object objVal = dto.getOrganizationId();
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
        return clazz;
    }

}

