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

	public class UserPermissionMvoStateEventIdDto
	{

        private UserPermissionMvoStateEventId _value = new UserPermissionMvoStateEventId();

		public UserPermissionMvoStateEventIdDto()
		{
		}

		public UserPermissionMvoStateEventIdDto(UserPermissionMvoStateEventId val)
		{
			if (val == null) { throw new ArgumentNullException("val"); }
			this._value = val;
		}

        public UserPermissionMvoStateEventId ToUserPermissionMvoStateEventId()
        {
            return this._value;
        }

		public virtual UserPermissionIdDto UserPermissionId { 
			get { return new UserPermissionIdDto(_value.UserPermissionId); } 
			set { _value.UserPermissionId = value.ToUserPermissionId(); } 
		}

		public virtual long UserVersion { 
			get { return _value.UserVersion; } 
			set { _value.UserVersion = value; } 
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			UserPermissionMvoStateEventIdDto other = obj as UserPermissionMvoStateEventIdDto;
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


