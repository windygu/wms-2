﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateRamlClientProxies.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.OrderRoleMvo;
using Dddml.Wms.Domain.Order;
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

    public partial class OrderRoleMvoApplicationServiceProxy : IOrderRoleMvoApplicationService
    {

        private DddmlWmsRamlClient _ramlClient;

        public OrderRoleMvoApplicationServiceProxy(ProxyTemplate proxyTemplate)
            : this(proxyTemplate.GetEndpointUrl())
        {
            _ramlClient.GetAuthenticationHeaderValue = proxyTemplate.GetAuthenticationHeaderValue;
        }

        public OrderRoleMvoApplicationServiceProxy(string endpointUrl)
        {
            _ramlClient = new DddmlWmsRamlClient(endpointUrl);
        }

        public OrderRoleMvoApplicationServiceProxy(HttpClient httpClient)
        {
            _ramlClient = new DddmlWmsRamlClient(httpClient);
        }

        public async Task WhenAsync(CreateOrderRoleMvoDto c)
        {
            var idObj = OrderRoleMvoProxyUtils.ToIdString((c as ICreateOrderRoleMvo).OrderRoleId);
            var uriParameters = new OrderRoleMvoUriParameters();
            uriParameters.Id = idObj;

            var req = new OrderRoleMvoPutRequest(uriParameters, (CreateOrderRoleMvoDto)c);
                
            var resp = await _ramlClient.OrderRoleMvo.Put(req);
            OrderRoleMvoProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(CreateOrderRoleMvoDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }

        public async Task WhenAsync(MergePatchOrderRoleMvoDto c)
        {
            var idObj = OrderRoleMvoProxyUtils.ToIdString((c as IMergePatchOrderRoleMvo).OrderRoleId);
            var uriParameters = new OrderRoleMvoUriParameters();
            uriParameters.Id = idObj;

            var req = new OrderRoleMvoPatchRequest(uriParameters, (MergePatchOrderRoleMvoDto)c);
            var resp = await _ramlClient.OrderRoleMvo.Patch(req);
            OrderRoleMvoProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(MergePatchOrderRoleMvoDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }

        public async Task WhenAsync(DeleteOrderRoleMvoDto c)
        {
            var idObj = OrderRoleMvoProxyUtils.ToIdString((c as IDeleteOrderRoleMvo).OrderRoleId);
            var uriParameters = new OrderRoleMvoUriParameters();
            uriParameters.Id = idObj;

            var q = new OrderRoleMvoDeleteQuery();
            q.CommandId = c.CommandId;
            q.RequesterId = c.RequesterId;
            q.Version = Convert.ToString(c.OrderVersion);
                
            var req = new OrderRoleMvoDeleteRequest(uriParameters);
            req.Query = q;

            var resp = await _ramlClient.OrderRoleMvo.Delete(req);
            OrderRoleMvoProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(DeleteOrderRoleMvoDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }
		
        void IOrderRoleMvoApplicationService.When(ICreateOrderRoleMvo c)
        {
            this.When((CreateOrderRoleMvoDto)c);
        }

        void IOrderRoleMvoApplicationService.When(IMergePatchOrderRoleMvo c)
        {
            this.When((MergePatchOrderRoleMvoDto)c);
        }

        void IOrderRoleMvoApplicationService.When(IDeleteOrderRoleMvo c)
        {
            this.When((DeleteOrderRoleMvoDto)c);
        }

        public async Task<IOrderRoleMvoState> GetAsync(OrderRoleId orderRoleId)
        {
            IOrderRoleMvoState state = null;
            var idObj = OrderRoleMvoProxyUtils.ToIdString(orderRoleId);
            var uriParameters = new OrderRoleMvoUriParameters();
            uriParameters.Id = idObj;

            var req = new OrderRoleMvoGetRequest(uriParameters);

            var resp = await _ramlClient.OrderRoleMvo.Get(req);
            OrderRoleMvoProxyUtils.ThrowOnHttpResponseError(resp);
            state = (resp.Content == null) ? null : resp.Content.ToOrderRoleMvoState();
            return state;
        }

        public IOrderRoleMvoState Get(OrderRoleId orderRoleId)
        {
            return GetAsync(orderRoleId).GetAwaiter().GetResult();
        }


        public IEnumerable<IOrderRoleMvoState> GetAll(int firstResult, int maxResults)
        {
            return Get((IDictionary<string, object>)null, null, firstResult, maxResults);
        }

        public IEnumerable<IOrderRoleMvoState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return Get(filter, orders, firstResult, maxResults, null);
        }

        public async Task<IEnumerable<IOrderRoleMvoState>> GetAsync(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            IEnumerable<IOrderRoleMvoState> states = null;
			var q = new OrderRoleMvosGetQuery();
			q.FirstResult = firstResult;
			q.MaxResults = maxResults;
            q.Sort = OrderRoleMvoProxyUtils.GetOrdersQueryValueString(orders);
            q.Fields = OrderRoleMvoProxyUtils.GetReturnedFieldsQueryValueString(fields, QueryFieldValueSeparator);
            q.FilterTag = OrderRoleMvoProxyUtils.GetFilterTagQueryValueString(filter);
            var req = new OrderRoleMvosGetRequest();
            req.Query = q;
            var resp = await _ramlClient.OrderRoleMvos.Get(req);
            OrderRoleMvoProxyUtils.ThrowOnHttpResponseError(resp);
            states = (resp.Content == null) ? null : resp.Content.Select(e => e.ToOrderRoleMvoState());
            return states;
        }

        public IEnumerable<IOrderRoleMvoState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            return GetAsync(filter, orders, firstResult, maxResults, fields).GetAwaiter().GetResult();
        }

        public IEnumerable<IOrderRoleMvoState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return GetByProperty(propertyName, propertyValue, orders, firstResult, maxResults, null);
        }

        public IEnumerable<IOrderRoleMvoState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            var filter = Restrictions.Eq(propertyName, propertyValue);
            return Get(filter, orders, firstResult, maxResults, fields);
        }

        public virtual void Execute(object command)
        {
            ((dynamic)this).When((dynamic)command);
        }

        public IEnumerable<IOrderRoleMvoState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return Get(filter, orders, firstResult, maxResults, null);
        }

        public async Task<IEnumerable<IOrderRoleMvoState>> GetAsync(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            IEnumerable<IOrderRoleMvoState> states = null;
			var q = new OrderRoleMvosGetQuery();
			q.FirstResult = firstResult;
			q.MaxResults = maxResults;
            q.Sort = OrderRoleMvoProxyUtils.GetOrdersQueryValueString(orders);
            q.Fields = OrderRoleMvoProxyUtils.GetReturnedFieldsQueryValueString(fields, QueryFieldValueSeparator);
            q.Filter = OrderRoleMvoProxyUtils.GetFilterQueryValueString(filter);
            var req = new OrderRoleMvosGetRequest();
            req.Query = q;
            var resp = await _ramlClient.OrderRoleMvos.Get(req);
            OrderRoleMvoProxyUtils.ThrowOnHttpResponseError(resp);
            states = (resp.Content == null) ? null : resp.Content.Select(e => e.ToOrderRoleMvoState());
            return states;
        }

        public IEnumerable<IOrderRoleMvoState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            return GetAsync(filter, orders, firstResult, maxResults, fields).GetAwaiter().GetResult();
        }

        public async virtual Task<long> GetCountAsync(IEnumerable<KeyValuePair<string, object>> filter)
		{
			var q = new OrderRoleMvosCountGetQuery();
            q.FilterTag = OrderRoleMvoProxyUtils.GetFilterTagQueryValueString(filter);
            var req = new OrderRoleMvosCountGetRequest();
            req.Query = q;
            var resp = await _ramlClient.OrderRoleMvosCount.Get(req);
            OrderRoleMvoProxyUtils.ThrowOnHttpResponseError(resp);
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
			var q = new OrderRoleMvosCountGetQuery();
            q.Filter = OrderRoleMvoProxyUtils.GetFilterQueryValueString(filter);
            var req = new OrderRoleMvosCountGetRequest();
            req.Query = q;
            var resp = await _ramlClient.OrderRoleMvosCount.Get(req);
            OrderRoleMvoProxyUtils.ThrowOnHttpResponseError(resp);
            string str = await resp.RawContent.ReadAsStringAsync();
            if (str.StartsWith("\"")) { str = str.Substring(1); }
            if (str.EndsWith("\"")) { str = str.Substring(0, str.Length - 1); }
            return long.Parse(str);
		}

        public virtual long GetCount(ICriterion filter)
		{
		    return GetCountAsync(filter).GetAwaiter().GetResult();
		}

        public async Task<IOrderRoleMvoEvent> GetStateEventAsync(OrderRoleId orderRoleId, long version)
        {
            var idObj = OrderRoleMvoProxyUtils.ToIdString(orderRoleId);
            var uriParameters = new OrderRoleMvoStateEventUriParameters();
            uriParameters.Id = idObj;
            uriParameters.Version = version.ToString();

            var req = new OrderRoleMvoStateEventGetRequest(uriParameters);
            var resp = await _ramlClient.OrderRoleMvoStateEvent.Get(req);
            OrderRoleMvoProxyUtils.ThrowOnHttpResponseError(resp);
            return resp.Content;
        }

        public IOrderRoleMvoEvent GetEvent(OrderRoleId orderRoleId, long version)
        {
            return GetStateEventAsync(orderRoleId, version).GetAwaiter().GetResult();
        }


        public async Task<IOrderRoleMvoState> GetHistoryStateAsync(OrderRoleId orderRoleId, long version)
        {
            var idObj = OrderRoleMvoProxyUtils.ToIdString(orderRoleId);
            var uriParameters = new OrderRoleMvoHistoryStateUriParameters();
            uriParameters.Id = idObj;
            uriParameters.Version = version.ToString();

            var req = new OrderRoleMvoHistoryStateGetRequest(uriParameters);
            var resp = await _ramlClient.OrderRoleMvoHistoryState.Get(req);
            OrderRoleMvoProxyUtils.ThrowOnHttpResponseError(resp);
            return (resp.Content == null) ? null : resp.Content.ToOrderRoleMvoState();
        }

        public virtual IOrderRoleMvoState GetHistoryState(OrderRoleId orderRoleId, long version)
        {
            return GetHistoryStateAsync(orderRoleId, version).GetAwaiter().GetResult();
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


    public partial class OrderRoleMvoApplicationServiceProxyFactory : ProxyFactoryBase, IOrderRoleMvoApplicationServiceFactory
    {

        public OrderRoleMvoApplicationServiceProxyFactory() : base()
        {}

        public OrderRoleMvoApplicationServiceProxyFactory(string endpointUrl) : base(endpointUrl)
        {}

        public IOrderRoleMvoApplicationService OrderRoleMvoApplicationService
        {
            get
            {
                return new OrderRoleMvoApplicationServiceProxy(ProxyTemplate);
            }
        }
		
        public ICreateOrderRoleMvo NewCreateOrderRoleMvo()
        {
            return new CreateOrderRoleMvoDto();
        }

        public IMergePatchOrderRoleMvo NewMergePatchOrderRoleMvo()
        {
            return new MergePatchOrderRoleMvoDto();
        }

        public IDeleteOrderRoleMvo NewDeleteOrderRoleMvo()
        {
            return new DeleteOrderRoleMvoDto();
        }
    }

    public static class OrderRoleMvoProxyUtils
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

        public static string ToIdString(OrderRoleId id)
        {
            var formatter = (new ValueObjectTextFormatter<OrderRoleId>());
            var idStr = formatter.ToString(id);
            return idStr;
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

        public static IEnumerable<OrderRoleId> ToIdCollection(IEnumerable<IOrderRoleMvoState> states)
        {
            var ids = new List<OrderRoleId>();
            foreach (var s in states)
            {
                ids.Add(s.OrderRoleId);
            }
            return ids;
        }

    }

}
