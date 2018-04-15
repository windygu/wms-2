package org.dddml.wms.domain.productcategorymember;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ProductCategoryMemberStateEventDtoConverter {

    public ProductCategoryMemberStateEventDto toProductCategoryMemberStateEventDto(AbstractProductCategoryMemberEvent stateEvent) {
        if (stateEvent instanceof AbstractProductCategoryMemberEvent.AbstractProductCategoryMemberStateCreated) {
            ProductCategoryMemberEvent.ProductCategoryMemberStateCreated e = (ProductCategoryMemberEvent.ProductCategoryMemberStateCreated) stateEvent;
            return toProductCategoryMemberStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractProductCategoryMemberEvent.AbstractProductCategoryMemberStateMergePatched) {
            ProductCategoryMemberEvent.ProductCategoryMemberStateMergePatched e = (ProductCategoryMemberEvent.ProductCategoryMemberStateMergePatched) stateEvent;
            return toProductCategoryMemberStateMergePatchedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public ProductCategoryMemberStateEventDto.ProductCategoryMemberStateCreatedDto toProductCategoryMemberStateCreatedDto(ProductCategoryMemberEvent.ProductCategoryMemberStateCreated e) {
        ProductCategoryMemberStateEventDto.ProductCategoryMemberStateCreatedDto dto = new ProductCategoryMemberStateEventDto.ProductCategoryMemberStateCreatedDto();
        dto.setProductCategoryMemberEventId(e.getProductCategoryMemberEventId());
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

    public ProductCategoryMemberStateEventDto.ProductCategoryMemberStateMergePatchedDto toProductCategoryMemberStateMergePatchedDto(ProductCategoryMemberEvent.ProductCategoryMemberStateMergePatched e) {
        ProductCategoryMemberStateEventDto.ProductCategoryMemberStateMergePatchedDto dto = new ProductCategoryMemberStateEventDto.ProductCategoryMemberStateMergePatchedDto();
        dto.setProductCategoryMemberEventId(e.getProductCategoryMemberEventId());
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

