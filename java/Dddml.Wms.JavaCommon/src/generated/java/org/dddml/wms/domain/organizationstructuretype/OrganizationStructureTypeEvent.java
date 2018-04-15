package org.dddml.wms.domain.organizationstructuretype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrganizationStructureTypeEvent extends Event
{
    OrganizationStructureTypeEventId getOrganizationStructureTypeEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getDescription();

    void setDescription(String description);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface OrganizationStructureTypeStateCreated extends OrganizationStructureTypeEvent
    {
    
    }


    interface OrganizationStructureTypeStateMergePatched extends OrganizationStructureTypeEvent
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface OrganizationStructureTypeStateDeleted extends OrganizationStructureTypeEvent
    {
    }


}

