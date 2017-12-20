package org.dddml.wms.domain.movement;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractMovementLineCommand extends AbstractCommand implements MovementLineCommand
{
    private String lineNumber;

    public String getLineNumber()
    {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    private String movementDocumentNumber;

    public String getMovementDocumentNumber()
    {
        return this.movementDocumentNumber;
    }

    public void setMovementDocumentNumber(String movementDocumentNumber)
    {
        this.movementDocumentNumber = movementDocumentNumber;
    }


    public static abstract class AbstractCreateOrMergePatchMovementLine extends AbstractMovementLineCommand implements CreateOrMergePatchMovementLine
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

    }

    public static abstract class AbstractCreateMovementLine extends AbstractCreateOrMergePatchMovementLine implements CreateMovementLine
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchMovementLine extends AbstractCreateOrMergePatchMovementLine implements MergePatchMovementLine
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

    }

    public static class SimpleCreateMovementLine extends AbstractCreateMovementLine
    {
    }

    
    public static class SimpleMergePatchMovementLine extends AbstractMergePatchMovementLine
    {
    }

    
	public static class SimpleRemoveMovementLine extends AbstractMovementLineCommand implements RemoveMovementLine
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_REMOVE;
        }
	}

    

}

