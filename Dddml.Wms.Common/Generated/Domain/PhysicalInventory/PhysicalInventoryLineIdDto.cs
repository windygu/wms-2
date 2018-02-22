﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.PhysicalInventory
{

	public class PhysicalInventoryLineIdDto
	{

		public PhysicalInventoryLineIdDto()
		{
		}

        public virtual PhysicalInventoryLineId ToPhysicalInventoryLineId()
        {
            PhysicalInventoryLineId v = new PhysicalInventoryLineId();
            v.PhysicalInventoryDocumentNumber = this.PhysicalInventoryDocumentNumber;
            v.InventoryItemId = this.InventoryItemId.ToInventoryItemId();
            return v;
        }

		public virtual string PhysicalInventoryDocumentNumber { 
			get;
			set;
		}

		private InventoryItemIdDto _inventoryItemId = new InventoryItemIdDto();

		public virtual InventoryItemIdDto InventoryItemId { 
			get { return this._inventoryItemId; } 
			set { this._inventoryItemId = value; } 
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			PhysicalInventoryLineIdDto other = obj as PhysicalInventoryLineIdDto;
			if (other == null) {
				return false;
			}

			return true 
				&& Object.Equals (this.PhysicalInventoryDocumentNumber, other.PhysicalInventoryDocumentNumber)
				&& Object.Equals (this.InventoryItemId, other.InventoryItemId)
				;
		}

		public override int GetHashCode ()
		{
			int hash = 0;
			if (this.PhysicalInventoryDocumentNumber != null) {
				hash += 13 * this.PhysicalInventoryDocumentNumber.GetHashCode ();
			}
			if (this.InventoryItemId != null) {
				hash += 13 * this.InventoryItemId.GetHashCode ();
			}
			return hash;
		}

	}

}


