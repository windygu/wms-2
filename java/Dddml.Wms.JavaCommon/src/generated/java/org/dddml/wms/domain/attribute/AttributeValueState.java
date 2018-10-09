package org.dddml.wms.domain.attribute;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attribute.AttributeValueEvent.*;

public interface AttributeValueState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getValue();

    String getAttributeValueName();

    String getDescription();

    String getReferenceId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getAttributeId();

    interface MutableAttributeValueState extends AttributeValueState {
        void setAttributeValueId(AttributeValueId attributeValueId);

        void setValue(String value);

        void setAttributeValueName(String attributeValueName);

        void setDescription(String description);

        void setReferenceId(String referenceId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setAttributeId(String attributeId);


        void mutate(Event e);

        void when(AttributeValueEvent.AttributeValueStateCreated e);

        void when(AttributeValueEvent.AttributeValueStateMergePatched e);

        void when(AttributeValueEvent.AttributeValueStateRemoved e);
    }

    interface SqlAttributeValueState extends MutableAttributeValueState {
        AttributeValueId getAttributeValueId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

