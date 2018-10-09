package org.dddml.wms.domain.physicalinventory;

import java.util.Set;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.physicalinventory.PhysicalInventoryLineEvent.*;

public interface PhysicalInventoryLineState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InventoryItemId getInventoryItemId();

    BigDecimal getBookQuantity();

    BigDecimal getCountedQuantity();

    Boolean getProcessed();

    String getLineNumber();

    String getReversalLineNumber();

    String getDescription();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getDeleted();

    String getPhysicalInventoryDocumentNumber();

    interface MutablePhysicalInventoryLineState extends PhysicalInventoryLineState {
        void setPhysicalInventoryLineId(PhysicalInventoryLineId physicalInventoryLineId);

        void setInventoryItemId(InventoryItemId inventoryItemId);

        void setBookQuantity(BigDecimal bookQuantity);

        void setCountedQuantity(BigDecimal countedQuantity);

        void setProcessed(Boolean processed);

        void setLineNumber(String lineNumber);

        void setReversalLineNumber(String reversalLineNumber);

        void setDescription(String description);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setDeleted(Boolean deleted);

        void setPhysicalInventoryDocumentNumber(String physicalInventoryDocumentNumber);


        void mutate(Event e);

        void when(PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated e);

        void when(PhysicalInventoryLineEvent.PhysicalInventoryLineStateMergePatched e);

        void when(PhysicalInventoryLineEvent.PhysicalInventoryLineStateRemoved e);
    }

    interface SqlPhysicalInventoryLineState extends MutablePhysicalInventoryLineState {
        PhysicalInventoryLineId getPhysicalInventoryLineId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

