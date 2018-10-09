package org.dddml.wms.domain.movement;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.movement.MovementLineEvent.*;

public interface MovementLineState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getLineNumber();

    BigDecimal getMovementQuantity();

    String getProductId();

    String getLocatorIdFrom();

    String getLocatorIdTo();

    String getAttributeSetInstanceId();

    Boolean getProcessed();

    String getReversalLineNumber();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getMovementDocumentNumber();

    interface MutableMovementLineState extends MovementLineState {
        void setMovementLineId(MovementLineId movementLineId);

        void setLineNumber(String lineNumber);

        void setMovementQuantity(BigDecimal movementQuantity);

        void setProductId(String productId);

        void setLocatorIdFrom(String locatorIdFrom);

        void setLocatorIdTo(String locatorIdTo);

        void setAttributeSetInstanceId(String attributeSetInstanceId);

        void setProcessed(Boolean processed);

        void setReversalLineNumber(String reversalLineNumber);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setMovementDocumentNumber(String movementDocumentNumber);


        void mutate(Event e);

        void when(MovementLineEvent.MovementLineStateCreated e);

        void when(MovementLineEvent.MovementLineStateMergePatched e);

        void when(MovementLineEvent.MovementLineStateRemoved e);
    }

    interface SqlMovementLineState extends MutableMovementLineState {
        MovementLineId getMovementLineId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

