﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentReceiptMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ShipmentReceiptMvo;
using Dddml.Wms.Domain.Shipment;

namespace Dddml.Wms.Domain.ShipmentReceiptMvo
{

	public abstract class ShipmentReceiptMvoCommandBase : IShipmentReceiptMvoCommand
	{
		public virtual ShipmentReceiptId ShipmentReceiptId { get; set; }


		ShipmentReceiptId IAggregateCommand<ShipmentReceiptId, long>.AggregateId
		{
			get
			{
				return this.ShipmentReceiptId;
			}
		}


		long IAggregateCommand<ShipmentReceiptId, long>.AggregateVersion
		{
			get
			{
				return this.ShipmentVersion;
			}
		}

		public virtual long ShipmentVersion { get; set; }

		public virtual string RequesterId { get; set; }

		public virtual string CommandId { get; set; }

        object ICommand.RequesterId
        {
            get { return this.RequesterId; }
            set { this.RequesterId = (string)value; }
        }

        string ICommand.CommandId
        {
            get { return this.CommandId; }
            set { this.CommandId = value; }
        }

		public virtual string ProductId { get; set; }

		public virtual string ShipmentItemSeqId { get; set; }

		public virtual string RejectionReasonId { get; set; }

		public virtual string DamageStatusId { get; set; }

		public virtual string DamageReasonId { get; set; }

		public virtual string ItemDescription { get; set; }

		public virtual decimal? AcceptedQuantity { get; set; }

		public virtual decimal? RejectedQuantity { get; set; }

		public virtual decimal? DamagedQuantity { get; set; }

		public virtual long? Version { get; set; }

		public virtual bool? Active { get; set; }

		public virtual string ShipmentShipmentTypeId { get; set; }

		public virtual string ShipmentStatusId { get; set; }

		public virtual string ShipmentPrimaryOrderId { get; set; }

		public virtual string ShipmentPrimaryReturnId { get; set; }

		public virtual string ShipmentPicklistBinId { get; set; }

		public virtual DateTime? ShipmentEstimatedReadyDate { get; set; }

		public virtual DateTime? ShipmentEstimatedShipDate { get; set; }

		public virtual string ShipmentEstimatedShipWorkEffId { get; set; }

		public virtual DateTime? ShipmentEstimatedArrivalDate { get; set; }

		public virtual string ShipmentEstimatedArrivalWorkEffId { get; set; }

		public virtual DateTime? ShipmentLatestCancelDate { get; set; }

		public virtual decimal? ShipmentEstimatedShipCost { get; set; }

		public virtual string ShipmentCurrencyUomId { get; set; }

		public virtual string ShipmentHandlingInstructions { get; set; }

		public virtual string ShipmentOriginFacilityId { get; set; }

		public virtual string ShipmentDestinationFacilityId { get; set; }

		public virtual string ShipmentOriginContactMechId { get; set; }

		public virtual string ShipmentOriginTelecomNumberId { get; set; }

		public virtual string ShipmentDestinationContactMechId { get; set; }

		public virtual string ShipmentDestinationTelecomNumberId { get; set; }

		public virtual string ShipmentPartyIdTo { get; set; }

		public virtual string ShipmentPartyIdFrom { get; set; }

		public virtual decimal? ShipmentAdditionalShippingCharge { get; set; }

		public virtual string ShipmentAddtlShippingChargeDesc { get; set; }

		public virtual string ShipmentCreatedBy { get; set; }

		public virtual DateTime? ShipmentCreatedAt { get; set; }

		public virtual string ShipmentUpdatedBy { get; set; }

		public virtual DateTime? ShipmentUpdatedAt { get; set; }

		public virtual bool? ShipmentActive { get; set; }


		// //////////////////////////////////////////////////

        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();


	}


	public class CreateShipmentReceiptMvo : ShipmentReceiptMvoCommandBase, ICreateShipmentReceiptMvo
	{
		
		public CreateShipmentReceiptMvo ()
		{
		}


        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }
	}


	public class MergePatchShipmentReceiptMvo :ShipmentReceiptMvoCommandBase, IMergePatchShipmentReceiptMvo
	{

		public virtual bool IsPropertyProductIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentItemSeqIdRemoved { get; set; }

		public virtual bool IsPropertyRejectionReasonIdRemoved { get; set; }

		public virtual bool IsPropertyDamageStatusIdRemoved { get; set; }

		public virtual bool IsPropertyDamageReasonIdRemoved { get; set; }

		public virtual bool IsPropertyItemDescriptionRemoved { get; set; }

		public virtual bool IsPropertyAcceptedQuantityRemoved { get; set; }

		public virtual bool IsPropertyRejectedQuantityRemoved { get; set; }

		public virtual bool IsPropertyDamagedQuantityRemoved { get; set; }

		public virtual bool IsPropertyVersionRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }

		public virtual bool IsPropertyShipmentShipmentTypeIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentStatusIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentPrimaryOrderIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentPrimaryReturnIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentPicklistBinIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentEstimatedReadyDateRemoved { get; set; }

		public virtual bool IsPropertyShipmentEstimatedShipDateRemoved { get; set; }

		public virtual bool IsPropertyShipmentEstimatedShipWorkEffIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentEstimatedArrivalDateRemoved { get; set; }

		public virtual bool IsPropertyShipmentEstimatedArrivalWorkEffIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentLatestCancelDateRemoved { get; set; }

		public virtual bool IsPropertyShipmentEstimatedShipCostRemoved { get; set; }

		public virtual bool IsPropertyShipmentCurrencyUomIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentHandlingInstructionsRemoved { get; set; }

		public virtual bool IsPropertyShipmentOriginFacilityIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentDestinationFacilityIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentOriginContactMechIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentOriginTelecomNumberIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentDestinationContactMechIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentDestinationTelecomNumberIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentPartyIdToRemoved { get; set; }

		public virtual bool IsPropertyShipmentPartyIdFromRemoved { get; set; }

		public virtual bool IsPropertyShipmentAdditionalShippingChargeRemoved { get; set; }

		public virtual bool IsPropertyShipmentAddtlShippingChargeDescRemoved { get; set; }

		public virtual bool IsPropertyShipmentCreatedByRemoved { get; set; }

		public virtual bool IsPropertyShipmentCreatedAtRemoved { get; set; }

		public virtual bool IsPropertyShipmentUpdatedByRemoved { get; set; }

		public virtual bool IsPropertyShipmentUpdatedAtRemoved { get; set; }

		public virtual bool IsPropertyShipmentActiveRemoved { get; set; }


		public MergePatchShipmentReceiptMvo ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class DeleteShipmentReceiptMvo : ShipmentReceiptMvoCommandBase, IDeleteShipmentReceiptMvo
	{
		public DeleteShipmentReceiptMvo ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Delete;
        }

	}

    public static partial class ShipmentReceiptMvoCommands
    {
    }

}
