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

	public static partial class UserRoleStateExtensions
	{

        public static IUserRoleCommand ToCreateOrMergePatchUserRole(this UserRoleState state)
        {
            bool bUnsaved = ((IUserRoleState)state).IsUnsaved;
            if (bUnsaved)
            {
                return state.ToCreateUserRole();
            }
            else 
            {
                return state.ToMergePatchUserRole();
            }
        }

        public static RemoveUserRole ToRemoveUserRole(this UserRoleState state)
        {
            var cmd = new RemoveUserRole();
            cmd.RoleId = state.RoleId;
            return cmd;
        }

        public static MergePatchUserRole ToMergePatchUserRole(this UserRoleState state)
        {
            var cmd = new MergePatchUserRole();

            cmd.RoleId = state.RoleId;
            cmd.Active = state.Active;
            cmd.UserId = state.UserId;
            
            return cmd;
        }

        public static CreateUserRole ToCreateUserRole(this UserRoleState state)
        {
            var cmd = new CreateUserRole();

            cmd.RoleId = state.RoleId;
            cmd.Active = state.Active;
            cmd.UserId = state.UserId;
            return cmd;
        }
		

	}

}
