package org.dddml.wms.domain.attributeusemvo;

import java.util.*;
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class AttributeUseMvoStateDto
{

    private AttributeSetAttributeUseIdDto attributeSetAttributeUseId;

    public AttributeSetAttributeUseIdDto getAttributeSetAttributeUseId()
    {
        return this.attributeSetAttributeUseId;
    }

    public void setAttributeSetAttributeUseId(AttributeSetAttributeUseIdDto attributeSetAttributeUseId)
    {
        this.attributeSetAttributeUseId = attributeSetAttributeUseId;
    }

    private Integer sequenceNumber;

    public Integer getSequenceNumber()
    {
        return this.sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber)
    {
        this.sequenceNumber = sequenceNumber;
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private String attributeSetName;

    public String getAttributeSetName()
    {
        return this.attributeSetName;
    }

    public void setAttributeSetName(String attributeSetName)
    {
        this.attributeSetName = attributeSetName;
    }

    private String attributeSetOrganizationId;

    public String getAttributeSetOrganizationId()
    {
        return this.attributeSetOrganizationId;
    }

    public void setAttributeSetOrganizationId(String attributeSetOrganizationId)
    {
        this.attributeSetOrganizationId = attributeSetOrganizationId;
    }

    private String attributeSetDescription;

    public String getAttributeSetDescription()
    {
        return this.attributeSetDescription;
    }

    public void setAttributeSetDescription(String attributeSetDescription)
    {
        this.attributeSetDescription = attributeSetDescription;
    }

    private String attributeSetSerialNumberAttributeId;

    public String getAttributeSetSerialNumberAttributeId()
    {
        return this.attributeSetSerialNumberAttributeId;
    }

    public void setAttributeSetSerialNumberAttributeId(String attributeSetSerialNumberAttributeId)
    {
        this.attributeSetSerialNumberAttributeId = attributeSetSerialNumberAttributeId;
    }

    private String attributeSetLotAttributeId;

    public String getAttributeSetLotAttributeId()
    {
        return this.attributeSetLotAttributeId;
    }

    public void setAttributeSetLotAttributeId(String attributeSetLotAttributeId)
    {
        this.attributeSetLotAttributeId = attributeSetLotAttributeId;
    }

    private String attributeSetReferenceId;

    public String getAttributeSetReferenceId()
    {
        return this.attributeSetReferenceId;
    }

    public void setAttributeSetReferenceId(String attributeSetReferenceId)
    {
        this.attributeSetReferenceId = attributeSetReferenceId;
    }

    private String attributeSetCreatedBy;

    public String getAttributeSetCreatedBy()
    {
        return this.attributeSetCreatedBy;
    }

    public void setAttributeSetCreatedBy(String attributeSetCreatedBy)
    {
        this.attributeSetCreatedBy = attributeSetCreatedBy;
    }

    private Date attributeSetCreatedAt;

    public Date getAttributeSetCreatedAt()
    {
        return this.attributeSetCreatedAt;
    }

    public void setAttributeSetCreatedAt(Date attributeSetCreatedAt)
    {
        this.attributeSetCreatedAt = attributeSetCreatedAt;
    }

    private String attributeSetUpdatedBy;

    public String getAttributeSetUpdatedBy()
    {
        return this.attributeSetUpdatedBy;
    }

    public void setAttributeSetUpdatedBy(String attributeSetUpdatedBy)
    {
        this.attributeSetUpdatedBy = attributeSetUpdatedBy;
    }

    private Date attributeSetUpdatedAt;

    public Date getAttributeSetUpdatedAt()
    {
        return this.attributeSetUpdatedAt;
    }

    public void setAttributeSetUpdatedAt(Date attributeSetUpdatedAt)
    {
        this.attributeSetUpdatedAt = attributeSetUpdatedAt;
    }

    private Boolean attributeSetActive;

    public Boolean getAttributeSetActive()
    {
        return this.attributeSetActive;
    }

    public void setAttributeSetActive(Boolean attributeSetActive)
    {
        this.attributeSetActive = attributeSetActive;
    }

    private Boolean attributeSetDeleted;

    public Boolean getAttributeSetDeleted()
    {
        return this.attributeSetDeleted;
    }

    public void setAttributeSetDeleted(Boolean attributeSetDeleted)
    {
        this.attributeSetDeleted = attributeSetDeleted;
    }

    private Long attributeSetVersion;

    public Long getAttributeSetVersion()
    {
        return this.attributeSetVersion;
    }

    public void setAttributeSetVersion(Long attributeSetVersion)
    {
        this.attributeSetVersion = attributeSetVersion;
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

        public AttributeUseMvoStateDto[] toAttributeUseMvoStateDtoArray(Iterable<AttributeUseMvoState> states) 
        {
            ArrayList<AttributeUseMvoStateDto> stateDtos = new ArrayList();
            for (AttributeUseMvoState s : states) {
                AttributeUseMvoStateDto dto = toAttributeUseMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new AttributeUseMvoStateDto[0]);
        }

        public AttributeUseMvoStateDto toAttributeUseMvoStateDto(AttributeUseMvoState state)
        {
            AttributeUseMvoStateDto dto = new AttributeUseMvoStateDto();
            if (returnedFieldsContains("AttributeSetAttributeUseId")) {
                dto.setAttributeSetAttributeUseId((state.getAttributeSetAttributeUseId() == null) ? null : new AttributeSetAttributeUseIdDtoWrapper(state.getAttributeSetAttributeUseId()));
            }
            if (returnedFieldsContains("SequenceNumber")) {
                dto.setSequenceNumber(state.getSequenceNumber());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("AttributeSetName")) {
                dto.setAttributeSetName(state.getAttributeSetName());
            }
            if (returnedFieldsContains("AttributeSetOrganizationId")) {
                dto.setAttributeSetOrganizationId(state.getAttributeSetOrganizationId());
            }
            if (returnedFieldsContains("AttributeSetDescription")) {
                dto.setAttributeSetDescription(state.getAttributeSetDescription());
            }
            if (returnedFieldsContains("AttributeSetSerialNumberAttributeId")) {
                dto.setAttributeSetSerialNumberAttributeId(state.getAttributeSetSerialNumberAttributeId());
            }
            if (returnedFieldsContains("AttributeSetLotAttributeId")) {
                dto.setAttributeSetLotAttributeId(state.getAttributeSetLotAttributeId());
            }
            if (returnedFieldsContains("AttributeSetReferenceId")) {
                dto.setAttributeSetReferenceId(state.getAttributeSetReferenceId());
            }
            if (returnedFieldsContains("AttributeSetCreatedBy")) {
                dto.setAttributeSetCreatedBy(state.getAttributeSetCreatedBy());
            }
            if (returnedFieldsContains("AttributeSetCreatedAt")) {
                dto.setAttributeSetCreatedAt(state.getAttributeSetCreatedAt());
            }
            if (returnedFieldsContains("AttributeSetUpdatedBy")) {
                dto.setAttributeSetUpdatedBy(state.getAttributeSetUpdatedBy());
            }
            if (returnedFieldsContains("AttributeSetUpdatedAt")) {
                dto.setAttributeSetUpdatedAt(state.getAttributeSetUpdatedAt());
            }
            if (returnedFieldsContains("AttributeSetActive")) {
                dto.setAttributeSetActive(state.getAttributeSetActive());
            }
            if (returnedFieldsContains("AttributeSetDeleted")) {
                dto.setAttributeSetDeleted(state.getAttributeSetDeleted());
            }
            if (returnedFieldsContains("AttributeSetVersion")) {
                dto.setAttributeSetVersion(state.getAttributeSetVersion());
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

