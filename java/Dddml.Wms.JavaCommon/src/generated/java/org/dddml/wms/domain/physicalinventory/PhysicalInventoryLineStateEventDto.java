package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class PhysicalInventoryLineStateEventDto extends AbstractEvent
{

    private PhysicalInventoryLineEventId physicalInventoryLineEventId;

    PhysicalInventoryLineEventId getPhysicalInventoryLineEventId() {
        if (physicalInventoryLineEventId == null) { physicalInventoryLineEventId = new PhysicalInventoryLineEventId(); }
        return physicalInventoryLineEventId;
    }

    void setPhysicalInventoryLineEventId(PhysicalInventoryLineEventId eventId) {
        this.physicalInventoryLineEventId = eventId;
    }

    public InventoryItemId getInventoryItemId() {
        return getPhysicalInventoryLineEventId().getInventoryItemId();
    }

    public void setInventoryItemId(InventoryItemId inventoryItemId) {
        getPhysicalInventoryLineEventId().setInventoryItemId(inventoryItemId);
    }

    private BigDecimal bookQuantity;

    public BigDecimal getBookQuantity() {
        return this.bookQuantity;
    }

    public void setBookQuantity(BigDecimal bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    private BigDecimal countedQuantity;

    public BigDecimal getCountedQuantity() {
        return this.countedQuantity;
    }

    public void setCountedQuantity(BigDecimal countedQuantity) {
        this.countedQuantity = countedQuantity;
    }

    private Boolean processed;

    public Boolean getProcessed() {
        return this.processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    private String lineNumber;

    public String getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    private Long reversalLineNumber;

    public Long getReversalLineNumber() {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(Long reversalLineNumber) {
        this.reversalLineNumber = reversalLineNumber;
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    private Boolean isPropertyBookQuantityRemoved;

    public Boolean getIsPropertyBookQuantityRemoved() {
        return this.isPropertyBookQuantityRemoved;
    }

    public void setIsPropertyBookQuantityRemoved(Boolean removed) {
        this.isPropertyBookQuantityRemoved = removed;
    }

    private Boolean isPropertyCountedQuantityRemoved;

    public Boolean getIsPropertyCountedQuantityRemoved() {
        return this.isPropertyCountedQuantityRemoved;
    }

    public void setIsPropertyCountedQuantityRemoved(Boolean removed) {
        this.isPropertyCountedQuantityRemoved = removed;
    }

    private Boolean isPropertyProcessedRemoved;

    public Boolean getIsPropertyProcessedRemoved() {
        return this.isPropertyProcessedRemoved;
    }

    public void setIsPropertyProcessedRemoved(Boolean removed) {
        this.isPropertyProcessedRemoved = removed;
    }

    private Boolean isPropertyLineNumberRemoved;

    public Boolean getIsPropertyLineNumberRemoved() {
        return this.isPropertyLineNumberRemoved;
    }

    public void setIsPropertyLineNumberRemoved(Boolean removed) {
        this.isPropertyLineNumberRemoved = removed;
    }

    private Boolean isPropertyReversalLineNumberRemoved;

    public Boolean getIsPropertyReversalLineNumberRemoved() {
        return this.isPropertyReversalLineNumberRemoved;
    }

    public void setIsPropertyReversalLineNumberRemoved(Boolean removed) {
        this.isPropertyReversalLineNumberRemoved = removed;
    }

    private Boolean isPropertyDescriptionRemoved;

    public Boolean getIsPropertyDescriptionRemoved() {
        return this.isPropertyDescriptionRemoved;
    }

    public void setIsPropertyDescriptionRemoved(Boolean removed) {
        this.isPropertyDescriptionRemoved = removed;
    }


	public static class PhysicalInventoryLineStateCreatedDto extends PhysicalInventoryLineStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class PhysicalInventoryLineStateMergePatchedDto extends PhysicalInventoryLineStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class PhysicalInventoryLineStateRemovedDto extends PhysicalInventoryLineStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_REMOVED;
        }

	}


}

