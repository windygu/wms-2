package org.dddml.wms.domain.inoutlinemvo;

import java.util.*;
import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface InOutLineMvoCommand extends Command
{
    InOutLineId getInOutLineId();

    void setInOutLineId(InOutLineId inOutLineId);

    Long getInOutVersion();

    void setInOutVersion(Long inOutVersion);

    static void throwOnInvalidStateTransition(InOutLineMvoState state, Command c) {
        if (state.getInOutVersion() == null)
        {
            if (isCommandCreate((InOutLineMvoCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((InOutLineMvoCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(InOutLineMvoCommand c) {
        return ((c instanceof InOutLineMvoCommand.CreateInOutLineMvo) 
            && c.getInOutVersion().equals(InOutLineMvoState.VERSION_NULL));
    }

    interface CreateOrMergePatchInOutLineMvo extends InOutLineMvoCommand
    {
        String getLocatorId();

        void setLocatorId(String locatorId);

        String getProductId();

        void setProductId(String productId);

        String getAttributeSetInstanceId();

        void setAttributeSetInstanceId(String attributeSetInstanceId);

        String getDescription();

        void setDescription(String description);

        String getUomId();

        void setUomId(String uomId);

        BigDecimal getMovementQuantity();

        void setMovementQuantity(BigDecimal movementQuantity);

        BigDecimal getConfirmedQuantity();

        void setConfirmedQuantity(BigDecimal confirmedQuantity);

        BigDecimal getScrappedQuantity();

        void setScrappedQuantity(BigDecimal scrappedQuantity);

        BigDecimal getTargetQuantity();

        void setTargetQuantity(BigDecimal targetQuantity);

        BigDecimal getPickedQuantity();

        void setPickedQuantity(BigDecimal pickedQuantity);

        Boolean getIsInvoiced();

        void setIsInvoiced(Boolean isInvoiced);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        BigDecimal getQuantityEntered();

        void setQuantityEntered(BigDecimal quantityEntered);

        Long getRmaLineNumber();

        void setRmaLineNumber(Long rmaLineNumber);

        Long getReversalLineNumber();

        void setReversalLineNumber(Long reversalLineNumber);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getDocumentAction();

        void setDocumentAction(String documentAction);

        Boolean getInOutPosted();

        void setInOutPosted(Boolean inOutPosted);

        Boolean getInOutProcessed();

        void setInOutProcessed(Boolean inOutProcessed);

        String getInOutProcessing();

        void setInOutProcessing(String inOutProcessing);

        String getInOutDocumentTypeId();

        void setInOutDocumentTypeId(String inOutDocumentTypeId);

        String getInOutDescription();

        void setInOutDescription(String inOutDescription);

        String getInOutOrderId();

        void setInOutOrderId(String inOutOrderId);

        Date getInOutDateOrdered();

        void setInOutDateOrdered(Date inOutDateOrdered);

        Boolean getInOutIsPrinted();

        void setInOutIsPrinted(Boolean inOutIsPrinted);

        String getInOutMovementTypeId();

        void setInOutMovementTypeId(String inOutMovementTypeId);

        Date getInOutMovementDate();

        void setInOutMovementDate(Date inOutMovementDate);

        String getInOutBusinessPartnerId();

        void setInOutBusinessPartnerId(String inOutBusinessPartnerId);

        String getInOutWarehouseId();

        void setInOutWarehouseId(String inOutWarehouseId);

        String getInOutPOReference();

        void setInOutPOReference(String inOutPOReference);

        BigDecimal getInOutFreightAmount();

        void setInOutFreightAmount(BigDecimal inOutFreightAmount);

        String getInOutShipperId();

        void setInOutShipperId(String inOutShipperId);

        BigDecimal getInOutChargeAmount();

        void setInOutChargeAmount(BigDecimal inOutChargeAmount);

        Date getInOutDatePrinted();

        void setInOutDatePrinted(Date inOutDatePrinted);

        String getInOutCreatedFrom();

        void setInOutCreatedFrom(String inOutCreatedFrom);

        String getInOutSalesRepresentativeId();

        void setInOutSalesRepresentativeId(String inOutSalesRepresentativeId);

        Integer getInOutNumberOfPackages();

        void setInOutNumberOfPackages(Integer inOutNumberOfPackages);

        Date getInOutPickDate();

        void setInOutPickDate(Date inOutPickDate);

        Date getInOutShipDate();

        void setInOutShipDate(Date inOutShipDate);

        String getInOutTrackingNumber();

        void setInOutTrackingNumber(String inOutTrackingNumber);

        Date getInOutDateReceived();

        void setInOutDateReceived(Date inOutDateReceived);

        Boolean getInOutIsInTransit();

        void setInOutIsInTransit(Boolean inOutIsInTransit);

        Boolean getInOutIsApproved();

        void setInOutIsApproved(Boolean inOutIsApproved);

        Boolean getInOutIsInDispute();

        void setInOutIsInDispute(Boolean inOutIsInDispute);

        String getInOutRmaDocumentNumber();

        void setInOutRmaDocumentNumber(String inOutRmaDocumentNumber);

        String getInOutReversalDocumentNumber();

        void setInOutReversalDocumentNumber(String inOutReversalDocumentNumber);

        String getInOutCreatedBy();

        void setInOutCreatedBy(String inOutCreatedBy);

        Date getInOutCreatedAt();

        void setInOutCreatedAt(Date inOutCreatedAt);

        String getInOutUpdatedBy();

        void setInOutUpdatedBy(String inOutUpdatedBy);

        Date getInOutUpdatedAt();

        void setInOutUpdatedAt(Date inOutUpdatedAt);

        Boolean getInOutActive();

        void setInOutActive(Boolean inOutActive);

        Boolean getInOutDeleted();

        void setInOutDeleted(Boolean inOutDeleted);

    }

    interface CreateInOutLineMvo extends CreateOrMergePatchInOutLineMvo
    {
    }

    interface MergePatchInOutLineMvo extends CreateOrMergePatchInOutLineMvo
    {
        Boolean getIsPropertyLocatorIdRemoved();

        void setIsPropertyLocatorIdRemoved(Boolean removed);

        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyUomIdRemoved();

        void setIsPropertyUomIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementQuantityRemoved();

        void setIsPropertyMovementQuantityRemoved(Boolean removed);

        Boolean getIsPropertyConfirmedQuantityRemoved();

        void setIsPropertyConfirmedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyScrappedQuantityRemoved();

        void setIsPropertyScrappedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyTargetQuantityRemoved();

        void setIsPropertyTargetQuantityRemoved(Boolean removed);

        Boolean getIsPropertyPickedQuantityRemoved();

        void setIsPropertyPickedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyIsInvoicedRemoved();

        void setIsPropertyIsInvoicedRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyQuantityEnteredRemoved();

        void setIsPropertyQuantityEnteredRemoved(Boolean removed);

        Boolean getIsPropertyRmaLineNumberRemoved();

        void setIsPropertyRmaLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyReversalLineNumberRemoved();

        void setIsPropertyReversalLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyInOutPostedRemoved();

        void setIsPropertyInOutPostedRemoved(Boolean removed);

        Boolean getIsPropertyInOutProcessedRemoved();

        void setIsPropertyInOutProcessedRemoved(Boolean removed);

        Boolean getIsPropertyInOutProcessingRemoved();

        void setIsPropertyInOutProcessingRemoved(Boolean removed);

        Boolean getIsPropertyInOutDocumentTypeIdRemoved();

        void setIsPropertyInOutDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyInOutDescriptionRemoved();

        void setIsPropertyInOutDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyInOutOrderIdRemoved();

        void setIsPropertyInOutOrderIdRemoved(Boolean removed);

        Boolean getIsPropertyInOutDateOrderedRemoved();

        void setIsPropertyInOutDateOrderedRemoved(Boolean removed);

        Boolean getIsPropertyInOutIsPrintedRemoved();

        void setIsPropertyInOutIsPrintedRemoved(Boolean removed);

        Boolean getIsPropertyInOutMovementTypeIdRemoved();

        void setIsPropertyInOutMovementTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyInOutMovementDateRemoved();

        void setIsPropertyInOutMovementDateRemoved(Boolean removed);

        Boolean getIsPropertyInOutBusinessPartnerIdRemoved();

        void setIsPropertyInOutBusinessPartnerIdRemoved(Boolean removed);

        Boolean getIsPropertyInOutWarehouseIdRemoved();

        void setIsPropertyInOutWarehouseIdRemoved(Boolean removed);

        Boolean getIsPropertyInOutPOReferenceRemoved();

        void setIsPropertyInOutPOReferenceRemoved(Boolean removed);

        Boolean getIsPropertyInOutFreightAmountRemoved();

        void setIsPropertyInOutFreightAmountRemoved(Boolean removed);

        Boolean getIsPropertyInOutShipperIdRemoved();

        void setIsPropertyInOutShipperIdRemoved(Boolean removed);

        Boolean getIsPropertyInOutChargeAmountRemoved();

        void setIsPropertyInOutChargeAmountRemoved(Boolean removed);

        Boolean getIsPropertyInOutDatePrintedRemoved();

        void setIsPropertyInOutDatePrintedRemoved(Boolean removed);

        Boolean getIsPropertyInOutCreatedFromRemoved();

        void setIsPropertyInOutCreatedFromRemoved(Boolean removed);

        Boolean getIsPropertyInOutSalesRepresentativeIdRemoved();

        void setIsPropertyInOutSalesRepresentativeIdRemoved(Boolean removed);

        Boolean getIsPropertyInOutNumberOfPackagesRemoved();

        void setIsPropertyInOutNumberOfPackagesRemoved(Boolean removed);

        Boolean getIsPropertyInOutPickDateRemoved();

        void setIsPropertyInOutPickDateRemoved(Boolean removed);

        Boolean getIsPropertyInOutShipDateRemoved();

        void setIsPropertyInOutShipDateRemoved(Boolean removed);

        Boolean getIsPropertyInOutTrackingNumberRemoved();

        void setIsPropertyInOutTrackingNumberRemoved(Boolean removed);

        Boolean getIsPropertyInOutDateReceivedRemoved();

        void setIsPropertyInOutDateReceivedRemoved(Boolean removed);

        Boolean getIsPropertyInOutIsInTransitRemoved();

        void setIsPropertyInOutIsInTransitRemoved(Boolean removed);

        Boolean getIsPropertyInOutIsApprovedRemoved();

        void setIsPropertyInOutIsApprovedRemoved(Boolean removed);

        Boolean getIsPropertyInOutIsInDisputeRemoved();

        void setIsPropertyInOutIsInDisputeRemoved(Boolean removed);

        Boolean getIsPropertyInOutRmaDocumentNumberRemoved();

        void setIsPropertyInOutRmaDocumentNumberRemoved(Boolean removed);

        Boolean getIsPropertyInOutReversalDocumentNumberRemoved();

        void setIsPropertyInOutReversalDocumentNumberRemoved(Boolean removed);

        Boolean getIsPropertyInOutCreatedByRemoved();

        void setIsPropertyInOutCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyInOutCreatedAtRemoved();

        void setIsPropertyInOutCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyInOutUpdatedByRemoved();

        void setIsPropertyInOutUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyInOutUpdatedAtRemoved();

        void setIsPropertyInOutUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyInOutActiveRemoved();

        void setIsPropertyInOutActiveRemoved(Boolean removed);

        Boolean getIsPropertyInOutDeletedRemoved();

        void setIsPropertyInOutDeletedRemoved(Boolean removed);

    }

	interface DeleteInOutLineMvo extends InOutLineMvoCommand
	{
	}

}

