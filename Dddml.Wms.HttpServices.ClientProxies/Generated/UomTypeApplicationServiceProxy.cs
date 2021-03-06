﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateRamlClientProxies.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.UomType;
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

    public partial class UomTypeApplicationServiceProxy : IUomTypeApplicationService
    {

        private DddmlWmsRamlClient _ramlClient;

        public UomTypeApplicationServiceProxy(ProxyTemplate proxyTemplate)
            : this(proxyTemplate.GetEndpointUrl())
        {
            _ramlClient.GetAuthenticationHeaderValue = proxyTemplate.GetAuthenticationHeaderValue;
        }

        public UomTypeApplicationServiceProxy(string endpointUrl)
        {
            _ramlClient = new DddmlWmsRamlClient(endpointUrl);
        }

        public UomTypeApplicationServiceProxy(HttpClient httpClient)
        {
            _ramlClient = new DddmlWmsRamlClient(httpClient);
        }

        public async Task WhenAsync(CreateUomTypeDto c)
        {
            var idObj = (c as ICreateUomType).UomTypeId;
            var uriParameters = new UomTypeUriParameters();
            uriParameters.Id = idObj;

            var req = new UomTypePutRequest(uriParameters, (CreateUomTypeDto)c);
                
            var resp = await _ramlClient.UomType.Put(req);
            UomTypeProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(CreateUomTypeDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }

        public async Task WhenAsync(MergePatchUomTypeDto c)
        {
            var idObj = (c as IMergePatchUomType).UomTypeId;
            var uriParameters = new UomTypeUriParameters();
            uriParameters.Id = idObj;

            var req = new UomTypePatchRequest(uriParameters, (MergePatchUomTypeDto)c);
            var resp = await _ramlClient.UomType.Patch(req);
            UomTypeProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(MergePatchUomTypeDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }

        public async Task WhenAsync(DeleteUomTypeDto c)
        {
            var idObj = (c as IDeleteUomType).UomTypeId;
            var uriParameters = new UomTypeUriParameters();
            uriParameters.Id = idObj;

            var q = new UomTypeDeleteQuery();
            q.CommandId = c.CommandId;
            q.RequesterId = c.RequesterId;
            q.Version = Convert.ToString(c.Version);
                
            var req = new UomTypeDeleteRequest(uriParameters);
            req.Query = q;

            var resp = await _ramlClient.UomType.Delete(req);
            UomTypeProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(DeleteUomTypeDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }
		
        void IUomTypeApplicationService.When(ICreateUomType c)
        {
            this.When((CreateUomTypeDto)c);
        }

        void IUomTypeApplicationService.When(IMergePatchUomType c)
        {
            this.When((MergePatchUomTypeDto)c);
        }

        void IUomTypeApplicationService.When(IDeleteUomType c)
        {
            this.When((DeleteUomTypeDto)c);
        }

        public async Task<IUomTypeState> GetAsync(string uomTypeId)
        {
            IUomTypeState state = null;
            var idObj = uomTypeId;
            var uriParameters = new UomTypeUriParameters();
            uriParameters.Id = idObj;

            var req = new UomTypeGetRequest(uriParameters);

            var resp = await _ramlClient.UomType.Get(req);
            UomTypeProxyUtils.ThrowOnHttpResponseError(resp);
            state = (resp.Content == null) ? null : resp.Content.ToUomTypeState();
            return state;
        }

        public IUomTypeState Get(string uomTypeId)
        {
            return GetAsync(uomTypeId).GetAwaiter().GetResult();
        }


        public IEnumerable<IUomTypeState> GetAll(int firstResult, int maxResults)
        {
            return Get((IDictionary<string, object>)null, null, firstResult, maxResults);
        }

        public IEnumerable<IUomTypeState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return Get(filter, orders, firstResult, maxResults, null);
        }

        public async Task<IEnumerable<IUomTypeState>> GetAsync(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            IEnumerable<IUomTypeState> states = null;
			var q = new UomTypesGetQuery();
			q.FirstResult = firstResult;
			q.MaxResults = maxResults;
            q.Sort = UomTypeProxyUtils.GetOrdersQueryValueString(orders);
            q.Fields = UomTypeProxyUtils.GetReturnedFieldsQueryValueString(fields, QueryFieldValueSeparator);
            q.FilterTag = UomTypeProxyUtils.GetFilterTagQueryValueString(filter);
            var req = new UomTypesGetRequest();
            req.Query = q;
            var resp = await _ramlClient.UomTypes.Get(req);
            UomTypeProxyUtils.ThrowOnHttpResponseError(resp);
            states = (resp.Content == null) ? null : resp.Content.Select(e => e.ToUomTypeState());
            return states;
        }

        public IEnumerable<IUomTypeState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            return GetAsync(filter, orders, firstResult, maxResults, fields).GetAwaiter().GetResult();
        }

        public IEnumerable<IUomTypeState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return GetByProperty(propertyName, propertyValue, orders, firstResult, maxResults, null);
        }

        public IEnumerable<IUomTypeState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            var filter = Restrictions.Eq(propertyName, propertyValue);
            return Get(filter, orders, firstResult, maxResults, fields);
        }

        public virtual void Execute(object command)
        {
            ((dynamic)this).When((dynamic)command);
        }

        public IEnumerable<IUomTypeState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return Get(filter, orders, firstResult, maxResults, null);
        }

        public async Task<IEnumerable<IUomTypeState>> GetAsync(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            IEnumerable<IUomTypeState> states = null;
			var q = new UomTypesGetQuery();
			q.FirstResult = firstResult;
			q.MaxResults = maxResults;
            q.Sort = UomTypeProxyUtils.GetOrdersQueryValueString(orders);
            q.Fields = UomTypeProxyUtils.GetReturnedFieldsQueryValueString(fields, QueryFieldValueSeparator);
            q.Filter = UomTypeProxyUtils.GetFilterQueryValueString(filter);
            var req = new UomTypesGetRequest();
            req.Query = q;
            var resp = await _ramlClient.UomTypes.Get(req);
            UomTypeProxyUtils.ThrowOnHttpResponseError(resp);
            states = (resp.Content == null) ? null : resp.Content.Select(e => e.ToUomTypeState());
            return states;
        }

        public IEnumerable<IUomTypeState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            return GetAsync(filter, orders, firstResult, maxResults, fields).GetAwaiter().GetResult();
        }

        public async virtual Task<long> GetCountAsync(IEnumerable<KeyValuePair<string, object>> filter)
		{
			var q = new UomTypesCountGetQuery();
            q.FilterTag = UomTypeProxyUtils.GetFilterTagQueryValueString(filter);
            var req = new UomTypesCountGetRequest();
            req.Query = q;
            var resp = await _ramlClient.UomTypesCount.Get(req);
            UomTypeProxyUtils.ThrowOnHttpResponseError(resp);
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
			var q = new UomTypesCountGetQuery();
            q.Filter = UomTypeProxyUtils.GetFilterQueryValueString(filter);
            var req = new UomTypesCountGetRequest();
            req.Query = q;
            var resp = await _ramlClient.UomTypesCount.Get(req);
            UomTypeProxyUtils.ThrowOnHttpResponseError(resp);
            string str = await resp.RawContent.ReadAsStringAsync();
            if (str.StartsWith("\"")) { str = str.Substring(1); }
            if (str.EndsWith("\"")) { str = str.Substring(0, str.Length - 1); }
            return long.Parse(str);
		}

        public virtual long GetCount(ICriterion filter)
		{
		    return GetCountAsync(filter).GetAwaiter().GetResult();
		}

        public async Task<IUomTypeEvent> GetStateEventAsync(string uomTypeId, long version)
        {
            var idObj = uomTypeId;
            var uriParameters = new UomTypeStateEventUriParameters();
            uriParameters.Id = idObj;
            uriParameters.Version = version.ToString();

            var req = new UomTypeStateEventGetRequest(uriParameters);
            var resp = await _ramlClient.UomTypeStateEvent.Get(req);
            UomTypeProxyUtils.ThrowOnHttpResponseError(resp);
            return resp.Content;
        }

        public IUomTypeEvent GetEvent(string uomTypeId, long version)
        {
            return GetStateEventAsync(uomTypeId, version).GetAwaiter().GetResult();
        }


        public async Task<IUomTypeState> GetHistoryStateAsync(string uomTypeId, long version)
        {
            var idObj = uomTypeId;
            var uriParameters = new UomTypeHistoryStateUriParameters();
            uriParameters.Id = idObj;
            uriParameters.Version = version.ToString();

            var req = new UomTypeHistoryStateGetRequest(uriParameters);
            var resp = await _ramlClient.UomTypeHistoryState.Get(req);
            UomTypeProxyUtils.ThrowOnHttpResponseError(resp);
            return (resp.Content == null) ? null : resp.Content.ToUomTypeState();
        }

        public virtual IUomTypeState GetHistoryState(string uomTypeId, long version)
        {
            return GetHistoryStateAsync(uomTypeId, version).GetAwaiter().GetResult();
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


    public partial class UomTypeApplicationServiceProxyFactory : ProxyFactoryBase, IUomTypeApplicationServiceFactory
    {

        public UomTypeApplicationServiceProxyFactory() : base()
        {}

        public UomTypeApplicationServiceProxyFactory(string endpointUrl) : base(endpointUrl)
        {}

        public IUomTypeApplicationService UomTypeApplicationService
        {
            get
            {
                return new UomTypeApplicationServiceProxy(ProxyTemplate);
            }
        }
		
        public ICreateUomType NewCreateUomType()
        {
            return new CreateUomTypeDto();
        }

        public IMergePatchUomType NewMergePatchUomType()
        {
            return new MergePatchUomTypeDto();
        }

        public IDeleteUomType NewDeleteUomType()
        {
            return new DeleteUomTypeDto();
        }
    }

    public static class UomTypeProxyUtils
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

        public static IEnumerable<string> ToIdCollection(IEnumerable<IUomTypeState> states)
        {
            var ids = new List<string>();
            foreach (var s in states)
            {
                ids.Add(s.UomTypeId);
            }
            return ids;
        }

    }

}

