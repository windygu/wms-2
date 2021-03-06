﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateBoundedContextDomainAggregates.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.RolePermission;

namespace Dddml.Wms.Domain.RolePermission
{

	public static partial class RolePermissionStateDtoExtension
	{

        public static IRolePermissionCommand ToCreateOrMergePatchRolePermission(this RolePermissionStateDtoWrapper state)
        {
            return state.ToCreateOrMergePatchRolePermission<CreateRolePermissionDto, MergePatchRolePermissionDto>();
        }

        public static DeleteRolePermissionDto ToDeleteRolePermission(this RolePermissionStateDtoWrapper state)
        {
            return state.ToDeleteRolePermission<DeleteRolePermissionDto>();
        }

        public static MergePatchRolePermissionDto ToMergePatchRolePermission(this RolePermissionStateDtoWrapper state)
        {
            return state.ToMergePatchRolePermission<MergePatchRolePermissionDto>();
        }

        public static CreateRolePermissionDto ToCreateRolePermission(this RolePermissionStateDtoWrapper state)
        {
            return state.ToCreateRolePermission<CreateRolePermissionDto>();
        }
		

	}

}

