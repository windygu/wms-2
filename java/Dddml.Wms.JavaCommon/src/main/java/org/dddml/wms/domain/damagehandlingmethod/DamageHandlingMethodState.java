package org.dddml.wms.domain.damagehandlingmethod;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.damagehandlingmethod.DamageHandlingMethodStateEvent.*;

public interface DamageHandlingMethodState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDamageHandlingMethodId();

    void setDamageHandlingMethodId(String damageHandlingMethodId);

    String getDescription();

    void setDescription(String description);

    String getSequenceId();

    void setSequenceId(String sequenceId);

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

    String getCommandId();

    void setCommandId(String commandId);


    void mutate(Event e);

    void when(DamageHandlingMethodStateEvent.DamageHandlingMethodStateCreated e);

    void when(DamageHandlingMethodStateEvent.DamageHandlingMethodStateMergePatched e);

    void when(DamageHandlingMethodStateEvent.DamageHandlingMethodStateDeleted e);
    
}

