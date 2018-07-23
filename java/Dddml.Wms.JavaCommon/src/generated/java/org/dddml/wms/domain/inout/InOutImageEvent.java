package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InOutImageEvent extends Event
{
    InOutImageEventId getInOutImageEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InOutImageStateEvent extends InOutImageEvent {
        Long getVersion();

        void setVersion(Long version);

        String getUrl();

        void setUrl(String url);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface InOutImageStateCreated extends InOutImageStateEvent
    {
    
    }


    interface InOutImageStateMergePatched extends InOutImageStateEvent
    {
        Boolean getIsPropertyUrlRemoved();

        void setIsPropertyUrlRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface InOutImageStateRemoved extends InOutImageStateEvent
    {
    }


}

