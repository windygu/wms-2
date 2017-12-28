package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchAttributeSetInstanceExtensionFieldDto extends AbstractAttributeSetInstanceExtensionFieldCommandDto
{
    private String type;

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    private Integer length;

    public Integer getLength()
    {
        return this.length;
    }

    public void setLength(Integer length)
    {
        this.length = length;
    }

    private String alias;

    public String getAlias()
    {
        return this.alias;
    }

    public void setAlias(String alias)
    {
        this.alias = alias;
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

    private String groupId;

    public String getGroupId()
    {
        return this.groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
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

    public void copyTo(AbstractAttributeSetInstanceExtensionFieldCommand.AbstractCreateOrMergePatchAttributeSetInstanceExtensionField command)
    {
        ((AbstractAttributeSetInstanceExtensionFieldCommandDto) this).copyTo(command);
        command.setType(this.getType());
        command.setLength(this.getLength());
        command.setAlias(this.getAlias());
        command.setDescription(this.getDescription());
        command.setGroupId(this.getGroupId());
        command.setActive(this.getActive());
    }

    public AttributeSetInstanceExtensionFieldCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractAttributeSetInstanceExtensionFieldCommand.SimpleCreateAttributeSetInstanceExtensionField command = new AbstractAttributeSetInstanceExtensionFieldCommand.SimpleCreateAttributeSetInstanceExtensionField();
            copyTo((AbstractAttributeSetInstanceExtensionFieldCommand.AbstractCreateAttributeSetInstanceExtensionField) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractAttributeSetInstanceExtensionFieldCommand.SimpleMergePatchAttributeSetInstanceExtensionField command = new AbstractAttributeSetInstanceExtensionFieldCommand.SimpleMergePatchAttributeSetInstanceExtensionField();
            copyTo((AbstractAttributeSetInstanceExtensionFieldCommand.SimpleMergePatchAttributeSetInstanceExtensionField) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractAttributeSetInstanceExtensionFieldCommand.AbstractCreateAttributeSetInstanceExtensionField command)
    {
        copyTo((AbstractAttributeSetInstanceExtensionFieldCommand.AbstractCreateOrMergePatchAttributeSetInstanceExtensionField) command);
    }

    public void copyTo(AbstractAttributeSetInstanceExtensionFieldCommand.AbstractMergePatchAttributeSetInstanceExtensionField command)
    {
        copyTo((AbstractAttributeSetInstanceExtensionFieldCommand.AbstractCreateOrMergePatchAttributeSetInstanceExtensionField) command);
        command.setIsPropertyTypeRemoved(this.getIsPropertyTypeRemoved());
        command.setIsPropertyLengthRemoved(this.getIsPropertyLengthRemoved());
        command.setIsPropertyAliasRemoved(this.getIsPropertyAliasRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyGroupIdRemoved(this.getIsPropertyGroupIdRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateAttributeSetInstanceExtensionFieldDto extends CreateOrMergePatchAttributeSetInstanceExtensionFieldDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField toCreateAttributeSetInstanceExtensionField()
        {
            return (AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField) toCommand();
        }

    }

    public static class MergePatchAttributeSetInstanceExtensionFieldDto extends CreateOrMergePatchAttributeSetInstanceExtensionFieldDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public AttributeSetInstanceExtensionFieldCommand.MergePatchAttributeSetInstanceExtensionField toMergePatchAttributeSetInstanceExtensionField()
        {
            return (AttributeSetInstanceExtensionFieldCommand.MergePatchAttributeSetInstanceExtensionField) toCommand();
        }

    }

}

