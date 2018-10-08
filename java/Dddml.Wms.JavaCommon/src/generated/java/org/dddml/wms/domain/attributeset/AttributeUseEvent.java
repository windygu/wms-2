package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface AttributeUseEvent extends Event {

    interface SqlAttributeUseEvent extends AttributeUseEvent {
        AttributeUseEventId getAttributeUseEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    String getAttributeId();

    //void setAttributeId(String attributeId);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface AttributeUseStateEvent extends AttributeUseEvent {
        Long getVersion();

        void setVersion(Long version);

        Integer getSequenceNumber();

        void setSequenceNumber(Integer sequenceNumber);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface AttributeUseStateCreated extends AttributeUseStateEvent
    {
    
    }


    interface AttributeUseStateMergePatched extends AttributeUseStateEvent
    {
        Boolean getIsPropertySequenceNumberRemoved();

        void setIsPropertySequenceNumberRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface AttributeUseStateRemoved extends AttributeUseStateEvent
    {
    }


}

