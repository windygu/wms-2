package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class ProductStateDto
{

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    private String productTypeId;

    public String getProductTypeId()
    {
        return this.productTypeId;
    }

    public void setProductTypeId(String productTypeId)
    {
        this.productTypeId = productTypeId;
    }

    private String primaryProductCategoryId;

    public String getPrimaryProductCategoryId()
    {
        return this.primaryProductCategoryId;
    }

    public void setPrimaryProductCategoryId(String primaryProductCategoryId)
    {
        this.primaryProductCategoryId = primaryProductCategoryId;
    }

    private String manufacturerPartyId;

    public String getManufacturerPartyId()
    {
        return this.manufacturerPartyId;
    }

    public void setManufacturerPartyId(String manufacturerPartyId)
    {
        this.manufacturerPartyId = manufacturerPartyId;
    }

    private String facilityId;

    public String getFacilityId()
    {
        return this.facilityId;
    }

    public void setFacilityId(String facilityId)
    {
        this.facilityId = facilityId;
    }

    private java.sql.Timestamp introductionDate;

    public java.sql.Timestamp getIntroductionDate()
    {
        return this.introductionDate;
    }

    public void setIntroductionDate(java.sql.Timestamp introductionDate)
    {
        this.introductionDate = introductionDate;
    }

    private java.sql.Timestamp releaseDate;

    public java.sql.Timestamp getReleaseDate()
    {
        return this.releaseDate;
    }

    public void setReleaseDate(java.sql.Timestamp releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    private java.sql.Timestamp supportDiscontinuationDate;

    public java.sql.Timestamp getSupportDiscontinuationDate()
    {
        return this.supportDiscontinuationDate;
    }

    public void setSupportDiscontinuationDate(java.sql.Timestamp supportDiscontinuationDate)
    {
        this.supportDiscontinuationDate = supportDiscontinuationDate;
    }

    private java.sql.Timestamp salesDiscontinuationDate;

    public java.sql.Timestamp getSalesDiscontinuationDate()
    {
        return this.salesDiscontinuationDate;
    }

    public void setSalesDiscontinuationDate(java.sql.Timestamp salesDiscontinuationDate)
    {
        this.salesDiscontinuationDate = salesDiscontinuationDate;
    }

    private String salesDiscWhenNotAvail;

    public String getSalesDiscWhenNotAvail()
    {
        return this.salesDiscWhenNotAvail;
    }

    public void setSalesDiscWhenNotAvail(String salesDiscWhenNotAvail)
    {
        this.salesDiscWhenNotAvail = salesDiscWhenNotAvail;
    }

    private String internalName;

    public String getInternalName()
    {
        return this.internalName;
    }

    public void setInternalName(String internalName)
    {
        this.internalName = internalName;
    }

    private String brandName;

    public String getBrandName()
    {
        return this.brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    private String comments;

    public String getComments()
    {
        return this.comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    private String productName;

    public String getProductName()
    {
        return this.productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String priceDetailText;

    public String getPriceDetailText()
    {
        return this.priceDetailText;
    }

    public void setPriceDetailText(String priceDetailText)
    {
        this.priceDetailText = priceDetailText;
    }

    private String smallImageUrl;

    public String getSmallImageUrl()
    {
        return this.smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl)
    {
        this.smallImageUrl = smallImageUrl;
    }

    private String mediumImageUrl;

    public String getMediumImageUrl()
    {
        return this.mediumImageUrl;
    }

    public void setMediumImageUrl(String mediumImageUrl)
    {
        this.mediumImageUrl = mediumImageUrl;
    }

    private String largeImageUrl;

    public String getLargeImageUrl()
    {
        return this.largeImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl)
    {
        this.largeImageUrl = largeImageUrl;
    }

    private String detailImageUrl;

    public String getDetailImageUrl()
    {
        return this.detailImageUrl;
    }

    public void setDetailImageUrl(String detailImageUrl)
    {
        this.detailImageUrl = detailImageUrl;
    }

    private String originalImageUrl;

    public String getOriginalImageUrl()
    {
        return this.originalImageUrl;
    }

    public void setOriginalImageUrl(String originalImageUrl)
    {
        this.originalImageUrl = originalImageUrl;
    }

    private String detailScreen;

    public String getDetailScreen()
    {
        return this.detailScreen;
    }

    public void setDetailScreen(String detailScreen)
    {
        this.detailScreen = detailScreen;
    }

    private String inventoryMessage;

    public String getInventoryMessage()
    {
        return this.inventoryMessage;
    }

    public void setInventoryMessage(String inventoryMessage)
    {
        this.inventoryMessage = inventoryMessage;
    }

    private String inventoryItemTypeId;

    public String getInventoryItemTypeId()
    {
        return this.inventoryItemTypeId;
    }

    public void setInventoryItemTypeId(String inventoryItemTypeId)
    {
        this.inventoryItemTypeId = inventoryItemTypeId;
    }

    private String requireInventory;

    public String getRequireInventory()
    {
        return this.requireInventory;
    }

    public void setRequireInventory(String requireInventory)
    {
        this.requireInventory = requireInventory;
    }

    private String quantityUomId;

    public String getQuantityUomId()
    {
        return this.quantityUomId;
    }

    public void setQuantityUomId(String quantityUomId)
    {
        this.quantityUomId = quantityUomId;
    }

    private java.math.BigDecimal quantityIncluded;

    public java.math.BigDecimal getQuantityIncluded()
    {
        return this.quantityIncluded;
    }

    public void setQuantityIncluded(java.math.BigDecimal quantityIncluded)
    {
        this.quantityIncluded = quantityIncluded;
    }

    private Long piecesIncluded;

    public Long getPiecesIncluded()
    {
        return this.piecesIncluded;
    }

    public void setPiecesIncluded(Long piecesIncluded)
    {
        this.piecesIncluded = piecesIncluded;
    }

    private String requireAmount;

    public String getRequireAmount()
    {
        return this.requireAmount;
    }

    public void setRequireAmount(String requireAmount)
    {
        this.requireAmount = requireAmount;
    }

    private java.math.BigDecimal fixedAmount;

    public java.math.BigDecimal getFixedAmount()
    {
        return this.fixedAmount;
    }

    public void setFixedAmount(java.math.BigDecimal fixedAmount)
    {
        this.fixedAmount = fixedAmount;
    }

    private String amountUomTypeId;

    public String getAmountUomTypeId()
    {
        return this.amountUomTypeId;
    }

    public void setAmountUomTypeId(String amountUomTypeId)
    {
        this.amountUomTypeId = amountUomTypeId;
    }

    private String weightUomId;

    public String getWeightUomId()
    {
        return this.weightUomId;
    }

    public void setWeightUomId(String weightUomId)
    {
        this.weightUomId = weightUomId;
    }

    private java.math.BigDecimal shippingWeight;

    public java.math.BigDecimal getShippingWeight()
    {
        return this.shippingWeight;
    }

    public void setShippingWeight(java.math.BigDecimal shippingWeight)
    {
        this.shippingWeight = shippingWeight;
    }

    private java.math.BigDecimal productWeight;

    public java.math.BigDecimal getProductWeight()
    {
        return this.productWeight;
    }

    public void setProductWeight(java.math.BigDecimal productWeight)
    {
        this.productWeight = productWeight;
    }

    private String heightUomId;

    public String getHeightUomId()
    {
        return this.heightUomId;
    }

    public void setHeightUomId(String heightUomId)
    {
        this.heightUomId = heightUomId;
    }

    private java.math.BigDecimal productHeight;

    public java.math.BigDecimal getProductHeight()
    {
        return this.productHeight;
    }

    public void setProductHeight(java.math.BigDecimal productHeight)
    {
        this.productHeight = productHeight;
    }

    private java.math.BigDecimal shippingHeight;

    public java.math.BigDecimal getShippingHeight()
    {
        return this.shippingHeight;
    }

    public void setShippingHeight(java.math.BigDecimal shippingHeight)
    {
        this.shippingHeight = shippingHeight;
    }

    private String widthUomId;

    public String getWidthUomId()
    {
        return this.widthUomId;
    }

    public void setWidthUomId(String widthUomId)
    {
        this.widthUomId = widthUomId;
    }

    private java.math.BigDecimal productWidth;

    public java.math.BigDecimal getProductWidth()
    {
        return this.productWidth;
    }

    public void setProductWidth(java.math.BigDecimal productWidth)
    {
        this.productWidth = productWidth;
    }

    private java.math.BigDecimal shippingWidth;

    public java.math.BigDecimal getShippingWidth()
    {
        return this.shippingWidth;
    }

    public void setShippingWidth(java.math.BigDecimal shippingWidth)
    {
        this.shippingWidth = shippingWidth;
    }

    private String depthUomId;

    public String getDepthUomId()
    {
        return this.depthUomId;
    }

    public void setDepthUomId(String depthUomId)
    {
        this.depthUomId = depthUomId;
    }

    private java.math.BigDecimal productDepth;

    public java.math.BigDecimal getProductDepth()
    {
        return this.productDepth;
    }

    public void setProductDepth(java.math.BigDecimal productDepth)
    {
        this.productDepth = productDepth;
    }

    private java.math.BigDecimal shippingDepth;

    public java.math.BigDecimal getShippingDepth()
    {
        return this.shippingDepth;
    }

    public void setShippingDepth(java.math.BigDecimal shippingDepth)
    {
        this.shippingDepth = shippingDepth;
    }

    private String diameterUomId;

    public String getDiameterUomId()
    {
        return this.diameterUomId;
    }

    public void setDiameterUomId(String diameterUomId)
    {
        this.diameterUomId = diameterUomId;
    }

    private java.math.BigDecimal productDiameter;

    public java.math.BigDecimal getProductDiameter()
    {
        return this.productDiameter;
    }

    public void setProductDiameter(java.math.BigDecimal productDiameter)
    {
        this.productDiameter = productDiameter;
    }

    private java.math.BigDecimal productRating;

    public java.math.BigDecimal getProductRating()
    {
        return this.productRating;
    }

    public void setProductRating(java.math.BigDecimal productRating)
    {
        this.productRating = productRating;
    }

    private String ratingTypeEnum;

    public String getRatingTypeEnum()
    {
        return this.ratingTypeEnum;
    }

    public void setRatingTypeEnum(String ratingTypeEnum)
    {
        this.ratingTypeEnum = ratingTypeEnum;
    }

    private String returnable;

    public String getReturnable()
    {
        return this.returnable;
    }

    public void setReturnable(String returnable)
    {
        this.returnable = returnable;
    }

    private String taxable;

    public String getTaxable()
    {
        return this.taxable;
    }

    public void setTaxable(String taxable)
    {
        this.taxable = taxable;
    }

    private String chargeShipping;

    public String getChargeShipping()
    {
        return this.chargeShipping;
    }

    public void setChargeShipping(String chargeShipping)
    {
        this.chargeShipping = chargeShipping;
    }

    private String autoCreateKeywords;

    public String getAutoCreateKeywords()
    {
        return this.autoCreateKeywords;
    }

    public void setAutoCreateKeywords(String autoCreateKeywords)
    {
        this.autoCreateKeywords = autoCreateKeywords;
    }

    private String includeInPromotions;

    public String getIncludeInPromotions()
    {
        return this.includeInPromotions;
    }

    public void setIncludeInPromotions(String includeInPromotions)
    {
        this.includeInPromotions = includeInPromotions;
    }

    private String isVirtual;

    public String getIsVirtual()
    {
        return this.isVirtual;
    }

    public void setIsVirtual(String isVirtual)
    {
        this.isVirtual = isVirtual;
    }

    private String isVariant;

    public String getIsVariant()
    {
        return this.isVariant;
    }

    public void setIsVariant(String isVariant)
    {
        this.isVariant = isVariant;
    }

    private String virtualVariantMethodEnum;

    public String getVirtualVariantMethodEnum()
    {
        return this.virtualVariantMethodEnum;
    }

    public void setVirtualVariantMethodEnum(String virtualVariantMethodEnum)
    {
        this.virtualVariantMethodEnum = virtualVariantMethodEnum;
    }

    private String inShippingBox;

    public String getInShippingBox()
    {
        return this.inShippingBox;
    }

    public void setInShippingBox(String inShippingBox)
    {
        this.inShippingBox = inShippingBox;
    }

    private String defaultShipmentBoxTypeId;

    public String getDefaultShipmentBoxTypeId()
    {
        return this.defaultShipmentBoxTypeId;
    }

    public void setDefaultShipmentBoxTypeId(String defaultShipmentBoxTypeId)
    {
        this.defaultShipmentBoxTypeId = defaultShipmentBoxTypeId;
    }

    private String lotIdFilledIn;

    public String getLotIdFilledIn()
    {
        return this.lotIdFilledIn;
    }

    public void setLotIdFilledIn(String lotIdFilledIn)
    {
        this.lotIdFilledIn = lotIdFilledIn;
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


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public ProductStateDto[] toProductStateDtoArray(Iterable<ProductState> states) 
        {
            ArrayList<ProductStateDto> stateDtos = new ArrayList();
            for (ProductState s : states) {
                ProductStateDto dto = toProductStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new ProductStateDto[0]);
        }

        public ProductStateDto toProductStateDto(ProductState state)
        {
            if(state == null) {
                return null;
            }
            ProductStateDto dto = new ProductStateDto();
            if (returnedFieldsContains("ProductId")) {
                dto.setProductId(state.getProductId());
            }
            if (returnedFieldsContains("ProductTypeId")) {
                dto.setProductTypeId(state.getProductTypeId());
            }
            if (returnedFieldsContains("PrimaryProductCategoryId")) {
                dto.setPrimaryProductCategoryId(state.getPrimaryProductCategoryId());
            }
            if (returnedFieldsContains("ManufacturerPartyId")) {
                dto.setManufacturerPartyId(state.getManufacturerPartyId());
            }
            if (returnedFieldsContains("FacilityId")) {
                dto.setFacilityId(state.getFacilityId());
            }
            if (returnedFieldsContains("IntroductionDate")) {
                dto.setIntroductionDate(state.getIntroductionDate());
            }
            if (returnedFieldsContains("ReleaseDate")) {
                dto.setReleaseDate(state.getReleaseDate());
            }
            if (returnedFieldsContains("SupportDiscontinuationDate")) {
                dto.setSupportDiscontinuationDate(state.getSupportDiscontinuationDate());
            }
            if (returnedFieldsContains("SalesDiscontinuationDate")) {
                dto.setSalesDiscontinuationDate(state.getSalesDiscontinuationDate());
            }
            if (returnedFieldsContains("SalesDiscWhenNotAvail")) {
                dto.setSalesDiscWhenNotAvail(state.getSalesDiscWhenNotAvail());
            }
            if (returnedFieldsContains("InternalName")) {
                dto.setInternalName(state.getInternalName());
            }
            if (returnedFieldsContains("BrandName")) {
                dto.setBrandName(state.getBrandName());
            }
            if (returnedFieldsContains("Comments")) {
                dto.setComments(state.getComments());
            }
            if (returnedFieldsContains("ProductName")) {
                dto.setProductName(state.getProductName());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("PriceDetailText")) {
                dto.setPriceDetailText(state.getPriceDetailText());
            }
            if (returnedFieldsContains("SmallImageUrl")) {
                dto.setSmallImageUrl(state.getSmallImageUrl());
            }
            if (returnedFieldsContains("MediumImageUrl")) {
                dto.setMediumImageUrl(state.getMediumImageUrl());
            }
            if (returnedFieldsContains("LargeImageUrl")) {
                dto.setLargeImageUrl(state.getLargeImageUrl());
            }
            if (returnedFieldsContains("DetailImageUrl")) {
                dto.setDetailImageUrl(state.getDetailImageUrl());
            }
            if (returnedFieldsContains("OriginalImageUrl")) {
                dto.setOriginalImageUrl(state.getOriginalImageUrl());
            }
            if (returnedFieldsContains("DetailScreen")) {
                dto.setDetailScreen(state.getDetailScreen());
            }
            if (returnedFieldsContains("InventoryMessage")) {
                dto.setInventoryMessage(state.getInventoryMessage());
            }
            if (returnedFieldsContains("InventoryItemTypeId")) {
                dto.setInventoryItemTypeId(state.getInventoryItemTypeId());
            }
            if (returnedFieldsContains("RequireInventory")) {
                dto.setRequireInventory(state.getRequireInventory());
            }
            if (returnedFieldsContains("QuantityUomId")) {
                dto.setQuantityUomId(state.getQuantityUomId());
            }
            if (returnedFieldsContains("QuantityIncluded")) {
                dto.setQuantityIncluded(state.getQuantityIncluded());
            }
            if (returnedFieldsContains("PiecesIncluded")) {
                dto.setPiecesIncluded(state.getPiecesIncluded());
            }
            if (returnedFieldsContains("RequireAmount")) {
                dto.setRequireAmount(state.getRequireAmount());
            }
            if (returnedFieldsContains("FixedAmount")) {
                dto.setFixedAmount(state.getFixedAmount());
            }
            if (returnedFieldsContains("AmountUomTypeId")) {
                dto.setAmountUomTypeId(state.getAmountUomTypeId());
            }
            if (returnedFieldsContains("WeightUomId")) {
                dto.setWeightUomId(state.getWeightUomId());
            }
            if (returnedFieldsContains("ShippingWeight")) {
                dto.setShippingWeight(state.getShippingWeight());
            }
            if (returnedFieldsContains("ProductWeight")) {
                dto.setProductWeight(state.getProductWeight());
            }
            if (returnedFieldsContains("HeightUomId")) {
                dto.setHeightUomId(state.getHeightUomId());
            }
            if (returnedFieldsContains("ProductHeight")) {
                dto.setProductHeight(state.getProductHeight());
            }
            if (returnedFieldsContains("ShippingHeight")) {
                dto.setShippingHeight(state.getShippingHeight());
            }
            if (returnedFieldsContains("WidthUomId")) {
                dto.setWidthUomId(state.getWidthUomId());
            }
            if (returnedFieldsContains("ProductWidth")) {
                dto.setProductWidth(state.getProductWidth());
            }
            if (returnedFieldsContains("ShippingWidth")) {
                dto.setShippingWidth(state.getShippingWidth());
            }
            if (returnedFieldsContains("DepthUomId")) {
                dto.setDepthUomId(state.getDepthUomId());
            }
            if (returnedFieldsContains("ProductDepth")) {
                dto.setProductDepth(state.getProductDepth());
            }
            if (returnedFieldsContains("ShippingDepth")) {
                dto.setShippingDepth(state.getShippingDepth());
            }
            if (returnedFieldsContains("DiameterUomId")) {
                dto.setDiameterUomId(state.getDiameterUomId());
            }
            if (returnedFieldsContains("ProductDiameter")) {
                dto.setProductDiameter(state.getProductDiameter());
            }
            if (returnedFieldsContains("ProductRating")) {
                dto.setProductRating(state.getProductRating());
            }
            if (returnedFieldsContains("RatingTypeEnum")) {
                dto.setRatingTypeEnum(state.getRatingTypeEnum());
            }
            if (returnedFieldsContains("Returnable")) {
                dto.setReturnable(state.getReturnable());
            }
            if (returnedFieldsContains("Taxable")) {
                dto.setTaxable(state.getTaxable());
            }
            if (returnedFieldsContains("ChargeShipping")) {
                dto.setChargeShipping(state.getChargeShipping());
            }
            if (returnedFieldsContains("AutoCreateKeywords")) {
                dto.setAutoCreateKeywords(state.getAutoCreateKeywords());
            }
            if (returnedFieldsContains("IncludeInPromotions")) {
                dto.setIncludeInPromotions(state.getIncludeInPromotions());
            }
            if (returnedFieldsContains("IsVirtual")) {
                dto.setIsVirtual(state.getIsVirtual());
            }
            if (returnedFieldsContains("IsVariant")) {
                dto.setIsVariant(state.getIsVariant());
            }
            if (returnedFieldsContains("VirtualVariantMethodEnum")) {
                dto.setVirtualVariantMethodEnum(state.getVirtualVariantMethodEnum());
            }
            if (returnedFieldsContains("InShippingBox")) {
                dto.setInShippingBox(state.getInShippingBox());
            }
            if (returnedFieldsContains("DefaultShipmentBoxTypeId")) {
                dto.setDefaultShipmentBoxTypeId(state.getDefaultShipmentBoxTypeId());
            }
            if (returnedFieldsContains("LotIdFilledIn")) {
                dto.setLotIdFilledIn(state.getLotIdFilledIn());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            return dto;
        }

    }
}

