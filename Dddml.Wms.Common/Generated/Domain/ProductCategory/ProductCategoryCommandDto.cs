﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateProductCategoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ProductCategory;

namespace Dddml.Wms.Domain.ProductCategory
{

	public abstract class ProductCategoryCommandDtoBase : ICommandDto, ICreateProductCategory, IMergePatchProductCategory, IDeleteProductCategory
	{

		string IAggregateCommand<string, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteProductCategory)this).ProductCategoryId;
			}
		}


		long IAggregateCommand<string, long>.AggregateVersion
		{
			get
			{
				return this.Version != null ? this.Version.Value : default(long);
			}
		}

        long IProductCategoryCommand.Version
        {
            get { return this.Version != null ? this.Version.Value : default(long); }
            set { this.Version = value; }
        }

		public virtual long? Version { get; set; }

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

		public virtual string ProductCategoryId { get; set; }

		public virtual string ProductCategoryTypeId { get; set; }

		public virtual string PrimaryParentCategoryId { get; set; }

		public virtual string CategoryName { get; set; }

		public virtual string Description { get; set; }

		public virtual string CategoryImageUrl { get; set; }

		public virtual string DetailScreen { get; set; }

		public virtual bool? ShowInSelect { get; set; }

		public virtual string AttributeSetId { get; set; }

		public virtual bool? Active { get; set; }

		public virtual bool? IsPropertyProductCategoryTypeIdRemoved { get; set; }

        bool IMergePatchProductCategory.IsPropertyProductCategoryTypeIdRemoved
        {
            get
            {
                var b = this.IsPropertyProductCategoryTypeIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyProductCategoryTypeIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyPrimaryParentCategoryIdRemoved { get; set; }

        bool IMergePatchProductCategory.IsPropertyPrimaryParentCategoryIdRemoved
        {
            get
            {
                var b = this.IsPropertyPrimaryParentCategoryIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyPrimaryParentCategoryIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyCategoryNameRemoved { get; set; }

        bool IMergePatchProductCategory.IsPropertyCategoryNameRemoved
        {
            get
            {
                var b = this.IsPropertyCategoryNameRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyCategoryNameRemoved = value;
            }
        }

		public virtual bool? IsPropertyDescriptionRemoved { get; set; }

        bool IMergePatchProductCategory.IsPropertyDescriptionRemoved
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

		public virtual bool? IsPropertyCategoryImageUrlRemoved { get; set; }

        bool IMergePatchProductCategory.IsPropertyCategoryImageUrlRemoved
        {
            get
            {
                var b = this.IsPropertyCategoryImageUrlRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyCategoryImageUrlRemoved = value;
            }
        }

		public virtual bool? IsPropertyDetailScreenRemoved { get; set; }

        bool IMergePatchProductCategory.IsPropertyDetailScreenRemoved
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

		public virtual bool? IsPropertyShowInSelectRemoved { get; set; }

        bool IMergePatchProductCategory.IsPropertyShowInSelectRemoved
        {
            get
            {
                var b = this.IsPropertyShowInSelectRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShowInSelectRemoved = value;
            }
        }

		public virtual bool? IsPropertyAttributeSetIdRemoved { get; set; }

        bool IMergePatchProductCategory.IsPropertyAttributeSetIdRemoved
        {
            get
            {
                var b = this.IsPropertyAttributeSetIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyAttributeSetIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchProductCategory.IsPropertyActiveRemoved
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


    public class CreateOrMergePatchOrDeleteProductCategoryDto : ProductCategoryCommandDtoBase
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



	public class CreateProductCategoryDto : CreateOrMergePatchOrDeleteProductCategoryDto
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


	public class MergePatchProductCategoryDto : CreateOrMergePatchOrDeleteProductCategoryDto
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

	public class DeleteProductCategoryDto : CreateOrMergePatchOrDeleteProductCategoryDto
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

    public static partial class ProductCategoryCommandDtos
    {

    }

}

