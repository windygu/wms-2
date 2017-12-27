﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateMovementLineMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.MovementLineMvo;
using Dddml.Wms.Domain.Movement;

namespace Dddml.Wms.Domain.MovementLineMvo
{

    public class MovementLineMvoStateEventDtoConverter
    {
        public virtual MovementLineMvoStateCreatedOrMergePatchedOrDeletedDto ToMovementLineMvoStateEventDto(IMovementLineMvoStateEvent stateEvent)
        {
            if (stateEvent.StateEventType == StateEventType.Created)
            {
                var e = (IMovementLineMvoStateCreated)stateEvent;
                return ToMovementLineMvoStateCreatedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.MergePatched)
            {
                var e = (IMovementLineMvoStateMergePatched)stateEvent;
                return ToMovementLineMvoStateMergePatchedDto(e);
            }
            else if (stateEvent.StateEventType == StateEventType.Deleted)
            {
                var e = (IMovementLineMvoStateDeleted)stateEvent;
                return ToMovementLineMvoStateDeletedDto(e);
            }
            throw DomainError.Named("invalidStateEventType", String.Format("Invalid state event type: {0}", stateEvent.StateEventType));
        }

        public virtual MovementLineMvoStateCreatedDto ToMovementLineMvoStateCreatedDto(IMovementLineMvoStateCreated e)
        {
            var dto = new MovementLineMvoStateCreatedDto();
            dto.StateEventId = new MovementLineMvoStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.MovementQuantity = e.MovementQuantity;
            dto.ProductId = e.ProductId;
            dto.LocatorIdFrom = e.LocatorIdFrom;
            dto.LocatorIdTo = e.LocatorIdTo;
            dto.AttributeSetInstanceIdFrom = e.AttributeSetInstanceIdFrom;
            dto.AttributeSetInstanceIdTo = e.AttributeSetInstanceIdTo;
            dto.Processed = e.Processed;
            dto.ReversalLineNumber = e.ReversalLineNumber;
            dto.Version = e.Version;
            dto.Active = e.Active;
            dto.MovementDocumentStatusId = e.MovementDocumentStatusId;
            dto.MovementMovementDate = e.MovementMovementDate;
            dto.MovementPosted = e.MovementPosted;
            dto.MovementProcessed = e.MovementProcessed;
            dto.MovementProcessing = e.MovementProcessing;
            dto.MovementDateReceived = e.MovementDateReceived;
            dto.MovementDocumentTypeId = e.MovementDocumentTypeId;
            dto.MovementIsInTransit = e.MovementIsInTransit;
            dto.MovementIsApproved = e.MovementIsApproved;
            dto.MovementApprovalAmount = e.MovementApprovalAmount;
            dto.MovementShipperId = e.MovementShipperId;
            dto.MovementSalesRepresentativeId = e.MovementSalesRepresentativeId;
            dto.MovementBusinessPartnerId = e.MovementBusinessPartnerId;
            dto.MovementChargeAmount = e.MovementChargeAmount;
            dto.MovementCreateFrom = e.MovementCreateFrom;
            dto.MovementFreightAmount = e.MovementFreightAmount;
            dto.MovementReversalDocumentNumber = e.MovementReversalDocumentNumber;
            dto.MovementWarehouseIdFrom = e.MovementWarehouseIdFrom;
            dto.MovementWarehouseIdTo = e.MovementWarehouseIdTo;
            dto.MovementDescription = e.MovementDescription;
            dto.MovementCreatedBy = e.MovementCreatedBy;
            dto.MovementCreatedAt = e.MovementCreatedAt;
            dto.MovementUpdatedBy = e.MovementUpdatedBy;
            dto.MovementUpdatedAt = e.MovementUpdatedAt;
            dto.MovementActive = e.MovementActive;
            dto.MovementDeleted = e.MovementDeleted;
            return dto;
        }

