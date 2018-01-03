package org.dddml.wms.domain.damagehandlingmethod;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchDamageHandlingMethodDto extends AbstractDamageHandlingMethodCommandDto
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

    private String sequenceId;

    public String getSequenceId()
    {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId)
    {
        this.sequenceId = sequenceId;
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

    public void copyTo(AbstractDamageHandlingMethodCommand.AbstractCreateOrMergePatchDamageHandlingMethod command)
    {
        ((AbstractDamageHandlingMethodCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setSequenceId(this.getSequenceId());
        command.setActive(this.getActive());
    }

    public DamageHandlingMethodCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractDamageHandlingMethodCommand.SimpleCreateDamageHandlingMethod command = new AbstractDamageHandlingMethodCommand.SimpleCreateDamageHandlingMethod();
            copyTo((AbstractDamageHandlingMethodCommand.AbstractCreateDamageHandlingMethod) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractDamageHandlingMethodCommand.SimpleMergePatchDamageHandlingMethod command = new AbstractDamageHandlingMethodCommand.SimpleMergePatchDamageHandlingMethod();
            copyTo((AbstractDamageHandlingMethodCommand.SimpleMergePatchDamageHandlingMethod) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractDamageHandlingMethodCommand.AbstractCreateDamageHandlingMethod command)
    {
        copyTo((AbstractDamageHandlingMethodCommand.AbstractCreateOrMergePatchDamageHandlingMethod) command);
    }

    public void copyTo(AbstractDamageHandlingMethodCommand.AbstractMergePatchDamageHandlingMethod command)
    {
        copyTo((AbstractDamageHandlingMethodCommand.AbstractCreateOrMergePatchDamageHandlingMethod) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertySequenceIdRemoved(this.getIsPropertySequenceIdRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateDamageHandlingMethodDto extends CreateOrMergePatchDamageHandlingMethodDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public DamageHandlingMethodCommand.CreateDamageHandlingMethod toCreateDamageHandlingMethod()
        {
            return (DamageHandlingMethodCommand.CreateDamageHandlingMethod) toCommand();
        }

    }

    public static class MergePatchDamageHandlingMethodDto extends CreateOrMergePatchDamageHandlingMethodDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public DamageHandlingMethodCommand.MergePatchDamageHandlingMethod toMergePatchDamageHandlingMethod()
        {
            return (DamageHandlingMethodCommand.MergePatchDamageHandlingMethod) toCommand();
        }

    }

}

