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

	public class OrderItemShipGroupAssociationInfo
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

		private string _orderItemSeqId;

		public virtual string OrderItemSeqId { 
			get { return this._orderItemSeqId; } 
			set { _orderItemSeqId = value; } 
		}

		private string _productId;

		public virtual string ProductId { 
			get { return this._productId; } 
			set { _productId = value; } 
		}

		private decimal? _quantity;

		public virtual decimal? Quantity { 
			get { return this._quantity; } 
			set { _quantity = value; } 
		}

		private int _numberOfPackages;

		public virtual int NumberOfPackages { 
			get { return this._numberOfPackages; } 
			set { _numberOfPackages = value; } 
		}

		private int _numberOfContainers;

		public virtual int NumberOfContainers { 
			get { return this._numberOfContainers; } 
			set { _numberOfContainers = value; } 
		}

		private int _numberOfPakagesPerContainer;

		public virtual int NumberOfPakagesPerContainer { 
			get { return this._numberOfPakagesPerContainer; } 
			set { _numberOfPakagesPerContainer = value; } 
		}


        #region  Flattened Properties


        #endregion

		public OrderItemShipGroupAssociationInfo ()
		{
		}

		public OrderItemShipGroupAssociationInfo (string orderId, string shipGroupSeqId, string orderItemSeqId, string productId, decimal? quantity, int numberOfPackages, int numberOfContainers, int numberOfPakagesPerContainer)
		{
			this._orderId = orderId;
			this._shipGroupSeqId = shipGroupSeqId;
			this._orderItemSeqId = orderItemSeqId;
			this._productId = productId;
			this._quantity = quantity;
			this._numberOfPackages = numberOfPackages;
			this._numberOfContainers = numberOfContainers;
			this._numberOfPakagesPerContainer = numberOfPakagesPerContainer;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			OrderItemShipGroupAssociationInfo other = obj as OrderItemShipGroupAssociationInfo;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.OrderId, other.OrderId)
				&& Object.Equals (this.ShipGroupSeqId, other.ShipGroupSeqId)
				&& Object.Equals (this.OrderItemSeqId, other.OrderItemSeqId)
				&& Object.Equals (this.ProductId, other.ProductId)
				&& Object.Equals (this.Quantity, other.Quantity)
				&& Object.Equals (this.NumberOfPackages, other.NumberOfPackages)
				&& Object.Equals (this.NumberOfContainers, other.NumberOfContainers)
				&& Object.Equals (this.NumberOfPakagesPerContainer, other.NumberOfPakagesPerContainer)
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
			if (this.OrderItemSeqId != null) {
				hash += 13 * this.OrderItemSeqId.GetHashCode ();
			}
			if (this.ProductId != null) {
				hash += 13 * this.ProductId.GetHashCode ();
			}
			if (this.Quantity != null) {
				hash += 13 * this.Quantity.GetHashCode ();
			}
			if (this.NumberOfPackages != null) {
				hash += 13 * this.NumberOfPackages.GetHashCode ();
			}
			if (this.NumberOfContainers != null) {
				hash += 13 * this.NumberOfContainers.GetHashCode ();
			}
			if (this.NumberOfPakagesPerContainer != null) {
				hash += 13 * this.NumberOfPakagesPerContainer.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(OrderItemShipGroupAssociationInfo obj1, OrderItemShipGroupAssociationInfo obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(OrderItemShipGroupAssociationInfo obj1, OrderItemShipGroupAssociationInfo obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

        public override string ToString()
        {
            return String.Empty
                + "OrderId: " + this.OrderId + ", "
                + "ShipGroupSeqId: " + this.ShipGroupSeqId + ", "
                + "OrderItemSeqId: " + this.OrderItemSeqId + ", "
                + "ProductId: " + this.ProductId + ", "
                + "Quantity: " + this.Quantity + ", "
                + "NumberOfPackages: " + this.NumberOfPackages + ", "
                + "NumberOfContainers: " + this.NumberOfContainers + ", "
                + "NumberOfPakagesPerContainer: " + this.NumberOfPakagesPerContainer + ", "
                ;
        }
	}

}


