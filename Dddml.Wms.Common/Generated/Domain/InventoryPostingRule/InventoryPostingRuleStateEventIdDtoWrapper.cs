﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryPostingRuleDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryPostingRule;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryPostingRule
{

	public class InventoryPostingRuleStateEventIdDtoWrapper : InventoryPostingRuleStateEventIdDto
	{

        private InventoryPostingRuleStateEventId _value = new InventoryPostingRuleStateEventId();

		public InventoryPostingRuleStateEventIdDtoWrapper()
		{
		}

		public InventoryPostingRuleStateEventIdDtoWrapper(InventoryPostingRuleStateEventId val)
		{
			if (val == null) { throw new ArgumentNullException("val"); }
			this._value = val;
		}

        public override InventoryPostingRuleStateEventId ToInventoryPostingRuleStateEventId()
        {
            return this._value;
        }

		public override string InventoryPostingRuleId { 
			get { return _value.InventoryPostingRuleId; } 
			set { _value.InventoryPostingRuleId = value; } 
		}

		public override long Version { 
			get { return _value.Version; } 
			set { _value.Version = value; } 
		}


	}

}


