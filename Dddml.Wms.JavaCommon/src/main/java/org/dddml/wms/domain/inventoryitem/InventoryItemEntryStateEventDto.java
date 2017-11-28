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

    private BigDecimal quantityOnHandVar;

    public BigDecimal getQuantityOnHandVar() {
        return this.quantityOnHandVar;
    }

    public void setQuantityOnHandVar(BigDecimal quantityOnHandVar) {
        this.quantityOnHandVar = quantityOnHandVar;
    }

    private BigDecimal quantityReservedVar;

    public BigDecimal getQuantityReservedVar() {
        return this.quantityReservedVar;
    }

    public void setQuantityReservedVar(BigDecimal quantityReservedVar) {
        this.quantityReservedVar = quantityReservedVar;
    }

    private BigDecimal quantityOccupiedVar;

    public BigDecimal getQuantityOccupiedVar() {
        return this.quantityOccupiedVar;
    }

    public void setQuantityOccupiedVar(BigDecimal quantityOccupiedVar) {
        this.quantityOccupiedVar = quantityOccupiedVar;
    }

    private BigDecimal quantityVirtualVar;

    public BigDecimal getQuantityVirtualVar() {
        return this.quantityVirtualVar;
    }

    public void setQuantityVirtualVar(BigDecimal quantityVirtualVar) {
        this.quantityVirtualVar = quantityVirtualVar;
    }

    private InventoryItemEventVODto eventVO = new InventoryItemEventVODto();

    public InventoryItemEventVODto getEventVO() {
        return this.eventVO;
    }

    public void setEventVO(InventoryItemEventVODto eventVO) {
        this.eventVO = eventVO;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    private Boolean isPropertyQuantityOnHandVarRemoved;

    public Boolean getIsPropertyQuantityOnHandVarRemoved() {
        return this.isPropertyQuantityOnHandVarRemoved;
    }

    public void setIsPropertyQuantityOnHandVarRemoved(Boolean removed) {
        this.isPropertyQuantityOnHandVarRemoved = removed;
    }

    private Boolean isPropertyQuantityReservedVarRemoved;

    public Boolean getIsPropertyQuantityReservedVarRemoved() {
        return this.isPropertyQuantityReservedVarRemoved;
    }

    public void setIsPropertyQuantityReservedVarRemoved(Boolean removed) {
        this.isPropertyQuantityReservedVarRemoved = removed;
    }

    private Boolean isPropertyQuantityOccupiedVarRemoved;

    public Boolean getIsPropertyQuantityOccupiedVarRemoved() {
        return this.isPropertyQuantityOccupiedVarRemoved;
    }

    public void setIsPropertyQuantityOccupiedVarRemoved(Boolean removed) {
        this.isPropertyQuantityOccupiedVarRemoved = removed;
    }

    private Boolean isPropertyQuantityVirtualVarRemoved;

    public Boolean getIsPropertyQuantityVirtualVarRemoved() {
        return this.isPropertyQuantityVirtualVarRemoved;
    }

    public void setIsPropertyQuantityVirtualVarRemoved(Boolean removed) {
        this.isPropertyQuantityVirtualVarRemoved = removed;
    }

    private Boolean isPropertyEventVORemoved;

    public Boolean getIsPropertyEventVORemoved() {
        return this.isPropertyEventVORemoved;
    }

    public void setIsPropertyEventVORemoved(Boolean removed) {
        this.isPropertyEventVORemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
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

