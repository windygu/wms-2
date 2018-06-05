package org.dddml.wms.domain.goodidentificationmvo;

import java.util.*;
import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public abstract class AbstractGoodIdentificationMvoAggregate extends AbstractAggregate implements GoodIdentificationMvoAggregate
{
    private GoodIdentificationMvoState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractGoodIdentificationMvoAggregate(GoodIdentificationMvoState state)
    {
        this.state = state;
    }

    public GoodIdentificationMvoState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void create(GoodIdentificationMvoCommand.CreateGoodIdentificationMvo c)
    {
        if (c.getProductVersion() == null) { c.setProductVersion(GoodIdentificationMvoState.VERSION_NULL); }
        GoodIdentificationMvoEvent e = map(c);
        apply(e);
    }

    public void mergePatch(GoodIdentificationMvoCommand.MergePatchGoodIdentificationMvo c)
    {
        GoodIdentificationMvoEvent e = map(c);
        apply(e);
    }

    public void delete(GoodIdentificationMvoCommand.DeleteGoodIdentificationMvo c)
    {
        GoodIdentificationMvoEvent e = map(c);
        apply(e);
    }

    public void throwOnInvalidStateTransition(Command c) {
        GoodIdentificationMvoCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e)
    {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }

    protected GoodIdentificationMvoEvent map(GoodIdentificationMvoCommand.CreateGoodIdentificationMvo c) {
        GoodIdentificationMvoEventId stateEventId = new GoodIdentificationMvoEventId(c.getProductGoodIdentificationId(), c.getProductVersion());
        GoodIdentificationMvoEvent.GoodIdentificationMvoStateCreated e = newGoodIdentificationMvoStateCreated(stateEventId);
        e.setIdValue(c.getIdValue());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setProductProductTypeId(c.getProductProductTypeId());
        e.setProductPrimaryProductCategoryId(c.getProductPrimaryProductCategoryId());
        e.setProductManufacturerPartyId(c.getProductManufacturerPartyId());
        e.setProductFacilityId(c.getProductFacilityId());
        e.setProductIntroductionDate(c.getProductIntroductionDate());
        e.setProductReleaseDate(c.getProductReleaseDate());
        e.setProductSupportDiscontinuationDate(c.getProductSupportDiscontinuationDate());
        e.setProductSalesDiscontinuationDate(c.getProductSalesDiscontinuationDate());
        e.setProductSalesDiscWhenNotAvail(c.getProductSalesDiscWhenNotAvail());
        e.setProductInternalName(c.getProductInternalName());
        e.setProductBrandName(c.getProductBrandName());
        e.setProductComments(c.getProductComments());
        e.setProductProductName(c.getProductProductName());
        e.setProductDescription(c.getProductDescription());
        e.setProductPriceDetailText(c.getProductPriceDetailText());
        e.setProductSmallImageUrl(c.getProductSmallImageUrl());
        e.setProductMediumImageUrl(c.getProductMediumImageUrl());
        e.setProductLargeImageUrl(c.getProductLargeImageUrl());
        e.setProductDetailImageUrl(c.getProductDetailImageUrl());
        e.setProductOriginalImageUrl(c.getProductOriginalImageUrl());
        e.setProductDetailScreen(c.getProductDetailScreen());
        e.setProductInventoryMessage(c.getProductInventoryMessage());
        e.setProductInventoryItemTypeId(c.getProductInventoryItemTypeId());
        e.setProductRequireInventory(c.getProductRequireInventory());
        e.setProductQuantityUomId(c.getProductQuantityUomId());
        e.setProductQuantityIncluded(c.getProductQuantityIncluded());
        e.setProductPiecesIncluded(c.getProductPiecesIncluded());
        e.setProductRequireAmount(c.getProductRequireAmount());
        e.setProductFixedAmount(c.getProductFixedAmount());
        e.setProductAmountUomTypeId(c.getProductAmountUomTypeId());
        e.setProductWeightUomId(c.getProductWeightUomId());
        e.setProductShippingWeight(c.getProductShippingWeight());
        e.setProductProductWeight(c.getProductProductWeight());
        e.setProductHeightUomId(c.getProductHeightUomId());
        e.setProductProductHeight(c.getProductProductHeight());
        e.setProductShippingHeight(c.getProductShippingHeight());
        e.setProductWidthUomId(c.getProductWidthUomId());
        e.setProductProductWidth(c.getProductProductWidth());
        e.setProductShippingWidth(c.getProductShippingWidth());
        e.setProductDepthUomId(c.getProductDepthUomId());
        e.setProductProductDepth(c.getProductProductDepth());
        e.setProductShippingDepth(c.getProductShippingDepth());
        e.setProductDiameterUomId(c.getProductDiameterUomId());
        e.setProductProductDiameter(c.getProductProductDiameter());
        e.setProductProductRating(c.getProductProductRating());
        e.setProductRatingTypeEnum(c.getProductRatingTypeEnum());
        e.setProductReturnable(c.getProductReturnable());
        e.setProductTaxable(c.getProductTaxable());
        e.setProductChargeShipping(c.getProductChargeShipping());
        e.setProductAutoCreateKeywords(c.getProductAutoCreateKeywords());
        e.setProductIncludeInPromotions(c.getProductIncludeInPromotions());
        e.setProductIsVirtual(c.getProductIsVirtual());
        e.setProductIsVariant(c.getProductIsVariant());
        e.setProductVirtualVariantMethodEnum(c.getProductVirtualVariantMethodEnum());
        e.setProductInShippingBox(c.getProductInShippingBox());
        e.setProductDefaultShipmentBoxTypeId(c.getProductDefaultShipmentBoxTypeId());
        e.setProductIsSerialNumbered(c.getProductIsSerialNumbered());
        e.setProductIsManagedByLot(c.getProductIsManagedByLot());
        e.setProductAttributeSetId(c.getProductAttributeSetId());
        e.setProductAttributeSetInstanceId(c.getProductAttributeSetInstanceId());
        e.setProductCreatedBy(c.getProductCreatedBy());
        e.setProductCreatedAt(c.getProductCreatedAt());
        e.setProductUpdatedBy(c.getProductUpdatedBy());
        e.setProductUpdatedAt(c.getProductUpdatedAt());
        e.setProductActive(c.getProductActive());
        ((AbstractGoodIdentificationMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected GoodIdentificationMvoEvent map(GoodIdentificationMvoCommand.MergePatchGoodIdentificationMvo c) {
        GoodIdentificationMvoEventId stateEventId = new GoodIdentificationMvoEventId(c.getProductGoodIdentificationId(), c.getProductVersion());
        GoodIdentificationMvoEvent.GoodIdentificationMvoStateMergePatched e = newGoodIdentificationMvoStateMergePatched(stateEventId);
        e.setIdValue(c.getIdValue());
        e.setVersion(c.getVersion());
        e.setActive(c.getActive());
        e.setProductProductTypeId(c.getProductProductTypeId());
        e.setProductPrimaryProductCategoryId(c.getProductPrimaryProductCategoryId());
        e.setProductManufacturerPartyId(c.getProductManufacturerPartyId());
        e.setProductFacilityId(c.getProductFacilityId());
        e.setProductIntroductionDate(c.getProductIntroductionDate());
        e.setProductReleaseDate(c.getProductReleaseDate());
        e.setProductSupportDiscontinuationDate(c.getProductSupportDiscontinuationDate());
        e.setProductSalesDiscontinuationDate(c.getProductSalesDiscontinuationDate());
        e.setProductSalesDiscWhenNotAvail(c.getProductSalesDiscWhenNotAvail());
        e.setProductInternalName(c.getProductInternalName());
        e.setProductBrandName(c.getProductBrandName());
        e.setProductComments(c.getProductComments());
        e.setProductProductName(c.getProductProductName());
        e.setProductDescription(c.getProductDescription());
        e.setProductPriceDetailText(c.getProductPriceDetailText());
        e.setProductSmallImageUrl(c.getProductSmallImageUrl());
        e.setProductMediumImageUrl(c.getProductMediumImageUrl());
        e.setProductLargeImageUrl(c.getProductLargeImageUrl());
        e.setProductDetailImageUrl(c.getProductDetailImageUrl());
        e.setProductOriginalImageUrl(c.getProductOriginalImageUrl());
        e.setProductDetailScreen(c.getProductDetailScreen());
        e.setProductInventoryMessage(c.getProductInventoryMessage());
        e.setProductInventoryItemTypeId(c.getProductInventoryItemTypeId());
        e.setProductRequireInventory(c.getProductRequireInventory());
        e.setProductQuantityUomId(c.getProductQuantityUomId());
        e.setProductQuantityIncluded(c.getProductQuantityIncluded());
        e.setProductPiecesIncluded(c.getProductPiecesIncluded());
        e.setProductRequireAmount(c.getProductRequireAmount());
        e.setProductFixedAmount(c.getProductFixedAmount());
        e.setProductAmountUomTypeId(c.getProductAmountUomTypeId());
        e.setProductWeightUomId(c.getProductWeightUomId());
        e.setProductShippingWeight(c.getProductShippingWeight());
        e.setProductProductWeight(c.getProductProductWeight());
        e.setProductHeightUomId(c.getProductHeightUomId());
        e.setProductProductHeight(c.getProductProductHeight());
        e.setProductShippingHeight(c.getProductShippingHeight());
        e.setProductWidthUomId(c.getProductWidthUomId());
        e.setProductProductWidth(c.getProductProductWidth());
        e.setProductShippingWidth(c.getProductShippingWidth());
        e.setProductDepthUomId(c.getProductDepthUomId());
        e.setProductProductDepth(c.getProductProductDepth());
        e.setProductShippingDepth(c.getProductShippingDepth());
        e.setProductDiameterUomId(c.getProductDiameterUomId());
        e.setProductProductDiameter(c.getProductProductDiameter());
        e.setProductProductRating(c.getProductProductRating());
        e.setProductRatingTypeEnum(c.getProductRatingTypeEnum());
        e.setProductReturnable(c.getProductReturnable());
        e.setProductTaxable(c.getProductTaxable());
        e.setProductChargeShipping(c.getProductChargeShipping());
        e.setProductAutoCreateKeywords(c.getProductAutoCreateKeywords());
        e.setProductIncludeInPromotions(c.getProductIncludeInPromotions());
        e.setProductIsVirtual(c.getProductIsVirtual());
        e.setProductIsVariant(c.getProductIsVariant());
        e.setProductVirtualVariantMethodEnum(c.getProductVirtualVariantMethodEnum());
        e.setProductInShippingBox(c.getProductInShippingBox());
        e.setProductDefaultShipmentBoxTypeId(c.getProductDefaultShipmentBoxTypeId());
        e.setProductIsSerialNumbered(c.getProductIsSerialNumbered());
        e.setProductIsManagedByLot(c.getProductIsManagedByLot());
        e.setProductAttributeSetId(c.getProductAttributeSetId());
        e.setProductAttributeSetInstanceId(c.getProductAttributeSetInstanceId());
        e.setProductCreatedBy(c.getProductCreatedBy());
        e.setProductCreatedAt(c.getProductCreatedAt());
        e.setProductUpdatedBy(c.getProductUpdatedBy());
        e.setProductUpdatedAt(c.getProductUpdatedAt());
        e.setProductActive(c.getProductActive());
        e.setIsPropertyIdValueRemoved(c.getIsPropertyIdValueRemoved());
        e.setIsPropertyVersionRemoved(c.getIsPropertyVersionRemoved());
        e.setIsPropertyActiveRemoved(c.getIsPropertyActiveRemoved());
        e.setIsPropertyProductProductTypeIdRemoved(c.getIsPropertyProductProductTypeIdRemoved());
        e.setIsPropertyProductPrimaryProductCategoryIdRemoved(c.getIsPropertyProductPrimaryProductCategoryIdRemoved());
        e.setIsPropertyProductManufacturerPartyIdRemoved(c.getIsPropertyProductManufacturerPartyIdRemoved());
        e.setIsPropertyProductFacilityIdRemoved(c.getIsPropertyProductFacilityIdRemoved());
        e.setIsPropertyProductIntroductionDateRemoved(c.getIsPropertyProductIntroductionDateRemoved());
        e.setIsPropertyProductReleaseDateRemoved(c.getIsPropertyProductReleaseDateRemoved());
        e.setIsPropertyProductSupportDiscontinuationDateRemoved(c.getIsPropertyProductSupportDiscontinuationDateRemoved());
        e.setIsPropertyProductSalesDiscontinuationDateRemoved(c.getIsPropertyProductSalesDiscontinuationDateRemoved());
        e.setIsPropertyProductSalesDiscWhenNotAvailRemoved(c.getIsPropertyProductSalesDiscWhenNotAvailRemoved());
        e.setIsPropertyProductInternalNameRemoved(c.getIsPropertyProductInternalNameRemoved());
        e.setIsPropertyProductBrandNameRemoved(c.getIsPropertyProductBrandNameRemoved());
        e.setIsPropertyProductCommentsRemoved(c.getIsPropertyProductCommentsRemoved());
        e.setIsPropertyProductProductNameRemoved(c.getIsPropertyProductProductNameRemoved());
        e.setIsPropertyProductDescriptionRemoved(c.getIsPropertyProductDescriptionRemoved());
        e.setIsPropertyProductPriceDetailTextRemoved(c.getIsPropertyProductPriceDetailTextRemoved());
        e.setIsPropertyProductSmallImageUrlRemoved(c.getIsPropertyProductSmallImageUrlRemoved());
        e.setIsPropertyProductMediumImageUrlRemoved(c.getIsPropertyProductMediumImageUrlRemoved());
        e.setIsPropertyProductLargeImageUrlRemoved(c.getIsPropertyProductLargeImageUrlRemoved());
        e.setIsPropertyProductDetailImageUrlRemoved(c.getIsPropertyProductDetailImageUrlRemoved());
        e.setIsPropertyProductOriginalImageUrlRemoved(c.getIsPropertyProductOriginalImageUrlRemoved());
        e.setIsPropertyProductDetailScreenRemoved(c.getIsPropertyProductDetailScreenRemoved());
        e.setIsPropertyProductInventoryMessageRemoved(c.getIsPropertyProductInventoryMessageRemoved());
        e.setIsPropertyProductInventoryItemTypeIdRemoved(c.getIsPropertyProductInventoryItemTypeIdRemoved());
        e.setIsPropertyProductRequireInventoryRemoved(c.getIsPropertyProductRequireInventoryRemoved());
        e.setIsPropertyProductQuantityUomIdRemoved(c.getIsPropertyProductQuantityUomIdRemoved());
        e.setIsPropertyProductQuantityIncludedRemoved(c.getIsPropertyProductQuantityIncludedRemoved());
        e.setIsPropertyProductPiecesIncludedRemoved(c.getIsPropertyProductPiecesIncludedRemoved());
        e.setIsPropertyProductRequireAmountRemoved(c.getIsPropertyProductRequireAmountRemoved());
        e.setIsPropertyProductFixedAmountRemoved(c.getIsPropertyProductFixedAmountRemoved());
        e.setIsPropertyProductAmountUomTypeIdRemoved(c.getIsPropertyProductAmountUomTypeIdRemoved());
        e.setIsPropertyProductWeightUomIdRemoved(c.getIsPropertyProductWeightUomIdRemoved());
        e.setIsPropertyProductShippingWeightRemoved(c.getIsPropertyProductShippingWeightRemoved());
        e.setIsPropertyProductProductWeightRemoved(c.getIsPropertyProductProductWeightRemoved());
        e.setIsPropertyProductHeightUomIdRemoved(c.getIsPropertyProductHeightUomIdRemoved());
        e.setIsPropertyProductProductHeightRemoved(c.getIsPropertyProductProductHeightRemoved());
        e.setIsPropertyProductShippingHeightRemoved(c.getIsPropertyProductShippingHeightRemoved());
        e.setIsPropertyProductWidthUomIdRemoved(c.getIsPropertyProductWidthUomIdRemoved());
        e.setIsPropertyProductProductWidthRemoved(c.getIsPropertyProductProductWidthRemoved());
        e.setIsPropertyProductShippingWidthRemoved(c.getIsPropertyProductShippingWidthRemoved());
        e.setIsPropertyProductDepthUomIdRemoved(c.getIsPropertyProductDepthUomIdRemoved());
        e.setIsPropertyProductProductDepthRemoved(c.getIsPropertyProductProductDepthRemoved());
        e.setIsPropertyProductShippingDepthRemoved(c.getIsPropertyProductShippingDepthRemoved());
        e.setIsPropertyProductDiameterUomIdRemoved(c.getIsPropertyProductDiameterUomIdRemoved());
        e.setIsPropertyProductProductDiameterRemoved(c.getIsPropertyProductProductDiameterRemoved());
        e.setIsPropertyProductProductRatingRemoved(c.getIsPropertyProductProductRatingRemoved());
        e.setIsPropertyProductRatingTypeEnumRemoved(c.getIsPropertyProductRatingTypeEnumRemoved());
        e.setIsPropertyProductReturnableRemoved(c.getIsPropertyProductReturnableRemoved());
        e.setIsPropertyProductTaxableRemoved(c.getIsPropertyProductTaxableRemoved());
        e.setIsPropertyProductChargeShippingRemoved(c.getIsPropertyProductChargeShippingRemoved());
        e.setIsPropertyProductAutoCreateKeywordsRemoved(c.getIsPropertyProductAutoCreateKeywordsRemoved());
        e.setIsPropertyProductIncludeInPromotionsRemoved(c.getIsPropertyProductIncludeInPromotionsRemoved());
        e.setIsPropertyProductIsVirtualRemoved(c.getIsPropertyProductIsVirtualRemoved());
        e.setIsPropertyProductIsVariantRemoved(c.getIsPropertyProductIsVariantRemoved());
        e.setIsPropertyProductVirtualVariantMethodEnumRemoved(c.getIsPropertyProductVirtualVariantMethodEnumRemoved());
        e.setIsPropertyProductInShippingBoxRemoved(c.getIsPropertyProductInShippingBoxRemoved());
        e.setIsPropertyProductDefaultShipmentBoxTypeIdRemoved(c.getIsPropertyProductDefaultShipmentBoxTypeIdRemoved());
        e.setIsPropertyProductIsSerialNumberedRemoved(c.getIsPropertyProductIsSerialNumberedRemoved());
        e.setIsPropertyProductIsManagedByLotRemoved(c.getIsPropertyProductIsManagedByLotRemoved());
        e.setIsPropertyProductAttributeSetIdRemoved(c.getIsPropertyProductAttributeSetIdRemoved());
        e.setIsPropertyProductAttributeSetInstanceIdRemoved(c.getIsPropertyProductAttributeSetInstanceIdRemoved());
        e.setIsPropertyProductCreatedByRemoved(c.getIsPropertyProductCreatedByRemoved());
        e.setIsPropertyProductCreatedAtRemoved(c.getIsPropertyProductCreatedAtRemoved());
        e.setIsPropertyProductUpdatedByRemoved(c.getIsPropertyProductUpdatedByRemoved());
        e.setIsPropertyProductUpdatedAtRemoved(c.getIsPropertyProductUpdatedAtRemoved());
        e.setIsPropertyProductActiveRemoved(c.getIsPropertyProductActiveRemoved());
        ((AbstractGoodIdentificationMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected GoodIdentificationMvoEvent map(GoodIdentificationMvoCommand.DeleteGoodIdentificationMvo c) {
        GoodIdentificationMvoEventId stateEventId = new GoodIdentificationMvoEventId(c.getProductGoodIdentificationId(), c.getProductVersion());
        GoodIdentificationMvoEvent.GoodIdentificationMvoStateDeleted e = newGoodIdentificationMvoStateDeleted(stateEventId);
        ((AbstractGoodIdentificationMvoEvent)e).setCommandId(c.getCommandId());
        e.setCreatedBy(c.getRequesterId());
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }


    ////////////////////////

    protected GoodIdentificationMvoEvent.GoodIdentificationMvoStateCreated newGoodIdentificationMvoStateCreated(Long version, String commandId, String requesterId) {
        GoodIdentificationMvoEventId stateEventId = new GoodIdentificationMvoEventId(this.state.getProductGoodIdentificationId(), version);
        GoodIdentificationMvoEvent.GoodIdentificationMvoStateCreated e = newGoodIdentificationMvoStateCreated(stateEventId);
        ((AbstractGoodIdentificationMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected GoodIdentificationMvoEvent.GoodIdentificationMvoStateMergePatched newGoodIdentificationMvoStateMergePatched(Long version, String commandId, String requesterId) {
        GoodIdentificationMvoEventId stateEventId = new GoodIdentificationMvoEventId(this.state.getProductGoodIdentificationId(), version);
        GoodIdentificationMvoEvent.GoodIdentificationMvoStateMergePatched e = newGoodIdentificationMvoStateMergePatched(stateEventId);
        ((AbstractGoodIdentificationMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected GoodIdentificationMvoEvent.GoodIdentificationMvoStateDeleted newGoodIdentificationMvoStateDeleted(Long version, String commandId, String requesterId) {
        GoodIdentificationMvoEventId stateEventId = new GoodIdentificationMvoEventId(this.state.getProductGoodIdentificationId(), version);
        GoodIdentificationMvoEvent.GoodIdentificationMvoStateDeleted e = newGoodIdentificationMvoStateDeleted(stateEventId);
        ((AbstractGoodIdentificationMvoEvent)e).setCommandId(commandId);
        e.setCreatedBy(requesterId);
        e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));
        return e;
    }

    protected GoodIdentificationMvoEvent.GoodIdentificationMvoStateCreated newGoodIdentificationMvoStateCreated(GoodIdentificationMvoEventId stateEventId) {
        return new AbstractGoodIdentificationMvoEvent.SimpleGoodIdentificationMvoStateCreated(stateEventId);
    }

    protected GoodIdentificationMvoEvent.GoodIdentificationMvoStateMergePatched newGoodIdentificationMvoStateMergePatched(GoodIdentificationMvoEventId stateEventId) {
        return new AbstractGoodIdentificationMvoEvent.SimpleGoodIdentificationMvoStateMergePatched(stateEventId);
    }

    protected GoodIdentificationMvoEvent.GoodIdentificationMvoStateDeleted newGoodIdentificationMvoStateDeleted(GoodIdentificationMvoEventId stateEventId)
    {
        return new AbstractGoodIdentificationMvoEvent.SimpleGoodIdentificationMvoStateDeleted(stateEventId);
    }

    public static class SimpleGoodIdentificationMvoAggregate extends AbstractGoodIdentificationMvoAggregate
    {
        public SimpleGoodIdentificationMvoAggregate(GoodIdentificationMvoState state) {
            super(state);
        }

    }

}

