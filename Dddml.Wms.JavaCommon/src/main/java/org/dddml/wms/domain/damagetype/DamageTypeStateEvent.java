package org.dddml.wms.domain.damagetype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface DamageTypeStateEvent extends Event
{
    DamageTypeStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getDescription();

    void setDescription(String description);

    String getSequenceId();

    void setSequenceId(String sequenceId);

    String getDefaultHandlingMethodId();

    void setDefaultHandlingMethodId(String defaultHandlingMethodId);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface DamageTypeStateCreated extends DamageTypeStateEvent
    {
    
    }


    interface DamageTypeStateMergePatched extends DamageTypeStateEvent
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertySequenceIdRemoved();

        void setIsPropertySequenceIdRemoved(Boolean removed);

        Boolean getIsPropertyDefaultHandlingMethodIdRemoved();

        void setIsPropertyDefaultHandlingMethodIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface DamageTypeStateDeleted extends DamageTypeStateEvent
    {
    }


}

