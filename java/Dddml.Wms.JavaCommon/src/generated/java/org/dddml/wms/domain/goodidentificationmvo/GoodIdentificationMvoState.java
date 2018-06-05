package org.dddml.wms.domain.goodidentificationmvo;

import java.util.Set;
import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.goodidentificationmvo.GoodIdentificationMvoEvent.*;

public interface GoodIdentificationMvoState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    ProductGoodIdentificationId getProductGoodIdentificationId();

    void setProductGoodIdentificationId(ProductGoodIdentificationId productGoodIdentificationId);

    String getIdValue();

    void setIdValue(String idValue);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

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

    Long getProductVersion();

    void setProductVersion(Long productVersion);

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


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(GoodIdentificationMvoEvent.GoodIdentificationMvoStateCreated e);

    void when(GoodIdentificationMvoEvent.GoodIdentificationMvoStateMergePatched e);

    void when(GoodIdentificationMvoEvent.GoodIdentificationMvoStateDeleted e);
    
}

