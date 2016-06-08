﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain
{

	public class AttributeValueMvoStateEventId
	{

		private AttributeValueId _attributeValueId = new AttributeValueId();

		public virtual AttributeValueId AttributeValueId { 
			get { return this._attributeValueId; } 
			internal set { _attributeValueId = value; } 
		}

		private long _attributeVersion;

		public virtual long AttributeVersion { 
			get { return this._attributeVersion; } 
			internal set { _attributeVersion = value; } 
		}


        #region  Flattened Properties


		public virtual string AttributeValueIdAttributeId {
			get { return AttributeValueId.AttributeId; }
			internal set { AttributeValueId.AttributeId = value; }
		}

		public virtual string AttributeValueIdValue {
			get { return AttributeValueId.Value; }
			internal set { AttributeValueId.Value = value; }
		}

        #endregion

		internal AttributeValueMvoStateEventId ()
		{
		}

		public AttributeValueMvoStateEventId (AttributeValueId attributeValueId, long attributeVersion)
		{
			this._attributeValueId = attributeValueId;
			this._attributeVersion = attributeVersion;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			AttributeValueMvoStateEventId other = obj as AttributeValueMvoStateEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.AttributeValueId, other.AttributeValueId)
				&& Object.Equals (this.AttributeVersion, other.AttributeVersion)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.AttributeValueId != null) {
				hash += 13 * this.AttributeValueId.GetHashCode ();
			}
			if (this.AttributeVersion != null) {
				hash += 13 * this.AttributeVersion.GetHashCode ();
			}
			return hash;
		}

	}

}


