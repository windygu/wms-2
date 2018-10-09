package org.dddml.wms.domain.picklist;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.picklist.PicklistEvent.*;

public interface PicklistState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getPicklistId();

    String getDescription();

    String getFacilityId();

    String getShipmentMethodTypeId();

    String getStatusId();

    java.sql.Timestamp getPicklistDate();

    Long getPickwaveId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    EntityStateCollection<PartyRoleId, PicklistRoleState> getPicklistRoles();

    interface MutablePicklistState extends PicklistState {
        void setPicklistId(String picklistId);

        void setDescription(String description);

        void setFacilityId(String facilityId);

        void setShipmentMethodTypeId(String shipmentMethodTypeId);

        void setStatusId(String statusId);

        void setPicklistDate(java.sql.Timestamp picklistDate);

        void setPickwaveId(Long pickwaveId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(PicklistEvent.PicklistStateCreated e);

        void when(PicklistEvent.PicklistStateMergePatched e);

        void when(PicklistEvent.PicklistStateDeleted e);
    }

    interface SqlPicklistState extends MutablePicklistState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

