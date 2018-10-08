package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface AttributeValueEvent extends Event {

    interface SqlAttributeValueEvent extends AttributeValueEvent {
        AttributeValueEventId getAttributeValueEventId();
    }

    String getValue();

    //void setValue(String value);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface AttributeValueStateEvent extends AttributeValueEvent {
        Long getVersion();

        void setVersion(Long version);

        String getAttributeValueName();

        void setAttributeValueName(String attributeValueName);

        String getDescription();

        void setDescription(String description);

        String getReferenceId();

        void setReferenceId(String referenceId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface AttributeValueStateCreated extends AttributeValueStateEvent
    {
    
    }


    interface AttributeValueStateMergePatched extends AttributeValueStateEvent
    {
        Boolean getIsPropertyAttributeValueNameRemoved();

        void setIsPropertyAttributeValueNameRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyReferenceIdRemoved();

        void setIsPropertyReferenceIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface AttributeValueStateRemoved extends AttributeValueStateEvent
    {
    }


}

