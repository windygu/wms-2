﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateDomainServicesControllers.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Services;
using Dddml.Wms.HttpServices.Filters;
using System.Linq;
using System.Net;
using System.ComponentModel;
using System.Net.Http;
using System.Net.Http.Formatting;
using System.Web.Http;
using Newtonsoft.Json.Linq;
using Dddml.Support.Criterion;

namespace Dddml.Wms.HttpServices.ApiControllers
{

    [RoutePrefix("api/IdService")]
    public partial class IdServiceController : ApiController
    {

        IIdApplicationService _idApplicationService = ApplicationContext.Current["IdApplicationService"] as IIdApplicationService;

        [Route("GetDocumentNumber")]
        [HttpPost][SetRequesterId]
        public string GetDocumentNumber([FromBody]IdServiceCommandDtos.GetDocumentNumberDto requestContent)
        {
            return _idApplicationService.When(requestContent.ToGetDocumentNumber());
        }
        
    }

}
