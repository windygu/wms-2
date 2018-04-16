package org.dddml.wms.domain.attributeusemvo;

import java.util.*;
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface AttributeUseMvoEvent extends Event
{
    AttributeUseMvoEventId getAttributeUseMvoEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface AttributeUseMvoStateEvent extends AttributeUseMvoEvent {
        Integer getSequenceNumber();

        void setSequenceNumber(Integer sequenceNumber);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getAttributeSetAttributeSetName();

        void setAttributeSetAttributeSetName(String attributeSetAttributeSetName);

        String getAttributeSetOrganizationId();

        void setAttributeSetOrganizationId(String attributeSetOrganizationId);

        String getAttributeSetDescription();

        void setAttributeSetDescription(String attributeSetDescription);

        String getAttributeSetReferenceId();

        void setAttributeSetReferenceId(String attributeSetReferenceId);

        Boolean getAttributeSetIsInstanceAttributeSet();

        void setAttributeSetIsInstanceAttributeSet(Boolean attributeSetIsInstanceAttributeSet);

        Boolean getAttributeSetIsMandatory();

        void setAttributeSetIsMandatory(Boolean attributeSetIsMandatory);

        String getAttributeSetCreatedBy();

        void setAttributeSetCreatedBy(String attributeSetCreatedBy);

        Date getAttributeSetCreatedAt();

        void setAttributeSetCreatedAt(Date attributeSetCreatedAt);

        String getAttributeSetUpdatedBy();

        void setAttributeSetUpdatedBy(String attributeSetUpdatedBy);

        Date getAttributeSetUpdatedAt();

        void setAttributeSetUpdatedAt(Date attributeSetUpdatedAt);

        Boolean getAttributeSetActive();

        void setAttributeSetActive(Boolean attributeSetActive);

        Boolean getAttributeSetDeleted();

        void setAttributeSetDeleted(Boolean attributeSetDeleted);

    }

    interface AttributeUseMvoStateCreated extends AttributeUseMvoStateEvent
    {
    
    }


    interface AttributeUseMvoStateMergePatched extends AttributeUseMvoStateEvent
    {
        Boolean getIsPropertySequenceNumberRemoved();

        void setIsPropertySequenceNumberRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetAttributeSetNameRemoved();

        void setIsPropertyAttributeSetAttributeSetNameRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetOrganizationIdRemoved();

        void setIsPropertyAttributeSetOrganizationIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetDescriptionRemoved();

        void setIsPropertyAttributeSetDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetReferenceIdRemoved();

        void setIsPropertyAttributeSetReferenceIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetIsInstanceAttributeSetRemoved();

        void setIsPropertyAttributeSetIsInstanceAttributeSetRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetIsMandatoryRemoved();

        void setIsPropertyAttributeSetIsMandatoryRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetCreatedByRemoved();

        void setIsPropertyAttributeSetCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetCreatedAtRemoved();

        void setIsPropertyAttributeSetCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetUpdatedByRemoved();

        void setIsPropertyAttributeSetUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetUpdatedAtRemoved();

        void setIsPropertyAttributeSetUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetActiveRemoved();

        void setIsPropertyAttributeSetActiveRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetDeletedRemoved();

        void setIsPropertyAttributeSetDeletedRemoved(Boolean removed);


    }

    interface AttributeUseMvoStateDeleted extends AttributeUseMvoStateEvent
    {
    }


}

