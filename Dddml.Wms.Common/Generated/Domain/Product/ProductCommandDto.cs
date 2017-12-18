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

	public abstract class ProductCommandDtoBase : ICommandDto, ICreateProduct, IMergePatchProduct, IDeleteProduct
	{

		string IAggregateCommand<string, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteProduct)this).ProductId;
			}
		}


		long IAggregateCommand<string, long>.AggregateVersion
		{
			get
			{
				return this.Version;
			}
		}

		public virtual long Version { get; set; }

		public virtual string RequesterId { get; set; }

		public virtual string CommandId { get; set; }

        object ICommand.RequesterId
        {
            get { return this.RequesterId; }
            set { this.RequesterId = (string)value; }
        }

        string ICommand.CommandId
        {
            get { return this.CommandId; }
            set { this.CommandId = value; }
        }

		public virtual string ProductId { get; set; }

		public virtual string ProductTypeId { get; set; }

		public virtual string PrimaryProductCategoryId { get; set; }

		public virtual string ManufacturerPartyId { get; set; }

		public virtual string FacilityId { get; set; }

		public virtual DateTime? IntroductionDate { get; set; }

		public virtual DateTime? ReleaseDate { get; set; }

		public virtual DateTime? SupportDiscontinuationDate { get; set; }

		public virtual DateTime? SalesDiscontinuationDate { get; set; }

		public virtual string SalesDiscWhenNotAvail { get; set; }

		public virtual string InternalName { get; set; }

		public virtual string BrandName { get; set; }

		public virtual string Comments { get; set; }

		public virtual string ProductName { get; set; }

		public virtual string Description { get; set; }

		public virtual string PriceDetailText { get; set; }

		public virtual string SmallImageUrl { get; set; }

		public virtual string MediumImageUrl { get; set; }

		public virtual string LargeImageUrl { get; set; }

		public virtual string DetailImageUrl { get; set; }

		public virtual string OriginalImageUrl { get; set; }

		public virtual string DetailScreen { get; set; }

		public virtual string InventoryMessage { get; set; }

		public virtual string InventoryItemTypeId { get; set; }

		public virtual string RequireInventory { get; set; }

		public virtual string QuantityUomId { get; set; }

		public virtual decimal? QuantityIncluded { get; set; }

		public virtual long? PiecesIncluded { get; set; }

		public virtual string RequireAmount { get; set; }

		public virtual decimal? FixedAmount { get; set; }

		public virtual string AmountUomTypeId { get; set; }

		public virtual string WeightUomId { get; set; }

		public virtual decimal? ShippingWeight { get; set; }

		public virtual decimal? ProductWeight { get; set; }

		public virtual string HeightUomId { get; set; }

		public virtual decimal? ProductHeight { get; set; }

		public virtual decimal? ShippingHeight { get; set; }

		public virtual string WidthUomId { get; set; }

		public virtual decimal? ProductWidth { get; set; }

		public virtual decimal? ShippingWidth { get; set; }

		public virtual string DepthUomId { get; set; }

		public virtual decimal? ProductDepth { get; set; }

		public virtual decimal? ShippingDepth { get; set; }

		public virtual string DiameterUomId { get; set; }

		public virtual decimal? ProductDiameter { get; set; }

		public virtual decimal? ProductRating { get; set; }

		public virtual string RatingTypeEnum { get; set; }

		public virtual string Returnable { get; set; }

		public virtual string Taxable { get; set; }

		public virtual string ChargeShipping { get; set; }

		public virtual string AutoCreateKeywords { get; set; }

		public virtual string IncludeInPromotions { get; set; }

		public virtual string IsVirtual { get; set; }

		public virtual string IsVariant { get; set; }

		public virtual string VirtualVariantMethodEnum { get; set; }

		public virtual string InShippingBox { get; set; }

		public virtual string DefaultShipmentBoxTypeId { get; set; }

		public virtual string LotIdFilledIn { get; set; }

		public virtual bool? Active { get; set; }

		public virtual bool? IsPropertyProductTypeIdRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyProductTypeIdRemoved
        {
            get
            {
                var b = this.IsPropertyProductTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProductTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyPrimaryProductCategoryIdRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyPrimaryProductCategoryIdRemoved
        {
            get
            {
                var b = this.IsPropertyPrimaryProductCategoryIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyPrimaryProductCategoryIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyManufacturerPartyIdRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyManufacturerPartyIdRemoved
        {
            get
            {
                var b = this.IsPropertyManufacturerPartyIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyManufacturerPartyIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyFacilityIdRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyFacilityIdRemoved
        {
            get
            {
                var b = this.IsPropertyFacilityIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyFacilityIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyIntroductionDateRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyIntroductionDateRemoved
        {
            get
            {
                var b = this.IsPropertyIntroductionDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyIntroductionDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyReleaseDateRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyReleaseDateRemoved
        {
            get
            {
                var b = this.IsPropertyReleaseDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyReleaseDateRemoved = value;
            }
        }

		public virtual bool? IsPropertySupportDiscontinuationDateRemoved { get; set; }

        bool IMergePatchProduct.IsPropertySupportDiscontinuationDateRemoved
        {
            get
            {
                var b = this.IsPropertySupportDiscontinuationDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertySupportDiscontinuationDateRemoved = value;
            }
        }

		public virtual bool? IsPropertySalesDiscontinuationDateRemoved { get; set; }

        bool IMergePatchProduct.IsPropertySalesDiscontinuationDateRemoved
        {
            get
            {
                var b = this.IsPropertySalesDiscontinuationDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertySalesDiscontinuationDateRemoved = value;
            }
        }

		public virtual bool? IsPropertySalesDiscWhenNotAvailRemoved { get; set; }

        bool IMergePatchProduct.IsPropertySalesDiscWhenNotAvailRemoved
        {
            get
            {
                var b = this.IsPropertySalesDiscWhenNotAvailRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertySalesDiscWhenNotAvailRemoved = value;
            }
        }

		public virtual bool? IsPropertyInternalNameRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyInternalNameRemoved
        {
            get
            {
                var b = this.IsPropertyInternalNameRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyInternalNameRemoved = value;
            }
        }

		public virtual bool? IsPropertyBrandNameRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyBrandNameRemoved
        {
            get
            {
                var b = this.IsPropertyBrandNameRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyBrandNameRemoved = value;
            }
        }

		public virtual bool? IsPropertyCommentsRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyCommentsRemoved
        {
            get
            {
                var b = this.IsPropertyCommentsRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyCommentsRemoved = value;
            }
        }

		public virtual bool? IsPropertyProductNameRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyProductNameRemoved
        {
            get
            {
                var b = this.IsPropertyProductNameRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProductNameRemoved = value;
            }
        }

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyDescriptionRemoved
        {
            get
            {
                var b = this.IsPropertyDescriptionRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDescriptionRemoved = value;
            }
        }

		public virtual bool? IsPropertyPriceDetailTextRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyPriceDetailTextRemoved
        {
            get
            {
                var b = this.IsPropertyPriceDetailTextRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyPriceDetailTextRemoved = value;
            }
        }

		public virtual bool? IsPropertySmallImageUrlRemoved { get; set; }

        bool IMergePatchProduct.IsPropertySmallImageUrlRemoved
        {
            get
            {
                var b = this.IsPropertySmallImageUrlRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertySmallImageUrlRemoved = value;
            }
        }

		public virtual bool? IsPropertyMediumImageUrlRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyMediumImageUrlRemoved
        {
            get
            {
                var b = this.IsPropertyMediumImageUrlRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyMediumImageUrlRemoved = value;
            }
        }

		public virtual bool? IsPropertyLargeImageUrlRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyLargeImageUrlRemoved
        {
            get
            {
                var b = this.IsPropertyLargeImageUrlRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyLargeImageUrlRemoved = value;
            }
        }

		public virtual bool? IsPropertyDetailImageUrlRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyDetailImageUrlRemoved
        {
            get
            {
                var b = this.IsPropertyDetailImageUrlRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDetailImageUrlRemoved = value;
            }
        }

		public virtual bool? IsPropertyOriginalImageUrlRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyOriginalImageUrlRemoved
        {
            get
            {
                var b = this.IsPropertyOriginalImageUrlRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyOriginalImageUrlRemoved = value;
            }
        }

		public virtual bool? IsPropertyDetailScreenRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyDetailScreenRemoved
        {
            get
            {
                var b = this.IsPropertyDetailScreenRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDetailScreenRemoved = value;
            }
        }

		public virtual bool? IsPropertyInventoryMessageRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyInventoryMessageRemoved
        {
            get
            {
                var b = this.IsPropertyInventoryMessageRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyInventoryMessageRemoved = value;
            }
        }

		public virtual bool? IsPropertyInventoryItemTypeIdRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyInventoryItemTypeIdRemoved
        {
            get
            {
                var b = this.IsPropertyInventoryItemTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyInventoryItemTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyRequireInventoryRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyRequireInventoryRemoved
        {
            get
            {
                var b = this.IsPropertyRequireInventoryRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyRequireInventoryRemoved = value;
            }
        }

		public virtual bool? IsPropertyQuantityUomIdRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyQuantityUomIdRemoved
        {
            get
            {
                var b = this.IsPropertyQuantityUomIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyQuantityUomIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyQuantityIncludedRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyQuantityIncludedRemoved
        {
            get
            {
                var b = this.IsPropertyQuantityIncludedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyQuantityIncludedRemoved = value;
            }
        }

		public virtual bool? IsPropertyPiecesIncludedRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyPiecesIncludedRemoved
        {
            get
            {
                var b = this.IsPropertyPiecesIncludedRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyPiecesIncludedRemoved = value;
            }
        }

		public virtual bool? IsPropertyRequireAmountRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyRequireAmountRemoved
        {
            get
            {
                var b = this.IsPropertyRequireAmountRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyRequireAmountRemoved = value;
            }
        }

		public virtual bool? IsPropertyFixedAmountRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyFixedAmountRemoved
        {
            get
            {
                var b = this.IsPropertyFixedAmountRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyFixedAmountRemoved = value;
            }
        }

		public virtual bool? IsPropertyAmountUomTypeIdRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyAmountUomTypeIdRemoved
        {
            get
            {
                var b = this.IsPropertyAmountUomTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAmountUomTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyWeightUomIdRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyWeightUomIdRemoved
        {
            get
            {
                var b = this.IsPropertyWeightUomIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyWeightUomIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyShippingWeightRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyShippingWeightRemoved
        {
            get
            {
                var b = this.IsPropertyShippingWeightRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShippingWeightRemoved = value;
            }
        }

		public virtual bool? IsPropertyProductWeightRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyProductWeightRemoved
        {
            get
            {
                var b = this.IsPropertyProductWeightRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProductWeightRemoved = value;
            }
        }

		public virtual bool? IsPropertyHeightUomIdRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyHeightUomIdRemoved
        {
            get
            {
                var b = this.IsPropertyHeightUomIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyHeightUomIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyProductHeightRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyProductHeightRemoved
        {
            get
            {
                var b = this.IsPropertyProductHeightRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProductHeightRemoved = value;
            }
        }

		public virtual bool? IsPropertyShippingHeightRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyShippingHeightRemoved
        {
            get
            {
                var b = this.IsPropertyShippingHeightRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShippingHeightRemoved = value;
            }
        }

		public virtual bool? IsPropertyWidthUomIdRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyWidthUomIdRemoved
        {
            get
            {
                var b = this.IsPropertyWidthUomIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyWidthUomIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyProductWidthRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyProductWidthRemoved
        {
            get
            {
                var b = this.IsPropertyProductWidthRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProductWidthRemoved = value;
            }
        }

		public virtual bool? IsPropertyShippingWidthRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyShippingWidthRemoved
        {
            get
            {
                var b = this.IsPropertyShippingWidthRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShippingWidthRemoved = value;
            }
        }

		public virtual bool? IsPropertyDepthUomIdRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyDepthUomIdRemoved
        {
            get
            {
                var b = this.IsPropertyDepthUomIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDepthUomIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyProductDepthRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyProductDepthRemoved
        {
            get
            {
                var b = this.IsPropertyProductDepthRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProductDepthRemoved = value;
            }
        }

		public virtual bool? IsPropertyShippingDepthRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyShippingDepthRemoved
        {
            get
            {
                var b = this.IsPropertyShippingDepthRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShippingDepthRemoved = value;
            }
        }

		public virtual bool? IsPropertyDiameterUomIdRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyDiameterUomIdRemoved
        {
            get
            {
                var b = this.IsPropertyDiameterUomIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDiameterUomIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyProductDiameterRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyProductDiameterRemoved
        {
            get
            {
                var b = this.IsPropertyProductDiameterRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProductDiameterRemoved = value;
            }
        }

		public virtual bool? IsPropertyProductRatingRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyProductRatingRemoved
        {
            get
            {
                var b = this.IsPropertyProductRatingRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProductRatingRemoved = value;
            }
        }

		public virtual bool? IsPropertyRatingTypeEnumRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyRatingTypeEnumRemoved
        {
            get
            {
                var b = this.IsPropertyRatingTypeEnumRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyRatingTypeEnumRemoved = value;
            }
        }

		public virtual bool? IsPropertyReturnableRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyReturnableRemoved
        {
            get
            {
                var b = this.IsPropertyReturnableRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyReturnableRemoved = value;
            }
        }

		public virtual bool? IsPropertyTaxableRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyTaxableRemoved
        {
            get
            {
                var b = this.IsPropertyTaxableRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyTaxableRemoved = value;
            }
        }

		public virtual bool? IsPropertyChargeShippingRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyChargeShippingRemoved
        {
            get
            {
                var b = this.IsPropertyChargeShippingRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyChargeShippingRemoved = value;
            }
        }

		public virtual bool? IsPropertyAutoCreateKeywordsRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyAutoCreateKeywordsRemoved
        {
            get
            {
                var b = this.IsPropertyAutoCreateKeywordsRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAutoCreateKeywordsRemoved = value;
            }
        }

		public virtual bool? IsPropertyIncludeInPromotionsRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyIncludeInPromotionsRemoved
        {
            get
            {
                var b = this.IsPropertyIncludeInPromotionsRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyIncludeInPromotionsRemoved = value;
            }
        }

		public virtual bool? IsPropertyIsVirtualRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyIsVirtualRemoved
        {
            get
            {
                var b = this.IsPropertyIsVirtualRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyIsVirtualRemoved = value;
            }
        }

		public virtual bool? IsPropertyIsVariantRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyIsVariantRemoved
        {
            get
            {
                var b = this.IsPropertyIsVariantRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyIsVariantRemoved = value;
            }
        }

		public virtual bool? IsPropertyVirtualVariantMethodEnumRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyVirtualVariantMethodEnumRemoved
        {
            get
            {
                var b = this.IsPropertyVirtualVariantMethodEnumRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyVirtualVariantMethodEnumRemoved = value;
            }
        }

		public virtual bool? IsPropertyInShippingBoxRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyInShippingBoxRemoved
        {
            get
            {
                var b = this.IsPropertyInShippingBoxRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyInShippingBoxRemoved = value;
            }
        }

		public virtual bool? IsPropertyDefaultShipmentBoxTypeIdRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyDefaultShipmentBoxTypeIdRemoved
        {
            get
            {
                var b = this.IsPropertyDefaultShipmentBoxTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyDefaultShipmentBoxTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyLotIdFilledInRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyLotIdFilledInRemoved
        {
            get
            {
                var b = this.IsPropertyLotIdFilledInRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyLotIdFilledInRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchProduct.IsPropertyActiveRemoved
        {
            get
            {
                var b = this.IsPropertyActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyActiveRemoved = value;
            }
        }


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrDeleteProductDto : ProductCommandDtoBase
    {
        private string _commandType;

        public virtual string CommandType
        {
            get { return _commandType; }
            set { _commandType = value; }
        }

        protected override string GetCommandType()
        {
            return this._commandType;
        }

    }



	public class CreateProductDto : CreateOrMergePatchOrDeleteProductDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }

	}


	public class MergePatchProductDto : CreateOrMergePatchOrDeleteProductDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class DeleteProductDto : CreateOrMergePatchOrDeleteProductDto
	{
        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Delete;
        }


        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

	}

    public static partial class ProductCommandDtos
    {

    }

}

