package org.dddml.wms.domain.productcategory;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class ProductCategoryStateEventDtoConverter {

    public ProductCategoryStateEventDto toProductCategoryStateEventDto(AbstractProductCategoryEvent stateEvent) {
        if (stateEvent instanceof AbstractProductCategoryEvent.AbstractProductCategoryStateCreated) {
            ProductCategoryEvent.ProductCategoryStateCreated e = (ProductCategoryEvent.ProductCategoryStateCreated) stateEvent;
            return toProductCategoryStateCreatedDto(e);
        } else if (stateEvent instanceof AbstractProductCategoryEvent.AbstractProductCategoryStateMergePatched) {
            ProductCategoryEvent.ProductCategoryStateMergePatched e = (ProductCategoryEvent.ProductCategoryStateMergePatched) stateEvent;
            return toProductCategoryStateMergePatchedDto(e);
        } else if (stateEvent instanceof AbstractProductCategoryEvent.AbstractProductCategoryStateDeleted) {
            ProductCategoryEvent.ProductCategoryStateDeleted e = (ProductCategoryEvent.ProductCategoryStateDeleted) stateEvent;
            return toProductCategoryStateDeletedDto(e);
        }

        throw DomainError.named("invalidEventType", String.format("Invalid state event type: %1$s", stateEvent.getEventType()));
    }

    public ProductCategoryStateEventDto.ProductCategoryStateCreatedDto toProductCategoryStateCreatedDto(ProductCategoryEvent.ProductCategoryStateCreated e) {
        ProductCategoryStateEventDto.ProductCategoryStateCreatedDto dto = new ProductCategoryStateEventDto.ProductCategoryStateCreatedDto();
        dto.setProductCategoryEventId(e.getProductCategoryEventId());
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

    public ProductCategoryStateEventDto.ProductCategoryStateMergePatchedDto toProductCategoryStateMergePatchedDto(ProductCategoryEvent.ProductCategoryStateMergePatched e) {
        ProductCategoryStateEventDto.ProductCategoryStateMergePatchedDto dto = new ProductCategoryStateEventDto.ProductCategoryStateMergePatchedDto();
        dto.setProductCategoryEventId(e.getProductCategoryEventId());
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


    public ProductCategoryStateEventDto.ProductCategoryStateDeletedDto toProductCategoryStateDeletedDto(ProductCategoryEvent.ProductCategoryStateDeleted e) {
        ProductCategoryStateEventDto.ProductCategoryStateDeletedDto dto = new ProductCategoryStateEventDto.ProductCategoryStateDeletedDto();
        dto.setProductCategoryEventId(e.getProductCategoryEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        return dto;
    }

}

