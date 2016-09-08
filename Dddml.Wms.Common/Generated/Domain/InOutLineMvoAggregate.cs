﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using NodaMoney;

namespace Dddml.Wms.Domain
{
    public partial class InOutLineMvoAggregate : AggregateBase, IInOutLineMvoAggregate
    {

        readonly IInOutLineMvoState _state;

        readonly IList<IEvent> _changes = new List<IEvent>();

        public IInOutLineMvoState State
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

        InOutLineId IGlobalIdentity<InOutLineId>.GlobalId
        {
            get
            {
                return this._state.GlobalId;
            }
        }

        #endregion


        public InOutLineMvoAggregate(IInOutLineMvoState state)
        {
            _state = state;
        }


        public virtual void ThrowOnInvalidStateTransition(ICommand c)
        {
            if (((IInOutLineMvoStateProperties)_state).InOutVersion == InOutLineMvoState.VersionZero)
            {
                if (IsCommandCreate((IInOutLineMvoCommand)c))
                {
                    return;
                }
                throw DomainError.Named("premature", "Can't do anything to unexistent aggregate");
            }
            if (_state.Deleted)
            {
                throw DomainError.Named("zombie", "Can't do anything to deleted aggregate.");
            }
            if (IsCommandCreate((IInOutLineMvoCommand)c))
                throw DomainError.Named("rebirth", "Can't create aggregate that already exists");
        }

        private static bool IsCommandCreate(IInOutLineMvoCommand c)
        {
            return c.InOutVersion == InOutLineMvoState.VersionZero;
        }

        protected virtual void Apply(IEvent e)
        {
            OnApplying(e);
            _state.Mutate(e);
            _changes.Add(e);
        }

        public virtual void Create(ICreateInOutLineMvo c)
        {
            IInOutLineMvoStateCreated e = Map(c);
            Apply(e);
        }

        public virtual void MergePatch(IMergePatchInOutLineMvo c)
        {
            IInOutLineMvoStateMergePatched e = Map(c);
            Apply(e);
        }

        public virtual void Delete(IDeleteInOutLineMvo c)
        {
            IInOutLineMvoStateDeleted e = Map(c);
            Apply(e);
        }


