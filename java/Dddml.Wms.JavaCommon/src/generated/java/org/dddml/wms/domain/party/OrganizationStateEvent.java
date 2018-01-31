package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrganizationStateEvent extends PartyStateEvent
{
    String getOrganizationName();

    void setOrganizationName(String organizationName);

    String getDescription();

    void setDescription(String description);

    String getType();

    void setType(String type);

    Boolean getIsSummary();

    void setIsSummary(Boolean isSummary);

    interface OrganizationStateCreated extends OrganizationStateEvent
    {
    
    }


    interface OrganizationStateMergePatched extends OrganizationStateEvent
    {
        Boolean getIsPropertyOrganizationNameRemoved();

        void setIsPropertyOrganizationNameRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyTypeRemoved();

        void setIsPropertyTypeRemoved(Boolean removed);

        Boolean getIsPropertyIsSummaryRemoved();

        void setIsPropertyIsSummaryRemoved(Boolean removed);

        Boolean getIsPropertyPartyTypeIdRemoved();

        void setIsPropertyPartyTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface OrganizationStateDeleted extends OrganizationStateEvent
    {
    }


}

