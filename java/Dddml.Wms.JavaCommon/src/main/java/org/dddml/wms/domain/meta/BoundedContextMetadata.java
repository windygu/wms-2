package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public class BoundedContextMetadata {

    public static final String NAME_REQUESTER_ID = "requesterId";
    public static final String DISCRIMINATOR_COMMAND_TYPE = "commandType";
    public static final String DISCRIMINATOR_STATE_EVENT_TYPE = "stateEventType";
    public static final String DISCRIMINATOR_COMMAND_ID = "commandId";

    public static final String HTTP_SERVICE_ORDERS_QUERY_NAME = "sort";
    public static final String HTTP_SERVICE_FIRST_RESULT_QUERY_NAME = "firstResult";
    public static final String HTTP_SERVICE_MAX_RESULTS_QUERY_NAME = "maxResults";
    public static final String HTTP_SERVICE_RETURNED_FIELDS_QUERY_NAME = "fields";
    public static final String HTTP_SERVICE_FILTER_QUERY_NAME = "filter";

    public static final Map<String, String> TYPE_NAME_TO_AGGREGATE_NAME_MAP;

    static {
        Map<String, String> map = new HashMap<>();

        map.put("Attribute", "Attribute");
        map.put("AttributeValue", "Attribute");
        map.put("AttributeAlias", "Attribute");
        map.put("AttributeSet", "AttributeSet");
        map.put("AttributeUse", "AttributeSet");
        map.put("DamageReason", "DamageReason");
        map.put("DamageType", "DamageType");
        map.put("DamageHandlingMethod", "DamageHandlingMethod");
        map.put("DocumentType", "DocumentType");
        map.put("InOut", "InOut");
        map.put("InOutLine", "InOut");
        map.put("InventoryItem", "InventoryItem");
        map.put("InventoryItemEntry", "InventoryItem");
        map.put("InventoryItemRequirement", "InventoryItemRequirement");
        map.put("InventoryItemRequirementEntry", "InventoryItemRequirement");
        map.put("InventoryPostingRule", "InventoryPostingRule");
        map.put("InventoryPRTriggered", "InventoryPRTriggered");
        map.put("Lot", "Lot");
        map.put("Movement", "Movement");
        map.put("MovementLine", "Movement");
        map.put("MovementConfirmation", "MovementConfirmation");
        map.put("MovementConfirmationLine", "MovementConfirmation");
        map.put("MovementType", "MovementType");
        map.put("Order", "Order");
        map.put("OrderItem", "Order");
        map.put("OrderShipment", "OrderShipment");
        map.put("OrganizationStructure", "OrganizationStructure");
        map.put("OrganizationStructureType", "OrganizationStructureType");
        map.put("Party", "Party");
        map.put("Organization", "Party");
        map.put("PhysicalInventory", "PhysicalInventory");
        map.put("PhysicalInventoryLine", "PhysicalInventory");
        map.put("Product", "Product");
        map.put("ProductCategory", "ProductCategory");
        map.put("ProductCategoryMember", "ProductCategoryMember");
        map.put("RejectionReason", "RejectionReason");
        map.put("SellableInventoryItem", "SellableInventoryItem");
        map.put("SellableInventoryItemEntry", "SellableInventoryItem");
        map.put("Shipment", "Shipment");
        map.put("ShipmentItem", "Shipment");
        map.put("ShipmentReceipt", "Shipment");
        map.put("ShipmentType", "ShipmentType");
        map.put("StatusItem", "StatusItem");
        map.put("SupplierProduct", "SupplierProduct");
        map.put("Uom", "Uom");
        map.put("UomConversion", "UomConversion");
        map.put("UomType", "UomType");
        map.put("Warehouse", "Warehouse");
        map.put("Locator", "Locator");
        map.put("AttributeSetInstance", "AttributeSetInstance");
        map.put("AttributeSetInstanceExtensionField", "AttributeSetInstanceExtensionField");
        map.put("AttributeSetInstanceExtensionFieldGroup", "AttributeSetInstanceExtensionFieldGroup");
        map.put("AttributeValueMvo", "AttributeValueMvo");
        map.put("AttributeAliasMvo", "AttributeAliasMvo");
        map.put("AttributeUseMvo", "AttributeUseMvo");
        map.put("InOutLineMvo", "InOutLineMvo");
        map.put("InventoryItemEntryMvo", "InventoryItemEntryMvo");
        map.put("InventoryItemRequirementEntryMvo", "InventoryItemRequirementEntryMvo");
        map.put("MovementLineMvo", "MovementLineMvo");
        map.put("MovementConfirmationLineMvo", "MovementConfirmationLineMvo");
        map.put("OrderItemMvo", "OrderItemMvo");
        map.put("PhysicalInventoryLineMvo", "PhysicalInventoryLineMvo");
        map.put("SellableInventoryItemEntryMvo", "SellableInventoryItemEntryMvo");
        map.put("ShipmentItemMvo", "ShipmentItemMvo");
        map.put("ShipmentReceiptMvo", "ShipmentReceiptMvo");

        TYPE_NAME_TO_AGGREGATE_NAME_MAP = map;
    }

    private BoundedContextMetadata() {
    }
}


