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

    public partial class ProductStateDto : IProductStateDto
    {
        public virtual string ProductId
        {
            get;
            set;
        }

        public virtual string ProductTypeId
        {
            get;
            set;
        }

        public virtual string PrimaryProductCategoryId
        {
            get;
            set;
        }

        public virtual string ManufacturerPartyId
        {
            get;
            set;
        }

        public virtual string FacilityId
        {
            get;
            set;
        }

        public virtual DateTime? IntroductionDate
        {
            get;
            set;
        }

        public virtual DateTime? ReleaseDate
        {
            get;
            set;
        }

        public virtual DateTime? SupportDiscontinuationDate
        {
            get;
            set;
        }

        public virtual DateTime? SalesDiscontinuationDate
        {
            get;
            set;
        }

        public virtual string SalesDiscWhenNotAvail
        {
            get;
            set;
        }

        public virtual string InternalName
        {
            get;
            set;
        }

        public virtual string BrandName
        {
            get;
            set;
        }

        public virtual string Comments
        {
            get;
            set;
        }

        public virtual string ProductName
        {
            get;
            set;
        }

        public virtual string Description
        {
            get;
            set;
        }

        public virtual string PriceDetailText
        {
            get;
            set;
        }

        public virtual string SmallImageUrl
        {
            get;
            set;
        }

        public virtual string MediumImageUrl
        {
            get;
            set;
        }

        public virtual string LargeImageUrl
        {
            get;
            set;
        }

        public virtual string DetailImageUrl
        {
            get;
            set;
        }

        public virtual string OriginalImageUrl
        {
            get;
            set;
        }

        public virtual string DetailScreen
        {
            get;
            set;
        }

        public virtual string InventoryMessage
        {
            get;
            set;
        }

        public virtual string InventoryItemTypeId
        {
            get;
            set;
        }

        public virtual string RequireInventory
        {
            get;
            set;
        }

        public virtual string QuantityUomId
        {
            get;
            set;
        }

        public virtual decimal? QuantityIncluded
        {
            get;
            set;
        }

        public virtual long? PiecesIncluded
        {
            get;
            set;
        }

        public virtual string RequireAmount
        {
            get;
            set;
        }

        public virtual decimal? FixedAmount
        {
            get;
            set;
        }

        public virtual string AmountUomTypeId
        {
            get;
            set;
        }

        public virtual string WeightUomId
        {
            get;
            set;
        }

        public virtual decimal? ShippingWeight
        {
            get;
            set;
        }

        public virtual decimal? ProductWeight
        {
            get;
            set;
        }

        public virtual string HeightUomId
        {
            get;
            set;
        }

        public virtual decimal? ProductHeight
        {
            get;
            set;
        }

        public virtual decimal? ShippingHeight
        {
            get;
            set;
        }

        public virtual string WidthUomId
        {
            get;
            set;
        }

        public virtual decimal? ProductWidth
        {
            get;
            set;
        }

        public virtual decimal? ShippingWidth
        {
            get;
            set;
        }

        public virtual string DepthUomId
        {
            get;
            set;
        }

        public virtual decimal? ProductDepth
        {
            get;
            set;
        }

        public virtual decimal? ShippingDepth
        {
            get;
            set;
        }

        public virtual string DiameterUomId
        {
            get;
            set;
        }

        public virtual decimal? ProductDiameter
        {
            get;
            set;
        }

        public virtual decimal? ProductRating
        {
            get;
            set;
        }

        public virtual string RatingTypeEnum
        {
            get;
            set;
        }

        public virtual string Returnable
        {
            get;
            set;
        }

        public virtual string Taxable
        {
            get;
            set;
        }

        public virtual string ChargeShipping
        {
            get;
            set;
        }

        public virtual string AutoCreateKeywords
        {
            get;
            set;
        }

        public virtual string IncludeInPromotions
        {
            get;
            set;
        }

        public virtual string IsVirtual
        {
            get;
            set;
        }

        public virtual string IsVariant
        {
            get;
            set;
        }

        public virtual string VirtualVariantMethodEnum
        {
            get;
            set;
        }

        public virtual string InShippingBox
        {
            get;
            set;
        }

        public virtual string DefaultShipmentBoxTypeId
        {
            get;
            set;
        }

        public virtual string LotIdFilledIn
        {
            get;
            set;
        }

        public virtual bool? Active
        {
            get;
            set;
        }

        public virtual long? Version
        {
            get;
            set;
        }

        public virtual string CreatedBy
        {
            get;
            set;
        }

        public virtual DateTime? CreatedAt
        {
            get;
            set;
        }

        public virtual string UpdatedBy
        {
            get;
            set;
        }

        public virtual DateTime? UpdatedAt
        {
            get;
            set;
        }

        public virtual IProductState ToProductState()
        {
            var state = new ProductState(true);
            state.ProductId = this.ProductId;
            state.ProductTypeId = this.ProductTypeId;
            state.PrimaryProductCategoryId = this.PrimaryProductCategoryId;
            state.ManufacturerPartyId = this.ManufacturerPartyId;
            state.FacilityId = this.FacilityId;
            state.IntroductionDate = this.IntroductionDate;
            state.ReleaseDate = this.ReleaseDate;
            state.SupportDiscontinuationDate = this.SupportDiscontinuationDate;
            state.SalesDiscontinuationDate = this.SalesDiscontinuationDate;
            state.SalesDiscWhenNotAvail = this.SalesDiscWhenNotAvail;
            state.InternalName = this.InternalName;
            state.BrandName = this.BrandName;
            state.Comments = this.Comments;
            state.ProductName = this.ProductName;
            state.Description = this.Description;
            state.PriceDetailText = this.PriceDetailText;
            state.SmallImageUrl = this.SmallImageUrl;
            state.MediumImageUrl = this.MediumImageUrl;
            state.LargeImageUrl = this.LargeImageUrl;
            state.DetailImageUrl = this.DetailImageUrl;
            state.OriginalImageUrl = this.OriginalImageUrl;
            state.DetailScreen = this.DetailScreen;
            state.InventoryMessage = this.InventoryMessage;
            state.InventoryItemTypeId = this.InventoryItemTypeId;
            state.RequireInventory = this.RequireInventory;
            state.QuantityUomId = this.QuantityUomId;
            state.QuantityIncluded = this.QuantityIncluded;
            state.PiecesIncluded = this.PiecesIncluded;
            state.RequireAmount = this.RequireAmount;
            state.FixedAmount = this.FixedAmount;
            state.AmountUomTypeId = this.AmountUomTypeId;
            state.WeightUomId = this.WeightUomId;
            state.ShippingWeight = this.ShippingWeight;
            state.ProductWeight = this.ProductWeight;
            state.HeightUomId = this.HeightUomId;
            state.ProductHeight = this.ProductHeight;
            state.ShippingHeight = this.ShippingHeight;
            state.WidthUomId = this.WidthUomId;
            state.ProductWidth = this.ProductWidth;
            state.ShippingWidth = this.ShippingWidth;
            state.DepthUomId = this.DepthUomId;
            state.ProductDepth = this.ProductDepth;
            state.ShippingDepth = this.ShippingDepth;
            state.DiameterUomId = this.DiameterUomId;
            state.ProductDiameter = this.ProductDiameter;
            state.ProductRating = this.ProductRating;
            state.RatingTypeEnum = this.RatingTypeEnum;
            state.Returnable = this.Returnable;
            state.Taxable = this.Taxable;
            state.ChargeShipping = this.ChargeShipping;
            state.AutoCreateKeywords = this.AutoCreateKeywords;
            state.IncludeInPromotions = this.IncludeInPromotions;
            state.IsVirtual = this.IsVirtual;
            state.IsVariant = this.IsVariant;
            state.VirtualVariantMethodEnum = this.VirtualVariantMethodEnum;
            state.InShippingBox = this.InShippingBox;
            state.DefaultShipmentBoxTypeId = this.DefaultShipmentBoxTypeId;
            state.LotIdFilledIn = this.LotIdFilledIn;
            if (this.Active != null && this.Active.HasValue) { state.Active = this.Active.Value; }
            if (this.Version != null && this.Version.HasValue) { state.Version = this.Version.Value; }
            state.CreatedBy = this.CreatedBy;
            if (this.CreatedAt != null && this.CreatedAt.HasValue) { state.CreatedAt = this.CreatedAt.Value; }
            state.UpdatedBy = this.UpdatedBy;
            if (this.UpdatedAt != null && this.UpdatedAt.HasValue) { state.UpdatedAt = this.UpdatedAt.Value; }

            return state;
        }

    }

}

