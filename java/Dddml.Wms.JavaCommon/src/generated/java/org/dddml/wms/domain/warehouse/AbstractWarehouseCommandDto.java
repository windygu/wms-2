package org.dddml.wms.domain.warehouse;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractWarehouseCommandDto extends AbstractCommand
{
    /**
     * Warehouse Id
     */
    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
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


    public void copyTo(AbstractWarehouseCommand command)
    {
        command.setWarehouseId(this.getWarehouseId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
