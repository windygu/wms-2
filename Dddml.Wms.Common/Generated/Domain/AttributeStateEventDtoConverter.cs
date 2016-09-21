﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain
{

    public class AttributeStateEventDtoConverter
    {
        public virtual AttributeStateCreatedOrMergePatchedOrDeletedDto ToAttributeStateEventDto(IAttributeStateEvent stateEvent)
        {
            if (stateEvent.StateEventType == StateEventType.Created)
            {
                var e = (IAttributeStateCreated)stateEvent;
                return ToAttributeStateCreatedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.MergePatched)
            {
                var e = (IAttributeStateMergePatched)stateEvent;
                return ToAttributeStateMergePatchedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.Deleted)
            {
                var e = (IAttributeStateDeleted)stateEvent;
                return ToAttributeStateDeletedDto(e);
            }

            throw DomainError.Named("invalidStateEventType", String.Format("Invalid state event type: {0}", stateEvent.StateEventType));
        }

        public virtual AttributeStateCreatedDto ToAttributeStateCreatedDto(IAttributeStateCreated e)
        {
            var dto = new AttributeStateCreatedDto();
            dto.StateEventId = new AttributeStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Name = e.Name;
            dto.OrganizationId = e.OrganizationId;
            dto.Description = e.Description;
            dto.IsMandatory = e.IsMandatory;
            dto.IsInstanceAttribute = e.IsInstanceAttribute;
            dto.AttributeValueType = e.AttributeValueType;
            dto.AttributeValueLength = e.AttributeValueLength;
            dto.IsList = e.IsList;
            dto.FieldName = e.FieldName;
            dto.ReferenceId = e.ReferenceId;
            dto.Active = e.Active;
            var attributeValueEvents = new List<AttributeValueStateCreatedDto>();
            foreach (var ee in e.AttributeValueEvents)
            {
                AttributeValueStateCreatedDto eeDto = AttributeValueStateEventDtoConverter.ToAttributeValueStateCreatedDto(ee);
                attributeValueEvents.Add(eeDto);
            }
            dto.AttributeValueEvents = attributeValueEvents.ToArray();

            return dto;
        }

        public virtual AttributeStateMergePatchedDto ToAttributeStateMergePatchedDto(IAttributeStateMergePatched e)
        {
            var dto = new AttributeStateMergePatchedDto();
            dto.StateEventId = new AttributeStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Name = e.Name;
            dto.OrganizationId = e.OrganizationId;
            dto.Description = e.Description;
            dto.IsMandatory = e.IsMandatory;
            dto.IsInstanceAttribute = e.IsInstanceAttribute;
            dto.AttributeValueType = e.AttributeValueType;
            dto.AttributeValueLength = e.AttributeValueLength;
            dto.IsList = e.IsList;
            dto.FieldName = e.FieldName;
            dto.ReferenceId = e.ReferenceId;
            dto.Active = e.Active;
            dto.IsPropertyNameRemoved = e.IsPropertyNameRemoved;
            dto.IsPropertyOrganizationIdRemoved = e.IsPropertyOrganizationIdRemoved;
            dto.IsPropertyDescriptionRemoved = e.IsPropertyDescriptionRemoved;
            dto.IsPropertyIsMandatoryRemoved = e.IsPropertyIsMandatoryRemoved;
            dto.IsPropertyIsInstanceAttributeRemoved = e.IsPropertyIsInstanceAttributeRemoved;
            dto.IsPropertyAttributeValueTypeRemoved = e.IsPropertyAttributeValueTypeRemoved;
            dto.IsPropertyAttributeValueLengthRemoved = e.IsPropertyAttributeValueLengthRemoved;
            dto.IsPropertyIsListRemoved = e.IsPropertyIsListRemoved;
            dto.IsPropertyFieldNameRemoved = e.IsPropertyFieldNameRemoved;
            dto.IsPropertyReferenceIdRemoved = e.IsPropertyReferenceIdRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;
            var attributeValueEvents = new List<AttributeValueStateCreatedOrMergePatchedOrRemovedDto>();
            foreach (var ee in e.AttributeValueEvents)
            {
                AttributeValueStateCreatedOrMergePatchedOrRemovedDto eeDto = AttributeValueStateEventDtoConverter.ToAttributeValueStateEventDto(ee);
                attributeValueEvents.Add(eeDto);
            }
            dto.AttributeValueEvents = attributeValueEvents.ToArray();


            return dto;
        }


        public virtual AttributeStateDeletedDto ToAttributeStateDeletedDto(IAttributeStateDeleted e)
        {
            var dto = new AttributeStateDeletedDto();
            dto.StateEventId = new AttributeStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            var attributeValueEvents = new List<AttributeValueStateRemovedDto>();
            foreach (var ee in e.AttributeValueEvents)
            {
                AttributeValueStateRemovedDto eeDto = AttributeValueStateEventDtoConverter.ToAttributeValueStateRemovedDto(ee);
                attributeValueEvents.Add(eeDto);
            }
            dto.AttributeValueEvents = attributeValueEvents.ToArray();


            return dto;
        }

        protected virtual AttributeValueStateEventDtoConverter AttributeValueStateEventDtoConverter
        {
            get
            {
                return new AttributeValueStateEventDtoConverter();
            }
        }


    }


}

