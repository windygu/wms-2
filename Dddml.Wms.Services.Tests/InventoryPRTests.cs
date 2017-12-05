using Dddml.Wms.Domain;
using Dddml.Wms.Specialization;
using Dddml.Wms.Specialization.Spring;
using Dddml.Wms.Support;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using NodaMoney;
using Dddml.Support.NHibernate;
using Dddml.Wms.Domain.InventoryPostingRule;
using Dddml.Wms.Domain.InventoryItem;

namespace Dddml.Wms.Services.Tests
{
    [TestFixture]
    public class InventoryPostingRuleTests : TestsBase
    {

        IInventoryPostingRuleApplicationService inventoryPostingRuleApplicationService;

        [SetUp]
        public void SetUp()
        {
            base.SetUp();
            
            inventoryPostingRuleApplicationService = ApplicationContext.Current["inventoryPostingRuleApplicationService"] as IInventoryPostingRuleApplicationService;
        }

        [Test]
        public void TestCreateInventoryPostingRule()
        {
            var t = new InventoryItemId("*", "*", "*");
            var o = new InventoryItemId("_", "*", "*");

            CreateInventoryPostingRule inventoryPostingRule_1 = new CreateInventoryPostingRule();
            inventoryPostingRule_1.InventoryPostingRuleId = "OH->PrdSellableTotal";
            inventoryPostingRule_1.Trigger = t;
            inventoryPostingRule_1.Output = o;
            inventoryPostingRule_1.AccountName = "QuantityOnHand";
            inventoryPostingRule_1.IsOutputNegated = false;
            inventoryPostingRule_1.Active = true;
            inventoryPostingRule_1.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_1);

            CreateInventoryPostingRule inventoryPostingRule_2 = new CreateInventoryPostingRule();
            inventoryPostingRule_2.InventoryPostingRuleId = "Oc->PrdSellableTotal";
            inventoryPostingRule_2.Trigger = t;
            inventoryPostingRule_2.Output = o;
            inventoryPostingRule_2.AccountName = "QuantityOccupied";
            inventoryPostingRule_2.IsOutputNegated = true;
            inventoryPostingRule_2.Active = true;
            inventoryPostingRule_2.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_2);

            CreateInventoryPostingRule inventoryPostingRule_3 = new CreateInventoryPostingRule();
            inventoryPostingRule_3.InventoryPostingRuleId = "R->PrdSellableTotal";
            inventoryPostingRule_3.Trigger = t;
            inventoryPostingRule_3.Output = o;
            inventoryPostingRule_3.AccountName = "QuantityReserved";
            inventoryPostingRule_3.IsOutputNegated = true;
            inventoryPostingRule_3.Active = true;
            inventoryPostingRule_3.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_3);

            CreateInventoryPostingRule inventoryPostingRule_4 = new CreateInventoryPostingRule();
            inventoryPostingRule_4.InventoryPostingRuleId = "V->PrdSellableTotal";
            inventoryPostingRule_4.Trigger = t;
            inventoryPostingRule_4.Output = o;
            inventoryPostingRule_4.AccountName = "QuantityVirtual";
            inventoryPostingRule_4.IsOutputNegated = false;
            inventoryPostingRule_4.Active = true;
            inventoryPostingRule_4.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_4);
        }


    }


}