        public virtual MovementLineMvoStateMergePatchedDto ToMovementLineMvoStateMergePatchedDto(IMovementLineMvoStateMergePatched e)
        {
            var dto = new MovementLineMvoStateMergePatchedDto();
            dto.StateEventId = new MovementLineMvoStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;
            dto.MovementQuantity = e.MovementQuantity;
            dto.ProductId = e.ProductId;
            dto.LocatorIdFrom = e.LocatorIdFrom;
            dto.LocatorIdTo = e.LocatorIdTo;
            dto.AttributeSetInstanceIdFrom = e.AttributeSetInstanceIdFrom;
            dto.AttributeSetInstanceIdTo = e.AttributeSetInstanceIdTo;
            dto.Processed = e.Processed;
            dto.ReversalLineNumber = e.ReversalLineNumber;
            dto.Version = e.Version;
            dto.Active = e.Active;
            dto.MovementDocumentStatusId = e.MovementDocumentStatusId;
            dto.MovementMovementDate = e.MovementMovementDate;
            dto.MovementPosted = e.MovementPosted;
            dto.MovementProcessed = e.MovementProcessed;
            dto.MovementProcessing = e.MovementProcessing;
            dto.MovementDateReceived = e.MovementDateReceived;
            dto.MovementDocumentTypeId = e.MovementDocumentTypeId;
            dto.MovementIsInTransit = e.MovementIsInTransit;
            dto.MovementIsApproved = e.MovementIsApproved;
            dto.MovementApprovalAmount = e.MovementApprovalAmount;
            dto.MovementShipperId = e.MovementShipperId;
            dto.MovementSalesRepresentativeId = e.MovementSalesRepresentativeId;
            dto.MovementBusinessPartnerId = e.MovementBusinessPartnerId;
            dto.MovementChargeAmount = e.MovementChargeAmount;
            dto.MovementCreateFrom = e.MovementCreateFrom;
            dto.MovementFreightAmount = e.MovementFreightAmount;
            dto.MovementReversalDocumentNumber = e.MovementReversalDocumentNumber;
            dto.MovementWarehouseIdFrom = e.MovementWarehouseIdFrom;
            dto.MovementWarehouseIdTo = e.MovementWarehouseIdTo;
            dto.MovementDescription = e.MovementDescription;
            dto.MovementCreatedBy = e.MovementCreatedBy;
            dto.MovementCreatedAt = e.MovementCreatedAt;
            dto.MovementUpdatedBy = e.MovementUpdatedBy;
            dto.MovementUpdatedAt = e.MovementUpdatedAt;
            dto.MovementActive = e.MovementActive;
            dto.MovementDeleted = e.MovementDeleted;
            dto.IsPropertyMovementQuantityRemoved = e.IsPropertyMovementQuantityRemoved;
            dto.IsPropertyProductIdRemoved = e.IsPropertyProductIdRemoved;
            dto.IsPropertyLocatorIdFromRemoved = e.IsPropertyLocatorIdFromRemoved;
            dto.IsPropertyLocatorIdToRemoved = e.IsPropertyLocatorIdToRemoved;
            dto.IsPropertyAttributeSetInstanceIdFromRemoved = e.IsPropertyAttributeSetInstanceIdFromRemoved;
            dto.IsPropertyAttributeSetInstanceIdToRemoved = e.IsPropertyAttributeSetInstanceIdToRemoved;
            dto.IsPropertyProcessedRemoved = e.IsPropertyProcessedRemoved;
            dto.IsPropertyReversalLineNumberRemoved = e.IsPropertyReversalLineNumberRemoved;
            dto.IsPropertyVersionRemoved = e.IsPropertyVersionRemoved;
            dto.IsPropertyActiveRemoved = e.IsPropertyActiveRemoved;
            dto.IsPropertyMovementDocumentStatusIdRemoved = e.IsPropertyMovementDocumentStatusIdRemoved;
            dto.IsPropertyMovementMovementDateRemoved = e.IsPropertyMovementMovementDateRemoved;
            dto.IsPropertyMovementPostedRemoved = e.IsPropertyMovementPostedRemoved;
            dto.IsPropertyMovementProcessedRemoved = e.IsPropertyMovementProcessedRemoved;
            dto.IsPropertyMovementProcessingRemoved = e.IsPropertyMovementProcessingRemoved;
            dto.IsPropertyMovementDateReceivedRemoved = e.IsPropertyMovementDateReceivedRemoved;
            dto.IsPropertyMovementDocumentTypeIdRemoved = e.IsPropertyMovementDocumentTypeIdRemoved;
            dto.IsPropertyMovementIsInTransitRemoved = e.IsPropertyMovementIsInTransitRemoved;
            dto.IsPropertyMovementIsApprovedRemoved = e.IsPropertyMovementIsApprovedRemoved;
            dto.IsPropertyMovementApprovalAmountRemoved = e.IsPropertyMovementApprovalAmountRemoved;
            dto.IsPropertyMovementShipperIdRemoved = e.IsPropertyMovementShipperIdRemoved;
            dto.IsPropertyMovementSalesRepresentativeIdRemoved = e.IsPropertyMovementSalesRepresentativeIdRemoved;
            dto.IsPropertyMovementBusinessPartnerIdRemoved = e.IsPropertyMovementBusinessPartnerIdRemoved;
            dto.IsPropertyMovementChargeAmountRemoved = e.IsPropertyMovementChargeAmountRemoved;
            dto.IsPropertyMovementCreateFromRemoved = e.IsPropertyMovementCreateFromRemoved;
            dto.IsPropertyMovementFreightAmountRemoved = e.IsPropertyMovementFreightAmountRemoved;
            dto.IsPropertyMovementReversalDocumentNumberRemoved = e.IsPropertyMovementReversalDocumentNumberRemoved;
            dto.IsPropertyMovementWarehouseIdFromRemoved = e.IsPropertyMovementWarehouseIdFromRemoved;
            dto.IsPropertyMovementWarehouseIdToRemoved = e.IsPropertyMovementWarehouseIdToRemoved;
            dto.IsPropertyMovementDescriptionRemoved = e.IsPropertyMovementDescriptionRemoved;
            dto.IsPropertyMovementCreatedByRemoved = e.IsPropertyMovementCreatedByRemoved;
            dto.IsPropertyMovementCreatedAtRemoved = e.IsPropertyMovementCreatedAtRemoved;
            dto.IsPropertyMovementUpdatedByRemoved = e.IsPropertyMovementUpdatedByRemoved;
            dto.IsPropertyMovementUpdatedAtRemoved = e.IsPropertyMovementUpdatedAtRemoved;
            dto.IsPropertyMovementActiveRemoved = e.IsPropertyMovementActiveRemoved;
            dto.IsPropertyMovementDeletedRemoved = e.IsPropertyMovementDeletedRemoved;

            return dto;
        }


        public virtual MovementLineMvoStateDeletedDto ToMovementLineMvoStateDeletedDto(IMovementLineMvoStateDeleted e)
        {
            var dto = new MovementLineMvoStateDeletedDto();
            dto.StateEventId = new MovementLineMvoStateEventIdDtoWrapper(e.StateEventId);
            dto.CreatedAt = e.CreatedAt;
            dto.CreatedBy = e.CreatedBy;
            dto.CommandId = e.CommandId;

            return dto;
        }


    }


}
