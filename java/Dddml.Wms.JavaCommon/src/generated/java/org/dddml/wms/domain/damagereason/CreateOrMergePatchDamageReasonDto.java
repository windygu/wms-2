package org.dddml.wms.domain.damagereason;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchDamageReasonDto extends AbstractDamageReasonCommandDto
{
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
     * Sequence Id
     */
    private String sequenceId;

    public String getSequenceId()
    {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId)
    {
        this.sequenceId = sequenceId;
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

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved()
    {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed)
    {
        this.isPropertyDescriptionRemoved = removed;
    }

    private Boolean isPropertySequenceIdRemoved;

    public Boolean getIsPropertySequenceIdRemoved()
    {
        return this.isPropertySequenceIdRemoved;
    }

    public void setIsPropertySequenceIdRemoved(Boolean removed)
    {
        this.isPropertySequenceIdRemoved = removed;
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

    public void copyTo(AbstractDamageReasonCommand.AbstractCreateOrMergePatchDamageReason command)
    {
        ((AbstractDamageReasonCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setSequenceId(this.getSequenceId());
        command.setActive(this.getActive());
    }

    public DamageReasonCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractDamageReasonCommand.SimpleCreateDamageReason command = new AbstractDamageReasonCommand.SimpleCreateDamageReason();
            copyTo((AbstractDamageReasonCommand.AbstractCreateDamageReason) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractDamageReasonCommand.SimpleMergePatchDamageReason command = new AbstractDamageReasonCommand.SimpleMergePatchDamageReason();
            copyTo((AbstractDamageReasonCommand.SimpleMergePatchDamageReason) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractDamageReasonCommand.AbstractCreateDamageReason command)
    {
        copyTo((AbstractDamageReasonCommand.AbstractCreateOrMergePatchDamageReason) command);
    }

    public void copyTo(AbstractDamageReasonCommand.AbstractMergePatchDamageReason command)
    {
        copyTo((AbstractDamageReasonCommand.AbstractCreateOrMergePatchDamageReason) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertySequenceIdRemoved(this.getIsPropertySequenceIdRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateDamageReasonDto extends CreateOrMergePatchDamageReasonDto
    {
        public CreateDamageReasonDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public DamageReasonCommand.CreateDamageReason toCreateDamageReason()
        {
            return (DamageReasonCommand.CreateDamageReason) toCommand();
        }

    }

    public static class MergePatchDamageReasonDto extends CreateOrMergePatchDamageReasonDto
    {
        public MergePatchDamageReasonDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public DamageReasonCommand.MergePatchDamageReason toMergePatchDamageReason()
        {
            return (DamageReasonCommand.MergePatchDamageReason) toCommand();
        }

    }

}

