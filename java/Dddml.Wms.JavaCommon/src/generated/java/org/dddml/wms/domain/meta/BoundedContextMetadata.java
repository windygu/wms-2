package org.dddml.wms.domain.meta;

import java.util.*;

public class BoundedContextMetadata {

    public static final String NAME_REQUESTER_ID				= "requesterId";
    public static final String DISCRIMINATOR_COMMAND_TYPE		= "commandType";
    public static final String DISCRIMINATOR_EVENT_TYPE	= "eventType";
    public static final String DISCRIMINATOR_COMMAND_ID			= "commandId";

    public static final String HTTP_SERVICE_ORDERS_QUERY_NAME			= "sort";
    public static final String HTTP_SERVICE_FIRST_RESULT_QUERY_NAME		= "firstResult";
    public static final String HTTP_SERVICE_MAX_RESULTS_QUERY_NAME		= "maxResults";
    public static final String HTTP_SERVICE_RETURNED_FIELDS_QUERY_NAME	= "fields";
    public static final String HTTP_SERVICE_FILTER_QUERY_NAME			= "filter";

    public static final Map<String, String> TYPE_NAME_TO_AGGREGATE_NAME_MAP;

    public static final Map<String, Class<?>> CLASS_MAP;

    static {
        Map<String, String> typeToAggMap = new HashMap<>();

        typeToAggMap.put("Attribute", "Attribute");
        typeToAggMap.put("AttributeValue", "Attribute");
        typeToAggMap.put("AttributeAlias", "Attribute");
        typeToAggMap.put("AttributeSet", "AttributeSet");
        typeToAggMap.put("AttributeUse", "AttributeSet");
        typeToAggMap.put("ContactMech", "ContactMech");
        typeToAggMap.put("PostalAddress", "ContactMech");
        typeToAggMap.put("TelecomNumber", "ContactMech");
        typeToAggMap.put("DamageHandlingMethod", "DamageHandlingMethod");
        typeToAggMap.put("DamageReason", "DamageReason");
        typeToAggMap.put("DamageType", "DamageType");
        typeToAggMap.put("DocumentType", "DocumentType");
        typeToAggMap.put("Facility", "Facility");
        typeToAggMap.put("InOut", "InOut");
        typeToAggMap.put("InOutLine", "InOut");
        typeToAggMap.put("InventoryItem", "InventoryItem");
        typeToAggMap.put("InventoryItemEntry", "InventoryItem");
        typeToAggMap.put("InventoryItemRequirement", "InventoryItemRequirement");
        typeToAggMap.put("InventoryItemRequirementEntry", "InventoryItemRequirement");
        typeToAggMap.put("InventoryPostingRule", "InventoryPostingRule");
        typeToAggMap.put("InventoryPRTriggered", "InventoryPRTriggered");
        typeToAggMap.put("Locator", "Locator");
        typeToAggMap.put("LocatorType", "LocatorType");
        typeToAggMap.put("Lot", "Lot");
        typeToAggMap.put("Movement", "Movement");
        typeToAggMap.put("MovementLine", "Movement");
        typeToAggMap.put("MovementConfirmation", "MovementConfirmation");
        typeToAggMap.put("MovementConfirmationLine", "MovementConfirmation");
        typeToAggMap.put("MovementType", "MovementType");
        typeToAggMap.put("Order", "Order");
        typeToAggMap.put("OrderRole", "Order");
        typeToAggMap.put("OrderItem", "Order");
        typeToAggMap.put("OrderShipGroup", "Order");
        typeToAggMap.put("OrderItemShipGroupAssociation", "Order");
        typeToAggMap.put("OrderItemShipGrpInvReservation", "OrderItemShipGrpInvReservation");
        typeToAggMap.put("OrderShipment", "OrderShipment");
        typeToAggMap.put("OrganizationStructure", "OrganizationStructure");
        typeToAggMap.put("OrganizationStructureType", "OrganizationStructureType");
        typeToAggMap.put("Party", "Party");
        typeToAggMap.put("Organization", "Party");
        typeToAggMap.put("PartyRole", "PartyRole");
        typeToAggMap.put("PhysicalInventory", "PhysicalInventory");
        typeToAggMap.put("PhysicalInventoryLine", "PhysicalInventory");
        typeToAggMap.put("Picklist", "Picklist");
        typeToAggMap.put("PicklistRole", "Picklist");
        typeToAggMap.put("PicklistBin", "PicklistBin");
        typeToAggMap.put("PicklistItem", "PicklistBin");
        typeToAggMap.put("Pickwave", "Pickwave");
        typeToAggMap.put("Product", "Product");
        typeToAggMap.put("ProductCategory", "ProductCategory");
        typeToAggMap.put("ProductCategoryMember", "ProductCategoryMember");
        typeToAggMap.put("RejectionReason", "RejectionReason");
        typeToAggMap.put("RoleType", "RoleType");
        typeToAggMap.put("SellableInventoryItem", "SellableInventoryItem");
        typeToAggMap.put("SellableInventoryItemEntry", "SellableInventoryItem");
        typeToAggMap.put("Shipment", "Shipment");
        typeToAggMap.put("ShipmentItem", "Shipment");
        typeToAggMap.put("ShipmentReceipt", "Shipment");
        typeToAggMap.put("ItemIssuance", "Shipment");
        typeToAggMap.put("ShipmentMethodType", "ShipmentMethodType");
        typeToAggMap.put("ShipmentPackage", "ShipmentPackage");
        typeToAggMap.put("ShipmentPackageContent", "ShipmentPackage");
        typeToAggMap.put("ShipmentType", "ShipmentType");
        typeToAggMap.put("StatusItem", "StatusItem");
        typeToAggMap.put("SupplierProduct", "SupplierProduct");
        typeToAggMap.put("Uom", "Uom");
        typeToAggMap.put("UomConversion", "UomConversion");
        typeToAggMap.put("UomType", "UomType");
        typeToAggMap.put("Warehouse", "Warehouse");
        typeToAggMap.put("AttributeSetInstance", "AttributeSetInstance");
        typeToAggMap.put("AttributeSetInstanceExtensionField", "AttributeSetInstanceExtensionField");
        typeToAggMap.put("AttributeSetInstanceExtensionFieldGroup", "AttributeSetInstanceExtensionFieldGroup");
        typeToAggMap.put("AttributeValueMvo", "AttributeValueMvo");
        typeToAggMap.put("AttributeAliasMvo", "AttributeAliasMvo");
        typeToAggMap.put("AttributeUseMvo", "AttributeUseMvo");
        typeToAggMap.put("InOutLineMvo", "InOutLineMvo");
        typeToAggMap.put("InventoryItemEntryMvo", "InventoryItemEntryMvo");
        typeToAggMap.put("InventoryItemRequirementEntryMvo", "InventoryItemRequirementEntryMvo");
        typeToAggMap.put("MovementLineMvo", "MovementLineMvo");
        typeToAggMap.put("MovementConfirmationLineMvo", "MovementConfirmationLineMvo");
        typeToAggMap.put("OrderRoleMvo", "OrderRoleMvo");
        typeToAggMap.put("OrderItemMvo", "OrderItemMvo");
        typeToAggMap.put("OrderShipGroupMvo", "OrderShipGroupMvo");
        typeToAggMap.put("OrderItemShipGroupAssociationMvo", "OrderItemShipGroupAssociationMvo");
        typeToAggMap.put("PhysicalInventoryLineMvo", "PhysicalInventoryLineMvo");
        typeToAggMap.put("PicklistRoleMvo", "PicklistRoleMvo");
        typeToAggMap.put("PicklistItemMvo", "PicklistItemMvo");
        typeToAggMap.put("SellableInventoryItemEntryMvo", "SellableInventoryItemEntryMvo");
        typeToAggMap.put("ShipmentItemMvo", "ShipmentItemMvo");
        typeToAggMap.put("ShipmentReceiptMvo", "ShipmentReceiptMvo");
        typeToAggMap.put("ItemIssuanceMvo", "ItemIssuanceMvo");
        typeToAggMap.put("ShipmentPackageContentMvo", "ShipmentPackageContentMvo");
        TYPE_NAME_TO_AGGREGATE_NAME_MAP = typeToAggMap;

        Map<String, Class<?>> clsMap = new HashMap<>();
        clsMap.put("bool", Boolean.class);
        clsMap.put("Boolean", Boolean.class);
        clsMap.put("bool?", Boolean.class);
        clsMap.put("DateTime", java.util.Date.class);
        clsMap.put("Date", java.util.Date.class);
        clsMap.put("java.util.Date", java.util.Date.class);
        clsMap.put("DateTime?", java.util.Date.class);
        clsMap.put("decimal", java.math.BigDecimal.class);
        clsMap.put("BigDecimal", java.math.BigDecimal.class);
        clsMap.put("java.math.BigDecimal", java.math.BigDecimal.class);
        clsMap.put("decimal?", java.math.BigDecimal.class);
        clsMap.put("int", Integer.class);
        clsMap.put("Integer", Integer.class);
        clsMap.put("int?", Integer.class);
        clsMap.put("long", Long.class);
        clsMap.put("Long", Long.class);
        clsMap.put("long?", Long.class);
        clsMap.put("string", String.class);
        clsMap.put("String", String.class);
        clsMap.put("map", java.util.Map.class);
        clsMap.put("java.util.Map<String, Object>", java.util.Map.class);
        clsMap.put("java.util.Map", java.util.Map.class);
        clsMap.put("blob", java.sql.Blob.class);
        clsMap.put("java.sql.Blob", java.sql.Blob.class);
        clsMap.put("byte-array", byte[].class);
        clsMap.put("byte[]", byte[].class);
        clsMap.put("object", Object.class);
        clsMap.put("Object", Object.class);
        clsMap.put("date-time", java.sql.Timestamp.class);
        clsMap.put("java.sql.Timestamp", java.sql.Timestamp.class);
        clsMap.put("date", java.sql.Date.class);
        clsMap.put("java.sql.Date", java.sql.Date.class);
        clsMap.put("time", java.sql.Time.class);
        clsMap.put("java.sql.Time", java.sql.Time.class);
        clsMap.put("currency-amount", java.math.BigDecimal.class);
        clsMap.put("currency-precise", java.math.BigDecimal.class);
        clsMap.put("fixed-point", java.math.BigDecimal.class);
        clsMap.put("floating-point", Double.class);
        clsMap.put("Double", Double.class);
        clsMap.put("numeric", Long.class);
        clsMap.put("id", String.class);
        clsMap.put("id-long", String.class);
        clsMap.put("id-vlong", String.class);
        clsMap.put("indicator", String.class);
        clsMap.put("very-short", String.class);
        clsMap.put("short-varchar", String.class);
        clsMap.put("long-varchar", String.class);
        clsMap.put("very-long", String.class);
        clsMap.put("comment", String.class);
        clsMap.put("description", String.class);
        clsMap.put("name", String.class);
        clsMap.put("value", String.class);
        clsMap.put("credit-card-number", String.class);
        clsMap.put("credit-card-date", String.class);
        clsMap.put("email", String.class);
        clsMap.put("url", String.class);
        clsMap.put("id-ne", String.class);
        clsMap.put("id-long-ne", String.class);
        clsMap.put("id-vlong-ne", String.class);
        clsMap.put("tel-number", String.class);
        CLASS_MAP = clsMap;
    }

    private BoundedContextMetadata() {
    }
}


