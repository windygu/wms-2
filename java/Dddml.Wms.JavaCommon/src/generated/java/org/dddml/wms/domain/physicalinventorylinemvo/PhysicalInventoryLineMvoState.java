package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.Set;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.physicalinventorylinemvo.PhysicalInventoryLineMvoEvent.*;

public interface PhysicalInventoryLineMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    PhysicalInventoryLineId getPhysicalInventoryLineId();

    void setPhysicalInventoryLineId(PhysicalInventoryLineId physicalInventoryLineId);

    BigDecimal getBookQuantity();

    void setBookQuantity(BigDecimal bookQuantity);

    BigDecimal getCountedQuantity();

    void setCountedQuantity(BigDecimal countedQuantity);

    Boolean getProcessed();

    void setProcessed(Boolean processed);

    String getLineNumber();

    void setLineNumber(String lineNumber);

    Long getReversalLineNumber();

    void setReversalLineNumber(Long reversalLineNumber);

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

    String getPhysicalInventoryDocumentStatusId();

    void setPhysicalInventoryDocumentStatusId(String physicalInventoryDocumentStatusId);

    String getPhysicalInventoryWarehouseId();

    void setPhysicalInventoryWarehouseId(String physicalInventoryWarehouseId);

    String getPhysicalInventoryLocatorIdPattern();

    void setPhysicalInventoryLocatorIdPattern(String physicalInventoryLocatorIdPattern);

    String getPhysicalInventoryProductIdPattern();

    void setPhysicalInventoryProductIdPattern(String physicalInventoryProductIdPattern);

    Boolean getPhysicalInventoryPosted();

    void setPhysicalInventoryPosted(Boolean physicalInventoryPosted);

    Boolean getPhysicalInventoryProcessed();

    void setPhysicalInventoryProcessed(Boolean physicalInventoryProcessed);

    String getPhysicalInventoryProcessing();

    void setPhysicalInventoryProcessing(String physicalInventoryProcessing);

    String getPhysicalInventoryDocumentTypeId();

    void setPhysicalInventoryDocumentTypeId(String physicalInventoryDocumentTypeId);

    Date getPhysicalInventoryMovementDate();

    void setPhysicalInventoryMovementDate(Date physicalInventoryMovementDate);

    String getPhysicalInventoryDescription();

    void setPhysicalInventoryDescription(String physicalInventoryDescription);

    Boolean getPhysicalInventoryIsApproved();

    void setPhysicalInventoryIsApproved(Boolean physicalInventoryIsApproved);

    BigDecimal getPhysicalInventoryApprovalAmount();

    void setPhysicalInventoryApprovalAmount(BigDecimal physicalInventoryApprovalAmount);

    Boolean getPhysicalInventoryIsQuantityUpdated();

    void setPhysicalInventoryIsQuantityUpdated(Boolean physicalInventoryIsQuantityUpdated);

    String getPhysicalInventoryReversalDocumentNumber();

    void setPhysicalInventoryReversalDocumentNumber(String physicalInventoryReversalDocumentNumber);

    Long getPhysicalInventoryVersion();

    void setPhysicalInventoryVersion(Long physicalInventoryVersion);

    String getPhysicalInventoryCreatedBy();

    void setPhysicalInventoryCreatedBy(String physicalInventoryCreatedBy);

    Date getPhysicalInventoryCreatedAt();

    void setPhysicalInventoryCreatedAt(Date physicalInventoryCreatedAt);

    String getPhysicalInventoryUpdatedBy();

    void setPhysicalInventoryUpdatedBy(String physicalInventoryUpdatedBy);

    Date getPhysicalInventoryUpdatedAt();

    void setPhysicalInventoryUpdatedAt(Date physicalInventoryUpdatedAt);

    Boolean getPhysicalInventoryActive();

    void setPhysicalInventoryActive(Boolean physicalInventoryActive);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateCreated e);

    void when(PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateMergePatched e);

    void when(PhysicalInventoryLineMvoEvent.PhysicalInventoryLineMvoStateDeleted e);
    
}

