package org.dddml.wms.domain.damagetype;

import org.dddml.wms.specialization.Event;

import java.util.Date;

public interface DamageTypeState {
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getDamageTypeId();

    void setDamageTypeId(String damageTypeId);

    String getDescription();

    void setDescription(String description);

    String getSequenceId();

    void setSequenceId(String sequenceId);

    String getDefaultHandlingMethodId();

    void setDefaultHandlingMethodId(String defaultHandlingMethodId);

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

    void when(DamageTypeStateEvent.DamageTypeStateCreated e);

    void when(DamageTypeStateEvent.DamageTypeStateMergePatched e);

    void when(DamageTypeStateEvent.DamageTypeStateDeleted e);

}

