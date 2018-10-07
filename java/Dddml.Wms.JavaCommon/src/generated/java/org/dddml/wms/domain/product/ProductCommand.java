package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface ProductCommand extends Command
{
    String getProductId();

    void setProductId(String productId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(ProductState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((ProductCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((ProductCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(ProductCommand c) {
        return ((c instanceof ProductCommand.CreateProduct) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(ProductState.VERSION_NULL)));
    }

    interface CreateOrMergePatchProduct extends ProductCommand
    {
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

        Boolean getIsSerialNumbered();

        void setIsSerialNumbered(Boolean isSerialNumbered);

        Boolean getIsManagedByLot();

        void setIsManagedByLot(Boolean isManagedByLot);

        String getAttributeSetId();

        void setAttributeSetId(String attributeSetId);

        String getAttributeSetInstanceId();

        void setAttributeSetInstanceId(String attributeSetInstanceId);

        String getGrade();

        void setGrade(String grade);

        java.math.BigDecimal getGsm();

        void setGsm(java.math.BigDecimal gsm);

        java.math.BigDecimal getCoreDiameter();

        void setCoreDiameter(java.math.BigDecimal coreDiameter);

        java.math.BigDecimal getOutsideDiameter();

        void setOutsideDiameter(java.math.BigDecimal outsideDiameter);

        java.math.BigDecimal getMoisturePct();

        void setMoisturePct(java.math.BigDecimal moisturePct);

        String getRollCnt();

        void setRollCnt(String rollCnt);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateProduct extends CreateOrMergePatchProduct
    {
        CreateGoodIdentificationCommandCollection getGoodIdentifications();

        GoodIdentificationCommand.CreateGoodIdentification newCreateGoodIdentification();

    }

    interface MergePatchProduct extends CreateOrMergePatchProduct
    {
        Boolean getIsPropertyProductTypeIdRemoved();

        void setIsPropertyProductTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryProductCategoryIdRemoved();

        void setIsPropertyPrimaryProductCategoryIdRemoved(Boolean removed);

        Boolean getIsPropertyManufacturerPartyIdRemoved();

        void setIsPropertyManufacturerPartyIdRemoved(Boolean removed);

        Boolean getIsPropertyFacilityIdRemoved();

        void setIsPropertyFacilityIdRemoved(Boolean removed);

        Boolean getIsPropertyIntroductionDateRemoved();

        void setIsPropertyIntroductionDateRemoved(Boolean removed);

        Boolean getIsPropertyReleaseDateRemoved();

        void setIsPropertyReleaseDateRemoved(Boolean removed);

        Boolean getIsPropertySupportDiscontinuationDateRemoved();

        void setIsPropertySupportDiscontinuationDateRemoved(Boolean removed);

        Boolean getIsPropertySalesDiscontinuationDateRemoved();

        void setIsPropertySalesDiscontinuationDateRemoved(Boolean removed);

        Boolean getIsPropertySalesDiscWhenNotAvailRemoved();

        void setIsPropertySalesDiscWhenNotAvailRemoved(Boolean removed);

        Boolean getIsPropertyInternalNameRemoved();

        void setIsPropertyInternalNameRemoved(Boolean removed);

        Boolean getIsPropertyBrandNameRemoved();

        void setIsPropertyBrandNameRemoved(Boolean removed);

        Boolean getIsPropertyCommentsRemoved();

        void setIsPropertyCommentsRemoved(Boolean removed);

        Boolean getIsPropertyProductNameRemoved();

        void setIsPropertyProductNameRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyPriceDetailTextRemoved();

        void setIsPropertyPriceDetailTextRemoved(Boolean removed);

        Boolean getIsPropertySmallImageUrlRemoved();

        void setIsPropertySmallImageUrlRemoved(Boolean removed);

        Boolean getIsPropertyMediumImageUrlRemoved();

        void setIsPropertyMediumImageUrlRemoved(Boolean removed);

        Boolean getIsPropertyLargeImageUrlRemoved();

        void setIsPropertyLargeImageUrlRemoved(Boolean removed);

        Boolean getIsPropertyDetailImageUrlRemoved();

        void setIsPropertyDetailImageUrlRemoved(Boolean removed);

        Boolean getIsPropertyOriginalImageUrlRemoved();

        void setIsPropertyOriginalImageUrlRemoved(Boolean removed);

        Boolean getIsPropertyDetailScreenRemoved();

        void setIsPropertyDetailScreenRemoved(Boolean removed);

        Boolean getIsPropertyInventoryMessageRemoved();

        void setIsPropertyInventoryMessageRemoved(Boolean removed);

        Boolean getIsPropertyInventoryItemTypeIdRemoved();

        void setIsPropertyInventoryItemTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyRequireInventoryRemoved();

        void setIsPropertyRequireInventoryRemoved(Boolean removed);

        Boolean getIsPropertyQuantityUomIdRemoved();

        void setIsPropertyQuantityUomIdRemoved(Boolean removed);

        Boolean getIsPropertyQuantityIncludedRemoved();

        void setIsPropertyQuantityIncludedRemoved(Boolean removed);

        Boolean getIsPropertyPiecesIncludedRemoved();

        void setIsPropertyPiecesIncludedRemoved(Boolean removed);

        Boolean getIsPropertyRequireAmountRemoved();

        void setIsPropertyRequireAmountRemoved(Boolean removed);

        Boolean getIsPropertyFixedAmountRemoved();

        void setIsPropertyFixedAmountRemoved(Boolean removed);

        Boolean getIsPropertyAmountUomTypeIdRemoved();

        void setIsPropertyAmountUomTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyWeightUomIdRemoved();

        void setIsPropertyWeightUomIdRemoved(Boolean removed);

        Boolean getIsPropertyShippingWeightRemoved();

        void setIsPropertyShippingWeightRemoved(Boolean removed);

        Boolean getIsPropertyProductWeightRemoved();

        void setIsPropertyProductWeightRemoved(Boolean removed);

        Boolean getIsPropertyHeightUomIdRemoved();

        void setIsPropertyHeightUomIdRemoved(Boolean removed);

        Boolean getIsPropertyProductHeightRemoved();

        void setIsPropertyProductHeightRemoved(Boolean removed);

        Boolean getIsPropertyShippingHeightRemoved();

        void setIsPropertyShippingHeightRemoved(Boolean removed);

        Boolean getIsPropertyWidthUomIdRemoved();

        void setIsPropertyWidthUomIdRemoved(Boolean removed);

        Boolean getIsPropertyProductWidthRemoved();

        void setIsPropertyProductWidthRemoved(Boolean removed);

        Boolean getIsPropertyShippingWidthRemoved();

        void setIsPropertyShippingWidthRemoved(Boolean removed);

        Boolean getIsPropertyDepthUomIdRemoved();

        void setIsPropertyDepthUomIdRemoved(Boolean removed);

        Boolean getIsPropertyProductDepthRemoved();

        void setIsPropertyProductDepthRemoved(Boolean removed);

        Boolean getIsPropertyShippingDepthRemoved();

        void setIsPropertyShippingDepthRemoved(Boolean removed);

        Boolean getIsPropertyDiameterUomIdRemoved();

        void setIsPropertyDiameterUomIdRemoved(Boolean removed);

        Boolean getIsPropertyProductDiameterRemoved();

        void setIsPropertyProductDiameterRemoved(Boolean removed);

        Boolean getIsPropertyProductRatingRemoved();

        void setIsPropertyProductRatingRemoved(Boolean removed);

        Boolean getIsPropertyRatingTypeEnumRemoved();

        void setIsPropertyRatingTypeEnumRemoved(Boolean removed);

        Boolean getIsPropertyReturnableRemoved();

        void setIsPropertyReturnableRemoved(Boolean removed);

        Boolean getIsPropertyTaxableRemoved();

        void setIsPropertyTaxableRemoved(Boolean removed);

        Boolean getIsPropertyChargeShippingRemoved();

        void setIsPropertyChargeShippingRemoved(Boolean removed);

        Boolean getIsPropertyAutoCreateKeywordsRemoved();

        void setIsPropertyAutoCreateKeywordsRemoved(Boolean removed);

        Boolean getIsPropertyIncludeInPromotionsRemoved();

        void setIsPropertyIncludeInPromotionsRemoved(Boolean removed);

        Boolean getIsPropertyIsVirtualRemoved();

        void setIsPropertyIsVirtualRemoved(Boolean removed);

        Boolean getIsPropertyIsVariantRemoved();

        void setIsPropertyIsVariantRemoved(Boolean removed);

        Boolean getIsPropertyVirtualVariantMethodEnumRemoved();

        void setIsPropertyVirtualVariantMethodEnumRemoved(Boolean removed);

        Boolean getIsPropertyInShippingBoxRemoved();

        void setIsPropertyInShippingBoxRemoved(Boolean removed);

        Boolean getIsPropertyDefaultShipmentBoxTypeIdRemoved();

        void setIsPropertyDefaultShipmentBoxTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyIsSerialNumberedRemoved();

        void setIsPropertyIsSerialNumberedRemoved(Boolean removed);

        Boolean getIsPropertyIsManagedByLotRemoved();

        void setIsPropertyIsManagedByLotRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetIdRemoved();

        void setIsPropertyAttributeSetIdRemoved(Boolean removed);

        Boolean getIsPropertyAttributeSetInstanceIdRemoved();

        void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed);

        Boolean getIsPropertyGradeRemoved();

        void setIsPropertyGradeRemoved(Boolean removed);

        Boolean getIsPropertyGsmRemoved();

        void setIsPropertyGsmRemoved(Boolean removed);

        Boolean getIsPropertyCoreDiameterRemoved();

        void setIsPropertyCoreDiameterRemoved(Boolean removed);

        Boolean getIsPropertyOutsideDiameterRemoved();

        void setIsPropertyOutsideDiameterRemoved(Boolean removed);

        Boolean getIsPropertyMoisturePctRemoved();

        void setIsPropertyMoisturePctRemoved(Boolean removed);

        Boolean getIsPropertyRollCntRemoved();

        void setIsPropertyRollCntRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        GoodIdentificationCommandCollection getGoodIdentificationCommands();

        GoodIdentificationCommand.CreateGoodIdentification newCreateGoodIdentification();

        GoodIdentificationCommand.MergePatchGoodIdentification newMergePatchGoodIdentification();

        GoodIdentificationCommand.RemoveGoodIdentification newRemoveGoodIdentification();

    }

	interface DeleteProduct extends ProductCommand
	{
	}

    interface CreateGoodIdentificationCommandCollection extends Iterable<GoodIdentificationCommand.CreateGoodIdentification>
    {
        void add(GoodIdentificationCommand.CreateGoodIdentification c);

        void remove(GoodIdentificationCommand.CreateGoodIdentification c);

        void clear();
    }

    interface GoodIdentificationCommandCollection extends Iterable<GoodIdentificationCommand>
    {
        void add(GoodIdentificationCommand c);

        void remove(GoodIdentificationCommand c);

        void clear();
    }

}

