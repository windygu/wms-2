package org.dddml.wms.domain.damagereason;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.damagereason.DamageReasonEvent.*;

public interface DamageReasonState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDamageReasonId();

    String getDescription();

    String getSequenceId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableDamageReasonState extends DamageReasonState {
        void setDamageReasonId(String damageReasonId);

        void setDescription(String description);

        void setSequenceId(String sequenceId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(DamageReasonEvent.DamageReasonStateCreated e);

        void when(DamageReasonEvent.DamageReasonStateMergePatched e);

        void when(DamageReasonEvent.DamageReasonStateDeleted e);
    }

    interface SqlDamageReasonState extends MutableDamageReasonState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

