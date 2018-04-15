package org.dddml.wms.domain.uomconversion;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractEvent;

public abstract class AbstractUomConversionEvent extends AbstractEvent implements UomConversionEvent 
{
    private UomConversionEventId uomConversionEventId;

    public UomConversionEventId getUomConversionEventId() {
        return this.uomConversionEventId;
    }

    public void setUomConversionEventId(UomConversionEventId eventId) {
        this.uomConversionEventId = eventId;
    }
    
    public UomConversionId getUomConversionId() {
        return getUomConversionEventId().getUomConversionId();
    }

    public void setUomConversionId(UomConversionId uomConversionId) {
        getUomConversionEventId().setUomConversionId(uomConversionId);
    }

    private boolean stateEventReadOnly;

    public boolean getEventReadOnly() { return this.stateEventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

    private Double conversionFactor;

    public Double getConversionFactor()
    {
        return this.conversionFactor;
    }

    public void setConversionFactor(Double conversionFactor)
    {
        this.conversionFactor = conversionFactor;
    }

    private String customMethodId;

    public String getCustomMethodId()
    {
        return this.customMethodId;
    }

    public void setCustomMethodId(String customMethodId)
    {
        this.customMethodId = customMethodId;
    }

    private Long decimalScale;

    public Long getDecimalScale()
    {
        return this.decimalScale;
    }

    public void setDecimalScale(Long decimalScale)
    {
        this.decimalScale = decimalScale;
    }

    private String roundingMode;

    public String getRoundingMode()
    {
        return this.roundingMode;
    }

    public void setRoundingMode(String roundingMode)
    {
        this.roundingMode = roundingMode;
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

    protected AbstractUomConversionEvent() {
    }

    protected AbstractUomConversionEvent(UomConversionEventId eventId) {
        this.uomConversionEventId = eventId;
    }


    public abstract String getEventType();


    public static abstract class AbstractUomConversionStateCreated extends AbstractUomConversionEvent implements UomConversionEvent.UomConversionStateCreated
    {
        public AbstractUomConversionStateCreated() {
            this(new UomConversionEventId());
        }

        public AbstractUomConversionStateCreated(UomConversionEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractUomConversionStateMergePatched extends AbstractUomConversionEvent implements UomConversionEvent.UomConversionStateMergePatched
    {
        public AbstractUomConversionStateMergePatched() {
            this(new UomConversionEventId());
        }

        public AbstractUomConversionStateMergePatched(UomConversionEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.MERGE_PATCHED;
        }

        private Boolean isPropertyConversionFactorRemoved;

        public Boolean getIsPropertyConversionFactorRemoved() {
            return this.isPropertyConversionFactorRemoved;
        }

        public void setIsPropertyConversionFactorRemoved(Boolean removed) {
            this.isPropertyConversionFactorRemoved = removed;
        }

        private Boolean isPropertyCustomMethodIdRemoved;

        public Boolean getIsPropertyCustomMethodIdRemoved() {
            return this.isPropertyCustomMethodIdRemoved;
        }

        public void setIsPropertyCustomMethodIdRemoved(Boolean removed) {
            this.isPropertyCustomMethodIdRemoved = removed;
        }

        private Boolean isPropertyDecimalScaleRemoved;

        public Boolean getIsPropertyDecimalScaleRemoved() {
            return this.isPropertyDecimalScaleRemoved;
        }

        public void setIsPropertyDecimalScaleRemoved(Boolean removed) {
            this.isPropertyDecimalScaleRemoved = removed;
        }

        private Boolean isPropertyRoundingModeRemoved;

        public Boolean getIsPropertyRoundingModeRemoved() {
            return this.isPropertyRoundingModeRemoved;
        }

        public void setIsPropertyRoundingModeRemoved(Boolean removed) {
            this.isPropertyRoundingModeRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved() {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed) {
            this.isPropertyActiveRemoved = removed;
        }

    }


    public static abstract class AbstractUomConversionStateDeleted extends AbstractUomConversionEvent implements UomConversionEvent.UomConversionStateDeleted
    {
        public AbstractUomConversionStateDeleted() {
            this(new UomConversionEventId());
        }

        public AbstractUomConversionStateDeleted(UomConversionEventId eventId) {
            super(eventId);
        }

        public String getEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleUomConversionStateCreated extends AbstractUomConversionStateCreated
    {
        public SimpleUomConversionStateCreated() {
        }

        public SimpleUomConversionStateCreated(UomConversionEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleUomConversionStateMergePatched extends AbstractUomConversionStateMergePatched
    {
        public SimpleUomConversionStateMergePatched() {
        }

        public SimpleUomConversionStateMergePatched(UomConversionEventId eventId) {
            super(eventId);
        }
    }

    public static class SimpleUomConversionStateDeleted extends AbstractUomConversionStateDeleted
    {
        public SimpleUomConversionStateDeleted() {
        }

        public SimpleUomConversionStateDeleted(UomConversionEventId eventId) {
            super(eventId);
        }
    }

}

