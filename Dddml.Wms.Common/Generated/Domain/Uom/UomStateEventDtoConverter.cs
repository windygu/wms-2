﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateUomDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Uom;

namespace Dddml.Wms.Domain.Uom
{

    public class UomStateEventDtoConverter
    {
        public virtual UomStateCreatedOrMergePatchedOrDeletedDto ToUomStateEventDto(IUomStateEvent stateEvent)
        {
            if (stateEvent.StateEventType == StateEventType.Created)
            {
                var e = (IUomStateCreated)stateEvent;
                return ToUomStateCreatedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.MergePatched)
            {
                var e = (IUomStateMergePatched)stateEvent;
                return ToUomStateMergePatchedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.Deleted)
            {
                var e = (IUomStateDeleted)stateEvent;
                return ToUomStateDeletedDto(e);
            }
            throw DomainError.Named("invalidStateEventType", String.Format("Invalid state event type: {0}", stateEvent.StateEventType));
        }

        public virtual UomStateCreatedDto ToUomStateCreatedDto(IUomStateCreated e)
        {
            var dto = new UomStateCreatedDto();
            dto.StateEventId = new UomStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.UomTypeId = e.UomTypeId;
            dto.Abbreviation = e.Abbreviation;
            dto.Description = e.Description;
            dto.Active = e.Active;
            return dto;
        }

        public virtual UomStateMergePatchedDto ToUomStateMergePatchedDto(IUomStateMergePatched e)
        {
            var dto = new UomStateMergePatchedDto();
            dto.StateEventId = new UomStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.UomTypeId = e.UomTypeId;
            dto.Abbreviation = e.Abbreviation;
            dto.Description = e.Description;
            dto.Active = e.Active;
            dto.IsPropertyUomTypeIdRemoved = e.IsPropertyUomTypeIdRemoved;
            dto.IsPropertyAbbreviationRemoved = e.IsPropertyAbbreviationRemoved;
            dto.IsPropertyDescriptionRemoved = e.IsPropertyDescriptionRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;

            return dto;
        }


        public virtual UomStateDeletedDto ToUomStateDeletedDto(IUomStateDeleted e)
        {
            var dto = new UomStateDeletedDto();
            dto.StateEventId = new UomStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;

            return dto;
        }


    }


}

