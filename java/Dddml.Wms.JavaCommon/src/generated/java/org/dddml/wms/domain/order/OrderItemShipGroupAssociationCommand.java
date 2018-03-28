package org.dddml.wms.domain.order;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface OrderItemShipGroupAssociationCommand extends Command
{
    String getOrderItemSeqId();

    void setOrderItemSeqId(String orderItemSeqId);

    String getOrderId();

    void setOrderId(String orderId);

    Long getOrderShipGroupShipGroupSeqId();

    void setOrderShipGroupShipGroupSeqId(Long orderShipGroupShipGroupSeqId);

    interface CreateOrMergePatchOrderItemShipGroupAssociation extends OrderItemShipGroupAssociationCommand
    {
        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        java.math.BigDecimal getCancelQuantity();

        void setCancelQuantity(java.math.BigDecimal cancelQuantity);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateOrderItemShipGroupAssociation extends CreateOrMergePatchOrderItemShipGroupAssociation
    {
    }

    interface MergePatchOrderItemShipGroupAssociation extends CreateOrMergePatchOrderItemShipGroupAssociation
    {
        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyCancelQuantityRemoved();

        void setIsPropertyCancelQuantityRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveOrderItemShipGroupAssociation extends OrderItemShipGroupAssociationCommand
	{
	}

}

