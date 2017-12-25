package org.dddml.wms.domain.movement;

import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchMovementDto extends AbstractMovementCommandDto
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

    private Date movementDate;

    public Date getMovementDate()
    {
        return this.movementDate;
    }

    public void setMovementDate(Date movementDate)
    {
        this.movementDate = movementDate;
    }

    private Boolean posted;

    public Boolean getPosted()
    {
        return this.posted;
    }

    public void setPosted(Boolean posted)
    {
        this.posted = posted;
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

    private Date dateReceived;

    public Date getDateReceived()
    {
        return this.dateReceived;
    }

    public void setDateReceived(Date dateReceived)
    {
        this.dateReceived = dateReceived;
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

    private Boolean isInTransit;

    public Boolean getIsInTransit()
    {
        return this.isInTransit;
    }

    public void setIsInTransit(Boolean isInTransit)
    {
        this.isInTransit = isInTransit;
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

    private String shipperId;

    public String getShipperId()
    {
        return this.shipperId;
    }

    public void setShipperId(String shipperId)
    {
        this.shipperId = shipperId;
    }

    private String salesRepresentativeId;

    public String getSalesRepresentativeId()
    {
        return this.salesRepresentativeId;
    }

    public void setSalesRepresentativeId(String salesRepresentativeId)
    {
        this.salesRepresentativeId = salesRepresentativeId;
    }

    private String businessPartnerId;

    public String getBusinessPartnerId()
    {
        return this.businessPartnerId;
    }

    public void setBusinessPartnerId(String businessPartnerId)
    {
        this.businessPartnerId = businessPartnerId;
    }

    private BigDecimal chargeAmount;

    public BigDecimal getChargeAmount()
    {
        return this.chargeAmount;
    }

    public void setChargeAmount(BigDecimal chargeAmount)
    {
        this.chargeAmount = chargeAmount;
    }

    private String createFrom;

    public String getCreateFrom()
    {
        return this.createFrom;
    }

    public void setCreateFrom(String createFrom)
    {
        this.createFrom = createFrom;
    }

    private BigDecimal freightAmount;

    public BigDecimal getFreightAmount()
    {
        return this.freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount)
    {
        this.freightAmount = freightAmount;
    }

    private String reversalDocumentNumber;

    public String getReversalDocumentNumber()
    {
        return this.reversalDocumentNumber;
    }

    public void setReversalDocumentNumber(String reversalDocumentNumber)
    {
        this.reversalDocumentNumber = reversalDocumentNumber;
    }

    private String warehouseIdFrom;

    public String getWarehouseIdFrom()
    {
        return this.warehouseIdFrom;
    }

    public void setWarehouseIdFrom(String warehouseIdFrom)
    {
        this.warehouseIdFrom = warehouseIdFrom;
    }

    private String warehouseIdTo;

    public String getWarehouseIdTo()
    {
        return this.warehouseIdTo;
    }

    public void setWarehouseIdTo(String warehouseIdTo)
    {
        this.warehouseIdTo = warehouseIdTo;
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

    private CreateOrMergePatchMovementLineDto[] movementLines;

    public CreateOrMergePatchMovementLineDto[] getMovementLines()
    {
        return this.movementLines;
    }

    public void setMovementLines(CreateOrMergePatchMovementLineDto[] movementLines)
    {
        this.movementLines = movementLines;
    }

    private Boolean isPropertyMovementDateRemoved;

    public Boolean getIsPropertyMovementDateRemoved()
    {
        return this.isPropertyMovementDateRemoved;
    }

    public void setIsPropertyMovementDateRemoved(Boolean removed)
    {
        this.isPropertyMovementDateRemoved = removed;
    }

    private Boolean isPropertyPostedRemoved;

    public Boolean getIsPropertyPostedRemoved()
    {
        return this.isPropertyPostedRemoved;
    }

    public void setIsPropertyPostedRemoved(Boolean removed)
    {
        this.isPropertyPostedRemoved = removed;
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

    private Boolean isPropertyDateReceivedRemoved;

    public Boolean getIsPropertyDateReceivedRemoved()
    {
        return this.isPropertyDateReceivedRemoved;
    }

    public void setIsPropertyDateReceivedRemoved(Boolean removed)
    {
        this.isPropertyDateReceivedRemoved = removed;
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

    private Boolean isPropertyIsInTransitRemoved;

    public Boolean getIsPropertyIsInTransitRemoved()
    {
        return this.isPropertyIsInTransitRemoved;
    }

    public void setIsPropertyIsInTransitRemoved(Boolean removed)
    {
        this.isPropertyIsInTransitRemoved = removed;
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

    private Boolean isPropertyShipperIdRemoved;

    public Boolean getIsPropertyShipperIdRemoved()
    {
        return this.isPropertyShipperIdRemoved;
    }

    public void setIsPropertyShipperIdRemoved(Boolean removed)
    {
        this.isPropertyShipperIdRemoved = removed;
    }

    private Boolean isPropertySalesRepresentativeIdRemoved;

    public Boolean getIsPropertySalesRepresentativeIdRemoved()
    {
        return this.isPropertySalesRepresentativeIdRemoved;
    }

    public void setIsPropertySalesRepresentativeIdRemoved(Boolean removed)
    {
        this.isPropertySalesRepresentativeIdRemoved = removed;
    }

    private Boolean isPropertyBusinessPartnerIdRemoved;

    public Boolean getIsPropertyBusinessPartnerIdRemoved()
    {
        return this.isPropertyBusinessPartnerIdRemoved;
    }

    public void setIsPropertyBusinessPartnerIdRemoved(Boolean removed)
    {
        this.isPropertyBusinessPartnerIdRemoved = removed;
    }

    private Boolean isPropertyChargeAmountRemoved;

    public Boolean getIsPropertyChargeAmountRemoved()
    {
        return this.isPropertyChargeAmountRemoved;
    }

    public void setIsPropertyChargeAmountRemoved(Boolean removed)
    {
        this.isPropertyChargeAmountRemoved = removed;
    }

    private Boolean isPropertyCreateFromRemoved;

    public Boolean getIsPropertyCreateFromRemoved()
    {
        return this.isPropertyCreateFromRemoved;
    }

    public void setIsPropertyCreateFromRemoved(Boolean removed)
    {
        this.isPropertyCreateFromRemoved = removed;
    }

    private Boolean isPropertyFreightAmountRemoved;

    public Boolean getIsPropertyFreightAmountRemoved()
    {
        return this.isPropertyFreightAmountRemoved;
    }

    public void setIsPropertyFreightAmountRemoved(Boolean removed)
    {
        this.isPropertyFreightAmountRemoved = removed;
    }

    private Boolean isPropertyReversalDocumentNumberRemoved;

    public Boolean getIsPropertyReversalDocumentNumberRemoved()
    {
        return this.isPropertyReversalDocumentNumberRemoved;
    }

    public void setIsPropertyReversalDocumentNumberRemoved(Boolean removed)
    {
        this.isPropertyReversalDocumentNumberRemoved = removed;
    }

    private Boolean isPropertyWarehouseIdFromRemoved;

    public Boolean getIsPropertyWarehouseIdFromRemoved()
    {
        return this.isPropertyWarehouseIdFromRemoved;
    }

    public void setIsPropertyWarehouseIdFromRemoved(Boolean removed)
    {
        this.isPropertyWarehouseIdFromRemoved = removed;
    }

    private Boolean isPropertyWarehouseIdToRemoved;

    public Boolean getIsPropertyWarehouseIdToRemoved()
    {
        return this.isPropertyWarehouseIdToRemoved;
    }

    public void setIsPropertyWarehouseIdToRemoved(Boolean removed)
    {
        this.isPropertyWarehouseIdToRemoved = removed;
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

    public void copyTo(AbstractMovementCommand.AbstractCreateOrMergePatchMovement command)
    {
        ((AbstractMovementCommandDto) this).copyTo(command);
        command.setDocumentAction(this.getDocumentAction());
        command.setMovementDate(this.getMovementDate());
        command.setPosted(this.getPosted());
        command.setProcessed(this.getProcessed());
        command.setProcessing(this.getProcessing());
        command.setDateReceived(this.getDateReceived());
        command.setDocumentTypeId(this.getDocumentTypeId());
        command.setIsInTransit(this.getIsInTransit());
        command.setIsApproved(this.getIsApproved());
        command.setApprovalAmount(this.getApprovalAmount());
        command.setShipperId(this.getShipperId());
        command.setSalesRepresentativeId(this.getSalesRepresentativeId());
        command.setBusinessPartnerId(this.getBusinessPartnerId());
        command.setChargeAmount(this.getChargeAmount());
        command.setCreateFrom(this.getCreateFrom());
        command.setFreightAmount(this.getFreightAmount());
        command.setReversalDocumentNumber(this.getReversalDocumentNumber());
        command.setWarehouseIdFrom(this.getWarehouseIdFrom());
        command.setWarehouseIdTo(this.getWarehouseIdTo());
        command.setDescription(this.getDescription());
        command.setActive(this.getActive());
    }

    public MovementCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractMovementCommand.SimpleCreateMovement command = new AbstractMovementCommand.SimpleCreateMovement();
            copyTo((AbstractMovementCommand.AbstractCreateMovement) command);
            if (this.getMovementLines() != null) {
                for (CreateOrMergePatchMovementLineDto cmd : this.getMovementLines()) {
                    command.getMovementLines().add((MovementLineCommand.CreateMovementLine) cmd.toCommand());
                }
            }
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractMovementCommand.SimpleMergePatchMovement command = new AbstractMovementCommand.SimpleMergePatchMovement();
            copyTo((AbstractMovementCommand.SimpleMergePatchMovement) command);
            if (this.getMovementLines() != null) {
                for (CreateOrMergePatchMovementLineDto cmd : this.getMovementLines()) {
                    command.getMovementLineCommands().add(cmd.toCommand());
                }
            }
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractMovementCommand.AbstractCreateMovement command)
    {
        copyTo((AbstractMovementCommand.AbstractCreateOrMergePatchMovement) command);
    }

    public void copyTo(AbstractMovementCommand.AbstractMergePatchMovement command)
    {
        copyTo((AbstractMovementCommand.AbstractCreateOrMergePatchMovement) command);
        command.setIsPropertyMovementDateRemoved(this.getIsPropertyMovementDateRemoved());
        command.setIsPropertyPostedRemoved(this.getIsPropertyPostedRemoved());
        command.setIsPropertyProcessedRemoved(this.getIsPropertyProcessedRemoved());
        command.setIsPropertyProcessingRemoved(this.getIsPropertyProcessingRemoved());
        command.setIsPropertyDateReceivedRemoved(this.getIsPropertyDateReceivedRemoved());
        command.setIsPropertyDocumentTypeIdRemoved(this.getIsPropertyDocumentTypeIdRemoved());
        command.setIsPropertyIsInTransitRemoved(this.getIsPropertyIsInTransitRemoved());
        command.setIsPropertyIsApprovedRemoved(this.getIsPropertyIsApprovedRemoved());
        command.setIsPropertyApprovalAmountRemoved(this.getIsPropertyApprovalAmountRemoved());
        command.setIsPropertyShipperIdRemoved(this.getIsPropertyShipperIdRemoved());
        command.setIsPropertySalesRepresentativeIdRemoved(this.getIsPropertySalesRepresentativeIdRemoved());
        command.setIsPropertyBusinessPartnerIdRemoved(this.getIsPropertyBusinessPartnerIdRemoved());
        command.setIsPropertyChargeAmountRemoved(this.getIsPropertyChargeAmountRemoved());
        command.setIsPropertyCreateFromRemoved(this.getIsPropertyCreateFromRemoved());
        command.setIsPropertyFreightAmountRemoved(this.getIsPropertyFreightAmountRemoved());
        command.setIsPropertyReversalDocumentNumberRemoved(this.getIsPropertyReversalDocumentNumberRemoved());
        command.setIsPropertyWarehouseIdFromRemoved(this.getIsPropertyWarehouseIdFromRemoved());
        command.setIsPropertyWarehouseIdToRemoved(this.getIsPropertyWarehouseIdToRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateMovementDto extends CreateOrMergePatchMovementDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public MovementCommand.CreateMovement toCreateMovement()
        {
            return (MovementCommand.CreateMovement) toCommand();
        }

    }

    public static class MergePatchMovementDto extends CreateOrMergePatchMovementDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public MovementCommand.MergePatchMovement toMergePatchMovement()
        {
            return (MovementCommand.MergePatchMovement) toCommand();
        }

    }

}

