﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateGoodIdentificationMvoDomain.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.GoodIdentificationMvo;
using Dddml.Wms.Domain.Product;

namespace Dddml.Wms.Domain.GoodIdentificationMvo
{

    public partial class GoodIdentificationMvoApplicationServiceFactory : IGoodIdentificationMvoApplicationServiceFactory
    {

        public virtual IGoodIdentificationMvoApplicationService GoodIdentificationMvoApplicationService 
        {
		    get
		    {
			    return ApplicationContext.Current["GoodIdentificationMvoApplicationService"] as IGoodIdentificationMvoApplicationService;
		    }
        }

        public virtual ICreateGoodIdentificationMvo NewCreateGoodIdentificationMvo()
        {
		    return new CreateGoodIdentificationMvo();
        }

        public virtual IMergePatchGoodIdentificationMvo NewMergePatchGoodIdentificationMvo()
        {
            return new MergePatchGoodIdentificationMvo();
        }

        public virtual IDeleteGoodIdentificationMvo NewDeleteGoodIdentificationMvo()
        {
            return new DeleteGoodIdentificationMvo();
        }

    }


}
