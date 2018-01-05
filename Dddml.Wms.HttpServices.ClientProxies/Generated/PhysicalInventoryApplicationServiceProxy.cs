﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateRamlClientProxies.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PhysicalInventory;
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

    public partial class PhysicalInventoryApplicationServiceProxy : IPhysicalInventoryApplicationService
    {

        private DddmlWmsRamlClient _ramlClient;

        public PhysicalInventoryApplicationServiceProxy(ProxyTemplate proxyTemplate)
            : this(proxyTemplate.GetEndpointUrl())
        {
            _ramlClient.GetAuthenticationHeaderValue = proxyTemplate.GetAuthenticationHeaderValue;
        }

        public PhysicalInventoryApplicationServiceProxy(string endpointUrl)
        {
            _ramlClient = new DddmlWmsRamlClient(endpointUrl);
        }

        public PhysicalInventoryApplicationServiceProxy(HttpClient httpClient)
        {
            _ramlClient = new DddmlWmsRamlClient(httpClient);
        }

        public async Task WhenAsync(CreatePhysicalInventoryDto c)
        {
            var idObj = (c as ICreatePhysicalInventory).DocumentNumber;
            var uriParameters = new PhysicalInventoryUriParameters();
            uriParameters.Id = idObj;

            var req = new PhysicalInventoryPutRequest(uriParameters, (CreatePhysicalInventoryDto)c);
                
            var resp = await _ramlClient.PhysicalInventory.Put(req);
            PhysicalInventoryProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(CreatePhysicalInventoryDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }

        public async Task WhenAsync(MergePatchPhysicalInventoryDto c)
        {
            var idObj = (c as IMergePatchPhysicalInventory).DocumentNumber;
            var uriParameters = new PhysicalInventoryUriParameters();
            uriParameters.Id = idObj;

            var req = new PhysicalInventoryPatchRequest(uriParameters, (MergePatchPhysicalInventoryDto)c);
            var resp = await _ramlClient.PhysicalInventory.Patch(req);
            PhysicalInventoryProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(MergePatchPhysicalInventoryDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }

        public async Task WhenAsync(DeletePhysicalInventoryDto c)
        {
            var idObj = (c as IDeletePhysicalInventory).DocumentNumber;
            var uriParameters = new PhysicalInventoryUriParameters();
            uriParameters.Id = idObj;

            var q = new PhysicalInventoryDeleteQuery();
            q.CommandId = c.CommandId;
            q.RequesterId = c.RequesterId;
            q.Version = Convert.ToString(c.Version);
                
            var req = new PhysicalInventoryDeleteRequest(uriParameters);
            req.Query = q;

            var resp = await _ramlClient.PhysicalInventory.Delete(req);
            PhysicalInventoryProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(DeletePhysicalInventoryDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }
		
        void IPhysicalInventoryApplicationService.When(ICreatePhysicalInventory c)
        {
            this.When((CreatePhysicalInventoryDto)c);
        }

        void IPhysicalInventoryApplicationService.When(IMergePatchPhysicalInventory c)
        {
            this.When((MergePatchPhysicalInventoryDto)c);
        }

        void IPhysicalInventoryApplicationService.When(IDeletePhysicalInventory c)
        {
            this.When((DeletePhysicalInventoryDto)c);
        }

        public void When(PhysicalInventoryCommands.DocumentAction c)
        {
            throw new NotImplementedException();//todo
        }

        public async Task<IPhysicalInventoryState> GetAsync(string documentNumber)
        {
            IPhysicalInventoryState state = null;
            var idObj = documentNumber;
            var uriParameters = new PhysicalInventoryUriParameters();
            uriParameters.Id = idObj;

            var req = new PhysicalInventoryGetRequest(uriParameters);

            var resp = await _ramlClient.PhysicalInventory.Get(req);
            PhysicalInventoryProxyUtils.ThrowOnHttpResponseError(resp);
            state = (resp.Content == null) ? null : resp.Content.ToPhysicalInventoryState();
            return state;
        }

        public IPhysicalInventoryState Get(string documentNumber)
        {
            return GetAsync(documentNumber).GetAwaiter().GetResult();
        }


        public IEnumerable<IPhysicalInventoryState> GetAll(int firstResult, int maxResults)
        {
            return Get((IDictionary<string, object>)null, null, firstResult, maxResults);
        }

        public IEnumerable<IPhysicalInventoryState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return Get(filter, orders, firstResult, maxResults, null);
        }

        public async Task<IEnumerable<IPhysicalInventoryState>> GetAsync(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            IEnumerable<IPhysicalInventoryState> states = null;
			var q = new PhysicalInventoriesGetQuery();
			q.FirstResult = firstResult;
			q.MaxResults = maxResults;
            q.Sort = PhysicalInventoryProxyUtils.GetOrdersQueryValueString(orders);
            q.Fields = PhysicalInventoryProxyUtils.GetReturnedFieldsQueryValueString(fields, QueryFieldValueSeparator);
            q.FilterTag = PhysicalInventoryProxyUtils.GetFilterTagQueryValueString(filter);
            var req = new PhysicalInventoriesGetRequest();
            req.Query = q;
            var resp = await _ramlClient.PhysicalInventories.Get(req);
            PhysicalInventoryProxyUtils.ThrowOnHttpResponseError(resp);
            states = (resp.Content == null) ? null : resp.Content.Select(e => e.ToPhysicalInventoryState());
            return states;
        }

        public IEnumerable<IPhysicalInventoryState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            return GetAsync(filter, orders, firstResult, maxResults, fields).GetAwaiter().GetResult();
        }

        public IEnumerable<IPhysicalInventoryState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return GetByProperty(propertyName, propertyValue, orders, firstResult, maxResults, null);
        }

        public IEnumerable<IPhysicalInventoryState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            var filter = Restrictions.Eq(propertyName, propertyValue);
            return Get(filter, orders, firstResult, maxResults, fields);
        }

        public virtual void Execute(object command)
        {
            ((dynamic)this).When((dynamic)command);
        }

        public IEnumerable<IPhysicalInventoryState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return Get(filter, orders, firstResult, maxResults, null);
        }

        public async Task<IEnumerable<IPhysicalInventoryState>> GetAsync(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            IEnumerable<IPhysicalInventoryState> states = null;
			var q = new PhysicalInventoriesGetQuery();
			q.FirstResult = firstResult;
			q.MaxResults = maxResults;
            q.Sort = PhysicalInventoryProxyUtils.GetOrdersQueryValueString(orders);
            q.Fields = PhysicalInventoryProxyUtils.GetReturnedFieldsQueryValueString(fields, QueryFieldValueSeparator);
            q.Filter = PhysicalInventoryProxyUtils.GetFilterQueryValueString(filter);
            var req = new PhysicalInventoriesGetRequest();
            req.Query = q;
            var resp = await _ramlClient.PhysicalInventories.Get(req);
            PhysicalInventoryProxyUtils.ThrowOnHttpResponseError(resp);
            states = (resp.Content == null) ? null : resp.Content.Select(e => e.ToPhysicalInventoryState());
            return states;
        }

        public IEnumerable<IPhysicalInventoryState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            return GetAsync(filter, orders, firstResult, maxResults, fields).GetAwaiter().GetResult();
        }

        public async virtual Task<long> GetCountAsync(IEnumerable<KeyValuePair<string, object>> filter)
		{
			var q = new PhysicalInventoriesCountGetQuery();
            q.FilterTag = PhysicalInventoryProxyUtils.GetFilterTagQueryValueString(filter);
            var req = new PhysicalInventoriesCountGetRequest();
            req.Query = q;
            var resp = await _ramlClient.PhysicalInventoriesCount.Get(req);
            PhysicalInventoryProxyUtils.ThrowOnHttpResponseError(resp);
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
			var q = new PhysicalInventoriesCountGetQuery();
            q.Filter = PhysicalInventoryProxyUtils.GetFilterQueryValueString(filter);
            var req = new PhysicalInventoriesCountGetRequest();
            req.Query = q;
            var resp = await _ramlClient.PhysicalInventoriesCount.Get(req);
            PhysicalInventoryProxyUtils.ThrowOnHttpResponseError(resp);
            string str = await resp.RawContent.ReadAsStringAsync();
            if (str.StartsWith("\"")) { str = str.Substring(1); }
            if (str.EndsWith("\"")) { str = str.Substring(0, str.Length - 1); }
            return long.Parse(str);
		}

        public virtual long GetCount(ICriterion filter)
		{
		    return GetCountAsync(filter).GetAwaiter().GetResult();
		}

        public async Task<IPhysicalInventoryStateEvent> GetStateEventAsync(string documentNumber, long version)
        {
            var idObj = documentNumber;
            var uriParameters = new PhysicalInventoryStateEventUriParameters();
            uriParameters.Id = idObj;
            uriParameters.Version = version.ToString();

            var req = new PhysicalInventoryStateEventGetRequest(uriParameters);
            var resp = await _ramlClient.PhysicalInventoryStateEvent.Get(req);
            PhysicalInventoryProxyUtils.ThrowOnHttpResponseError(resp);
            return resp.Content;
        }

        public IPhysicalInventoryStateEvent GetStateEvent(string documentNumber, long version)
        {
            return GetStateEventAsync(documentNumber, version).GetAwaiter().GetResult();
        }


        public async Task<IPhysicalInventoryState> GetHistoryStateAsync(string documentNumber, long version)
        {
            var idObj = documentNumber;
            var uriParameters = new PhysicalInventoryHistoryStateUriParameters();
            uriParameters.Id = idObj;
            uriParameters.Version = version.ToString();

            var req = new PhysicalInventoryHistoryStateGetRequest(uriParameters);
            var resp = await _ramlClient.PhysicalInventoryHistoryState.Get(req);
            PhysicalInventoryProxyUtils.ThrowOnHttpResponseError(resp);
            return (resp.Content == null) ? null : resp.Content.ToPhysicalInventoryState();
        }

        public virtual IPhysicalInventoryState GetHistoryState(string documentNumber, long version)
        {
            return GetHistoryStateAsync(documentNumber, version).GetAwaiter().GetResult();
        }

        public async virtual Task<IPhysicalInventoryLineState> GetPhysicalInventoryLineAsync(string physicalInventoryDocumentNumber, string lineNumber)
        {
            var uriParameters = new PhysicalInventoryLineUriParameters();
            uriParameters.PhysicalInventoryDocumentNumber = physicalInventoryDocumentNumber;
            uriParameters.LineNumber = lineNumber;

            var req = new PhysicalInventoryLineGetRequest(uriParameters);
            var resp = await _ramlClient.PhysicalInventoryLine.Get(req);
            PhysicalInventoryProxyUtils.ThrowOnHttpResponseError(resp);
            return (resp.Content == null) ? null : resp.Content.ToPhysicalInventoryLineState();
        }

        public virtual IPhysicalInventoryLineState GetPhysicalInventoryLine(string physicalInventoryDocumentNumber, string lineNumber)
        {
            return GetPhysicalInventoryLineAsync(physicalInventoryDocumentNumber, lineNumber).GetAwaiter().GetResult();
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


    public partial class PhysicalInventoryApplicationServiceProxyFactory : ProxyFactoryBase, IPhysicalInventoryApplicationServiceFactory
    {

        public PhysicalInventoryApplicationServiceProxyFactory() : base()
        {}

        public PhysicalInventoryApplicationServiceProxyFactory(string endpointUrl) : base(endpointUrl)
        {}

        public IPhysicalInventoryApplicationService PhysicalInventoryApplicationService
        {
            get
            {
                return new PhysicalInventoryApplicationServiceProxy(ProxyTemplate);
            }
        }
		
        public ICreatePhysicalInventory NewCreatePhysicalInventory()
        {
            return new CreatePhysicalInventoryDto();
        }

        public IMergePatchPhysicalInventory NewMergePatchPhysicalInventory()
        {
            return new MergePatchPhysicalInventoryDto();
        }

        public IDeletePhysicalInventory NewDeletePhysicalInventory()
        {
            return new DeletePhysicalInventoryDto();
        }
    }

    public static class PhysicalInventoryProxyUtils
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

        public static IEnumerable<string> ToIdCollection(IEnumerable<IPhysicalInventoryState> states)
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

