package org.dddml.wms.domain.inout;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inout.InOutLineImageEvent.*;

public interface InOutLineImageState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getSequenceId();

    String getUrl();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getInOutDocumentNumber();

    String getInOutLineLineNumber();

    interface MutableInOutLineImageState extends InOutLineImageState {
        void setInOutLineImageId(InOutLineImageId inOutLineImageId);

        void setSequenceId(String sequenceId);

        void setUrl(String url);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setInOutDocumentNumber(String inOutDocumentNumber);

        void setInOutLineLineNumber(String inOutLineLineNumber);


        void mutate(Event e);

        void when(InOutLineImageEvent.InOutLineImageStateCreated e);

        void when(InOutLineImageEvent.InOutLineImageStateMergePatched e);

        void when(InOutLineImageEvent.InOutLineImageStateRemoved e);
    }

    interface SqlInOutLineImageState extends MutableInOutLineImageState {
        InOutLineImageId getInOutLineImageId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

