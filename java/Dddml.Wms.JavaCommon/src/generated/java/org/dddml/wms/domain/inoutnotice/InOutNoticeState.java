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

    void setInOutNoticeId(String inOutNoticeId);

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

    String getStatusId();

    void setStatusId(String statusId);

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


    void mutate(Event e);

    void when(InOutNoticeEvent.InOutNoticeStateCreated e);

    void when(InOutNoticeEvent.InOutNoticeStateMergePatched e);

    void when(InOutNoticeEvent.InOutNoticeStateDeleted e);
    
}

