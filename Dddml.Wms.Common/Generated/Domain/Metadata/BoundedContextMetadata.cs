using System;
using System.Collections.Generic;

namespace Dddml.Wms.Domain.Metadata
{

    public class BoundedContextMetadata
    {
        private static IList<string> _aggregateNames;

        public static IList<string> AggregateNames
        {
            get { return _aggregateNames; }
        }

        private static IDictionary<string, string> _aggregateNamespaces;

        public static IDictionary<string, string> AggregateNamespaces
        {
            get { return _aggregateNamespaces; }
        }

        private static string _domainAssemblyName = "Dddml.Wms.Common";

        public static string DomainAssemblyName
        {
            get { return _domainAssemblyName; }
        }

        static BoundedContextMetadata()
        {
            _aggregateNames = new List<string>();
            _aggregateNames.Add("Attribute");
            _aggregateNames.Add("AttributeSet");
            _aggregateNames.Add("DocumentType");
            _aggregateNames.Add("InOut");
            _aggregateNames.Add("InventoryItem");
            _aggregateNames.Add("InventoryItemRequirement");
            _aggregateNames.Add("InventoryPostingRule");
            _aggregateNames.Add("InventoryPRTriggered");
            _aggregateNames.Add("Movement");
            _aggregateNames.Add("MovementConfirmation");
            _aggregateNames.Add("MovementType");
            _aggregateNames.Add("Order");
            _aggregateNames.Add("OrderShipment");
            _aggregateNames.Add("Organization");
            _aggregateNames.Add("OrganizationStructure");
            _aggregateNames.Add("OrganizationStructureType");
            _aggregateNames.Add("PhysicalInventory");
            _aggregateNames.Add("Product");
            _aggregateNames.Add("ProductCategory");
            _aggregateNames.Add("ProductCategoryMember");
            _aggregateNames.Add("SellableInventoryItem");
            _aggregateNames.Add("Shipment");
            _aggregateNames.Add("ShipmentType");
            _aggregateNames.Add("StatusItem");
            _aggregateNames.Add("SupplierProduct");
            _aggregateNames.Add("Warehouse");
            _aggregateNames.Add("Locator");
            _aggregateNames.Add("AttributeSetInstance");
            _aggregateNames.Add("AttributeSetInstanceExtensionFieldGroup");
            _aggregateNames.Add("AttributeValueMvo");
            _aggregateNames.Add("AttributeUseMvo");
            _aggregateNames.Add("InOutLineMvo");
            _aggregateNames.Add("InventoryItemEntryMvo");
            _aggregateNames.Add("InventoryItemRequirementEntryMvo");
            _aggregateNames.Add("MovementLineMvo");
            _aggregateNames.Add("MovementConfirmationLineMvo");
            _aggregateNames.Add("OrderItemMvo");
            _aggregateNames.Add("PhysicalInventoryLineMvo");
            _aggregateNames.Add("SellableInventoryItemEntryMvo");
            _aggregateNames.Add("ShipmentItemMvo");
            _aggregateNames.Add("AttributeSetInstanceExtensionFieldMvo");

            _aggregateNamespaces = new Dictionary<string, string>();
            _aggregateNamespaces.Add("Attribute", "Dddml.Wms.Domain.Attribute");
            _aggregateNamespaces.Add("AttributeSet", "Dddml.Wms.Domain.AttributeSet");
            _aggregateNamespaces.Add("DocumentType", "Dddml.Wms.Domain.DocumentType");
            _aggregateNamespaces.Add("InOut", "Dddml.Wms.Domain.InOut");
            _aggregateNamespaces.Add("InventoryItem", "Dddml.Wms.Domain.InventoryItem");
            _aggregateNamespaces.Add("InventoryItemRequirement", "Dddml.Wms.Domain.InventoryItemRequirement");
            _aggregateNamespaces.Add("InventoryPostingRule", "Dddml.Wms.Domain.InventoryPostingRule");
            _aggregateNamespaces.Add("InventoryPRTriggered", "Dddml.Wms.Domain.InventoryPRTriggered");
            _aggregateNamespaces.Add("Movement", "Dddml.Wms.Domain.Movement");
            _aggregateNamespaces.Add("MovementConfirmation", "Dddml.Wms.Domain.MovementConfirmation");
            _aggregateNamespaces.Add("MovementType", "Dddml.Wms.Domain.MovementType");
            _aggregateNamespaces.Add("Order", "Dddml.Wms.Domain.Order");
            _aggregateNamespaces.Add("OrderShipment", "Dddml.Wms.Domain.OrderShipment");
            _aggregateNamespaces.Add("Organization", "Dddml.Wms.Domain.Organization");
            _aggregateNamespaces.Add("OrganizationStructure", "Dddml.Wms.Domain.OrganizationStructure");
            _aggregateNamespaces.Add("OrganizationStructureType", "Dddml.Wms.Domain.OrganizationStructureType");
            _aggregateNamespaces.Add("PhysicalInventory", "Dddml.Wms.Domain.PhysicalInventory");
            _aggregateNamespaces.Add("Product", "Dddml.Wms.Domain.Product");
            _aggregateNamespaces.Add("ProductCategory", "Dddml.Wms.Domain.ProductCategory");
            _aggregateNamespaces.Add("ProductCategoryMember", "Dddml.Wms.Domain.ProductCategoryMember");
            _aggregateNamespaces.Add("SellableInventoryItem", "Dddml.Wms.Domain.SellableInventoryItem");
            _aggregateNamespaces.Add("Shipment", "Dddml.Wms.Domain.Shipment");
            _aggregateNamespaces.Add("ShipmentType", "Dddml.Wms.Domain.ShipmentType");
            _aggregateNamespaces.Add("StatusItem", "Dddml.Wms.Domain.StatusItem");
            _aggregateNamespaces.Add("SupplierProduct", "Dddml.Wms.Domain.SupplierProduct");
            _aggregateNamespaces.Add("Warehouse", "Dddml.Wms.Domain.Warehouse");
            _aggregateNamespaces.Add("Locator", "Dddml.Wms.Domain.Locator");
            _aggregateNamespaces.Add("AttributeSetInstance", "Dddml.Wms.Domain.AttributeSetInstance");
            _aggregateNamespaces.Add("AttributeSetInstanceExtensionFieldGroup", "Dddml.Wms.Domain.AttributeSetInstanceExtensionFieldGroup");
            _aggregateNamespaces.Add("AttributeValueMvo", "Dddml.Wms.Domain.AttributeValueMvo");
            _aggregateNamespaces.Add("AttributeUseMvo", "Dddml.Wms.Domain.AttributeUseMvo");
            _aggregateNamespaces.Add("InOutLineMvo", "Dddml.Wms.Domain.InOutLineMvo");
            _aggregateNamespaces.Add("InventoryItemEntryMvo", "Dddml.Wms.Domain.InventoryItemEntryMvo");
            _aggregateNamespaces.Add("InventoryItemRequirementEntryMvo", "Dddml.Wms.Domain.InventoryItemRequirementEntryMvo");
            _aggregateNamespaces.Add("MovementLineMvo", "Dddml.Wms.Domain.MovementLineMvo");
            _aggregateNamespaces.Add("MovementConfirmationLineMvo", "Dddml.Wms.Domain.MovementConfirmationLineMvo");
            _aggregateNamespaces.Add("OrderItemMvo", "Dddml.Wms.Domain.OrderItemMvo");
            _aggregateNamespaces.Add("PhysicalInventoryLineMvo", "Dddml.Wms.Domain.PhysicalInventoryLineMvo");
            _aggregateNamespaces.Add("SellableInventoryItemEntryMvo", "Dddml.Wms.Domain.SellableInventoryItemEntryMvo");
            _aggregateNamespaces.Add("ShipmentItemMvo", "Dddml.Wms.Domain.ShipmentItemMvo");
            _aggregateNamespaces.Add("AttributeSetInstanceExtensionFieldMvo", "Dddml.Wms.Domain.AttributeSetInstanceExtensionFieldMvo");
        }

    }
}

