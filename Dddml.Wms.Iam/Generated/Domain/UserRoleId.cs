﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.User;

namespace Dddml.Wms.Domain.User
{

	public class UserRoleId
	{

		private string _userId;

		public virtual string UserId { 
			get { return this._userId; } 
			set { _userId = value; } 
		}

		private string _roleId;

		public virtual string RoleId { 
			get { return this._roleId; } 
			set { _roleId = value; } 
		}


        #region  Flattened Properties


        #endregion

		public UserRoleId ()
		{
		}

		public UserRoleId (string userId, string roleId)
		{
			this._userId = userId;
			this._roleId = roleId;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			UserRoleId other = obj as UserRoleId;
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

        public static bool operator ==(UserRoleId obj1, UserRoleId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(UserRoleId obj1, UserRoleId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

        public override string ToString()
        {
            return String.Empty
                + "UserId: " + this.UserId + ", "
                + "RoleId: " + this.RoleId + ", "
                ;
        }
	}

}


