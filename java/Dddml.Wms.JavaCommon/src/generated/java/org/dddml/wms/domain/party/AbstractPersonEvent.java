package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractPersonEvent extends AbstractPartyEvent implements PartyEvent 
{
    protected AbstractPersonEvent() {
    }

    protected AbstractPersonEvent(PartyEventId eventId) {
        super(eventId);
    }


    public static abstract class AbstractPersonStateEvent extends AbstractPartyStateEvent implements PersonEvent.PersonStateEvent {
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

        protected AbstractPersonStateEvent(PartyEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractPersonStateCreated extends AbstractPersonStateEvent implements PersonEvent.PersonStateCreated
    {
        public AbstractPersonStateCreated() {
            this(new PartyEventId());
        }

        public AbstractPersonStateCreated(PartyEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractPersonStateMergePatched extends AbstractPersonStateEvent implements PersonEvent.PersonStateMergePatched
    {
        public AbstractPersonStateMergePatched() {
            this(new PartyEventId());
        }

        public AbstractPersonStateMergePatched(PartyEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertySalutationRemoved;

        public Boolean getIsPropertySalutationRemoved() {
            return this.isPropertySalutationRemoved;
        }

        public void setIsPropertySalutationRemoved(Boolean removed) {
            this.isPropertySalutationRemoved = removed;
        }

        private Boolean isPropertyFirstNameRemoved;

        public Boolean getIsPropertyFirstNameRemoved() {
            return this.isPropertyFirstNameRemoved;
        }

        public void setIsPropertyFirstNameRemoved(Boolean removed) {
            this.isPropertyFirstNameRemoved = removed;
        }

        private Boolean isPropertyMiddleNameRemoved;

        public Boolean getIsPropertyMiddleNameRemoved() {
            return this.isPropertyMiddleNameRemoved;
        }

        public void setIsPropertyMiddleNameRemoved(Boolean removed) {
            this.isPropertyMiddleNameRemoved = removed;
        }

        private Boolean isPropertyLastNameRemoved;

        public Boolean getIsPropertyLastNameRemoved() {
            return this.isPropertyLastNameRemoved;
        }

        public void setIsPropertyLastNameRemoved(Boolean removed) {
            this.isPropertyLastNameRemoved = removed;
        }

        private Boolean isPropertyPersonalTitleRemoved;

        public Boolean getIsPropertyPersonalTitleRemoved() {
            return this.isPropertyPersonalTitleRemoved;
        }

        public void setIsPropertyPersonalTitleRemoved(Boolean removed) {
            this.isPropertyPersonalTitleRemoved = removed;
        }

        private Boolean isPropertyNicknameRemoved;

        public Boolean getIsPropertyNicknameRemoved() {
            return this.isPropertyNicknameRemoved;
        }

        public void setIsPropertyNicknameRemoved(Boolean removed) {
            this.isPropertyNicknameRemoved = removed;
        }

        private Boolean isPropertyCardIdRemoved;

        public Boolean getIsPropertyCardIdRemoved() {
            return this.isPropertyCardIdRemoved;
        }

        public void setIsPropertyCardIdRemoved(Boolean removed) {
            this.isPropertyCardIdRemoved = removed;
        }

        private Boolean isPropertyPartyTypeIdRemoved;

        public Boolean getIsPropertyPartyTypeIdRemoved() {
            return this.isPropertyPartyTypeIdRemoved;
        }

        public void setIsPropertyPartyTypeIdRemoved(Boolean removed) {
            this.isPropertyPartyTypeIdRemoved = removed;
        }

        private Boolean isPropertyPrimaryRoleTypeIdRemoved;

        public Boolean getIsPropertyPrimaryRoleTypeIdRemoved() {
            return this.isPropertyPrimaryRoleTypeIdRemoved;
        }

        public void setIsPropertyPrimaryRoleTypeIdRemoved(Boolean removed) {
            this.isPropertyPrimaryRoleTypeIdRemoved = removed;
        }

        private Boolean isPropertyExternalIdRemoved;

        public Boolean getIsPropertyExternalIdRemoved() {
            return this.isPropertyExternalIdRemoved;
        }

        public void setIsPropertyExternalIdRemoved(Boolean removed) {
            this.isPropertyExternalIdRemoved = removed;
        }

        private Boolean isPropertyPreferredCurrencyUomIdRemoved;

        public Boolean getIsPropertyPreferredCurrencyUomIdRemoved() {
            return this.isPropertyPreferredCurrencyUomIdRemoved;
        }

        public void setIsPropertyPreferredCurrencyUomIdRemoved(Boolean removed) {
            this.isPropertyPreferredCurrencyUomIdRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractPersonStateDeleted extends AbstractPersonStateEvent implements PersonEvent.PersonStateDeleted
    {
        public AbstractPersonStateDeleted() {
            this(new PartyEventId());
        }

        public AbstractPersonStateDeleted(PartyEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimplePersonStateCreated extends AbstractPersonStateCreated
    {
        public SimplePersonStateCreated() {
        }

        public SimplePersonStateCreated(PartyEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePersonStateMergePatched extends AbstractPersonStateMergePatched
    {
        public SimplePersonStateMergePatched() {
        }

        public SimplePersonStateMergePatched(PartyEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePersonStateDeleted extends AbstractPersonStateDeleted
    {
        public SimplePersonStateDeleted() {
        }

        public SimplePersonStateDeleted(PartyEventId eventId) {
            super(eventId);
        }
    }

}

