﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateOrderItemShipGrpInvReservationDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.OrderItemShipGrpInvReservation;

namespace Dddml.Wms.Domain.OrderItemShipGrpInvReservation
{

	public static partial class OrderItemShipGrpInvReservationStateExtension
	{

        public static IOrderItemShipGrpInvReservationCommand ToCreateOrMergePatchOrderItemShipGrpInvReservation(this OrderItemShipGrpInvReservationState state)
        {
            return state.ToCreateOrMergePatchOrderItemShipGrpInvReservation<CreateOrderItemShipGrpInvReservation, MergePatchOrderItemShipGrpInvReservation>();
        }

        public static DeleteOrderItemShipGrpInvReservation ToDeleteOrderItemShipGrpInvReservation(this OrderItemShipGrpInvReservationState state)
        {
            return state.ToDeleteOrderItemShipGrpInvReservation<DeleteOrderItemShipGrpInvReservation>();
        }

        public static MergePatchOrderItemShipGrpInvReservation ToMergePatchOrderItemShipGrpInvReservation(this OrderItemShipGrpInvReservationState state)
        {
            return state.ToMergePatchOrderItemShipGrpInvReservation<MergePatchOrderItemShipGrpInvReservation>();
        }

        public static CreateOrderItemShipGrpInvReservation ToCreateOrderItemShipGrpInvReservation(this OrderItemShipGrpInvReservationState state)
        {
            return state.ToCreateOrderItemShipGrpInvReservation<CreateOrderItemShipGrpInvReservation>();
        }
		

	}

}
