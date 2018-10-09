package org.dddml.wms.domain.shipmentmethodtype;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.shipmentmethodtype.ShipmentMethodTypeEvent.*;

public interface ShipmentMethodTypeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getShipmentMethodTypeId();

    String getDescription();

    Long getSequenceNum();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableShipmentMethodTypeState extends ShipmentMethodTypeState {
        void setShipmentMethodTypeId(String shipmentMethodTypeId);

        void setDescription(String description);

        void setSequenceNum(Long sequenceNum);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(ShipmentMethodTypeEvent.ShipmentMethodTypeStateCreated e);

        void when(ShipmentMethodTypeEvent.ShipmentMethodTypeStateMergePatched e);

        void when(ShipmentMethodTypeEvent.ShipmentMethodTypeStateDeleted e);
    }

    interface SqlShipmentMethodTypeState extends MutableShipmentMethodTypeState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

