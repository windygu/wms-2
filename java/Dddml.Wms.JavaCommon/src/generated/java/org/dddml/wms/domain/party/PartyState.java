package org.dddml.wms.domain.party;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.party.PartyEvent.*;

public interface PartyState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getPartyId();

    void setPartyId(String partyId);

    String getPartyTypeId();

    void setPartyTypeId(String partyTypeId);

    String getPrimaryRoleTypeId();

    void setPrimaryRoleTypeId(String primaryRoleTypeId);

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

    void when(PartyEvent.PartyStateCreated e);

    void when(PartyEvent.PartyStateMergePatched e);

    void when(PartyEvent.PartyStateDeleted e);
    
}

