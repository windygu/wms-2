package org.dddml.wms.domain.product;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.product.ProductEvent.*;

public interface ProductState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getProductId();

    String getProductTypeId();

    String getPrimaryProductCategoryId();

    String getManufacturerPartyId();

    String getFacilityId();

    java.sql.Timestamp getIntroductionDate();

    java.sql.Timestamp getReleaseDate();

    java.sql.Timestamp getSupportDiscontinuationDate();

    java.sql.Timestamp getSalesDiscontinuationDate();

    String getSalesDiscWhenNotAvail();

    String getInternalName();

    String getBrandName();

    String getComments();

    String getProductName();

    String getDescription();

    String getPriceDetailText();

    String getSmallImageUrl();

    String getMediumImageUrl();

    String getLargeImageUrl();

    String getDetailImageUrl();

    String getOriginalImageUrl();

    String getDetailScreen();

    String getInventoryMessage();

    String getInventoryItemTypeId();

    String getRequireInventory();

    String getQuantityUomId();

    java.math.BigDecimal getQuantityIncluded();

    Long getPiecesIncluded();

    String getRequireAmount();

    java.math.BigDecimal getFixedAmount();

    String getAmountUomTypeId();

    String getWeightUomId();

    java.math.BigDecimal getShippingWeight();

    java.math.BigDecimal getProductWeight();

    String getHeightUomId();

    java.math.BigDecimal getProductHeight();

    java.math.BigDecimal getShippingHeight();

    String getWidthUomId();

    java.math.BigDecimal getProductWidth();

    java.math.BigDecimal getShippingWidth();

    String getDepthUomId();

    java.math.BigDecimal getProductDepth();

    java.math.BigDecimal getShippingDepth();

    String getDiameterUomId();

    java.math.BigDecimal getProductDiameter();

    java.math.BigDecimal getProductRating();

    String getRatingTypeEnum();

    String getReturnable();

    String getTaxable();

    String getChargeShipping();

    String getAutoCreateKeywords();

    String getIncludeInPromotions();

    String getIsVirtual();

    String getIsVariant();

    String getVirtualVariantMethodEnum();

    String getInShippingBox();

    String getDefaultShipmentBoxTypeId();

    Boolean getIsSerialNumbered();

    Boolean getIsManagedByLot();

    String getAttributeSetId();

    String getAttributeSetInstanceId();

    String getGrade();

    java.math.BigDecimal getGsm();

    java.math.BigDecimal getCoreDiameter();

    java.math.BigDecimal getOutsideDiameter();

    java.math.BigDecimal getMoisturePct();

    String getRollCnt();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    EntityStateCollection<String, GoodIdentificationState> getGoodIdentifications();

    interface MutableProductState extends ProductState {
        void setProductId(String productId);

        void setProductTypeId(String productTypeId);

        void setPrimaryProductCategoryId(String primaryProductCategoryId);

        void setManufacturerPartyId(String manufacturerPartyId);

        void setFacilityId(String facilityId);

        void setIntroductionDate(java.sql.Timestamp introductionDate);

        void setReleaseDate(java.sql.Timestamp releaseDate);

        void setSupportDiscontinuationDate(java.sql.Timestamp supportDiscontinuationDate);

        void setSalesDiscontinuationDate(java.sql.Timestamp salesDiscontinuationDate);

        void setSalesDiscWhenNotAvail(String salesDiscWhenNotAvail);

        void setInternalName(String internalName);

        void setBrandName(String brandName);

        void setComments(String comments);

        void setProductName(String productName);

        void setDescription(String description);

        void setPriceDetailText(String priceDetailText);

        void setSmallImageUrl(String smallImageUrl);

        void setMediumImageUrl(String mediumImageUrl);

        void setLargeImageUrl(String largeImageUrl);

        void setDetailImageUrl(String detailImageUrl);

        void setOriginalImageUrl(String originalImageUrl);

        void setDetailScreen(String detailScreen);

        void setInventoryMessage(String inventoryMessage);

        void setInventoryItemTypeId(String inventoryItemTypeId);

        void setRequireInventory(String requireInventory);

        void setQuantityUomId(String quantityUomId);

        void setQuantityIncluded(java.math.BigDecimal quantityIncluded);

        void setPiecesIncluded(Long piecesIncluded);

        void setRequireAmount(String requireAmount);

        void setFixedAmount(java.math.BigDecimal fixedAmount);

        void setAmountUomTypeId(String amountUomTypeId);

        void setWeightUomId(String weightUomId);

        void setShippingWeight(java.math.BigDecimal shippingWeight);

        void setProductWeight(java.math.BigDecimal productWeight);

        void setHeightUomId(String heightUomId);

        void setProductHeight(java.math.BigDecimal productHeight);

        void setShippingHeight(java.math.BigDecimal shippingHeight);

        void setWidthUomId(String widthUomId);

        void setProductWidth(java.math.BigDecimal productWidth);

        void setShippingWidth(java.math.BigDecimal shippingWidth);

        void setDepthUomId(String depthUomId);

        void setProductDepth(java.math.BigDecimal productDepth);

        void setShippingDepth(java.math.BigDecimal shippingDepth);

        void setDiameterUomId(String diameterUomId);

        void setProductDiameter(java.math.BigDecimal productDiameter);

        void setProductRating(java.math.BigDecimal productRating);

        void setRatingTypeEnum(String ratingTypeEnum);

        void setReturnable(String returnable);

        void setTaxable(String taxable);

        void setChargeShipping(String chargeShipping);

        void setAutoCreateKeywords(String autoCreateKeywords);

        void setIncludeInPromotions(String includeInPromotions);

        void setIsVirtual(String isVirtual);

        void setIsVariant(String isVariant);

        void setVirtualVariantMethodEnum(String virtualVariantMethodEnum);

        void setInShippingBox(String inShippingBox);

        void setDefaultShipmentBoxTypeId(String defaultShipmentBoxTypeId);

        void setIsSerialNumbered(Boolean isSerialNumbered);

        void setIsManagedByLot(Boolean isManagedByLot);

        void setAttributeSetId(String attributeSetId);

        void setAttributeSetInstanceId(String attributeSetInstanceId);

        void setGrade(String grade);

        void setGsm(java.math.BigDecimal gsm);

        void setCoreDiameter(java.math.BigDecimal coreDiameter);

        void setOutsideDiameter(java.math.BigDecimal outsideDiameter);

        void setMoisturePct(java.math.BigDecimal moisturePct);

        void setRollCnt(String rollCnt);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);


        void mutate(Event e);

        void when(ProductEvent.ProductStateCreated e);

        void when(ProductEvent.ProductStateMergePatched e);

    }

    interface SqlProductState extends MutableProductState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

