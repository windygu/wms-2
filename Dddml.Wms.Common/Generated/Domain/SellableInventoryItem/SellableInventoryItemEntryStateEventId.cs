﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateSellableInventoryItemDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.SellableInventoryItem;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.InventoryPRTriggered;

namespace Dddml.Wms.Domain.SellableInventoryItem
{

	public class SellableInventoryItemEntryStateEventId
	{

		private InventoryItemId _sellableInventoryItemId = new InventoryItemId();

		public virtual InventoryItemId SellableInventoryItemId { 
			get { return this._sellableInventoryItemId; } 
			internal set { _sellableInventoryItemId = value; } 
		}

		private long _entrySeqId;

		public virtual long EntrySeqId { 
			get { return this._entrySeqId; } 
			internal set { _entrySeqId = value; } 
		}

		private long _sellableInventoryItemVersion;

		public virtual long SellableInventoryItemVersion { 
			get { return this._sellableInventoryItemVersion; } 
			internal set { _sellableInventoryItemVersion = value; } 
		}


        #region  Flattened Properties


		public virtual string SellableInventoryItemIdProductId {
			get { return SellableInventoryItemId.ProductId; }
			internal set { SellableInventoryItemId.ProductId = value; }
		}

		public virtual string SellableInventoryItemIdLocatorId {
			get { return SellableInventoryItemId.LocatorId; }
			internal set { SellableInventoryItemId.LocatorId = value; }
		}

		public virtual string SellableInventoryItemIdAttributeSetInstanceId {
			get { return SellableInventoryItemId.AttributeSetInstanceId; }
			internal set { SellableInventoryItemId.AttributeSetInstanceId = value; }
		}

        #endregion

		internal SellableInventoryItemEntryStateEventId ()
		{
		}

		public SellableInventoryItemEntryStateEventId (InventoryItemId sellableInventoryItemId, long entrySeqId, long sellableInventoryItemVersion)
		{
			this._sellableInventoryItemId = sellableInventoryItemId;
			this._entrySeqId = entrySeqId;
			this._sellableInventoryItemVersion = sellableInventoryItemVersion;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			SellableInventoryItemEntryStateEventId other = obj as SellableInventoryItemEntryStateEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.SellableInventoryItemId, other.SellableInventoryItemId)
				&& Object.Equals (this.EntrySeqId, other.EntrySeqId)
				&& Object.Equals (this.SellableInventoryItemVersion, other.SellableInventoryItemVersion)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.SellableInventoryItemId != null) {
				hash += 13 * this.SellableInventoryItemId.GetHashCode ();
			}
			if (this.EntrySeqId != null) {
				hash += 13 * this.EntrySeqId.GetHashCode ();
			}
			if (this.SellableInventoryItemVersion != null) {
				hash += 13 * this.SellableInventoryItemVersion.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(SellableInventoryItemEntryStateEventId obj1, SellableInventoryItemEntryStateEventId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(SellableInventoryItemEntryStateEventId obj1, SellableInventoryItemEntryStateEventId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

	}

}

