package org.dddml.wms.domain.supplierproduct;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.supplierproduct.SupplierProductStateEvent.*;

public abstract class AbstractSupplierProductState implements SupplierProductState
{

    private SupplierProductId supplierProductId;

    public SupplierProductId getSupplierProductId()
    {
        return this.supplierProductId;
    }

    public void setSupplierProductId(SupplierProductId supplierProductId)
    {
        this.supplierProductId = supplierProductId;
    }

    private java.sql.Timestamp availableThruDate;

    public java.sql.Timestamp getAvailableThruDate()
    {
        return this.availableThruDate;
    }

    public void setAvailableThruDate(java.sql.Timestamp availableThruDate)
    {
        this.availableThruDate = availableThruDate;
    }

    private String supplierPrefOrderId;

    public String getSupplierPrefOrderId()
    {
        return this.supplierPrefOrderId;
    }

    public void setSupplierPrefOrderId(String supplierPrefOrderId)
    {
        this.supplierPrefOrderId = supplierPrefOrderId;
    }

    private String supplierRatingTypeId;

    public String getSupplierRatingTypeId()
    {
        return this.supplierRatingTypeId;
    }

    public void setSupplierRatingTypeId(String supplierRatingTypeId)
    {
        this.supplierRatingTypeId = supplierRatingTypeId;
    }

    private java.math.BigDecimal standardLeadTimeDays;

    public java.math.BigDecimal getStandardLeadTimeDays()
    {
        return this.standardLeadTimeDays;
    }

    public void setStandardLeadTimeDays(java.math.BigDecimal standardLeadTimeDays)
    {
        this.standardLeadTimeDays = standardLeadTimeDays;
    }

    private java.math.BigDecimal manufacturingLeadTimeDays;

    public java.math.BigDecimal getManufacturingLeadTimeDays()
    {
        return this.manufacturingLeadTimeDays;
    }

    public void setManufacturingLeadTimeDays(java.math.BigDecimal manufacturingLeadTimeDays)
    {
        this.manufacturingLeadTimeDays = manufacturingLeadTimeDays;
    }

    private java.math.BigDecimal deliveryLeadTimeDays;

    public java.math.BigDecimal getDeliveryLeadTimeDays()
    {
        return this.deliveryLeadTimeDays;
    }

    public void setDeliveryLeadTimeDays(java.math.BigDecimal deliveryLeadTimeDays)
    {
        this.deliveryLeadTimeDays = deliveryLeadTimeDays;
    }

    private String quantityUomId;

    public String getQuantityUomId()
    {
        return this.quantityUomId;
    }

    public void setQuantityUomId(String quantityUomId)
    {
        this.quantityUomId = quantityUomId;
    }

    private java.math.BigDecimal lastPrice;

    public java.math.BigDecimal getLastPrice()
    {
        return this.lastPrice;
    }

    public void setLastPrice(java.math.BigDecimal lastPrice)
    {
        this.lastPrice = lastPrice;
    }

    private java.math.BigDecimal shippingPrice;

    public java.math.BigDecimal getShippingPrice()
    {
        return this.shippingPrice;
    }

    public void setShippingPrice(java.math.BigDecimal shippingPrice)
    {
        this.shippingPrice = shippingPrice;
    }

    private String externalProductName;

    public String getExternalProductName()
    {
        return this.externalProductName;
    }

    public void setExternalProductName(String externalProductName)
    {
        this.externalProductName = externalProductName;
    }

    private String externalProductId;

    public String getExternalProductId()
    {
        return this.externalProductId;
    }

    public void setExternalProductId(String externalProductId)
    {
        this.externalProductId = externalProductId;
    }

    private Boolean canDropShip;

    public Boolean getCanDropShip()
    {
        return this.canDropShip;
    }

    public void setCanDropShip(Boolean canDropShip)
    {
        this.canDropShip = canDropShip;
    }

    private String comments;

