package org.dddml.wms.domain.lot;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface LotEvent extends Event
{
    LotEventId getLotEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    java.sql.Timestamp getExpirationDate();

    void setExpirationDate(java.sql.Timestamp expirationDate);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface LotStateCreated extends LotEvent
    {
    
    }


    interface LotStateMergePatched extends LotEvent
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyExpirationDateRemoved();

        void setIsPropertyExpirationDateRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface LotStateDeleted extends LotEvent
    {
    }


}

