﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;

namespace Dddml.Wms.Domain.PhysicalInventory
{

	public class PhysicalInventoryLineStateEventId
	{

		private string _physicalInventoryDocumentNumber;

		public virtual string PhysicalInventoryDocumentNumber { 
			get { return this._physicalInventoryDocumentNumber; } 
			set { _physicalInventoryDocumentNumber = value; } 
		}

		private string _lineNumber;

		public virtual string LineNumber { 
			get { return this._lineNumber; } 
			set { _lineNumber = value; } 
		}

		private long _physicalInventoryVersion;

		public virtual long PhysicalInventoryVersion { 
			get { return this._physicalInventoryVersion; } 
			set { _physicalInventoryVersion = value; } 
		}


        #region  Flattened Properties


        #endregion

		public PhysicalInventoryLineStateEventId ()
		{
		}

		public PhysicalInventoryLineStateEventId (string physicalInventoryDocumentNumber, string lineNumber, long physicalInventoryVersion)
		{
			this._physicalInventoryDocumentNumber = physicalInventoryDocumentNumber;
			this._lineNumber = lineNumber;
			this._physicalInventoryVersion = physicalInventoryVersion;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			PhysicalInventoryLineStateEventId other = obj as PhysicalInventoryLineStateEventId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.PhysicalInventoryDocumentNumber, other.PhysicalInventoryDocumentNumber)
				&& Object.Equals (this.LineNumber, other.LineNumber)
				&& Object.Equals (this.PhysicalInventoryVersion, other.PhysicalInventoryVersion)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.PhysicalInventoryDocumentNumber != null) {
				hash += 13 * this.PhysicalInventoryDocumentNumber.GetHashCode ();
			}
			if (this.LineNumber != null) {
				hash += 13 * this.LineNumber.GetHashCode ();
			}
			if (this.PhysicalInventoryVersion != null) {
				hash += 13 * this.PhysicalInventoryVersion.GetHashCode ();
			}
			return hash;
		}

        public static bool operator ==(PhysicalInventoryLineStateEventId obj1, PhysicalInventoryLineStateEventId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(PhysicalInventoryLineStateEventId obj1, PhysicalInventoryLineStateEventId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

        public override string ToString()
        {
            return String.Empty
                + "PhysicalInventoryDocumentNumber: " + this.PhysicalInventoryDocumentNumber + ", "
                + "LineNumber: " + this.LineNumber + ", "
                + "PhysicalInventoryVersion: " + this.PhysicalInventoryVersion + ", "
                ;
        }
	}

}


