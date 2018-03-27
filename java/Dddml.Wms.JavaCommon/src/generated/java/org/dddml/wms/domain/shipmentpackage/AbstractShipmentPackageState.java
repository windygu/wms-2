package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipmentpackage.ShipmentPackageStateEvent.*;

public abstract class AbstractShipmentPackageState implements ShipmentPackageState, Saveable
{

    private ShipmentPackageId shipmentPackageId;

    public ShipmentPackageId getShipmentPackageId()
    {
        return this.shipmentPackageId;
    }

    public void setShipmentPackageId(ShipmentPackageId shipmentPackageId)
    {
        this.shipmentPackageId = shipmentPackageId;
    }

    private String shipmentBoxTypeId;

    public String getShipmentBoxTypeId()
    {
        return this.shipmentBoxTypeId;
    }

    public void setShipmentBoxTypeId(String shipmentBoxTypeId)
    {
        this.shipmentBoxTypeId = shipmentBoxTypeId;
    }

    private java.sql.Timestamp dateCreated;

    public java.sql.Timestamp getDateCreated()
    {
        return this.dateCreated;
    }

    public void setDateCreated(java.sql.Timestamp dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    private java.math.BigDecimal boxLength;

    public java.math.BigDecimal getBoxLength()
    {
        return this.boxLength;
    }

    public void setBoxLength(java.math.BigDecimal boxLength)
    {
        this.boxLength = boxLength;
    }

    private java.math.BigDecimal boxHeight;

    public java.math.BigDecimal getBoxHeight()
    {
        return this.boxHeight;
    }

    public void setBoxHeight(java.math.BigDecimal boxHeight)
    {
        this.boxHeight = boxHeight;
    }

    private java.math.BigDecimal boxWidth;

    public java.math.BigDecimal getBoxWidth()
    {
        return this.boxWidth;
    }

    public void setBoxWidth(java.math.BigDecimal boxWidth)
    {
        this.boxWidth = boxWidth;
    }

    private String dimensionUomId;

    public String getDimensionUomId()
    {
        return this.dimensionUomId;
    }

    public void setDimensionUomId(String dimensionUomId)
    {
        this.dimensionUomId = dimensionUomId;
    }

    private java.math.BigDecimal weight;

    public java.math.BigDecimal getWeight()
    {
        return this.weight;
    }

    public void setWeight(java.math.BigDecimal weight)
    {
        this.weight = weight;
    }

    private String weightUomId;

    public String getWeightUomId()
    {
        return this.weightUomId;
    }

    public void setWeightUomId(String weightUomId)
    {
        this.weightUomId = weightUomId;
    }

    private java.math.BigDecimal insuredValue;

    public java.math.BigDecimal getInsuredValue()
    {
        return this.insuredValue;
    }

    public void setInsuredValue(java.math.BigDecimal insuredValue)
    {
        this.insuredValue = insuredValue;
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

    private ShipmentPackageContentStates shipmentPackageContents;

    public ShipmentPackageContentStates getShipmentPackageContents()
    {
        return this.shipmentPackageContents;
    }

    public void setShipmentPackageContents(ShipmentPackageContentStates shipmentPackageContents)
    {
        this.shipmentPackageContents = shipmentPackageContents;
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

    public AbstractShipmentPackageState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setShipmentPackageId(((ShipmentPackageStateEvent) events.get(0)).getShipmentPackageEventId().getShipmentPackageId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractShipmentPackageState() {
        this(false);
    }

    public AbstractShipmentPackageState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        shipmentPackageContents = new SimpleShipmentPackageContentStates(this);
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ShipmentPackageStateCreated) {
            when((ShipmentPackageStateCreated) e);
        } else if (e instanceof ShipmentPackageStateMergePatched) {
            when((ShipmentPackageStateMergePatched) e);
        } else if (e instanceof ShipmentPackageStateDeleted) {
            when((ShipmentPackageStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ShipmentPackageStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setShipmentBoxTypeId(e.getShipmentBoxTypeId());
        this.setDateCreated(e.getDateCreated());
        this.setBoxLength(e.getBoxLength());
        this.setBoxHeight(e.getBoxHeight());
        this.setBoxWidth(e.getBoxWidth());
        this.setDimensionUomId(e.getDimensionUomId());
        this.setWeight(e.getWeight());
        this.setWeightUomId(e.getWeightUomId());
        this.setInsuredValue(e.getInsuredValue());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

        for (ShipmentPackageContentStateEvent.ShipmentPackageContentStateCreated innerEvent : e.getShipmentPackageContentEvents()) {
            ShipmentPackageContentState innerState = this.getShipmentPackageContents().get(innerEvent.getShipmentPackageContentEventId().getShipmentItemSeqId());
            innerState.mutate(innerEvent);
        }
    }

    public void when(ShipmentPackageStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getShipmentBoxTypeId() == null)
        {
            if (e.getIsPropertyShipmentBoxTypeIdRemoved() != null && e.getIsPropertyShipmentBoxTypeIdRemoved())
            {
                this.setShipmentBoxTypeId(null);
            }
        }
        else
        {
            this.setShipmentBoxTypeId(e.getShipmentBoxTypeId());
        }
        if (e.getDateCreated() == null)
        {
            if (e.getIsPropertyDateCreatedRemoved() != null && e.getIsPropertyDateCreatedRemoved())
            {
                this.setDateCreated(null);
            }
        }
        else
        {
            this.setDateCreated(e.getDateCreated());
        }
        if (e.getBoxLength() == null)
        {
            if (e.getIsPropertyBoxLengthRemoved() != null && e.getIsPropertyBoxLengthRemoved())
            {
                this.setBoxLength(null);
            }
        }
        else
        {
            this.setBoxLength(e.getBoxLength());
        }
        if (e.getBoxHeight() == null)
        {
            if (e.getIsPropertyBoxHeightRemoved() != null && e.getIsPropertyBoxHeightRemoved())
            {
                this.setBoxHeight(null);
            }
        }
        else
        {
            this.setBoxHeight(e.getBoxHeight());
        }
        if (e.getBoxWidth() == null)
        {
            if (e.getIsPropertyBoxWidthRemoved() != null && e.getIsPropertyBoxWidthRemoved())
            {
                this.setBoxWidth(null);
            }
        }
        else
        {
            this.setBoxWidth(e.getBoxWidth());
        }
        if (e.getDimensionUomId() == null)
        {
            if (e.getIsPropertyDimensionUomIdRemoved() != null && e.getIsPropertyDimensionUomIdRemoved())
            {
                this.setDimensionUomId(null);
            }
        }
        else
        {
            this.setDimensionUomId(e.getDimensionUomId());
        }
        if (e.getWeight() == null)
        {
            if (e.getIsPropertyWeightRemoved() != null && e.getIsPropertyWeightRemoved())
            {
                this.setWeight(null);
            }
        }
        else
        {
            this.setWeight(e.getWeight());
        }
        if (e.getWeightUomId() == null)
        {
            if (e.getIsPropertyWeightUomIdRemoved() != null && e.getIsPropertyWeightUomIdRemoved())
            {
                this.setWeightUomId(null);
            }
        }
        else
        {
            this.setWeightUomId(e.getWeightUomId());
        }
        if (e.getInsuredValue() == null)
        {
            if (e.getIsPropertyInsuredValueRemoved() != null && e.getIsPropertyInsuredValueRemoved())
            {
                this.setInsuredValue(null);
            }
        }
        else
        {
            this.setInsuredValue(e.getInsuredValue());
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

        for (ShipmentPackageContentStateEvent innerEvent : e.getShipmentPackageContentEvents()) {
            ShipmentPackageContentState innerState = this.getShipmentPackageContents().get(innerEvent.getShipmentPackageContentEventId().getShipmentItemSeqId());
            innerState.mutate(innerEvent);
            if (innerEvent instanceof ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved)
            {
                //ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved removed = (ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved)innerEvent;
                this.getShipmentPackageContents().remove(innerState);
            }
        }
    }

    public void when(ShipmentPackageStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        for (ShipmentPackageContentState innerState : this.getShipmentPackageContents())
        {
            this.getShipmentPackageContents().remove(innerState);
        
            ShipmentPackageContentStateEvent.ShipmentPackageContentStateRemoved innerE = e.newShipmentPackageContentStateRemoved(innerState.getShipmentItemSeqId());
            innerE.setCreatedAt(e.getCreatedAt());
            innerE.setCreatedBy(e.getCreatedBy());
            innerState.when(innerE);
            //e.addShipmentPackageContentEvent(innerE);
        }
    }

    public void save()
    {
        shipmentPackageContents.save();

    }

    protected void throwOnWrongEvent(ShipmentPackageStateEvent stateEvent)
    {
        ShipmentPackageId stateEntityId = this.getShipmentPackageId(); // Aggregate Id
        ShipmentPackageId eventEntityId = stateEvent.getShipmentPackageEventId().getShipmentPackageId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getShipmentPackageEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getShipmentPackageEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(ShipmentPackageState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleShipmentPackageState extends AbstractShipmentPackageState
    {

        public SimpleShipmentPackageState() {
        }

        public SimpleShipmentPackageState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleShipmentPackageState(List<Event> events) {
            super(events);
        }

    }

    static class SimpleShipmentPackageContentStates extends AbstractShipmentPackageContentStates
    {
        public SimpleShipmentPackageContentStates(AbstractShipmentPackageState outerState)
        {
            super(outerState);
        }
    }


}

