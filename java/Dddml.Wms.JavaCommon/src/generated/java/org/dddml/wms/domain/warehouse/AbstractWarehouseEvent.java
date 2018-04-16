package org.dddml.wms.domain.warehouse;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractWarehouseEvent extends AbstractEvent implements WarehouseEvent 
{
    private WarehouseEventId warehouseEventId;

    public WarehouseEventId getWarehouseEventId() {
        return this.warehouseEventId;
    }

    public void setWarehouseEventId(WarehouseEventId eventId) {
        this.warehouseEventId = eventId;
    }
    
    public String getWarehouseId() {
        return getWarehouseEventId().getWarehouseId();
    }

    public void setWarehouseId(String warehouseId) {
        getWarehouseEventId().setWarehouseId(warehouseId);
    }

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

    protected AbstractWarehouseEvent() {
    }

    protected AbstractWarehouseEvent(WarehouseEventId eventId) {
        this.warehouseEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractWarehouseStateEvent extends AbstractWarehouseEvent implements WarehouseEvent.WarehouseStateEvent {
        private String warehouseName;

        public String getWarehouseName()
        {
            return this.warehouseName;
        }

        public void setWarehouseName(String warehouseName)
        {
            this.warehouseName = warehouseName;
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

        private Boolean isInTransit;

        public Boolean getIsInTransit()
        {
            return this.isInTransit;
        }

        public void setIsInTransit(Boolean isInTransit)
        {
            this.isInTransit = isInTransit;
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

        protected AbstractWarehouseStateEvent(WarehouseEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractWarehouseStateCreated extends AbstractWarehouseStateEvent implements WarehouseEvent.WarehouseStateCreated
    {
        public AbstractWarehouseStateCreated() {
            this(new WarehouseEventId());
        }

        public AbstractWarehouseStateCreated(WarehouseEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractWarehouseStateMergePatched extends AbstractWarehouseStateEvent implements WarehouseEvent.WarehouseStateMergePatched
    {
        public AbstractWarehouseStateMergePatched() {
            this(new WarehouseEventId());
        }

        public AbstractWarehouseStateMergePatched(WarehouseEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyWarehouseNameRemoved;

        public Boolean getIsPropertyWarehouseNameRemoved() {
            return this.isPropertyWarehouseNameRemoved;
        }

        public void setIsPropertyWarehouseNameRemoved(Boolean removed) {
            this.isPropertyWarehouseNameRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyIsInTransitRemoved;

        public Boolean getIsPropertyIsInTransitRemoved() {
            return this.isPropertyIsInTransitRemoved;
        }

        public void setIsPropertyIsInTransitRemoved(Boolean removed) {
            this.isPropertyIsInTransitRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractWarehouseStateDeleted extends AbstractWarehouseStateEvent implements WarehouseEvent.WarehouseStateDeleted
    {
        public AbstractWarehouseStateDeleted() {
            this(new WarehouseEventId());
        }

        public AbstractWarehouseStateDeleted(WarehouseEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleWarehouseStateCreated extends AbstractWarehouseStateCreated
    {
        public SimpleWarehouseStateCreated() {
        }

        public SimpleWarehouseStateCreated(WarehouseEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleWarehouseStateMergePatched extends AbstractWarehouseStateMergePatched
    {
        public SimpleWarehouseStateMergePatched() {
        }

        public SimpleWarehouseStateMergePatched(WarehouseEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleWarehouseStateDeleted extends AbstractWarehouseStateDeleted
    {
        public SimpleWarehouseStateDeleted() {
        }

        public SimpleWarehouseStateDeleted(WarehouseEventId eventId) {
            super(eventId);
        }
    }

}

