package org.dddml.wms.domain.shipment;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.shipment.ShipmentItemEvent.*;

public interface ShipmentItemState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getShipmentItemSeqId();

    String getProductId();

    String getAttributeSetInstanceId();

    java.math.BigDecimal getQuantity();

    String getShipmentContentDescription();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    String getShipmentId();

    interface MutableShipmentItemState extends ShipmentItemState {
        void setShipmentItemId(ShipmentItemId shipmentItemId);

        void setShipmentItemSeqId(String shipmentItemSeqId);

        void setProductId(String productId);

        void setAttributeSetInstanceId(String attributeSetInstanceId);

        void setQuantity(java.math.BigDecimal quantity);

        void setShipmentContentDescription(String shipmentContentDescription);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setShipmentId(String shipmentId);


        void mutate(Event e);

        void when(ShipmentItemEvent.ShipmentItemStateCreated e);

        void when(ShipmentItemEvent.ShipmentItemStateMergePatched e);

    }

    interface SqlShipmentItemState extends MutableShipmentItemState {
        ShipmentItemId getShipmentItemId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

