package org.dddml.wms.domain.inventorypostingrule;

import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class InventoryPostingRuleStateEventDto extends AbstractStateEvent
{

    private InventoryPostingRuleStateEventId stateEventId;

    InventoryPostingRuleStateEventId getStateEventId() {
        if (stateEventId == null) { stateEventId = new InventoryPostingRuleStateEventId(); }
        return this.stateEventId;
    }

    void setStateEventId(InventoryPostingRuleStateEventId stateEventId) {
        this.stateEventId = stateEventId;
    }

    public String getInventoryPostingRuleId() {
        return getStateEventId().getInventoryPostingRuleId();
    }

    public void setInventoryPostingRuleId(String inventoryPostingRuleId) {
        getStateEventId().setInventoryPostingRuleId(inventoryPostingRuleId);
    }

    public Long getVersion() {
        return getStateEventId().getVersion();
    }
    
    public void getVersion(Long version) {
        getStateEventId().setVersion(version);
    }

    private InventoryItemId triggerInventoryItemId;

    public InventoryItemId getTriggerInventoryItemId() {
        return this.triggerInventoryItemId;
    }

    public void setTriggerInventoryItemId(InventoryItemId triggerInventoryItemId) {
        this.triggerInventoryItemId = triggerInventoryItemId;
    }

    private InventoryItemId outputInventoryItemId;

    public InventoryItemId getOutputInventoryItemId() {
        return this.outputInventoryItemId;
    }

    public void setOutputInventoryItemId(InventoryItemId outputInventoryItemId) {
        this.outputInventoryItemId = outputInventoryItemId;
    }

    private String triggerAccountName;

    public String getTriggerAccountName() {
        return this.triggerAccountName;
    }

    public void setTriggerAccountName(String triggerAccountName) {
        this.triggerAccountName = triggerAccountName;
    }

    private String outputAccountName;

    public String getOutputAccountName() {
        return this.outputAccountName;
    }

    public void setOutputAccountName(String outputAccountName) {
        this.outputAccountName = outputAccountName;
    }

    private Boolean isOutputNegated;

    public Boolean getIsOutputNegated() {
        return this.isOutputNegated;
    }

    public void setIsOutputNegated(Boolean isOutputNegated) {
        this.isOutputNegated = isOutputNegated;
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

    private Boolean isPropertyTriggerInventoryItemIdRemoved;

    public Boolean getIsPropertyTriggerInventoryItemIdRemoved() {
        return this.isPropertyTriggerInventoryItemIdRemoved;
    }

    public void setIsPropertyTriggerInventoryItemIdRemoved(Boolean removed) {
        this.isPropertyTriggerInventoryItemIdRemoved = removed;
    }

    private Boolean isPropertyOutputInventoryItemIdRemoved;

    public Boolean getIsPropertyOutputInventoryItemIdRemoved() {
        return this.isPropertyOutputInventoryItemIdRemoved;
    }

    public void setIsPropertyOutputInventoryItemIdRemoved(Boolean removed) {
        this.isPropertyOutputInventoryItemIdRemoved = removed;
    }

    private Boolean isPropertyTriggerAccountNameRemoved;

    public Boolean getIsPropertyTriggerAccountNameRemoved() {
        return this.isPropertyTriggerAccountNameRemoved;
    }

    public void setIsPropertyTriggerAccountNameRemoved(Boolean removed) {
        this.isPropertyTriggerAccountNameRemoved = removed;
    }

    private Boolean isPropertyOutputAccountNameRemoved;

    public Boolean getIsPropertyOutputAccountNameRemoved() {
        return this.isPropertyOutputAccountNameRemoved;
    }

    public void setIsPropertyOutputAccountNameRemoved(Boolean removed) {
        this.isPropertyOutputAccountNameRemoved = removed;
    }

    private Boolean isPropertyIsOutputNegatedRemoved;

    public Boolean getIsPropertyIsOutputNegatedRemoved() {
        return this.isPropertyIsOutputNegatedRemoved;
    }

    public void setIsPropertyIsOutputNegatedRemoved(Boolean removed) {
        this.isPropertyIsOutputNegatedRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }


	public static class InventoryPostingRuleStateCreatedDto extends InventoryPostingRuleStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class InventoryPostingRuleStateMergePatchedDto extends InventoryPostingRuleStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class InventoryPostingRuleStateDeletedDto extends InventoryPostingRuleStateEventDto
	{
        @Override
        public String getStateEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

