package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ItemIssuanceCommand extends Command
{
    String getItemIssuanceSeqId();

    void setItemIssuanceSeqId(String itemIssuanceSeqId);

    String getShipmentId();

    void setShipmentId(String shipmentId);

    interface CreateOrMergePatchItemIssuance extends ItemIssuanceCommand
    {
        String getOrderId();

        void setOrderId(String orderId);

        String getOrderItemSeqId();

        void setOrderItemSeqId(String orderItemSeqId);

        Long getShipGroupSeqId();

        void setShipGroupSeqId(Long shipGroupSeqId);

        String getProductId();

        void setProductId(String productId);

        String getLocatorId();

        void setLocatorId(String locatorId);

        String getAttributeSetInstanceId();

        void setAttributeSetInstanceId(String attributeSetInstanceId);

        String getShipmentItemSeqId();

        void setShipmentItemSeqId(String shipmentItemSeqId);

        String getFixedAssetId();

        void setFixedAssetId(String fixedAssetId);

        String getMaintHistSeqId();

        void setMaintHistSeqId(String maintHistSeqId);

        java.sql.Timestamp getIssuedDateTime();

        void setIssuedDateTime(java.sql.Timestamp issuedDateTime);

        String getIssuedByUserLoginId();

        void setIssuedByUserLoginId(String issuedByUserLoginId);

        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        java.math.BigDecimal getCancelQuantity();

        void setCancelQuantity(java.math.BigDecimal cancelQuantity);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateItemIssuance extends CreateOrMergePatchItemIssuance
    {
    }

    interface MergePatchItemIssuance extends CreateOrMergePatchItemIssuance
    {
        Boolean getIsPropertyOrderIdRemoved();

        void setIsPropertyOrderIdRemoved(Boolean removed);

        Boolean getIsPropertyOrderItemSeqIdRemoved();

        void setIsPropertyOrderItemSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyShipGroupSeqIdRemoved();

        void setIsPropertyShipGroupSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyLocatorIdRemoved();

        void setIsPropertyLocatorIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentItemSeqIdRemoved();

        void setIsPropertyShipmentItemSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyFixedAssetIdRemoved();

        void setIsPropertyFixedAssetIdRemoved(Boolean removed);

        Boolean getIsPropertyMaintHistSeqIdRemoved();

        void setIsPropertyMaintHistSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyIssuedDateTimeRemoved();

        void setIsPropertyIssuedDateTimeRemoved(Boolean removed);

        Boolean getIsPropertyIssuedByUserLoginIdRemoved();

        void setIsPropertyIssuedByUserLoginIdRemoved(Boolean removed);

        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyCancelQuantityRemoved();

        void setIsPropertyCancelQuantityRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveItemIssuance extends ItemIssuanceCommand
	{
	}

}

