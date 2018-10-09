package org.dddml.wms.domain.physicalinventory;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.physicalinventory.PhysicalInventoryEvent.*;

public interface PhysicalInventoryState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDocumentNumber();

    String getDocumentStatusId();

    String getWarehouseId();

    String getLocatorIdPattern();

    String getProductIdPattern();

    Boolean getPosted();

    Boolean getProcessed();

    String getProcessing();

    String getDocumentTypeId();

    Date getMovementDate();

    String getDescription();

    Boolean getIsApproved();

    BigDecimal getApprovalAmount();

    Boolean getIsQuantityUpdated();

    String getReversalDocumentNumber();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    EntityStateCollection<InventoryItemId, PhysicalInventoryLineState> getPhysicalInventoryLines();

    interface MutablePhysicalInventoryState extends PhysicalInventoryState {
        void setDocumentNumber(String documentNumber);

        void setDocumentStatusId(String documentStatusId);

        void setWarehouseId(String warehouseId);

        void setLocatorIdPattern(String locatorIdPattern);

        void setProductIdPattern(String productIdPattern);

        void setPosted(Boolean posted);

        void setProcessed(Boolean processed);

        void setProcessing(String processing);

        void setDocumentTypeId(String documentTypeId);

        void setMovementDate(Date movementDate);

        void setDescription(String description);

        void setIsApproved(Boolean isApproved);

        void setApprovalAmount(BigDecimal approvalAmount);

        void setIsQuantityUpdated(Boolean isQuantityUpdated);

        void setReversalDocumentNumber(String reversalDocumentNumber);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);


        void mutate(Event e);

        void when(PhysicalInventoryEvent.PhysicalInventoryStateCreated e);

        void when(PhysicalInventoryEvent.PhysicalInventoryStateMergePatched e);

    }

    interface SqlPhysicalInventoryState extends MutablePhysicalInventoryState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

