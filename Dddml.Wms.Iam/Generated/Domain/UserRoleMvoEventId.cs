﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.UserRoleMvo;
using Dddml.Wms.Domain.User;

namespace Dddml.Wms.Domain.UserRoleMvo
{

	public class UserRoleMvoEventId
	{

		private UserRoleId _userRoleId = new UserRoleId();

		public virtual UserRoleId UserRoleId { 
			get { return this._userRoleId; } 
			set { _userRoleId = value; } 
		}

		private long _userVersion;

		public virtual long UserVersion { 
			get { return this._userVersion; } 
			set { _userVersion = value; } 
		}


        #region  Flattened Properties


		protected internal virtual string UserRoleIdUserId {
			get { return UserRoleId.UserId; }
			set { UserRoleId.UserId = value; }
		}

		protected internal virtual string UserRoleIdRoleId {
			get { return UserRoleId.RoleId; }
			set { UserRoleId.RoleId = value; }
		}

        #endregion

		public UserRoleMvoEventId ()
		{
		}

		public UserRoleMvoEventId (UserRoleId userRoleId, long userVersion)
		{
			this._userRoleId = userRoleId;
			this._userVersion = userVersion;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			UserRoleMvoEventId other = obj as UserRoleMvoEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.UserRoleId, other.UserRoleId)
				&& Object.Equals (this.UserVersion, other.UserVersion)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.UserRoleId != null) {
				hash += 13 * this.UserRoleId.GetHashCode ();
			}
			if (this.UserVersion != null) {
				hash += 13 * this.UserVersion.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(UserRoleMvoEventId obj1, UserRoleMvoEventId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(UserRoleMvoEventId obj1, UserRoleMvoEventId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

        public override string ToString()
        {
            return String.Empty
                + "UserRoleId: " + this.UserRoleId + ", "
                + "UserVersion: " + this.UserVersion + ", "
                ;
        }

        protected internal static readonly string[] FlattenedPropertyNames = new string[] { "UserRoleIdUserId", "UserRoleIdRoleId", "UserVersion" };

        protected internal static readonly Type[] FlattenedPropertyTypes = new Type[] { typeof(string), typeof(string), typeof(long) };

        protected internal static readonly IDictionary<string, Type> FlattenedPropertyTypeDictionary;

        static UserRoleMvoEventId()
        {
            var dict = new Dictionary<string, Type>();
            for (int i = 0; i < FlattenedPropertyNames.Length; i++)
            {
                dict.Add(FlattenedPropertyNames[i], FlattenedPropertyTypes[i]);
            }
            FlattenedPropertyTypeDictionary = dict;
        }

        protected internal void ForEachFlattenedProperty(Action<string, object> act)
        {
            for (int i = 0; i < FlattenedPropertyNames.Length; i++)
            {
                string pn = FlattenedPropertyNames[i];
                if (Char.IsLower(pn[0])) { pn = Char.ToUpper(pn[0]) + pn.Substring(1); }
                var m = this.GetType().GetProperty(pn, System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance);
                object pv = m.GetValue(this);
                act(pn, pv);
            }
        }

        protected internal void SetFlattenedPropertyValues(params object[] values)
        {
            for (int i = 0; i < FlattenedPropertyNames.Length; i++)
            {
                string pn = FlattenedPropertyNames[i];
                if (Char.IsLower(pn[0])) { pn = Char.ToUpper(pn[0]) + pn.Substring(1); }
                var v = values[i];
                var m = this.GetType().GetProperty(pn, System.Reflection.BindingFlags.Public | System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance);
                m.SetValue(this, v);
            }
        }
	}

}


