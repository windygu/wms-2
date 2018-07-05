package org.dddml.wms.domain.goodidentificationmvo;

import java.util.*;
import org.dddml.wms.domain.product.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.goodidentificationmvo.GoodIdentificationMvoEvent.*;

public abstract class AbstractGoodIdentificationMvoState implements GoodIdentificationMvoState
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

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Boolean deleted;

    public Boolean getDeleted()
    {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
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

    private Long productVersion;

    public Long getProductVersion()
    {
        return this.productVersion;
    }

    public void setProductVersion(Long productVersion)
    {
        this.productVersion = productVersion;
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

    public boolean isStateUnsaved() 
    {
        return this.getProductVersion() == null;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractGoodIdentificationMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setProductGoodIdentificationId(((GoodIdentificationMvoEvent) events.get(0)).getGoodIdentificationMvoEventId().getProductGoodIdentificationId());
            for (Event e : events) {
                mutate(e);
                this.setProductVersion(this.getProductVersion() + 1);
            }
        }
    }


    public AbstractGoodIdentificationMvoState() {
        this(false);
    }

    public AbstractGoodIdentificationMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof GoodIdentificationMvoStateCreated) {
            when((GoodIdentificationMvoStateCreated) e);
        } else if (e instanceof GoodIdentificationMvoStateMergePatched) {
            when((GoodIdentificationMvoStateMergePatched) e);
        } else if (e instanceof GoodIdentificationMvoStateDeleted) {
            when((GoodIdentificationMvoStateDeleted) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(GoodIdentificationMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setIdValue(e.getIdValue());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setProductProductTypeId(e.getProductProductTypeId());
        this.setProductPrimaryProductCategoryId(e.getProductPrimaryProductCategoryId());
        this.setProductManufacturerPartyId(e.getProductManufacturerPartyId());
        this.setProductFacilityId(e.getProductFacilityId());
        this.setProductIntroductionDate(e.getProductIntroductionDate());
        this.setProductReleaseDate(e.getProductReleaseDate());
        this.setProductSupportDiscontinuationDate(e.getProductSupportDiscontinuationDate());
        this.setProductSalesDiscontinuationDate(e.getProductSalesDiscontinuationDate());
        this.setProductSalesDiscWhenNotAvail(e.getProductSalesDiscWhenNotAvail());
        this.setProductInternalName(e.getProductInternalName());
        this.setProductBrandName(e.getProductBrandName());
        this.setProductComments(e.getProductComments());
        this.setProductProductName(e.getProductProductName());
        this.setProductDescription(e.getProductDescription());
        this.setProductPriceDetailText(e.getProductPriceDetailText());
        this.setProductSmallImageUrl(e.getProductSmallImageUrl());
        this.setProductMediumImageUrl(e.getProductMediumImageUrl());
        this.setProductLargeImageUrl(e.getProductLargeImageUrl());
        this.setProductDetailImageUrl(e.getProductDetailImageUrl());
        this.setProductOriginalImageUrl(e.getProductOriginalImageUrl());
        this.setProductDetailScreen(e.getProductDetailScreen());
        this.setProductInventoryMessage(e.getProductInventoryMessage());
        this.setProductInventoryItemTypeId(e.getProductInventoryItemTypeId());
        this.setProductRequireInventory(e.getProductRequireInventory());
        this.setProductQuantityUomId(e.getProductQuantityUomId());
        this.setProductQuantityIncluded(e.getProductQuantityIncluded());
        this.setProductPiecesIncluded(e.getProductPiecesIncluded());
        this.setProductRequireAmount(e.getProductRequireAmount());
        this.setProductFixedAmount(e.getProductFixedAmount());
        this.setProductAmountUomTypeId(e.getProductAmountUomTypeId());
        this.setProductWeightUomId(e.getProductWeightUomId());
        this.setProductShippingWeight(e.getProductShippingWeight());
        this.setProductProductWeight(e.getProductProductWeight());
        this.setProductHeightUomId(e.getProductHeightUomId());
        this.setProductProductHeight(e.getProductProductHeight());
        this.setProductShippingHeight(e.getProductShippingHeight());
        this.setProductWidthUomId(e.getProductWidthUomId());
        this.setProductProductWidth(e.getProductProductWidth());
        this.setProductShippingWidth(e.getProductShippingWidth());
        this.setProductDepthUomId(e.getProductDepthUomId());
        this.setProductProductDepth(e.getProductProductDepth());
        this.setProductShippingDepth(e.getProductShippingDepth());
        this.setProductDiameterUomId(e.getProductDiameterUomId());
        this.setProductProductDiameter(e.getProductProductDiameter());
        this.setProductProductRating(e.getProductProductRating());
        this.setProductRatingTypeEnum(e.getProductRatingTypeEnum());
        this.setProductReturnable(e.getProductReturnable());
        this.setProductTaxable(e.getProductTaxable());
        this.setProductChargeShipping(e.getProductChargeShipping());
        this.setProductAutoCreateKeywords(e.getProductAutoCreateKeywords());
        this.setProductIncludeInPromotions(e.getProductIncludeInPromotions());
        this.setProductIsVirtual(e.getProductIsVirtual());
        this.setProductIsVariant(e.getProductIsVariant());
        this.setProductVirtualVariantMethodEnum(e.getProductVirtualVariantMethodEnum());
        this.setProductInShippingBox(e.getProductInShippingBox());
        this.setProductDefaultShipmentBoxTypeId(e.getProductDefaultShipmentBoxTypeId());
        this.setProductIsSerialNumbered(e.getProductIsSerialNumbered());
        this.setProductIsManagedByLot(e.getProductIsManagedByLot());
        this.setProductAttributeSetId(e.getProductAttributeSetId());
        this.setProductAttributeSetInstanceId(e.getProductAttributeSetInstanceId());
        this.setProductCreatedBy(e.getProductCreatedBy());
        this.setProductCreatedAt(e.getProductCreatedAt());
        this.setProductUpdatedBy(e.getProductUpdatedBy());
        this.setProductUpdatedAt(e.getProductUpdatedAt());
        this.setProductActive(e.getProductActive());

        this.setDeleted(false);

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(GoodIdentificationMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getIdValue() == null)
        {
            if (e.getIsPropertyIdValueRemoved() != null && e.getIsPropertyIdValueRemoved())
            {
                this.setIdValue(null);
            }
        }
        else
        {
            this.setIdValue(e.getIdValue());
        }
        if (e.getVersion() == null)
        {
            if (e.getIsPropertyVersionRemoved() != null && e.getIsPropertyVersionRemoved())
            {
                this.setVersion(null);
            }
        }
        else
        {
            this.setVersion(e.getVersion());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }
        if (e.getProductProductTypeId() == null)
        {
            if (e.getIsPropertyProductProductTypeIdRemoved() != null && e.getIsPropertyProductProductTypeIdRemoved())
            {
                this.setProductProductTypeId(null);
            }
        }
        else
        {
            this.setProductProductTypeId(e.getProductProductTypeId());
        }
        if (e.getProductPrimaryProductCategoryId() == null)
        {
            if (e.getIsPropertyProductPrimaryProductCategoryIdRemoved() != null && e.getIsPropertyProductPrimaryProductCategoryIdRemoved())
            {
                this.setProductPrimaryProductCategoryId(null);
            }
        }
        else
        {
            this.setProductPrimaryProductCategoryId(e.getProductPrimaryProductCategoryId());
        }
        if (e.getProductManufacturerPartyId() == null)
        {
            if (e.getIsPropertyProductManufacturerPartyIdRemoved() != null && e.getIsPropertyProductManufacturerPartyIdRemoved())
            {
                this.setProductManufacturerPartyId(null);
            }
        }
        else
        {
            this.setProductManufacturerPartyId(e.getProductManufacturerPartyId());
        }
        if (e.getProductFacilityId() == null)
        {
            if (e.getIsPropertyProductFacilityIdRemoved() != null && e.getIsPropertyProductFacilityIdRemoved())
            {
                this.setProductFacilityId(null);
            }
        }
        else
        {
            this.setProductFacilityId(e.getProductFacilityId());
        }
        if (e.getProductIntroductionDate() == null)
        {
            if (e.getIsPropertyProductIntroductionDateRemoved() != null && e.getIsPropertyProductIntroductionDateRemoved())
            {
                this.setProductIntroductionDate(null);
            }
        }
        else
        {
            this.setProductIntroductionDate(e.getProductIntroductionDate());
        }
        if (e.getProductReleaseDate() == null)
        {
            if (e.getIsPropertyProductReleaseDateRemoved() != null && e.getIsPropertyProductReleaseDateRemoved())
            {
                this.setProductReleaseDate(null);
            }
        }
        else
        {
            this.setProductReleaseDate(e.getProductReleaseDate());
        }
        if (e.getProductSupportDiscontinuationDate() == null)
        {
            if (e.getIsPropertyProductSupportDiscontinuationDateRemoved() != null && e.getIsPropertyProductSupportDiscontinuationDateRemoved())
            {
                this.setProductSupportDiscontinuationDate(null);
            }
        }
        else
        {
            this.setProductSupportDiscontinuationDate(e.getProductSupportDiscontinuationDate());
        }
        if (e.getProductSalesDiscontinuationDate() == null)
        {
            if (e.getIsPropertyProductSalesDiscontinuationDateRemoved() != null && e.getIsPropertyProductSalesDiscontinuationDateRemoved())
            {
                this.setProductSalesDiscontinuationDate(null);
            }
        }
        else
        {
            this.setProductSalesDiscontinuationDate(e.getProductSalesDiscontinuationDate());
        }
        if (e.getProductSalesDiscWhenNotAvail() == null)
        {
            if (e.getIsPropertyProductSalesDiscWhenNotAvailRemoved() != null && e.getIsPropertyProductSalesDiscWhenNotAvailRemoved())
            {
                this.setProductSalesDiscWhenNotAvail(null);
            }
        }
        else
        {
            this.setProductSalesDiscWhenNotAvail(e.getProductSalesDiscWhenNotAvail());
        }
        if (e.getProductInternalName() == null)
        {
            if (e.getIsPropertyProductInternalNameRemoved() != null && e.getIsPropertyProductInternalNameRemoved())
            {
                this.setProductInternalName(null);
            }
        }
        else
        {
            this.setProductInternalName(e.getProductInternalName());
        }
        if (e.getProductBrandName() == null)
        {
            if (e.getIsPropertyProductBrandNameRemoved() != null && e.getIsPropertyProductBrandNameRemoved())
            {
                this.setProductBrandName(null);
            }
        }
        else
        {
            this.setProductBrandName(e.getProductBrandName());
        }
        if (e.getProductComments() == null)
        {
            if (e.getIsPropertyProductCommentsRemoved() != null && e.getIsPropertyProductCommentsRemoved())
            {
                this.setProductComments(null);
            }
        }
        else
        {
            this.setProductComments(e.getProductComments());
        }
        if (e.getProductProductName() == null)
        {
            if (e.getIsPropertyProductProductNameRemoved() != null && e.getIsPropertyProductProductNameRemoved())
            {
                this.setProductProductName(null);
            }
        }
        else
        {
            this.setProductProductName(e.getProductProductName());
        }
        if (e.getProductDescription() == null)
        {
            if (e.getIsPropertyProductDescriptionRemoved() != null && e.getIsPropertyProductDescriptionRemoved())
            {
                this.setProductDescription(null);
            }
        }
        else
        {
            this.setProductDescription(e.getProductDescription());
        }
        if (e.getProductPriceDetailText() == null)
        {
            if (e.getIsPropertyProductPriceDetailTextRemoved() != null && e.getIsPropertyProductPriceDetailTextRemoved())
            {
                this.setProductPriceDetailText(null);
            }
        }
        else
        {
            this.setProductPriceDetailText(e.getProductPriceDetailText());
        }
        if (e.getProductSmallImageUrl() == null)
        {
            if (e.getIsPropertyProductSmallImageUrlRemoved() != null && e.getIsPropertyProductSmallImageUrlRemoved())
            {
                this.setProductSmallImageUrl(null);
            }
        }
        else
        {
            this.setProductSmallImageUrl(e.getProductSmallImageUrl());
        }
        if (e.getProductMediumImageUrl() == null)
        {
            if (e.getIsPropertyProductMediumImageUrlRemoved() != null && e.getIsPropertyProductMediumImageUrlRemoved())
            {
                this.setProductMediumImageUrl(null);
            }
        }
        else
        {
            this.setProductMediumImageUrl(e.getProductMediumImageUrl());
        }
        if (e.getProductLargeImageUrl() == null)
        {
            if (e.getIsPropertyProductLargeImageUrlRemoved() != null && e.getIsPropertyProductLargeImageUrlRemoved())
            {
                this.setProductLargeImageUrl(null);
            }
        }
        else
        {
            this.setProductLargeImageUrl(e.getProductLargeImageUrl());
        }
        if (e.getProductDetailImageUrl() == null)
        {
            if (e.getIsPropertyProductDetailImageUrlRemoved() != null && e.getIsPropertyProductDetailImageUrlRemoved())
            {
                this.setProductDetailImageUrl(null);
            }
        }
        else
        {
            this.setProductDetailImageUrl(e.getProductDetailImageUrl());
        }
        if (e.getProductOriginalImageUrl() == null)
        {
            if (e.getIsPropertyProductOriginalImageUrlRemoved() != null && e.getIsPropertyProductOriginalImageUrlRemoved())
            {
                this.setProductOriginalImageUrl(null);
            }
        }
        else
        {
            this.setProductOriginalImageUrl(e.getProductOriginalImageUrl());
        }
        if (e.getProductDetailScreen() == null)
        {
            if (e.getIsPropertyProductDetailScreenRemoved() != null && e.getIsPropertyProductDetailScreenRemoved())
            {
                this.setProductDetailScreen(null);
            }
        }
        else
        {
            this.setProductDetailScreen(e.getProductDetailScreen());
        }
        if (e.getProductInventoryMessage() == null)
        {
            if (e.getIsPropertyProductInventoryMessageRemoved() != null && e.getIsPropertyProductInventoryMessageRemoved())
            {
                this.setProductInventoryMessage(null);
            }
        }
        else
        {
            this.setProductInventoryMessage(e.getProductInventoryMessage());
        }
        if (e.getProductInventoryItemTypeId() == null)
        {
            if (e.getIsPropertyProductInventoryItemTypeIdRemoved() != null && e.getIsPropertyProductInventoryItemTypeIdRemoved())
            {
                this.setProductInventoryItemTypeId(null);
            }
        }
        else
        {
            this.setProductInventoryItemTypeId(e.getProductInventoryItemTypeId());
        }
        if (e.getProductRequireInventory() == null)
        {
            if (e.getIsPropertyProductRequireInventoryRemoved() != null && e.getIsPropertyProductRequireInventoryRemoved())
            {
                this.setProductRequireInventory(null);
            }
        }
        else
        {
            this.setProductRequireInventory(e.getProductRequireInventory());
        }
        if (e.getProductQuantityUomId() == null)
        {
            if (e.getIsPropertyProductQuantityUomIdRemoved() != null && e.getIsPropertyProductQuantityUomIdRemoved())
            {
                this.setProductQuantityUomId(null);
            }
        }
        else
        {
            this.setProductQuantityUomId(e.getProductQuantityUomId());
        }
        if (e.getProductQuantityIncluded() == null)
        {
            if (e.getIsPropertyProductQuantityIncludedRemoved() != null && e.getIsPropertyProductQuantityIncludedRemoved())
            {
                this.setProductQuantityIncluded(null);
            }
        }
        else
        {
            this.setProductQuantityIncluded(e.getProductQuantityIncluded());
        }
        if (e.getProductPiecesIncluded() == null)
        {
            if (e.getIsPropertyProductPiecesIncludedRemoved() != null && e.getIsPropertyProductPiecesIncludedRemoved())
            {
                this.setProductPiecesIncluded(null);
            }
        }
        else
        {
            this.setProductPiecesIncluded(e.getProductPiecesIncluded());
        }
        if (e.getProductRequireAmount() == null)
        {
            if (e.getIsPropertyProductRequireAmountRemoved() != null && e.getIsPropertyProductRequireAmountRemoved())
            {
                this.setProductRequireAmount(null);
            }
        }
        else
        {
            this.setProductRequireAmount(e.getProductRequireAmount());
        }
        if (e.getProductFixedAmount() == null)
        {
            if (e.getIsPropertyProductFixedAmountRemoved() != null && e.getIsPropertyProductFixedAmountRemoved())
            {
                this.setProductFixedAmount(null);
            }
        }
        else
        {
            this.setProductFixedAmount(e.getProductFixedAmount());
        }
        if (e.getProductAmountUomTypeId() == null)
        {
            if (e.getIsPropertyProductAmountUomTypeIdRemoved() != null && e.getIsPropertyProductAmountUomTypeIdRemoved())
            {
                this.setProductAmountUomTypeId(null);
            }
        }
        else
        {
            this.setProductAmountUomTypeId(e.getProductAmountUomTypeId());
        }
        if (e.getProductWeightUomId() == null)
        {
            if (e.getIsPropertyProductWeightUomIdRemoved() != null && e.getIsPropertyProductWeightUomIdRemoved())
            {
                this.setProductWeightUomId(null);
            }
        }
        else
        {
            this.setProductWeightUomId(e.getProductWeightUomId());
        }
        if (e.getProductShippingWeight() == null)
        {
            if (e.getIsPropertyProductShippingWeightRemoved() != null && e.getIsPropertyProductShippingWeightRemoved())
            {
                this.setProductShippingWeight(null);
            }
        }
        else
        {
            this.setProductShippingWeight(e.getProductShippingWeight());
        }
        if (e.getProductProductWeight() == null)
        {
            if (e.getIsPropertyProductProductWeightRemoved() != null && e.getIsPropertyProductProductWeightRemoved())
            {
                this.setProductProductWeight(null);
            }
        }
        else
        {
            this.setProductProductWeight(e.getProductProductWeight());
        }
        if (e.getProductHeightUomId() == null)
        {
            if (e.getIsPropertyProductHeightUomIdRemoved() != null && e.getIsPropertyProductHeightUomIdRemoved())
            {
                this.setProductHeightUomId(null);
            }
        }
        else
        {
            this.setProductHeightUomId(e.getProductHeightUomId());
        }
        if (e.getProductProductHeight() == null)
        {
            if (e.getIsPropertyProductProductHeightRemoved() != null && e.getIsPropertyProductProductHeightRemoved())
            {
                this.setProductProductHeight(null);
            }
        }
        else
        {
            this.setProductProductHeight(e.getProductProductHeight());
        }
        if (e.getProductShippingHeight() == null)
        {
            if (e.getIsPropertyProductShippingHeightRemoved() != null && e.getIsPropertyProductShippingHeightRemoved())
            {
                this.setProductShippingHeight(null);
            }
        }
        else
        {
            this.setProductShippingHeight(e.getProductShippingHeight());
        }
        if (e.getProductWidthUomId() == null)
        {
            if (e.getIsPropertyProductWidthUomIdRemoved() != null && e.getIsPropertyProductWidthUomIdRemoved())
            {
                this.setProductWidthUomId(null);
            }
        }
        else
        {
            this.setProductWidthUomId(e.getProductWidthUomId());
        }
        if (e.getProductProductWidth() == null)
        {
            if (e.getIsPropertyProductProductWidthRemoved() != null && e.getIsPropertyProductProductWidthRemoved())
            {
                this.setProductProductWidth(null);
            }
        }
        else
        {
            this.setProductProductWidth(e.getProductProductWidth());
        }
        if (e.getProductShippingWidth() == null)
        {
            if (e.getIsPropertyProductShippingWidthRemoved() != null && e.getIsPropertyProductShippingWidthRemoved())
            {
                this.setProductShippingWidth(null);
            }
        }
        else
        {
            this.setProductShippingWidth(e.getProductShippingWidth());
        }
        if (e.getProductDepthUomId() == null)
        {
            if (e.getIsPropertyProductDepthUomIdRemoved() != null && e.getIsPropertyProductDepthUomIdRemoved())
            {
                this.setProductDepthUomId(null);
            }
        }
        else
        {
            this.setProductDepthUomId(e.getProductDepthUomId());
        }
        if (e.getProductProductDepth() == null)
        {
            if (e.getIsPropertyProductProductDepthRemoved() != null && e.getIsPropertyProductProductDepthRemoved())
            {
                this.setProductProductDepth(null);
            }
        }
        else
        {
            this.setProductProductDepth(e.getProductProductDepth());
        }
        if (e.getProductShippingDepth() == null)
        {
            if (e.getIsPropertyProductShippingDepthRemoved() != null && e.getIsPropertyProductShippingDepthRemoved())
            {
                this.setProductShippingDepth(null);
            }
        }
        else
        {
            this.setProductShippingDepth(e.getProductShippingDepth());
        }
        if (e.getProductDiameterUomId() == null)
        {
            if (e.getIsPropertyProductDiameterUomIdRemoved() != null && e.getIsPropertyProductDiameterUomIdRemoved())
            {
                this.setProductDiameterUomId(null);
            }
        }
        else
        {
            this.setProductDiameterUomId(e.getProductDiameterUomId());
        }
        if (e.getProductProductDiameter() == null)
        {
            if (e.getIsPropertyProductProductDiameterRemoved() != null && e.getIsPropertyProductProductDiameterRemoved())
            {
                this.setProductProductDiameter(null);
            }
        }
        else
        {
            this.setProductProductDiameter(e.getProductProductDiameter());
        }
        if (e.getProductProductRating() == null)
        {
            if (e.getIsPropertyProductProductRatingRemoved() != null && e.getIsPropertyProductProductRatingRemoved())
            {
                this.setProductProductRating(null);
            }
        }
        else
        {
            this.setProductProductRating(e.getProductProductRating());
        }
        if (e.getProductRatingTypeEnum() == null)
        {
            if (e.getIsPropertyProductRatingTypeEnumRemoved() != null && e.getIsPropertyProductRatingTypeEnumRemoved())
            {
                this.setProductRatingTypeEnum(null);
            }
        }
        else
        {
            this.setProductRatingTypeEnum(e.getProductRatingTypeEnum());
        }
        if (e.getProductReturnable() == null)
        {
            if (e.getIsPropertyProductReturnableRemoved() != null && e.getIsPropertyProductReturnableRemoved())
            {
                this.setProductReturnable(null);
            }
        }
        else
        {
            this.setProductReturnable(e.getProductReturnable());
        }
        if (e.getProductTaxable() == null)
        {
            if (e.getIsPropertyProductTaxableRemoved() != null && e.getIsPropertyProductTaxableRemoved())
            {
                this.setProductTaxable(null);
            }
        }
        else
        {
            this.setProductTaxable(e.getProductTaxable());
        }
        if (e.getProductChargeShipping() == null)
        {
            if (e.getIsPropertyProductChargeShippingRemoved() != null && e.getIsPropertyProductChargeShippingRemoved())
            {
                this.setProductChargeShipping(null);
            }
        }
        else
        {
            this.setProductChargeShipping(e.getProductChargeShipping());
        }
        if (e.getProductAutoCreateKeywords() == null)
        {
            if (e.getIsPropertyProductAutoCreateKeywordsRemoved() != null && e.getIsPropertyProductAutoCreateKeywordsRemoved())
            {
                this.setProductAutoCreateKeywords(null);
            }
        }
        else
        {
            this.setProductAutoCreateKeywords(e.getProductAutoCreateKeywords());
        }
        if (e.getProductIncludeInPromotions() == null)
        {
            if (e.getIsPropertyProductIncludeInPromotionsRemoved() != null && e.getIsPropertyProductIncludeInPromotionsRemoved())
            {
                this.setProductIncludeInPromotions(null);
            }
        }
        else
        {
            this.setProductIncludeInPromotions(e.getProductIncludeInPromotions());
        }
        if (e.getProductIsVirtual() == null)
        {
            if (e.getIsPropertyProductIsVirtualRemoved() != null && e.getIsPropertyProductIsVirtualRemoved())
            {
                this.setProductIsVirtual(null);
            }
        }
        else
        {
            this.setProductIsVirtual(e.getProductIsVirtual());
        }
        if (e.getProductIsVariant() == null)
        {
            if (e.getIsPropertyProductIsVariantRemoved() != null && e.getIsPropertyProductIsVariantRemoved())
            {
                this.setProductIsVariant(null);
            }
        }
        else
        {
            this.setProductIsVariant(e.getProductIsVariant());
        }
        if (e.getProductVirtualVariantMethodEnum() == null)
        {
            if (e.getIsPropertyProductVirtualVariantMethodEnumRemoved() != null && e.getIsPropertyProductVirtualVariantMethodEnumRemoved())
            {
                this.setProductVirtualVariantMethodEnum(null);
            }
        }
        else
        {
            this.setProductVirtualVariantMethodEnum(e.getProductVirtualVariantMethodEnum());
        }
        if (e.getProductInShippingBox() == null)
        {
            if (e.getIsPropertyProductInShippingBoxRemoved() != null && e.getIsPropertyProductInShippingBoxRemoved())
            {
                this.setProductInShippingBox(null);
            }
        }
        else
        {
            this.setProductInShippingBox(e.getProductInShippingBox());
        }
        if (e.getProductDefaultShipmentBoxTypeId() == null)
        {
            if (e.getIsPropertyProductDefaultShipmentBoxTypeIdRemoved() != null && e.getIsPropertyProductDefaultShipmentBoxTypeIdRemoved())
            {
                this.setProductDefaultShipmentBoxTypeId(null);
            }
        }
        else
        {
            this.setProductDefaultShipmentBoxTypeId(e.getProductDefaultShipmentBoxTypeId());
        }
        if (e.getProductIsSerialNumbered() == null)
        {
            if (e.getIsPropertyProductIsSerialNumberedRemoved() != null && e.getIsPropertyProductIsSerialNumberedRemoved())
            {
                this.setProductIsSerialNumbered(null);
            }
        }
        else
        {
            this.setProductIsSerialNumbered(e.getProductIsSerialNumbered());
        }
        if (e.getProductIsManagedByLot() == null)
        {
            if (e.getIsPropertyProductIsManagedByLotRemoved() != null && e.getIsPropertyProductIsManagedByLotRemoved())
            {
                this.setProductIsManagedByLot(null);
            }
        }
        else
        {
            this.setProductIsManagedByLot(e.getProductIsManagedByLot());
        }
        if (e.getProductAttributeSetId() == null)
        {
            if (e.getIsPropertyProductAttributeSetIdRemoved() != null && e.getIsPropertyProductAttributeSetIdRemoved())
            {
                this.setProductAttributeSetId(null);
            }
        }
        else
        {
            this.setProductAttributeSetId(e.getProductAttributeSetId());
        }
        if (e.getProductAttributeSetInstanceId() == null)
        {
            if (e.getIsPropertyProductAttributeSetInstanceIdRemoved() != null && e.getIsPropertyProductAttributeSetInstanceIdRemoved())
            {
                this.setProductAttributeSetInstanceId(null);
            }
        }
        else
        {
            this.setProductAttributeSetInstanceId(e.getProductAttributeSetInstanceId());
        }
        if (e.getProductCreatedBy() == null)
        {
            if (e.getIsPropertyProductCreatedByRemoved() != null && e.getIsPropertyProductCreatedByRemoved())
            {
                this.setProductCreatedBy(null);
            }
        }
        else
        {
            this.setProductCreatedBy(e.getProductCreatedBy());
        }
        if (e.getProductCreatedAt() == null)
        {
            if (e.getIsPropertyProductCreatedAtRemoved() != null && e.getIsPropertyProductCreatedAtRemoved())
            {
                this.setProductCreatedAt(null);
            }
        }
        else
        {
            this.setProductCreatedAt(e.getProductCreatedAt());
        }
        if (e.getProductUpdatedBy() == null)
        {
            if (e.getIsPropertyProductUpdatedByRemoved() != null && e.getIsPropertyProductUpdatedByRemoved())
            {
                this.setProductUpdatedBy(null);
            }
        }
        else
        {
            this.setProductUpdatedBy(e.getProductUpdatedBy());
        }
        if (e.getProductUpdatedAt() == null)
        {
            if (e.getIsPropertyProductUpdatedAtRemoved() != null && e.getIsPropertyProductUpdatedAtRemoved())
            {
                this.setProductUpdatedAt(null);
            }
        }
        else
        {
            this.setProductUpdatedAt(e.getProductUpdatedAt());
        }
        if (e.getProductActive() == null)
        {
            if (e.getIsPropertyProductActiveRemoved() != null && e.getIsPropertyProductActiveRemoved())
            {
                this.setProductActive(null);
            }
        }
        else
        {
            this.setProductActive(e.getProductActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void when(GoodIdentificationMvoStateDeleted e)
    {
        throwOnWrongEvent(e);

        this.setDeleted(true);
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(GoodIdentificationMvoEvent event)
    {
        ProductGoodIdentificationId stateEntityId = this.getProductGoodIdentificationId(); // Aggregate Id
        ProductGoodIdentificationId eventEntityId = event.getGoodIdentificationMvoEventId().getProductGoodIdentificationId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getProductVersion();
        Long eventVersion = event.getGoodIdentificationMvoEventId().getProductVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("event.getGoodIdentificationMvoEventId().getProductVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(GoodIdentificationMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleGoodIdentificationMvoState extends AbstractGoodIdentificationMvoState
    {

        public SimpleGoodIdentificationMvoState() {
        }

        public SimpleGoodIdentificationMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleGoodIdentificationMvoState(List<Event> events) {
            super(events);
        }

    }


}

