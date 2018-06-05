﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateProductDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Product;

namespace Dddml.Wms.Domain.Product
{

    public class ProductStateEventDtoConverter
    {
        public virtual ProductStateCreatedOrMergePatchedOrDeletedDto ToProductStateEventDto(IProductEvent stateEvent)
        {
            if (stateEvent.EventType == StateEventType.Created)
            {
                var e = (IProductStateCreated)stateEvent;
                return ToProductStateCreatedDto(e);
            }
            else if (stateEvent.EventType == StateEventType.MergePatched)
            {
                var e = (IProductStateMergePatched)stateEvent;
                return ToProductStateMergePatchedDto(e);
            }
            throw DomainError.Named("invalidEventType", String.Format("Invalid state event type: {0}", stateEvent.EventType));
        }

        public virtual ProductStateCreatedDto ToProductStateCreatedDto(IProductStateCreated e)
        {
            var dto = new ProductStateCreatedDto();
            dto.ProductEventId = e.ProductEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.ProductTypeId = e.ProductTypeId;
            dto.PrimaryProductCategoryId = e.PrimaryProductCategoryId;
            dto.ManufacturerPartyId = e.ManufacturerPartyId;
            dto.FacilityId = e.FacilityId;
            dto.IntroductionDate = e.IntroductionDate;
            dto.ReleaseDate = e.ReleaseDate;
            dto.SupportDiscontinuationDate = e.SupportDiscontinuationDate;
            dto.SalesDiscontinuationDate = e.SalesDiscontinuationDate;
            dto.SalesDiscWhenNotAvail = e.SalesDiscWhenNotAvail;
            dto.InternalName = e.InternalName;
            dto.BrandName = e.BrandName;
            dto.Comments = e.Comments;
            dto.ProductName = e.ProductName;
            dto.Description = e.Description;
            dto.PriceDetailText = e.PriceDetailText;
            dto.SmallImageUrl = e.SmallImageUrl;
            dto.MediumImageUrl = e.MediumImageUrl;
            dto.LargeImageUrl = e.LargeImageUrl;
            dto.DetailImageUrl = e.DetailImageUrl;
            dto.OriginalImageUrl = e.OriginalImageUrl;
            dto.DetailScreen = e.DetailScreen;
            dto.InventoryMessage = e.InventoryMessage;
            dto.InventoryItemTypeId = e.InventoryItemTypeId;
            dto.RequireInventory = e.RequireInventory;
            dto.QuantityUomId = e.QuantityUomId;
            dto.QuantityIncluded = e.QuantityIncluded;
            dto.PiecesIncluded = e.PiecesIncluded;
            dto.RequireAmount = e.RequireAmount;
            dto.FixedAmount = e.FixedAmount;
            dto.AmountUomTypeId = e.AmountUomTypeId;
            dto.WeightUomId = e.WeightUomId;
            dto.ShippingWeight = e.ShippingWeight;
            dto.ProductWeight = e.ProductWeight;
            dto.HeightUomId = e.HeightUomId;
            dto.ProductHeight = e.ProductHeight;
            dto.ShippingHeight = e.ShippingHeight;
            dto.WidthUomId = e.WidthUomId;
            dto.ProductWidth = e.ProductWidth;
            dto.ShippingWidth = e.ShippingWidth;
            dto.DepthUomId = e.DepthUomId;
            dto.ProductDepth = e.ProductDepth;
            dto.ShippingDepth = e.ShippingDepth;
            dto.DiameterUomId = e.DiameterUomId;
            dto.ProductDiameter = e.ProductDiameter;
            dto.ProductRating = e.ProductRating;
            dto.RatingTypeEnum = e.RatingTypeEnum;
            dto.Returnable = e.Returnable;
            dto.Taxable = e.Taxable;
            dto.ChargeShipping = e.ChargeShipping;
            dto.AutoCreateKeywords = e.AutoCreateKeywords;
            dto.IncludeInPromotions = e.IncludeInPromotions;
            dto.IsVirtual = e.IsVirtual;
            dto.IsVariant = e.IsVariant;
            dto.VirtualVariantMethodEnum = e.VirtualVariantMethodEnum;
            dto.InShippingBox = e.InShippingBox;
            dto.DefaultShipmentBoxTypeId = e.DefaultShipmentBoxTypeId;
            dto.IsSerialNumbered = e.IsSerialNumbered;
            dto.IsManagedByLot = e.IsManagedByLot;
            dto.AttributeSetId = e.AttributeSetId;
            dto.AttributeSetInstanceId = e.AttributeSetInstanceId;
            dto.Active = e.Active;
            var goodIdentificationEvents = new List<GoodIdentificationStateCreatedDto>();
            foreach (var ee in e.GoodIdentificationEvents)
            {
                GoodIdentificationStateCreatedDto eeDto = GoodIdentificationStateEventDtoConverter.ToGoodIdentificationStateCreatedDto(ee);
                goodIdentificationEvents.Add(eeDto);
            }
            dto.GoodIdentificationEvents = goodIdentificationEvents.ToArray();

            return dto;
        }

