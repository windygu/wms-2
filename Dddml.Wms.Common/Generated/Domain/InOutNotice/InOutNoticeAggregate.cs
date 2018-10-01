﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInOutNoticeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOutNotice;

namespace Dddml.Wms.Domain.InOutNotice
{
    public partial class InOutNoticeAggregate : AggregateBase, IInOutNoticeAggregate
    {

        readonly IInOutNoticeState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IInOutNoticeState State
        {
            get
            {
                return _state;
            }
        }

        public IList<IEvent> Changes
        {
            get
            {
                return _changes;
            }
        }

        #region IIdentity implementation

        string IGlobalIdentity<string>.GlobalId
        {
            get
            {
                return this._state.GlobalId;
            }
        }

        #endregion


        public InOutNoticeAggregate(IInOutNoticeState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((IInOutNoticeStateProperties)_state).Version == InOutNoticeState.VersionZero)
            {
                if (IsCommandCreate((IInOutNoticeCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (_state.Deleted)
            {
                throw DomainError.Named("zombie", "Can't do anything to deleted aggregate.");
            }
            if (IsCommandCreate((IInOutNoticeCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IInOutNoticeCommand c)
        {
            return c.Version == InOutNoticeState.VersionZero;
        }

        protected internal virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateInOutNotice c)
        {
            IInOutNoticeStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchInOutNotice c)
        {
            IInOutNoticeStateMergePatched e = Map(c);
            Apply(e);
        }

        public virtual void Delete(IDeleteInOutNotice c)
        {
            IInOutNoticeStateDeleted e = Map(c);
            Apply(e);
        }


        protected virtual IInOutNoticeStateCreated Map(ICreateInOutNotice c)
        {
			var stateEventId = new InOutNoticeEventId(c.InOutNoticeId, c.Version);
            IInOutNoticeStateCreated e = NewInOutNoticeStateCreated(stateEventId);
		
            e.WarehouseId = c.WarehouseId;
            e.InOutNoticeType = c.InOutNoticeType;
            e.TelecomContactMechId = c.TelecomContactMechId;
            e.TrackingNumber = c.TrackingNumber;
            e.ContactPartyId = c.ContactPartyId;
            e.VehiclePlateNumber = c.VehiclePlateNumber;
            e.ShippingInstructions = c.ShippingInstructions;
            e.EstimatedShipDate = c.EstimatedShipDate;
            e.EstimatedDeliveryDate = c.EstimatedDeliveryDate;
            e.IsScheduleNeeded = c.IsScheduleNeeded;
            NewInOutNoticeInOutNoticeActionCommandAndExecute(c, _state, e);
            e.Active = c.Active;
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();
			var version = c.Version;


            return e;
        }

        protected virtual IInOutNoticeStateMergePatched Map(IMergePatchInOutNotice c)
        {
			var stateEventId = new InOutNoticeEventId(c.InOutNoticeId, c.Version);
            IInOutNoticeStateMergePatched e = NewInOutNoticeStateMergePatched(stateEventId);

            e.WarehouseId = c.WarehouseId;
            e.InOutNoticeType = c.InOutNoticeType;
            e.TelecomContactMechId = c.TelecomContactMechId;
            e.TrackingNumber = c.TrackingNumber;
            e.ContactPartyId = c.ContactPartyId;
            e.VehiclePlateNumber = c.VehiclePlateNumber;
            e.ShippingInstructions = c.ShippingInstructions;
            e.EstimatedShipDate = c.EstimatedShipDate;
            e.EstimatedDeliveryDate = c.EstimatedDeliveryDate;
            e.IsScheduleNeeded = c.IsScheduleNeeded;
            e.Active = c.Active;
            e.IsPropertyWarehouseIdRemoved = c.IsPropertyWarehouseIdRemoved;
            e.IsPropertyInOutNoticeTypeRemoved = c.IsPropertyInOutNoticeTypeRemoved;
            e.IsPropertyTelecomContactMechIdRemoved = c.IsPropertyTelecomContactMechIdRemoved;
            e.IsPropertyTrackingNumberRemoved = c.IsPropertyTrackingNumberRemoved;
            e.IsPropertyContactPartyIdRemoved = c.IsPropertyContactPartyIdRemoved;
            e.IsPropertyVehiclePlateNumberRemoved = c.IsPropertyVehiclePlateNumberRemoved;
            e.IsPropertyShippingInstructionsRemoved = c.IsPropertyShippingInstructionsRemoved;
            e.IsPropertyEstimatedShipDateRemoved = c.IsPropertyEstimatedShipDateRemoved;
            e.IsPropertyEstimatedDeliveryDateRemoved = c.IsPropertyEstimatedDeliveryDateRemoved;
            e.IsPropertyIsScheduleNeededRemoved = c.IsPropertyIsScheduleNeededRemoved;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;

            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

			var version = c.Version;


            return e;
        }

        protected virtual IInOutNoticeStateDeleted Map(IDeleteInOutNotice c)
        {
			var stateEventId = new InOutNoticeEventId(c.InOutNoticeId, c.Version);
            IInOutNoticeStateDeleted e = NewInOutNoticeStateDeleted(stateEventId);
			
            e.CommandId = c.CommandId;


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();


            return e;
        }

        private void ThrowOnInconsistentIds(object innerObject, string innerIdName, object innerIdValue, string outerIdName, object outerIdValue)
        {
            if (!Object.Equals(innerIdValue, outerIdValue))
            {
                if (innerIdValue is string && outerIdValue is string && ((string)innerIdValue).Normalize() == ((string)outerIdValue).Normalize())
                {
                    return;
                }
                throw DomainError.Named("inconsistentId", "Outer {0} {1} NOT equals inner {2} {3}", outerIdName, outerIdValue, innerIdName, innerIdValue);
            }
        }

////////////////////////

        protected InOutNoticeStateCreated NewInOutNoticeStateCreated(long version, string commandId, string requesterId)
        {
            var stateEventId = new InOutNoticeEventId(_state.InOutNoticeId, version);
            var e = NewInOutNoticeStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

        protected InOutNoticeStateMergePatched NewInOutNoticeStateMergePatched(long version, string commandId, string requesterId)
        {
            var stateEventId = new InOutNoticeEventId(_state.InOutNoticeId, version);
            var e = NewInOutNoticeStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }


        protected InOutNoticeStateDeleted NewInOutNoticeStateDeleted(long version, string commandId, string requesterId)
        {
            var stateEventId = new InOutNoticeEventId(_state.InOutNoticeId, version);
            var e = NewInOutNoticeStateDeleted(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = ApplicationContext.Current.TimestampService.Now<DateTime>();

            return e;
        }

////////////////////////

		private InOutNoticeStateCreated NewInOutNoticeStateCreated(InOutNoticeEventId stateEventId)
		{
			return new InOutNoticeStateCreated(stateEventId);			
		}

        private InOutNoticeStateMergePatched NewInOutNoticeStateMergePatched(InOutNoticeEventId stateEventId)
		{
			return new InOutNoticeStateMergePatched(stateEventId);
		}

        private InOutNoticeStateDeleted NewInOutNoticeStateDeleted(InOutNoticeEventId stateEventId)
		{
			return new InOutNoticeStateDeleted(stateEventId);
		}
        protected void NewInOutNoticeInOutNoticeActionCommandAndExecute(ICreateInOutNotice c, IInOutNoticeState s, IInOutNoticeStateCreated e)
        {
            var pCommandHandler = this.InOutNoticeInOutNoticeActionCommandHandler;
            var pCmdContent = default(string);
            var pCmd = new PropertyCommand<string, string> { Content = pCmdContent, GetState = () => s.StatusId, SetState = p => e.StatusId = p, OuterCommandType = CommandType.Create };
            pCmd.Context = this.State;
            pCommandHandler.Execute(pCmd);
        }

        public class SimpleInOutNoticeInOutNoticeActionCommandHandler : IPropertyCommandHandler<string, string>
        {
            public virtual void Execute(IPropertyCommand<string, string> command)
            {
                if (null == command.GetState() && null == command.Content)
                {
                    command.SetState("NOTICE_CREATED");
                    return;
                }
                if ("NOTICE_CREATED" == command.GetState() && "Approve" == command.Content)
                {
                    command.SetState("NOTICE_APPROVED");
                    return;
                }
                if ("NOTICE_APPROVED" == command.GetState() && "Complete" == command.Content)
                {
                    command.SetState("NOTICE_COMPLETED");
                    return;
                }
                if ("NOTICE_CREATED" == command.GetState() && "Reject" == command.Content)
                {
                    command.SetState("NOTICE_REJECTED");
                    return;
                }
                if ("NOTICE_CREATED" == command.GetState() && "Cancel" == command.Content)
                {
                    command.SetState("NOTICE_CANCELLED");
                    return;
                }
                throw new ArgumentException(String.Format("State: {0}, command: {1}", command.GetState, command.Content));
            }
        }

        private IPropertyCommandHandler<string, string> _inOutNoticeInOutNoticeActionCommandHandler = new SimpleInOutNoticeInOutNoticeActionCommandHandler();

        protected IPropertyCommandHandler<string, string> InOutNoticeInOutNoticeActionCommandHandler
        {
            get
            {
                var h = ApplicationContext.Current["InOutNoticeInOutNoticeActionCommandHandler"] as IPropertyCommandHandler<string, string>;
                if (h != null)
                { return h; }
                return this._inOutNoticeInOutNoticeActionCommandHandler;
            }
            set
            {
                this._inOutNoticeInOutNoticeActionCommandHandler = value;
            }
        }

        protected virtual void DoInOutNoticeAction(string value, Action<string> setStatusId)
        {
            var pCommandHandler = this.InOutNoticeInOutNoticeActionCommandHandler;
            var pCmdContent = value;
            var pCmd = new PropertyCommand<string, string> { Content = pCmdContent, GetState = () => this.State.StatusId, SetState = setStatusId, OuterCommandType = "InOutNoticeAction" };
            pCmd.Context = this.State;
            pCommandHandler.Execute(pCmd);
        }

    }

}

