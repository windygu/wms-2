﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateAggregatesControllers.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InOut;
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

    [RoutePrefix("api/InOuts")]
    public partial class InOutsController : ApiController
    {

        IInOutApplicationService _inOutApplicationService = ApplicationContext.Current["InOutApplicationService"] as IInOutApplicationService;

        [Route(Order = 1)]
        [HttpGet]
        public IEnumerable<IInOutStateDto> GetAll(string sort = null, string fields = null, int firstResult = 0, int maxResults = int.MaxValue, string filter = null)
        {
          try {
            IEnumerable<IInOutState> states = null; 
            if (!String.IsNullOrWhiteSpace(filter))
            {
                states = _inOutApplicationService.Get(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new WebApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (InOutMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? InOutMetadata.Instance.FilteringPropertyAliasDictionary[n] : n))
                    , InOutsControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            else 
            {
                states = _inOutApplicationService.Get(InOutsControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs())
                    , InOutsControllerUtils.GetQueryOrders(sort, QueryOrderSeparator), firstResult, maxResults);
            }
            var stateDtos = new List<IInOutStateDto>();
            foreach (var s in states)
            {
                var dto = s is InOutStateDtoWrapper ? (InOutStateDtoWrapper)s : new InOutStateDtoWrapper(s);
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
        public IInOutStateDto Get(string id, string fields = null)
        {
          try {
            var idObj = id;
            var state = _inOutApplicationService.Get(idObj);
            if (state == null) { return null; }
            var stateDto = new InOutStateDtoWrapper(state);
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
                count = _inOutApplicationService.GetCount(CriterionDto.ToSubclass(JObject.Parse(filter).ToObject<CriterionDto>(), new WebApiControllerTypeConverter(), new PropertyTypeResolver()
                    , n => (InOutMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(n) ? InOutMetadata.Instance.FilteringPropertyAliasDictionary[n] : n)));
            }
            else 
            {
                count = _inOutApplicationService.GetCount(InOutsControllerUtils.GetQueryFilterDictionary(this.Request.GetQueryNameValuePairs()));
            }
            return count;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route(Order = 1)]
        [HttpPost][SetRequesterId]
        public HttpResponseMessage Post([FromBody]CreateInOutDto value)
        {
          try {
            if (value.DocumentNumber == default(string))
            {
                throw DomainError.Named("nullId", "Aggregate Id in cmd is null, aggregate name: {0}.", "InOut");
            }
            _inOutApplicationService.When(value as ICreateInOut);
            var idObj = value.DocumentNumber;

            return Request.CreateResponse<string>(HttpStatusCode.Created, idObj);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPut][SetRequesterId]
        public void Put(string id, [FromBody]CreateOrMergePatchOrDeleteInOutDto value)
        {
          try {
              // ///////////////////////////////
              if (value.Version != default(long))
              {
                  value.CommandType = CommandType.MergePatch;
                  InOutsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
                  _inOutApplicationService.When(value as IMergePatchInOut);
                  return;
              }
              // ///////////////////////////////

            InOutsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _inOutApplicationService.When(value as ICreateInOut);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [HttpPatch][SetRequesterId]
        public void Patch(string id, [FromBody]MergePatchInOutDto value)
        {
          try {
            InOutsControllerUtils.SetNullIdOrThrowOnInconsistentIds(id, value);
            _inOutApplicationService.When(value as IMergePatchInOut);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_commands/Complete")]
        [HttpPut][SetRequesterId]
        public void Complete(string id, [FromBody]InOutCommandDtos.CompleteRequestContent content)
        {
          try {
            var cmd = content.ToComplete();
            var idObj = id;
            if (cmd.DocumentNumber == null)
            {
                cmd.DocumentNumber = idObj;
            }
            else if (!cmd.DocumentNumber.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, cmd.DocumentNumber);
            }
            _inOutApplicationService.When(cmd);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_commands/Close")]
        [HttpPut][SetRequesterId]
        public void Close(string id, [FromBody]InOutCommandDtos.CloseRequestContent content)
        {
          try {
            var cmd = content.ToClose();
            var idObj = id;
            if (cmd.DocumentNumber == null)
            {
                cmd.DocumentNumber = idObj;
            }
            else if (!cmd.DocumentNumber.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, cmd.DocumentNumber);
            }
            _inOutApplicationService.When(cmd);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_commands/Void")]
        [HttpPut][SetRequesterId]
        public void Void(string id, [FromBody]InOutCommandDtos.VoidRequestContent content)
        {
          try {
            var cmd = content.ToVoid();
            var idObj = id;
            if (cmd.DocumentNumber == null)
            {
                cmd.DocumentNumber = idObj;
            }
            else if (!cmd.DocumentNumber.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, cmd.DocumentNumber);
            }
            _inOutApplicationService.When(cmd);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_commands/Reverse")]
        [HttpPut][SetRequesterId]
        public void Reverse(string id, [FromBody]InOutCommandDtos.ReverseRequestContent content)
        {
          try {
            var cmd = content.ToReverse();
            var idObj = id;
            if (cmd.DocumentNumber == null)
            {
                cmd.DocumentNumber = idObj;
            }
            else if (!cmd.DocumentNumber.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, cmd.DocumentNumber);
            }
            _inOutApplicationService.When(cmd);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_commands/AddLine")]
        [HttpPut][SetRequesterId]
        public void AddLine(string id, [FromBody]InOutCommandDtos.AddLineRequestContent content)
        {
          try {
            var cmd = content.ToAddLine();
            var idObj = id;
            if (cmd.DocumentNumber == null)
            {
                cmd.DocumentNumber = idObj;
            }
            else if (!cmd.DocumentNumber.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, cmd.DocumentNumber);
            }
            _inOutApplicationService.When(cmd);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_commands/Import")]
        [HttpPut][SetRequesterId]
        public void Import(string id, [FromBody]InOutCommandDtos.ImportRequestContent content)
        {
          try {
            var cmd = content.ToImport();
            var idObj = id;
            if (cmd.DocumentNumber == null)
            {
                cmd.DocumentNumber = idObj;
            }
            else if (!cmd.DocumentNumber.Equals(idObj))
            {
                throw DomainError.Named("inconsistentId", "Argument Id {0} NOT equals body Id {1}", id, cmd.DocumentNumber);
            }
            _inOutApplicationService.When(cmd);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_commands/DocumentAction")]
        [HttpPut][SetRequesterId]
        public void DocumentAction(string id, [FromBody]InOutCommandDtos.DocumentActionRequestContent content)
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
            _inOutApplicationService.When(cmd);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("_metadata/filteringFields")]
        [HttpGet]
        public IEnumerable<PropertyMetadataDto> GetMetadataFilteringFields()
        {
          try {
            var filtering = new List<PropertyMetadataDto>();
            foreach (var p in InOutMetadata.Instance.Properties)
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
        public InOutStateCreatedOrMergePatchedOrDeletedDto GetStateEvent(string id, long version)
        {
          try {
            var idObj = id;
            var conv = new InOutStateEventDtoConverter();
            var se = _inOutApplicationService.GetEvent(idObj, version);
            return se == null ? null : conv.ToInOutStateEventDto(se);
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{id}/_historyStates/{version}")]
        [HttpGet]
        public IInOutStateDto GetHistoryState(string id, long version, string fields = null)
        {
          try {
            var idObj = id;
            var state = _inOutApplicationService.GetHistoryState(idObj, version);
            if (state == null) { return null; }
            var stateDto = new InOutStateDtoWrapper(state);
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

        [Route("{inOutDocumentNumber}/InOutImages/{sequenceId}")]
        [HttpGet]
        public IInOutImageStateDto GetInOutImage(string inOutDocumentNumber, string sequenceId)
        {
          try {
            var state = (InOutImageState)_inOutApplicationService.GetInOutImage(inOutDocumentNumber, sequenceId);
            if (state == null) { return null; }
            var stateDto = new InOutImageStateDtoWrapper(state);
            stateDto.AllFieldsReturned = true;
            return stateDto;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{inOutDocumentNumber}/InOutImages/")]
        [HttpGet]
        public IEnumerable<IInOutImageStateDto> GetInOutImages(string inOutDocumentNumber)
        {
          try {
            var states = _inOutApplicationService.GetInOutImages(inOutDocumentNumber);
            if (states == null) { return null; }
            var stateDtos = new List<IInOutImageStateDto>();
            foreach (var s in states)
            {
                var dto = s is InOutImageStateDtoWrapper ? (InOutImageStateDtoWrapper)s : new InOutImageStateDtoWrapper((IInOutImageState)s);
                dto.AllFieldsReturned = true;
                stateDtos.Add(dto);
            }
            return stateDtos;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{inOutDocumentNumber}/InOutLines/{lineNumber}")]
        [HttpGet]
        public IInOutLineStateDto GetInOutLine(string inOutDocumentNumber, string lineNumber)
        {
          try {
            var state = (InOutLineState)_inOutApplicationService.GetInOutLine(inOutDocumentNumber, lineNumber);
            if (state == null) { return null; }
            var stateDto = new InOutLineStateDtoWrapper(state);
            stateDto.AllFieldsReturned = true;
            return stateDto;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{inOutDocumentNumber}/InOutLines/")]
        [HttpGet]
        public IEnumerable<IInOutLineStateDto> GetInOutLines(string inOutDocumentNumber)
        {
          try {
            var states = _inOutApplicationService.GetInOutLines(inOutDocumentNumber);
            if (states == null) { return null; }
            var stateDtos = new List<IInOutLineStateDto>();
            foreach (var s in states)
            {
                var dto = s is InOutLineStateDtoWrapper ? (InOutLineStateDtoWrapper)s : new InOutLineStateDtoWrapper((IInOutLineState)s);
                dto.AllFieldsReturned = true;
                stateDtos.Add(dto);
            }
            return stateDtos;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{inOutDocumentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages/{sequenceId}")]
        [HttpGet]
        public IInOutLineImageStateDto GetInOutLineImage(string inOutDocumentNumber, string inOutLineLineNumber, string sequenceId)
        {
          try {
            var state = (InOutLineImageState)_inOutApplicationService.GetInOutLineImage(inOutDocumentNumber, inOutLineLineNumber, sequenceId);
            if (state == null) { return null; }
            var stateDto = new InOutLineImageStateDtoWrapper(state);
            stateDto.AllFieldsReturned = true;
            return stateDto;
          } catch (Exception ex) { var response = HttpServiceExceptionUtils.GetErrorHttpResponseMessage(ex); throw new HttpResponseException(response); }
        }

        [Route("{inOutDocumentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages/")]
        [HttpGet]
        public IEnumerable<IInOutLineImageStateDto> GetInOutLineImages(string inOutDocumentNumber, string inOutLineLineNumber)
        {
          try {
            var states = _inOutApplicationService.GetInOutLineImages(inOutDocumentNumber, inOutLineLineNumber);
            if (states == null) { return null; }
            var stateDtos = new List<IInOutLineImageStateDto>();
            foreach (var s in states)
            {
                var dto = s is InOutLineImageStateDtoWrapper ? (InOutLineImageStateDtoWrapper)s : new InOutLineImageStateDtoWrapper((IInOutLineImageState)s);
                dto.AllFieldsReturned = true;
                stateDtos.Add(dto);
            }
            return stateDtos;
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
                return InOutsControllerUtils.GetFilterPropertyType(propertyName);
            }
        }

    }


    
    public static class InOutsControllerUtils
    {

        public static void SetNullIdOrThrowOnInconsistentIds(string id, CreateOrMergePatchOrDeleteInOutDto value)
        {
            var idObj = id;
            if (value.DocumentNumber == null)
            {
                value.DocumentNumber = idObj;
            }
            else if (!((ICreateOrMergePatchOrDeleteInOut)value).DocumentNumber.Equals(idObj))
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
            if (InOutMetadata.Instance.FilteringPropertyAliasDictionary.ContainsKey(fieldName))
            {
                return InOutMetadata.Instance.FilteringPropertyAliasDictionary[fieldName];
            }
            return null;
        }

        public static Type GetFilterPropertyType(string propertyName)
        {
            if (InOutMetadata.Instance.PropertyMetadataDictionary.ContainsKey(propertyName))
            {
                return InOutMetadata.Instance.PropertyMetadataDictionary[propertyName].Type;
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

        public static IEnumerable<IInOutStateDto> ToInOutStateDtoCollection(IEnumerable<string> ids)
        {
            var states = new List<IInOutStateDto>();
            foreach (var id in ids)
            {
                var dto = new InOutStateDtoWrapper();
                dto.DocumentNumber = id;
                states.Add(dto);
            }
            return states;
        }

        public static IEnumerable<IInOutState> ToInOutStateCollection(IEnumerable<string> ids)
        {
            var states = new List<InOutState>();
            foreach (var id in ids)
            {
                var s = new InOutState();
                s.DocumentNumber = id;
                states.Add(s);
            }
            return states;
        }

    }

}

