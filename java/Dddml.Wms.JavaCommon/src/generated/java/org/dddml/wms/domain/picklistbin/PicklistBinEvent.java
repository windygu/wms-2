package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PicklistBinEvent extends Event {

    interface SqlPicklistBinEvent extends PicklistBinEvent {
        PicklistBinEventId getPicklistBinEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    String getPicklistBinId();

    //void setPicklistBinId(String picklistBinId);

    Long getVersion();
    
    //void getVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface PicklistBinStateEvent extends PicklistBinEvent {
        String getPicklistId();

        void setPicklistId(String picklistId);

        Long getBinLocationNumber();

        void setBinLocationNumber(Long binLocationNumber);

        String getPrimaryOrderId();

        void setPrimaryOrderId(String primaryOrderId);

        String getPrimaryShipGroupSeqId();

        void setPrimaryShipGroupSeqId(String primaryShipGroupSeqId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface PicklistBinStateCreated extends PicklistBinStateEvent
    {
        Iterable<PicklistItemEvent.PicklistItemStateCreated> getPicklistItemEvents();
        
        void addPicklistItemEvent(PicklistItemEvent.PicklistItemStateCreated e);

        PicklistItemEvent.PicklistItemStateCreated newPicklistItemStateCreated(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

    
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

        Iterable<PicklistItemEvent> getPicklistItemEvents();
        
        void addPicklistItemEvent(PicklistItemEvent e);

        PicklistItemEvent.PicklistItemStateCreated newPicklistItemStateCreated(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

        PicklistItemEvent.PicklistItemStateMergePatched newPicklistItemStateMergePatched(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

        PicklistItemEvent.PicklistItemStateRemoved newPicklistItemStateRemoved(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);


    }

    interface PicklistBinStateDeleted extends PicklistBinStateEvent
    {
        Iterable<PicklistItemEvent.PicklistItemStateRemoved> getPicklistItemEvents();
        
        void addPicklistItemEvent(PicklistItemEvent.PicklistItemStateRemoved e);
        
        PicklistItemEvent.PicklistItemStateRemoved newPicklistItemStateRemoved(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

    }


}

