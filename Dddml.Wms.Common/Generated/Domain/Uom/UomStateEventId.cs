﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateUomDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Uom;

namespace Dddml.Wms.Domain.Uom
{

	public class UomStateEventId
	{

		private string _uomId;

		public virtual string UomId { 
			get { return this._uomId; } 
			set { _uomId = value; } 
		}

		private long _version;

		public virtual long Version { 
			get { return this._version; } 
			set { _version = value; } 
		}


        #region  Flattened Properties


        #endregion

		public UomStateEventId ()
		{
		}

		public UomStateEventId (string uomId, long version)
		{
			this._uomId = uomId;
			this._version = version;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			UomStateEventId other = obj as UomStateEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.UomId, other.UomId)
				&& Object.Equals (this.Version, other.Version)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.UomId != null) {
				hash += 13 * this.UomId.GetHashCode ();
			}
			if (this.Version != null) {
				hash += 13 * this.Version.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(UomStateEventId obj1, UomStateEventId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(UomStateEventId obj1, UomStateEventId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

        public override string ToString()
        {
            return String.Empty
                + "UomId: " + this.UomId + ", "
                + "Version: " + this.Version + ", "
                ;
        }
	}

}


