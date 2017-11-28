package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInventoryItemEventTypeCommand extends AbstractCommand implements InventoryItemEventTypeCommand
{
    private String inventoryItemEventTypeId;

    public String getInventoryItemEventTypeId()
    {
        return this.inventoryItemEventTypeId;
    }

    public void setInventoryItemEventTypeId(String inventoryItemEventTypeId)
    {
        this.inventoryItemEventTypeId = inventoryItemEventTypeId;
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


    public static abstract class AbstractCreateOrMergePatchInventoryItemEventType extends AbstractInventoryItemEventTypeCommand implements CreateOrMergePatchInventoryItemEventType
    {
        private String description;

        public String getDescription()
        {
            return this.description;
        }

        public void setDescription(String description)
        {
            this.description = description;
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

    public static abstract class AbstractCreateInventoryItemEventType extends AbstractCreateOrMergePatchInventoryItemEventType implements CreateInventoryItemEventType
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchInventoryItemEventType extends AbstractCreateOrMergePatchInventoryItemEventType implements MergePatchInventoryItemEventType
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyDescriptionRemoved;

        public Boolean getIsPropertyDescriptionRemoved()
        {
            return this.isPropertyDescriptionRemoved;
        }

        public void setIsPropertyDescriptionRemoved(Boolean removed)
        {
            this.isPropertyDescriptionRemoved = removed;
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

    public static class SimpleCreateInventoryItemEventType extends AbstractCreateInventoryItemEventType
    {
    }

    
    public static class SimpleMergePatchInventoryItemEventType extends AbstractMergePatchInventoryItemEventType
    {
    }

    
	public static class SimpleDeleteInventoryItemEventType extends AbstractInventoryItemEventTypeCommand implements DeleteInventoryItemEventType
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_DELETE;
        }
	}

    

}

