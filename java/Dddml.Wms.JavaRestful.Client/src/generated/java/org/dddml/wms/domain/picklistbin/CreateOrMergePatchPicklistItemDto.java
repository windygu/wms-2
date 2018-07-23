package org.dddml.wms.domain.picklistbin;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchPicklistItemDto extends AbstractPicklistItemCommandDto
{
    /**
     * Item Status Id
     */
    private String itemStatusId;

    public String getItemStatusId()
    {
        return this.itemStatusId;
    }

    public void setItemStatusId(String itemStatusId)
    {
        this.itemStatusId = itemStatusId;
    }

    /**
     * Quantity
     */
    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    /**
     * Active
     */
    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean isPropertyItemStatusIdRemoved;

    public Boolean getIsPropertyItemStatusIdRemoved()
    {
        return this.isPropertyItemStatusIdRemoved;
    }

    public void setIsPropertyItemStatusIdRemoved(Boolean removed)
    {
        this.isPropertyItemStatusIdRemoved = removed;
    }

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved()
    {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed)
    {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved()
    {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed)
    {
        this.isPropertyActiveRemoved = removed;
    }

    public static class CreatePicklistItemDto extends CreateOrMergePatchPicklistItemDto
    {
        public CreatePicklistItemDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static class MergePatchPicklistItemDto extends CreateOrMergePatchPicklistItemDto
    {
        public MergePatchPicklistItemDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

    }

}

