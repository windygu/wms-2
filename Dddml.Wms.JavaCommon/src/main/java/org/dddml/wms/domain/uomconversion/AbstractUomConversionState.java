package org.dddml.wms.domain.uomconversion;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.uomconversion.UomConversionStateEvent.*;

public abstract class AbstractUomConversionState implements UomConversionState
{

    private UomConversionId uomConversionId;

    public UomConversionId getUomConversionId()
    {
        return this.uomConversionId;
    }

    public void setUomConversionId(UomConversionId uomConversionId)
    {
        this.uomConversionId = uomConversionId;
    }

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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
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

    private Boolean deleted;

    public Boolean getDeleted()
    {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

    public boolean isStateUnsaved() 
    {
        return this.getVersion() == null;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractUomConversionState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setUomConversionId(((UomConversionStateEvent) events.get(0)).getStateEventId().getUomConversionId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractUomConversionState() {
        this(false);
    }

    public AbstractUomConversionState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof UomConversionStateCreated) {
            when((UomConversionStateCreated) e);
        } else if (e instanceof UomConversionStateMergePatched) {
            when((UomConversionStateMergePatched) e);
        } else if (e instanceof UomConversionStateDeleted) {
            when((UomConversionStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(UomConversionStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setConversionFactor(e.getConversionFactor());
        this.setCustomMethodId(e.getCustomMethodId());
        this.setDecimalScale(e.getDecimalScale());
        this.setRoundingMode(e.getRoundingMode());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(UomConversionStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getConversionFactor() == null)
        {
            if (e.getIsPropertyConversionFactorRemoved() != null && e.getIsPropertyConversionFactorRemoved())
            {
                this.setConversionFactor(null);
            }
        }
        else
        {
            this.setConversionFactor(e.getConversionFactor());
        }
        if (e.getCustomMethodId() == null)
        {
            if (e.getIsPropertyCustomMethodIdRemoved() != null && e.getIsPropertyCustomMethodIdRemoved())
            {
                this.setCustomMethodId(null);
            }
        }
        else
        {
            this.setCustomMethodId(e.getCustomMethodId());
        }
        if (e.getDecimalScale() == null)
        {
            if (e.getIsPropertyDecimalScaleRemoved() != null && e.getIsPropertyDecimalScaleRemoved())
            {
                this.setDecimalScale(null);
            }
        }
        else
        {
            this.setDecimalScale(e.getDecimalScale());
        }
        if (e.getRoundingMode() == null)
        {
            if (e.getIsPropertyRoundingModeRemoved() != null && e.getIsPropertyRoundingModeRemoved())
            {
                this.setRoundingMode(null);
            }
        }
        else
        {
            this.setRoundingMode(e.getRoundingMode());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(UomConversionStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(UomConversionStateEvent stateEvent)
    {
        UomConversionId stateEntityId = this.getUomConversionId(); // Aggregate Id
        UomConversionId eventEntityId = stateEvent.getStateEventId().getUomConversionId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getStateEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(UomConversionState.VERSION_NULL)) && !(eventVersion.compareTo(stateVersion) >= 0))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleUomConversionState extends AbstractUomConversionState
    {

        public SimpleUomConversionState() {
        }

        public SimpleUomConversionState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleUomConversionState(List<Event> events) {
            super(events);
        }

    }


}

