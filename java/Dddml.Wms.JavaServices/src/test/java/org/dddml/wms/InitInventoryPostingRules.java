package org.dddml.wms;

import org.dddml.wms.domain.inventoryitem.InventoryItemId;
import org.dddml.wms.domain.inventoryitem.InventoryItemIds;
import org.dddml.wms.domain.inventorypostingrule.AbstractInventoryPostingRuleCommand;
import org.dddml.wms.domain.inventorypostingrule.InventoryPostingRuleApplicationService;
import org.dddml.wms.domain.inventorypostingrule.InventoryPostingRuleCommand;
import org.dddml.wms.domain.inventorypostingrule.InventoryPostingRuleIds;
import org.dddml.wms.specialization.ApplicationContext;

import java.util.UUID;

/**
 * Created by yangjiefeng on 2018/1/29.
 */
public class InitInventoryPostingRules {

    static InventoryPostingRuleApplicationService inventoryPostingRuleApplicationService;

    public static void createDefaultInventoryPostingRules() {
        inventoryPostingRuleApplicationService = (InventoryPostingRuleApplicationService) ApplicationContext.current.get("inventoryPostingRuleApplicationService");

        InventoryItemId triggerItemId = new InventoryItemId(InventoryItemIds.WILDCARD, InventoryItemIds.WILDCARD, InventoryItemIds.WILDCARD);
        InventoryItemId outputItemId = new InventoryItemId(InventoryItemIds.SAME_AS_SOURCE, InventoryItemIds.EMPTY_LOCATOR_ID, InventoryItemIds.EMPTY_ATTRIBUTE_SET_INSTANCE_ID);

        // --------------------------------------------------------
        // S = OH - Oc + V - R + IT
        // --------------------------------------------------------
        // On-Hand
        createPRQuantityOnHandUpdateProductSellableTotal(triggerItemId, outputItemId);
        // Occupied
        createPRQuantityOccupiedUpdateProductSellableTotal(triggerItemId, outputItemId);
        // Reserved
        createPRQuantityReservedUpdateProductSellableTotal(triggerItemId, outputItemId);
        // Virtual
        createPRQuantityVirtualUpdateProductSellableTotal(triggerItemId, outputItemId);
        // In-Transit
        createPRQuantityInTransitUpdateProductSellableTotal(triggerItemId, outputItemId);

        // ---------------------------------------------------------------------------
        //需求数量 = 订单占用数量（Oc） - 在库数量（OH） + 保留数量（R） - 在途数量（IT）
        // ---------------------------------------------------------------------------
        // Occupied
        createPRQuantityOccupiedUpdateProductRequiredTotal(triggerItemId, outputItemId);
        // On-Hand
        createPRQuantityOnHandUpdateProductRequiredTotal(triggerItemId, outputItemId);
        // Reserved
        createPRQuantityReservedUpdateProductRequiredTotal(triggerItemId, outputItemId);
        // In-Transit
        createPRQuantityInTransitUpdateProductRequiredTotal(triggerItemId, outputItemId);

    }

