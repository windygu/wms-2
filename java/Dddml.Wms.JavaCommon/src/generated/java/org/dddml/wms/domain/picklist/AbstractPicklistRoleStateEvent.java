package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractPicklistRoleStateEvent extends AbstractStateEvent implements PicklistRoleStateEvent 
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

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

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

    protected AbstractPicklistRoleStateEvent() {
    }

    protected AbstractPicklistRoleStateEvent(PicklistRoleEventId eventId) {
        this.picklistRoleEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractPicklistRoleStateCreated extends AbstractPicklistRoleStateEvent implements PicklistRoleStateEvent.PicklistRoleStateCreated
    {
        public AbstractPicklistRoleStateCreated() {
            this(new PicklistRoleEventId());
        }

        public AbstractPicklistRoleStateCreated(PicklistRoleEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractPicklistRoleStateMergePatched extends AbstractPicklistRoleStateEvent implements PicklistRoleStateEvent.PicklistRoleStateMergePatched
    {
        public AbstractPicklistRoleStateMergePatched() {
            this(new PicklistRoleEventId());
        }

        public AbstractPicklistRoleStateMergePatched(PicklistRoleEventId eventId) {
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


    public static abstract class AbstractPicklistRoleStateRemoved extends AbstractPicklistRoleStateEvent implements PicklistRoleStateEvent.PicklistRoleStateRemoved
    {
        public AbstractPicklistRoleStateRemoved() {
            this(new PicklistRoleEventId());
        }

        public AbstractPicklistRoleStateRemoved(PicklistRoleEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
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

