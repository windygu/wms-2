package org.dddml.wms.domain.product;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractProductStateCommandConverter<TCreateProduct extends ProductCommand.CreateProduct, TMergePatchProduct extends ProductCommand.MergePatchProduct, TDeleteProduct extends ProductCommand.DeleteProduct>
{
    public ProductCommand toCreateOrMergePatchProduct(ProductState state)
    {
        //where TCreateProduct : ICreateProduct, new()
        //where TMergePatchProduct : IMergePatchProduct, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateProduct(state);
        }
        else 
        {
            return toMergePatchProduct(state);
        }
    }

    public TDeleteProduct toDeleteProduct(ProductState state) //where TDeleteProduct : IDeleteProduct, new()
    {
        TDeleteProduct cmd = newDeleteProduct();
        cmd.setProductId(state.getProductId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchProduct toMergePatchProduct(ProductState state) //where TMergePatchProduct : IMergePatchProduct, new()
    {
        TMergePatchProduct cmd = newMergePatchProduct();

        cmd.setVersion(state.getVersion());

        cmd.setProductId(state.getProductId());
        cmd.setProductTypeId(state.getProductTypeId());
        cmd.setPrimaryProductCategoryId(state.getPrimaryProductCategoryId());
        cmd.setManufacturerPartyId(state.getManufacturerPartyId());
        cmd.setFacilityId(state.getFacilityId());
        cmd.setIntroductionDate(state.getIntroductionDate());
        cmd.setReleaseDate(state.getReleaseDate());
        cmd.setSupportDiscontinuationDate(state.getSupportDiscontinuationDate());
        cmd.setSalesDiscontinuationDate(state.getSalesDiscontinuationDate());
        cmd.setSalesDiscWhenNotAvail(state.getSalesDiscWhenNotAvail());
        cmd.setInternalName(state.getInternalName());
        cmd.setBrandName(state.getBrandName());
        cmd.setComments(state.getComments());
        cmd.setProductName(state.getProductName());
        cmd.setDescription(state.getDescription());
        cmd.setPriceDetailText(state.getPriceDetailText());
        cmd.setSmallImageUrl(state.getSmallImageUrl());
        cmd.setMediumImageUrl(state.getMediumImageUrl());
        cmd.setLargeImageUrl(state.getLargeImageUrl());
        cmd.setDetailImageUrl(state.getDetailImageUrl());
        cmd.setOriginalImageUrl(state.getOriginalImageUrl());
        cmd.setDetailScreen(state.getDetailScreen());
        cmd.setInventoryMessage(state.getInventoryMessage());
        cmd.setInventoryItemTypeId(state.getInventoryItemTypeId());
        cmd.setRequireInventory(state.getRequireInventory());
        cmd.setQuantityUomId(state.getQuantityUomId());
        cmd.setQuantityIncluded(state.getQuantityIncluded());
        cmd.setPiecesIncluded(state.getPiecesIncluded());
        cmd.setRequireAmount(state.getRequireAmount());
        cmd.setFixedAmount(state.getFixedAmount());
        cmd.setAmountUomTypeId(state.getAmountUomTypeId());
        cmd.setWeightUomId(state.getWeightUomId());
        cmd.setShippingWeight(state.getShippingWeight());
        cmd.setProductWeight(state.getProductWeight());
        cmd.setHeightUomId(state.getHeightUomId());
        cmd.setProductHeight(state.getProductHeight());
        cmd.setShippingHeight(state.getShippingHeight());
        cmd.setWidthUomId(state.getWidthUomId());
        cmd.setProductWidth(state.getProductWidth());
        cmd.setShippingWidth(state.getShippingWidth());
        cmd.setDepthUomId(state.getDepthUomId());
        cmd.setProductDepth(state.getProductDepth());
        cmd.setShippingDepth(state.getShippingDepth());
        cmd.setDiameterUomId(state.getDiameterUomId());
        cmd.setProductDiameter(state.getProductDiameter());
        cmd.setProductRating(state.getProductRating());
        cmd.setRatingTypeEnum(state.getRatingTypeEnum());
        cmd.setReturnable(state.getReturnable());
        cmd.setTaxable(state.getTaxable());
        cmd.setChargeShipping(state.getChargeShipping());
        cmd.setAutoCreateKeywords(state.getAutoCreateKeywords());
        cmd.setIncludeInPromotions(state.getIncludeInPromotions());
        cmd.setIsVirtual(state.getIsVirtual());
        cmd.setIsVariant(state.getIsVariant());
        cmd.setVirtualVariantMethodEnum(state.getVirtualVariantMethodEnum());
        cmd.setInShippingBox(state.getInShippingBox());
        cmd.setDefaultShipmentBoxTypeId(state.getDefaultShipmentBoxTypeId());
        cmd.setLotIdFilledIn(state.getLotIdFilledIn());
        cmd.setActive(state.getActive());
            
        if (state.getProductTypeId() == null) { cmd.setIsPropertyProductTypeIdRemoved(true); }
        if (state.getPrimaryProductCategoryId() == null) { cmd.setIsPropertyPrimaryProductCategoryIdRemoved(true); }
        if (state.getManufacturerPartyId() == null) { cmd.setIsPropertyManufacturerPartyIdRemoved(true); }
        if (state.getFacilityId() == null) { cmd.setIsPropertyFacilityIdRemoved(true); }
        if (state.getIntroductionDate() == null) { cmd.setIsPropertyIntroductionDateRemoved(true); }
        if (state.getReleaseDate() == null) { cmd.setIsPropertyReleaseDateRemoved(true); }
        if (state.getSupportDiscontinuationDate() == null) { cmd.setIsPropertySupportDiscontinuationDateRemoved(true); }
        if (state.getSalesDiscontinuationDate() == null) { cmd.setIsPropertySalesDiscontinuationDateRemoved(true); }
        if (state.getSalesDiscWhenNotAvail() == null) { cmd.setIsPropertySalesDiscWhenNotAvailRemoved(true); }
        if (state.getInternalName() == null) { cmd.setIsPropertyInternalNameRemoved(true); }
        if (state.getBrandName() == null) { cmd.setIsPropertyBrandNameRemoved(true); }
        if (state.getComments() == null) { cmd.setIsPropertyCommentsRemoved(true); }
        if (state.getProductName() == null) { cmd.setIsPropertyProductNameRemoved(true); }
        if (state.getDescription() == null) { cmd.setIsPropertyDescriptionRemoved(true); }
        if (state.getPriceDetailText() == null) { cmd.setIsPropertyPriceDetailTextRemoved(true); }
        if (state.getSmallImageUrl() == null) { cmd.setIsPropertySmallImageUrlRemoved(true); }
        if (state.getMediumImageUrl() == null) { cmd.setIsPropertyMediumImageUrlRemoved(true); }
        if (state.getLargeImageUrl() == null) { cmd.setIsPropertyLargeImageUrlRemoved(true); }
        if (state.getDetailImageUrl() == null) { cmd.setIsPropertyDetailImageUrlRemoved(true); }
        if (state.getOriginalImageUrl() == null) { cmd.setIsPropertyOriginalImageUrlRemoved(true); }
        if (state.getDetailScreen() == null) { cmd.setIsPropertyDetailScreenRemoved(true); }
        if (state.getInventoryMessage() == null) { cmd.setIsPropertyInventoryMessageRemoved(true); }
        if (state.getInventoryItemTypeId() == null) { cmd.setIsPropertyInventoryItemTypeIdRemoved(true); }
        if (state.getRequireInventory() == null) { cmd.setIsPropertyRequireInventoryRemoved(true); }
        if (state.getQuantityUomId() == null) { cmd.setIsPropertyQuantityUomIdRemoved(true); }
        if (state.getQuantityIncluded() == null) { cmd.setIsPropertyQuantityIncludedRemoved(true); }
        if (state.getPiecesIncluded() == null) { cmd.setIsPropertyPiecesIncludedRemoved(true); }
        if (state.getRequireAmount() == null) { cmd.setIsPropertyRequireAmountRemoved(true); }
        if (state.getFixedAmount() == null) { cmd.setIsPropertyFixedAmountRemoved(true); }
        if (state.getAmountUomTypeId() == null) { cmd.setIsPropertyAmountUomTypeIdRemoved(true); }
        if (state.getWeightUomId() == null) { cmd.setIsPropertyWeightUomIdRemoved(true); }
        if (state.getShippingWeight() == null) { cmd.setIsPropertyShippingWeightRemoved(true); }
        if (state.getProductWeight() == null) { cmd.setIsPropertyProductWeightRemoved(true); }
        if (state.getHeightUomId() == null) { cmd.setIsPropertyHeightUomIdRemoved(true); }
        if (state.getProductHeight() == null) { cmd.setIsPropertyProductHeightRemoved(true); }
        if (state.getShippingHeight() == null) { cmd.setIsPropertyShippingHeightRemoved(true); }
        if (state.getWidthUomId() == null) { cmd.setIsPropertyWidthUomIdRemoved(true); }
        if (state.getProductWidth() == null) { cmd.setIsPropertyProductWidthRemoved(true); }
        if (state.getShippingWidth() == null) { cmd.setIsPropertyShippingWidthRemoved(true); }
        if (state.getDepthUomId() == null) { cmd.setIsPropertyDepthUomIdRemoved(true); }
        if (state.getProductDepth() == null) { cmd.setIsPropertyProductDepthRemoved(true); }
        if (state.getShippingDepth() == null) { cmd.setIsPropertyShippingDepthRemoved(true); }
        if (state.getDiameterUomId() == null) { cmd.setIsPropertyDiameterUomIdRemoved(true); }
        if (state.getProductDiameter() == null) { cmd.setIsPropertyProductDiameterRemoved(true); }
        if (state.getProductRating() == null) { cmd.setIsPropertyProductRatingRemoved(true); }
        if (state.getRatingTypeEnum() == null) { cmd.setIsPropertyRatingTypeEnumRemoved(true); }
        if (state.getReturnable() == null) { cmd.setIsPropertyReturnableRemoved(true); }
        if (state.getTaxable() == null) { cmd.setIsPropertyTaxableRemoved(true); }
        if (state.getChargeShipping() == null) { cmd.setIsPropertyChargeShippingRemoved(true); }
        if (state.getAutoCreateKeywords() == null) { cmd.setIsPropertyAutoCreateKeywordsRemoved(true); }
        if (state.getIncludeInPromotions() == null) { cmd.setIsPropertyIncludeInPromotionsRemoved(true); }
        if (state.getIsVirtual() == null) { cmd.setIsPropertyIsVirtualRemoved(true); }
        if (state.getIsVariant() == null) { cmd.setIsPropertyIsVariantRemoved(true); }
        if (state.getVirtualVariantMethodEnum() == null) { cmd.setIsPropertyVirtualVariantMethodEnumRemoved(true); }
        if (state.getInShippingBox() == null) { cmd.setIsPropertyInShippingBoxRemoved(true); }
        if (state.getDefaultShipmentBoxTypeId() == null) { cmd.setIsPropertyDefaultShipmentBoxTypeIdRemoved(true); }
        if (state.getLotIdFilledIn() == null) { cmd.setIsPropertyLotIdFilledInRemoved(true); }
        if (state.getActive() == null) { cmd.setIsPropertyActiveRemoved(true); }
        return cmd;
    }

    public TCreateProduct toCreateProduct(ProductState state) //where TCreateProduct : ICreateProduct, new()
    {
        TCreateProduct cmd = newCreateProduct();

        cmd.setVersion(state.getVersion());
        cmd.setProductId(state.getProductId());
        cmd.setProductTypeId(state.getProductTypeId());
        cmd.setPrimaryProductCategoryId(state.getPrimaryProductCategoryId());
        cmd.setManufacturerPartyId(state.getManufacturerPartyId());
        cmd.setFacilityId(state.getFacilityId());
        cmd.setIntroductionDate(state.getIntroductionDate());
        cmd.setReleaseDate(state.getReleaseDate());
        cmd.setSupportDiscontinuationDate(state.getSupportDiscontinuationDate());
        cmd.setSalesDiscontinuationDate(state.getSalesDiscontinuationDate());
        cmd.setSalesDiscWhenNotAvail(state.getSalesDiscWhenNotAvail());
        cmd.setInternalName(state.getInternalName());
        cmd.setBrandName(state.getBrandName());
        cmd.setComments(state.getComments());
        cmd.setProductName(state.getProductName());
        cmd.setDescription(state.getDescription());
        cmd.setPriceDetailText(state.getPriceDetailText());
        cmd.setSmallImageUrl(state.getSmallImageUrl());
        cmd.setMediumImageUrl(state.getMediumImageUrl());
        cmd.setLargeImageUrl(state.getLargeImageUrl());
        cmd.setDetailImageUrl(state.getDetailImageUrl());
        cmd.setOriginalImageUrl(state.getOriginalImageUrl());
        cmd.setDetailScreen(state.getDetailScreen());
        cmd.setInventoryMessage(state.getInventoryMessage());
        cmd.setInventoryItemTypeId(state.getInventoryItemTypeId());
        cmd.setRequireInventory(state.getRequireInventory());
        cmd.setQuantityUomId(state.getQuantityUomId());
        cmd.setQuantityIncluded(state.getQuantityIncluded());
        cmd.setPiecesIncluded(state.getPiecesIncluded());
        cmd.setRequireAmount(state.getRequireAmount());
        cmd.setFixedAmount(state.getFixedAmount());
        cmd.setAmountUomTypeId(state.getAmountUomTypeId());
        cmd.setWeightUomId(state.getWeightUomId());
        cmd.setShippingWeight(state.getShippingWeight());
        cmd.setProductWeight(state.getProductWeight());
        cmd.setHeightUomId(state.getHeightUomId());
        cmd.setProductHeight(state.getProductHeight());
        cmd.setShippingHeight(state.getShippingHeight());
        cmd.setWidthUomId(state.getWidthUomId());
        cmd.setProductWidth(state.getProductWidth());
        cmd.setShippingWidth(state.getShippingWidth());
        cmd.setDepthUomId(state.getDepthUomId());
        cmd.setProductDepth(state.getProductDepth());
        cmd.setShippingDepth(state.getShippingDepth());
        cmd.setDiameterUomId(state.getDiameterUomId());
        cmd.setProductDiameter(state.getProductDiameter());
        cmd.setProductRating(state.getProductRating());
        cmd.setRatingTypeEnum(state.getRatingTypeEnum());
        cmd.setReturnable(state.getReturnable());
        cmd.setTaxable(state.getTaxable());
        cmd.setChargeShipping(state.getChargeShipping());
        cmd.setAutoCreateKeywords(state.getAutoCreateKeywords());
        cmd.setIncludeInPromotions(state.getIncludeInPromotions());
        cmd.setIsVirtual(state.getIsVirtual());
        cmd.setIsVariant(state.getIsVariant());
        cmd.setVirtualVariantMethodEnum(state.getVirtualVariantMethodEnum());
        cmd.setInShippingBox(state.getInShippingBox());
        cmd.setDefaultShipmentBoxTypeId(state.getDefaultShipmentBoxTypeId());
        cmd.setLotIdFilledIn(state.getLotIdFilledIn());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateProduct newCreateProduct();

    protected abstract TMergePatchProduct newMergePatchProduct(); 

    protected abstract TDeleteProduct newDeleteProduct();

    public static class SimpleProductStateCommandConverter extends AbstractProductStateCommandConverter<AbstractProductCommand.SimpleCreateProduct, AbstractProductCommand.SimpleMergePatchProduct, AbstractProductCommand.SimpleDeleteProduct>
    {
        @Override
        protected AbstractProductCommand.SimpleCreateProduct newCreateProduct() {
            return new AbstractProductCommand.SimpleCreateProduct();
        }

        @Override
        protected AbstractProductCommand.SimpleMergePatchProduct newMergePatchProduct() {
            return new AbstractProductCommand.SimpleMergePatchProduct();
        }

        @Override
        protected AbstractProductCommand.SimpleDeleteProduct newDeleteProduct() {
            return new AbstractProductCommand.SimpleDeleteProduct();
        }


    }

}

