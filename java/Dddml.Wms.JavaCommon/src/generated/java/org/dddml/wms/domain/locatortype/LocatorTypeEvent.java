package org.dddml.wms.domain.locatortype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface LocatorTypeEvent extends Event {

    interface SqlLocatorTypeEvent extends LocatorTypeEvent {
        LocatorTypeEventId getLocatorTypeEventId();
    }

    String getLocatorTypeId();

    //void setLocatorTypeId(String locatorTypeId);

    Long getVersion();
    
    //void getVersion(Long version);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface LocatorTypeStateEvent extends LocatorTypeEvent {
        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface LocatorTypeStateCreated extends LocatorTypeStateEvent
    {
    
    }


    interface LocatorTypeStateMergePatched extends LocatorTypeStateEvent
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface LocatorTypeStateDeleted extends LocatorTypeStateEvent
    {
    }


}

