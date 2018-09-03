﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAggregatesControllers.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.RejectionReason;
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

    [RoutePrefix("api/RejectionReasons")]
    public partial class RejectionReasonsController : ApiController
    {

        IRejectionReasonApplicationService _rejectionReasonApplicationService = ApplicationContext.Current["RejectionReasonApplicationService"] as IRejectionReasonApplicationService;

        [Route(Order = 1)]
        [HttpGet]
        public IEnumerable<IRejectionReasonStateDto> GetAll(string sort = null, string fields = null, int firstResult = 0, int maxResults = int.MaxValue, string filter = null)
        {
          try {
            IEnumerable<IRejectionReasonState> states = null; 
            if (!String.IsNullOrWhiteSpace(filter))
            {
                states = _rejectionReasonApplicationService.Get(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new WebApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (RejectionReasonMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? RejectionReasonMetadata.Instance.FilteringPropertyAliasDictionary[n] : n))
                    , RejectionReasonsControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            else 
            {
                states = _rejectionReasonApplicationService.Get(RejectionReasonsControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs())
                    , RejectionReasonsControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            var stateDtos = new List<IRejectionReasonStateDto>();
            foreach (var s in states)
            {
                var dto = s is RejectionReasonStateDtoWrapper ? (RejectionReasonStateDtoWrapper)s : new RejectionReasonStateDtoWrapper(s);
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
        public IRejectionReasonStateDto Get(string id, string fields = null)
        {
          try {
            var idObj = id;
            var state = _rejectionReasonApplicationService.Get(idObj);
            if (state == null) { return null; }
            var stateDto = new RejectionReasonStateDtoWrapper(state);
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
                count = _rejectionReasonApplicationService.GetCount(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new WebApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (RejectionReasonMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? RejectionReasonMetadata.Instance.FilteringPropertyAliasDictionary[n] : n)));
            }
            else 
            {
                count = _rejectionReasonApplicationService.GetCount(RejectionReasonsControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs()));
            }
            return count;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route(Order = 1)]
        [HttpPost][SetRequesterId]
        public HttpResponseMessage Post([FromBody]CreateRejectionReasonDto value)
        {
          try {
            if (value.RejectionReasonId == default(string))
            {
                throw DomainError.Named("nullId", "Aggregate Id in cmd is null, aggregate name: {0}.", "RejectionReason");
            }
            _rejectionReasonApplicationService.When(value as ICreateRejectionReason);
            var idObj = value.RejectionReasonId;

            return Request.CreateResponse<string>(HttpStatusCode.Created, idObj);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPut][SetRequesterId]
        public void Put(string id, [FromBody]CreateOrMergePatchOrDeleteRejectionReasonDto value)
        {
          try {
              // ///////////////////////////////
              if (value.Version != default(long))
              {
                  value.CommandType = CommandType.MergePatch;
                  RejectionReasonsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
                  _rejectionReasonApplicationService.When(value as IMergePatchRejectionReason);
                  return;
              }
              // ///////////////////////////////

            RejectionReasonsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _rejectionReasonApplicationService.When(value as ICreateRejectionReason);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPatch][SetRequesterId]
        public void Patch(string id, [FromBody]MergePatchRejectionReasonDto value)
        {
          try {
            RejectionReasonsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _rejectionReasonApplicationService.When(value as IMergePatchRejectionReason);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpDelete][SetRequesterId]
        public void Delete(string id, string commandId, string version, string requesterId = default(string))
        {
          try {
            var value = new DeleteRejectionReasonDto();
            value.CommandId = commandId;
            value.RequesterId = requesterId;
            value.Version = (long)Convert.ChangeType(version, typeof(long));
            RejectionReasonsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _rejectionReasonApplicationService.When(value as IDeleteRejectionReason);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("_metadata/filteringFields")]
        [HttpGet]
        public IEnumerable<PropertyMetadataDto> GetMetadataFilteringFields()
        {
          try {
            var filtering = new List<PropertyMetadataDto>();
            foreach (var p in RejectionReasonMetadata.Instance.Properties)
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
        public RejectionReasonStateCreatedOrMergePatchedOrDeletedDto GetStateEvent(string id, long version)
        {
          try {
            var idObj = id;
            var conv = new RejectionReasonStateEventDtoConverter();
            var se = _rejectionReasonApplicationService.GetEvent(idObj, version);
            return se == null ? null : conv.ToRejectionReasonStateEventDto(se);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_historyStates/{version}")]
        [HttpGet]
        public IRejectionReasonStateDto GetHistoryState(string id, long version, string fields = null)
        {
          try {
            var idObj = id;
            var state = _rejectionReasonApplicationService.GetHistoryState(idObj, version);
            if (state == null) { return null; }
            var stateDto = new RejectionReasonStateDtoWrapper(state);
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
                return RejectionReasonsControllerUtils.GetFilterPropertyType(propertyName);
            }
        }

    }


    
    public static class RejectionReasonsControllerUtils
    {

        public static void SetNullIdOrThrowOnInconsistentIds(string id, CreateOrMergePatchOrDeleteRejectionReasonDto value)
        {
            var idObj = id;
            if (value.RejectionReasonId == null)
            {
                value.RejectionReasonId = idObj;
            }
            else if (!((ICreateOrMergePatchOrDeleteRejectionReason)value).RejectionReasonId.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.RejectionReasonId);
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
            if (RejectionReasonMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(fieldName))
            {
                return RejectionReasonMetadata.Instance.FilteringPropertyAliasDictionary[fieldName];
            }
            return null;
        }

        public static Type GetFilterPropertyType(string propertyName)
        {
            if (RejectionReasonMetadata.Instance.PropertyMetadataDictionary.ContainsKey(propertyName))
            {
                return RejectionReasonMetadata.Instance.PropertyMetadataDictionary[propertyName].Type;
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

        public static IEnumerable<IRejectionReasonStateDto> ToRejectionReasonStateDtoCollection(IEnumerable<string> ids)
        {
            var states = new List<IRejectionReasonStateDto>();
            foreach (var id in ids)
            {
                var dto = new RejectionReasonStateDtoWrapper();
                dto.RejectionReasonId = id;
                states.Add(dto);
            }
            return states;
        }

        public static IEnumerable<IRejectionReasonState> ToRejectionReasonStateCollection(IEnumerable<string> ids)
        {
            var states = new List<RejectionReasonState>();
            foreach (var id in ids)
            {
                var s = new RejectionReasonState();
                s.RejectionReasonId = id;
                states.Add(s);
            }
            return states;
        }

    }

}

