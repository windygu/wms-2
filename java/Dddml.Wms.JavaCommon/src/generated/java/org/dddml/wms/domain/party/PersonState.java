package org.dddml.wms.domain.party;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.party.PartyEvent.*;

public interface PersonState extends PartyState
{
    String getSalutation();

    String getFirstName();

    String getMiddleName();

    String getLastName();

    String getPersonalTitle();

    String getNickname();

    String getCardId();

    interface MutablePersonState extends PersonState, PartyState.MutablePartyState {
        void setSalutation(String salutation);

        void setFirstName(String firstName);

        void setMiddleName(String middleName);

        void setLastName(String lastName);

        void setPersonalTitle(String personalTitle);

        void setNickname(String nickname);

        void setCardId(String cardId);

        void when(PersonEvent.PersonStateCreated e);

        void when(PersonEvent.PersonStateMergePatched e);

        void when(PersonEvent.PersonStateDeleted e);
    }

    interface SqlPersonState extends MutablePersonState, PartyState.SqlPartyState {
    }
}

