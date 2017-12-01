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
using Dddml.Wms.Domain.InventoryItem;


namespace Dddml.Wms.HttpServices.ClientProxies.Tests
{
    [TestFixture]
    public class InventoryItemServiceTests : ClientProxyTestsBase
    {

        private IInventoryItemApplicationServiceFactory _inventoryItemApplicationServiceFactory;

        [SetUp]
        public void SetUp()
        {
            base.SetUp();

            _inventoryItemApplicationServiceFactory = new InventoryItemApplicationServiceProxyFactory();

            //JsonConvert.DefaultSettings = () => new JsonSerializerSettings()
            //{
            //    ContractResolver = new CustomContractResolver()
            //};
        }

        [Test]
        public void TestCreateInventoryItem()
        {
            var service = _inventoryItemApplicationServiceFactory.InventoryItemApplicationService;

            var ii = _inventoryItemApplicationServiceFactory.NewCreateInventoryItem();
            var iiId = new InventoryItemId("TEST_PRD_1", "TEST_LOC_1", Guid.NewGuid().ToString());
            ii.InventoryItemId = iiId;

            var iiEntry = ii.NewCreateInventoryItemEntry();
            iiEntry.EntrySeqId = DateTime.Now.Ticks;
            iiEntry.QuantityOnHand = 100;
            var iiEntrySrc = new InventoryItemSourceVO("TEST_EVT_TYPE", "TEST_DOCUMENT_NO_1", Guid.NewGuid().ToString());
            iiEntry.Source = iiEntrySrc;

            ii.Entries.Add(iiEntry);
            ii.CommandId = Guid.NewGuid().ToString();

            service.When(ii);
        }
    }

}
