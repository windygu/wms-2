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

	public partial interface IShipmentAggregate : IGlobalIdentity<string>
	{
		IShipmentState State { get; }

		IList<IEvent> Changes { get; }

		void ThrowOnInvalidStateTransition (ICommand c);

		void Create (ICreateShipment c);

		void MergePatch (IMergePatchShipment c);

		void Import(string shipmentTypeId, string primaryOrderId, string primaryReturnId, string bolNumber, string vehicleId, string sealNumber, string externalOrderNumber, string carrier, DateTime? dateShipped, DateTime? estimatedReadyDate, DateTime? estimatedShipDate, DateTime? estimatedArrivalDate, DateTime? latestCancelDate, decimal? estimatedShipCost, string currencyUomId, string handlingInstructions, string originFacilityId, string destinationFacilityId, string partyIdTo, string partyIdFrom, decimal? additionalShippingCharge, string addtlShippingChargeDesc, IEnumerable<ImportingShipmentItem> shipmentItems, long version, string commandId, string requesterId);

		void Ship(long version, string commandId, string requesterId);

		void ReceiveItem(string shipmentItemSeqId, IDictionary<string, object> attributeSetInstance, string rejectionReasonId, IEnumerable<string> damageStatusIds, string damageReasonId, decimal? acceptedQuantity, decimal? rejectedQuantity, decimal? damagedQuantity, string itemDescription, long version, string commandId, string requesterId);

		void AddItemAndReceipt(string receiptSeqId, string productId, IDictionary<string, object> attributeSetInstance, string rejectionReasonId, IEnumerable<string> damageStatusIds, string damageReasonId, decimal? acceptedQuantity, decimal? rejectedQuantity, decimal? damagedQuantity, string itemDescription, long version, string commandId, string requesterId);

		void IssueItem(string shipmentItemSeqId, string orderId, string orderItemSeqId, string shipGroupSeqId, string productId, string locatorId, IDictionary<string, object> attributeSetInstance, decimal? quantity, decimal? cancelQuantity, string itemDescription, long version, string commandId, string requesterId);

		void AddItemAndIssuance(string orderId, string orderItemSeqId, string shipGroupSeqId, string itemIssuanceSeqId, string productId, string locatorId, IDictionary<string, object> attributeSetInstance, decimal? quantity, decimal? cancelQuantity, string itemDescription, long version, string commandId, string requesterId);

		void ConfirmAllItemsReceived(string destinationLocatorId, long version, string commandId, string requesterId);

		void ConfirmAllItemsIssued(long version, string commandId, string requesterId);

		void PurchaseShipmentAction(string value, long version, string commandId, string requesterId);

		void SalesShipmentAction(string value, long version, string commandId, string requesterId);


	}

}

