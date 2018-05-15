﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateRamlClientProxies.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.Pickwave;
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

    public partial class PickwaveApplicationServiceProxy : IPickwaveApplicationService
    {

        private DddmlWmsRamlClient _ramlClient;

        public PickwaveApplicationServiceProxy(ProxyTemplate proxyTemplate)
            : this(proxyTemplate.GetEndpointUrl())
        {
            _ramlClient.GetAuthenticationHeaderValue = proxyTemplate.GetAuthenticationHeaderValue;
        }

        public PickwaveApplicationServiceProxy(string endpointUrl)
        {
            _ramlClient = new DddmlWmsRamlClient(endpointUrl);
        }

        public PickwaveApplicationServiceProxy(HttpClient httpClient)
        {
            _ramlClient = new DddmlWmsRamlClient(httpClient);
        }

        public async Task WhenAsync(CreatePickwaveDto c)
        {
            var idObj = (c as ICreatePickwave).PickwaveId;
            var uriParameters = new PickwaveUriParameters();
            uriParameters.Id = idObj;

            var req = new PickwavePutRequest(uriParameters, (CreatePickwaveDto)c);
                
            var resp = await _ramlClient.Pickwave.Put(req);
            PickwaveProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(CreatePickwaveDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }

        public async Task WhenAsync(MergePatchPickwaveDto c)
        {
            var idObj = (c as IMergePatchPickwave).PickwaveId;
            var uriParameters = new PickwaveUriParameters();
            uriParameters.Id = idObj;

            var req = new PickwavePatchRequest(uriParameters, (MergePatchPickwaveDto)c);
            var resp = await _ramlClient.Pickwave.Patch(req);
            PickwaveProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(MergePatchPickwaveDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }

        public async Task WhenAsync(DeletePickwaveDto c)
        {
            var idObj = (c as IDeletePickwave).PickwaveId;
            var uriParameters = new PickwaveUriParameters();
            uriParameters.Id = idObj;

            var q = new PickwaveDeleteQuery();
            q.CommandId = c.CommandId;
            q.RequesterId = c.RequesterId;
            q.Version = Convert.ToString(c.Version);
                
            var req = new PickwaveDeleteRequest(uriParameters);
            req.Query = q;

            var resp = await _ramlClient.Pickwave.Delete(req);
            PickwaveProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(DeletePickwaveDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }
		
        void IPickwaveApplicationService.When(ICreatePickwave c)
        {
            this.When((CreatePickwaveDto)c);
        }

        void IPickwaveApplicationService.When(IMergePatchPickwave c)
        {
            this.When((MergePatchPickwaveDto)c);
        }

        void IPickwaveApplicationService.When(IDeletePickwave c)
        {
            this.When((DeletePickwaveDto)c);
        }

        public async Task<IPickwaveState> GetAsync(long? pickwaveId)
        {
            IPickwaveState state = null;
            var idObj = pickwaveId;
            var uriParameters = new PickwaveUriParameters();
            uriParameters.Id = idObj;

            var req = new PickwaveGetRequest(uriParameters);

            var resp = await _ramlClient.Pickwave.Get(req);
            PickwaveProxyUtils.ThrowOnHttpResponseError(resp);
            state = (resp.Content == null) ? null : resp.Content.ToPickwaveState();
            return state;
        }

        public IPickwaveState Get(long? pickwaveId)
        {
            return GetAsync(pickwaveId).GetAwaiter().GetResult();
        }


        public IEnumerable<IPickwaveState> GetAll(int firstResult, int maxResults)
        {
            return Get((IDictionary<string, object>)null, null, firstResult, maxResults);
        }

        public IEnumerable<IPickwaveState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return Get(filter, orders, firstResult, maxResults, null);
        }

        public async Task<IEnumerable<IPickwaveState>> GetAsync(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            IEnumerable<IPickwaveState> states = null;
			var q = new PickwavesGetQuery();
			q.FirstResult = firstResult;
			q.MaxResults = maxResults;
            q.Sort = PickwaveProxyUtils.GetOrdersQueryValueString(orders);
            q.Fields = PickwaveProxyUtils.GetReturnedFieldsQueryValueString(fields, QueryFieldValueSeparator);
            q.FilterTag = PickwaveProxyUtils.GetFilterTagQueryValueString(filter);
            var req = new PickwavesGetRequest();
            req.Query = q;
            var resp = await _ramlClient.Pickwaves.Get(req);
            PickwaveProxyUtils.ThrowOnHttpResponseError(resp);
            states = (resp.Content == null) ? null : resp.Content.Select(e => e.ToPickwaveState());
            return states;
        }

        public IEnumerable<IPickwaveState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            return GetAsync(filter, orders, firstResult, maxResults, fields).GetAwaiter().GetResult();
        }

        public IEnumerable<IPickwaveState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return GetByProperty(propertyName, propertyValue, orders, firstResult, maxResults, null);
        }

        public IEnumerable<IPickwaveState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            var filter = Restrictions.Eq(propertyName, propertyValue);
            return Get(filter, orders, firstResult, maxResults, fields);
        }

        public virtual void Execute(object command)
        {
            ((dynamic)this).When((dynamic)command);
        }

        public IEnumerable<IPickwaveState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return Get(filter, orders, firstResult, maxResults, null);
        }

        public async Task<IEnumerable<IPickwaveState>> GetAsync(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            IEnumerable<IPickwaveState> states = null;
			var q = new PickwavesGetQuery();
			q.FirstResult = firstResult;
			q.MaxResults = maxResults;
            q.Sort = PickwaveProxyUtils.GetOrdersQueryValueString(orders);
            q.Fields = PickwaveProxyUtils.GetReturnedFieldsQueryValueString(fields, QueryFieldValueSeparator);
            q.Filter = PickwaveProxyUtils.GetFilterQueryValueString(filter);
            var req = new PickwavesGetRequest();
            req.Query = q;
            var resp = await _ramlClient.Pickwaves.Get(req);
            PickwaveProxyUtils.ThrowOnHttpResponseError(resp);
            states = (resp.Content == null) ? null : resp.Content.Select(e => e.ToPickwaveState());
            return states;
        }

        public IEnumerable<IPickwaveState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            return GetAsync(filter, orders, firstResult, maxResults, fields).GetAwaiter().GetResult();
        }

        public async virtual Task<long> GetCountAsync(IEnumerable<KeyValuePair<string, object>> filter)
		{
			var q = new PickwavesCountGetQuery();
            q.FilterTag = PickwaveProxyUtils.GetFilterTagQueryValueString(filter);
            var req = new PickwavesCountGetRequest();
            req.Query = q;
            var resp = await _ramlClient.PickwavesCount.Get(req);
            PickwaveProxyUtils.ThrowOnHttpResponseError(resp);
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
			var q = new PickwavesCountGetQuery();
            q.Filter = PickwaveProxyUtils.GetFilterQueryValueString(filter);
            var req = new PickwavesCountGetRequest();
            req.Query = q;
            var resp = await _ramlClient.PickwavesCount.Get(req);
            PickwaveProxyUtils.ThrowOnHttpResponseError(resp);
            string str = await resp.RawContent.ReadAsStringAsync();
            if (str.StartsWith("\"")) { str = str.Substring(1); }
            if (str.EndsWith("\"")) { str = str.Substring(0, str.Length - 1); }
            return long.Parse(str);
		}

        public virtual long GetCount(ICriterion filter)
		{
		    return GetCountAsync(filter).GetAwaiter().GetResult();
		}

        public async Task<IPickwaveEvent> GetStateEventAsync(long? pickwaveId, long version)
        {
            var idObj = pickwaveId;
            var uriParameters = new PickwaveStateEventUriParameters();
            uriParameters.Id = idObj;
            uriParameters.Version = version.ToString();

            var req = new PickwaveStateEventGetRequest(uriParameters);
            var resp = await _ramlClient.PickwaveStateEvent.Get(req);
            PickwaveProxyUtils.ThrowOnHttpResponseError(resp);
            return resp.Content;
        }

        public IPickwaveEvent GetEvent(long? pickwaveId, long version)
        {
            return GetStateEventAsync(pickwaveId, version).GetAwaiter().GetResult();
        }


        public async Task<IPickwaveState> GetHistoryStateAsync(long? pickwaveId, long version)
        {
            var idObj = pickwaveId;
            var uriParameters = new PickwaveHistoryStateUriParameters();
            uriParameters.Id = idObj;
            uriParameters.Version = version.ToString();

            var req = new PickwaveHistoryStateGetRequest(uriParameters);
            var resp = await _ramlClient.PickwaveHistoryState.Get(req);
            PickwaveProxyUtils.ThrowOnHttpResponseError(resp);
            return (resp.Content == null) ? null : resp.Content.ToPickwaveState();
        }

        public virtual IPickwaveState GetHistoryState(long? pickwaveId, long version)
        {
            return GetHistoryStateAsync(pickwaveId, version).GetAwaiter().GetResult();
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


    public partial class PickwaveApplicationServiceProxyFactory : ProxyFactoryBase, IPickwaveApplicationServiceFactory
    {

        public PickwaveApplicationServiceProxyFactory() : base()
        {}

        public PickwaveApplicationServiceProxyFactory(string endpointUrl) : base(endpointUrl)
        {}

        public IPickwaveApplicationService PickwaveApplicationService
        {
            get
            {
                return new PickwaveApplicationServiceProxy(ProxyTemplate);
            }
        }
		
        public ICreatePickwave NewCreatePickwave()
        {
            return new CreatePickwaveDto();
        }

        public IMergePatchPickwave NewMergePatchPickwave()
        {
            return new MergePatchPickwaveDto();
        }

        public IDeletePickwave NewDeletePickwave()
        {
            return new DeletePickwaveDto();
        }
    }

    public static class PickwaveProxyUtils
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

        public static IEnumerable<long?> ToIdCollection(IEnumerable<IPickwaveState> states)
        {
            var ids = new List<long?>();
            foreach (var s in states)
            {
                ids.Add(s.PickwaveId);
            }
            return ids;
        }

    }

}
