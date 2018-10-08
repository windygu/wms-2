package org.dddml.wms.domain.order;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrderRoleEvent extends Event {

    interface SqlOrderRoleEvent extends OrderRoleEvent {
        OrderRoleEventId getOrderRoleEventId();
    }

    PartyRoleId getPartyRoleId();

    //void setPartyRoleId(PartyRoleId partyRoleId);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface OrderRoleStateEvent extends OrderRoleEvent {
        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface OrderRoleStateCreated extends OrderRoleStateEvent
    {
    
    }


    interface OrderRoleStateMergePatched extends OrderRoleStateEvent
    {
        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface OrderRoleStateRemoved extends OrderRoleStateEvent
    {
    }


}

