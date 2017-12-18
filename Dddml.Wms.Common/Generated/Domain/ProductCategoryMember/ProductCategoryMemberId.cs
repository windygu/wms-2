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

	public class ProductCategoryMemberId
	{

		private string _productCategoryId;

		public virtual string ProductCategoryId { 
			get { return this._productCategoryId; } 
			internal set { _productCategoryId = value; } 
		}

		private string _productId;

		public virtual string ProductId { 
			get { return this._productId; } 
			internal set { _productId = value; } 
		}


        #region  Flattened Properties


        #endregion

		internal ProductCategoryMemberId ()
		{
		}

		public ProductCategoryMemberId (string productCategoryId, string productId)
		{
			this._productCategoryId = productCategoryId;
			this._productId = productId;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			ProductCategoryMemberId other = obj as ProductCategoryMemberId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.ProductCategoryId, other.ProductCategoryId)
				&& Object.Equals (this.ProductId, other.ProductId)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.ProductCategoryId != null) {
				hash += 13 * this.ProductCategoryId.GetHashCode ();
			}
			if (this.ProductId != null) {
				hash += 13 * this.ProductId.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(ProductCategoryMemberId obj1, ProductCategoryMemberId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(ProductCategoryMemberId obj1, ProductCategoryMemberId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

	}

}


