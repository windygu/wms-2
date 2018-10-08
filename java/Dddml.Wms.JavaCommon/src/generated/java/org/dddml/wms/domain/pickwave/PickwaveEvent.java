package org.dddml.wms.domain.pickwave;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PickwaveEvent extends Event {

    interface SqlPickwaveEvent extends PickwaveEvent {
        PickwaveEventId getPickwaveEventId();
    }

    Long getPickwaveId();

    //void setPickwaveId(Long pickwaveId);

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

    interface PickwaveStateEvent extends PickwaveEvent {
        String getStatusId();

        void setStatusId(String statusId);

        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface PickwaveStateCreated extends PickwaveStateEvent
    {
    
    }


    interface PickwaveStateMergePatched extends PickwaveStateEvent
    {
        Boolean getIsPropertyStatusIdRemoved();

        void setIsPropertyStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface PickwaveStateDeleted extends PickwaveStateEvent
    {
    }


}

