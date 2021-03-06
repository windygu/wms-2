﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentPackageDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ShipmentPackage;

namespace Dddml.Wms.Domain.ShipmentPackage
{

    public interface IShipmentPackageContentStates : IEnumerable<IShipmentPackageContentState>, ISaveable
    {
        
        IShipmentPackageContentState Get(string shipmentItemSeqId);

        IShipmentPackageContentState Get(string shipmentItemSeqId, bool forCreation);

        IShipmentPackageContentState Get(string shipmentItemSeqId, bool forCreation, bool nullAllowed);
        
        void Remove(IShipmentPackageContentState state);

        void AddToSave(IShipmentPackageContentState state);
        
    }

}


