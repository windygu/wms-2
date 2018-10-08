package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface AttributeSetInstanceExtensionFieldEvent extends Event {

    interface SqlAttributeSetInstanceExtensionFieldEvent extends AttributeSetInstanceExtensionFieldEvent {
        AttributeSetInstanceExtensionFieldEventId getAttributeSetInstanceExtensionFieldEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    String getName();

    //void setName(String name);

    Long getVersion();
    
    //void getVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface AttributeSetInstanceExtensionFieldStateEvent extends AttributeSetInstanceExtensionFieldEvent {
        String getType();

        void setType(String type);

        Integer getLength();

        void setLength(Integer length);

        String getAlias();

        void setAlias(String alias);

        String getDescription();

        void setDescription(String description);

        String getGroupId();

        void setGroupId(String groupId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface AttributeSetInstanceExtensionFieldStateCreated extends AttributeSetInstanceExtensionFieldStateEvent
    {
    
    }


    interface AttributeSetInstanceExtensionFieldStateMergePatched extends AttributeSetInstanceExtensionFieldStateEvent
    {
        Boolean getIsPropertyTypeRemoved();

        void setIsPropertyTypeRemoved(Boolean removed);

        Boolean getIsPropertyLengthRemoved();

        void setIsPropertyLengthRemoved(Boolean removed);

        Boolean getIsPropertyAliasRemoved();

        void setIsPropertyAliasRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyGroupIdRemoved();

        void setIsPropertyGroupIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface AttributeSetInstanceExtensionFieldStateDeleted extends AttributeSetInstanceExtensionFieldStateEvent
    {
    }


}

