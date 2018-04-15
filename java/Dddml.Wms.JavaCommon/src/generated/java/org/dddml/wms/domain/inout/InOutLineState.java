package org.dddml.wms.domain.inout;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inout.InOutLineEvent.*;

public interface InOutLineState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    InOutLineId getInOutLineId();

    void setInOutLineId(InOutLineId inOutLineId);

    String getLineNumber();

    void setLineNumber(String lineNumber);

    String getLocatorId();

    void setLocatorId(String locatorId);

    String getProductId();

    void setProductId(String productId);

    String getAttributeSetInstanceId();

    void setAttributeSetInstanceId(String attributeSetInstanceId);

    String getDescription();

    void setDescription(String description);

    String getQuantityUomId();

    void setQuantityUomId(String quantityUomId);

    BigDecimal getMovementQuantity();

    void setMovementQuantity(BigDecimal movementQuantity);

    BigDecimal getPickedQuantity();

    void setPickedQuantity(BigDecimal pickedQuantity);

    Boolean getIsInvoiced();

    void setIsInvoiced(Boolean isInvoiced);

    Boolean getProcessed();

    void setProcessed(Boolean processed);

    String getRmaLineNumber();

    void setRmaLineNumber(String rmaLineNumber);

    String getReversalLineNumber();

    void setReversalLineNumber(String reversalLineNumber);

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

    String getInOutDocumentNumber();

    void setInOutDocumentNumber(String inOutDocumentNumber);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(InOutLineEvent.InOutLineStateCreated e);

    void when(InOutLineEvent.InOutLineStateMergePatched e);

    void when(InOutLineEvent.InOutLineStateRemoved e);
    
}

