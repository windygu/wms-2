package org.dddml.wms.domain.inventoryitementrymvo;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class InventoryItemEntryMvoStateEventDto extends AbstractStateEvent
{

    private InventoryItemEntryMvoStateEventIdDto stateEventId;

    InventoryItemEntryMvoStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new InventoryItemEntryMvoStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(InventoryItemEntryMvoStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public InventoryItemEntryIdDto getInventoryItemEntryId() {
        return getStateEventId().getInventoryItemEntryId();
    }

    public void setInventoryItemEntryId(InventoryItemEntryIdDto inventoryItemEntryId) {
        getStateEventId().setInventoryItemEntryId(inventoryItemEntryId);
    }

    public Long getInventoryItemVersion() {
        return getStateEventId().getInventoryItemVersion();
    }
    
    public void getInventoryItemVersion(Long inventoryItemVersion) {
        getStateEventId().setInventoryItemVersion(inventoryItemVersion);
    }

    private BigDecimal quantityOnHand;

    public BigDecimal getQuantityOnHand() {
        return this.quantityOnHand;
    }

    public void setQuantityOnHand(BigDecimal quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    private BigDecimal quantityReserved;

    public BigDecimal getQuantityReserved() {
        return this.quantityReserved;
    }

    public void setQuantityReserved(BigDecimal quantityReserved) {
        this.quantityReserved = quantityReserved;
    }

    private BigDecimal quantityOccupied;

    public BigDecimal getQuantityOccupied() {
        return this.quantityOccupied;
    }

    public void setQuantityOccupied(BigDecimal quantityOccupied) {
        this.quantityOccupied = quantityOccupied;
    }

    private BigDecimal quantityVirtual;

    public BigDecimal getQuantityVirtual() {
        return this.quantityVirtual;
    }

    public void setQuantityVirtual(BigDecimal quantityVirtual) {
        this.quantityVirtual = quantityVirtual;
    }

    private InventoryItemSourceVODto source = new InventoryItemSourceVODto();

    public InventoryItemSourceVODto getSource() {
        return this.source;
    }

    public void setSource(InventoryItemSourceVODto source) {
        this.source = source;
    }

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private BigDecimal inventoryItemQuantityOnHand;

    public BigDecimal getInventoryItemQuantityOnHand() {
        return this.inventoryItemQuantityOnHand;
    }

    public void setInventoryItemQuantityOnHand(BigDecimal inventoryItemQuantityOnHand) {
        this.inventoryItemQuantityOnHand = inventoryItemQuantityOnHand;
    }

    private BigDecimal inventoryItemQuantityReserved;

    public BigDecimal getInventoryItemQuantityReserved() {
        return this.inventoryItemQuantityReserved;
    }

    public void setInventoryItemQuantityReserved(BigDecimal inventoryItemQuantityReserved) {
        this.inventoryItemQuantityReserved = inventoryItemQuantityReserved;
    }

    private BigDecimal inventoryItemQuantityOccupied;

    public BigDecimal getInventoryItemQuantityOccupied() {
        return this.inventoryItemQuantityOccupied;
    }

    public void setInventoryItemQuantityOccupied(BigDecimal inventoryItemQuantityOccupied) {
        this.inventoryItemQuantityOccupied = inventoryItemQuantityOccupied;
    }

    private BigDecimal inventoryItemQuantityVirtual;

    public BigDecimal getInventoryItemQuantityVirtual() {
        return this.inventoryItemQuantityVirtual;
    }

    public void setInventoryItemQuantityVirtual(BigDecimal inventoryItemQuantityVirtual) {
        this.inventoryItemQuantityVirtual = inventoryItemQuantityVirtual;
    }

    private String inventoryItemCreatedBy;

    public String getInventoryItemCreatedBy() {
        return this.inventoryItemCreatedBy;
    }

    public void setInventoryItemCreatedBy(String inventoryItemCreatedBy) {
        this.inventoryItemCreatedBy = inventoryItemCreatedBy;
    }

    private Date inventoryItemCreatedAt;

    public Date getInventoryItemCreatedAt() {
        return this.inventoryItemCreatedAt;
    }

    public void setInventoryItemCreatedAt(Date inventoryItemCreatedAt) {
        this.inventoryItemCreatedAt = inventoryItemCreatedAt;
    }

    private String inventoryItemUpdatedBy;

    public String getInventoryItemUpdatedBy() {
        return this.inventoryItemUpdatedBy;
    }

    public void setInventoryItemUpdatedBy(String inventoryItemUpdatedBy) {
        this.inventoryItemUpdatedBy = inventoryItemUpdatedBy;
    }

    private Date inventoryItemUpdatedAt;

    public Date getInventoryItemUpdatedAt() {
        return this.inventoryItemUpdatedAt;
    }

    public void setInventoryItemUpdatedAt(Date inventoryItemUpdatedAt) {
        this.inventoryItemUpdatedAt = inventoryItemUpdatedAt;
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

    private Boolean isPropertyQuantityOnHandRemoved;

    public Boolean getIsPropertyQuantityOnHandRemoved() {
        return this.isPropertyQuantityOnHandRemoved;
    }

    public void setIsPropertyQuantityOnHandRemoved(Boolean removed) {
        this.isPropertyQuantityOnHandRemoved = removed;
    }

    private Boolean isPropertyQuantityReservedRemoved;

    public Boolean getIsPropertyQuantityReservedRemoved() {
        return this.isPropertyQuantityReservedRemoved;
    }

    public void setIsPropertyQuantityReservedRemoved(Boolean removed) {
        this.isPropertyQuantityReservedRemoved = removed;
    }

    private Boolean isPropertyQuantityOccupiedRemoved;

    public Boolean getIsPropertyQuantityOccupiedRemoved() {
        return this.isPropertyQuantityOccupiedRemoved;
    }

    public void setIsPropertyQuantityOccupiedRemoved(Boolean removed) {
        this.isPropertyQuantityOccupiedRemoved = removed;
    }

    private Boolean isPropertyQuantityVirtualRemoved;

    public Boolean getIsPropertyQuantityVirtualRemoved() {
        return this.isPropertyQuantityVirtualRemoved;
    }

    public void setIsPropertyQuantityVirtualRemoved(Boolean removed) {
        this.isPropertyQuantityVirtualRemoved = removed;
    }

    private Boolean isPropertySourceRemoved;

    public Boolean getIsPropertySourceRemoved() {
        return this.isPropertySourceRemoved;
    }

    public void setIsPropertySourceRemoved(Boolean removed) {
        this.isPropertySourceRemoved = removed;
    }

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved() {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed) {
        this.isPropertyVersionRemoved = removed;
    }

    private Boolean isPropertyInventoryItemQuantityOnHandRemoved;

    public Boolean getIsPropertyInventoryItemQuantityOnHandRemoved() {
        return this.isPropertyInventoryItemQuantityOnHandRemoved;
    }

    public void setIsPropertyInventoryItemQuantityOnHandRemoved(Boolean removed) {
        this.isPropertyInventoryItemQuantityOnHandRemoved = removed;
    }

    private Boolean isPropertyInventoryItemQuantityReservedRemoved;

    public Boolean getIsPropertyInventoryItemQuantityReservedRemoved() {
        return this.isPropertyInventoryItemQuantityReservedRemoved;
    }

    public void setIsPropertyInventoryItemQuantityReservedRemoved(Boolean removed) {
        this.isPropertyInventoryItemQuantityReservedRemoved = removed;
    }

    private Boolean isPropertyInventoryItemQuantityOccupiedRemoved;

    public Boolean getIsPropertyInventoryItemQuantityOccupiedRemoved() {
        return this.isPropertyInventoryItemQuantityOccupiedRemoved;
    }

    public void setIsPropertyInventoryItemQuantityOccupiedRemoved(Boolean removed) {
        this.isPropertyInventoryItemQuantityOccupiedRemoved = removed;
    }

    private Boolean isPropertyInventoryItemQuantityVirtualRemoved;

    public Boolean getIsPropertyInventoryItemQuantityVirtualRemoved() {
        return this.isPropertyInventoryItemQuantityVirtualRemoved;
    }

    public void setIsPropertyInventoryItemQuantityVirtualRemoved(Boolean removed) {
        this.isPropertyInventoryItemQuantityVirtualRemoved = removed;
    }

    private Boolean isPropertyInventoryItemCreatedByRemoved;

    public Boolean getIsPropertyInventoryItemCreatedByRemoved() {
        return this.isPropertyInventoryItemCreatedByRemoved;
    }

    public void setIsPropertyInventoryItemCreatedByRemoved(Boolean removed) {
        this.isPropertyInventoryItemCreatedByRemoved = removed;
    }

    private Boolean isPropertyInventoryItemCreatedAtRemoved;

    public Boolean getIsPropertyInventoryItemCreatedAtRemoved() {
        return this.isPropertyInventoryItemCreatedAtRemoved;
    }

    public void setIsPropertyInventoryItemCreatedAtRemoved(Boolean removed) {
        this.isPropertyInventoryItemCreatedAtRemoved = removed;
    }

    private Boolean isPropertyInventoryItemUpdatedByRemoved;

    public Boolean getIsPropertyInventoryItemUpdatedByRemoved() {
        return this.isPropertyInventoryItemUpdatedByRemoved;
    }

    public void setIsPropertyInventoryItemUpdatedByRemoved(Boolean removed) {
        this.isPropertyInventoryItemUpdatedByRemoved = removed;
    }

    private Boolean isPropertyInventoryItemUpdatedAtRemoved;

    public Boolean getIsPropertyInventoryItemUpdatedAtRemoved() {
        return this.isPropertyInventoryItemUpdatedAtRemoved;
    }

    public void setIsPropertyInventoryItemUpdatedAtRemoved(Boolean removed) {
        this.isPropertyInventoryItemUpdatedAtRemoved = removed;
    }


	public static class InventoryItemEntryMvoStateCreatedDto extends InventoryItemEntryMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class InventoryItemEntryMvoStateMergePatchedDto extends InventoryItemEntryMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class InventoryItemEntryMvoStateDeletedDto extends InventoryItemEntryMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

