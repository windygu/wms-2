﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateMovementConfirmationDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.MovementConfirmation;

namespace Dddml.Wms.Domain.MovementConfirmation
{
	public interface IMovementConfirmationLineCommand : ICommand, ICommandDto
	{
		// Outer Id:

		string MovementConfirmationDocumentNumber { get; set; }

		string LineNumber { get; set; }

	}


	public interface ICreateOrMergePatchOrRemoveMovementConfirmationLine : IMovementConfirmationLineCommand
	{

		string MovementLineNumber { get; set; }

		decimal? TargetQuantity { get; set; }

		decimal? ConfirmedQuantity { get; set; }

		decimal? DifferenceQuantity { get; set; }

		decimal? ScrappedQuantity { get; set; }

		string Description { get; set; }

		bool? Processed { get; set; }

		bool? Active { get; set; }


	}

	public interface ICreateMovementConfirmationLine : ICreateOrMergePatchOrRemoveMovementConfirmationLine
	{
	}

	public interface IMergePatchMovementConfirmationLine : ICreateOrMergePatchOrRemoveMovementConfirmationLine
	{

		bool IsPropertyMovementLineNumberRemoved { get; set; }

		bool IsPropertyTargetQuantityRemoved { get; set; }

		bool IsPropertyConfirmedQuantityRemoved { get; set; }

		bool IsPropertyDifferenceQuantityRemoved { get; set; }

		bool IsPropertyScrappedQuantityRemoved { get; set; }

		bool IsPropertyDescriptionRemoved { get; set; }

		bool IsPropertyProcessedRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }


	}

	public interface IRemoveMovementConfirmationLine : ICreateOrMergePatchOrRemoveMovementConfirmationLine
	{
	}


}

