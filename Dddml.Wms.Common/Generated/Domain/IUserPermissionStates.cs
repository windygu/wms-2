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

    public interface IUserPermissionStates : IEnumerable<IUserPermissionState>, ISaveable
    {
        
        IUserPermissionState Get(string permissionId);

        IUserPermissionState Get(string permissionId, bool forCreation);

        IUserPermissionState Get(string permissionId, bool forCreation, bool nullAllowed);
        
        void Remove(IUserPermissionState state);

        void AddToSave(IUserPermissionState state);
        
    }

}