    public String getComments()
    {
        return this.comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
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

    public AbstractSupplierProductState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setSupplierProductId(((SupplierProductStateEvent) events.get(0)).getStateEventId().getSupplierProductId());
            for (Event e : events) {
                mutate(e);
                this.setVersion(this.getVersion() + 1);
            }
        }
    }


    public AbstractSupplierProductState() {
        this(false);
    }

    public AbstractSupplierProductState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof SupplierProductStateCreated) {
            when((SupplierProductStateCreated) e);
        } else if (e instanceof SupplierProductStateMergePatched) {
            when((SupplierProductStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(SupplierProductStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setAvailableThruDate(e.getAvailableThruDate());
        this.setSupplierPrefOrderId(e.getSupplierPrefOrderId());
        this.setSupplierRatingTypeId(e.getSupplierRatingTypeId());
        this.setStandardLeadTimeDays(e.getStandardLeadTimeDays());
        this.setManufacturingLeadTimeDays(e.getManufacturingLeadTimeDays());
        this.setDeliveryLeadTimeDays(e.getDeliveryLeadTimeDays());
        this.setQuantityUomId(e.getQuantityUomId());
        this.setLastPrice(e.getLastPrice());
        this.setShippingPrice(e.getShippingPrice());
        this.setExternalProductName(e.getExternalProductName());
        this.setExternalProductId(e.getExternalProductId());
        this.setCanDropShip(e.getCanDropShip());
        this.setComments(e.getComments());
        this.setActive(e.getActive());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(SupplierProductStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getAvailableThruDate() == null)
        {
            if (e.getIsPropertyAvailableThruDateRemoved() != null && e.getIsPropertyAvailableThruDateRemoved())
            {
                this.setAvailableThruDate(null);
            }
        }
        else
        {
            this.setAvailableThruDate(e.getAvailableThruDate());
        }
        if (e.getSupplierPrefOrderId() == null)
        {
            if (e.getIsPropertySupplierPrefOrderIdRemoved() != null && e.getIsPropertySupplierPrefOrderIdRemoved())
            {
                this.setSupplierPrefOrderId(null);
            }
        }
        else
        {
            this.setSupplierPrefOrderId(e.getSupplierPrefOrderId());
        }
        if (e.getSupplierRatingTypeId() == null)
        {
            if (e.getIsPropertySupplierRatingTypeIdRemoved() != null && e.getIsPropertySupplierRatingTypeIdRemoved())
            {
                this.setSupplierRatingTypeId(null);
            }
        }
        else
        {
            this.setSupplierRatingTypeId(e.getSupplierRatingTypeId());
        }
        if (e.getStandardLeadTimeDays() == null)
        {
            if (e.getIsPropertyStandardLeadTimeDaysRemoved() != null && e.getIsPropertyStandardLeadTimeDaysRemoved())
            {
                this.setStandardLeadTimeDays(null);
            }
        }
        else
        {
            this.setStandardLeadTimeDays(e.getStandardLeadTimeDays());
        }
        if (e.getManufacturingLeadTimeDays() == null)
        {
            if (e.getIsPropertyManufacturingLeadTimeDaysRemoved() != null && e.getIsPropertyManufacturingLeadTimeDaysRemoved())
            {
                this.setManufacturingLeadTimeDays(null);
            }
        }
        else
        {
            this.setManufacturingLeadTimeDays(e.getManufacturingLeadTimeDays());
        }
        if (e.getDeliveryLeadTimeDays() == null)
        {
            if (e.getIsPropertyDeliveryLeadTimeDaysRemoved() != null && e.getIsPropertyDeliveryLeadTimeDaysRemoved())
            {
                this.setDeliveryLeadTimeDays(null);
            }
        }
        else
        {
            this.setDeliveryLeadTimeDays(e.getDeliveryLeadTimeDays());
        }
        if (e.getQuantityUomId() == null)
        {
            if (e.getIsPropertyQuantityUomIdRemoved() != null && e.getIsPropertyQuantityUomIdRemoved())
            {
                this.setQuantityUomId(null);
            }
        }
        else
        {
            this.setQuantityUomId(e.getQuantityUomId());
        }
        if (e.getLastPrice() == null)
        {
            if (e.getIsPropertyLastPriceRemoved() != null && e.getIsPropertyLastPriceRemoved())
            {
                this.setLastPrice(null);
            }
        }
        else
        {
            this.setLastPrice(e.getLastPrice());
        }
        if (e.getShippingPrice() == null)
        {
            if (e.getIsPropertyShippingPriceRemoved() != null && e.getIsPropertyShippingPriceRemoved())
            {
                this.setShippingPrice(null);
            }
        }
        else
        {
            this.setShippingPrice(e.getShippingPrice());
        }
        if (e.getExternalProductName() == null)
        {
            if (e.getIsPropertyExternalProductNameRemoved() != null && e.getIsPropertyExternalProductNameRemoved())
            {
                this.setExternalProductName(null);
            }
        }
        else
        {
            this.setExternalProductName(e.getExternalProductName());
        }
        if (e.getExternalProductId() == null)
        {
            if (e.getIsPropertyExternalProductIdRemoved() != null && e.getIsPropertyExternalProductIdRemoved())
            {
                this.setExternalProductId(null);
            }
        }
        else
        {
            this.setExternalProductId(e.getExternalProductId());
        }
        if (e.getCanDropShip() == null)
        {
            if (e.getIsPropertyCanDropShipRemoved() != null && e.getIsPropertyCanDropShipRemoved())
            {
                this.setCanDropShip(null);
            }
        }
        else
        {
            this.setCanDropShip(e.getCanDropShip());
        }
        if (e.getComments() == null)
        {
            if (e.getIsPropertyCommentsRemoved() != null && e.getIsPropertyCommentsRemoved())
            {
                this.setComments(null);
            }
        }
        else
        {
            this.setComments(e.getComments());
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

    public void save()
    {
    }

    protected void throwOnWrongEvent(SupplierProductStateEvent stateEvent)
    {
        SupplierProductId stateEntityId = this.getSupplierProductId(); // Aggregate Id
        SupplierProductId eventEntityId = stateEvent.getStateEventId().getSupplierProductId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getStateEventId().getVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(SupplierProductState.VERSION_NULL)) && !(eventVersion.compareTo(stateVersion) >= 0))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleSupplierProductState extends AbstractSupplierProductState
    {

        public SimpleSupplierProductState() {
        }

        public SimpleSupplierProductState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleSupplierProductState(List<Event> events) {
            super(events);
        }

    }


}

