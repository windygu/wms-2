package org.dddml.wms.domain.supplierproduct;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class SupplierProductStateEventDtoConverter {

    public SupplierProductStateEventDto toSupplierProductStateEventDto(AbstractSupplierProductStateEvent stateEvent) {
        if (stateEvent instanceof AbstractSupplierProductStateEvent.AbstractSupplierProductStateCreated) {
            SupplierProductStateEvent.SupplierProductStateCreated e = (SupplierProductStateEvent.SupplierProductStateCreated) stateEvent;
            return toSupplierProductStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractSupplierProductStateEvent.AbstractSupplierProductStateMergePatched) {
            SupplierProductStateEvent.SupplierProductStateMergePatched e = (SupplierProductStateEvent.SupplierProductStateMergePatched) stateEvent;
            return toSupplierProductStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public SupplierProductStateEventDto.SupplierProductStateCreatedDto toSupplierProductStateCreatedDto(SupplierProductStateEvent.SupplierProductStateCreated e) {
        SupplierProductStateEventDto.SupplierProductStateCreatedDto dto = new SupplierProductStateEventDto.SupplierProductStateCreatedDto();
        dto.setSupplierProductEventId(e.getSupplierProductEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setAvailableThruDate(e.getAvailableThruDate());
        dto.setSupplierPrefOrderId(e.getSupplierPrefOrderId());
        dto.setSupplierRatingTypeId(e.getSupplierRatingTypeId());
        dto.setStandardLeadTimeDays(e.getStandardLeadTimeDays());
        dto.setManufacturingLeadTimeDays(e.getManufacturingLeadTimeDays());
        dto.setDeliveryLeadTimeDays(e.getDeliveryLeadTimeDays());
        dto.setQuantityUomId(e.getQuantityUomId());
        dto.setLastPrice(e.getLastPrice());
        dto.setShippingPrice(e.getShippingPrice());
        dto.setExternalProductName(e.getExternalProductName());
        dto.setExternalProductId(e.getExternalProductId());
        dto.setCanDropShip(e.getCanDropShip());
        dto.setComments(e.getComments());
        dto.setActive(e.getActive());
        return dto;
    }

    public SupplierProductStateEventDto.SupplierProductStateMergePatchedDto toSupplierProductStateMergePatchedDto(SupplierProductStateEvent.SupplierProductStateMergePatched e) {
        SupplierProductStateEventDto.SupplierProductStateMergePatchedDto dto = new SupplierProductStateEventDto.SupplierProductStateMergePatchedDto();
        dto.setSupplierProductEventId(e.getSupplierProductEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setAvailableThruDate(e.getAvailableThruDate());
        dto.setSupplierPrefOrderId(e.getSupplierPrefOrderId());
        dto.setSupplierRatingTypeId(e.getSupplierRatingTypeId());
        dto.setStandardLeadTimeDays(e.getStandardLeadTimeDays());
        dto.setManufacturingLeadTimeDays(e.getManufacturingLeadTimeDays());
        dto.setDeliveryLeadTimeDays(e.getDeliveryLeadTimeDays());
        dto.setQuantityUomId(e.getQuantityUomId());
        dto.setLastPrice(e.getLastPrice());
        dto.setShippingPrice(e.getShippingPrice());
        dto.setExternalProductName(e.getExternalProductName());
        dto.setExternalProductId(e.getExternalProductId());
        dto.setCanDropShip(e.getCanDropShip());
        dto.setComments(e.getComments());
        dto.setActive(e.getActive());
        dto.setIsPropertyAvailableThruDateRemoved(e.getIsPropertyAvailableThruDateRemoved());
        dto.setIsPropertySupplierPrefOrderIdRemoved(e.getIsPropertySupplierPrefOrderIdRemoved());
        dto.setIsPropertySupplierRatingTypeIdRemoved(e.getIsPropertySupplierRatingTypeIdRemoved());
        dto.setIsPropertyStandardLeadTimeDaysRemoved(e.getIsPropertyStandardLeadTimeDaysRemoved());
        dto.setIsPropertyManufacturingLeadTimeDaysRemoved(e.getIsPropertyManufacturingLeadTimeDaysRemoved());
        dto.setIsPropertyDeliveryLeadTimeDaysRemoved(e.getIsPropertyDeliveryLeadTimeDaysRemoved());
        dto.setIsPropertyQuantityUomIdRemoved(e.getIsPropertyQuantityUomIdRemoved());
        dto.setIsPropertyLastPriceRemoved(e.getIsPropertyLastPriceRemoved());
        dto.setIsPropertyShippingPriceRemoved(e.getIsPropertyShippingPriceRemoved());
        dto.setIsPropertyExternalProductNameRemoved(e.getIsPropertyExternalProductNameRemoved());
        dto.setIsPropertyExternalProductIdRemoved(e.getIsPropertyExternalProductIdRemoved());
        dto.setIsPropertyCanDropShipRemoved(e.getIsPropertyCanDropShipRemoved());
        dto.setIsPropertyCommentsRemoved(e.getIsPropertyCommentsRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


}

