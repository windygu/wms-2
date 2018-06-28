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

	public class ProductGoodIdentificationId
	{

		private string _productId;

		public virtual string ProductId { 
			get { return this._productId; } 
			set { _productId = value; } 
		}

		private string _goodIdentificationTypeId;

		public virtual string GoodIdentificationTypeId { 
			get { return this._goodIdentificationTypeId; } 
			set { _goodIdentificationTypeId = value; } 
		}


        #region  Flattened Properties


        #endregion

		public ProductGoodIdentificationId ()
		{
		}

		public ProductGoodIdentificationId (string productId, string goodIdentificationTypeId)
		{
			this._productId = productId;
			this._goodIdentificationTypeId = goodIdentificationTypeId;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			ProductGoodIdentificationId other = obj as ProductGoodIdentificationId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.ProductId, other.ProductId)
				&& Object.Equals (this.GoodIdentificationTypeId, other.GoodIdentificationTypeId)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.ProductId != null) {
				hash += 13 * this.ProductId.GetHashCode ();
			}
			if (this.GoodIdentificationTypeId != null) {
				hash += 13 * this.GoodIdentificationTypeId.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(ProductGoodIdentificationId obj1, ProductGoodIdentificationId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(ProductGoodIdentificationId obj1, ProductGoodIdentificationId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

        public override string ToString()
        {
            return String.Empty
                + "ProductId: " + this.ProductId + ", "
                + "GoodIdentificationTypeId: " + this.GoodIdentificationTypeId + ", "
                ;
        }

        protected internal static readonly string[] FlattenedPropertyNames = new string[] { "ProductId", "GoodIdentificationTypeId" };

        protected internal static readonly Type[] FlattenedPropertyTypes = new Type[] { typeof(string), typeof(string) };

        protected internal static readonly IDictionary<string, Type> FlattenedPropertyTypeDictionary;

        static ProductGoodIdentificationId()
        {
            var dict = new Dictionary<string, Type>();
            for (int i = 0; i < FlattenedPropertyNames.Length; i++)
            {
                dict.Add(FlattenedPropertyNames[i], FlattenedPropertyTypes[i]);
            }
            FlattenedPropertyTypeDictionary = dict;
        }

        protected internal void ForEachFlattenedProperty(Action<string, object> act)
        {
            for (int i = 0; i < FlattenedPropertyNames.Length; i++)
            {
                string pn = FlattenedPropertyNames[i];
                if (Char.IsLower(pn[0])) { pn = Char.ToUpper(pn[0]) + pn.Substring(1); }
                var m = this.GetType().GetProperty(pn, System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance);
                object pv = m.GetValue(this);
                act(pn, pv);
            }
        }

        protected internal void SetFlattenedPropertyValues(params object[] values)
        {
            for (int i = 0; i < FlattenedPropertyNames.Length; i++)
            {
                string pn = FlattenedPropertyNames[i];
                if (Char.IsLower(pn[0])) { pn = Char.ToUpper(pn[0]) + pn.Substring(1); }
                var v = values[i];
                var m = this.GetType().GetProperty(pn, System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance);
                m.SetValue(this, v);
            }
        }
	}

}