        protected virtual IInOutLineMvoStateCreated Map(ICreateInOutLineMvo c)
        {
			var stateEventId = new InOutLineMvoStateEventId(c.InOutLineId, c.InOutVersion);
            IInOutLineMvoStateCreated e = NewInOutLineMvoStateCreated(stateEventId);
		
            e.LineNumber = c.LineNumber;
            e.Description = c.Description;
            e.LocatorId = c.LocatorId;
            e.Product = c.Product;
            e.UomId = c.UomId;
            e.MovementQuantity = c.MovementQuantity;
            e.ConfirmedQuantity = c.ConfirmedQuantity;
            e.ScrappedQuantity = c.ScrappedQuantity;
            e.TargetQuantity = c.TargetQuantity;
            e.PickedQuantity = c.PickedQuantity;
            e.IsInvoiced = c.IsInvoiced;
            e.AttributeSetInstanceId = c.AttributeSetInstanceId;
            e.IsDescription = c.IsDescription;
            e.Processed = c.Processed;
            e.QuantityEntered = c.QuantityEntered;
            e.RmaLineNumber = c.RmaLineNumber;
            e.ReversalLineNumber = c.ReversalLineNumber;
            e.Version = c.Version;
            e.Active = c.Active;
            e.InOutIsSOTransaction = c.InOutIsSOTransaction;
            NewInOutLineMvoDocumentActionCommandAndExecute(c, _state, e);
            e.InOutPosted = c.InOutPosted;
            e.InOutProcessing = c.InOutProcessing;
            e.InOutProcessed = c.InOutProcessed;
            e.InOutDocumentType = c.InOutDocumentType;
            e.InOutDescription = c.InOutDescription;
            e.InOutOrderNumber = c.InOutOrderNumber;
            e.InOutDateOrdered = c.InOutDateOrdered;
            e.InOutIsPrinted = c.InOutIsPrinted;
            e.InOutMovementType = c.InOutMovementType;
            e.InOutMovementDate = c.InOutMovementDate;
            e.InOutBusinessPartnerId = c.InOutBusinessPartnerId;
            e.InOutWarehouseId = c.InOutWarehouseId;
            e.InOutPOReference = c.InOutPOReference;
            e.InOutFreightAmount = c.InOutFreightAmount;
            e.InOutShipperId = c.InOutShipperId;
            e.InOutChargeAmount = c.InOutChargeAmount;
            e.InOutDatePrinted = c.InOutDatePrinted;
            e.InOutSalesRepresentative = c.InOutSalesRepresentative;
            e.InOutNumberOfPackages = c.InOutNumberOfPackages;
            e.InOutPickDate = c.InOutPickDate;
            e.InOutShipDate = c.InOutShipDate;
            e.InOutTrackingNumber = c.InOutTrackingNumber;
            e.InOutDateReceived = c.InOutDateReceived;
            e.InOutIsInTransit = c.InOutIsInTransit;
            e.InOutIsApproved = c.InOutIsApproved;
            e.InOutIsInDispute = c.InOutIsInDispute;
            e.InOutVolume = c.InOutVolume;
            e.InOutWeight = c.InOutWeight;
            e.InOutRmaNumber = c.InOutRmaNumber;
            e.InOutReversalNumber = c.InOutReversalNumber;
            e.InOutIsDropShip = c.InOutIsDropShip;
            e.InOutDropShipBusinessPartnerId = c.InOutDropShipBusinessPartnerId;
            e.InOutCreatedBy = c.InOutCreatedBy;
            e.InOutCreatedAt = c.InOutCreatedAt;
            e.InOutUpdatedBy = c.InOutUpdatedBy;
            e.InOutUpdatedAt = c.InOutUpdatedAt;
            e.InOutActive = c.InOutActive;
            e.InOutDeleted = c.InOutDeleted;
            ReflectUtils.CopyPropertyValue("CommandId", c, e);


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;
			var inOutVersion = c.InOutVersion;


            return e;
        }

