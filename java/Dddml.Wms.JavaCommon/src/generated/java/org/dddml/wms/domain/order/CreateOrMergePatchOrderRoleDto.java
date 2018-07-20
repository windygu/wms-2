package org.dddml.wms.domain.order;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchOrderRoleDto extends AbstractOrderRoleCommandDto
{
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

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public void copyTo(AbstractOrderRoleCommand.AbstractCreateOrMergePatchOrderRole command)
    {
        ((AbstractOrderRoleCommandDto) this).copyTo(command);
        command.setActive(this.getActive());
    }

    public OrderRoleCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractOrderRoleCommand.SimpleCreateOrderRole command = new AbstractOrderRoleCommand.SimpleCreateOrderRole();
            copyTo((AbstractOrderRoleCommand.AbstractCreateOrderRole) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractOrderRoleCommand.SimpleMergePatchOrderRole command = new AbstractOrderRoleCommand.SimpleMergePatchOrderRole();
            copyTo((AbstractOrderRoleCommand.SimpleMergePatchOrderRole) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractOrderRoleCommand.SimpleRemoveOrderRole command = new AbstractOrderRoleCommand.SimpleRemoveOrderRole();
            ((AbstractOrderRoleCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractOrderRoleCommand.AbstractCreateOrderRole command)
    {
        copyTo((AbstractOrderRoleCommand.AbstractCreateOrMergePatchOrderRole) command);
    }

    public void copyTo(AbstractOrderRoleCommand.AbstractMergePatchOrderRole command)
    {
        copyTo((AbstractOrderRoleCommand.AbstractCreateOrMergePatchOrderRole) command);
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateOrderRoleDto extends CreateOrMergePatchOrderRoleDto
    {
        public CreateOrderRoleDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public OrderRoleCommand.CreateOrderRole toCreateOrderRole()
        {
            return (OrderRoleCommand.CreateOrderRole) toCommand();
        }

    }

    public static class MergePatchOrderRoleDto extends CreateOrMergePatchOrderRoleDto
    {
        public MergePatchOrderRoleDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public OrderRoleCommand.MergePatchOrderRole toMergePatchOrderRole()
        {
            return (OrderRoleCommand.MergePatchOrderRole) toCommand();
        }

    }

}

