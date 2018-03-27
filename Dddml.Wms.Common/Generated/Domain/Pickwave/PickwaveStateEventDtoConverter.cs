﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePickwaveDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Pickwave;

namespace Dddml.Wms.Domain.Pickwave
{

    public class PickwaveStateEventDtoConverter
    {
        public virtual PickwaveStateCreatedOrMergePatchedOrDeletedDto ToPickwaveStateEventDto(IPickwaveStateEvent stateEvent)
        {
            if (stateEvent.StateEventType == StateEventType.Created)
            {
                var e = (IPickwaveStateCreated)stateEvent;
                return ToPickwaveStateCreatedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.MergePatched)
            {
                var e = (IPickwaveStateMergePatched)stateEvent;
                return ToPickwaveStateMergePatchedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.Deleted)
            {
                var e = (IPickwaveStateDeleted)stateEvent;
                return ToPickwaveStateDeletedDto(e);
            }
            throw DomainError.Named("invalidStateEventType", String.Format("Invalid state event type: {0}", stateEvent.StateEventType));
        }

        public virtual PickwaveStateCreatedDto ToPickwaveStateCreatedDto(IPickwaveStateCreated e)
        {
            var dto = new PickwaveStateCreatedDto();
            dto.PickwaveEventId = e.PickwaveEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.StatusId = e.StatusId;
            dto.Description = e.Description;
            dto.Active = e.Active;
            return dto;
        }

        public virtual PickwaveStateMergePatchedDto ToPickwaveStateMergePatchedDto(IPickwaveStateMergePatched e)
        {
            var dto = new PickwaveStateMergePatchedDto();
            dto.PickwaveEventId = e.PickwaveEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.StatusId = e.StatusId;
            dto.Description = e.Description;
            dto.Active = e.Active;
            dto.IsPropertyStatusIdRemoved = e.IsPropertyStatusIdRemoved;
            dto.IsPropertyDescriptionRemoved = e.IsPropertyDescriptionRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;

            return dto;
        }


        public virtual PickwaveStateDeletedDto ToPickwaveStateDeletedDto(IPickwaveStateDeleted e)
        {
            var dto = new PickwaveStateDeletedDto();
            dto.PickwaveEventId = e.PickwaveEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;

            return dto;
        }


    }


}

