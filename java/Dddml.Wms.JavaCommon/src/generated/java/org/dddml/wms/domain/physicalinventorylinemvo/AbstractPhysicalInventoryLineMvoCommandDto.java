package org.dddml.wms.domain.physicalinventorylinemvo;

import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPhysicalInventoryLineMvoCommandDto extends AbstractCommand
{
    /**
     * Physical Inventory Line Id
     */
    private PhysicalInventoryLineId physicalInventoryLineId;

    public PhysicalInventoryLineId getPhysicalInventoryLineId()
    {
        return this.physicalInventoryLineId;
    }

    public void setPhysicalInventoryLineId(PhysicalInventoryLineId physicalInventoryLineId)
    {
        this.physicalInventoryLineId = physicalInventoryLineId;
    }

    /**
     * Physical Inventory Version
     */
    private Long physicalInventoryVersion;

    public Long getPhysicalInventoryVersion()
    {
        return this.physicalInventoryVersion;
    }

    public void setPhysicalInventoryVersion(Long physicalInventoryVersion)
    {
        this.physicalInventoryVersion = physicalInventoryVersion;
    }


    public void copyTo(AbstractPhysicalInventoryLineMvoCommand command)
    {
        command.setPhysicalInventoryLineId(this.getPhysicalInventoryLineId());
        command.setPhysicalInventoryVersion(this.getPhysicalInventoryVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
