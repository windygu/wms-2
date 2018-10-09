package org.dddml.wms.domain.attributeset;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attributeset.AttributeSetEvent.*;

public interface AttributeSetState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getAttributeSetId();

    String getAttributeSetName();

    String getOrganizationId();

    String getDescription();

    String getReferenceId();

    Boolean getIsInstanceAttributeSet();

    Boolean getIsMandatory();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    EntityStateCollection<String, AttributeUseState> getAttributeUses();

    interface MutableAttributeSetState extends AttributeSetState {
        void setAttributeSetId(String attributeSetId);

        void setAttributeSetName(String attributeSetName);

        void setOrganizationId(String organizationId);

        void setDescription(String description);

        void setReferenceId(String referenceId);

        void setIsInstanceAttributeSet(Boolean isInstanceAttributeSet);

        void setIsMandatory(Boolean isMandatory);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(AttributeSetEvent.AttributeSetStateCreated e);

        void when(AttributeSetEvent.AttributeSetStateMergePatched e);

        void when(AttributeSetEvent.AttributeSetStateDeleted e);
    }

    interface SqlAttributeSetState extends MutableAttributeSetState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

