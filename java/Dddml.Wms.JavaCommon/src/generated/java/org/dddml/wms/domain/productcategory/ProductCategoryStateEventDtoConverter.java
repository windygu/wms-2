package org.dddml.wms.domain.productcategory;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ProductCategoryStateEventDtoConverter {

    public ProductCategoryStateEventDto toProductCategoryStateEventDto(AbstractProductCategoryStateEvent stateEvent) {
        if (stateEvent instanceof AbstractProductCategoryStateEvent.AbstractProductCategoryStateCreated) {
            ProductCategoryStateEvent.ProductCategoryStateCreated e = (ProductCategoryStateEvent.ProductCategoryStateCreated) stateEvent;
            return toProductCategoryStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractProductCategoryStateEvent.AbstractProductCategoryStateMergePatched) {
            ProductCategoryStateEvent.ProductCategoryStateMergePatched e = (ProductCategoryStateEvent.ProductCategoryStateMergePatched) stateEvent;
            return toProductCategoryStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractProductCategoryStateEvent.AbstractProductCategoryStateDeleted) {
            ProductCategoryStateEvent.ProductCategoryStateDeleted e = (ProductCategoryStateEvent.ProductCategoryStateDeleted) stateEvent;
            return toProductCategoryStateDeletedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public ProductCategoryStateEventDto.ProductCategoryStateCreatedDto toProductCategoryStateCreatedDto(ProductCategoryStateEvent.ProductCategoryStateCreated e) {
        ProductCategoryStateEventDto.ProductCategoryStateCreatedDto dto = new ProductCategoryStateEventDto.ProductCategoryStateCreatedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setProductCategoryTypeId(e.getProductCategoryTypeId());
        dto.setPrimaryParentCategoryId(e.getPrimaryParentCategoryId());
        dto.setCategoryName(e.getCategoryName());
        dto.setDescription(e.getDescription());
        dto.setCategoryImageUrl(e.getCategoryImageUrl());
        dto.setDetailScreen(e.getDetailScreen());
        dto.setShowInSelect(e.getShowInSelect());
        dto.setAttributeSetId(e.getAttributeSetId());
        dto.setActive(e.getActive());
        return dto;
    }

    public ProductCategoryStateEventDto.ProductCategoryStateMergePatchedDto toProductCategoryStateMergePatchedDto(ProductCategoryStateEvent.ProductCategoryStateMergePatched e) {
        ProductCategoryStateEventDto.ProductCategoryStateMergePatchedDto dto = new ProductCategoryStateEventDto.ProductCategoryStateMergePatchedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setProductCategoryTypeId(e.getProductCategoryTypeId());
        dto.setPrimaryParentCategoryId(e.getPrimaryParentCategoryId());
        dto.setCategoryName(e.getCategoryName());
        dto.setDescription(e.getDescription());
        dto.setCategoryImageUrl(e.getCategoryImageUrl());
        dto.setDetailScreen(e.getDetailScreen());
        dto.setShowInSelect(e.getShowInSelect());
        dto.setAttributeSetId(e.getAttributeSetId());
        dto.setActive(e.getActive());
        dto.setIsPropertyProductCategoryTypeIdRemoved(e.getIsPropertyProductCategoryTypeIdRemoved());
        dto.setIsPropertyPrimaryParentCategoryIdRemoved(e.getIsPropertyPrimaryParentCategoryIdRemoved());
        dto.setIsPropertyCategoryNameRemoved(e.getIsPropertyCategoryNameRemoved());
        dto.setIsPropertyDescriptionRemoved(e.getIsPropertyDescriptionRemoved());
        dto.setIsPropertyCategoryImageUrlRemoved(e.getIsPropertyCategoryImageUrlRemoved());
        dto.setIsPropertyDetailScreenRemoved(e.getIsPropertyDetailScreenRemoved());
        dto.setIsPropertyShowInSelectRemoved(e.getIsPropertyShowInSelectRemoved());
        dto.setIsPropertyAttributeSetIdRemoved(e.getIsPropertyAttributeSetIdRemoved());
        dto.setIsPropertyActiveRemoved(e.getIsPropertyActiveRemoved());
        return dto;
    }


    public ProductCategoryStateEventDto.ProductCategoryStateDeletedDto toProductCategoryStateDeletedDto(ProductCategoryStateEvent.ProductCategoryStateDeleted e) {
        ProductCategoryStateEventDto.ProductCategoryStateDeletedDto dto = new ProductCategoryStateEventDto.ProductCategoryStateDeletedDto();
        dto.setStateEventId(e.getStateEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

