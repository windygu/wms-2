package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PicklistRoleStateEvent extends Event
{
    PicklistRoleEventId getPicklistRoleEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedByUserLogin();

    void setCreatedByUserLogin(String createdByUserLogin);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

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

