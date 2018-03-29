package org.dddml.wms.domain.picklist;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.picklist.PicklistStateEvent.*;

public interface PicklistState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getPicklistId();

    void setPicklistId(String picklistId);

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


    boolean isStateUnsaved();

    boolean getForReapplying();

    PicklistRoleStates getPicklistRoles();


    void mutate(Event e);

    void when(PicklistStateEvent.PicklistStateCreated e);

    void when(PicklistStateEvent.PicklistStateMergePatched e);

    void when(PicklistStateEvent.PicklistStateDeleted e);
    
}

