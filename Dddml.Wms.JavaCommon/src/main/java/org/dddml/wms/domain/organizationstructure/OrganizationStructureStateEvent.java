package org.dddml.wms.domain.organizationstructure;

import java.util.*;
import org.dddml.wms.domain.*;
import java.util.Date;
import org.dddml.wms.specialization.Event;

public interface OrganizationStructureStateEvent extends Event
{
    OrganizationStructureStateEventId getStateEventId();

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

    interface OrganizationStructureStateCreated extends OrganizationStructureStateEvent
    {
    
    }


    interface OrganizationStructureStateMergePatched extends OrganizationStructureStateEvent
    {
        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface OrganizationStructureStateDeleted extends OrganizationStructureStateEvent
    {
    }


}

