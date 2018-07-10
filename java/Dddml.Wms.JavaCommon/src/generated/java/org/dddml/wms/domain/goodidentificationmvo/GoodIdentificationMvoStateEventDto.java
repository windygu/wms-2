package org.dddml.wms.domain.goodidentificationmvo;

import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractEvent;

public class GoodIdentificationMvoStateEventDto extends AbstractEvent
{

    private GoodIdentificationMvoEventId goodIdentificationMvoEventId;

    GoodIdentificationMvoEventId getGoodIdentificationMvoEventId() {
        if (goodIdentificationMvoEventId == null) { goodIdentificationMvoEventId = new GoodIdentificationMvoEventId(); }
        return goodIdentificationMvoEventId;
    }

    void setGoodIdentificationMvoEventId(GoodIdentificationMvoEventId eventId) {
        this.goodIdentificationMvoEventId = eventId;
    }

    public ProductGoodIdentificationId getProductGoodIdentificationId() {
        return getGoodIdentificationMvoEventId().getProductGoodIdentificationId();
    }

    public void setProductGoodIdentificationId(ProductGoodIdentificationId productGoodIdentificationId) {
        getGoodIdentificationMvoEventId().setProductGoodIdentificationId(productGoodIdentificationId);
    }

    public Long getProductVersion() {
        return getGoodIdentificationMvoEventId().getProductVersion();
    }
    
    public void getProductVersion(Long productVersion) {
        getGoodIdentificationMvoEventId().setProductVersion(productVersion);
    }

    private String idValue;

    public String getIdValue() {
        return this.idValue;
    }

    public void setIdValue(String idValue) {
        this.idValue = idValue;
    }

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private String productProductTypeId;

    public String getProductProductTypeId() {
        return this.productProductTypeId;
    }

    public void setProductProductTypeId(String productProductTypeId) {
        this.productProductTypeId = productProductTypeId;
    }

    private String productPrimaryProductCategoryId;

    public String getProductPrimaryProductCategoryId() {
        return this.productPrimaryProductCategoryId;
    }

    public void setProductPrimaryProductCategoryId(String productPrimaryProductCategoryId) {
        this.productPrimaryProductCategoryId = productPrimaryProductCategoryId;
    }

    private String productManufacturerPartyId;

    public String getProductManufacturerPartyId() {
        return this.productManufacturerPartyId;
    }

    public void setProductManufacturerPartyId(String productManufacturerPartyId) {
        this.productManufacturerPartyId = productManufacturerPartyId;
    }

    private String productFacilityId;

    public String getProductFacilityId() {
        return this.productFacilityId;
    }

    public void setProductFacilityId(String productFacilityId) {
        this.productFacilityId = productFacilityId;
    }

    private java.sql.Timestamp productIntroductionDate;

    public java.sql.Timestamp getProductIntroductionDate() {
        return this.productIntroductionDate;
    }

    public void setProductIntroductionDate(java.sql.Timestamp productIntroductionDate) {
        this.productIntroductionDate = productIntroductionDate;
    }

    private java.sql.Timestamp productReleaseDate;

    public java.sql.Timestamp getProductReleaseDate() {
        return this.productReleaseDate;
    }

    public void setProductReleaseDate(java.sql.Timestamp productReleaseDate) {
        this.productReleaseDate = productReleaseDate;
    }

    private java.sql.Timestamp productSupportDiscontinuationDate;

    public java.sql.Timestamp getProductSupportDiscontinuationDate() {
        return this.productSupportDiscontinuationDate;
    }

    public void setProductSupportDiscontinuationDate(java.sql.Timestamp productSupportDiscontinuationDate) {
        this.productSupportDiscontinuationDate = productSupportDiscontinuationDate;
    }

    private java.sql.Timestamp productSalesDiscontinuationDate;

    public java.sql.Timestamp getProductSalesDiscontinuationDate() {
        return this.productSalesDiscontinuationDate;
    }

    public void setProductSalesDiscontinuationDate(java.sql.Timestamp productSalesDiscontinuationDate) {
        this.productSalesDiscontinuationDate = productSalesDiscontinuationDate;
    }

    private String productSalesDiscWhenNotAvail;

    public String getProductSalesDiscWhenNotAvail() {
        return this.productSalesDiscWhenNotAvail;
    }

    public void setProductSalesDiscWhenNotAvail(String productSalesDiscWhenNotAvail) {
        this.productSalesDiscWhenNotAvail = productSalesDiscWhenNotAvail;
    }

    private String productInternalName;

    public String getProductInternalName() {
        return this.productInternalName;
    }

    public void setProductInternalName(String productInternalName) {
        this.productInternalName = productInternalName;
    }

    private String productBrandName;

    public String getProductBrandName() {
        return this.productBrandName;
    }

    public void setProductBrandName(String productBrandName) {
        this.productBrandName = productBrandName;
    }

    private String productComments;

    public String getProductComments() {
        return this.productComments;
    }

    public void setProductComments(String productComments) {
        this.productComments = productComments;
    }

    private String productProductName;

    public String getProductProductName() {
        return this.productProductName;
    }

    public void setProductProductName(String productProductName) {
        this.productProductName = productProductName;
    }

    private String productDescription;

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    private String productPriceDetailText;

    public String getProductPriceDetailText() {
        return this.productPriceDetailText;
    }

    public void setProductPriceDetailText(String productPriceDetailText) {
        this.productPriceDetailText = productPriceDetailText;
    }

