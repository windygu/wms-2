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

	public abstract class ProductCategoryMemberStateProperties : IProductCategoryMemberStateProperties
	{
		public virtual ProductCategoryMemberId ProductCategoryMemberId { get; set; }

		public virtual DateTime? ThruDate { get; set; }

		public virtual string Comments { get; set; }

		public virtual long? SequenceNum { get; set; }

		public virtual decimal? Quantity { get; set; }

		public virtual long Version { get; set; }

		public virtual bool Active { get; set; }

        protected virtual void InitializeProperties()
        { 
        }

	}
}
