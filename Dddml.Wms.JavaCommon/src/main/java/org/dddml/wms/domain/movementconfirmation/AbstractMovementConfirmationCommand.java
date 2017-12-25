package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractMovementConfirmationCommand extends AbstractCommand implements MovementConfirmationCommand
{
    private String documentNumber;

    public String getDocumentNumber()
    {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber)
    {
        this.documentNumber = documentNumber;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    public static abstract class AbstractCreateOrMergePatchMovementConfirmation extends AbstractMovementConfirmationCommand implements CreateOrMergePatchMovementConfirmation
    {
        private String documentAction;

        public String getDocumentAction()
        {
            return this.documentAction;
        }

        public void setDocumentAction(String documentAction)
        {
            this.documentAction = documentAction;
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

        private Boolean isApproved;

        public Boolean getIsApproved()
        {
            return this.isApproved;
        }

        public void setIsApproved(Boolean isApproved)
        {
            this.isApproved = isApproved;
        }

        private BigDecimal approvalAmount;

        public BigDecimal getApprovalAmount()
        {
            return this.approvalAmount;
        }

        public void setApprovalAmount(BigDecimal approvalAmount)
        {
            this.approvalAmount = approvalAmount;
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

        private String processing;

        public String getProcessing()
        {
            return this.processing;
        }

        public void setProcessing(String processing)
        {
            this.processing = processing;
        }

        private String documentTypeId;

        public String getDocumentTypeId()
        {
            return this.documentTypeId;
        }

        public void setDocumentTypeId(String documentTypeId)
        {
            this.documentTypeId = documentTypeId;
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

        public MovementConfirmationLineCommand.CreateMovementConfirmationLine newCreateMovementConfirmationLine()
        {
            AbstractMovementConfirmationLineCommand.SimpleCreateMovementConfirmationLine c = new AbstractMovementConfirmationLineCommand.SimpleCreateMovementConfirmationLine();
            c.setMovementConfirmationDocumentNumber(this.getDocumentNumber());

            return c;
        }

        public MovementConfirmationLineCommand.MergePatchMovementConfirmationLine newMergePatchMovementConfirmationLine()
        {
            AbstractMovementConfirmationLineCommand.SimpleMergePatchMovementConfirmationLine c = new AbstractMovementConfirmationLineCommand.SimpleMergePatchMovementConfirmationLine();
            c.setMovementConfirmationDocumentNumber(this.getDocumentNumber());

            return c;
        }

        public MovementConfirmationLineCommand.RemoveMovementConfirmationLine newRemoveMovementConfirmationLine()
        {
            AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine c = new AbstractMovementConfirmationLineCommand.SimpleRemoveMovementConfirmationLine();
            c.setMovementConfirmationDocumentNumber(this.getDocumentNumber());

            return c;
        }

    }

    public static abstract class AbstractCreateMovementConfirmation extends AbstractCreateOrMergePatchMovementConfirmation implements CreateMovementConfirmation
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

        private CreateMovementConfirmationLineCommands movementConfirmationLines = new SimpleCreateMovementConfirmationLineCommands();

        public CreateMovementConfirmationLineCommands getMovementConfirmationLines()
        {
            return this.movementConfirmationLines;
        }

    }

    public static abstract class AbstractMergePatchMovementConfirmation extends AbstractCreateOrMergePatchMovementConfirmation implements MergePatchMovementConfirmation
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyMovementDocumentNumberRemoved;

        public Boolean getIsPropertyMovementDocumentNumberRemoved()
        {
            return this.isPropertyMovementDocumentNumberRemoved;
        }

        public void setIsPropertyMovementDocumentNumberRemoved(Boolean removed)
        {
            this.isPropertyMovementDocumentNumberRemoved = removed;
        }

        private Boolean isPropertyIsApprovedRemoved;

        public Boolean getIsPropertyIsApprovedRemoved()
        {
            return this.isPropertyIsApprovedRemoved;
        }

        public void setIsPropertyIsApprovedRemoved(Boolean removed)
        {
            this.isPropertyIsApprovedRemoved = removed;
        }

        private Boolean isPropertyApprovalAmountRemoved;

        public Boolean getIsPropertyApprovalAmountRemoved()
        {
            return this.isPropertyApprovalAmountRemoved;
        }

        public void setIsPropertyApprovalAmountRemoved(Boolean removed)
        {
            this.isPropertyApprovalAmountRemoved = removed;
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

        private Boolean isPropertyProcessingRemoved;

        public Boolean getIsPropertyProcessingRemoved()
        {
            return this.isPropertyProcessingRemoved;
        }

        public void setIsPropertyProcessingRemoved(Boolean removed)
        {
            this.isPropertyProcessingRemoved = removed;
        }

        private Boolean isPropertyDocumentTypeIdRemoved;

        public Boolean getIsPropertyDocumentTypeIdRemoved()
        {
            return this.isPropertyDocumentTypeIdRemoved;
        }

        public void setIsPropertyDocumentTypeIdRemoved(Boolean removed)
        {
            this.isPropertyDocumentTypeIdRemoved = removed;
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

        private MovementConfirmationLineCommands movementConfirmationLineCommands = new SimpleMovementConfirmationLineCommands();

        public MovementConfirmationLineCommands getMovementConfirmationLineCommands()
        {
            return this.movementConfirmationLineCommands;
        }

    }

    public static class SimpleCreateMovementConfirmation extends AbstractCreateMovementConfirmation
    {
    }

    
    public static class SimpleMergePatchMovementConfirmation extends AbstractMergePatchMovementConfirmation
    {
    }

    
	public static class SimpleDeleteMovementConfirmation extends AbstractMovementConfirmationCommand implements DeleteMovementConfirmation
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    
    public static class SimpleCreateMovementConfirmationLineCommands implements CreateMovementConfirmationLineCommands
    {
        private List<MovementConfirmationLineCommand.CreateMovementConfirmationLine> innerCommands = new ArrayList<MovementConfirmationLineCommand.CreateMovementConfirmationLine>();

        public void add(MovementConfirmationLineCommand.CreateMovementConfirmationLine c)
        {
            innerCommands.add(c);
        }

        public void remove(MovementConfirmationLineCommand.CreateMovementConfirmationLine c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<MovementConfirmationLineCommand.CreateMovementConfirmationLine> iterator()
        {
            return innerCommands.iterator();
        }
    }

    public static class SimpleMovementConfirmationLineCommands implements MovementConfirmationLineCommands
    {
        private List<MovementConfirmationLineCommand> innerCommands = new ArrayList<MovementConfirmationLineCommand>();

        public void add(MovementConfirmationLineCommand c)
        {
            innerCommands.add(c);
        }

        public void remove(MovementConfirmationLineCommand c)
        {
            innerCommands.remove(c);
        }

        public void clear()
        {
            innerCommands.clear();
        }

        @Override
        public Iterator<MovementConfirmationLineCommand> iterator()
        {
            return innerCommands.iterator();
        }
    }


}

