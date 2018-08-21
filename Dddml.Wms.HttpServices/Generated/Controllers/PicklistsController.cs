﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAggregatesControllers.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Picklist;
using Dddml.Wms.Domain.PartyRole;
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

    [RoutePrefix("api/Picklists")]
    public partial class PicklistsController : ApiController
    {

        IPicklistApplicationService _picklistApplicationService = ApplicationContext.Current["PicklistApplicationService"] as IPicklistApplicationService;

        [Route(Order = 1)]
        [HttpGet]
        public IEnumerable<IPicklistStateDto> GetAll(string sort = null, string fields = null, int firstResult = 0, int maxResults = int.MaxValue, string filter = null)
        {
          try {
            IEnumerable<IPicklistState> states = null; 
            if (!String.IsNullOrWhiteSpace(filter))
            {
                states = _picklistApplicationService.Get(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new ApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (PicklistMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? PicklistMetadata.Instance.FilteringPropertyAliasDictionary[n] : n))
                    , PicklistsControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            else 
            {
                states = _picklistApplicationService.Get(PicklistsControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs())
                    , PicklistsControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            var stateDtos = new List<IPicklistStateDto>();
            foreach (var s in states)
            {
                var dto = s is PicklistStateDtoWrapper ? (PicklistStateDtoWrapper)s : new PicklistStateDtoWrapper(s);
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
          } catch (Exception ex) { var response = PicklistsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpGet]
        public IPicklistStateDto Get(string id, string fields = null)
        {
          try {
            var idObj = id;
            var state = _picklistApplicationService.Get(idObj);
            if (state == null) { return null; }
            var stateDto = new PicklistStateDtoWrapper(state);
            if (String.IsNullOrWhiteSpace(fields))
            {
                stateDto.AllFieldsReturned = true;
            }
            else
            {
                stateDto.ReturnedFieldsString = fields;
            }
            return stateDto;
          } catch (Exception ex) { var response = PicklistsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }


        [Route("_count")]
        [HttpGet]
        public long GetCount(string filter = null)
        {
          try
          {
            long count = 0;
            if (!String.IsNullOrWhiteSpace(filter))
            {
                count = _picklistApplicationService.GetCount(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new ApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (PicklistMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? PicklistMetadata.Instance.FilteringPropertyAliasDictionary[n] : n)));
            }
            else 
            {
                count = _picklistApplicationService.GetCount(PicklistsControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs()));
            }
            return count;
          } catch (Exception ex) { var response = PicklistsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route(Order = 1)]
        [HttpPost][SetRequesterId]
        public HttpResponseMessage Post([FromBody]CreatePicklistDto value)
        {
          try {
            if (value.PicklistId == default(string))
            {
                throw DomainError.Named("nullId", "Aggregate Id in cmd is null, aggregate name: {0}.", "Picklist");
            }
            _picklistApplicationService.When(value as ICreatePicklist);
            var idObj = value.PicklistId;

            return Request.CreateResponse<string>(HttpStatusCode.Created, idObj);
          } catch (Exception ex) { var response = PicklistsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPut][SetRequesterId]
        public void Put(string id, [FromBody]CreateOrMergePatchOrDeletePicklistDto value)
        {
          try {
              // ///////////////////////////////
              if (value.Version != default(long))
              {
                  value.CommandType = CommandType.MergePatch;
                  PicklistsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
                  _picklistApplicationService.When(value as IMergePatchPicklist);
                  return;
              }
              // ///////////////////////////////

            PicklistsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _picklistApplicationService.When(value as ICreatePicklist);
          } catch (Exception ex) { var response = PicklistsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPatch][SetRequesterId]
        public void Patch(string id, [FromBody]MergePatchPicklistDto value)
        {
          try {
            PicklistsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _picklistApplicationService.When(value as IMergePatchPicklist);
          } catch (Exception ex) { var response = PicklistsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpDelete][SetRequesterId]
        public void Delete(string id, string commandId, string version, string requesterId = default(string))
        {
          try {
            var value = new DeletePicklistDto();
            value.CommandId = commandId;
            value.RequesterId = requesterId;
            value.Version = (long)Convert.ChangeType(version, typeof(long));
            PicklistsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _picklistApplicationService.When(value as IDeletePicklist);
          } catch (Exception ex) { var response = PicklistsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("_metadata/filteringFields")]
        [HttpGet]
        public IEnumerable<PropertyMetadataDto> GetMetadataFilteringFields()
        {
          try {
            var filtering = new List<PropertyMetadataDto>();
            foreach (var p in PicklistMetadata.Instance.Properties)
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
          } catch (Exception ex) { var response = PicklistsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_stateEvents/{version}")]
        [HttpGet]
        public PicklistStateCreatedOrMergePatchedOrDeletedDto GetStateEvent(string id, long version)
        {
          try {
            var idObj = id;
            var conv = new PicklistStateEventDtoConverter();
            var se = _picklistApplicationService.GetEvent(idObj, version);
            return se == null ? null : conv.ToPicklistStateEventDto(se);
          } catch (Exception ex) { var response = PicklistsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_historyStates/{version}")]
        [HttpGet]
        public IPicklistStateDto GetHistoryState(string id, long version, string fields = null)
        {
          try {
            var idObj = id;
            var state = _picklistApplicationService.GetHistoryState(idObj, version);
            if (state == null) { return null; }
            var stateDto = new PicklistStateDtoWrapper(state);
            if (String.IsNullOrWhiteSpace(fields))
            {
                stateDto.AllFieldsReturned = true;
            }
            else
            {
                stateDto.ReturnedFieldsString = fields;
            }
            return stateDto;
          } catch (Exception ex) { var response = PicklistsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{picklistId}/PicklistRoles/{partyRoleId}")]
        [HttpGet]
        public IPicklistRoleStateDto GetPicklistRole(string picklistId, string partyRoleId)
        {
          try {
            var state = (PicklistRoleState)_picklistApplicationService.GetPicklistRole(picklistId, ((new ValueObjectTextFormatter<PartyRoleId>()).Parse(partyRoleId)));
            if (state == null) { return null; }
            var stateDto = new PicklistRoleStateDtoWrapper(state);
            stateDto.AllFieldsReturned = true;
            return stateDto;
          } catch (Exception ex) { var response = PicklistsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{picklistId}/PicklistRoles/")]
        [HttpGet]
        public IEnumerable<IPicklistRoleStateDto> GetPicklistRoles(string picklistId)
        {
          try {
            var states = _picklistApplicationService.GetPicklistRoles(picklistId);
            if (states == null) { return null; }
            var stateDtos = new List<IPicklistRoleStateDto>();
            foreach (var s in states)
            {
                var dto = s is PicklistRoleStateDtoWrapper ? (PicklistRoleStateDtoWrapper)s : new PicklistRoleStateDtoWrapper((IPicklistRoleState)s);
                dto.AllFieldsReturned = true;
                stateDtos.Add(dto);
            }
            return stateDtos;
          } catch (Exception ex) { var response = PicklistsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }


		// /////////////////////////////////////////////////

        protected virtual string QueryOrderSeparator
        {
            get { return ","; }
        }

        // ////////////////////////////////

        private class ApiControllerTypeConverter : Dddml.Support.Criterion.ITypeConverter
        {
            public T ConvertFromString<T>(string text)
            {
                return (T)ApplicationContext.Current.TypeConverter.ConvertFromString(typeof(T), text);
            }

            public object ConvertFromString(Type type, string text)
            {
                return ApplicationContext.Current.TypeConverter.ConvertFromString(type, text);
            }

            public string ConvertToString<T>(T value)
            {
                return ApplicationContext.Current.TypeConverter.ConvertToString(typeof(T), value);
            }

            public string ConvertToString(object value)
            {
                return ApplicationContext.Current.TypeConverter.ConvertToString(value.GetType(), value);
            }

            public string[] ConvertToStringArray(object[] values)
            {
                throw new NotSupportedException();
            }
        }

        private class PropertyTypeResolver : IPropertyTypeResolver
        {

            public Type ResolveTypeByPropertyName(string propertyName)
            {
                return PicklistsControllerUtils.GetFilterPropertyType(propertyName);
            }
        }

    }


    
    public static class PicklistsControllerUtils
    {

        public static HttpResponseMessage GetErrorHttpResponseMessage(Exception ex)
        {
            var errorName = ex.GetType().Name;
            var errorMessage = ex.Message;
            if (ex is DomainError)
            {
                DomainError de = ex as DomainError;
                errorName = de.Name;
                errorMessage = de.Message;
            }
            else
            {
                //改进??
                errorMessage = String.IsNullOrWhiteSpace(ex.Message) ? String.Empty : ex.Message.Substring(0, (ex.Message.Length > 140) ? 140 : ex.Message.Length);
            }
            dynamic content = new JObject();
            content.ErrorName = errorName;
            content.ErrorMessage = errorMessage;
            var response = new HttpResponseMessage(HttpStatusCode.InternalServerError)
            {
                Content = new ObjectContent<JObject>(content as JObject, new JsonMediaTypeFormatter()),
                ReasonPhrase = "Server Error"
            };
            return response;
        }

        public static void SetNullIdOrThrowOnInconsistentIds(string id, CreateOrMergePatchOrDeletePicklistDto value)
        {
            var idObj = id;
            if (value.PicklistId == null)
            {
                value.PicklistId = idObj;
            }
            else if (!((ICreateOrMergePatchOrDeletePicklist)value).PicklistId.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.PicklistId);
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
            if (PicklistMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(fieldName))
            {
                return PicklistMetadata.Instance.FilteringPropertyAliasDictionary[fieldName];
            }
            return null;
        }

        public static Type GetFilterPropertyType(string propertyName)
        {
            if (PicklistMetadata.Instance.PropertyMetadataDictionary.ContainsKey(propertyName))
            {
                return PicklistMetadata.Instance.PropertyMetadataDictionary[propertyName].Type;
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

        public static IEnumerable<IPicklistStateDto> ToPicklistStateDtoCollection(IEnumerable<string> ids)
        {
            var states = new List<IPicklistStateDto>();
            foreach (var id in ids)
            {
                var dto = new PicklistStateDtoWrapper();
                dto.PicklistId = id;
                states.Add(dto);
            }
            return states;
        }

        public static IEnumerable<IPicklistState> ToPicklistStateCollection(IEnumerable<string> ids)
        {
            var states = new List<PicklistState>();
            foreach (var id in ids)
            {
                var s = new PicklistState();
                s.PicklistId = id;
                states.Add(s);
            }
            return states;
        }

    }

}

