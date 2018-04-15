package org.dddml.wms.domain.organizationstructure;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrganizationStructureEvent extends Event
{
    OrganizationStructureEventId getOrganizationStructureEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface OrganizationStructureStateCreated extends OrganizationStructureEvent
    {
    
    }


    interface OrganizationStructureStateMergePatched extends OrganizationStructureEvent
    {
        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface OrganizationStructureStateDeleted extends OrganizationStructureEvent
    {
    }


}

