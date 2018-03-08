package org.dddml.wms.domain.uom;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractUomStateEvent extends AbstractStateEvent implements UomStateEvent 
{
    private UomEventId uomEventId;

    public UomEventId getUomEventId() {
        return this.uomEventId;
    }

    public void setUomEventId(UomEventId eventId) {
        this.uomEventId = eventId;
    }
    
    public String getUomId() {
        return getUomEventId().getUomId();
    }

    public void setUomId(String uomId) {
        getUomEventId().setUomId(uomId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private String uomTypeId;

    public String getUomTypeId()
    {
        return this.uomTypeId;
    }

    public void setUomTypeId(String uomTypeId)
    {
        this.uomTypeId = uomTypeId;
    }

    private String abbreviation;

    public String getAbbreviation()
    {
        return this.abbreviation;
    }

    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
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

    protected AbstractUomStateEvent() {
    }

    protected AbstractUomStateEvent(UomEventId eventId) {
        this.uomEventId = eventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractUomStateCreated extends AbstractUomStateEvent implements UomStateEvent.UomStateCreated
    {
        public AbstractUomStateCreated() {
            this(new UomEventId());
        }

        public AbstractUomStateCreated(UomEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractUomStateMergePatched extends AbstractUomStateEvent implements UomStateEvent.UomStateMergePatched
    {
        public AbstractUomStateMergePatched() {
            this(new UomEventId());
        }

        public AbstractUomStateMergePatched(UomEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyUomTypeIdRemoved;

        public Boolean getIsPropertyUomTypeIdRemoved() {
            return this.isPropertyUomTypeIdRemoved;
        }

        public void setIsPropertyUomTypeIdRemoved(Boolean removed) {
            this.isPropertyUomTypeIdRemoved = removed;
        }

        private Boolean isPropertyAbbreviationRemoved;

        public Boolean getIsPropertyAbbreviationRemoved() {
            return this.isPropertyAbbreviationRemoved;
        }

        public void setIsPropertyAbbreviationRemoved(Boolean removed) {
            this.isPropertyAbbreviationRemoved = removed;
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


    public static abstract class AbstractUomStateDeleted extends AbstractUomStateEvent implements UomStateEvent.UomStateDeleted
    {
        public AbstractUomStateDeleted() {
            this(new UomEventId());
        }

        public AbstractUomStateDeleted(UomEventId eventId) {
            super(eventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleUomStateCreated extends AbstractUomStateCreated
    {
        public SimpleUomStateCreated() {
        }

        public SimpleUomStateCreated(UomEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleUomStateMergePatched extends AbstractUomStateMergePatched
    {
        public SimpleUomStateMergePatched() {
        }

        public SimpleUomStateMergePatched(UomEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleUomStateDeleted extends AbstractUomStateDeleted
    {
        public SimpleUomStateDeleted() {
        }

        public SimpleUomStateDeleted(UomEventId eventId) {
            super(eventId);
        }
    }

}

