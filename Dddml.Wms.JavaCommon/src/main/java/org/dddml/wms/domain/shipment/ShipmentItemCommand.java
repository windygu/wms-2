package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ShipmentItemCommand extends Command
{
    String getShipmentItemSeqId();

    void setShipmentItemSeqId(String shipmentItemSeqId);

    String getShipmentId();

    void setShipmentId(String shipmentId);

    interface CreateOrMergePatchShipmentItem extends ShipmentItemCommand
    {
        String getProductId();

        void setProductId(String productId);

        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        String getShipmentContentDescription();

        void setShipmentContentDescription(String shipmentContentDescription);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateShipmentItem extends CreateOrMergePatchShipmentItem
    {
    }

    interface MergePatchShipmentItem extends CreateOrMergePatchShipmentItem
    {
        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyShipmentContentDescriptionRemoved();

        void setIsPropertyShipmentContentDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveShipmentItem extends ShipmentItemCommand
	{
	}

}

