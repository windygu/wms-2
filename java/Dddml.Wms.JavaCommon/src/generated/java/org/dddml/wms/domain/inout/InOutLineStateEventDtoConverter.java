package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class InOutLineStateEventDtoConverter {

    public InOutLineStateEventDto toInOutLineStateEventDto(AbstractInOutLineEvent stateEvent) {
        if (stateEvent instanceof AbstractInOutLineEvent.AbstractInOutLineStateCreated) {
            InOutLineEvent.InOutLineStateCreated e = (InOutLineEvent.InOutLineStateCreated) stateEvent;
            return toInOutLineStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractInOutLineEvent.AbstractInOutLineStateMergePatched) {
            InOutLineEvent.InOutLineStateMergePatched e = (InOutLineEvent.InOutLineStateMergePatched) stateEvent;
            return toInOutLineStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractInOutLineEvent.AbstractInOutLineStateRemoved) {
            InOutLineEvent.InOutLineStateRemoved e = (InOutLineEvent.InOutLineStateRemoved) stateEvent;
            return toInOutLineStateRemovedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public InOutLineStateEventDto.InOutLineStateCreatedDto toInOutLineStateCreatedDto(InOutLineEvent.InOutLineStateCreated e) {
        InOutLineStateEventDto.InOutLineStateCreatedDto dto = new InOutLineStateEventDto.InOutLineStateCreatedDto();
        dto.setInOutLineEventId(e.getInOutLineEventId());
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
        List<InOutLineImageStateEventDto.InOutLineImageStateCreatedDto> inOutLineImageEvents = new ArrayList<>();
        for (InOutLineImageEvent.InOutLineImageStateCreated ee : e.getInOutLineImageEvents()) {
            InOutLineImageStateEventDto.InOutLineImageStateCreatedDto eeDto = getInOutLineImageStateEventDtoConverter().toInOutLineImageStateCreatedDto(ee);
            inOutLineImageEvents.add(eeDto);
        }
        dto.setInOutLineImageEvents(inOutLineImageEvents.toArray(new InOutLineImageStateEventDto.InOutLineImageStateCreatedDto[0]));

        return dto;
    }

    public InOutLineStateEventDto.InOutLineStateMergePatchedDto toInOutLineStateMergePatchedDto(InOutLineEvent.InOutLineStateMergePatched e) {
        InOutLineStateEventDto.InOutLineStateMergePatchedDto dto = new InOutLineStateEventDto.InOutLineStateMergePatchedDto();
        dto.setInOutLineEventId(e.getInOutLineEventId());
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
        List<InOutLineImageStateEventDto> inOutLineImageEvents = new ArrayList<>();
        for (InOutLineImageEvent ee : e.getInOutLineImageEvents()) {
            InOutLineImageStateEventDto eeDto = getInOutLineImageStateEventDtoConverter().toInOutLineImageStateEventDto((AbstractInOutLineImageEvent) ee);
            inOutLineImageEvents.add(eeDto);
        }
        dto.setInOutLineImageEvents(inOutLineImageEvents.toArray(new InOutLineImageStateEventDto[0]));

        return dto;
    }


    public InOutLineStateEventDto.InOutLineStateRemovedDto toInOutLineStateRemovedDto(InOutLineEvent.InOutLineStateRemoved e) {
        InOutLineStateEventDto.InOutLineStateRemovedDto dto = new InOutLineStateEventDto.InOutLineStateRemovedDto();
        dto.setInOutLineEventId(e.getInOutLineEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setVersion(e.getVersion());
        dto.setCommandId(e.getCommandId());
        List<InOutLineImageStateEventDto.InOutLineImageStateRemovedDto> inOutLineImageEvents = new ArrayList<>();
        for (InOutLineImageEvent.InOutLineImageStateRemoved ee : e.getInOutLineImageEvents()) {
            InOutLineImageStateEventDto.InOutLineImageStateRemovedDto eeDto = getInOutLineImageStateEventDtoConverter().toInOutLineImageStateRemovedDto(ee);
            inOutLineImageEvents.add(eeDto);
        }
        dto.setInOutLineImageEvents(inOutLineImageEvents.toArray(new InOutLineImageStateEventDto.InOutLineImageStateRemovedDto[0]));

        return dto;
    }

    protected InOutLineImageStateEventDtoConverter getInOutLineImageStateEventDtoConverter() {
        return new InOutLineImageStateEventDtoConverter();
    }

}

