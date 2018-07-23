package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InOutLineEvent extends Event
{
    InOutLineEventId getInOutLineEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InOutLineStateEvent extends InOutLineEvent {
        Long getVersion();

        void setVersion(Long version);

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

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface InOutLineStateCreated extends InOutLineStateEvent
    {
        Iterable<InOutLineImageEvent.InOutLineImageStateCreated> getInOutLineImageEvents();
        
        void addInOutLineImageEvent(InOutLineImageEvent.InOutLineImageStateCreated e);

        InOutLineImageEvent.InOutLineImageStateCreated newInOutLineImageStateCreated(String sequenceId);

    
    }


    interface InOutLineStateMergePatched extends InOutLineStateEvent
    {
        Boolean getIsPropertyLocatorIdRemoved();

        void setIsPropertyLocatorIdRemoved(Boolean removed);

        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyQuantityUomIdRemoved();

        void setIsPropertyQuantityUomIdRemoved(Boolean removed);

        Boolean getIsPropertyMovementQuantityRemoved();

        void setIsPropertyMovementQuantityRemoved(Boolean removed);

        Boolean getIsPropertyPickedQuantityRemoved();

        void setIsPropertyPickedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyIsInvoicedRemoved();

        void setIsPropertyIsInvoicedRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyRmaLineNumberRemoved();

        void setIsPropertyRmaLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyReversalLineNumberRemoved();

        void setIsPropertyReversalLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Iterable<InOutLineImageEvent> getInOutLineImageEvents();
        
        void addInOutLineImageEvent(InOutLineImageEvent e);

        InOutLineImageEvent.InOutLineImageStateCreated newInOutLineImageStateCreated(String sequenceId);

        InOutLineImageEvent.InOutLineImageStateMergePatched newInOutLineImageStateMergePatched(String sequenceId);

        InOutLineImageEvent.InOutLineImageStateRemoved newInOutLineImageStateRemoved(String sequenceId);


    }

    interface InOutLineStateRemoved extends InOutLineStateEvent
    {
        Iterable<InOutLineImageEvent.InOutLineImageStateRemoved> getInOutLineImageEvents();
        
        void addInOutLineImageEvent(InOutLineImageEvent.InOutLineImageStateRemoved e);
        
        InOutLineImageEvent.InOutLineImageStateRemoved newInOutLineImageStateRemoved(String sequenceId);

    }


}

