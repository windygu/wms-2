package org.dddml.wms.domain.picklist;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PicklistEvent extends Event
{
    PicklistEventId getPicklistEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface PicklistStateEvent extends PicklistEvent {
        String getDescription();

        void setDescription(String description);

        String getFacilityId();

        void setFacilityId(String facilityId);

        String getShipmentMethodTypeId();

        void setShipmentMethodTypeId(String shipmentMethodTypeId);

        String getStatusId();

        void setStatusId(String statusId);

        java.sql.Timestamp getPicklistDate();

        void setPicklistDate(java.sql.Timestamp picklistDate);

        Long getPickwaveId();

        void setPickwaveId(Long pickwaveId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface PicklistStateCreated extends PicklistStateEvent
    {
        Iterable<PicklistRoleEvent.PicklistRoleStateCreated> getPicklistRoleEvents();
        
        void addPicklistRoleEvent(PicklistRoleEvent.PicklistRoleStateCreated e);

        PicklistRoleEvent.PicklistRoleStateCreated newPicklistRoleStateCreated(PartyRoleId partyRoleId);

    
    }


    interface PicklistStateMergePatched extends PicklistStateEvent
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyFacilityIdRemoved();

        void setIsPropertyFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyShipmentMethodTypeIdRemoved();

        void setIsPropertyShipmentMethodTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyStatusIdRemoved();

        void setIsPropertyStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyPicklistDateRemoved();

        void setIsPropertyPicklistDateRemoved(Boolean removed);

        Boolean getIsPropertyPickwaveIdRemoved();

        void setIsPropertyPickwaveIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Iterable<PicklistRoleEvent> getPicklistRoleEvents();
        
        void addPicklistRoleEvent(PicklistRoleEvent e);

        PicklistRoleEvent.PicklistRoleStateCreated newPicklistRoleStateCreated(PartyRoleId partyRoleId);

        PicklistRoleEvent.PicklistRoleStateMergePatched newPicklistRoleStateMergePatched(PartyRoleId partyRoleId);

        PicklistRoleEvent.PicklistRoleStateRemoved newPicklistRoleStateRemoved(PartyRoleId partyRoleId);


    }

    interface PicklistStateDeleted extends PicklistStateEvent
    {
        Iterable<PicklistRoleEvent.PicklistRoleStateRemoved> getPicklistRoleEvents();
        
        void addPicklistRoleEvent(PicklistRoleEvent.PicklistRoleStateRemoved e);
        
        PicklistRoleEvent.PicklistRoleStateRemoved newPicklistRoleStateRemoved(PartyRoleId partyRoleId);

    }


}

