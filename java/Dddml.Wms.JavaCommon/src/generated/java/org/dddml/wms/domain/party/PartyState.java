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

    String getPartyTypeId();

    String getPrimaryRoleTypeId();

    String getExternalId();

    String getPreferredCurrencyUomId();

    String getDescription();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutablePartyState extends PartyState {
        void setPartyId(String partyId);

        void setPartyTypeId(String partyTypeId);

        void setPrimaryRoleTypeId(String primaryRoleTypeId);

        void setExternalId(String externalId);

        void setPreferredCurrencyUomId(String preferredCurrencyUomId);

        void setDescription(String description);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(PartyEvent.PartyStateCreated e);

        void when(PartyEvent.PartyStateMergePatched e);

        void when(PartyEvent.PartyStateDeleted e);
    }

    interface SqlPartyState extends MutablePartyState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

