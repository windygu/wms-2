package org.dddml.wms.domain.picklistrolemvo;

import java.util.*;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PicklistRoleMvoEvent extends Event
{
    PicklistRoleMvoEventId getPicklistRoleMvoEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedByUserLogin();

    void setCreatedByUserLogin(String createdByUserLogin);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface PicklistRoleMvoStateEvent extends PicklistRoleMvoEvent {
        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getPicklistDescription();

        void setPicklistDescription(String picklistDescription);

        String getPicklistFacilityId();

        void setPicklistFacilityId(String picklistFacilityId);

        String getPicklistShipmentMethodTypeId();

        void setPicklistShipmentMethodTypeId(String picklistShipmentMethodTypeId);

        String getPicklistStatusId();

        void setPicklistStatusId(String picklistStatusId);

        java.sql.Timestamp getPicklistPicklistDate();

        void setPicklistPicklistDate(java.sql.Timestamp picklistPicklistDate);

        Long getPicklistPickwaveId();

        void setPicklistPickwaveId(Long picklistPickwaveId);

        String getPicklistCreatedBy();

        void setPicklistCreatedBy(String picklistCreatedBy);

        Date getPicklistCreatedAt();

        void setPicklistCreatedAt(Date picklistCreatedAt);

        String getPicklistUpdatedBy();

        void setPicklistUpdatedBy(String picklistUpdatedBy);

        Date getPicklistUpdatedAt();

        void setPicklistUpdatedAt(Date picklistUpdatedAt);

        Boolean getPicklistActive();

        void setPicklistActive(Boolean picklistActive);

        Boolean getPicklistDeleted();

        void setPicklistDeleted(Boolean picklistDeleted);

    }

    interface PicklistRoleMvoStateCreated extends PicklistRoleMvoStateEvent
    {
    
    }


    interface PicklistRoleMvoStateMergePatched extends PicklistRoleMvoStateEvent
    {
        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyPicklistDescriptionRemoved();

        void setIsPropertyPicklistDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyPicklistFacilityIdRemoved();

        void setIsPropertyPicklistFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyPicklistShipmentMethodTypeIdRemoved();

        void setIsPropertyPicklistShipmentMethodTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyPicklistStatusIdRemoved();

        void setIsPropertyPicklistStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyPicklistPicklistDateRemoved();

        void setIsPropertyPicklistPicklistDateRemoved(Boolean removed);

        Boolean getIsPropertyPicklistPickwaveIdRemoved();

        void setIsPropertyPicklistPickwaveIdRemoved(Boolean removed);

        Boolean getIsPropertyPicklistCreatedByRemoved();

        void setIsPropertyPicklistCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyPicklistCreatedAtRemoved();

        void setIsPropertyPicklistCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyPicklistUpdatedByRemoved();

        void setIsPropertyPicklistUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyPicklistUpdatedAtRemoved();

        void setIsPropertyPicklistUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyPicklistActiveRemoved();

        void setIsPropertyPicklistActiveRemoved(Boolean removed);

        Boolean getIsPropertyPicklistDeletedRemoved();

        void setIsPropertyPicklistDeletedRemoved(Boolean removed);


    }

    interface PicklistRoleMvoStateDeleted extends PicklistRoleMvoStateEvent
    {
    }


}

