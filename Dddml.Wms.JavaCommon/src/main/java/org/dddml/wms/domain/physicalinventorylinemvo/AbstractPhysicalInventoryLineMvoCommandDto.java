package org.dddml.wms.domain.physicalinventorylinemvo;

import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPhysicalInventoryLineMvoCommandDto extends AbstractCommand
{
    private PhysicalInventoryLineIdDto physicalInventoryLineId;

    public PhysicalInventoryLineIdDto getPhysicalInventoryLineId()
    {
        return this.physicalInventoryLineId;
    }

    public void setPhysicalInventoryLineId(PhysicalInventoryLineIdDto physicalInventoryLineId)
    {
        this.physicalInventoryLineId = physicalInventoryLineId;
    }

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
        command.setPhysicalInventoryLineId((this.getPhysicalInventoryLineId() == null) ? null : this.getPhysicalInventoryLineId().toPhysicalInventoryLineId());
        command.setPhysicalInventoryVersion(this.getPhysicalInventoryVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
