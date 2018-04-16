package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PhysicalInventoryEvent extends Event
{
    PhysicalInventoryEventId getPhysicalInventoryEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface PhysicalInventoryStateEvent extends PhysicalInventoryEvent {
        String getDocumentStatusId();

        void setDocumentStatusId(String documentStatusId);

        String getWarehouseId();

        void setWarehouseId(String warehouseId);

        String getLocatorIdPattern();

        void setLocatorIdPattern(String locatorIdPattern);

        String getProductIdPattern();

        void setProductIdPattern(String productIdPattern);

        Boolean getPosted();

        void setPosted(Boolean posted);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        String getProcessing();

        void setProcessing(String processing);

        String getDocumentTypeId();

        void setDocumentTypeId(String documentTypeId);

        Date getMovementDate();

        void setMovementDate(Date movementDate);

        String getDescription();

        void setDescription(String description);

        Boolean getIsApproved();

        void setIsApproved(Boolean isApproved);

        BigDecimal getApprovalAmount();

        void setApprovalAmount(BigDecimal approvalAmount);

        Boolean getIsQuantityUpdated();

        void setIsQuantityUpdated(Boolean isQuantityUpdated);

        String getReversalDocumentNumber();

        void setReversalDocumentNumber(String reversalDocumentNumber);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface PhysicalInventoryStateCreated extends PhysicalInventoryStateEvent
    {
        Iterable<PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated> getPhysicalInventoryLineEvents();
        
        void addPhysicalInventoryLineEvent(PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated e);

        PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated newPhysicalInventoryLineStateCreated(InventoryItemId inventoryItemId);

    
    }


    interface PhysicalInventoryStateMergePatched extends PhysicalInventoryStateEvent
    {
        Boolean getIsPropertyDocumentStatusIdRemoved();

        void setIsPropertyDocumentStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyWarehouseIdRemoved();

        void setIsPropertyWarehouseIdRemoved(Boolean removed);

        Boolean getIsPropertyLocatorIdPatternRemoved();

        void setIsPropertyLocatorIdPatternRemoved(Boolean removed);

        Boolean getIsPropertyProductIdPatternRemoved();

        void setIsPropertyProductIdPatternRemoved(Boolean removed);

        Boolean getIsPropertyPostedRemoved();

        void setIsPropertyPostedRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyProcessingRemoved();

        void setIsPropertyProcessingRemoved(Boolean removed);

        Boolean getIsPropertyDocumentTypeIdRemoved();

        void setIsPropertyDocumentTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementDateRemoved();

        void setIsPropertyMovementDateRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyIsApprovedRemoved();

        void setIsPropertyIsApprovedRemoved(Boolean removed);

        Boolean getIsPropertyApprovalAmountRemoved();

        void setIsPropertyApprovalAmountRemoved(Boolean removed);

        Boolean getIsPropertyIsQuantityUpdatedRemoved();

        void setIsPropertyIsQuantityUpdatedRemoved(Boolean removed);

        Boolean getIsPropertyReversalDocumentNumberRemoved();

        void setIsPropertyReversalDocumentNumberRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Iterable<PhysicalInventoryLineEvent> getPhysicalInventoryLineEvents();
        
        void addPhysicalInventoryLineEvent(PhysicalInventoryLineEvent e);

        PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated newPhysicalInventoryLineStateCreated(InventoryItemId inventoryItemId);

        PhysicalInventoryLineEvent.PhysicalInventoryLineStateMergePatched newPhysicalInventoryLineStateMergePatched(InventoryItemId inventoryItemId);

        PhysicalInventoryLineEvent.PhysicalInventoryLineStateRemoved newPhysicalInventoryLineStateRemoved(InventoryItemId inventoryItemId);


    }


}

