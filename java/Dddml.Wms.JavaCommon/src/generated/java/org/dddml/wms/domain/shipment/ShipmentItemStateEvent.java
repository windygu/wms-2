package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentItemStateEvent extends Event
{
    ShipmentItemEventId getShipmentItemEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    Long getVersion();

    void setVersion(Long version);

    String getProductId();

    void setProductId(String productId);

    String getAttributeSetInstanceId();

    void setAttributeSetInstanceId(String attributeSetInstanceId);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    String getShipmentContentDescription();

    void setShipmentContentDescription(String shipmentContentDescription);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface ShipmentItemStateCreated extends ShipmentItemStateEvent
    {
    
    }


    interface ShipmentItemStateMergePatched extends ShipmentItemStateEvent
    {
        Boolean getIsPropertyProductIdRemoved();

        void setIsPropertyProductIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyShipmentContentDescriptionRemoved();

        void setIsPropertyShipmentContentDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }


}

