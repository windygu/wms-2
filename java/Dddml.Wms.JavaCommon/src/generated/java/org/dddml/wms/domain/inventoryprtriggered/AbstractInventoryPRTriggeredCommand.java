package org.dddml.wms.domain.inventoryprtriggered;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInventoryPRTriggeredCommand extends AbstractCommand implements InventoryPRTriggeredCommand
{
    private InventoryPRTriggeredId inventoryPRTriggeredId;

    public InventoryPRTriggeredId getInventoryPRTriggeredId()
    {
        return this.inventoryPRTriggeredId;
    }

    public void setInventoryPRTriggeredId(InventoryPRTriggeredId inventoryPRTriggeredId)
    {
        this.inventoryPRTriggeredId = inventoryPRTriggeredId;
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


    public static abstract class AbstractCreateOrMergePatchInventoryPRTriggered extends AbstractInventoryPRTriggeredCommand implements CreateOrMergePatchInventoryPRTriggered
    {
        private Boolean isProcessed;

        public Boolean getIsProcessed()
        {
            return this.isProcessed;
        }

        public void setIsProcessed(Boolean isProcessed)
        {
            this.isProcessed = isProcessed;
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

    public static abstract class AbstractCreateInventoryPRTriggered extends AbstractCreateOrMergePatchInventoryPRTriggered implements CreateInventoryPRTriggered
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchInventoryPRTriggered extends AbstractCreateOrMergePatchInventoryPRTriggered implements MergePatchInventoryPRTriggered
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyIsProcessedRemoved;

        public Boolean getIsPropertyIsProcessedRemoved()
        {
            return this.isPropertyIsProcessedRemoved;
        }

        public void setIsPropertyIsProcessedRemoved(Boolean removed)
        {
            this.isPropertyIsProcessedRemoved = removed;
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

    public static class SimpleCreateInventoryPRTriggered extends AbstractCreateInventoryPRTriggered
    {
    }

    
    public static class SimpleMergePatchInventoryPRTriggered extends AbstractMergePatchInventoryPRTriggered
    {
    }

    
	public static class SimpleDeleteInventoryPRTriggered extends AbstractInventoryPRTriggeredCommand implements DeleteInventoryPRTriggered
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

