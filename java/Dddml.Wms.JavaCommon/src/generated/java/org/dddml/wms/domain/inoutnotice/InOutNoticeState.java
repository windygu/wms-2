package org.dddml.wms.domain.inoutnotice;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inoutnotice.InOutNoticeEvent.*;

public interface InOutNoticeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getInOutNoticeId();

    String getWarehouseId();

    String getInOutNoticeType();

    String getTelecomContactMechId();

    String getTrackingNumber();

    String getContactPartyId();

    String getVehiclePlateNumber();

    String getShippingInstructions();

    java.sql.Timestamp getEstimatedShipDate();

    java.sql.Timestamp getEstimatedDeliveryDate();

    Boolean getIsScheduleNeeded();

    String getStatusId();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableInOutNoticeState extends InOutNoticeState {
        void setInOutNoticeId(String inOutNoticeId);

        void setWarehouseId(String warehouseId);

        void setInOutNoticeType(String inOutNoticeType);

        void setTelecomContactMechId(String telecomContactMechId);

        void setTrackingNumber(String trackingNumber);

        void setContactPartyId(String contactPartyId);

        void setVehiclePlateNumber(String vehiclePlateNumber);

        void setShippingInstructions(String shippingInstructions);

        void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate);

        void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate);

        void setIsScheduleNeeded(Boolean isScheduleNeeded);

        void setStatusId(String statusId);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(InOutNoticeEvent.InOutNoticeStateCreated e);

        void when(InOutNoticeEvent.InOutNoticeStateMergePatched e);

        void when(InOutNoticeEvent.InOutNoticeStateDeleted e);
    }

    interface SqlInOutNoticeState extends MutableInOutNoticeState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

