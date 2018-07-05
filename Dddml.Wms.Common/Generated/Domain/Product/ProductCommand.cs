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

	public abstract class ProductCommandBase : IProductCommand
	{
		public virtual string ProductId { get; set; }


		string IAggregateCommand<string, long>.AggregateId
		{
			get
			{
				return this.ProductId;
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

		public virtual bool? IsSerialNumbered { get; set; }

		public virtual bool? IsManagedByLot { get; set; }

		public virtual string AttributeSetId { get; set; }

		public virtual string AttributeSetInstanceId { get; set; }

		public virtual bool? Active { get; set; }


		// //////////////////////////////////////////////////

        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();


	}


	public class CreateProduct : ProductCommandBase, ICreateProduct
	{
		
		public CreateProduct ()
		{
		}


        private CreateGoodIdentificationCommands _goodIdentifications = new CreateGoodIdentificationCommands();

        public ICreateGoodIdentificationCommands GoodIdentifications
        {
            get
            {
                return this._goodIdentifications;
            }
        }

        public CreateGoodIdentification NewCreateGoodIdentification()
        {
            var c = new CreateGoodIdentification();
            c.ProductId = this.ProductId;

            return c;
        }

        ICreateGoodIdentification ICreateProduct.NewCreateGoodIdentification()
        {
            return this.NewCreateGoodIdentification();
        }



        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }
	}


	public class MergePatchProduct :ProductCommandBase, IMergePatchProduct
	{

		public virtual bool IsPropertyProductTypeIdRemoved { get; set; }

		public virtual bool IsPropertyPrimaryProductCategoryIdRemoved { get; set; }

		public virtual bool IsPropertyManufacturerPartyIdRemoved { get; set; }

		public virtual bool IsPropertyFacilityIdRemoved { get; set; }

		public virtual bool IsPropertyIntroductionDateRemoved { get; set; }

		public virtual bool IsPropertyReleaseDateRemoved { get; set; }

		public virtual bool IsPropertySupportDiscontinuationDateRemoved { get; set; }

		public virtual bool IsPropertySalesDiscontinuationDateRemoved { get; set; }

		public virtual bool IsPropertySalesDiscWhenNotAvailRemoved { get; set; }

		public virtual bool IsPropertyInternalNameRemoved { get; set; }

		public virtual bool IsPropertyBrandNameRemoved { get; set; }

		public virtual bool IsPropertyCommentsRemoved { get; set; }

		public virtual bool IsPropertyProductNameRemoved { get; set; }

		public virtual bool IsPropertyDescriptionRemoved { get; set; }

		public virtual bool IsPropertyPriceDetailTextRemoved { get; set; }

		public virtual bool IsPropertySmallImageUrlRemoved { get; set; }

		public virtual bool IsPropertyMediumImageUrlRemoved { get; set; }

		public virtual bool IsPropertyLargeImageUrlRemoved { get; set; }

		public virtual bool IsPropertyDetailImageUrlRemoved { get; set; }

		public virtual bool IsPropertyOriginalImageUrlRemoved { get; set; }

		public virtual bool IsPropertyDetailScreenRemoved { get; set; }

		public virtual bool IsPropertyInventoryMessageRemoved { get; set; }

		public virtual bool IsPropertyInventoryItemTypeIdRemoved { get; set; }

		public virtual bool IsPropertyRequireInventoryRemoved { get; set; }

		public virtual bool IsPropertyQuantityUomIdRemoved { get; set; }

		public virtual bool IsPropertyQuantityIncludedRemoved { get; set; }

		public virtual bool IsPropertyPiecesIncludedRemoved { get; set; }

		public virtual bool IsPropertyRequireAmountRemoved { get; set; }

		public virtual bool IsPropertyFixedAmountRemoved { get; set; }

		public virtual bool IsPropertyAmountUomTypeIdRemoved { get; set; }

		public virtual bool IsPropertyWeightUomIdRemoved { get; set; }

		public virtual bool IsPropertyShippingWeightRemoved { get; set; }

		public virtual bool IsPropertyProductWeightRemoved { get; set; }

		public virtual bool IsPropertyHeightUomIdRemoved { get; set; }

		public virtual bool IsPropertyProductHeightRemoved { get; set; }

		public virtual bool IsPropertyShippingHeightRemoved { get; set; }

		public virtual bool IsPropertyWidthUomIdRemoved { get; set; }

		public virtual bool IsPropertyProductWidthRemoved { get; set; }

		public virtual bool IsPropertyShippingWidthRemoved { get; set; }

		public virtual bool IsPropertyDepthUomIdRemoved { get; set; }

		public virtual bool IsPropertyProductDepthRemoved { get; set; }

		public virtual bool IsPropertyShippingDepthRemoved { get; set; }

		public virtual bool IsPropertyDiameterUomIdRemoved { get; set; }

		public virtual bool IsPropertyProductDiameterRemoved { get; set; }

		public virtual bool IsPropertyProductRatingRemoved { get; set; }

		public virtual bool IsPropertyRatingTypeEnumRemoved { get; set; }

		public virtual bool IsPropertyReturnableRemoved { get; set; }

		public virtual bool IsPropertyTaxableRemoved { get; set; }

		public virtual bool IsPropertyChargeShippingRemoved { get; set; }

		public virtual bool IsPropertyAutoCreateKeywordsRemoved { get; set; }

		public virtual bool IsPropertyIncludeInPromotionsRemoved { get; set; }

		public virtual bool IsPropertyIsVirtualRemoved { get; set; }

		public virtual bool IsPropertyIsVariantRemoved { get; set; }

		public virtual bool IsPropertyVirtualVariantMethodEnumRemoved { get; set; }

		public virtual bool IsPropertyInShippingBoxRemoved { get; set; }

		public virtual bool IsPropertyDefaultShipmentBoxTypeIdRemoved { get; set; }

		public virtual bool IsPropertyIsSerialNumberedRemoved { get; set; }

		public virtual bool IsPropertyIsManagedByLotRemoved { get; set; }

		public virtual bool IsPropertyAttributeSetIdRemoved { get; set; }

		public virtual bool IsPropertyAttributeSetInstanceIdRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public MergePatchProduct ()
		{
		}

        private GoodIdentificationCommands _goodIdentificationCommands = new GoodIdentificationCommands();

        public IGoodIdentificationCommands GoodIdentificationCommands
        {
            get
            {
                return this._goodIdentificationCommands;
            }
        }


        public CreateGoodIdentification NewCreateGoodIdentification()
        {
            var c = new CreateGoodIdentification();
            c.ProductId = this.ProductId;

            return c;
        }

        ICreateGoodIdentification IMergePatchProduct.NewCreateGoodIdentification()
        {
            return this.NewCreateGoodIdentification();
        }

        public MergePatchGoodIdentification NewMergePatchGoodIdentification()
        {
            var c = new MergePatchGoodIdentification();
            c.ProductId = this.ProductId;

            return c;
        }

        IMergePatchGoodIdentification IMergePatchProduct.NewMergePatchGoodIdentification()
        {
            return this.NewMergePatchGoodIdentification();
        }


        public RemoveGoodIdentification NewRemoveGoodIdentification()
        {
            var c = new RemoveGoodIdentification();
            c.ProductId = this.ProductId;

            return c;
        }

        IRemoveGoodIdentification IMergePatchProduct.NewRemoveGoodIdentification()
        {
            return this.NewRemoveGoodIdentification();
        }


        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class DeleteProduct : ProductCommandBase, IDeleteProduct
	{
		public DeleteProduct ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Delete;
        }

	}


    public class CreateGoodIdentificationCommands : ICreateGoodIdentificationCommands
    {
        private List<ICreateGoodIdentification> _innerCommands = new List<ICreateGoodIdentification>();

        public void Add(ICreateGoodIdentification c)
        {
            _innerCommands.Add(c);
        }

        public void Remove(ICreateGoodIdentification c)
        {
            _innerCommands.Remove(c);
        }

        public void Clear()
        {
            _innerCommands.Clear();
        }

        public IEnumerator<ICreateGoodIdentification> GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

    }

    public class GoodIdentificationCommands : IGoodIdentificationCommands
    {
        private List<IGoodIdentificationCommand> _innerCommands = new List<IGoodIdentificationCommand>();

        public void Add(IGoodIdentificationCommand c)
        {
            _innerCommands.Add(c);
        }

        public void Remove(IGoodIdentificationCommand c)
        {
            _innerCommands.Remove(c);
        }

        public void Clear()
        {
            _innerCommands.Clear();
        }

        public IEnumerator<IGoodIdentificationCommand> GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return _innerCommands.GetEnumerator();
        }

    }

    public static partial class ProductCommands
    {
    }

}