    private String productSmallImageUrl;

    public String getProductSmallImageUrl() {
        return this.productSmallImageUrl;
    }

    public void setProductSmallImageUrl(String productSmallImageUrl) {
        this.productSmallImageUrl = productSmallImageUrl;
    }

    private String productMediumImageUrl;

    public String getProductMediumImageUrl() {
        return this.productMediumImageUrl;
    }

    public void setProductMediumImageUrl(String productMediumImageUrl) {
        this.productMediumImageUrl = productMediumImageUrl;
    }

    private String productLargeImageUrl;

    public String getProductLargeImageUrl() {
        return this.productLargeImageUrl;
    }

    public void setProductLargeImageUrl(String productLargeImageUrl) {
        this.productLargeImageUrl = productLargeImageUrl;
    }

    private String productDetailImageUrl;

    public String getProductDetailImageUrl() {
        return this.productDetailImageUrl;
    }

    public void setProductDetailImageUrl(String productDetailImageUrl) {
        this.productDetailImageUrl = productDetailImageUrl;
    }

    private String productOriginalImageUrl;

    public String getProductOriginalImageUrl() {
        return this.productOriginalImageUrl;
    }

    public void setProductOriginalImageUrl(String productOriginalImageUrl) {
        this.productOriginalImageUrl = productOriginalImageUrl;
    }

    private String productDetailScreen;

    public String getProductDetailScreen() {
        return this.productDetailScreen;
    }

    public void setProductDetailScreen(String productDetailScreen) {
        this.productDetailScreen = productDetailScreen;
    }

    private String productInventoryMessage;

    public String getProductInventoryMessage() {
        return this.productInventoryMessage;
    }

    public void setProductInventoryMessage(String productInventoryMessage) {
        this.productInventoryMessage = productInventoryMessage;
    }

    private String productInventoryItemTypeId;

    public String getProductInventoryItemTypeId() {
        return this.productInventoryItemTypeId;
    }

    public void setProductInventoryItemTypeId(String productInventoryItemTypeId) {
        this.productInventoryItemTypeId = productInventoryItemTypeId;
    }

    private String productRequireInventory;

    public String getProductRequireInventory() {
        return this.productRequireInventory;
    }

    public void setProductRequireInventory(String productRequireInventory) {
        this.productRequireInventory = productRequireInventory;
    }

    private String productQuantityUomId;

    public String getProductQuantityUomId() {
        return this.productQuantityUomId;
    }

    public void setProductQuantityUomId(String productQuantityUomId) {
        this.productQuantityUomId = productQuantityUomId;
    }

    private java.math.BigDecimal productQuantityIncluded;

    public java.math.BigDecimal getProductQuantityIncluded() {
        return this.productQuantityIncluded;
    }

    public void setProductQuantityIncluded(java.math.BigDecimal productQuantityIncluded) {
        this.productQuantityIncluded = productQuantityIncluded;
    }

    private Long productPiecesIncluded;

    public Long getProductPiecesIncluded() {
        return this.productPiecesIncluded;
    }

    public void setProductPiecesIncluded(Long productPiecesIncluded) {
        this.productPiecesIncluded = productPiecesIncluded;
    }

    private String productRequireAmount;

    public String getProductRequireAmount() {
        return this.productRequireAmount;
    }

    public void setProductRequireAmount(String productRequireAmount) {
        this.productRequireAmount = productRequireAmount;
    }

    private java.math.BigDecimal productFixedAmount;

    public java.math.BigDecimal getProductFixedAmount() {
        return this.productFixedAmount;
    }

    public void setProductFixedAmount(java.math.BigDecimal productFixedAmount) {
        this.productFixedAmount = productFixedAmount;
    }

    private String productAmountUomTypeId;

    public String getProductAmountUomTypeId() {
        return this.productAmountUomTypeId;
    }

    public void setProductAmountUomTypeId(String productAmountUomTypeId) {
        this.productAmountUomTypeId = productAmountUomTypeId;
    }

    private String productWeightUomId;

    public String getProductWeightUomId() {
        return this.productWeightUomId;
    }

    public void setProductWeightUomId(String productWeightUomId) {
        this.productWeightUomId = productWeightUomId;
    }

    private java.math.BigDecimal productShippingWeight;

    public java.math.BigDecimal getProductShippingWeight() {
        return this.productShippingWeight;
    }

    public void setProductShippingWeight(java.math.BigDecimal productShippingWeight) {
        this.productShippingWeight = productShippingWeight;
    }

    private java.math.BigDecimal productProductWeight;

    public java.math.BigDecimal getProductProductWeight() {
        return this.productProductWeight;
    }

    public void setProductProductWeight(java.math.BigDecimal productProductWeight) {
        this.productProductWeight = productProductWeight;
    }

    private String productHeightUomId;

    public String getProductHeightUomId() {
        return this.productHeightUomId;
    }

    public void setProductHeightUomId(String productHeightUomId) {
        this.productHeightUomId = productHeightUomId;
    }

    private java.math.BigDecimal productProductHeight;

    public java.math.BigDecimal getProductProductHeight() {
        return this.productProductHeight;
    }

    public void setProductProductHeight(java.math.BigDecimal productProductHeight) {
        this.productProductHeight = productProductHeight;
    }

    private java.math.BigDecimal productShippingHeight;

    public java.math.BigDecimal getProductShippingHeight() {
        return this.productShippingHeight;
    }

