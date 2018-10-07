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

    void setPicklistBinId(String picklistBinId);

    String getPicklistId();

    void setPicklistId(String picklistId);

    Long getBinLocationNumber();

    void setBinLocationNumber(Long binLocationNumber);

    String getPrimaryOrderId();

    void setPrimaryOrderId(String primaryOrderId);

    String getPrimaryShipGroupSeqId();

    void setPrimaryShipGroupSeqId(String primaryShipGroupSeqId);

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

    EntityStateCollection<PicklistItemOrderShipGrpInvId, PicklistItemState> getPicklistItems();


    void mutate(Event e);

    void when(PicklistBinEvent.PicklistBinStateCreated e);

    void when(PicklistBinEvent.PicklistBinStateMergePatched e);

    void when(PicklistBinEvent.PicklistBinStateDeleted e);
    
}

