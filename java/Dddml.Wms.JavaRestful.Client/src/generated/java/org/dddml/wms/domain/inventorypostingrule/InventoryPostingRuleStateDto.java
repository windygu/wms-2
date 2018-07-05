package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class InventoryPostingRuleStateDto
{

    private String inventoryPostingRuleId;

    public String getInventoryPostingRuleId()
    {
        return this.inventoryPostingRuleId;
    }

    public void setInventoryPostingRuleId(String inventoryPostingRuleId)
    {
        this.inventoryPostingRuleId = inventoryPostingRuleId;
    }

    private InventoryItemId triggerInventoryItemId;

    public InventoryItemId getTriggerInventoryItemId()
    {
        return this.triggerInventoryItemId;
    }

    public void setTriggerInventoryItemId(InventoryItemId triggerInventoryItemId)
    {
        this.triggerInventoryItemId = triggerInventoryItemId;
    }

    private InventoryItemId outputInventoryItemId;

    public InventoryItemId getOutputInventoryItemId()
    {
        return this.outputInventoryItemId;
    }

    public void setOutputInventoryItemId(InventoryItemId outputInventoryItemId)
    {
        this.outputInventoryItemId = outputInventoryItemId;
    }

    private String triggerAccountName;

    public String getTriggerAccountName()
    {
        return this.triggerAccountName;
    }

    public void setTriggerAccountName(String triggerAccountName)
    {
        this.triggerAccountName = triggerAccountName;
    }

    private String outputAccountName;

    public String getOutputAccountName()
    {
        return this.outputAccountName;
    }

    public void setOutputAccountName(String outputAccountName)
    {
        this.outputAccountName = outputAccountName;
    }

    private Boolean isOutputNegated;

    public Boolean getIsOutputNegated()
    {
        return this.isOutputNegated;
    }

    public void setIsOutputNegated(Boolean isOutputNegated)
    {
        this.isOutputNegated = isOutputNegated;
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

}

