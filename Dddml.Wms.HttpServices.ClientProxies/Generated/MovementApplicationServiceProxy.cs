﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateRamlClientProxies.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Movement;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using System.Net.Http;
using System.Web.Http;
using Dddml.Wms.HttpServices.ClientProxies.Raml;
using Dddml.Wms.HttpServices.ClientProxies.Raml.Models;
using System.Text;
using System.ComponentModel;
using RAML.Api.Core;
using Newtonsoft.Json.Linq;
using Dddml.Support.Criterion;
using Dddml.Wms.Specialization.HttpServices.ClientProxies;


namespace Dddml.Wms.HttpServices.ClientProxies
{

    public partial class MovementApplicationServiceProxy : IMovementApplicationService
    {

        private DddmlWmsRamlClient _ramlClient;

        public MovementApplicationServiceProxy(ProxyTemplate proxyTemplate)
            : this(proxyTemplate.GetEndpointUrl())
        {
            _ramlClient.GetAuthenticationHeaderValue = proxyTemplate.GetAuthenticationHeaderValue;
        }

        public MovementApplicationServiceProxy(string endpointUrl)
        {
            _ramlClient = new DddmlWmsRamlClient(endpointUrl);
        }

        public MovementApplicationServiceProxy(HttpClient httpClient)
        {
            _ramlClient = new DddmlWmsRamlClient(httpClient);
        }

        public async Task WhenAsync(CreateMovementDto c)
        {
            var idObj = (c as ICreateMovement).DocumentNumber;
            var uriParameters = new MovementUriParameters();
            uriParameters.Id = idObj;

            var req = new MovementPutRequest(uriParameters, (CreateMovementDto)c);
                
            var resp = await _ramlClient.Movement.Put(req);
            MovementProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(CreateMovementDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }

        public async Task WhenAsync(MergePatchMovementDto c)
        {
            var idObj = (c as IMergePatchMovement).DocumentNumber;
            var uriParameters = new MovementUriParameters();
            uriParameters.Id = idObj;

            var req = new MovementPatchRequest(uriParameters, (MergePatchMovementDto)c);
            var resp = await _ramlClient.Movement.Patch(req);
            MovementProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(MergePatchMovementDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }

        public async Task WhenAsync(DeleteMovementDto c)
        {
            var idObj = (c as IDeleteMovement).DocumentNumber;
            var uriParameters = new MovementUriParameters();
            uriParameters.Id = idObj;

            var q = new MovementDeleteQuery();
            q.CommandId = c.CommandId;
            q.RequesterId = c.RequesterId;
            q.Version = Convert.ToString(c.Version);
                
            var req = new MovementDeleteRequest(uriParameters);
            req.Query = q;

            var resp = await _ramlClient.Movement.Delete(req);
            MovementProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(DeleteMovementDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }
		
        void IMovementApplicationService.When(ICreateMovement c)
        {
            this.When((CreateMovementDto)c);
        }

        void IMovementApplicationService.When(IMergePatchMovement c)
        {
            this.When((MergePatchMovementDto)c);
        }

        void IMovementApplicationService.When(IDeleteMovement c)
        {
            this.When((DeleteMovementDto)c);
        }

        public void When(MovementCommands.AddLine c)
        {
            throw new NotImplementedException();//todo
        }

        public void When(MovementCommands.DocumentAction c)
        {
            throw new NotImplementedException();//todo
        }

        public async Task<IMovementState> GetAsync(string documentNumber)
        {
            IMovementState state = null;
            var idObj = documentNumber;
            var uriParameters = new MovementUriParameters();
            uriParameters.Id = idObj;

            var req = new MovementGetRequest(uriParameters);

            var resp = await _ramlClient.Movement.Get(req);
            MovementProxyUtils.ThrowOnHttpResponseError(resp);
            state = (resp.Content == null) ? null : resp.Content.ToMovementState();
            return state;
        }

        public IMovementState Get(string documentNumber)
        {
            return GetAsync(documentNumber).GetAwaiter().GetResult();
        }


        public IEnumerable<IMovementState> GetAll(int firstResult, int maxResults)
        {
            return Get((IDictionary<string, object>)null, null, firstResult, maxResults);
        }

        public IEnumerable<IMovementState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return Get(filter, orders, firstResult, maxResults, null);
        }

        public async Task<IEnumerable<IMovementState>> GetAsync(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            IEnumerable<IMovementState> states = null;
			var q = new MovementsGetQuery();
			q.FirstResult = firstResult;
			q.MaxResults = maxResults;
            q.Sort = MovementProxyUtils.GetOrdersQueryValueString(orders);
            q.Fields = MovementProxyUtils.GetReturnedFieldsQueryValueString(fields, QueryFieldValueSeparator);
            q.FilterTag = MovementProxyUtils.GetFilterTagQueryValueString(filter);
            var req = new MovementsGetRequest();
            req.Query = q;
            var resp = await _ramlClient.Movements.Get(req);
            MovementProxyUtils.ThrowOnHttpResponseError(resp);
            states = (resp.Content == null) ? null : resp.Content.Select(e => e.ToMovementState());
            return states;
        }

        public IEnumerable<IMovementState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            return GetAsync(filter, orders, firstResult, maxResults, fields).GetAwaiter().GetResult();
        }

        public IEnumerable<IMovementState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return GetByProperty(propertyName, propertyValue, orders, firstResult, maxResults, null);
        }

