package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractMovementConfirmationLineCommand extends AbstractCommand implements MovementConfirmationLineCommand
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

    private String movementConfirmationDocumentNumber;

    public String getMovementConfirmationDocumentNumber()
    {
        return this.movementConfirmationDocumentNumber;
    }

    public void setMovementConfirmationDocumentNumber(String movementConfirmationDocumentNumber)
    {
        this.movementConfirmationDocumentNumber = movementConfirmationDocumentNumber;
    }


    public static abstract class AbstractCreateOrMergePatchMovementConfirmationLine extends AbstractMovementConfirmationLineCommand implements CreateOrMergePatchMovementConfirmationLine
    {
        private String movementLineNumber;

        public String getMovementLineNumber()
        {
            return this.movementLineNumber;
        }

        public void setMovementLineNumber(String movementLineNumber)
        {
            this.movementLineNumber = movementLineNumber;
        }

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

        private String description;

        public String getDescription()
        {
            return this.description;
        }

        public void setDescription(String description)
        {
            this.description = description;
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

    public static abstract class AbstractCreateMovementConfirmationLine extends AbstractCreateOrMergePatchMovementConfirmationLine implements CreateMovementConfirmationLine
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchMovementConfirmationLine extends AbstractCreateOrMergePatchMovementConfirmationLine implements MergePatchMovementConfirmationLine
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyMovementLineNumberRemoved;

        public Boolean getIsPropertyMovementLineNumberRemoved()
        {
            return this.isPropertyMovementLineNumberRemoved;
        }

        public void setIsPropertyMovementLineNumberRemoved(Boolean removed)
        {
            this.isPropertyMovementLineNumberRemoved = removed;
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

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved()
        {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed)
        {
            this.isPropertyDescriptionRemoved = removed;
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

    public static class SimpleCreateMovementConfirmationLine extends AbstractCreateMovementConfirmationLine
    {
    }

    
    public static class SimpleMergePatchMovementConfirmationLine extends AbstractMergePatchMovementConfirmationLine
    {
    }

    
	public static class SimpleRemoveMovementConfirmationLine extends AbstractMovementConfirmationLineCommand implements RemoveMovementConfirmationLine
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_REMOVE;
        }
	}

    

}

