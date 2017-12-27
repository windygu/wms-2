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
	public interface IMovementLineCommand : ICommand, ICommandDto
	{
		// Outer Id:

		string MovementDocumentNumber { get; set; }

		string LineNumber { get; set; }

	}


	public interface ICreateOrMergePatchOrRemoveMovementLine : IMovementLineCommand
	{

		decimal? MovementQuantity { get; set; }

		string ProductId { get; set; }

		string LocatorIdFrom { get; set; }

		string LocatorIdTo { get; set; }

		string AttributeSetInstanceIdFrom { get; set; }

		string AttributeSetInstanceIdTo { get; set; }

		bool? Processed { get; set; }

		string ReversalLineNumber { get; set; }

		bool? Active { get; set; }


	}

	public interface ICreateMovementLine : ICreateOrMergePatchOrRemoveMovementLine
	{
	}

	public interface IMergePatchMovementLine : ICreateOrMergePatchOrRemoveMovementLine
	{

		bool IsPropertyMovementQuantityRemoved { get; set; }

		bool IsPropertyProductIdRemoved { get; set; }

		bool IsPropertyLocatorIdFromRemoved { get; set; }

		bool IsPropertyLocatorIdToRemoved { get; set; }

		bool IsPropertyAttributeSetInstanceIdFromRemoved { get; set; }

		bool IsPropertyAttributeSetInstanceIdToRemoved { get; set; }

		bool IsPropertyProcessedRemoved { get; set; }

		bool IsPropertyReversalLineNumberRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }


	}

	public interface IRemoveMovementLine : ICreateOrMergePatchOrRemoveMovementLine
	{
	}


}
