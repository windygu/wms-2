﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainServices.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain.Services
{

	public class OrderIdShipGroupSeqIdPair
	{

		private string _orderId;

		public virtual string OrderId { 
			get { return this._orderId; } 
			set { _orderId = value; } 
		}

		private string _shipGroupSeqId;

		public virtual string ShipGroupSeqId { 
			get { return this._shipGroupSeqId; } 
			set { _shipGroupSeqId = value; } 
		}


        #region  Flattened Properties


        #endregion

		public OrderIdShipGroupSeqIdPair ()
		{
		}

		public OrderIdShipGroupSeqIdPair (string orderId, string shipGroupSeqId)
		{
			this._orderId = orderId;
			this._shipGroupSeqId = shipGroupSeqId;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			OrderIdShipGroupSeqIdPair other = obj as OrderIdShipGroupSeqIdPair;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.OrderId, other.OrderId)
				&& Object.Equals (this.ShipGroupSeqId, other.ShipGroupSeqId)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.OrderId != null) {
				hash += 13 * this.OrderId.GetHashCode ();
			}
			if (this.ShipGroupSeqId != null) {
				hash += 13 * this.ShipGroupSeqId.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(OrderIdShipGroupSeqIdPair obj1, OrderIdShipGroupSeqIdPair obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(OrderIdShipGroupSeqIdPair obj1, OrderIdShipGroupSeqIdPair obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

        public override string ToString()
        {
            return String.Empty
                + "OrderId: " + this.OrderId + ", "
                + "ShipGroupSeqId: " + this.ShipGroupSeqId + ", "
                ;
        }
	}

}

