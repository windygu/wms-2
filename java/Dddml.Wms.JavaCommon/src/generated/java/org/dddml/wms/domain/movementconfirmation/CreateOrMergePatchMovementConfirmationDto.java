package org.dddml.wms.domain.movementconfirmation;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchMovementConfirmationDto extends AbstractMovementConfirmationCommandDto
{
    /**
     * Movement Document Number
     */
    private String movementDocumentNumber;

    public String getMovementDocumentNumber()
    {
        return this.movementDocumentNumber;
    }

    public void setMovementDocumentNumber(String movementDocumentNumber)
    {
        this.movementDocumentNumber = movementDocumentNumber;
    }

    /**
     * Is Approved
     */
    private Boolean isApproved;

    public Boolean getIsApproved()
    {
        return this.isApproved;
    }

    public void setIsApproved(Boolean isApproved)
    {
        this.isApproved = isApproved;
    }

    /**
     * Approval Amount
     */
    private BigDecimal approvalAmount;

    public BigDecimal getApprovalAmount()
    {
        return this.approvalAmount;
    }

    public void setApprovalAmount(BigDecimal approvalAmount)
    {
        this.approvalAmount = approvalAmount;
    }

    /**
     * Processed
     */
    private Boolean processed;

    public Boolean getProcessed()
    {
        return this.processed;
    }

    public void setProcessed(Boolean processed)
    {
        this.processed = processed;
    }

    /**
     * Processing
     */
    private String processing;

    public String getProcessing()
    {
        return this.processing;
    }

    public void setProcessing(String processing)
    {
        this.processing = processing;
    }

    /**
     * Document Type Id
     */
    private String documentTypeId;

    public String getDocumentTypeId()
    {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId)
    {
        this.documentTypeId = documentTypeId;
    }

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

    private CreateOrMergePatchMovementConfirmationLineDto[] movementConfirmationLines;

    public CreateOrMergePatchMovementConfirmationLineDto[] getMovementConfirmationLines()
    {
        return this.movementConfirmationLines;
    }

    public void setMovementConfirmationLines(CreateOrMergePatchMovementConfirmationLineDto[] movementConfirmationLines)
    {
        this.movementConfirmationLines = movementConfirmationLines;
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

    public void copyTo(AbstractMovementConfirmationCommand.AbstractCreateOrMergePatchMovementConfirmation command)
    {
        ((AbstractMovementConfirmationCommandDto) this).copyTo(command);
        command.setMovementDocumentNumber(this.getMovementDocumentNumber());
        command.setIsApproved(this.getIsApproved());
        command.setApprovalAmount(this.getApprovalAmount());
        command.setProcessed(this.getProcessed());
        command.setProcessing(this.getProcessing());
        command.setDocumentTypeId(this.getDocumentTypeId());
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public MovementConfirmationCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractMovementConfirmationCommand.SimpleCreateMovementConfirmation command = new AbstractMovementConfirmationCommand.SimpleCreateMovementConfirmation();
            copyTo((AbstractMovementConfirmationCommand.AbstractCreateMovementConfirmation) command);
            if (this.getMovementConfirmationLines() != null) {
                for (CreateOrMergePatchMovementConfirmationLineDto cmd : this.getMovementConfirmationLines()) {
                    command.getMovementConfirmationLines().add((MovementConfirmationLineCommand.CreateMovementConfirmationLine) cmd.toCommand());
                }
            }
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractMovementConfirmationCommand.SimpleMergePatchMovementConfirmation command = new AbstractMovementConfirmationCommand.SimpleMergePatchMovementConfirmation();
            copyTo((AbstractMovementConfirmationCommand.SimpleMergePatchMovementConfirmation) command);
            if (this.getMovementConfirmationLines() != null) {
                for (CreateOrMergePatchMovementConfirmationLineDto cmd : this.getMovementConfirmationLines()) {
                    command.getMovementConfirmationLineCommands().add(cmd.toCommand());
                }
            }
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractMovementConfirmationCommand.AbstractCreateMovementConfirmation command)
    {
        copyTo((AbstractMovementConfirmationCommand.AbstractCreateOrMergePatchMovementConfirmation) command);
    }

    public void copyTo(AbstractMovementConfirmationCommand.AbstractMergePatchMovementConfirmation command)
    {
        copyTo((AbstractMovementConfirmationCommand.AbstractCreateOrMergePatchMovementConfirmation) command);
        command.setIsPropertyMovementDocumentNumberRemoved(this.getIsPropertyMovementDocumentNumberRemoved());
        command.setIsPropertyIsApprovedRemoved(this.getIsPropertyIsApprovedRemoved());
        command.setIsPropertyApprovalAmountRemoved(this.getIsPropertyApprovalAmountRemoved());
        command.setIsPropertyProcessedRemoved(this.getIsPropertyProcessedRemoved());
        command.setIsPropertyProcessingRemoved(this.getIsPropertyProcessingRemoved());
        command.setIsPropertyDocumentTypeIdRemoved(this.getIsPropertyDocumentTypeIdRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateMovementConfirmationDto extends CreateOrMergePatchMovementConfirmationDto
    {
        public CreateMovementConfirmationDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public MovementConfirmationCommand.CreateMovementConfirmation toCreateMovementConfirmation()
        {
            return (MovementConfirmationCommand.CreateMovementConfirmation) toCommand();
        }

    }

    public static class MergePatchMovementConfirmationDto extends CreateOrMergePatchMovementConfirmationDto
    {
        public MergePatchMovementConfirmationDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public MovementConfirmationCommand.MergePatchMovementConfirmation toMergePatchMovementConfirmation()
        {
            return (MovementConfirmationCommand.MergePatchMovementConfirmation) toCommand();
        }

    }

}

