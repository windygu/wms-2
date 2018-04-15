package org.dddml.wms.domain.picklistrolemvo;

import java.util.Set;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.picklistrolemvo.PicklistRoleMvoEvent.*;

public interface PicklistRoleMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    PicklistRoleId getPicklistRoleId();

    void setPicklistRoleId(PicklistRoleId picklistRoleId);

    String getCreatedByUserLogin();

    void setCreatedByUserLogin(String createdByUserLogin);

    String getLastModifiedByUserLogin();

    void setLastModifiedByUserLogin(String lastModifiedByUserLogin);

    Long getVersion();

    void setVersion(Long version);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

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

    Long getPicklistVersion();

    void setPicklistVersion(Long picklistVersion);

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


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(PicklistRoleMvoEvent.PicklistRoleMvoStateCreated e);

    void when(PicklistRoleMvoEvent.PicklistRoleMvoStateMergePatched e);

    void when(PicklistRoleMvoEvent.PicklistRoleMvoStateDeleted e);
    
}

