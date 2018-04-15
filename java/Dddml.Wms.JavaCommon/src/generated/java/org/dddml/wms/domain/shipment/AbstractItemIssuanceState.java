package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipment.ItemIssuanceEvent.*;

public abstract class AbstractItemIssuanceState implements ItemIssuanceState
{

    private ShipmentItemIssuanceId shipmentItemIssuanceId = new ShipmentItemIssuanceId();

    public ShipmentItemIssuanceId getShipmentItemIssuanceId() {
        return this.shipmentItemIssuanceId;
    }

    public void setShipmentItemIssuanceId(ShipmentItemIssuanceId shipmentItemIssuanceId) {
        this.shipmentItemIssuanceId = shipmentItemIssuanceId;
    }

    public String getShipmentId() {
        return this.getShipmentItemIssuanceId().getShipmentId();
    }
        
    public void setShipmentId(String shipmentId) {
        this.getShipmentItemIssuanceId().setShipmentId(shipmentId);
    }

    public String getItemIssuanceSeqId() {
        return this.getShipmentItemIssuanceId().getItemIssuanceSeqId();
    }
        
    public void setItemIssuanceSeqId(String itemIssuanceSeqId) {
        this.getShipmentItemIssuanceId().setItemIssuanceSeqId(itemIssuanceSeqId);
    }

    private String orderId;

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    private String orderItemSeqId;

    public String getOrderItemSeqId()
    {
        return this.orderItemSeqId;
    }

    public void setOrderItemSeqId(String orderItemSeqId)
    {
        this.orderItemSeqId = orderItemSeqId;
    }

    private Long shipGroupSeqId;

    public Long getShipGroupSeqId()
    {
        return this.shipGroupSeqId;
    }

    public void setShipGroupSeqId(Long shipGroupSeqId)
    {
        this.shipGroupSeqId = shipGroupSeqId;
    }

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    private String locatorId;

    public String getLocatorId()
    {
        return this.locatorId;
    }

