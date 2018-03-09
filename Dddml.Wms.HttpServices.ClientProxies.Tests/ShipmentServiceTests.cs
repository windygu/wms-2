using Dddml.Wms.Domain.Product;
using Dddml.Wms.Domain.Shipment;
using Dddml.Wms.Domain.ShipmentType;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Formatting;
using System.Text;
using System.Threading.Tasks;

namespace Dddml.Wms.HttpServices.ClientProxies.Tests
{
    [TestFixture]
    public class ShipmentServiceTests : ClientProxyTestsBase
    {

        private IShipmentApplicationServiceFactory _shipmentApplicationServiceFactory;

        private IProductApplicationServiceFactory _productApplicationServiceFactory;

        [SetUp]
        public void SetUp()
        {
            base.SetUp();

            _shipmentApplicationServiceFactory = new ShipmentApplicationServiceProxyFactory();
            _productApplicationServiceFactory = new ProductApplicationServiceProxyFactory();
            //JsonConvert.DefaultSettings = () => new JsonSerializerSettings()
            //{
            //    ContractResolver = new CustomContractResolver()
            //};
        }

        [Test]
        public void TestCreateShipment_1()
        {
            var prd_1 = CreateProduct_1();
            CreateShipment_1(prd_1);
        }

        private CreateProductDto CreateProduct_1()
        {
            var prd_1 = new CreateProductDto();
            prd_1.ProductId = DateTime.Now.Ticks.ToString();//Guid.NewGuid().ToString();
            prd_1.ProductName = "Test_" + prd_1.ProductId;
            prd_1.AttributeSetId = "FluffPulpAttrSetInstance";
            prd_1.IsSerialNumbered = true;
            //prd_1.QuantityUomId;
            prd_1.CommandId = Guid.NewGuid().ToString();

            _productApplicationServiceFactory.ProductApplicationService.When((ICreateProduct)prd_1);
            return prd_1;
        }

        private string CreateShipment_1(CreateProductDto prd_1)
        {
            var shipmentId = DateTime.Now.Ticks.ToString();
            var shipImport = new ShipmentCommandDtos.ImportRequestContent();
            shipImport.ShipmentId = shipmentId;

            var prdId = prd_1.ProductId;

            var rollId_1 = "H71051402A";
            var shipItem_1 = NewImportingShipmentItem(prdId, rollId_1);

            var rollId_2 = "H00000000A";
            var shipItem_2 = NewImportingShipmentItem(prdId, rollId_2);

            shipImport.ShipmentItems = new ImportingShipmentItem[] {
                    shipItem_1,
                    shipItem_2,
                };

            shipImport.ShipmentTypeId = ShipmentTypeIds.IncomingShipment;
            shipImport.DestinationFacilityId = "TEST_1";

            // ////////////////////////////////
            //_shipmentApplicationServiceFactory.ShipmentApplicationService.When(shipImport.ToImport());

            var endpointUrl = ProxyTemplate.GetEndpointUrl();
            var client = new HttpClient { BaseAddress = new Uri(endpointUrl) };
            //var attrSetInstId = Guid.NewGuid().ToString();

            var url = "Shipments/{id}/_commands/Import";
            url = url.Replace("{id}", shipmentId);

            var req = new  HttpRequestMessage(HttpMethod.Put, url);
            SetAuthenticationHeader(req);
            req.Content = new ObjectContent<ShipmentCommandDtos.ImportRequestContent>(shipImport, new JsonMediaTypeFormatter());
            var response = client.SendAsync(req).GetAwaiter().GetResult();

            Console.WriteLine(response.Content);
            Console.WriteLine(response.Headers);
            Console.WriteLine(response.StatusCode);
            Console.WriteLine(response.ReasonPhrase);

            // ////////////////////////////////

            return shipmentId;
        }

        static decimal TestWeightKg
        {
            get { return (decimal)761.125; }
        }

        private static ImportingShipmentItem NewImportingShipmentItem(string productId, string rollId)
        {
            var shipItem_1 = new ImportingShipmentItem();
            shipItem_1.ProductId = productId;
            shipItem_1.Quantity = 1;
            var attrSetInst_1 = new Dictionary<string, object>();

            // //////////////////////////////////
            attrSetInst_1.Add("SerialNumber", rollId);
            attrSetInst_1.Add("WidthInch", (decimal)17.75);
            attrSetInst_1.Add("DiameterInch", 48.00);
            //attrSetInst_1.Add("WeightLbs", (decimal)1678);
            attrSetInst_1.Add("WeightKg", TestWeightKg);
            //attrSetInst_1.Add("AirDryWeightLbs", (decimal)1705.682);
            attrSetInst_1.Add("AirDryWeightKg", (decimal)773.684);
            attrSetInst_1.Add("AirDryMetricTon", (decimal)0.774);
            attrSetInst_1.Add("PackageCount", 2);
            attrSetInst_1.Add("AirDryPct", (decimal)101.650);
            // //////////////////////////////////

            shipItem_1.AttributeSetInstance = attrSetInst_1;
            return shipItem_1;
        }
    }
}
