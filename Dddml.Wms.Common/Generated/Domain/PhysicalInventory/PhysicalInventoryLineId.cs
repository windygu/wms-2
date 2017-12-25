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

	public class PhysicalInventoryLineId
	{

		private string _physicalInventoryDocumentNumber;

		public virtual string PhysicalInventoryDocumentNumber { 
			get { return this._physicalInventoryDocumentNumber; } 
			internal set { _physicalInventoryDocumentNumber = value; } 
		}

		private string _lineNumber;

		public virtual string LineNumber { 
			get { return this._lineNumber; } 
			internal set { _lineNumber = value; } 
		}


        #region  Flattened Properties


        #endregion

		internal PhysicalInventoryLineId ()
		{
		}

		public PhysicalInventoryLineId (string physicalInventoryDocumentNumber, string lineNumber)
		{
			this._physicalInventoryDocumentNumber = physicalInventoryDocumentNumber;
			this._lineNumber = lineNumber;

		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			PhysicalInventoryLineId other = obj as PhysicalInventoryLineId;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.PhysicalInventoryDocumentNumber, other.PhysicalInventoryDocumentNumber)
				&& Object.Equals (this.LineNumber, other.LineNumber)
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
			return hash;
		}

        public static bool operator ==(PhysicalInventoryLineId obj1, PhysicalInventoryLineId obj2)
        {
            return Object.Equals(obj1, obj2);
        }

        public static bool operator !=(PhysicalInventoryLineId obj1, PhysicalInventoryLineId obj2)
        {
            return !Object.Equals(obj1, obj2);
        }

	}

}


