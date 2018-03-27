package org.dddml.wms.domain.shipmentpackagecontentmvo;

import java.util.*;
import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipmentpackagecontentmvo.ShipmentPackageContentMvoStateEvent.*;

public abstract class AbstractShipmentPackageContentMvoState implements ShipmentPackageContentMvoState
{

    private ShipmentPackageContentId shipmentPackageContentId;

    public ShipmentPackageContentId getShipmentPackageContentId()
    {
        return this.shipmentPackageContentId;
    }

    public void setShipmentPackageContentId(ShipmentPackageContentId shipmentPackageContentId)
    {
        this.shipmentPackageContentId = shipmentPackageContentId;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    private String subProductId;

    public String getSubProductId()
    {
        return this.subProductId;
    }

    public void setSubProductId(String subProductId)
    {
        this.subProductId = subProductId;
    }

    private java.math.BigDecimal subProductQuantity;

    public java.math.BigDecimal getSubProductQuantity()
    {
        return this.subProductQuantity;
    }

    public void setSubProductQuantity(java.math.BigDecimal subProductQuantity)
    {
        this.subProductQuantity = subProductQuantity;
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

    private String shipmentPackageShipmentBoxTypeId;

    public String getShipmentPackageShipmentBoxTypeId()
    {
        return this.shipmentPackageShipmentBoxTypeId;
    }

    public void setShipmentPackageShipmentBoxTypeId(String shipmentPackageShipmentBoxTypeId)
    {
        this.shipmentPackageShipmentBoxTypeId = shipmentPackageShipmentBoxTypeId;
    }

    private java.sql.Timestamp shipmentPackageDateCreated;

    public java.sql.Timestamp getShipmentPackageDateCreated()
    {
        return this.shipmentPackageDateCreated;
    }

    public void setShipmentPackageDateCreated(java.sql.Timestamp shipmentPackageDateCreated)
    {
        this.shipmentPackageDateCreated = shipmentPackageDateCreated;
    }

    private java.math.BigDecimal shipmentPackageBoxLength;

    public java.math.BigDecimal getShipmentPackageBoxLength()
    {
        return this.shipmentPackageBoxLength;
    }

    public void setShipmentPackageBoxLength(java.math.BigDecimal shipmentPackageBoxLength)
    {
        this.shipmentPackageBoxLength = shipmentPackageBoxLength;
    }

    private java.math.BigDecimal shipmentPackageBoxHeight;

    public java.math.BigDecimal getShipmentPackageBoxHeight()
    {
        return this.shipmentPackageBoxHeight;
    }

    public void setShipmentPackageBoxHeight(java.math.BigDecimal shipmentPackageBoxHeight)
    {
        this.shipmentPackageBoxHeight = shipmentPackageBoxHeight;
    }

    private java.math.BigDecimal shipmentPackageBoxWidth;

    public java.math.BigDecimal getShipmentPackageBoxWidth()
    {
        return this.shipmentPackageBoxWidth;
    }

    public void setShipmentPackageBoxWidth(java.math.BigDecimal shipmentPackageBoxWidth)
    {
        this.shipmentPackageBoxWidth = shipmentPackageBoxWidth;
    }

    private String shipmentPackageDimensionUomId;

    public String getShipmentPackageDimensionUomId()
    {
        return this.shipmentPackageDimensionUomId;
    }

    public void setShipmentPackageDimensionUomId(String shipmentPackageDimensionUomId)
    {
        this.shipmentPackageDimensionUomId = shipmentPackageDimensionUomId;
    }

    private java.math.BigDecimal shipmentPackageWeight;

    public java.math.BigDecimal getShipmentPackageWeight()
    {
        return this.shipmentPackageWeight;
    }

    public void setShipmentPackageWeight(java.math.BigDecimal shipmentPackageWeight)
    {
        this.shipmentPackageWeight = shipmentPackageWeight;
    }

    private String shipmentPackageWeightUomId;

    public String getShipmentPackageWeightUomId()
    {
        return this.shipmentPackageWeightUomId;
    }

    public void setShipmentPackageWeightUomId(String shipmentPackageWeightUomId)
    {
        this.shipmentPackageWeightUomId = shipmentPackageWeightUomId;
    }

    private java.math.BigDecimal shipmentPackageInsuredValue;

    public java.math.BigDecimal getShipmentPackageInsuredValue()
    {
        return this.shipmentPackageInsuredValue;
    }

    public void setShipmentPackageInsuredValue(java.math.BigDecimal shipmentPackageInsuredValue)
    {
        this.shipmentPackageInsuredValue = shipmentPackageInsuredValue;
    }

    private Long shipmentPackageVersion;

    public Long getShipmentPackageVersion()
    {
        return this.shipmentPackageVersion;
    }

    public void setShipmentPackageVersion(Long shipmentPackageVersion)
    {
        this.shipmentPackageVersion = shipmentPackageVersion;
    }

    private String shipmentPackageCreatedBy;

    public String getShipmentPackageCreatedBy()
    {
        return this.shipmentPackageCreatedBy;
    }

    public void setShipmentPackageCreatedBy(String shipmentPackageCreatedBy)
    {
        this.shipmentPackageCreatedBy = shipmentPackageCreatedBy;
    }

    private Date shipmentPackageCreatedAt;

    public Date getShipmentPackageCreatedAt()
    {
        return this.shipmentPackageCreatedAt;
    }

    public void setShipmentPackageCreatedAt(Date shipmentPackageCreatedAt)
    {
        this.shipmentPackageCreatedAt = shipmentPackageCreatedAt;
    }

    private String shipmentPackageUpdatedBy;

    public String getShipmentPackageUpdatedBy()
    {
        return this.shipmentPackageUpdatedBy;
    }

    public void setShipmentPackageUpdatedBy(String shipmentPackageUpdatedBy)
    {
        this.shipmentPackageUpdatedBy = shipmentPackageUpdatedBy;
    }

    private Date shipmentPackageUpdatedAt;

    public Date getShipmentPackageUpdatedAt()
    {
        return this.shipmentPackageUpdatedAt;
    }

    public void setShipmentPackageUpdatedAt(Date shipmentPackageUpdatedAt)
    {
        this.shipmentPackageUpdatedAt = shipmentPackageUpdatedAt;
    }

    private Boolean shipmentPackageActive;

    public Boolean getShipmentPackageActive()
    {
        return this.shipmentPackageActive;
    }

    public void setShipmentPackageActive(Boolean shipmentPackageActive)
    {
        this.shipmentPackageActive = shipmentPackageActive;
    }

    private Boolean shipmentPackageDeleted;

    public Boolean getShipmentPackageDeleted()
    {
        return this.shipmentPackageDeleted;
    }

    public void setShipmentPackageDeleted(Boolean shipmentPackageDeleted)
    {
        this.shipmentPackageDeleted = shipmentPackageDeleted;
    }

    public boolean isStateUnsaved() 
    {
        return this.getShipmentPackageVersion() == null;
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

    public AbstractShipmentPackageContentMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setShipmentPackageContentId(((ShipmentPackageContentMvoStateEvent) events.get(0)).getShipmentPackageContentMvoEventId().getShipmentPackageContentId());
            for (Event e : events) {
                mutate(e);
                this.setShipmentPackageVersion(this.getShipmentPackageVersion() + 1);
            }
        }
    }


    public AbstractShipmentPackageContentMvoState() {
        this(false);
    }

    public AbstractShipmentPackageContentMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ShipmentPackageContentMvoStateCreated) {
            when((ShipmentPackageContentMvoStateCreated) e);
        } else if (e instanceof ShipmentPackageContentMvoStateMergePatched) {
            when((ShipmentPackageContentMvoStateMergePatched) e);
        } else if (e instanceof ShipmentPackageContentMvoStateDeleted) {
            when((ShipmentPackageContentMvoStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ShipmentPackageContentMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setQuantity(e.getQuantity());
        this.setSubProductId(e.getSubProductId());
        this.setSubProductQuantity(e.getSubProductQuantity());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setShipmentPackageShipmentBoxTypeId(e.getShipmentPackageShipmentBoxTypeId());
        this.setShipmentPackageDateCreated(e.getShipmentPackageDateCreated());
        this.setShipmentPackageBoxLength(e.getShipmentPackageBoxLength());
        this.setShipmentPackageBoxHeight(e.getShipmentPackageBoxHeight());
        this.setShipmentPackageBoxWidth(e.getShipmentPackageBoxWidth());
        this.setShipmentPackageDimensionUomId(e.getShipmentPackageDimensionUomId());
        this.setShipmentPackageWeight(e.getShipmentPackageWeight());
        this.setShipmentPackageWeightUomId(e.getShipmentPackageWeightUomId());
        this.setShipmentPackageInsuredValue(e.getShipmentPackageInsuredValue());
        this.setShipmentPackageCreatedBy(e.getShipmentPackageCreatedBy());
        this.setShipmentPackageCreatedAt(e.getShipmentPackageCreatedAt());
        this.setShipmentPackageUpdatedBy(e.getShipmentPackageUpdatedBy());
        this.setShipmentPackageUpdatedAt(e.getShipmentPackageUpdatedAt());
        this.setShipmentPackageActive(e.getShipmentPackageActive());
        this.setShipmentPackageDeleted(e.getShipmentPackageDeleted());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(ShipmentPackageContentMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getQuantity() == null)
        {
            if (e.getIsPropertyQuantityRemoved() != null && e.getIsPropertyQuantityRemoved())
            {
                this.setQuantity(null);
            }
        }
        else
        {
            this.setQuantity(e.getQuantity());
        }
        if (e.getSubProductId() == null)
        {
            if (e.getIsPropertySubProductIdRemoved() != null && e.getIsPropertySubProductIdRemoved())
            {
                this.setSubProductId(null);
            }
        }
        else
        {
            this.setSubProductId(e.getSubProductId());
        }
        if (e.getSubProductQuantity() == null)
        {
            if (e.getIsPropertySubProductQuantityRemoved() != null && e.getIsPropertySubProductQuantityRemoved())
            {
                this.setSubProductQuantity(null);
            }
        }
        else
        {
            this.setSubProductQuantity(e.getSubProductQuantity());
        }
        if (e.getVersion() == null)
        {
            if (e.getIsPropertyVersionRemoved() != null && e.getIsPropertyVersionRemoved())
            {
                this.setVersion(null);
            }
        }
        else
        {
            this.setVersion(e.getVersion());
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
        if (e.getShipmentPackageShipmentBoxTypeId() == null)
        {
            if (e.getIsPropertyShipmentPackageShipmentBoxTypeIdRemoved() != null && e.getIsPropertyShipmentPackageShipmentBoxTypeIdRemoved())
            {
                this.setShipmentPackageShipmentBoxTypeId(null);
            }
        }
        else
        {
            this.setShipmentPackageShipmentBoxTypeId(e.getShipmentPackageShipmentBoxTypeId());
        }
        if (e.getShipmentPackageDateCreated() == null)
        {
            if (e.getIsPropertyShipmentPackageDateCreatedRemoved() != null && e.getIsPropertyShipmentPackageDateCreatedRemoved())
            {
                this.setShipmentPackageDateCreated(null);
            }
        }
        else
        {
            this.setShipmentPackageDateCreated(e.getShipmentPackageDateCreated());
        }
        if (e.getShipmentPackageBoxLength() == null)
        {
            if (e.getIsPropertyShipmentPackageBoxLengthRemoved() != null && e.getIsPropertyShipmentPackageBoxLengthRemoved())
            {
                this.setShipmentPackageBoxLength(null);
            }
        }
        else
        {
            this.setShipmentPackageBoxLength(e.getShipmentPackageBoxLength());
        }
        if (e.getShipmentPackageBoxHeight() == null)
        {
            if (e.getIsPropertyShipmentPackageBoxHeightRemoved() != null && e.getIsPropertyShipmentPackageBoxHeightRemoved())
            {
                this.setShipmentPackageBoxHeight(null);
            }
        }
        else
        {
            this.setShipmentPackageBoxHeight(e.getShipmentPackageBoxHeight());
        }
        if (e.getShipmentPackageBoxWidth() == null)
        {
            if (e.getIsPropertyShipmentPackageBoxWidthRemoved() != null && e.getIsPropertyShipmentPackageBoxWidthRemoved())
            {
                this.setShipmentPackageBoxWidth(null);
            }
        }
        else
        {
            this.setShipmentPackageBoxWidth(e.getShipmentPackageBoxWidth());
        }
        if (e.getShipmentPackageDimensionUomId() == null)
        {
            if (e.getIsPropertyShipmentPackageDimensionUomIdRemoved() != null && e.getIsPropertyShipmentPackageDimensionUomIdRemoved())
            {
                this.setShipmentPackageDimensionUomId(null);
            }
        }
        else
        {
            this.setShipmentPackageDimensionUomId(e.getShipmentPackageDimensionUomId());
        }
        if (e.getShipmentPackageWeight() == null)
        {
            if (e.getIsPropertyShipmentPackageWeightRemoved() != null && e.getIsPropertyShipmentPackageWeightRemoved())
            {
                this.setShipmentPackageWeight(null);
            }
        }
        else
        {
            this.setShipmentPackageWeight(e.getShipmentPackageWeight());
        }
        if (e.getShipmentPackageWeightUomId() == null)
        {
            if (e.getIsPropertyShipmentPackageWeightUomIdRemoved() != null && e.getIsPropertyShipmentPackageWeightUomIdRemoved())
            {
                this.setShipmentPackageWeightUomId(null);
            }
        }
        else
        {
            this.setShipmentPackageWeightUomId(e.getShipmentPackageWeightUomId());
        }
        if (e.getShipmentPackageInsuredValue() == null)
        {
            if (e.getIsPropertyShipmentPackageInsuredValueRemoved() != null && e.getIsPropertyShipmentPackageInsuredValueRemoved())
            {
                this.setShipmentPackageInsuredValue(null);
            }
        }
        else
        {
            this.setShipmentPackageInsuredValue(e.getShipmentPackageInsuredValue());
        }
        if (e.getShipmentPackageCreatedBy() == null)
        {
            if (e.getIsPropertyShipmentPackageCreatedByRemoved() != null && e.getIsPropertyShipmentPackageCreatedByRemoved())
            {
                this.setShipmentPackageCreatedBy(null);
            }
        }
        else
        {
            this.setShipmentPackageCreatedBy(e.getShipmentPackageCreatedBy());
        }
        if (e.getShipmentPackageCreatedAt() == null)
        {
            if (e.getIsPropertyShipmentPackageCreatedAtRemoved() != null && e.getIsPropertyShipmentPackageCreatedAtRemoved())
            {
                this.setShipmentPackageCreatedAt(null);
            }
        }
        else
        {
            this.setShipmentPackageCreatedAt(e.getShipmentPackageCreatedAt());
        }
        if (e.getShipmentPackageUpdatedBy() == null)
        {
            if (e.getIsPropertyShipmentPackageUpdatedByRemoved() != null && e.getIsPropertyShipmentPackageUpdatedByRemoved())
            {
                this.setShipmentPackageUpdatedBy(null);
            }
        }
        else
        {
            this.setShipmentPackageUpdatedBy(e.getShipmentPackageUpdatedBy());
        }
        if (e.getShipmentPackageUpdatedAt() == null)
        {
            if (e.getIsPropertyShipmentPackageUpdatedAtRemoved() != null && e.getIsPropertyShipmentPackageUpdatedAtRemoved())
            {
                this.setShipmentPackageUpdatedAt(null);
            }
        }
        else
        {
            this.setShipmentPackageUpdatedAt(e.getShipmentPackageUpdatedAt());
        }
        if (e.getShipmentPackageActive() == null)
        {
            if (e.getIsPropertyShipmentPackageActiveRemoved() != null && e.getIsPropertyShipmentPackageActiveRemoved())
            {
                this.setShipmentPackageActive(null);
            }
        }
        else
        {
            this.setShipmentPackageActive(e.getShipmentPackageActive());
        }
        if (e.getShipmentPackageDeleted() == null)
        {
            if (e.getIsPropertyShipmentPackageDeletedRemoved() != null && e.getIsPropertyShipmentPackageDeletedRemoved())
            {
                this.setShipmentPackageDeleted(null);
            }
        }
        else
        {
            this.setShipmentPackageDeleted(e.getShipmentPackageDeleted());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(ShipmentPackageContentMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(ShipmentPackageContentMvoStateEvent stateEvent)
    {
        ShipmentPackageContentId stateEntityId = this.getShipmentPackageContentId(); // Aggregate Id
        ShipmentPackageContentId eventEntityId = stateEvent.getShipmentPackageContentMvoEventId().getShipmentPackageContentId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getShipmentPackageVersion();
        Long eventVersion = stateEvent.getShipmentPackageContentMvoEventId().getShipmentPackageVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getShipmentPackageContentMvoEventId().getShipmentPackageVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(ShipmentPackageContentMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleShipmentPackageContentMvoState extends AbstractShipmentPackageContentMvoState
    {

        public SimpleShipmentPackageContentMvoState() {
        }

        public SimpleShipmentPackageContentMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleShipmentPackageContentMvoState(List<Event> events) {
            super(events);
        }

    }


}

