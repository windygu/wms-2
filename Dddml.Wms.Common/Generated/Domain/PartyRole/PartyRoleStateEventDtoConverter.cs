﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePartyRoleDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PartyRole;

namespace Dddml.Wms.Domain.PartyRole
{

    public class PartyRoleStateEventDtoConverter
    {
        public virtual PartyRoleStateCreatedOrMergePatchedOrDeletedDto ToPartyRoleStateEventDto(IPartyRoleEvent stateEvent)
        {
            if (stateEvent.EventType == StateEventType.Created)
            {
                var e = (IPartyRoleStateCreated)stateEvent;
                return ToPartyRoleStateCreatedDto(e);
            }
            else if (stateEvent.EventType == StateEventType.MergePatched)
            {
                var e = (IPartyRoleStateMergePatched)stateEvent;
                return ToPartyRoleStateMergePatchedDto(e);
            }
            else if (stateEvent.EventType == StateEventType.Deleted)
            {
                var e = (IPartyRoleStateDeleted)stateEvent;
                return ToPartyRoleStateDeletedDto(e);
            }
            throw DomainError.Named("invalidEventType", String.Format("Invalid state event type: {0}", stateEvent.EventType));
        }

        public virtual PartyRoleStateCreatedDto ToPartyRoleStateCreatedDto(IPartyRoleStateCreated e)
        {
            var dto = new PartyRoleStateCreatedDto();
            dto.PartyRoleEventId = e.PartyRoleEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Active = e.Active;
            return dto;
        }

        public virtual PartyRoleStateMergePatchedDto ToPartyRoleStateMergePatchedDto(IPartyRoleStateMergePatched e)
        {
            var dto = new PartyRoleStateMergePatchedDto();
            dto.PartyRoleEventId = e.PartyRoleEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Active = e.Active;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;

            return dto;
        }


        public virtual PartyRoleStateDeletedDto ToPartyRoleStateDeletedDto(IPartyRoleStateDeleted e)
        {
            var dto = new PartyRoleStateDeletedDto();
            dto.PartyRoleEventId = e.PartyRoleEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;

            return dto;
        }


    }


}

