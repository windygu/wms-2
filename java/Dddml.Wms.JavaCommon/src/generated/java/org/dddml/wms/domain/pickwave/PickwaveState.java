package org.dddml.wms.domain.pickwave;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.pickwave.PickwaveStateEvent.*;

public interface PickwaveState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    Long getPickwaveId();

    void setPickwaveId(Long pickwaveId);

    String getStatusId();

    void setStatusId(String statusId);

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

    Boolean getDeleted();

    void setDeleted(Boolean deleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(PickwaveStateEvent.PickwaveStateCreated e);

    void when(PickwaveStateEvent.PickwaveStateMergePatched e);

    void when(PickwaveStateEvent.PickwaveStateDeleted e);
    
}

