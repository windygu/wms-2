package org.dddml.wms.domain.pickwave;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchPickwaveDto extends AbstractPickwaveCommandDto
{
    private String statusId;

    public String getStatusId()
    {
        return this.statusId;
    }

    public void setStatusId(String statusId)
    {
        this.statusId = statusId;
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

    private Boolean isPropertyStatusIdRemoved;

    public Boolean getIsPropertyStatusIdRemoved()
    {
        return this.isPropertyStatusIdRemoved;
    }

    public void setIsPropertyStatusIdRemoved(Boolean removed)
    {
        this.isPropertyStatusIdRemoved = removed;
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

    public void copyTo(AbstractPickwaveCommand.AbstractCreateOrMergePatchPickwave command)
    {
        ((AbstractPickwaveCommandDto) this).copyTo(command);
        command.setStatusId(this.getStatusId());
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public PickwaveCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractPickwaveCommand.SimpleCreatePickwave command = new AbstractPickwaveCommand.SimpleCreatePickwave();
            copyTo((AbstractPickwaveCommand.AbstractCreatePickwave) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractPickwaveCommand.SimpleMergePatchPickwave command = new AbstractPickwaveCommand.SimpleMergePatchPickwave();
            copyTo((AbstractPickwaveCommand.SimpleMergePatchPickwave) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractPickwaveCommand.AbstractCreatePickwave command)
    {
        copyTo((AbstractPickwaveCommand.AbstractCreateOrMergePatchPickwave) command);
    }

    public void copyTo(AbstractPickwaveCommand.AbstractMergePatchPickwave command)
    {
        copyTo((AbstractPickwaveCommand.AbstractCreateOrMergePatchPickwave) command);
        command.setIsPropertyStatusIdRemoved(this.getIsPropertyStatusIdRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreatePickwaveDto extends CreateOrMergePatchPickwaveDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public PickwaveCommand.CreatePickwave toCreatePickwave()
        {
            return (PickwaveCommand.CreatePickwave) toCommand();
        }

    }

    public static class MergePatchPickwaveDto extends CreateOrMergePatchPickwaveDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public PickwaveCommand.MergePatchPickwave toMergePatchPickwave()
        {
            return (PickwaveCommand.MergePatchPickwave) toCommand();
        }

    }

}

