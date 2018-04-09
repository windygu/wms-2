using Dddml.Wms.Domain;
using Dddml.Wms.Support;
using Newtonsoft.Json.Linq;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Formatting;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using NodaMoney;
using Newtonsoft.Json.Serialization;
using Newtonsoft.Json;
using Dddml.Wms.Specialization;
using Dddml.Wms.Domain.InOut;

namespace Dddml.Wms.HttpServices.ClientProxies.Tests
{

    [TestFixture]
    public class InOutServiceTests : ClientProxyTestsBase
    {

        private IInOutApplicationServiceFactory _inOutApplicationServiceFactory;

        [SetUp]
        public void SetUp()
        {
            base.SetUp();

            _inOutApplicationServiceFactory = new InOutApplicationServiceProxyFactory();

            //JsonConvert.DefaultSettings = () => new JsonSerializerSettings()
            //{
            //    ContractResolver = new CustomContractResolver()
            //};
        }

        //private class CustomContractResolver : DefaultContractResolver
        //{
        //    private static readonly Type _moneyType = typeof(NodaMoney.Money);

        //    private static readonly JsonConverter _moneyJsonConverter = new NodaMoney.Serialization.JsonNet.MoneyJsonConverter();

        //    protected override JsonConverter ResolveContractConverter(Type objectType)
        //    {
        //        if (objectType != null && _moneyType.IsAssignableFrom(objectType))
        //        {
        //            return _moneyJsonConverter;
        //        }
        //        return base.ResolveContractConverter(objectType);
        //    }
        //}

        [Test]
        public void TestPostCreateAndPutPatchInOut()
        {
            var documentNumber = Guid.NewGuid().ToString();
            //var inOutApplicationService = _inOutApplicationServiceFactory.InOutApplicationService;

            var createInOut = new CreateOrMergePatchOrDeleteInOutDto();
            createInOut.DocumentNumber = documentNumber;
            createInOut.CommandId = Guid.NewGuid().ToString();

            var endpointUrl = ProxyTemplate.GetEndpointUrl();
            var client = new HttpClient { BaseAddress = new Uri(endpointUrl) };
            //var attrSetInstId = Guid.NewGuid().ToString();

            var postUrl = "InOuts";

            var postReq = new HttpRequestMessage(HttpMethod.Post, postUrl);
            SetAuthenticationHeader(postReq);
            postReq.Content = new ObjectContent<CreateOrMergePatchOrDeleteInOutDto>(createInOut, new JsonMediaTypeFormatter());
            var postRsp = client.SendAsync(postReq).GetAwaiter().GetResult();

            Console.WriteLine(postRsp.Content);
            Console.WriteLine(postRsp.Headers);
            Console.WriteLine(postRsp.StatusCode);
            Console.WriteLine(postRsp.ReasonPhrase);

            var inOutId = createInOut.DocumentNumber;
            var url = "InOuts/{id}";
            url = url.Replace("{id}", inOutId);
            var updateInOut = new CreateOrMergePatchOrDeleteInOutDto();
            updateInOut.Version = 1;
            updateInOut.InOutLines = new CreateOrMergePatchOrRemoveInOutLineDto[] {
                new CreateOrMergePatchOrRemoveInOutLineDto() {
                    LineNumber = "1",
                    ProductId = Guid.NewGuid().ToString(),
                    LocatorId = "1-Test-1-1",
                    MovementQuantity = 1,
                    AttributeSetInstanceId = "EMPTY"
                }
            };

            var req = new HttpRequestMessage(HttpMethod.Put, url);
            SetAuthenticationHeader(req);
            req.Content = new ObjectContent<CreateOrMergePatchOrDeleteInOutDto>(updateInOut, new JsonMediaTypeFormatter());
            var response = client.SendAsync(req).GetAwaiter().GetResult();

            Console.WriteLine(response.Content);
            Console.WriteLine(response.Headers);
            Console.WriteLine(response.StatusCode);
            Console.WriteLine(response.ReasonPhrase);

        }

        [Test]
        public void TestCreateAndVoidInOut()
        {
            var documentNumber = Guid.NewGuid().ToString();
            var inOutApplicationService = _inOutApplicationServiceFactory.InOutApplicationService;

            var inOut = _inOutApplicationServiceFactory.NewCreateInOut();
            inOut.DocumentNumber = documentNumber;
            inOut.CommandId = Guid.NewGuid().ToString();
            //inOut.DocumentAction = DocumentAction.Draft;// 不能这样写：inOut.DocumentStatus = DocumentStatus.Drafted
            //inOut.ChargeAmount = new Money(10000, "CNY");
            //inOut.FreightAmount = new Money(400, "CNY");
            inOutApplicationService.When(inOut);

            PrintAsJObject(inOut, "InOut");

            //var patchInOut =  _inOutApplicationServiceFactory.NewMergePatchInOut();
            //patchInOut.DocumentNumber = documentNumber;
            ////patchInOut.DocumentAction = DocumentAction.Void;//不能这样写：patchInOut.DocumentStatus = DocumentStatus.Voided
            //patchInOut.Version = 1;
            //patchInOut.CommandId = Guid.NewGuid().ToString();

            //inOutApplicationService.When(patchInOut);

            //var inOutResult = inOutApplicationService.Get(inOut.DocumentNumber);
            ////Console.WriteLine(inOutResult.DocumentNumber);
            //Assert.AreEqual(DocumentStatusIds.Voided, inOutResult.DocumentStatusId);
            ////Console.WriteLine(inOutResult.FreightAmount);
            ////Assert.AreEqual(inOut.FreightAmount, inOutResult.FreightAmount);
            ////Console.WriteLine(inOutResult.ChargeAmount);
            ////Assert.AreEqual(inOut.ChargeAmount, inOutResult.ChargeAmount);

            ////var deleteInOut = _inOutApplicationServiceFactory.NewDeleteInOut();
            ////deleteInOut.DocumentNumber = documentNumber;
            ////deleteInOut.Version = 2;
            ////deleteInOut.CommandId = Guid.NewGuid().ToString();
            ////inOutApplicationService.When(deleteInOut);

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