    public void setProductShippingHeight(java.math.BigDecimal productShippingHeight) {
        this.productShippingHeight = productShippingHeight;
    }

    private String productWidthUomId;

    public String getProductWidthUomId() {
        return this.productWidthUomId;
    }

    public void setProductWidthUomId(String productWidthUomId) {
        this.productWidthUomId = productWidthUomId;
    }

    private java.math.BigDecimal productProductWidth;

    public java.math.BigDecimal getProductProductWidth() {
        return this.productProductWidth;
    }

    public void setProductProductWidth(java.math.BigDecimal productProductWidth) {
        this.productProductWidth = productProductWidth;
    }

    private java.math.BigDecimal productShippingWidth;

    public java.math.BigDecimal getProductShippingWidth() {
        return this.productShippingWidth;
    }

    public void setProductShippingWidth(java.math.BigDecimal productShippingWidth) {
        this.productShippingWidth = productShippingWidth;
    }

    private String productDepthUomId;

    public String getProductDepthUomId() {
        return this.productDepthUomId;
    }

    public void setProductDepthUomId(String productDepthUomId) {
        this.productDepthUomId = productDepthUomId;
    }

    private java.math.BigDecimal productProductDepth;

    public java.math.BigDecimal getProductProductDepth() {
        return this.productProductDepth;
    }

    public void setProductProductDepth(java.math.BigDecimal productProductDepth) {
        this.productProductDepth = productProductDepth;
    }

    private java.math.BigDecimal productShippingDepth;

    public java.math.BigDecimal getProductShippingDepth() {
        return this.productShippingDepth;
    }

    public void setProductShippingDepth(java.math.BigDecimal productShippingDepth) {
        this.productShippingDepth = productShippingDepth;
    }

    private String productDiameterUomId;

    public String getProductDiameterUomId() {
        return this.productDiameterUomId;
    }

    public void setProductDiameterUomId(String productDiameterUomId) {
        this.productDiameterUomId = productDiameterUomId;
    }

    private java.math.BigDecimal productProductDiameter;

    public java.math.BigDecimal getProductProductDiameter() {
        return this.productProductDiameter;
    }

    public void setProductProductDiameter(java.math.BigDecimal productProductDiameter) {
        this.productProductDiameter = productProductDiameter;
    }

    private java.math.BigDecimal productProductRating;

    public java.math.BigDecimal getProductProductRating() {
        return this.productProductRating;
    }

    public void setProductProductRating(java.math.BigDecimal productProductRating) {
        this.productProductRating = productProductRating;
    }

    private String productRatingTypeEnum;

    public String getProductRatingTypeEnum() {
        return this.productRatingTypeEnum;
    }

    public void setProductRatingTypeEnum(String productRatingTypeEnum) {
        this.productRatingTypeEnum = productRatingTypeEnum;
    }

    private String productReturnable;

    public String getProductReturnable() {
        return this.productReturnable;
    }

    public void setProductReturnable(String productReturnable) {
        this.productReturnable = productReturnable;
    }

    private String productTaxable;

    public String getProductTaxable() {
        return this.productTaxable;
    }

    public void setProductTaxable(String productTaxable) {
        this.productTaxable = productTaxable;
    }

    private String productChargeShipping;

    public String getProductChargeShipping() {
        return this.productChargeShipping;
    }

    public void setProductChargeShipping(String productChargeShipping) {
        this.productChargeShipping = productChargeShipping;
    }

    private String productAutoCreateKeywords;

    public String getProductAutoCreateKeywords() {
        return this.productAutoCreateKeywords;
    }

    public void setProductAutoCreateKeywords(String productAutoCreateKeywords) {
        this.productAutoCreateKeywords = productAutoCreateKeywords;
    }

    private String productIncludeInPromotions;

    public String getProductIncludeInPromotions() {
        return this.productIncludeInPromotions;
    }

    public void setProductIncludeInPromotions(String productIncludeInPromotions) {
        this.productIncludeInPromotions = productIncludeInPromotions;
    }

    private String productIsVirtual;

    public String getProductIsVirtual() {
        return this.productIsVirtual;
    }

    public void setProductIsVirtual(String productIsVirtual) {
        this.productIsVirtual = productIsVirtual;
    }

    private String productIsVariant;

    public String getProductIsVariant() {
        return this.productIsVariant;
    }

    public void setProductIsVariant(String productIsVariant) {
        this.productIsVariant = productIsVariant;
    }

    private String productVirtualVariantMethodEnum;

    public String getProductVirtualVariantMethodEnum() {
        return this.productVirtualVariantMethodEnum;
    }

    public void setProductVirtualVariantMethodEnum(String productVirtualVariantMethodEnum) {
        this.productVirtualVariantMethodEnum = productVirtualVariantMethodEnum;
    }

    private String productInShippingBox;

    public String getProductInShippingBox() {
        return this.productInShippingBox;
    }

    public void setProductInShippingBox(String productInShippingBox) {
        this.productInShippingBox = productInShippingBox;
    }

    private String productDefaultShipmentBoxTypeId;

    public String getProductDefaultShipmentBoxTypeId() {
        return this.productDefaultShipmentBoxTypeId;
    }

    public void setProductDefaultShipmentBoxTypeId(String productDefaultShipmentBoxTypeId) {
        this.productDefaultShipmentBoxTypeId = productDefaultShipmentBoxTypeId;
    }

    private Boolean productIsSerialNumbered;

