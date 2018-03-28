
    drop table if exists Hello;

    drop table if exists Attributes;

    drop table if exists AttributeStateEvents;

    drop table if exists AttributeValues;

    drop table if exists AttributeValueStateEvents;

    drop table if exists AttributeAlias;

    drop table if exists AttributeAliasStateEvents;

    drop table if exists AttributeSets;

    drop table if exists AttributeSetStateEvents;

    drop table if exists AttributeUses;

    drop table if exists AttributeUseStateEvents;

    drop table if exists DamageReasons;

    drop table if exists DamageReasonStateEvents;

    drop table if exists DamageTypes;

    drop table if exists DamageHandlingMethods;

    drop table if exists DocumentTypes;

    drop table if exists ContactMeches;

    drop table if exists ContactMechStateEvents;

    drop table if exists Facilities;

    drop table if exists FacilityStateEvents;

    drop table if exists AttributeSetInstances;

    drop table if exists AttributeSetInstanceExtensionFields;

    drop table if exists AttributeSetInstanceExtensionFieldStateEvents;

    drop table if exists AttributeSetInstanceExtensionFieldGroups;

    drop table if exists AttributeSetInstanceExtensionFieldGroupStateEvents;

    drop table if exists AttributeValue_RV;

    drop table if exists AttributeValueMvoStateEvents;

    drop table if exists AttributeAlias_RV;

    drop table if exists AttributeAliasMvoStateEvents;

    drop table if exists AttributeUse_RV;

    drop table if exists AttributeUseMvoStateEvents;

    drop table if exists InOuts;

    drop table if exists InOutStateEvents;

    drop table if exists InOutLines;

    drop table if exists InOutLineStateEvents;

    drop table if exists InventoryItems;

    drop table if exists InventoryItemStateEvents;

    drop table if exists InventoryItemEntries;

    drop table if exists InventoryItemRequirements;

    drop table if exists InventoryItemRequirementEntries;

    drop table if exists InventoryPostingRules;

    drop table if exists InventoryPostingRuleStateEvents;

    drop table if exists InventoryPRTriggereds;

    drop table if exists Lots;

    drop table if exists LotStateEvents;

    drop table if exists Movements;

    drop table if exists MovementStateEvents;

    drop table if exists MovementLines;

    drop table if exists MovementLineStateEvents;

    drop table if exists MovementConfirmations;

    drop table if exists MovementConfirmationStateEvents;

    drop table if exists MovementConfirmationLines;

    drop table if exists MovementConfirmationLineStateEvents;

    drop table if exists MovementTypes;

    drop table if exists Orders;

    drop table if exists OrderStateEvents;

    drop table if exists OrderItems;

    drop table if exists OrderItemStateEvents;

    drop table if exists OrderShipments;

    drop table if exists OrderShipmentStateEvents;

    drop table if exists OrganizationStructures;

    drop table if exists OrganizationStructureStateEvents;

    drop table if exists OrganizationStructureTypes;

    drop table if exists OrganizationStructureTypeStateEvents;

    drop table if exists Parties;

    drop table if exists Organizations;

    drop table if exists PartyStateEvents;

    drop table if exists PhysicalInventories;

    drop table if exists PhysicalInventoryStateEvents;

    drop table if exists PhysicalInventoryLines;

    drop table if exists PhysicalInventoryLineStateEvents;

    drop table if exists Locators;

    drop table if exists LocatorStateEvents;

    drop table if exists OrderRoles;

    drop table if exists OrderRoleStateEvents;

    drop table if exists OrderShipGroups;

    drop table if exists OrderShipGroupStateEvents;

    drop table if exists PartyRoles;

    drop table if exists PartyRoleStateEvents;

    drop table if exists Picklists;

    drop table if exists PicklistStateEvents;

    drop table if exists PicklistRoles;

    drop table if exists PicklistRoleStateEvents;

    drop table if exists PicklistBins;

    drop table if exists PicklistBinStateEvents;

    drop table if exists PicklistItems;

    drop table if exists PicklistItemStateEvents;

    drop table if exists Products;

    drop table if exists ProductStateEvents;

    drop table if exists ProductCategories;

    drop table if exists ProductCategoryStateEvents;

    drop table if exists ProductCategoryMembers;

    drop table if exists ProductCategoryMemberStateEvents;

    drop table if exists RejectionReasons;

    drop table if exists RejectionReasonStateEvents;

    drop table if exists RoleTypes;

    drop table if exists RoleTypeStateEvents;

    drop table if exists SellableInventoryItems;

    drop table if exists SellableInventoryItemEntries;

    drop table if exists Shipments;

    drop table if exists ShipmentStateEvents;

    drop table if exists ShipmentItems;

    drop table if exists ShipmentItemStateEvents;

    drop table if exists ShipmentReceipts;

    drop table if exists ShipmentReceiptStateEvents;

    drop table if exists ItemIssuances;

    drop table if exists ItemIssuanceStateEvents;

    drop table if exists ShipmentMethodTypes;

    drop table if exists ShipmentMethodTypeStateEvents;

    drop table if exists ShipmentPackages;

    drop table if exists ShipmentPackageStateEvents;

    drop table if exists ShipmentPackageContents;

    drop table if exists ShipmentPackageContentStateEvents;

    drop table if exists ShipmentTypes;

    drop table if exists StatusItems;

    drop table if exists SupplierProducts;

    drop table if exists SupplierProductStateEvents;

    drop table if exists Uoms;

    drop table if exists UomStateEvents;

    drop table if exists UomConversions;

    drop table if exists UomConversionStateEvents;

    drop table if exists UomTypes;

    drop table if exists Warehouses;

    drop table if exists WarehouseStateEvents;

    drop table if exists InOutLine_RV;

    drop table if exists InOutLineMvoStateEvents;

    drop table if exists InventoryItemEntry_RV;

    drop table if exists InventoryItemEntryMvoStateEvents;

    drop table if exists InventoryItemRequirementEntry_RV;

    drop table if exists InventoryItemRequirementEntryMvoStateEvents;

    drop table if exists MovementLine_RV;

    drop table if exists MovementLineMvoStateEvents;

    drop table if exists MovementConfirmationLine_RV;

    drop table if exists MovementConfirmationLineMvoStateEvents;

    drop table if exists OrderRole_RV;

    drop table if exists OrderRoleMvoStateEvents;

    drop table if exists OrderItem_RV;

    drop table if exists OrderItemMvoStateEvents;

    drop table if exists OrderShipGroup_RV;

    drop table if exists OrderShipGroupMvoStateEvents;

    drop table if exists PhysicalInventoryLine_RV;

    drop table if exists PhysicalInventoryLineMvoStateEvents;

    drop table if exists PicklistRole_RV;

    drop table if exists PicklistRoleMvoStateEvents;

    drop table if exists PicklistItem_RV;

    drop table if exists PicklistItemMvoStateEvents;

    drop table if exists SellableInventoryItemEntry_RV;

    drop table if exists SellableInventoryItemEntryMvoStateEvents;

    drop table if exists ShipmentItem_RV;

    drop table if exists ShipmentItemMvoStateEvents;

    drop table if exists ShipmentReceipt_RV;

    drop table if exists ShipmentReceiptMvoStateEvents;

    drop table if exists ItemIssuance_RV;

    drop table if exists ItemIssuanceMvoStateEvents;

    drop table if exists ShipmentPackageContent_RV;

    drop table if exists ShipmentPackageContentMvoStateEvents;

    drop table if exists OrderItemShipGrpInvReservations;

    drop table if exists OrderItemShipGrpInvReservationStateEvents;

    drop table if exists LocatorTypes;

    drop table if exists LocatorTypeStateEvents;

    drop table if exists Pickwaves;

    drop table if exists PickwaveStateEvents;

    drop table if exists OrderItemShipGroupAssociations;

    drop table if exists OrderItemShipGroupAssociationStateEvents;

    drop table if exists OrderItemShipGroupAssociation_RV;

    drop table if exists OrderItemShipGroupAssociationMvoStateEvents;

    drop table if exists nhibernate_hilo_table;
