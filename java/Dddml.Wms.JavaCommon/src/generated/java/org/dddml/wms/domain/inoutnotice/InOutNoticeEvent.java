package org.dddml.wms.domain.inoutnotice;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InOutNoticeEvent extends Event {

    interface SqlInOutNoticeEvent extends InOutNoticeEvent {
        InOutNoticeEventId getInOutNoticeEventId();
    }

    String getInOutNoticeId();

    //void setInOutNoticeId(String inOutNoticeId);

    Long getVersion();
    
    //void getVersion(Long version);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InOutNoticeStateEvent extends InOutNoticeEvent {
        String getWarehouseId();

        void setWarehouseId(String warehouseId);

        String getInOutNoticeType();

        void setInOutNoticeType(String inOutNoticeType);

        String getTelecomContactMechId();

        void setTelecomContactMechId(String telecomContactMechId);

        String getTrackingNumber();

        void setTrackingNumber(String trackingNumber);

        String getContactPartyId();

        void setContactPartyId(String contactPartyId);

        String getVehiclePlateNumber();

        void setVehiclePlateNumber(String vehiclePlateNumber);

        String getShippingInstructions();

        void setShippingInstructions(String shippingInstructions);

        java.sql.Timestamp getEstimatedShipDate();

        void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate);

        java.sql.Timestamp getEstimatedDeliveryDate();

        void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate);

        Boolean getIsScheduleNeeded();

        void setIsScheduleNeeded(Boolean isScheduleNeeded);

        String getStatusId();

        void setStatusId(String statusId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface InOutNoticeStateCreated extends InOutNoticeStateEvent
    {
    
    }


    interface InOutNoticeStateMergePatched extends InOutNoticeStateEvent
    {
        Boolean getIsPropertyWarehouseIdRemoved();

        void setIsPropertyWarehouseIdRemoved(Boolean removed);

        Boolean getIsPropertyInOutNoticeTypeRemoved();

        void setIsPropertyInOutNoticeTypeRemoved(Boolean removed);

        Boolean getIsPropertyTelecomContactMechIdRemoved();

        void setIsPropertyTelecomContactMechIdRemoved(Boolean removed);

        Boolean getIsPropertyTrackingNumberRemoved();

        void setIsPropertyTrackingNumberRemoved(Boolean removed);

        Boolean getIsPropertyContactPartyIdRemoved();

        void setIsPropertyContactPartyIdRemoved(Boolean removed);

        Boolean getIsPropertyVehiclePlateNumberRemoved();

        void setIsPropertyVehiclePlateNumberRemoved(Boolean removed);

        Boolean getIsPropertyShippingInstructionsRemoved();

        void setIsPropertyShippingInstructionsRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedShipDateRemoved();

        void setIsPropertyEstimatedShipDateRemoved(Boolean removed);

        Boolean getIsPropertyEstimatedDeliveryDateRemoved();

        void setIsPropertyEstimatedDeliveryDateRemoved(Boolean removed);

        Boolean getIsPropertyIsScheduleNeededRemoved();

        void setIsPropertyIsScheduleNeededRemoved(Boolean removed);

        Boolean getIsPropertyStatusIdRemoved();

        void setIsPropertyStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);


    }

    interface InOutNoticeStateDeleted extends InOutNoticeStateEvent
    {
    }


}

