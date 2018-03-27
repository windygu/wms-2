package org.dddml.wms.domain.shipmentpackage;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentPackageContentStateEvent extends Event
{
    ShipmentPackageContentEventId getShipmentPackageContentEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    Long getVersion();

    void setVersion(Long version);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    String getSubProductId();

    void setSubProductId(String subProductId);

    java.math.BigDecimal getSubProductQuantity();

    void setSubProductQuantity(java.math.BigDecimal subProductQuantity);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

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

