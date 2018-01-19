﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.RolePermission;

namespace Dddml.Wms.Domain.RolePermission
{

	public class RolePermissionStateEventId
	{

		private RolePermissionId _id = new RolePermissionId();

		public virtual RolePermissionId Id { 
			get { return this._id; } 
			set { _id = value; } 
		}

		private long _version;

		public virtual long Version { 
			get { return this._version; } 
			set { _version = value; } 
		}


        #region  Flattened Properties


		public virtual string IdRoleId {
			get { return Id.RoleId; }
			set { Id.RoleId = value; }
		}

		public virtual string IdPermissionId {
			get { return Id.PermissionId; }
			set { Id.PermissionId = value; }
		}

        #endregion

		public RolePermissionStateEventId ()
		{
		}

		public RolePermissionStateEventId (RolePermissionId id, long version)
		{
			this._id = id;
			this._version = version;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			RolePermissionStateEventId other = obj as RolePermissionStateEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.Id, other.Id)
				&& Object.Equals (this.Version, other.Version)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.Id != null) {
				hash += 13 * this.Id.GetHashCode ();
			}
			if (this.Version != null) {
				hash += 13 * this.Version.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(RolePermissionStateEventId obj1, RolePermissionStateEventId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(RolePermissionStateEventId obj1, RolePermissionStateEventId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

        public override string ToString()
        {
            return String.Empty
                + "Id: " + this.Id + ", "
                + "Version: " + this.Version + ", "
                ;
        }
	}

}


