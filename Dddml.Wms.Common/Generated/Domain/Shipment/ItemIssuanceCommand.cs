﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Shipment;

namespace Dddml.Wms.Domain.Shipment
{

	public abstract class ItemIssuanceCommandBase : IItemIssuanceCommand
	{
		public virtual string ItemIssuanceSeqId { get; set; }


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

		public virtual string OrderId { get; set; }

		public virtual string OrderItemSeqId { get; set; }

		public virtual string ShipGroupSeqId { get; set; }

		public virtual string ProductId { get; set; }

		public virtual string LocatorId { get; set; }

		public virtual string AttributeSetInstanceId { get; set; }

		public virtual string ShipmentItemSeqId { get; set; }

		public virtual string FixedAssetId { get; set; }

		public virtual string MaintHistSeqId { get; set; }

		public virtual DateTime? IssuedDateTime { get; set; }

		public virtual string IssuedByUserLoginId { get; set; }

		public virtual decimal? Quantity { get; set; }

		public virtual decimal? CancelQuantity { get; set; }

		public virtual bool? Active { get; set; }

		// Outer Id:

		public virtual string ShipmentId { get; set; }


		// //////////////////////////////////////////////////

        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();


	}


	public class CreateItemIssuance : ItemIssuanceCommandBase, ICreateItemIssuance
	{
		
		public CreateItemIssuance ()
		{
		}


        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }
	}


	public class MergePatchItemIssuance :ItemIssuanceCommandBase, IMergePatchItemIssuance
	{

		public virtual bool IsPropertyOrderIdRemoved { get; set; }

		public virtual bool IsPropertyOrderItemSeqIdRemoved { get; set; }

		public virtual bool IsPropertyShipGroupSeqIdRemoved { get; set; }

		public virtual bool IsPropertyProductIdRemoved { get; set; }

		public virtual bool IsPropertyLocatorIdRemoved { get; set; }

		public virtual bool IsPropertyAttributeSetInstanceIdRemoved { get; set; }

		public virtual bool IsPropertyShipmentItemSeqIdRemoved { get; set; }

		public virtual bool IsPropertyFixedAssetIdRemoved { get; set; }

		public virtual bool IsPropertyMaintHistSeqIdRemoved { get; set; }

		public virtual bool IsPropertyIssuedDateTimeRemoved { get; set; }

		public virtual bool IsPropertyIssuedByUserLoginIdRemoved { get; set; }

		public virtual bool IsPropertyQuantityRemoved { get; set; }

		public virtual bool IsPropertyCancelQuantityRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public MergePatchItemIssuance ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class RemoveItemIssuance : ItemIssuanceCommandBase, IRemoveItemIssuance
	{
		public RemoveItemIssuance ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Remove;
        }
	}

}
