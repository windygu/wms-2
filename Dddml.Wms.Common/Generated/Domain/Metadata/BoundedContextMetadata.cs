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
            _aggregateNames.Add("ContactMech");
            _aggregateNames.Add("DamageHandlingMethod");
            _aggregateNames.Add("DamageReason");
            _aggregateNames.Add("DamageType");
            _aggregateNames.Add("DocumentType");
            _aggregateNames.Add("Facility");
            _aggregateNames.Add("GoodIdentificationType");
            _aggregateNames.Add("InOut");
            _aggregateNames.Add("InventoryItem");
            _aggregateNames.Add("InventoryItemRequirement");
            _aggregateNames.Add("InventoryPostingRule");
            _aggregateNames.Add("InventoryPRTriggered");
            _aggregateNames.Add("Locator");
            _aggregateNames.Add("LocatorType");
            _aggregateNames.Add("Lot");
            _aggregateNames.Add("Movement");
            _aggregateNames.Add("MovementConfirmation");
            _aggregateNames.Add("MovementType");
            _aggregateNames.Add("Order");
            _aggregateNames.Add("OrderItemShipGrpInvReservation");
            _aggregateNames.Add("OrderShipment");
            _aggregateNames.Add("OrganizationStructure");
            _aggregateNames.Add("OrganizationStructureType");
            _aggregateNames.Add("Party");
            _aggregateNames.Add("PartyRole");
            _aggregateNames.Add("PhysicalInventory");
            _aggregateNames.Add("Picklist");
            _aggregateNames.Add("PicklistBin");
            _aggregateNames.Add("Pickwave");
            _aggregateNames.Add("Product");
            _aggregateNames.Add("ProductCategory");
            _aggregateNames.Add("ProductCategoryMember");
            _aggregateNames.Add("RejectionReason");
            _aggregateNames.Add("RoleType");
            _aggregateNames.Add("SellableInventoryItem");
            _aggregateNames.Add("Shipment");
            _aggregateNames.Add("ShipmentMethodType");
            _aggregateNames.Add("ShipmentPackage");
            _aggregateNames.Add("ShipmentType");
            _aggregateNames.Add("StatusItem");
            _aggregateNames.Add("SupplierProduct");
            _aggregateNames.Add("Uom");
            _aggregateNames.Add("UomConversion");
            _aggregateNames.Add("UomType");
            _aggregateNames.Add("Warehouse");
            _aggregateNames.Add("AttributeSetInstance");
            _aggregateNames.Add("AttributeSetInstanceExtensionField");
            _aggregateNames.Add("AttributeSetInstanceExtensionFieldGroup");

            _aggregateNamespaces = new Dictionary<string, string>();
            _aggregateNamespaces.Add("Attribute", "Dddml.Wms.Domain.Attribute");
            _aggregateNamespaces.Add("AttributeSet", "Dddml.Wms.Domain.AttributeSet");
            _aggregateNamespaces.Add("ContactMech", "Dddml.Wms.Domain.ContactMech");
            _aggregateNamespaces.Add("DamageHandlingMethod", "Dddml.Wms.Domain.DamageHandlingMethod");
            _aggregateNamespaces.Add("DamageReason", "Dddml.Wms.Domain.DamageReason");
            _aggregateNamespaces.Add("DamageType", "Dddml.Wms.Domain.DamageType");
            _aggregateNamespaces.Add("DocumentType", "Dddml.Wms.Domain.DocumentType");
            _aggregateNamespaces.Add("Facility", "Dddml.Wms.Domain.Facility");
            _aggregateNamespaces.Add("GoodIdentificationType", "Dddml.Wms.Domain.GoodIdentificationType");
            _aggregateNamespaces.Add("InOut", "Dddml.Wms.Domain.InOut");
            _aggregateNamespaces.Add("InventoryItem", "Dddml.Wms.Domain.InventoryItem");
            _aggregateNamespaces.Add("InventoryItemRequirement", "Dddml.Wms.Domain.InventoryItemRequirement");
            _aggregateNamespaces.Add("InventoryPostingRule", "Dddml.Wms.Domain.InventoryPostingRule");
            _aggregateNamespaces.Add("InventoryPRTriggered", "Dddml.Wms.Domain.InventoryPRTriggered");
            _aggregateNamespaces.Add("Locator", "Dddml.Wms.Domain.Locator");
            _aggregateNamespaces.Add("LocatorType", "Dddml.Wms.Domain.LocatorType");
            _aggregateNamespaces.Add("Lot", "Dddml.Wms.Domain.Lot");
            _aggregateNamespaces.Add("Movement", "Dddml.Wms.Domain.Movement");
            _aggregateNamespaces.Add("MovementConfirmation", "Dddml.Wms.Domain.MovementConfirmation");
            _aggregateNamespaces.Add("MovementType", "Dddml.Wms.Domain.MovementType");
            _aggregateNamespaces.Add("Order", "Dddml.Wms.Domain.Order");
            _aggregateNamespaces.Add("OrderItemShipGrpInvReservation", "Dddml.Wms.Domain.OrderItemShipGrpInvReservation");
            _aggregateNamespaces.Add("OrderShipment", "Dddml.Wms.Domain.OrderShipment");
            _aggregateNamespaces.Add("OrganizationStructure", "Dddml.Wms.Domain.OrganizationStructure");
            _aggregateNamespaces.Add("OrganizationStructureType", "Dddml.Wms.Domain.OrganizationStructureType");
            _aggregateNamespaces.Add("Party", "Dddml.Wms.Domain.Party");
            _aggregateNamespaces.Add("PartyRole", "Dddml.Wms.Domain.PartyRole");
            _aggregateNamespaces.Add("PhysicalInventory", "Dddml.Wms.Domain.PhysicalInventory");
            _aggregateNamespaces.Add("Picklist", "Dddml.Wms.Domain.Picklist");
            _aggregateNamespaces.Add("PicklistBin", "Dddml.Wms.Domain.PicklistBin");
            _aggregateNamespaces.Add("Pickwave", "Dddml.Wms.Domain.Pickwave");
            _aggregateNamespaces.Add("Product", "Dddml.Wms.Domain.Product");
            _aggregateNamespaces.Add("ProductCategory", "Dddml.Wms.Domain.ProductCategory");
            _aggregateNamespaces.Add("ProductCategoryMember", "Dddml.Wms.Domain.ProductCategoryMember");
            _aggregateNamespaces.Add("RejectionReason", "Dddml.Wms.Domain.RejectionReason");
            _aggregateNamespaces.Add("RoleType", "Dddml.Wms.Domain.RoleType");
            _aggregateNamespaces.Add("SellableInventoryItem", "Dddml.Wms.Domain.SellableInventoryItem");
            _aggregateNamespaces.Add("Shipment", "Dddml.Wms.Domain.Shipment");
            _aggregateNamespaces.Add("ShipmentMethodType", "Dddml.Wms.Domain.ShipmentMethodType");
            _aggregateNamespaces.Add("ShipmentPackage", "Dddml.Wms.Domain.ShipmentPackage");
            _aggregateNamespaces.Add("ShipmentType", "Dddml.Wms.Domain.ShipmentType");
            _aggregateNamespaces.Add("StatusItem", "Dddml.Wms.Domain.StatusItem");
            _aggregateNamespaces.Add("SupplierProduct", "Dddml.Wms.Domain.SupplierProduct");
            _aggregateNamespaces.Add("Uom", "Dddml.Wms.Domain.Uom");
            _aggregateNamespaces.Add("UomConversion", "Dddml.Wms.Domain.UomConversion");
            _aggregateNamespaces.Add("UomType", "Dddml.Wms.Domain.UomType");
            _aggregateNamespaces.Add("Warehouse", "Dddml.Wms.Domain.Warehouse");
            _aggregateNamespaces.Add("AttributeSetInstance", "Dddml.Wms.Domain.AttributeSetInstance");
            _aggregateNamespaces.Add("AttributeSetInstanceExtensionField", "Dddml.Wms.Domain.AttributeSetInstanceExtensionField");
            _aggregateNamespaces.Add("AttributeSetInstanceExtensionFieldGroup", "Dddml.Wms.Domain.AttributeSetInstanceExtensionFieldGroup");
        }

    }
}

