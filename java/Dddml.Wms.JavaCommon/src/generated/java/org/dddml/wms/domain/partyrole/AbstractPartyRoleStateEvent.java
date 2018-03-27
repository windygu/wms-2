package org.dddml.wms.domain.partyrole;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractPartyRoleStateEvent extends AbstractStateEvent implements PartyRoleStateEvent 
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

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractPartyRoleStateEvent() {
    }

    protected AbstractPartyRoleStateEvent(PartyRoleEventId eventId) {
        this.partyRoleEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractPartyRoleStateCreated extends AbstractPartyRoleStateEvent implements PartyRoleStateEvent.PartyRoleStateCreated
    {
        public AbstractPartyRoleStateCreated() {
            this(new PartyRoleEventId());
        }

        public AbstractPartyRoleStateCreated(PartyRoleEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractPartyRoleStateMergePatched extends AbstractPartyRoleStateEvent implements PartyRoleStateEvent.PartyRoleStateMergePatched
    {
        public AbstractPartyRoleStateMergePatched() {
            this(new PartyRoleEventId());
        }

        public AbstractPartyRoleStateMergePatched(PartyRoleEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
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


    public static abstract class AbstractPartyRoleStateDeleted extends AbstractPartyRoleStateEvent implements PartyRoleStateEvent.PartyRoleStateDeleted
    {
        public AbstractPartyRoleStateDeleted() {
            this(new PartyRoleEventId());
        }

        public AbstractPartyRoleStateDeleted(PartyRoleEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
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

