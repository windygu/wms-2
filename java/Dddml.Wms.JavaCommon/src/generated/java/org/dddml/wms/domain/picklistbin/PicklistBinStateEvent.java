package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PicklistBinStateEvent extends Event
{
    PicklistBinEventId getPicklistBinEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

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

    interface PicklistBinStateCreated extends PicklistBinStateEvent
    {
        Iterable<PicklistItemStateEvent.PicklistItemStateCreated> getPicklistItemEvents();
        
        void addPicklistItemEvent(PicklistItemStateEvent.PicklistItemStateCreated e);

        PicklistItemStateEvent.PicklistItemStateCreated newPicklistItemStateCreated(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

    
    }


    interface PicklistBinStateMergePatched extends PicklistBinStateEvent
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

        Iterable<PicklistItemStateEvent> getPicklistItemEvents();
        
        void addPicklistItemEvent(PicklistItemStateEvent e);

        PicklistItemStateEvent.PicklistItemStateCreated newPicklistItemStateCreated(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

        PicklistItemStateEvent.PicklistItemStateMergePatched newPicklistItemStateMergePatched(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

        PicklistItemStateEvent.PicklistItemStateRemoved newPicklistItemStateRemoved(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);


    }

    interface PicklistBinStateDeleted extends PicklistBinStateEvent
    {
        Iterable<PicklistItemStateEvent.PicklistItemStateRemoved> getPicklistItemEvents();
        
        void addPicklistItemEvent(PicklistItemStateEvent.PicklistItemStateRemoved e);
        
        PicklistItemStateEvent.PicklistItemStateRemoved newPicklistItemStateRemoved(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

    }


}

