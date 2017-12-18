﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAggregatesControllers.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.ShipmentItemMvo;
using Dddml.Wms.Domain.Shipment;
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

    [RoutePrefix("api/ShipmentItemMvos")]
    public partial class ShipmentItemMvosController : ApiController
    {

        IShipmentItemMvoApplicationService _shipmentItemMvoApplicationService = ApplicationContext.Current["ShipmentItemMvoApplicationService"] as IShipmentItemMvoApplicationService;

        [Route(Order = 1)]
        [HttpGet]
        public IEnumerable<IShipmentItemMvoStateDto> GetAll(string sort = null, string fields = null, int firstResult = 0, int maxResults = int.MaxValue, string filter = null)
        {
          try {
            IEnumerable<IShipmentItemMvoState> states = null; 
            if (!String.IsNullOrWhiteSpace(filter))
            {
                states = _shipmentItemMvoApplicationService.Get(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(),new ApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (ShipmentItemMvoMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? ShipmentItemMvoMetadata.Instance.FilteringPropertyAliasDictionary[n] : n))
                    , ShipmentItemMvosControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            else 
            {
                states = _shipmentItemMvoApplicationService.Get(ShipmentItemMvosControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs())
                    , ShipmentItemMvosControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            var stateDtos = new List<IShipmentItemMvoStateDto>();
            foreach (var s in states)
            {
                var dto = s is ShipmentItemMvoStateDtoWrapper ? (ShipmentItemMvoStateDtoWrapper)s : new ShipmentItemMvoStateDtoWrapper(s);
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
          } catch (Exception ex) { var response = ShipmentItemMvosControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpGet]
        public IShipmentItemMvoStateDto Get(string id, string fields = null)
        {
          try {
            var idObj = ShipmentItemMvosControllerUtils.ParseIdString(id);
            var state = _shipmentItemMvoApplicationService.Get(idObj);
            if (state == null) { return null; }
            var stateDto = new ShipmentItemMvoStateDtoWrapper(state);
            if (String.IsNullOrWhiteSpace(fields))
            {
                stateDto.AllFieldsReturned = true;
            }
            else
            {
                stateDto.ReturnedFieldsString = fields;
            }
            return stateDto;
          } catch (Exception ex) { var response = ShipmentItemMvosControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
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
                count = _shipmentItemMvoApplicationService.GetCount(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(),new ApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (ShipmentItemMvoMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? ShipmentItemMvoMetadata.Instance.FilteringPropertyAliasDictionary[n] : n)));
            }
            else 
            {
                count = _shipmentItemMvoApplicationService.GetCount(ShipmentItemMvosControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs()));
            }
            return count;
          } catch (Exception ex) { var response = ShipmentItemMvosControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPut][SetRequesterId]
        public void Put(string id, [FromBody]CreateShipmentItemMvoDto value)
        {
          try {
            ShipmentItemMvosControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _shipmentItemMvoApplicationService.When(value as ICreateShipmentItemMvo);
          } catch (Exception ex) { var response = ShipmentItemMvosControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPatch][SetRequesterId]
        public void Patch(string id, [FromBody]MergePatchShipmentItemMvoDto value)
        {
          try {
            ShipmentItemMvosControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _shipmentItemMvoApplicationService.When(value as IMergePatchShipmentItemMvo);
          } catch (Exception ex) { var response = ShipmentItemMvosControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpDelete][SetRequesterId]
        public void Delete(string id, string commandId, string version, string requesterId = default(string))
        {
          try {
            var value = new DeleteShipmentItemMvoDto();
            value.CommandId = commandId;
            value.RequesterId = requesterId;
            value.ShipmentVersion = (long)Convert.ChangeType(version, typeof(long));
            ShipmentItemMvosControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _shipmentItemMvoApplicationService.When(value as IDeleteShipmentItemMvo);
          } catch (Exception ex) { var response = ShipmentItemMvosControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("_metadata/filteringFields")]
        [HttpGet]
        public IEnumerable<PropertyMetadataDto> GetMetadataFilteringFields()
        {
          try {
            var filtering = new List<PropertyMetadataDto>();
            foreach (var p in ShipmentItemMvoMetadata.Instance.Properties)
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
          } catch (Exception ex) { var response = ShipmentItemMvosControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_stateEvents/{version}")]
        [HttpGet]
        public ShipmentItemMvoStateCreatedOrMergePatchedOrDeletedDto GetStateEvent(string id, long version)
        {
          try {
            var idObj = ShipmentItemMvosControllerUtils.ParseIdString(id);
            var conv = new ShipmentItemMvoStateEventDtoConverter();
            var se = _shipmentItemMvoApplicationService.GetStateEvent(idObj, version);
            return se == null ? null : conv.ToShipmentItemMvoStateEventDto(se);
          } catch (Exception ex) { var response = ShipmentItemMvosControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_historyStates/{version}")]
        [HttpGet]
        public IShipmentItemMvoStateDto GetHistoryState(string id, long version, string fields = null)
        {
          try {
            var idObj = ShipmentItemMvosControllerUtils.ParseIdString(id);
            var state = _shipmentItemMvoApplicationService.GetHistoryState(idObj, version);
            if (state == null) { return null; }
            var stateDto = new ShipmentItemMvoStateDtoWrapper(state);
            if (String.IsNullOrWhiteSpace(fields))
            {
                stateDto.AllFieldsReturned = true;
            }
            else
            {
                stateDto.ReturnedFieldsString = fields;
            }
            return stateDto;
          } catch (Exception ex) { var response = ShipmentItemMvosControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
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
                return ShipmentItemMvosControllerUtils.GetFilterPropertyType(propertyName);
            }
        }

    }


    
    public static class ShipmentItemMvosControllerUtils
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

        public static void SetNullIdOrThrowOnInconsistentIds(string id, CreateOrMergePatchOrDeleteShipmentItemMvoDto value)
        {
            var idObj = ParseIdString(id.IsNormalized() ? id : id.Normalize());
            if (value.ShipmentItemId == null)
            {
                value.ShipmentItemId = new ShipmentItemIdDtoWrapper(idObj);
            }
            else if (!((ICreateOrMergePatchOrDeleteShipmentItemMvo)value).ShipmentItemId.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.ShipmentItemId);
            }
        }

        public static ShipmentItemId ParseIdString(string idString)
        {
            var formatter = new ShipmentItemIdFlattenedDtoFormatter();
            var idDto = formatter.Parse(idString);
            var rId = idDto.ToShipmentItemId();
            return rId;
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
            if (ShipmentItemMvoMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(fieldName))
            {
                return ShipmentItemMvoMetadata.Instance.FilteringPropertyAliasDictionary[fieldName];
            }
            return null;
        }

        public static Type GetFilterPropertyType(string propertyName)
        {
            if (ShipmentItemMvoMetadata.Instance.PropertyMetadataDictionary.ContainsKey(propertyName))
            {
                return ShipmentItemMvoMetadata.Instance.PropertyMetadataDictionary[propertyName].Type;
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

        public static IEnumerable<IShipmentItemMvoStateDto> ToShipmentItemMvoStateDtoCollection(IEnumerable<ShipmentItemId> ids)
        {
            var states = new List<IShipmentItemMvoStateDto>();
            foreach (var id in ids)
            {
                var dto = new ShipmentItemMvoStateDtoWrapper();
                dto.ShipmentItemId = new ShipmentItemIdDtoWrapper(id);
                states.Add(dto);
            }
            return states;
        }

        public static IEnumerable<IShipmentItemMvoState> ToShipmentItemMvoStateCollection(IEnumerable<ShipmentItemId> ids)
        {
            var states = new List<ShipmentItemMvoState>();
            foreach (var id in ids)
            {
                var s = new ShipmentItemMvoState();
                s.ShipmentItemId = id;
                states.Add(s);
            }
            return states;
        }

    }

}

