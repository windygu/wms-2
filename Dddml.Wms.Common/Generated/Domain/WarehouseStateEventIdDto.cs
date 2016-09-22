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

	public class WarehouseStateEventIdDto
	{

        private WarehouseStateEventId _value = new WarehouseStateEventId();

		public WarehouseStateEventIdDto()
		{
		}

		public WarehouseStateEventIdDto(WarehouseStateEventId val)
		{
			if (val == null) { throw new ArgumentNullException("val"); }
			this._value = val;
		}

        public WarehouseStateEventId ToWarehouseStateEventId()
        {
            return this._value;
        }

		public virtual string WarehouseId { 
			get { return _value.WarehouseId; } 
			set { _value.WarehouseId = value; } 
		}

		public virtual long Version { 
			get { return _value.Version; } 
			set { _value.Version = value; } 
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			WarehouseStateEventIdDto other = obj as WarehouseStateEventIdDto;
			if (other == null) {
				return false;
			}

            return _value.Equals(other._value);

		}

		public override int GetHashCode ()
		{
			return _value.GetHashCode();
		}

	}

}


