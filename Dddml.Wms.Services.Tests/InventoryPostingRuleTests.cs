using Dddml.Wms.Domain.InventoryItem;
using Dddml.Wms.Domain.InventoryPostingRule;
using Dddml.Wms.Specialization;
using NUnit.Framework;
using System;

namespace Dddml.Wms.Services.Tests
{
    [TestFixture]
    public class InventoryPostingRuleTests : TestsBase
    {
        [SetUp]
        public void SetUp()
        {
            base.SetUp();
        }

        [Test]
        public void TestCreateInventoryPostingRules()
        {
            try
            {
                InitInventoryPostingRules.CreateDefaultInventoryPostingRules();
            }
            catch (Exception ex)
            {
                // [rebirth] Can't create aggregate that already exists
                Console.WriteLine(ex);
            }
        }
    }


}
