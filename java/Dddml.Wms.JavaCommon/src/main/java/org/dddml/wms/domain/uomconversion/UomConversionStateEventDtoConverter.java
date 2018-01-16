package org.dddml.wms.domain.uomconversion;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class UomConversionStateEventDtoConverter {

    public UomConversionStateEventDto toUomConversionStateEventDto(AbstractUomConversionStateEvent stateEvent) {
        if (stateEvent instanceof AbstractUomConversionStateEvent.AbstractUomConversionStateCreated) {
            UomConversionStateEvent.UomConversionStateCreated e = (UomConversionStateEvent.UomConversionStateCreated) stateEvent;
            return toUomConversionStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractUomConversionStateEvent.AbstractUomConversionStateMergePatched) {
            UomConversionStateEvent.UomConversionStateMergePatched e = (UomConversionStateEvent.UomConversionStateMergePatched) stateEvent;
            return toUomConversionStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractUomConversionStateEvent.AbstractUomConversionStateDeleted) {
            UomConversionStateEvent.UomConversionStateDeleted e = (UomConversionStateEvent.UomConversionStateDeleted) stateEvent;
            return toUomConversionStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public UomConversionStateEventDto.UomConversionStateCreatedDto toUomConversionStateCreatedDto(UomConversionStateEvent.UomConversionStateCreated e) {
        UomConversionStateEventDto.UomConversionStateCreatedDto dto = new UomConversionStateEventDto.UomConversionStateCreatedDto();
        dto.setStateEventId(new UomConversionStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setConversionFactor(e.getConversionFactor());
        dto.setCustomMethodId(e.getCustomMethodId());
        dto.setDecimalScale(e.getDecimalScale());
        dto.setRoundingMode(e.getRoundingMode());
        dto.setActive(e.getActive());
        return dto;
    }

    public UomConversionStateEventDto.UomConversionStateMergePatchedDto toUomConversionStateMergePatchedDto(UomConversionStateEvent.UomConversionStateMergePatched e) {
        UomConversionStateEventDto.UomConversionStateMergePatchedDto dto = new UomConversionStateEventDto.UomConversionStateMergePatchedDto();
        dto.setStateEventId(new UomConversionStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setConversionFactor(e.getConversionFactor());
        dto.setCustomMethodId(e.getCustomMethodId());
        dto.setDecimalScale(e.getDecimalScale());
        dto.setRoundingMode(e.getRoundingMode());
        dto.setActive(e.getActive());
        dto.setIsPropertyConversionFactorRemoved(e.getIsPropertyConversionFactorRemoved());
        dto.setIsPropertyCustomMethodIdRemoved(e.getIsPropertyCustomMethodIdRemoved());
        dto.setIsPropertyDecimalScaleRemoved(e.getIsPropertyDecimalScaleRemoved());
        dto.setIsPropertyRoundingModeRemoved(e.getIsPropertyRoundingModeRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public UomConversionStateEventDto.UomConversionStateDeletedDto toUomConversionStateDeletedDto(UomConversionStateEvent.UomConversionStateDeleted e) {
        UomConversionStateEventDto.UomConversionStateDeletedDto dto = new UomConversionStateEventDto.UomConversionStateDeletedDto();
        dto.setStateEventId(new UomConversionStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

