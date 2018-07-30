package org.dddml.wms.domain.uom;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class UomStateDto
{

    private String uomId;

    public String getUomId()
    {
        return this.uomId;
    }

    public void setUomId(String uomId)
    {
        this.uomId = uomId;
    }

    private String uomTypeId;

    public String getUomTypeId()
    {
        return this.uomTypeId;
    }

    public void setUomTypeId(String uomTypeId)
    {
        this.uomTypeId = uomTypeId;
    }

    private String abbreviation;

    public String getAbbreviation()
    {
        return this.abbreviation;
    }

    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

        public UomStateDto[] toUomStateDtoArray(Iterable<UomState> states) {
            return toUomStateDtoList(states).toArray(new UomStateDto[0]);
        }

        public List<UomStateDto> toUomStateDtoList(Iterable<UomState> states) {
            ArrayList<UomStateDto> stateDtos = new ArrayList();
            for (UomState s : states) {
                UomStateDto dto = toUomStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public UomStateDto toUomStateDto(UomState state)
        {
            if(state == null) {
                return null;
            }
            UomStateDto dto = new UomStateDto();
            if (returnedFieldsContains("UomId")) {
                dto.setUomId(state.getUomId());
            }
            if (returnedFieldsContains("UomTypeId")) {
                dto.setUomTypeId(state.getUomTypeId());
            }
            if (returnedFieldsContains("Abbreviation")) {
                dto.setAbbreviation(state.getAbbreviation());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
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