    public Boolean getProductIsSerialNumbered() {
        return this.productIsSerialNumbered;
    }

    public void setProductIsSerialNumbered(Boolean productIsSerialNumbered) {
        this.productIsSerialNumbered = productIsSerialNumbered;
    }

    private Boolean productIsManagedByLot;

    public Boolean getProductIsManagedByLot() {
        return this.productIsManagedByLot;
    }

    public void setProductIsManagedByLot(Boolean productIsManagedByLot) {
        this.productIsManagedByLot = productIsManagedByLot;
    }

    private String productAttributeSetId;

    public String getProductAttributeSetId() {
        return this.productAttributeSetId;
    }

    public void setProductAttributeSetId(String productAttributeSetId) {
        this.productAttributeSetId = productAttributeSetId;
    }

    private String productAttributeSetInstanceId;

    public String getProductAttributeSetInstanceId() {
        return this.productAttributeSetInstanceId;
    }

    public void setProductAttributeSetInstanceId(String productAttributeSetInstanceId) {
        this.productAttributeSetInstanceId = productAttributeSetInstanceId;
    }

    private String productCreatedBy;

    public String getProductCreatedBy() {
        return this.productCreatedBy;
    }

    public void setProductCreatedBy(String productCreatedBy) {
        this.productCreatedBy = productCreatedBy;
    }

    private Date productCreatedAt;

    public Date getProductCreatedAt() {
        return this.productCreatedAt;
    }

    public void setProductCreatedAt(Date productCreatedAt) {
        this.productCreatedAt = productCreatedAt;
    }

    private String productUpdatedBy;

    public String getProductUpdatedBy() {
        return this.productUpdatedBy;
    }

    public void setProductUpdatedBy(String productUpdatedBy) {
        this.productUpdatedBy = productUpdatedBy;
    }

    private Date productUpdatedAt;

    public Date getProductUpdatedAt() {
        return this.productUpdatedAt;
    }

    public void setProductUpdatedAt(Date productUpdatedAt) {
        this.productUpdatedAt = productUpdatedAt;
    }

    private Boolean productActive;

    public Boolean getProductActive() {
        return this.productActive;
    }

