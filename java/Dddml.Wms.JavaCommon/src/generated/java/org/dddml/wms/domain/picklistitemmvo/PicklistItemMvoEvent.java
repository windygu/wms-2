package org.dddml.wms.domain.picklistitemmvo;

import java.util.*;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PicklistItemMvoEvent extends Event
{
    PicklistItemMvoEventId getPicklistItemMvoEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

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

    Boolean getActive();

    void setActive(Boolean active);

    String getPicklistBinPicklistId();

    void setPicklistBinPicklistId(String picklistBinPicklistId);

    Long getPicklistBinBinLocationNumber();

    void setPicklistBinBinLocationNumber(Long picklistBinBinLocationNumber);

    String getPicklistBinPrimaryOrderId();

    void setPicklistBinPrimaryOrderId(String picklistBinPrimaryOrderId);

    Long getPicklistBinPrimaryShipGroupSeqId();

    void setPicklistBinPrimaryShipGroupSeqId(Long picklistBinPrimaryShipGroupSeqId);

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

    String getCommandId();

    void setCommandId(String commandId);

    interface PicklistItemMvoStateCreated extends PicklistItemMvoEvent
    {
    
    }


    interface PicklistItemMvoStateMergePatched extends PicklistItemMvoEvent
    {
        Boolean getIsPropertyItemStatusIdRemoved();

        void setIsPropertyItemStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinPicklistIdRemoved();

        void setIsPropertyPicklistBinPicklistIdRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinBinLocationNumberRemoved();

        void setIsPropertyPicklistBinBinLocationNumberRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinPrimaryOrderIdRemoved();

        void setIsPropertyPicklistBinPrimaryOrderIdRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinPrimaryShipGroupSeqIdRemoved();

        void setIsPropertyPicklistBinPrimaryShipGroupSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinCreatedByRemoved();

        void setIsPropertyPicklistBinCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinCreatedAtRemoved();

        void setIsPropertyPicklistBinCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinUpdatedByRemoved();

        void setIsPropertyPicklistBinUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinUpdatedAtRemoved();

        void setIsPropertyPicklistBinUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinActiveRemoved();

        void setIsPropertyPicklistBinActiveRemoved(Boolean removed);

        Boolean getIsPropertyPicklistBinDeletedRemoved();

        void setIsPropertyPicklistBinDeletedRemoved(Boolean removed);


    }

    interface PicklistItemMvoStateDeleted extends PicklistItemMvoEvent
    {
    }


}

