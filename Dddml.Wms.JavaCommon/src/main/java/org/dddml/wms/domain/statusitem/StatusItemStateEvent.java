package org.dddml.wms.domain.statusitem;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface StatusItemStateEvent extends Event
{
    StatusItemStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getStatusTypeId();

    void setStatusTypeId(String statusTypeId);

    String getStatusCode();

    void setStatusCode(String statusCode);

    String getSequenceId();

    void setSequenceId(String sequenceId);

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

    interface StatusItemStateCreated extends StatusItemStateEvent
    {
    
    }


    interface StatusItemStateMergePatched extends StatusItemStateEvent
    {
        Boolean getIsPropertyStatusTypeIdRemoved();

        void setIsPropertyStatusTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyStatusCodeRemoved();

        void setIsPropertyStatusCodeRemoved(Boolean removed);

        Boolean getIsPropertySequenceIdRemoved();

        void setIsPropertySequenceIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }


}

