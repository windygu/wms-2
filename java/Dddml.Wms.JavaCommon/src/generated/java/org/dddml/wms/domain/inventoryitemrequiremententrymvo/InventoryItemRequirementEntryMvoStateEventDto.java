package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class InventoryItemRequirementEntryMvoStateEventDto extends AbstractStateEvent
{

    private InventoryItemRequirementEntryMvoEventId inventoryItemRequirementEntryMvoEventId;

    InventoryItemRequirementEntryMvoEventId getStateEventId() {
        if (inventoryItemRequirementEntryMvoEventId == null) { inventoryItemRequirementEntryMvoEventId = new InventoryItemRequirementEntryMvoEventId(); }
        return inventoryItemRequirementEntryMvoEventId;
    }

    void setInventoryItemRequirementEntryMvoEventId(InventoryItemRequirementEntryMvoEventId eventId) {
        this.inventoryItemRequirementEntryMvoEventId = eventId;
    }

    public InventoryItemRequirementEntryId getInventoryItemRequirementEntryId() {
        return getStateEventId().getInventoryItemRequirementEntryId();
    }

    public void setInventoryItemRequirementEntryId(InventoryItemRequirementEntryId inventoryItemRequirementEntryId) {
        getStateEventId().setInventoryItemRequirementEntryId(inventoryItemRequirementEntryId);
    }

    public Long getInventoryItemRequirementVersion() {
        return getStateEventId().getInventoryItemRequirementVersion();
    }
    
    public void getInventoryItemRequirementVersion(Long inventoryItemRequirementVersion) {
        getStateEventId().setInventoryItemRequirementVersion(inventoryItemRequirementVersion);
    }

    private BigDecimal quantity;

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    private InventoryPRTriggeredId sourceEventId;

    public InventoryPRTriggeredId getSourceEventId() {
        return this.sourceEventId;
    }

    public void setSourceEventId(InventoryPRTriggeredId sourceEventId) {
        this.sourceEventId = sourceEventId;
    }

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private BigDecimal inventoryItemRequirementQuantity;

    public BigDecimal getInventoryItemRequirementQuantity() {
        return this.inventoryItemRequirementQuantity;
    }

    public void setInventoryItemRequirementQuantity(BigDecimal inventoryItemRequirementQuantity) {
        this.inventoryItemRequirementQuantity = inventoryItemRequirementQuantity;
    }

    private String inventoryItemRequirementCreatedBy;

    public String getInventoryItemRequirementCreatedBy() {
        return this.inventoryItemRequirementCreatedBy;
    }

    public void setInventoryItemRequirementCreatedBy(String inventoryItemRequirementCreatedBy) {
        this.inventoryItemRequirementCreatedBy = inventoryItemRequirementCreatedBy;
    }

    private Date inventoryItemRequirementCreatedAt;

    public Date getInventoryItemRequirementCreatedAt() {
        return this.inventoryItemRequirementCreatedAt;
    }

    public void setInventoryItemRequirementCreatedAt(Date inventoryItemRequirementCreatedAt) {
        this.inventoryItemRequirementCreatedAt = inventoryItemRequirementCreatedAt;
    }

    private String inventoryItemRequirementUpdatedBy;

    public String getInventoryItemRequirementUpdatedBy() {
        return this.inventoryItemRequirementUpdatedBy;
    }

    public void setInventoryItemRequirementUpdatedBy(String inventoryItemRequirementUpdatedBy) {
        this.inventoryItemRequirementUpdatedBy = inventoryItemRequirementUpdatedBy;
    }

    private Date inventoryItemRequirementUpdatedAt;

    public Date getInventoryItemRequirementUpdatedAt() {
        return this.inventoryItemRequirementUpdatedAt;
    }

    public void setInventoryItemRequirementUpdatedAt(Date inventoryItemRequirementUpdatedAt) {
        this.inventoryItemRequirementUpdatedAt = inventoryItemRequirementUpdatedAt;
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

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved() {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed) {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertySourceEventIdRemoved;

    public Boolean getIsPropertySourceEventIdRemoved() {
        return this.isPropertySourceEventIdRemoved;
    }

    public void setIsPropertySourceEventIdRemoved(Boolean removed) {
        this.isPropertySourceEventIdRemoved = removed;
    }

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved() {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed) {
        this.isPropertyVersionRemoved = removed;
    }

    private Boolean isPropertyInventoryItemRequirementQuantityRemoved;

    public Boolean getIsPropertyInventoryItemRequirementQuantityRemoved() {
        return this.isPropertyInventoryItemRequirementQuantityRemoved;
    }

    public void setIsPropertyInventoryItemRequirementQuantityRemoved(Boolean removed) {
        this.isPropertyInventoryItemRequirementQuantityRemoved = removed;
    }

    private Boolean isPropertyInventoryItemRequirementCreatedByRemoved;

    public Boolean getIsPropertyInventoryItemRequirementCreatedByRemoved() {
        return this.isPropertyInventoryItemRequirementCreatedByRemoved;
    }

    public void setIsPropertyInventoryItemRequirementCreatedByRemoved(Boolean removed) {
        this.isPropertyInventoryItemRequirementCreatedByRemoved = removed;
    }

    private Boolean isPropertyInventoryItemRequirementCreatedAtRemoved;

    public Boolean getIsPropertyInventoryItemRequirementCreatedAtRemoved() {
        return this.isPropertyInventoryItemRequirementCreatedAtRemoved;
    }

    public void setIsPropertyInventoryItemRequirementCreatedAtRemoved(Boolean removed) {
        this.isPropertyInventoryItemRequirementCreatedAtRemoved = removed;
    }

    private Boolean isPropertyInventoryItemRequirementUpdatedByRemoved;

    public Boolean getIsPropertyInventoryItemRequirementUpdatedByRemoved() {
        return this.isPropertyInventoryItemRequirementUpdatedByRemoved;
    }

    public void setIsPropertyInventoryItemRequirementUpdatedByRemoved(Boolean removed) {
        this.isPropertyInventoryItemRequirementUpdatedByRemoved = removed;
    }

    private Boolean isPropertyInventoryItemRequirementUpdatedAtRemoved;

    public Boolean getIsPropertyInventoryItemRequirementUpdatedAtRemoved() {
        return this.isPropertyInventoryItemRequirementUpdatedAtRemoved;
    }

    public void setIsPropertyInventoryItemRequirementUpdatedAtRemoved(Boolean removed) {
        this.isPropertyInventoryItemRequirementUpdatedAtRemoved = removed;
    }


	public static class InventoryItemRequirementEntryMvoStateCreatedDto extends InventoryItemRequirementEntryMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class InventoryItemRequirementEntryMvoStateMergePatchedDto extends InventoryItemRequirementEntryMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class InventoryItemRequirementEntryMvoStateDeletedDto extends InventoryItemRequirementEntryMvoStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

