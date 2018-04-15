package org.dddml.wms.domain.locatortype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface LocatorTypeEvent extends Event
{
    LocatorTypeEventId getLocatorTypeEventId();

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

    interface LocatorTypeStateCreated extends LocatorTypeEvent
    {
    
    }


    interface LocatorTypeStateMergePatched extends LocatorTypeEvent
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface LocatorTypeStateDeleted extends LocatorTypeEvent
    {
    }


}

