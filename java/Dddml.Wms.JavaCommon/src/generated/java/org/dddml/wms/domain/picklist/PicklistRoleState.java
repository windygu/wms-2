package org.dddml.wms.domain.picklist;

import java.util.Set;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.picklist.PicklistRoleEvent.*;

public interface PicklistRoleState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    PicklistRoleId getPicklistRoleId();

    void setPicklistRoleId(PicklistRoleId picklistRoleId);

    PartyRoleId getPartyRoleId();

    void setPartyRoleId(PartyRoleId partyRoleId);

    String getCreatedByUserLogin();

    void setCreatedByUserLogin(String createdByUserLogin);

    String getLastModifiedByUserLogin();

    void setLastModifiedByUserLogin(String lastModifiedByUserLogin);

    Long getVersion();

    void setVersion(Long version);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

    String getPicklistId();

    void setPicklistId(String picklistId);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(PicklistRoleEvent.PicklistRoleStateCreated e);

    void when(PicklistRoleEvent.PicklistRoleStateMergePatched e);

    void when(PicklistRoleEvent.PicklistRoleStateRemoved e);
    
}

