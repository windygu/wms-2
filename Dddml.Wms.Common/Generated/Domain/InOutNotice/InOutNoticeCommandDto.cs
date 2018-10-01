﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutNoticeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOutNotice;

namespace Dddml.Wms.Domain.InOutNotice
{

	public abstract class InOutNoticeCommandDtoBase : ICommandDto, ICreateInOutNotice, IMergePatchInOutNotice, IDeleteInOutNotice
	{

		string IAggregateCommand<string, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteInOutNotice)this).InOutNoticeId;
			}
		}


		long IAggregateCommand<string, long>.AggregateVersion
		{
			get
			{
				return this.Version != null ? this.Version.Value : default(long);
			}
		}

        long IInOutNoticeCommand.Version
        {
            get { return this.Version != null ? this.Version.Value : default(long); }
            set { this.Version = value; }
        }

		public virtual long? Version { get; set; }

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

		public virtual string InOutNoticeId { get; set; }

		public virtual string WarehouseId { get; set; }

		public virtual string InOutNoticeType { get; set; }

		public virtual string TelecomContactMechId { get; set; }

		public virtual string TrackingNumber { get; set; }

		public virtual string ContactPartyId { get; set; }

		public virtual string VehiclePlateNumber { get; set; }

		public virtual string ShippingInstructions { get; set; }

		public virtual DateTime? EstimatedShipDate { get; set; }

		public virtual DateTime? EstimatedDeliveryDate { get; set; }

		public virtual bool? IsScheduleNeeded { get; set; }

		public virtual bool? Active { get; set; }

		public virtual bool? IsPropertyWarehouseIdRemoved { get; set; }

        bool IMergePatchInOutNotice.IsPropertyWarehouseIdRemoved
        {
            get
            {
                var b = this.IsPropertyWarehouseIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyWarehouseIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyInOutNoticeTypeRemoved { get; set; }

        bool IMergePatchInOutNotice.IsPropertyInOutNoticeTypeRemoved
        {
            get
            {
                var b = this.IsPropertyInOutNoticeTypeRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyInOutNoticeTypeRemoved = value;
            }
        }

		public virtual bool? IsPropertyTelecomContactMechIdRemoved { get; set; }

        bool IMergePatchInOutNotice.IsPropertyTelecomContactMechIdRemoved
        {
            get
            {
                var b = this.IsPropertyTelecomContactMechIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyTelecomContactMechIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyTrackingNumberRemoved { get; set; }

        bool IMergePatchInOutNotice.IsPropertyTrackingNumberRemoved
        {
            get
            {
                var b = this.IsPropertyTrackingNumberRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyTrackingNumberRemoved = value;
            }
        }

		public virtual bool? IsPropertyContactPartyIdRemoved { get; set; }

        bool IMergePatchInOutNotice.IsPropertyContactPartyIdRemoved
        {
            get
            {
                var b = this.IsPropertyContactPartyIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyContactPartyIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyVehiclePlateNumberRemoved { get; set; }

        bool IMergePatchInOutNotice.IsPropertyVehiclePlateNumberRemoved
        {
            get
            {
                var b = this.IsPropertyVehiclePlateNumberRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyVehiclePlateNumberRemoved = value;
            }
        }

		public virtual bool? IsPropertyShippingInstructionsRemoved { get; set; }

        bool IMergePatchInOutNotice.IsPropertyShippingInstructionsRemoved
        {
            get
            {
                var b = this.IsPropertyShippingInstructionsRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyShippingInstructionsRemoved = value;
            }
        }

		public virtual bool? IsPropertyEstimatedShipDateRemoved { get; set; }

        bool IMergePatchInOutNotice.IsPropertyEstimatedShipDateRemoved
        {
            get
            {
                var b = this.IsPropertyEstimatedShipDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyEstimatedShipDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyEstimatedDeliveryDateRemoved { get; set; }

        bool IMergePatchInOutNotice.IsPropertyEstimatedDeliveryDateRemoved
        {
            get
            {
                var b = this.IsPropertyEstimatedDeliveryDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyEstimatedDeliveryDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyIsScheduleNeededRemoved { get; set; }

        bool IMergePatchInOutNotice.IsPropertyIsScheduleNeededRemoved
        {
            get
            {
                var b = this.IsPropertyIsScheduleNeededRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyIsScheduleNeededRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchInOutNotice.IsPropertyActiveRemoved
        {
            get
            {
                var b = this.IsPropertyActiveRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyActiveRemoved = value;
            }
        }


        string ICommandDto.CommandType 
        {
            get { return this.GetCommandType(); }
        }

        protected abstract string GetCommandType();

	}


    public class CreateOrMergePatchOrDeleteInOutNoticeDto : InOutNoticeCommandDtoBase
    {
        private string _commandType;

        public virtual string CommandType
        {
            get { return _commandType; }
            set { _commandType = value; }
        }

        protected override string GetCommandType()
        {
            return this._commandType;
        }

    }



	public class CreateInOutNoticeDto : CreateOrMergePatchOrDeleteInOutNoticeDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Create;
        }

	}


	public class MergePatchInOutNoticeDto : CreateOrMergePatchOrDeleteInOutNoticeDto
	{

        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.MergePatch;
        }

	}

	public class DeleteInOutNoticeDto : CreateOrMergePatchOrDeleteInOutNoticeDto
	{
        protected override string GetCommandType()
        {
            return Dddml.Wms.Specialization.CommandType.Delete;
        }


        public override string CommandType
        {
            get { return this.GetCommandType(); }
            set { 
				// do nothing
            }
        }

	}

    public static partial class InOutNoticeCommandDtos
    {

        public class InOutNoticeActionRequestContent : ICommandDto
        {

            public string CommandType
            {
                get { return "InOutNoticeAction"; }
            }

            public string Value { get; set; }

            public string InOutNoticeId { get; set; }

            public long Version { get; set; }

            public string CommandId { get; set; }

            public string RequesterId { get; set; }

            public InOutNoticeCommands.InOutNoticeAction ToInOutNoticeAction()
            {
                var cmd = new InOutNoticeCommands.InOutNoticeAction();
                cmd.Value = this.Value;
                cmd.InOutNoticeId = this.InOutNoticeId;
                cmd.Version = this.Version;
                cmd.CommandId = this.CommandId;
                cmd.RequesterId = this.RequesterId;
                return cmd;
            }

        }

    }

}

