package org.dddml.wms.domain.attributesetinstanceextensionfieldgroup;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attributesetinstanceextensionfieldgroup.AttributeSetInstanceExtensionFieldGroupEvent.*;

public interface AttributeSetInstanceExtensionFieldGroupState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getId();

    String getFieldType();

    Integer getFieldLength();

    Integer getFieldCount();

    String getNameFormat();

    String getDescription();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableAttributeSetInstanceExtensionFieldGroupState extends AttributeSetInstanceExtensionFieldGroupState {
        void setId(String id);

        void setFieldType(String fieldType);

        void setFieldLength(Integer fieldLength);

        void setFieldCount(Integer fieldCount);

        void setNameFormat(String nameFormat);

        void setDescription(String description);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateCreated e);

        void when(AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateMergePatched e);

        void when(AttributeSetInstanceExtensionFieldGroupEvent.AttributeSetInstanceExtensionFieldGroupStateDeleted e);
    }

    interface SqlAttributeSetInstanceExtensionFieldGroupState extends MutableAttributeSetInstanceExtensionFieldGroupState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

