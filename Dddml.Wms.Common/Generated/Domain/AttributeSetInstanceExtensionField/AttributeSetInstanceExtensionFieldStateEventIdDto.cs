﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAttributeSetInstanceExtensionFieldDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.AttributeSetInstanceExtensionField;

namespace Dddml.Wms.Domain.AttributeSetInstanceExtensionField
{

	public class AttributeSetInstanceExtensionFieldStateEventIdDto
	{

		public AttributeSetInstanceExtensionFieldStateEventIdDto()
		{
		}

        public virtual AttributeSetInstanceExtensionFieldStateEventId ToAttributeSetInstanceExtensionFieldStateEventId()
        {
            AttributeSetInstanceExtensionFieldStateEventId v = new AttributeSetInstanceExtensionFieldStateEventId();
            v.Name = this.Name;
            v.Version = this.Version;
            return v;
        }

		public virtual string Name { 
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

			AttributeSetInstanceExtensionFieldStateEventIdDto other = obj as AttributeSetInstanceExtensionFieldStateEventIdDto;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.Name, other.Name)
				&& Object.Equals (this.Version, other.Version)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.Name != null) {
				hash += 13 * this.Name.GetHashCode ();
			}
			if (this.Version != null) {
				hash += 13 * this.Version.GetHashCode ();
			}
			return hash;
		}

	}

}

