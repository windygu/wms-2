package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface AttributeSetInstanceExtensionFieldGroupEvent extends Event
{
    AttributeSetInstanceExtensionFieldGroupEventId getAttributeSetInstanceExtensionFieldGroupEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getFieldType();

    void setFieldType(String fieldType);

    Integer getFieldLength();

    void setFieldLength(Integer fieldLength);

    Integer getFieldCount();

    void setFieldCount(Integer fieldCount);

    String getNameFormat();

    void setNameFormat(String nameFormat);

    String getDescription();

    void setDescription(String description);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface AttributeSetInstanceExtensionFieldGroupStateCreated extends AttributeSetInstanceExtensionFieldGroupEvent
    {
    
    }


    interface AttributeSetInstanceExtensionFieldGroupStateMergePatched extends AttributeSetInstanceExtensionFieldGroupEvent
    {
        Boolean getIsPropertyFieldTypeRemoved();

        void setIsPropertyFieldTypeRemoved(Boolean removed);

        Boolean getIsPropertyFieldLengthRemoved();

        void setIsPropertyFieldLengthRemoved(Boolean removed);

        Boolean getIsPropertyFieldCountRemoved();

        void setIsPropertyFieldCountRemoved(Boolean removed);

        Boolean getIsPropertyNameFormatRemoved();

        void setIsPropertyNameFormatRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface AttributeSetInstanceExtensionFieldGroupStateDeleted extends AttributeSetInstanceExtensionFieldGroupEvent
    {
    }


}

