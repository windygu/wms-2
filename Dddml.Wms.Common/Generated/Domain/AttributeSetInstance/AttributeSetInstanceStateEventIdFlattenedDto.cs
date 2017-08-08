﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAttributeSetInstanceDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.AttributeSetInstance;

namespace Dddml.Wms.Domain.AttributeSetInstance
{

	public class AttributeSetInstanceStateEventIdFlattenedDto : IIdFlattenedDto
	{

        private static string[] _flattenedPropertyNames = new string[] { "AttributeSetInstanceId", "Version" };

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
            if (fieldName.Equals("AttributeSetInstanceId", StringComparison.InvariantCultureIgnoreCase))
            {
                return typeof(string);
            }

            if (fieldName.Equals("Version", StringComparison.InvariantCultureIgnoreCase))
            {
                return typeof(long);
            }

            throw new ArgumentException(String.Format("Unknown fileName: {0}", fieldName));
        }


        private AttributeSetInstanceStateEventIdDto _value = new AttributeSetInstanceStateEventIdDto();

		public AttributeSetInstanceStateEventIdFlattenedDto()
		{
		}

		public AttributeSetInstanceStateEventIdFlattenedDto(AttributeSetInstanceStateEventIdDto val)
		{
			this._value = val;
		}

        public AttributeSetInstanceStateEventIdDto ToAttributeSetInstanceStateEventIdDto()
        {
            return this._value;
        }

		public AttributeSetInstanceStateEventIdFlattenedDto(AttributeSetInstanceStateEventId val)
		{
			this._value = new AttributeSetInstanceStateEventIdDtoWrapper(val);
		}

        public AttributeSetInstanceStateEventId ToAttributeSetInstanceStateEventId()
        {
            return this._value.ToAttributeSetInstanceStateEventId();
        }

		public virtual string AttributeSetInstanceId { 
			get { return _value.AttributeSetInstanceId; } 
			set { _value.AttributeSetInstanceId = value; } 
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

			AttributeSetInstanceStateEventIdFlattenedDto other = obj as AttributeSetInstanceStateEventIdFlattenedDto;
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

    public class AttributeSetInstanceStateEventIdFlattenedDtoFormatter : IdFlattenedDtoFormatterBase<AttributeSetInstanceStateEventIdFlattenedDto>
    {

    }

}

