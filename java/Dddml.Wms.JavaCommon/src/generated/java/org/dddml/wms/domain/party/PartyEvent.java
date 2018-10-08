package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PartyEvent extends Event {

    interface SqlPartyEvent extends PartyEvent {
        PartyEventId getPartyEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    String getPartyId();

    //void setPartyId(String partyId);

    Long getVersion();
    
    //void getVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface PartyStateEvent extends PartyEvent {
        String getPartyTypeId();

        void setPartyTypeId(String partyTypeId);

        String getPrimaryRoleTypeId();

        void setPrimaryRoleTypeId(String primaryRoleTypeId);

        String getExternalId();

        void setExternalId(String externalId);

        String getPreferredCurrencyUomId();

        void setPreferredCurrencyUomId(String preferredCurrencyUomId);

        String getDescription();

        void setDescription(String description);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface PartyStateCreated extends PartyStateEvent
    {
    
    }


    interface PartyStateMergePatched extends PartyStateEvent
    {
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

    interface PartyStateDeleted extends PartyStateEvent
    {
    }


}

