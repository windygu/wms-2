package org.dddml.wms.domain.attribute;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchAttributeAliasDto extends AbstractAttributeAliasCommandDto
{
    /**
     * Name
     */
    private String name;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    private Boolean isPropertyNameRemoved;

    public Boolean getIsPropertyNameRemoved()
    {
        return this.isPropertyNameRemoved;
    }

    public void setIsPropertyNameRemoved(Boolean removed)
    {
        this.isPropertyNameRemoved = removed;
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

    public void copyTo(AbstractAttributeAliasCommand.AbstractCreateOrMergePatchAttributeAlias command)
    {
        ((AbstractAttributeAliasCommandDto) this).copyTo(command);
        command.setName(this.getName());
        command.setActive(this.getActive());
    }

    public AttributeAliasCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractAttributeAliasCommand.SimpleCreateAttributeAlias command = new AbstractAttributeAliasCommand.SimpleCreateAttributeAlias();
            copyTo((AbstractAttributeAliasCommand.AbstractCreateAttributeAlias) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractAttributeAliasCommand.SimpleMergePatchAttributeAlias command = new AbstractAttributeAliasCommand.SimpleMergePatchAttributeAlias();
            copyTo((AbstractAttributeAliasCommand.SimpleMergePatchAttributeAlias) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractAttributeAliasCommand.SimpleRemoveAttributeAlias command = new AbstractAttributeAliasCommand.SimpleRemoveAttributeAlias();
            ((AbstractAttributeAliasCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractAttributeAliasCommand.AbstractCreateAttributeAlias command)
    {
        copyTo((AbstractAttributeAliasCommand.AbstractCreateOrMergePatchAttributeAlias) command);
    }

    public void copyTo(AbstractAttributeAliasCommand.AbstractMergePatchAttributeAlias command)
    {
        copyTo((AbstractAttributeAliasCommand.AbstractCreateOrMergePatchAttributeAlias) command);
        command.setIsPropertyNameRemoved(this.getIsPropertyNameRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateAttributeAliasDto extends CreateOrMergePatchAttributeAliasDto
    {
        public CreateAttributeAliasDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public AttributeAliasCommand.CreateAttributeAlias toCreateAttributeAlias()
        {
            return (AttributeAliasCommand.CreateAttributeAlias) toCommand();
        }

    }

    public static class MergePatchAttributeAliasDto extends CreateOrMergePatchAttributeAliasDto
    {
        public MergePatchAttributeAliasDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public AttributeAliasCommand.MergePatchAttributeAlias toMergePatchAttributeAlias()
        {
            return (AttributeAliasCommand.MergePatchAttributeAlias) toCommand();
        }

    }

}

