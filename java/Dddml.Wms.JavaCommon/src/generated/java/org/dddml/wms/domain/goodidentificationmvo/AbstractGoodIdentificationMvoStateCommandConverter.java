package org.dddml.wms.domain.goodidentificationmvo;

import java.util.*;
import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractGoodIdentificationMvoStateCommandConverter<TCreateGoodIdentificationMvo extends GoodIdentificationMvoCommand.CreateGoodIdentificationMvo, TMergePatchGoodIdentificationMvo extends GoodIdentificationMvoCommand.MergePatchGoodIdentificationMvo, TDeleteGoodIdentificationMvo extends GoodIdentificationMvoCommand.DeleteGoodIdentificationMvo>
{
    public GoodIdentificationMvoCommand toCreateOrMergePatchGoodIdentificationMvo(GoodIdentificationMvoState state)
    {
        //where TCreateGoodIdentificationMvo : ICreateGoodIdentificationMvo, new()
        //where TMergePatchGoodIdentificationMvo : IMergePatchGoodIdentificationMvo, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateGoodIdentificationMvo(state);
        }
        else 
        {
            return toMergePatchGoodIdentificationMvo(state);
        }
    }

    public TDeleteGoodIdentificationMvo toDeleteGoodIdentificationMvo(GoodIdentificationMvoState state) //where TDeleteGoodIdentificationMvo : IDeleteGoodIdentificationMvo, new()
    {
        TDeleteGoodIdentificationMvo cmd = newDeleteGoodIdentificationMvo();
        cmd.setProductGoodIdentificationId(state.getProductGoodIdentificationId());
        cmd.setProductVersion(state.getProductVersion());

        return cmd;
    }

    public TMergePatchGoodIdentificationMvo toMergePatchGoodIdentificationMvo(GoodIdentificationMvoState state) //where TMergePatchGoodIdentificationMvo : IMergePatchGoodIdentificationMvo, new()
    {
        TMergePatchGoodIdentificationMvo cmd = newMergePatchGoodIdentificationMvo();

        cmd.setProductVersion(state.getProductVersion());

        cmd.setProductGoodIdentificationId(state.getProductGoodIdentificationId());
        cmd.setIdValue(state.getIdValue());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setProductProductTypeId(state.getProductProductTypeId());
        cmd.setProductPrimaryProductCategoryId(state.getProductPrimaryProductCategoryId());
        cmd.setProductManufacturerPartyId(state.getProductManufacturerPartyId());
        cmd.setProductFacilityId(state.getProductFacilityId());
        cmd.setProductIntroductionDate(state.getProductIntroductionDate());
        cmd.setProductReleaseDate(state.getProductReleaseDate());
        cmd.setProductSupportDiscontinuationDate(state.getProductSupportDiscontinuationDate());
        cmd.setProductSalesDiscontinuationDate(state.getProductSalesDiscontinuationDate());
        cmd.setProductSalesDiscWhenNotAvail(state.getProductSalesDiscWhenNotAvail());
        cmd.setProductInternalName(state.getProductInternalName());
        cmd.setProductBrandName(state.getProductBrandName());
        cmd.setProductComments(state.getProductComments());
        cmd.setProductProductName(state.getProductProductName());
        cmd.setProductDescription(state.getProductDescription());
        cmd.setProductPriceDetailText(state.getProductPriceDetailText());
        cmd.setProductSmallImageUrl(state.getProductSmallImageUrl());
        cmd.setProductMediumImageUrl(state.getProductMediumImageUrl());
        cmd.setProductLargeImageUrl(state.getProductLargeImageUrl());
        cmd.setProductDetailImageUrl(state.getProductDetailImageUrl());
        cmd.setProductOriginalImageUrl(state.getProductOriginalImageUrl());
        cmd.setProductDetailScreen(state.getProductDetailScreen());
        cmd.setProductInventoryMessage(state.getProductInventoryMessage());
        cmd.setProductInventoryItemTypeId(state.getProductInventoryItemTypeId());
        cmd.setProductRequireInventory(state.getProductRequireInventory());
        cmd.setProductQuantityUomId(state.getProductQuantityUomId());
        cmd.setProductQuantityIncluded(state.getProductQuantityIncluded());
        cmd.setProductPiecesIncluded(state.getProductPiecesIncluded());
        cmd.setProductRequireAmount(state.getProductRequireAmount());
        cmd.setProductFixedAmount(state.getProductFixedAmount());
        cmd.setProductAmountUomTypeId(state.getProductAmountUomTypeId());
        cmd.setProductWeightUomId(state.getProductWeightUomId());
        cmd.setProductShippingWeight(state.getProductShippingWeight());
        cmd.setProductProductWeight(state.getProductProductWeight());
        cmd.setProductHeightUomId(state.getProductHeightUomId());
        cmd.setProductProductHeight(state.getProductProductHeight());
        cmd.setProductShippingHeight(state.getProductShippingHeight());
        cmd.setProductWidthUomId(state.getProductWidthUomId());
        cmd.setProductProductWidth(state.getProductProductWidth());
        cmd.setProductShippingWidth(state.getProductShippingWidth());
        cmd.setProductDepthUomId(state.getProductDepthUomId());
        cmd.setProductProductDepth(state.getProductProductDepth());
        cmd.setProductShippingDepth(state.getProductShippingDepth());
        cmd.setProductDiameterUomId(state.getProductDiameterUomId());
        cmd.setProductProductDiameter(state.getProductProductDiameter());
        cmd.setProductProductRating(state.getProductProductRating());
        cmd.setProductRatingTypeEnum(state.getProductRatingTypeEnum());
        cmd.setProductReturnable(state.getProductReturnable());
        cmd.setProductTaxable(state.getProductTaxable());
        cmd.setProductChargeShipping(state.getProductChargeShipping());
        cmd.setProductAutoCreateKeywords(state.getProductAutoCreateKeywords());
        cmd.setProductIncludeInPromotions(state.getProductIncludeInPromotions());
        cmd.setProductIsVirtual(state.getProductIsVirtual());
        cmd.setProductIsVariant(state.getProductIsVariant());
        cmd.setProductVirtualVariantMethodEnum(state.getProductVirtualVariantMethodEnum());
        cmd.setProductInShippingBox(state.getProductInShippingBox());
        cmd.setProductDefaultShipmentBoxTypeId(state.getProductDefaultShipmentBoxTypeId());
        cmd.setProductIsSerialNumbered(state.getProductIsSerialNumbered());
        cmd.setProductIsManagedByLot(state.getProductIsManagedByLot());
        cmd.setProductAttributeSetId(state.getProductAttributeSetId());
        cmd.setProductAttributeSetInstanceId(state.getProductAttributeSetInstanceId());
        cmd.setProductCreatedBy(state.getProductCreatedBy());
        cmd.setProductCreatedAt(state.getProductCreatedAt());
        cmd.setProductUpdatedBy(state.getProductUpdatedBy());
        cmd.setProductUpdatedAt(state.getProductUpdatedAt());
        cmd.setProductActive(state.getProductActive());
            
        if (state.getIdValue() == null) { cmd.setIsPropertyIdValueRemoved(true); }
        if (state.getVersion() == null) { cmd.setIsPropertyVersionRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        if (state.getProductProductTypeId() == null) { cmd.setIsPropertyProductProductTypeIdRemoved(true); }
        if (state.getProductPrimaryProductCategoryId() == null) { cmd.setIsPropertyProductPrimaryProductCategoryIdRemoved(true); }
        if (state.getProductManufacturerPartyId() == null) { cmd.setIsPropertyProductManufacturerPartyIdRemoved(true); }
        if (state.getProductFacilityId() == null) { cmd.setIsPropertyProductFacilityIdRemoved(true); }
        if (state.getProductIntroductionDate() == null) { cmd.setIsPropertyProductIntroductionDateRemoved(true); }
        if (state.getProductReleaseDate() == null) { cmd.setIsPropertyProductReleaseDateRemoved(true); }
        if (state.getProductSupportDiscontinuationDate() == null) { cmd.setIsPropertyProductSupportDiscontinuationDateRemoved(true); }
        if (state.getProductSalesDiscontinuationDate() == null) { cmd.setIsPropertyProductSalesDiscontinuationDateRemoved(true); }
        if (state.getProductSalesDiscWhenNotAvail() == null) { cmd.setIsPropertyProductSalesDiscWhenNotAvailRemoved(true); }
        if (state.getProductInternalName() == null) { cmd.setIsPropertyProductInternalNameRemoved(true); }
        if (state.getProductBrandName() == null) { cmd.setIsPropertyProductBrandNameRemoved(true); }
        if (state.getProductComments() == null) { cmd.setIsPropertyProductCommentsRemoved(true); }
        if (state.getProductProductName() == null) { cmd.setIsPropertyProductProductNameRemoved(true); }
        if (state.getProductDescription() == null) { cmd.setIsPropertyProductDescriptionRemoved(true); }
        if (state.getProductPriceDetailText() == null) { cmd.setIsPropertyProductPriceDetailTextRemoved(true); }
        if (state.getProductSmallImageUrl() == null) { cmd.setIsPropertyProductSmallImageUrlRemoved(true); }
        if (state.getProductMediumImageUrl() == null) { cmd.setIsPropertyProductMediumImageUrlRemoved(true); }
        if (state.getProductLargeImageUrl() == null) { cmd.setIsPropertyProductLargeImageUrlRemoved(true); }
        if (state.getProductDetailImageUrl() == null) { cmd.setIsPropertyProductDetailImageUrlRemoved(true); }
        if (state.getProductOriginalImageUrl() == null) { cmd.setIsPropertyProductOriginalImageUrlRemoved(true); }
        if (state.getProductDetailScreen() == null) { cmd.setIsPropertyProductDetailScreenRemoved(true); }
        if (state.getProductInventoryMessage() == null) { cmd.setIsPropertyProductInventoryMessageRemoved(true); }
        if (state.getProductInventoryItemTypeId() == null) { cmd.setIsPropertyProductInventoryItemTypeIdRemoved(true); }
        if (state.getProductRequireInventory() == null) { cmd.setIsPropertyProductRequireInventoryRemoved(true); }
        if (state.getProductQuantityUomId() == null) { cmd.setIsPropertyProductQuantityUomIdRemoved(true); }
        if (state.getProductQuantityIncluded() == null) { cmd.setIsPropertyProductQuantityIncludedRemoved(true); }
        if (state.getProductPiecesIncluded() == null) { cmd.setIsPropertyProductPiecesIncludedRemoved(true); }
        if (state.getProductRequireAmount() == null) { cmd.setIsPropertyProductRequireAmountRemoved(true); }
        if (state.getProductFixedAmount() == null) { cmd.setIsPropertyProductFixedAmountRemoved(true); }
        if (state.getProductAmountUomTypeId() == null) { cmd.setIsPropertyProductAmountUomTypeIdRemoved(true); }
        if (state.getProductWeightUomId() == null) { cmd.setIsPropertyProductWeightUomIdRemoved(true); }
        if (state.getProductShippingWeight() == null) { cmd.setIsPropertyProductShippingWeightRemoved(true); }
        if (state.getProductProductWeight() == null) { cmd.setIsPropertyProductProductWeightRemoved(true); }
        if (state.getProductHeightUomId() == null) { cmd.setIsPropertyProductHeightUomIdRemoved(true); }
        if (state.getProductProductHeight() == null) { cmd.setIsPropertyProductProductHeightRemoved(true); }
        if (state.getProductShippingHeight() == null) { cmd.setIsPropertyProductShippingHeightRemoved(true); }
        if (state.getProductWidthUomId() == null) { cmd.setIsPropertyProductWidthUomIdRemoved(true); }
        if (state.getProductProductWidth() == null) { cmd.setIsPropertyProductProductWidthRemoved(true); }
        if (state.getProductShippingWidth() == null) { cmd.setIsPropertyProductShippingWidthRemoved(true); }
        if (state.getProductDepthUomId() == null) { cmd.setIsPropertyProductDepthUomIdRemoved(true); }
        if (state.getProductProductDepth() == null) { cmd.setIsPropertyProductProductDepthRemoved(true); }
        if (state.getProductShippingDepth() == null) { cmd.setIsPropertyProductShippingDepthRemoved(true); }
        if (state.getProductDiameterUomId() == null) { cmd.setIsPropertyProductDiameterUomIdRemoved(true); }
        if (state.getProductProductDiameter() == null) { cmd.setIsPropertyProductProductDiameterRemoved(true); }
        if (state.getProductProductRating() == null) { cmd.setIsPropertyProductProductRatingRemoved(true); }
        if (state.getProductRatingTypeEnum() == null) { cmd.setIsPropertyProductRatingTypeEnumRemoved(true); }
        if (state.getProductReturnable() == null) { cmd.setIsPropertyProductReturnableRemoved(true); }
        if (state.getProductTaxable() == null) { cmd.setIsPropertyProductTaxableRemoved(true); }
        if (state.getProductChargeShipping() == null) { cmd.setIsPropertyProductChargeShippingRemoved(true); }
        if (state.getProductAutoCreateKeywords() == null) { cmd.setIsPropertyProductAutoCreateKeywordsRemoved(true); }
        if (state.getProductIncludeInPromotions() == null) { cmd.setIsPropertyProductIncludeInPromotionsRemoved(true); }
        if (state.getProductIsVirtual() == null) { cmd.setIsPropertyProductIsVirtualRemoved(true); }
        if (state.getProductIsVariant() == null) { cmd.setIsPropertyProductIsVariantRemoved(true); }
        if (state.getProductVirtualVariantMethodEnum() == null) { cmd.setIsPropertyProductVirtualVariantMethodEnumRemoved(true); }
        if (state.getProductInShippingBox() == null) { cmd.setIsPropertyProductInShippingBoxRemoved(true); }
        if (state.getProductDefaultShipmentBoxTypeId() == null) { cmd.setIsPropertyProductDefaultShipmentBoxTypeIdRemoved(true); }
        if (state.getProductIsSerialNumbered() == null) { cmd.setIsPropertyProductIsSerialNumberedRemoved(true); }
        if (state.getProductIsManagedByLot() == null) { cmd.setIsPropertyProductIsManagedByLotRemoved(true); }
        if (state.getProductAttributeSetId() == null) { cmd.setIsPropertyProductAttributeSetIdRemoved(true); }
        if (state.getProductAttributeSetInstanceId() == null) { cmd.setIsPropertyProductAttributeSetInstanceIdRemoved(true); }
        if (state.getProductCreatedBy() == null) { cmd.setIsPropertyProductCreatedByRemoved(true); }
        if (state.getProductCreatedAt() == null) { cmd.setIsPropertyProductCreatedAtRemoved(true); }
        if (state.getProductUpdatedBy() == null) { cmd.setIsPropertyProductUpdatedByRemoved(true); }
        if (state.getProductUpdatedAt() == null) { cmd.setIsPropertyProductUpdatedAtRemoved(true); }
        if (state.getProductActive() == null) { cmd.setIsPropertyProductActiveRemoved(true); }
        return cmd;
    }

    public TCreateGoodIdentificationMvo toCreateGoodIdentificationMvo(GoodIdentificationMvoState state) //where TCreateGoodIdentificationMvo : ICreateGoodIdentificationMvo, new()
    {
        TCreateGoodIdentificationMvo cmd = newCreateGoodIdentificationMvo();

        cmd.setProductVersion(state.getProductVersion());
        cmd.setProductGoodIdentificationId(state.getProductGoodIdentificationId());
        cmd.setIdValue(state.getIdValue());
        cmd.setVersion(state.getVersion());
        cmd.setActive(state.getActive());
        cmd.setProductProductTypeId(state.getProductProductTypeId());
        cmd.setProductPrimaryProductCategoryId(state.getProductPrimaryProductCategoryId());
        cmd.setProductManufacturerPartyId(state.getProductManufacturerPartyId());
        cmd.setProductFacilityId(state.getProductFacilityId());
        cmd.setProductIntroductionDate(state.getProductIntroductionDate());
        cmd.setProductReleaseDate(state.getProductReleaseDate());
        cmd.setProductSupportDiscontinuationDate(state.getProductSupportDiscontinuationDate());
        cmd.setProductSalesDiscontinuationDate(state.getProductSalesDiscontinuationDate());
        cmd.setProductSalesDiscWhenNotAvail(state.getProductSalesDiscWhenNotAvail());
        cmd.setProductInternalName(state.getProductInternalName());
        cmd.setProductBrandName(state.getProductBrandName());
        cmd.setProductComments(state.getProductComments());
        cmd.setProductProductName(state.getProductProductName());
        cmd.setProductDescription(state.getProductDescription());
        cmd.setProductPriceDetailText(state.getProductPriceDetailText());
        cmd.setProductSmallImageUrl(state.getProductSmallImageUrl());
        cmd.setProductMediumImageUrl(state.getProductMediumImageUrl());
        cmd.setProductLargeImageUrl(state.getProductLargeImageUrl());
        cmd.setProductDetailImageUrl(state.getProductDetailImageUrl());
        cmd.setProductOriginalImageUrl(state.getProductOriginalImageUrl());
        cmd.setProductDetailScreen(state.getProductDetailScreen());
        cmd.setProductInventoryMessage(state.getProductInventoryMessage());
        cmd.setProductInventoryItemTypeId(state.getProductInventoryItemTypeId());
        cmd.setProductRequireInventory(state.getProductRequireInventory());
        cmd.setProductQuantityUomId(state.getProductQuantityUomId());
        cmd.setProductQuantityIncluded(state.getProductQuantityIncluded());
        cmd.setProductPiecesIncluded(state.getProductPiecesIncluded());
        cmd.setProductRequireAmount(state.getProductRequireAmount());
        cmd.setProductFixedAmount(state.getProductFixedAmount());
        cmd.setProductAmountUomTypeId(state.getProductAmountUomTypeId());
        cmd.setProductWeightUomId(state.getProductWeightUomId());
        cmd.setProductShippingWeight(state.getProductShippingWeight());
        cmd.setProductProductWeight(state.getProductProductWeight());
        cmd.setProductHeightUomId(state.getProductHeightUomId());
        cmd.setProductProductHeight(state.getProductProductHeight());
        cmd.setProductShippingHeight(state.getProductShippingHeight());
        cmd.setProductWidthUomId(state.getProductWidthUomId());
        cmd.setProductProductWidth(state.getProductProductWidth());
        cmd.setProductShippingWidth(state.getProductShippingWidth());
        cmd.setProductDepthUomId(state.getProductDepthUomId());
        cmd.setProductProductDepth(state.getProductProductDepth());
        cmd.setProductShippingDepth(state.getProductShippingDepth());
        cmd.setProductDiameterUomId(state.getProductDiameterUomId());
        cmd.setProductProductDiameter(state.getProductProductDiameter());
        cmd.setProductProductRating(state.getProductProductRating());
        cmd.setProductRatingTypeEnum(state.getProductRatingTypeEnum());
        cmd.setProductReturnable(state.getProductReturnable());
        cmd.setProductTaxable(state.getProductTaxable());
        cmd.setProductChargeShipping(state.getProductChargeShipping());
        cmd.setProductAutoCreateKeywords(state.getProductAutoCreateKeywords());
        cmd.setProductIncludeInPromotions(state.getProductIncludeInPromotions());
        cmd.setProductIsVirtual(state.getProductIsVirtual());
        cmd.setProductIsVariant(state.getProductIsVariant());
        cmd.setProductVirtualVariantMethodEnum(state.getProductVirtualVariantMethodEnum());
        cmd.setProductInShippingBox(state.getProductInShippingBox());
        cmd.setProductDefaultShipmentBoxTypeId(state.getProductDefaultShipmentBoxTypeId());
        cmd.setProductIsSerialNumbered(state.getProductIsSerialNumbered());
        cmd.setProductIsManagedByLot(state.getProductIsManagedByLot());
        cmd.setProductAttributeSetId(state.getProductAttributeSetId());
        cmd.setProductAttributeSetInstanceId(state.getProductAttributeSetInstanceId());
        cmd.setProductCreatedBy(state.getProductCreatedBy());
        cmd.setProductCreatedAt(state.getProductCreatedAt());
        cmd.setProductUpdatedBy(state.getProductUpdatedBy());
        cmd.setProductUpdatedAt(state.getProductUpdatedAt());
        cmd.setProductActive(state.getProductActive());
        return cmd;
    }

    protected abstract TCreateGoodIdentificationMvo newCreateGoodIdentificationMvo();

    protected abstract TMergePatchGoodIdentificationMvo newMergePatchGoodIdentificationMvo(); 

    protected abstract TDeleteGoodIdentificationMvo newDeleteGoodIdentificationMvo();

    public static class SimpleGoodIdentificationMvoStateCommandConverter extends AbstractGoodIdentificationMvoStateCommandConverter<AbstractGoodIdentificationMvoCommand.SimpleCreateGoodIdentificationMvo, AbstractGoodIdentificationMvoCommand.SimpleMergePatchGoodIdentificationMvo, AbstractGoodIdentificationMvoCommand.SimpleDeleteGoodIdentificationMvo>
    {
        @Override
        protected AbstractGoodIdentificationMvoCommand.SimpleCreateGoodIdentificationMvo newCreateGoodIdentificationMvo() {
            return new AbstractGoodIdentificationMvoCommand.SimpleCreateGoodIdentificationMvo();
        }

        @Override
        protected AbstractGoodIdentificationMvoCommand.SimpleMergePatchGoodIdentificationMvo newMergePatchGoodIdentificationMvo() {
            return new AbstractGoodIdentificationMvoCommand.SimpleMergePatchGoodIdentificationMvo();
        }

        @Override
        protected AbstractGoodIdentificationMvoCommand.SimpleDeleteGoodIdentificationMvo newDeleteGoodIdentificationMvo() {
            return new AbstractGoodIdentificationMvoCommand.SimpleDeleteGoodIdentificationMvo();
        }


    }

}

