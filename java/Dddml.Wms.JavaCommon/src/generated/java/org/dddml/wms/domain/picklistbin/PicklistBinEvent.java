package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PicklistBinEvent extends Event
{
    PicklistBinEventId getPicklistBinEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getPicklistId();

    void setPicklistId(String picklistId);

    Long getBinLocationNumber();

    void setBinLocationNumber(Long binLocationNumber);

    String getPrimaryOrderId();

    void setPrimaryOrderId(String primaryOrderId);

    Long getPrimaryShipGroupSeqId();

    void setPrimaryShipGroupSeqId(Long primaryShipGroupSeqId);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface PicklistBinStateCreated extends PicklistBinEvent
    {
        Iterable<PicklistItemEvent.PicklistItemStateCreated> getPicklistItemEvents();
        
        void addPicklistItemEvent(PicklistItemEvent.PicklistItemStateCreated e);

        PicklistItemEvent.PicklistItemStateCreated newPicklistItemStateCreated(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

    
    }


    interface PicklistBinStateMergePatched extends PicklistBinEvent
    {
        Boolean getIsPropertyPicklistIdRemoved();

        void setIsPropertyPicklistIdRemoved(Boolean removed);

        Boolean getIsPropertyBinLocationNumberRemoved();

        void setIsPropertyBinLocationNumberRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryOrderIdRemoved();

        void setIsPropertyPrimaryOrderIdRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryShipGroupSeqIdRemoved();

        void setIsPropertyPrimaryShipGroupSeqIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Iterable<PicklistItemEvent> getPicklistItemEvents();
        
        void addPicklistItemEvent(PicklistItemEvent e);

        PicklistItemEvent.PicklistItemStateCreated newPicklistItemStateCreated(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

        PicklistItemEvent.PicklistItemStateMergePatched newPicklistItemStateMergePatched(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

        PicklistItemEvent.PicklistItemStateRemoved newPicklistItemStateRemoved(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);


    }

    interface PicklistBinStateDeleted extends PicklistBinEvent
    {
        Iterable<PicklistItemEvent.PicklistItemStateRemoved> getPicklistItemEvents();
        
        void addPicklistItemEvent(PicklistItemEvent.PicklistItemStateRemoved e);
        
        PicklistItemEvent.PicklistItemStateRemoved newPicklistItemStateRemoved(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

    }


}

