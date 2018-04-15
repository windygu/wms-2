package org.dddml.wms.domain.inventoryitem;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class InventoryItemStateEventDto extends AbstractEvent
{

    private InventoryItemEventId inventoryItemEventId;

    InventoryItemEventId getStateEventId() {
        if (inventoryItemEventId == null) { inventoryItemEventId = new InventoryItemEventId(); }
        return inventoryItemEventId;
    }

    void setInventoryItemEventId(InventoryItemEventId eventId) {
        this.inventoryItemEventId = eventId;
    }

    public InventoryItemId getInventoryItemId() {
        return getStateEventId().getInventoryItemId();
    }

    public void setInventoryItemId(InventoryItemId inventoryItemId) {
        getStateEventId().setInventoryItemId(inventoryItemId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private BigDecimal onHandQuantity;

    public BigDecimal getOnHandQuantity() {
        return this.onHandQuantity;
    }

    public void setOnHandQuantity(BigDecimal onHandQuantity) {
        this.onHandQuantity = onHandQuantity;
    }

    private BigDecimal inTransitQuantity;

    public BigDecimal getInTransitQuantity() {
        return this.inTransitQuantity;
    }

    public void setInTransitQuantity(BigDecimal inTransitQuantity) {
        this.inTransitQuantity = inTransitQuantity;
    }

    private BigDecimal reservedQuantity;

    public BigDecimal getReservedQuantity() {
        return this.reservedQuantity;
    }

    public void setReservedQuantity(BigDecimal reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    private BigDecimal occupiedQuantity;

    public BigDecimal getOccupiedQuantity() {
        return this.occupiedQuantity;
    }

    public void setOccupiedQuantity(BigDecimal occupiedQuantity) {
        this.occupiedQuantity = occupiedQuantity;
    }

    private BigDecimal virtualQuantity;

    public BigDecimal getVirtualQuantity() {
        return this.virtualQuantity;
    }

    public void setVirtualQuantity(BigDecimal virtualQuantity) {
        this.virtualQuantity = virtualQuantity;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private Boolean isPropertyOnHandQuantityRemoved;

    public Boolean getIsPropertyOnHandQuantityRemoved() {
        return this.isPropertyOnHandQuantityRemoved;
    }

    public void setIsPropertyOnHandQuantityRemoved(Boolean removed) {
        this.isPropertyOnHandQuantityRemoved = removed;
    }

    private Boolean isPropertyInTransitQuantityRemoved;

    public Boolean getIsPropertyInTransitQuantityRemoved() {
        return this.isPropertyInTransitQuantityRemoved;
    }

    public void setIsPropertyInTransitQuantityRemoved(Boolean removed) {
        this.isPropertyInTransitQuantityRemoved = removed;
    }

    private Boolean isPropertyReservedQuantityRemoved;

    public Boolean getIsPropertyReservedQuantityRemoved() {
        return this.isPropertyReservedQuantityRemoved;
    }

    public void setIsPropertyReservedQuantityRemoved(Boolean removed) {
        this.isPropertyReservedQuantityRemoved = removed;
    }

    private Boolean isPropertyOccupiedQuantityRemoved;

    public Boolean getIsPropertyOccupiedQuantityRemoved() {
        return this.isPropertyOccupiedQuantityRemoved;
    }

    public void setIsPropertyOccupiedQuantityRemoved(Boolean removed) {
        this.isPropertyOccupiedQuantityRemoved = removed;
    }

    private Boolean isPropertyVirtualQuantityRemoved;

    public Boolean getIsPropertyVirtualQuantityRemoved() {
        return this.isPropertyVirtualQuantityRemoved;
    }

    public void setIsPropertyVirtualQuantityRemoved(Boolean removed) {
        this.isPropertyVirtualQuantityRemoved = removed;
    }


    private InventoryItemEntryStateEventDto[] inventoryItemEntryEvents;

    public InventoryItemEntryStateEventDto[] getInventoryItemEntryEvents() {
        return this.inventoryItemEntryEvents;
    }

    public void setInventoryItemEntryEvents(InventoryItemEntryStateEventDto[] events) {
        this.inventoryItemEntryEvents = events;
    }


	public static class InventoryItemStateCreatedDto extends InventoryItemStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class InventoryItemStateMergePatchedDto extends InventoryItemStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class InventoryItemStateDeletedDto extends InventoryItemStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