        public virtual ProductStateMergePatchedDto ToProductStateMergePatchedDto(IProductStateMergePatched e)
        {
            var dto = new ProductStateMergePatchedDto();
            dto.ProductEventId = e.ProductEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.ProductTypeId = e.ProductTypeId;
            dto.PrimaryProductCategoryId = e.PrimaryProductCategoryId;
            dto.ManufacturerPartyId = e.ManufacturerPartyId;
            dto.FacilityId = e.FacilityId;
            dto.IntroductionDate = e.IntroductionDate;
            dto.ReleaseDate = e.ReleaseDate;
            dto.SupportDiscontinuationDate = e.SupportDiscontinuationDate;
            dto.SalesDiscontinuationDate = e.SalesDiscontinuationDate;
            dto.SalesDiscWhenNotAvail = e.SalesDiscWhenNotAvail;
            dto.InternalName = e.InternalName;
            dto.BrandName = e.BrandName;
            dto.Comments = e.Comments;
            dto.ProductName = e.ProductName;
            dto.Description = e.Description;
            dto.PriceDetailText = e.PriceDetailText;
            dto.SmallImageUrl = e.SmallImageUrl;
            dto.MediumImageUrl = e.MediumImageUrl;
            dto.LargeImageUrl = e.LargeImageUrl;
            dto.DetailImageUrl = e.DetailImageUrl;
            dto.OriginalImageUrl = e.OriginalImageUrl;
            dto.DetailScreen = e.DetailScreen;
            dto.InventoryMessage = e.InventoryMessage;
            dto.InventoryItemTypeId = e.InventoryItemTypeId;
            dto.RequireInventory = e.RequireInventory;
            dto.QuantityUomId = e.QuantityUomId;
            dto.QuantityIncluded = e.QuantityIncluded;
            dto.PiecesIncluded = e.PiecesIncluded;
            dto.RequireAmount = e.RequireAmount;
            dto.FixedAmount = e.FixedAmount;
            dto.AmountUomTypeId = e.AmountUomTypeId;
            dto.WeightUomId = e.WeightUomId;
            dto.ShippingWeight = e.ShippingWeight;
            dto.ProductWeight = e.ProductWeight;
            dto.HeightUomId = e.HeightUomId;
            dto.ProductHeight = e.ProductHeight;
            dto.ShippingHeight = e.ShippingHeight;
            dto.WidthUomId = e.WidthUomId;
            dto.ProductWidth = e.ProductWidth;
            dto.ShippingWidth = e.ShippingWidth;
            dto.DepthUomId = e.DepthUomId;
            dto.ProductDepth = e.ProductDepth;
            dto.ShippingDepth = e.ShippingDepth;
            dto.DiameterUomId = e.DiameterUomId;
            dto.ProductDiameter = e.ProductDiameter;
            dto.ProductRating = e.ProductRating;
            dto.RatingTypeEnum = e.RatingTypeEnum;
            dto.Returnable = e.Returnable;
            dto.Taxable = e.Taxable;
            dto.ChargeShipping = e.ChargeShipping;
            dto.AutoCreateKeywords = e.AutoCreateKeywords;
            dto.IncludeInPromotions = e.IncludeInPromotions;
            dto.IsVirtual = e.IsVirtual;
            dto.IsVariant = e.IsVariant;
            dto.VirtualVariantMethodEnum = e.VirtualVariantMethodEnum;
            dto.InShippingBox = e.InShippingBox;
            dto.DefaultShipmentBoxTypeId = e.DefaultShipmentBoxTypeId;
            dto.IsSerialNumbered = e.IsSerialNumbered;
            dto.IsManagedByLot = e.IsManagedByLot;
            dto.AttributeSetId = e.AttributeSetId;
            dto.AttributeSetInstanceId = e.AttributeSetInstanceId;
            dto.Active = e.Active;
            dto.IsPropertyProductTypeIdRemoved = e.IsPropertyProductTypeIdRemoved;
            dto.IsPropertyPrimaryProductCategoryIdRemoved = e.IsPropertyPrimaryProductCategoryIdRemoved;
            dto.IsPropertyManufacturerPartyIdRemoved = e.IsPropertyManufacturerPartyIdRemoved;
            dto.IsPropertyFacilityIdRemoved = e.IsPropertyFacilityIdRemoved;
            dto.IsPropertyIntroductionDateRemoved = e.IsPropertyIntroductionDateRemoved;
            dto.IsPropertyReleaseDateRemoved = e.IsPropertyReleaseDateRemoved;
            dto.IsPropertySupportDiscontinuationDateRemoved = e.IsPropertySupportDiscontinuationDateRemoved;
            dto.IsPropertySalesDiscontinuationDateRemoved = e.IsPropertySalesDiscontinuationDateRemoved;
            dto.IsPropertySalesDiscWhenNotAvailRemoved = e.IsPropertySalesDiscWhenNotAvailRemoved;
            dto.IsPropertyInternalNameRemoved = e.IsPropertyInternalNameRemoved;
            dto.IsPropertyBrandNameRemoved = e.IsPropertyBrandNameRemoved;
            dto.IsPropertyCommentsRemoved = e.IsPropertyCommentsRemoved;
            dto.IsPropertyProductNameRemoved = e.IsPropertyProductNameRemoved;
            dto.IsPropertyDescriptionRemoved = e.IsPropertyDescriptionRemoved;
            dto.IsPropertyPriceDetailTextRemoved = e.IsPropertyPriceDetailTextRemoved;
            dto.IsPropertySmallImageUrlRemoved = e.IsPropertySmallImageUrlRemoved;
            dto.IsPropertyMediumImageUrlRemoved = e.IsPropertyMediumImageUrlRemoved;
            dto.IsPropertyLargeImageUrlRemoved = e.IsPropertyLargeImageUrlRemoved;
            dto.IsPropertyDetailImageUrlRemoved = e.IsPropertyDetailImageUrlRemoved;
            dto.IsPropertyOriginalImageUrlRemoved = e.IsPropertyOriginalImageUrlRemoved;
            dto.IsPropertyDetailScreenRemoved = e.IsPropertyDetailScreenRemoved;
            dto.IsPropertyInventoryMessageRemoved = e.IsPropertyInventoryMessageRemoved;
            dto.IsPropertyInventoryItemTypeIdRemoved = e.IsPropertyInventoryItemTypeIdRemoved;
            dto.IsPropertyRequireInventoryRemoved = e.IsPropertyRequireInventoryRemoved;
            dto.IsPropertyQuantityUomIdRemoved = e.IsPropertyQuantityUomIdRemoved;
            dto.IsPropertyQuantityIncludedRemoved = e.IsPropertyQuantityIncludedRemoved;
            dto.IsPropertyPiecesIncludedRemoved = e.IsPropertyPiecesIncludedRemoved;
            dto.IsPropertyRequireAmountRemoved = e.IsPropertyRequireAmountRemoved;
            dto.IsPropertyFixedAmountRemoved = e.IsPropertyFixedAmountRemoved;
            dto.IsPropertyAmountUomTypeIdRemoved = e.IsPropertyAmountUomTypeIdRemoved;
            dto.IsPropertyWeightUomIdRemoved = e.IsPropertyWeightUomIdRemoved;
            dto.IsPropertyShippingWeightRemoved = e.IsPropertyShippingWeightRemoved;
            dto.IsPropertyProductWeightRemoved = e.IsPropertyProductWeightRemoved;
            dto.IsPropertyHeightUomIdRemoved = e.IsPropertyHeightUomIdRemoved;
            dto.IsPropertyProductHeightRemoved = e.IsPropertyProductHeightRemoved;
            dto.IsPropertyShippingHeightRemoved = e.IsPropertyShippingHeightRemoved;
            dto.IsPropertyWidthUomIdRemoved = e.IsPropertyWidthUomIdRemoved;
            dto.IsPropertyProductWidthRemoved = e.IsPropertyProductWidthRemoved;
            dto.IsPropertyShippingWidthRemoved = e.IsPropertyShippingWidthRemoved;
            dto.IsPropertyDepthUomIdRemoved = e.IsPropertyDepthUomIdRemoved;
            dto.IsPropertyProductDepthRemoved = e.IsPropertyProductDepthRemoved;
            dto.IsPropertyShippingDepthRemoved = e.IsPropertyShippingDepthRemoved;
            dto.IsPropertyDiameterUomIdRemoved = e.IsPropertyDiameterUomIdRemoved;
            dto.IsPropertyProductDiameterRemoved = e.IsPropertyProductDiameterRemoved;
            dto.IsPropertyProductRatingRemoved = e.IsPropertyProductRatingRemoved;
            dto.IsPropertyRatingTypeEnumRemoved = e.IsPropertyRatingTypeEnumRemoved;
            dto.IsPropertyReturnableRemoved = e.IsPropertyReturnableRemoved;
            dto.IsPropertyTaxableRemoved = e.IsPropertyTaxableRemoved;
            dto.IsPropertyChargeShippingRemoved = e.IsPropertyChargeShippingRemoved;
            dto.IsPropertyAutoCreateKeywordsRemoved = e.IsPropertyAutoCreateKeywordsRemoved;
            dto.IsPropertyIncludeInPromotionsRemoved = e.IsPropertyIncludeInPromotionsRemoved;
            dto.IsPropertyIsVirtualRemoved = e.IsPropertyIsVirtualRemoved;
            dto.IsPropertyIsVariantRemoved = e.IsPropertyIsVariantRemoved;
            dto.IsPropertyVirtualVariantMethodEnumRemoved = e.IsPropertyVirtualVariantMethodEnumRemoved;
            dto.IsPropertyInShippingBoxRemoved = e.IsPropertyInShippingBoxRemoved;
            dto.IsPropertyDefaultShipmentBoxTypeIdRemoved = e.IsPropertyDefaultShipmentBoxTypeIdRemoved;
            dto.IsPropertyIsSerialNumberedRemoved = e.IsPropertyIsSerialNumberedRemoved;
            dto.IsPropertyIsManagedByLotRemoved = e.IsPropertyIsManagedByLotRemoved;
            dto.IsPropertyAttributeSetIdRemoved = e.IsPropertyAttributeSetIdRemoved;
            dto.IsPropertyAttributeSetInstanceIdRemoved = e.IsPropertyAttributeSetInstanceIdRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;
            var goodIdentificationEvents = new List<GoodIdentificationStateCreatedOrMergePatchedOrRemovedDto>();
            foreach (var ee in e.GoodIdentificationEvents)
            {
                GoodIdentificationStateCreatedOrMergePatchedOrRemovedDto eeDto = GoodIdentificationStateEventDtoConverter.ToGoodIdentificationStateEventDto(ee);
                goodIdentificationEvents.Add(eeDto);
            }
            dto.GoodIdentificationEvents = goodIdentificationEvents.ToArray();


            return dto;
        }


        protected virtual GoodIdentificationStateEventDtoConverter GoodIdentificationStateEventDtoConverter
        {
            get
            {
                return new GoodIdentificationStateEventDtoConverter();
            }
        }


    }


}

