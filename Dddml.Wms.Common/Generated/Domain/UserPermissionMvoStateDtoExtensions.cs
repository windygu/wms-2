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

	public static partial class UserPermissionMvoStateDtoExtensions
	{

        public static IUserPermissionMvoCommand ToCreateOrMergePatchUserPermissionMvo(this UserPermissionMvoStateDto state)
        {
            return state.ToCreateOrMergePatchUserPermissionMvo<CreateUserPermissionMvoDto, MergePatchUserPermissionMvoDto>();
        }

        public static DeleteUserPermissionMvoDto ToDeleteUserPermissionMvo(this UserPermissionMvoStateDto state)
        {
            return state.ToDeleteUserPermissionMvo<DeleteUserPermissionMvoDto>();
        }

        public static MergePatchUserPermissionMvoDto ToMergePatchUserPermissionMvo(this UserPermissionMvoStateDto state)
        {
            return state.ToMergePatchUserPermissionMvo<MergePatchUserPermissionMvoDto>();
        }

        public static CreateUserPermissionMvoDto ToCreateUserPermissionMvo(this UserPermissionMvoStateDto state)
        {
            return state.ToCreateUserPermissionMvo<CreateUserPermissionMvoDto>();
        }
		

	}

}

