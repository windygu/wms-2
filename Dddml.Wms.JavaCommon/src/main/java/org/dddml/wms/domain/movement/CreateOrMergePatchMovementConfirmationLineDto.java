package org.dddml.wms.domain.movement;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchMovementConfirmationLineDto extends AbstractMovementConfirmationLineCommandDto
{
    private BigDecimal targetQuantity;

    public BigDecimal getTargetQuantity()
    {
        return this.targetQuantity;
    }

    public void setTargetQuantity(BigDecimal targetQuantity)
    {
        this.targetQuantity = targetQuantity;
    }

    private BigDecimal confirmedQuantity;

    public BigDecimal getConfirmedQuantity()
    {
        return this.confirmedQuantity;
    }

    public void setConfirmedQuantity(BigDecimal confirmedQuantity)
    {
        this.confirmedQuantity = confirmedQuantity;
    }

    private BigDecimal differenceQuantity;

    public BigDecimal getDifferenceQuantity()
    {
        return this.differenceQuantity;
    }

    public void setDifferenceQuantity(BigDecimal differenceQuantity)
    {
        this.differenceQuantity = differenceQuantity;
    }

    private BigDecimal scrappedQuantity;

    public BigDecimal getScrappedQuantity()
    {
        return this.scrappedQuantity;
    }

    public void setScrappedQuantity(BigDecimal scrappedQuantity)
    {
        this.scrappedQuantity = scrappedQuantity;
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

    private Boolean isPropertyTargetQuantityRemoved;

    public Boolean getIsPropertyTargetQuantityRemoved()
    {
        return this.isPropertyTargetQuantityRemoved;
    }

    public void setIsPropertyTargetQuantityRemoved(Boolean removed)
    {
        this.isPropertyTargetQuantityRemoved = removed;
    }

    private Boolean isPropertyConfirmedQuantityRemoved;

    public Boolean getIsPropertyConfirmedQuantityRemoved()
    {
        return this.isPropertyConfirmedQuantityRemoved;
    }

    public void setIsPropertyConfirmedQuantityRemoved(Boolean removed)
    {
        this.isPropertyConfirmedQuantityRemoved = removed;
    }

    private Boolean isPropertyDifferenceQuantityRemoved;

    public Boolean getIsPropertyDifferenceQuantityRemoved()
    {
        return this.isPropertyDifferenceQuantityRemoved;
    }

    public void setIsPropertyDifferenceQuantityRemoved(Boolean removed)
    {
        this.isPropertyDifferenceQuantityRemoved = removed;
    }

    private Boolean isPropertyScrappedQuantityRemoved;

    public Boolean getIsPropertyScrappedQuantityRemoved()
    {
        return this.isPropertyScrappedQuantityRemoved;
    }

    public void setIsPropertyScrappedQuantityRemoved(Boolean removed)
    {
        this.isPropertyScrappedQuantityRemoved = removed;
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

    public void copyTo(AbstractMovementConfirmationLineCommand.AbstractCreateOrMergePatchMovementConfirmationLine command)
    {
        ((AbstractMovementConfirmationLineCommandDto) this).copyTo(command);
        command.setTargetQuantity(this.getTargetQuantity());
        command.setConfirmedQuantity(this.getConfirmedQuantity());
        command.setDifferenceQuantity(this.getDifferenceQuantity());
        command.setScrappedQuantity(this.getScrappedQuantity());
        command.setActive(this.getActive());
    }

    public MovementConfirmationLineCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractMovementConfirmationLineCommand.SimpleCreateMovementConfirmationLine command = new AbstractMovementConfirmationLineCommand.SimpleCreateMovementConfirmationLine();
            copyTo((AbstractMovementConfirmationLineCommand.AbstractCreateMovementConfirmationLine) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractMovementConfirmationLineCommand.SimpleMergePatchMovementConfirmationLine command = new AbstractMovementConfirmationLineCommand.SimpleMergePatchMovementConfirmationLine();
            copyTo((AbstractMovementConfirmationLineCommand.SimpleMergePatchMovementConfirmationLine) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine command = new AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine();
            ((AbstractMovementConfirmationLineCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractMovementConfirmationLineCommand.AbstractCreateMovementConfirmationLine command)
    {
        copyTo((AbstractMovementConfirmationLineCommand.AbstractCreateOrMergePatchMovementConfirmationLine) command);
    }

    public void copyTo(AbstractMovementConfirmationLineCommand.AbstractMergePatchMovementConfirmationLine command)
    {
        copyTo((AbstractMovementConfirmationLineCommand.AbstractCreateOrMergePatchMovementConfirmationLine) command);
        command.setIsPropertyTargetQuantityRemoved(this.getIsPropertyTargetQuantityRemoved());
        command.setIsPropertyConfirmedQuantityRemoved(this.getIsPropertyConfirmedQuantityRemoved());
        command.setIsPropertyDifferenceQuantityRemoved(this.getIsPropertyDifferenceQuantityRemoved());
        command.setIsPropertyScrappedQuantityRemoved(this.getIsPropertyScrappedQuantityRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateMovementConfirmationLineDto extends CreateOrMergePatchMovementConfirmationLineDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public MovementConfirmationLineCommand.CreateMovementConfirmationLine toCreateMovementConfirmationLine()
        {
            return (MovementConfirmationLineCommand.CreateMovementConfirmationLine) toCommand();
        }

    }

    public static class MergePatchMovementConfirmationLineDto extends CreateOrMergePatchMovementConfirmationLineDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public MovementConfirmationLineCommand.MergePatchMovementConfirmationLine toMergePatchMovementConfirmationLine()
        {
            return (MovementConfirmationLineCommand.MergePatchMovementConfirmationLine) toCommand();
        }

    }

}

