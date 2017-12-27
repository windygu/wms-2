﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateMovementDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Movement;

namespace Dddml.Wms.Domain.Movement
{
	public interface IMovementCommand : IAggregateCommand<string, long>, ICommandDto
	{
		long Version { get; set; }

		string DocumentNumber { get; set; }

	}


	public interface ICreateOrMergePatchOrDeleteMovement : IMovementCommand
	{

		string DocumentAction { get; set; }

		DateTime? MovementDate { get; set; }

		bool? Posted { get; set; }

		bool? Processed { get; set; }

		string Processing { get; set; }

		DateTime? DateReceived { get; set; }

		string DocumentTypeId { get; set; }

		bool? IsInTransit { get; set; }

		bool? IsApproved { get; set; }

		decimal? ApprovalAmount { get; set; }

		string ShipperId { get; set; }

		string SalesRepresentativeId { get; set; }

		string BusinessPartnerId { get; set; }

		decimal? ChargeAmount { get; set; }

		string CreateFrom { get; set; }

		decimal? FreightAmount { get; set; }

		string ReversalDocumentNumber { get; set; }

		string WarehouseIdFrom { get; set; }

		string WarehouseIdTo { get; set; }

		string Description { get; set; }

		bool? Active { get; set; }


	}

	public interface ICreateMovement : ICreateOrMergePatchOrDeleteMovement
	{
        ICreateMovementLineCommands MovementLines { get; }

        ICreateMovementLine NewCreateMovementLine();

	}

	public interface IMergePatchMovement : ICreateOrMergePatchOrDeleteMovement
	{

		bool IsPropertyMovementDateRemoved { get; set; }

		bool IsPropertyPostedRemoved { get; set; }

		bool IsPropertyProcessedRemoved { get; set; }

		bool IsPropertyProcessingRemoved { get; set; }

		bool IsPropertyDateReceivedRemoved { get; set; }

		bool IsPropertyDocumentTypeIdRemoved { get; set; }

		bool IsPropertyIsInTransitRemoved { get; set; }

		bool IsPropertyIsApprovedRemoved { get; set; }

		bool IsPropertyApprovalAmountRemoved { get; set; }

		bool IsPropertyShipperIdRemoved { get; set; }

		bool IsPropertySalesRepresentativeIdRemoved { get; set; }

		bool IsPropertyBusinessPartnerIdRemoved { get; set; }

		bool IsPropertyChargeAmountRemoved { get; set; }

		bool IsPropertyCreateFromRemoved { get; set; }

		bool IsPropertyFreightAmountRemoved { get; set; }

		bool IsPropertyReversalDocumentNumberRemoved { get; set; }

		bool IsPropertyWarehouseIdFromRemoved { get; set; }

		bool IsPropertyWarehouseIdToRemoved { get; set; }

		bool IsPropertyDescriptionRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }

        IMovementLineCommands MovementLineCommands { get; }

        ICreateMovementLine NewCreateMovementLine();

        IMergePatchMovementLine NewMergePatchMovementLine();

        IRemoveMovementLine NewRemoveMovementLine();


	}

	public interface IDeleteMovement : ICreateOrMergePatchOrDeleteMovement
	{
	}

    public interface ICreateMovementLineCommands : IEnumerable<ICreateMovementLine>
    {
        void Add(ICreateMovementLine c);

        void Remove(ICreateMovementLine c);

        void Clear();

    }

    public interface IMovementLineCommands : IEnumerable<IMovementLineCommand>
    {
        void Add(IMovementLineCommand c);

        void Remove(IMovementLineCommand c);

        void Clear();

    }


}
