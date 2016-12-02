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

    public class AttributeValueMvoStateEventDtoConverter
    {
        public virtual AttributeValueMvoStateCreatedOrMergePatchedOrDeletedDto ToAttributeValueMvoStateEventDto(IAttributeValueMvoStateEvent stateEvent)
        {
            if (stateEvent.StateEventType == StateEventType.Created)
            {
                var e = (IAttributeValueMvoStateCreated)stateEvent;
                return ToAttributeValueMvoStateCreatedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.MergePatched)
            {
                var e = (IAttributeValueMvoStateMergePatched)stateEvent;
                return ToAttributeValueMvoStateMergePatchedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.Deleted)
            {
                var e = (IAttributeValueMvoStateDeleted)stateEvent;
                return ToAttributeValueMvoStateDeletedDto(e);
            }

            throw DomainError.Named("invalidStateEventType", String.Format("Invalid state event type: {0}", stateEvent.StateEventType));
        }

        public virtual AttributeValueMvoStateCreatedDto ToAttributeValueMvoStateCreatedDto(IAttributeValueMvoStateCreated e)
        {
            var dto = new AttributeValueMvoStateCreatedDto();
            dto.StateEventId = new AttributeValueMvoStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Name = e.Name;
            dto.Description = e.Description;
            dto.ReferenceId = e.ReferenceId;
            dto.Version = e.Version;
            dto.Active = e.Active;
            dto.AttributeName = e.AttributeName;
            dto.AttributeOrganizationId = e.AttributeOrganizationId;
            dto.AttributeDescription = e.AttributeDescription;
            dto.AttributeIsMandatory = e.AttributeIsMandatory;
            dto.AttributeIsInstanceAttribute = e.AttributeIsInstanceAttribute;
            dto.AttributeAttributeValueType = e.AttributeAttributeValueType;
            dto.AttributeAttributeValueLength = e.AttributeAttributeValueLength;
            dto.AttributeIsList = e.AttributeIsList;
            dto.AttributeFieldName = e.AttributeFieldName;
            dto.AttributeReferenceId = e.AttributeReferenceId;
            dto.AttributeCreatedBy = e.AttributeCreatedBy;
            dto.AttributeCreatedAt = e.AttributeCreatedAt;
            dto.AttributeUpdatedBy = e.AttributeUpdatedBy;
            dto.AttributeUpdatedAt = e.AttributeUpdatedAt;
            dto.AttributeActive = e.AttributeActive;
            dto.AttributeDeleted = e.AttributeDeleted;
            return dto;
        }

        public virtual AttributeValueMvoStateMergePatchedDto ToAttributeValueMvoStateMergePatchedDto(IAttributeValueMvoStateMergePatched e)
        {
            var dto = new AttributeValueMvoStateMergePatchedDto();
            dto.StateEventId = new AttributeValueMvoStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Name = e.Name;
            dto.Description = e.Description;
            dto.ReferenceId = e.ReferenceId;
            dto.Version = e.Version;
            dto.Active = e.Active;
            dto.AttributeName = e.AttributeName;
            dto.AttributeOrganizationId = e.AttributeOrganizationId;
            dto.AttributeDescription = e.AttributeDescription;
            dto.AttributeIsMandatory = e.AttributeIsMandatory;
            dto.AttributeIsInstanceAttribute = e.AttributeIsInstanceAttribute;
            dto.AttributeAttributeValueType = e.AttributeAttributeValueType;
            dto.AttributeAttributeValueLength = e.AttributeAttributeValueLength;
            dto.AttributeIsList = e.AttributeIsList;
            dto.AttributeFieldName = e.AttributeFieldName;
            dto.AttributeReferenceId = e.AttributeReferenceId;
            dto.AttributeCreatedBy = e.AttributeCreatedBy;
            dto.AttributeCreatedAt = e.AttributeCreatedAt;
            dto.AttributeUpdatedBy = e.AttributeUpdatedBy;
            dto.AttributeUpdatedAt = e.AttributeUpdatedAt;
            dto.AttributeActive = e.AttributeActive;
            dto.AttributeDeleted = e.AttributeDeleted;
            dto.IsPropertyNameRemoved = e.IsPropertyNameRemoved;
            dto.IsPropertyDescriptionRemoved = e.IsPropertyDescriptionRemoved;
            dto.IsPropertyReferenceIdRemoved = e.IsPropertyReferenceIdRemoved;
            dto.IsPropertyVersionRemoved = e.IsPropertyVersionRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;
            dto.IsPropertyAttributeNameRemoved = e.IsPropertyAttributeNameRemoved;
            dto.IsPropertyAttributeOrganizationIdRemoved = e.IsPropertyAttributeOrganizationIdRemoved;
            dto.IsPropertyAttributeDescriptionRemoved = e.IsPropertyAttributeDescriptionRemoved;
            dto.IsPropertyAttributeIsMandatoryRemoved = e.IsPropertyAttributeIsMandatoryRemoved;
            dto.IsPropertyAttributeIsInstanceAttributeRemoved = e.IsPropertyAttributeIsInstanceAttributeRemoved;
            dto.IsPropertyAttributeAttributeValueTypeRemoved = e.IsPropertyAttributeAttributeValueTypeRemoved;
            dto.IsPropertyAttributeAttributeValueLengthRemoved = e.IsPropertyAttributeAttributeValueLengthRemoved;
            dto.IsPropertyAttributeIsListRemoved = e.IsPropertyAttributeIsListRemoved;
            dto.IsPropertyAttributeFieldNameRemoved = e.IsPropertyAttributeFieldNameRemoved;
            dto.IsPropertyAttributeReferenceIdRemoved = e.IsPropertyAttributeReferenceIdRemoved;
            dto.IsPropertyAttributeCreatedByRemoved = e.IsPropertyAttributeCreatedByRemoved;
            dto.IsPropertyAttributeCreatedAtRemoved = e.IsPropertyAttributeCreatedAtRemoved;
            dto.IsPropertyAttributeUpdatedByRemoved = e.IsPropertyAttributeUpdatedByRemoved;
            dto.IsPropertyAttributeUpdatedAtRemoved = e.IsPropertyAttributeUpdatedAtRemoved;
            dto.IsPropertyAttributeActiveRemoved = e.IsPropertyAttributeActiveRemoved;
            dto.IsPropertyAttributeDeletedRemoved = e.IsPropertyAttributeDeletedRemoved;

            return dto;
        }


        public virtual AttributeValueMvoStateDeletedDto ToAttributeValueMvoStateDeletedDto(IAttributeValueMvoStateDeleted e)
        {
            var dto = new AttributeValueMvoStateDeletedDto();
            dto.StateEventId = new AttributeValueMvoStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;

            return dto;
        }


    }


}

