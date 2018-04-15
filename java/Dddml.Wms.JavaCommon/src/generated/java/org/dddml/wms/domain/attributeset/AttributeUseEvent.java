package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface AttributeUseEvent extends Event
{
    AttributeUseEventId getAttributeUseEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    Long getVersion();

    void setVersion(Long version);

    Integer getSequenceNumber();

    void setSequenceNumber(Integer sequenceNumber);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface AttributeUseStateCreated extends AttributeUseEvent
    {
    
    }


    interface AttributeUseStateMergePatched extends AttributeUseEvent
    {
        Boolean getIsPropertySequenceNumberRemoved();

        void setIsPropertySequenceNumberRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface AttributeUseStateRemoved extends AttributeUseEvent
    {
    }


}

