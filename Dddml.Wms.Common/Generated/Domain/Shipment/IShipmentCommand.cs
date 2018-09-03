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
	public interface IShipmentCommand : IAggregateCommand<string, long>, ICommandDto
	{
		long Version { get; set; }

		string ShipmentId { get; set; }

	}


	public interface ICreateOrMergePatchOrDeleteShipment : IShipmentCommand
	{

		string ShipmentTypeId { get; set; }

		string StatusId { get; set; }

		string PrimaryOrderId { get; set; }

		string PrimaryReturnId { get; set; }

		string PrimaryShipGroupSeqId { get; set; }

		string PicklistBinId { get; set; }

		string BolNumber { get; set; }

		string SealNumber { get; set; }

		string VehicleId { get; set; }

		string ExternalOrderNumber { get; set; }

		string Carrier { get; set; }

		DateTime? DateShipped { get; set; }

		DateTime? EstimatedReadyDate { get; set; }

		DateTime? EstimatedShipDate { get; set; }

		string EstimatedShipWorkEffId { get; set; }

		DateTime? EstimatedArrivalDate { get; set; }

		string EstimatedArrivalWorkEffId { get; set; }

		DateTime? LatestCancelDate { get; set; }

		decimal? EstimatedShipCost { get; set; }

		string CurrencyUomId { get; set; }

		string HandlingInstructions { get; set; }

		string OriginFacilityId { get; set; }

		string DestinationFacilityId { get; set; }

		string OriginContactMechId { get; set; }

		string OriginTelecomNumberId { get; set; }

		string DestinationContactMechId { get; set; }

		string DestinationTelecomNumberId { get; set; }

		string PartyIdTo { get; set; }

		string PartyIdFrom { get; set; }

		decimal? AdditionalShippingCharge { get; set; }

		string AddtlShippingChargeDesc { get; set; }

		bool? Active { get; set; }


	}

	public interface ICreateShipment : ICreateOrMergePatchOrDeleteShipment
	{
        ICreateShipmentImageCommands ShipmentImages { get; }

        ICreateShipmentImage NewCreateShipmentImage();

        ICreateShipmentItemCommands ShipmentItems { get; }

        ICreateShipmentItem NewCreateShipmentItem();

        ICreateShipmentReceiptCommands ShipmentReceipts { get; }

        ICreateShipmentReceipt NewCreateShipmentReceipt();

        ICreateItemIssuanceCommands ItemIssuances { get; }

        ICreateItemIssuance NewCreateItemIssuance();

	}

	public interface IMergePatchShipment : ICreateOrMergePatchOrDeleteShipment
	{

		bool IsPropertyShipmentTypeIdRemoved { get; set; }

		bool IsPropertyStatusIdRemoved { get; set; }

		bool IsPropertyPrimaryOrderIdRemoved { get; set; }

		bool IsPropertyPrimaryReturnIdRemoved { get; set; }

		bool IsPropertyPrimaryShipGroupSeqIdRemoved { get; set; }

		bool IsPropertyPicklistBinIdRemoved { get; set; }

		bool IsPropertyBolNumberRemoved { get; set; }

		bool IsPropertySealNumberRemoved { get; set; }

		bool IsPropertyVehicleIdRemoved { get; set; }

		bool IsPropertyExternalOrderNumberRemoved { get; set; }

		bool IsPropertyCarrierRemoved { get; set; }

		bool IsPropertyDateShippedRemoved { get; set; }

		bool IsPropertyEstimatedReadyDateRemoved { get; set; }

		bool IsPropertyEstimatedShipDateRemoved { get; set; }

		bool IsPropertyEstimatedShipWorkEffIdRemoved { get; set; }

		bool IsPropertyEstimatedArrivalDateRemoved { get; set; }

		bool IsPropertyEstimatedArrivalWorkEffIdRemoved { get; set; }

		bool IsPropertyLatestCancelDateRemoved { get; set; }

		bool IsPropertyEstimatedShipCostRemoved { get; set; }

		bool IsPropertyCurrencyUomIdRemoved { get; set; }

		bool IsPropertyHandlingInstructionsRemoved { get; set; }

		bool IsPropertyOriginFacilityIdRemoved { get; set; }

		bool IsPropertyDestinationFacilityIdRemoved { get; set; }

		bool IsPropertyOriginContactMechIdRemoved { get; set; }

		bool IsPropertyOriginTelecomNumberIdRemoved { get; set; }

		bool IsPropertyDestinationContactMechIdRemoved { get; set; }

		bool IsPropertyDestinationTelecomNumberIdRemoved { get; set; }

		bool IsPropertyPartyIdToRemoved { get; set; }

		bool IsPropertyPartyIdFromRemoved { get; set; }

		bool IsPropertyAdditionalShippingChargeRemoved { get; set; }

		bool IsPropertyAddtlShippingChargeDescRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }

        IShipmentImageCommands ShipmentImageCommands { get; }

        ICreateShipmentImage NewCreateShipmentImage();

        IMergePatchShipmentImage NewMergePatchShipmentImage();

        IRemoveShipmentImage NewRemoveShipmentImage();

        IShipmentItemCommands ShipmentItemCommands { get; }

        ICreateShipmentItem NewCreateShipmentItem();

        IMergePatchShipmentItem NewMergePatchShipmentItem();

        IRemoveShipmentItem NewRemoveShipmentItem();

        IShipmentReceiptCommands ShipmentReceiptCommands { get; }

        ICreateShipmentReceipt NewCreateShipmentReceipt();

        IMergePatchShipmentReceipt NewMergePatchShipmentReceipt();

        IRemoveShipmentReceipt NewRemoveShipmentReceipt();

        IItemIssuanceCommands ItemIssuanceCommands { get; }

        ICreateItemIssuance NewCreateItemIssuance();

        IMergePatchItemIssuance NewMergePatchItemIssuance();

        IRemoveItemIssuance NewRemoveItemIssuance();


	}

	public interface IDeleteShipment : ICreateOrMergePatchOrDeleteShipment
	{
	}

    public interface ICreateShipmentImageCommands : IEnumerable<ICreateShipmentImage>
    {
        void Add(ICreateShipmentImage c);

        void Remove(ICreateShipmentImage c);

        void Clear();

    }

    public interface IShipmentImageCommands : IEnumerable<IShipmentImageCommand>
    {
        void Add(IShipmentImageCommand c);

        void Remove(IShipmentImageCommand c);

        void Clear();

    }

    public interface ICreateShipmentItemCommands : IEnumerable<ICreateShipmentItem>
    {
        void Add(ICreateShipmentItem c);

        void Remove(ICreateShipmentItem c);

        void Clear();

    }

    public interface IShipmentItemCommands : IEnumerable<IShipmentItemCommand>
    {
        void Add(IShipmentItemCommand c);

        void Remove(IShipmentItemCommand c);

        void Clear();

    }

    public interface ICreateShipmentReceiptCommands : IEnumerable<ICreateShipmentReceipt>
    {
        void Add(ICreateShipmentReceipt c);

        void Remove(ICreateShipmentReceipt c);

        void Clear();

    }

    public interface IShipmentReceiptCommands : IEnumerable<IShipmentReceiptCommand>
    {
        void Add(IShipmentReceiptCommand c);

        void Remove(IShipmentReceiptCommand c);

        void Clear();

    }

    public interface ICreateItemIssuanceCommands : IEnumerable<ICreateItemIssuance>
    {
        void Add(ICreateItemIssuance c);

        void Remove(ICreateItemIssuance c);

        void Clear();

    }

    public interface IItemIssuanceCommands : IEnumerable<IItemIssuanceCommand>
    {
        void Add(IItemIssuanceCommand c);

        void Remove(IItemIssuanceCommand c);

        void Clear();

    }


}

