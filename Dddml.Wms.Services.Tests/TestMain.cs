using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dddml.Wms.Services.Tests
{
    class TestMain
    {

        public static void DoSomeTests()
        {
            var inventoryPostingRuleTests = new InventoryPostingRuleTests();
            inventoryPostingRuleTests.SetUp();
            inventoryPostingRuleTests.TestCreateInventoryPostingRules();

            //var xmlDataLoader = new XmlDataLoader();
            //xmlDataLoader.Process(".\\");
        }
    }
}
