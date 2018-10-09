package org.dddml.wms.domain.picklistbin;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.picklistbin.PicklistItemEvent.*;

public interface PicklistItemState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    PicklistItemOrderShipGrpInvId getPicklistItemOrderShipGrpInvId();

    String getItemStatusId();

    java.math.BigDecimal getQuantity();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getPicklistBinId();

    interface MutablePicklistItemState extends PicklistItemState {
        void setPicklistBinPicklistItemId(PicklistBinPicklistItemId picklistBinPicklistItemId);

        void setPicklistItemOrderShipGrpInvId(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

        void setItemStatusId(String itemStatusId);

        void setQuantity(java.math.BigDecimal quantity);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setPicklistBinId(String picklistBinId);


        void mutate(Event e);

        void when(PicklistItemEvent.PicklistItemStateCreated e);

        void when(PicklistItemEvent.PicklistItemStateMergePatched e);

        void when(PicklistItemEvent.PicklistItemStateRemoved e);
    }

    interface SqlPicklistItemState extends MutablePicklistItemState {
        PicklistBinPicklistItemId getPicklistBinPicklistItemId();

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

