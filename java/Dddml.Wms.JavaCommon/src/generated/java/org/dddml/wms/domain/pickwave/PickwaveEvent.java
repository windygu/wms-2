package org.dddml.wms.domain.pickwave;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PickwaveEvent extends Event
{
    PickwaveEventId getPickwaveEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getStatusId();

    void setStatusId(String statusId);

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

    interface PickwaveStateCreated extends PickwaveEvent
    {
    
    }


    interface PickwaveStateMergePatched extends PickwaveEvent
    {
        Boolean getIsPropertyStatusIdRemoved();

        void setIsPropertyStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface PickwaveStateDeleted extends PickwaveEvent
    {
    }


}

