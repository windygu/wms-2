package org.dddml.wms.domain.goodidentificationmvo;

import java.util.*;
import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class GoodIdentificationMvoStateDto
{

    private ProductGoodIdentificationId productGoodIdentificationId;

    public ProductGoodIdentificationId getProductGoodIdentificationId()
    {
        return this.productGoodIdentificationId;
    }

    public void setProductGoodIdentificationId(ProductGoodIdentificationId productGoodIdentificationId)
    {
        this.productGoodIdentificationId = productGoodIdentificationId;
    }

    private String idValue;

    public String getIdValue()
    {
        return this.idValue;
    }

    public void setIdValue(String idValue)
    {
        this.idValue = idValue;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private String productProductTypeId;

    public String getProductProductTypeId()
    {
        return this.productProductTypeId;
    }

    public void setProductProductTypeId(String productProductTypeId)
    {
        this.productProductTypeId = productProductTypeId;
    }

    private String productPrimaryProductCategoryId;

    public String getProductPrimaryProductCategoryId()
    {
        return this.productPrimaryProductCategoryId;
    }

    public void setProductPrimaryProductCategoryId(String productPrimaryProductCategoryId)
    {
        this.productPrimaryProductCategoryId = productPrimaryProductCategoryId;
    }

    private String productManufacturerPartyId;

    public String getProductManufacturerPartyId()
    {
        return this.productManufacturerPartyId;
    }

    public void setProductManufacturerPartyId(String productManufacturerPartyId)
    {
        this.productManufacturerPartyId = productManufacturerPartyId;
    }

    private String productFacilityId;

    public String getProductFacilityId()
    {
        return this.productFacilityId;
    }

    public void setProductFacilityId(String productFacilityId)
    {
        this.productFacilityId = productFacilityId;
    }

    private java.sql.Timestamp productIntroductionDate;

    public java.sql.Timestamp getProductIntroductionDate()
    {
        return this.productIntroductionDate;
    }

    public void setProductIntroductionDate(java.sql.Timestamp productIntroductionDate)
    {
        this.productIntroductionDate = productIntroductionDate;
    }

    private java.sql.Timestamp productReleaseDate;

    public java.sql.Timestamp getProductReleaseDate()
    {
        return this.productReleaseDate;
    }

    public void setProductReleaseDate(java.sql.Timestamp productReleaseDate)
    {
        this.productReleaseDate = productReleaseDate;
    }

    private java.sql.Timestamp productSupportDiscontinuationDate;

    public java.sql.Timestamp getProductSupportDiscontinuationDate()
    {
        return this.productSupportDiscontinuationDate;
    }

    public void setProductSupportDiscontinuationDate(java.sql.Timestamp productSupportDiscontinuationDate)
    {
        this.productSupportDiscontinuationDate = productSupportDiscontinuationDate;
    }

    private java.sql.Timestamp productSalesDiscontinuationDate;

    public java.sql.Timestamp getProductSalesDiscontinuationDate()
    {
        return this.productSalesDiscontinuationDate;
    }

    public void setProductSalesDiscontinuationDate(java.sql.Timestamp productSalesDiscontinuationDate)
    {
        this.productSalesDiscontinuationDate = productSalesDiscontinuationDate;
    }

    private String productSalesDiscWhenNotAvail;

    public String getProductSalesDiscWhenNotAvail()
    {
        return this.productSalesDiscWhenNotAvail;
    }

    public void setProductSalesDiscWhenNotAvail(String productSalesDiscWhenNotAvail)
    {
        this.productSalesDiscWhenNotAvail = productSalesDiscWhenNotAvail;
    }

    private String productInternalName;

    public String getProductInternalName()
    {
        return this.productInternalName;
    }

    public void setProductInternalName(String productInternalName)
    {
        this.productInternalName = productInternalName;
    }

    private String productBrandName;

    public String getProductBrandName()
    {
        return this.productBrandName;
    }

    public void setProductBrandName(String productBrandName)
    {
        this.productBrandName = productBrandName;
    }

    private String productComments;

    public String getProductComments()
    {
        return this.productComments;
    }

    public void setProductComments(String productComments)
    {
        this.productComments = productComments;
    }

    private String productProductName;

    public String getProductProductName()
    {
        return this.productProductName;
    }

    public void setProductProductName(String productProductName)
    {
        this.productProductName = productProductName;
    }

    private String productDescription;

    public String getProductDescription()
    {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription)
    {
        this.productDescription = productDescription;
    }

    private String productPriceDetailText;

    public String getProductPriceDetailText()
    {
        return this.productPriceDetailText;
    }

    public void setProductPriceDetailText(String productPriceDetailText)
    {
        this.productPriceDetailText = productPriceDetailText;
    }

    private String productSmallImageUrl;

    public String getProductSmallImageUrl()
    {
        return this.productSmallImageUrl;
    }

    public void setProductSmallImageUrl(String productSmallImageUrl)
    {
        this.productSmallImageUrl = productSmallImageUrl;
    }

    private String productMediumImageUrl;

    public String getProductMediumImageUrl()
    {
        return this.productMediumImageUrl;
    }

    public void setProductMediumImageUrl(String productMediumImageUrl)
    {
        this.productMediumImageUrl = productMediumImageUrl;
    }

    private String productLargeImageUrl;

    public String getProductLargeImageUrl()
    {
        return this.productLargeImageUrl;
    }

    public void setProductLargeImageUrl(String productLargeImageUrl)
    {
        this.productLargeImageUrl = productLargeImageUrl;
    }

    private String productDetailImageUrl;

    public String getProductDetailImageUrl()
    {
        return this.productDetailImageUrl;
    }

    public void setProductDetailImageUrl(String productDetailImageUrl)
    {
        this.productDetailImageUrl = productDetailImageUrl;
    }

    private String productOriginalImageUrl;

    public String getProductOriginalImageUrl()
    {
        return this.productOriginalImageUrl;
    }

    public void setProductOriginalImageUrl(String productOriginalImageUrl)
    {
        this.productOriginalImageUrl = productOriginalImageUrl;
    }

    private String productDetailScreen;

    public String getProductDetailScreen()
    {
        return this.productDetailScreen;
    }

    public void setProductDetailScreen(String productDetailScreen)
    {
        this.productDetailScreen = productDetailScreen;
    }

    private String productInventoryMessage;

    public String getProductInventoryMessage()
    {
        return this.productInventoryMessage;
    }

    public void setProductInventoryMessage(String productInventoryMessage)
    {
        this.productInventoryMessage = productInventoryMessage;
    }

    private String productInventoryItemTypeId;

    public String getProductInventoryItemTypeId()
    {
        return this.productInventoryItemTypeId;
    }

    public void setProductInventoryItemTypeId(String productInventoryItemTypeId)
    {
        this.productInventoryItemTypeId = productInventoryItemTypeId;
    }

    private String productRequireInventory;

    public String getProductRequireInventory()
    {
        return this.productRequireInventory;
    }

    public void setProductRequireInventory(String productRequireInventory)
    {
        this.productRequireInventory = productRequireInventory;
    }

    private String productQuantityUomId;

    public String getProductQuantityUomId()
    {
        return this.productQuantityUomId;
    }

    public void setProductQuantityUomId(String productQuantityUomId)
    {
        this.productQuantityUomId = productQuantityUomId;
    }

    private java.math.BigDecimal productQuantityIncluded;

    public java.math.BigDecimal getProductQuantityIncluded()
    {
        return this.productQuantityIncluded;
    }

    public void setProductQuantityIncluded(java.math.BigDecimal productQuantityIncluded)
    {
        this.productQuantityIncluded = productQuantityIncluded;
    }

    private Long productPiecesIncluded;

    public Long getProductPiecesIncluded()
    {
        return this.productPiecesIncluded;
    }

    public void setProductPiecesIncluded(Long productPiecesIncluded)
    {
        this.productPiecesIncluded = productPiecesIncluded;
    }

    private String productRequireAmount;

    public String getProductRequireAmount()
    {
        return this.productRequireAmount;
    }

    public void setProductRequireAmount(String productRequireAmount)
    {
        this.productRequireAmount = productRequireAmount;
    }

    private java.math.BigDecimal productFixedAmount;

    public java.math.BigDecimal getProductFixedAmount()
    {
        return this.productFixedAmount;
    }

    public void setProductFixedAmount(java.math.BigDecimal productFixedAmount)
    {
        this.productFixedAmount = productFixedAmount;
    }

    private String productAmountUomTypeId;

    public String getProductAmountUomTypeId()
    {
        return this.productAmountUomTypeId;
    }

    public void setProductAmountUomTypeId(String productAmountUomTypeId)
    {
        this.productAmountUomTypeId = productAmountUomTypeId;
    }

    private String productWeightUomId;

    public String getProductWeightUomId()
    {
        return this.productWeightUomId;
    }

    public void setProductWeightUomId(String productWeightUomId)
    {
        this.productWeightUomId = productWeightUomId;
    }

    private java.math.BigDecimal productShippingWeight;

    public java.math.BigDecimal getProductShippingWeight()
    {
        return this.productShippingWeight;
    }

    public void setProductShippingWeight(java.math.BigDecimal productShippingWeight)
    {
        this.productShippingWeight = productShippingWeight;
    }

    private java.math.BigDecimal productProductWeight;

    public java.math.BigDecimal getProductProductWeight()
    {
        return this.productProductWeight;
    }

    public void setProductProductWeight(java.math.BigDecimal productProductWeight)
    {
        this.productProductWeight = productProductWeight;
    }

    private String productHeightUomId;

    public String getProductHeightUomId()
    {
        return this.productHeightUomId;
    }

    public void setProductHeightUomId(String productHeightUomId)
    {
        this.productHeightUomId = productHeightUomId;
    }

    private java.math.BigDecimal productProductHeight;

    public java.math.BigDecimal getProductProductHeight()
    {
        return this.productProductHeight;
    }

    public void setProductProductHeight(java.math.BigDecimal productProductHeight)
    {
        this.productProductHeight = productProductHeight;
    }

    private java.math.BigDecimal productShippingHeight;

    public java.math.BigDecimal getProductShippingHeight()
    {
        return this.productShippingHeight;
    }

    public void setProductShippingHeight(java.math.BigDecimal productShippingHeight)
    {
        this.productShippingHeight = productShippingHeight;
    }

    private String productWidthUomId;

    public String getProductWidthUomId()
    {
        return this.productWidthUomId;
    }

    public void setProductWidthUomId(String productWidthUomId)
    {
        this.productWidthUomId = productWidthUomId;
    }

    private java.math.BigDecimal productProductWidth;

    public java.math.BigDecimal getProductProductWidth()
    {
        return this.productProductWidth;
    }

    public void setProductProductWidth(java.math.BigDecimal productProductWidth)
    {
        this.productProductWidth = productProductWidth;
    }

    private java.math.BigDecimal productShippingWidth;

    public java.math.BigDecimal getProductShippingWidth()
    {
        return this.productShippingWidth;
    }

    public void setProductShippingWidth(java.math.BigDecimal productShippingWidth)
    {
        this.productShippingWidth = productShippingWidth;
    }

    private String productDepthUomId;

    public String getProductDepthUomId()
    {
        return this.productDepthUomId;
    }

    public void setProductDepthUomId(String productDepthUomId)
    {
        this.productDepthUomId = productDepthUomId;
    }

    private java.math.BigDecimal productProductDepth;

    public java.math.BigDecimal getProductProductDepth()
    {
        return this.productProductDepth;
    }

    public void setProductProductDepth(java.math.BigDecimal productProductDepth)
    {
        this.productProductDepth = productProductDepth;
    }

    private java.math.BigDecimal productShippingDepth;

    public java.math.BigDecimal getProductShippingDepth()
    {
        return this.productShippingDepth;
    }

    public void setProductShippingDepth(java.math.BigDecimal productShippingDepth)
    {
        this.productShippingDepth = productShippingDepth;
    }

    private String productDiameterUomId;

    public String getProductDiameterUomId()
    {
        return this.productDiameterUomId;
    }

    public void setProductDiameterUomId(String productDiameterUomId)
    {
        this.productDiameterUomId = productDiameterUomId;
    }

    private java.math.BigDecimal productProductDiameter;

    public java.math.BigDecimal getProductProductDiameter()
    {
        return this.productProductDiameter;
    }

    public void setProductProductDiameter(java.math.BigDecimal productProductDiameter)
    {
        this.productProductDiameter = productProductDiameter;
    }

    private java.math.BigDecimal productProductRating;

    public java.math.BigDecimal getProductProductRating()
    {
        return this.productProductRating;
    }

    public void setProductProductRating(java.math.BigDecimal productProductRating)
    {
        this.productProductRating = productProductRating;
    }

    private String productRatingTypeEnum;

    public String getProductRatingTypeEnum()
    {
        return this.productRatingTypeEnum;
    }

    public void setProductRatingTypeEnum(String productRatingTypeEnum)
    {
        this.productRatingTypeEnum = productRatingTypeEnum;
    }

    private String productReturnable;

    public String getProductReturnable()
    {
        return this.productReturnable;
    }

    public void setProductReturnable(String productReturnable)
    {
        this.productReturnable = productReturnable;
    }

    private String productTaxable;

    public String getProductTaxable()
    {
        return this.productTaxable;
    }

    public void setProductTaxable(String productTaxable)
    {
        this.productTaxable = productTaxable;
    }

    private String productChargeShipping;

    public String getProductChargeShipping()
    {
        return this.productChargeShipping;
    }

    public void setProductChargeShipping(String productChargeShipping)
    {
        this.productChargeShipping = productChargeShipping;
    }

    private String productAutoCreateKeywords;

    public String getProductAutoCreateKeywords()
    {
        return this.productAutoCreateKeywords;
    }

    public void setProductAutoCreateKeywords(String productAutoCreateKeywords)
    {
        this.productAutoCreateKeywords = productAutoCreateKeywords;
    }

    private String productIncludeInPromotions;

    public String getProductIncludeInPromotions()
    {
        return this.productIncludeInPromotions;
    }

    public void setProductIncludeInPromotions(String productIncludeInPromotions)
    {
        this.productIncludeInPromotions = productIncludeInPromotions;
    }

    private String productIsVirtual;

    public String getProductIsVirtual()
    {
        return this.productIsVirtual;
    }

    public void setProductIsVirtual(String productIsVirtual)
    {
        this.productIsVirtual = productIsVirtual;
    }

    private String productIsVariant;

    public String getProductIsVariant()
    {
        return this.productIsVariant;
    }

    public void setProductIsVariant(String productIsVariant)
    {
        this.productIsVariant = productIsVariant;
    }

    private String productVirtualVariantMethodEnum;

    public String getProductVirtualVariantMethodEnum()
    {
        return this.productVirtualVariantMethodEnum;
    }

    public void setProductVirtualVariantMethodEnum(String productVirtualVariantMethodEnum)
    {
        this.productVirtualVariantMethodEnum = productVirtualVariantMethodEnum;
    }

    private String productInShippingBox;

    public String getProductInShippingBox()
    {
        return this.productInShippingBox;
    }

    public void setProductInShippingBox(String productInShippingBox)
    {
        this.productInShippingBox = productInShippingBox;
    }

    private String productDefaultShipmentBoxTypeId;

    public String getProductDefaultShipmentBoxTypeId()
    {
        return this.productDefaultShipmentBoxTypeId;
    }

    public void setProductDefaultShipmentBoxTypeId(String productDefaultShipmentBoxTypeId)
    {
        this.productDefaultShipmentBoxTypeId = productDefaultShipmentBoxTypeId;
    }

    private Boolean productIsSerialNumbered;

    public Boolean getProductIsSerialNumbered()
    {
        return this.productIsSerialNumbered;
    }

    public void setProductIsSerialNumbered(Boolean productIsSerialNumbered)
    {
        this.productIsSerialNumbered = productIsSerialNumbered;
    }

    private Boolean productIsManagedByLot;

    public Boolean getProductIsManagedByLot()
    {
        return this.productIsManagedByLot;
    }

    public void setProductIsManagedByLot(Boolean productIsManagedByLot)
    {
        this.productIsManagedByLot = productIsManagedByLot;
    }

    private String productAttributeSetId;

    public String getProductAttributeSetId()
    {
        return this.productAttributeSetId;
    }

    public void setProductAttributeSetId(String productAttributeSetId)
    {
        this.productAttributeSetId = productAttributeSetId;
    }

    private String productAttributeSetInstanceId;

    public String getProductAttributeSetInstanceId()
    {
        return this.productAttributeSetInstanceId;
    }

    public void setProductAttributeSetInstanceId(String productAttributeSetInstanceId)
    {
        this.productAttributeSetInstanceId = productAttributeSetInstanceId;
    }

    private String productCreatedBy;

    public String getProductCreatedBy()
    {
        return this.productCreatedBy;
    }

    public void setProductCreatedBy(String productCreatedBy)
    {
        this.productCreatedBy = productCreatedBy;
    }

    private Date productCreatedAt;

    public Date getProductCreatedAt()
    {
        return this.productCreatedAt;
    }

    public void setProductCreatedAt(Date productCreatedAt)
    {
        this.productCreatedAt = productCreatedAt;
    }

    private String productUpdatedBy;

    public String getProductUpdatedBy()
    {
        return this.productUpdatedBy;
    }

    public void setProductUpdatedBy(String productUpdatedBy)
    {
        this.productUpdatedBy = productUpdatedBy;
    }

    private Date productUpdatedAt;

    public Date getProductUpdatedAt()
    {
        return this.productUpdatedAt;
    }

    public void setProductUpdatedAt(Date productUpdatedAt)
    {
        this.productUpdatedAt = productUpdatedAt;
    }

    private Boolean productActive;

    public Boolean getProductActive()
    {
        return this.productActive;
    }

    public void setProductActive(Boolean productActive)
    {
        this.productActive = productActive;
    }

    private Long productVersion;

    public Long getProductVersion()
    {
        return this.productVersion;
    }

    public void setProductVersion(Long productVersion)
    {
        this.productVersion = productVersion;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

}

