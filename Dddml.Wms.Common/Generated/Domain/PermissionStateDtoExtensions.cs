﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;

namespace Dddml.Wms.Domain
{

	public static partial class PermissionStateDtoExtensions
	{

        public static IPermissionCommand ToCreateOrMergePatchPermission(this PermissionStateDto state)
        {
            return state.ToCreateOrMergePatchPermission<CreatePermissionDto, MergePatchPermissionDto>();
        }

        public static DeletePermissionDto ToDeletePermission(this PermissionStateDto state)
        {
            return state.ToDeletePermission<DeletePermissionDto>();
        }

        public static MergePatchPermissionDto ToMergePatchPermission(this PermissionStateDto state)
        {
            return state.ToMergePatchPermission<MergePatchPermissionDto>();
        }

        public static CreatePermissionDto ToCreatePermission(this PermissionStateDto state)
        {
            return state.ToCreatePermission<CreatePermissionDto>();
        }
		

	}

}

