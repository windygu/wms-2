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

    InOutImageId getInOutImageId();

    void setInOutImageId(InOutImageId inOutImageId);

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


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(InOutImageEvent.InOutImageStateCreated e);

    void when(InOutImageEvent.InOutImageStateMergePatched e);

    void when(InOutImageEvent.InOutImageStateRemoved e);
    
}

