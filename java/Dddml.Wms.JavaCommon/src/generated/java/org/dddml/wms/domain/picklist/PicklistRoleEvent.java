package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PicklistRoleEvent extends Event {

    interface SqlPicklistRoleEvent extends PicklistRoleEvent {
        PicklistRoleEventId getPicklistRoleEventId();
    }

    PartyRoleId getPartyRoleId();

    //void setPartyRoleId(PartyRoleId partyRoleId);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedByUserLogin();

    void setCreatedByUserLogin(String createdByUserLogin);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface PicklistRoleStateEvent extends PicklistRoleEvent {
        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface PicklistRoleStateCreated extends PicklistRoleStateEvent
    {
    
    }


    interface PicklistRoleStateMergePatched extends PicklistRoleStateEvent
    {
        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface PicklistRoleStateRemoved extends PicklistRoleStateEvent
    {
    }


}

