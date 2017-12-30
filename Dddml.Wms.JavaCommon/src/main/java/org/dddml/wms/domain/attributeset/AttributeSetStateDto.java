package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class AttributeSetStateDto
{

    private String attributeSetId;

    public String getAttributeSetId()
    {
        return this.attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId)
    {
        this.attributeSetId = attributeSetId;
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

    private String organizationId;

    public String getOrganizationId()
    {
        return this.organizationId;
    }

    public void setOrganizationId(String organizationId)
    {
        this.organizationId = organizationId;
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

    private String serialNumberAttributeId;

    public String getSerialNumberAttributeId()
    {
        return this.serialNumberAttributeId;
    }

    public void setSerialNumberAttributeId(String serialNumberAttributeId)
    {
        this.serialNumberAttributeId = serialNumberAttributeId;
    }

    private String lotAttributeId;

    public String getLotAttributeId()
    {
        return this.lotAttributeId;
    }

    public void setLotAttributeId(String lotAttributeId)
    {
        this.lotAttributeId = lotAttributeId;
    }

    private String referenceId;

    public String getReferenceId()
    {
        return this.referenceId;
    }

    public void setReferenceId(String referenceId)
    {
        this.referenceId = referenceId;
    }

    private Boolean isInstanceAttributeSet;

    public Boolean getIsInstanceAttributeSet()
    {
        return this.isInstanceAttributeSet;
    }

    public void setIsInstanceAttributeSet(Boolean isInstanceAttributeSet)
    {
        this.isInstanceAttributeSet = isInstanceAttributeSet;
    }

    private Boolean isMandatory;

    public Boolean getIsMandatory()
    {
        return this.isMandatory;
    }

    public void setIsMandatory(Boolean isMandatory)
    {
        this.isMandatory = isMandatory;
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

    private AttributeUseStateDto[] attributeUses;

    public AttributeUseStateDto[] getAttributeUses()
    {
        return this.attributeUses;
    }	

    public void setAttributeUses(AttributeUseStateDto[] attributeUses)
    {
        this.attributeUses = attributeUses;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"AttributeUses"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public AttributeSetStateDto[] toAttributeSetStateDtoArray(Iterable<AttributeSetState> states) 
        {
            ArrayList<AttributeSetStateDto> stateDtos = new ArrayList();
            for (AttributeSetState s : states) {
                AttributeSetStateDto dto = toAttributeSetStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new AttributeSetStateDto[0]);
        }

        public AttributeSetStateDto toAttributeSetStateDto(AttributeSetState state)
        {
            if(state == null) {
                return null;
            }
            AttributeSetStateDto dto = new AttributeSetStateDto();
            if (returnedFieldsContains("AttributeSetId")) {
                dto.setAttributeSetId(state.getAttributeSetId());
            }
            if (returnedFieldsContains("AttributeSetName")) {
                dto.setAttributeSetName(state.getAttributeSetName());
            }
            if (returnedFieldsContains("OrganizationId")) {
                dto.setOrganizationId(state.getOrganizationId());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("SerialNumberAttributeId")) {
                dto.setSerialNumberAttributeId(state.getSerialNumberAttributeId());
            }
            if (returnedFieldsContains("LotAttributeId")) {
                dto.setLotAttributeId(state.getLotAttributeId());
            }
            if (returnedFieldsContains("ReferenceId")) {
                dto.setReferenceId(state.getReferenceId());
            }
            if (returnedFieldsContains("IsInstanceAttributeSet")) {
                dto.setIsInstanceAttributeSet(state.getIsInstanceAttributeSet());
            }
            if (returnedFieldsContains("IsMandatory")) {
                dto.setIsMandatory(state.getIsMandatory());
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
            if (returnedFieldsContains("AttributeUses")) {
                ArrayList<AttributeUseStateDto> arrayList = new ArrayList();
                if (state.getAttributeUses() != null) {
                    AttributeUseStateDto.DtoConverter conv = new AttributeUseStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "AttributeUses");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (AttributeUseState s : state.getAttributeUses()) {
                        arrayList.add(conv.toAttributeUseStateDto(s));
                    }
                }
                dto.setAttributeUses(arrayList.toArray(new AttributeUseStateDto[0]));
            }
            return dto;
        }

    }
}

