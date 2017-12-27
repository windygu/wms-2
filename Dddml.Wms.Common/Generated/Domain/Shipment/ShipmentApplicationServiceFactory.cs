﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateShipmentDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Shipment;

namespace Dddml.Wms.Domain.Shipment
{

    public partial class ShipmentApplicationServiceFactory : IShipmentApplicationServiceFactory
    {

        public virtual IShipmentApplicationService ShipmentApplicationService 
        {
		    get
		    {
			    return ApplicationContext.Current["ShipmentApplicationService"] as IShipmentApplicationService;
		    }
        }

        public virtual ICreateShipment NewCreateShipment()
        {
		    return new CreateShipment();
        }

        public virtual IMergePatchShipment NewMergePatchShipment()
        {
            return new MergePatchShipment();
        }

        public virtual IDeleteShipment NewDeleteShipment()
        {
            return new DeleteShipment();
        }

    }


}
