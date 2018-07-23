package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractInOutImageEvent extends AbstractEvent implements InOutImageEvent 
{
    private InOutImageEventId inOutImageEventId;

    public InOutImageEventId getInOutImageEventId() {
        return this.inOutImageEventId;
    }

    public void setInOutImageEventId(InOutImageEventId eventId) {
        this.inOutImageEventId = eventId;
    }
    
    public String getSequenceId() {
        return getInOutImageEventId().getSequenceId();
    }

    public void setSequenceId(String sequenceId) {
        getInOutImageEventId().setSequenceId(sequenceId);
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

    protected AbstractInOutImageEvent() {
    }

    protected AbstractInOutImageEvent(InOutImageEventId eventId) {
        this.inOutImageEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractInOutImageStateEvent extends AbstractInOutImageEvent implements InOutImageEvent.InOutImageStateEvent {
        private Long version;

        public Long getVersion()
        {
            return this.version;
        }

        public void setVersion(Long version)
        {
            this.version = version;
        }

        private String url;

        public String getUrl()
        {
            return this.url;
        }

        public void setUrl(String url)
        {
            this.url = url;
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

        protected AbstractInOutImageStateEvent(InOutImageEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractInOutImageStateCreated extends AbstractInOutImageStateEvent implements InOutImageEvent.InOutImageStateCreated
    {
        public AbstractInOutImageStateCreated() {
            this(new InOutImageEventId());
        }

        public AbstractInOutImageStateCreated(InOutImageEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractInOutImageStateMergePatched extends AbstractInOutImageStateEvent implements InOutImageEvent.InOutImageStateMergePatched
    {
        public AbstractInOutImageStateMergePatched() {
            this(new InOutImageEventId());
        }

        public AbstractInOutImageStateMergePatched(InOutImageEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyUrlRemoved;

        public Boolean getIsPropertyUrlRemoved() {
            return this.isPropertyUrlRemoved;
        }

        public void setIsPropertyUrlRemoved(Boolean removed) {
            this.isPropertyUrlRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractInOutImageStateRemoved extends AbstractInOutImageStateEvent implements InOutImageEvent.InOutImageStateRemoved
    {
        public AbstractInOutImageStateRemoved() {
            this(new InOutImageEventId());
        }

        public AbstractInOutImageStateRemoved(InOutImageEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleInOutImageStateCreated extends AbstractInOutImageStateCreated
    {
        public SimpleInOutImageStateCreated() {
        }

        public SimpleInOutImageStateCreated(InOutImageEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleInOutImageStateMergePatched extends AbstractInOutImageStateMergePatched
    {
        public SimpleInOutImageStateMergePatched() {
        }

        public SimpleInOutImageStateMergePatched(InOutImageEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleInOutImageStateRemoved extends AbstractInOutImageStateRemoved
    {
        public SimpleInOutImageStateRemoved() {
        }

        public SimpleInOutImageStateRemoved(InOutImageEventId eventId) {
            super(eventId);
        }
    }

}

