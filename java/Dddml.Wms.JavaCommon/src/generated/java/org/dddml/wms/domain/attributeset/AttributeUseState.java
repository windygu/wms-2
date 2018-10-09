package org.dddml.wms.domain.attributeset;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attributeset.AttributeUseEvent.*;

public interface AttributeUseState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getAttributeId();

    Integer getSequenceNumber();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getAttributeSetId();

    interface MutableAttributeUseState extends AttributeUseState {
        void setAttributeSetAttributeUseId(AttributeSetAttributeUseId attributeSetAttributeUseId);

        void setAttributeId(String attributeId);

        void setSequenceNumber(Integer sequenceNumber);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setAttributeSetId(String attributeSetId);


        void mutate(Event e);

        void when(AttributeUseEvent.AttributeUseStateCreated e);

        void when(AttributeUseEvent.AttributeUseStateMergePatched e);

        void when(AttributeUseEvent.AttributeUseStateRemoved e);
    }

    interface SqlAttributeUseState extends MutableAttributeUseState {
        AttributeSetAttributeUseId getAttributeSetAttributeUseId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

