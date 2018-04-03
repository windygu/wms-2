package org.dddml.wms.domain.rejectionreason;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchRejectionReasonDto extends AbstractRejectionReasonCommandDto
{
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

    public void copyTo(AbstractRejectionReasonCommand.AbstractCreateOrMergePatchRejectionReason command)
    {
        ((AbstractRejectionReasonCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public RejectionReasonCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractRejectionReasonCommand.SimpleCreateRejectionReason command = new AbstractRejectionReasonCommand.SimpleCreateRejectionReason();
            copyTo((AbstractRejectionReasonCommand.AbstractCreateRejectionReason) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractRejectionReasonCommand.SimpleMergePatchRejectionReason command = new AbstractRejectionReasonCommand.SimpleMergePatchRejectionReason();
            copyTo((AbstractRejectionReasonCommand.SimpleMergePatchRejectionReason) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractRejectionReasonCommand.AbstractCreateRejectionReason command)
    {
        copyTo((AbstractRejectionReasonCommand.AbstractCreateOrMergePatchRejectionReason) command);
    }

    public void copyTo(AbstractRejectionReasonCommand.AbstractMergePatchRejectionReason command)
    {
        copyTo((AbstractRejectionReasonCommand.AbstractCreateOrMergePatchRejectionReason) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateRejectionReasonDto extends CreateOrMergePatchRejectionReasonDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public RejectionReasonCommand.CreateRejectionReason toCreateRejectionReason()
        {
            return (RejectionReasonCommand.CreateRejectionReason) toCommand();
        }

    }

    public static class MergePatchRejectionReasonDto extends CreateOrMergePatchRejectionReasonDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public RejectionReasonCommand.MergePatchRejectionReason toMergePatchRejectionReason()
        {
            return (RejectionReasonCommand.MergePatchRejectionReason) toCommand();
        }

    }

}

