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

	public class AttributeStateEventIdDto
	{

		public AttributeStateEventIdDto()
		{
		}

        public virtual AttributeStateEventId ToAttributeStateEventId()
        {
            AttributeStateEventId v = new AttributeStateEventId();
            v.AttributeId = this.AttributeId;
            v.Version = this.Version;
            return v;
        }

		public virtual string AttributeId { 
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

			AttributeStateEventIdDto other = obj as AttributeStateEventIdDto;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.AttributeId, other.AttributeId)
				&& Object.Equals (this.Version, other.Version)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.AttributeId != null) {
				hash += 13 * this.AttributeId.GetHashCode ();
			}
			if (this.Version != null) {
				hash += 13 * this.Version.GetHashCode ();
			}
			return hash;
		}

	}

}


