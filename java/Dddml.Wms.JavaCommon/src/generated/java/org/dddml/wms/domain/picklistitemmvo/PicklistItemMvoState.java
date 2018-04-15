package org.dddml.wms.domain.picklistitemmvo;

import java.util.Set;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.picklistitemmvo.PicklistItemMvoEvent.*;

public interface PicklistItemMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    PicklistBinPicklistItemId getPicklistBinPicklistItemId();

    void setPicklistBinPicklistItemId(PicklistBinPicklistItemId picklistBinPicklistItemId);

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

    String getPicklistBinPicklistId();

    void setPicklistBinPicklistId(String picklistBinPicklistId);

    Long getPicklistBinBinLocationNumber();

    void setPicklistBinBinLocationNumber(Long picklistBinBinLocationNumber);

    String getPicklistBinPrimaryOrderId();

    void setPicklistBinPrimaryOrderId(String picklistBinPrimaryOrderId);

    Long getPicklistBinPrimaryShipGroupSeqId();

    void setPicklistBinPrimaryShipGroupSeqId(Long picklistBinPrimaryShipGroupSeqId);

    Long getPicklistBinVersion();

    void setPicklistBinVersion(Long picklistBinVersion);

    String getPicklistBinCreatedBy();

    void setPicklistBinCreatedBy(String picklistBinCreatedBy);

    Date getPicklistBinCreatedAt();

    void setPicklistBinCreatedAt(Date picklistBinCreatedAt);

    String getPicklistBinUpdatedBy();

    void setPicklistBinUpdatedBy(String picklistBinUpdatedBy);

    Date getPicklistBinUpdatedAt();

    void setPicklistBinUpdatedAt(Date picklistBinUpdatedAt);

    Boolean getPicklistBinActive();

    void setPicklistBinActive(Boolean picklistBinActive);

    Boolean getPicklistBinDeleted();

    void setPicklistBinDeleted(Boolean picklistBinDeleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(PicklistItemMvoEvent.PicklistItemMvoStateCreated e);

    void when(PicklistItemMvoEvent.PicklistItemMvoStateMergePatched e);

    void when(PicklistItemMvoEvent.PicklistItemMvoStateDeleted e);
    
}

