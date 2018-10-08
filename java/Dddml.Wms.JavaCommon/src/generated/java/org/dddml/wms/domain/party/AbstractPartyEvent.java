package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractPartyEvent extends AbstractEvent implements PartyEvent.SqlPartyEvent 
{
    private PartyEventId partyEventId;

    public PartyEventId getPartyEventId() {
        return this.partyEventId;
    }

    public void setPartyEventId(PartyEventId eventId) {
        this.partyEventId = eventId;
    }
    
    public String getPartyId() {
        return getPartyEventId().getPartyId();
    }

    public void setPartyId(String partyId) {
        getPartyEventId().setPartyId(partyId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public Long getVersion() {
        return getPartyEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getPartyEventId().setVersion(version);
    //}

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractPartyEvent() {
    }

    protected AbstractPartyEvent(PartyEventId eventId) {
        this.partyEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractPartyStateEvent extends AbstractPartyEvent implements PartyEvent.PartyStateEvent {
        private String partyTypeId;

        public String getPartyTypeId()
        {
            return this.partyTypeId;
        }

        public void setPartyTypeId(String partyTypeId)
        {
            this.partyTypeId = partyTypeId;
        }

        private String primaryRoleTypeId;

        public String getPrimaryRoleTypeId()
        {
            return this.primaryRoleTypeId;
        }

        public void setPrimaryRoleTypeId(String primaryRoleTypeId)
        {
            this.primaryRoleTypeId = primaryRoleTypeId;
        }

        private String externalId;

        public String getExternalId()
        {
            return this.externalId;
        }

        public void setExternalId(String externalId)
        {
            this.externalId = externalId;
        }

        private String preferredCurrencyUomId;

        public String getPreferredCurrencyUomId()
        {
            return this.preferredCurrencyUomId;
        }

        public void setPreferredCurrencyUomId(String preferredCurrencyUomId)
        {
            this.preferredCurrencyUomId = preferredCurrencyUomId;
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

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractPartyStateEvent(PartyEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractPartyStateCreated extends AbstractPartyStateEvent implements PartyEvent.PartyStateCreated
    {
        public AbstractPartyStateCreated() {
            this(new PartyEventId());
        }

        public AbstractPartyStateCreated(PartyEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractPartyStateMergePatched extends AbstractPartyStateEvent implements PartyEvent.PartyStateMergePatched
    {
        public AbstractPartyStateMergePatched() {
            this(new PartyEventId());
        }

        public AbstractPartyStateMergePatched(PartyEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
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


    public static abstract class AbstractPartyStateDeleted extends AbstractPartyStateEvent implements PartyEvent.PartyStateDeleted
    {
        public AbstractPartyStateDeleted() {
            this(new PartyEventId());
        }

        public AbstractPartyStateDeleted(PartyEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimplePartyStateCreated extends AbstractPartyStateCreated
    {
        public SimplePartyStateCreated() {
        }

        public SimplePartyStateCreated(PartyEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePartyStateMergePatched extends AbstractPartyStateMergePatched
    {
        public SimplePartyStateMergePatched() {
        }

        public SimplePartyStateMergePatched(PartyEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePartyStateDeleted extends AbstractPartyStateDeleted
    {
        public SimplePartyStateDeleted() {
        }

        public SimplePartyStateDeleted(PartyEventId eventId) {
            super(eventId);
        }
    }

}

