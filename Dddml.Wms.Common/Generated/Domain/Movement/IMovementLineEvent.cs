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
	public interface IMovementLineEvent : IEvent, IEventDto, IGlobalIdentity<MovementLineEventId>, ICreated<string>
	{
		MovementLineEventId MovementLineEventId { get; }

        bool ReadOnly { get; set; }

		// Outer Id:
		//string MovementDocumentNumber { get; set; }

	}

    public interface IMovementLineStateEvent : IMovementLineEvent
    {
		long Version { get; set; }

		decimal? MovementQuantity { get; set; }

		string ProductId { get; set; }

		string LocatorIdFrom { get; set; }

		string LocatorIdTo { get; set; }

		string AttributeSetInstanceId { get; set; }

		bool? Processed { get; set; }

		string ReversalLineNumber { get; set; }

		bool? Active { get; set; }

    }
   
	public interface IMovementLineStateCreated : IMovementLineStateEvent
	{
	
	}


	public interface IMovementLineStateMergePatched : IMovementLineStateEvent
	{
		bool IsPropertyMovementQuantityRemoved { get; set; }

		bool IsPropertyProductIdRemoved { get; set; }

		bool IsPropertyLocatorIdFromRemoved { get; set; }

		bool IsPropertyLocatorIdToRemoved { get; set; }

		bool IsPropertyAttributeSetInstanceIdRemoved { get; set; }

		bool IsPropertyProcessedRemoved { get; set; }

		bool IsPropertyReversalLineNumberRemoved { get; set; }

		bool IsPropertyActiveRemoved { get; set; }


	}

	public interface IMovementLineStateRemoved : IMovementLineStateEvent
	{
	}


}

