package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;


public class OrganizationStructureStateDto
{

    private OrganizationStructureIdDto id;

    public OrganizationStructureIdDto getId()
    {
        return this.id;
    }

    public void setId(OrganizationStructureIdDto id)
    {
        this.id = id;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public OrganizationStructureStateDto[] toOrganizationStructureStateDtoArray(Iterable<OrganizationStructureState> states) 
        {
            ArrayList<OrganizationStructureStateDto> stateDtos = new ArrayList();
            for (OrganizationStructureState s : states) {
                OrganizationStructureStateDto dto = toOrganizationStructureStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new OrganizationStructureStateDto[0]);
        }

        public OrganizationStructureStateDto toOrganizationStructureStateDto(OrganizationStructureState state)
        {
            OrganizationStructureStateDto dto = new OrganizationStructureStateDto();
            if (returnedFieldsContains("Id")) {
                dto.setId((state.getId() == null) ? null : new OrganizationStructureIdDtoWrapper(state.getId()));
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            return dto;
        }

    }
}

