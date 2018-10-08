package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InOutLineImageEvent extends Event {

    interface SqlInOutLineImageEvent extends InOutLineImageEvent {
        InOutLineImageEventId getInOutLineImageEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    String getSequenceId();

    //void setSequenceId(String sequenceId);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InOutLineImageStateEvent extends InOutLineImageEvent {
        Long getVersion();

        void setVersion(Long version);

        String getUrl();

        void setUrl(String url);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface InOutLineImageStateCreated extends InOutLineImageStateEvent
    {
    
    }


    interface InOutLineImageStateMergePatched extends InOutLineImageStateEvent
    {
        Boolean getIsPropertyUrlRemoved();

        void setIsPropertyUrlRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface InOutLineImageStateRemoved extends InOutLineImageStateEvent
    {
    }


}

