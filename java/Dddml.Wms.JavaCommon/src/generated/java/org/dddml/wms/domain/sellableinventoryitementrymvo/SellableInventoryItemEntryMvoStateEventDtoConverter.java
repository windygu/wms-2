package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class SellableInventoryItemEntryMvoStateEventDtoConverter {

    public SellableInventoryItemEntryMvoStateEventDto toSellableInventoryItemEntryMvoStateEventDto(AbstractSellableInventoryItemEntryMvoStateEvent stateEvent) {
        if (stateEvent instanceof AbstractSellableInventoryItemEntryMvoStateEvent.AbstractSellableInventoryItemEntryMvoStateCreated) {
            SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateCreated e = (SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateCreated) stateEvent;
            return toSellableInventoryItemEntryMvoStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractSellableInventoryItemEntryMvoStateEvent.AbstractSellableInventoryItemEntryMvoStateMergePatched) {
            SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateMergePatched e = (SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateMergePatched) stateEvent;
            return toSellableInventoryItemEntryMvoStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public SellableInventoryItemEntryMvoStateEventDto.SellableInventoryItemEntryMvoStateCreatedDto toSellableInventoryItemEntryMvoStateCreatedDto(SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateCreated e) {
        SellableInventoryItemEntryMvoStateEventDto.SellableInventoryItemEntryMvoStateCreatedDto dto = new SellableInventoryItemEntryMvoStateEventDto.SellableInventoryItemEntryMvoStateCreatedDto();
        dto.setStateEventId(new SellableInventoryItemEntryMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setSellableQuantity(e.getSellableQuantity());
        dto.setSourceEventId((e.getSourceEventId() == null) ? null : new InventoryPRTriggeredIdDtoWrapper(e.getSourceEventId()));
        dto.setVersion(e.getVersion());
        dto.setSellableInventoryItemSellableQuantity(e.getSellableInventoryItemSellableQuantity());
        dto.setSellableInventoryItemCreatedBy(e.getSellableInventoryItemCreatedBy());
        dto.setSellableInventoryItemCreatedAt(e.getSellableInventoryItemCreatedAt());
        dto.setSellableInventoryItemUpdatedBy(e.getSellableInventoryItemUpdatedBy());
        dto.setSellableInventoryItemUpdatedAt(e.getSellableInventoryItemUpdatedAt());
        return dto;
    }

    public SellableInventoryItemEntryMvoStateEventDto.SellableInventoryItemEntryMvoStateMergePatchedDto toSellableInventoryItemEntryMvoStateMergePatchedDto(SellableInventoryItemEntryMvoStateEvent.SellableInventoryItemEntryMvoStateMergePatched e) {
        SellableInventoryItemEntryMvoStateEventDto.SellableInventoryItemEntryMvoStateMergePatchedDto dto = new SellableInventoryItemEntryMvoStateEventDto.SellableInventoryItemEntryMvoStateMergePatchedDto();
        dto.setStateEventId(new SellableInventoryItemEntryMvoStateEventIdDtoWrapper(e.getStateEventId()));
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setSellableQuantity(e.getSellableQuantity());
        dto.setSourceEventId((e.getSourceEventId() == null) ? null : new InventoryPRTriggeredIdDtoWrapper(e.getSourceEventId()));
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

