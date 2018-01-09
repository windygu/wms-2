package org.dddml.wms.domain.inoutlinemvo;

import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchInOutLineMvoDto extends AbstractInOutLineMvoCommandDto
{
    private String locatorId;

    public String getLocatorId()
    {
        return this.locatorId;
    }

    public void setLocatorId(String locatorId)
    {
        this.locatorId = locatorId;
    }

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
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

    private String quantityUomId;

    public String getQuantityUomId()
    {
        return this.quantityUomId;
    }

    public void setQuantityUomId(String quantityUomId)
    {
        this.quantityUomId = quantityUomId;
    }

    private BigDecimal movementQuantity;

    public BigDecimal getMovementQuantity()
    {
        return this.movementQuantity;
    }

    public void setMovementQuantity(BigDecimal movementQuantity)
    {
        this.movementQuantity = movementQuantity;
    }

    private BigDecimal pickedQuantity;

    public BigDecimal getPickedQuantity()
    {
        return this.pickedQuantity;
    }

    public void setPickedQuantity(BigDecimal pickedQuantity)
    {
        this.pickedQuantity = pickedQuantity;
    }

    private Boolean isInvoiced;

    public Boolean getIsInvoiced()
    {
        return this.isInvoiced;
    }

    public void setIsInvoiced(Boolean isInvoiced)
    {
        this.isInvoiced = isInvoiced;
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

    private String rmaLineNumber;

    public String getRmaLineNumber()
    {
        return this.rmaLineNumber;
    }

    public void setRmaLineNumber(String rmaLineNumber)
    {
        this.rmaLineNumber = rmaLineNumber;
    }

    private String reversalLineNumber;

    public String getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(String reversalLineNumber)
    {
        this.reversalLineNumber = reversalLineNumber;
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

    private String inOutDocumentStatusId;

    public String getInOutDocumentStatusId()
    {
        return this.inOutDocumentStatusId;
    }

    public void setInOutDocumentStatusId(String inOutDocumentStatusId)
    {
        this.inOutDocumentStatusId = inOutDocumentStatusId;
    }

    private Boolean inOutPosted;

    public Boolean getInOutPosted()
    {
        return this.inOutPosted;
    }

    public void setInOutPosted(Boolean inOutPosted)
    {
        this.inOutPosted = inOutPosted;
    }

    private Boolean inOutProcessed;

    public Boolean getInOutProcessed()
    {
        return this.inOutProcessed;
    }

    public void setInOutProcessed(Boolean inOutProcessed)
    {
        this.inOutProcessed = inOutProcessed;
    }

    private String inOutProcessing;

    public String getInOutProcessing()
    {
        return this.inOutProcessing;
    }

    public void setInOutProcessing(String inOutProcessing)
    {
        this.inOutProcessing = inOutProcessing;
    }

    private String inOutDocumentTypeId;

    public String getInOutDocumentTypeId()
    {
        return this.inOutDocumentTypeId;
    }

    public void setInOutDocumentTypeId(String inOutDocumentTypeId)
    {
        this.inOutDocumentTypeId = inOutDocumentTypeId;
    }

    private String inOutDescription;

    public String getInOutDescription()
    {
        return this.inOutDescription;
    }

    public void setInOutDescription(String inOutDescription)
    {
        this.inOutDescription = inOutDescription;
    }

    private String inOutOrderId;

    public String getInOutOrderId()
    {
        return this.inOutOrderId;
    }

    public void setInOutOrderId(String inOutOrderId)
    {
        this.inOutOrderId = inOutOrderId;
    }

    private Date inOutDateOrdered;

    public Date getInOutDateOrdered()
    {
        return this.inOutDateOrdered;
    }

    public void setInOutDateOrdered(Date inOutDateOrdered)
    {
        this.inOutDateOrdered = inOutDateOrdered;
    }

    private Boolean inOutIsPrinted;

    public Boolean getInOutIsPrinted()
    {
        return this.inOutIsPrinted;
    }

    public void setInOutIsPrinted(Boolean inOutIsPrinted)
    {
        this.inOutIsPrinted = inOutIsPrinted;
    }

    private String inOutMovementTypeId;

    public String getInOutMovementTypeId()
    {
        return this.inOutMovementTypeId;
    }

    public void setInOutMovementTypeId(String inOutMovementTypeId)
    {
        this.inOutMovementTypeId = inOutMovementTypeId;
    }

    private Date inOutMovementDate;

    public Date getInOutMovementDate()
    {
        return this.inOutMovementDate;
    }

    public void setInOutMovementDate(Date inOutMovementDate)
    {
        this.inOutMovementDate = inOutMovementDate;
    }

    private String inOutBusinessPartnerId;

    public String getInOutBusinessPartnerId()
    {
        return this.inOutBusinessPartnerId;
    }

    public void setInOutBusinessPartnerId(String inOutBusinessPartnerId)
    {
        this.inOutBusinessPartnerId = inOutBusinessPartnerId;
    }

    private String inOutWarehouseId;

    public String getInOutWarehouseId()
    {
        return this.inOutWarehouseId;
    }

    public void setInOutWarehouseId(String inOutWarehouseId)
    {
        this.inOutWarehouseId = inOutWarehouseId;
    }

    private String inOutPOReference;

    public String getInOutPOReference()
    {
        return this.inOutPOReference;
    }

    public void setInOutPOReference(String inOutPOReference)
    {
        this.inOutPOReference = inOutPOReference;
    }

    private BigDecimal inOutFreightAmount;

    public BigDecimal getInOutFreightAmount()
    {
        return this.inOutFreightAmount;
    }

    public void setInOutFreightAmount(BigDecimal inOutFreightAmount)
    {
        this.inOutFreightAmount = inOutFreightAmount;
    }

    private String inOutShipperId;

    public String getInOutShipperId()
    {
        return this.inOutShipperId;
    }

    public void setInOutShipperId(String inOutShipperId)
    {
        this.inOutShipperId = inOutShipperId;
    }

    private BigDecimal inOutChargeAmount;

    public BigDecimal getInOutChargeAmount()
    {
        return this.inOutChargeAmount;
    }

    public void setInOutChargeAmount(BigDecimal inOutChargeAmount)
    {
        this.inOutChargeAmount = inOutChargeAmount;
    }

    private Date inOutDatePrinted;

    public Date getInOutDatePrinted()
    {
        return this.inOutDatePrinted;
    }

    public void setInOutDatePrinted(Date inOutDatePrinted)
    {
        this.inOutDatePrinted = inOutDatePrinted;
    }

    private String inOutCreatedFrom;

    public String getInOutCreatedFrom()
    {
        return this.inOutCreatedFrom;
    }

    public void setInOutCreatedFrom(String inOutCreatedFrom)
    {
        this.inOutCreatedFrom = inOutCreatedFrom;
    }

    private String inOutSalesRepresentativeId;

    public String getInOutSalesRepresentativeId()
    {
        return this.inOutSalesRepresentativeId;
    }

    public void setInOutSalesRepresentativeId(String inOutSalesRepresentativeId)
    {
        this.inOutSalesRepresentativeId = inOutSalesRepresentativeId;
    }

    private Integer inOutNumberOfPackages;

    public Integer getInOutNumberOfPackages()
    {
        return this.inOutNumberOfPackages;
    }

    public void setInOutNumberOfPackages(Integer inOutNumberOfPackages)
    {
        this.inOutNumberOfPackages = inOutNumberOfPackages;
    }

    private Date inOutPickDate;

    public Date getInOutPickDate()
    {
        return this.inOutPickDate;
    }

    public void setInOutPickDate(Date inOutPickDate)
    {
        this.inOutPickDate = inOutPickDate;
    }

    private Date inOutShipDate;

    public Date getInOutShipDate()
    {
        return this.inOutShipDate;
    }

    public void setInOutShipDate(Date inOutShipDate)
    {
        this.inOutShipDate = inOutShipDate;
    }

    private String inOutTrackingNumber;

    public String getInOutTrackingNumber()
    {
        return this.inOutTrackingNumber;
    }

    public void setInOutTrackingNumber(String inOutTrackingNumber)
    {
        this.inOutTrackingNumber = inOutTrackingNumber;
    }

    private Date inOutDateReceived;

    public Date getInOutDateReceived()
    {
        return this.inOutDateReceived;
    }

    public void setInOutDateReceived(Date inOutDateReceived)
    {
        this.inOutDateReceived = inOutDateReceived;
    }

    private Boolean inOutIsInTransit;

    public Boolean getInOutIsInTransit()
    {
        return this.inOutIsInTransit;
    }

    public void setInOutIsInTransit(Boolean inOutIsInTransit)
    {
        this.inOutIsInTransit = inOutIsInTransit;
    }

    private Boolean inOutIsApproved;

    public Boolean getInOutIsApproved()
    {
        return this.inOutIsApproved;
    }

    public void setInOutIsApproved(Boolean inOutIsApproved)
    {
        this.inOutIsApproved = inOutIsApproved;
    }

    private Boolean inOutIsInDispute;

    public Boolean getInOutIsInDispute()
    {
        return this.inOutIsInDispute;
    }

    public void setInOutIsInDispute(Boolean inOutIsInDispute)
    {
        this.inOutIsInDispute = inOutIsInDispute;
    }

    private String inOutRmaDocumentNumber;

    public String getInOutRmaDocumentNumber()
    {
        return this.inOutRmaDocumentNumber;
    }

    public void setInOutRmaDocumentNumber(String inOutRmaDocumentNumber)
    {
        this.inOutRmaDocumentNumber = inOutRmaDocumentNumber;
    }

    private String inOutReversalDocumentNumber;

    public String getInOutReversalDocumentNumber()
    {
        return this.inOutReversalDocumentNumber;
    }

    public void setInOutReversalDocumentNumber(String inOutReversalDocumentNumber)
    {
        this.inOutReversalDocumentNumber = inOutReversalDocumentNumber;
    }

    private String inOutCreatedBy;

    public String getInOutCreatedBy()
    {
        return this.inOutCreatedBy;
    }

    public void setInOutCreatedBy(String inOutCreatedBy)
    {
        this.inOutCreatedBy = inOutCreatedBy;
    }

    private Date inOutCreatedAt;

    public Date getInOutCreatedAt()
    {
        return this.inOutCreatedAt;
    }

    public void setInOutCreatedAt(Date inOutCreatedAt)
    {
        this.inOutCreatedAt = inOutCreatedAt;
    }

    private String inOutUpdatedBy;

    public String getInOutUpdatedBy()
    {
        return this.inOutUpdatedBy;
    }

    public void setInOutUpdatedBy(String inOutUpdatedBy)
    {
        this.inOutUpdatedBy = inOutUpdatedBy;
    }

    private Date inOutUpdatedAt;

    public Date getInOutUpdatedAt()
    {
        return this.inOutUpdatedAt;
    }

    public void setInOutUpdatedAt(Date inOutUpdatedAt)
    {
        this.inOutUpdatedAt = inOutUpdatedAt;
    }

    private Boolean inOutActive;

    public Boolean getInOutActive()
    {
        return this.inOutActive;
    }

    public void setInOutActive(Boolean inOutActive)
    {
        this.inOutActive = inOutActive;
    }

    private Boolean isPropertyLocatorIdRemoved;

    public Boolean getIsPropertyLocatorIdRemoved()
    {
        return this.isPropertyLocatorIdRemoved;
    }

    public void setIsPropertyLocatorIdRemoved(Boolean removed)
    {
        this.isPropertyLocatorIdRemoved = removed;
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

    private Boolean isPropertyAttributeSetInstanceIdRemoved;

    public Boolean getIsPropertyAttributeSetInstanceIdRemoved()
    {
        return this.isPropertyAttributeSetInstanceIdRemoved;
    }

    public void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed)
    {
        this.isPropertyAttributeSetInstanceIdRemoved = removed;
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

    private Boolean isPropertyQuantityUomIdRemoved;

    public Boolean getIsPropertyQuantityUomIdRemoved()
    {
        return this.isPropertyQuantityUomIdRemoved;
    }

    public void setIsPropertyQuantityUomIdRemoved(Boolean removed)
    {
        this.isPropertyQuantityUomIdRemoved = removed;
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

    private Boolean isPropertyPickedQuantityRemoved;

    public Boolean getIsPropertyPickedQuantityRemoved()
    {
        return this.isPropertyPickedQuantityRemoved;
    }

    public void setIsPropertyPickedQuantityRemoved(Boolean removed)
    {
        this.isPropertyPickedQuantityRemoved = removed;
    }

    private Boolean isPropertyIsInvoicedRemoved;

    public Boolean getIsPropertyIsInvoicedRemoved()
    {
        return this.isPropertyIsInvoicedRemoved;
    }

    public void setIsPropertyIsInvoicedRemoved(Boolean removed)
    {
        this.isPropertyIsInvoicedRemoved = removed;
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

    private Boolean isPropertyRmaLineNumberRemoved;

    public Boolean getIsPropertyRmaLineNumberRemoved()
    {
        return this.isPropertyRmaLineNumberRemoved;
    }

    public void setIsPropertyRmaLineNumberRemoved(Boolean removed)
    {
        this.isPropertyRmaLineNumberRemoved = removed;
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

    private Boolean isPropertyInOutDocumentStatusIdRemoved;

    public Boolean getIsPropertyInOutDocumentStatusIdRemoved()
    {
        return this.isPropertyInOutDocumentStatusIdRemoved;
    }

    public void setIsPropertyInOutDocumentStatusIdRemoved(Boolean removed)
    {
        this.isPropertyInOutDocumentStatusIdRemoved = removed;
    }

    private Boolean isPropertyInOutPostedRemoved;

    public Boolean getIsPropertyInOutPostedRemoved()
    {
        return this.isPropertyInOutPostedRemoved;
    }

    public void setIsPropertyInOutPostedRemoved(Boolean removed)
    {
        this.isPropertyInOutPostedRemoved = removed;
    }

    private Boolean isPropertyInOutProcessedRemoved;

    public Boolean getIsPropertyInOutProcessedRemoved()
    {
        return this.isPropertyInOutProcessedRemoved;
    }

    public void setIsPropertyInOutProcessedRemoved(Boolean removed)
    {
        this.isPropertyInOutProcessedRemoved = removed;
    }

    private Boolean isPropertyInOutProcessingRemoved;

    public Boolean getIsPropertyInOutProcessingRemoved()
    {
        return this.isPropertyInOutProcessingRemoved;
    }

    public void setIsPropertyInOutProcessingRemoved(Boolean removed)
    {
        this.isPropertyInOutProcessingRemoved = removed;
    }

    private Boolean isPropertyInOutDocumentTypeIdRemoved;

    public Boolean getIsPropertyInOutDocumentTypeIdRemoved()
    {
        return this.isPropertyInOutDocumentTypeIdRemoved;
    }

    public void setIsPropertyInOutDocumentTypeIdRemoved(Boolean removed)
    {
        this.isPropertyInOutDocumentTypeIdRemoved = removed;
    }

    private Boolean isPropertyInOutDescriptionRemoved;

    public Boolean getIsPropertyInOutDescriptionRemoved()
    {
        return this.isPropertyInOutDescriptionRemoved;
    }

    public void setIsPropertyInOutDescriptionRemoved(Boolean removed)
    {
        this.isPropertyInOutDescriptionRemoved = removed;
    }

    private Boolean isPropertyInOutOrderIdRemoved;

    public Boolean getIsPropertyInOutOrderIdRemoved()
    {
        return this.isPropertyInOutOrderIdRemoved;
    }

    public void setIsPropertyInOutOrderIdRemoved(Boolean removed)
    {
        this.isPropertyInOutOrderIdRemoved = removed;
    }

    private Boolean isPropertyInOutDateOrderedRemoved;

    public Boolean getIsPropertyInOutDateOrderedRemoved()
    {
        return this.isPropertyInOutDateOrderedRemoved;
    }

    public void setIsPropertyInOutDateOrderedRemoved(Boolean removed)
    {
        this.isPropertyInOutDateOrderedRemoved = removed;
    }

    private Boolean isPropertyInOutIsPrintedRemoved;

    public Boolean getIsPropertyInOutIsPrintedRemoved()
    {
        return this.isPropertyInOutIsPrintedRemoved;
    }

    public void setIsPropertyInOutIsPrintedRemoved(Boolean removed)
    {
        this.isPropertyInOutIsPrintedRemoved = removed;
    }

    private Boolean isPropertyInOutMovementTypeIdRemoved;

    public Boolean getIsPropertyInOutMovementTypeIdRemoved()
    {
        return this.isPropertyInOutMovementTypeIdRemoved;
    }

    public void setIsPropertyInOutMovementTypeIdRemoved(Boolean removed)
    {
        this.isPropertyInOutMovementTypeIdRemoved = removed;
    }

    private Boolean isPropertyInOutMovementDateRemoved;

    public Boolean getIsPropertyInOutMovementDateRemoved()
    {
        return this.isPropertyInOutMovementDateRemoved;
    }

    public void setIsPropertyInOutMovementDateRemoved(Boolean removed)
    {
        this.isPropertyInOutMovementDateRemoved = removed;
    }

    private Boolean isPropertyInOutBusinessPartnerIdRemoved;

    public Boolean getIsPropertyInOutBusinessPartnerIdRemoved()
    {
        return this.isPropertyInOutBusinessPartnerIdRemoved;
    }

    public void setIsPropertyInOutBusinessPartnerIdRemoved(Boolean removed)
    {
        this.isPropertyInOutBusinessPartnerIdRemoved = removed;
    }

    private Boolean isPropertyInOutWarehouseIdRemoved;

    public Boolean getIsPropertyInOutWarehouseIdRemoved()
    {
        return this.isPropertyInOutWarehouseIdRemoved;
    }

    public void setIsPropertyInOutWarehouseIdRemoved(Boolean removed)
    {
        this.isPropertyInOutWarehouseIdRemoved = removed;
    }

    private Boolean isPropertyInOutPOReferenceRemoved;

    public Boolean getIsPropertyInOutPOReferenceRemoved()
    {
        return this.isPropertyInOutPOReferenceRemoved;
    }

    public void setIsPropertyInOutPOReferenceRemoved(Boolean removed)
    {
        this.isPropertyInOutPOReferenceRemoved = removed;
    }

    private Boolean isPropertyInOutFreightAmountRemoved;

    public Boolean getIsPropertyInOutFreightAmountRemoved()
    {
        return this.isPropertyInOutFreightAmountRemoved;
    }

    public void setIsPropertyInOutFreightAmountRemoved(Boolean removed)
    {
        this.isPropertyInOutFreightAmountRemoved = removed;
    }

    private Boolean isPropertyInOutShipperIdRemoved;

    public Boolean getIsPropertyInOutShipperIdRemoved()
    {
        return this.isPropertyInOutShipperIdRemoved;
    }

    public void setIsPropertyInOutShipperIdRemoved(Boolean removed)
    {
        this.isPropertyInOutShipperIdRemoved = removed;
    }

    private Boolean isPropertyInOutChargeAmountRemoved;

    public Boolean getIsPropertyInOutChargeAmountRemoved()
    {
        return this.isPropertyInOutChargeAmountRemoved;
    }

    public void setIsPropertyInOutChargeAmountRemoved(Boolean removed)
    {
        this.isPropertyInOutChargeAmountRemoved = removed;
    }

    private Boolean isPropertyInOutDatePrintedRemoved;

    public Boolean getIsPropertyInOutDatePrintedRemoved()
    {
        return this.isPropertyInOutDatePrintedRemoved;
    }

    public void setIsPropertyInOutDatePrintedRemoved(Boolean removed)
    {
        this.isPropertyInOutDatePrintedRemoved = removed;
    }

    private Boolean isPropertyInOutCreatedFromRemoved;

    public Boolean getIsPropertyInOutCreatedFromRemoved()
    {
        return this.isPropertyInOutCreatedFromRemoved;
    }

    public void setIsPropertyInOutCreatedFromRemoved(Boolean removed)
    {
        this.isPropertyInOutCreatedFromRemoved = removed;
    }

    private Boolean isPropertyInOutSalesRepresentativeIdRemoved;

    public Boolean getIsPropertyInOutSalesRepresentativeIdRemoved()
    {
        return this.isPropertyInOutSalesRepresentativeIdRemoved;
    }

    public void setIsPropertyInOutSalesRepresentativeIdRemoved(Boolean removed)
    {
        this.isPropertyInOutSalesRepresentativeIdRemoved = removed;
    }

    private Boolean isPropertyInOutNumberOfPackagesRemoved;

    public Boolean getIsPropertyInOutNumberOfPackagesRemoved()
    {
        return this.isPropertyInOutNumberOfPackagesRemoved;
    }

    public void setIsPropertyInOutNumberOfPackagesRemoved(Boolean removed)
    {
        this.isPropertyInOutNumberOfPackagesRemoved = removed;
    }

    private Boolean isPropertyInOutPickDateRemoved;

    public Boolean getIsPropertyInOutPickDateRemoved()
    {
        return this.isPropertyInOutPickDateRemoved;
    }

    public void setIsPropertyInOutPickDateRemoved(Boolean removed)
    {
        this.isPropertyInOutPickDateRemoved = removed;
    }

    private Boolean isPropertyInOutShipDateRemoved;

    public Boolean getIsPropertyInOutShipDateRemoved()
    {
        return this.isPropertyInOutShipDateRemoved;
    }

    public void setIsPropertyInOutShipDateRemoved(Boolean removed)
    {
        this.isPropertyInOutShipDateRemoved = removed;
    }

    private Boolean isPropertyInOutTrackingNumberRemoved;

    public Boolean getIsPropertyInOutTrackingNumberRemoved()
    {
        return this.isPropertyInOutTrackingNumberRemoved;
    }

    public void setIsPropertyInOutTrackingNumberRemoved(Boolean removed)
    {
        this.isPropertyInOutTrackingNumberRemoved = removed;
    }

    private Boolean isPropertyInOutDateReceivedRemoved;

    public Boolean getIsPropertyInOutDateReceivedRemoved()
    {
        return this.isPropertyInOutDateReceivedRemoved;
    }

    public void setIsPropertyInOutDateReceivedRemoved(Boolean removed)
    {
        this.isPropertyInOutDateReceivedRemoved = removed;
    }

    private Boolean isPropertyInOutIsInTransitRemoved;

    public Boolean getIsPropertyInOutIsInTransitRemoved()
    {
        return this.isPropertyInOutIsInTransitRemoved;
    }

    public void setIsPropertyInOutIsInTransitRemoved(Boolean removed)
    {
        this.isPropertyInOutIsInTransitRemoved = removed;
    }

    private Boolean isPropertyInOutIsApprovedRemoved;

    public Boolean getIsPropertyInOutIsApprovedRemoved()
    {
        return this.isPropertyInOutIsApprovedRemoved;
    }

    public void setIsPropertyInOutIsApprovedRemoved(Boolean removed)
    {
        this.isPropertyInOutIsApprovedRemoved = removed;
    }

    private Boolean isPropertyInOutIsInDisputeRemoved;

    public Boolean getIsPropertyInOutIsInDisputeRemoved()
    {
        return this.isPropertyInOutIsInDisputeRemoved;
    }

    public void setIsPropertyInOutIsInDisputeRemoved(Boolean removed)
    {
        this.isPropertyInOutIsInDisputeRemoved = removed;
    }

    private Boolean isPropertyInOutRmaDocumentNumberRemoved;

    public Boolean getIsPropertyInOutRmaDocumentNumberRemoved()
    {
        return this.isPropertyInOutRmaDocumentNumberRemoved;
    }

    public void setIsPropertyInOutRmaDocumentNumberRemoved(Boolean removed)
    {
        this.isPropertyInOutRmaDocumentNumberRemoved = removed;
    }

    private Boolean isPropertyInOutReversalDocumentNumberRemoved;

    public Boolean getIsPropertyInOutReversalDocumentNumberRemoved()
    {
        return this.isPropertyInOutReversalDocumentNumberRemoved;
    }

    public void setIsPropertyInOutReversalDocumentNumberRemoved(Boolean removed)
    {
        this.isPropertyInOutReversalDocumentNumberRemoved = removed;
    }

    private Boolean isPropertyInOutCreatedByRemoved;

    public Boolean getIsPropertyInOutCreatedByRemoved()
    {
        return this.isPropertyInOutCreatedByRemoved;
    }

    public void setIsPropertyInOutCreatedByRemoved(Boolean removed)
    {
        this.isPropertyInOutCreatedByRemoved = removed;
    }

    private Boolean isPropertyInOutCreatedAtRemoved;

    public Boolean getIsPropertyInOutCreatedAtRemoved()
    {
        return this.isPropertyInOutCreatedAtRemoved;
    }

    public void setIsPropertyInOutCreatedAtRemoved(Boolean removed)
    {
        this.isPropertyInOutCreatedAtRemoved = removed;
    }

    private Boolean isPropertyInOutUpdatedByRemoved;

    public Boolean getIsPropertyInOutUpdatedByRemoved()
    {
        return this.isPropertyInOutUpdatedByRemoved;
    }

    public void setIsPropertyInOutUpdatedByRemoved(Boolean removed)
    {
        this.isPropertyInOutUpdatedByRemoved = removed;
    }

    private Boolean isPropertyInOutUpdatedAtRemoved;

    public Boolean getIsPropertyInOutUpdatedAtRemoved()
    {
        return this.isPropertyInOutUpdatedAtRemoved;
    }

    public void setIsPropertyInOutUpdatedAtRemoved(Boolean removed)
    {
        this.isPropertyInOutUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyInOutActiveRemoved;

    public Boolean getIsPropertyInOutActiveRemoved()
    {
        return this.isPropertyInOutActiveRemoved;
    }

    public void setIsPropertyInOutActiveRemoved(Boolean removed)
    {
        this.isPropertyInOutActiveRemoved = removed;
    }

    public void copyTo(AbstractInOutLineMvoCommand.AbstractCreateOrMergePatchInOutLineMvo command)
    {
        ((AbstractInOutLineMvoCommandDto) this).copyTo(command);
        command.setLocatorId(this.getLocatorId());
        command.setProductId(this.getProductId());
        command.setAttributeSetInstanceId(this.getAttributeSetInstanceId());
        command.setDescription(this.getDescription());
        command.setQuantityUomId(this.getQuantityUomId());
        command.setMovementQuantity(this.getMovementQuantity());
        command.setPickedQuantity(this.getPickedQuantity());
        command.setIsInvoiced(this.getIsInvoiced());
        command.setProcessed(this.getProcessed());
        command.setRmaLineNumber(this.getRmaLineNumber());
        command.setReversalLineNumber(this.getReversalLineNumber());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setInOutDocumentStatusId(this.getInOutDocumentStatusId());
        command.setInOutPosted(this.getInOutPosted());
        command.setInOutProcessed(this.getInOutProcessed());
        command.setInOutProcessing(this.getInOutProcessing());
        command.setInOutDocumentTypeId(this.getInOutDocumentTypeId());
        command.setInOutDescription(this.getInOutDescription());
        command.setInOutOrderId(this.getInOutOrderId());
        command.setInOutDateOrdered(this.getInOutDateOrdered());
        command.setInOutIsPrinted(this.getInOutIsPrinted());
        command.setInOutMovementTypeId(this.getInOutMovementTypeId());
        command.setInOutMovementDate(this.getInOutMovementDate());
        command.setInOutBusinessPartnerId(this.getInOutBusinessPartnerId());
        command.setInOutWarehouseId(this.getInOutWarehouseId());
        command.setInOutPOReference(this.getInOutPOReference());
        command.setInOutFreightAmount(this.getInOutFreightAmount());
        command.setInOutShipperId(this.getInOutShipperId());
        command.setInOutChargeAmount(this.getInOutChargeAmount());
        command.setInOutDatePrinted(this.getInOutDatePrinted());
        command.setInOutCreatedFrom(this.getInOutCreatedFrom());
        command.setInOutSalesRepresentativeId(this.getInOutSalesRepresentativeId());
        command.setInOutNumberOfPackages(this.getInOutNumberOfPackages());
        command.setInOutPickDate(this.getInOutPickDate());
        command.setInOutShipDate(this.getInOutShipDate());
        command.setInOutTrackingNumber(this.getInOutTrackingNumber());
        command.setInOutDateReceived(this.getInOutDateReceived());
        command.setInOutIsInTransit(this.getInOutIsInTransit());
        command.setInOutIsApproved(this.getInOutIsApproved());
        command.setInOutIsInDispute(this.getInOutIsInDispute());
        command.setInOutRmaDocumentNumber(this.getInOutRmaDocumentNumber());
        command.setInOutReversalDocumentNumber(this.getInOutReversalDocumentNumber());
        command.setInOutCreatedBy(this.getInOutCreatedBy());
        command.setInOutCreatedAt(this.getInOutCreatedAt());
        command.setInOutUpdatedBy(this.getInOutUpdatedBy());
        command.setInOutUpdatedAt(this.getInOutUpdatedAt());
        command.setInOutActive(this.getInOutActive());
    }

    public InOutLineMvoCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractInOutLineMvoCommand.SimpleCreateInOutLineMvo command = new AbstractInOutLineMvoCommand.SimpleCreateInOutLineMvo();
            copyTo((AbstractInOutLineMvoCommand.AbstractCreateInOutLineMvo) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractInOutLineMvoCommand.SimpleMergePatchInOutLineMvo command = new AbstractInOutLineMvoCommand.SimpleMergePatchInOutLineMvo();
            copyTo((AbstractInOutLineMvoCommand.SimpleMergePatchInOutLineMvo) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractInOutLineMvoCommand.AbstractCreateInOutLineMvo command)
    {
        copyTo((AbstractInOutLineMvoCommand.AbstractCreateOrMergePatchInOutLineMvo) command);
    }

    public void copyTo(AbstractInOutLineMvoCommand.AbstractMergePatchInOutLineMvo command)
    {
        copyTo((AbstractInOutLineMvoCommand.AbstractCreateOrMergePatchInOutLineMvo) command);
        command.setIsPropertyLocatorIdRemoved(this.getIsPropertyLocatorIdRemoved());
        command.setIsPropertyProductIdRemoved(this.getIsPropertyProductIdRemoved());
        command.setIsPropertyAttributeSetInstanceIdRemoved(this.getIsPropertyAttributeSetInstanceIdRemoved());
        command.setIsPropertyDescriptionRemoved(this.getIsPropertyDescriptionRemoved());
        command.setIsPropertyQuantityUomIdRemoved(this.getIsPropertyQuantityUomIdRemoved());
        command.setIsPropertyMovementQuantityRemoved(this.getIsPropertyMovementQuantityRemoved());
        command.setIsPropertyPickedQuantityRemoved(this.getIsPropertyPickedQuantityRemoved());
        command.setIsPropertyIsInvoicedRemoved(this.getIsPropertyIsInvoicedRemoved());
        command.setIsPropertyProcessedRemoved(this.getIsPropertyProcessedRemoved());
        command.setIsPropertyRmaLineNumberRemoved(this.getIsPropertyRmaLineNumberRemoved());
        command.setIsPropertyReversalLineNumberRemoved(this.getIsPropertyReversalLineNumberRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyInOutDocumentStatusIdRemoved(this.getIsPropertyInOutDocumentStatusIdRemoved());
        command.setIsPropertyInOutPostedRemoved(this.getIsPropertyInOutPostedRemoved());
        command.setIsPropertyInOutProcessedRemoved(this.getIsPropertyInOutProcessedRemoved());
        command.setIsPropertyInOutProcessingRemoved(this.getIsPropertyInOutProcessingRemoved());
        command.setIsPropertyInOutDocumentTypeIdRemoved(this.getIsPropertyInOutDocumentTypeIdRemoved());
        command.setIsPropertyInOutDescriptionRemoved(this.getIsPropertyInOutDescriptionRemoved());
        command.setIsPropertyInOutOrderIdRemoved(this.getIsPropertyInOutOrderIdRemoved());
        command.setIsPropertyInOutDateOrderedRemoved(this.getIsPropertyInOutDateOrderedRemoved());
        command.setIsPropertyInOutIsPrintedRemoved(this.getIsPropertyInOutIsPrintedRemoved());
        command.setIsPropertyInOutMovementTypeIdRemoved(this.getIsPropertyInOutMovementTypeIdRemoved());
        command.setIsPropertyInOutMovementDateRemoved(this.getIsPropertyInOutMovementDateRemoved());
        command.setIsPropertyInOutBusinessPartnerIdRemoved(this.getIsPropertyInOutBusinessPartnerIdRemoved());
        command.setIsPropertyInOutWarehouseIdRemoved(this.getIsPropertyInOutWarehouseIdRemoved());
        command.setIsPropertyInOutPOReferenceRemoved(this.getIsPropertyInOutPOReferenceRemoved());
        command.setIsPropertyInOutFreightAmountRemoved(this.getIsPropertyInOutFreightAmountRemoved());
        command.setIsPropertyInOutShipperIdRemoved(this.getIsPropertyInOutShipperIdRemoved());
        command.setIsPropertyInOutChargeAmountRemoved(this.getIsPropertyInOutChargeAmountRemoved());
        command.setIsPropertyInOutDatePrintedRemoved(this.getIsPropertyInOutDatePrintedRemoved());
        command.setIsPropertyInOutCreatedFromRemoved(this.getIsPropertyInOutCreatedFromRemoved());
        command.setIsPropertyInOutSalesRepresentativeIdRemoved(this.getIsPropertyInOutSalesRepresentativeIdRemoved());
        command.setIsPropertyInOutNumberOfPackagesRemoved(this.getIsPropertyInOutNumberOfPackagesRemoved());
        command.setIsPropertyInOutPickDateRemoved(this.getIsPropertyInOutPickDateRemoved());
        command.setIsPropertyInOutShipDateRemoved(this.getIsPropertyInOutShipDateRemoved());
        command.setIsPropertyInOutTrackingNumberRemoved(this.getIsPropertyInOutTrackingNumberRemoved());
        command.setIsPropertyInOutDateReceivedRemoved(this.getIsPropertyInOutDateReceivedRemoved());
        command.setIsPropertyInOutIsInTransitRemoved(this.getIsPropertyInOutIsInTransitRemoved());
        command.setIsPropertyInOutIsApprovedRemoved(this.getIsPropertyInOutIsApprovedRemoved());
        command.setIsPropertyInOutIsInDisputeRemoved(this.getIsPropertyInOutIsInDisputeRemoved());
        command.setIsPropertyInOutRmaDocumentNumberRemoved(this.getIsPropertyInOutRmaDocumentNumberRemoved());
        command.setIsPropertyInOutReversalDocumentNumberRemoved(this.getIsPropertyInOutReversalDocumentNumberRemoved());
        command.setIsPropertyInOutCreatedByRemoved(this.getIsPropertyInOutCreatedByRemoved());
        command.setIsPropertyInOutCreatedAtRemoved(this.getIsPropertyInOutCreatedAtRemoved());
        command.setIsPropertyInOutUpdatedByRemoved(this.getIsPropertyInOutUpdatedByRemoved());
        command.setIsPropertyInOutUpdatedAtRemoved(this.getIsPropertyInOutUpdatedAtRemoved());
        command.setIsPropertyInOutActiveRemoved(this.getIsPropertyInOutActiveRemoved());
    }

    public static class CreateInOutLineMvoDto extends CreateOrMergePatchInOutLineMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public InOutLineMvoCommand.CreateInOutLineMvo toCreateInOutLineMvo()
        {
            return (InOutLineMvoCommand.CreateInOutLineMvo) toCommand();
        }

    }

    public static class MergePatchInOutLineMvoDto extends CreateOrMergePatchInOutLineMvoDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public InOutLineMvoCommand.MergePatchInOutLineMvo toMergePatchInOutLineMvo()
        {
            return (InOutLineMvoCommand.MergePatchInOutLineMvo) toCommand();
        }

    }

}

