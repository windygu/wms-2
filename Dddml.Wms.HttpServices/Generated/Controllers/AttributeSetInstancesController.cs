﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAggregatesControllers.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.AttributeSetInstance;
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

    [RoutePrefix("api/AttributeSetInstances")]
    public partial class AttributeSetInstancesController : ApiController
    {

        DynamicObjectMapperBase<JObject, IAttributeSetInstanceStateDto, CreateAttributeSetInstanceDto, MergePatchAttributeSetInstanceDto> _attributeSetInstanceDtoJObjectMapper = ApplicationContext.Current["AttributeSetInstanceDtoJObjectMapper"] as DynamicObjectMapperBase<JObject, IAttributeSetInstanceStateDto, CreateAttributeSetInstanceDto, MergePatchAttributeSetInstanceDto>;

        IAttributeSetInstanceApplicationService _attributeSetInstanceApplicationService = ApplicationContext.Current["AttributeSetInstanceApplicationService"] as IAttributeSetInstanceApplicationService;

        [Route(Order = 1)]
        [HttpGet]
        public JArray GetAll(string sort = null, string fields = null, int firstResult = 0, int maxResults = int.MaxValue, string filter = null)
        {
          try {
            IEnumerable<IAttributeSetInstanceState> states = null; 
            if (!String.IsNullOrWhiteSpace(filter))
            {
                states = _attributeSetInstanceApplicationService.Get(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new WebApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (AttributeSetInstanceMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? AttributeSetInstanceMetadata.Instance.FilteringPropertyAliasDictionary[n] : n))
                    , AttributeSetInstancesControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            else 
            {
                states = _attributeSetInstanceApplicationService.Get(AttributeSetInstancesControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs())
                    , AttributeSetInstancesControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            JArray dynamicArray = new JArray(); 
            foreach (var s in states)
            {
                var dto = s is AttributeSetInstanceStateDtoWrapper ? (AttributeSetInstanceStateDtoWrapper)s : new AttributeSetInstanceStateDtoWrapper(s);
                if (String.IsNullOrWhiteSpace(fields))
                {
                    dto.AllFieldsReturned = true;
                }
                else
                {
                    dto.ReturnedFieldsString = fields;
                }
                dynamicArray.Add(_attributeSetInstanceDtoJObjectMapper.MapState(dto));
            }
            return dynamicArray; 
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpGet]
        public JObject Get(string id, string fields = null)
        {
          try {
            var idObj = id;
            var state = _attributeSetInstanceApplicationService.Get(idObj);
            if (state == null) { return null; }
            var stateDto = new AttributeSetInstanceStateDtoWrapper(state);
            if (String.IsNullOrWhiteSpace(fields))
            {
                stateDto.AllFieldsReturned = true;
            }
            else
            {
                stateDto.ReturnedFieldsString = fields;
            }
            return _attributeSetInstanceDtoJObjectMapper.MapState(stateDto);
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
                count = _attributeSetInstanceApplicationService.GetCount(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new WebApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (AttributeSetInstanceMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? AttributeSetInstanceMetadata.Instance.FilteringPropertyAliasDictionary[n] : n)));
            }
            else 
            {
                count = _attributeSetInstanceApplicationService.GetCount(AttributeSetInstancesControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs()));
            }
            return count;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route(Order = 1)]
        [HttpPost][SetRequesterId]
        public HttpResponseMessage Post([FromBody]JObject dynamicObject)
        {
          try {
            CreateAttributeSetInstanceDto value = _attributeSetInstanceDtoJObjectMapper.ToCommandCreate(dynamicObject);
            var idObj = _attributeSetInstanceApplicationService.CreateWithoutId(value as ICreateAttributeSetInstance);


            return Request.CreateResponse<string>(HttpStatusCode.Created, idObj);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPut][SetRequesterId]
        public void Put(string id, [FromBody]JObject dynamicObject)
        {
          try {
            CreateAttributeSetInstanceDto value = _attributeSetInstanceDtoJObjectMapper.ToCommandCreate(dynamicObject);
            AttributeSetInstancesControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _attributeSetInstanceApplicationService.When(value as ICreateAttributeSetInstance);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("_metadata/filteringFields")]
        [HttpGet]
        public IEnumerable<PropertyMetadataDto> GetMetadataFilteringFields()
        {
          try {
            var filtering = new List<PropertyMetadataDto>();
            foreach (var p in AttributeSetInstanceMetadata.Instance.Properties)
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
        public AttributeSetInstanceStateCreatedOrMergePatchedOrDeletedDto GetStateEvent(string id, long version)
        {
          try {
            var idObj = id;
            var conv = new AttributeSetInstanceStateEventDtoConverter();
            var se = _attributeSetInstanceApplicationService.GetEvent(idObj, version);
            return se == null ? null : conv.ToAttributeSetInstanceStateEventDto(se);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_historyStates/{version}")]
        [HttpGet]
        public JObject GetHistoryState(string id, long version, string fields = null)
        {
          try {
            var idObj = id;
            var state = _attributeSetInstanceApplicationService.GetHistoryState(idObj, version);
            if (state == null) { return null; }
            var stateDto = new AttributeSetInstanceStateDtoWrapper(state);
            if (String.IsNullOrWhiteSpace(fields))
            {
                stateDto.AllFieldsReturned = true;
            }
            else
            {
                stateDto.ReturnedFieldsString = fields;
            }
            return _attributeSetInstanceDtoJObjectMapper.MapState(stateDto);
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
                return AttributeSetInstancesControllerUtils.GetFilterPropertyType(propertyName);
            }
        }

    }


    public abstract partial class AttributeSetInstanceDtoJObjectMapperBase : DynamicObjectMapperBase<JObject, IAttributeSetInstanceStateDto, CreateAttributeSetInstanceDto, MergePatchAttributeSetInstanceDto>
    {
        public override JObject MapState(IAttributeSetInstanceStateDto state)
        {
            var dynamicObject = NewJObject(state);
            MapDynamicProperties(state, dynamicObject);
            return dynamicObject;
        }

        public override CreateAttributeSetInstanceDto ToCommandCreate(JObject dynamicObject)
        {
            CreateAttributeSetInstanceDto command = NewCreateAttributeSetInstanceDto(dynamicObject);
            MapDynamicProperties(dynamicObject, command);
            return command;
        }

        public override MergePatchAttributeSetInstanceDto ToCommandMergePatch(JObject dynamicObject)
        {
            MergePatchAttributeSetInstanceDto command = NewMergePatchAttributeSetInstanceDto(dynamicObject);
            MapDynamicProperties(dynamicObject, command);
            return command;
        }

        protected virtual CreateAttributeSetInstanceDto NewCreateAttributeSetInstanceDto(JObject dynamicObject)
        {
            CreateAttributeSetInstanceDto command = dynamicObject.ToObject<CreateAttributeSetInstanceDto>();
            return command;
        }

        protected virtual MergePatchAttributeSetInstanceDto NewMergePatchAttributeSetInstanceDto(JObject dynamicObject)
        {
            MergePatchAttributeSetInstanceDto command = dynamicObject.ToObject<MergePatchAttributeSetInstanceDto>();
            return command;
        }

        protected virtual JObject NewJObject(IAttributeSetInstanceStateDto state)
        {
            var dynamicObject = JObject.FromObject(state);
            return dynamicObject;
        }

        protected abstract void MapDynamicProperties(IAttributeSetInstanceStateDto state, JObject dynamicObject);

        protected abstract void MapDynamicProperties(JObject dynamicObject, CreateAttributeSetInstanceDto command);

        protected abstract void MapDynamicProperties(JObject dynamicObject, MergePatchAttributeSetInstanceDto command);

    }

    
    public static class AttributeSetInstancesControllerUtils
    {

        public static void SetNullIdOrThrowOnInconsistentIds(string id, CreateOrMergePatchOrDeleteAttributeSetInstanceDto value)
        {
            var idObj = id;
            if (value.AttributeSetInstanceId == null)
            {
                value.AttributeSetInstanceId = idObj;
            }
            else if (!((ICreateOrMergePatchOrDeleteAttributeSetInstance)value).AttributeSetInstanceId.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.AttributeSetInstanceId);
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
            if (AttributeSetInstanceMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(fieldName))
            {
                return AttributeSetInstanceMetadata.Instance.FilteringPropertyAliasDictionary[fieldName];
            }
            return null;
        }

        public static Type GetFilterPropertyType(string propertyName)
        {
            if (AttributeSetInstanceMetadata.Instance.PropertyMetadataDictionary.ContainsKey(propertyName))
            {
                return AttributeSetInstanceMetadata.Instance.PropertyMetadataDictionary[propertyName].Type;
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

        public static IEnumerable<IAttributeSetInstanceStateDto> ToAttributeSetInstanceStateDtoCollection(IEnumerable<string> ids)
        {
            var states = new List<IAttributeSetInstanceStateDto>();
            foreach (var id in ids)
            {
                var dto = new AttributeSetInstanceStateDtoWrapper();
                dto.AttributeSetInstanceId = id;
                states.Add(dto);
            }
            return states;
        }

        public static IEnumerable<IAttributeSetInstanceState> ToAttributeSetInstanceStateCollection(IEnumerable<string> ids)
        {
            var states = new List<AttributeSetInstanceState>();
            foreach (var id in ids)
            {
                var s = new AttributeSetInstanceState();
                s.AttributeSetInstanceId = id;
                states.Add(s);
            }
            return states;
        }

    }

}

