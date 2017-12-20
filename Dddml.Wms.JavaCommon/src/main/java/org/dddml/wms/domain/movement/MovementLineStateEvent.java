package org.dddml.wms.domain.movement;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface MovementLineStateEvent extends Event
{
    MovementLineStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    Long getVersion();

    void setVersion(Long version);

    BigDecimal getMovementQuantity();

    void setMovementQuantity(BigDecimal movementQuantity);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface MovementLineStateCreated extends MovementLineStateEvent
    {
    
    }


    interface MovementLineStateMergePatched extends MovementLineStateEvent
    {
        Boolean getIsPropertyMovementQuantityRemoved();

        void setIsPropertyMovementQuantityRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface MovementLineStateRemoved extends MovementLineStateEvent
    {
    }


}

