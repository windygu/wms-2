package org.dddml.wms.domain.inventoryitem;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class InventoryItemEntryStateEventDto extends AbstractStateEvent
{

    private InventoryItemEntryStateEventIdDto stateEventId;

    InventoryItemEntryStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new InventoryItemEntryStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(InventoryItemEntryStateEventIdDto stateEventId) {
        this.stateEventId = stateEventId;
    }

    public Long getEntrySeqId() {
        return getStateEventId().getEntrySeqId();
    }

    public void setEntrySeqId(Long entrySeqId) {
        getStateEventId().setEntrySeqId(entrySeqId);
    }

    private BigDecimal quantityOnHand;

    public BigDecimal getQuantityOnHand() {
        return this.quantityOnHand;
    }

    public void setQuantityOnHand(BigDecimal quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    private BigDecimal quantityInTransit;

    public BigDecimal getQuantityInTransit() {
        return this.quantityInTransit;
    }

    public void setQuantityInTransit(BigDecimal quantityInTransit) {
        this.quantityInTransit = quantityInTransit;
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

    private InventoryItemSourceInfoDto source = new InventoryItemSourceInfoDto();

    public InventoryItemSourceInfoDto getSource() {
        return this.source;
    }

    public void setSource(InventoryItemSourceInfoDto source) {
        this.source = source;
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

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private Boolean isPropertyQuantityOnHandRemoved;

    public Boolean getIsPropertyQuantityOnHandRemoved() {
        return this.isPropertyQuantityOnHandRemoved;
    }

    public void setIsPropertyQuantityOnHandRemoved(Boolean removed) {
        this.isPropertyQuantityOnHandRemoved = removed;
    }

    private Boolean isPropertyQuantityInTransitRemoved;

    public Boolean getIsPropertyQuantityInTransitRemoved() {
        return this.isPropertyQuantityInTransitRemoved;
    }

    public void setIsPropertyQuantityInTransitRemoved(Boolean removed) {
        this.isPropertyQuantityInTransitRemoved = removed;
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


	public static class InventoryItemEntryStateCreatedDto extends InventoryItemEntryStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class InventoryItemEntryStateMergePatchedDto extends InventoryItemEntryStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class InventoryItemEntryStateRemovedDto extends InventoryItemEntryStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

