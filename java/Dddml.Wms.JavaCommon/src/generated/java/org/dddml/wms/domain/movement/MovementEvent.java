package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface MovementEvent extends Event
{
    MovementEventId getMovementEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface MovementStateEvent extends MovementEvent {
        String getDocumentStatusId();

        void setDocumentStatusId(String documentStatusId);

        Date getMovementDate();

        void setMovementDate(Date movementDate);

        Boolean getPosted();

        void setPosted(Boolean posted);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        String getProcessing();

        void setProcessing(String processing);

        Date getDateReceived();

        void setDateReceived(Date dateReceived);

        String getDocumentTypeId();

        void setDocumentTypeId(String documentTypeId);

        Boolean getIsInTransit();

        void setIsInTransit(Boolean isInTransit);

        Boolean getIsApproved();

        void setIsApproved(Boolean isApproved);

        BigDecimal getApprovalAmount();

        void setApprovalAmount(BigDecimal approvalAmount);

        String getShipperId();

        void setShipperId(String shipperId);

        String getSalesRepresentativeId();

        void setSalesRepresentativeId(String salesRepresentativeId);

        String getBusinessPartnerId();

        void setBusinessPartnerId(String businessPartnerId);

        BigDecimal getChargeAmount();

        void setChargeAmount(BigDecimal chargeAmount);

        String getCreateFrom();

        void setCreateFrom(String createFrom);

        BigDecimal getFreightAmount();

        void setFreightAmount(BigDecimal freightAmount);

        String getReversalDocumentNumber();

        void setReversalDocumentNumber(String reversalDocumentNumber);

        String getWarehouseIdFrom();

        void setWarehouseIdFrom(String warehouseIdFrom);

        String getWarehouseIdTo();

        void setWarehouseIdTo(String warehouseIdTo);

        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface MovementStateCreated extends MovementStateEvent
    {
        Iterable<MovementLineEvent.MovementLineStateCreated> getMovementLineEvents();
        
        void addMovementLineEvent(MovementLineEvent.MovementLineStateCreated e);

        MovementLineEvent.MovementLineStateCreated newMovementLineStateCreated(String lineNumber);

    
    }


    interface MovementStateMergePatched extends MovementStateEvent
    {
        Boolean getIsPropertyDocumentStatusIdRemoved();

        void setIsPropertyDocumentStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementDateRemoved();

        void setIsPropertyMovementDateRemoved(Boolean removed);

        Boolean getIsPropertyPostedRemoved();

        void setIsPropertyPostedRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyProcessingRemoved();

        void setIsPropertyProcessingRemoved(Boolean removed);

        Boolean getIsPropertyDateReceivedRemoved();

        void setIsPropertyDateReceivedRemoved(Boolean removed);

        Boolean getIsPropertyDocumentTypeIdRemoved();

        void setIsPropertyDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyIsInTransitRemoved();

        void setIsPropertyIsInTransitRemoved(Boolean removed);

        Boolean getIsPropertyIsApprovedRemoved();

        void setIsPropertyIsApprovedRemoved(Boolean removed);

        Boolean getIsPropertyApprovalAmountRemoved();

        void setIsPropertyApprovalAmountRemoved(Boolean removed);

        Boolean getIsPropertyShipperIdRemoved();

        void setIsPropertyShipperIdRemoved(Boolean removed);

        Boolean getIsPropertySalesRepresentativeIdRemoved();

        void setIsPropertySalesRepresentativeIdRemoved(Boolean removed);

        Boolean getIsPropertyBusinessPartnerIdRemoved();

        void setIsPropertyBusinessPartnerIdRemoved(Boolean removed);

        Boolean getIsPropertyChargeAmountRemoved();

        void setIsPropertyChargeAmountRemoved(Boolean removed);

        Boolean getIsPropertyCreateFromRemoved();

        void setIsPropertyCreateFromRemoved(Boolean removed);

        Boolean getIsPropertyFreightAmountRemoved();

        void setIsPropertyFreightAmountRemoved(Boolean removed);

        Boolean getIsPropertyReversalDocumentNumberRemoved();

        void setIsPropertyReversalDocumentNumberRemoved(Boolean removed);

        Boolean getIsPropertyWarehouseIdFromRemoved();

        void setIsPropertyWarehouseIdFromRemoved(Boolean removed);

        Boolean getIsPropertyWarehouseIdToRemoved();

        void setIsPropertyWarehouseIdToRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Iterable<MovementLineEvent> getMovementLineEvents();
        
        void addMovementLineEvent(MovementLineEvent e);

        MovementLineEvent.MovementLineStateCreated newMovementLineStateCreated(String lineNumber);

        MovementLineEvent.MovementLineStateMergePatched newMovementLineStateMergePatched(String lineNumber);

        MovementLineEvent.MovementLineStateRemoved newMovementLineStateRemoved(String lineNumber);


    }

    interface MovementStateDeleted extends MovementStateEvent
    {
        Iterable<MovementLineEvent.MovementLineStateRemoved> getMovementLineEvents();
        
        void addMovementLineEvent(MovementLineEvent.MovementLineStateRemoved e);
        
        MovementLineEvent.MovementLineStateRemoved newMovementLineStateRemoved(String lineNumber);

    }


}

