package org.dddml.wms.domain.uomconversion;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class UomConversionStateEventDtoConverter {

    public UomConversionStateEventDto toUomConversionStateEventDto(AbstractUomConversionEvent stateEvent) {
        if (stateEvent instanceof AbstractUomConversionEvent.AbstractUomConversionStateCreated) {
            UomConversionEvent.UomConversionStateCreated e = (UomConversionEvent.UomConversionStateCreated) stateEvent;
            return toUomConversionStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractUomConversionEvent.AbstractUomConversionStateMergePatched) {
            UomConversionEvent.UomConversionStateMergePatched e = (UomConversionEvent.UomConversionStateMergePatched) stateEvent;
            return toUomConversionStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractUomConversionEvent.AbstractUomConversionStateDeleted) {
            UomConversionEvent.UomConversionStateDeleted e = (UomConversionEvent.UomConversionStateDeleted) stateEvent;
            return toUomConversionStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public UomConversionStateEventDto.UomConversionStateCreatedDto toUomConversionStateCreatedDto(UomConversionEvent.UomConversionStateCreated e) {
        UomConversionStateEventDto.UomConversionStateCreatedDto dto = new UomConversionStateEventDto.UomConversionStateCreatedDto();
        dto.setUomConversionEventId(e.getUomConversionEventId());
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

    public UomConversionStateEventDto.UomConversionStateMergePatchedDto toUomConversionStateMergePatchedDto(UomConversionEvent.UomConversionStateMergePatched e) {
        UomConversionStateEventDto.UomConversionStateMergePatchedDto dto = new UomConversionStateEventDto.UomConversionStateMergePatchedDto();
        dto.setUomConversionEventId(e.getUomConversionEventId());
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


    public UomConversionStateEventDto.UomConversionStateDeletedDto toUomConversionStateDeletedDto(UomConversionEvent.UomConversionStateDeleted e) {
        UomConversionStateEventDto.UomConversionStateDeletedDto dto = new UomConversionStateEventDto.UomConversionStateDeletedDto();
        dto.setUomConversionEventId(e.getUomConversionEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