        protected virtual IInOutLineMvoStateMergePatched Map(IMergePatchInOutLineMvo c)
        {
			var stateEventId = new InOutLineMvoStateEventId(c.InOutLineId, c.InOutVersion);
            IInOutLineMvoStateMergePatched e = NewInOutLineMvoStateMergePatched(stateEventId);

            e.LineNumber = c.LineNumber;
            e.Description = c.Description;
            e.LocatorId = c.LocatorId;
            e.Product = c.Product;
            e.UomId = c.UomId;
            e.MovementQuantity = c.MovementQuantity;
            e.ConfirmedQuantity = c.ConfirmedQuantity;
            e.ScrappedQuantity = c.ScrappedQuantity;
            e.TargetQuantity = c.TargetQuantity;
            e.PickedQuantity = c.PickedQuantity;
            e.IsInvoiced = c.IsInvoiced;
            e.AttributeSetInstanceId = c.AttributeSetInstanceId;
            e.IsDescription = c.IsDescription;
            e.Processed = c.Processed;
            e.QuantityEntered = c.QuantityEntered;
            e.RmaLineNumber = c.RmaLineNumber;
            e.ReversalLineNumber = c.ReversalLineNumber;
            e.Version = c.Version;
            e.Active = c.Active;
            e.InOutIsSOTransaction = c.InOutIsSOTransaction;
            NewInOutLineMvoDocumentActionCommandAndExecute(c, _state, e);
            e.InOutPosted = c.InOutPosted;
            e.InOutProcessing = c.InOutProcessing;
            e.InOutProcessed = c.InOutProcessed;
            e.InOutDocumentType = c.InOutDocumentType;
            e.InOutDescription = c.InOutDescription;
            e.InOutOrderNumber = c.InOutOrderNumber;
            e.InOutDateOrdered = c.InOutDateOrdered;
            e.InOutIsPrinted = c.InOutIsPrinted;
            e.InOutMovementType = c.InOutMovementType;
            e.InOutMovementDate = c.InOutMovementDate;
            e.InOutBusinessPartnerId = c.InOutBusinessPartnerId;
            e.InOutWarehouseId = c.InOutWarehouseId;
            e.InOutPOReference = c.InOutPOReference;
            e.InOutFreightAmount = c.InOutFreightAmount;
            e.InOutShipperId = c.InOutShipperId;
            e.InOutChargeAmount = c.InOutChargeAmount;
            e.InOutDatePrinted = c.InOutDatePrinted;
            e.InOutSalesRepresentative = c.InOutSalesRepresentative;
            e.InOutNumberOfPackages = c.InOutNumberOfPackages;
            e.InOutPickDate = c.InOutPickDate;
            e.InOutShipDate = c.InOutShipDate;
            e.InOutTrackingNumber = c.InOutTrackingNumber;
            e.InOutDateReceived = c.InOutDateReceived;
            e.InOutIsInTransit = c.InOutIsInTransit;
            e.InOutIsApproved = c.InOutIsApproved;
            e.InOutIsInDispute = c.InOutIsInDispute;
            e.InOutVolume = c.InOutVolume;
            e.InOutWeight = c.InOutWeight;
            e.InOutRmaNumber = c.InOutRmaNumber;
            e.InOutReversalNumber = c.InOutReversalNumber;
            e.InOutIsDropShip = c.InOutIsDropShip;
            e.InOutDropShipBusinessPartnerId = c.InOutDropShipBusinessPartnerId;
            e.InOutCreatedBy = c.InOutCreatedBy;
            e.InOutCreatedAt = c.InOutCreatedAt;
            e.InOutUpdatedBy = c.InOutUpdatedBy;
            e.InOutUpdatedAt = c.InOutUpdatedAt;
            e.InOutActive = c.InOutActive;
            e.InOutDeleted = c.InOutDeleted;
            e.IsPropertyLineNumberRemoved = c.IsPropertyLineNumberRemoved;
            e.IsPropertyDescriptionRemoved = c.IsPropertyDescriptionRemoved;
            e.IsPropertyLocatorIdRemoved = c.IsPropertyLocatorIdRemoved;
            e.IsPropertyProductRemoved = c.IsPropertyProductRemoved;
            e.IsPropertyUomIdRemoved = c.IsPropertyUomIdRemoved;
            e.IsPropertyMovementQuantityRemoved = c.IsPropertyMovementQuantityRemoved;
            e.IsPropertyConfirmedQuantityRemoved = c.IsPropertyConfirmedQuantityRemoved;
            e.IsPropertyScrappedQuantityRemoved = c.IsPropertyScrappedQuantityRemoved;
            e.IsPropertyTargetQuantityRemoved = c.IsPropertyTargetQuantityRemoved;
            e.IsPropertyPickedQuantityRemoved = c.IsPropertyPickedQuantityRemoved;
            e.IsPropertyIsInvoicedRemoved = c.IsPropertyIsInvoicedRemoved;
            e.IsPropertyAttributeSetInstanceIdRemoved = c.IsPropertyAttributeSetInstanceIdRemoved;
            e.IsPropertyIsDescriptionRemoved = c.IsPropertyIsDescriptionRemoved;
            e.IsPropertyProcessedRemoved = c.IsPropertyProcessedRemoved;
            e.IsPropertyQuantityEnteredRemoved = c.IsPropertyQuantityEnteredRemoved;
            e.IsPropertyRmaLineNumberRemoved = c.IsPropertyRmaLineNumberRemoved;
            e.IsPropertyReversalLineNumberRemoved = c.IsPropertyReversalLineNumberRemoved;
            e.IsPropertyVersionRemoved = c.IsPropertyVersionRemoved;
            e.IsPropertyActiveRemoved = c.IsPropertyActiveRemoved;
            e.IsPropertyInOutIsSOTransactionRemoved = c.IsPropertyInOutIsSOTransactionRemoved;
            e.IsPropertyInOutPostedRemoved = c.IsPropertyInOutPostedRemoved;
            e.IsPropertyInOutProcessingRemoved = c.IsPropertyInOutProcessingRemoved;
            e.IsPropertyInOutProcessedRemoved = c.IsPropertyInOutProcessedRemoved;
            e.IsPropertyInOutDocumentTypeRemoved = c.IsPropertyInOutDocumentTypeRemoved;
            e.IsPropertyInOutDescriptionRemoved = c.IsPropertyInOutDescriptionRemoved;
            e.IsPropertyInOutOrderNumberRemoved = c.IsPropertyInOutOrderNumberRemoved;
            e.IsPropertyInOutDateOrderedRemoved = c.IsPropertyInOutDateOrderedRemoved;
            e.IsPropertyInOutIsPrintedRemoved = c.IsPropertyInOutIsPrintedRemoved;
            e.IsPropertyInOutMovementTypeRemoved = c.IsPropertyInOutMovementTypeRemoved;
            e.IsPropertyInOutMovementDateRemoved = c.IsPropertyInOutMovementDateRemoved;
            e.IsPropertyInOutBusinessPartnerIdRemoved = c.IsPropertyInOutBusinessPartnerIdRemoved;
            e.IsPropertyInOutWarehouseIdRemoved = c.IsPropertyInOutWarehouseIdRemoved;
            e.IsPropertyInOutPOReferenceRemoved = c.IsPropertyInOutPOReferenceRemoved;
            e.IsPropertyInOutFreightAmountRemoved = c.IsPropertyInOutFreightAmountRemoved;
            e.IsPropertyInOutShipperIdRemoved = c.IsPropertyInOutShipperIdRemoved;
            e.IsPropertyInOutChargeAmountRemoved = c.IsPropertyInOutChargeAmountRemoved;
            e.IsPropertyInOutDatePrintedRemoved = c.IsPropertyInOutDatePrintedRemoved;
            e.IsPropertyInOutSalesRepresentativeRemoved = c.IsPropertyInOutSalesRepresentativeRemoved;
            e.IsPropertyInOutNumberOfPackagesRemoved = c.IsPropertyInOutNumberOfPackagesRemoved;
            e.IsPropertyInOutPickDateRemoved = c.IsPropertyInOutPickDateRemoved;
            e.IsPropertyInOutShipDateRemoved = c.IsPropertyInOutShipDateRemoved;
            e.IsPropertyInOutTrackingNumberRemoved = c.IsPropertyInOutTrackingNumberRemoved;
            e.IsPropertyInOutDateReceivedRemoved = c.IsPropertyInOutDateReceivedRemoved;
            e.IsPropertyInOutIsInTransitRemoved = c.IsPropertyInOutIsInTransitRemoved;
            e.IsPropertyInOutIsApprovedRemoved = c.IsPropertyInOutIsApprovedRemoved;
            e.IsPropertyInOutIsInDisputeRemoved = c.IsPropertyInOutIsInDisputeRemoved;
            e.IsPropertyInOutVolumeRemoved = c.IsPropertyInOutVolumeRemoved;
            e.IsPropertyInOutWeightRemoved = c.IsPropertyInOutWeightRemoved;
            e.IsPropertyInOutRmaNumberRemoved = c.IsPropertyInOutRmaNumberRemoved;
            e.IsPropertyInOutReversalNumberRemoved = c.IsPropertyInOutReversalNumberRemoved;
            e.IsPropertyInOutIsDropShipRemoved = c.IsPropertyInOutIsDropShipRemoved;
            e.IsPropertyInOutDropShipBusinessPartnerIdRemoved = c.IsPropertyInOutDropShipBusinessPartnerIdRemoved;
            e.IsPropertyInOutCreatedByRemoved = c.IsPropertyInOutCreatedByRemoved;
            e.IsPropertyInOutCreatedAtRemoved = c.IsPropertyInOutCreatedAtRemoved;
            e.IsPropertyInOutUpdatedByRemoved = c.IsPropertyInOutUpdatedByRemoved;
            e.IsPropertyInOutUpdatedAtRemoved = c.IsPropertyInOutUpdatedAtRemoved;
            e.IsPropertyInOutActiveRemoved = c.IsPropertyInOutActiveRemoved;
            e.IsPropertyInOutDeletedRemoved = c.IsPropertyInOutDeletedRemoved;

            ReflectUtils.CopyPropertyValue("CommandId", c, e);


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;

			var inOutVersion = c.InOutVersion;


            return e;
        }

