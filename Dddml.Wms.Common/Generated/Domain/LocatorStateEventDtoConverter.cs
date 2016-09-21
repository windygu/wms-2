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

    public class LocatorStateEventDtoConverter
    {
        public virtual LocatorStateCreatedOrMergePatchedOrDeletedDto ToLocatorStateEventDto(ILocatorStateEvent stateEvent)
        {
            if (stateEvent.StateEventType == StateEventType.Created)
            {
                var e = (ILocatorStateCreated)stateEvent;
                return ToLocatorStateCreatedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.MergePatched)
            {
                var e = (ILocatorStateMergePatched)stateEvent;
                return ToLocatorStateMergePatchedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.Deleted)
            {
                var e = (ILocatorStateDeleted)stateEvent;
                return ToLocatorStateDeletedDto(e);
            }

            throw DomainError.Named("invalidStateEventType", String.Format("Invalid state event type: {0}", stateEvent.StateEventType));
        }

        public virtual LocatorStateCreatedDto ToLocatorStateCreatedDto(ILocatorStateCreated e)
        {
            var dto = new LocatorStateCreatedDto();
            dto.StateEventId = new LocatorStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.WarehouseId = e.WarehouseId;
            dto.ParentLocatorId = e.ParentLocatorId;
            dto.LocatorType = e.LocatorType;
            dto.PriorityNumber = e.PriorityNumber;
            dto.IsDefault = e.IsDefault;
            dto.X = e.X;
            dto.Y = e.Y;
            dto.Z = e.Z;
            dto.Active = e.Active;
            return dto;
        }

        public virtual LocatorStateMergePatchedDto ToLocatorStateMergePatchedDto(ILocatorStateMergePatched e)
        {
            var dto = new LocatorStateMergePatchedDto();
            dto.StateEventId = new LocatorStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.WarehouseId = e.WarehouseId;
            dto.ParentLocatorId = e.ParentLocatorId;
            dto.LocatorType = e.LocatorType;
            dto.PriorityNumber = e.PriorityNumber;
            dto.IsDefault = e.IsDefault;
            dto.X = e.X;
            dto.Y = e.Y;
            dto.Z = e.Z;
            dto.Active = e.Active;
            dto.IsPropertyWarehouseIdRemoved = e.IsPropertyWarehouseIdRemoved;
            dto.IsPropertyParentLocatorIdRemoved = e.IsPropertyParentLocatorIdRemoved;
            dto.IsPropertyLocatorTypeRemoved = e.IsPropertyLocatorTypeRemoved;
            dto.IsPropertyPriorityNumberRemoved = e.IsPropertyPriorityNumberRemoved;
            dto.IsPropertyIsDefaultRemoved = e.IsPropertyIsDefaultRemoved;
            dto.IsPropertyXRemoved = e.IsPropertyXRemoved;
            dto.IsPropertyYRemoved = e.IsPropertyYRemoved;
            dto.IsPropertyZRemoved = e.IsPropertyZRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;

            return dto;
        }


        public virtual LocatorStateDeletedDto ToLocatorStateDeletedDto(ILocatorStateDeleted e)
        {
            var dto = new LocatorStateDeletedDto();
            dto.StateEventId = new LocatorStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;

            return dto;
        }


    }


}

