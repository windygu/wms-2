package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class SellableInventoryItemEntryMvoStateEventDtoConverter {

    public SellableInventoryItemEntryMvoStateEventDto toSellableInventoryItemEntryMvoStateEventDto(AbstractSellableInventoryItemEntryMvoEvent stateEvent) {
        if (stateEvent instanceof AbstractSellableInventoryItemEntryMvoEvent.AbstractSellableInventoryItemEntryMvoStateCreated) {
            SellableInventoryItemEntryMvoEvent.SellableInventoryItemEntryMvoStateCreated e = (SellableInventoryItemEntryMvoEvent.SellableInventoryItemEntryMvoStateCreated) stateEvent;
            return toSellableInventoryItemEntryMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractSellableInventoryItemEntryMvoEvent.AbstractSellableInventoryItemEntryMvoStateMergePatched) {
            SellableInventoryItemEntryMvoEvent.SellableInventoryItemEntryMvoStateMergePatched e = (SellableInventoryItemEntryMvoEvent.SellableInventoryItemEntryMvoStateMergePatched) stateEvent;
            return toSellableInventoryItemEntryMvoStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public SellableInventoryItemEntryMvoStateEventDto.SellableInventoryItemEntryMvoStateCreatedDto toSellableInventoryItemEntryMvoStateCreatedDto(SellableInventoryItemEntryMvoEvent.SellableInventoryItemEntryMvoStateCreated e) {
        SellableInventoryItemEntryMvoStateEventDto.SellableInventoryItemEntryMvoStateCreatedDto dto = new SellableInventoryItemEntryMvoStateEventDto.SellableInventoryItemEntryMvoStateCreatedDto();
        dto.setSellableInventoryItemEntryMvoEventId(e.getSellableInventoryItemEntryMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setSellableQuantity(e.getSellableQuantity());
        dto.setSourceEventId(e.getSourceEventId());
        dto.setVersion(e.getVersion());
        dto.setSellableInventoryItemSellableQuantity(e.getSellableInventoryItemSellableQuantity());
        dto.setSellableInventoryItemCreatedBy(e.getSellableInventoryItemCreatedBy());
        dto.setSellableInventoryItemCreatedAt(e.getSellableInventoryItemCreatedAt());
        dto.setSellableInventoryItemUpdatedBy(e.getSellableInventoryItemUpdatedBy());
        dto.setSellableInventoryItemUpdatedAt(e.getSellableInventoryItemUpdatedAt());
        return dto;
    }

    public SellableInventoryItemEntryMvoStateEventDto.SellableInventoryItemEntryMvoStateMergePatchedDto toSellableInventoryItemEntryMvoStateMergePatchedDto(SellableInventoryItemEntryMvoEvent.SellableInventoryItemEntryMvoStateMergePatched e) {
        SellableInventoryItemEntryMvoStateEventDto.SellableInventoryItemEntryMvoStateMergePatchedDto dto = new SellableInventoryItemEntryMvoStateEventDto.SellableInventoryItemEntryMvoStateMergePatchedDto();
        dto.setSellableInventoryItemEntryMvoEventId(e.getSellableInventoryItemEntryMvoEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setSellableQuantity(e.getSellableQuantity());
        dto.setSourceEventId(e.getSourceEventId());
        dto.setVersion(e.getVersion());
        dto.setSellableInventoryItemSellableQuantity(e.getSellableInventoryItemSellableQuantity());
        dto.setSellableInventoryItemCreatedBy(e.getSellableInventoryItemCreatedBy());
        dto.setSellableInventoryItemCreatedAt(e.getSellableInventoryItemCreatedAt());
        dto.setSellableInventoryItemUpdatedBy(e.getSellableInventoryItemUpdatedBy());
        dto.setSellableInventoryItemUpdatedAt(e.getSellableInventoryItemUpdatedAt());
        dto.setIsPropertySellableQuantityRemoved(e.getIsPropertySellableQuantityRemoved());
        dto.setIsPropertySourceEventIdRemoved(e.getIsPropertySourceEventIdRemoved());
        dto.setIsPropertyVersionRemoved(e.getIsPropertyVersionRemoved());
        dto.setIsPropertySellableInventoryItemSellableQuantityRemoved(e.getIsPropertySellableInventoryItemSellableQuantityRemoved());
        dto.setIsPropertySellableInventoryItemCreatedByRemoved(e.getIsPropertySellableInventoryItemCreatedByRemoved());
        dto.setIsPropertySellableInventoryItemCreatedAtRemoved(e.getIsPropertySellableInventoryItemCreatedAtRemoved());
        dto.setIsPropertySellableInventoryItemUpdatedByRemoved(e.getIsPropertySellableInventoryItemUpdatedByRemoved());
        dto.setIsPropertySellableInventoryItemUpdatedAtRemoved(e.getIsPropertySellableInventoryItemUpdatedAtRemoved());
        return dto;
    }


}