        protected virtual IInOutLineMvoStateDeleted Map(IDeleteInOutLineMvo c)
        {
			var stateEventId = new InOutLineMvoStateEventId(c.InOutLineId, c.InOutVersion);
            IInOutLineMvoStateDeleted e = NewInOutLineMvoStateDeleted(stateEventId);
			
            ReflectUtils.CopyPropertyValue("CommandId", c, e);


            e.CreatedBy = (string)c.RequesterId;
            e.CreatedAt = DateTime.Now;


            return e;
        }

        protected void NewInOutLineMvoDocumentActionCommandAndExecute(IMergePatchInOutLineMvo c, IInOutLineMvoState s, IInOutLineMvoStateMergePatched e)
        {
            var pCommandHandler = this.InOutLineMvoDocumentActionCommandHandler;
            var pCmdContent = c.DocumentAction;
            var pCmd = new PropertyCommand<string, string> { Content = pCmdContent, GetState = () => s.InOutDocumentStatus, SetState = p => e.InOutDocumentStatus = p, OuterCommandType = CommandType.MergePatch };
            pCommandHandler.Execute(pCmd);
        }

        protected void NewInOutLineMvoDocumentActionCommandAndExecute(ICreateInOutLineMvo c, IInOutLineMvoState s, IInOutLineMvoStateCreated e)
        {
            var pCommandHandler = this.InOutLineMvoDocumentActionCommandHandler;
            var pCmdContent = c.DocumentAction;
            var pCmd = new PropertyCommand<string, string> { Content = pCmdContent, GetState = () => s.InOutDocumentStatus, SetState = p => e.InOutDocumentStatus = p, OuterCommandType = CommandType.Create };
            pCommandHandler.Execute(pCmd);
        }

