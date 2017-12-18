﻿using Dddml.Wms.Domain;
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

            // --------------------------------------------------------
            // S = OH - Oc + V - R + IT
            // --------------------------------------------------------
            // On-Hand
            CreatePRQuantityOnHandUpdateProductSellableTotal(triggerItemId, outputItemId);
            // Occupied
            CreatePRQuantityOccupiedUpdateProductSellableTotal(triggerItemId, outputItemId);
            // Reserved
            CreatePRQuantityReservedUpdateProductSellableTotal(triggerItemId, outputItemId);
            // Virtual
            CreatePRQuantityVirtualUpdateProductSellableTotal(triggerItemId, outputItemId);
            // In-Transit
            CreatePRQuantityInTransitUpdateProductSellableTotal(triggerItemId, outputItemId);

            // --------------------------------------------------------
            //需求数量 = 订单占用数量（Oc） - 在库数量（OH） + 保留数量（R） - 在途数量（IT）
            // --------------------------------------------------------
            // Occupied
            CreatePRQuantityOccupiedUpdateProductRequiredTotal(triggerItemId, outputItemId);
            // On-Hand
            CreatePRQuantityOnHandUpdateProductRequiredTotal(triggerItemId, outputItemId);
            // Reserved
            CreatePRQuantityReservedUpdateProductRequiredTotal(triggerItemId, outputItemId);
            // In-Transit
            CreatePRQuantityInTransitUpdateProductRequiredTotal(triggerItemId, outputItemId);

        }


        private void CreatePRQuantityInTransitUpdateProductRequiredTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId)
        {
            CreateInventoryPostingRule inventoryPostingRule_62 = new CreateInventoryPostingRule();
            inventoryPostingRule_62.InventoryPostingRuleId = InventoryPostingRuleIds.QuantityInTransitUpdateProductRequiredTotal;
            inventoryPostingRule_62.TriggerInventoryItemId = triggerItemId;
            inventoryPostingRule_62.OutputInventoryItemId = outputItemId;
            inventoryPostingRule_62.TriggerAccountName = "QuantityInTransit";
            inventoryPostingRule_62.OutputAccountName = InventoryPostingRuleIds.OutputAccountNameQuantityRequired;
            inventoryPostingRule_62.IsOutputNegated = true;
            inventoryPostingRule_62.Active = true;
            inventoryPostingRule_62.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_62);
        }

        private void CreatePRQuantityReservedUpdateProductRequiredTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId)
        {
            CreateInventoryPostingRule inventoryPostingRule_32 = new CreateInventoryPostingRule();
            inventoryPostingRule_32.InventoryPostingRuleId = InventoryPostingRuleIds.QuantityReservedUpdateProductRequiredTotal;
            inventoryPostingRule_32.TriggerInventoryItemId = triggerItemId;
            inventoryPostingRule_32.OutputInventoryItemId = outputItemId;
            inventoryPostingRule_32.TriggerAccountName = "QuantityReserved";
            inventoryPostingRule_32.OutputAccountName = InventoryPostingRuleIds.OutputAccountNameQuantityRequired;
            inventoryPostingRule_32.IsOutputNegated = false;
            inventoryPostingRule_32.Active = true;
            inventoryPostingRule_32.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_32);
        }

        private void CreatePRQuantityOccupiedUpdateProductRequiredTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId)
        {
            CreateInventoryPostingRule inventoryPostingRule_22 = new CreateInventoryPostingRule();
            inventoryPostingRule_22.InventoryPostingRuleId = InventoryPostingRuleIds.QuantityOccupiedUpdateProductRequiredTotal;
            inventoryPostingRule_22.TriggerInventoryItemId = triggerItemId;
            inventoryPostingRule_22.OutputInventoryItemId = outputItemId;
            inventoryPostingRule_22.TriggerAccountName = "QuantityOccupied";
            inventoryPostingRule_22.OutputAccountName = InventoryPostingRuleIds.OutputAccountNameQuantityRequired;
            inventoryPostingRule_22.IsOutputNegated = false;
            inventoryPostingRule_22.Active = true;
            inventoryPostingRule_22.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_22);
        }

        private void CreatePRQuantityOnHandUpdateProductRequiredTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId)
        {
            CreateInventoryPostingRule inventoryPostingRule_12 = new CreateInventoryPostingRule();
            inventoryPostingRule_12.InventoryPostingRuleId = InventoryPostingRuleIds.QuantityOnHandUpdateProductRequiredTotal;
            inventoryPostingRule_12.TriggerInventoryItemId = triggerItemId;
            inventoryPostingRule_12.OutputInventoryItemId = outputItemId;
            inventoryPostingRule_12.TriggerAccountName = "QuantityOnHand";
            inventoryPostingRule_12.OutputAccountName = InventoryPostingRuleIds.OutputAccountNameQuantityRequired;
            inventoryPostingRule_12.IsOutputNegated = true;
            inventoryPostingRule_12.Active = true;
            inventoryPostingRule_12.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_12);
        }

        // ///////////////////////////////////////////////////////////
        // //////////////// Ouput: Sellable Quantity  ///////////////
        // ///////////////////////////////////////////////////////////
        
        #region Ouput: Sellable Quantity

        private void CreatePRQuantityVirtualUpdateProductSellableTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId)
        {
            CreateInventoryPostingRule inventoryPostingRule_4 = new CreateInventoryPostingRule();
            inventoryPostingRule_4.InventoryPostingRuleId = InventoryPostingRuleIds.QuantityVirtualUpdateProductSellableTotal;
            inventoryPostingRule_4.TriggerInventoryItemId = triggerItemId;
            inventoryPostingRule_4.OutputInventoryItemId = outputItemId;
            inventoryPostingRule_4.TriggerAccountName = "QuantityVirtual";
            inventoryPostingRule_4.OutputAccountName = InventoryPostingRuleIds.OutputAccountNameQuantitySellable;
            inventoryPostingRule_4.IsOutputNegated = false;
            inventoryPostingRule_4.Active = true;
            inventoryPostingRule_4.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_4);
        }

        private void CreatePRQuantityReservedUpdateProductSellableTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId)
        {
            CreateInventoryPostingRule inventoryPostingRule_3 = new CreateInventoryPostingRule();
            inventoryPostingRule_3.InventoryPostingRuleId = InventoryPostingRuleIds.QuantityReservedUpdateProductSellableTotal;
            inventoryPostingRule_3.TriggerInventoryItemId = triggerItemId;
            inventoryPostingRule_3.OutputInventoryItemId = outputItemId;
            inventoryPostingRule_3.TriggerAccountName = "QuantityReserved";
            inventoryPostingRule_3.OutputAccountName = InventoryPostingRuleIds.OutputAccountNameQuantitySellable;
            inventoryPostingRule_3.IsOutputNegated = true;
            inventoryPostingRule_3.Active = true;
            inventoryPostingRule_3.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_3);
        }

        private void CreatePRQuantityOccupiedUpdateProductSellableTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId)
        {
            CreateInventoryPostingRule inventoryPostingRule_2 = new CreateInventoryPostingRule();
            inventoryPostingRule_2.InventoryPostingRuleId = InventoryPostingRuleIds.QuantityOccupiedUpdateProductSellableTotal;
            inventoryPostingRule_2.TriggerInventoryItemId = triggerItemId;
            inventoryPostingRule_2.OutputInventoryItemId = outputItemId;
            inventoryPostingRule_2.TriggerAccountName = "QuantityOccupied";
            inventoryPostingRule_2.OutputAccountName = InventoryPostingRuleIds.OutputAccountNameQuantitySellable;
            inventoryPostingRule_2.IsOutputNegated = true;
            inventoryPostingRule_2.Active = true;
            inventoryPostingRule_2.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_2);
        }

        private void CreatePRQuantityOnHandUpdateProductSellableTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId)
        {
            CreateInventoryPostingRule inventoryPostingRule_1 = new CreateInventoryPostingRule();
            inventoryPostingRule_1.InventoryPostingRuleId = InventoryPostingRuleIds.QuantityOnHandUpdateProductSellableTotal;
            inventoryPostingRule_1.TriggerInventoryItemId = triggerItemId;
            inventoryPostingRule_1.OutputInventoryItemId = outputItemId;
            inventoryPostingRule_1.TriggerAccountName = "QuantityOnHand";
            inventoryPostingRule_1.OutputAccountName = InventoryPostingRuleIds.OutputAccountNameQuantitySellable;
            inventoryPostingRule_1.IsOutputNegated = false;
            inventoryPostingRule_1.Active = true;
            inventoryPostingRule_1.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_1);
        }

        private void CreatePRQuantityInTransitUpdateProductSellableTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId)
        {
            CreateInventoryPostingRule inventoryPostingRule_6 = new CreateInventoryPostingRule();
            inventoryPostingRule_6.InventoryPostingRuleId = InventoryPostingRuleIds.QuantityInTransitUpdateProductSellableTotal;
            inventoryPostingRule_6.TriggerInventoryItemId = triggerItemId;
            inventoryPostingRule_6.OutputInventoryItemId = outputItemId;
            inventoryPostingRule_6.TriggerAccountName = "QuantityInTransit";
            inventoryPostingRule_6.OutputAccountName = InventoryPostingRuleIds.OutputAccountNameQuantitySellable;
            inventoryPostingRule_6.IsOutputNegated = false;
            inventoryPostingRule_6.Active = true;
            inventoryPostingRule_6.CommandId = Guid.NewGuid().ToString();
            inventoryPostingRuleApplicationService.When(inventoryPostingRule_6);
        }

        #endregion

    }


}
