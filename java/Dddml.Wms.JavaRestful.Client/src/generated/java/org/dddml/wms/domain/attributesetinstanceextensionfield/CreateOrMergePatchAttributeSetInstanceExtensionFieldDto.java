package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchAttributeSetInstanceExtensionFieldDto extends AbstractAttributeSetInstanceExtensionFieldCommandDto
{
    /**
     * Type
     */
    private String type;

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Length
     */
    private Integer length;

    public Integer getLength()
    {
        return this.length;
    }

    public void setLength(Integer length)
    {
        this.length = length;
    }

    /**
     * Alias
     */
    private String alias;

    public String getAlias()
    {
        return this.alias;
    }

    public void setAlias(String alias)
    {
        this.alias = alias;
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
     * Group Id
     */
    private String groupId;

    public String getGroupId()
    {
        return this.groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
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

    private Boolean isPropertyTypeRemoved;

    public Boolean getIsPropertyTypeRemoved()
    {
        return this.isPropertyTypeRemoved;
    }

    public void setIsPropertyTypeRemoved(Boolean removed)
    {
        this.isPropertyTypeRemoved = removed;
    }

    private Boolean isPropertyLengthRemoved;

    public Boolean getIsPropertyLengthRemoved()
    {
        return this.isPropertyLengthRemoved;
    }

    public void setIsPropertyLengthRemoved(Boolean removed)
    {
        this.isPropertyLengthRemoved = removed;
    }

    private Boolean isPropertyAliasRemoved;

    public Boolean getIsPropertyAliasRemoved()
    {
        return this.isPropertyAliasRemoved;
    }

    public void setIsPropertyAliasRemoved(Boolean removed)
    {
        this.isPropertyAliasRemoved = removed;
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

    private Boolean isPropertyGroupIdRemoved;

    public Boolean getIsPropertyGroupIdRemoved()
    {
        return this.isPropertyGroupIdRemoved;
    }

    public void setIsPropertyGroupIdRemoved(Boolean removed)
    {
        this.isPropertyGroupIdRemoved = removed;
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

    public static class CreateAttributeSetInstanceExtensionFieldDto extends CreateOrMergePatchAttributeSetInstanceExtensionFieldDto
    {
        public CreateAttributeSetInstanceExtensionFieldDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchAttributeSetInstanceExtensionFieldDto extends CreateOrMergePatchAttributeSetInstanceExtensionFieldDto
    {
        public MergePatchAttributeSetInstanceExtensionFieldDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

