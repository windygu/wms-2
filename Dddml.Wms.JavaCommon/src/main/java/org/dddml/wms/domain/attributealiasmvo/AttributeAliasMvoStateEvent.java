package org.dddml.wms.domain.attributealiasmvo;

import java.util.*;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface AttributeAliasMvoStateEvent extends Event
{
    AttributeAliasMvoStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getName();

    void setName(String name);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getAttributeAttributeName();

    void setAttributeAttributeName(String attributeAttributeName);

    String getAttributeOrganizationId();

    void setAttributeOrganizationId(String attributeOrganizationId);

    String getAttributeDescription();

    void setAttributeDescription(String attributeDescription);

    Boolean getAttributeIsMandatory();

    void setAttributeIsMandatory(Boolean attributeIsMandatory);

    String getAttributeAttributeValueType();

    void setAttributeAttributeValueType(String attributeAttributeValueType);

    Integer getAttributeAttributeValueLength();

    void setAttributeAttributeValueLength(Integer attributeAttributeValueLength);

    Boolean getAttributeIsList();

    void setAttributeIsList(Boolean attributeIsList);

    String getAttributeFieldName();

    void setAttributeFieldName(String attributeFieldName);

    String getAttributeReferenceId();

    void setAttributeReferenceId(String attributeReferenceId);

    String getAttributeCreatedBy();

    void setAttributeCreatedBy(String attributeCreatedBy);

    Date getAttributeCreatedAt();

    void setAttributeCreatedAt(Date attributeCreatedAt);

    String getAttributeUpdatedBy();

    void setAttributeUpdatedBy(String attributeUpdatedBy);

    Date getAttributeUpdatedAt();

    void setAttributeUpdatedAt(Date attributeUpdatedAt);

    Boolean getAttributeActive();

    void setAttributeActive(Boolean attributeActive);

    Boolean getAttributeDeleted();

    void setAttributeDeleted(Boolean attributeDeleted);

    String getCommandId();

    void setCommandId(String commandId);

    interface AttributeAliasMvoStateCreated extends AttributeAliasMvoStateEvent
    {
    
    }


    interface AttributeAliasMvoStateMergePatched extends AttributeAliasMvoStateEvent
    {
        Boolean getIsPropertyNameRemoved();

        void setIsPropertyNameRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyAttributeAttributeNameRemoved();

        void setIsPropertyAttributeAttributeNameRemoved(Boolean removed);

        Boolean getIsPropertyAttributeOrganizationIdRemoved();

        void setIsPropertyAttributeOrganizationIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeDescriptionRemoved();

        void setIsPropertyAttributeDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyAttributeIsMandatoryRemoved();

        void setIsPropertyAttributeIsMandatoryRemoved(Boolean removed);

        Boolean getIsPropertyAttributeAttributeValueTypeRemoved();

        void setIsPropertyAttributeAttributeValueTypeRemoved(Boolean removed);

        Boolean getIsPropertyAttributeAttributeValueLengthRemoved();

        void setIsPropertyAttributeAttributeValueLengthRemoved(Boolean removed);

        Boolean getIsPropertyAttributeIsListRemoved();

        void setIsPropertyAttributeIsListRemoved(Boolean removed);

        Boolean getIsPropertyAttributeFieldNameRemoved();

        void setIsPropertyAttributeFieldNameRemoved(Boolean removed);

        Boolean getIsPropertyAttributeReferenceIdRemoved();

        void setIsPropertyAttributeReferenceIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeCreatedByRemoved();

        void setIsPropertyAttributeCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyAttributeCreatedAtRemoved();

        void setIsPropertyAttributeCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyAttributeUpdatedByRemoved();

        void setIsPropertyAttributeUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyAttributeUpdatedAtRemoved();

        void setIsPropertyAttributeUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyAttributeActiveRemoved();

        void setIsPropertyAttributeActiveRemoved(Boolean removed);

        Boolean getIsPropertyAttributeDeletedRemoved();

        void setIsPropertyAttributeDeletedRemoved(Boolean removed);


    }

    interface AttributeAliasMvoStateDeleted extends AttributeAliasMvoStateEvent
    {
    }


}

