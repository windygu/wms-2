package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.party.PersonEvent.*;

public abstract class AbstractPersonState extends AbstractPartyState implements PersonState.SqlPersonState
{

    private String salutation;

    public String getSalutation()
    {
        return this.salutation;
    }

    public void setSalutation(String salutation)
    {
        this.salutation = salutation;
    }

    private String firstName;

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    private String middleName;

    public String getMiddleName()
    {
        return this.middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    private String lastName;

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    private String personalTitle;

    public String getPersonalTitle()
    {
        return this.personalTitle;
    }

    public void setPersonalTitle(String personalTitle)
    {
        this.personalTitle = personalTitle;
    }

    private String nickname;

    public String getNickname()
    {
        return this.nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    private String cardId;

    public String getCardId()
    {
        return this.cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }

    public AbstractPersonState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setPartyId(((PartyEvent.SqlPartyEvent) events.get(0)).getPartyEventId().getPartyId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractPersonState() {
        this(false);
    }

    public AbstractPersonState(boolean forReapplying) {
        super.setForReapplying(forReapplying);

        initializeProperties();
    }
    
    protected void initializeProperties() {
        super.initializeProperties();
    }

    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof PersonStateCreated) {
            when((PersonStateCreated) e);
        } else if (e instanceof PersonStateMergePatched) {
            when((PersonStateMergePatched) e);
        } else if (e instanceof PersonStateDeleted) {
            when((PersonStateDeleted) e);
        } else if (e instanceof PartyEvent.PartyStateDeleted) {
            when((PartyEvent.PartyStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(PersonStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setPartyTypeId(e.getPartyTypeId());
        this.setPrimaryRoleTypeId(e.getPrimaryRoleTypeId());
        this.setExternalId(e.getExternalId());
        this.setPreferredCurrencyUomId(e.getPreferredCurrencyUomId());
        this.setDescription(e.getDescription());
        this.setActive(e.getActive());
        this.setSalutation(e.getSalutation());
        this.setFirstName(e.getFirstName());
        this.setMiddleName(e.getMiddleName());
        this.setLastName(e.getLastName());
        this.setPersonalTitle(e.getPersonalTitle());
        this.setNickname(e.getNickname());
        this.setCardId(e.getCardId());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    @Override
    protected void merge(PartyState s) {
        merge((PersonState)s);
    }

    protected void merge(PersonState s) {
        if (s == this) {
            return;
        }
        this.setPartyTypeId(s.getPartyTypeId());
        this.setPrimaryRoleTypeId(s.getPrimaryRoleTypeId());
        this.setExternalId(s.getExternalId());
        this.setPreferredCurrencyUomId(s.getPreferredCurrencyUomId());
        this.setDescription(s.getDescription());
        this.setActive(s.getActive());
        this.setSalutation(s.getSalutation());
        this.setFirstName(s.getFirstName());
        this.setMiddleName(s.getMiddleName());
        this.setLastName(s.getLastName());
        this.setPersonalTitle(s.getPersonalTitle());
        this.setNickname(s.getNickname());
        this.setCardId(s.getCardId());
    }

    public void when(PersonStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getPartyTypeId() == null)
        {
            if (e.getIsPropertyPartyTypeIdRemoved() != null && e.getIsPropertyPartyTypeIdRemoved())
            {
                this.setPartyTypeId(null);
            }
        }
        else
        {
            this.setPartyTypeId(e.getPartyTypeId());
        }
        if (e.getPrimaryRoleTypeId() == null)
        {
            if (e.getIsPropertyPrimaryRoleTypeIdRemoved() != null && e.getIsPropertyPrimaryRoleTypeIdRemoved())
            {
                this.setPrimaryRoleTypeId(null);
            }
        }
        else
        {
            this.setPrimaryRoleTypeId(e.getPrimaryRoleTypeId());
        }
        if (e.getExternalId() == null)
        {
            if (e.getIsPropertyExternalIdRemoved() != null && e.getIsPropertyExternalIdRemoved())
            {
                this.setExternalId(null);
            }
        }
        else
        {
            this.setExternalId(e.getExternalId());
        }
        if (e.getPreferredCurrencyUomId() == null)
        {
            if (e.getIsPropertyPreferredCurrencyUomIdRemoved() != null && e.getIsPropertyPreferredCurrencyUomIdRemoved())
            {
                this.setPreferredCurrencyUomId(null);
            }
        }
        else
        {
            this.setPreferredCurrencyUomId(e.getPreferredCurrencyUomId());
        }
        if (e.getDescription() == null)
        {
            if (e.getIsPropertyDescriptionRemoved() != null && e.getIsPropertyDescriptionRemoved())
            {
                this.setDescription(null);
            }
        }
        else
        {
            this.setDescription(e.getDescription());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }
        if (e.getSalutation() == null)
        {
            if (e.getIsPropertySalutationRemoved() != null && e.getIsPropertySalutationRemoved())
            {
                this.setSalutation(null);
            }
        }
        else
        {
            this.setSalutation(e.getSalutation());
        }
        if (e.getFirstName() == null)
        {
            if (e.getIsPropertyFirstNameRemoved() != null && e.getIsPropertyFirstNameRemoved())
            {
                this.setFirstName(null);
            }
        }
        else
        {
            this.setFirstName(e.getFirstName());
        }
        if (e.getMiddleName() == null)
        {
            if (e.getIsPropertyMiddleNameRemoved() != null && e.getIsPropertyMiddleNameRemoved())
            {
                this.setMiddleName(null);
            }
        }
        else
        {
            this.setMiddleName(e.getMiddleName());
        }
        if (e.getLastName() == null)
        {
            if (e.getIsPropertyLastNameRemoved() != null && e.getIsPropertyLastNameRemoved())
            {
                this.setLastName(null);
            }
        }
        else
        {
            this.setLastName(e.getLastName());
        }
        if (e.getPersonalTitle() == null)
        {
            if (e.getIsPropertyPersonalTitleRemoved() != null && e.getIsPropertyPersonalTitleRemoved())
            {
                this.setPersonalTitle(null);
            }
        }
        else
        {
            this.setPersonalTitle(e.getPersonalTitle());
        }
        if (e.getNickname() == null)
        {
            if (e.getIsPropertyNicknameRemoved() != null && e.getIsPropertyNicknameRemoved())
            {
                this.setNickname(null);
            }
        }
        else
        {
            this.setNickname(e.getNickname());
        }
        if (e.getCardId() == null)
        {
            if (e.getIsPropertyCardIdRemoved() != null && e.getIsPropertyCardIdRemoved())
            {
                this.setCardId(null);
            }
        }
        else
        {
            this.setCardId(e.getCardId());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(PersonStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
       super.save();
    }

    public static class SimplePersonState extends AbstractPersonState
    {

        public SimplePersonState() {
        }

        public SimplePersonState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimplePersonState(List<Event> events) {
            super(events);
        }

    }


}

