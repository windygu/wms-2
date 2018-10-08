package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface AttributeSetEvent extends Event {

    interface SqlAttributeSetEvent extends AttributeSetEvent {
        AttributeSetEventId getAttributeSetEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    String getAttributeSetId();

    //void setAttributeSetId(String attributeSetId);

    Long getVersion();
    
    //void getVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface AttributeSetStateEvent extends AttributeSetEvent {
        String getAttributeSetName();

        void setAttributeSetName(String attributeSetName);

        String getOrganizationId();

        void setOrganizationId(String organizationId);

        String getDescription();

        void setDescription(String description);

        String getReferenceId();

        void setReferenceId(String referenceId);

        Boolean getIsInstanceAttributeSet();

        void setIsInstanceAttributeSet(Boolean isInstanceAttributeSet);

        Boolean getIsMandatory();

        void setIsMandatory(Boolean isMandatory);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface AttributeSetStateCreated extends AttributeSetStateEvent
    {
        Iterable<AttributeUseEvent.AttributeUseStateCreated> getAttributeUseEvents();
        
        void addAttributeUseEvent(AttributeUseEvent.AttributeUseStateCreated e);

        AttributeUseEvent.AttributeUseStateCreated newAttributeUseStateCreated(String attributeId);

    
    }


    interface AttributeSetStateMergePatched extends AttributeSetStateEvent
    {
        Boolean getIsPropertyAttributeSetNameRemoved();

        void setIsPropertyAttributeSetNameRemoved(Boolean removed);

        Boolean getIsPropertyOrganizationIdRemoved();

        void setIsPropertyOrganizationIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyReferenceIdRemoved();

        void setIsPropertyReferenceIdRemoved(Boolean removed);

        Boolean getIsPropertyIsInstanceAttributeSetRemoved();

        void setIsPropertyIsInstanceAttributeSetRemoved(Boolean removed);

        Boolean getIsPropertyIsMandatoryRemoved();

        void setIsPropertyIsMandatoryRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Iterable<AttributeUseEvent> getAttributeUseEvents();
        
        void addAttributeUseEvent(AttributeUseEvent e);

        AttributeUseEvent.AttributeUseStateCreated newAttributeUseStateCreated(String attributeId);

        AttributeUseEvent.AttributeUseStateMergePatched newAttributeUseStateMergePatched(String attributeId);

        AttributeUseEvent.AttributeUseStateRemoved newAttributeUseStateRemoved(String attributeId);


    }

    interface AttributeSetStateDeleted extends AttributeSetStateEvent
    {
        Iterable<AttributeUseEvent.AttributeUseStateRemoved> getAttributeUseEvents();
        
        void addAttributeUseEvent(AttributeUseEvent.AttributeUseStateRemoved e);
        
        AttributeUseEvent.AttributeUseStateRemoved newAttributeUseStateRemoved(String attributeId);

    }


}

