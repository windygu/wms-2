using Dddml.Wms.Domain;
using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.StatusItem;
using Dddml.Wms.Specialization;
using Dddml.Wms.Support;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json.Serialization;
using NodaMoney;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Formatting;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;


namespace Dddml.Wms.HttpServices.ClientProxies.Tests
{
    [TestFixture]
    public class StatusItemTests : ClientProxyTestsBase
    {

        private IStatusItemApplicationServiceFactory _statusItemApplicationServiceFactory;

        [SetUp]
        public void SetUp()
        {
            base.SetUp();

            _statusItemApplicationServiceFactory = new StatusItemApplicationServiceProxyFactory();

            //JsonConvert.DefaultSettings = () => new JsonSerializerSettings()
            //{
            //    ContractResolver = new CustomContractResolver()
            //};
        }

        private const string TestStatusItemId = "EXST_TESTED";

        [Test]
        public void TestUpdateStatusItem()
        {
            var appService = _statusItemApplicationServiceFactory.StatusItemApplicationService;
            var statusItem = appService.Get(TestStatusItemId);
            if (statusItem != null)
            {
                var itemDesc = "TESTED" + " " + DateTime.Now.Ticks;

                var endpointUrl = ProxyTemplate.GetEndpointUrl();
                var client = new HttpClient { BaseAddress = new Uri(endpointUrl) };
                //var attrSetInstId = Guid.NewGuid().ToString();

                var url = "StatusItems/{id}";
                url = url.Replace("{id}", TestStatusItemId);

                //var patch = new MergePatchStatusItemDto();
                ////patch.StatusId = TestStatusItemId;
                //patch.Description = itemDesc;
                //patch.Version = statusItem.Version;
                ////PrintAsJObject(patch, "StatusItem, Id: EXST_TESTED");
                //dynamic jObject = JObject.FromObject(patch);

                var version = statusItem.Version;

                var jsonRequstStr = String.Format(
                    "{{\"version\":{0},\"commandId\":\"{1}\",\"description\":\"{2}\"}}",
                    version, Guid.NewGuid().ToString(), itemDesc);
                DoPatch(client, url, jsonRequstStr);

                //// ///////////////////////////
                //jsonRequstStr = String.Format(
                //    "{{\"version\":{0},\"commandId\":\"{1}\",\"description\":null}}",
                //    version, Guid.NewGuid().ToString(), itemDesc);
                //DoPatch(client, url, jsonRequstStr);
                
            }
        }

        private void DoPatch(HttpClient client, string url, string jsonRequstStr)
        {
            System.Console.WriteLine(jsonRequstStr);
            JObject jObject = JObject.Parse(jsonRequstStr);

            var req = new HttpRequestMessage(new HttpMethod("PATCH"), url);

            SetAuthenticationHeader(req);
            var jsonFormatter = GetJsonMediaTypeFormatter();
            req.Content = new ObjectContent(typeof(JObject), jObject, jsonFormatter);
            // //////////////////////////////////////////
            //var requestStr = req.Content.ReadAsStringAsync().GetAwaiter().GetResult();
            //Console.WriteLine(requestStr);
            // //////////////////////////////////////////
            var response = client.SendAsync(req).GetAwaiter().GetResult();

            Console.WriteLine(response.Content);
            Console.WriteLine(response.Headers);
            Console.WriteLine(response.StatusCode);
            Console.WriteLine(response.ReasonPhrase);
        }

        private static JsonMediaTypeFormatter GetJsonMediaTypeFormatter()
        {
            var formatter = new JsonMediaTypeFormatter();
            formatter.SerializerSettings.NullValueHandling = NullValueHandling.Ignore;
            formatter.SerializerSettings.Formatting = Formatting.None;
            formatter.SerializerSettings.DateFormatHandling = DateFormatHandling.IsoDateFormat;
            //formatter.SerializerSettings.Converters.Add(new LongConverter());
            //formatter.SerializerSettings.Converters.Add(new DecimalConverter());
            formatter.SerializerSettings.ContractResolver = new CamelCasePropertyNamesContractResolver();

            return formatter;
        }

        private static void PrintAsJObject(object value, string name)
        {
            JObject jObj = JObject.FromObject(value);
            Console.WriteLine("==================== Object [name = " + name + "] : ====================");
            Console.WriteLine(jObj.ToString());
            Console.WriteLine("==================== End Of Object [name = " + name + "] ====================");
        }

    }
}