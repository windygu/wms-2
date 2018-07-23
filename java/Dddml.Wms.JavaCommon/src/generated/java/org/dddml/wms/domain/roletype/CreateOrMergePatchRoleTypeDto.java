package org.dddml.wms.domain.roletype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchRoleTypeDto extends AbstractRoleTypeCommandDto
{
    /**
     * Parent Type Id
     */
    private String parentTypeId;

    public String getParentTypeId()
    {
        return this.parentTypeId;
    }

    public void setParentTypeId(String parentTypeId)
    {
        this.parentTypeId = parentTypeId;
    }

    /**
     * Has Table
     */
    private String hasTable;

    public String getHasTable()
    {
        return this.hasTable;
    }

    public void setHasTable(String hasTable)
    {
        this.hasTable = hasTable;
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

    private Boolean isPropertyParentTypeIdRemoved;

    public Boolean getIsPropertyParentTypeIdRemoved()
    {
        return this.isPropertyParentTypeIdRemoved;
    }

    public void setIsPropertyParentTypeIdRemoved(Boolean removed)
    {
        this.isPropertyParentTypeIdRemoved = removed;
    }

    private Boolean isPropertyHasTableRemoved;

    public Boolean getIsPropertyHasTableRemoved()
    {
        return this.isPropertyHasTableRemoved;
    }

    public void setIsPropertyHasTableRemoved(Boolean removed)
    {
        this.isPropertyHasTableRemoved = removed;
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public void copyTo(AbstractRoleTypeCommand.AbstractCreateOrMergePatchRoleType command)
    {
        ((AbstractRoleTypeCommandDto) this).copyTo(command);
        command.setParentTypeId(this.getParentTypeId());
        command.setHasTable(this.getHasTable());
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public RoleTypeCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractRoleTypeCommand.SimpleCreateRoleType command = new AbstractRoleTypeCommand.SimpleCreateRoleType();
            copyTo((AbstractRoleTypeCommand.AbstractCreateRoleType) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractRoleTypeCommand.SimpleMergePatchRoleType command = new AbstractRoleTypeCommand.SimpleMergePatchRoleType();
            copyTo((AbstractRoleTypeCommand.SimpleMergePatchRoleType) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractRoleTypeCommand.AbstractCreateRoleType command)
    {
        copyTo((AbstractRoleTypeCommand.AbstractCreateOrMergePatchRoleType) command);
    }

    public void copyTo(AbstractRoleTypeCommand.AbstractMergePatchRoleType command)
    {
        copyTo((AbstractRoleTypeCommand.AbstractCreateOrMergePatchRoleType) command);
        command.setIsPropertyParentTypeIdRemoved(this.getIsPropertyParentTypeIdRemoved());
        command.setIsPropertyHasTableRemoved(this.getIsPropertyHasTableRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateRoleTypeDto extends CreateOrMergePatchRoleTypeDto
    {
        public CreateRoleTypeDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public RoleTypeCommand.CreateRoleType toCreateRoleType()
        {
            return (RoleTypeCommand.CreateRoleType) toCommand();
        }

    }

    public static class MergePatchRoleTypeDto extends CreateOrMergePatchRoleTypeDto
    {
        public MergePatchRoleTypeDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public RoleTypeCommand.MergePatchRoleType toMergePatchRoleType()
        {
            return (RoleTypeCommand.MergePatchRoleType) toCommand();
        }

    }

}

