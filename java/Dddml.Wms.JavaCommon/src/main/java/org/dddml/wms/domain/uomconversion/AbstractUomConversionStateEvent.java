package org.dddml.wms.domain.uomconversion;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.AbstractStateEvent;

public abstract class AbstractUomConversionStateEvent extends AbstractStateEvent implements UomConversionStateEvent 
{
    private UomConversionStateEventId stateEventId;

    public UomConversionStateEventId getStateEventId() {
        return this.stateEventId;
    }

    public void setStateEventId(UomConversionStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }
    
    public UomConversionId getUomConversionId() {
        return getStateEventId().getUomConversionId();
    }

    public void setUomConversionId(UomConversionId uomConversionId) {
        getStateEventId().setUomConversionId(uomConversionId);
    }

    private boolean stateEventReadOnly;

    public boolean getStateEventReadOnly() { return this.stateEventReadOnly; }

    public void setStateEventReadOnly(boolean readOnly) { this.stateEventReadOnly = readOnly; }

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

    protected AbstractUomConversionStateEvent() {
    }

    protected AbstractUomConversionStateEvent(UomConversionStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }


    public abstract String getStateEventType();


    public static abstract class AbstractUomConversionStateCreated extends AbstractUomConversionStateEvent implements UomConversionStateEvent.UomConversionStateCreated
    {
        public AbstractUomConversionStateCreated() {
            this(new UomConversionStateEventId());
        }

        public AbstractUomConversionStateCreated(UomConversionStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.CREATED;
        }

    }


    public static abstract class AbstractUomConversionStateMergePatched extends AbstractUomConversionStateEvent implements UomConversionStateEvent.UomConversionStateMergePatched
    {
        public AbstractUomConversionStateMergePatched() {
            this(new UomConversionStateEventId());
        }

        public AbstractUomConversionStateMergePatched(UomConversionStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
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


    public static abstract class AbstractUomConversionStateDeleted extends AbstractUomConversionStateEvent implements UomConversionStateEvent.UomConversionStateDeleted
    {
        public AbstractUomConversionStateDeleted() {
            this(new UomConversionStateEventId());
        }

        public AbstractUomConversionStateDeleted(UomConversionStateEventId stateEventId) {
            super(stateEventId);
        }

        public String getStateEventType() {
            return StateEventType.DELETED;
        }

    }
    public static class SimpleUomConversionStateCreated extends AbstractUomConversionStateCreated
    {
        public SimpleUomConversionStateCreated() {
        }

        public SimpleUomConversionStateCreated(UomConversionStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleUomConversionStateMergePatched extends AbstractUomConversionStateMergePatched
    {
        public SimpleUomConversionStateMergePatched() {
        }

        public SimpleUomConversionStateMergePatched(UomConversionStateEventId stateEventId) {
            super(stateEventId);
        }
    }

    public static class SimpleUomConversionStateDeleted extends AbstractUomConversionStateDeleted
    {
        public SimpleUomConversionStateDeleted() {
        }

        public SimpleUomConversionStateDeleted(UomConversionStateEventId stateEventId) {
            super(stateEventId);
        }
    }

}
