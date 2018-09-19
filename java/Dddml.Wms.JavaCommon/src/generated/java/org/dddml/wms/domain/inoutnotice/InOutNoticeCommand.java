package org.dddml.wms.domain.inoutnotice;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface InOutNoticeCommand extends Command
{
    String getInOutNoticeId();

    void setInOutNoticeId(String inOutNoticeId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(InOutNoticeState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((InOutNoticeCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((InOutNoticeCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(InOutNoticeCommand c) {
        return ((c instanceof InOutNoticeCommand.CreateInOutNotice) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(InOutNoticeState.VERSION_NULL)));
    }

    interface CreateOrMergePatchInOutNotice extends InOutNoticeCommand
    {
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

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInOutNotice extends CreateOrMergePatchInOutNotice
    {
    }

    interface MergePatchInOutNotice extends CreateOrMergePatchInOutNotice
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

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteInOutNotice extends InOutNoticeCommand
	{
	}

}

