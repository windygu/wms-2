﻿// <autogenerated>
//   This file was generated by T4 code generator GeneratePickwaveDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Pickwave;

namespace Dddml.Wms.Domain.Pickwave
{

    public partial class PickwaveApplicationServiceFactory : IPickwaveApplicationServiceFactory
    {

        public virtual IPickwaveApplicationService PickwaveApplicationService 
        {
		    get
		    {
			    return ApplicationContext.Current["PickwaveApplicationService"] as IPickwaveApplicationService;
		    }
        }

        public virtual ICreatePickwave NewCreatePickwave()
        {
		    return new CreatePickwave();
        }

        public virtual IMergePatchPickwave NewMergePatchPickwave()
        {
            return new MergePatchPickwave();
        }

        public virtual IDeletePickwave NewDeletePickwave()
        {
            return new DeletePickwave();
        }

    }


}

