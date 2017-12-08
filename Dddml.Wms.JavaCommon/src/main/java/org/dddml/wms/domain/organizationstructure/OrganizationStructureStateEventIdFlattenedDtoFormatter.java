package org.dddml.wms.domain.organizationstructure;

import org.dddml.wms.domain.OrganizationStructureIdDto;
import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class OrganizationStructureStateEventIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<OrganizationStructureStateEventIdFlattenedDto>
{


    @Override
    protected OrganizationStructureStateEventIdFlattenedDto newDto() {
        return new OrganizationStructureStateEventIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return OrganizationStructureStateEventIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(OrganizationStructureStateEventIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("idOrganizationStructureTypeId".equals(fieldName)) {
            dto.setIdOrganizationStructureTypeId((String) objVal);
            return;
        }
        if ("idParentId".equals(fieldName)) {
            dto.setIdParentId((String) objVal);
            return;
        }
        if ("idSubsidiaryId".equals(fieldName)) {
            dto.setIdSubsidiaryId((String) objVal);
            return;
        }
        if ("version".equals(fieldName)) {
            dto.setVersion((Long) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(OrganizationStructureStateEventIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("idOrganizationStructureTypeId".equals(fieldName)) {
            Object objVal = dto.getIdOrganizationStructureTypeId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("idParentId".equals(fieldName)) {
            Object objVal = dto.getIdParentId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("idSubsidiaryId".equals(fieldName)) {
            Object objVal = dto.getIdSubsidiaryId();
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
        String type = OrganizationStructureStateEventIdFlattenedDto.propertyTypeMap.get(fieldName);
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

