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

	public class InventoryPRTriggeredEventId
	{

		private InventoryPRTriggeredId _inventoryPRTriggeredId = new InventoryPRTriggeredId();

		public virtual InventoryPRTriggeredId InventoryPRTriggeredId { 
			get { return this._inventoryPRTriggeredId; } 
			set { _inventoryPRTriggeredId = value; } 
		}

		private long _version;

		public virtual long Version { 
			get { return this._version; } 
			set { _version = value; } 
		}


        #region  Flattened Properties


		protected internal virtual string InventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId {
			get { return InventoryPRTriggeredId.SourceEntryId.InventoryItemId.ProductId; }
			set { InventoryPRTriggeredId.SourceEntryId.InventoryItemId.ProductId = value; }
		}

		protected internal virtual string InventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId {
			get { return InventoryPRTriggeredId.SourceEntryId.InventoryItemId.LocatorId; }
			set { InventoryPRTriggeredId.SourceEntryId.InventoryItemId.LocatorId = value; }
		}

		protected internal virtual string InventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId {
			get { return InventoryPRTriggeredId.SourceEntryId.InventoryItemId.AttributeSetInstanceId; }
			set { InventoryPRTriggeredId.SourceEntryId.InventoryItemId.AttributeSetInstanceId = value; }
		}

		protected internal virtual long InventoryPRTriggeredIdSourceEntryIdEntrySeqId {
			get { return InventoryPRTriggeredId.SourceEntryId.EntrySeqId; }
			set { InventoryPRTriggeredId.SourceEntryId.EntrySeqId = value; }
		}

		protected internal virtual string InventoryPRTriggeredIdInventoryPostingRuleId {
			get { return InventoryPRTriggeredId.InventoryPostingRuleId; }
			set { InventoryPRTriggeredId.InventoryPostingRuleId = value; }
		}

        #endregion

		public InventoryPRTriggeredEventId ()
		{
		}

		public InventoryPRTriggeredEventId (InventoryPRTriggeredId inventoryPRTriggeredId, long version)
		{
			this._inventoryPRTriggeredId = inventoryPRTriggeredId;
			this._version = version;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			InventoryPRTriggeredEventId other = obj as InventoryPRTriggeredEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.InventoryPRTriggeredId, other.InventoryPRTriggeredId)
				&& Object.Equals (this.Version, other.Version)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.InventoryPRTriggeredId != null) {
				hash += 13 * this.InventoryPRTriggeredId.GetHashCode ();
			}
			if (this.Version != null) {
				hash += 13 * this.Version.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(InventoryPRTriggeredEventId obj1, InventoryPRTriggeredEventId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(InventoryPRTriggeredEventId obj1, InventoryPRTriggeredEventId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

        public override string ToString()
        {
            return String.Empty
                + "InventoryPRTriggeredId: " + this.InventoryPRTriggeredId + ", "
                + "Version: " + this.Version + ", "
                ;
        }

        protected internal static readonly string[] FlattenedPropertyNames = new string[] { "InventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId", "InventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId", "InventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId", "InventoryPRTriggeredIdSourceEntryIdEntrySeqId", "InventoryPRTriggeredIdInventoryPostingRuleId", "Version" };

        protected internal static readonly Type[] FlattenedPropertyTypes = new Type[] { typeof(string), typeof(string), typeof(string), typeof(long), typeof(string), typeof(long) };

        protected internal static readonly IDictionary<string, Type> FlattenedPropertyTypeDictionary;

        static InventoryPRTriggeredEventId()
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


