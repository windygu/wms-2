﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAggregatesControllers.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.StatusItem;
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

    [RoutePrefix("api/StatusItems")]
    public partial class StatusItemsController : ApiController
    {

        IStatusItemApplicationService _statusItemApplicationService = ApplicationContext.Current["StatusItemApplicationService"] as IStatusItemApplicationService;

        [Route(Order = 1)]
        [HttpGet]
        public IEnumerable<IStatusItemStateDto> GetAll(string sort = null, string fields = null, int firstResult = 0, int maxResults = int.MaxValue, string filter = null)
        {
          try {
            IEnumerable<IStatusItemState> states = null; 
            if (!String.IsNullOrWhiteSpace(filter))
            {
                states = _statusItemApplicationService.Get(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new WebApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (StatusItemMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? StatusItemMetadata.Instance.FilteringPropertyAliasDictionary[n] : n))
                    , StatusItemsControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            else 
            {
                states = _statusItemApplicationService.Get(StatusItemsControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs())
                    , StatusItemsControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            var stateDtos = new List<IStatusItemStateDto>();
            foreach (var s in states)
            {
                var dto = s is StatusItemStateDtoWrapper ? (StatusItemStateDtoWrapper)s : new StatusItemStateDtoWrapper(s);
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
        public IStatusItemStateDto Get(string id, string fields = null)
        {
          try {
            var idObj = id;
            var state = _statusItemApplicationService.Get(idObj);
            if (state == null) { return null; }
            var stateDto = new StatusItemStateDtoWrapper(state);
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
                count = _statusItemApplicationService.GetCount(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new WebApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (StatusItemMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? StatusItemMetadata.Instance.FilteringPropertyAliasDictionary[n] : n)));
            }
            else 
            {
                count = _statusItemApplicationService.GetCount(StatusItemsControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs()));
            }
            return count;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route(Order = 1)]
        [HttpPost][SetRequesterId]
        public HttpResponseMessage Post([FromBody]CreateStatusItemDto value)
        {
          try {
            if (value.StatusId == default(string))
            {
                throw DomainError.Named("nullId", "Aggregate Id in cmd is null, aggregate name: {0}.", "StatusItem");
            }
            _statusItemApplicationService.When(value as ICreateStatusItem);
            var idObj = value.StatusId;

            return Request.CreateResponse<string>(HttpStatusCode.Created, idObj);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPut][SetRequesterId]
        public void Put(string id, [FromBody]CreateOrMergePatchOrDeleteStatusItemDto value)
        {
          try {
              // ///////////////////////////////
              if (value.Version != default(long))
              {
                  value.CommandType = CommandType.MergePatch;
                  StatusItemsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
                  _statusItemApplicationService.When(value as IMergePatchStatusItem);
                  return;
              }
              // ///////////////////////////////

            StatusItemsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _statusItemApplicationService.When(value as ICreateStatusItem);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPatch][SetRequesterId]
        public void Patch(string id, [FromBody]MergePatchStatusItemDto value)
        {
          try {
            StatusItemsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _statusItemApplicationService.When(value as IMergePatchStatusItem);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("_metadata/filteringFields")]
        [HttpGet]
        public IEnumerable<PropertyMetadataDto> GetMetadataFilteringFields()
        {
          try {
            var filtering = new List<PropertyMetadataDto>();
            foreach (var p in StatusItemMetadata.Instance.Properties)
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
                return StatusItemsControllerUtils.GetFilterPropertyType(propertyName);
            }
        }

    }


    
    public static class StatusItemsControllerUtils
    {

        public static void SetNullIdOrThrowOnInconsistentIds(string id, CreateOrMergePatchOrDeleteStatusItemDto value)
        {
            var idObj = id;
            if (value.StatusId == null)
            {
                value.StatusId = idObj;
            }
            else if (!((ICreateOrMergePatchOrDeleteStatusItem)value).StatusId.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.StatusId);
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
            if (StatusItemMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(fieldName))
            {
                return StatusItemMetadata.Instance.FilteringPropertyAliasDictionary[fieldName];
            }
            return null;
        }

        public static Type GetFilterPropertyType(string propertyName)
        {
            if (StatusItemMetadata.Instance.PropertyMetadataDictionary.ContainsKey(propertyName))
            {
                return StatusItemMetadata.Instance.PropertyMetadataDictionary[propertyName].Type;
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

        public static IEnumerable<IStatusItemStateDto> ToStatusItemStateDtoCollection(IEnumerable<string> ids)
        {
            var states = new List<IStatusItemStateDto>();
            foreach (var id in ids)
            {
                var dto = new StatusItemStateDtoWrapper();
                dto.StatusId = id;
                states.Add(dto);
            }
            return states;
        }

        public static IEnumerable<IStatusItemState> ToStatusItemStateCollection(IEnumerable<string> ids)
        {
            var states = new List<StatusItemState>();
            foreach (var id in ids)
            {
                var s = new StatusItemState();
                s.StatusId = id;
                states.Add(s);
            }
            return states;
        }

    }

}

