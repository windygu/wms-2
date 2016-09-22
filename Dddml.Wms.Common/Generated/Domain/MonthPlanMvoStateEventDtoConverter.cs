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

    public class MonthPlanMvoStateEventDtoConverter
    {
        public virtual MonthPlanMvoStateCreatedOrMergePatchedOrDeletedDto ToMonthPlanMvoStateEventDto(IMonthPlanMvoStateEvent stateEvent)
        {
            if (stateEvent.StateEventType == StateEventType.Created)
            {
                var e = (IMonthPlanMvoStateCreated)stateEvent;
                return ToMonthPlanMvoStateCreatedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.MergePatched)
            {
                var e = (IMonthPlanMvoStateMergePatched)stateEvent;
                return ToMonthPlanMvoStateMergePatchedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.Deleted)
            {
                var e = (IMonthPlanMvoStateDeleted)stateEvent;
                return ToMonthPlanMvoStateDeletedDto(e);
            }

            throw DomainError.Named("invalidStateEventType", String.Format("Invalid state event type: {0}", stateEvent.StateEventType));
        }

        public virtual MonthPlanMvoStateCreatedDto ToMonthPlanMvoStateCreatedDto(IMonthPlanMvoStateCreated e)
        {
            var dto = new MonthPlanMvoStateCreatedDto();
            dto.StateEventId = new MonthPlanMvoStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Description = e.Description;
            dto.Version = e.Version;
            dto.Active = e.Active;
            dto.YearPlanDescription = e.YearPlanDescription;
            dto.YearPlanCreatedBy = e.YearPlanCreatedBy;
            dto.YearPlanUpdatedBy = e.YearPlanUpdatedBy;
            dto.YearPlanVersion = e.YearPlanVersion;
            dto.YearPlanCreatedAt = e.YearPlanCreatedAt;
            dto.YearPlanUpdatedAt = e.YearPlanUpdatedAt;
            dto.YearPlanActive = e.YearPlanActive;
            dto.YearPlanDeleted = e.YearPlanDeleted;
            dto.PersonBirthDate = e.PersonBirthDate;
            dto.PersonLoves = (e.PersonLoves == null) ? null : new PersonalNameDto(e.PersonLoves);
            dto.PersonEmergencyContact = (e.PersonEmergencyContact == null) ? null : new ContactDto(e.PersonEmergencyContact);
            dto.PersonCreatedBy = e.PersonCreatedBy;
            dto.PersonUpdatedBy = e.PersonUpdatedBy;
            dto.PersonCreatedAt = e.PersonCreatedAt;
            dto.PersonUpdatedAt = e.PersonUpdatedAt;
            dto.PersonActive = e.PersonActive;
            dto.PersonDeleted = e.PersonDeleted;
            return dto;
        }

        public virtual MonthPlanMvoStateMergePatchedDto ToMonthPlanMvoStateMergePatchedDto(IMonthPlanMvoStateMergePatched e)
        {
            var dto = new MonthPlanMvoStateMergePatchedDto();
            dto.StateEventId = new MonthPlanMvoStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Description = e.Description;
            dto.Version = e.Version;
            dto.Active = e.Active;
            dto.YearPlanDescription = e.YearPlanDescription;
            dto.YearPlanCreatedBy = e.YearPlanCreatedBy;
            dto.YearPlanUpdatedBy = e.YearPlanUpdatedBy;
            dto.YearPlanVersion = e.YearPlanVersion;
            dto.YearPlanCreatedAt = e.YearPlanCreatedAt;
            dto.YearPlanUpdatedAt = e.YearPlanUpdatedAt;
            dto.YearPlanActive = e.YearPlanActive;
            dto.YearPlanDeleted = e.YearPlanDeleted;
            dto.PersonBirthDate = e.PersonBirthDate;
            dto.PersonLoves = (e.PersonLoves == null) ? null : new PersonalNameDto(e.PersonLoves);
            dto.PersonEmergencyContact = (e.PersonEmergencyContact == null) ? null : new ContactDto(e.PersonEmergencyContact);
            dto.PersonCreatedBy = e.PersonCreatedBy;
            dto.PersonUpdatedBy = e.PersonUpdatedBy;
            dto.PersonCreatedAt = e.PersonCreatedAt;
            dto.PersonUpdatedAt = e.PersonUpdatedAt;
            dto.PersonActive = e.PersonActive;
            dto.PersonDeleted = e.PersonDeleted;
            dto.IsPropertyDescriptionRemoved = e.IsPropertyDescriptionRemoved;
            dto.IsPropertyVersionRemoved = e.IsPropertyVersionRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;
            dto.IsPropertyYearPlanDescriptionRemoved = e.IsPropertyYearPlanDescriptionRemoved;
            dto.IsPropertyYearPlanCreatedByRemoved = e.IsPropertyYearPlanCreatedByRemoved;
            dto.IsPropertyYearPlanUpdatedByRemoved = e.IsPropertyYearPlanUpdatedByRemoved;
            dto.IsPropertyYearPlanVersionRemoved = e.IsPropertyYearPlanVersionRemoved;
            dto.IsPropertyYearPlanCreatedAtRemoved = e.IsPropertyYearPlanCreatedAtRemoved;
            dto.IsPropertyYearPlanUpdatedAtRemoved = e.IsPropertyYearPlanUpdatedAtRemoved;
            dto.IsPropertyYearPlanActiveRemoved = e.IsPropertyYearPlanActiveRemoved;
            dto.IsPropertyYearPlanDeletedRemoved = e.IsPropertyYearPlanDeletedRemoved;
            dto.IsPropertyPersonBirthDateRemoved = e.IsPropertyPersonBirthDateRemoved;
            dto.IsPropertyPersonLovesRemoved = e.IsPropertyPersonLovesRemoved;
            dto.IsPropertyPersonEmergencyContactRemoved = e.IsPropertyPersonEmergencyContactRemoved;
            dto.IsPropertyPersonCreatedByRemoved = e.IsPropertyPersonCreatedByRemoved;
            dto.IsPropertyPersonUpdatedByRemoved = e.IsPropertyPersonUpdatedByRemoved;
            dto.IsPropertyPersonCreatedAtRemoved = e.IsPropertyPersonCreatedAtRemoved;
            dto.IsPropertyPersonUpdatedAtRemoved = e.IsPropertyPersonUpdatedAtRemoved;
            dto.IsPropertyPersonActiveRemoved = e.IsPropertyPersonActiveRemoved;
            dto.IsPropertyPersonDeletedRemoved = e.IsPropertyPersonDeletedRemoved;

            return dto;
        }


        public virtual MonthPlanMvoStateDeletedDto ToMonthPlanMvoStateDeletedDto(IMonthPlanMvoStateDeleted e)
        {
            var dto = new MonthPlanMvoStateDeletedDto();
            dto.StateEventId = new MonthPlanMvoStateEventIdDto(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;

            return dto;
        }


    }


}

