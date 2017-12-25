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

	public class PhysicalInventoryLineStateEventIdDto
	{

		public PhysicalInventoryLineStateEventIdDto()
		{
		}

        public virtual PhysicalInventoryLineStateEventId ToPhysicalInventoryLineStateEventId()
        {
            PhysicalInventoryLineStateEventId v = new PhysicalInventoryLineStateEventId();
            v.PhysicalInventoryDocumentNumber = this.PhysicalInventoryDocumentNumber;
            v.LineNumber = this.LineNumber;
            v.PhysicalInventoryVersion = this.PhysicalInventoryVersion;
            return v;
        }

		public virtual string PhysicalInventoryDocumentNumber { 
			get;
			set;
		}

		public virtual string LineNumber { 
			get;
			set;
		}

		public virtual long PhysicalInventoryVersion { 
			get;
			set;
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			PhysicalInventoryLineStateEventIdDto other = obj as PhysicalInventoryLineStateEventIdDto;
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

	}

}


