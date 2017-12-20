package org.dddml.wms.domain.movement;

import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.movement.MovementLineStateEvent.*;

public interface MovementLineState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    MovementLineId getMovementLineId();

    void setMovementLineId(MovementLineId movementLineId);

    String getLineNumber();

    void setLineNumber(String lineNumber);

    BigDecimal getMovementQuantity();

    void setMovementQuantity(BigDecimal movementQuantity);

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

    String getMovementDocumentNumber();

    void setMovementDocumentNumber(String movementDocumentNumber);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(MovementLineStateEvent.MovementLineStateCreated e);

    void when(MovementLineStateEvent.MovementLineStateMergePatched e);

    void when(MovementLineStateEvent.MovementLineStateRemoved e);
    
}

