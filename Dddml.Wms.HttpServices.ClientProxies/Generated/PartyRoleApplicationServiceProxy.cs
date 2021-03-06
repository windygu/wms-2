﻿// <autogenerated>
//   This file was generated by T4 code generator GenerateRamlClientProxies.tt.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

using System;
using System.Collections.Generic;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain;
using Dddml.Wms.Domain.PartyRole;
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

    public partial class PartyRoleApplicationServiceProxy : IPartyRoleApplicationService
    {

        private DddmlWmsRamlClient _ramlClient;

        public PartyRoleApplicationServiceProxy(ProxyTemplate proxyTemplate)
            : this(proxyTemplate.GetEndpointUrl())
        {
            _ramlClient.GetAuthenticationHeaderValue = proxyTemplate.GetAuthenticationHeaderValue;
        }

        public PartyRoleApplicationServiceProxy(string endpointUrl)
        {
            _ramlClient = new DddmlWmsRamlClient(endpointUrl);
        }

        public PartyRoleApplicationServiceProxy(HttpClient httpClient)
        {
            _ramlClient = new DddmlWmsRamlClient(httpClient);
        }

        public async Task WhenAsync(CreatePartyRoleDto c)
        {
            var idObj = PartyRoleProxyUtils.ToIdString((c as ICreatePartyRole).PartyRoleId);
            var uriParameters = new PartyRoleUriParameters();
            uriParameters.Id = idObj;

            var req = new PartyRolePutRequest(uriParameters, (CreatePartyRoleDto)c);
                
            var resp = await _ramlClient.PartyRole.Put(req);
            PartyRoleProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(CreatePartyRoleDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }

        public async Task WhenAsync(MergePatchPartyRoleDto c)
        {
            var idObj = PartyRoleProxyUtils.ToIdString((c as IMergePatchPartyRole).PartyRoleId);
            var uriParameters = new PartyRoleUriParameters();
            uriParameters.Id = idObj;

            var req = new PartyRolePatchRequest(uriParameters, (MergePatchPartyRoleDto)c);
            var resp = await _ramlClient.PartyRole.Patch(req);
            PartyRoleProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(MergePatchPartyRoleDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }

        public async Task WhenAsync(DeletePartyRoleDto c)
        {
            var idObj = PartyRoleProxyUtils.ToIdString((c as IDeletePartyRole).PartyRoleId);
            var uriParameters = new PartyRoleUriParameters();
            uriParameters.Id = idObj;

            var q = new PartyRoleDeleteQuery();
            q.CommandId = c.CommandId;
            q.RequesterId = c.RequesterId;
            q.Version = Convert.ToString(c.Version);
                
            var req = new PartyRoleDeleteRequest(uriParameters);
            req.Query = q;

            var resp = await _ramlClient.PartyRole.Delete(req);
            PartyRoleProxyUtils.ThrowOnHttpResponseError(resp);
        }

        public void When(DeletePartyRoleDto c)
        {
            WhenAsync(c).GetAwaiter().GetResult();
        }
		
        void IPartyRoleApplicationService.When(ICreatePartyRole c)
        {
            this.When((CreatePartyRoleDto)c);
        }

        void IPartyRoleApplicationService.When(IMergePatchPartyRole c)
        {
            this.When((MergePatchPartyRoleDto)c);
        }

        void IPartyRoleApplicationService.When(IDeletePartyRole c)
        {
            this.When((DeletePartyRoleDto)c);
        }

        public async Task<IPartyRoleState> GetAsync(PartyRoleId partyRoleId)
        {
            IPartyRoleState state = null;
            var idObj = PartyRoleProxyUtils.ToIdString(partyRoleId);
            var uriParameters = new PartyRoleUriParameters();
            uriParameters.Id = idObj;

            var req = new PartyRoleGetRequest(uriParameters);

            var resp = await _ramlClient.PartyRole.Get(req);
            PartyRoleProxyUtils.ThrowOnHttpResponseError(resp);
            state = (resp.Content == null) ? null : resp.Content.ToPartyRoleState();
            return state;
        }

        public IPartyRoleState Get(PartyRoleId partyRoleId)
        {
            return GetAsync(partyRoleId).GetAwaiter().GetResult();
        }


        public IEnumerable<IPartyRoleState> GetAll(int firstResult, int maxResults)
        {
            return Get((IDictionary<string, object>)null, null, firstResult, maxResults);
        }

        public IEnumerable<IPartyRoleState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return Get(filter, orders, firstResult, maxResults, null);
        }

        public async Task<IEnumerable<IPartyRoleState>> GetAsync(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            IEnumerable<IPartyRoleState> states = null;
			var q = new PartyRolesGetQuery();
			q.FirstResult = firstResult;
			q.MaxResults = maxResults;
            q.Sort = PartyRoleProxyUtils.GetOrdersQueryValueString(orders);
            q.Fields = PartyRoleProxyUtils.GetReturnedFieldsQueryValueString(fields, QueryFieldValueSeparator);
            q.FilterTag = PartyRoleProxyUtils.GetFilterTagQueryValueString(filter);
            var req = new PartyRolesGetRequest();
            req.Query = q;
            var resp = await _ramlClient.PartyRoles.Get(req);
            PartyRoleProxyUtils.ThrowOnHttpResponseError(resp);
            states = (resp.Content == null) ? null : resp.Content.Select(e => e.ToPartyRoleState());
            return states;
        }

        public IEnumerable<IPartyRoleState> Get(IEnumerable<KeyValuePair<string, object>> filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            return GetAsync(filter, orders, firstResult, maxResults, fields).GetAwaiter().GetResult();
        }

        public IEnumerable<IPartyRoleState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return GetByProperty(propertyName, propertyValue, orders, firstResult, maxResults, null);
        }

        public IEnumerable<IPartyRoleState> GetByProperty(string propertyName, object propertyValue, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            var filter = Restrictions.Eq(propertyName, propertyValue);
            return Get(filter, orders, firstResult, maxResults, fields);
        }

        public virtual void Execute(object command)
        {
            ((dynamic)this).When((dynamic)command);
        }

        public IEnumerable<IPartyRoleState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue)
        {
            return Get(filter, orders, firstResult, maxResults, null);
        }

        public async Task<IEnumerable<IPartyRoleState>> GetAsync(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            IEnumerable<IPartyRoleState> states = null;
			var q = new PartyRolesGetQuery();
			q.FirstResult = firstResult;
			q.MaxResults = maxResults;
            q.Sort = PartyRoleProxyUtils.GetOrdersQueryValueString(orders);
            q.Fields = PartyRoleProxyUtils.GetReturnedFieldsQueryValueString(fields, QueryFieldValueSeparator);
            q.Filter = PartyRoleProxyUtils.GetFilterQueryValueString(filter);
            var req = new PartyRolesGetRequest();
            req.Query = q;
            var resp = await _ramlClient.PartyRoles.Get(req);
            PartyRoleProxyUtils.ThrowOnHttpResponseError(resp);
            states = (resp.Content == null) ? null : resp.Content.Select(e => e.ToPartyRoleState());
            return states;
        }

        public IEnumerable<IPartyRoleState> Get(ICriterion filter, IList<string> orders = null, int firstResult = 0, int maxResults = int.MaxValue, IList<string> fields = null)
        {
            return GetAsync(filter, orders, firstResult, maxResults, fields).GetAwaiter().GetResult();
        }

        public async virtual Task<long> GetCountAsync(IEnumerable<KeyValuePair<string, object>> filter)
		{
			var q = new PartyRolesCountGetQuery();
            q.FilterTag = PartyRoleProxyUtils.GetFilterTagQueryValueString(filter);
            var req = new PartyRolesCountGetRequest();
            req.Query = q;
            var resp = await _ramlClient.PartyRolesCount.Get(req);
            PartyRoleProxyUtils.ThrowOnHttpResponseError(resp);
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
			var q = new PartyRolesCountGetQuery();
            q.Filter = PartyRoleProxyUtils.GetFilterQueryValueString(filter);
            var req = new PartyRolesCountGetRequest();
            req.Query = q;
            var resp = await _ramlClient.PartyRolesCount.Get(req);
            PartyRoleProxyUtils.ThrowOnHttpResponseError(resp);
            string str = await resp.RawContent.ReadAsStringAsync();
            if (str.StartsWith("\"")) { str = str.Substring(1); }
            if (str.EndsWith("\"")) { str = str.Substring(0, str.Length - 1); }
            return long.Parse(str);
		}

        public virtual long GetCount(ICriterion filter)
		{
		    return GetCountAsync(filter).GetAwaiter().GetResult();
		}

        public async Task<IPartyRoleEvent> GetStateEventAsync(PartyRoleId partyRoleId, long version)
        {
            var idObj = PartyRoleProxyUtils.ToIdString(partyRoleId);
            var uriParameters = new PartyRoleStateEventUriParameters();
            uriParameters.Id = idObj;
            uriParameters.Version = version.ToString();

            var req = new PartyRoleStateEventGetRequest(uriParameters);
            var resp = await _ramlClient.PartyRoleStateEvent.Get(req);
            PartyRoleProxyUtils.ThrowOnHttpResponseError(resp);
            return resp.Content;
        }

        public IPartyRoleEvent GetEvent(PartyRoleId partyRoleId, long version)
        {
            return GetStateEventAsync(partyRoleId, version).GetAwaiter().GetResult();
        }


        public async Task<IPartyRoleState> GetHistoryStateAsync(PartyRoleId partyRoleId, long version)
        {
            var idObj = PartyRoleProxyUtils.ToIdString(partyRoleId);
            var uriParameters = new PartyRoleHistoryStateUriParameters();
            uriParameters.Id = idObj;
            uriParameters.Version = version.ToString();

            var req = new PartyRoleHistoryStateGetRequest(uriParameters);
            var resp = await _ramlClient.PartyRoleHistoryState.Get(req);
            PartyRoleProxyUtils.ThrowOnHttpResponseError(resp);
            return (resp.Content == null) ? null : resp.Content.ToPartyRoleState();
        }

        public virtual IPartyRoleState GetHistoryState(PartyRoleId partyRoleId, long version)
        {
            return GetHistoryStateAsync(partyRoleId, version).GetAwaiter().GetResult();
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


    public partial class PartyRoleApplicationServiceProxyFactory : ProxyFactoryBase, IPartyRoleApplicationServiceFactory
    {

        public PartyRoleApplicationServiceProxyFactory() : base()
        {}

        public PartyRoleApplicationServiceProxyFactory(string endpointUrl) : base(endpointUrl)
        {}

        public IPartyRoleApplicationService PartyRoleApplicationService
        {
            get
            {
                return new PartyRoleApplicationServiceProxy(ProxyTemplate);
            }
        }
		
        public ICreatePartyRole NewCreatePartyRole()
        {
            return new CreatePartyRoleDto();
        }

        public IMergePatchPartyRole NewMergePatchPartyRole()
        {
            return new MergePatchPartyRoleDto();
        }

        public IDeletePartyRole NewDeletePartyRole()
        {
            return new DeletePartyRoleDto();
        }
    }

    public static class PartyRoleProxyUtils
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

        public static string ToIdString(PartyRoleId id)
        {
            var formatter = (new ValueObjectTextFormatter<PartyRoleId>());
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

        public static IEnumerable<PartyRoleId> ToIdCollection(IEnumerable<IPartyRoleState> states)
        {
            var ids = new List<PartyRoleId>();
            foreach (var s in states)
            {
                ids.Add(s.PartyRoleId);
            }
            return ids;
        }

    }

}

