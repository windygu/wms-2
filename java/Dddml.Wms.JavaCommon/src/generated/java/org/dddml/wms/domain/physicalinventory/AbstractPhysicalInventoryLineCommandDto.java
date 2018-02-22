package org.dddml.wms.domain.physicalinventory;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPhysicalInventoryLineCommandDto extends AbstractCommand
{
    private InventoryItemIdDto inventoryItemId;

    public InventoryItemIdDto getInventoryItemId()
    {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemIdDto inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
    }


    public void copyTo(AbstractPhysicalInventoryLineCommand command)
    {
        command.setInventoryItemId((this.getInventoryItemId() == null) ? null : this.getInventoryItemId().toInventoryItemId());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
