package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchPhysicalInventoryLineDto extends AbstractPhysicalInventoryLineCommandDto
{
    private BigDecimal bookQuantity;

    public BigDecimal getBookQuantity()
    {
        return this.bookQuantity;
    }

    public void setBookQuantity(BigDecimal bookQuantity)
    {
        this.bookQuantity = bookQuantity;
    }

    private BigDecimal countedQuantity;

    public BigDecimal getCountedQuantity()
    {
        return this.countedQuantity;
    }

    public void setCountedQuantity(BigDecimal countedQuantity)
    {
        this.countedQuantity = countedQuantity;
    }

    private Boolean processed;

    public Boolean getProcessed()
    {
        return this.processed;
    }

    public void setProcessed(Boolean processed)
    {
        this.processed = processed;
    }

    private String lineNumber;

    public String getLineNumber()
    {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    private Long reversalLineNumber;

    public Long getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(Long reversalLineNumber)
    {
        this.reversalLineNumber = reversalLineNumber;
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

    private Boolean isPropertyBookQuantityRemoved;

    public Boolean getIsPropertyBookQuantityRemoved()
    {
        return this.isPropertyBookQuantityRemoved;
    }

    public void setIsPropertyBookQuantityRemoved(Boolean removed)
    {
        this.isPropertyBookQuantityRemoved = removed;
    }

    private Boolean isPropertyCountedQuantityRemoved;

    public Boolean getIsPropertyCountedQuantityRemoved()
    {
        return this.isPropertyCountedQuantityRemoved;
    }

    public void setIsPropertyCountedQuantityRemoved(Boolean removed)
    {
        this.isPropertyCountedQuantityRemoved = removed;
    }

    private Boolean isPropertyProcessedRemoved;

    public Boolean getIsPropertyProcessedRemoved()
    {
        return this.isPropertyProcessedRemoved;
    }

    public void setIsPropertyProcessedRemoved(Boolean removed)
    {
        this.isPropertyProcessedRemoved = removed;
    }

    private Boolean isPropertyLineNumberRemoved;

    public Boolean getIsPropertyLineNumberRemoved()
    {
        return this.isPropertyLineNumberRemoved;
    }

    public void setIsPropertyLineNumberRemoved(Boolean removed)
    {
        this.isPropertyLineNumberRemoved = removed;
    }

    private Boolean isPropertyReversalLineNumberRemoved;

    public Boolean getIsPropertyReversalLineNumberRemoved()
    {
        return this.isPropertyReversalLineNumberRemoved;
    }

    public void setIsPropertyReversalLineNumberRemoved(Boolean removed)
    {
        this.isPropertyReversalLineNumberRemoved = removed;
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

    public void copyTo(AbstractPhysicalInventoryLineCommand.AbstractCreateOrMergePatchPhysicalInventoryLine command)
    {
        ((AbstractPhysicalInventoryLineCommandDto) this).copyTo(command);
        command.setBookQuantity(this.getBookQuantity());
        command.setCountedQuantity(this.getCountedQuantity());
        command.setProcessed(this.getProcessed());
        command.setLineNumber(this.getLineNumber());
        command.setReversalLineNumber(this.getReversalLineNumber());
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public PhysicalInventoryLineCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractPhysicalInventoryLineCommand.SimpleCreatePhysicalInventoryLine command = new AbstractPhysicalInventoryLineCommand.SimpleCreatePhysicalInventoryLine();
            copyTo((AbstractPhysicalInventoryLineCommand.AbstractCreatePhysicalInventoryLine) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractPhysicalInventoryLineCommand.SimpleMergePatchPhysicalInventoryLine command = new AbstractPhysicalInventoryLineCommand.SimpleMergePatchPhysicalInventoryLine();
            copyTo((AbstractPhysicalInventoryLineCommand.SimpleMergePatchPhysicalInventoryLine) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractPhysicalInventoryLineCommand.SimpleRemovePhysicalInventoryLine command = new AbstractPhysicalInventoryLineCommand.SimpleRemovePhysicalInventoryLine();
            ((AbstractPhysicalInventoryLineCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractPhysicalInventoryLineCommand.AbstractCreatePhysicalInventoryLine command)
    {
        copyTo((AbstractPhysicalInventoryLineCommand.AbstractCreateOrMergePatchPhysicalInventoryLine) command);
    }

    public void copyTo(AbstractPhysicalInventoryLineCommand.AbstractMergePatchPhysicalInventoryLine command)
    {
        copyTo((AbstractPhysicalInventoryLineCommand.AbstractCreateOrMergePatchPhysicalInventoryLine) command);
        command.setIsPropertyBookQuantityRemoved(this.getIsPropertyBookQuantityRemoved());
        command.setIsPropertyCountedQuantityRemoved(this.getIsPropertyCountedQuantityRemoved());
        command.setIsPropertyProcessedRemoved(this.getIsPropertyProcessedRemoved());
        command.setIsPropertyLineNumberRemoved(this.getIsPropertyLineNumberRemoved());
        command.setIsPropertyReversalLineNumberRemoved(this.getIsPropertyReversalLineNumberRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreatePhysicalInventoryLineDto extends CreateOrMergePatchPhysicalInventoryLineDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public PhysicalInventoryLineCommand.CreatePhysicalInventoryLine toCreatePhysicalInventoryLine()
        {
            return (PhysicalInventoryLineCommand.CreatePhysicalInventoryLine) toCommand();
        }

    }

    public static class MergePatchPhysicalInventoryLineDto extends CreateOrMergePatchPhysicalInventoryLineDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public PhysicalInventoryLineCommand.MergePatchPhysicalInventoryLine toMergePatchPhysicalInventoryLine()
        {
            return (PhysicalInventoryLineCommand.MergePatchPhysicalInventoryLine) toCommand();
        }

    }

}

