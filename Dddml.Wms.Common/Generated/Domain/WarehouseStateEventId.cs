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

	public class WarehouseStateEventId
	{

		private string _warehouseId;

		public virtual string WarehouseId { 
			get { return this._warehouseId; } 
			internal set { _warehouseId = value; } 
		}

		private long _version;

		public virtual long Version { 
			get { return this._version; } 
			internal set { _version = value; } 
		}


        #region  Flattened Properties


        #endregion

		internal WarehouseStateEventId ()
		{
		}

		public WarehouseStateEventId (string warehouseId, long version)
		{
			this._warehouseId = warehouseId;
			this._version = version;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			WarehouseStateEventId other = obj as WarehouseStateEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.WarehouseId, other.WarehouseId)
				&& Object.Equals (this.Version, other.Version)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.WarehouseId != null) {
				hash += 13 * this.WarehouseId.GetHashCode ();
			}
			if (this.Version != null) {
				hash += 13 * this.Version.GetHashCode ();
			}
			return hash;
		}

	}

}


