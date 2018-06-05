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

	public partial class ProductState : ProductStateProperties, IProductState, ISaveable
	{

		public virtual string CreatedBy { get; set; }

		public virtual DateTime CreatedAt { get; set; }

		public virtual string UpdatedBy { get; set; }

		public virtual DateTime UpdatedAt { get; set; }


		#region IIdentity implementation

		string IGlobalIdentity<string>.GlobalId
		{
			get
			{
				return this.ProductId;
			}
		}

		#endregion

		#region IActive implementation

		bool IActive.IsActive()
		{
			return this.Active;
		}

		#endregion


		#region ICreated implementation

		string ICreated<string>.CreatedBy
		{
			get
			{
				return this.CreatedBy;
			}
			set
			{
				this.CreatedBy = value;
			}
		}

		DateTime ICreated<string>.CreatedAt
		{
			get
			{
				return this.CreatedAt;
			}
			set
			{
				this.CreatedAt = value;
			}
		}

		#endregion

		#region IUpdated implementation

		string IUpdated<string>.UpdatedBy
		{
			get { return this.UpdatedBy; }
			set { this.UpdatedBy = value; }
		}

		DateTime IUpdated<string>.UpdatedAt
		{
			get { return this.UpdatedAt; }
			set { this.UpdatedAt = value; }
		}

		#endregion

		#region IVersioned implementation

		long IAggregateVersioned<long>.AggregateVersion
		{
			get
			{
				return this.Version;
			}
		}


		#endregion

        bool IProductState.IsUnsaved
        {
            get { return this.Version == VersionZero; }
        }

		public static long VersionZero
		{
			get
			{
				return (long)0;
			}
		}


        private IGoodIdentificationStates _goodIdentifications;
      
        public virtual IGoodIdentificationStates GoodIdentifications
        {
            get
            {
                return this._goodIdentifications;
            }
            set
            {
                this._goodIdentifications = value;
            }
        }


        public virtual bool StateReadOnly { get; set; }

        bool IState.ReadOnly
        {
            get { return this.StateReadOnly; }
            set { this.StateReadOnly = value; }
        }
	
        private bool _forReapplying;

        public virtual bool ForReapplying
        {
            get { return _forReapplying; }
            set { _forReapplying = value; } 
        }

        public ProductState(IEnumerable<IEvent> events) : this(true)
        {
            if (events != null && events.Count() > 0)
            {
                this.ProductId = ((IProductEvent)events.First()).ProductEventId.ProductId;
                foreach (var e in events)
                {
                    Mutate(e);
                    this.Version += 1;
                }
            }
        }

        public ProductState() : this(false)
        {
        }

        public ProductState(bool forReapplying)
        {
            this._forReapplying = forReapplying;
            _goodIdentifications = new GoodIdentificationStates(this);

            InitializeProperties();
        }


		#region Saveable Implements

        public virtual void Save()
        {
            _goodIdentifications.Save();

        }


		#endregion


		public virtual void When(IProductStateCreated e)
		{
			ThrowOnWrongEvent(e);
			this.ProductTypeId = e.ProductTypeId;

			this.PrimaryProductCategoryId = e.PrimaryProductCategoryId;

			this.ManufacturerPartyId = e.ManufacturerPartyId;

			this.FacilityId = e.FacilityId;

			this.IntroductionDate = e.IntroductionDate;

			this.ReleaseDate = e.ReleaseDate;

			this.SupportDiscontinuationDate = e.SupportDiscontinuationDate;

			this.SalesDiscontinuationDate = e.SalesDiscontinuationDate;

			this.SalesDiscWhenNotAvail = e.SalesDiscWhenNotAvail;

			this.InternalName = e.InternalName;

			this.BrandName = e.BrandName;

			this.Comments = e.Comments;

			this.ProductName = e.ProductName;

			this.Description = e.Description;

			this.PriceDetailText = e.PriceDetailText;

			this.SmallImageUrl = e.SmallImageUrl;

			this.MediumImageUrl = e.MediumImageUrl;

			this.LargeImageUrl = e.LargeImageUrl;

			this.DetailImageUrl = e.DetailImageUrl;

			this.OriginalImageUrl = e.OriginalImageUrl;

			this.DetailScreen = e.DetailScreen;

			this.InventoryMessage = e.InventoryMessage;

			this.InventoryItemTypeId = e.InventoryItemTypeId;

			this.RequireInventory = e.RequireInventory;

			this.QuantityUomId = e.QuantityUomId;

			this.QuantityIncluded = e.QuantityIncluded;

			this.PiecesIncluded = e.PiecesIncluded;

			this.RequireAmount = e.RequireAmount;

			this.FixedAmount = e.FixedAmount;

			this.AmountUomTypeId = e.AmountUomTypeId;

			this.WeightUomId = e.WeightUomId;

			this.ShippingWeight = e.ShippingWeight;

			this.ProductWeight = e.ProductWeight;

			this.HeightUomId = e.HeightUomId;

			this.ProductHeight = e.ProductHeight;

			this.ShippingHeight = e.ShippingHeight;

			this.WidthUomId = e.WidthUomId;

			this.ProductWidth = e.ProductWidth;

			this.ShippingWidth = e.ShippingWidth;

			this.DepthUomId = e.DepthUomId;

			this.ProductDepth = e.ProductDepth;

			this.ShippingDepth = e.ShippingDepth;

			this.DiameterUomId = e.DiameterUomId;

			this.ProductDiameter = e.ProductDiameter;

			this.ProductRating = e.ProductRating;

			this.RatingTypeEnum = e.RatingTypeEnum;

			this.Returnable = e.Returnable;

			this.Taxable = e.Taxable;

			this.ChargeShipping = e.ChargeShipping;

			this.AutoCreateKeywords = e.AutoCreateKeywords;

			this.IncludeInPromotions = e.IncludeInPromotions;

			this.IsVirtual = e.IsVirtual;

			this.IsVariant = e.IsVariant;

			this.VirtualVariantMethodEnum = e.VirtualVariantMethodEnum;

			this.InShippingBox = e.InShippingBox;

			this.DefaultShipmentBoxTypeId = e.DefaultShipmentBoxTypeId;

            this.IsSerialNumbered = (e.IsSerialNumbered != null && e.IsSerialNumbered.HasValue) ? e.IsSerialNumbered.Value : default(bool);

            this.IsManagedByLot = (e.IsManagedByLot != null && e.IsManagedByLot.HasValue) ? e.IsManagedByLot.Value : default(bool);

			this.AttributeSetId = e.AttributeSetId;

			this.AttributeSetInstanceId = e.AttributeSetInstanceId;

            this.Active = (e.Active != null && e.Active.HasValue) ? e.Active.Value : default(bool);

			this.CreatedBy = e.CreatedBy;
			this.CreatedAt = e.CreatedAt;

			foreach (IGoodIdentificationStateCreated innerEvent in e.GoodIdentificationEvents) {
				IGoodIdentificationState innerState = this.GoodIdentifications.Get(innerEvent.GlobalId.GoodIdentificationTypeId, true);
				innerState.Mutate (innerEvent);
			}

		}


		public virtual void When(IProductStateMergePatched e)
		{
			ThrowOnWrongEvent(e);

			if (e.ProductTypeId == null)
			{
				if (e.IsPropertyProductTypeIdRemoved)
				{
					this.ProductTypeId = default(string);
				}
			}
			else
			{
				this.ProductTypeId = e.ProductTypeId;
			}

			if (e.PrimaryProductCategoryId == null)
			{
				if (e.IsPropertyPrimaryProductCategoryIdRemoved)
				{
					this.PrimaryProductCategoryId = default(string);
				}
			}
			else
			{
				this.PrimaryProductCategoryId = e.PrimaryProductCategoryId;
			}

			if (e.ManufacturerPartyId == null)
			{
				if (e.IsPropertyManufacturerPartyIdRemoved)
				{
					this.ManufacturerPartyId = default(string);
				}
			}
			else
			{
				this.ManufacturerPartyId = e.ManufacturerPartyId;
			}

			if (e.FacilityId == null)
			{
				if (e.IsPropertyFacilityIdRemoved)
				{
					this.FacilityId = default(string);
				}
			}
			else
			{
				this.FacilityId = e.FacilityId;
			}

			if (e.IntroductionDate == null)
			{
				if (e.IsPropertyIntroductionDateRemoved)
				{
					this.IntroductionDate = default(DateTime?);
				}
			}
			else
			{
				this.IntroductionDate = e.IntroductionDate;
			}

			if (e.ReleaseDate == null)
			{
				if (e.IsPropertyReleaseDateRemoved)
				{
					this.ReleaseDate = default(DateTime?);
				}
			}
			else
			{
				this.ReleaseDate = e.ReleaseDate;
			}

			if (e.SupportDiscontinuationDate == null)
			{
				if (e.IsPropertySupportDiscontinuationDateRemoved)
				{
					this.SupportDiscontinuationDate = default(DateTime?);
				}
			}
			else
			{
				this.SupportDiscontinuationDate = e.SupportDiscontinuationDate;
			}

			if (e.SalesDiscontinuationDate == null)
			{
				if (e.IsPropertySalesDiscontinuationDateRemoved)
				{
					this.SalesDiscontinuationDate = default(DateTime?);
				}
			}
			else
			{
				this.SalesDiscontinuationDate = e.SalesDiscontinuationDate;
			}

			if (e.SalesDiscWhenNotAvail == null)
			{
				if (e.IsPropertySalesDiscWhenNotAvailRemoved)
				{
					this.SalesDiscWhenNotAvail = default(string);
				}
			}
			else
			{
				this.SalesDiscWhenNotAvail = e.SalesDiscWhenNotAvail;
			}

			if (e.InternalName == null)
			{
				if (e.IsPropertyInternalNameRemoved)
				{
					this.InternalName = default(string);
				}
			}
			else
			{
				this.InternalName = e.InternalName;
			}

			if (e.BrandName == null)
			{
				if (e.IsPropertyBrandNameRemoved)
				{
					this.BrandName = default(string);
				}
			}
			else
			{
				this.BrandName = e.BrandName;
			}

			if (e.Comments == null)
			{
				if (e.IsPropertyCommentsRemoved)
				{
					this.Comments = default(string);
				}
			}
			else
			{
				this.Comments = e.Comments;
			}

			if (e.ProductName == null)
			{
				if (e.IsPropertyProductNameRemoved)
				{
					this.ProductName = default(string);
				}
			}
			else
			{
				this.ProductName = e.ProductName;
			}

			if (e.Description == null)
			{
				if (e.IsPropertyDescriptionRemoved)
				{
					this.Description = default(string);
				}
			}
			else
			{
				this.Description = e.Description;
			}

			if (e.PriceDetailText == null)
			{
				if (e.IsPropertyPriceDetailTextRemoved)
				{
					this.PriceDetailText = default(string);
				}
			}
			else
			{
				this.PriceDetailText = e.PriceDetailText;
			}

			if (e.SmallImageUrl == null)
			{
				if (e.IsPropertySmallImageUrlRemoved)
				{
					this.SmallImageUrl = default(string);
				}
			}
			else
			{
				this.SmallImageUrl = e.SmallImageUrl;
			}

			if (e.MediumImageUrl == null)
			{
				if (e.IsPropertyMediumImageUrlRemoved)
				{
					this.MediumImageUrl = default(string);
				}
			}
			else
			{
				this.MediumImageUrl = e.MediumImageUrl;
			}

			if (e.LargeImageUrl == null)
			{
				if (e.IsPropertyLargeImageUrlRemoved)
				{
					this.LargeImageUrl = default(string);
				}
			}
			else
			{
				this.LargeImageUrl = e.LargeImageUrl;
			}

			if (e.DetailImageUrl == null)
			{
				if (e.IsPropertyDetailImageUrlRemoved)
				{
					this.DetailImageUrl = default(string);
				}
			}
			else
			{
				this.DetailImageUrl = e.DetailImageUrl;
			}

			if (e.OriginalImageUrl == null)
			{
				if (e.IsPropertyOriginalImageUrlRemoved)
				{
					this.OriginalImageUrl = default(string);
				}
			}
			else
			{
				this.OriginalImageUrl = e.OriginalImageUrl;
			}

			if (e.DetailScreen == null)
			{
				if (e.IsPropertyDetailScreenRemoved)
				{
					this.DetailScreen = default(string);
				}
			}
			else
			{
				this.DetailScreen = e.DetailScreen;
			}

			if (e.InventoryMessage == null)
			{
				if (e.IsPropertyInventoryMessageRemoved)
				{
					this.InventoryMessage = default(string);
				}
			}
			else
			{
				this.InventoryMessage = e.InventoryMessage;
			}

			if (e.InventoryItemTypeId == null)
			{
				if (e.IsPropertyInventoryItemTypeIdRemoved)
				{
					this.InventoryItemTypeId = default(string);
				}
			}
			else
			{
				this.InventoryItemTypeId = e.InventoryItemTypeId;
			}

			if (e.RequireInventory == null)
			{
				if (e.IsPropertyRequireInventoryRemoved)
				{
					this.RequireInventory = default(string);
				}
			}
			else
			{
				this.RequireInventory = e.RequireInventory;
			}

			if (e.QuantityUomId == null)
			{
				if (e.IsPropertyQuantityUomIdRemoved)
				{
					this.QuantityUomId = default(string);
				}
			}
			else
			{
				this.QuantityUomId = e.QuantityUomId;
			}

			if (e.QuantityIncluded == null)
			{
				if (e.IsPropertyQuantityIncludedRemoved)
				{
					this.QuantityIncluded = default(decimal?);
				}
			}
			else
			{
				this.QuantityIncluded = e.QuantityIncluded;
			}

			if (e.PiecesIncluded == null)
			{
				if (e.IsPropertyPiecesIncludedRemoved)
				{
					this.PiecesIncluded = default(long?);
				}
			}
			else
			{
				this.PiecesIncluded = e.PiecesIncluded;
			}

			if (e.RequireAmount == null)
			{
				if (e.IsPropertyRequireAmountRemoved)
				{
					this.RequireAmount = default(string);
				}
			}
			else
			{
				this.RequireAmount = e.RequireAmount;
			}

			if (e.FixedAmount == null)
			{
				if (e.IsPropertyFixedAmountRemoved)
				{
					this.FixedAmount = default(decimal?);
				}
			}
			else
			{
				this.FixedAmount = e.FixedAmount;
			}

			if (e.AmountUomTypeId == null)
			{
				if (e.IsPropertyAmountUomTypeIdRemoved)
				{
					this.AmountUomTypeId = default(string);
				}
			}
			else
			{
				this.AmountUomTypeId = e.AmountUomTypeId;
			}

			if (e.WeightUomId == null)
			{
				if (e.IsPropertyWeightUomIdRemoved)
				{
					this.WeightUomId = default(string);
				}
			}
			else
			{
				this.WeightUomId = e.WeightUomId;
			}

			if (e.ShippingWeight == null)
			{
				if (e.IsPropertyShippingWeightRemoved)
				{
					this.ShippingWeight = default(decimal?);
				}
			}
			else
			{
				this.ShippingWeight = e.ShippingWeight;
			}

			if (e.ProductWeight == null)
			{
				if (e.IsPropertyProductWeightRemoved)
				{
					this.ProductWeight = default(decimal?);
				}
			}
			else
			{
				this.ProductWeight = e.ProductWeight;
			}

			if (e.HeightUomId == null)
			{
				if (e.IsPropertyHeightUomIdRemoved)
				{
					this.HeightUomId = default(string);
				}
			}
			else
			{
				this.HeightUomId = e.HeightUomId;
			}

			if (e.ProductHeight == null)
			{
				if (e.IsPropertyProductHeightRemoved)
				{
					this.ProductHeight = default(decimal?);
				}
			}
			else
			{
				this.ProductHeight = e.ProductHeight;
			}

			if (e.ShippingHeight == null)
			{
				if (e.IsPropertyShippingHeightRemoved)
				{
					this.ShippingHeight = default(decimal?);
				}
			}
			else
			{
				this.ShippingHeight = e.ShippingHeight;
			}

			if (e.WidthUomId == null)
			{
				if (e.IsPropertyWidthUomIdRemoved)
				{
					this.WidthUomId = default(string);
				}
			}
			else
			{
				this.WidthUomId = e.WidthUomId;
			}

			if (e.ProductWidth == null)
			{
				if (e.IsPropertyProductWidthRemoved)
				{
					this.ProductWidth = default(decimal?);
				}
			}
			else
			{
				this.ProductWidth = e.ProductWidth;
			}

			if (e.ShippingWidth == null)
			{
				if (e.IsPropertyShippingWidthRemoved)
				{
					this.ShippingWidth = default(decimal?);
				}
			}
			else
			{
				this.ShippingWidth = e.ShippingWidth;
			}

			if (e.DepthUomId == null)
			{
				if (e.IsPropertyDepthUomIdRemoved)
				{
					this.DepthUomId = default(string);
				}
			}
			else
			{
				this.DepthUomId = e.DepthUomId;
			}

			if (e.ProductDepth == null)
			{
				if (e.IsPropertyProductDepthRemoved)
				{
					this.ProductDepth = default(decimal?);
				}
			}
			else
			{
				this.ProductDepth = e.ProductDepth;
			}

			if (e.ShippingDepth == null)
			{
				if (e.IsPropertyShippingDepthRemoved)
				{
					this.ShippingDepth = default(decimal?);
				}
			}
			else
			{
				this.ShippingDepth = e.ShippingDepth;
			}

			if (e.DiameterUomId == null)
			{
				if (e.IsPropertyDiameterUomIdRemoved)
				{
					this.DiameterUomId = default(string);
				}
			}
			else
			{
				this.DiameterUomId = e.DiameterUomId;
			}

			if (e.ProductDiameter == null)
			{
				if (e.IsPropertyProductDiameterRemoved)
				{
					this.ProductDiameter = default(decimal?);
				}
			}
			else
			{
				this.ProductDiameter = e.ProductDiameter;
			}

			if (e.ProductRating == null)
			{
				if (e.IsPropertyProductRatingRemoved)
				{
					this.ProductRating = default(decimal?);
				}
			}
			else
			{
				this.ProductRating = e.ProductRating;
			}

			if (e.RatingTypeEnum == null)
			{
				if (e.IsPropertyRatingTypeEnumRemoved)
				{
					this.RatingTypeEnum = default(string);
				}
			}
			else
			{
				this.RatingTypeEnum = e.RatingTypeEnum;
			}

			if (e.Returnable == null)
			{
				if (e.IsPropertyReturnableRemoved)
				{
					this.Returnable = default(string);
				}
			}
			else
			{
				this.Returnable = e.Returnable;
			}

			if (e.Taxable == null)
			{
				if (e.IsPropertyTaxableRemoved)
				{
					this.Taxable = default(string);
				}
			}
			else
			{
				this.Taxable = e.Taxable;
			}

			if (e.ChargeShipping == null)
			{
				if (e.IsPropertyChargeShippingRemoved)
				{
					this.ChargeShipping = default(string);
				}
			}
			else
			{
				this.ChargeShipping = e.ChargeShipping;
			}

			if (e.AutoCreateKeywords == null)
			{
				if (e.IsPropertyAutoCreateKeywordsRemoved)
				{
					this.AutoCreateKeywords = default(string);
				}
			}
			else
			{
				this.AutoCreateKeywords = e.AutoCreateKeywords;
			}

			if (e.IncludeInPromotions == null)
			{
				if (e.IsPropertyIncludeInPromotionsRemoved)
				{
					this.IncludeInPromotions = default(string);
				}
			}
			else
			{
				this.IncludeInPromotions = e.IncludeInPromotions;
			}

			if (e.IsVirtual == null)
			{
				if (e.IsPropertyIsVirtualRemoved)
				{
					this.IsVirtual = default(string);
				}
			}
			else
			{
				this.IsVirtual = e.IsVirtual;
			}

			if (e.IsVariant == null)
			{
				if (e.IsPropertyIsVariantRemoved)
				{
					this.IsVariant = default(string);
				}
			}
			else
			{
				this.IsVariant = e.IsVariant;
			}

			if (e.VirtualVariantMethodEnum == null)
			{
				if (e.IsPropertyVirtualVariantMethodEnumRemoved)
				{
					this.VirtualVariantMethodEnum = default(string);
				}
			}
			else
			{
				this.VirtualVariantMethodEnum = e.VirtualVariantMethodEnum;
			}

			if (e.InShippingBox == null)
			{
				if (e.IsPropertyInShippingBoxRemoved)
				{
					this.InShippingBox = default(string);
				}
			}
			else
			{
				this.InShippingBox = e.InShippingBox;
			}

			if (e.DefaultShipmentBoxTypeId == null)
			{
				if (e.IsPropertyDefaultShipmentBoxTypeIdRemoved)
				{
					this.DefaultShipmentBoxTypeId = default(string);
				}
			}
			else
			{
				this.DefaultShipmentBoxTypeId = e.DefaultShipmentBoxTypeId;
			}

			if (e.IsSerialNumbered == null)
			{
				if (e.IsPropertyIsSerialNumberedRemoved)
				{
					this.IsSerialNumbered = default(bool);
				}
			}
			else
			{
				this.IsSerialNumbered = (e.IsSerialNumbered != null && e.IsSerialNumbered.HasValue) ? e.IsSerialNumbered.Value : default(bool);
			}

			if (e.IsManagedByLot == null)
			{
				if (e.IsPropertyIsManagedByLotRemoved)
				{
					this.IsManagedByLot = default(bool);
				}
			}
			else
			{
				this.IsManagedByLot = (e.IsManagedByLot != null && e.IsManagedByLot.HasValue) ? e.IsManagedByLot.Value : default(bool);
			}

			if (e.AttributeSetId == null)
			{
				if (e.IsPropertyAttributeSetIdRemoved)
				{
					this.AttributeSetId = default(string);
				}
			}
			else
			{
				this.AttributeSetId = e.AttributeSetId;
			}

			if (e.AttributeSetInstanceId == null)
			{
				if (e.IsPropertyAttributeSetInstanceIdRemoved)
				{
					this.AttributeSetInstanceId = default(string);
				}
			}
			else
			{
				this.AttributeSetInstanceId = e.AttributeSetInstanceId;
			}

			if (e.Active == null)
			{
				if (e.IsPropertyActiveRemoved)
				{
					this.Active = default(bool);
				}
			}
			else
			{
				this.Active = (e.Active != null && e.Active.HasValue) ? e.Active.Value : default(bool);
			}


			this.UpdatedBy = e.CreatedBy;
			this.UpdatedAt = e.CreatedAt;


			foreach (IGoodIdentificationEvent innerEvent in e.GoodIdentificationEvents)
            {
                IGoodIdentificationState innerState = this.GoodIdentifications.Get(innerEvent.GlobalId.GoodIdentificationTypeId);

                innerState.Mutate(innerEvent);
                var removed = innerEvent as IGoodIdentificationStateRemoved;
                if (removed != null)
                {
                    this.GoodIdentifications.Remove(innerState);
                }
          
            }

		}


		public virtual void Mutate(IEvent e)
		{
            StateReadOnly = false;
			((dynamic)this).When((dynamic)e);
		}

        protected void ThrowOnWrongEvent(IProductEvent e)
        {
            var id = new System.Text.StringBuilder(); 
            id.Append("[").Append("Product|");

            var stateEntityId = this.ProductId; // Aggregate Id
            var eventEntityId = e.ProductEventId.ProductId;
            if (stateEntityId != eventEntityId)
            {
                throw DomainError.Named("mutateWrongEntity", "Entity Id {0} in state but entity id {1} in event", stateEntityId, eventEntityId);
            }
            id.Append(stateEntityId).Append(",");

            id.Append("]");

            var stateVersion = this.Version;
            var eventVersion = e.ProductEventId.Version;
            if (stateVersion != eventVersion)
            {
                throw OptimisticConcurrencyException.Create(stateVersion, eventVersion, id.ToString());
            }
        }
    }

}

