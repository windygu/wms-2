package org.dddml.wms.domain.damagereason;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface DamageReasonEvent extends Event {

    interface SqlDamageReasonEvent extends DamageReasonEvent {
        DamageReasonEventId getDamageReasonEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    String getDamageReasonId();

    //void setDamageReasonId(String damageReasonId);

    Long getVersion();
    
    //void getVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface DamageReasonStateEvent extends DamageReasonEvent {
        String getDescription();

        void setDescription(String description);

        String getSequenceId();

        void setSequenceId(String sequenceId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface DamageReasonStateCreated extends DamageReasonStateEvent
    {
    
    }


    interface DamageReasonStateMergePatched extends DamageReasonStateEvent
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertySequenceIdRemoved();

        void setIsPropertySequenceIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface DamageReasonStateDeleted extends DamageReasonStateEvent
    {
    }


}

