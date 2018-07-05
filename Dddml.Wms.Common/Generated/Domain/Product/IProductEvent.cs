﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateProductDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Product;

namespace Dddml.Wms.Domain.Product
{
	public interface IProductEvent : IEvent, IEventDto, IGlobalIdentity<ProductEventId>, ICreated<string>
	{
		ProductEventId ProductEventId { get; }

        bool ReadOnly { get; set; }

	}

    public interface IProductStateEvent : IProductEvent
    {
		string ProductTypeId { get; set; }

		string PrimaryProductCategoryId { get; set; }

		string ManufacturerPartyId { get; set; }

		string FacilityId { get; set; }

		DateTime? IntroductionDate { get; set; }

		DateTime? ReleaseDate { get; set; }

		DateTime? SupportDiscontinuationDate { get; set; }

		DateTime? SalesDiscontinuationDate { get; set; }

		string SalesDiscWhenNotAvail { get; set; }

		string InternalName { get; set; }

		string BrandName { get; set; }

		string Comments { get; set; }

		string ProductName { get; set; }

		string Description { get; set; }

		string PriceDetailText { get; set; }

		string SmallImageUrl { get; set; }

		string MediumImageUrl { get; set; }

		string LargeImageUrl { get; set; }

		string DetailImageUrl { get; set; }

		string OriginalImageUrl { get; set; }

		string DetailScreen { get; set; }

		string InventoryMessage { get; set; }

		string InventoryItemTypeId { get; set; }

		string RequireInventory { get; set; }

		string QuantityUomId { get; set; }

		decimal? QuantityIncluded { get; set; }

		long? PiecesIncluded { get; set; }

		string RequireAmount { get; set; }

		decimal? FixedAmount { get; set; }

		string AmountUomTypeId { get; set; }

		string WeightUomId { get; set; }

		decimal? ShippingWeight { get; set; }

		decimal? ProductWeight { get; set; }

		string HeightUomId { get; set; }

		decimal? ProductHeight { get; set; }

		decimal? ShippingHeight { get; set; }

		string WidthUomId { get; set; }

		decimal? ProductWidth { get; set; }

		decimal? ShippingWidth { get; set; }

		string DepthUomId { get; set; }

		decimal? ProductDepth { get; set; }

		decimal? ShippingDepth { get; set; }

		string DiameterUomId { get; set; }

		decimal? ProductDiameter { get; set; }

		decimal? ProductRating { get; set; }

		string RatingTypeEnum { get; set; }

		string Returnable { get; set; }

		string Taxable { get; set; }

		string ChargeShipping { get; set; }

		string AutoCreateKeywords { get; set; }

		string IncludeInPromotions { get; set; }

		string IsVirtual { get; set; }

		string IsVariant { get; set; }

		string VirtualVariantMethodEnum { get; set; }

		string InShippingBox { get; set; }

		string DefaultShipmentBoxTypeId { get; set; }

		bool? IsSerialNumbered { get; set; }

		bool? IsManagedByLot { get; set; }

		string AttributeSetId { get; set; }

		string AttributeSetInstanceId { get; set; }

		bool? Active { get; set; }

    }
   
	public interface IProductStateCreated : IProductStateEvent
	{
		IEnumerable<IGoodIdentificationStateCreated> GoodIdentificationEvents { get; }
		
		void AddGoodIdentificationEvent(IGoodIdentificationStateCreated e);

		IGoodIdentificationStateCreated NewGoodIdentificationStateCreated(string goodIdentificationTypeId);

	
	}


	public interface IProductStateMergePatched : IProductStateEvent
	{
		bool IsPropertyProductTypeIdRemoved { get; set; }

		bool IsPropertyPrimaryProductCategoryIdRemoved { get; set; }

		bool IsPropertyManufacturerPartyIdRemoved { get; set; }

		bool IsPropertyFacilityIdRemoved { get; set; }

		bool IsPropertyIntroductionDateRemoved { get; set; }

		bool IsPropertyReleaseDateRemoved { get; set; }

		bool IsPropertySupportDiscontinuationDateRemoved { get; set; }

		bool IsPropertySalesDiscontinuationDateRemoved { get; set; }

