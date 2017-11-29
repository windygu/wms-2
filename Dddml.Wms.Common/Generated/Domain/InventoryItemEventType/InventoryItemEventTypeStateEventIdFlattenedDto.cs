﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemEventTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItemEventType;

namespace Dddml.Wms.Domain.InventoryItemEventType
{

	public class InventoryItemEventTypeStateEventIdFlattenedDto : IIdFlattenedDto
	{

        private static string[] _flattenedPropertyNames = new string[] { "InventoryItemEventTypeId", "Version" };

        string[] IIdFlattenedDto.FieldNames
        {
            get { return _flattenedPropertyNames; }
        }

        object IIdFlattenedDto.GetFieldValue(string fieldName)
        {
            return ReflectUtils.GetPropertyValue(fieldName, this._value);
        }

        void IIdFlattenedDto.SetFieldValue(string fieldName, object fieldValue)
        {
            ReflectUtils.SetPropertyValue(fieldName, this._value, fieldValue);
        }

        Type IIdFlattenedDto.GetFieldType(string fieldName)
        {
            if (fieldName.Equals("InventoryItemEventTypeId", StringComparison.InvariantCultureIgnoreCase))
            {
                return typeof(string);
            }

            if (fieldName.Equals("Version", StringComparison.InvariantCultureIgnoreCase))
            {
                return typeof(long);
            }

            throw new ArgumentException(String.Format("Unknown fileName: {0}", fieldName));
        }


        private InventoryItemEventTypeStateEventIdDto _value = new InventoryItemEventTypeStateEventIdDto();

		public InventoryItemEventTypeStateEventIdFlattenedDto()
		{
		}

		public InventoryItemEventTypeStateEventIdFlattenedDto(InventoryItemEventTypeStateEventIdDto val)
		{
			this._value = val;
		}

        public InventoryItemEventTypeStateEventIdDto ToInventoryItemEventTypeStateEventIdDto()
        {
            return this._value;
        }

		public InventoryItemEventTypeStateEventIdFlattenedDto(InventoryItemEventTypeStateEventId val)
		{
			this._value = new InventoryItemEventTypeStateEventIdDtoWrapper(val);
		}

        public InventoryItemEventTypeStateEventId ToInventoryItemEventTypeStateEventId()
        {
            return this._value.ToInventoryItemEventTypeStateEventId();
        }

		public virtual string InventoryItemEventTypeId { 
			get { return _value.InventoryItemEventTypeId; } 
			set { _value.InventoryItemEventTypeId = value; } 
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

			InventoryItemEventTypeStateEventIdFlattenedDto other = obj as InventoryItemEventTypeStateEventIdFlattenedDto;
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

    public class InventoryItemEventTypeStateEventIdFlattenedDtoFormatter : IdFlattenedDtoFormatterBase<InventoryItemEventTypeStateEventIdFlattenedDto>
    {

    }

}

