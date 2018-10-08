package org.dddml.wms.domain.movement;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface MovementLineEvent extends Event {

    interface SqlMovementLineEvent extends MovementLineEvent {
        MovementLineEventId getMovementLineEventId();
    }

    String getLineNumber();

    //void setLineNumber(String lineNumber);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface MovementLineStateEvent extends MovementLineEvent {
        Long getVersion();

        void setVersion(Long version);

        BigDecimal getMovementQuantity();

        void setMovementQuantity(BigDecimal movementQuantity);

        String getProductId();

        void setProductId(String productId);

        String getLocatorIdFrom();

        void setLocatorIdFrom(String locatorIdFrom);

        String getLocatorIdTo();

        void setLocatorIdTo(String locatorIdTo);

        String getAttributeSetInstanceId();

        void setAttributeSetInstanceId(String attributeSetInstanceId);

        Boolean getProcessed();

        void setProcessed(Boolean processed);

        String getReversalLineNumber();

        void setReversalLineNumber(String reversalLineNumber);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface MovementLineStateCreated extends MovementLineStateEvent
    {
    
    }


    interface MovementLineStateMergePatched extends MovementLineStateEvent
    {
        Boolean getIsPropertyMovementQuantityRemoved();

        void setIsPropertyMovementQuantityRemoved(Boolean removed);

        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyLocatorIdFromRemoved();

        void setIsPropertyLocatorIdFromRemoved(Boolean removed);

        Boolean getIsPropertyLocatorIdToRemoved();

        void setIsPropertyLocatorIdToRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyProcessedRemoved();

        void setIsPropertyProcessedRemoved(Boolean removed);

        Boolean getIsPropertyReversalLineNumberRemoved();

        void setIsPropertyReversalLineNumberRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface MovementLineStateRemoved extends MovementLineStateEvent
    {
    }


}

