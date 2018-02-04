using Dddml.Wms.Domain.AttributeSetInstance;
using Dddml.Wms.Domain.Product;
using Dddml.Wms.Domain.Shipment;
using Dddml.Wms.Domain.ShipmentType;
using Dddml.Wms.Domain.StatusItem;
using Dddml.Wms.Specialization;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dddml.Wms.Services.Tests
{
    public class ShipmentTests : TestsBase
    {
        IShipmentApplicationService shipmentApplicationService;

        IProductApplicationService productApplicationService;

        IAttributeSetInstanceApplicationService attributeSetInstanceApplicationService;

        [SetUp]
        public void SetUp()
        {
            base.SetUp();

            shipmentApplicationService = ApplicationContext.Current["shipmentApplicationService"] as IShipmentApplicationService;

            productApplicationService = ApplicationContext.Current["productApplicationService"] as IProductApplicationService;

            attributeSetInstanceApplicationService = ApplicationContext.Current["attributeSetInstanceApplicationService"] as IAttributeSetInstanceApplicationService;
        }

        [Test]
        public void TestImportAndReceive()
        {
            // ///////////////////////////////////////
            // Create a product for test.
            var prd_1 = CreateProduct_1();

            // ///////////////////////////////////////
            // Create a shipment.
            var shipmentId = CreateShipment_1(prd_1);

            UpdateShipmentToPurchShipShipped(shipmentId);

            ReceiveAllItems(shipmentId);

            UpdateShipmentToPurchShipReceived(shipmentId);
        }

        private void ReceiveAllItems(string shipmentId)
        {
            var shipmentState = shipmentApplicationService.Get(shipmentId);
            var version = shipmentState.Version;
            foreach (var item in shipmentState.ShipmentItems)
            {
                var receiveItem = new ShipmentCommands.ReceiveItem();
                receiveItem.ShipmentId = shipmentId;
                receiveItem.ShipmentItemSeqId = item.ShipmentItemSeqId;
                receiveItem.AcceptedQuantity = item.Quantity;
                receiveItem.RejectedQuantity = 0;
                receiveItem.DamagedQuantity = 0;

                if (!String.IsNullOrWhiteSpace(item.AttributeSetInstanceId))
                {
                    var srcAttrSetInst = attributeSetInstanceApplicationService.Get(item.AttributeSetInstanceId);
                    var rollId = srcAttrSetInst.SerialNumber;

                    var attrSetInst_1 = new Dictionary<string, object>();
                    // //////////////////////////////////
                    attrSetInst_1.Add("SerialNumber", rollId);
                    //attrSetInst_1.Add("WidthInch", (decimal)17.75);
                    //attrSetInst_1.Add("DiameterInch", 48.00);
                    //attrSetInst_1.Add("WeightLbs", (decimal)1678);
                    attrSetInst_1.Add("WeightKg", (TestWeightKg - (decimal)0.001));
                    //attrSetInst_1.Add("AirDryWeightLbs", (decimal)1705.682);
                    //attrSetInst_1.Add("AirDryWeightKg", (decimal)773.684);
                    //attrSetInst_1.Add("AirDryMetricTon", (decimal)0.774);
                    //attrSetInst_1.Add("PackageCount", 2);
                    //attrSetInst_1.Add("AirDryPct", (decimal)101.650);
                    // //////////////////////////////////
                    receiveItem.AttributeSetInstance = attrSetInst_1;
                }

                receiveItem.CommandId = Guid.NewGuid().ToString();
                receiveItem.Version = version;
                shipmentApplicationService.When(receiveItem);

                version++;
            }
        }

        static decimal TestWeightKg
        {
            get { return (decimal)761.125; }
        }

        private void UpdateShipmentToPurchShipShipped(string shipmentId)
        {
            //var updateShipment = new MergePatchShipment();
            var updateShipment = new ShipmentCommands.Ship();
            updateShipment.ShipmentId = shipmentId;
            updateShipment.CommandId = Guid.NewGuid().ToString();
            //updateShipment.StatusId = StatusItemIds.PurchShipShipped;
            updateShipment.Version = 1;
            shipmentApplicationService.When(updateShipment);
        }

        private void UpdateShipmentToPurchShipReceived(string shipmentId)
        {
            //var updateShipment = new MergePatchShipment();
            var updateShipment = new ShipmentCommands.ConfirmAllItemsReceived();
            updateShipment.ShipmentId = shipmentId;
            updateShipment.CommandId = Guid.NewGuid().ToString();
            //updateShipment.StatusId = StatusItemIds.PurchShipShipped;
            updateShipment.Version = 4; //todo???
            shipmentApplicationService.When(updateShipment);
        }

        private string CreateShipment_1(CreateProduct prd_1)
        {
            var shipmentId = DateTime.Now.Ticks.ToString();
            var shipImport = new ShipmentCommands.Import();
            shipImport.ShipmentId = shipmentId;

            var prdId = prd_1.ProductId;

            var rollId_1 = "H71051402A";
            var shipItem_1 = NewImportingShipmentItem(prdId, rollId_1);

            var rollId_2 = "H00000000A";
            var shipItem_2 = NewImportingShipmentItem(prdId, rollId_2);

            shipImport.ShipmentItems = new HashSet<ImportingShipmentItem>(new ImportingShipmentItem[] {
                    shipItem_1,
                    shipItem_2,
                });

            shipImport.ShipmentTypeId = ShipmentTypeIds.IncomingShipment;
            shipImport.DestinationFacilityId = "TEST_1";

            shipmentApplicationService.When(shipImport);
            return shipmentId;
        }

        private CreateProduct CreateProduct_1()
        {
            var prd_1 = new CreateProduct();
            prd_1.ProductId = DateTime.Now.Ticks.ToString();//Guid.NewGuid().ToString();
            prd_1.ProductName = "Test_" + prd_1.ProductId;
            prd_1.AttributeSetId = typeof(InitAttributeSets.FluffPulpAttrSetInstance).Name;
            prd_1.IsSerialNumbered = true;
            //prd_1.QuantityUomId;
            prd_1.CommandId = Guid.NewGuid().ToString();

            productApplicationService.When(prd_1);
            return prd_1;
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
            attrSetInst_1.Add("WeightLbs", (decimal)1678);
            attrSetInst_1.Add("WeightKg", TestWeightKg);
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
