﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryItemRequirementDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItemRequirement;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.InventoryPRTriggered;

namespace Dddml.Wms.Domain.InventoryItemRequirement
{

	public class InventoryItemRequirementEntryStateEventIdFlattenedDto : IIdFlattenedDto
	{

        private static string[] _flattenedPropertyNames = new string[] { "InventoryItemRequirementIdProductId", "InventoryItemRequirementIdLocatorId", "InventoryItemRequirementIdAttributeSetInstanceId", "EntrySeqId", "InventoryItemRequirementVersion" };

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
            if (fieldName.Equals("InventoryItemRequirementIdProductId", StringComparison.InvariantCultureIgnoreCase))
            {
                return typeof(string);
            }

            if (fieldName.Equals("InventoryItemRequirementIdLocatorId", StringComparison.InvariantCultureIgnoreCase))
            {
                return typeof(string);
            }

            if (fieldName.Equals("InventoryItemRequirementIdAttributeSetInstanceId", StringComparison.InvariantCultureIgnoreCase))
            {
                return typeof(string);
            }

            if (fieldName.Equals("EntrySeqId", StringComparison.InvariantCultureIgnoreCase))
            {
                return typeof(long);
            }

            if (fieldName.Equals("InventoryItemRequirementVersion", StringComparison.InvariantCultureIgnoreCase))
            {
                return typeof(long);
            }

            throw new ArgumentException(String.Format("Unknown fileName: {0}", fieldName));
        }


        private InventoryItemRequirementEntryStateEventIdDto _value = new InventoryItemRequirementEntryStateEventIdDto();

		public InventoryItemRequirementEntryStateEventIdFlattenedDto()
		{
		}

		public InventoryItemRequirementEntryStateEventIdFlattenedDto(InventoryItemRequirementEntryStateEventIdDto val)
		{
			this._value = val;
		}

        public InventoryItemRequirementEntryStateEventIdDto ToInventoryItemRequirementEntryStateEventIdDto()
        {
            return this._value;
        }

		public InventoryItemRequirementEntryStateEventIdFlattenedDto(InventoryItemRequirementEntryStateEventId val)
		{
			this._value = new InventoryItemRequirementEntryStateEventIdDtoWrapper(val);
		}

        public InventoryItemRequirementEntryStateEventId ToInventoryItemRequirementEntryStateEventId()
        {
            return this._value.ToInventoryItemRequirementEntryStateEventId();
        }

		public virtual string InventoryItemRequirementIdProductId {
			get { return _value.InventoryItemRequirementId.ProductId; }
			set { _value.InventoryItemRequirementId.ProductId = value; }
		}

		public virtual string InventoryItemRequirementIdLocatorId {
			get { return _value.InventoryItemRequirementId.LocatorId; }
			set { _value.InventoryItemRequirementId.LocatorId = value; }
		}

		public virtual string InventoryItemRequirementIdAttributeSetInstanceId {
			get { return _value.InventoryItemRequirementId.AttributeSetInstanceId; }
			set { _value.InventoryItemRequirementId.AttributeSetInstanceId = value; }
		}

		public virtual long EntrySeqId { 
			get { return _value.EntrySeqId; } 
			set { _value.EntrySeqId = value; } 
		}

		public virtual long InventoryItemRequirementVersion { 
			get { return _value.InventoryItemRequirementVersion; } 
			set { _value.InventoryItemRequirementVersion = value; } 
		}


		public override bool Equals (object obj)
		{
			if (Object.ReferenceEquals (this, obj)) {
				return true;
			}

			InventoryItemRequirementEntryStateEventIdFlattenedDto other = obj as InventoryItemRequirementEntryStateEventIdFlattenedDto;
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

    public class InventoryItemRequirementEntryStateEventIdFlattenedDtoFormatter : IdFlattenedDtoFormatterBase<InventoryItemRequirementEntryStateEventIdFlattenedDto>
    {

    }

}

