package org.dddml.wms.domain.rejectionreason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface RejectionReasonEvent extends Event
{
    RejectionReasonEventId getRejectionReasonEventId();

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

    interface RejectionReasonStateCreated extends RejectionReasonEvent
    {
    
    }


    interface RejectionReasonStateMergePatched extends RejectionReasonEvent
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface RejectionReasonStateDeleted extends RejectionReasonEvent
    {
    }


}

