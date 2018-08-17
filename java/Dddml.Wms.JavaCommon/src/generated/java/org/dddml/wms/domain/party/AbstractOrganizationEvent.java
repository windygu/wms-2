package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractOrganizationEvent extends AbstractPartyEvent implements PartyEvent 
{
    protected AbstractOrganizationEvent() {
    }

    protected AbstractOrganizationEvent(PartyEventId eventId) {
        super(eventId);
    }


    public static abstract class AbstractOrganizationStateEvent extends AbstractPartyStateEvent implements OrganizationEvent.OrganizationStateEvent {
        private String organizationName;

        public String getOrganizationName()
        {
            return this.organizationName;
        }

        public void setOrganizationName(String organizationName)
        {
            this.organizationName = organizationName;
        }

        private Boolean isSummary;

        public Boolean getIsSummary()
        {
            return this.isSummary;
        }

        public void setIsSummary(Boolean isSummary)
        {
            this.isSummary = isSummary;
        }

        protected AbstractOrganizationStateEvent(PartyEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractOrganizationStateCreated extends AbstractOrganizationStateEvent implements OrganizationEvent.OrganizationStateCreated
    {
        public AbstractOrganizationStateCreated() {
            this(new PartyEventId());
        }

        public AbstractOrganizationStateCreated(PartyEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractOrganizationStateMergePatched extends AbstractOrganizationStateEvent implements OrganizationEvent.OrganizationStateMergePatched
    {
        public AbstractOrganizationStateMergePatched() {
            this(new PartyEventId());
        }

        public AbstractOrganizationStateMergePatched(PartyEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyOrganizationNameRemoved;

        public Boolean getIsPropertyOrganizationNameRemoved() {
            return this.isPropertyOrganizationNameRemoved;
        }

        public void setIsPropertyOrganizationNameRemoved(Boolean removed) {
            this.isPropertyOrganizationNameRemoved = removed;
        }

        private Boolean isPropertyIsSummaryRemoved;

        public Boolean getIsPropertyIsSummaryRemoved() {
            return this.isPropertyIsSummaryRemoved;
        }

        public void setIsPropertyIsSummaryRemoved(Boolean removed) {
            this.isPropertyIsSummaryRemoved = removed;
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


    public static abstract class AbstractOrganizationStateDeleted extends AbstractOrganizationStateEvent implements OrganizationEvent.OrganizationStateDeleted
    {
        public AbstractOrganizationStateDeleted() {
            this(new PartyEventId());
        }

        public AbstractOrganizationStateDeleted(PartyEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleOrganizationStateCreated extends AbstractOrganizationStateCreated
    {
        public SimpleOrganizationStateCreated() {
        }

        public SimpleOrganizationStateCreated(PartyEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrganizationStateMergePatched extends AbstractOrganizationStateMergePatched
    {
        public SimpleOrganizationStateMergePatched() {
        }

        public SimpleOrganizationStateMergePatched(PartyEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleOrganizationStateDeleted extends AbstractOrganizationStateDeleted
    {
        public SimpleOrganizationStateDeleted() {
        }

        public SimpleOrganizationStateDeleted(PartyEventId eventId) {
            super(eventId);
        }
    }

}

