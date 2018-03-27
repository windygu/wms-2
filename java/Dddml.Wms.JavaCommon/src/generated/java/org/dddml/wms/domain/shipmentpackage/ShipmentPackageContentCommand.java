package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ShipmentPackageContentCommand extends Command
{
    String getShipmentItemSeqId();

    void setShipmentItemSeqId(String shipmentItemSeqId);

    ShipmentPackageId getShipmentPackageId();

    void setShipmentPackageId(ShipmentPackageId shipmentPackageId);

    interface CreateOrMergePatchShipmentPackageContent extends ShipmentPackageContentCommand
    {
        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        String getSubProductId();

        void setSubProductId(String subProductId);

        java.math.BigDecimal getSubProductQuantity();

        void setSubProductQuantity(java.math.BigDecimal subProductQuantity);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateShipmentPackageContent extends CreateOrMergePatchShipmentPackageContent
    {
    }

    interface MergePatchShipmentPackageContent extends CreateOrMergePatchShipmentPackageContent
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertySubProductIdRemoved();

        void setIsPropertySubProductIdRemoved(Boolean removed);

        Boolean getIsPropertySubProductQuantityRemoved();

        void setIsPropertySubProductQuantityRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveShipmentPackageContent extends ShipmentPackageContentCommand
	{
	}

}

