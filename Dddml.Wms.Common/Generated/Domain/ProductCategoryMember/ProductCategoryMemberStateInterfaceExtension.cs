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

	public static partial class ProductCategoryMemberStateInterfaceExtension
	{

        public static IProductCategoryMemberCommand ToCreateOrMergePatchProductCategoryMember<TCreateProductCategoryMember, TMergePatchProductCategoryMember>(this IProductCategoryMemberState state)
            where TCreateProductCategoryMember : ICreateProductCategoryMember, new()
            where TMergePatchProductCategoryMember : IMergePatchProductCategoryMember, new()
        {
            bool bUnsaved = ((IProductCategoryMemberState)state).IsUnsaved;
            if (bUnsaved)
            {
                return state.ToCreateProductCategoryMember<TCreateProductCategoryMember>();
            }
            else 
            {
                return state.ToMergePatchProductCategoryMember<TMergePatchProductCategoryMember>();
            }
        }

        public static TDeleteProductCategoryMember ToDeleteProductCategoryMember<TDeleteProductCategoryMember>(this IProductCategoryMemberState state)
            where TDeleteProductCategoryMember : IDeleteProductCategoryMember, new()
        {
            var cmd = new TDeleteProductCategoryMember();
            cmd.ProductCategoryMemberId = state.ProductCategoryMemberId;
            cmd.Version = ((IProductCategoryMemberStateProperties)state).Version;

            return cmd;
        }

        public static TMergePatchProductCategoryMember ToMergePatchProductCategoryMember<TMergePatchProductCategoryMember>(this IProductCategoryMemberState state)
            where TMergePatchProductCategoryMember : IMergePatchProductCategoryMember, new()
        {
            var cmd = new TMergePatchProductCategoryMember();

            cmd.Version = ((IProductCategoryMemberStateProperties)state).Version;

            cmd.ProductCategoryMemberId = state.ProductCategoryMemberId;
            cmd.ThruDate = state.ThruDate;
            cmd.Comments = state.Comments;
            cmd.SequenceNum = state.SequenceNum;
            cmd.Quantity = state.Quantity;
            cmd.Active = ((IProductCategoryMemberStateProperties)state).Active;
            
            if (state.ThruDate == null) { cmd.IsPropertyThruDateRemoved = true; }
            if (state.Comments == null) { cmd.IsPropertyCommentsRemoved = true; }
            if (state.SequenceNum == null) { cmd.IsPropertySequenceNumRemoved = true; }
            if (state.Quantity == null) { cmd.IsPropertyQuantityRemoved = true; }
            return cmd;
        }

        public static TCreateProductCategoryMember ToCreateProductCategoryMember<TCreateProductCategoryMember>(this IProductCategoryMemberState state)
            where TCreateProductCategoryMember : ICreateProductCategoryMember, new()
        {
            var cmd = new TCreateProductCategoryMember();

            cmd.Version = ((IProductCategoryMemberStateProperties)state).Version;

            cmd.ProductCategoryMemberId = state.ProductCategoryMemberId;
            cmd.ThruDate = state.ThruDate;
            cmd.Comments = state.Comments;
            cmd.SequenceNum = state.SequenceNum;
            cmd.Quantity = state.Quantity;
            cmd.Active = ((IProductCategoryMemberStateProperties)state).Active;
            return cmd;
        }
		

	}

}

