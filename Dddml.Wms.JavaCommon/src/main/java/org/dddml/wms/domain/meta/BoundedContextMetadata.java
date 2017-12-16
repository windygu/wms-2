package org.dddml.wms.domain.meta;

import java.util.*;

public class BoundedContextMetadata {

    public static final String NAME_REQUESTER_ID				= "requesterId";
    public static final String DISCRIMINATOR_COMMAND_TYPE		= "commandType";
    public static final String DISCRIMINATOR_STATE_EVENT_TYPE	= "stateEventType";
    public static final String DISCRIMINATOR_COMMAND_ID			= "commandId";

    public static final String HTTP_SERVICE_ORDERS_QUERY_NAME			= "sort";
    public static final String HTTP_SERVICE_FIRST_RESULT_QUERY_NAME		= "firstResult";
    public static final String HTTP_SERVICE_MAX_RESULTS_QUERY_NAME		= "maxResults";
    public static final String HTTP_SERVICE_RETURNED_FIELDS_QUERY_NAME	= "fields";
    public static final String HTTP_SERVICE_FILTER_QUERY_NAME			= "filter";

    public static final Map<String, String> TYPE_NAME_TO_AGGREGATE_NAME_MAP;

    static {
        Map<String, String> map = new HashMap<>();

        map.put("Attribute", "Attribute");
        map.put("AttributeValue", "Attribute");
        map.put("AttributeSet", "AttributeSet");
        map.put("AttributeUse", "AttributeSet");
        map.put("DocumentType", "DocumentType");
        map.put("InOut", "InOut");
        map.put("InOutLine", "InOut");
        map.put("InventoryItem", "InventoryItem");
        map.put("InventoryItemEntry", "InventoryItem");
        map.put("SellableInventoryItem", "SellableInventoryItem");
        map.put("SellableInventoryItemEntry", "SellableInventoryItem");
        map.put("InventoryPostingRule", "InventoryPostingRule");
        map.put("InventoryPRTriggered", "InventoryPRTriggered");
        map.put("MovementType", "MovementType");
        map.put("OrderHeader", "OrderHeader");
        map.put("OrderItem", "OrderItem");
        map.put("OrderShipment", "OrderShipment");
        map.put("Organization", "Organization");
        map.put("OrganizationStructureType", "OrganizationStructureType");
        map.put("OrganizationStructure", "OrganizationStructure");
        map.put("Product", "Product");
        map.put("ProductCategory", "ProductCategory");
        map.put("Shipment", "Shipment");
        map.put("ShipmentItem", "ShipmentItem");
        map.put("StatusItem", "StatusItem");
        map.put("SupplierProduct", "SupplierProduct");
        map.put("Warehouse", "Warehouse");
        map.put("Locator", "Locator");
        map.put("AttributeSetInstance", "AttributeSetInstance");
        map.put("AttributeSetInstanceExtensionFieldGroup", "AttributeSetInstanceExtensionFieldGroup");
        map.put("AttributeSetInstanceExtensionField", "AttributeSetInstanceExtensionFieldGroup");
        map.put("AttributeValueMvo", "AttributeValueMvo");
        map.put("AttributeUseMvo", "AttributeUseMvo");
        map.put("InOutLineMvo", "InOutLineMvo");
        map.put("InventoryItemEntryMvo", "InventoryItemEntryMvo");
        map.put("SellableInventoryItemEntryMvo", "SellableInventoryItemEntryMvo");
        map.put("AttributeSetInstanceExtensionFieldMvo", "AttributeSetInstanceExtensionFieldMvo");
        
        TYPE_NAME_TO_AGGREGATE_NAME_MAP = map;
    }

    private BoundedContextMetadata() {
    }
}


