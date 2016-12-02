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

	public class UserRoleIdDto
	{

		public UserRoleIdDto()
		{
		}

        public virtual UserRoleId ToUserRoleId()
        {
            UserRoleId v = new UserRoleId();
            v.UserId = this.UserId;
            v.RoleId = this.RoleId;
            return v;
        }

		public virtual string UserId { 
			get;
			set;
		}

		public virtual string RoleId { 
			get;
			set;
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			UserRoleIdDto other = obj as UserRoleIdDto;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.UserId, other.UserId)
				&& Object.Equals (this.RoleId, other.RoleId)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.UserId != null) {
				hash += 13 * this.UserId.GetHashCode ();
			}
			if (this.RoleId != null) {
				hash += 13 * this.RoleId.GetHashCode ();
			}
			return hash;
		}

	}

}


