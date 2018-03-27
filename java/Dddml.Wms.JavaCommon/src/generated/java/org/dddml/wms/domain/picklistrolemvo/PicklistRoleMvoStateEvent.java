package org.dddml.wms.domain.picklistrolemvo;

import java.util.*;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface PicklistRoleMvoStateEvent extends Event
{
    PicklistRoleMvoEventId getPicklistRoleMvoEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    String getCreatedByUserLogin();

    void setCreatedByUserLogin(String createdByUserLogin);

    Long getVersion();

    void setVersion(Long version);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

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

    String getPicklistCreatedByUserLogin();

    void setPicklistCreatedByUserLogin(String picklistCreatedByUserLogin);

    String getPicklistLastModifiedByUserLogin();

    void setPicklistLastModifiedByUserLogin(String picklistLastModifiedByUserLogin);

    Long getPicklistPickwaveId();

    void setPicklistPickwaveId(Long picklistPickwaveId);

    Date getPicklistCreatedAt();

    void setPicklistCreatedAt(Date picklistCreatedAt);

    Date getPicklistUpdatedAt();

    void setPicklistUpdatedAt(Date picklistUpdatedAt);

    Boolean getPicklistActive();

    void setPicklistActive(Boolean picklistActive);

    Boolean getPicklistDeleted();

    void setPicklistDeleted(Boolean picklistDeleted);

    String getCommandId();

    void setCommandId(String commandId);

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

        Boolean getIsPropertyPicklistCreatedByUserLoginRemoved();

        void setIsPropertyPicklistCreatedByUserLoginRemoved(Boolean removed);

        Boolean getIsPropertyPicklistLastModifiedByUserLoginRemoved();

        void setIsPropertyPicklistLastModifiedByUserLoginRemoved(Boolean removed);

        Boolean getIsPropertyPicklistPickwaveIdRemoved();

        void setIsPropertyPicklistPickwaveIdRemoved(Boolean removed);

        Boolean getIsPropertyPicklistCreatedAtRemoved();

        void setIsPropertyPicklistCreatedAtRemoved(Boolean removed);

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

