﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateSellableInventoryItemDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.SellableInventoryItem;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.InventoryPRTriggered;

namespace Dddml.Wms.Domain.SellableInventoryItem
{

	public class SellableInventoryItemStateEventIdDtoWrapper : SellableInventoryItemStateEventIdDto
	{

        private SellableInventoryItemStateEventId _value = new SellableInventoryItemStateEventId();

		public SellableInventoryItemStateEventIdDtoWrapper()
		{
		}

		public SellableInventoryItemStateEventIdDtoWrapper(SellableInventoryItemStateEventId val)
		{
			if (val == null) { throw new ArgumentNullException("val"); }
			this._value = val;
		}

        public override SellableInventoryItemStateEventId ToSellableInventoryItemStateEventId()
        {
            return this._value;
        }

		public override InventoryItemIdDto SellableInventoryItemId { 
			get { return new InventoryItemIdDtoWrapper(_value.SellableInventoryItemId); } 
			set { _value.SellableInventoryItemId = value.ToInventoryItemId(); } 
		}

		public override long Version { 
			get { return _value.Version; } 
			set { _value.Version = value; } 
		}


	}

}

