package org.dddml.wms.domain.party;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.party.PartyStateEvent.*;

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

    void when(OrganizationStateEvent.OrganizationStateCreated e);

    void when(OrganizationStateEvent.OrganizationStateMergePatched e);

    void when(OrganizationStateEvent.OrganizationStateDeleted e);
    
}

