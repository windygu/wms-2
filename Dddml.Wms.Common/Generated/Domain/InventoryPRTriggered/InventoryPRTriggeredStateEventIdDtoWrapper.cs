﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryPRTriggeredDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryPRTriggered;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryPRTriggered
{

	public class InventoryPRTriggeredStateEventIdDtoWrapper : InventoryPRTriggeredStateEventIdDto
	{

        private InventoryPRTriggeredStateEventId _value = new InventoryPRTriggeredStateEventId();

		public InventoryPRTriggeredStateEventIdDtoWrapper()
		{
		}

		public InventoryPRTriggeredStateEventIdDtoWrapper(InventoryPRTriggeredStateEventId val)
		{
			if (val == null) { throw new ArgumentNullException("val"); }
			this._value = val;
		}

        public override InventoryPRTriggeredStateEventId ToInventoryPRTriggeredStateEventId()
        {
            return this._value;
        }

		public override InventoryPRTriggeredIdDto InventoryPRTriggeredId { 
			get { return new InventoryPRTriggeredIdDtoWrapper(_value.InventoryPRTriggeredId); } 
			set { _value.InventoryPRTriggeredId = value.ToInventoryPRTriggeredId(); } 
		}

		public override long Version { 
			get { return _value.Version; } 
			set { _value.Version = value; } 
		}


	}

}


