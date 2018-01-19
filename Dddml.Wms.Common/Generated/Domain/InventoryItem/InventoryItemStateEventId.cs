﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryItem
{

	public class InventoryItemStateEventId
	{

		private InventoryItemId _inventoryItemId = new InventoryItemId();

		public virtual InventoryItemId InventoryItemId { 
			get { return this._inventoryItemId; } 
			set { _inventoryItemId = value; } 
		}

		private long _version;

		public virtual long Version { 
			get { return this._version; } 
			set { _version = value; } 
		}


        #region  Flattened Properties


		public virtual string InventoryItemIdProductId {
			get { return InventoryItemId.ProductId; }
			set { InventoryItemId.ProductId = value; }
		}

		public virtual string InventoryItemIdLocatorId {
			get { return InventoryItemId.LocatorId; }
			set { InventoryItemId.LocatorId = value; }
		}

		public virtual string InventoryItemIdAttributeSetInstanceId {
			get { return InventoryItemId.AttributeSetInstanceId; }
			set { InventoryItemId.AttributeSetInstanceId = value; }
		}

        #endregion

		public InventoryItemStateEventId ()
		{
		}

		public InventoryItemStateEventId (InventoryItemId inventoryItemId, long version)
		{
			this._inventoryItemId = inventoryItemId;
			this._version = version;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			InventoryItemStateEventId other = obj as InventoryItemStateEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.InventoryItemId, other.InventoryItemId)
				&& Object.Equals (this.Version, other.Version)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.InventoryItemId != null) {
				hash += 13 * this.InventoryItemId.GetHashCode ();
			}
			if (this.Version != null) {
				hash += 13 * this.Version.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(InventoryItemStateEventId obj1, InventoryItemStateEventId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(InventoryItemStateEventId obj1, InventoryItemStateEventId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

        public override string ToString()
        {
            return String.Empty
                + "InventoryItemId: " + this.InventoryItemId + ", "
                + "Version: " + this.Version + ", "
                ;
        }
	}

}


