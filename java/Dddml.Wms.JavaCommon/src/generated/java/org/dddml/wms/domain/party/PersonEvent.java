package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PersonEvent extends PartyEvent {

    interface SqlPersonEvent extends PersonEvent {
    }

    interface PersonStateEvent extends PartyStateEvent, PersonEvent {
        String getSalutation();

        void setSalutation(String salutation);

        String getFirstName();

        void setFirstName(String firstName);

        String getMiddleName();

        void setMiddleName(String middleName);

        String getLastName();

        void setLastName(String lastName);

        String getPersonalTitle();

        void setPersonalTitle(String personalTitle);

        String getNickname();

        void setNickname(String nickname);

        String getCardId();

        void setCardId(String cardId);

    }

    interface PersonStateCreated extends PersonStateEvent
    {
    
    }


    interface PersonStateMergePatched extends PersonStateEvent
    {
        Boolean getIsPropertySalutationRemoved();

        void setIsPropertySalutationRemoved(Boolean removed);

        Boolean getIsPropertyFirstNameRemoved();

        void setIsPropertyFirstNameRemoved(Boolean removed);

        Boolean getIsPropertyMiddleNameRemoved();

        void setIsPropertyMiddleNameRemoved(Boolean removed);

        Boolean getIsPropertyLastNameRemoved();

        void setIsPropertyLastNameRemoved(Boolean removed);

        Boolean getIsPropertyPersonalTitleRemoved();

        void setIsPropertyPersonalTitleRemoved(Boolean removed);

        Boolean getIsPropertyNicknameRemoved();

        void setIsPropertyNicknameRemoved(Boolean removed);

        Boolean getIsPropertyCardIdRemoved();

        void setIsPropertyCardIdRemoved(Boolean removed);

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

    interface PersonStateDeleted extends PersonStateEvent
    {
    }


}

