package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ShipmentReceiptCommand extends Command
{
    String getReceiptSeqId();

    void setReceiptSeqId(String receiptSeqId);

    String getShipmentId();

    void setShipmentId(String shipmentId);

    interface CreateOrMergePatchShipmentReceipt extends ShipmentReceiptCommand
    {
        String getProductId();

        void setProductId(String productId);

        String getShipmentItemSeqId();

        void setShipmentItemSeqId(String shipmentItemSeqId);

        String getRejectionReasonId();

        void setRejectionReasonId(String rejectionReasonId);

        String getDamageStatusId();

        void setDamageStatusId(String damageStatusId);

        String getDamageReasonId();

        void setDamageReasonId(String damageReasonId);

        String getItemDescription();

        void setItemDescription(String itemDescription);

        java.math.BigDecimal getAcceptedQuantity();

        void setAcceptedQuantity(java.math.BigDecimal acceptedQuantity);

        java.math.BigDecimal getRejectedQuantity();

        void setRejectedQuantity(java.math.BigDecimal rejectedQuantity);

        java.math.BigDecimal getDamagedQuantity();

        void setDamagedQuantity(java.math.BigDecimal damagedQuantity);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateShipmentReceipt extends CreateOrMergePatchShipmentReceipt
    {
    }

    interface MergePatchShipmentReceipt extends CreateOrMergePatchShipmentReceipt
    {
        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentItemSeqIdRemoved();

        void setIsPropertyShipmentItemSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyRejectionReasonIdRemoved();

        void setIsPropertyRejectionReasonIdRemoved(Boolean removed);

        Boolean getIsPropertyDamageStatusIdRemoved();

        void setIsPropertyDamageStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyDamageReasonIdRemoved();

        void setIsPropertyDamageReasonIdRemoved(Boolean removed);

        Boolean getIsPropertyItemDescriptionRemoved();

        void setIsPropertyItemDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyAcceptedQuantityRemoved();

        void setIsPropertyAcceptedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyRejectedQuantityRemoved();

        void setIsPropertyRejectedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyDamagedQuantityRemoved();

        void setIsPropertyDamagedQuantityRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveShipmentReceipt extends ShipmentReceiptCommand
	{
	}

}

