package org.dddml.wms.domain.inventoryprtriggered;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInventoryPRTriggeredCommandDto extends AbstractCommand
{
    private InventoryPRTriggeredIdDto inventoryPRTriggeredId;

    public InventoryPRTriggeredIdDto getInventoryPRTriggeredId()
    {
        return this.inventoryPRTriggeredId;
    }

    public void setInventoryPRTriggeredId(InventoryPRTriggeredIdDto inventoryPRTriggeredId)
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


    public void copyTo(AbstractInventoryPRTriggeredCommand command)
    {
        command.setInventoryPRTriggeredId((this.getInventoryPRTriggeredId() == null) ? null : this.getInventoryPRTriggeredId().toInventoryPRTriggeredId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
