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

	public class AttributeSetInstanceExtensionFieldIdFlattenedDto : IIdFlattenedDto
	{

        private static string[] _flattenedPropertyNames = new string[] { "GroupId", "Index" };

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
            if (fieldName.Equals("GroupId", StringComparison.InvariantCultureIgnoreCase))
            {
                return typeof(string);
            }

            if (fieldName.Equals("Index", StringComparison.InvariantCultureIgnoreCase))
            {
                return typeof(string);
            }

            throw new ArgumentException(String.Format("Unknown fileName: {0}", fieldName));
        }


        private AttributeSetInstanceExtensionFieldId _value = new AttributeSetInstanceExtensionFieldId();

		public AttributeSetInstanceExtensionFieldIdFlattenedDto()
		{
		}

		public AttributeSetInstanceExtensionFieldIdFlattenedDto(AttributeSetInstanceExtensionFieldId val)
		{
			this._value = val;
		}

        public AttributeSetInstanceExtensionFieldId ToAttributeSetInstanceExtensionFieldId()
        {
            return this._value;
        }


		public virtual string GroupId { 
			get { return _value.GroupId; } 
			set { _value.GroupId = value; } 
		}

		public virtual string Index { 
			get { return _value.Index; } 
			set { _value.Index = value; } 
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			AttributeSetInstanceExtensionFieldIdFlattenedDto other = obj as AttributeSetInstanceExtensionFieldIdFlattenedDto;
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

