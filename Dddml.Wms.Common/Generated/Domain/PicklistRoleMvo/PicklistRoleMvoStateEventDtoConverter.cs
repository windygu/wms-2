﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePicklistRoleMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PicklistRoleMvo;
using Dddml.Wms.Domain.Picklist;

namespace Dddml.Wms.Domain.PicklistRoleMvo
{

    public class PicklistRoleMvoStateEventDtoConverter
    {
        public virtual PicklistRoleMvoStateCreatedOrMergePatchedOrDeletedDto ToPicklistRoleMvoStateEventDto(IPicklistRoleMvoEvent stateEvent)
        {
            if (stateEvent.EventType == StateEventType.Created)
            {
                var e = (IPicklistRoleMvoStateCreated)stateEvent;
                return ToPicklistRoleMvoStateCreatedDto(e);
            }
            else if (stateEvent.EventType == StateEventType.MergePatched)
            {
                var e = (IPicklistRoleMvoStateMergePatched)stateEvent;
                return ToPicklistRoleMvoStateMergePatchedDto(e);
            }
            else if (stateEvent.EventType == StateEventType.Deleted)
            {
                var e = (IPicklistRoleMvoStateDeleted)stateEvent;
                return ToPicklistRoleMvoStateDeletedDto(e);
            }
            throw DomainError.Named("invalidEventType", String.Format("Invalid state event type: {0}", stateEvent.EventType));
        }

        public virtual PicklistRoleMvoStateCreatedDto ToPicklistRoleMvoStateCreatedDto(IPicklistRoleMvoStateCreated e)
        {
            var dto = new PicklistRoleMvoStateCreatedDto();
            dto.PicklistRoleMvoEventId = e.PicklistRoleMvoEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedByUserLogin = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Version = e.Version;
            dto.Active = e.Active;
            dto.PicklistDescription = e.PicklistDescription;
            dto.PicklistFacilityId = e.PicklistFacilityId;
            dto.PicklistShipmentMethodTypeId = e.PicklistShipmentMethodTypeId;
            dto.PicklistStatusId = e.PicklistStatusId;
            dto.PicklistPicklistDate = e.PicklistPicklistDate;
            dto.PicklistPickwaveId = e.PicklistPickwaveId;
            dto.PicklistCreatedBy = e.PicklistCreatedBy;
            dto.PicklistCreatedAt = e.PicklistCreatedAt;
            dto.PicklistUpdatedBy = e.PicklistUpdatedBy;
            dto.PicklistUpdatedAt = e.PicklistUpdatedAt;
            dto.PicklistActive = e.PicklistActive;
            dto.PicklistDeleted = e.PicklistDeleted;
            return dto;
        }

        public virtual PicklistRoleMvoStateMergePatchedDto ToPicklistRoleMvoStateMergePatchedDto(IPicklistRoleMvoStateMergePatched e)
        {
            var dto = new PicklistRoleMvoStateMergePatchedDto();
            dto.PicklistRoleMvoEventId = e.PicklistRoleMvoEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedByUserLogin = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.Version = e.Version;
            dto.Active = e.Active;
            dto.PicklistDescription = e.PicklistDescription;
            dto.PicklistFacilityId = e.PicklistFacilityId;
            dto.PicklistShipmentMethodTypeId = e.PicklistShipmentMethodTypeId;
            dto.PicklistStatusId = e.PicklistStatusId;
            dto.PicklistPicklistDate = e.PicklistPicklistDate;
            dto.PicklistPickwaveId = e.PicklistPickwaveId;
            dto.PicklistCreatedBy = e.PicklistCreatedBy;
            dto.PicklistCreatedAt = e.PicklistCreatedAt;
            dto.PicklistUpdatedBy = e.PicklistUpdatedBy;
            dto.PicklistUpdatedAt = e.PicklistUpdatedAt;
            dto.PicklistActive = e.PicklistActive;
            dto.PicklistDeleted = e.PicklistDeleted;
            dto.IsPropertyVersionRemoved = e.IsPropertyVersionRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;
            dto.IsPropertyPicklistDescriptionRemoved = e.IsPropertyPicklistDescriptionRemoved;
            dto.IsPropertyPicklistFacilityIdRemoved = e.IsPropertyPicklistFacilityIdRemoved;
            dto.IsPropertyPicklistShipmentMethodTypeIdRemoved = e.IsPropertyPicklistShipmentMethodTypeIdRemoved;
            dto.IsPropertyPicklistStatusIdRemoved = e.IsPropertyPicklistStatusIdRemoved;
            dto.IsPropertyPicklistPicklistDateRemoved = e.IsPropertyPicklistPicklistDateRemoved;
            dto.IsPropertyPicklistPickwaveIdRemoved = e.IsPropertyPicklistPickwaveIdRemoved;
            dto.IsPropertyPicklistCreatedByRemoved = e.IsPropertyPicklistCreatedByRemoved;
            dto.IsPropertyPicklistCreatedAtRemoved = e.IsPropertyPicklistCreatedAtRemoved;
            dto.IsPropertyPicklistUpdatedByRemoved = e.IsPropertyPicklistUpdatedByRemoved;
            dto.IsPropertyPicklistUpdatedAtRemoved = e.IsPropertyPicklistUpdatedAtRemoved;
            dto.IsPropertyPicklistActiveRemoved = e.IsPropertyPicklistActiveRemoved;
            dto.IsPropertyPicklistDeletedRemoved = e.IsPropertyPicklistDeletedRemoved;

            return dto;
        }


        public virtual PicklistRoleMvoStateDeletedDto ToPicklistRoleMvoStateDeletedDto(IPicklistRoleMvoStateDeleted e)
        {
            var dto = new PicklistRoleMvoStateDeletedDto();
            dto.PicklistRoleMvoEventId = e.PicklistRoleMvoEventId;
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedByUserLogin = e.CreatedBy;
            dto.CommandId = e.CommandId;

            return dto;
        }


    }


}
