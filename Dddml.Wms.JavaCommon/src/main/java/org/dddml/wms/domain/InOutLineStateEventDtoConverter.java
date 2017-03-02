package org.dddml.wms.domain;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InOutLineStateEventDtoConverter {

    public InOutLineStateEventDto toInOutLineStateEventDto(AbstractInOutLineStateEvent stateEvent) {
        if (StateEventType.CREATED.equals(stateEvent.getStateEventType())) {
            InOutLineStateEvent.InOutLineStateCreated e = (InOutLineStateEvent.InOutLineStateCreated) stateEvent;
            return toInOutLineStateCreatedDto(e);
        } else if (StateEventType.MERGE_PATCHED.equals(stateEvent.getStateEventType())) {
            InOutLineStateEvent.InOutLineStateMergePatched e = (InOutLineStateEvent.InOutLineStateMergePatched) stateEvent;
            return toInOutLineStateMergePatchedDto(e);
        } else if (StateEventType.REMOVED.equals(stateEvent.getStateEventType())) {
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
        dto.setLineNumber(e.getLineNumber());
        dto.setDescription(e.getDescription());
        dto.setLocatorId(e.getLocatorId());
        dto.setProduct(e.getProduct());
        dto.setUomId(e.getUomId());
        dto.setMovementQuantity(e.getMovementQuantity());
        dto.setConfirmedQuantity(e.getConfirmedQuantity());
        dto.setScrappedQuantity(e.getScrappedQuantity());
        dto.setTargetQuantity(e.getTargetQuantity());
        dto.setPickedQuantity(e.getPickedQuantity());
        dto.setIsInvoiced(e.getIsInvoiced());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setIsDescription(e.getIsDescription());
        dto.setProcessed(e.getProcessed());
        dto.setQuantityEntered(e.getQuantityEntered());
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
        dto.setLineNumber(e.getLineNumber());
        dto.setDescription(e.getDescription());
        dto.setLocatorId(e.getLocatorId());
        dto.setProduct(e.getProduct());
        dto.setUomId(e.getUomId());
        dto.setMovementQuantity(e.getMovementQuantity());
        dto.setConfirmedQuantity(e.getConfirmedQuantity());
        dto.setScrappedQuantity(e.getScrappedQuantity());
        dto.setTargetQuantity(e.getTargetQuantity());
        dto.setPickedQuantity(e.getPickedQuantity());
        dto.setIsInvoiced(e.getIsInvoiced());
        dto.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        dto.setIsDescription(e.getIsDescription());
        dto.setProcessed(e.getProcessed());
        dto.setQuantityEntered(e.getQuantityEntered());
        dto.setRmaLineNumber(e.getRmaLineNumber());
        dto.setReversalLineNumber(e.getReversalLineNumber());
        dto.setActive(e.getActive());
        dto.setIsPropertyLineNumberRemoved(e.getIsPropertyLineNumberRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyLocatorIdRemoved(e.getIsPropertyLocatorIdRemoved());
        dto.setIsPropertyProductRemoved(e.getIsPropertyProductRemoved());
        dto.setIsPropertyUomIdRemoved(e.getIsPropertyUomIdRemoved());
        dto.setIsPropertyMovementQuantityRemoved(e.getIsPropertyMovementQuantityRemoved());
        dto.setIsPropertyConfirmedQuantityRemoved(e.getIsPropertyConfirmedQuantityRemoved());
        dto.setIsPropertyScrappedQuantityRemoved(e.getIsPropertyScrappedQuantityRemoved());
        dto.setIsPropertyTargetQuantityRemoved(e.getIsPropertyTargetQuantityRemoved());
        dto.setIsPropertyPickedQuantityRemoved(e.getIsPropertyPickedQuantityRemoved());
        dto.setIsPropertyIsInvoicedRemoved(e.getIsPropertyIsInvoicedRemoved());
        dto.setIsPropertyAttributeSetInstanceIdRemoved(e.getIsPropertyAttributeSetInstanceIdRemoved());
        dto.setIsPropertyIsDescriptionRemoved(e.getIsPropertyIsDescriptionRemoved());
        dto.setIsPropertyProcessedRemoved(e.getIsPropertyProcessedRemoved());
        dto.setIsPropertyQuantityEnteredRemoved(e.getIsPropertyQuantityEnteredRemoved());
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

