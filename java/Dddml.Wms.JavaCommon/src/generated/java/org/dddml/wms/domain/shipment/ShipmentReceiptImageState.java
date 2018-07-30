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

    ShipmentReceiptImageId getShipmentReceiptImageId();

    void setShipmentReceiptImageId(ShipmentReceiptImageId shipmentReceiptImageId);

    String getSequenceId();

    void setSequenceId(String sequenceId);

    String getUrl();

    void setUrl(String url);

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

    String getShipmentReceiptReceiptSeqId();

    void setShipmentReceiptReceiptSeqId(String shipmentReceiptReceiptSeqId);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(ShipmentReceiptImageEvent.ShipmentReceiptImageStateCreated e);

    void when(ShipmentReceiptImageEvent.ShipmentReceiptImageStateMergePatched e);

    void when(ShipmentReceiptImageEvent.ShipmentReceiptImageStateRemoved e);
    
}

