package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface OrganizationEvent extends PartyEvent {

    interface OrganizationStateEvent extends PartyStateEvent, OrganizationEvent {
        String getOrganizationName();

        void setOrganizationName(String organizationName);

        Boolean getIsSummary();

        void setIsSummary(Boolean isSummary);

    }

    interface OrganizationStateCreated extends OrganizationStateEvent
    {
    
    }


    interface OrganizationStateMergePatched extends OrganizationStateEvent
    {
        Boolean getIsPropertyOrganizationNameRemoved();

        void setIsPropertyOrganizationNameRemoved(Boolean removed);

        Boolean getIsPropertyIsSummaryRemoved();

        void setIsPropertyIsSummaryRemoved(Boolean removed);

        Boolean getIsPropertyPartyTypeIdRemoved();

        void setIsPropertyPartyTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryRoleTypeIdRemoved();

        void setIsPropertyPrimaryRoleTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyExternalIdRemoved();

        void setIsPropertyExternalIdRemoved(Boolean removed);

        Boolean getIsPropertyPreferredCurrencyUomIdRemoved();

        void setIsPropertyPreferredCurrencyUomIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface OrganizationStateDeleted extends OrganizationStateEvent
    {
    }


}

