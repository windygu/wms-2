package org.dddml.wms.domain.organizationstructure;

import org.dddml.wms.domain.*;
import java.util.*;
import org.dddml.wms.specialization.*;

public class OrganizationStructureIdFlattenedDtoFormatter extends AbstractIdFlattenedDtoFormatter<OrganizationStructureIdFlattenedDto>
{


    @Override
    protected OrganizationStructureIdFlattenedDto newDto() {
        return new OrganizationStructureIdFlattenedDto();
    }

    @Override
    protected String[] getFieldNames() {
        return OrganizationStructureIdFlattenedDto.propertyNames;
    }

    @Override
    protected void setFieldStringValue(OrganizationStructureIdFlattenedDto dto, String fieldName, String fieldValue) {
        Class clazz = getFieldClass(fieldName);
        Object objVal = ApplicationContext.current.getTypeConverter().convertFromString(clazz, fieldValue);
        if ("organizationStructureTypeId".equals(fieldName)) {
            dto.setOrganizationStructureTypeId((String) objVal);
            return;
        }
        if ("parentId".equals(fieldName)) {
            dto.setParentId((String) objVal);
            return;
        }
        if ("subsidiaryId".equals(fieldName)) {
            dto.setSubsidiaryId((String) objVal);
            return;
        }
    }

    @Override
    protected String getFieldStringValue(OrganizationStructureIdFlattenedDto dto, String fieldName) {
        Class clazz = getFieldClass(fieldName);
        if ("organizationStructureTypeId".equals(fieldName)) {
            Object objVal = dto.getOrganizationStructureTypeId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("parentId".equals(fieldName)) {
            Object objVal = dto.getParentId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        if ("subsidiaryId".equals(fieldName)) {
            Object objVal = dto.getSubsidiaryId();
            String strVal = ApplicationContext.current.getTypeConverter().convertToString(clazz, objVal);
            return strVal;
        }
        return null;
    }

    protected Class getFieldClass(String fieldName) {
        String type = OrganizationStructureIdFlattenedDto.propertyTypeMap.get(fieldName);
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

