package org.dddml.wms.domain.movementconfirmationlinemvo;

import org.dddml.wms.domain.movementconfirmation.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchMovementConfirmationLineMvoDto extends AbstractMovementConfirmationLineMvoCommandDto
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    private String movementConfirmationDocumentStatusId;

    public String getMovementConfirmationDocumentStatusId()
    {
        return this.movementConfirmationDocumentStatusId;
    }

    public void setMovementConfirmationDocumentStatusId(String movementConfirmationDocumentStatusId)
    {
        this.movementConfirmationDocumentStatusId = movementConfirmationDocumentStatusId;
    }

    private String movementConfirmationMovementDocumentNumber;

    public String getMovementConfirmationMovementDocumentNumber()
    {
        return this.movementConfirmationMovementDocumentNumber;
    }

    public void setMovementConfirmationMovementDocumentNumber(String movementConfirmationMovementDocumentNumber)
    {
        this.movementConfirmationMovementDocumentNumber = movementConfirmationMovementDocumentNumber;
    }

    private Boolean movementConfirmationIsApproved;

    public Boolean getMovementConfirmationIsApproved()
    {
        return this.movementConfirmationIsApproved;
    }

    public void setMovementConfirmationIsApproved(Boolean movementConfirmationIsApproved)
    {
        this.movementConfirmationIsApproved = movementConfirmationIsApproved;
    }

    private BigDecimal movementConfirmationApprovalAmount;

    public BigDecimal getMovementConfirmationApprovalAmount()
    {
        return this.movementConfirmationApprovalAmount;
    }

    public void setMovementConfirmationApprovalAmount(BigDecimal movementConfirmationApprovalAmount)
    {
        this.movementConfirmationApprovalAmount = movementConfirmationApprovalAmount;
    }

    private Boolean movementConfirmationProcessed;

    public Boolean getMovementConfirmationProcessed()
    {
        return this.movementConfirmationProcessed;
    }

    public void setMovementConfirmationProcessed(Boolean movementConfirmationProcessed)
    {
        this.movementConfirmationProcessed = movementConfirmationProcessed;
    }

    private String movementConfirmationProcessing;

    public String getMovementConfirmationProcessing()
    {
        return this.movementConfirmationProcessing;
    }

    public void setMovementConfirmationProcessing(String movementConfirmationProcessing)
    {
        this.movementConfirmationProcessing = movementConfirmationProcessing;
    }

    private String movementConfirmationDocumentTypeId;

    public String getMovementConfirmationDocumentTypeId()
    {
        return this.movementConfirmationDocumentTypeId;
    }

    public void setMovementConfirmationDocumentTypeId(String movementConfirmationDocumentTypeId)
    {
        this.movementConfirmationDocumentTypeId = movementConfirmationDocumentTypeId;
    }

    private String movementConfirmationDescription;

    public String getMovementConfirmationDescription()
    {
        return this.movementConfirmationDescription;
    }

    public void setMovementConfirmationDescription(String movementConfirmationDescription)
    {
        this.movementConfirmationDescription = movementConfirmationDescription;
    }

    private String movementConfirmationCreatedBy;

    public String getMovementConfirmationCreatedBy()
    {
        return this.movementConfirmationCreatedBy;
    }

    public void setMovementConfirmationCreatedBy(String movementConfirmationCreatedBy)
    {
        this.movementConfirmationCreatedBy = movementConfirmationCreatedBy;
    }

    private Date movementConfirmationCreatedAt;

    public Date getMovementConfirmationCreatedAt()
    {
        return this.movementConfirmationCreatedAt;
    }

    public void setMovementConfirmationCreatedAt(Date movementConfirmationCreatedAt)
    {
        this.movementConfirmationCreatedAt = movementConfirmationCreatedAt;
    }

    private String movementConfirmationUpdatedBy;

    public String getMovementConfirmationUpdatedBy()
    {
        return this.movementConfirmationUpdatedBy;
    }

    public void setMovementConfirmationUpdatedBy(String movementConfirmationUpdatedBy)
    {
        this.movementConfirmationUpdatedBy = movementConfirmationUpdatedBy;
    }

    private Date movementConfirmationUpdatedAt;

    public Date getMovementConfirmationUpdatedAt()
    {
        return this.movementConfirmationUpdatedAt;
    }

    public void setMovementConfirmationUpdatedAt(Date movementConfirmationUpdatedAt)
    {
        this.movementConfirmationUpdatedAt = movementConfirmationUpdatedAt;
    }

    private Boolean movementConfirmationActive;

    public Boolean getMovementConfirmationActive()
    {
        return this.movementConfirmationActive;
    }

    public void setMovementConfirmationActive(Boolean movementConfirmationActive)
    {
        this.movementConfirmationActive = movementConfirmationActive;
    }

    private Boolean movementConfirmationDeleted;

    public Boolean getMovementConfirmationDeleted()
    {
        return this.movementConfirmationDeleted;
    }

    public void setMovementConfirmationDeleted(Boolean movementConfirmationDeleted)
    {
        this.movementConfirmationDeleted = movementConfirmationDeleted;
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

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved()
    {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed)
    {
        this.isPropertyVersionRemoved = removed;
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

    private Boolean isPropertyMovementConfirmationDocumentStatusIdRemoved;

    public Boolean getIsPropertyMovementConfirmationDocumentStatusIdRemoved()
    {
        return this.isPropertyMovementConfirmationDocumentStatusIdRemoved;
    }

    public void setIsPropertyMovementConfirmationDocumentStatusIdRemoved(Boolean removed)
    {
        this.isPropertyMovementConfirmationDocumentStatusIdRemoved = removed;
    }

    private Boolean isPropertyMovementConfirmationMovementDocumentNumberRemoved;

    public Boolean getIsPropertyMovementConfirmationMovementDocumentNumberRemoved()
    {
        return this.isPropertyMovementConfirmationMovementDocumentNumberRemoved;
    }

    public void setIsPropertyMovementConfirmationMovementDocumentNumberRemoved(Boolean removed)
    {
        this.isPropertyMovementConfirmationMovementDocumentNumberRemoved = removed;
    }

    private Boolean isPropertyMovementConfirmationIsApprovedRemoved;

    public Boolean getIsPropertyMovementConfirmationIsApprovedRemoved()
    {
        return this.isPropertyMovementConfirmationIsApprovedRemoved;
    }

    public void setIsPropertyMovementConfirmationIsApprovedRemoved(Boolean removed)
    {
        this.isPropertyMovementConfirmationIsApprovedRemoved = removed;
    }

    private Boolean isPropertyMovementConfirmationApprovalAmountRemoved;

    public Boolean getIsPropertyMovementConfirmationApprovalAmountRemoved()
    {
        return this.isPropertyMovementConfirmationApprovalAmountRemoved;
    }

    public void setIsPropertyMovementConfirmationApprovalAmountRemoved(Boolean removed)
    {
        this.isPropertyMovementConfirmationApprovalAmountRemoved = removed;
    }

    private Boolean isPropertyMovementConfirmationProcessedRemoved;

    public Boolean getIsPropertyMovementConfirmationProcessedRemoved()
    {
        return this.isPropertyMovementConfirmationProcessedRemoved;
    }

    public void setIsPropertyMovementConfirmationProcessedRemoved(Boolean removed)
    {
        this.isPropertyMovementConfirmationProcessedRemoved = removed;
    }

    private Boolean isPropertyMovementConfirmationProcessingRemoved;

    public Boolean getIsPropertyMovementConfirmationProcessingRemoved()
    {
        return this.isPropertyMovementConfirmationProcessingRemoved;
    }

    public void setIsPropertyMovementConfirmationProcessingRemoved(Boolean removed)
    {
        this.isPropertyMovementConfirmationProcessingRemoved = removed;
    }

    private Boolean isPropertyMovementConfirmationDocumentTypeIdRemoved;

    public Boolean getIsPropertyMovementConfirmationDocumentTypeIdRemoved()
    {
        return this.isPropertyMovementConfirmationDocumentTypeIdRemoved;
    }

    public void setIsPropertyMovementConfirmationDocumentTypeIdRemoved(Boolean removed)
    {
        this.isPropertyMovementConfirmationDocumentTypeIdRemoved = removed;
    }

    private Boolean isPropertyMovementConfirmationDescriptionRemoved;

    public Boolean getIsPropertyMovementConfirmationDescriptionRemoved()
    {
        return this.isPropertyMovementConfirmationDescriptionRemoved;
    }

    public void setIsPropertyMovementConfirmationDescriptionRemoved(Boolean removed)
    {
        this.isPropertyMovementConfirmationDescriptionRemoved = removed;
    }

    private Boolean isPropertyMovementConfirmationCreatedByRemoved;

    public Boolean getIsPropertyMovementConfirmationCreatedByRemoved()
    {
        return this.isPropertyMovementConfirmationCreatedByRemoved;
    }

    public void setIsPropertyMovementConfirmationCreatedByRemoved(Boolean removed)
    {
        this.isPropertyMovementConfirmationCreatedByRemoved = removed;
    }

    private Boolean isPropertyMovementConfirmationCreatedAtRemoved;

    public Boolean getIsPropertyMovementConfirmationCreatedAtRemoved()
    {
        return this.isPropertyMovementConfirmationCreatedAtRemoved;
    }

    public void setIsPropertyMovementConfirmationCreatedAtRemoved(Boolean removed)
    {
        this.isPropertyMovementConfirmationCreatedAtRemoved = removed;
    }

    private Boolean isPropertyMovementConfirmationUpdatedByRemoved;

    public Boolean getIsPropertyMovementConfirmationUpdatedByRemoved()
    {
        return this.isPropertyMovementConfirmationUpdatedByRemoved;
    }

    public void setIsPropertyMovementConfirmationUpdatedByRemoved(Boolean removed)
    {
        this.isPropertyMovementConfirmationUpdatedByRemoved = removed;
    }

    private Boolean isPropertyMovementConfirmationUpdatedAtRemoved;

    public Boolean getIsPropertyMovementConfirmationUpdatedAtRemoved()
    {
        return this.isPropertyMovementConfirmationUpdatedAtRemoved;
    }

    public void setIsPropertyMovementConfirmationUpdatedAtRemoved(Boolean removed)
    {
        this.isPropertyMovementConfirmationUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyMovementConfirmationActiveRemoved;

    public Boolean getIsPropertyMovementConfirmationActiveRemoved()
    {
        return this.isPropertyMovementConfirmationActiveRemoved;
    }

    public void setIsPropertyMovementConfirmationActiveRemoved(Boolean removed)
    {
        this.isPropertyMovementConfirmationActiveRemoved = removed;
    }

    private Boolean isPropertyMovementConfirmationDeletedRemoved;

    public Boolean getIsPropertyMovementConfirmationDeletedRemoved()
    {
        return this.isPropertyMovementConfirmationDeletedRemoved;
    }

    public void setIsPropertyMovementConfirmationDeletedRemoved(Boolean removed)
    {
        this.isPropertyMovementConfirmationDeletedRemoved = removed;
    }

    public void copyTo(AbstractMovementConfirmationLineMvoCommand.AbstractCreateOrMergePatchMovementConfirmationLineMvo command)
    {
        ((AbstractMovementConfirmationLineMvoCommandDto) this).copyTo(command);
        command.setMovementLineNumber(this.getMovementLineNumber());
        command.setTargetQuantity(this.getTargetQuantity());
        command.setConfirmedQuantity(this.getConfirmedQuantity());
        command.setDifferenceQuantity(this.getDifferenceQuantity());
        command.setScrappedQuantity(this.getScrappedQuantity());
        command.setDescription(this.getDescription());
        command.setProcessed(this.getProcessed());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setMovementConfirmationDocumentStatusId(this.getMovementConfirmationDocumentStatusId());
        command.setMovementConfirmationMovementDocumentNumber(this.getMovementConfirmationMovementDocumentNumber());
        command.setMovementConfirmationIsApproved(this.getMovementConfirmationIsApproved());
        command.setMovementConfirmationApprovalAmount(this.getMovementConfirmationApprovalAmount());
        command.setMovementConfirmationProcessed(this.getMovementConfirmationProcessed());
        command.setMovementConfirmationProcessing(this.getMovementConfirmationProcessing());
        command.setMovementConfirmationDocumentTypeId(this.getMovementConfirmationDocumentTypeId());
        command.setMovementConfirmationDescription(this.getMovementConfirmationDescription());
        command.setMovementConfirmationCreatedBy(this.getMovementConfirmationCreatedBy());
        command.setMovementConfirmationCreatedAt(this.getMovementConfirmationCreatedAt());
        command.setMovementConfirmationUpdatedBy(this.getMovementConfirmationUpdatedBy());
        command.setMovementConfirmationUpdatedAt(this.getMovementConfirmationUpdatedAt());
        command.setMovementConfirmationActive(this.getMovementConfirmationActive());
        command.setMovementConfirmationDeleted(this.getMovementConfirmationDeleted());
    }

    public MovementConfirmationLineMvoCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractMovementConfirmationLineMvoCommand.SimpleCreateMovementConfirmationLineMvo command = new AbstractMovementConfirmationLineMvoCommand.SimpleCreateMovementConfirmationLineMvo();
            copyTo((AbstractMovementConfirmationLineMvoCommand.AbstractCreateMovementConfirmationLineMvo) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractMovementConfirmationLineMvoCommand.SimpleMergePatchMovementConfirmationLineMvo command = new AbstractMovementConfirmationLineMvoCommand.SimpleMergePatchMovementConfirmationLineMvo();
            copyTo((AbstractMovementConfirmationLineMvoCommand.SimpleMergePatchMovementConfirmationLineMvo) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractMovementConfirmationLineMvoCommand.AbstractCreateMovementConfirmationLineMvo command)
    {
        copyTo((AbstractMovementConfirmationLineMvoCommand.AbstractCreateOrMergePatchMovementConfirmationLineMvo) command);
    }

    public void copyTo(AbstractMovementConfirmationLineMvoCommand.AbstractMergePatchMovementConfirmationLineMvo command)
    {
        copyTo((AbstractMovementConfirmationLineMvoCommand.AbstractCreateOrMergePatchMovementConfirmationLineMvo) command);
        command.setIsPropertyMovementLineNumberRemoved(this.getIsPropertyMovementLineNumberRemoved());
        command.setIsPropertyTargetQuantityRemoved(this.getIsPropertyTargetQuantityRemoved());
        command.setIsPropertyConfirmedQuantityRemoved(this.getIsPropertyConfirmedQuantityRemoved());
        command.setIsPropertyDifferenceQuantityRemoved(this.getIsPropertyDifferenceQuantityRemoved());
        command.setIsPropertyScrappedQuantityRemoved(this.getIsPropertyScrappedQuantityRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyProcessedRemoved(this.getIsPropertyProcessedRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyMovementConfirmationDocumentStatusIdRemoved(this.getIsPropertyMovementConfirmationDocumentStatusIdRemoved());
        command.setIsPropertyMovementConfirmationMovementDocumentNumberRemoved(this.getIsPropertyMovementConfirmationMovementDocumentNumberRemoved());
        command.setIsPropertyMovementConfirmationIsApprovedRemoved(this.getIsPropertyMovementConfirmationIsApprovedRemoved());
        command.setIsPropertyMovementConfirmationApprovalAmountRemoved(this.getIsPropertyMovementConfirmationApprovalAmountRemoved());
        command.setIsPropertyMovementConfirmationProcessedRemoved(this.getIsPropertyMovementConfirmationProcessedRemoved());
        command.setIsPropertyMovementConfirmationProcessingRemoved(this.getIsPropertyMovementConfirmationProcessingRemoved());
        command.setIsPropertyMovementConfirmationDocumentTypeIdRemoved(this.getIsPropertyMovementConfirmationDocumentTypeIdRemoved());
        command.setIsPropertyMovementConfirmationDescriptionRemoved(this.getIsPropertyMovementConfirmationDescriptionRemoved());
        command.setIsPropertyMovementConfirmationCreatedByRemoved(this.getIsPropertyMovementConfirmationCreatedByRemoved());
        command.setIsPropertyMovementConfirmationCreatedAtRemoved(this.getIsPropertyMovementConfirmationCreatedAtRemoved());
        command.setIsPropertyMovementConfirmationUpdatedByRemoved(this.getIsPropertyMovementConfirmationUpdatedByRemoved());
        command.setIsPropertyMovementConfirmationUpdatedAtRemoved(this.getIsPropertyMovementConfirmationUpdatedAtRemoved());
        command.setIsPropertyMovementConfirmationActiveRemoved(this.getIsPropertyMovementConfirmationActiveRemoved());
        command.setIsPropertyMovementConfirmationDeletedRemoved(this.getIsPropertyMovementConfirmationDeletedRemoved());
    }

    public static class CreateMovementConfirmationLineMvoDto extends CreateOrMergePatchMovementConfirmationLineMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo toCreateMovementConfirmationLineMvo()
        {
            return (MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo) toCommand();
        }

    }

    public static class MergePatchMovementConfirmationLineMvoDto extends CreateOrMergePatchMovementConfirmationLineMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo toMergePatchMovementConfirmationLineMvo()
        {
            return (MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo) toCommand();
        }

    }

}

