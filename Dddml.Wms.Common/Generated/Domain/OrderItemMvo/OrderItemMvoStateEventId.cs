﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderItemMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.OrderItemMvo;
using Dddml.Wms.Domain.Order;

namespace Dddml.Wms.Domain.OrderItemMvo
{

	public class OrderItemMvoStateEventId
	{

		private OrderItemId _orderItemId = new OrderItemId();

		public virtual OrderItemId OrderItemId { 
			get { return this._orderItemId; } 
			internal set { _orderItemId = value; } 
		}

		private long _orderVersion;

		public virtual long OrderVersion { 
			get { return this._orderVersion; } 
			internal set { _orderVersion = value; } 
		}


        #region  Flattened Properties


		public virtual string OrderItemIdOrderId {
			get { return OrderItemId.OrderId; }
			internal set { OrderItemId.OrderId = value; }
		}

		public virtual string OrderItemIdOrderItemSeqId {
			get { return OrderItemId.OrderItemSeqId; }
			internal set { OrderItemId.OrderItemSeqId = value; }
		}

        #endregion

		internal OrderItemMvoStateEventId ()
		{
		}

		public OrderItemMvoStateEventId (OrderItemId orderItemId, long orderVersion)
		{
			this._orderItemId = orderItemId;
			this._orderVersion = orderVersion;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			OrderItemMvoStateEventId other = obj as OrderItemMvoStateEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.OrderItemId, other.OrderItemId)
				&& Object.Equals (this.OrderVersion, other.OrderVersion)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.OrderItemId != null) {
				hash += 13 * this.OrderItemId.GetHashCode ();
			}
			if (this.OrderVersion != null) {
				hash += 13 * this.OrderVersion.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(OrderItemMvoStateEventId obj1, OrderItemMvoStateEventId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(OrderItemMvoStateEventId obj1, OrderItemMvoStateEventId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

	}

}

