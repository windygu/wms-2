package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractPicklistRoleEvent extends AbstractEvent implements PicklistRoleEvent.SqlPicklistRoleEvent 
{
    private PicklistRoleEventId picklistRoleEventId;

    public PicklistRoleEventId getPicklistRoleEventId() {
        return this.picklistRoleEventId;
    }

    public void setPicklistRoleEventId(PicklistRoleEventId eventId) {
        this.picklistRoleEventId = eventId;
    }
    
    public PartyRoleId getPartyRoleId() {
        return getPicklistRoleEventId().getPartyRoleId();
    }

    public void setPartyRoleId(PartyRoleId partyRoleId) {
        getPicklistRoleEventId().setPartyRoleId(partyRoleId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    private String createdByUserLogin;

    public String getCreatedByUserLogin()
    {
        return this.createdByUserLogin;
    }

    public void setCreatedByUserLogin(String createdByUserLogin)
    {
        this.createdByUserLogin = createdByUserLogin;
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

    protected AbstractPicklistRoleEvent() {
    }

    protected AbstractPicklistRoleEvent(PicklistRoleEventId eventId) {
        this.picklistRoleEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractPicklistRoleStateEvent extends AbstractPicklistRoleEvent implements PicklistRoleEvent.PicklistRoleStateEvent {
        private Long version;

        public Long getVersion()
        {
            return this.version;
        }

        public void setVersion(Long version)
        {
            this.version = version;
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

        protected AbstractPicklistRoleStateEvent(PicklistRoleEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractPicklistRoleStateCreated extends AbstractPicklistRoleStateEvent implements PicklistRoleEvent.PicklistRoleStateCreated
    {
        public AbstractPicklistRoleStateCreated() {
            this(new PicklistRoleEventId());
        }

        public AbstractPicklistRoleStateCreated(PicklistRoleEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractPicklistRoleStateMergePatched extends AbstractPicklistRoleStateEvent implements PicklistRoleEvent.PicklistRoleStateMergePatched
    {
        public AbstractPicklistRoleStateMergePatched() {
            this(new PicklistRoleEventId());
        }

        public AbstractPicklistRoleStateMergePatched(PicklistRoleEventId eventId) {
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


    public static abstract class AbstractPicklistRoleStateRemoved extends AbstractPicklistRoleStateEvent implements PicklistRoleEvent.PicklistRoleStateRemoved
    {
        public AbstractPicklistRoleStateRemoved() {
            this(new PicklistRoleEventId());
        }

        public AbstractPicklistRoleStateRemoved(PicklistRoleEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimplePicklistRoleStateCreated extends AbstractPicklistRoleStateCreated
    {
        public SimplePicklistRoleStateCreated() {
        }

        public SimplePicklistRoleStateCreated(PicklistRoleEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePicklistRoleStateMergePatched extends AbstractPicklistRoleStateMergePatched
    {
        public SimplePicklistRoleStateMergePatched() {
        }

        public SimplePicklistRoleStateMergePatched(PicklistRoleEventId eventId) {
            super(eventId);
        }
    }

    public static class SimplePicklistRoleStateRemoved extends AbstractPicklistRoleStateRemoved
    {
        public SimplePicklistRoleStateRemoved() {
        }

        public SimplePicklistRoleStateRemoved(PicklistRoleEventId eventId) {
            super(eventId);
        }
    }

}