        protected IPropertyCommandHandler<string, string> InOutLineMvoDocumentActionCommandHandler
        {
            get
            {
                return ApplicationContext.Current["InOutLineMvoDocumentActionCommandHandler"] as IPropertyCommandHandler<string, string>;
            }
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

        protected InOutLineMvoStateCreated NewInOutLineMvoStateCreated(string commandId, string requesterId)
        {
            var stateEventId = new InOutLineMvoStateEventId(_state.InOutLineId, ((IInOutLineMvoStateProperties)_state).InOutVersion);
            var e = NewInOutLineMvoStateCreated(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }

        protected InOutLineMvoStateMergePatched NewInOutLineMvoStateMergePatched(string commandId, string requesterId)
        {
            var stateEventId = new InOutLineMvoStateEventId(_state.InOutLineId, ((IInOutLineMvoStateProperties)_state).InOutVersion);
            var e = NewInOutLineMvoStateMergePatched(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }


        protected InOutLineMvoStateDeleted NewInOutLineMvoStateDeleted(string commandId, string requesterId)
        {
            var stateEventId = new InOutLineMvoStateEventId(_state.InOutLineId, ((IInOutLineMvoStateProperties)_state).InOutVersion);
            var e = NewInOutLineMvoStateDeleted(stateEventId);

            e.CommandId = commandId;

            e.CreatedBy = (string)requesterId;
            e.CreatedAt = DateTime.Now;

            return e;
        }

////////////////////////

		private InOutLineMvoStateCreated NewInOutLineMvoStateCreated(InOutLineMvoStateEventId stateEventId)
		{
			return new InOutLineMvoStateCreated(stateEventId);			
		}

        private InOutLineMvoStateMergePatched NewInOutLineMvoStateMergePatched(InOutLineMvoStateEventId stateEventId)
		{
			return new InOutLineMvoStateMergePatched(stateEventId);
		}

        private InOutLineMvoStateDeleted NewInOutLineMvoStateDeleted(InOutLineMvoStateEventId stateEventId)
		{
			return new InOutLineMvoStateDeleted(stateEventId);
		}


    }

}

