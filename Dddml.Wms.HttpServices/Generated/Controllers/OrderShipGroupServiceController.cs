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

    [RoutePrefix("api/OrderShipGroupService")]
    public partial class OrderShipGroupServiceController : ApiController
    {

        IOrderShipGroupApplicationService _orderShipGroupApplicationService = ApplicationContext.Current["OrderShipGroupApplicationService"] as IOrderShipGroupApplicationService;

        [Route("CreatePOShipGroup")]
        [HttpPost][SetRequesterId]
        public void CreatePOShipGroup([FromBody]OrderShipGroupServiceCommandDtos.CreatePOShipGroupDto requestContent)
        {
          try {
             _orderShipGroupApplicationService.When(requestContent.ToCreatePOShipGroup());
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }
        
        [Route("CreateSOShipGroup")]
        [HttpPost][SetRequesterId]
        public void CreateSOShipGroup([FromBody]OrderShipGroupServiceCommandDtos.CreateSOShipGroupDto requestContent)
        {
          try {
             _orderShipGroupApplicationService.When(requestContent.ToCreateSOShipGroup());
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }
        
        [Route("UpdateOrderItemShipGroupAssociation")]
        [HttpPost][SetRequesterId]
        public void UpdateOrderItemShipGroupAssociation([FromBody]OrderShipGroupServiceCommandDtos.UpdateOrderItemShipGroupAssociationDto requestContent)
        {
          try {
             _orderShipGroupApplicationService.When(requestContent.ToUpdateOrderItemShipGroupAssociation());
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }
        
        [Route("CreatePOShipment")]
        [HttpPost][SetRequesterId]
        public string CreatePOShipment([FromBody]OrderShipGroupServiceCommandDtos.CreatePOShipmentDto requestContent)
        {
          try {
            return _orderShipGroupApplicationService.When(requestContent.ToCreatePOShipment());
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }
        
        [Route("CreateSOShipment")]
        [HttpPost][SetRequesterId]
        public string CreateSOShipment([FromBody]OrderShipGroupServiceCommandDtos.CreateSOShipmentDto requestContent)
        {
          try {
            return _orderShipGroupApplicationService.When(requestContent.ToCreateSOShipment());
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }
        
        [Route("Ship")]
        [HttpPost][SetRequesterId]
        public void Ship([FromBody]OrderShipGroupServiceCommandDtos.ShipDto requestContent)
        {
          try {
             _orderShipGroupApplicationService.When(requestContent.ToShip());
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }
        
    }

}

