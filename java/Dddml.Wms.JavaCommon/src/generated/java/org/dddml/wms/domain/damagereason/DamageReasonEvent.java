package org.dddml.wms.domain.damagereason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface DamageReasonEvent extends Event
{
    DamageReasonEventId getDamageReasonEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getDescription();

    void setDescription(String description);

    String getSequenceId();

    void setSequenceId(String sequenceId);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface DamageReasonStateCreated extends DamageReasonEvent
    {
    
    }


    interface DamageReasonStateMergePatched extends DamageReasonEvent
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertySequenceIdRemoved();

        void setIsPropertySequenceIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface DamageReasonStateDeleted extends DamageReasonEvent
    {
    }


}

