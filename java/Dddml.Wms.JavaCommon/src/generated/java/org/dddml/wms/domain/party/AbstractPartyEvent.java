package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractPartyEvent extends AbstractEvent implements PartyEvent 
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

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
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


    public static abstract class AbstractPartyStateCreated extends AbstractPartyEvent implements PartyEvent.PartyStateCreated
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


    public static abstract class AbstractPartyStateMergePatched extends AbstractPartyEvent implements PartyEvent.PartyStateMergePatched
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

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractPartyStateDeleted extends AbstractPartyEvent implements PartyEvent.PartyStateDeleted
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

