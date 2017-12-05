package org.dddml.wms.domain.inventorypostingrule;

import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractStateEvent;

public class InventoryPostingRuleStateEventDto extends AbstractStateEvent
{

    private InventoryPostingRuleStateEventIdDto stateEventId;

    InventoryPostingRuleStateEventIdDto getStateEventId() {
        if (stateEventId == null) { stateEventId = new InventoryPostingRuleStateEventIdDto(); }
        return this.stateEventId;
    }

    void setStateEventId(InventoryPostingRuleStateEventIdDto stateEventId) {
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

    private InventoryItemIdDto trigger = new InventoryItemIdDto();

    public InventoryItemIdDto getTrigger() {
        return this.trigger;
    }

    public void setTrigger(InventoryItemIdDto trigger) {
        this.trigger = trigger;
    }

    private InventoryItemIdDto output = new InventoryItemIdDto();

    public InventoryItemIdDto getOutput() {
        return this.output;
    }

    public void setOutput(InventoryItemIdDto output) {
        this.output = output;
    }

    private String accountName;

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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

    private Boolean isPropertyTriggerRemoved;

    public Boolean getIsPropertyTriggerRemoved() {
        return this.isPropertyTriggerRemoved;
    }

    public void setIsPropertyTriggerRemoved(Boolean removed) {
        this.isPropertyTriggerRemoved = removed;
    }

    private Boolean isPropertyOutputRemoved;

    public Boolean getIsPropertyOutputRemoved() {
        return this.isPropertyOutputRemoved;
    }

    public void setIsPropertyOutputRemoved(Boolean removed) {
        this.isPropertyOutputRemoved = removed;
    }

    private Boolean isPropertyAccountNameRemoved;

    public Boolean getIsPropertyAccountNameRemoved() {
        return this.isPropertyAccountNameRemoved;
    }

    public void setIsPropertyAccountNameRemoved(Boolean removed) {
        this.isPropertyAccountNameRemoved = removed;
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

