package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ShipmentReceiptImageCommand extends Command
{
    String getSequenceId();

    void setSequenceId(String sequenceId);

    String getShipmentId();

    void setShipmentId(String shipmentId);

    String getShipmentReceiptReceiptSeqId();

    void setShipmentReceiptReceiptSeqId(String shipmentReceiptReceiptSeqId);

    interface CreateOrMergePatchShipmentReceiptImage extends ShipmentReceiptImageCommand
    {
        String getUrl();

        void setUrl(String url);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateShipmentReceiptImage extends CreateOrMergePatchShipmentReceiptImage
    {
    }

    interface MergePatchShipmentReceiptImage extends CreateOrMergePatchShipmentReceiptImage
    {
        Boolean getIsPropertyUrlRemoved();

        void setIsPropertyUrlRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveShipmentReceiptImage extends ShipmentReceiptImageCommand
	{
	}

}

