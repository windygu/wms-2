package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attributesetinstanceextensionfield.AttributeSetInstanceExtensionFieldEvent.*;

public interface AttributeSetInstanceExtensionFieldState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getName();

    String getType();

    Integer getLength();

    String getAlias();

    String getDescription();

    String getGroupId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableAttributeSetInstanceExtensionFieldState extends AttributeSetInstanceExtensionFieldState {
        void setName(String name);

        void setType(String type);

        void setLength(Integer length);

        void setAlias(String alias);

        void setDescription(String description);

        void setGroupId(String groupId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateCreated e);

        void when(AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateMergePatched e);

        void when(AttributeSetInstanceExtensionFieldEvent.AttributeSetInstanceExtensionFieldStateDeleted e);
    }

    interface SqlAttributeSetInstanceExtensionFieldState extends MutableAttributeSetInstanceExtensionFieldState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

