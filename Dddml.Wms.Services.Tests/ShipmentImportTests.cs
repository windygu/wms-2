using Dddml.Wms.Domain.Product;
using Dddml.Wms.Domain.Shipment;
using Dddml.Wms.Specialization;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dddml.Wms.Services.Tests
{
    public class ShipmentImportTests : TestsBase
    {
        IShipmentApplicationService shipmentApplicationService;

        IProductApplicationService productApplicationService;

        [SetUp]
        public void SetUp()
        {
            base.SetUp();

            shipmentApplicationService = ApplicationContext.Current["shipmentApplicationService"] as IShipmentApplicationService;

            productApplicationService = ApplicationContext.Current["productApplicationService"] as IProductApplicationService;
        }

        [Test]
        public void TestImport_1()
        {
            // ///////////////////////////////////////
            // Create a product for test.
            var prd_1 = new CreateProduct();
            prd_1.ProductId = DateTime.Now.Ticks.ToString();//Guid.NewGuid().ToString();
            prd_1.ProductName = "Test_" + prd_1.ProductId;
            prd_1.AttributeSetId = typeof(InitAttributeSets.FluffPulpAttrSetInstance).Name;
            prd_1.IsSerialNumbered = true;
            //prd_1.QuantityUomId;
            prd_1.CommandId = Guid.NewGuid().ToString();

            productApplicationService.When(prd_1);
            

            // ///////////////////////////////////////
            var shipImport = new ShipmentCommands.Import();
            shipImport.ShipmentId = DateTime.Now.Ticks.ToString();

            var prdId = prd_1.ProductId;

            var rollId_1 = "H71051402A";
            var shipItem_1 = NewImportingShipmentItem(prdId, rollId_1);

            var rollId_2 = "H00000000A";
            var shipItem_2 = NewImportingShipmentItem(prdId, rollId_2);

            shipImport.ShipmentItems = new HashSet<ImportingShipmentItem>(new ImportingShipmentItem[] {
                    shipItem_1,
                    shipItem_2,
                });

            shipmentApplicationService.When(shipImport);
        }

        private static ImportingShipmentItem NewImportingShipmentItem(string productId, string rollId)
        {
            var shipItem_1 = new ImportingShipmentItem();
            shipItem_1.ProductId = productId;
            var attrSetInst_1 = new Dictionary<string, object>();

            // //////////////////////////////////
            attrSetInst_1.Add("SerialNumber", rollId);
            attrSetInst_1.Add("WidthInch", (decimal)17.75);
            attrSetInst_1.Add("DiameterInch", 48.00);
            attrSetInst_1.Add("WeightLbs", (decimal)1678);
            attrSetInst_1.Add("WeightKg", (decimal)761.125);
            attrSetInst_1.Add("AirDryWeightLbs", (decimal)1705.682);
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
