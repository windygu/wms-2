package org.dddml.wms.domain.attribute;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface AttributeEvent extends Event {

    interface SqlAttributeEvent extends AttributeEvent {
        AttributeEventId getAttributeEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    String getAttributeId();

    //void setAttributeId(String attributeId);

    Long getVersion();
    
    //void getVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface AttributeStateEvent extends AttributeEvent {
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

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface AttributeStateCreated extends AttributeStateEvent
    {
        Iterable<AttributeValueEvent.AttributeValueStateCreated> getAttributeValueEvents();
        
        void addAttributeValueEvent(AttributeValueEvent.AttributeValueStateCreated e);

        AttributeValueEvent.AttributeValueStateCreated newAttributeValueStateCreated(String value);

        Iterable<AttributeAliasEvent.AttributeAliasStateCreated> getAttributeAliasEvents();
        
        void addAttributeAliasEvent(AttributeAliasEvent.AttributeAliasStateCreated e);

        AttributeAliasEvent.AttributeAliasStateCreated newAttributeAliasStateCreated(String code);

    
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

        Iterable<AttributeValueEvent> getAttributeValueEvents();
        
        void addAttributeValueEvent(AttributeValueEvent e);

        AttributeValueEvent.AttributeValueStateCreated newAttributeValueStateCreated(String value);

        AttributeValueEvent.AttributeValueStateMergePatched newAttributeValueStateMergePatched(String value);

        AttributeValueEvent.AttributeValueStateRemoved newAttributeValueStateRemoved(String value);

        Iterable<AttributeAliasEvent> getAttributeAliasEvents();
        
        void addAttributeAliasEvent(AttributeAliasEvent e);

        AttributeAliasEvent.AttributeAliasStateCreated newAttributeAliasStateCreated(String code);

        AttributeAliasEvent.AttributeAliasStateMergePatched newAttributeAliasStateMergePatched(String code);

        AttributeAliasEvent.AttributeAliasStateRemoved newAttributeAliasStateRemoved(String code);


    }

    interface AttributeStateDeleted extends AttributeStateEvent
    {
        Iterable<AttributeValueEvent.AttributeValueStateRemoved> getAttributeValueEvents();
        
        void addAttributeValueEvent(AttributeValueEvent.AttributeValueStateRemoved e);
        
        AttributeValueEvent.AttributeValueStateRemoved newAttributeValueStateRemoved(String value);

        Iterable<AttributeAliasEvent.AttributeAliasStateRemoved> getAttributeAliasEvents();
        
        void addAttributeAliasEvent(AttributeAliasEvent.AttributeAliasStateRemoved e);
        
        AttributeAliasEvent.AttributeAliasStateRemoved newAttributeAliasStateRemoved(String code);

    }


}

