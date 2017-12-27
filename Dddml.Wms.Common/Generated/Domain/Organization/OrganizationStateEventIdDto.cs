﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrganizationDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Organization;

namespace Dddml.Wms.Domain.Organization
{

	public class OrganizationStateEventIdDto
	{

		public OrganizationStateEventIdDto()
		{
		}

        public virtual OrganizationStateEventId ToOrganizationStateEventId()
        {
            OrganizationStateEventId v = new OrganizationStateEventId();
            v.PartyId = this.PartyId;
            v.Version = this.Version;
            return v;
        }

		public virtual string PartyId { 
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

			OrganizationStateEventIdDto other = obj as OrganizationStateEventIdDto;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.PartyId, other.PartyId)
				&& Object.Equals (this.Version, other.Version)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.PartyId != null) {
				hash += 13 * this.PartyId.GetHashCode ();
			}
			if (this.Version != null) {
				hash += 13 * this.Version.GetHashCode ();
			}
			return hash;
		}

	}

}


