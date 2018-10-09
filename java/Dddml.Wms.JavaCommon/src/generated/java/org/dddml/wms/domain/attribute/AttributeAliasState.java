package org.dddml.wms.domain.attribute;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attribute.AttributeAliasEvent.*;

public interface AttributeAliasState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getCode();

    String getName();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getAttributeId();

    interface MutableAttributeAliasState extends AttributeAliasState {
        void setAttributeAliasId(AttributeAliasId attributeAliasId);

        void setCode(String code);

        void setName(String name);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setAttributeId(String attributeId);


        void mutate(Event e);

        void when(AttributeAliasEvent.AttributeAliasStateCreated e);

        void when(AttributeAliasEvent.AttributeAliasStateMergePatched e);

        void when(AttributeAliasEvent.AttributeAliasStateRemoved e);
    }

    interface SqlAttributeAliasState extends MutableAttributeAliasState {
        AttributeAliasId getAttributeAliasId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

