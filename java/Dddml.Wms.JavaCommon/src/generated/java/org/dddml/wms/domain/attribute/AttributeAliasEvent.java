package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface AttributeAliasEvent extends Event {

    interface SqlAttributeAliasEvent extends AttributeAliasEvent {
        AttributeAliasEventId getAttributeAliasEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    String getCode();

    //void setCode(String code);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface AttributeAliasStateEvent extends AttributeAliasEvent {
        Long getVersion();

        void setVersion(Long version);

        String getName();

        void setName(String name);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface AttributeAliasStateCreated extends AttributeAliasStateEvent
    {
    
    }


    interface AttributeAliasStateMergePatched extends AttributeAliasStateEvent
    {
        Boolean getIsPropertyNameRemoved();

        void setIsPropertyNameRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface AttributeAliasStateRemoved extends AttributeAliasStateEvent
    {
    }


}

