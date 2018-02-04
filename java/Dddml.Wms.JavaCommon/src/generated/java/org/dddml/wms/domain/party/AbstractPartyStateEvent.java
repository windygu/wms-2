package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractPartyStateEvent extends AbstractStateEvent implements PartyStateEvent 
{
    private PartyStateEventId stateEventId;

    public PartyStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(PartyStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public String getPartyId() {
        return getStateEventId().getPartyId();
    }

    public void setPartyId(String partyId) {
        getStateEventId().setPartyId(partyId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private String partyTypeId;

    public String getPartyTypeId()
    {
        return this.partyTypeId;
    }

    public void setPartyTypeId(String partyTypeId)
    {
        this.partyTypeId = partyTypeId;
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

    protected AbstractPartyStateEvent() {
    }

    protected AbstractPartyStateEvent(PartyStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractPartyStateCreated extends AbstractPartyStateEvent implements PartyStateEvent.PartyStateCreated
    {
        public AbstractPartyStateCreated() {
            this(new PartyStateEventId());
        }

        public AbstractPartyStateCreated(PartyStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractPartyStateMergePatched extends AbstractPartyStateEvent implements PartyStateEvent.PartyStateMergePatched
    {
        public AbstractPartyStateMergePatched() {
            this(new PartyStateEventId());
        }

        public AbstractPartyStateMergePatched(PartyStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
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


    public static abstract class AbstractPartyStateDeleted extends AbstractPartyStateEvent implements PartyStateEvent.PartyStateDeleted
    {
        public AbstractPartyStateDeleted() {
            this(new PartyStateEventId());
        }

        public AbstractPartyStateDeleted(PartyStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimplePartyStateCreated extends AbstractPartyStateCreated
    {
        public SimplePartyStateCreated() {
        }

        public SimplePartyStateCreated(PartyStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimplePartyStateMergePatched extends AbstractPartyStateMergePatched
    {
        public SimplePartyStateMergePatched() {
        }

        public SimplePartyStateMergePatched(PartyStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimplePartyStateDeleted extends AbstractPartyStateDeleted
    {
        public SimplePartyStateDeleted() {
        }

        public SimplePartyStateDeleted(PartyStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}
