package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface GoodIdentificationEvent extends Event
{
    GoodIdentificationEventId getGoodIdentificationEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface GoodIdentificationStateEvent extends GoodIdentificationEvent {
        Long getVersion();

        void setVersion(Long version);

        String getIdValue();

        void setIdValue(String idValue);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface GoodIdentificationStateCreated extends GoodIdentificationStateEvent
    {
    
    }


    interface GoodIdentificationStateMergePatched extends GoodIdentificationStateEvent
    {
        Boolean getIsPropertyIdValueRemoved();

        void setIsPropertyIdValueRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface GoodIdentificationStateRemoved extends GoodIdentificationStateEvent
    {
    }


}

