package org.dddml.wms.domain.rejectionreason;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.rejectionreason.RejectionReasonEvent.*;

public interface RejectionReasonState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getRejectionReasonId();

    String getDescription();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableRejectionReasonState extends RejectionReasonState {
        void setRejectionReasonId(String rejectionReasonId);

        void setDescription(String description);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(RejectionReasonEvent.RejectionReasonStateCreated e);

        void when(RejectionReasonEvent.RejectionReasonStateMergePatched e);

        void when(RejectionReasonEvent.RejectionReasonStateDeleted e);
    }

    interface SqlRejectionReasonState extends MutableRejectionReasonState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