        public IEnumerable<IMovementState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            var filter = Restrictions.Eq(propertyName, propertyValue);
            return Get(filter, orders, firstResult, maxResults, fields);
        }

        public virtual void Execute(object command)
        {
            ((dynamic)this).When((dynamic)command);
        }

        public IEnumerable<IMovementState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return Get(filter, orders, firstResult, maxResults, null);
        }

        public async Task<IEnumerable<IMovementState>> GetAsync(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            IEnumerable<IMovementState> states = null;
			var q = new MovementsGetQuery();
			q.FirstResult = firstResult;
			q.MaxResults = maxResults;
            q.Sort = MovementProxyUtils.GetOrdersQueryValueString(orders);
            q.Fields = MovementProxyUtils.GetReturnedFieldsQueryValueString(fields, QueryFieldValueSeparator);
            q.Filter = MovementProxyUtils.GetFilterQueryValueString(filter);
            var req = new MovementsGetRequest();
            req.Query = q;
            var resp = await _ramlClient.Movements.Get(req);
            MovementProxyUtils.ThrowOnHttpResponseError(resp);
            states = (resp.Content == null) ? null : resp.Content.Select(e => e.ToMovementState());
            return states;
        }

        public IEnumerable<IMovementState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            return GetAsync(filter, orders, firstResult, maxResults, fields).GetAwaiter().GetResult();
        }

        public async virtual Task<long> GetCountAsync(IEnumerable<KeyValuePair<string, object>> filter)
		{
			var q = new MovementsCountGetQuery();
            q.FilterTag = MovementProxyUtils.GetFilterTagQueryValueString(filter);
            var req = new MovementsCountGetRequest();
            req.Query = q;
            var resp = await _ramlClient.MovementsCount.Get(req);
            MovementProxyUtils.ThrowOnHttpResponseError(resp);
            string str = await resp.RawContent.ReadAsStringAsync();
            if (str.StartsWith("\"")) { str = str.Substring(1); }
            if (str.EndsWith("\"")) { str = str.Substring(0, str.Length - 1); }
            return long.Parse(str);
		}

        public virtual long GetCount(IEnumerable<KeyValuePair<string, object>> filter)
		{
		    return GetCountAsync(filter).GetAwaiter().GetResult();
		}

        public async virtual Task<long> GetCountAsync(ICriterion filter)
		{
			var q = new MovementsCountGetQuery();
            q.Filter = MovementProxyUtils.GetFilterQueryValueString(filter);
            var req = new MovementsCountGetRequest();
            req.Query = q;
            var resp = await _ramlClient.MovementsCount.Get(req);
            MovementProxyUtils.ThrowOnHttpResponseError(resp);
            string str = await resp.RawContent.ReadAsStringAsync();
            if (str.StartsWith("\"")) { str = str.Substring(1); }
            if (str.EndsWith("\"")) { str = str.Substring(0, str.Length - 1); }
            return long.Parse(str);
		}

        public virtual long GetCount(ICriterion filter)
		{
		    return GetCountAsync(filter).GetAwaiter().GetResult();
		}

        public async Task<IMovementEvent> GetStateEventAsync(string documentNumber, long version)
        {
            var idObj = documentNumber;
            var uriParameters = new MovementStateEventUriParameters();
            uriParameters.Id = idObj;
            uriParameters.Version = version.ToString();

            var req = new MovementStateEventGetRequest(uriParameters);
            var resp = await _ramlClient.MovementStateEvent.Get(req);
            MovementProxyUtils.ThrowOnHttpResponseError(resp);
            return resp.Content;
        }

        public IMovementEvent GetEvent(string documentNumber, long version)
        {
            return GetStateEventAsync(documentNumber, version).GetAwaiter().GetResult();
        }


        public async Task<IMovementState> GetHistoryStateAsync(string documentNumber, long version)
        {
            var idObj = documentNumber;
            var uriParameters = new MovementHistoryStateUriParameters();
            uriParameters.Id = idObj;
            uriParameters.Version = version.ToString();

            var req = new MovementHistoryStateGetRequest(uriParameters);
            var resp = await _ramlClient.MovementHistoryState.Get(req);
            MovementProxyUtils.ThrowOnHttpResponseError(resp);
            return (resp.Content == null) ? null : resp.Content.ToMovementState();
        }

        public virtual IMovementState GetHistoryState(string documentNumber, long version)
        {
            return GetHistoryStateAsync(documentNumber, version).GetAwaiter().GetResult();
        }

        public async virtual Task<IMovementLineState> GetMovementLineAsync(string movementDocumentNumber, string lineNumber)
        {
            var uriParameters = new MovementLineUriParameters();
            uriParameters.MovementDocumentNumber = movementDocumentNumber;
            uriParameters.LineNumber = lineNumber;

            var req = new MovementLineGetRequest(uriParameters);
            var resp = await _ramlClient.MovementLine.Get(req);
            MovementProxyUtils.ThrowOnHttpResponseError(resp);
            return (resp.Content == null) ? null : resp.Content.ToMovementLineState();
        }

        public virtual IMovementLineState GetMovementLine(string movementDocumentNumber, string lineNumber)
        {
            return GetMovementLineAsync(movementDocumentNumber, lineNumber).GetAwaiter().GetResult();
        }

        public IEnumerable<IMovementLineState> GetMovementLines(string movementDocumentNumber)
        {
            throw new NotImplementedException();//todo
        }


        protected virtual string QueryFieldValueSeparator
        {
            get { return ","; }
        }

        protected virtual string QueryOrderSeparator
        {
            get { return ","; }
        }

    }


    public partial class MovementApplicationServiceProxyFactory : ProxyFactoryBase, IMovementApplicationServiceFactory
    {

        public MovementApplicationServiceProxyFactory() : base()
        {}

        public MovementApplicationServiceProxyFactory(string endpointUrl) : base(endpointUrl)
        {}

        public IMovementApplicationService MovementApplicationService
        {
            get
            {
                return new MovementApplicationServiceProxy(ProxyTemplate);
            }
        }
		
        public ICreateMovement NewCreateMovement()
        {
            return new CreateMovementDto();
        }

        public IMergePatchMovement NewMergePatchMovement()
        {
            return new MergePatchMovementDto();
        }

        public IDeleteMovement NewDeleteMovement()
        {
            return new DeleteMovementDto();
        }
    }

    public static class MovementProxyUtils
    {

        private class ProxyTypeConverter : Dddml.Support.Criterion.ITypeConverter
        {
            public T ConvertFromString<T>(string text)
            {
                throw new NotSupportedException();
            }

            public object ConvertFromString(Type type, string text)
            {
                throw new NotSupportedException();
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
                var list = new List<string>();
                foreach (var o in values)
                {
                    list.Add(ConvertToString(o));
                }
                return list.ToArray();
            }
        }


        public static string GetFilterQueryValueString(ICriterion filter)
        {
            if (filter == null) { return null; }
            return WebUtility.UrlEncode(JObject.FromObject(new CriterionDto(filter, new ProxyTypeConverter())).ToString());
        }

        public static string GetFilterTagQueryValueString(IEnumerable<KeyValuePair<string, object>> filter)
        {
            if (filter == null) { return null; }
            StringBuilder sb = new StringBuilder();
            sb.Append(DateTime.Now.Ticks);
            foreach (var p in filter)
            {
                var k = p.Key;
                var v = p.Value;
                sb.Append("&");
                sb.Append(k);
                sb.Append("=");
                if (v != null)
                {
                    string valStr = ApplicationContext.Current.TypeConverter.ConvertToString(v.GetType(), v);
                    sb.Append(WebUtility.UrlEncode(valStr));
                }

            }
            return sb.ToString();
        }

        public static string GetReturnedFieldsQueryValueString(IList<string> fields, string separator)
        {
            if (fields == null) { return null; }
            StringBuilder sb = new StringBuilder();
            foreach (var f in fields)
            {
                sb.Append(WebUtility.UrlEncode(f));
                sb.Append(separator);
            }
            return sb.ToString();
        }

        public static string GetOrdersQueryValueString(IList<string> orders)
        {
            if (orders == null) { return null; }
            StringBuilder sb = new StringBuilder();
            foreach (var ord in orders)
            {
                sb.Append(WebUtility.UrlEncode(ord));
                sb.Append(",");
            }
            return sb.ToString();
        }

        public static void ThrowOnHttpResponseError(ApiResponse resp)
        {
            var httpResponseMessage = new HttpResponseMessage()
            {
                StatusCode = resp.StatusCode,
                Content = resp.RawContent,
                ReasonPhrase = resp.ReasonPhrase
            };
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                return;
            }
            try
            {
                if (resp.StatusCode == HttpStatusCode.InternalServerError)
                {
                    IEnumerable<string> headerValues = new List<string>();
                    if (resp.RawContent != null && resp.RawContent.Headers != null)
                        resp.RawContent.Headers.TryGetValues("Content-Type", out headerValues);
                    if (headerValues.Any(hv => hv.ToLowerInvariant().Contains("json")))
                    {
                        JObject jObj = JObject.Parse(httpResponseMessage.Content.ReadAsStringAsync().GetAwaiter().GetResult());
                        var errorName = jObj.GetValue("ErrorName").ToObject<string>();
                        var errorMessage = jObj.GetValue("ErrorMessage").ToObject<string>();
                        throw DomainError.Named(errorName, errorMessage);
                    }
                }
                throw new HttpResponseException(httpResponseMessage);
            }
            catch
            {
                throw new HttpResponseException(httpResponseMessage);
            }
        }

        public static IEnumerable<string> ToIdCollection(IEnumerable<IMovementState> states)
        {
            var ids = new List<string>();
            foreach (var s in states)
            {
                ids.Add(s.DocumentNumber);
            }
            return ids;
        }

    }

}

