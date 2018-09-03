﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePicklistBinDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PicklistBin;

namespace Dddml.Wms.Domain.PicklistBin
{

	public class PicklistItemEventId
	{

		private string _picklistBinId;

		public virtual string PicklistBinId { 
			get { return this._picklistBinId; } 
			set { _picklistBinId = value; } 
		}

		private PicklistItemOrderShipGrpInvId _picklistItemOrderShipGrpInvId = new PicklistItemOrderShipGrpInvId();

		public virtual PicklistItemOrderShipGrpInvId PicklistItemOrderShipGrpInvId { 
			get { return this._picklistItemOrderShipGrpInvId; } 
			set { _picklistItemOrderShipGrpInvId = value; } 
		}

		private long _picklistBinVersion;

		public virtual long PicklistBinVersion { 
			get { return this._picklistBinVersion; } 
			set { _picklistBinVersion = value; } 
		}


        #region  Flattened Properties


		protected internal virtual string PicklistItemOrderShipGrpInvIdOrderId {
			get { return PicklistItemOrderShipGrpInvId.OrderId; }
			set { PicklistItemOrderShipGrpInvId.OrderId = value; }
		}

		protected internal virtual string PicklistItemOrderShipGrpInvIdOrderItemSeqId {
			get { return PicklistItemOrderShipGrpInvId.OrderItemSeqId; }
			set { PicklistItemOrderShipGrpInvId.OrderItemSeqId = value; }
		}

		protected internal virtual string PicklistItemOrderShipGrpInvIdShipGroupSeqId {
			get { return PicklistItemOrderShipGrpInvId.ShipGroupSeqId; }
			set { PicklistItemOrderShipGrpInvId.ShipGroupSeqId = value; }
		}

		protected internal virtual string PicklistItemOrderShipGrpInvIdProductId {
			get { return PicklistItemOrderShipGrpInvId.ProductId; }
			set { PicklistItemOrderShipGrpInvId.ProductId = value; }
		}

		protected internal virtual string PicklistItemOrderShipGrpInvIdLocatorId {
			get { return PicklistItemOrderShipGrpInvId.LocatorId; }
			set { PicklistItemOrderShipGrpInvId.LocatorId = value; }
		}

		protected internal virtual string PicklistItemOrderShipGrpInvIdAttributeSetInstanceId {
			get { return PicklistItemOrderShipGrpInvId.AttributeSetInstanceId; }
			set { PicklistItemOrderShipGrpInvId.AttributeSetInstanceId = value; }
		}

        #endregion

		public PicklistItemEventId ()
		{
		}

		public PicklistItemEventId (string picklistBinId, PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId, long picklistBinVersion)
		{
			this._picklistBinId = picklistBinId;
			this._picklistItemOrderShipGrpInvId = picklistItemOrderShipGrpInvId;
			this._picklistBinVersion = picklistBinVersion;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			PicklistItemEventId other = obj as PicklistItemEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.PicklistBinId, other.PicklistBinId)
				&& Object.Equals (this.PicklistItemOrderShipGrpInvId, other.PicklistItemOrderShipGrpInvId)
				&& Object.Equals (this.PicklistBinVersion, other.PicklistBinVersion)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.PicklistBinId != null) {
				hash += 13 * this.PicklistBinId.GetHashCode ();
			}
			if (this.PicklistItemOrderShipGrpInvId != null) {
				hash += 13 * this.PicklistItemOrderShipGrpInvId.GetHashCode ();
			}
			if (this.PicklistBinVersion != null) {
				hash += 13 * this.PicklistBinVersion.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(PicklistItemEventId obj1, PicklistItemEventId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(PicklistItemEventId obj1, PicklistItemEventId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

        public override string ToString()
        {
            return String.Empty
                + "PicklistBinId: " + this.PicklistBinId + ", "
                + "PicklistItemOrderShipGrpInvId: " + this.PicklistItemOrderShipGrpInvId + ", "
                + "PicklistBinVersion: " + this.PicklistBinVersion + ", "
                ;
        }

        protected internal static readonly string[] FlattenedPropertyNames = new string[] { "PicklistBinId", "PicklistItemOrderShipGrpInvIdOrderId", "PicklistItemOrderShipGrpInvIdOrderItemSeqId", "PicklistItemOrderShipGrpInvIdShipGroupSeqId", "PicklistItemOrderShipGrpInvIdProductId", "PicklistItemOrderShipGrpInvIdLocatorId", "PicklistItemOrderShipGrpInvIdAttributeSetInstanceId", "PicklistBinVersion" };

        protected internal static readonly Type[] FlattenedPropertyTypes = new Type[] { typeof(string), typeof(string), typeof(string), typeof(string), typeof(string), typeof(string), typeof(string), typeof(long) };

        protected internal static readonly IDictionary<string, Type> FlattenedPropertyTypeDictionary;

        static PicklistItemEventId()
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


