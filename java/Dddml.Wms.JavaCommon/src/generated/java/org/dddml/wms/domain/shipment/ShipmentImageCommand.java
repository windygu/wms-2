package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ShipmentImageCommand extends Command
{
    String getSequenceId();

    void setSequenceId(String sequenceId);

    String getShipmentId();

    void setShipmentId(String shipmentId);

    interface CreateOrMergePatchShipmentImage extends ShipmentImageCommand
    {
        String getUrl();

        void setUrl(String url);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateShipmentImage extends CreateOrMergePatchShipmentImage
    {
    }

    interface MergePatchShipmentImage extends CreateOrMergePatchShipmentImage
    {
        Boolean getIsPropertyUrlRemoved();

        void setIsPropertyUrlRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveShipmentImage extends ShipmentImageCommand
	{
	}

}

