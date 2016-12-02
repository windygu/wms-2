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

	public class OrganizationStructureStateEventId
	{

		private OrganizationStructureId _id = new OrganizationStructureId();

		public virtual OrganizationStructureId Id { 
			get { return this._id; } 
			internal set { _id = value; } 
		}

		private long _version;

		public virtual long Version { 
			get { return this._version; } 
			internal set { _version = value; } 
		}


        #region  Flattened Properties


		public virtual string IdOrganizationStructureTypeId {
			get { return Id.OrganizationStructureTypeId; }
			internal set { Id.OrganizationStructureTypeId = value; }
		}

		public virtual string IdParentId {
			get { return Id.ParentId; }
			internal set { Id.ParentId = value; }
		}

		public virtual string IdSubsidiaryId {
			get { return Id.SubsidiaryId; }
			internal set { Id.SubsidiaryId = value; }
		}

        #endregion

		internal OrganizationStructureStateEventId ()
		{
		}

		public OrganizationStructureStateEventId (OrganizationStructureId id, long version)
		{
			this._id = id;
			this._version = version;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			OrganizationStructureStateEventId other = obj as OrganizationStructureStateEventId;
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

        public static bool operator ==(OrganizationStructureStateEventId obj1, OrganizationStructureStateEventId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(OrganizationStructureStateEventId obj1, OrganizationStructureStateEventId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

	}

}


