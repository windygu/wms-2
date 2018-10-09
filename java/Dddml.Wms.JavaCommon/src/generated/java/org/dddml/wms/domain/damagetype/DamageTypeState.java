package org.dddml.wms.domain.damagetype;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface DamageTypeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDamageTypeId();

    String getDescription();

    String getSequenceId();

    String getDefaultHandlingMethodId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getCommandId();

    interface MutableDamageTypeState extends DamageTypeState {
        void setDamageTypeId(String damageTypeId);

        void setDescription(String description);

        void setSequenceId(String sequenceId);

        void setDefaultHandlingMethodId(String defaultHandlingMethodId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setCommandId(String commandId);

    }

    interface SqlDamageTypeState extends MutableDamageTypeState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

