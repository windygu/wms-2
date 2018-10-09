package org.dddml.wms.domain.partyrole;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.partyrole.PartyRoleEvent.*;

public interface PartyRoleState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    PartyRoleId getPartyRoleId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutablePartyRoleState extends PartyRoleState {
        void setPartyRoleId(PartyRoleId partyRoleId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(PartyRoleEvent.PartyRoleStateCreated e);

        void when(PartyRoleEvent.PartyRoleStateMergePatched e);

        void when(PartyRoleEvent.PartyRoleStateDeleted e);
    }

    interface SqlPartyRoleState extends MutablePartyRoleState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

