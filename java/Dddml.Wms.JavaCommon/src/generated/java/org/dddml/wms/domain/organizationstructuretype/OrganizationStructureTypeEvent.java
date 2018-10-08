package org.dddml.wms.domain.organizationstructuretype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrganizationStructureTypeEvent extends Event {

    interface SqlOrganizationStructureTypeEvent extends OrganizationStructureTypeEvent {
        OrganizationStructureTypeEventId getOrganizationStructureTypeEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    String getId();

    //void setId(String id);

    Long getVersion();
    
    //void getVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface OrganizationStructureTypeStateEvent extends OrganizationStructureTypeEvent {
        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface OrganizationStructureTypeStateCreated extends OrganizationStructureTypeStateEvent
    {
    
    }


    interface OrganizationStructureTypeStateMergePatched extends OrganizationStructureTypeStateEvent
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface OrganizationStructureTypeStateDeleted extends OrganizationStructureTypeStateEvent
    {
    }


}

