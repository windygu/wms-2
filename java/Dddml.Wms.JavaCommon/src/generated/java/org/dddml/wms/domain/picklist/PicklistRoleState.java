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

    PartyRoleId getPartyRoleId();

    String getCreatedByUserLogin();

    String getLastModifiedByUserLogin();

    Long getVersion();

    Date getCreatedAt();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getPicklistId();

    interface MutablePicklistRoleState extends PicklistRoleState {
        void setPicklistRoleId(PicklistRoleId picklistRoleId);

        void setPartyRoleId(PartyRoleId partyRoleId);

        void setCreatedByUserLogin(String createdByUserLogin);

        void setLastModifiedByUserLogin(String lastModifiedByUserLogin);

        void setVersion(Long version);

        void setCreatedAt(Date createdAt);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setPicklistId(String picklistId);


        void mutate(Event e);

        void when(PicklistRoleEvent.PicklistRoleStateCreated e);

        void when(PicklistRoleEvent.PicklistRoleStateMergePatched e);

        void when(PicklistRoleEvent.PicklistRoleStateRemoved e);
    }

    interface SqlPicklistRoleState extends MutablePicklistRoleState {
        PicklistRoleId getPicklistRoleId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

