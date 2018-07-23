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

    InOutLineImageId getInOutLineImageId();

    void setInOutLineImageId(InOutLineImageId inOutLineImageId);

    String getSequenceId();

    void setSequenceId(String sequenceId);

    String getUrl();

    void setUrl(String url);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

    String getInOutDocumentNumber();

    void setInOutDocumentNumber(String inOutDocumentNumber);

    String getInOutLineLineNumber();

    void setInOutLineLineNumber(String inOutLineLineNumber);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(InOutLineImageEvent.InOutLineImageStateCreated e);

    void when(InOutLineImageEvent.InOutLineImageStateMergePatched e);

    void when(InOutLineImageEvent.InOutLineImageStateRemoved e);
    
}

