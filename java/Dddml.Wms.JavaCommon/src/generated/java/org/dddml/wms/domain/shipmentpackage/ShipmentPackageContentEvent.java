package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentPackageContentEvent extends Event
{
    ShipmentPackageContentEventId getShipmentPackageContentEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface ShipmentPackageContentStateEvent extends ShipmentPackageContentEvent {
        Long getVersion();

        void setVersion(Long version);

        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        String getSubProductId();

        void setSubProductId(String subProductId);

        java.math.BigDecimal getSubProductQuantity();

        void setSubProductQuantity(java.math.BigDecimal subProductQuantity);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface ShipmentPackageContentStateCreated extends ShipmentPackageContentStateEvent
    {
    
    }


    interface ShipmentPackageContentStateMergePatched extends ShipmentPackageContentStateEvent
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

    interface ShipmentPackageContentStateRemoved extends ShipmentPackageContentStateEvent
    {
    }


}

