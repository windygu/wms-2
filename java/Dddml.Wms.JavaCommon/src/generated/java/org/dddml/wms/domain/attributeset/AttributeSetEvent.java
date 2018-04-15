package org.dddml.wms.domain.attributeset;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface AttributeSetEvent extends Event
{
    AttributeSetEventId getAttributeSetEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

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

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface AttributeSetStateCreated extends AttributeSetEvent
    {
        Iterable<AttributeUseEvent.AttributeUseStateCreated> getAttributeUseEvents();
        
        void addAttributeUseEvent(AttributeUseEvent.AttributeUseStateCreated e);

        AttributeUseEvent.AttributeUseStateCreated newAttributeUseStateCreated(String attributeId);

    
    }


    interface AttributeSetStateMergePatched extends AttributeSetEvent
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

    interface AttributeSetStateDeleted extends AttributeSetEvent
    {
        Iterable<AttributeUseEvent.AttributeUseStateRemoved> getAttributeUseEvents();
        
        void addAttributeUseEvent(AttributeUseEvent.AttributeUseStateRemoved e);
        
        AttributeUseEvent.AttributeUseStateRemoved newAttributeUseStateRemoved(String attributeId);

    }


}

