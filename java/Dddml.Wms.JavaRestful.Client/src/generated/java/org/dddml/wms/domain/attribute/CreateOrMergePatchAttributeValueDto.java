package org.dddml.wms.domain.attribute;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchAttributeValueDto extends AbstractAttributeValueCommandDto
{
    /**
     * Attribute Value Name
     */
    private String attributeValueName;

    public String getAttributeValueName()
    {
        return this.attributeValueName;
    }

    public void setAttributeValueName(String attributeValueName)
    {
        this.attributeValueName = attributeValueName;
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

    private Boolean isPropertyAttributeValueNameRemoved;

    public Boolean getIsPropertyAttributeValueNameRemoved()
    {
        return this.isPropertyAttributeValueNameRemoved;
    }

    public void setIsPropertyAttributeValueNameRemoved(Boolean removed)
    {
        this.isPropertyAttributeValueNameRemoved = removed;
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public static class CreateAttributeValueDto extends CreateOrMergePatchAttributeValueDto
    {
        public CreateAttributeValueDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchAttributeValueDto extends CreateOrMergePatchAttributeValueDto
    {
        public MergePatchAttributeValueDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

