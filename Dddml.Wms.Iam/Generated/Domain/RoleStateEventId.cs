﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Role;

namespace Dddml.Wms.Domain.Role
{

	public class RoleStateEventId
	{

		private string _roleId;

		public virtual string RoleId { 
			get { return this._roleId; } 
			set { _roleId = value; } 
		}

		private long _version;

		public virtual long Version { 
			get { return this._version; } 
			set { _version = value; } 
		}


        #region  Flattened Properties


        #endregion

		public RoleStateEventId ()
		{
		}

		public RoleStateEventId (string roleId, long version)
		{
			this._roleId = roleId;
			this._version = version;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			RoleStateEventId other = obj as RoleStateEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.RoleId, other.RoleId)
				&& Object.Equals (this.Version, other.Version)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.RoleId != null) {
				hash += 13 * this.RoleId.GetHashCode ();
			}
			if (this.Version != null) {
				hash += 13 * this.Version.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(RoleStateEventId obj1, RoleStateEventId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(RoleStateEventId obj1, RoleStateEventId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

        public override string ToString()
        {
            return String.Empty
                + "RoleId: " + this.RoleId + ", "
                + "Version: " + this.Version + ", "
                ;
        }
	}

}


