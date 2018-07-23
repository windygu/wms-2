package org.dddml.wms.domain.attributeset;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchAttributeSetDto extends AbstractAttributeSetCommandDto
{
    /**
     * Attribute Set Name
     */
    private String attributeSetName;

    public String getAttributeSetName()
    {
        return this.attributeSetName;
    }

    public void setAttributeSetName(String attributeSetName)
    {
        this.attributeSetName = attributeSetName;
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
     * Is Instance Attribute Set
     */
    private Boolean isInstanceAttributeSet;

    public Boolean getIsInstanceAttributeSet()
    {
        return this.isInstanceAttributeSet;
    }

    public void setIsInstanceAttributeSet(Boolean isInstanceAttributeSet)
    {
        this.isInstanceAttributeSet = isInstanceAttributeSet;
    }

    /**
     * Is Mandatory
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

    private CreateOrMergePatchAttributeUseDto[] attributeUses;

    public CreateOrMergePatchAttributeUseDto[] getAttributeUses()
    {
        return this.attributeUses;
    }

    public void setAttributeUses(CreateOrMergePatchAttributeUseDto[] attributeUses)
    {
        this.attributeUses = attributeUses;
    }

    private Boolean isPropertyAttributeSetNameRemoved;

    public Boolean getIsPropertyAttributeSetNameRemoved()
    {
        return this.isPropertyAttributeSetNameRemoved;
    }

    public void setIsPropertyAttributeSetNameRemoved(Boolean removed)
    {
        this.isPropertyAttributeSetNameRemoved = removed;
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

    private Boolean isPropertyReferenceIdRemoved;

    public Boolean getIsPropertyReferenceIdRemoved()
    {
        return this.isPropertyReferenceIdRemoved;
    }

    public void setIsPropertyReferenceIdRemoved(Boolean removed)
    {
        this.isPropertyReferenceIdRemoved = removed;
    }

    private Boolean isPropertyIsInstanceAttributeSetRemoved;

    public Boolean getIsPropertyIsInstanceAttributeSetRemoved()
    {
        return this.isPropertyIsInstanceAttributeSetRemoved;
    }

    public void setIsPropertyIsInstanceAttributeSetRemoved(Boolean removed)
    {
        this.isPropertyIsInstanceAttributeSetRemoved = removed;
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public static class CreateAttributeSetDto extends CreateOrMergePatchAttributeSetDto
    {
        public CreateAttributeSetDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchAttributeSetDto extends CreateOrMergePatchAttributeSetDto
    {
        public MergePatchAttributeSetDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

