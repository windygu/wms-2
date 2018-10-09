package org.dddml.wms.domain.inout;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inout.InOutImageEvent.*;

public interface InOutImageState
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

    interface MutableInOutImageState extends InOutImageState {
        void setInOutImageId(InOutImageId inOutImageId);

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


        void mutate(Event e);

        void when(InOutImageEvent.InOutImageStateCreated e);

        void when(InOutImageEvent.InOutImageStateMergePatched e);

        void when(InOutImageEvent.InOutImageStateRemoved e);
    }

    interface SqlInOutImageState extends MutableInOutImageState {
        InOutImageId getInOutImageId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

