﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAttributeSetDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.AttributeSet;

namespace Dddml.Wms.Domain.AttributeSet
{

	public class AttributeSetAttributeUseIdFlattenedDto : IIdFlattenedDto
	{

        private static string[] _flattenedPropertyNames = new string[] { "AttributeSetId", "AttributeId" };

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
            if (fieldName.Equals("AttributeSetId", StringComparison.InvariantCultureIgnoreCase))
            {
                return typeof(string);
            }

            if (fieldName.Equals("AttributeId", StringComparison.InvariantCultureIgnoreCase))
            {
                return typeof(string);
            }

            throw new ArgumentException(String.Format("Unknown fileName: {0}", fieldName));
        }


        private AttributeSetAttributeUseIdDto _value = new AttributeSetAttributeUseIdDto();

		public AttributeSetAttributeUseIdFlattenedDto()
		{
		}

		public AttributeSetAttributeUseIdFlattenedDto(AttributeSetAttributeUseIdDto val)
		{
			this._value = val;
		}

        public AttributeSetAttributeUseIdDto ToAttributeSetAttributeUseIdDto()
        {
            return this._value;
        }

		public AttributeSetAttributeUseIdFlattenedDto(AttributeSetAttributeUseId val)
		{
			this._value = new AttributeSetAttributeUseIdDtoWrapper(val);
		}

        public AttributeSetAttributeUseId ToAttributeSetAttributeUseId()
        {
            return this._value.ToAttributeSetAttributeUseId();
        }

		public virtual string AttributeSetId { 
			get { return _value.AttributeSetId; } 
			set { _value.AttributeSetId = value; } 
		}

		public virtual string AttributeId { 
			get { return _value.AttributeId; } 
			set { _value.AttributeId = value; } 
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			AttributeSetAttributeUseIdFlattenedDto other = obj as AttributeSetAttributeUseIdFlattenedDto;
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

    public class AttributeSetAttributeUseIdFlattenedDtoFormatter : IdFlattenedDtoFormatterBase<AttributeSetAttributeUseIdFlattenedDto>
    {

    }

}

