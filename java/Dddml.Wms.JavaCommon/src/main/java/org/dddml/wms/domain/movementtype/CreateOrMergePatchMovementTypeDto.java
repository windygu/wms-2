package org.dddml.wms.domain.movementtype;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchMovementTypeDto extends AbstractMovementTypeCommandDto
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

    public void copyTo(AbstractMovementTypeCommand.AbstractCreateOrMergePatchMovementType command)
    {
        ((AbstractMovementTypeCommandDto) this).copyTo(command);
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public MovementTypeCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractMovementTypeCommand.SimpleCreateMovementType command = new AbstractMovementTypeCommand.SimpleCreateMovementType();
            copyTo((AbstractMovementTypeCommand.AbstractCreateMovementType) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractMovementTypeCommand.SimpleMergePatchMovementType command = new AbstractMovementTypeCommand.SimpleMergePatchMovementType();
            copyTo((AbstractMovementTypeCommand.SimpleMergePatchMovementType) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractMovementTypeCommand.AbstractCreateMovementType command)
    {
        copyTo((AbstractMovementTypeCommand.AbstractCreateOrMergePatchMovementType) command);
    }

    public void copyTo(AbstractMovementTypeCommand.AbstractMergePatchMovementType command)
    {
        copyTo((AbstractMovementTypeCommand.AbstractCreateOrMergePatchMovementType) command);
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateMovementTypeDto extends CreateOrMergePatchMovementTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public MovementTypeCommand.CreateMovementType toCreateMovementType()
        {
            return (MovementTypeCommand.CreateMovementType) toCommand();
        }

    }

    public static class MergePatchMovementTypeDto extends CreateOrMergePatchMovementTypeDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public MovementTypeCommand.MergePatchMovementType toMergePatchMovementType()
        {
            return (MovementTypeCommand.MergePatchMovementType) toCommand();
        }

    }

}

