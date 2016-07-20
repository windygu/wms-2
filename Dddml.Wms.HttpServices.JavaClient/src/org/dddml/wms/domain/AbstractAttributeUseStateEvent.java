package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.specialization.*;

public abstract class AbstractAttributeUseStateEvent implements AttributeUseStateEvent
{
    private AttributeUseStateEventId stateEventId;

    public AttributeUseStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(AttributeUseStateEventId stateEventId) {
        this.stateEventId = stateEventId;
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

    private Integer sequenceNumber;

    public Integer getSequenceNumber()
    {
        return this.sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber)
    {
        this.sequenceNumber = sequenceNumber;
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

    private String attributeSetId;

    public String getAttributeSetId()
    {
        return this.attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId)
    {
        this.attributeSetId = attributeSetId;
    }

    protected AbstractAttributeUseStateEvent() {
    }

    protected AbstractAttributeUseStateEvent(AttributeUseStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractAttributeUseStateCreated extends AbstractAttributeUseStateEvent implements AttributeUseStateCreated
    {
        public AbstractAttributeUseStateCreated() {
        }

        public AbstractAttributeUseStateCreated(AttributeUseStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


/*
    public static abstract class AbstractAttributeUseStateMergePatched extends AbstractAttributeUseStateEvent implements AttributeUseStateMergePatched
    {
        Boolean isPropertySequenceNumberRemoved();

        void setPropertySequenceNumberRemoved(Boolean removed);

        Boolean isPropertyActiveRemoved();

        void setPropertyActiveRemoved(Boolean removed);


    }
*/

    public static abstract class AbstractAttributeUseStateRemoved extends AbstractAttributeUseStateEvent implements AttributeUseStateRemoved
    {
        public AbstractAttributeUseStateRemoved() {
        }

        public AbstractAttributeUseStateRemoved(AttributeUseStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.REMOVED;
        }

    }

}

