package org.dddml.wms.domain.damagehandlingmethod;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface DamageHandlingMethodState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDamageHandlingMethodId();

    String getDescription();

    String getSequenceId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getCommandId();

    interface MutableDamageHandlingMethodState extends DamageHandlingMethodState {
        void setDamageHandlingMethodId(String damageHandlingMethodId);

        void setDescription(String description);

        void setSequenceId(String sequenceId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setCommandId(String commandId);

    }

    interface SqlDamageHandlingMethodState extends MutableDamageHandlingMethodState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

