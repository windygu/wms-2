package org.dddml.wms.domain.statusitem;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.statusitem.StatusItemStateEvent.*;

public interface StatusItemState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getStatusId();

    void setStatusId(String statusId);

    String getStatusTypeId();

    void setStatusTypeId(String statusTypeId);

    String getStatusCode();

    void setStatusCode(String statusCode);

    String getSequenceId();

    void setSequenceId(String sequenceId);

    String getDescription();

    void setDescription(String description);

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


    boolean isStateUnsaved();

    boolean getForReapplying();

    String getCommandId();

    void setCommandId(String commandId);


    void mutate(Event e);

    void when(StatusItemStateEvent.StatusItemStateCreated e);

    void when(StatusItemStateEvent.StatusItemStateMergePatched e);

    
}

