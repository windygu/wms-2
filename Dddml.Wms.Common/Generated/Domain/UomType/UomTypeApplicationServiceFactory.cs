﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateUomTypeDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.UomType;

namespace Dddml.Wms.Domain.UomType
{

    public partial class UomTypeApplicationServiceFactory : IUomTypeApplicationServiceFactory
    {

        public virtual IUomTypeApplicationService UomTypeApplicationService 
        {
		    get
		    {
			    return ApplicationContext.Current["UomTypeApplicationService"] as IUomTypeApplicationService;
		    }
        }

        public virtual ICreateUomType NewCreateUomType()
        {
		    return new CreateUomType();
        }

        public virtual IMergePatchUomType NewMergePatchUomType()
        {
            return new MergePatchUomType();
        }

        public virtual IDeleteUomType NewDeleteUomType()
        {
            return new DeleteUomType();
        }

    }


}

