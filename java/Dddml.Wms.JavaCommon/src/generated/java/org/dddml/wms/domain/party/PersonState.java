package org.dddml.wms.domain.party;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.party.PartyEvent.*;

public interface PersonState extends PartyState
{
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

    void when(PersonEvent.PersonStateCreated e);

    void when(PersonEvent.PersonStateMergePatched e);

    void when(PersonEvent.PersonStateDeleted e);
    
}

