package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class AttributeStateDto
{

    private String attributeId;

    public String getAttributeId()
    {
        return this.attributeId;
    }

    public void setAttributeId(String attributeId)
    {
        this.attributeId = attributeId;
    }

    private String attributeName;

    public String getAttributeName()
    {
        return this.attributeName;
    }

    public void setAttributeName(String attributeName)
    {
        this.attributeName = attributeName;
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

    private Boolean isMandatory;

    public Boolean getIsMandatory()
    {
        return this.isMandatory;
    }

    public void setIsMandatory(Boolean isMandatory)
    {
        this.isMandatory = isMandatory;
    }

    private Boolean isInstanceAttribute;

    public Boolean getIsInstanceAttribute()
    {
        return this.isInstanceAttribute;
    }

    public void setIsInstanceAttribute(Boolean isInstanceAttribute)
    {
        this.isInstanceAttribute = isInstanceAttribute;
    }

    private String attributeValueType;

    public String getAttributeValueType()
    {
        return this.attributeValueType;
    }

    public void setAttributeValueType(String attributeValueType)
    {
        this.attributeValueType = attributeValueType;
    }

    private Integer attributeValueLength;

    public Integer getAttributeValueLength()
    {
        return this.attributeValueLength;
    }

    public void setAttributeValueLength(Integer attributeValueLength)
    {
        this.attributeValueLength = attributeValueLength;
    }

    private Boolean isList;

    public Boolean getIsList()
    {
        return this.isList;
    }

    public void setIsList(Boolean isList)
    {
        this.isList = isList;
    }

    private String fieldName;

    public String getFieldName()
    {
        return this.fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
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

    private AttributeValueStateDto[] attributeValues;

    public AttributeValueStateDto[] getAttributeValues()
    {
        return this.attributeValues;
    }	

    public void setAttributeValues(AttributeValueStateDto[] attributeValues)
    {
        this.attributeValues = attributeValues;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"AttributeValues"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public AttributeStateDto[] toAttributeStateDtoArray(Iterable<AttributeState> states) 
        {
            ArrayList<AttributeStateDto> stateDtos = new ArrayList();
            for (AttributeState s : states) {
                AttributeStateDto dto = toAttributeStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new AttributeStateDto[0]);
        }

        public AttributeStateDto toAttributeStateDto(AttributeState state)
        {
            if(state == null) {
                return null;
            }
            AttributeStateDto dto = new AttributeStateDto();
            if (returnedFieldsContains("AttributeId")) {
                dto.setAttributeId(state.getAttributeId());
            }
            if (returnedFieldsContains("AttributeName")) {
                dto.setAttributeName(state.getAttributeName());
            }
            if (returnedFieldsContains("OrganizationId")) {
                dto.setOrganizationId(state.getOrganizationId());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("IsMandatory")) {
                dto.setIsMandatory(state.getIsMandatory());
            }
            if (returnedFieldsContains("IsInstanceAttribute")) {
                dto.setIsInstanceAttribute(state.getIsInstanceAttribute());
            }
            if (returnedFieldsContains("AttributeValueType")) {
                dto.setAttributeValueType(state.getAttributeValueType());
            }
            if (returnedFieldsContains("AttributeValueLength")) {
                dto.setAttributeValueLength(state.getAttributeValueLength());
            }
            if (returnedFieldsContains("IsList")) {
                dto.setIsList(state.getIsList());
            }
            if (returnedFieldsContains("FieldName")) {
                dto.setFieldName(state.getFieldName());
            }
            if (returnedFieldsContains("ReferenceId")) {
                dto.setReferenceId(state.getReferenceId());
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
            if (returnedFieldsContains("AttributeValues")) {
                ArrayList<AttributeValueStateDto> arrayList = new ArrayList();
                if (state.getAttributeValues() != null) {
                    AttributeValueStateDto.DtoConverter conv = new AttributeValueStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "AttributeValues");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (AttributeValueState s : state.getAttributeValues()) {
                        arrayList.add(conv.toAttributeValueStateDto(s));
                    }
                }
                dto.setAttributeValues(arrayList.toArray(new AttributeValueStateDto[0]));
            }
            return dto;
        }

    }
}

