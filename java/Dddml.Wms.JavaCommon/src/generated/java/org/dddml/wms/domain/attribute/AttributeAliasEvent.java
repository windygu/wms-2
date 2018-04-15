package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface AttributeAliasEvent extends Event
{
    AttributeAliasEventId getAttributeAliasEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    Long getVersion();

    void setVersion(Long version);

    String getName();

    void setName(String name);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface AttributeAliasStateCreated extends AttributeAliasEvent
    {
    
    }


    interface AttributeAliasStateMergePatched extends AttributeAliasEvent
    {
        Boolean getIsPropertyNameRemoved();

        void setIsPropertyNameRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface AttributeAliasStateRemoved extends AttributeAliasEvent
    {
    }


}

