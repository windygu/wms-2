package org.dddml.wms.domain.attribute;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchAttributeDto extends AbstractAttributeCommandDto
{
    /**
     * Attribute Name
     */
    private String attributeName;

    public String getAttributeName()
    {
        return this.attributeName;
    }

    public void setAttributeName(String attributeName)
    {
        this.attributeName = attributeName;
    }

    /**
     * Organization Id
     */
    private String organizationId;

    public String getOrganizationId()
    {
        return this.organizationId;
    }

    public void setOrganizationId(String organizationId)
    {
        this.organizationId = organizationId;
    }

    /**
     * Description
     */
    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * The field must have a value for the record to be saved to the database.
     */
    private Boolean isMandatory;

    public Boolean getIsMandatory()
    {
        return this.isMandatory;
    }

    public void setIsMandatory(Boolean isMandatory)
    {
        this.isMandatory = isMandatory;
    }

    /**
     * The Attribute Value type deternines the data/validation type.
     */
    private String attributeValueType;

    public String getAttributeValueType()
    {
        return this.attributeValueType;
    }

    public void setAttributeValueType(String attributeValueType)
    {
        this.attributeValueType = attributeValueType;
    }

    /**
     * Attribute Value Length
     */
    private Integer attributeValueLength;

    public Integer getAttributeValueLength()
    {
        return this.attributeValueLength;
    }

    public void setAttributeValueLength(Integer attributeValueLength)
    {
        this.attributeValueLength = attributeValueLength;
    }

    /**
     * Is the attribute values a list(enumerable).
     */
    private Boolean isList;

    public Boolean getIsList()
    {
        return this.isList;
    }

    public void setIsList(Boolean isList)
    {
        this.isList = isList;
    }

    /**
     * The field name to save this attribute.
     */
    private String fieldName;

    public String getFieldName()
    {
        return this.fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    /**
     * Reference Id
     */
    private String referenceId;

    public String getReferenceId()
    {
        return this.referenceId;
    }

    public void setReferenceId(String referenceId)
    {
        this.referenceId = referenceId;
    }

    /**
     * Active
     */
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private CreateOrMergePatchAttributeValueDto[] attributeValues;

    public CreateOrMergePatchAttributeValueDto[] getAttributeValues()
    {
        return this.attributeValues;
    }

    public void setAttributeValues(CreateOrMergePatchAttributeValueDto[] attributeValues)
    {
        this.attributeValues = attributeValues;
    }

    private CreateOrMergePatchAttributeAliasDto[] aliases;

    public CreateOrMergePatchAttributeAliasDto[] getAliases()
    {
        return this.aliases;
    }

    public void setAliases(CreateOrMergePatchAttributeAliasDto[] aliases)
    {
        this.aliases = aliases;
    }

    private Boolean isPropertyAttributeNameRemoved;

    public Boolean getIsPropertyAttributeNameRemoved()
    {
        return this.isPropertyAttributeNameRemoved;
    }

    public void setIsPropertyAttributeNameRemoved(Boolean removed)
    {
        this.isPropertyAttributeNameRemoved = removed;
    }

    private Boolean isPropertyOrganizationIdRemoved;

    public Boolean getIsPropertyOrganizationIdRemoved()
    {
        return this.isPropertyOrganizationIdRemoved;
    }

    public void setIsPropertyOrganizationIdRemoved(Boolean removed)
    {
        this.isPropertyOrganizationIdRemoved = removed;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved()
    {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed)
    {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertyIsMandatoryRemoved;

    public Boolean getIsPropertyIsMandatoryRemoved()
    {
        return this.isPropertyIsMandatoryRemoved;
    }

    public void setIsPropertyIsMandatoryRemoved(Boolean removed)
    {
        this.isPropertyIsMandatoryRemoved = removed;
    }

    private Boolean isPropertyAttributeValueTypeRemoved;

    public Boolean getIsPropertyAttributeValueTypeRemoved()
    {
        return this.isPropertyAttributeValueTypeRemoved;
    }

    public void setIsPropertyAttributeValueTypeRemoved(Boolean removed)
    {
        this.isPropertyAttributeValueTypeRemoved = removed;
    }

    private Boolean isPropertyAttributeValueLengthRemoved;

    public Boolean getIsPropertyAttributeValueLengthRemoved()
    {
        return this.isPropertyAttributeValueLengthRemoved;
    }

    public void setIsPropertyAttributeValueLengthRemoved(Boolean removed)
    {
        this.isPropertyAttributeValueLengthRemoved = removed;
    }

    private Boolean isPropertyIsListRemoved;

    public Boolean getIsPropertyIsListRemoved()
    {
        return this.isPropertyIsListRemoved;
    }

    public void setIsPropertyIsListRemoved(Boolean removed)
    {
        this.isPropertyIsListRemoved = removed;
    }

    private Boolean isPropertyFieldNameRemoved;

    public Boolean getIsPropertyFieldNameRemoved()
    {
        return this.isPropertyFieldNameRemoved;
    }

    public void setIsPropertyFieldNameRemoved(Boolean removed)
    {
        this.isPropertyFieldNameRemoved = removed;
    }

    private Boolean isPropertyReferenceIdRemoved;

    public Boolean getIsPropertyReferenceIdRemoved()
    {
        return this.isPropertyReferenceIdRemoved;
    }

    public void setIsPropertyReferenceIdRemoved(Boolean removed)
    {
        this.isPropertyReferenceIdRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public static class CreateAttributeDto extends CreateOrMergePatchAttributeDto
    {
        public CreateAttributeDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchAttributeDto extends CreateOrMergePatchAttributeDto
    {
        public MergePatchAttributeDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

