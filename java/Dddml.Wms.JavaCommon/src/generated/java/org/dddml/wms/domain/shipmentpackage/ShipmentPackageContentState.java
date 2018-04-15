package org.dddml.wms.domain.shipmentpackage;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.shipmentpackage.ShipmentPackageContentEvent.*;

public interface ShipmentPackageContentState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    ShipmentPackageContentId getShipmentPackageContentId();

    void setShipmentPackageContentId(ShipmentPackageContentId shipmentPackageContentId);

    String getShipmentItemSeqId();

    void setShipmentItemSeqId(String shipmentItemSeqId);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

    String getSubProductId();

    void setSubProductId(String subProductId);

    java.math.BigDecimal getSubProductQuantity();

    void setSubProductQuantity(java.math.BigDecimal subProductQuantity);

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

    ShipmentPackageId getShipmentPackageId();

    void setShipmentPackageId(ShipmentPackageId shipmentPackageId);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(ShipmentPackageContentEvent.ShipmentPackageContentStateCreated e);

    void when(ShipmentPackageContentEvent.ShipmentPackageContentStateMergePatched e);

    void when(ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved e);
    
}

