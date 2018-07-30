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

    ShipmentImageId getShipmentImageId();

    void setShipmentImageId(ShipmentImageId shipmentImageId);

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


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(ShipmentImageEvent.ShipmentImageStateCreated e);

    void when(ShipmentImageEvent.ShipmentImageStateMergePatched e);

    void when(ShipmentImageEvent.ShipmentImageStateRemoved e);
    
}

