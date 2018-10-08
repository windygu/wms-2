package org.dddml.wms.domain.partyrole;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractPartyRoleEvent extends AbstractEvent implements PartyRoleEvent.SqlPartyRoleEvent 
{
    private PartyRoleEventId partyRoleEventId;

    public PartyRoleEventId getPartyRoleEventId() {
        return this.partyRoleEventId;
    }

    public void setPartyRoleEventId(PartyRoleEventId eventId) {
        this.partyRoleEventId = eventId;
    }
    
    public PartyRoleId getPartyRoleId() {
        return getPartyRoleEventId().getPartyRoleId();
    }

    public void setPartyRoleId(PartyRoleId partyRoleId) {
        getPartyRoleEventId().setPartyRoleId(partyRoleId);
    }

    public Long getVersion() {
        return getPartyRoleEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getPartyRoleEventId().setVersion(version);
    //}

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractPartyRoleEvent() {
    }

    protected AbstractPartyRoleEvent(PartyRoleEventId eventId) {
        this.partyRoleEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractPartyRoleStateEvent extends AbstractPartyRoleEvent implements PartyRoleEvent.PartyRoleStateEvent {
        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

        protected AbstractPartyRoleStateEvent(PartyRoleEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractPartyRoleStateCreated extends AbstractPartyRoleStateEvent implements PartyRoleEvent.PartyRoleStateCreated
    {
        public AbstractPartyRoleStateCreated() {
            this(new PartyRoleEventId());
        }

        public AbstractPartyRoleStateCreated(PartyRoleEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractPartyRoleStateMergePatched extends AbstractPartyRoleStateEvent implements PartyRoleEvent.PartyRoleStateMergePatched
    {
        public AbstractPartyRoleStateMergePatched() {
            this(new PartyRoleEventId());
        }

        public AbstractPartyRoleStateMergePatched(PartyRoleEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractPartyRoleStateDeleted extends AbstractPartyRoleStateEvent implements PartyRoleEvent.PartyRoleStateDeleted
    {
        public AbstractPartyRoleStateDeleted() {
            this(new PartyRoleEventId());
        }

        public AbstractPartyRoleStateDeleted(PartyRoleEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimplePartyRoleStateCreated extends AbstractPartyRoleStateCreated
    {
        public SimplePartyRoleStateCreated() {
        }

        public SimplePartyRoleStateCreated(PartyRoleEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePartyRoleStateMergePatched extends AbstractPartyRoleStateMergePatched
    {
        public SimplePartyRoleStateMergePatched() {
        }

        public SimplePartyRoleStateMergePatched(PartyRoleEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePartyRoleStateDeleted extends AbstractPartyRoleStateDeleted
    {
        public SimplePartyRoleStateDeleted() {
        }

        public SimplePartyRoleStateDeleted(PartyRoleEventId eventId) {
            super(eventId);
        }
    }

}

