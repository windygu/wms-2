﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateProductCategoryMemberDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ProductCategoryMember;

namespace Dddml.Wms.Domain.ProductCategoryMember
{

	public abstract class ProductCategoryMemberCommandBase : IProductCategoryMemberCommand
	{
		public virtual ProductCategoryMemberId ProductCategoryMemberId { get; set; }


		ProductCategoryMemberId IAggregateCommand<ProductCategoryMemberId, long>.AggregateId
		{
			get
			{
				return this.ProductCategoryMemberId;
			}
		}


		long IAggregateCommand<ProductCategoryMemberId, long>.AggregateVersion
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

		public virtual DateTime? ThruDate { get; set; }

		public virtual string Comments { get; set; }

		public virtual long? SequenceNum { get; set; }

		public virtual decimal? Quantity { get; set; }

		public virtual bool? Active { get; set; }


		// //////////////////////////////////////////////////

        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();


	}


	public class CreateProductCategoryMember : ProductCategoryMemberCommandBase, ICreateProductCategoryMember
	{
		
		public CreateProductCategoryMember ()
		{
		}


        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }
	}


	public class MergePatchProductCategoryMember :ProductCategoryMemberCommandBase, IMergePatchProductCategoryMember
	{

		public virtual bool IsPropertyThruDateRemoved { get; set; }

		public virtual bool IsPropertyCommentsRemoved { get; set; }

		public virtual bool IsPropertySequenceNumRemoved { get; set; }

		public virtual bool IsPropertyQuantityRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public MergePatchProductCategoryMember ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class DeleteProductCategoryMember : ProductCategoryMemberCommandBase, IDeleteProductCategoryMember
	{
		public DeleteProductCategoryMember ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Delete;
        }

	}

    public static partial class ProductCategoryMemberCommands
    {
    }

}
