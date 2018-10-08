package org.dddml.wms.domain.organizationstructure;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrganizationStructureEvent extends Event {

    interface SqlOrganizationStructureEvent extends OrganizationStructureEvent {
        OrganizationStructureEventId getOrganizationStructureEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    OrganizationStructureId getId();

    //void setId(OrganizationStructureId id);

    Long getVersion();
    
    //void getVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface OrganizationStructureStateEvent extends OrganizationStructureEvent {
        Boolean getActive();

        void setActive(Boolean active);

    }

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

