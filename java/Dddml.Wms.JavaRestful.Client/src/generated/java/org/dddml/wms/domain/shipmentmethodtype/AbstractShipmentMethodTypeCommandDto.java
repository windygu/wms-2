package org.dddml.wms.domain.shipmentmethodtype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentMethodTypeCommandDto extends AbstractCommand
{
    /**
     * Shipment Method Type Id
     */
    private String shipmentMethodTypeId;

    public String getShipmentMethodTypeId()
    {
        return this.shipmentMethodTypeId;
    }

    public void setShipmentMethodTypeId(String shipmentMethodTypeId)
    {
        this.shipmentMethodTypeId = shipmentMethodTypeId;
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


}
