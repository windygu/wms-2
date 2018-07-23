package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractInOutLineImageEvent extends AbstractEvent implements InOutLineImageEvent 
{
    private InOutLineImageEventId inOutLineImageEventId;

    public InOutLineImageEventId getInOutLineImageEventId() {
        return this.inOutLineImageEventId;
    }

    public void setInOutLineImageEventId(InOutLineImageEventId eventId) {
        this.inOutLineImageEventId = eventId;
    }
    
    public String getSequenceId() {
        return getInOutLineImageEventId().getSequenceId();
    }

    public void setSequenceId(String sequenceId) {
        getInOutLineImageEventId().setSequenceId(sequenceId);
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

    protected AbstractInOutLineImageEvent() {
    }

    protected AbstractInOutLineImageEvent(InOutLineImageEventId eventId) {
        this.inOutLineImageEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractInOutLineImageStateEvent extends AbstractInOutLineImageEvent implements InOutLineImageEvent.InOutLineImageStateEvent {
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

        protected AbstractInOutLineImageStateEvent(InOutLineImageEventId eventId) {
            super(eventId);
        }
    }

    public static abstract class AbstractInOutLineImageStateCreated extends AbstractInOutLineImageStateEvent implements InOutLineImageEvent.InOutLineImageStateCreated
    {
        public AbstractInOutLineImageStateCreated() {
            this(new InOutLineImageEventId());
        }

        public AbstractInOutLineImageStateCreated(InOutLineImageEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractInOutLineImageStateMergePatched extends AbstractInOutLineImageStateEvent implements InOutLineImageEvent.InOutLineImageStateMergePatched
    {
        public AbstractInOutLineImageStateMergePatched() {
            this(new InOutLineImageEventId());
        }

        public AbstractInOutLineImageStateMergePatched(InOutLineImageEventId eventId) {
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


    public static abstract class AbstractInOutLineImageStateRemoved extends AbstractInOutLineImageStateEvent implements InOutLineImageEvent.InOutLineImageStateRemoved
    {
        public AbstractInOutLineImageStateRemoved() {
            this(new InOutLineImageEventId());
        }

        public AbstractInOutLineImageStateRemoved(InOutLineImageEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.REMOVED;
        }

    }
    public static class SimpleInOutLineImageStateCreated extends AbstractInOutLineImageStateCreated
    {
        public SimpleInOutLineImageStateCreated() {
        }

        public SimpleInOutLineImageStateCreated(InOutLineImageEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleInOutLineImageStateMergePatched extends AbstractInOutLineImageStateMergePatched
    {
        public SimpleInOutLineImageStateMergePatched() {
        }

        public SimpleInOutLineImageStateMergePatched(InOutLineImageEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleInOutLineImageStateRemoved extends AbstractInOutLineImageStateRemoved
    {
        public SimpleInOutLineImageStateRemoved() {
        }

        public SimpleInOutLineImageStateRemoved(InOutLineImageEventId eventId) {
            super(eventId);
        }
    }

}

