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

	public class AttributeUseStateEventIdDto
	{

        private AttributeUseStateEventId _value = new AttributeUseStateEventId();

		public AttributeUseStateEventIdDto()
		{
		}

		public AttributeUseStateEventIdDto(AttributeUseStateEventId val)
		{
			if (val == null) { throw new ArgumentNullException("val"); }
			this._value = val;
		}

        public AttributeUseStateEventId ToAttributeUseStateEventId()
        {
            return this._value;
        }

		public virtual string AttributeSetId { 
			get { return _value.AttributeSetId; } 
			set { _value.AttributeSetId = value; } 
		}

		public virtual string AttributeId { 
			get { return _value.AttributeId; } 
			set { _value.AttributeId = value; } 
		}

		public virtual long AttributeSetVersion { 
			get { return _value.AttributeSetVersion; } 
			set { _value.AttributeSetVersion = value; } 
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			AttributeUseStateEventIdDto other = obj as AttributeUseStateEventIdDto;
			if (other == null) {
				return false;
			}

            return _value.Equals(other._value);

		}

		public override int GetHashCode ()
		{
			return _value.GetHashCode();
		}

	}

}


