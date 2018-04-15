package org.dddml.wms.domain.party;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.party.PartyEvent.*;

public interface OrganizationState extends PartyState
{
    String getOrganizationName();

    void setOrganizationName(String organizationName);

    String getDescription();

    void setDescription(String description);

    String getType();

    void setType(String type);

    Boolean getIsSummary();

    void setIsSummary(Boolean isSummary);

    void when(OrganizationEvent.OrganizationStateCreated e);

    void when(OrganizationEvent.OrganizationStateMergePatched e);

    void when(OrganizationEvent.OrganizationStateDeleted e);
    
}