    public void setLocatorId(String locatorId)
    {
        this.locatorId = locatorId;
    }

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
    }

    private String shipmentItemSeqId;

    public String getShipmentItemSeqId()
    {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.shipmentItemSeqId = shipmentItemSeqId;
    }

    private String fixedAssetId;

    public String getFixedAssetId()
    {
        return this.fixedAssetId;
    }

    public void setFixedAssetId(String fixedAssetId)
    {
        this.fixedAssetId = fixedAssetId;
    }

    private String maintHistSeqId;

    public String getMaintHistSeqId()
    {
        return this.maintHistSeqId;
    }

    public void setMaintHistSeqId(String maintHistSeqId)
    {
        this.maintHistSeqId = maintHistSeqId;
    }

    private java.sql.Timestamp issuedDateTime;

    public java.sql.Timestamp getIssuedDateTime()
    {
        return this.issuedDateTime;
    }

    public void setIssuedDateTime(java.sql.Timestamp issuedDateTime)
    {
        this.issuedDateTime = issuedDateTime;
    }

    private String issuedByUserLoginId;

    public String getIssuedByUserLoginId()
    {
        return this.issuedByUserLoginId;
    }

    public void setIssuedByUserLoginId(String issuedByUserLoginId)
    {
        this.issuedByUserLoginId = issuedByUserLoginId;
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

    private java.math.BigDecimal cancelQuantity;

    public java.math.BigDecimal getCancelQuantity()
    {
        return this.cancelQuantity;
    }

    public void setCancelQuantity(java.math.BigDecimal cancelQuantity)
    {
        this.cancelQuantity = cancelQuantity;
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


    public AbstractItemIssuanceState() {
        this(false);
    }

    public AbstractItemIssuanceState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ItemIssuanceStateCreated) {
            when((ItemIssuanceStateCreated) e);
        } else if (e instanceof ItemIssuanceStateMergePatched) {
            when((ItemIssuanceStateMergePatched) e);
        } else if (e instanceof ItemIssuanceStateRemoved) {
            when((ItemIssuanceStateRemoved) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ItemIssuanceStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setOrderId(e.getOrderId());
        this.setOrderItemSeqId(e.getOrderItemSeqId());
        this.setShipGroupSeqId(e.getShipGroupSeqId());
        this.setProductId(e.getProductId());
        this.setLocatorId(e.getLocatorId());
        this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        this.setShipmentItemSeqId(e.getShipmentItemSeqId());
        this.setFixedAssetId(e.getFixedAssetId());
        this.setMaintHistSeqId(e.getMaintHistSeqId());
        this.setIssuedDateTime(e.getIssuedDateTime());
        this.setIssuedByUserLoginId(e.getIssuedByUserLoginId());
        this.setQuantity(e.getQuantity());
        this.setCancelQuantity(e.getCancelQuantity());
        this.setActive(e.getActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(ItemIssuanceStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getOrderId() == null)
        {
            if (e.getIsPropertyOrderIdRemoved() != null && e.getIsPropertyOrderIdRemoved())
            {
                this.setOrderId(null);
            }
        }
        else
        {
            this.setOrderId(e.getOrderId());
        }
        if (e.getOrderItemSeqId() == null)
        {
            if (e.getIsPropertyOrderItemSeqIdRemoved() != null && e.getIsPropertyOrderItemSeqIdRemoved())
            {
                this.setOrderItemSeqId(null);
            }
        }
        else
        {
            this.setOrderItemSeqId(e.getOrderItemSeqId());
        }
        if (e.getShipGroupSeqId() == null)
        {
            if (e.getIsPropertyShipGroupSeqIdRemoved() != null && e.getIsPropertyShipGroupSeqIdRemoved())
            {
                this.setShipGroupSeqId(null);
            }
        }
        else
        {
            this.setShipGroupSeqId(e.getShipGroupSeqId());
        }
        if (e.getProductId() == null)
        {
            if (e.getIsPropertyProductIdRemoved() != null && e.getIsPropertyProductIdRemoved())
            {
                this.setProductId(null);
            }
        }
        else
        {
            this.setProductId(e.getProductId());
        }
        if (e.getLocatorId() == null)
        {
            if (e.getIsPropertyLocatorIdRemoved() != null && e.getIsPropertyLocatorIdRemoved())
            {
                this.setLocatorId(null);
            }
        }
        else
        {
            this.setLocatorId(e.getLocatorId());
        }
        if (e.getAttributeSetInstanceId() == null)
        {
            if (e.getIsPropertyAttributeSetInstanceIdRemoved() != null && e.getIsPropertyAttributeSetInstanceIdRemoved())
            {
                this.setAttributeSetInstanceId(null);
            }
        }
        else
        {
            this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        }
        if (e.getShipmentItemSeqId() == null)
        {
            if (e.getIsPropertyShipmentItemSeqIdRemoved() != null && e.getIsPropertyShipmentItemSeqIdRemoved())
            {
                this.setShipmentItemSeqId(null);
            }
        }
        else
        {
            this.setShipmentItemSeqId(e.getShipmentItemSeqId());
        }
        if (e.getFixedAssetId() == null)
        {
            if (e.getIsPropertyFixedAssetIdRemoved() != null && e.getIsPropertyFixedAssetIdRemoved())
            {
                this.setFixedAssetId(null);
            }
        }
        else
        {
            this.setFixedAssetId(e.getFixedAssetId());
        }
        if (e.getMaintHistSeqId() == null)
        {
            if (e.getIsPropertyMaintHistSeqIdRemoved() != null && e.getIsPropertyMaintHistSeqIdRemoved())
            {
                this.setMaintHistSeqId(null);
            }
        }
        else
        {
            this.setMaintHistSeqId(e.getMaintHistSeqId());
        }
        if (e.getIssuedDateTime() == null)
        {
            if (e.getIsPropertyIssuedDateTimeRemoved() != null && e.getIsPropertyIssuedDateTimeRemoved())
            {
                this.setIssuedDateTime(null);
            }
        }
        else
        {
            this.setIssuedDateTime(e.getIssuedDateTime());
        }
        if (e.getIssuedByUserLoginId() == null)
        {
            if (e.getIsPropertyIssuedByUserLoginIdRemoved() != null && e.getIsPropertyIssuedByUserLoginIdRemoved())
            {
                this.setIssuedByUserLoginId(null);
            }
        }
        else
        {
            this.setIssuedByUserLoginId(e.getIssuedByUserLoginId());
        }
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
        if (e.getCancelQuantity() == null)
        {
            if (e.getIsPropertyCancelQuantityRemoved() != null && e.getIsPropertyCancelQuantityRemoved())
            {
                this.setCancelQuantity(null);
            }
        }
        else
        {
            this.setCancelQuantity(e.getCancelQuantity());
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

    public void when(ItemIssuanceStateRemoved e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(ItemIssuanceEvent stateEvent)
    {
        String stateEntityIdShipmentId = this.getShipmentItemIssuanceId().getShipmentId();
        String eventEntityIdShipmentId = stateEvent.getItemIssuanceEventId().getShipmentId();
        if (!stateEntityIdShipmentId.equals(eventEntityIdShipmentId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ShipmentId %1$s in state but entity id ShipmentId %2$s in event", stateEntityIdShipmentId, eventEntityIdShipmentId);
        }

        String stateEntityIdItemIssuanceSeqId = this.getShipmentItemIssuanceId().getItemIssuanceSeqId();
        String eventEntityIdItemIssuanceSeqId = stateEvent.getItemIssuanceEventId().getItemIssuanceSeqId();
        if (!stateEntityIdItemIssuanceSeqId.equals(eventEntityIdItemIssuanceSeqId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id ItemIssuanceSeqId %1$s in state but entity id ItemIssuanceSeqId %2$s in event", stateEntityIdItemIssuanceSeqId, eventEntityIdItemIssuanceSeqId);
        }

        if (getForReapplying()) { return; }

        Long stateVersion = this.getVersion();
        Long eventVersion = stateEvent.getVersion();
        if (eventVersion == null) {
            eventVersion = stateVersion == null ? ItemIssuanceState.VERSION_NULL : stateVersion;
            stateEvent.setVersion(eventVersion);
        }
        if (!(stateVersion == null && eventVersion.equals(ItemIssuanceState.VERSION_NULL)) && !eventVersion.equals(stateVersion))//(eventVersion.compareTo(stateVersion) >= 0)
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleItemIssuanceState extends AbstractItemIssuanceState
    {

        public SimpleItemIssuanceState() {
        }

        public SimpleItemIssuanceState(boolean forReapplying) {
            super(forReapplying);
        }

    }


}

