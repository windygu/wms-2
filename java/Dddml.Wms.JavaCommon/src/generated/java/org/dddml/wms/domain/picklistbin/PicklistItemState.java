package org.dddml.wms.domain.picklistbin;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.picklistbin.PicklistItemStateEvent.*;

public interface PicklistItemState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    PicklistBinPicklistItemId getPicklistBinPicklistItemId();

    void setPicklistBinPicklistItemId(PicklistBinPicklistItemId picklistBinPicklistItemId);

    PicklistItemOrderShipGrpInvId getPicklistItemOrderShipGrpInvId();

    void setPicklistItemOrderShipGrpInvId(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

    String getItemStatusId();

    void setItemStatusId(String itemStatusId);

    java.math.BigDecimal getQuantity();

    void setQuantity(java.math.BigDecimal quantity);

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

    String getPicklistBinId();

    void setPicklistBinId(String picklistBinId);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(PicklistItemStateEvent.PicklistItemStateCreated e);

    void when(PicklistItemStateEvent.PicklistItemStateMergePatched e);

    void when(PicklistItemStateEvent.PicklistItemStateRemoved e);
    
}

