package org.dddml.wms.domain.productcategorymember;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ProductCategoryMemberStateEventDtoConverter {

    public ProductCategoryMemberStateEventDto toProductCategoryMemberStateEventDto(AbstractProductCategoryMemberStateEvent stateEvent) {
        if (stateEvent instanceof AbstractProductCategoryMemberStateEvent.AbstractProductCategoryMemberStateCreated) {
            ProductCategoryMemberStateEvent.ProductCategoryMemberStateCreated e = (ProductCategoryMemberStateEvent.ProductCategoryMemberStateCreated) stateEvent;
            return toProductCategoryMemberStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractProductCategoryMemberStateEvent.AbstractProductCategoryMemberStateMergePatched) {
            ProductCategoryMemberStateEvent.ProductCategoryMemberStateMergePatched e = (ProductCategoryMemberStateEvent.ProductCategoryMemberStateMergePatched) stateEvent;
            return toProductCategoryMemberStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public ProductCategoryMemberStateEventDto.ProductCategoryMemberStateCreatedDto toProductCategoryMemberStateCreatedDto(ProductCategoryMemberStateEvent.ProductCategoryMemberStateCreated e) {
        ProductCategoryMemberStateEventDto.ProductCategoryMemberStateCreatedDto dto = new ProductCategoryMemberStateEventDto.ProductCategoryMemberStateCreatedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setThruDate(e.getThruDate());
        dto.setComments(e.getComments());
        dto.setSequenceNum(e.getSequenceNum());
        dto.setQuantity(e.getQuantity());
        dto.setActive(e.getActive());
        return dto;
    }

    public ProductCategoryMemberStateEventDto.ProductCategoryMemberStateMergePatchedDto toProductCategoryMemberStateMergePatchedDto(ProductCategoryMemberStateEvent.ProductCategoryMemberStateMergePatched e) {
        ProductCategoryMemberStateEventDto.ProductCategoryMemberStateMergePatchedDto dto = new ProductCategoryMemberStateEventDto.ProductCategoryMemberStateMergePatchedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setThruDate(e.getThruDate());
        dto.setComments(e.getComments());
        dto.setSequenceNum(e.getSequenceNum());
        dto.setQuantity(e.getQuantity());
        dto.setActive(e.getActive());
        dto.setIsPropertyThruDateRemoved(e.getIsPropertyThruDateRemoved());
        dto.setIsPropertyCommentsRemoved(e.getIsPropertyCommentsRemoved());
        dto.setIsPropertySequenceNumRemoved(e.getIsPropertySequenceNumRemoved());
        dto.setIsPropertyQuantityRemoved(e.getIsPropertyQuantityRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


}

