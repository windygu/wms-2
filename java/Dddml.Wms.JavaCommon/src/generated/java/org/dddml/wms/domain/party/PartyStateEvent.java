package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PartyStateEvent extends Event
{
    PartyEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getPartyTypeId();

    void setPartyTypeId(String partyTypeId);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface PartyStateCreated extends PartyStateEvent
    {
    
    }


    interface PartyStateMergePatched extends PartyStateEvent
    {
        Boolean getIsPropertyPartyTypeIdRemoved();

        void setIsPropertyPartyTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface PartyStateDeleted extends PartyStateEvent
    {
    }


}

