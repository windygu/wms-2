package org.dddml.wms.domain.shipment;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.shipment.ShipmentImageEvent.*;

public interface ShipmentImageState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getSequenceId();

    String getUrl();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getShipmentId();

    interface MutableShipmentImageState extends ShipmentImageState {
        void setShipmentImageId(ShipmentImageId shipmentImageId);

        void setSequenceId(String sequenceId);

        void setUrl(String url);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setShipmentId(String shipmentId);


        void mutate(Event e);

        void when(ShipmentImageEvent.ShipmentImageStateCreated e);

        void when(ShipmentImageEvent.ShipmentImageStateMergePatched e);

        void when(ShipmentImageEvent.ShipmentImageStateRemoved e);
    }

    interface SqlShipmentImageState extends MutableShipmentImageState {
        ShipmentImageId getShipmentImageId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

