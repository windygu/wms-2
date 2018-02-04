package org.dddml.wms.domain.physicalinventory;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.physicalinventory.PhysicalInventoryLineStateEvent.*;

public interface PhysicalInventoryLineState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    PhysicalInventoryLineId getPhysicalInventoryLineId();

    void setPhysicalInventoryLineId(PhysicalInventoryLineId physicalInventoryLineId);

    String getLineNumber();

    void setLineNumber(String lineNumber);

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

    String getPhysicalInventoryDocumentNumber();

    void setPhysicalInventoryDocumentNumber(String physicalInventoryDocumentNumber);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateCreated e);

    void when(PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateMergePatched e);

    void when(PhysicalInventoryLineStateEvent.PhysicalInventoryLineStateRemoved e);
    
}
