﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateInventoryPRTriggeredDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryPRTriggered;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Domain.InventoryPRTriggered
{
	public interface IInventoryPRTriggeredCommand : IAggregateCommand<InventoryPRTriggeredId, long>, ICommandDto
	{
		long Version { get; set; }

		InventoryPRTriggeredId InventoryPRTriggeredId { get; set; }

	}


	public interface ICreateOrMergePatchOrDeleteInventoryPRTriggered : IInventoryPRTriggeredCommand
	{

		bool? IsProcessed { get; set; }

		bool? Active { get; set; }


	}

	public interface ICreateInventoryPRTriggered : ICreateOrMergePatchOrDeleteInventoryPRTriggered
	{
	}

	public interface IMergePatchInventoryPRTriggered : ICreateOrMergePatchOrDeleteInventoryPRTriggered
	{

		bool IsPropertyIsProcessedRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }


	}

	public interface IDeleteInventoryPRTriggered : ICreateOrMergePatchOrDeleteInventoryPRTriggered
	{
	}


}

