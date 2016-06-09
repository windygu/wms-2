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

	public class OrganizationStateEventId
	{

		private string _organizationId;

		public virtual string OrganizationId { 
			get { return this._organizationId; } 
			internal set { _organizationId = value; } 
		}

		private long _version;

		public virtual long Version { 
			get { return this._version; } 
			internal set { _version = value; } 
		}


        #region  Flattened Properties


        #endregion

		internal OrganizationStateEventId ()
		{
		}

		public OrganizationStateEventId (string organizationId, long version)
		{
			this._organizationId = organizationId;
			this._version = version;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			OrganizationStateEventId other = obj as OrganizationStateEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.OrganizationId, other.OrganizationId)
				&& Object.Equals (this.Version, other.Version)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.OrganizationId != null) {
				hash += 13 * this.OrganizationId.GetHashCode ();
			}
			if (this.Version != null) {
				hash += 13 * this.Version.GetHashCode ();
			}
			return hash;
		}

	}

}

