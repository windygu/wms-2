package org.dddml.wms.domain.shipmenttype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentTypeCommandDto extends AbstractCommand
{
    private String shipmentTypeId;

    public String getShipmentTypeId()
    {
        return this.shipmentTypeId;
    }

    public void setShipmentTypeId(String shipmentTypeId)
    {
        this.shipmentTypeId = shipmentTypeId;
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


}
