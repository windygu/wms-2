﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;

namespace Dddml.Wms.Domain.PhysicalInventory
{
	public interface IPhysicalInventoryCommand : IAggregateCommand<string, long>, ICommandDto
	{
		long Version { get; set; }

		string DocumentNumber { get; set; }

	}


	public interface ICreateOrMergePatchOrDeletePhysicalInventory : IPhysicalInventoryCommand
	{

		string DocumentAction { get; set; }

		string WarehouseId { get; set; }

		bool? Posted { get; set; }

		bool? Processed { get; set; }

		string Processing { get; set; }

		string DocumentTypeId { get; set; }

		DateTime? MovementDate { get; set; }

		string Description { get; set; }

		bool? IsApproved { get; set; }

		decimal? ApprovalAmount { get; set; }

		bool? IsQuantityUpdated { get; set; }

		string ReversalDocumentNumber { get; set; }

		bool? Active { get; set; }


	}

	public interface ICreatePhysicalInventory : ICreateOrMergePatchOrDeletePhysicalInventory
	{
        ICreatePhysicalInventoryLineCommands PhysicalInventoryLines { get; }

        ICreatePhysicalInventoryLine NewCreatePhysicalInventoryLine();

	}

	public interface IMergePatchPhysicalInventory : ICreateOrMergePatchOrDeletePhysicalInventory
	{

		bool IsPropertyWarehouseIdRemoved { get; set; }

		bool IsPropertyPostedRemoved { get; set; }

		bool IsPropertyProcessedRemoved { get; set; }

		bool IsPropertyProcessingRemoved { get; set; }

		bool IsPropertyDocumentTypeIdRemoved { get; set; }

		bool IsPropertyMovementDateRemoved { get; set; }

		bool IsPropertyDescriptionRemoved { get; set; }

		bool IsPropertyIsApprovedRemoved { get; set; }

		bool IsPropertyApprovalAmountRemoved { get; set; }

		bool IsPropertyIsQuantityUpdatedRemoved { get; set; }

		bool IsPropertyReversalDocumentNumberRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }

        IPhysicalInventoryLineCommands PhysicalInventoryLineCommands { get; }

        ICreatePhysicalInventoryLine NewCreatePhysicalInventoryLine();

        IMergePatchPhysicalInventoryLine NewMergePatchPhysicalInventoryLine();

        IRemovePhysicalInventoryLine NewRemovePhysicalInventoryLine();


	}

	public interface IDeletePhysicalInventory : ICreateOrMergePatchOrDeletePhysicalInventory
	{
	}

    public interface ICreatePhysicalInventoryLineCommands : IEnumerable<ICreatePhysicalInventoryLine>
    {
        void Add(ICreatePhysicalInventoryLine c);

        void Remove(ICreatePhysicalInventoryLine c);

        void Clear();

    }

    public interface IPhysicalInventoryLineCommands : IEnumerable<IPhysicalInventoryLineCommand>
    {
        void Add(IPhysicalInventoryLineCommand c);

        void Remove(IPhysicalInventoryLineCommand c);

        void Clear();

    }


}
