package org.dddml.wms.domain.physicalinventory;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.physicalinventory.PhysicalInventoryStateEvent.*;

public interface PhysicalInventoryState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDocumentNumber();

    void setDocumentNumber(String documentNumber);

    String getDocumentStatusId();

    void setDocumentStatusId(String documentStatusId);

    String getWarehouseId();

    void setWarehouseId(String warehouseId);

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

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);


    boolean isStateUnsaved();

    boolean getForReapplying();

    PhysicalInventoryLineStates getPhysicalInventoryLines();


    void mutate(Event e);

    void when(PhysicalInventoryStateEvent.PhysicalInventoryStateCreated e);

    void when(PhysicalInventoryStateEvent.PhysicalInventoryStateMergePatched e);

    void when(PhysicalInventoryStateEvent.PhysicalInventoryStateDeleted e);
    
}

