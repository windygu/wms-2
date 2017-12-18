﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Order;

namespace Dddml.Wms.Domain.Order
{

	public class OrderItemStateEventIdDto
	{

		public OrderItemStateEventIdDto()
		{
		}

        public virtual OrderItemStateEventId ToOrderItemStateEventId()
        {
            OrderItemStateEventId v = new OrderItemStateEventId();
            v.OrderId = this.OrderId;
            v.OrderItemSeqId = this.OrderItemSeqId;
            v.OrderVersion = this.OrderVersion;
            return v;
        }

		public virtual string OrderId { 
			get;
			set;
		}

		public virtual string OrderItemSeqId { 
			get;
			set;
		}

		public virtual long OrderVersion { 
			get;
			set;
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			OrderItemStateEventIdDto other = obj as OrderItemStateEventIdDto;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.OrderId, other.OrderId)
				&& Object.Equals (this.OrderItemSeqId, other.OrderItemSeqId)
				&& Object.Equals (this.OrderVersion, other.OrderVersion)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.OrderId != null) {
				hash += 13 * this.OrderId.GetHashCode ();
			}
			if (this.OrderItemSeqId != null) {
				hash += 13 * this.OrderItemSeqId.GetHashCode ();
			}
			if (this.OrderVersion != null) {
				hash += 13 * this.OrderVersion.GetHashCode ();
			}
			return hash;
		}

	}

}


