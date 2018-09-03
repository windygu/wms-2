﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAggregatesControllers.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ShipmentMethodType;
using Dddml.Wms.Domain.Metadata;
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

    [RoutePrefix("api/ShipmentMethodTypes")]
    public partial class ShipmentMethodTypesController : ApiController
    {

        IShipmentMethodTypeApplicationService _shipmentMethodTypeApplicationService = ApplicationContext.Current["ShipmentMethodTypeApplicationService"] as IShipmentMethodTypeApplicationService;

        [Route(Order = 1)]
        [HttpGet]
        public IEnumerable<IShipmentMethodTypeStateDto> GetAll(string sort = null, string fields = null, int firstResult = 0, int maxResults = int.MaxValue, string filter = null)
        {
          try {
            IEnumerable<IShipmentMethodTypeState> states = null; 
            if (!String.IsNullOrWhiteSpace(filter))
            {
                states = _shipmentMethodTypeApplicationService.Get(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new WebApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (ShipmentMethodTypeMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? ShipmentMethodTypeMetadata.Instance.FilteringPropertyAliasDictionary[n] : n))
                    , ShipmentMethodTypesControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            else 
            {
                states = _shipmentMethodTypeApplicationService.Get(ShipmentMethodTypesControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs())
                    , ShipmentMethodTypesControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            var stateDtos = new List<IShipmentMethodTypeStateDto>();
            foreach (var s in states)
            {
                var dto = s is ShipmentMethodTypeStateDtoWrapper ? (ShipmentMethodTypeStateDtoWrapper)s : new ShipmentMethodTypeStateDtoWrapper(s);
                if (String.IsNullOrWhiteSpace(fields))
                {
                    dto.AllFieldsReturned = true;
                }
                else
                {
                    dto.ReturnedFieldsString = fields;
                }
                stateDtos.Add(dto);
            }
            return stateDtos;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpGet]
        public IShipmentMethodTypeStateDto Get(string id, string fields = null)
        {
          try {
            var idObj = id;
            var state = _shipmentMethodTypeApplicationService.Get(idObj);
            if (state == null) { return null; }
            var stateDto = new ShipmentMethodTypeStateDtoWrapper(state);
            if (String.IsNullOrWhiteSpace(fields))
            {
                stateDto.AllFieldsReturned = true;
            }
            else
            {
                stateDto.ReturnedFieldsString = fields;
            }
            return stateDto;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }


        [Route("_count")]
        [HttpGet]
        public long GetCount(string filter = null)
        {
          try {
            long count = 0;
            if (!String.IsNullOrWhiteSpace(filter))
            {
                count = _shipmentMethodTypeApplicationService.GetCount(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new WebApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (ShipmentMethodTypeMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? ShipmentMethodTypeMetadata.Instance.FilteringPropertyAliasDictionary[n] : n)));
            }
            else 
            {
                count = _shipmentMethodTypeApplicationService.GetCount(ShipmentMethodTypesControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs()));
            }
            return count;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route(Order = 1)]
        [HttpPost][SetRequesterId]
        public HttpResponseMessage Post([FromBody]CreateShipmentMethodTypeDto value)
        {
          try {
            if (value.ShipmentMethodTypeId == default(string))
            {
                throw DomainError.Named("nullId", "Aggregate Id in cmd is null, aggregate name: {0}.", "ShipmentMethodType");
            }
            _shipmentMethodTypeApplicationService.When(value as ICreateShipmentMethodType);
            var idObj = value.ShipmentMethodTypeId;

            return Request.CreateResponse<string>(HttpStatusCode.Created, idObj);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPut][SetRequesterId]
        public void Put(string id, [FromBody]CreateOrMergePatchOrDeleteShipmentMethodTypeDto value)
        {
          try {
              // ///////////////////////////////
              if (value.Version != default(long))
              {
                  value.CommandType = CommandType.MergePatch;
                  ShipmentMethodTypesControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
                  _shipmentMethodTypeApplicationService.When(value as IMergePatchShipmentMethodType);
                  return;
              }
              // ///////////////////////////////

            ShipmentMethodTypesControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _shipmentMethodTypeApplicationService.When(value as ICreateShipmentMethodType);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPatch][SetRequesterId]
        public void Patch(string id, [FromBody]MergePatchShipmentMethodTypeDto value)
        {
          try {
            ShipmentMethodTypesControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _shipmentMethodTypeApplicationService.When(value as IMergePatchShipmentMethodType);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpDelete][SetRequesterId]
        public void Delete(string id, string commandId, string version, string requesterId = default(string))
        {
          try {
            var value = new DeleteShipmentMethodTypeDto();
            value.CommandId = commandId;
            value.RequesterId = requesterId;
            value.Version = (long)Convert.ChangeType(version, typeof(long));
            ShipmentMethodTypesControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _shipmentMethodTypeApplicationService.When(value as IDeleteShipmentMethodType);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("_metadata/filteringFields")]
        [HttpGet]
        public IEnumerable<PropertyMetadataDto> GetMetadataFilteringFields()
        {
          try {
            var filtering = new List<PropertyMetadataDto>();
            foreach (var p in ShipmentMethodTypeMetadata.Instance.Properties)
            {
                if (p.IsFilteringProperty)
                {
                    var pdto = new PropertyMetadataDto(p.Name, p.TypeName, p.IsFilteringProperty,
                       !String.IsNullOrWhiteSpace(p.SourceChainingName) ? p.SourceChainingName :
                       (!String.IsNullOrWhiteSpace(p.DerivedFrom) ? p.DerivedFrom : p.Name));
                    filtering.Add(pdto);
                }
            }
            return filtering;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_stateEvents/{version}")]
        [HttpGet]
        public ShipmentMethodTypeStateCreatedOrMergePatchedOrDeletedDto GetStateEvent(string id, long version)
        {
          try {
            var idObj = id;
            var conv = new ShipmentMethodTypeStateEventDtoConverter();
            var se = _shipmentMethodTypeApplicationService.GetEvent(idObj, version);
            return se == null ? null : conv.ToShipmentMethodTypeStateEventDto(se);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_historyStates/{version}")]
        [HttpGet]
        public IShipmentMethodTypeStateDto GetHistoryState(string id, long version, string fields = null)
        {
          try {
            var idObj = id;
            var state = _shipmentMethodTypeApplicationService.GetHistoryState(idObj, version);
            if (state == null) { return null; }
            var stateDto = new ShipmentMethodTypeStateDtoWrapper(state);
            if (String.IsNullOrWhiteSpace(fields))
            {
                stateDto.AllFieldsReturned = true;
            }
            else
            {
                stateDto.ReturnedFieldsString = fields;
            }
            return stateDto;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }


		// /////////////////////////////////////////////////

        protected virtual string QueryOrderSeparator
        {
            get { return ","; }
        }

        // ////////////////////////////////

        private class PropertyTypeResolver : IPropertyTypeResolver
        {

            public Type ResolveTypeByPropertyName(string propertyName)
            {
                return ShipmentMethodTypesControllerUtils.GetFilterPropertyType(propertyName);
            }
        }

    }


    
    public static class ShipmentMethodTypesControllerUtils
    {

        public static void SetNullIdOrThrowOnInconsistentIds(string id, CreateOrMergePatchOrDeleteShipmentMethodTypeDto value)
        {
            var idObj = id;
            if (value.ShipmentMethodTypeId == null)
            {
                value.ShipmentMethodTypeId = idObj;
            }
            else if (!((ICreateOrMergePatchOrDeleteShipmentMethodType)value).ShipmentMethodTypeId.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.ShipmentMethodTypeId);
            }
        }


        public static string GetFilterPropertyName(string fieldName)
        {
            if (String.Equals(fieldName, "sort", StringComparison.InvariantCultureIgnoreCase)
                || String.Equals(fieldName, "firstResult", StringComparison.InvariantCultureIgnoreCase)
                || String.Equals(fieldName, "maxResults", StringComparison.InvariantCultureIgnoreCase)
                || String.Equals(fieldName, "fields", StringComparison.InvariantCultureIgnoreCase))
            {
                return null;
            }
            if (ShipmentMethodTypeMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(fieldName))
            {
                return ShipmentMethodTypeMetadata.Instance.FilteringPropertyAliasDictionary[fieldName];
            }
            return null;
        }

        public static Type GetFilterPropertyType(string propertyName)
        {
            if (ShipmentMethodTypeMetadata.Instance.PropertyMetadataDictionary.ContainsKey(propertyName))
            {
                return ShipmentMethodTypeMetadata.Instance.PropertyMetadataDictionary[propertyName].Type;
            }
            return typeof(string);
        }

        public static IDictionary<string, object> GetQueryFilterDictionary(IEnumerable<KeyValuePair<string, string>> queryNameValuePairs)
        {
            var filter = new Dictionary<string, object>();
            foreach (var p in queryNameValuePairs)
            {
                var pName = GetFilterPropertyName(p.Key);
                if (!String.IsNullOrWhiteSpace(pName))
                {
                    Type type = GetFilterPropertyType(pName);
                    var pValue = ApplicationContext.Current.TypeConverter.ConvertFromString(type, p.Value);
                    filter.Add(pName, pValue);
                }
            }
            return filter;
        }

        public static IList<string> GetQueryOrders(string str, string separator)
        {
            if (String.IsNullOrWhiteSpace(str))
            {
                return new string[0];
            }
            var arr = str.Split(new string[] { separator }, StringSplitOptions.RemoveEmptyEntries);
            var orders = new List<string>();
            foreach (var a in arr)
            {
                orders.Add(a.Trim());
            }
            return orders;
        }

        public static IEnumerable<IShipmentMethodTypeStateDto> ToShipmentMethodTypeStateDtoCollection(IEnumerable<string> ids)
        {
            var states = new List<IShipmentMethodTypeStateDto>();
            foreach (var id in ids)
            {
                var dto = new ShipmentMethodTypeStateDtoWrapper();
                dto.ShipmentMethodTypeId = id;
                states.Add(dto);
            }
            return states;
        }

        public static IEnumerable<IShipmentMethodTypeState> ToShipmentMethodTypeStateCollection(IEnumerable<string> ids)
        {
            var states = new List<ShipmentMethodTypeState>();
            foreach (var id in ids)
            {
                var s = new ShipmentMethodTypeState();
                s.ShipmentMethodTypeId = id;
                states.Add(s);
            }
            return states;
        }

    }

}