    public void setProductActive(Boolean productActive) {
        this.productActive = productActive;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private Boolean isPropertyIdValueRemoved;

    public Boolean getIsPropertyIdValueRemoved() {
        return this.isPropertyIdValueRemoved;
    }

    public void setIsPropertyIdValueRemoved(Boolean removed) {
        this.isPropertyIdValueRemoved = removed;
    }

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved() {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed) {
        this.isPropertyVersionRemoved = removed;
    }

    private Boolean isPropertyActiveRemoved;

    public Boolean getIsPropertyActiveRemoved() {
        return this.isPropertyActiveRemoved;
    }

    public void setIsPropertyActiveRemoved(Boolean removed) {
        this.isPropertyActiveRemoved = removed;
    }

    private Boolean isPropertyProductProductTypeIdRemoved;

    public Boolean getIsPropertyProductProductTypeIdRemoved() {
        return this.isPropertyProductProductTypeIdRemoved;
    }

    public void setIsPropertyProductProductTypeIdRemoved(Boolean removed) {
        this.isPropertyProductProductTypeIdRemoved = removed;
    }

    private Boolean isPropertyProductPrimaryProductCategoryIdRemoved;

    public Boolean getIsPropertyProductPrimaryProductCategoryIdRemoved() {
        return this.isPropertyProductPrimaryProductCategoryIdRemoved;
    }

    public void setIsPropertyProductPrimaryProductCategoryIdRemoved(Boolean removed) {
        this.isPropertyProductPrimaryProductCategoryIdRemoved = removed;
    }

    private Boolean isPropertyProductManufacturerPartyIdRemoved;

    public Boolean getIsPropertyProductManufacturerPartyIdRemoved() {
        return this.isPropertyProductManufacturerPartyIdRemoved;
    }

    public void setIsPropertyProductManufacturerPartyIdRemoved(Boolean removed) {
        this.isPropertyProductManufacturerPartyIdRemoved = removed;
    }

    private Boolean isPropertyProductFacilityIdRemoved;

    public Boolean getIsPropertyProductFacilityIdRemoved() {
        return this.isPropertyProductFacilityIdRemoved;
    }

    public void setIsPropertyProductFacilityIdRemoved(Boolean removed) {
        this.isPropertyProductFacilityIdRemoved = removed;
    }

    private Boolean isPropertyProductIntroductionDateRemoved;

    public Boolean getIsPropertyProductIntroductionDateRemoved() {
        return this.isPropertyProductIntroductionDateRemoved;
    }

    public void setIsPropertyProductIntroductionDateRemoved(Boolean removed) {
        this.isPropertyProductIntroductionDateRemoved = removed;
    }

    private Boolean isPropertyProductReleaseDateRemoved;

    public Boolean getIsPropertyProductReleaseDateRemoved() {
        return this.isPropertyProductReleaseDateRemoved;
    }

    public void setIsPropertyProductReleaseDateRemoved(Boolean removed) {
        this.isPropertyProductReleaseDateRemoved = removed;
    }

    private Boolean isPropertyProductSupportDiscontinuationDateRemoved;

    public Boolean getIsPropertyProductSupportDiscontinuationDateRemoved() {
        return this.isPropertyProductSupportDiscontinuationDateRemoved;
    }

    public void setIsPropertyProductSupportDiscontinuationDateRemoved(Boolean removed) {
        this.isPropertyProductSupportDiscontinuationDateRemoved = removed;
    }

    private Boolean isPropertyProductSalesDiscontinuationDateRemoved;

    public Boolean getIsPropertyProductSalesDiscontinuationDateRemoved() {
        return this.isPropertyProductSalesDiscontinuationDateRemoved;
    }

    public void setIsPropertyProductSalesDiscontinuationDateRemoved(Boolean removed) {
        this.isPropertyProductSalesDiscontinuationDateRemoved = removed;
    }

    private Boolean isPropertyProductSalesDiscWhenNotAvailRemoved;

    public Boolean getIsPropertyProductSalesDiscWhenNotAvailRemoved() {
        return this.isPropertyProductSalesDiscWhenNotAvailRemoved;
    }

    public void setIsPropertyProductSalesDiscWhenNotAvailRemoved(Boolean removed) {
        this.isPropertyProductSalesDiscWhenNotAvailRemoved = removed;
    }

    private Boolean isPropertyProductInternalNameRemoved;

    public Boolean getIsPropertyProductInternalNameRemoved() {
        return this.isPropertyProductInternalNameRemoved;
    }

    public void setIsPropertyProductInternalNameRemoved(Boolean removed) {
        this.isPropertyProductInternalNameRemoved = removed;
    }

    private Boolean isPropertyProductBrandNameRemoved;

    public Boolean getIsPropertyProductBrandNameRemoved() {
        return this.isPropertyProductBrandNameRemoved;
    }

    public void setIsPropertyProductBrandNameRemoved(Boolean removed) {
        this.isPropertyProductBrandNameRemoved = removed;
    }

    private Boolean isPropertyProductCommentsRemoved;

    public Boolean getIsPropertyProductCommentsRemoved() {
        return this.isPropertyProductCommentsRemoved;
    }

    public void setIsPropertyProductCommentsRemoved(Boolean removed) {
        this.isPropertyProductCommentsRemoved = removed;
    }

    private Boolean isPropertyProductProductNameRemoved;

    public Boolean getIsPropertyProductProductNameRemoved() {
        return this.isPropertyProductProductNameRemoved;
    }

    public void setIsPropertyProductProductNameRemoved(Boolean removed) {
        this.isPropertyProductProductNameRemoved = removed;
    }

    private Boolean isPropertyProductDescriptionRemoved;

    public Boolean getIsPropertyProductDescriptionRemoved() {
        return this.isPropertyProductDescriptionRemoved;
    }

    public void setIsPropertyProductDescriptionRemoved(Boolean removed) {
        this.isPropertyProductDescriptionRemoved = removed;
    }

    private Boolean isPropertyProductPriceDetailTextRemoved;

    public Boolean getIsPropertyProductPriceDetailTextRemoved() {
        return this.isPropertyProductPriceDetailTextRemoved;
    }

    public void setIsPropertyProductPriceDetailTextRemoved(Boolean removed) {
        this.isPropertyProductPriceDetailTextRemoved = removed;
    }

    private Boolean isPropertyProductSmallImageUrlRemoved;

    public Boolean getIsPropertyProductSmallImageUrlRemoved() {
        return this.isPropertyProductSmallImageUrlRemoved;
    }

    public void setIsPropertyProductSmallImageUrlRemoved(Boolean removed) {
        this.isPropertyProductSmallImageUrlRemoved = removed;
    }

    private Boolean isPropertyProductMediumImageUrlRemoved;

    public Boolean getIsPropertyProductMediumImageUrlRemoved() {
        return this.isPropertyProductMediumImageUrlRemoved;
    }

    public void setIsPropertyProductMediumImageUrlRemoved(Boolean removed) {
        this.isPropertyProductMediumImageUrlRemoved = removed;
    }

    private Boolean isPropertyProductLargeImageUrlRemoved;

    public Boolean getIsPropertyProductLargeImageUrlRemoved() {
        return this.isPropertyProductLargeImageUrlRemoved;
    }

    public void setIsPropertyProductLargeImageUrlRemoved(Boolean removed) {
        this.isPropertyProductLargeImageUrlRemoved = removed;
    }

    private Boolean isPropertyProductDetailImageUrlRemoved;

    public Boolean getIsPropertyProductDetailImageUrlRemoved() {
        return this.isPropertyProductDetailImageUrlRemoved;
    }

    public void setIsPropertyProductDetailImageUrlRemoved(Boolean removed) {
        this.isPropertyProductDetailImageUrlRemoved = removed;
    }

    private Boolean isPropertyProductOriginalImageUrlRemoved;

    public Boolean getIsPropertyProductOriginalImageUrlRemoved() {
        return this.isPropertyProductOriginalImageUrlRemoved;
    }

    public void setIsPropertyProductOriginalImageUrlRemoved(Boolean removed) {
        this.isPropertyProductOriginalImageUrlRemoved = removed;
    }

    private Boolean isPropertyProductDetailScreenRemoved;

    public Boolean getIsPropertyProductDetailScreenRemoved() {
        return this.isPropertyProductDetailScreenRemoved;
    }

    public void setIsPropertyProductDetailScreenRemoved(Boolean removed) {
        this.isPropertyProductDetailScreenRemoved = removed;
    }

    private Boolean isPropertyProductInventoryMessageRemoved;

    public Boolean getIsPropertyProductInventoryMessageRemoved() {
        return this.isPropertyProductInventoryMessageRemoved;
    }

    public void setIsPropertyProductInventoryMessageRemoved(Boolean removed) {
        this.isPropertyProductInventoryMessageRemoved = removed;
    }

    private Boolean isPropertyProductInventoryItemTypeIdRemoved;

    public Boolean getIsPropertyProductInventoryItemTypeIdRemoved() {
        return this.isPropertyProductInventoryItemTypeIdRemoved;
    }

    public void setIsPropertyProductInventoryItemTypeIdRemoved(Boolean removed) {
        this.isPropertyProductInventoryItemTypeIdRemoved = removed;
    }

    private Boolean isPropertyProductRequireInventoryRemoved;

    public Boolean getIsPropertyProductRequireInventoryRemoved() {
        return this.isPropertyProductRequireInventoryRemoved;
    }

    public void setIsPropertyProductRequireInventoryRemoved(Boolean removed) {
        this.isPropertyProductRequireInventoryRemoved = removed;
    }

    private Boolean isPropertyProductQuantityUomIdRemoved;

    public Boolean getIsPropertyProductQuantityUomIdRemoved() {
        return this.isPropertyProductQuantityUomIdRemoved;
    }

    public void setIsPropertyProductQuantityUomIdRemoved(Boolean removed) {
        this.isPropertyProductQuantityUomIdRemoved = removed;
    }

    private Boolean isPropertyProductQuantityIncludedRemoved;

    public Boolean getIsPropertyProductQuantityIncludedRemoved() {
        return this.isPropertyProductQuantityIncludedRemoved;
    }

    public void setIsPropertyProductQuantityIncludedRemoved(Boolean removed) {
        this.isPropertyProductQuantityIncludedRemoved = removed;
    }

    private Boolean isPropertyProductPiecesIncludedRemoved;

    public Boolean getIsPropertyProductPiecesIncludedRemoved() {
        return this.isPropertyProductPiecesIncludedRemoved;
    }

    public void setIsPropertyProductPiecesIncludedRemoved(Boolean removed) {
        this.isPropertyProductPiecesIncludedRemoved = removed;
    }

    private Boolean isPropertyProductRequireAmountRemoved;

    public Boolean getIsPropertyProductRequireAmountRemoved() {
        return this.isPropertyProductRequireAmountRemoved;
    }

    public void setIsPropertyProductRequireAmountRemoved(Boolean removed) {
        this.isPropertyProductRequireAmountRemoved = removed;
    }

    private Boolean isPropertyProductFixedAmountRemoved;

    public Boolean getIsPropertyProductFixedAmountRemoved() {
        return this.isPropertyProductFixedAmountRemoved;
    }

    public void setIsPropertyProductFixedAmountRemoved(Boolean removed) {
        this.isPropertyProductFixedAmountRemoved = removed;
    }

    private Boolean isPropertyProductAmountUomTypeIdRemoved;

    public Boolean getIsPropertyProductAmountUomTypeIdRemoved() {
        return this.isPropertyProductAmountUomTypeIdRemoved;
    }

    public void setIsPropertyProductAmountUomTypeIdRemoved(Boolean removed) {
        this.isPropertyProductAmountUomTypeIdRemoved = removed;
    }

    private Boolean isPropertyProductWeightUomIdRemoved;

    public Boolean getIsPropertyProductWeightUomIdRemoved() {
        return this.isPropertyProductWeightUomIdRemoved;
    }

    public void setIsPropertyProductWeightUomIdRemoved(Boolean removed) {
        this.isPropertyProductWeightUomIdRemoved = removed;
    }

    private Boolean isPropertyProductShippingWeightRemoved;

    public Boolean getIsPropertyProductShippingWeightRemoved() {
        return this.isPropertyProductShippingWeightRemoved;
    }

    public void setIsPropertyProductShippingWeightRemoved(Boolean removed) {
        this.isPropertyProductShippingWeightRemoved = removed;
    }

    private Boolean isPropertyProductProductWeightRemoved;

    public Boolean getIsPropertyProductProductWeightRemoved() {
        return this.isPropertyProductProductWeightRemoved;
    }

    public void setIsPropertyProductProductWeightRemoved(Boolean removed) {
        this.isPropertyProductProductWeightRemoved = removed;
    }

    private Boolean isPropertyProductHeightUomIdRemoved;

    public Boolean getIsPropertyProductHeightUomIdRemoved() {
        return this.isPropertyProductHeightUomIdRemoved;
    }

    public void setIsPropertyProductHeightUomIdRemoved(Boolean removed) {
        this.isPropertyProductHeightUomIdRemoved = removed;
    }

    private Boolean isPropertyProductProductHeightRemoved;

    public Boolean getIsPropertyProductProductHeightRemoved() {
        return this.isPropertyProductProductHeightRemoved;
    }

    public void setIsPropertyProductProductHeightRemoved(Boolean removed) {
        this.isPropertyProductProductHeightRemoved = removed;
    }

    private Boolean isPropertyProductShippingHeightRemoved;

    public Boolean getIsPropertyProductShippingHeightRemoved() {
        return this.isPropertyProductShippingHeightRemoved;
    }

    public void setIsPropertyProductShippingHeightRemoved(Boolean removed) {
        this.isPropertyProductShippingHeightRemoved = removed;
    }

    private Boolean isPropertyProductWidthUomIdRemoved;

    public Boolean getIsPropertyProductWidthUomIdRemoved() {
        return this.isPropertyProductWidthUomIdRemoved;
    }

    public void setIsPropertyProductWidthUomIdRemoved(Boolean removed) {
        this.isPropertyProductWidthUomIdRemoved = removed;
    }

    private Boolean isPropertyProductProductWidthRemoved;

    public Boolean getIsPropertyProductProductWidthRemoved() {
        return this.isPropertyProductProductWidthRemoved;
    }

    public void setIsPropertyProductProductWidthRemoved(Boolean removed) {
        this.isPropertyProductProductWidthRemoved = removed;
    }

    private Boolean isPropertyProductShippingWidthRemoved;

    public Boolean getIsPropertyProductShippingWidthRemoved() {
        return this.isPropertyProductShippingWidthRemoved;
    }

    public void setIsPropertyProductShippingWidthRemoved(Boolean removed) {
        this.isPropertyProductShippingWidthRemoved = removed;
    }

    private Boolean isPropertyProductDepthUomIdRemoved;

    public Boolean getIsPropertyProductDepthUomIdRemoved() {
        return this.isPropertyProductDepthUomIdRemoved;
    }

    public void setIsPropertyProductDepthUomIdRemoved(Boolean removed) {
        this.isPropertyProductDepthUomIdRemoved = removed;
    }

    private Boolean isPropertyProductProductDepthRemoved;

    public Boolean getIsPropertyProductProductDepthRemoved() {
        return this.isPropertyProductProductDepthRemoved;
    }

    public void setIsPropertyProductProductDepthRemoved(Boolean removed) {
        this.isPropertyProductProductDepthRemoved = removed;
    }

    private Boolean isPropertyProductShippingDepthRemoved;

    public Boolean getIsPropertyProductShippingDepthRemoved() {
        return this.isPropertyProductShippingDepthRemoved;
    }

    public void setIsPropertyProductShippingDepthRemoved(Boolean removed) {
        this.isPropertyProductShippingDepthRemoved = removed;
    }

    private Boolean isPropertyProductDiameterUomIdRemoved;

    public Boolean getIsPropertyProductDiameterUomIdRemoved() {
        return this.isPropertyProductDiameterUomIdRemoved;
    }

    public void setIsPropertyProductDiameterUomIdRemoved(Boolean removed) {
        this.isPropertyProductDiameterUomIdRemoved = removed;
    }

    private Boolean isPropertyProductProductDiameterRemoved;

    public Boolean getIsPropertyProductProductDiameterRemoved() {
        return this.isPropertyProductProductDiameterRemoved;
    }

    public void setIsPropertyProductProductDiameterRemoved(Boolean removed) {
        this.isPropertyProductProductDiameterRemoved = removed;
    }

    private Boolean isPropertyProductProductRatingRemoved;

    public Boolean getIsPropertyProductProductRatingRemoved() {
        return this.isPropertyProductProductRatingRemoved;
    }

    public void setIsPropertyProductProductRatingRemoved(Boolean removed) {
        this.isPropertyProductProductRatingRemoved = removed;
    }

    private Boolean isPropertyProductRatingTypeEnumRemoved;

    public Boolean getIsPropertyProductRatingTypeEnumRemoved() {
        return this.isPropertyProductRatingTypeEnumRemoved;
    }

    public void setIsPropertyProductRatingTypeEnumRemoved(Boolean removed) {
        this.isPropertyProductRatingTypeEnumRemoved = removed;
    }

    private Boolean isPropertyProductReturnableRemoved;

    public Boolean getIsPropertyProductReturnableRemoved() {
        return this.isPropertyProductReturnableRemoved;
    }

    public void setIsPropertyProductReturnableRemoved(Boolean removed) {
        this.isPropertyProductReturnableRemoved = removed;
    }

    private Boolean isPropertyProductTaxableRemoved;

    public Boolean getIsPropertyProductTaxableRemoved() {
        return this.isPropertyProductTaxableRemoved;
    }

    public void setIsPropertyProductTaxableRemoved(Boolean removed) {
        this.isPropertyProductTaxableRemoved = removed;
    }

    private Boolean isPropertyProductChargeShippingRemoved;

    public Boolean getIsPropertyProductChargeShippingRemoved() {
        return this.isPropertyProductChargeShippingRemoved;
    }

    public void setIsPropertyProductChargeShippingRemoved(Boolean removed) {
        this.isPropertyProductChargeShippingRemoved = removed;
    }

    private Boolean isPropertyProductAutoCreateKeywordsRemoved;

    public Boolean getIsPropertyProductAutoCreateKeywordsRemoved() {
        return this.isPropertyProductAutoCreateKeywordsRemoved;
    }

    public void setIsPropertyProductAutoCreateKeywordsRemoved(Boolean removed) {
        this.isPropertyProductAutoCreateKeywordsRemoved = removed;
    }

    private Boolean isPropertyProductIncludeInPromotionsRemoved;

    public Boolean getIsPropertyProductIncludeInPromotionsRemoved() {
        return this.isPropertyProductIncludeInPromotionsRemoved;
    }

    public void setIsPropertyProductIncludeInPromotionsRemoved(Boolean removed) {
        this.isPropertyProductIncludeInPromotionsRemoved = removed;
    }

    private Boolean isPropertyProductIsVirtualRemoved;

    public Boolean getIsPropertyProductIsVirtualRemoved() {
        return this.isPropertyProductIsVirtualRemoved;
    }

    public void setIsPropertyProductIsVirtualRemoved(Boolean removed) {
        this.isPropertyProductIsVirtualRemoved = removed;
    }

    private Boolean isPropertyProductIsVariantRemoved;

    public Boolean getIsPropertyProductIsVariantRemoved() {
        return this.isPropertyProductIsVariantRemoved;
    }

    public void setIsPropertyProductIsVariantRemoved(Boolean removed) {
        this.isPropertyProductIsVariantRemoved = removed;
    }

    private Boolean isPropertyProductVirtualVariantMethodEnumRemoved;

    public Boolean getIsPropertyProductVirtualVariantMethodEnumRemoved() {
        return this.isPropertyProductVirtualVariantMethodEnumRemoved;
    }

    public void setIsPropertyProductVirtualVariantMethodEnumRemoved(Boolean removed) {
        this.isPropertyProductVirtualVariantMethodEnumRemoved = removed;
    }

    private Boolean isPropertyProductInShippingBoxRemoved;

    public Boolean getIsPropertyProductInShippingBoxRemoved() {
        return this.isPropertyProductInShippingBoxRemoved;
    }

    public void setIsPropertyProductInShippingBoxRemoved(Boolean removed) {
        this.isPropertyProductInShippingBoxRemoved = removed;
    }

    private Boolean isPropertyProductDefaultShipmentBoxTypeIdRemoved;

    public Boolean getIsPropertyProductDefaultShipmentBoxTypeIdRemoved() {
        return this.isPropertyProductDefaultShipmentBoxTypeIdRemoved;
    }

    public void setIsPropertyProductDefaultShipmentBoxTypeIdRemoved(Boolean removed) {
        this.isPropertyProductDefaultShipmentBoxTypeIdRemoved = removed;
    }

    private Boolean isPropertyProductIsSerialNumberedRemoved;

    public Boolean getIsPropertyProductIsSerialNumberedRemoved() {
        return this.isPropertyProductIsSerialNumberedRemoved;
    }

    public void setIsPropertyProductIsSerialNumberedRemoved(Boolean removed) {
        this.isPropertyProductIsSerialNumberedRemoved = removed;
    }

    private Boolean isPropertyProductIsManagedByLotRemoved;

    public Boolean getIsPropertyProductIsManagedByLotRemoved() {
        return this.isPropertyProductIsManagedByLotRemoved;
    }

    public void setIsPropertyProductIsManagedByLotRemoved(Boolean removed) {
        this.isPropertyProductIsManagedByLotRemoved = removed;
    }

    private Boolean isPropertyProductAttributeSetIdRemoved;

    public Boolean getIsPropertyProductAttributeSetIdRemoved() {
        return this.isPropertyProductAttributeSetIdRemoved;
    }

    public void setIsPropertyProductAttributeSetIdRemoved(Boolean removed) {
        this.isPropertyProductAttributeSetIdRemoved = removed;
    }

    private Boolean isPropertyProductAttributeSetInstanceIdRemoved;

    public Boolean getIsPropertyProductAttributeSetInstanceIdRemoved() {
        return this.isPropertyProductAttributeSetInstanceIdRemoved;
    }

    public void setIsPropertyProductAttributeSetInstanceIdRemoved(Boolean removed) {
        this.isPropertyProductAttributeSetInstanceIdRemoved = removed;
    }

    private Boolean isPropertyProductCreatedByRemoved;

    public Boolean getIsPropertyProductCreatedByRemoved() {
        return this.isPropertyProductCreatedByRemoved;
    }

    public void setIsPropertyProductCreatedByRemoved(Boolean removed) {
        this.isPropertyProductCreatedByRemoved = removed;
    }

    private Boolean isPropertyProductCreatedAtRemoved;

    public Boolean getIsPropertyProductCreatedAtRemoved() {
        return this.isPropertyProductCreatedAtRemoved;
    }

    public void setIsPropertyProductCreatedAtRemoved(Boolean removed) {
        this.isPropertyProductCreatedAtRemoved = removed;
    }

    private Boolean isPropertyProductUpdatedByRemoved;

    public Boolean getIsPropertyProductUpdatedByRemoved() {
        return this.isPropertyProductUpdatedByRemoved;
    }

    public void setIsPropertyProductUpdatedByRemoved(Boolean removed) {
        this.isPropertyProductUpdatedByRemoved = removed;
    }

    private Boolean isPropertyProductUpdatedAtRemoved;

    public Boolean getIsPropertyProductUpdatedAtRemoved() {
        return this.isPropertyProductUpdatedAtRemoved;
    }

    public void setIsPropertyProductUpdatedAtRemoved(Boolean removed) {
        this.isPropertyProductUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyProductActiveRemoved;

    public Boolean getIsPropertyProductActiveRemoved() {
        return this.isPropertyProductActiveRemoved;
    }

    public void setIsPropertyProductActiveRemoved(Boolean removed) {
        this.isPropertyProductActiveRemoved = removed;
    }


	public static class GoodIdentificationMvoStateCreatedDto extends GoodIdentificationMvoStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_CREATED;
        }

	}


	public static class GoodIdentificationMvoStateMergePatchedDto extends GoodIdentificationMvoStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_MERGE_PATCHED;
        }

	}


	public static class GoodIdentificationMvoStateDeletedDto extends GoodIdentificationMvoStateEventDto
	{
        @Override
        public String getEventType()
        {
            return STATE_EVENT_TYPE_DELETED;
        }

	}


}

