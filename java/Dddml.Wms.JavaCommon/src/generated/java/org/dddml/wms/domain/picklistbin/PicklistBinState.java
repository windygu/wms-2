package org.dddml.wms.domain.picklistbin;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.picklistbin.PicklistBinEvent.*;

public interface PicklistBinState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getPicklistBinId();

    String getPicklistId();

    Long getBinLocationNumber();

    String getPrimaryOrderId();

    String getPrimaryShipGroupSeqId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    EntityStateCollection<PicklistItemOrderShipGrpInvId, PicklistItemState> getPicklistItems();

    interface MutablePicklistBinState extends PicklistBinState {
        void setPicklistBinId(String picklistBinId);

        void setPicklistId(String picklistId);

        void setBinLocationNumber(Long binLocationNumber);

        void setPrimaryOrderId(String primaryOrderId);

        void setPrimaryShipGroupSeqId(String primaryShipGroupSeqId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(PicklistBinEvent.PicklistBinStateCreated e);

        void when(PicklistBinEvent.PicklistBinStateMergePatched e);

        void when(PicklistBinEvent.PicklistBinStateDeleted e);
    }

    interface SqlPicklistBinState extends MutablePicklistBinState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

