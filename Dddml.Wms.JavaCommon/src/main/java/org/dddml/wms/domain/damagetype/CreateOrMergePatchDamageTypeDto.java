package org.dddml.wms.domain.damagetype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchDamageTypeDto extends AbstractDamageTypeCommandDto
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

    private String defaultHandlingMethodId;

    public String getDefaultHandlingMethodId()
    {
        return this.defaultHandlingMethodId;
    }

    public void setDefaultHandlingMethodId(String defaultHandlingMethodId)
    {
        this.defaultHandlingMethodId = defaultHandlingMethodId;
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

    private Boolean isPropertyDefaultHandlingMethodIdRemoved;

    public Boolean getIsPropertyDefaultHandlingMethodIdRemoved()
    {
        return this.isPropertyDefaultHandlingMethodIdRemoved;
    }

    public void setIsPropertyDefaultHandlingMethodIdRemoved(Boolean removed)
    {
        this.isPropertyDefaultHandlingMethodIdRemoved = removed;
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

    public void copyTo(AbstractDamageTypeCommand.AbstractCreateOrMergePatchDamageType command)
    {
        ((AbstractDamageTypeCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setSequenceId(this.getSequenceId());
        command.setDefaultHandlingMethodId(this.getDefaultHandlingMethodId());
        command.setActive(this.getActive());
    }

    public DamageTypeCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractDamageTypeCommand.SimpleCreateDamageType command = new AbstractDamageTypeCommand.SimpleCreateDamageType();
            copyTo((AbstractDamageTypeCommand.AbstractCreateDamageType) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractDamageTypeCommand.SimpleMergePatchDamageType command = new AbstractDamageTypeCommand.SimpleMergePatchDamageType();
            copyTo((AbstractDamageTypeCommand.SimpleMergePatchDamageType) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractDamageTypeCommand.AbstractCreateDamageType command)
    {
        copyTo((AbstractDamageTypeCommand.AbstractCreateOrMergePatchDamageType) command);
    }

    public void copyTo(AbstractDamageTypeCommand.AbstractMergePatchDamageType command)
    {
        copyTo((AbstractDamageTypeCommand.AbstractCreateOrMergePatchDamageType) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertySequenceIdRemoved(this.getIsPropertySequenceIdRemoved());
        command.setIsPropertyDefaultHandlingMethodIdRemoved(this.getIsPropertyDefaultHandlingMethodIdRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateDamageTypeDto extends CreateOrMergePatchDamageTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public DamageTypeCommand.CreateDamageType toCreateDamageType()
        {
            return (DamageTypeCommand.CreateDamageType) toCommand();
        }

    }

    public static class MergePatchDamageTypeDto extends CreateOrMergePatchDamageTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public DamageTypeCommand.MergePatchDamageType toMergePatchDamageType()
        {
            return (DamageTypeCommand.MergePatchDamageType) toCommand();
        }

    }

}

