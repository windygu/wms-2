package org.dddml.wms.domain.party;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.party.PartyEvent.*;

public interface OrganizationState extends PartyState
{
    String getOrganizationName();

    Boolean getIsSummary();

    interface MutableOrganizationState extends OrganizationState, PartyState.MutablePartyState {
        void setOrganizationName(String organizationName);

        void setIsSummary(Boolean isSummary);

        void when(OrganizationEvent.OrganizationStateCreated e);

        void when(OrganizationEvent.OrganizationStateMergePatched e);

        void when(OrganizationEvent.OrganizationStateDeleted e);
    }

    interface SqlOrganizationState extends MutableOrganizationState, PartyState.SqlPartyState {
    }
}

