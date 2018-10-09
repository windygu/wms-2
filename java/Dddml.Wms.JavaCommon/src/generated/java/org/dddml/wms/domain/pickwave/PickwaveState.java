package org.dddml.wms.domain.pickwave;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.pickwave.PickwaveEvent.*;

public interface PickwaveState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    Long getPickwaveId();

    String getStatusId();

    String getDescription();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutablePickwaveState extends PickwaveState {
        void setPickwaveId(Long pickwaveId);

        void setStatusId(String statusId);

        void setDescription(String description);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(PickwaveEvent.PickwaveStateCreated e);

        void when(PickwaveEvent.PickwaveStateMergePatched e);

        void when(PickwaveEvent.PickwaveStateDeleted e);
    }

    interface SqlPickwaveState extends MutablePickwaveState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

