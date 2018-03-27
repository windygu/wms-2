package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPicklistItemCommand extends AbstractCommand implements PicklistItemCommand
{
    private PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId;

    public PicklistItemOrderShipGrpInvId getPicklistItemOrderShipGrpInvId()
    {
        return this.picklistItemOrderShipGrpInvId;
    }

    public void setPicklistItemOrderShipGrpInvId(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId)
    {
        this.picklistItemOrderShipGrpInvId = picklistItemOrderShipGrpInvId;
    }

    private String picklistBinId;

    public String getPicklistBinId()
    {
        return this.picklistBinId;
    }

    public void setPicklistBinId(String picklistBinId)
    {
        this.picklistBinId = picklistBinId;
    }


    public static abstract class AbstractCreateOrMergePatchPicklistItem extends AbstractPicklistItemCommand implements CreateOrMergePatchPicklistItem
    {
        private String itemStatusId;

        public String getItemStatusId()
        {
            return this.itemStatusId;
        }

        public void setItemStatusId(String itemStatusId)
        {
            this.itemStatusId = itemStatusId;
        }

        private java.math.BigDecimal quantity;

        public java.math.BigDecimal getQuantity()
        {
            return this.quantity;
        }

        public void setQuantity(java.math.BigDecimal quantity)
        {
            this.quantity = quantity;
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

    }

    public static abstract class AbstractCreatePicklistItem extends AbstractCreateOrMergePatchPicklistItem implements CreatePicklistItem
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchPicklistItem extends AbstractCreateOrMergePatchPicklistItem implements MergePatchPicklistItem
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
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

    }

    public static class SimpleCreatePicklistItem extends AbstractCreatePicklistItem
    {
    }

    
    public static class SimpleMergePatchPicklistItem extends AbstractMergePatchPicklistItem
    {
    }

    
	public static class SimpleRemovePicklistItem extends AbstractPicklistItemCommand implements RemovePicklistItem
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_REMOVE;
        }
	}

    

}

