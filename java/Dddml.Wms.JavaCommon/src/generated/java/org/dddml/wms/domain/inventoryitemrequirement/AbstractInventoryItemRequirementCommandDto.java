package org.dddml.wms.domain.inventoryitemrequirement;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInventoryItemRequirementCommandDto extends AbstractCommand
{
    /**
     * Inventory Item Requirement Id
     */
    private InventoryItemId inventoryItemRequirementId;

    public InventoryItemId getInventoryItemRequirementId()
    {
        return this.inventoryItemRequirementId;
    }

    public void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId)
    {
        this.inventoryItemRequirementId = inventoryItemRequirementId;
    }

    /**
     * Version
     */
    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    public void copyTo(AbstractInventoryItemRequirementCommand command)
    {
        command.setInventoryItemRequirementId(this.getInventoryItemRequirementId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
