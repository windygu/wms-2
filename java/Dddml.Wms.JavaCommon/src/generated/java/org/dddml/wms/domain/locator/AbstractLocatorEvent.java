package org.dddml.wms.domain.locator;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractLocatorEvent extends AbstractEvent implements LocatorEvent.SqlLocatorEvent 
{
    private LocatorEventId locatorEventId;

    public LocatorEventId getLocatorEventId() {
        return this.locatorEventId;
    }

    public void setLocatorEventId(LocatorEventId eventId) {
        this.locatorEventId = eventId;
    }
    
    public String getLocatorId() {
        return getLocatorEventId().getLocatorId();
    }

    public void setLocatorId(String locatorId) {
        getLocatorEventId().setLocatorId(locatorId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public Long getVersion() {
        return getLocatorEventId().getVersion();
    }
    
    //public void getVersion(Long version) {
    //    getLocatorEventId().setVersion(version);
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

    protected AbstractLocatorEvent() {
    }

    protected AbstractLocatorEvent(LocatorEventId eventId) {
        this.locatorEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractLocatorStateEvent extends AbstractLocatorEvent implements LocatorEvent.LocatorStateEvent {
        private String warehouseId;

        public String getWarehouseId()
        {
            return this.warehouseId;
        }

        public void setWarehouseId(String warehouseId)
        {
            this.warehouseId = warehouseId;
        }

        private String parentLocatorId;

        public String getParentLocatorId()
        {
            return this.parentLocatorId;
        }

        public void setParentLocatorId(String parentLocatorId)
        {
            this.parentLocatorId = parentLocatorId;
        }

        private String locatorType;

        public String getLocatorType()
        {
            return this.locatorType;
        }

        public void setLocatorType(String locatorType)
        {
            this.locatorType = locatorType;
        }

        private String priorityNumber;

        public String getPriorityNumber()
        {
            return this.priorityNumber;
        }

        public void setPriorityNumber(String priorityNumber)
        {
            this.priorityNumber = priorityNumber;
        }

        private Boolean isDefault;

        public Boolean getIsDefault()
        {
            return this.isDefault;
        }

        public void setIsDefault(Boolean isDefault)
        {
            this.isDefault = isDefault;
        }

        private String x;

        public String getX()
        {
            return this.x;
        }

        public void setX(String x)
        {
            this.x = x;
        }

        private String y;

        public String getY()
        {
            return this.y;
        }

        public void setY(String y)
        {
            this.y = y;
        }

        private String z;

        public String getZ()
        {
            return this.z;
        }

        public void setZ(String z)
        {
            this.z = z;
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

        private String locatorTypeId;

        public String getLocatorTypeId()
        {
            return this.locatorTypeId;
        }

        public void setLocatorTypeId(String locatorTypeId)
        {
            this.locatorTypeId = locatorTypeId;
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

        protected AbstractLocatorStateEvent(LocatorEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractLocatorStateCreated extends AbstractLocatorStateEvent implements LocatorEvent.LocatorStateCreated
    {
        public AbstractLocatorStateCreated() {
            this(new LocatorEventId());
        }

        public AbstractLocatorStateCreated(LocatorEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractLocatorStateMergePatched extends AbstractLocatorStateEvent implements LocatorEvent.LocatorStateMergePatched
    {
        public AbstractLocatorStateMergePatched() {
            this(new LocatorEventId());
        }

        public AbstractLocatorStateMergePatched(LocatorEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyWarehouseIdRemoved;

        public Boolean getIsPropertyWarehouseIdRemoved() {
            return this.isPropertyWarehouseIdRemoved;
        }

        public void setIsPropertyWarehouseIdRemoved(Boolean removed) {
            this.isPropertyWarehouseIdRemoved = removed;
        }

        private Boolean isPropertyParentLocatorIdRemoved;

        public Boolean getIsPropertyParentLocatorIdRemoved() {
            return this.isPropertyParentLocatorIdRemoved;
        }

        public void setIsPropertyParentLocatorIdRemoved(Boolean removed) {
            this.isPropertyParentLocatorIdRemoved = removed;
        }

        private Boolean isPropertyLocatorTypeRemoved;

        public Boolean getIsPropertyLocatorTypeRemoved() {
            return this.isPropertyLocatorTypeRemoved;
        }

        public void setIsPropertyLocatorTypeRemoved(Boolean removed) {
            this.isPropertyLocatorTypeRemoved = removed;
        }

        private Boolean isPropertyPriorityNumberRemoved;

        public Boolean getIsPropertyPriorityNumberRemoved() {
            return this.isPropertyPriorityNumberRemoved;
        }

        public void setIsPropertyPriorityNumberRemoved(Boolean removed) {
            this.isPropertyPriorityNumberRemoved = removed;
        }

        private Boolean isPropertyIsDefaultRemoved;

        public Boolean getIsPropertyIsDefaultRemoved() {
            return this.isPropertyIsDefaultRemoved;
        }

        public void setIsPropertyIsDefaultRemoved(Boolean removed) {
            this.isPropertyIsDefaultRemoved = removed;
        }

        private Boolean isPropertyXRemoved;

        public Boolean getIsPropertyXRemoved() {
            return this.isPropertyXRemoved;
        }

        public void setIsPropertyXRemoved(Boolean removed) {
            this.isPropertyXRemoved = removed;
        }

        private Boolean isPropertyYRemoved;

        public Boolean getIsPropertyYRemoved() {
            return this.isPropertyYRemoved;
        }

        public void setIsPropertyYRemoved(Boolean removed) {
            this.isPropertyYRemoved = removed;
        }

        private Boolean isPropertyZRemoved;

        public Boolean getIsPropertyZRemoved() {
            return this.isPropertyZRemoved;
        }

        public void setIsPropertyZRemoved(Boolean removed) {
            this.isPropertyZRemoved = removed;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved() {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed) {
            this.isPropertyDescriptionRemoved = removed;
        }

        private Boolean isPropertyLocatorTypeIdRemoved;

        public Boolean getIsPropertyLocatorTypeIdRemoved() {
            return this.isPropertyLocatorTypeIdRemoved;
        }

        public void setIsPropertyLocatorTypeIdRemoved(Boolean removed) {
            this.isPropertyLocatorTypeIdRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractLocatorStateDeleted extends AbstractLocatorStateEvent implements LocatorEvent.LocatorStateDeleted
    {
        public AbstractLocatorStateDeleted() {
            this(new LocatorEventId());
        }

        public AbstractLocatorStateDeleted(LocatorEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleLocatorStateCreated extends AbstractLocatorStateCreated
    {
        public SimpleLocatorStateCreated() {
        }

        public SimpleLocatorStateCreated(LocatorEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleLocatorStateMergePatched extends AbstractLocatorStateMergePatched
    {
        public SimpleLocatorStateMergePatched() {
        }

        public SimpleLocatorStateMergePatched(LocatorEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleLocatorStateDeleted extends AbstractLocatorStateDeleted
    {
        public SimpleLocatorStateDeleted() {
        }

        public SimpleLocatorStateDeleted(LocatorEventId eventId) {
            super(eventId);
        }
    }

}

