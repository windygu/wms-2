package org.dddml.wms.domain.shipmentmethodtype;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.shipmentmethodtype.ShipmentMethodTypeStateEvent.*;

public interface ShipmentMethodTypeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getShipmentMethodTypeId();

    void setShipmentMethodTypeId(String shipmentMethodTypeId);

    String getDescription();

    void setDescription(String description);

    Long getSequenceNum();

    void setSequenceNum(Long sequenceNum);

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


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateCreated e);

    void when(ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateMergePatched e);

    void when(ShipmentMethodTypeStateEvent.ShipmentMethodTypeStateDeleted e);
    
}

