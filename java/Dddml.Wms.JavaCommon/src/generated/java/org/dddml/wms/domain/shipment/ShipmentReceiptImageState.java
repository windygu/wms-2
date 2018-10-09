package org.dddml.wms.domain.shipment;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.shipment.ShipmentReceiptImageEvent.*;

public interface ShipmentReceiptImageState
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

    String getShipmentReceiptReceiptSeqId();

    interface MutableShipmentReceiptImageState extends ShipmentReceiptImageState {
        void setShipmentReceiptImageId(ShipmentReceiptImageId shipmentReceiptImageId);

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

        void setShipmentReceiptReceiptSeqId(String shipmentReceiptReceiptSeqId);


        void mutate(Event e);

        void when(ShipmentReceiptImageEvent.ShipmentReceiptImageStateCreated e);

        void when(ShipmentReceiptImageEvent.ShipmentReceiptImageStateMergePatched e);

        void when(ShipmentReceiptImageEvent.ShipmentReceiptImageStateRemoved e);
    }

    interface SqlShipmentReceiptImageState extends MutableShipmentReceiptImageState {
        ShipmentReceiptImageId getShipmentReceiptImageId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

