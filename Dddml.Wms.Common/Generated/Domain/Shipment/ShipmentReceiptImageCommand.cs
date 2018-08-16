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

	public abstract class ShipmentReceiptImageCommandBase : IShipmentReceiptImageCommand
	{
		public virtual string SequenceId { get; set; }


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

		public virtual string Url { get; set; }

		public virtual bool? Active { get; set; }

		// Outer Id:

		public virtual string ShipmentId { get; set; }

		// Outer Id:

		public virtual string ShipmentReceiptReceiptSeqId { get; set; }


		// //////////////////////////////////////////////////

        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();


	}


	public class CreateShipmentReceiptImage : ShipmentReceiptImageCommandBase, ICreateShipmentReceiptImage
	{
		
		public CreateShipmentReceiptImage ()
		{
		}


        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }
	}


	public class MergePatchShipmentReceiptImage :ShipmentReceiptImageCommandBase, IMergePatchShipmentReceiptImage
	{

		public virtual bool IsPropertyUrlRemoved { get; set; }

		public virtual bool IsPropertyActiveRemoved { get; set; }


		public MergePatchShipmentReceiptImage ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class RemoveShipmentReceiptImage : ShipmentReceiptImageCommandBase, IRemoveShipmentReceiptImage
	{
		public RemoveShipmentReceiptImage ()
		{
		}

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Remove;
        }
	}

}