package org.dddml.wms.domain.partyrole;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PartyRoleStateEvent extends Event
{
    PartyRoleEventId getPartyRoleEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface PartyRoleStateCreated extends PartyRoleStateEvent
    {
    
    }


    interface PartyRoleStateMergePatched extends PartyRoleStateEvent
    {
        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface PartyRoleStateDeleted extends PartyRoleStateEvent
    {
    }


}

