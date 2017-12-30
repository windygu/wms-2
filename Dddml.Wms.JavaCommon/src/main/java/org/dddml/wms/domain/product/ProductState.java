package org.dddml.wms.domain.product;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.product.ProductStateEvent.*;

public interface ProductState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getProductId();

    void setProductId(String productId);

    String getProductTypeId();

    void setProductTypeId(String productTypeId);

    String getPrimaryProductCategoryId();

    void setPrimaryProductCategoryId(String primaryProductCategoryId);

    String getManufacturerPartyId();

    void setManufacturerPartyId(String manufacturerPartyId);

    String getFacilityId();

    void setFacilityId(String facilityId);

    java.sql.Timestamp getIntroductionDate();

    void setIntroductionDate(java.sql.Timestamp introductionDate);

    java.sql.Timestamp getReleaseDate();

    void setReleaseDate(java.sql.Timestamp releaseDate);

    java.sql.Timestamp getSupportDiscontinuationDate();

    void setSupportDiscontinuationDate(java.sql.Timestamp supportDiscontinuationDate);

    java.sql.Timestamp getSalesDiscontinuationDate();

    void setSalesDiscontinuationDate(java.sql.Timestamp salesDiscontinuationDate);

    String getSalesDiscWhenNotAvail();

    void setSalesDiscWhenNotAvail(String salesDiscWhenNotAvail);

    String getInternalName();

    void setInternalName(String internalName);

    String getBrandName();

    void setBrandName(String brandName);

    String getComments();

    void setComments(String comments);

    String getProductName();

    void setProductName(String productName);

    String getDescription();

    void setDescription(String description);

    String getPriceDetailText();

    void setPriceDetailText(String priceDetailText);

    String getSmallImageUrl();

    void setSmallImageUrl(String smallImageUrl);

    String getMediumImageUrl();

    void setMediumImageUrl(String mediumImageUrl);

    String getLargeImageUrl();

    void setLargeImageUrl(String largeImageUrl);

    String getDetailImageUrl();

    void setDetailImageUrl(String detailImageUrl);

    String getOriginalImageUrl();

    void setOriginalImageUrl(String originalImageUrl);

    String getDetailScreen();

    void setDetailScreen(String detailScreen);

    String getInventoryMessage();

    void setInventoryMessage(String inventoryMessage);

    String getInventoryItemTypeId();

    void setInventoryItemTypeId(String inventoryItemTypeId);

    String getRequireInventory();

    void setRequireInventory(String requireInventory);

    String getQuantityUomId();

    void setQuantityUomId(String quantityUomId);

    java.math.BigDecimal getQuantityIncluded();

    void setQuantityIncluded(java.math.BigDecimal quantityIncluded);

    Long getPiecesIncluded();

    void setPiecesIncluded(Long piecesIncluded);

    String getRequireAmount();

    void setRequireAmount(String requireAmount);

    java.math.BigDecimal getFixedAmount();

    void setFixedAmount(java.math.BigDecimal fixedAmount);

    String getAmountUomTypeId();

    void setAmountUomTypeId(String amountUomTypeId);

    String getWeightUomId();

    void setWeightUomId(String weightUomId);

    java.math.BigDecimal getShippingWeight();

    void setShippingWeight(java.math.BigDecimal shippingWeight);

    java.math.BigDecimal getProductWeight();

    void setProductWeight(java.math.BigDecimal productWeight);

    String getHeightUomId();

    void setHeightUomId(String heightUomId);

    java.math.BigDecimal getProductHeight();

    void setProductHeight(java.math.BigDecimal productHeight);

    java.math.BigDecimal getShippingHeight();

    void setShippingHeight(java.math.BigDecimal shippingHeight);

    String getWidthUomId();

    void setWidthUomId(String widthUomId);

    java.math.BigDecimal getProductWidth();

    void setProductWidth(java.math.BigDecimal productWidth);

    java.math.BigDecimal getShippingWidth();

    void setShippingWidth(java.math.BigDecimal shippingWidth);

    String getDepthUomId();

    void setDepthUomId(String depthUomId);

    java.math.BigDecimal getProductDepth();

    void setProductDepth(java.math.BigDecimal productDepth);

    java.math.BigDecimal getShippingDepth();

    void setShippingDepth(java.math.BigDecimal shippingDepth);

    String getDiameterUomId();

    void setDiameterUomId(String diameterUomId);

    java.math.BigDecimal getProductDiameter();

    void setProductDiameter(java.math.BigDecimal productDiameter);

    java.math.BigDecimal getProductRating();

    void setProductRating(java.math.BigDecimal productRating);

    String getRatingTypeEnum();

    void setRatingTypeEnum(String ratingTypeEnum);

    String getReturnable();

    void setReturnable(String returnable);

    String getTaxable();

    void setTaxable(String taxable);

    String getChargeShipping();

    void setChargeShipping(String chargeShipping);

    String getAutoCreateKeywords();

    void setAutoCreateKeywords(String autoCreateKeywords);

    String getIncludeInPromotions();

    void setIncludeInPromotions(String includeInPromotions);

    String getIsVirtual();

    void setIsVirtual(String isVirtual);

    String getIsVariant();

    void setIsVariant(String isVariant);

    String getVirtualVariantMethodEnum();

    void setVirtualVariantMethodEnum(String virtualVariantMethodEnum);

    String getInShippingBox();

    void setInShippingBox(String inShippingBox);

    String getDefaultShipmentBoxTypeId();

    void setDefaultShipmentBoxTypeId(String defaultShipmentBoxTypeId);

    String getLotIdFilledIn();

    void setLotIdFilledIn(String lotIdFilledIn);

    String getAttributeSetId();

    void setAttributeSetId(String attributeSetId);

    String getAttributeSetInstanceId();

    void setAttributeSetInstanceId(String attributeSetInstanceId);

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


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(ProductStateEvent.ProductStateCreated e);

    void when(ProductStateEvent.ProductStateMergePatched e);

    
}

