package org.dddml.wms.domain.movement;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchMovementLineDto extends AbstractMovementLineCommandDto
{
    private BigDecimal movementQuantity;

    public BigDecimal getMovementQuantity()
    {
        return this.movementQuantity;
    }

    public void setMovementQuantity(BigDecimal movementQuantity)
    {
        this.movementQuantity = movementQuantity;
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

    private Boolean isPropertyMovementQuantityRemoved;

    public Boolean getIsPropertyMovementQuantityRemoved()
    {
        return this.isPropertyMovementQuantityRemoved;
    }

    public void setIsPropertyMovementQuantityRemoved(Boolean removed)
    {
        this.isPropertyMovementQuantityRemoved = removed;
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

    public void copyTo(AbstractMovementLineCommand.AbstractCreateOrMergePatchMovementLine command)
    {
        ((AbstractMovementLineCommandDto) this).copyTo(command);
        command.setMovementQuantity(this.getMovementQuantity());
        command.setActive(this.getActive());
    }

    public MovementLineCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractMovementLineCommand.SimpleCreateMovementLine command = new AbstractMovementLineCommand.SimpleCreateMovementLine();
            copyTo((AbstractMovementLineCommand.AbstractCreateMovementLine) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractMovementLineCommand.SimpleMergePatchMovementLine command = new AbstractMovementLineCommand.SimpleMergePatchMovementLine();
            copyTo((AbstractMovementLineCommand.SimpleMergePatchMovementLine) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractMovementLineCommand.SimpleRemoveMovementLine command = new AbstractMovementLineCommand.SimpleRemoveMovementLine();
            ((AbstractMovementLineCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractMovementLineCommand.AbstractCreateMovementLine command)
    {
        copyTo((AbstractMovementLineCommand.AbstractCreateOrMergePatchMovementLine) command);
    }

    public void copyTo(AbstractMovementLineCommand.AbstractMergePatchMovementLine command)
    {
        copyTo((AbstractMovementLineCommand.AbstractCreateOrMergePatchMovementLine) command);
        command.setIsPropertyMovementQuantityRemoved(this.getIsPropertyMovementQuantityRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateMovementLineDto extends CreateOrMergePatchMovementLineDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public MovementLineCommand.CreateMovementLine toCreateMovementLine()
        {
            return (MovementLineCommand.CreateMovementLine) toCommand();
        }

    }

    public static class MergePatchMovementLineDto extends CreateOrMergePatchMovementLineDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public MovementLineCommand.MergePatchMovementLine toMergePatchMovementLine()
        {
            return (MovementLineCommand.MergePatchMovementLine) toCommand();
        }

    }

}

