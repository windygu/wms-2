package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.specialization.Event;

public interface RolePermissionStateEvent extends Event
{
    RolePermissionStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    

    interface RolePermissionStateCreated extends RolePermissionStateEvent
    {
    
    }


    interface RolePermissionStateMergePatched extends RolePermissionStateEvent
    {
        Boolean isPropertyActiveRemoved();

        void setPropertyActiveRemoved(Boolean removed);


    }

    interface RolePermissionStateDeleted extends RolePermissionStateEvent
    {
    }


}

