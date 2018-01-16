package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InOutLineStateEventDtoConverter {

    public InOutLineStateEventDto toInOutLineStateEventDto(AbstractInOutLineStateEvent stateEvent) {
        if (stateEvent instanceof AbstractInOutLineStateEvent.AbstractInOutLineStateCreated) {
            InOutLineStateEvent.InOutLineStateCreated e = (InOutLineStateEvent.InOutLineStateCreated) stateEvent;
            return toInOutLineStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInOutLineStateEvent.AbstractInOutLineStateMergePatched) {
            InOutLineStateEvent.InOutLineStateMergePatched e = (InOutLineStateEvent.InOutLineStateMergePatched) stateEvent;
            return toInOutLineStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractInOutLineStateEvent.AbstractInOutLineStateRemoved) {
            InOutLineStateEvent.InOutLineStateRemoved e = (InOutLineStateEvent.InOutLineStateRemoved) stateEvent;
            return toInOutLineStateRemovedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public InOutLineStateEventDto.InOutLineStateCreatedDto toInOutLineStateCreatedDto(InOutLineStateEvent.InOutLineStateCreated e) {
        InOutLineStateEventDto.InOutLineStateCreatedDto dto = new InOutLineStateEventDto.InOutLineStateCreatedDto();
        dto.setStateEventId(new InOutLineStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setLocatorId(e.getLocatorId());
        dto.setProductId(e.getProductId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setDescription(e.getDescription());
        dto.setQuantityUomId(e.getQuantityUomId());
        dto.setMovementQuantity(e.getMovementQuantity());
        dto.setPickedQuantity(e.getPickedQuantity());
        dto.setIsInvoiced(e.getIsInvoiced());
        dto.setProcessed(e.getProcessed());
        dto.setRmaLineNumber(e.getRmaLineNumber());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setActive(e.getActive());
        return dto;
    }

    public InOutLineStateEventDto.InOutLineStateMergePatchedDto toInOutLineStateMergePatchedDto(InOutLineStateEvent.InOutLineStateMergePatched e) {
        InOutLineStateEventDto.InOutLineStateMergePatchedDto dto = new InOutLineStateEventDto.InOutLineStateMergePatchedDto();
        dto.setStateEventId(new InOutLineStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        dto.setLocatorId(e.getLocatorId());
        dto.setProductId(e.getProductId());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setDescription(e.getDescription());
        dto.setQuantityUomId(e.getQuantityUomId());
        dto.setMovementQuantity(e.getMovementQuantity());
        dto.setPickedQuantity(e.getPickedQuantity());
        dto.setIsInvoiced(e.getIsInvoiced());
        dto.setProcessed(e.getProcessed());
        dto.setRmaLineNumber(e.getRmaLineNumber());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setActive(e.getActive());
        dto.setIsPropertyLocatorIdRemoved(e.getIsPropertyLocatorIdRemoved());
        dto.setIsPropertyProductIdRemoved(e.getIsPropertyProductIdRemoved());
        dto.setIsPropertyAttributeSetInstanceIdRemoved(e.getIsPropertyAttributeSetInstanceIdRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyQuantityUomIdRemoved(e.getIsPropertyQuantityUomIdRemoved());
        dto.setIsPropertyMovementQuantityRemoved(e.getIsPropertyMovementQuantityRemoved());
        dto.setIsPropertyPickedQuantityRemoved(e.getIsPropertyPickedQuantityRemoved());
        dto.setIsPropertyIsInvoicedRemoved(e.getIsPropertyIsInvoicedRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyRmaLineNumberRemoved(e.getIsPropertyRmaLineNumberRemoved());
        dto.setIsPropertyReversalLineNumberRemoved(e.getIsPropertyReversalLineNumberRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public InOutLineStateEventDto.InOutLineStateRemovedDto toInOutLineStateRemovedDto(InOutLineStateEvent.InOutLineStateRemoved e) {
        InOutLineStateEventDto.InOutLineStateRemovedDto dto = new InOutLineStateEventDto.InOutLineStateRemovedDto();
        dto.setStateEventId(new InOutLineStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

