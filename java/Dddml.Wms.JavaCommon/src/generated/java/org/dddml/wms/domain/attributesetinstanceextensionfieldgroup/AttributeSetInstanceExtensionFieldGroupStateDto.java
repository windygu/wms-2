package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class AttributeSetInstanceExtensionFieldGroupStateDto
{

    private String id;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    private String fieldType;

    public String getFieldType()
    {
        return this.fieldType;
    }

    public void setFieldType(String fieldType)
    {
        this.fieldType = fieldType;
    }

    private Integer fieldLength;

    public Integer getFieldLength()
    {
        return this.fieldLength;
    }

    public void setFieldLength(Integer fieldLength)
    {
        this.fieldLength = fieldLength;
    }

    private Integer fieldCount;

    public Integer getFieldCount()
    {
        return this.fieldCount;
    }

    public void setFieldCount(Integer fieldCount)
    {
        this.fieldCount = fieldCount;
    }

    private String nameFormat;

    public String getNameFormat()
    {
        return this.nameFormat;
    }

    public void setNameFormat(String nameFormat)
    {
        this.nameFormat = nameFormat;
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

        public AttributeSetInstanceExtensionFieldGroupStateDto[] toAttributeSetInstanceExtensionFieldGroupStateDtoArray(Iterable<AttributeSetInstanceExtensionFieldGroupState> states) {
            return toAttributeSetInstanceExtensionFieldGroupStateDtoList(states).toArray(new AttributeSetInstanceExtensionFieldGroupStateDto[0]);
        }

        public List<AttributeSetInstanceExtensionFieldGroupStateDto> toAttributeSetInstanceExtensionFieldGroupStateDtoList(Iterable<AttributeSetInstanceExtensionFieldGroupState> states) {
            ArrayList<AttributeSetInstanceExtensionFieldGroupStateDto> stateDtos = new ArrayList();
            for (AttributeSetInstanceExtensionFieldGroupState s : states) {
                AttributeSetInstanceExtensionFieldGroupStateDto dto = toAttributeSetInstanceExtensionFieldGroupStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public AttributeSetInstanceExtensionFieldGroupStateDto toAttributeSetInstanceExtensionFieldGroupStateDto(AttributeSetInstanceExtensionFieldGroupState state)
        {
            if(state == null) {
                return null;
            }
            AttributeSetInstanceExtensionFieldGroupStateDto dto = new AttributeSetInstanceExtensionFieldGroupStateDto();
            if (returnedFieldsContains("Id")) {
                dto.setId(state.getId());
            }
            if (returnedFieldsContains("FieldType")) {
                dto.setFieldType(state.getFieldType());
            }
            if (returnedFieldsContains("FieldLength")) {
                dto.setFieldLength(state.getFieldLength());
            }
            if (returnedFieldsContains("FieldCount")) {
                dto.setFieldCount(state.getFieldCount());
            }
            if (returnedFieldsContains("NameFormat")) {
                dto.setNameFormat(state.getNameFormat());
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

