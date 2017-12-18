package org.dddml.wms.domain.shipment;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.shipment.ShipmentItemStateEvent.*;

public interface ShipmentItemState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    ShipmentItemId getShipmentItemId();

    void setShipmentItemId(ShipmentItemId shipmentItemId);

    String getShipmentItemSeqId();

    void setShipmentItemSeqId(String shipmentItemSeqId);

    String getProductId();

    void setProductId(String productId);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    String getShipmentContentDescription();

    void setShipmentContentDescription(String shipmentContentDescription);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

    String getShipmentId();

    void setShipmentId(String shipmentId);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(ShipmentItemStateEvent.ShipmentItemStateCreated e);

    void when(ShipmentItemStateEvent.ShipmentItemStateMergePatched e);

    void when(ShipmentItemStateEvent.ShipmentItemStateRemoved e);
    
}

