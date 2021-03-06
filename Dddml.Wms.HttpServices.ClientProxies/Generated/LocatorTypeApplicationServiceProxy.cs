﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateRamlClientProxies.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.LocatorType;
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

    public partial class LocatorTypeApplicationServiceProxy : ILocatorTypeApplicationService
    {

        private DddmlWmsRamlClient _ramlClient;

        public LocatorTypeApplicationServiceProxy(ProxyTemplate proxyTemplate)
            : this(proxyTemplate.GetEndpointUrl())
        {
            _ramlClient.GetAuthenticationHeaderValue = proxyTemplate.GetAuthenticationHeaderValue;
        }

        public LocatorTypeApplicationServiceProxy(string endpointUrl)
        {
            _ramlClient = new DddmlWmsRamlClient(endpointUrl);
        }

        public LocatorTypeApplicationServiceProxy(HttpClient httpClient)
        {
            _ramlClient = new DddmlWmsRamlClient(httpClient);
        }

        public async Task WhenAsync(CreateLocatorTypeDto c)
        {
            var idObj = (c as ICreateLocatorType).LocatorTypeId;
            var uriParameters = new LocatorTypeUriParameters();
            uriParameters.Id = idObj;

            var req = new LocatorTypePutRequest(uriParameters, (CreateLocatorTypeDto)c);
                
            var resp = await _ramlClient.LocatorType.Put(req);
            LocatorTypeProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(CreateLocatorTypeDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }

        public async Task WhenAsync(MergePatchLocatorTypeDto c)
        {
            var idObj = (c as IMergePatchLocatorType).LocatorTypeId;
            var uriParameters = new LocatorTypeUriParameters();
            uriParameters.Id = idObj;

            var req = new LocatorTypePatchRequest(uriParameters, (MergePatchLocatorTypeDto)c);
            var resp = await _ramlClient.LocatorType.Patch(req);
            LocatorTypeProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(MergePatchLocatorTypeDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }

        public async Task WhenAsync(DeleteLocatorTypeDto c)
        {
            var idObj = (c as IDeleteLocatorType).LocatorTypeId;
            var uriParameters = new LocatorTypeUriParameters();
            uriParameters.Id = idObj;

            var q = new LocatorTypeDeleteQuery();
            q.CommandId = c.CommandId;
            q.RequesterId = c.RequesterId;
            q.Version = Convert.ToString(c.Version);
                
            var req = new LocatorTypeDeleteRequest(uriParameters);
            req.Query = q;

            var resp = await _ramlClient.LocatorType.Delete(req);
            LocatorTypeProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(DeleteLocatorTypeDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }
		
        void ILocatorTypeApplicationService.When(ICreateLocatorType c)
        {
            this.When((CreateLocatorTypeDto)c);
        }

        void ILocatorTypeApplicationService.When(IMergePatchLocatorType c)
        {
            this.When((MergePatchLocatorTypeDto)c);
        }

        void ILocatorTypeApplicationService.When(IDeleteLocatorType c)
        {
            this.When((DeleteLocatorTypeDto)c);
        }

        public async Task<ILocatorTypeState> GetAsync(string locatorTypeId)
        {
            ILocatorTypeState state = null;
            var idObj = locatorTypeId;
            var uriParameters = new LocatorTypeUriParameters();
            uriParameters.Id = idObj;

            var req = new LocatorTypeGetRequest(uriParameters);

            var resp = await _ramlClient.LocatorType.Get(req);
            LocatorTypeProxyUtils.ThrowOnHttpResponseError(resp);
            state = (resp.Content == null) ? null : resp.Content.ToLocatorTypeState();
            return state;
        }

        public ILocatorTypeState Get(string locatorTypeId)
        {
            return GetAsync(locatorTypeId).GetAwaiter().GetResult();
        }


        public IEnumerable<ILocatorTypeState> GetAll(int firstResult, int maxResults)
        {
            return Get((IDictionary<string, object>)null, null, firstResult, maxResults);
        }

        public IEnumerable<ILocatorTypeState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return Get(filter, orders, firstResult, maxResults, null);
        }

        public async Task<IEnumerable<ILocatorTypeState>> GetAsync(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            IEnumerable<ILocatorTypeState> states = null;
			var q = new LocatorTypesGetQuery();
			q.FirstResult = firstResult;
			q.MaxResults = maxResults;
            q.Sort = LocatorTypeProxyUtils.GetOrdersQueryValueString(orders);
            q.Fields = LocatorTypeProxyUtils.GetReturnedFieldsQueryValueString(fields, QueryFieldValueSeparator);
            q.FilterTag = LocatorTypeProxyUtils.GetFilterTagQueryValueString(filter);
            var req = new LocatorTypesGetRequest();
            req.Query = q;
            var resp = await _ramlClient.LocatorTypes.Get(req);
            LocatorTypeProxyUtils.ThrowOnHttpResponseError(resp);
            states = (resp.Content == null) ? null : resp.Content.Select(e => e.ToLocatorTypeState());
            return states;
        }

        public IEnumerable<ILocatorTypeState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            return GetAsync(filter, orders, firstResult, maxResults, fields).GetAwaiter().GetResult();
        }

        public IEnumerable<ILocatorTypeState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return GetByProperty(propertyName, propertyValue, orders, firstResult, maxResults, null);
        }

        public IEnumerable<ILocatorTypeState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            var filter = Restrictions.Eq(propertyName, propertyValue);
            return Get(filter, orders, firstResult, maxResults, fields);
        }

        public virtual void Execute(object command)
        {
            ((dynamic)this).When((dynamic)command);
        }

        public IEnumerable<ILocatorTypeState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return Get(filter, orders, firstResult, maxResults, null);
        }

        public async Task<IEnumerable<ILocatorTypeState>> GetAsync(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            IEnumerable<ILocatorTypeState> states = null;
			var q = new LocatorTypesGetQuery();
			q.FirstResult = firstResult;
			q.MaxResults = maxResults;
            q.Sort = LocatorTypeProxyUtils.GetOrdersQueryValueString(orders);
            q.Fields = LocatorTypeProxyUtils.GetReturnedFieldsQueryValueString(fields, QueryFieldValueSeparator);
            q.Filter = LocatorTypeProxyUtils.GetFilterQueryValueString(filter);
            var req = new LocatorTypesGetRequest();
            req.Query = q;
            var resp = await _ramlClient.LocatorTypes.Get(req);
            LocatorTypeProxyUtils.ThrowOnHttpResponseError(resp);
            states = (resp.Content == null) ? null : resp.Content.Select(e => e.ToLocatorTypeState());
            return states;
        }

        public IEnumerable<ILocatorTypeState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            return GetAsync(filter, orders, firstResult, maxResults, fields).GetAwaiter().GetResult();
        }

        public async virtual Task<long> GetCountAsync(IEnumerable<KeyValuePair<string, object>> filter)
		{
			var q = new LocatorTypesCountGetQuery();
            q.FilterTag = LocatorTypeProxyUtils.GetFilterTagQueryValueString(filter);
            var req = new LocatorTypesCountGetRequest();
            req.Query = q;
            var resp = await _ramlClient.LocatorTypesCount.Get(req);
            LocatorTypeProxyUtils.ThrowOnHttpResponseError(resp);
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
			var q = new LocatorTypesCountGetQuery();
            q.Filter = LocatorTypeProxyUtils.GetFilterQueryValueString(filter);
            var req = new LocatorTypesCountGetRequest();
            req.Query = q;
            var resp = await _ramlClient.LocatorTypesCount.Get(req);
            LocatorTypeProxyUtils.ThrowOnHttpResponseError(resp);
            string str = await resp.RawContent.ReadAsStringAsync();
            if (str.StartsWith("\"")) { str = str.Substring(1); }
            if (str.EndsWith("\"")) { str = str.Substring(0, str.Length - 1); }
            return long.Parse(str);
		}

        public virtual long GetCount(ICriterion filter)
		{
		    return GetCountAsync(filter).GetAwaiter().GetResult();
		}

        public async Task<ILocatorTypeEvent> GetStateEventAsync(string locatorTypeId, long version)
        {
            var idObj = locatorTypeId;
            var uriParameters = new LocatorTypeStateEventUriParameters();
            uriParameters.Id = idObj;
            uriParameters.Version = version.ToString();

            var req = new LocatorTypeStateEventGetRequest(uriParameters);
            var resp = await _ramlClient.LocatorTypeStateEvent.Get(req);
            LocatorTypeProxyUtils.ThrowOnHttpResponseError(resp);
            return resp.Content;
        }

        public ILocatorTypeEvent GetEvent(string locatorTypeId, long version)
        {
            return GetStateEventAsync(locatorTypeId, version).GetAwaiter().GetResult();
        }


        public async Task<ILocatorTypeState> GetHistoryStateAsync(string locatorTypeId, long version)
        {
            var idObj = locatorTypeId;
            var uriParameters = new LocatorTypeHistoryStateUriParameters();
            uriParameters.Id = idObj;
            uriParameters.Version = version.ToString();

            var req = new LocatorTypeHistoryStateGetRequest(uriParameters);
            var resp = await _ramlClient.LocatorTypeHistoryState.Get(req);
            LocatorTypeProxyUtils.ThrowOnHttpResponseError(resp);
            return (resp.Content == null) ? null : resp.Content.ToLocatorTypeState();
        }

        public virtual ILocatorTypeState GetHistoryState(string locatorTypeId, long version)
        {
            return GetHistoryStateAsync(locatorTypeId, version).GetAwaiter().GetResult();
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


    public partial class LocatorTypeApplicationServiceProxyFactory : ProxyFactoryBase, ILocatorTypeApplicationServiceFactory
    {

        public LocatorTypeApplicationServiceProxyFactory() : base()
        {}

        public LocatorTypeApplicationServiceProxyFactory(string endpointUrl) : base(endpointUrl)
        {}

        public ILocatorTypeApplicationService LocatorTypeApplicationService
        {
            get
            {
                return new LocatorTypeApplicationServiceProxy(ProxyTemplate);
            }
        }
		
        public ICreateLocatorType NewCreateLocatorType()
        {
            return new CreateLocatorTypeDto();
        }

        public IMergePatchLocatorType NewMergePatchLocatorType()
        {
            return new MergePatchLocatorTypeDto();
        }

        public IDeleteLocatorType NewDeleteLocatorType()
        {
            return new DeleteLocatorTypeDto();
        }
    }

    public static class LocatorTypeProxyUtils
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

        public static IEnumerable<string> ToIdCollection(IEnumerable<ILocatorTypeState> states)
        {
            var ids = new List<string>();
            foreach (var s in states)
            {
                ids.Add(s.LocatorTypeId);
            }
            return ids;
        }

    }

}

