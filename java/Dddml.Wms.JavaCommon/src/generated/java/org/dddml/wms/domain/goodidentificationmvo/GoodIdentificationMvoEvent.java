package org.dddml.wms.domain.goodidentificationmvo;

import java.util.*;
import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface GoodIdentificationMvoEvent extends Event
{
    GoodIdentificationMvoEventId getGoodIdentificationMvoEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface GoodIdentificationMvoStateEvent extends GoodIdentificationMvoEvent {
        String getIdValue();

        void setIdValue(String idValue);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getProductProductTypeId();

        void setProductProductTypeId(String productProductTypeId);

        String getProductPrimaryProductCategoryId();

        void setProductPrimaryProductCategoryId(String productPrimaryProductCategoryId);

        String getProductManufacturerPartyId();

        void setProductManufacturerPartyId(String productManufacturerPartyId);

        String getProductFacilityId();

        void setProductFacilityId(String productFacilityId);

        java.sql.Timestamp getProductIntroductionDate();

        void setProductIntroductionDate(java.sql.Timestamp productIntroductionDate);

        java.sql.Timestamp getProductReleaseDate();

        void setProductReleaseDate(java.sql.Timestamp productReleaseDate);

        java.sql.Timestamp getProductSupportDiscontinuationDate();

        void setProductSupportDiscontinuationDate(java.sql.Timestamp productSupportDiscontinuationDate);

        java.sql.Timestamp getProductSalesDiscontinuationDate();

        void setProductSalesDiscontinuationDate(java.sql.Timestamp productSalesDiscontinuationDate);

        String getProductSalesDiscWhenNotAvail();

        void setProductSalesDiscWhenNotAvail(String productSalesDiscWhenNotAvail);

        String getProductInternalName();

        void setProductInternalName(String productInternalName);

        String getProductBrandName();

        void setProductBrandName(String productBrandName);

        String getProductComments();

        void setProductComments(String productComments);

        String getProductProductName();

        void setProductProductName(String productProductName);

        String getProductDescription();

        void setProductDescription(String productDescription);

        String getProductPriceDetailText();

        void setProductPriceDetailText(String productPriceDetailText);

        String getProductSmallImageUrl();

        void setProductSmallImageUrl(String productSmallImageUrl);

        String getProductMediumImageUrl();

        void setProductMediumImageUrl(String productMediumImageUrl);

        String getProductLargeImageUrl();

        void setProductLargeImageUrl(String productLargeImageUrl);

        String getProductDetailImageUrl();

        void setProductDetailImageUrl(String productDetailImageUrl);

        String getProductOriginalImageUrl();

        void setProductOriginalImageUrl(String productOriginalImageUrl);

        String getProductDetailScreen();

        void setProductDetailScreen(String productDetailScreen);

        String getProductInventoryMessage();

        void setProductInventoryMessage(String productInventoryMessage);

        String getProductInventoryItemTypeId();

        void setProductInventoryItemTypeId(String productInventoryItemTypeId);

        String getProductRequireInventory();

        void setProductRequireInventory(String productRequireInventory);

        String getProductQuantityUomId();

        void setProductQuantityUomId(String productQuantityUomId);

        java.math.BigDecimal getProductQuantityIncluded();

        void setProductQuantityIncluded(java.math.BigDecimal productQuantityIncluded);

        Long getProductPiecesIncluded();

        void setProductPiecesIncluded(Long productPiecesIncluded);

        String getProductRequireAmount();

        void setProductRequireAmount(String productRequireAmount);

        java.math.BigDecimal getProductFixedAmount();

        void setProductFixedAmount(java.math.BigDecimal productFixedAmount);

        String getProductAmountUomTypeId();

        void setProductAmountUomTypeId(String productAmountUomTypeId);

        String getProductWeightUomId();

        void setProductWeightUomId(String productWeightUomId);

        java.math.BigDecimal getProductShippingWeight();

        void setProductShippingWeight(java.math.BigDecimal productShippingWeight);

        java.math.BigDecimal getProductProductWeight();

        void setProductProductWeight(java.math.BigDecimal productProductWeight);

        String getProductHeightUomId();

        void setProductHeightUomId(String productHeightUomId);

        java.math.BigDecimal getProductProductHeight();

        void setProductProductHeight(java.math.BigDecimal productProductHeight);

        java.math.BigDecimal getProductShippingHeight();

        void setProductShippingHeight(java.math.BigDecimal productShippingHeight);

        String getProductWidthUomId();

        void setProductWidthUomId(String productWidthUomId);

        java.math.BigDecimal getProductProductWidth();

        void setProductProductWidth(java.math.BigDecimal productProductWidth);

        java.math.BigDecimal getProductShippingWidth();

        void setProductShippingWidth(java.math.BigDecimal productShippingWidth);

        String getProductDepthUomId();

        void setProductDepthUomId(String productDepthUomId);

        java.math.BigDecimal getProductProductDepth();

        void setProductProductDepth(java.math.BigDecimal productProductDepth);

        java.math.BigDecimal getProductShippingDepth();

        void setProductShippingDepth(java.math.BigDecimal productShippingDepth);

        String getProductDiameterUomId();

        void setProductDiameterUomId(String productDiameterUomId);

        java.math.BigDecimal getProductProductDiameter();

        void setProductProductDiameter(java.math.BigDecimal productProductDiameter);

        java.math.BigDecimal getProductProductRating();

        void setProductProductRating(java.math.BigDecimal productProductRating);

        String getProductRatingTypeEnum();

        void setProductRatingTypeEnum(String productRatingTypeEnum);

        String getProductReturnable();

        void setProductReturnable(String productReturnable);

        String getProductTaxable();

        void setProductTaxable(String productTaxable);

        String getProductChargeShipping();

        void setProductChargeShipping(String productChargeShipping);

        String getProductAutoCreateKeywords();

        void setProductAutoCreateKeywords(String productAutoCreateKeywords);

        String getProductIncludeInPromotions();

        void setProductIncludeInPromotions(String productIncludeInPromotions);

        String getProductIsVirtual();

        void setProductIsVirtual(String productIsVirtual);

        String getProductIsVariant();

        void setProductIsVariant(String productIsVariant);

        String getProductVirtualVariantMethodEnum();

        void setProductVirtualVariantMethodEnum(String productVirtualVariantMethodEnum);

        String getProductInShippingBox();

        void setProductInShippingBox(String productInShippingBox);

        String getProductDefaultShipmentBoxTypeId();

        void setProductDefaultShipmentBoxTypeId(String productDefaultShipmentBoxTypeId);

        Boolean getProductIsSerialNumbered();

        void setProductIsSerialNumbered(Boolean productIsSerialNumbered);

        Boolean getProductIsManagedByLot();

        void setProductIsManagedByLot(Boolean productIsManagedByLot);

        String getProductAttributeSetId();

        void setProductAttributeSetId(String productAttributeSetId);

        String getProductAttributeSetInstanceId();

        void setProductAttributeSetInstanceId(String productAttributeSetInstanceId);

        String getProductCreatedBy();

        void setProductCreatedBy(String productCreatedBy);

        Date getProductCreatedAt();

        void setProductCreatedAt(Date productCreatedAt);

        String getProductUpdatedBy();

        void setProductUpdatedBy(String productUpdatedBy);

        Date getProductUpdatedAt();

        void setProductUpdatedAt(Date productUpdatedAt);

        Boolean getProductActive();

        void setProductActive(Boolean productActive);

    }

    interface GoodIdentificationMvoStateCreated extends GoodIdentificationMvoStateEvent
    {
    
    }


    interface GoodIdentificationMvoStateMergePatched extends GoodIdentificationMvoStateEvent
    {
        Boolean getIsPropertyIdValueRemoved();

        void setIsPropertyIdValueRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyProductProductTypeIdRemoved();

        void setIsPropertyProductProductTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyProductPrimaryProductCategoryIdRemoved();

        void setIsPropertyProductPrimaryProductCategoryIdRemoved(Boolean removed);

        Boolean getIsPropertyProductManufacturerPartyIdRemoved();

        void setIsPropertyProductManufacturerPartyIdRemoved(Boolean removed);

        Boolean getIsPropertyProductFacilityIdRemoved();

        void setIsPropertyProductFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyProductIntroductionDateRemoved();

        void setIsPropertyProductIntroductionDateRemoved(Boolean removed);

        Boolean getIsPropertyProductReleaseDateRemoved();

        void setIsPropertyProductReleaseDateRemoved(Boolean removed);

        Boolean getIsPropertyProductSupportDiscontinuationDateRemoved();

        void setIsPropertyProductSupportDiscontinuationDateRemoved(Boolean removed);

        Boolean getIsPropertyProductSalesDiscontinuationDateRemoved();

        void setIsPropertyProductSalesDiscontinuationDateRemoved(Boolean removed);

        Boolean getIsPropertyProductSalesDiscWhenNotAvailRemoved();

        void setIsPropertyProductSalesDiscWhenNotAvailRemoved(Boolean removed);

        Boolean getIsPropertyProductInternalNameRemoved();

        void setIsPropertyProductInternalNameRemoved(Boolean removed);

        Boolean getIsPropertyProductBrandNameRemoved();

        void setIsPropertyProductBrandNameRemoved(Boolean removed);

        Boolean getIsPropertyProductCommentsRemoved();

        void setIsPropertyProductCommentsRemoved(Boolean removed);

        Boolean getIsPropertyProductProductNameRemoved();

        void setIsPropertyProductProductNameRemoved(Boolean removed);

        Boolean getIsPropertyProductDescriptionRemoved();

        void setIsPropertyProductDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyProductPriceDetailTextRemoved();

        void setIsPropertyProductPriceDetailTextRemoved(Boolean removed);

        Boolean getIsPropertyProductSmallImageUrlRemoved();

        void setIsPropertyProductSmallImageUrlRemoved(Boolean removed);

        Boolean getIsPropertyProductMediumImageUrlRemoved();

        void setIsPropertyProductMediumImageUrlRemoved(Boolean removed);

        Boolean getIsPropertyProductLargeImageUrlRemoved();

        void setIsPropertyProductLargeImageUrlRemoved(Boolean removed);

        Boolean getIsPropertyProductDetailImageUrlRemoved();

        void setIsPropertyProductDetailImageUrlRemoved(Boolean removed);

        Boolean getIsPropertyProductOriginalImageUrlRemoved();

        void setIsPropertyProductOriginalImageUrlRemoved(Boolean removed);

        Boolean getIsPropertyProductDetailScreenRemoved();

        void setIsPropertyProductDetailScreenRemoved(Boolean removed);

        Boolean getIsPropertyProductInventoryMessageRemoved();

        void setIsPropertyProductInventoryMessageRemoved(Boolean removed);

        Boolean getIsPropertyProductInventoryItemTypeIdRemoved();

        void setIsPropertyProductInventoryItemTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyProductRequireInventoryRemoved();

        void setIsPropertyProductRequireInventoryRemoved(Boolean removed);

        Boolean getIsPropertyProductQuantityUomIdRemoved();

        void setIsPropertyProductQuantityUomIdRemoved(Boolean removed);

        Boolean getIsPropertyProductQuantityIncludedRemoved();

        void setIsPropertyProductQuantityIncludedRemoved(Boolean removed);

        Boolean getIsPropertyProductPiecesIncludedRemoved();

        void setIsPropertyProductPiecesIncludedRemoved(Boolean removed);

        Boolean getIsPropertyProductRequireAmountRemoved();

        void setIsPropertyProductRequireAmountRemoved(Boolean removed);

        Boolean getIsPropertyProductFixedAmountRemoved();

        void setIsPropertyProductFixedAmountRemoved(Boolean removed);

        Boolean getIsPropertyProductAmountUomTypeIdRemoved();

        void setIsPropertyProductAmountUomTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyProductWeightUomIdRemoved();

        void setIsPropertyProductWeightUomIdRemoved(Boolean removed);

        Boolean getIsPropertyProductShippingWeightRemoved();

        void setIsPropertyProductShippingWeightRemoved(Boolean removed);

        Boolean getIsPropertyProductProductWeightRemoved();

        void setIsPropertyProductProductWeightRemoved(Boolean removed);

        Boolean getIsPropertyProductHeightUomIdRemoved();

        void setIsPropertyProductHeightUomIdRemoved(Boolean removed);

        Boolean getIsPropertyProductProductHeightRemoved();

        void setIsPropertyProductProductHeightRemoved(Boolean removed);

        Boolean getIsPropertyProductShippingHeightRemoved();

        void setIsPropertyProductShippingHeightRemoved(Boolean removed);

        Boolean getIsPropertyProductWidthUomIdRemoved();

        void setIsPropertyProductWidthUomIdRemoved(Boolean removed);

        Boolean getIsPropertyProductProductWidthRemoved();

        void setIsPropertyProductProductWidthRemoved(Boolean removed);

        Boolean getIsPropertyProductShippingWidthRemoved();

        void setIsPropertyProductShippingWidthRemoved(Boolean removed);

        Boolean getIsPropertyProductDepthUomIdRemoved();

        void setIsPropertyProductDepthUomIdRemoved(Boolean removed);

        Boolean getIsPropertyProductProductDepthRemoved();

        void setIsPropertyProductProductDepthRemoved(Boolean removed);

        Boolean getIsPropertyProductShippingDepthRemoved();

        void setIsPropertyProductShippingDepthRemoved(Boolean removed);

        Boolean getIsPropertyProductDiameterUomIdRemoved();

        void setIsPropertyProductDiameterUomIdRemoved(Boolean removed);

        Boolean getIsPropertyProductProductDiameterRemoved();

        void setIsPropertyProductProductDiameterRemoved(Boolean removed);

        Boolean getIsPropertyProductProductRatingRemoved();

        void setIsPropertyProductProductRatingRemoved(Boolean removed);

        Boolean getIsPropertyProductRatingTypeEnumRemoved();

        void setIsPropertyProductRatingTypeEnumRemoved(Boolean removed);

        Boolean getIsPropertyProductReturnableRemoved();

        void setIsPropertyProductReturnableRemoved(Boolean removed);

        Boolean getIsPropertyProductTaxableRemoved();

        void setIsPropertyProductTaxableRemoved(Boolean removed);

        Boolean getIsPropertyProductChargeShippingRemoved();

        void setIsPropertyProductChargeShippingRemoved(Boolean removed);

        Boolean getIsPropertyProductAutoCreateKeywordsRemoved();

        void setIsPropertyProductAutoCreateKeywordsRemoved(Boolean removed);

        Boolean getIsPropertyProductIncludeInPromotionsRemoved();

        void setIsPropertyProductIncludeInPromotionsRemoved(Boolean removed);

        Boolean getIsPropertyProductIsVirtualRemoved();

        void setIsPropertyProductIsVirtualRemoved(Boolean removed);

        Boolean getIsPropertyProductIsVariantRemoved();

        void setIsPropertyProductIsVariantRemoved(Boolean removed);

        Boolean getIsPropertyProductVirtualVariantMethodEnumRemoved();

        void setIsPropertyProductVirtualVariantMethodEnumRemoved(Boolean removed);

        Boolean getIsPropertyProductInShippingBoxRemoved();

        void setIsPropertyProductInShippingBoxRemoved(Boolean removed);

        Boolean getIsPropertyProductDefaultShipmentBoxTypeIdRemoved();

        void setIsPropertyProductDefaultShipmentBoxTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyProductIsSerialNumberedRemoved();

        void setIsPropertyProductIsSerialNumberedRemoved(Boolean removed);

        Boolean getIsPropertyProductIsManagedByLotRemoved();

        void setIsPropertyProductIsManagedByLotRemoved(Boolean removed);

        Boolean getIsPropertyProductAttributeSetIdRemoved();

        void setIsPropertyProductAttributeSetIdRemoved(Boolean removed);

        Boolean getIsPropertyProductAttributeSetInstanceIdRemoved();

        void setIsPropertyProductAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyProductCreatedByRemoved();

        void setIsPropertyProductCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyProductCreatedAtRemoved();

        void setIsPropertyProductCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyProductUpdatedByRemoved();

        void setIsPropertyProductUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyProductUpdatedAtRemoved();

        void setIsPropertyProductUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyProductActiveRemoved();

        void setIsPropertyProductActiveRemoved(Boolean removed);


    }

    interface GoodIdentificationMvoStateDeleted extends GoodIdentificationMvoStateEvent
    {
    }


}

