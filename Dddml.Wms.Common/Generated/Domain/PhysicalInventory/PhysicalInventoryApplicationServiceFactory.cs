﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePhysicalInventoryDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;

namespace Dddml.Wms.Domain.PhysicalInventory
{

    public partial class PhysicalInventoryApplicationServiceFactory : IPhysicalInventoryApplicationServiceFactory
    {

        public virtual IPhysicalInventoryApplicationService PhysicalInventoryApplicationService 
        {
		    get
		    {
			    return ApplicationContext.Current["PhysicalInventoryApplicationService"] as IPhysicalInventoryApplicationService;
		    }
        }

        public virtual ICreatePhysicalInventory NewCreatePhysicalInventory()
        {
		    return new CreatePhysicalInventory();
        }

        public virtual IMergePatchPhysicalInventory NewMergePatchPhysicalInventory()
        {
            return new MergePatchPhysicalInventory();
        }

        public virtual IDeletePhysicalInventory NewDeletePhysicalInventory()
        {
            return new DeletePhysicalInventory();
        }

    }


}

