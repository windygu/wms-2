package org.dddml.wms.domain.statusitem;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.statusitem.StatusItemEvent.*;

public interface StatusItemState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getStatusId();

    String getStatusTypeId();

    String getStatusCode();

    String getSequenceId();

    String getDescription();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    String getCommandId();

    interface MutableStatusItemState extends StatusItemState {
        void setStatusId(String statusId);

        void setStatusTypeId(String statusTypeId);

        void setStatusCode(String statusCode);

        void setSequenceId(String sequenceId);

        void setDescription(String description);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setCommandId(String commandId);


        void mutate(Event e);

        void when(StatusItemEvent.StatusItemStateCreated e);

        void when(StatusItemEvent.StatusItemStateMergePatched e);

    }

    interface SqlStatusItemState extends MutableStatusItemState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

