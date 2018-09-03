﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAggregatesControllers.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Warehouse;
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

    [RoutePrefix("api/Warehouses")]
    public partial class WarehousesController : ApiController
    {

        IWarehouseApplicationService _warehouseApplicationService = ApplicationContext.Current["WarehouseApplicationService"] as IWarehouseApplicationService;

        [Route(Order = 1)]
        [HttpGet]
        public IEnumerable<IWarehouseStateDto> GetAll(string sort = null, string fields = null, int firstResult = 0, int maxResults = int.MaxValue, string filter = null)
        {
          try {
            IEnumerable<IWarehouseState> states = null; 
            if (!String.IsNullOrWhiteSpace(filter))
            {
                states = _warehouseApplicationService.Get(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new WebApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (WarehouseMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? WarehouseMetadata.Instance.FilteringPropertyAliasDictionary[n] : n))
                    , WarehousesControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            else 
            {
                states = _warehouseApplicationService.Get(WarehousesControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs())
                    , WarehousesControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            var stateDtos = new List<IWarehouseStateDto>();
            foreach (var s in states)
            {
                var dto = s is WarehouseStateDtoWrapper ? (WarehouseStateDtoWrapper)s : new WarehouseStateDtoWrapper(s);
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
        public IWarehouseStateDto Get(string id, string fields = null)
        {
          try {
            var idObj = id;
            var state = _warehouseApplicationService.Get(idObj);
            if (state == null) { return null; }
            var stateDto = new WarehouseStateDtoWrapper(state);
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
                count = _warehouseApplicationService.GetCount(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new WebApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (WarehouseMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? WarehouseMetadata.Instance.FilteringPropertyAliasDictionary[n] : n)));
            }
            else 
            {
                count = _warehouseApplicationService.GetCount(WarehousesControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs()));
            }
            return count;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route(Order = 1)]
        [HttpPost][SetRequesterId]
        public HttpResponseMessage Post([FromBody]CreateWarehouseDto value)
        {
          try {
            if (value.WarehouseId == default(string))
            {
                throw DomainError.Named("nullId", "Aggregate Id in cmd is null, aggregate name: {0}.", "Warehouse");
            }
            _warehouseApplicationService.When(value as ICreateWarehouse);
            var idObj = value.WarehouseId;

            return Request.CreateResponse<string>(HttpStatusCode.Created, idObj);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPut][SetRequesterId]
        public void Put(string id, [FromBody]CreateOrMergePatchOrDeleteWarehouseDto value)
        {
          try {
              // ///////////////////////////////
              if (value.Version != default(long))
              {
                  value.CommandType = CommandType.MergePatch;
                  WarehousesControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
                  _warehouseApplicationService.When(value as IMergePatchWarehouse);
                  return;
              }
              // ///////////////////////////////

            WarehousesControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _warehouseApplicationService.When(value as ICreateWarehouse);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPatch][SetRequesterId]
        public void Patch(string id, [FromBody]MergePatchWarehouseDto value)
        {
          try {
            WarehousesControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _warehouseApplicationService.When(value as IMergePatchWarehouse);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpDelete][SetRequesterId]
        public void Delete(string id, string commandId, string version, string requesterId = default(string))
        {
          try {
            var value = new DeleteWarehouseDto();
            value.CommandId = commandId;
            value.RequesterId = requesterId;
            value.Version = (long)Convert.ChangeType(version, typeof(long));
            WarehousesControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _warehouseApplicationService.When(value as IDeleteWarehouse);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("_metadata/filteringFields")]
        [HttpGet]
        public IEnumerable<PropertyMetadataDto> GetMetadataFilteringFields()
        {
          try {
            var filtering = new List<PropertyMetadataDto>();
            foreach (var p in WarehouseMetadata.Instance.Properties)
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
        public WarehouseStateCreatedOrMergePatchedOrDeletedDto GetStateEvent(string id, long version)
        {
          try {
            var idObj = id;
            var conv = new WarehouseStateEventDtoConverter();
            var se = _warehouseApplicationService.GetEvent(idObj, version);
            return se == null ? null : conv.ToWarehouseStateEventDto(se);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_historyStates/{version}")]
        [HttpGet]
        public IWarehouseStateDto GetHistoryState(string id, long version, string fields = null)
        {
          try {
            var idObj = id;
            var state = _warehouseApplicationService.GetHistoryState(idObj, version);
            if (state == null) { return null; }
            var stateDto = new WarehouseStateDtoWrapper(state);
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
                return WarehousesControllerUtils.GetFilterPropertyType(propertyName);
            }
        }

    }


    
    public static class WarehousesControllerUtils
    {

        public static void SetNullIdOrThrowOnInconsistentIds(string id, CreateOrMergePatchOrDeleteWarehouseDto value)
        {
            var idObj = id;
            if (value.WarehouseId == null)
            {
                value.WarehouseId = idObj;
            }
            else if (!((ICreateOrMergePatchOrDeleteWarehouse)value).WarehouseId.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.WarehouseId);
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
            if (WarehouseMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(fieldName))
            {
                return WarehouseMetadata.Instance.FilteringPropertyAliasDictionary[fieldName];
            }
            return null;
        }

        public static Type GetFilterPropertyType(string propertyName)
        {
            if (WarehouseMetadata.Instance.PropertyMetadataDictionary.ContainsKey(propertyName))
            {
                return WarehouseMetadata.Instance.PropertyMetadataDictionary[propertyName].Type;
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

        public static IEnumerable<IWarehouseStateDto> ToWarehouseStateDtoCollection(IEnumerable<string> ids)
        {
            var states = new List<IWarehouseStateDto>();
            foreach (var id in ids)
            {
                var dto = new WarehouseStateDtoWrapper();
                dto.WarehouseId = id;
                states.Add(dto);
            }
            return states;
        }

        public static IEnumerable<IWarehouseState> ToWarehouseStateCollection(IEnumerable<string> ids)
        {
            var states = new List<WarehouseState>();
            foreach (var id in ids)
            {
                var s = new WarehouseState();
                s.WarehouseId = id;
                states.Add(s);
            }
            return states;
        }

    }

}

