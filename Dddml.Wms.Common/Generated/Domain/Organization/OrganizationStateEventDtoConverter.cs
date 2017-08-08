﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrganizationDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Organization;

namespace Dddml.Wms.Domain.Organization
{

    public class OrganizationStateEventDtoConverter
    {
        public virtual OrganizationStateCreatedOrMergePatchedOrDeletedDto ToOrganizationStateEventDto(IOrganizationStateEvent stateEvent)
        {
            if (stateEvent.StateEventType == StateEventType.Created)
            {
                var e = (IOrganizationStateCreated)stateEvent;
                return ToOrganizationStateCreatedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.MergePatched)
            {
                var e = (IOrganizationStateMergePatched)stateEvent;
                return ToOrganizationStateMergePatchedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.Deleted)
            {
                var e = (IOrganizationStateDeleted)stateEvent;
                return ToOrganizationStateDeletedDto(e);
            }
            throw DomainError.Named("invalidStateEventType", String.Format("Invalid state event type: {0}", stateEvent.StateEventType));
        }

        public virtual OrganizationStateCreatedDto ToOrganizationStateCreatedDto(IOrganizationStateCreated e)
        {
            var dto = new OrganizationStateCreatedDto();
            dto.StateEventId = new OrganizationStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Name = e.Name;
            dto.Description = e.Description;
            dto.Type = e.Type;
            dto.IsSummary = e.IsSummary;
            dto.Active = e.Active;
            return dto;
        }

        public virtual OrganizationStateMergePatchedDto ToOrganizationStateMergePatchedDto(IOrganizationStateMergePatched e)
        {
            var dto = new OrganizationStateMergePatchedDto();
            dto.StateEventId = new OrganizationStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Name = e.Name;
            dto.Description = e.Description;
            dto.Type = e.Type;
            dto.IsSummary = e.IsSummary;
            dto.Active = e.Active;
            dto.IsPropertyNameRemoved = e.IsPropertyNameRemoved;
            dto.IsPropertyDescriptionRemoved = e.IsPropertyDescriptionRemoved;
            dto.IsPropertyTypeRemoved = e.IsPropertyTypeRemoved;
            dto.IsPropertyIsSummaryRemoved = e.IsPropertyIsSummaryRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;

            return dto;
        }


        public virtual OrganizationStateDeletedDto ToOrganizationStateDeletedDto(IOrganizationStateDeleted e)
        {
            var dto = new OrganizationStateDeletedDto();
            dto.StateEventId = new OrganizationStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;

            return dto;
        }


    }


}
