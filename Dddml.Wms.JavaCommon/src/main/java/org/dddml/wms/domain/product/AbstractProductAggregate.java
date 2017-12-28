package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractProductAggregate extends AbstractAggregate implements ProductAggregate
{
    private ProductState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractProductAggregate(ProductState state)
    {
        this.state = state;
    }

    public ProductState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(ProductCommand.CreateProduct c)
    {
        if (c.getVersion() == null) { c.setVersion(ProductState.VERSION_NULL); }
        ProductStateEvent e = map(c);
        apply(e);
    }

    public void mergePatch(ProductCommand.MergePatchProduct c)
    {
        ProductStateEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        ProductCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected ProductStateEvent map(ProductCommand.CreateProduct c) {
        ProductStateEventId stateEventId = new ProductStateEventId(c.getProductId(), c.getVersion());
        ProductStateEvent.ProductStateCreated e = newProductStateCreated(stateEventId);
        e.setProductTypeId(c.getProductTypeId());
        e.setPrimaryProductCategoryId(c.getPrimaryProductCategoryId());
        e.setManufacturerPartyId(c.getManufacturerPartyId());
        e.setFacilityId(c.getFacilityId());
        e.setIntroductionDate(c.getIntroductionDate());
        e.setReleaseDate(c.getReleaseDate());
        e.setSupportDiscontinuationDate(c.getSupportDiscontinuationDate());
        e.setSalesDiscontinuationDate(c.getSalesDiscontinuationDate());
        e.setSalesDiscWhenNotAvail(c.getSalesDiscWhenNotAvail());
        e.setInternalName(c.getInternalName());
        e.setBrandName(c.getBrandName());
        e.setComments(c.getComments());
        e.setProductName(c.getProductName());
        e.setDescription(c.getDescription());
        e.setPriceDetailText(c.getPriceDetailText());
        e.setSmallImageUrl(c.getSmallImageUrl());
        e.setMediumImageUrl(c.getMediumImageUrl());
        e.setLargeImageUrl(c.getLargeImageUrl());
        e.setDetailImageUrl(c.getDetailImageUrl());
        e.setOriginalImageUrl(c.getOriginalImageUrl());
        e.setDetailScreen(c.getDetailScreen());
        e.setInventoryMessage(c.getInventoryMessage());
        e.setInventoryItemTypeId(c.getInventoryItemTypeId());
        e.setRequireInventory(c.getRequireInventory());
        e.setQuantityUomId(c.getQuantityUomId());
        e.setQuantityIncluded(c.getQuantityIncluded());
        e.setPiecesIncluded(c.getPiecesIncluded());
        e.setRequireAmount(c.getRequireAmount());
        e.setFixedAmount(c.getFixedAmount());
        e.setAmountUomTypeId(c.getAmountUomTypeId());
        e.setWeightUomId(c.getWeightUomId());
        e.setShippingWeight(c.getShippingWeight());
        e.setProductWeight(c.getProductWeight());
        e.setHeightUomId(c.getHeightUomId());
        e.setProductHeight(c.getProductHeight());
        e.setShippingHeight(c.getShippingHeight());
        e.setWidthUomId(c.getWidthUomId());
        e.setProductWidth(c.getProductWidth());
        e.setShippingWidth(c.getShippingWidth());
        e.setDepthUomId(c.getDepthUomId());
        e.setProductDepth(c.getProductDepth());
        e.setShippingDepth(c.getShippingDepth());
        e.setDiameterUomId(c.getDiameterUomId());
        e.setProductDiameter(c.getProductDiameter());
        e.setProductRating(c.getProductRating());
        e.setRatingTypeEnum(c.getRatingTypeEnum());
        e.setReturnable(c.getReturnable());
        e.setTaxable(c.getTaxable());
        e.setChargeShipping(c.getChargeShipping());
        e.setAutoCreateKeywords(c.getAutoCreateKeywords());
        e.setIncludeInPromotions(c.getIncludeInPromotions());
        e.setIsVirtual(c.getIsVirtual());
        e.setIsVariant(c.getIsVariant());
        e.setVirtualVariantMethodEnum(c.getVirtualVariantMethodEnum());
        e.setInShippingBox(c.getInShippingBox());
        e.setDefaultShipmentBoxTypeId(c.getDefaultShipmentBoxTypeId());
        e.setLotIdFilledIn(c.getLotIdFilledIn());
        e.setAttributeSetId(c.getAttributeSetId());
        e.setActive(c.getActive());
        ((AbstractProductStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductStateEvent map(ProductCommand.MergePatchProduct c) {
        ProductStateEventId stateEventId = new ProductStateEventId(c.getProductId(), c.getVersion());
        ProductStateEvent.ProductStateMergePatched e = newProductStateMergePatched(stateEventId);
        e.setProductTypeId(c.getProductTypeId());
        e.setPrimaryProductCategoryId(c.getPrimaryProductCategoryId());
        e.setManufacturerPartyId(c.getManufacturerPartyId());
        e.setFacilityId(c.getFacilityId());
        e.setIntroductionDate(c.getIntroductionDate());
        e.setReleaseDate(c.getReleaseDate());
        e.setSupportDiscontinuationDate(c.getSupportDiscontinuationDate());
        e.setSalesDiscontinuationDate(c.getSalesDiscontinuationDate());
        e.setSalesDiscWhenNotAvail(c.getSalesDiscWhenNotAvail());
        e.setInternalName(c.getInternalName());
        e.setBrandName(c.getBrandName());
        e.setComments(c.getComments());
        e.setProductName(c.getProductName());
        e.setDescription(c.getDescription());
        e.setPriceDetailText(c.getPriceDetailText());
        e.setSmallImageUrl(c.getSmallImageUrl());
        e.setMediumImageUrl(c.getMediumImageUrl());
        e.setLargeImageUrl(c.getLargeImageUrl());
        e.setDetailImageUrl(c.getDetailImageUrl());
        e.setOriginalImageUrl(c.getOriginalImageUrl());
        e.setDetailScreen(c.getDetailScreen());
        e.setInventoryMessage(c.getInventoryMessage());
        e.setInventoryItemTypeId(c.getInventoryItemTypeId());
        e.setRequireInventory(c.getRequireInventory());
        e.setQuantityUomId(c.getQuantityUomId());
        e.setQuantityIncluded(c.getQuantityIncluded());
        e.setPiecesIncluded(c.getPiecesIncluded());
        e.setRequireAmount(c.getRequireAmount());
        e.setFixedAmount(c.getFixedAmount());
        e.setAmountUomTypeId(c.getAmountUomTypeId());
        e.setWeightUomId(c.getWeightUomId());
        e.setShippingWeight(c.getShippingWeight());
        e.setProductWeight(c.getProductWeight());
        e.setHeightUomId(c.getHeightUomId());
        e.setProductHeight(c.getProductHeight());
        e.setShippingHeight(c.getShippingHeight());
        e.setWidthUomId(c.getWidthUomId());
        e.setProductWidth(c.getProductWidth());
        e.setShippingWidth(c.getShippingWidth());
        e.setDepthUomId(c.getDepthUomId());
        e.setProductDepth(c.getProductDepth());
        e.setShippingDepth(c.getShippingDepth());
        e.setDiameterUomId(c.getDiameterUomId());
        e.setProductDiameter(c.getProductDiameter());
        e.setProductRating(c.getProductRating());
        e.setRatingTypeEnum(c.getRatingTypeEnum());
        e.setReturnable(c.getReturnable());
        e.setTaxable(c.getTaxable());
        e.setChargeShipping(c.getChargeShipping());
        e.setAutoCreateKeywords(c.getAutoCreateKeywords());
        e.setIncludeInPromotions(c.getIncludeInPromotions());
        e.setIsVirtual(c.getIsVirtual());
        e.setIsVariant(c.getIsVariant());
        e.setVirtualVariantMethodEnum(c.getVirtualVariantMethodEnum());
        e.setInShippingBox(c.getInShippingBox());
        e.setDefaultShipmentBoxTypeId(c.getDefaultShipmentBoxTypeId());
        e.setLotIdFilledIn(c.getLotIdFilledIn());
        e.setAttributeSetId(c.getAttributeSetId());
        e.setActive(c.getActive());
        e.setIsPropertyProductTypeIdRemoved(c.getIsPropertyProductTypeIdRemoved());
        e.setIsPropertyPrimaryProductCategoryIdRemoved(c.getIsPropertyPrimaryProductCategoryIdRemoved());
        e.setIsPropertyManufacturerPartyIdRemoved(c.getIsPropertyManufacturerPartyIdRemoved());
        e.setIsPropertyFacilityIdRemoved(c.getIsPropertyFacilityIdRemoved());
        e.setIsPropertyIntroductionDateRemoved(c.getIsPropertyIntroductionDateRemoved());
        e.setIsPropertyReleaseDateRemoved(c.getIsPropertyReleaseDateRemoved());
        e.setIsPropertySupportDiscontinuationDateRemoved(c.getIsPropertySupportDiscontinuationDateRemoved());
        e.setIsPropertySalesDiscontinuationDateRemoved(c.getIsPropertySalesDiscontinuationDateRemoved());
        e.setIsPropertySalesDiscWhenNotAvailRemoved(c.getIsPropertySalesDiscWhenNotAvailRemoved());
        e.setIsPropertyInternalNameRemoved(c.getIsPropertyInternalNameRemoved());
        e.setIsPropertyBrandNameRemoved(c.getIsPropertyBrandNameRemoved());
        e.setIsPropertyCommentsRemoved(c.getIsPropertyCommentsRemoved());
        e.setIsPropertyProductNameRemoved(c.getIsPropertyProductNameRemoved());
        e.setIsPropertyDescriptionRemoved(c.getIsPropertyDescriptionRemoved());
        e.setIsPropertyPriceDetailTextRemoved(c.getIsPropertyPriceDetailTextRemoved());
        e.setIsPropertySmallImageUrlRemoved(c.getIsPropertySmallImageUrlRemoved());
        e.setIsPropertyMediumImageUrlRemoved(c.getIsPropertyMediumImageUrlRemoved());
        e.setIsPropertyLargeImageUrlRemoved(c.getIsPropertyLargeImageUrlRemoved());
        e.setIsPropertyDetailImageUrlRemoved(c.getIsPropertyDetailImageUrlRemoved());
        e.setIsPropertyOriginalImageUrlRemoved(c.getIsPropertyOriginalImageUrlRemoved());
        e.setIsPropertyDetailScreenRemoved(c.getIsPropertyDetailScreenRemoved());
        e.setIsPropertyInventoryMessageRemoved(c.getIsPropertyInventoryMessageRemoved());
        e.setIsPropertyInventoryItemTypeIdRemoved(c.getIsPropertyInventoryItemTypeIdRemoved());
        e.setIsPropertyRequireInventoryRemoved(c.getIsPropertyRequireInventoryRemoved());
        e.setIsPropertyQuantityUomIdRemoved(c.getIsPropertyQuantityUomIdRemoved());
        e.setIsPropertyQuantityIncludedRemoved(c.getIsPropertyQuantityIncludedRemoved());
        e.setIsPropertyPiecesIncludedRemoved(c.getIsPropertyPiecesIncludedRemoved());
        e.setIsPropertyRequireAmountRemoved(c.getIsPropertyRequireAmountRemoved());
        e.setIsPropertyFixedAmountRemoved(c.getIsPropertyFixedAmountRemoved());
        e.setIsPropertyAmountUomTypeIdRemoved(c.getIsPropertyAmountUomTypeIdRemoved());
        e.setIsPropertyWeightUomIdRemoved(c.getIsPropertyWeightUomIdRemoved());
        e.setIsPropertyShippingWeightRemoved(c.getIsPropertyShippingWeightRemoved());
        e.setIsPropertyProductWeightRemoved(c.getIsPropertyProductWeightRemoved());
        e.setIsPropertyHeightUomIdRemoved(c.getIsPropertyHeightUomIdRemoved());
        e.setIsPropertyProductHeightRemoved(c.getIsPropertyProductHeightRemoved());
        e.setIsPropertyShippingHeightRemoved(c.getIsPropertyShippingHeightRemoved());
        e.setIsPropertyWidthUomIdRemoved(c.getIsPropertyWidthUomIdRemoved());
        e.setIsPropertyProductWidthRemoved(c.getIsPropertyProductWidthRemoved());
        e.setIsPropertyShippingWidthRemoved(c.getIsPropertyShippingWidthRemoved());
        e.setIsPropertyDepthUomIdRemoved(c.getIsPropertyDepthUomIdRemoved());
        e.setIsPropertyProductDepthRemoved(c.getIsPropertyProductDepthRemoved());
        e.setIsPropertyShippingDepthRemoved(c.getIsPropertyShippingDepthRemoved());
        e.setIsPropertyDiameterUomIdRemoved(c.getIsPropertyDiameterUomIdRemoved());
        e.setIsPropertyProductDiameterRemoved(c.getIsPropertyProductDiameterRemoved());
        e.setIsPropertyProductRatingRemoved(c.getIsPropertyProductRatingRemoved());
        e.setIsPropertyRatingTypeEnumRemoved(c.getIsPropertyRatingTypeEnumRemoved());
        e.setIsPropertyReturnableRemoved(c.getIsPropertyReturnableRemoved());
        e.setIsPropertyTaxableRemoved(c.getIsPropertyTaxableRemoved());
        e.setIsPropertyChargeShippingRemoved(c.getIsPropertyChargeShippingRemoved());
        e.setIsPropertyAutoCreateKeywordsRemoved(c.getIsPropertyAutoCreateKeywordsRemoved());
        e.setIsPropertyIncludeInPromotionsRemoved(c.getIsPropertyIncludeInPromotionsRemoved());
        e.setIsPropertyIsVirtualRemoved(c.getIsPropertyIsVirtualRemoved());
        e.setIsPropertyIsVariantRemoved(c.getIsPropertyIsVariantRemoved());
        e.setIsPropertyVirtualVariantMethodEnumRemoved(c.getIsPropertyVirtualVariantMethodEnumRemoved());
        e.setIsPropertyInShippingBoxRemoved(c.getIsPropertyInShippingBoxRemoved());
        e.setIsPropertyDefaultShipmentBoxTypeIdRemoved(c.getIsPropertyDefaultShipmentBoxTypeIdRemoved());
        e.setIsPropertyLotIdFilledInRemoved(c.getIsPropertyLotIdFilledInRemoved());
        e.setIsPropertyAttributeSetIdRemoved(c.getIsPropertyAttributeSetIdRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        ((AbstractProductStateEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected ProductStateEvent.ProductStateCreated newProductStateCreated(String commandId, String requesterId) {
        ProductStateEventId stateEventId = new ProductStateEventId(this.state.getProductId(), this.state.getVersion());
        ProductStateEvent.ProductStateCreated e = newProductStateCreated(stateEventId);
        ((AbstractProductStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductStateEvent.ProductStateMergePatched newProductStateMergePatched(String commandId, String requesterId) {
        ProductStateEventId stateEventId = new ProductStateEventId(this.state.getProductId(), this.state.getVersion());
        ProductStateEvent.ProductStateMergePatched e = newProductStateMergePatched(stateEventId);
        ((AbstractProductStateEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected ProductStateEvent.ProductStateCreated newProductStateCreated(ProductStateEventId stateEventId) {
        return new AbstractProductStateEvent.SimpleProductStateCreated(stateEventId);
    }

    protected ProductStateEvent.ProductStateMergePatched newProductStateMergePatched(ProductStateEventId stateEventId) {
        return new AbstractProductStateEvent.SimpleProductStateMergePatched(stateEventId);
    }


    public static class SimpleProductAggregate extends AbstractProductAggregate
    {
        public SimpleProductAggregate(ProductState state) {
            super(state);
        }

    }

}

