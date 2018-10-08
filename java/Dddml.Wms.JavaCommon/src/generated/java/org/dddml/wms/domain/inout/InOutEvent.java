package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InOutEvent extends Event {

    interface SqlInOutEvent extends InOutEvent {
        InOutEventId getInOutEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    String getDocumentNumber();

    //void setDocumentNumber(String documentNumber);

    Long getVersion();
    
    //void getVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InOutStateEvent extends InOutEvent {
        String getDocumentStatusId();

        void setDocumentStatusId(String documentStatusId);

        Boolean getPosted();

        void setPosted(Boolean posted);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        String getProcessing();

        void setProcessing(String processing);

        String getDocumentTypeId();

        void setDocumentTypeId(String documentTypeId);

        String getDescription();

        void setDescription(String description);

        String getOrderId();

        void setOrderId(String orderId);

        Date getDateOrdered();

        void setDateOrdered(Date dateOrdered);

        Boolean getIsPrinted();

        void setIsPrinted(Boolean isPrinted);

        String getMovementTypeId();

        void setMovementTypeId(String movementTypeId);

        Date getMovementDate();

        void setMovementDate(Date movementDate);

        String getBusinessPartnerId();

        void setBusinessPartnerId(String businessPartnerId);

        String getWarehouseId();

        void setWarehouseId(String warehouseId);

        String getPOReference();

        void setPOReference(String poReference);

        BigDecimal getFreightAmount();

        void setFreightAmount(BigDecimal freightAmount);

        String getShipperId();

        void setShipperId(String shipperId);

        BigDecimal getChargeAmount();

        void setChargeAmount(BigDecimal chargeAmount);

        Date getDatePrinted();

        void setDatePrinted(Date datePrinted);

        String getCreatedFrom();

        void setCreatedFrom(String createdFrom);

        String getSalesRepresentativeId();

        void setSalesRepresentativeId(String salesRepresentativeId);

        Integer getNumberOfPackages();

        void setNumberOfPackages(Integer numberOfPackages);

        Date getPickDate();

        void setPickDate(Date pickDate);

        Date getShipDate();

        void setShipDate(Date shipDate);

        String getTrackingNumber();

        void setTrackingNumber(String trackingNumber);

        Date getDateReceived();

        void setDateReceived(Date dateReceived);

        Boolean getIsInTransit();

        void setIsInTransit(Boolean isInTransit);

        Boolean getIsApproved();

        void setIsApproved(Boolean isApproved);

        Boolean getIsInDispute();

        void setIsInDispute(Boolean isInDispute);

        String getRmaDocumentNumber();

        void setRmaDocumentNumber(String rmaDocumentNumber);

        String getReversalDocumentNumber();

        void setReversalDocumentNumber(String reversalDocumentNumber);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface InOutStateCreated extends InOutStateEvent
    {
        Iterable<InOutImageEvent.InOutImageStateCreated> getInOutImageEvents();
        
        void addInOutImageEvent(InOutImageEvent.InOutImageStateCreated e);

        InOutImageEvent.InOutImageStateCreated newInOutImageStateCreated(String sequenceId);

        Iterable<InOutLineEvent.InOutLineStateCreated> getInOutLineEvents();
        
        void addInOutLineEvent(InOutLineEvent.InOutLineStateCreated e);

        InOutLineEvent.InOutLineStateCreated newInOutLineStateCreated(String lineNumber);

    
    }


    interface InOutStateMergePatched extends InOutStateEvent
    {
        Boolean getIsPropertyDocumentStatusIdRemoved();

        void setIsPropertyDocumentStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyPostedRemoved();

        void setIsPropertyPostedRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyProcessingRemoved();

        void setIsPropertyProcessingRemoved(Boolean removed);

        Boolean getIsPropertyDocumentTypeIdRemoved();

        void setIsPropertyDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyOrderIdRemoved();

        void setIsPropertyOrderIdRemoved(Boolean removed);

        Boolean getIsPropertyDateOrderedRemoved();

        void setIsPropertyDateOrderedRemoved(Boolean removed);

        Boolean getIsPropertyIsPrintedRemoved();

        void setIsPropertyIsPrintedRemoved(Boolean removed);

        Boolean getIsPropertyMovementTypeIdRemoved();

        void setIsPropertyMovementTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementDateRemoved();

        void setIsPropertyMovementDateRemoved(Boolean removed);

        Boolean getIsPropertyBusinessPartnerIdRemoved();

        void setIsPropertyBusinessPartnerIdRemoved(Boolean removed);

        Boolean getIsPropertyWarehouseIdRemoved();

        void setIsPropertyWarehouseIdRemoved(Boolean removed);

        Boolean getIsPropertyPOReferenceRemoved();

        void setIsPropertyPOReferenceRemoved(Boolean removed);

        Boolean getIsPropertyFreightAmountRemoved();

        void setIsPropertyFreightAmountRemoved(Boolean removed);

        Boolean getIsPropertyShipperIdRemoved();

        void setIsPropertyShipperIdRemoved(Boolean removed);

        Boolean getIsPropertyChargeAmountRemoved();

        void setIsPropertyChargeAmountRemoved(Boolean removed);

        Boolean getIsPropertyDatePrintedRemoved();

        void setIsPropertyDatePrintedRemoved(Boolean removed);

        Boolean getIsPropertyCreatedFromRemoved();

        void setIsPropertyCreatedFromRemoved(Boolean removed);

        Boolean getIsPropertySalesRepresentativeIdRemoved();

        void setIsPropertySalesRepresentativeIdRemoved(Boolean removed);

        Boolean getIsPropertyNumberOfPackagesRemoved();

        void setIsPropertyNumberOfPackagesRemoved(Boolean removed);

        Boolean getIsPropertyPickDateRemoved();

        void setIsPropertyPickDateRemoved(Boolean removed);

        Boolean getIsPropertyShipDateRemoved();

        void setIsPropertyShipDateRemoved(Boolean removed);

        Boolean getIsPropertyTrackingNumberRemoved();

        void setIsPropertyTrackingNumberRemoved(Boolean removed);

        Boolean getIsPropertyDateReceivedRemoved();

        void setIsPropertyDateReceivedRemoved(Boolean removed);

        Boolean getIsPropertyIsInTransitRemoved();

        void setIsPropertyIsInTransitRemoved(Boolean removed);

        Boolean getIsPropertyIsApprovedRemoved();

        void setIsPropertyIsApprovedRemoved(Boolean removed);

        Boolean getIsPropertyIsInDisputeRemoved();

        void setIsPropertyIsInDisputeRemoved(Boolean removed);

        Boolean getIsPropertyRmaDocumentNumberRemoved();

        void setIsPropertyRmaDocumentNumberRemoved(Boolean removed);

        Boolean getIsPropertyReversalDocumentNumberRemoved();

        void setIsPropertyReversalDocumentNumberRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Iterable<InOutImageEvent> getInOutImageEvents();
        
        void addInOutImageEvent(InOutImageEvent e);

        InOutImageEvent.InOutImageStateCreated newInOutImageStateCreated(String sequenceId);

        InOutImageEvent.InOutImageStateMergePatched newInOutImageStateMergePatched(String sequenceId);

        InOutImageEvent.InOutImageStateRemoved newInOutImageStateRemoved(String sequenceId);

        Iterable<InOutLineEvent> getInOutLineEvents();
        
        void addInOutLineEvent(InOutLineEvent e);

        InOutLineEvent.InOutLineStateCreated newInOutLineStateCreated(String lineNumber);

        InOutLineEvent.InOutLineStateMergePatched newInOutLineStateMergePatched(String lineNumber);

        InOutLineEvent.InOutLineStateRemoved newInOutLineStateRemoved(String lineNumber);


    }


}

