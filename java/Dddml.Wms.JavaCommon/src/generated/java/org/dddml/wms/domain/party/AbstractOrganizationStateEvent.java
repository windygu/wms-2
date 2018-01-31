package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractOrganizationStateEvent extends AbstractPartyStateEvent implements PartyStateEvent 
{
    private String organizationName;

    public String getOrganizationName()
    {
        return this.organizationName;
    }

    public void setOrganizationName(String organizationName)
    {
        this.organizationName = organizationName;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String type;

    public String getType()
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
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

    protected AbstractOrganizationStateEvent() {
    }

    protected AbstractOrganizationStateEvent(PartyStateEventId stateEventId) {
        super(stateEventId);
    }


    public static abstract class AbstractOrganizationStateCreated extends AbstractOrganizationStateEvent implements OrganizationStateEvent.OrganizationStateCreated
    {
        public AbstractOrganizationStateCreated() {
            this(new PartyStateEventId());
        }

        public AbstractOrganizationStateCreated(PartyStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractOrganizationStateMergePatched extends AbstractOrganizationStateEvent implements OrganizationStateEvent.OrganizationStateMergePatched
    {
        public AbstractOrganizationStateMergePatched() {
            this(new PartyStateEventId());
        }

        public AbstractOrganizationStateMergePatched(PartyStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyOrganizationNameRemoved;

        public Boolean getIsPropertyOrganizationNameRemoved() {
            return this.isPropertyOrganizationNameRemoved;
        }

        public void setIsPropertyOrganizationNameRemoved(Boolean removed) {
            this.isPropertyOrganizationNameRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyTypeRemoved;

        public Boolean getIsPropertyTypeRemoved() {
            return this.isPropertyTypeRemoved;
        }

        public void setIsPropertyTypeRemoved(Boolean removed) {
            this.isPropertyTypeRemoved = removed;
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

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractOrganizationStateDeleted extends AbstractOrganizationStateEvent implements OrganizationStateEvent.OrganizationStateDeleted
    {
        public AbstractOrganizationStateDeleted() {
            this(new PartyStateEventId());
        }

        public AbstractOrganizationStateDeleted(PartyStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleOrganizationStateCreated extends AbstractOrganizationStateCreated
    {
        public SimpleOrganizationStateCreated() {
        }

        public SimpleOrganizationStateCreated(PartyStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleOrganizationStateMergePatched extends AbstractOrganizationStateMergePatched
    {
        public SimpleOrganizationStateMergePatched() {
        }

        public SimpleOrganizationStateMergePatched(PartyStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleOrganizationStateDeleted extends AbstractOrganizationStateDeleted
    {
        public SimpleOrganizationStateDeleted() {
        }

        public SimpleOrganizationStateDeleted(PartyStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

