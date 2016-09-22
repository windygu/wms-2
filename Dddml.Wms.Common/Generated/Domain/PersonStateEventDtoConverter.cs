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

    public class PersonStateEventDtoConverter
    {
        public virtual PersonStateCreatedOrMergePatchedOrDeletedDto ToPersonStateEventDto(IPersonStateEvent stateEvent)
        {
            if (stateEvent.StateEventType == StateEventType.Created)
            {
                var e = (IPersonStateCreated)stateEvent;
                return ToPersonStateCreatedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.MergePatched)
            {
                var e = (IPersonStateMergePatched)stateEvent;
                return ToPersonStateMergePatchedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.Deleted)
            {
                var e = (IPersonStateDeleted)stateEvent;
                return ToPersonStateDeletedDto(e);
            }

            throw DomainError.Named("invalidStateEventType", String.Format("Invalid state event type: {0}", stateEvent.StateEventType));
        }

        public virtual PersonStateCreatedDto ToPersonStateCreatedDto(IPersonStateCreated e)
        {
            var dto = new PersonStateCreatedDto();
            dto.StateEventId = new PersonStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.BirthDate = e.BirthDate;
            dto.Loves = (e.Loves == null) ? null : new PersonalNameDto(e.Loves);
            dto.EmergencyContact = (e.EmergencyContact == null) ? null : new ContactDto(e.EmergencyContact);
            dto.Active = e.Active;
            var yearPlanEvents = new List<YearPlanStateCreatedDto>();
            foreach (var ee in e.YearPlanEvents)
            {
                YearPlanStateCreatedDto eeDto = YearPlanStateEventDtoConverter.ToYearPlanStateCreatedDto(ee);
                yearPlanEvents.Add(eeDto);
            }
            dto.YearPlanEvents = yearPlanEvents.ToArray();

            return dto;
        }

        public virtual PersonStateMergePatchedDto ToPersonStateMergePatchedDto(IPersonStateMergePatched e)
        {
            var dto = new PersonStateMergePatchedDto();
            dto.StateEventId = new PersonStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.BirthDate = e.BirthDate;
            dto.Loves = (e.Loves == null) ? null : new PersonalNameDto(e.Loves);
            dto.EmergencyContact = (e.EmergencyContact == null) ? null : new ContactDto(e.EmergencyContact);
            dto.Active = e.Active;
            dto.IsPropertyBirthDateRemoved = e.IsPropertyBirthDateRemoved;
            dto.IsPropertyLovesRemoved = e.IsPropertyLovesRemoved;
            dto.IsPropertyEmergencyContactRemoved = e.IsPropertyEmergencyContactRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;
            var yearPlanEvents = new List<YearPlanStateCreatedOrMergePatchedOrRemovedDto>();
            foreach (var ee in e.YearPlanEvents)
            {
                YearPlanStateCreatedOrMergePatchedOrRemovedDto eeDto = YearPlanStateEventDtoConverter.ToYearPlanStateEventDto(ee);
                yearPlanEvents.Add(eeDto);
            }
            dto.YearPlanEvents = yearPlanEvents.ToArray();


            return dto;
        }


        public virtual PersonStateDeletedDto ToPersonStateDeletedDto(IPersonStateDeleted e)
        {
            var dto = new PersonStateDeletedDto();
            dto.StateEventId = new PersonStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            var yearPlanEvents = new List<YearPlanStateRemovedDto>();
            foreach (var ee in e.YearPlanEvents)
            {
                YearPlanStateRemovedDto eeDto = YearPlanStateEventDtoConverter.ToYearPlanStateRemovedDto(ee);
                yearPlanEvents.Add(eeDto);
            }
            dto.YearPlanEvents = yearPlanEvents.ToArray();


            return dto;
        }

        protected virtual YearPlanStateEventDtoConverter YearPlanStateEventDtoConverter
        {
            get
            {
                return new YearPlanStateEventDtoConverter();
            }
        }


    }


}