    // ///////////////////////////////////////////////////////////
    // //////////////// Ouput: Required Quantity  ///////////////
    // ///////////////////////////////////////////////////////////
    private static void createPRQuantityInTransitUpdateProductRequiredTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId) {
        InventoryPostingRuleCommand.CreateInventoryPostingRule inventoryPostingRule_62 = new AbstractInventoryPostingRuleCommand.SimpleCreateInventoryPostingRule();
        inventoryPostingRule_62.setInventoryPostingRuleId(InventoryPostingRuleIds.QUANTITY_IN_TRANSIT_UPDATE_PRODUCT_REQUIRED_TOTAL);
        inventoryPostingRule_62.setTriggerInventoryItemId(triggerItemId);
        inventoryPostingRule_62.setOutputInventoryItemId(outputItemId);
        inventoryPostingRule_62.setTriggerAccountName("InTransitQuantity");
        inventoryPostingRule_62.setOutputAccountName(InventoryPostingRuleIds.OUTPUT_ACCOUNT_NAME_REQUIRED_QUANTITY);
        inventoryPostingRule_62.setIsOutputNegated(true);
        inventoryPostingRule_62.setActive(true);
        inventoryPostingRule_62.setCommandId(UUID.randomUUID().toString());
        inventoryPostingRuleApplicationService.when(inventoryPostingRule_62);
    }

    private static void createPRQuantityReservedUpdateProductRequiredTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId) {
        InventoryPostingRuleCommand.CreateInventoryPostingRule inventoryPostingRule_32 = new AbstractInventoryPostingRuleCommand.SimpleCreateInventoryPostingRule();
        inventoryPostingRule_32.setInventoryPostingRuleId(InventoryPostingRuleIds.QUANTITY_RESERVED_UPDATE_PRODUCT_REQUIRED_TOTAL);
        inventoryPostingRule_32.setTriggerInventoryItemId(triggerItemId);
        inventoryPostingRule_32.setOutputInventoryItemId(outputItemId);
        inventoryPostingRule_32.setTriggerAccountName("ReservedQuantity");
        inventoryPostingRule_32.setOutputAccountName(InventoryPostingRuleIds.OUTPUT_ACCOUNT_NAME_REQUIRED_QUANTITY);
        inventoryPostingRule_32.setIsOutputNegated(false);
        inventoryPostingRule_32.setActive(true);
        inventoryPostingRule_32.setCommandId(UUID.randomUUID().toString());
        inventoryPostingRuleApplicationService.when(inventoryPostingRule_32);
    }

    private static void createPRQuantityOccupiedUpdateProductRequiredTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId) {
        InventoryPostingRuleCommand.CreateInventoryPostingRule inventoryPostingRule_22 = new AbstractInventoryPostingRuleCommand.SimpleCreateInventoryPostingRule();
        inventoryPostingRule_22.setInventoryPostingRuleId(InventoryPostingRuleIds.QUANTITY_OCCUPIED_UPDATE_PRODUCT_REQUIRED_TOTAL);
        inventoryPostingRule_22.setTriggerInventoryItemId(triggerItemId);
        inventoryPostingRule_22.setOutputInventoryItemId(outputItemId);
        inventoryPostingRule_22.setTriggerAccountName("OccupiedQuantity");
        inventoryPostingRule_22.setOutputAccountName(InventoryPostingRuleIds.OUTPUT_ACCOUNT_NAME_REQUIRED_QUANTITY);
        inventoryPostingRule_22.setIsOutputNegated(false);
        inventoryPostingRule_22.setActive(true);
        inventoryPostingRule_22.setCommandId(UUID.randomUUID().toString());
        inventoryPostingRuleApplicationService.when(inventoryPostingRule_22);
    }

    private static void createPRQuantityOnHandUpdateProductRequiredTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId) {
        InventoryPostingRuleCommand.CreateInventoryPostingRule inventoryPostingRule_12 = new AbstractInventoryPostingRuleCommand.SimpleCreateInventoryPostingRule();
        inventoryPostingRule_12.setInventoryPostingRuleId(InventoryPostingRuleIds.QUANTITY_ON_HAND_UPDATE_PRODUCT_REQUIRED_TOTAL);
        inventoryPostingRule_12.setTriggerInventoryItemId(triggerItemId);
        inventoryPostingRule_12.setOutputInventoryItemId(outputItemId);
        inventoryPostingRule_12.setTriggerAccountName("OnHandQuantity");
        inventoryPostingRule_12.setOutputAccountName(InventoryPostingRuleIds.OUTPUT_ACCOUNT_NAME_REQUIRED_QUANTITY);
        inventoryPostingRule_12.setIsOutputNegated(true);
        inventoryPostingRule_12.setActive(true);
        inventoryPostingRule_12.setCommandId(UUID.randomUUID().toString());
        inventoryPostingRuleApplicationService.when(inventoryPostingRule_12);
    }

    // ///////////////////////////////////////////////////////////
    // //////////////// Ouput: Sellable Quantity  ///////////////
    // ///////////////////////////////////////////////////////////

    private static void createPRQuantityVirtualUpdateProductSellableTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId) {
        InventoryPostingRuleCommand.CreateInventoryPostingRule inventoryPostingRule_4 = new AbstractInventoryPostingRuleCommand.SimpleCreateInventoryPostingRule();
        inventoryPostingRule_4.setInventoryPostingRuleId(InventoryPostingRuleIds.QUANTITY_VIRTUAL_UPDATE_PRODUCT_SELLABLE_TOTAL);
        inventoryPostingRule_4.setTriggerInventoryItemId(triggerItemId);
        inventoryPostingRule_4.setOutputInventoryItemId(outputItemId);
        inventoryPostingRule_4.setTriggerAccountName("VirtualQuantity");
        inventoryPostingRule_4.setOutputAccountName(InventoryPostingRuleIds.OUTPUT_ACCOUNT_NAME_SELLABLE_QUANTITY);
        inventoryPostingRule_4.setIsOutputNegated(false);
        inventoryPostingRule_4.setActive(true);
        inventoryPostingRule_4.setCommandId(UUID.randomUUID().toString());
        inventoryPostingRuleApplicationService.when(inventoryPostingRule_4);
    }

    private static void createPRQuantityReservedUpdateProductSellableTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId) {
        InventoryPostingRuleCommand.CreateInventoryPostingRule inventoryPostingRule_3 = new AbstractInventoryPostingRuleCommand.SimpleCreateInventoryPostingRule();
        inventoryPostingRule_3.setInventoryPostingRuleId(InventoryPostingRuleIds.QUANTITY_RESERVED_UPDATE_PRODUCT_SELLABLE_TOTAL);
        inventoryPostingRule_3.setTriggerInventoryItemId(triggerItemId);
        inventoryPostingRule_3.setOutputInventoryItemId(outputItemId);
        inventoryPostingRule_3.setTriggerAccountName("ReservedQuantity");
        inventoryPostingRule_3.setOutputAccountName(InventoryPostingRuleIds.OUTPUT_ACCOUNT_NAME_SELLABLE_QUANTITY);
        inventoryPostingRule_3.setIsOutputNegated(true);
        inventoryPostingRule_3.setActive(true);
        inventoryPostingRule_3.setCommandId(UUID.randomUUID().toString());
        inventoryPostingRuleApplicationService.when(inventoryPostingRule_3);
    }

    private static void createPRQuantityOccupiedUpdateProductSellableTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId) {
        InventoryPostingRuleCommand.CreateInventoryPostingRule inventoryPostingRule_2 = new AbstractInventoryPostingRuleCommand.SimpleCreateInventoryPostingRule();
        inventoryPostingRule_2.setInventoryPostingRuleId(InventoryPostingRuleIds.QUANTITY_OCCUPIED_UPDATE_PRODUCT_SELLABLE_TOTAL);
        inventoryPostingRule_2.setTriggerInventoryItemId(triggerItemId);
        inventoryPostingRule_2.setOutputInventoryItemId(outputItemId);
        inventoryPostingRule_2.setTriggerAccountName("OccupiedQuantity");
        inventoryPostingRule_2.setOutputAccountName(InventoryPostingRuleIds.OUTPUT_ACCOUNT_NAME_SELLABLE_QUANTITY);
        inventoryPostingRule_2.setIsOutputNegated(true);
        inventoryPostingRule_2.setActive(true);
        inventoryPostingRule_2.setCommandId(UUID.randomUUID().toString());
        inventoryPostingRuleApplicationService.when(inventoryPostingRule_2);
    }

    private static void createPRQuantityOnHandUpdateProductSellableTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId) {
        InventoryPostingRuleCommand.CreateInventoryPostingRule inventoryPostingRule_1 = new AbstractInventoryPostingRuleCommand.SimpleCreateInventoryPostingRule();
        inventoryPostingRule_1.setInventoryPostingRuleId(InventoryPostingRuleIds.QUANTITY_ON_HAND_UPDATE_PRODUCT_SELLABLE_TOTAL);
        inventoryPostingRule_1.setTriggerInventoryItemId(triggerItemId);
        inventoryPostingRule_1.setOutputInventoryItemId(outputItemId);
        inventoryPostingRule_1.setTriggerAccountName("OnHandQuantity");
        inventoryPostingRule_1.setOutputAccountName(InventoryPostingRuleIds.OUTPUT_ACCOUNT_NAME_SELLABLE_QUANTITY);
        inventoryPostingRule_1.setIsOutputNegated(false);
        inventoryPostingRule_1.setActive(true);
        inventoryPostingRule_1.setCommandId(UUID.randomUUID().toString());
        inventoryPostingRuleApplicationService.when(inventoryPostingRule_1);
    }

    private static void createPRQuantityInTransitUpdateProductSellableTotal(InventoryItemId triggerItemId, InventoryItemId outputItemId) {
        InventoryPostingRuleCommand.CreateInventoryPostingRule inventoryPostingRule_6 = new AbstractInventoryPostingRuleCommand.SimpleCreateInventoryPostingRule();
        inventoryPostingRule_6.setInventoryPostingRuleId(InventoryPostingRuleIds.QUANTITY_IN_TRANSIT_UPDATE_PRODUCT_SELLABLE_TOTAL);
        inventoryPostingRule_6.setTriggerInventoryItemId(triggerItemId);
        inventoryPostingRule_6.setOutputInventoryItemId(outputItemId);
        inventoryPostingRule_6.setTriggerAccountName("InTransitQuantity");
        inventoryPostingRule_6.setOutputAccountName(InventoryPostingRuleIds.OUTPUT_ACCOUNT_NAME_SELLABLE_QUANTITY);
        inventoryPostingRule_6.setIsOutputNegated(false);
        inventoryPostingRule_6.setActive(true);
        inventoryPostingRule_6.setCommandId(UUID.randomUUID().toString());
        inventoryPostingRuleApplicationService.when(inventoryPostingRule_6);
    }
}
