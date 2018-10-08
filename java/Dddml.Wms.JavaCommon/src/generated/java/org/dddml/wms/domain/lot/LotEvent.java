package org.dddml.wms.domain.lot;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface LotEvent extends Event {

    interface SqlLotEvent extends LotEvent {
        LotEventId getLotEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    String getLotId();

    //void setLotId(String lotId);

    Long getVersion();
    
    //void getVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface LotStateEvent extends LotEvent {
        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        java.sql.Timestamp getExpirationDate();

        void setExpirationDate(java.sql.Timestamp expirationDate);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface LotStateCreated extends LotStateEvent
    {
    
    }


    interface LotStateMergePatched extends LotStateEvent
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyExpirationDateRemoved();

        void setIsPropertyExpirationDateRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface LotStateDeleted extends LotStateEvent
    {
    }


}

