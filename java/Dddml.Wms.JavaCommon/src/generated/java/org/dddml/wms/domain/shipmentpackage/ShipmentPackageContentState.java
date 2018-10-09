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

    String getShipmentItemSeqId();

    java.math.BigDecimal getQuantity();

    String getSubProductId();

    java.math.BigDecimal getSubProductQuantity();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    ShipmentPackageId getShipmentPackageId();

    interface MutableShipmentPackageContentState extends ShipmentPackageContentState {
        void setShipmentPackageContentId(ShipmentPackageContentId shipmentPackageContentId);

        void setShipmentItemSeqId(String shipmentItemSeqId);

        void setQuantity(java.math.BigDecimal quantity);

        void setSubProductId(String subProductId);

        void setSubProductQuantity(java.math.BigDecimal subProductQuantity);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setShipmentPackageId(ShipmentPackageId shipmentPackageId);


        void mutate(Event e);

        void when(ShipmentPackageContentEvent.ShipmentPackageContentStateCreated e);

        void when(ShipmentPackageContentEvent.ShipmentPackageContentStateMergePatched e);

        void when(ShipmentPackageContentEvent.ShipmentPackageContentStateRemoved e);
    }

    interface SqlShipmentPackageContentState extends MutableShipmentPackageContentState {
        ShipmentPackageContentId getShipmentPackageContentId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

