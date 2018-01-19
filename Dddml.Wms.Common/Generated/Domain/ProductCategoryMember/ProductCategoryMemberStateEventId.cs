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

	public class ProductCategoryMemberStateEventId
	{

		private ProductCategoryMemberId _productCategoryMemberId = new ProductCategoryMemberId();

		public virtual ProductCategoryMemberId ProductCategoryMemberId { 
			get { return this._productCategoryMemberId; } 
			set { _productCategoryMemberId = value; } 
		}

		private long _version;

		public virtual long Version { 
			get { return this._version; } 
			set { _version = value; } 
		}


        #region  Flattened Properties


		public virtual string ProductCategoryMemberIdProductCategoryId {
			get { return ProductCategoryMemberId.ProductCategoryId; }
			set { ProductCategoryMemberId.ProductCategoryId = value; }
		}

		public virtual string ProductCategoryMemberIdProductId {
			get { return ProductCategoryMemberId.ProductId; }
			set { ProductCategoryMemberId.ProductId = value; }
		}

        #endregion

		public ProductCategoryMemberStateEventId ()
		{
		}

		public ProductCategoryMemberStateEventId (ProductCategoryMemberId productCategoryMemberId, long version)
		{
			this._productCategoryMemberId = productCategoryMemberId;
			this._version = version;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			ProductCategoryMemberStateEventId other = obj as ProductCategoryMemberStateEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.ProductCategoryMemberId, other.ProductCategoryMemberId)
				&& Object.Equals (this.Version, other.Version)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.ProductCategoryMemberId != null) {
				hash += 13 * this.ProductCategoryMemberId.GetHashCode ();
			}
			if (this.Version != null) {
				hash += 13 * this.Version.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(ProductCategoryMemberStateEventId obj1, ProductCategoryMemberStateEventId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(ProductCategoryMemberStateEventId obj1, ProductCategoryMemberStateEventId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

        public override string ToString()
        {
            return String.Empty
                + "ProductCategoryMemberId: " + this.ProductCategoryMemberId + ", "
                + "Version: " + this.Version + ", "
                ;
        }
	}

}


