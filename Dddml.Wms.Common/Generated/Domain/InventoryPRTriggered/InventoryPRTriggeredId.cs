﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryPRTriggeredDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryPRTriggered;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryPRTriggered
{

	public class InventoryPRTriggeredId
	{

		private InventoryItemEntryId _sourceEntryId = new InventoryItemEntryId();

		public virtual InventoryItemEntryId SourceEntryId { 
			get { return this._sourceEntryId; } 
			internal set { _sourceEntryId = value; } 
		}

		private string _inventoryPostingRuleId;

		public virtual string InventoryPostingRuleId { 
			get { return this._inventoryPostingRuleId; } 
			internal set { _inventoryPostingRuleId = value; } 
		}


        #region  Flattened Properties


		public virtual string SourceEntryIdInventoryItemIdProductId {
			get { return SourceEntryId.InventoryItemId.ProductId; }
			internal set { SourceEntryId.InventoryItemId.ProductId = value; }
		}

		public virtual string SourceEntryIdInventoryItemIdLocatorId {
			get { return SourceEntryId.InventoryItemId.LocatorId; }
			internal set { SourceEntryId.InventoryItemId.LocatorId = value; }
		}

		public virtual string SourceEntryIdInventoryItemIdAttributeSetInstanceId {
			get { return SourceEntryId.InventoryItemId.AttributeSetInstanceId; }
			internal set { SourceEntryId.InventoryItemId.AttributeSetInstanceId = value; }
		}

		public virtual long SourceEntryIdEntrySeqId {
			get { return SourceEntryId.EntrySeqId; }
			internal set { SourceEntryId.EntrySeqId = value; }
		}

        #endregion

		internal InventoryPRTriggeredId ()
		{
		}

		public InventoryPRTriggeredId (InventoryItemEntryId sourceEntryId, string inventoryPostingRuleId)
		{
			this._sourceEntryId = sourceEntryId;
			this._inventoryPostingRuleId = inventoryPostingRuleId;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			InventoryPRTriggeredId other = obj as InventoryPRTriggeredId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.SourceEntryId, other.SourceEntryId)
				&& Object.Equals (this.InventoryPostingRuleId, other.InventoryPostingRuleId)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.SourceEntryId != null) {
				hash += 13 * this.SourceEntryId.GetHashCode ();
			}
			if (this.InventoryPostingRuleId != null) {
				hash += 13 * this.InventoryPostingRuleId.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(InventoryPRTriggeredId obj1, InventoryPRTriggeredId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(InventoryPRTriggeredId obj1, InventoryPRTriggeredId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

	}

}


