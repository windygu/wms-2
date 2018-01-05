﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAggregatesControllers.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.MovementConfirmation;
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

    [RoutePrefix("api/MovementConfirmations")]
    public partial class MovementConfirmationsController : ApiController
    {

        IMovementConfirmationApplicationService _movementConfirmationApplicationService = ApplicationContext.Current["MovementConfirmationApplicationService"] as IMovementConfirmationApplicationService;

        [Route(Order = 1)]
        [HttpGet]
        public IEnumerable<IMovementConfirmationStateDto> GetAll(string sort = null, string fields = null, int firstResult = 0, int maxResults = int.MaxValue, string filter = null)
        {
          try {
            IEnumerable<IMovementConfirmationState> states = null; 
            if (!String.IsNullOrWhiteSpace(filter))
            {
                states = _movementConfirmationApplicationService.Get(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new ApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (MovementConfirmationMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? MovementConfirmationMetadata.Instance.FilteringPropertyAliasDictionary[n] : n))
                    , MovementConfirmationsControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            else 
            {
                states = _movementConfirmationApplicationService.Get(MovementConfirmationsControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs())
                    , MovementConfirmationsControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            var stateDtos = new List<IMovementConfirmationStateDto>();
            foreach (var s in states)
            {
                var dto = s is MovementConfirmationStateDtoWrapper ? (MovementConfirmationStateDtoWrapper)s : new MovementConfirmationStateDtoWrapper(s);
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
          } catch (Exception ex) { var response = MovementConfirmationsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpGet]
        public IMovementConfirmationStateDto Get(string id, string fields = null)
        {
          try {
            var idObj = id;
            var state = _movementConfirmationApplicationService.Get(idObj);
            if (state == null) { return null; }
            var stateDto = new MovementConfirmationStateDtoWrapper(state);
            if (String.IsNullOrWhiteSpace(fields))
            {
                stateDto.AllFieldsReturned = true;
            }
            else
            {
                stateDto.ReturnedFieldsString = fields;
            }
            return stateDto;
          } catch (Exception ex) { var response = MovementConfirmationsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
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
                count = _movementConfirmationApplicationService.GetCount(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new ApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (MovementConfirmationMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? MovementConfirmationMetadata.Instance.FilteringPropertyAliasDictionary[n] : n)));
            }
            else 
            {
                count = _movementConfirmationApplicationService.GetCount(MovementConfirmationsControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs()));
            }
            return count;
          } catch (Exception ex) { var response = MovementConfirmationsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPut][SetRequesterId]
        public void Put(string id, [FromBody]CreateMovementConfirmationDto value)
        {
          try {
            MovementConfirmationsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _movementConfirmationApplicationService.When(value as ICreateMovementConfirmation);
          } catch (Exception ex) { var response = MovementConfirmationsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPatch][SetRequesterId]
        public void Patch(string id, [FromBody]MergePatchMovementConfirmationDto value)
        {
          try {
            MovementConfirmationsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _movementConfirmationApplicationService.When(value as IMergePatchMovementConfirmation);
          } catch (Exception ex) { var response = MovementConfirmationsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpDelete][SetRequesterId]
        public void Delete(string id, string commandId, string version, string requesterId = default(string))
        {
          try {
            var value = new DeleteMovementConfirmationDto();
            value.CommandId = commandId;
            value.RequesterId = requesterId;
            value.Version = (long)Convert.ChangeType(version, typeof(long));
            MovementConfirmationsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _movementConfirmationApplicationService.When(value as IDeleteMovementConfirmation);
          } catch (Exception ex) { var response = MovementConfirmationsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_commands/DocumentAction")]
        [HttpPut][SetRequesterId]
        public void DocumentAction(string id, [FromBody]MovementConfirmationCommandDtos.DocumentActionRequestContent content)
        {
          try {
            var cmd = content.ToDocumentAction();
            var idObj = id;
            if (cmd.DocumentNumber == null)
            {
                cmd.DocumentNumber = idObj;
            }
            else if (!cmd.DocumentNumber.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, cmd.DocumentNumber);
            }
            _movementConfirmationApplicationService.When(cmd);
          } catch (Exception ex) { var response = MovementConfirmationsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("_metadata/filteringFields")]
        [HttpGet]
        public IEnumerable<PropertyMetadataDto> GetMetadataFilteringFields()
        {
          try {
            var filtering = new List<PropertyMetadataDto>();
            foreach (var p in MovementConfirmationMetadata.Instance.Properties)
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
          } catch (Exception ex) { var response = MovementConfirmationsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_stateEvents/{version}")]
        [HttpGet]
        public MovementConfirmationStateCreatedOrMergePatchedOrDeletedDto GetStateEvent(string id, long version)
        {
          try {
            var idObj = id;
            var conv = new MovementConfirmationStateEventDtoConverter();
            var se = _movementConfirmationApplicationService.GetStateEvent(idObj, version);
            return se == null ? null : conv.ToMovementConfirmationStateEventDto(se);
          } catch (Exception ex) { var response = MovementConfirmationsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_historyStates/{version}")]
        [HttpGet]
        public IMovementConfirmationStateDto GetHistoryState(string id, long version, string fields = null)
        {
          try {
            var idObj = id;
            var state = _movementConfirmationApplicationService.GetHistoryState(idObj, version);
            if (state == null) { return null; }
            var stateDto = new MovementConfirmationStateDtoWrapper(state);
            if (String.IsNullOrWhiteSpace(fields))
            {
                stateDto.AllFieldsReturned = true;
            }
            else
            {
                stateDto.ReturnedFieldsString = fields;
            }
            return stateDto;
          } catch (Exception ex) { var response = MovementConfirmationsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{movementConfirmationDocumentNumber}/MovementConfirmationLines/{lineNumber}")]
        [HttpGet]
        public IMovementConfirmationLineStateDto GetMovementConfirmationLine(string movementConfirmationDocumentNumber, string lineNumber)
        {
          try {
            var state = (MovementConfirmationLineState)_movementConfirmationApplicationService.GetMovementConfirmationLine(movementConfirmationDocumentNumber, lineNumber);
            if (state == null) { return null; }
            var stateDto = new MovementConfirmationLineStateDtoWrapper(state);
            stateDto.AllFieldsReturned = true;
            return stateDto;
          } catch (Exception ex) { var response = MovementConfirmationsControllerUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
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
                return MovementConfirmationsControllerUtils.GetFilterPropertyType(propertyName);
            }
        }

    }


    
    public static class MovementConfirmationsControllerUtils
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

        public static void SetNullIdOrThrowOnInconsistentIds(string id, CreateOrMergePatchOrDeleteMovementConfirmationDto value)
        {
            var idObj = id;
            if (value.DocumentNumber == null)
            {
                value.DocumentNumber = idObj;
            }
            else if (!((ICreateOrMergePatchOrDeleteMovementConfirmation)value).DocumentNumber.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, value.DocumentNumber);
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
            if (MovementConfirmationMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(fieldName))
            {
                return MovementConfirmationMetadata.Instance.FilteringPropertyAliasDictionary[fieldName];
            }
            return null;
        }

        public static Type GetFilterPropertyType(string propertyName)
        {
            if (MovementConfirmationMetadata.Instance.PropertyMetadataDictionary.ContainsKey(propertyName))
            {
                return MovementConfirmationMetadata.Instance.PropertyMetadataDictionary[propertyName].Type;
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

        public static IEnumerable<IMovementConfirmationStateDto> ToMovementConfirmationStateDtoCollection(IEnumerable<string> ids)
        {
            var states = new List<IMovementConfirmationStateDto>();
            foreach (var id in ids)
            {
                var dto = new MovementConfirmationStateDtoWrapper();
                dto.DocumentNumber = id;
                states.Add(dto);
            }
            return states;
        }

        public static IEnumerable<IMovementConfirmationState> ToMovementConfirmationStateCollection(IEnumerable<string> ids)
        {
            var states = new List<MovementConfirmationState>();
            foreach (var id in ids)
            {
                var s = new MovementConfirmationState();
                s.DocumentNumber = id;
                states.Add(s);
            }
            return states;
        }

    }

}

