package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface AttributeStateEvent extends Event
{
    AttributeEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getAttributeName();

    void setAttributeName(String attributeName);

    String getOrganizationId();

    void setOrganizationId(String organizationId);

    String getDescription();

    void setDescription(String description);

    Boolean getIsMandatory();

    void setIsMandatory(Boolean isMandatory);

    String getAttributeValueType();

    void setAttributeValueType(String attributeValueType);

    Integer getAttributeValueLength();

    void setAttributeValueLength(Integer attributeValueLength);

    Boolean getIsList();

    void setIsList(Boolean isList);

    String getFieldName();

    void setFieldName(String fieldName);

    String getReferenceId();

    void setReferenceId(String referenceId);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface AttributeStateCreated extends AttributeStateEvent
    {
        Iterable<AttributeValueStateEvent.AttributeValueStateCreated> getAttributeValueEvents();
        
        void addAttributeValueEvent(AttributeValueStateEvent.AttributeValueStateCreated e);

        AttributeValueStateEvent.AttributeValueStateCreated newAttributeValueStateCreated(String value);

        Iterable<AttributeAliasStateEvent.AttributeAliasStateCreated> getAttributeAliasEvents();
        
        void addAttributeAliasEvent(AttributeAliasStateEvent.AttributeAliasStateCreated e);

        AttributeAliasStateEvent.AttributeAliasStateCreated newAttributeAliasStateCreated(String code);

    
    }


    interface AttributeStateMergePatched extends AttributeStateEvent
    {
        Boolean getIsPropertyAttributeNameRemoved();

        void setIsPropertyAttributeNameRemoved(Boolean removed);

        Boolean getIsPropertyOrganizationIdRemoved();

        void setIsPropertyOrganizationIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyIsMandatoryRemoved();

        void setIsPropertyIsMandatoryRemoved(Boolean removed);

        Boolean getIsPropertyAttributeValueTypeRemoved();

        void setIsPropertyAttributeValueTypeRemoved(Boolean removed);

        Boolean getIsPropertyAttributeValueLengthRemoved();

        void setIsPropertyAttributeValueLengthRemoved(Boolean removed);

        Boolean getIsPropertyIsListRemoved();

        void setIsPropertyIsListRemoved(Boolean removed);

        Boolean getIsPropertyFieldNameRemoved();

        void setIsPropertyFieldNameRemoved(Boolean removed);

        Boolean getIsPropertyReferenceIdRemoved();

        void setIsPropertyReferenceIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Iterable<AttributeValueStateEvent> getAttributeValueEvents();
        
        void addAttributeValueEvent(AttributeValueStateEvent e);

        AttributeValueStateEvent.AttributeValueStateCreated newAttributeValueStateCreated(String value);

        AttributeValueStateEvent.AttributeValueStateMergePatched newAttributeValueStateMergePatched(String value);

        AttributeValueStateEvent.AttributeValueStateRemoved newAttributeValueStateRemoved(String value);

        Iterable<AttributeAliasStateEvent> getAttributeAliasEvents();
        
        void addAttributeAliasEvent(AttributeAliasStateEvent e);

        AttributeAliasStateEvent.AttributeAliasStateCreated newAttributeAliasStateCreated(String code);

        AttributeAliasStateEvent.AttributeAliasStateMergePatched newAttributeAliasStateMergePatched(String code);

        AttributeAliasStateEvent.AttributeAliasStateRemoved newAttributeAliasStateRemoved(String code);


    }

    interface AttributeStateDeleted extends AttributeStateEvent
    {
        Iterable<AttributeValueStateEvent.AttributeValueStateRemoved> getAttributeValueEvents();
        
        void addAttributeValueEvent(AttributeValueStateEvent.AttributeValueStateRemoved e);
        
        AttributeValueStateEvent.AttributeValueStateRemoved newAttributeValueStateRemoved(String value);

        Iterable<AttributeAliasStateEvent.AttributeAliasStateRemoved> getAttributeAliasEvents();
        
        void addAttributeAliasEvent(AttributeAliasStateEvent.AttributeAliasStateRemoved e);
        
        AttributeAliasStateEvent.AttributeAliasStateRemoved newAttributeAliasStateRemoved(String code);

    }


}

