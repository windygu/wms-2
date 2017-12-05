﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateSellableInventoryItemEntryMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.SellableInventoryItemEntryMvo;
using Dddml.Wms.Domain.SellableInventoryItem;
using Dddml.Wms.Domain.InventoryPRTriggered;

namespace Dddml.Wms.Domain.SellableInventoryItemEntryMvo
{

	public class SellableInventoryItemEntryMvoStateEventId
	{

		private SellableInventoryItemEntryId _sellableInventoryItemEntryId = new SellableInventoryItemEntryId();

		public virtual SellableInventoryItemEntryId SellableInventoryItemEntryId { 
			get { return this._sellableInventoryItemEntryId; } 
			internal set { _sellableInventoryItemEntryId = value; } 
		}

		private long _sellableInventoryItemVersion;

		public virtual long SellableInventoryItemVersion { 
			get { return this._sellableInventoryItemVersion; } 
			internal set { _sellableInventoryItemVersion = value; } 
		}


        #region  Flattened Properties


		public virtual string SellableInventoryItemEntryIdSellableInventoryItemIdProductId {
			get { return SellableInventoryItemEntryId.SellableInventoryItemId.ProductId; }
			internal set { SellableInventoryItemEntryId.SellableInventoryItemId.ProductId = value; }
		}

		public virtual string SellableInventoryItemEntryIdSellableInventoryItemIdLocatorId {
			get { return SellableInventoryItemEntryId.SellableInventoryItemId.LocatorId; }
			internal set { SellableInventoryItemEntryId.SellableInventoryItemId.LocatorId = value; }
		}

		public virtual string SellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId {
			get { return SellableInventoryItemEntryId.SellableInventoryItemId.AttributeSetInstanceId; }
			internal set { SellableInventoryItemEntryId.SellableInventoryItemId.AttributeSetInstanceId = value; }
		}

		public virtual long SellableInventoryItemEntryIdEntrySeqId {
			get { return SellableInventoryItemEntryId.EntrySeqId; }
			internal set { SellableInventoryItemEntryId.EntrySeqId = value; }
		}

        #endregion

		internal SellableInventoryItemEntryMvoStateEventId ()
		{
		}

		public SellableInventoryItemEntryMvoStateEventId (SellableInventoryItemEntryId sellableInventoryItemEntryId, long sellableInventoryItemVersion)
		{
			this._sellableInventoryItemEntryId = sellableInventoryItemEntryId;
			this._sellableInventoryItemVersion = sellableInventoryItemVersion;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			SellableInventoryItemEntryMvoStateEventId other = obj as SellableInventoryItemEntryMvoStateEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.SellableInventoryItemEntryId, other.SellableInventoryItemEntryId)
				&& Object.Equals (this.SellableInventoryItemVersion, other.SellableInventoryItemVersion)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.SellableInventoryItemEntryId != null) {
				hash += 13 * this.SellableInventoryItemEntryId.GetHashCode ();
			}
			if (this.SellableInventoryItemVersion != null) {
				hash += 13 * this.SellableInventoryItemVersion.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(SellableInventoryItemEntryMvoStateEventId obj1, SellableInventoryItemEntryMvoStateEventId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(SellableInventoryItemEntryMvoStateEventId obj1, SellableInventoryItemEntryMvoStateEventId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

	}

}

