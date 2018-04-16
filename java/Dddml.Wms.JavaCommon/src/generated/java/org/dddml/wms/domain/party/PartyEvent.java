package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PartyEvent extends Event
{
    PartyEventId getPartyEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface PartyStateEvent extends PartyEvent {
        String getPartyTypeId();

        void setPartyTypeId(String partyTypeId);

        String getPrimaryRoleTypeId();

        void setPrimaryRoleTypeId(String primaryRoleTypeId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface PartyStateCreated extends PartyStateEvent
    {
    
    }


    interface PartyStateMergePatched extends PartyStateEvent
    {
        Boolean getIsPropertyPartyTypeIdRemoved();

        void setIsPropertyPartyTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryRoleTypeIdRemoved();

        void setIsPropertyPrimaryRoleTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface PartyStateDeleted extends PartyStateEvent
    {
    }


}