		bool IsPropertySalesDiscWhenNotAvailRemoved { get; set; }

		bool IsPropertyInternalNameRemoved { get; set; }

		bool IsPropertyBrandNameRemoved { get; set; }

		bool IsPropertyCommentsRemoved { get; set; }

		bool IsPropertyProductNameRemoved { get; set; }

		bool IsPropertyDescriptionRemoved { get; set; }

		bool IsPropertyPriceDetailTextRemoved { get; set; }

		bool IsPropertySmallImageUrlRemoved { get; set; }

		bool IsPropertyMediumImageUrlRemoved { get; set; }

		bool IsPropertyLargeImageUrlRemoved { get; set; }

		bool IsPropertyDetailImageUrlRemoved { get; set; }

		bool IsPropertyOriginalImageUrlRemoved { get; set; }

		bool IsPropertyDetailScreenRemoved { get; set; }

		bool IsPropertyInventoryMessageRemoved { get; set; }

		bool IsPropertyInventoryItemTypeIdRemoved { get; set; }

		bool IsPropertyRequireInventoryRemoved { get; set; }

		bool IsPropertyQuantityUomIdRemoved { get; set; }

		bool IsPropertyQuantityIncludedRemoved { get; set; }

		bool IsPropertyPiecesIncludedRemoved { get; set; }

		bool IsPropertyRequireAmountRemoved { get; set; }

		bool IsPropertyFixedAmountRemoved { get; set; }

		bool IsPropertyAmountUomTypeIdRemoved { get; set; }

		bool IsPropertyWeightUomIdRemoved { get; set; }

		bool IsPropertyShippingWeightRemoved { get; set; }

		bool IsPropertyProductWeightRemoved { get; set; }

		bool IsPropertyHeightUomIdRemoved { get; set; }

		bool IsPropertyProductHeightRemoved { get; set; }

		bool IsPropertyShippingHeightRemoved { get; set; }

		bool IsPropertyWidthUomIdRemoved { get; set; }

		bool IsPropertyProductWidthRemoved { get; set; }

		bool IsPropertyShippingWidthRemoved { get; set; }

		bool IsPropertyDepthUomIdRemoved { get; set; }

		bool IsPropertyProductDepthRemoved { get; set; }

		bool IsPropertyShippingDepthRemoved { get; set; }

		bool IsPropertyDiameterUomIdRemoved { get; set; }

		bool IsPropertyProductDiameterRemoved { get; set; }

		bool IsPropertyProductRatingRemoved { get; set; }

		bool IsPropertyRatingTypeEnumRemoved { get; set; }

		bool IsPropertyReturnableRemoved { get; set; }

		bool IsPropertyTaxableRemoved { get; set; }

		bool IsPropertyChargeShippingRemoved { get; set; }

		bool IsPropertyAutoCreateKeywordsRemoved { get; set; }

		bool IsPropertyIncludeInPromotionsRemoved { get; set; }

		bool IsPropertyIsVirtualRemoved { get; set; }

		bool IsPropertyIsVariantRemoved { get; set; }

		bool IsPropertyVirtualVariantMethodEnumRemoved { get; set; }

		bool IsPropertyInShippingBoxRemoved { get; set; }

		bool IsPropertyDefaultShipmentBoxTypeIdRemoved { get; set; }

		bool IsPropertyIsSerialNumberedRemoved { get; set; }

		bool IsPropertyIsManagedByLotRemoved { get; set; }

		bool IsPropertyAttributeSetIdRemoved { get; set; }

		bool IsPropertyAttributeSetInstanceIdRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }

		IEnumerable<IGoodIdentificationEvent> GoodIdentificationEvents { get; }
		
		void AddGoodIdentificationEvent(IGoodIdentificationEvent e);

		IGoodIdentificationStateCreated NewGoodIdentificationStateCreated(string goodIdentificationTypeId);

		IGoodIdentificationStateMergePatched NewGoodIdentificationStateMergePatched(string goodIdentificationTypeId);

		IGoodIdentificationStateRemoved NewGoodIdentificationStateRemoved(string goodIdentificationTypeId);


	}


}

