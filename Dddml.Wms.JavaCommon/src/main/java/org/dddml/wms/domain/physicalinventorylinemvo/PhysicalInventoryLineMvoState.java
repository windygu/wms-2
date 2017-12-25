package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.Set;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.physicalinventorylinemvo.PhysicalInventoryLineMvoStateEvent.*;

public interface PhysicalInventoryLineMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    PhysicalInventoryLineId getPhysicalInventoryLineId();

    void setPhysicalInventoryLineId(PhysicalInventoryLineId physicalInventoryLineId);

    String getLocatorId();

    void setLocatorId(String locatorId);

    String getProductId();

    void setProductId(String productId);

    String getAttributeSetInstanceId();

    void setAttributeSetInstanceId(String attributeSetInstanceId);

    BigDecimal getBookQuantity();

    void setBookQuantity(BigDecimal bookQuantity);

    BigDecimal getCountedQuantity();

    void setCountedQuantity(BigDecimal countedQuantity);

    Boolean getProcessed();

    void setProcessed(Boolean processed);

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

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

    String getPhysicalInventoryDocumentStatusId();

    void setPhysicalInventoryDocumentStatusId(String physicalInventoryDocumentStatusId);

    String getPhysicalInventoryWarehouseId();

    void setPhysicalInventoryWarehouseId(String physicalInventoryWarehouseId);

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

    Boolean getPhysicalInventoryDeleted();

    void setPhysicalInventoryDeleted(Boolean physicalInventoryDeleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateCreated e);

    void when(PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateMergePatched e);

    void when(PhysicalInventoryLineMvoStateEvent.PhysicalInventoryLineMvoStateDeleted e);
    
}

