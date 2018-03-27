package org.dddml.wms.domain.shipmentmethodtype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentMethodTypeCommandDto extends AbstractCommand
{
    private String shipmentMethodTypeId;

    public String getShipmentMethodTypeId()
    {
        return this.shipmentMethodTypeId;
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId)
    {
        this.shipmentMethodTypeId = shipmentMethodTypeId;
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


    public void copyTo(AbstractShipmentMethodTypeCommand command)
    {
        command.setShipmentMethodTypeId(this.getShipmentMethodTypeId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
