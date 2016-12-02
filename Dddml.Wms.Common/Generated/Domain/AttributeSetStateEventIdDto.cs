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

	public class AttributeSetStateEventIdDto
	{

		public AttributeSetStateEventIdDto()
		{
		}

        public virtual AttributeSetStateEventId ToAttributeSetStateEventId()
        {
            AttributeSetStateEventId v = new AttributeSetStateEventId();
            v.AttributeSetId = this.AttributeSetId;
            v.Version = this.Version;
            return v;
        }

		public virtual string AttributeSetId { 
			get;
			set;
		}

		public virtual long Version { 
			get;
			set;
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			AttributeSetStateEventIdDto other = obj as AttributeSetStateEventIdDto;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.AttributeSetId, other.AttributeSetId)
				&& Object.Equals (this.Version, other.Version)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.AttributeSetId != null) {
				hash += 13 * this.AttributeSetId.GetHashCode ();
			}
			if (this.Version != null) {
				hash += 13 * this.Version.GetHashCode ();
			}
			return hash;
		}

	}

}


