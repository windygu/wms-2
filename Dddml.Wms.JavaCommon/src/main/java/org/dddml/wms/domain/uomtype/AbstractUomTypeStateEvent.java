package org.dddml.wms.domain.uomtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractUomTypeStateEvent extends AbstractStateEvent implements UomTypeStateEvent 
{
    private UomTypeStateEventId stateEventId;

    public UomTypeStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(UomTypeStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public String getUomTypeId() {
        return getStateEventId().getUomTypeId();
    }

    public void setUomTypeId(String uomTypeId) {
        getStateEventId().setUomTypeId(uomTypeId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private String parentTypeId;

    public String getParentTypeId()
    {
        return this.parentTypeId;
    }

    public void setParentTypeId(String parentTypeId)
    {
        this.parentTypeId = parentTypeId;
    }

    private String hasTable;

    public String getHasTable()
    {
        return this.hasTable;
    }

    public void setHasTable(String hasTable)
    {
        this.hasTable = hasTable;
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

    protected AbstractUomTypeStateEvent() {
    }

    protected AbstractUomTypeStateEvent(UomTypeStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractUomTypeStateCreated extends AbstractUomTypeStateEvent implements UomTypeStateEvent.UomTypeStateCreated
    {
        public AbstractUomTypeStateCreated() {
            this(new UomTypeStateEventId());
        }

        public AbstractUomTypeStateCreated(UomTypeStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractUomTypeStateMergePatched extends AbstractUomTypeStateEvent implements UomTypeStateEvent.UomTypeStateMergePatched
    {
        public AbstractUomTypeStateMergePatched() {
            this(new UomTypeStateEventId());
        }

        public AbstractUomTypeStateMergePatched(UomTypeStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyParentTypeIdRemoved;

        public Boolean getIsPropertyParentTypeIdRemoved() {
            return this.isPropertyParentTypeIdRemoved;
        }

        public void setIsPropertyParentTypeIdRemoved(Boolean removed) {
            this.isPropertyParentTypeIdRemoved = removed;
        }

        private Boolean isPropertyHasTableRemoved;

        public Boolean getIsPropertyHasTableRemoved() {
            return this.isPropertyHasTableRemoved;
        }

        public void setIsPropertyHasTableRemoved(Boolean removed) {
            this.isPropertyHasTableRemoved = removed;
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


    public static abstract class AbstractUomTypeStateDeleted extends AbstractUomTypeStateEvent implements UomTypeStateEvent.UomTypeStateDeleted
    {
        public AbstractUomTypeStateDeleted() {
            this(new UomTypeStateEventId());
        }

        public AbstractUomTypeStateDeleted(UomTypeStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleUomTypeStateCreated extends AbstractUomTypeStateCreated
    {
        public SimpleUomTypeStateCreated() {
        }

        public SimpleUomTypeStateCreated(UomTypeStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleUomTypeStateMergePatched extends AbstractUomTypeStateMergePatched
    {
        public SimpleUomTypeStateMergePatched() {
        }

        public SimpleUomTypeStateMergePatched(UomTypeStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleUomTypeStateDeleted extends AbstractUomTypeStateDeleted
    {
        public SimpleUomTypeStateDeleted() {
        }

        public SimpleUomTypeStateDeleted(UomTypeStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}

