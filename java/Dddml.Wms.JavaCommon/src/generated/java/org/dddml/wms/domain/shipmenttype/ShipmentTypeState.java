package org.dddml.wms.domain.shipmenttype;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface ShipmentTypeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getShipmentTypeId();

    String getParentTypeId();

    String getHasTable();

    String getDescription();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    String getCommandId();

    interface MutableShipmentTypeState extends ShipmentTypeState {
        void setShipmentTypeId(String shipmentTypeId);

        void setParentTypeId(String parentTypeId);

        void setHasTable(String hasTable);

        void setDescription(String description);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setCommandId(String commandId);

    }

    interface SqlShipmentTypeState extends MutableShipmentTypeState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

