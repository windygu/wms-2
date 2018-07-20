package org.dddml.wms.domain.movementlinemvo;

import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchMovementLineMvoDto extends AbstractMovementLineMvoCommandDto
{
    /**
     * The Movement Quantity indicates the quantity of a product that has been moved.
     */
    private BigDecimal movementQuantity;

    public BigDecimal getMovementQuantity()
    {
        return this.movementQuantity;
    }

    public void setMovementQuantity(BigDecimal movementQuantity)
    {
        this.movementQuantity = movementQuantity;
    }

    /**
     * Product Id
     */
    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    /**
     * Locator Id From
     */
    private String locatorIdFrom;

    public String getLocatorIdFrom()
    {
        return this.locatorIdFrom;
    }

    public void setLocatorIdFrom(String locatorIdFrom)
    {
        this.locatorIdFrom = locatorIdFrom;
    }

    /**
     * Locator Id To
     */
    private String locatorIdTo;

    public String getLocatorIdTo()
    {
        return this.locatorIdTo;
    }

    public void setLocatorIdTo(String locatorIdTo)
    {
        this.locatorIdTo = locatorIdTo;
    }

    /**
     * Attribute Set Instance Id
     */
    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
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
     * Reversal Line Number
     */
    private String reversalLineNumber;

    public String getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(String reversalLineNumber)
    {
        this.reversalLineNumber = reversalLineNumber;
    }

    /**
     * Version
     */
    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    /**
     * Movement Document Status Id
     */
    private String movementDocumentStatusId;

    public String getMovementDocumentStatusId()
    {
        return this.movementDocumentStatusId;
    }

    public void setMovementDocumentStatusId(String movementDocumentStatusId)
    {
        this.movementDocumentStatusId = movementDocumentStatusId;
    }

    /**
     * Movement Movement Date
     */
    private Date movementMovementDate;

    public Date getMovementMovementDate()
    {
        return this.movementMovementDate;
    }

    public void setMovementMovementDate(Date movementMovementDate)
    {
        this.movementMovementDate = movementMovementDate;
    }

    /**
     * Movement Posted
     */
    private Boolean movementPosted;

    public Boolean getMovementPosted()
    {
        return this.movementPosted;
    }

    public void setMovementPosted(Boolean movementPosted)
    {
        this.movementPosted = movementPosted;
    }

    /**
     * Movement Processed
     */
    private Boolean movementProcessed;

    public Boolean getMovementProcessed()
    {
        return this.movementProcessed;
    }

    public void setMovementProcessed(Boolean movementProcessed)
    {
        this.movementProcessed = movementProcessed;
    }

    /**
     * Movement Processing
     */
    private String movementProcessing;

    public String getMovementProcessing()
    {
        return this.movementProcessing;
    }

    public void setMovementProcessing(String movementProcessing)
    {
        this.movementProcessing = movementProcessing;
    }

    /**
     * Movement Date Received
     */
    private Date movementDateReceived;

    public Date getMovementDateReceived()
    {
        return this.movementDateReceived;
    }

    public void setMovementDateReceived(Date movementDateReceived)
    {
        this.movementDateReceived = movementDateReceived;
    }

    /**
     * Movement Document Type Id
     */
    private String movementDocumentTypeId;

    public String getMovementDocumentTypeId()
    {
        return this.movementDocumentTypeId;
    }

    public void setMovementDocumentTypeId(String movementDocumentTypeId)
    {
        this.movementDocumentTypeId = movementDocumentTypeId;
    }

    /**
     * Movement Is In Transit
     */
    private Boolean movementIsInTransit;

    public Boolean getMovementIsInTransit()
    {
        return this.movementIsInTransit;
    }

    public void setMovementIsInTransit(Boolean movementIsInTransit)
    {
        this.movementIsInTransit = movementIsInTransit;
    }

    /**
     * Movement Is Approved
     */
    private Boolean movementIsApproved;

    public Boolean getMovementIsApproved()
    {
        return this.movementIsApproved;
    }

    public void setMovementIsApproved(Boolean movementIsApproved)
    {
        this.movementIsApproved = movementIsApproved;
    }

    /**
     * Movement Approval Amount
     */
    private BigDecimal movementApprovalAmount;

    public BigDecimal getMovementApprovalAmount()
    {
        return this.movementApprovalAmount;
    }

    public void setMovementApprovalAmount(BigDecimal movementApprovalAmount)
    {
        this.movementApprovalAmount = movementApprovalAmount;
    }

    /**
     * Movement Shipper Id
     */
    private String movementShipperId;

    public String getMovementShipperId()
    {
        return this.movementShipperId;
    }

    public void setMovementShipperId(String movementShipperId)
    {
        this.movementShipperId = movementShipperId;
    }

    /**
     * Movement Sales Representative Id
     */
    private String movementSalesRepresentativeId;

    public String getMovementSalesRepresentativeId()
    {
        return this.movementSalesRepresentativeId;
    }

    public void setMovementSalesRepresentativeId(String movementSalesRepresentativeId)
    {
        this.movementSalesRepresentativeId = movementSalesRepresentativeId;
    }

    /**
     * Movement Business Partner Id
     */
    private String movementBusinessPartnerId;

    public String getMovementBusinessPartnerId()
    {
        return this.movementBusinessPartnerId;
    }

    public void setMovementBusinessPartnerId(String movementBusinessPartnerId)
    {
        this.movementBusinessPartnerId = movementBusinessPartnerId;
    }

    /**
     * Movement Charge Amount
     */
    private BigDecimal movementChargeAmount;

    public BigDecimal getMovementChargeAmount()
    {
        return this.movementChargeAmount;
    }

    public void setMovementChargeAmount(BigDecimal movementChargeAmount)
    {
        this.movementChargeAmount = movementChargeAmount;
    }

    /**
     * Movement Create From
     */
    private String movementCreateFrom;

    public String getMovementCreateFrom()
    {
        return this.movementCreateFrom;
    }

    public void setMovementCreateFrom(String movementCreateFrom)
    {
        this.movementCreateFrom = movementCreateFrom;
    }

    /**
     * Movement Freight Amount
     */
    private BigDecimal movementFreightAmount;

    public BigDecimal getMovementFreightAmount()
    {
        return this.movementFreightAmount;
    }

    public void setMovementFreightAmount(BigDecimal movementFreightAmount)
    {
        this.movementFreightAmount = movementFreightAmount;
    }

    /**
     * Movement Reversal Document Number
     */
    private String movementReversalDocumentNumber;

    public String getMovementReversalDocumentNumber()
    {
        return this.movementReversalDocumentNumber;
    }

    public void setMovementReversalDocumentNumber(String movementReversalDocumentNumber)
    {
        this.movementReversalDocumentNumber = movementReversalDocumentNumber;
    }

    /**
     * Movement Warehouse Id From
     */
    private String movementWarehouseIdFrom;

    public String getMovementWarehouseIdFrom()
    {
        return this.movementWarehouseIdFrom;
    }

    public void setMovementWarehouseIdFrom(String movementWarehouseIdFrom)
    {
        this.movementWarehouseIdFrom = movementWarehouseIdFrom;
    }

    /**
     * Movement Warehouse Id To
     */
    private String movementWarehouseIdTo;

    public String getMovementWarehouseIdTo()
    {
        return this.movementWarehouseIdTo;
    }

    public void setMovementWarehouseIdTo(String movementWarehouseIdTo)
    {
        this.movementWarehouseIdTo = movementWarehouseIdTo;
    }

    /**
     * Movement Description
     */
    private String movementDescription;

    public String getMovementDescription()
    {
        return this.movementDescription;
    }

    public void setMovementDescription(String movementDescription)
    {
        this.movementDescription = movementDescription;
    }

    /**
     * Movement Created By
     */
    private String movementCreatedBy;

    public String getMovementCreatedBy()
    {
        return this.movementCreatedBy;
    }

    public void setMovementCreatedBy(String movementCreatedBy)
    {
        this.movementCreatedBy = movementCreatedBy;
    }

    /**
     * Movement Created At
     */
    private Date movementCreatedAt;

    public Date getMovementCreatedAt()
    {
        return this.movementCreatedAt;
    }

    public void setMovementCreatedAt(Date movementCreatedAt)
    {
        this.movementCreatedAt = movementCreatedAt;
    }

    /**
     * Movement Updated By
     */
    private String movementUpdatedBy;

    public String getMovementUpdatedBy()
    {
        return this.movementUpdatedBy;
    }

    public void setMovementUpdatedBy(String movementUpdatedBy)
    {
        this.movementUpdatedBy = movementUpdatedBy;
    }

    /**
     * Movement Updated At
     */
    private Date movementUpdatedAt;

    public Date getMovementUpdatedAt()
    {
        return this.movementUpdatedAt;
    }

    public void setMovementUpdatedAt(Date movementUpdatedAt)
    {
        this.movementUpdatedAt = movementUpdatedAt;
    }

    /**
     * Movement Active
     */
    private Boolean movementActive;

    public Boolean getMovementActive()
    {
        return this.movementActive;
    }

    public void setMovementActive(Boolean movementActive)
    {
        this.movementActive = movementActive;
    }

    /**
     * Movement Deleted
     */
    private Boolean movementDeleted;

    public Boolean getMovementDeleted()
    {
        return this.movementDeleted;
    }

    public void setMovementDeleted(Boolean movementDeleted)
    {
        this.movementDeleted = movementDeleted;
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

    private Boolean isPropertyProductIdRemoved;

    public Boolean getIsPropertyProductIdRemoved()
    {
        return this.isPropertyProductIdRemoved;
    }

    public void setIsPropertyProductIdRemoved(Boolean removed)
    {
        this.isPropertyProductIdRemoved = removed;
    }

    private Boolean isPropertyLocatorIdFromRemoved;

    public Boolean getIsPropertyLocatorIdFromRemoved()
    {
        return this.isPropertyLocatorIdFromRemoved;
    }

    public void setIsPropertyLocatorIdFromRemoved(Boolean removed)
    {
        this.isPropertyLocatorIdFromRemoved = removed;
    }

    private Boolean isPropertyLocatorIdToRemoved;

    public Boolean getIsPropertyLocatorIdToRemoved()
    {
        return this.isPropertyLocatorIdToRemoved;
    }

    public void setIsPropertyLocatorIdToRemoved(Boolean removed)
    {
        this.isPropertyLocatorIdToRemoved = removed;
    }

    private Boolean isPropertyAttributeSetInstanceIdRemoved;

    public Boolean getIsPropertyAttributeSetInstanceIdRemoved()
    {
        return this.isPropertyAttributeSetInstanceIdRemoved;
    }

    public void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed)
    {
        this.isPropertyAttributeSetInstanceIdRemoved = removed;
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

    private Boolean isPropertyReversalLineNumberRemoved;

    public Boolean getIsPropertyReversalLineNumberRemoved()
    {
        return this.isPropertyReversalLineNumberRemoved;
    }

    public void setIsPropertyReversalLineNumberRemoved(Boolean removed)
    {
        this.isPropertyReversalLineNumberRemoved = removed;
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

    private Boolean isPropertyMovementDocumentStatusIdRemoved;

    public Boolean getIsPropertyMovementDocumentStatusIdRemoved()
    {
        return this.isPropertyMovementDocumentStatusIdRemoved;
    }

    public void setIsPropertyMovementDocumentStatusIdRemoved(Boolean removed)
    {
        this.isPropertyMovementDocumentStatusIdRemoved = removed;
    }

    private Boolean isPropertyMovementMovementDateRemoved;

    public Boolean getIsPropertyMovementMovementDateRemoved()
    {
        return this.isPropertyMovementMovementDateRemoved;
    }

    public void setIsPropertyMovementMovementDateRemoved(Boolean removed)
    {
        this.isPropertyMovementMovementDateRemoved = removed;
    }

    private Boolean isPropertyMovementPostedRemoved;

    public Boolean getIsPropertyMovementPostedRemoved()
    {
        return this.isPropertyMovementPostedRemoved;
    }

    public void setIsPropertyMovementPostedRemoved(Boolean removed)
    {
        this.isPropertyMovementPostedRemoved = removed;
    }

    private Boolean isPropertyMovementProcessedRemoved;

    public Boolean getIsPropertyMovementProcessedRemoved()
    {
        return this.isPropertyMovementProcessedRemoved;
    }

    public void setIsPropertyMovementProcessedRemoved(Boolean removed)
    {
        this.isPropertyMovementProcessedRemoved = removed;
    }

    private Boolean isPropertyMovementProcessingRemoved;

    public Boolean getIsPropertyMovementProcessingRemoved()
    {
        return this.isPropertyMovementProcessingRemoved;
    }

    public void setIsPropertyMovementProcessingRemoved(Boolean removed)
    {
        this.isPropertyMovementProcessingRemoved = removed;
    }

    private Boolean isPropertyMovementDateReceivedRemoved;

    public Boolean getIsPropertyMovementDateReceivedRemoved()
    {
        return this.isPropertyMovementDateReceivedRemoved;
    }

    public void setIsPropertyMovementDateReceivedRemoved(Boolean removed)
    {
        this.isPropertyMovementDateReceivedRemoved = removed;
    }

    private Boolean isPropertyMovementDocumentTypeIdRemoved;

    public Boolean getIsPropertyMovementDocumentTypeIdRemoved()
    {
        return this.isPropertyMovementDocumentTypeIdRemoved;
    }

    public void setIsPropertyMovementDocumentTypeIdRemoved(Boolean removed)
    {
        this.isPropertyMovementDocumentTypeIdRemoved = removed;
    }

    private Boolean isPropertyMovementIsInTransitRemoved;

    public Boolean getIsPropertyMovementIsInTransitRemoved()
    {
        return this.isPropertyMovementIsInTransitRemoved;
    }

    public void setIsPropertyMovementIsInTransitRemoved(Boolean removed)
    {
        this.isPropertyMovementIsInTransitRemoved = removed;
    }

    private Boolean isPropertyMovementIsApprovedRemoved;

    public Boolean getIsPropertyMovementIsApprovedRemoved()
    {
        return this.isPropertyMovementIsApprovedRemoved;
    }

    public void setIsPropertyMovementIsApprovedRemoved(Boolean removed)
    {
        this.isPropertyMovementIsApprovedRemoved = removed;
    }

    private Boolean isPropertyMovementApprovalAmountRemoved;

    public Boolean getIsPropertyMovementApprovalAmountRemoved()
    {
        return this.isPropertyMovementApprovalAmountRemoved;
    }

    public void setIsPropertyMovementApprovalAmountRemoved(Boolean removed)
    {
        this.isPropertyMovementApprovalAmountRemoved = removed;
    }

    private Boolean isPropertyMovementShipperIdRemoved;

    public Boolean getIsPropertyMovementShipperIdRemoved()
    {
        return this.isPropertyMovementShipperIdRemoved;
    }

    public void setIsPropertyMovementShipperIdRemoved(Boolean removed)
    {
        this.isPropertyMovementShipperIdRemoved = removed;
    }

    private Boolean isPropertyMovementSalesRepresentativeIdRemoved;

    public Boolean getIsPropertyMovementSalesRepresentativeIdRemoved()
    {
        return this.isPropertyMovementSalesRepresentativeIdRemoved;
    }

    public void setIsPropertyMovementSalesRepresentativeIdRemoved(Boolean removed)
    {
        this.isPropertyMovementSalesRepresentativeIdRemoved = removed;
    }

    private Boolean isPropertyMovementBusinessPartnerIdRemoved;

    public Boolean getIsPropertyMovementBusinessPartnerIdRemoved()
    {
        return this.isPropertyMovementBusinessPartnerIdRemoved;
    }

    public void setIsPropertyMovementBusinessPartnerIdRemoved(Boolean removed)
    {
        this.isPropertyMovementBusinessPartnerIdRemoved = removed;
    }

    private Boolean isPropertyMovementChargeAmountRemoved;

    public Boolean getIsPropertyMovementChargeAmountRemoved()
    {
        return this.isPropertyMovementChargeAmountRemoved;
    }

    public void setIsPropertyMovementChargeAmountRemoved(Boolean removed)
    {
        this.isPropertyMovementChargeAmountRemoved = removed;
    }

    private Boolean isPropertyMovementCreateFromRemoved;

    public Boolean getIsPropertyMovementCreateFromRemoved()
    {
        return this.isPropertyMovementCreateFromRemoved;
    }

    public void setIsPropertyMovementCreateFromRemoved(Boolean removed)
    {
        this.isPropertyMovementCreateFromRemoved = removed;
    }

    private Boolean isPropertyMovementFreightAmountRemoved;

    public Boolean getIsPropertyMovementFreightAmountRemoved()
    {
        return this.isPropertyMovementFreightAmountRemoved;
    }

    public void setIsPropertyMovementFreightAmountRemoved(Boolean removed)
    {
        this.isPropertyMovementFreightAmountRemoved = removed;
    }

    private Boolean isPropertyMovementReversalDocumentNumberRemoved;

    public Boolean getIsPropertyMovementReversalDocumentNumberRemoved()
    {
        return this.isPropertyMovementReversalDocumentNumberRemoved;
    }

    public void setIsPropertyMovementReversalDocumentNumberRemoved(Boolean removed)
    {
        this.isPropertyMovementReversalDocumentNumberRemoved = removed;
    }

    private Boolean isPropertyMovementWarehouseIdFromRemoved;

    public Boolean getIsPropertyMovementWarehouseIdFromRemoved()
    {
        return this.isPropertyMovementWarehouseIdFromRemoved;
    }

    public void setIsPropertyMovementWarehouseIdFromRemoved(Boolean removed)
    {
        this.isPropertyMovementWarehouseIdFromRemoved = removed;
    }

    private Boolean isPropertyMovementWarehouseIdToRemoved;

    public Boolean getIsPropertyMovementWarehouseIdToRemoved()
    {
        return this.isPropertyMovementWarehouseIdToRemoved;
    }

    public void setIsPropertyMovementWarehouseIdToRemoved(Boolean removed)
    {
        this.isPropertyMovementWarehouseIdToRemoved = removed;
    }

    private Boolean isPropertyMovementDescriptionRemoved;

    public Boolean getIsPropertyMovementDescriptionRemoved()
    {
        return this.isPropertyMovementDescriptionRemoved;
    }

    public void setIsPropertyMovementDescriptionRemoved(Boolean removed)
    {
        this.isPropertyMovementDescriptionRemoved = removed;
    }

    private Boolean isPropertyMovementCreatedByRemoved;

    public Boolean getIsPropertyMovementCreatedByRemoved()
    {
        return this.isPropertyMovementCreatedByRemoved;
    }

    public void setIsPropertyMovementCreatedByRemoved(Boolean removed)
    {
        this.isPropertyMovementCreatedByRemoved = removed;
    }

    private Boolean isPropertyMovementCreatedAtRemoved;

    public Boolean getIsPropertyMovementCreatedAtRemoved()
    {
        return this.isPropertyMovementCreatedAtRemoved;
    }

    public void setIsPropertyMovementCreatedAtRemoved(Boolean removed)
    {
        this.isPropertyMovementCreatedAtRemoved = removed;
    }

    private Boolean isPropertyMovementUpdatedByRemoved;

    public Boolean getIsPropertyMovementUpdatedByRemoved()
    {
        return this.isPropertyMovementUpdatedByRemoved;
    }

    public void setIsPropertyMovementUpdatedByRemoved(Boolean removed)
    {
        this.isPropertyMovementUpdatedByRemoved = removed;
    }

    private Boolean isPropertyMovementUpdatedAtRemoved;

    public Boolean getIsPropertyMovementUpdatedAtRemoved()
    {
        return this.isPropertyMovementUpdatedAtRemoved;
    }

    public void setIsPropertyMovementUpdatedAtRemoved(Boolean removed)
    {
        this.isPropertyMovementUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyMovementActiveRemoved;

    public Boolean getIsPropertyMovementActiveRemoved()
    {
        return this.isPropertyMovementActiveRemoved;
    }

    public void setIsPropertyMovementActiveRemoved(Boolean removed)
    {
        this.isPropertyMovementActiveRemoved = removed;
    }

    private Boolean isPropertyMovementDeletedRemoved;

    public Boolean getIsPropertyMovementDeletedRemoved()
    {
        return this.isPropertyMovementDeletedRemoved;
    }

    public void setIsPropertyMovementDeletedRemoved(Boolean removed)
    {
        this.isPropertyMovementDeletedRemoved = removed;
    }

    public void copyTo(AbstractMovementLineMvoCommand.AbstractCreateOrMergePatchMovementLineMvo command)
    {
        ((AbstractMovementLineMvoCommandDto) this).copyTo(command);
        command.setMovementQuantity(this.getMovementQuantity());
        command.setProductId(this.getProductId());
        command.setLocatorIdFrom(this.getLocatorIdFrom());
        command.setLocatorIdTo(this.getLocatorIdTo());
        command.setAttributeSetInstanceId(this.getAttributeSetInstanceId());
        command.setProcessed(this.getProcessed());
        command.setReversalLineNumber(this.getReversalLineNumber());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setMovementDocumentStatusId(this.getMovementDocumentStatusId());
        command.setMovementMovementDate(this.getMovementMovementDate());
        command.setMovementPosted(this.getMovementPosted());
        command.setMovementProcessed(this.getMovementProcessed());
        command.setMovementProcessing(this.getMovementProcessing());
        command.setMovementDateReceived(this.getMovementDateReceived());
        command.setMovementDocumentTypeId(this.getMovementDocumentTypeId());
        command.setMovementIsInTransit(this.getMovementIsInTransit());
        command.setMovementIsApproved(this.getMovementIsApproved());
        command.setMovementApprovalAmount(this.getMovementApprovalAmount());
        command.setMovementShipperId(this.getMovementShipperId());
        command.setMovementSalesRepresentativeId(this.getMovementSalesRepresentativeId());
        command.setMovementBusinessPartnerId(this.getMovementBusinessPartnerId());
        command.setMovementChargeAmount(this.getMovementChargeAmount());
        command.setMovementCreateFrom(this.getMovementCreateFrom());
        command.setMovementFreightAmount(this.getMovementFreightAmount());
        command.setMovementReversalDocumentNumber(this.getMovementReversalDocumentNumber());
        command.setMovementWarehouseIdFrom(this.getMovementWarehouseIdFrom());
        command.setMovementWarehouseIdTo(this.getMovementWarehouseIdTo());
        command.setMovementDescription(this.getMovementDescription());
        command.setMovementCreatedBy(this.getMovementCreatedBy());
        command.setMovementCreatedAt(this.getMovementCreatedAt());
        command.setMovementUpdatedBy(this.getMovementUpdatedBy());
        command.setMovementUpdatedAt(this.getMovementUpdatedAt());
        command.setMovementActive(this.getMovementActive());
        command.setMovementDeleted(this.getMovementDeleted());
    }

    public MovementLineMvoCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractMovementLineMvoCommand.SimpleCreateMovementLineMvo command = new AbstractMovementLineMvoCommand.SimpleCreateMovementLineMvo();
            copyTo((AbstractMovementLineMvoCommand.AbstractCreateMovementLineMvo) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractMovementLineMvoCommand.SimpleMergePatchMovementLineMvo command = new AbstractMovementLineMvoCommand.SimpleMergePatchMovementLineMvo();
            copyTo((AbstractMovementLineMvoCommand.SimpleMergePatchMovementLineMvo) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractMovementLineMvoCommand.AbstractCreateMovementLineMvo command)
    {
        copyTo((AbstractMovementLineMvoCommand.AbstractCreateOrMergePatchMovementLineMvo) command);
    }

    public void copyTo(AbstractMovementLineMvoCommand.AbstractMergePatchMovementLineMvo command)
    {
        copyTo((AbstractMovementLineMvoCommand.AbstractCreateOrMergePatchMovementLineMvo) command);
        command.setIsPropertyMovementQuantityRemoved(this.getIsPropertyMovementQuantityRemoved());
        command.setIsPropertyProductIdRemoved(this.getIsPropertyProductIdRemoved());
        command.setIsPropertyLocatorIdFromRemoved(this.getIsPropertyLocatorIdFromRemoved());
        command.setIsPropertyLocatorIdToRemoved(this.getIsPropertyLocatorIdToRemoved());
        command.setIsPropertyAttributeSetInstanceIdRemoved(this.getIsPropertyAttributeSetInstanceIdRemoved());
        command.setIsPropertyProcessedRemoved(this.getIsPropertyProcessedRemoved());
        command.setIsPropertyReversalLineNumberRemoved(this.getIsPropertyReversalLineNumberRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyMovementDocumentStatusIdRemoved(this.getIsPropertyMovementDocumentStatusIdRemoved());
        command.setIsPropertyMovementMovementDateRemoved(this.getIsPropertyMovementMovementDateRemoved());
        command.setIsPropertyMovementPostedRemoved(this.getIsPropertyMovementPostedRemoved());
        command.setIsPropertyMovementProcessedRemoved(this.getIsPropertyMovementProcessedRemoved());
        command.setIsPropertyMovementProcessingRemoved(this.getIsPropertyMovementProcessingRemoved());
        command.setIsPropertyMovementDateReceivedRemoved(this.getIsPropertyMovementDateReceivedRemoved());
        command.setIsPropertyMovementDocumentTypeIdRemoved(this.getIsPropertyMovementDocumentTypeIdRemoved());
        command.setIsPropertyMovementIsInTransitRemoved(this.getIsPropertyMovementIsInTransitRemoved());
        command.setIsPropertyMovementIsApprovedRemoved(this.getIsPropertyMovementIsApprovedRemoved());
        command.setIsPropertyMovementApprovalAmountRemoved(this.getIsPropertyMovementApprovalAmountRemoved());
        command.setIsPropertyMovementShipperIdRemoved(this.getIsPropertyMovementShipperIdRemoved());
        command.setIsPropertyMovementSalesRepresentativeIdRemoved(this.getIsPropertyMovementSalesRepresentativeIdRemoved());
        command.setIsPropertyMovementBusinessPartnerIdRemoved(this.getIsPropertyMovementBusinessPartnerIdRemoved());
        command.setIsPropertyMovementChargeAmountRemoved(this.getIsPropertyMovementChargeAmountRemoved());
        command.setIsPropertyMovementCreateFromRemoved(this.getIsPropertyMovementCreateFromRemoved());
        command.setIsPropertyMovementFreightAmountRemoved(this.getIsPropertyMovementFreightAmountRemoved());
        command.setIsPropertyMovementReversalDocumentNumberRemoved(this.getIsPropertyMovementReversalDocumentNumberRemoved());
        command.setIsPropertyMovementWarehouseIdFromRemoved(this.getIsPropertyMovementWarehouseIdFromRemoved());
        command.setIsPropertyMovementWarehouseIdToRemoved(this.getIsPropertyMovementWarehouseIdToRemoved());
        command.setIsPropertyMovementDescriptionRemoved(this.getIsPropertyMovementDescriptionRemoved());
        command.setIsPropertyMovementCreatedByRemoved(this.getIsPropertyMovementCreatedByRemoved());
        command.setIsPropertyMovementCreatedAtRemoved(this.getIsPropertyMovementCreatedAtRemoved());
        command.setIsPropertyMovementUpdatedByRemoved(this.getIsPropertyMovementUpdatedByRemoved());
        command.setIsPropertyMovementUpdatedAtRemoved(this.getIsPropertyMovementUpdatedAtRemoved());
        command.setIsPropertyMovementActiveRemoved(this.getIsPropertyMovementActiveRemoved());
        command.setIsPropertyMovementDeletedRemoved(this.getIsPropertyMovementDeletedRemoved());
    }

    public static class CreateMovementLineMvoDto extends CreateOrMergePatchMovementLineMvoDto
    {
        public CreateMovementLineMvoDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public MovementLineMvoCommand.CreateMovementLineMvo toCreateMovementLineMvo()
        {
            return (MovementLineMvoCommand.CreateMovementLineMvo) toCommand();
        }

    }

    public static class MergePatchMovementLineMvoDto extends CreateOrMergePatchMovementLineMvoDto
    {
        public MergePatchMovementLineMvoDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public MovementLineMvoCommand.MergePatchMovementLineMvo toMergePatchMovementLineMvo()
        {
            return (MovementLineMvoCommand.MergePatchMovementLineMvo) toCommand();
        }

    }

}

