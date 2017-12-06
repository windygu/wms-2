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
        public void TestCreateInventoryPostingRules()
        {
            var triggerItemId = new InventoryItemId(InventoryItemIds.Wildcard, InventoryItemIds.Wildcard, InventoryItemIds.Wildcard);
            var outputItemId = new InventoryItemId(InventoryItemIds.SameAsSource, InventoryItemIds.Empty, InventoryItemIds.Empty);

            CreateInventoryPostingRule inventoryPostingRule_1 = new CreateInventoryPostingRule();
            inventoryPostingRule_1.InventoryPostingRuleId = InventoryPostingRuleIds.QuantityOnHandUpdateProductSellableTotal;
            inventoryPostingRule_1.TriggerInventoryItemId = triggerItemId;
            inventoryPostingRule_1.OutputInventoryItemId = outputItemId;
            inventoryPostingRule_1.TriggerAccountName = "QuantityOnHand";
            inventoryPostingRule_1.OutputAccountName = "QuantitySellable";
            inventoryPostingRule_1.IsOutputNegated = false;
            inventoryPostingRule_1.Active = true;
            inventoryPostingRule_1.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_1);

            CreateInventoryPostingRule inventoryPostingRule_2 = new CreateInventoryPostingRule();
            inventoryPostingRule_2.InventoryPostingRuleId = InventoryPostingRuleIds.QuantityOccupiedUpdateProductSellableTotal;
            inventoryPostingRule_2.TriggerInventoryItemId = triggerItemId;
            inventoryPostingRule_2.OutputInventoryItemId = outputItemId;
            inventoryPostingRule_2.TriggerAccountName = "QuantityOccupied";
            inventoryPostingRule_2.OutputAccountName = "QuantitySellable";
            inventoryPostingRule_2.IsOutputNegated = true;
            inventoryPostingRule_2.Active = true;
            inventoryPostingRule_2.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_2);

            CreateInventoryPostingRule inventoryPostingRule_3 = new CreateInventoryPostingRule();
            inventoryPostingRule_3.InventoryPostingRuleId = InventoryPostingRuleIds.QuantityReservedUpdateProductSellableTotal;
            inventoryPostingRule_3.TriggerInventoryItemId = triggerItemId;
            inventoryPostingRule_3.OutputInventoryItemId = outputItemId;
            inventoryPostingRule_3.TriggerAccountName = "QuantityReserved";
            inventoryPostingRule_3.OutputAccountName = "QuantitySellable";
            inventoryPostingRule_3.IsOutputNegated = true;
            inventoryPostingRule_3.Active = true;
            inventoryPostingRule_3.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_3);

            CreateInventoryPostingRule inventoryPostingRule_4 = new CreateInventoryPostingRule();
            inventoryPostingRule_4.InventoryPostingRuleId = InventoryPostingRuleIds.QuantityVirtualUpdateProductSellableTotal;
            inventoryPostingRule_4.TriggerInventoryItemId = triggerItemId;
            inventoryPostingRule_4.OutputInventoryItemId = outputItemId;
            inventoryPostingRule_4.TriggerAccountName = "QuantityVirtual";
            inventoryPostingRule_4.OutputAccountName = "QuantitySellable";
            inventoryPostingRule_4.IsOutputNegated = false;
            inventoryPostingRule_4.Active = true;
            inventoryPostingRule_4.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_4);
        }


    }


}
