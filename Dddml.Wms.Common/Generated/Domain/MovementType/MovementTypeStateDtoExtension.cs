﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateMovementTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.MovementType;

namespace Dddml.Wms.Domain.MovementType
{

	public static partial class MovementTypeStateDtoExtension
	{

        public static IMovementTypeCommand ToCreateOrMergePatchMovementType(this MovementTypeStateDtoWrapper state)
        {
            return state.ToCreateOrMergePatchMovementType<CreateMovementTypeDto, MergePatchMovementTypeDto>();
        }

        public static DeleteMovementTypeDto ToDeleteMovementType(this MovementTypeStateDtoWrapper state)
        {
            return state.ToDeleteMovementType<DeleteMovementTypeDto>();
        }

        public static MergePatchMovementTypeDto ToMergePatchMovementType(this MovementTypeStateDtoWrapper state)
        {
            return state.ToMergePatchMovementType<MergePatchMovementTypeDto>();
        }

        public static CreateMovementTypeDto ToCreateMovementType(this MovementTypeStateDtoWrapper state)
        {
            return state.ToCreateMovementType<CreateMovementTypeDto>();
        }
		

	}

}
