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

    PhysicalInventoryLineId getPhysicalInventoryLineId();

    void setPhysicalInventoryLineId(PhysicalInventoryLineId physicalInventoryLineId);

    InventoryItemId getInventoryItemId();

    void setInventoryItemId(InventoryItemId inventoryItemId);

    BigDecimal getBookQuantity();

    void setBookQuantity(BigDecimal bookQuantity);

    BigDecimal getCountedQuantity();

    void setCountedQuantity(BigDecimal countedQuantity);

    Boolean getProcessed();

    void setProcessed(Boolean processed);

    String getLineNumber();

    void setLineNumber(String lineNumber);

    String getReversalLineNumber();

    void setReversalLineNumber(String reversalLineNumber);

    String getDescription();

    void setDescription(String description);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

    String getPhysicalInventoryDocumentNumber();

    void setPhysicalInventoryDocumentNumber(String physicalInventoryDocumentNumber);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(PhysicalInventoryLineEvent.PhysicalInventoryLineStateCreated e);

    void when(PhysicalInventoryLineEvent.PhysicalInventoryLineStateMergePatched e);

    void when(PhysicalInventoryLineEvent.PhysicalInventoryLineStateRemoved e);
    
}

