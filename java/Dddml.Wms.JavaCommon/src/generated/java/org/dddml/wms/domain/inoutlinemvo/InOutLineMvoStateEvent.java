package org.dddml.wms.domain.inoutlinemvo;

import java.util.*;
import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InOutLineMvoStateEvent extends Event
{
    InOutLineMvoEventId getInOutLineMvoEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getLocatorId();

    void setLocatorId(String locatorId);

    String getProductId();

    void setProductId(String productId);

    String getAttributeSetInstanceId();

    void setAttributeSetInstanceId(String attributeSetInstanceId);

    String getDescription();

    void setDescription(String description);

    String getQuantityUomId();

    void setQuantityUomId(String quantityUomId);

    BigDecimal getMovementQuantity();

    void setMovementQuantity(BigDecimal movementQuantity);

    BigDecimal getPickedQuantity();

    void setPickedQuantity(BigDecimal pickedQuantity);

    Boolean getIsInvoiced();

    void setIsInvoiced(Boolean isInvoiced);

    Boolean getProcessed();

    void setProcessed(Boolean processed);

    String getRmaLineNumber();

    void setRmaLineNumber(String rmaLineNumber);

    String getReversalLineNumber();

    void setReversalLineNumber(String reversalLineNumber);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getInOutDocumentStatusId();

    void setInOutDocumentStatusId(String inOutDocumentStatusId);

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

    String getCommandId();

    void setCommandId(String commandId);

    interface InOutLineMvoStateCreated extends InOutLineMvoStateEvent
    {
    
    }


    interface InOutLineMvoStateMergePatched extends InOutLineMvoStateEvent
    {
        Boolean getIsPropertyLocatorIdRemoved();

        void setIsPropertyLocatorIdRemoved(Boolean removed);

        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyQuantityUomIdRemoved();

        void setIsPropertyQuantityUomIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementQuantityRemoved();

        void setIsPropertyMovementQuantityRemoved(Boolean removed);

        Boolean getIsPropertyPickedQuantityRemoved();

        void setIsPropertyPickedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyIsInvoicedRemoved();

        void setIsPropertyIsInvoicedRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyRmaLineNumberRemoved();

        void setIsPropertyRmaLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyReversalLineNumberRemoved();

        void setIsPropertyReversalLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyInOutDocumentStatusIdRemoved();

        void setIsPropertyInOutDocumentStatusIdRemoved(Boolean removed);

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


    }

    interface InOutLineMvoStateDeleted extends InOutLineMvoStateEvent
    {
    }


}

