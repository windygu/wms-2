﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderItemShipGrpInvReservationDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Linq;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.OrderItemShipGrpInvReservation;

namespace Dddml.Wms.Domain.OrderItemShipGrpInvReservation
{

	public abstract class OrderItemShipGrpInvReservationCommandDtoBase : ICommandDto, ICreateOrderItemShipGrpInvReservation, IMergePatchOrderItemShipGrpInvReservation, IDeleteOrderItemShipGrpInvReservation
	{

		OrderItemShipGrpInvResId IAggregateCommand<OrderItemShipGrpInvResId, long>.AggregateId
		{
			get
			{
				return ((ICreateOrMergePatchOrDeleteOrderItemShipGrpInvReservation)this).OrderItemShipGrpInvResId;
			}
		}


		long IAggregateCommand<OrderItemShipGrpInvResId, long>.AggregateVersion
		{
			get
			{
				return this.Version != null ? this.Version.Value : default(long);
			}
		}

        long IOrderItemShipGrpInvReservationCommand.Version
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

		public virtual OrderItemShipGrpInvResId OrderItemShipGrpInvResId { get; set; }

		public virtual string ReserveOrderEnumId { get; set; }

		public virtual decimal? Quantity { get; set; }

		public virtual decimal? QuantityNotAvailable { get; set; }

		public virtual DateTime? ReservedDatetime { get; set; }

		public virtual DateTime? CreatedDatetime { get; set; }

		public virtual DateTime? PromisedDatetime { get; set; }

		public virtual DateTime? CurrentPromisedDate { get; set; }

		public virtual string Priority { get; set; }

		public virtual long? SequenceId { get; set; }

		public virtual DateTime? OldPickStartDate { get; set; }

		public virtual bool? Active { get; set; }

		public virtual bool? IsPropertyReserveOrderEnumIdRemoved { get; set; }

        bool IMergePatchOrderItemShipGrpInvReservation.IsPropertyReserveOrderEnumIdRemoved
        {
            get
            {
                var b = this.IsPropertyReserveOrderEnumIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyReserveOrderEnumIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyQuantityRemoved { get; set; }

        bool IMergePatchOrderItemShipGrpInvReservation.IsPropertyQuantityRemoved
        {
            get
            {
                var b = this.IsPropertyQuantityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyQuantityRemoved = value;
            }
        }

		public virtual bool? IsPropertyQuantityNotAvailableRemoved { get; set; }

        bool IMergePatchOrderItemShipGrpInvReservation.IsPropertyQuantityNotAvailableRemoved
        {
            get
            {
                var b = this.IsPropertyQuantityNotAvailableRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyQuantityNotAvailableRemoved = value;
            }
        }

		public virtual bool? IsPropertyReservedDatetimeRemoved { get; set; }

        bool IMergePatchOrderItemShipGrpInvReservation.IsPropertyReservedDatetimeRemoved
        {
            get
            {
                var b = this.IsPropertyReservedDatetimeRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyReservedDatetimeRemoved = value;
            }
        }

		public virtual bool? IsPropertyCreatedDatetimeRemoved { get; set; }

        bool IMergePatchOrderItemShipGrpInvReservation.IsPropertyCreatedDatetimeRemoved
        {
            get
            {
                var b = this.IsPropertyCreatedDatetimeRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyCreatedDatetimeRemoved = value;
            }
        }

		public virtual bool? IsPropertyPromisedDatetimeRemoved { get; set; }

        bool IMergePatchOrderItemShipGrpInvReservation.IsPropertyPromisedDatetimeRemoved
        {
            get
            {
                var b = this.IsPropertyPromisedDatetimeRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyPromisedDatetimeRemoved = value;
            }
        }

		public virtual bool? IsPropertyCurrentPromisedDateRemoved { get; set; }

        bool IMergePatchOrderItemShipGrpInvReservation.IsPropertyCurrentPromisedDateRemoved
        {
            get
            {
                var b = this.IsPropertyCurrentPromisedDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyCurrentPromisedDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyPriorityRemoved { get; set; }

        bool IMergePatchOrderItemShipGrpInvReservation.IsPropertyPriorityRemoved
        {
            get
            {
                var b = this.IsPropertyPriorityRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyPriorityRemoved = value;
            }
        }

		public virtual bool? IsPropertySequenceIdRemoved { get; set; }

        bool IMergePatchOrderItemShipGrpInvReservation.IsPropertySequenceIdRemoved
        {
            get
            {
                var b = this.IsPropertySequenceIdRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertySequenceIdRemoved = value;
            }
        }

		public virtual bool? IsPropertyOldPickStartDateRemoved { get; set; }

        bool IMergePatchOrderItemShipGrpInvReservation.IsPropertyOldPickStartDateRemoved
        {
            get
            {
                var b = this.IsPropertyOldPickStartDateRemoved;
                if (b != null && b.HasValue)
                {
                    return b.Value;
                }
                return false;
            }
            set
            {
                this.IsPropertyOldPickStartDateRemoved = value;
            }
        }

		public virtual bool? IsPropertyActiveRemoved { get; set; }

        bool IMergePatchOrderItemShipGrpInvReservation.IsPropertyActiveRemoved
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


    public class CreateOrMergePatchOrDeleteOrderItemShipGrpInvReservationDto : OrderItemShipGrpInvReservationCommandDtoBase
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



	public class CreateOrderItemShipGrpInvReservationDto : CreateOrMergePatchOrDeleteOrderItemShipGrpInvReservationDto
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


	public class MergePatchOrderItemShipGrpInvReservationDto : CreateOrMergePatchOrDeleteOrderItemShipGrpInvReservationDto
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

	public class DeleteOrderItemShipGrpInvReservationDto : CreateOrMergePatchOrDeleteOrderItemShipGrpInvReservationDto
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

    public static partial class OrderItemShipGrpInvReservationCommandDtos
    {

    }

}

