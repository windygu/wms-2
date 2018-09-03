﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAggregatesControllers.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Pickwave;
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

    [RoutePrefix("api/Pickwaves")]
    public partial class PickwavesController : ApiController
    {

        IPickwaveApplicationService _pickwaveApplicationService = ApplicationContext.Current["PickwaveApplicationService"] as IPickwaveApplicationService;

        [Route(Order = 1)]
        [HttpGet]
        public IEnumerable<IPickwaveStateDto> GetAll(string sort = null, string fields = null, int firstResult = 0, int maxResults = int.MaxValue, string filter = null)
        {
          try {
            IEnumerable<IPickwaveState> states = null; 
            if (!String.IsNullOrWhiteSpace(filter))
            {
                states = _pickwaveApplicationService.Get(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new WebApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (PickwaveMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? PickwaveMetadata.Instance.FilteringPropertyAliasDictionary[n] : n))
                    , PickwavesControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            else 
            {
                states = _pickwaveApplicationService.Get(PickwavesControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs())
                    , PickwavesControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            var stateDtos = new List<IPickwaveStateDto>();
            foreach (var s in states)
            {
                var dto = s is PickwaveStateDtoWrapper ? (PickwaveStateDtoWrapper)s : new PickwaveStateDtoWrapper(s);
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
        public IPickwaveStateDto Get(long? id, string fields = null)
        {
          try {
            var idObj = id;
            var state = _pickwaveApplicationService.Get(idObj);
            if (state == null) { return null; }
            var stateDto = new PickwaveStateDtoWrapper(state);
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
                count = _pickwaveApplicationService.GetCount(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new WebApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (PickwaveMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? PickwaveMetadata.Instance.FilteringPropertyAliasDictionary[n] : n)));
            }
            else 
            {
                count = _pickwaveApplicationService.GetCount(PickwavesControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs()));
            }
            return count;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route(Order = 1)]
        [HttpPost][SetRequesterId]
        public HttpResponseMessage Post([FromBody]CreatePickwaveDto value)
        {
          try {
            if (value.PickwaveId == default(long?))
            {
                throw DomainError.Named("nullId", "Aggregate Id in cmd is null, aggregate name: {0}.", "Pickwave");
            }
            _pickwaveApplicationService.When(value as ICreatePickwave);
            var idObj = value.PickwaveId;

            return Request.CreateResponse<long?>(HttpStatusCode.Created, idObj);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPut][SetRequesterId]
        public void Put(long? id, [FromBody]CreateOrMergePatchOrDeletePickwaveDto value)
        {
          try {
              // ///////////////////////////////
              if (value.Version != default(long))
              {
                  value.CommandType = CommandType.MergePatch;
                  PickwavesControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
                  _pickwaveApplicationService.When(value as IMergePatchPickwave);
                  return;
              }
              // ///////////////////////////////

            PickwavesControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _pickwaveApplicationService.When(value as ICreatePickwave);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPatch][SetRequesterId]
        public void Patch(long? id, [FromBody]MergePatchPickwaveDto value)
        {
          try {
            PickwavesControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _pickwaveApplicationService.When(value as IMergePatchPickwave);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpDelete][SetRequesterId]
        public void Delete(long? id, string commandId, string version, string requesterId = default(string))
        {
          try {
            var value = new DeletePickwaveDto();
            value.CommandId = commandId;
            value.RequesterId = requesterId;
            value.Version = (long)Convert.ChangeType(version, typeof(long));
            PickwavesControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _pickwaveApplicationService.When(value as IDeletePickwave);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("_metadata/filteringFields")]
        [HttpGet]
        public IEnumerable<PropertyMetadataDto> GetMetadataFilteringFields()
        {
          try {
            var filtering = new List<PropertyMetadataDto>();
            foreach (var p in PickwaveMetadata.Instance.Properties)
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
        public PickwaveStateCreatedOrMergePatchedOrDeletedDto GetStateEvent(long? id, long version)
        {
          try {
            var idObj = id;
            var conv = new PickwaveStateEventDtoConverter();
            var se = _pickwaveApplicationService.GetEvent(idObj, version);
            return se == null ? null : conv.ToPickwaveStateEventDto(se);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_historyStates/{version}")]
        [HttpGet]
        public IPickwaveStateDto GetHistoryState(long? id, long version, string fields = null)
        {
          try {
            var idObj = id;
            var state = _pickwaveApplicationService.GetHistoryState(idObj, version);
            if (state == null) { return null; }
            var stateDto = new PickwaveStateDtoWrapper(state);
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
                return PickwavesControllerUtils.GetFilterPropertyType(propertyName);
            }
        }

    }


    
    public static class PickwavesControllerUtils
    {

        public static void SetNullIdOrThrowOnInconsistentIds(long? id, CreateOrMergePatchOrDeletePickwaveDto value)
        {
            var idObj = id;
            if (value.PickwaveId == null)
            {
                value.PickwaveId = idObj;
            }
            else if (!((ICreateOrMergePatchOrDeletePickwave)value).PickwaveId.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.PickwaveId);
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
            if (PickwaveMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(fieldName))
            {
                return PickwaveMetadata.Instance.FilteringPropertyAliasDictionary[fieldName];
            }
            return null;
        }

        public static Type GetFilterPropertyType(string propertyName)
        {
            if (PickwaveMetadata.Instance.PropertyMetadataDictionary.ContainsKey(propertyName))
            {
                return PickwaveMetadata.Instance.PropertyMetadataDictionary[propertyName].Type;
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

        public static IEnumerable<IPickwaveStateDto> ToPickwaveStateDtoCollection(IEnumerable<long?> ids)
        {
            var states = new List<IPickwaveStateDto>();
            foreach (var id in ids)
            {
                var dto = new PickwaveStateDtoWrapper();
                dto.PickwaveId = id;
                states.Add(dto);
            }
            return states;
        }

        public static IEnumerable<IPickwaveState> ToPickwaveStateCollection(IEnumerable<long?> ids)
        {
            var states = new List<PickwaveState>();
            foreach (var id in ids)
            {
                var s = new PickwaveState();
                s.PickwaveId = id;
                states.Add(s);
            }
            return states;
        }

    }

}

