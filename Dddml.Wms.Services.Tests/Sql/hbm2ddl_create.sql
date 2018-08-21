
    
alter table AttributeSetInstanceStatusIds  drop foreign key FK6CFC352E46B90463
;

    
alter table InOutLineDamageStatusIds  drop foreign key FK9F1B674E77BC4BCB
;

    
alter table ShipmentReceiptDamageStatusIds  drop foreign key FKB9FCE6E151B2BEEA
;

    
alter table InOutLineStateEventDamageStatusIds  drop foreign key FK5BAF3ED4782FA244
;

    
alter table ShipmentReceiptStateEventDamageStatusIds  drop foreign key FK4AE85BEE4BB9F015
;

    drop table if exists Hello;

    drop table if exists Attributes;

    drop table if exists AttributeValues;

    drop table if exists AttributeAlias;

    drop table if exists AttributeSets;

    drop table if exists AttributeUses;

    drop table if exists DamageReasons;

    drop table if exists DamageTypes;

    drop table if exists DamageHandlingMethods;

    drop table if exists DocumentTypes;

    drop table if exists ContactMeches;

    drop table if exists Facilities;

    drop table if exists AttributeSetInstances;

    drop table if exists AttributeSetInstanceStatusIds;

    drop table if exists AttributeSetInstanceExtensionFields;

    drop table if exists AttributeSetInstanceExtensionFieldGroups;

    drop table if exists AttributeEvents;

    drop table if exists AttributeValueEvents;

    drop table if exists AttributeAliasEvents;

    drop table if exists AttributeSetEvents;

    drop table if exists AttributeUseEvents;

    drop table if exists ContactMechEvents;

    drop table if exists DamageReasonEvents;

    drop table if exists FacilityEvents;

    drop table if exists AttributeSetInstanceExtensionFieldEvents;

    drop table if exists AttributeSetInstanceExtensionFieldGroupEvents;

    drop table if exists InOuts;

    drop table if exists InOutLines;

    drop table if exists InOutLineDamageStatusIds;

    drop table if exists InventoryItems;

    drop table if exists InventoryItemEntries;

    drop table if exists InventoryItemRequirements;

    drop table if exists InventoryItemRequirementEntries;

    drop table if exists InventoryPostingRules;

    drop table if exists InventoryPRTriggereds;

    drop table if exists Lots;

    drop table if exists Movements;

    drop table if exists MovementLines;

    drop table if exists MovementConfirmations;

    drop table if exists MovementConfirmationLines;

    drop table if exists MovementTypes;

    drop table if exists Orders;

    drop table if exists OrderItems;

    drop table if exists OrderShipments;

    drop table if exists OrganizationStructures;

    drop table if exists OrganizationStructureTypes;

    drop table if exists Parties;

    drop table if exists Organizations;

    drop table if exists People;

    drop table if exists PhysicalInventories;

    drop table if exists PhysicalInventoryLines;

    drop table if exists Locators;

    drop table if exists OrderRoles;

    drop table if exists OrderShipGroups;

    drop table if exists PartyRoles;

    drop table if exists Picklists;

    drop table if exists PicklistRoles;

    drop table if exists PicklistBins;

    drop table if exists PicklistItems;

    drop table if exists Products;

    drop table if exists ProductCategories;

    drop table if exists ProductCategoryMembers;

    drop table if exists RejectionReasons;

    drop table if exists RoleTypes;

    drop table if exists SellableInventoryItems;

    drop table if exists SellableInventoryItemEntries;

    drop table if exists Shipments;

    drop table if exists ShipmentItems;

    drop table if exists ShipmentReceipts;

    drop table if exists ShipmentReceiptDamageStatusIds;

    drop table if exists ItemIssuances;

    drop table if exists ShipmentMethodTypes;

    drop table if exists ShipmentPackages;

    drop table if exists ShipmentPackageContents;

    drop table if exists ShipmentTypes;

    drop table if exists StatusItems;

    drop table if exists SupplierProducts;

    drop table if exists Uoms;

    drop table if exists UomConversions;

    drop table if exists UomTypes;

    drop table if exists Warehouses;

    drop table if exists OrderItemShipGrpInvReservations;

    drop table if exists LocatorTypes;

    drop table if exists Pickwaves;

    drop table if exists OrderItemShipGroupAssociations;

    drop table if exists InOutEvents;

    drop table if exists InOutLineEvents;

    drop table if exists InOutLineStateEventDamageStatusIds;

    drop table if exists InventoryItemEvents;

    drop table if exists InventoryPostingRuleEvents;

    drop table if exists LocatorEvents;

    drop table if exists LocatorTypeEvents;

    drop table if exists LotEvents;

    drop table if exists MovementEvents;

    drop table if exists MovementLineEvents;

    drop table if exists MovementConfirmationEvents;

    drop table if exists MovementConfirmationLineEvents;

    drop table if exists OrderEvents;

    drop table if exists OrderRoleEvents;

    drop table if exists OrderItemEvents;

    drop table if exists OrderShipGroupEvents;

    drop table if exists OrderItemShipGroupAssociationEvents;

    drop table if exists OrderItemShipGrpInvReservationEvents;

    drop table if exists OrderShipmentEvents;

    drop table if exists OrganizationStructureEvents;

    drop table if exists OrganizationStructureTypeEvents;

    drop table if exists PartyEvents;

    drop table if exists PartyRoleEvents;

    drop table if exists PhysicalInventoryEvents;

    drop table if exists PhysicalInventoryLineEvents;

    drop table if exists PicklistEvents;

    drop table if exists PicklistRoleEvents;

    drop table if exists PicklistBinEvents;

    drop table if exists PicklistItemEvents;

    drop table if exists PickwaveEvents;

    drop table if exists ProductEvents;

    drop table if exists ProductCategoryEvents;

    drop table if exists ProductCategoryMemberEvents;

    drop table if exists RejectionReasonEvents;

    drop table if exists RoleTypeEvents;

    drop table if exists ShipmentEvents;

    drop table if exists ShipmentItemEvents;

    drop table if exists ShipmentReceiptEvents;

    drop table if exists ShipmentReceiptStateEventDamageStatusIds;

    drop table if exists ItemIssuanceEvents;

    drop table if exists ShipmentMethodTypeEvents;

    drop table if exists ShipmentPackageEvents;

    drop table if exists ShipmentPackageContentEvents;

    drop table if exists SupplierProductEvents;

    drop table if exists UomEvents;

    drop table if exists UomConversionEvents;

    drop table if exists WarehouseEvents;

    drop table if exists GoodIdentificationTypes;

    drop table if exists GoodIdentificationTypeEvents;

    drop table if exists GoodIdentifications;

    drop table if exists GoodIdentificationEvents;

    drop table if exists InOutImages;

    drop table if exists InOutImageEvents;

    drop table if exists InOutLineImages;

    drop table if exists InOutLineImageEvents;

    drop table if exists ShipmentImages;

    drop table if exists ShipmentImageEvents;

    drop table if exists ShipmentReceiptImages;

    drop table if exists ShipmentReceiptImageEvents;

    drop table if exists nhibernate_hilo_table;

    create table Hello (
        Id BIGINT not null,
       Message VARCHAR(255),
       primary key (Id)
    );

    create table Attributes (
        AttributeId VARCHAR(50) not null,
       Version BIGINT not null,
       AttributeName VARCHAR(255),
       OrganizationId VARCHAR(255),
       Description VARCHAR(255),
       IsMandatory TINYINT(1),
       AttributeValueType VARCHAR(255),
       AttributeValueLength INTEGER,
       IsList TINYINT(1),
       FieldName VARCHAR(255),
       ReferenceId VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (AttributeId),
      unique (FieldName)
    );

    create table AttributeValues (
        AttributeValueIdAttributeId VARCHAR(50) not null,
       AttributeValueIdValue VARCHAR(50) not null,
       Version BIGINT not null,
       AttributeValueName VARCHAR(255),
       Description VARCHAR(255),
       ReferenceId VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (AttributeValueIdAttributeId, AttributeValueIdValue)
    );

    create table AttributeAlias (
        AttributeAliasIdAttributeId VARCHAR(50) not null,
       AttributeAliasIdCode VARCHAR(50) not null,
       Version BIGINT not null,
       Name VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (AttributeAliasIdAttributeId, AttributeAliasIdCode),
      unique (AttributeAliasIdCode),
      unique (Name)
    );

    create table AttributeSets (
        AttributeSetId VARCHAR(50) not null,
       Version BIGINT not null,
       AttributeSetName VARCHAR(255),
       OrganizationId VARCHAR(255),
       Description VARCHAR(255),
       ReferenceId VARCHAR(255),
       IsInstanceAttributeSet TINYINT(1),
       IsMandatory TINYINT(1),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (AttributeSetId)
    );

    create table AttributeUses (
        AttributeSetAttributeUseIdAttributeSetId VARCHAR(50) not null,
       AttributeSetAttributeUseIdAttributeId VARCHAR(50) not null,
       Version BIGINT not null,
       SequenceNumber INTEGER,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (AttributeSetAttributeUseIdAttributeSetId, AttributeSetAttributeUseIdAttributeId)
    );

    create table DamageReasons (
        DamageReasonId VARCHAR(60) not null,
       Version BIGINT not null,
       Description VARCHAR(255),
       SequenceId VARCHAR(20),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (DamageReasonId)
    );

    create table DamageTypes (
        DamageTypeId VARCHAR(60) not null,
       Version BIGINT not null,
       Description VARCHAR(255) not null,
       SequenceId VARCHAR(20),
       DefaultHandlingMethodId VARCHAR(60),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       CommandId VARCHAR(255),
       primary key (DamageTypeId)
    );

    create table DamageHandlingMethods (
        DamageHandlingMethodId VARCHAR(60) not null,
       Version BIGINT not null,
       Description VARCHAR(255) not null,
       SequenceId VARCHAR(20),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       CommandId VARCHAR(255),
       primary key (DamageHandlingMethodId)
    );

    create table DocumentTypes (
        DocumentTypeId VARCHAR(50) not null,
       Version BIGINT not null,
       Description VARCHAR(255) not null,
       ParentDocumentTypeId VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       CommandId VARCHAR(255),
       primary key (DocumentTypeId)
    );

    create table ContactMeches (
        ContactMechId VARCHAR(20) not null,
       Version BIGINT not null,
       ContactMechTypeId VARCHAR(20),
       InfoString VARCHAR(255),
       ToName VARCHAR(100),
       AttnName VARCHAR(100),
       Address1 VARCHAR(255),
       Address2 VARCHAR(255),
       Directions VARCHAR(255),
       City VARCHAR(100),
       PostalCode VARCHAR(60),
       PostalCodeExt VARCHAR(60),
       CountryGeoId VARCHAR(20),
       StateProvinceGeoId VARCHAR(20),
       CountyGeoId VARCHAR(20),
       PostalCodeGeoId VARCHAR(20),
       GeoPointId VARCHAR(20),
       CountryCode VARCHAR(10),
       AreaCode VARCHAR(10),
       ContactNumber VARCHAR(60),
       AskForName VARCHAR(100),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ContactMechId)
    );

    create table Facilities (
        FacilityId VARCHAR(20) not null,
       Version BIGINT not null,
       FacilityTypeId VARCHAR(20),
       ParentFacilityId VARCHAR(20),
       OwnerPartyId VARCHAR(20),
       DefaultInventoryItemTypeId VARCHAR(20),
       FacilityName VARCHAR(100),
       PrimaryFacilityGroupId VARCHAR(20),
       OldSquareFootage DECIMAL(20,0),
       FacilitySize DECIMAL(18,6),
       FacilitySizeUomId VARCHAR(20),
       ProductStoreId VARCHAR(20),
       DefaultDaysToShip DECIMAL(20,0),
       OpenedDate DATETIME,
       ClosedDate DATETIME,
       Description VARCHAR(255),
       DefaultDimensionUomId VARCHAR(20),
       DefaultWeightUomId VARCHAR(20),
       GeoPointId VARCHAR(20),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (FacilityId)
    );

    create table AttributeSetInstances (
        AttributeSetInstanceId VARCHAR(50) not null,
       Version BIGINT not null,
       AttributeSetId VARCHAR(255),
       OrganizationId VARCHAR(255),
       ReferenceId VARCHAR(255),
       SerialNumber VARCHAR(255),
       LotId VARCHAR(255),
       ImageUrl VARCHAR(255),
       Description VARCHAR(255),
       Hash VARCHAR(255),
       WidthInch decimal(18,6),
       DiameterInch decimal(18,6),
       WeightLbs decimal(18,6),
       WeightKg decimal(18,6),
       AirDryWeightLbs decimal(18,6),
       AirDryWeightKg decimal(18,6),
       AirDryMetricTon decimal(18,6),
       RollCnt INTEGER,
       AirDryPct decimal(18,6),
       _F_B_0_ TINYINT(1),
       _F_I_0_ INTEGER,
       _F_L_0_ BIGINT,
       _F_DT_0_ DATETIME,
       _F_N_0_ decimal(18,6),
       _F_C5_0_ VARCHAR(5),
       _F_C10_0_ VARCHAR(10),
       _F_C20_0_ VARCHAR(20),
       _F_C50_0_ VARCHAR(50),
       _F_C100_0_ VARCHAR(100),
       _F_C200_0_ VARCHAR(200),
       _F_C500_0_ TEXT,
       _F_C1000_0_ TEXT,
       _F_B_1_ TINYINT(1),
       _F_I_1_ INTEGER,
       _F_L_1_ BIGINT,
       _F_DT_1_ DATETIME,
       _F_N_1_ decimal(18,6),
       _F_C5_1_ VARCHAR(5),
       _F_C10_1_ VARCHAR(10),
       _F_C20_1_ VARCHAR(20),
       _F_C50_1_ VARCHAR(50),
       _F_C100_1_ VARCHAR(100),
       _F_C200_1_ VARCHAR(200),
       _F_B_2_ TINYINT(1),
       _F_I_2_ INTEGER,
       _F_L_2_ BIGINT,
       _F_DT_2_ DATETIME,
       _F_N_2_ decimal(18,6),
       _F_C5_2_ VARCHAR(5),
       _F_C10_2_ VARCHAR(10),
       _F_C20_2_ VARCHAR(20),
       _F_C50_2_ VARCHAR(50),
       _F_B_3_ TINYINT(1),
       _F_I_3_ INTEGER,
       _F_L_3_ BIGINT,
       _F_DT_3_ DATETIME,
       _F_N_3_ decimal(18,6),
       _F_C5_3_ VARCHAR(5),
       _F_C10_3_ VARCHAR(10),
       _F_C20_3_ VARCHAR(20),
       _F_C50_3_ VARCHAR(50),
       _F_B_4_ TINYINT(1),
       _F_I_4_ INTEGER,
       _F_L_4_ BIGINT,
       _F_DT_4_ DATETIME,
       _F_N_4_ decimal(18,6),
       _F_C5_4_ VARCHAR(5),
       _F_C10_4_ VARCHAR(10),
       _F_C20_4_ VARCHAR(20),
       _F_C50_4_ VARCHAR(50),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       CommandId VARCHAR(255),
       primary key (AttributeSetInstanceId)
    );

    create table AttributeSetInstanceStatusIds (
        AttributeSetInstanceId VARCHAR(50) not null,
       StatusIdsItem VARCHAR(255) not null,
       primary key (AttributeSetInstanceId, StatusIdsItem)
    );

    create table AttributeSetInstanceExtensionFields (
        Name VARCHAR(50) not null,
       Version BIGINT not null,
       Type VARCHAR(255),
       Length INTEGER,
       Alias VARCHAR(255),
       Description VARCHAR(255),
       GroupId VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (Name),
      unique (Alias)
    );

    create table AttributeSetInstanceExtensionFieldGroups (
        Id VARCHAR(50) not null,
       Version BIGINT not null,
       FieldType VARCHAR(255),
       FieldLength INTEGER,
       FieldCount INTEGER,
       NameFormat VARCHAR(255),
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (Id)
    );

    create table AttributeEvents (
        AttributeId VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       AttributeName VARCHAR(255),
       OrganizationId VARCHAR(255),
       Description VARCHAR(255),
       IsMandatory TINYINT(1),
       AttributeValueType VARCHAR(255),
       AttributeValueLength INTEGER,
       IsList TINYINT(1),
       FieldName VARCHAR(255),
       ReferenceId VARCHAR(255),
       Active TINYINT(1),
       IsPropertyAttributeNameRemoved TINYINT(1),
       IsPropertyOrganizationIdRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyIsMandatoryRemoved TINYINT(1),
       IsPropertyAttributeValueTypeRemoved TINYINT(1),
       IsPropertyAttributeValueLengthRemoved TINYINT(1),
       IsPropertyIsListRemoved TINYINT(1),
       IsPropertyFieldNameRemoved TINYINT(1),
       IsPropertyReferenceIdRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (AttributeId, Version),
      unique (FieldName)
    );

    create table AttributeValueEvents (
        AttributeValueIdAttributeId VARCHAR(50) not null,
       AttributeValueIdValue VARCHAR(50) not null,
       AttributeVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       AttributeValueName VARCHAR(255),
       Description VARCHAR(255),
       ReferenceId VARCHAR(255),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyAttributeValueNameRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyReferenceIdRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (AttributeValueIdAttributeId, AttributeValueIdValue, AttributeVersion)
    );

    create table AttributeAliasEvents (
        AttributeAliasIdAttributeId VARCHAR(50) not null,
       AttributeAliasIdCode VARCHAR(50) not null,
       AttributeVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Name VARCHAR(255),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyNameRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (AttributeAliasIdAttributeId, AttributeAliasIdCode, AttributeVersion),
      unique (Name)
    );

    create table AttributeSetEvents (
        AttributeSetId VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       AttributeSetName VARCHAR(255),
       OrganizationId VARCHAR(255),
       Description VARCHAR(255),
       ReferenceId VARCHAR(255),
       IsInstanceAttributeSet TINYINT(1),
       IsMandatory TINYINT(1),
       Active TINYINT(1),
       IsPropertyAttributeSetNameRemoved TINYINT(1),
       IsPropertyOrganizationIdRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyReferenceIdRemoved TINYINT(1),
       IsPropertyIsInstanceAttributeSetRemoved TINYINT(1),
       IsPropertyIsMandatoryRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (AttributeSetId, Version)
    );

    create table AttributeUseEvents (
        AttributeSetAttributeUseIdAttributeSetId VARCHAR(50) not null,
       AttributeSetAttributeUseIdAttributeId VARCHAR(50) not null,
       AttributeSetVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       SequenceNumber INTEGER,
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertySequenceNumberRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (AttributeSetAttributeUseIdAttributeSetId, AttributeSetAttributeUseIdAttributeId, AttributeSetVersion)
    );

    create table ContactMechEvents (
        ContactMechId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ContactMechTypeId VARCHAR(20),
       InfoString VARCHAR(255),
       ToName VARCHAR(100),
       AttnName VARCHAR(100),
       Address1 VARCHAR(255),
       Address2 VARCHAR(255),
       Directions VARCHAR(255),
       City VARCHAR(100),
       PostalCode VARCHAR(60),
       PostalCodeExt VARCHAR(60),
       CountryGeoId VARCHAR(20),
       StateProvinceGeoId VARCHAR(20),
       CountyGeoId VARCHAR(20),
       PostalCodeGeoId VARCHAR(20),
       GeoPointId VARCHAR(20),
       CountryCode VARCHAR(10),
       AreaCode VARCHAR(10),
       ContactNumber VARCHAR(60),
       AskForName VARCHAR(100),
       Active TINYINT(1),
       IsPropertyContactMechTypeIdRemoved TINYINT(1),
       IsPropertyInfoStringRemoved TINYINT(1),
       IsPropertyToNameRemoved TINYINT(1),
       IsPropertyAttnNameRemoved TINYINT(1),
       IsPropertyAddress1Removed TINYINT(1),
       IsPropertyAddress2Removed TINYINT(1),
       IsPropertyDirectionsRemoved TINYINT(1),
       IsPropertyCityRemoved TINYINT(1),
       IsPropertyPostalCodeRemoved TINYINT(1),
       IsPropertyPostalCodeExtRemoved TINYINT(1),
       IsPropertyCountryGeoIdRemoved TINYINT(1),
       IsPropertyStateProvinceGeoIdRemoved TINYINT(1),
       IsPropertyCountyGeoIdRemoved TINYINT(1),
       IsPropertyPostalCodeGeoIdRemoved TINYINT(1),
       IsPropertyGeoPointIdRemoved TINYINT(1),
       IsPropertyCountryCodeRemoved TINYINT(1),
       IsPropertyAreaCodeRemoved TINYINT(1),
       IsPropertyContactNumberRemoved TINYINT(1),
       IsPropertyAskForNameRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ContactMechId, Version)
    );

    create table DamageReasonEvents (
        DamageReasonId VARCHAR(60) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Description VARCHAR(255),
       SequenceId VARCHAR(20),
       Active TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertySequenceIdRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (DamageReasonId, Version)
    );

    create table FacilityEvents (
        FacilityId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       FacilityTypeId VARCHAR(20),
       ParentFacilityId VARCHAR(20),
       OwnerPartyId VARCHAR(20),
       DefaultInventoryItemTypeId VARCHAR(20),
       FacilityName VARCHAR(100),
       PrimaryFacilityGroupId VARCHAR(20),
       OldSquareFootage DECIMAL(20,0),
       FacilitySize DECIMAL(18,6),
       FacilitySizeUomId VARCHAR(20),
       ProductStoreId VARCHAR(20),
       DefaultDaysToShip DECIMAL(20,0),
       OpenedDate DATETIME,
       ClosedDate DATETIME,
       Description VARCHAR(255),
       DefaultDimensionUomId VARCHAR(20),
       DefaultWeightUomId VARCHAR(20),
       GeoPointId VARCHAR(20),
       Active TINYINT(1),
       IsPropertyFacilityTypeIdRemoved TINYINT(1),
       IsPropertyParentFacilityIdRemoved TINYINT(1),
       IsPropertyOwnerPartyIdRemoved TINYINT(1),
       IsPropertyDefaultInventoryItemTypeIdRemoved TINYINT(1),
       IsPropertyFacilityNameRemoved TINYINT(1),
       IsPropertyPrimaryFacilityGroupIdRemoved TINYINT(1),
       IsPropertyOldSquareFootageRemoved TINYINT(1),
       IsPropertyFacilitySizeRemoved TINYINT(1),
       IsPropertyFacilitySizeUomIdRemoved TINYINT(1),
       IsPropertyProductStoreIdRemoved TINYINT(1),
       IsPropertyDefaultDaysToShipRemoved TINYINT(1),
       IsPropertyOpenedDateRemoved TINYINT(1),
       IsPropertyClosedDateRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyDefaultDimensionUomIdRemoved TINYINT(1),
       IsPropertyDefaultWeightUomIdRemoved TINYINT(1),
       IsPropertyGeoPointIdRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (FacilityId, Version)
    );

    create table AttributeSetInstanceExtensionFieldEvents (
        Name VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Type VARCHAR(255),
       Length INTEGER,
       Alias VARCHAR(255),
       Description VARCHAR(255),
       GroupId VARCHAR(255),
       Active TINYINT(1),
       IsPropertyTypeRemoved TINYINT(1),
       IsPropertyLengthRemoved TINYINT(1),
       IsPropertyAliasRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyGroupIdRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (Name, Version),
      unique (Alias)
    );

    create table AttributeSetInstanceExtensionFieldGroupEvents (
        Id VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       FieldType VARCHAR(255),
       FieldLength INTEGER,
       FieldCount INTEGER,
       NameFormat VARCHAR(255),
       Description VARCHAR(255),
       Active TINYINT(1),
       IsPropertyFieldTypeRemoved TINYINT(1),
       IsPropertyFieldLengthRemoved TINYINT(1),
       IsPropertyFieldCountRemoved TINYINT(1),
       IsPropertyNameFormatRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (Id, Version)
    );

    create table InOuts (
        DocumentNumber VARCHAR(50) not null,
       Version BIGINT not null,
       DocumentStatusId VARCHAR(255),
       Posted TINYINT(1),
       Processed TINYINT(1),
       Processing VARCHAR(255),
       DocumentTypeId VARCHAR(255),
       Description VARCHAR(255),
       OrderId VARCHAR(255),
       DateOrdered DATETIME,
       IsPrinted TINYINT(1),
       MovementTypeId VARCHAR(255),
       MovementDate DATETIME,
       BusinessPartnerId VARCHAR(255),
       WarehouseId VARCHAR(255),
       POReference VARCHAR(255),
       FreightAmount decimal(18,6),
       ShipperId VARCHAR(255),
       ChargeAmount decimal(18,6),
       DatePrinted DATETIME,
       CreatedFrom VARCHAR(255),
       SalesRepresentativeId VARCHAR(255),
       NumberOfPackages INTEGER,
       PickDate DATETIME,
       ShipDate DATETIME,
       TrackingNumber VARCHAR(255),
       DateReceived DATETIME,
       IsInTransit TINYINT(1),
       IsApproved TINYINT(1),
       IsInDispute TINYINT(1),
       RmaDocumentNumber VARCHAR(255),
       ReversalDocumentNumber VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (DocumentNumber)
    );

    create table InOutLines (
        InOutLineIdInOutDocumentNumber VARCHAR(50) not null,
       InOutLineIdLineNumber VARCHAR(50) not null,
       Version BIGINT not null,
       LocatorId VARCHAR(255),
       ProductId VARCHAR(60),
       AttributeSetInstanceId VARCHAR(255),
       Description VARCHAR(255),
       QuantityUomId VARCHAR(255),
       MovementQuantity decimal(18,6),
       PickedQuantity decimal(18,6),
       IsInvoiced TINYINT(1),
       Processed TINYINT(1),
       RmaLineNumber VARCHAR(255),
       ReversalLineNumber VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber)
    );

    create table InOutLineDamageStatusIds (
        InOutLineIdInOutDocumentNumber VARCHAR(50) not null,
       InOutLineIdLineNumber VARCHAR(50) not null,
       DamageStatusIdsItem VARCHAR(255) not null,
       primary key (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber, DamageStatusIdsItem)
    );

    create table InventoryItems (
        ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       Version BIGINT not null,
       OnHandQuantity decimal(18,6),
       InTransitQuantity decimal(18,6),
       ReservedQuantity decimal(18,6),
       OccupiedQuantity decimal(18,6),
       VirtualQuantity decimal(18,6),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ProductId, LocatorId, AttributeSetInstanceId)
    );

    create table InventoryItemEntries (
        ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       EntrySeqId BIGINT not null,
       Version BIGINT not null,
       OnHandQuantity decimal(18,6),
       InTransitQuantity decimal(18,6),
       ReservedQuantity decimal(18,6),
       OccupiedQuantity decimal(18,6),
       VirtualQuantity decimal(18,6),
       SourceDocumentTypeId VARCHAR(255) not null,
       SourceDocumentNumber VARCHAR(255) not null,
       SourceLineNumber VARCHAR(255),
       SourceLineSeqId INTEGER,
       OccurredAt DATETIME not null,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       CommandId VARCHAR(255),
       primary key (ProductId, LocatorId, AttributeSetInstanceId, EntrySeqId),
      unique (SourceDocumentTypeId, SourceDocumentNumber, SourceLineNumber, SourceLineSeqId)
    );

    create table InventoryItemRequirements (
        ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       Version BIGINT not null,
       Quantity decimal(18,6),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       CommandId VARCHAR(255),
       primary key (ProductId, LocatorId, AttributeSetInstanceId)
    );

    create table InventoryItemRequirementEntries (
        ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       EntrySeqId BIGINT not null,
       Version BIGINT not null,
       Quantity decimal(18,6),
       SrcEventProductId VARCHAR(60),
       SrcEventLocatorId VARCHAR(50),
       SrcEventAttributeSetInstanceId VARCHAR(50),
       SrcEventEntrySeqId BIGINT,
       SrcEventInventoryPostingRuleId VARCHAR(50),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       CommandId VARCHAR(255),
       primary key (ProductId, LocatorId, AttributeSetInstanceId, EntrySeqId),
      unique (SrcEventProductId, SrcEventLocatorId, SrcEventAttributeSetInstanceId, SrcEventEntrySeqId, SrcEventInventoryPostingRuleId)
    );

    create table InventoryPostingRules (
        InventoryPostingRuleId VARCHAR(50) not null,
       Version BIGINT not null,
       TriggerProductId VARCHAR(60),
       TriggerLocatorId VARCHAR(50),
       TriggerAttributeSetInstanceId VARCHAR(50),
       OutputProductId VARCHAR(60),
       OutputLocatorId VARCHAR(50),
       OutputAttributeSetInstanceId VARCHAR(50),
       TriggerAccountName VARCHAR(255),
       OutputAccountName VARCHAR(255),
       IsOutputNegated TINYINT(1),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (InventoryPostingRuleId)
    );

    create table InventoryPRTriggereds (
        ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       EntrySeqId BIGINT not null,
       InventoryPostingRuleId VARCHAR(50) not null,
       Version BIGINT not null,
       IsProcessed TINYINT(1) not null,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       CommandId VARCHAR(255),
       primary key (ProductId, LocatorId, AttributeSetInstanceId, EntrySeqId, InventoryPostingRuleId)
    );

    create table Lots (
        LotId VARCHAR(20) not null,
       Version BIGINT not null,
       Quantity DECIMAL(18,6),
       ExpirationDate DATETIME,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (LotId)
    );

    create table Movements (
        DocumentNumber VARCHAR(50) not null,
       Version BIGINT not null,
       DocumentStatusId VARCHAR(255),
       MovementDate DATETIME,
       Posted TINYINT(1),
       Processed TINYINT(1),
       Processing VARCHAR(255),
       DateReceived DATETIME,
       DocumentTypeId VARCHAR(255),
       IsInTransit TINYINT(1),
       IsApproved TINYINT(1),
       ApprovalAmount decimal(18,6),
       ShipperId VARCHAR(255),
       SalesRepresentativeId VARCHAR(255),
       BusinessPartnerId VARCHAR(255),
       ChargeAmount decimal(18,6),
       CreateFrom VARCHAR(255),
       FreightAmount decimal(18,6),
       ReversalDocumentNumber VARCHAR(255),
       WarehouseIdFrom VARCHAR(255),
       WarehouseIdTo VARCHAR(255),
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (DocumentNumber)
    );

    create table MovementLines (
        MovementLineIdMovementDocumentNumber VARCHAR(50) not null,
       MovementLineIdLineNumber VARCHAR(50) not null,
       Version BIGINT not null,
       MovementQuantity decimal(18,6),
       ProductId VARCHAR(60),
       LocatorIdFrom VARCHAR(255),
       LocatorIdTo VARCHAR(255),
       AttributeSetInstanceId VARCHAR(255),
       Processed TINYINT(1),
       ReversalLineNumber VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (MovementLineIdMovementDocumentNumber, MovementLineIdLineNumber)
    );

    create table MovementConfirmations (
        DocumentNumber VARCHAR(50) not null,
       Version BIGINT not null,
       DocumentStatusId VARCHAR(255),
       MovementDocumentNumber VARCHAR(255),
       IsApproved TINYINT(1),
       ApprovalAmount decimal(18,6),
       Processed TINYINT(1),
       Processing VARCHAR(255),
       DocumentTypeId VARCHAR(255),
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (DocumentNumber)
    );

    create table MovementConfirmationLines (
        MovementConfirmationLineIdMovementConfirmationDocumentNumber VARCHAR(50) not null,
       MovementConfirmationLineIdLineNumber VARCHAR(50) not null,
       Version BIGINT not null,
       MovementLineNumber VARCHAR(255),
       TargetQuantity decimal(18,6),
       ConfirmedQuantity decimal(18,6),
       DifferenceQuantity decimal(18,6),
       ScrappedQuantity decimal(18,6),
       Description VARCHAR(255),
       Processed TINYINT(1),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (MovementConfirmationLineIdMovementConfirmationDocumentNumber, MovementConfirmationLineIdLineNumber)
    );

    create table MovementTypes (
        MovementTypeId VARCHAR(50) not null,
       Version BIGINT not null,
       Description VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       CommandId VARCHAR(255),
       primary key (MovementTypeId)
    );

    create table Orders (
        OrderId VARCHAR(20) not null,
       Version BIGINT not null,
       OrderTypeId VARCHAR(20),
       OrderName VARCHAR(100),
       ExternalId VARCHAR(20),
       SalesChannelEnumId VARCHAR(20),
       OrderDate DATETIME,
       Priority CHAR(1),
       EntryDate DATETIME,
       PickSheetPrintedDate DATETIME,
       StatusId VARCHAR(20),
       CurrencyUomId VARCHAR(20),
       SyncStatusId VARCHAR(20),
       BillingAccountId VARCHAR(20),
       OriginFacilityId VARCHAR(20),
       WebSiteId VARCHAR(20),
       ProductStoreId VARCHAR(20),
       TerminalId VARCHAR(60),
       TransactionId VARCHAR(60),
       AutoOrderShoppingListId VARCHAR(20),
       NeedsInventoryIssuance CHAR(1),
       IsRushOrder CHAR(1),
       InternalCode VARCHAR(60),
       RemainingSubTotal DECIMAL(18,2),
       GrandTotal DECIMAL(18,2),
       InvoicePerShipment CHAR(1),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (OrderId)
    );

    create table OrderItems (
        OrderItemIdOrderId VARCHAR(20) not null,
       OrderItemIdOrderItemSeqId VARCHAR(20) not null,
       Version BIGINT not null,
       ProductId VARCHAR(60),
       ExternalProductId VARCHAR(60),
       Quantity DECIMAL(18,6),
       CancelQuantity DECIMAL(18,6),
       SelectedAmount DECIMAL(18,6),
       ExternalId VARCHAR(20),
       OrderItemTypeId VARCHAR(20),
       OrderItemGroupSeqId VARCHAR(20),
       IsItemGroupPrimary CHAR(1),
       FromInventoryItemId VARCHAR(20),
       IsPromo CHAR(1),
       QuoteId VARCHAR(20),
       QuoteItemSeqId VARCHAR(20),
       ShoppingListId VARCHAR(20),
       ShoppingListItemSeqId VARCHAR(20),
       UnitPrice DECIMAL(18,3),
       UnitListPrice DECIMAL(18,3),
       UnitAverageCost DECIMAL(18,2),
       UnitRecurringPrice DECIMAL(18,2),
       IsModifiedPrice CHAR(1),
       RecurringFreqUomId VARCHAR(20),
       ItemDescription VARCHAR(255),
       Comments VARCHAR(255),
       CorrespondingPoId VARCHAR(20),
       StatusId VARCHAR(20),
       SyncStatusId VARCHAR(20),
       EstimatedShipDate DATETIME,
       EstimatedDeliveryDate DATETIME,
       AutoCancelDate DATETIME,
       DontCancelSetDate DATETIME,
       DontCancelSetBy VARCHAR(250),
       ShipBeforeDate DATETIME,
       ShipAfterDate DATETIME,
       CancelBackOrderDate DATETIME,
       OverrideGlAccountId VARCHAR(20),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (OrderItemIdOrderId, OrderItemIdOrderItemSeqId)
    );

    create table OrderShipments (
        OrderShipmentIdOrderId VARCHAR(20) not null,
       OrderShipmentIdOrderItemSeqId VARCHAR(20) not null,
       OrderShipmentIdShipGroupSeqId DECIMAL(20,0) not null,
       OrderShipmentIdShipmentId VARCHAR(20) not null,
       OrderShipmentIdShipmentItemSeqId VARCHAR(20) not null,
       Version BIGINT not null,
       Quantity DECIMAL(18,6),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (OrderShipmentIdOrderId, OrderShipmentIdOrderItemSeqId, OrderShipmentIdShipGroupSeqId, OrderShipmentIdShipmentId, OrderShipmentIdShipmentItemSeqId)
    );

    create table OrganizationStructures (
        IdOrganizationStructureTypeId VARCHAR(255) not null,
       IdParentId VARCHAR(255) not null,
       IdSubsidiaryId VARCHAR(255) not null,
       Version BIGINT not null,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (IdOrganizationStructureTypeId, IdParentId, IdSubsidiaryId)
    );

    create table OrganizationStructureTypes (
        Id VARCHAR(50) not null,
       Version BIGINT not null,
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (Id)
    );

    create table Parties (
        PartyId VARCHAR(50) not null,
       Version BIGINT not null,
       PrimaryRoleTypeId VARCHAR(20),
       ExternalId VARCHAR(20),
       PreferredCurrencyUomId VARCHAR(20),
       Description LONGTEXT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (PartyId)
    );

    create table Organizations (
        PartyId VARCHAR(50) not null,
       Version BIGINT not null,
       PrimaryRoleTypeId VARCHAR(20),
       ExternalId VARCHAR(20),
       PreferredCurrencyUomId VARCHAR(20),
       Description LONGTEXT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       OrganizationName VARCHAR(255),
       IsSummary TINYINT(1),
       primary key (PartyId)
    );

    create table People (
        PartyId VARCHAR(50) not null,
       Version BIGINT not null,
       PrimaryRoleTypeId VARCHAR(20),
       ExternalId VARCHAR(20),
       PreferredCurrencyUomId VARCHAR(20),
       Description LONGTEXT,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       Salutation VARCHAR(100),
       FirstName VARCHAR(100),
       MiddleName VARCHAR(100),
       LastName VARCHAR(100),
       PersonalTitle VARCHAR(100),
       Nickname VARCHAR(100),
       CardId VARCHAR(60),
       primary key (PartyId)
    );

    create table PhysicalInventories (
        DocumentNumber VARCHAR(50) not null,
       Version BIGINT not null,
       DocumentStatusId VARCHAR(255),
       WarehouseId VARCHAR(255),
       LocatorIdPattern VARCHAR(255),
       ProductIdPattern VARCHAR(60),
       Posted TINYINT(1),
       Processed TINYINT(1),
       Processing VARCHAR(255),
       DocumentTypeId VARCHAR(255),
       MovementDate DATETIME,
       Description VARCHAR(255),
       IsApproved TINYINT(1),
       ApprovalAmount decimal(18,6),
       IsQuantityUpdated TINYINT(1),
       ReversalDocumentNumber VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (DocumentNumber)
    );

    create table PhysicalInventoryLines (
        PhysicalInventoryLineIdPhysicalInventoryDocumentNumber VARCHAR(50) not null,
       ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       Version BIGINT not null,
       BookQuantity decimal(18,6),
       CountedQuantity decimal(18,6),
       Processed TINYINT(1),
       LineNumber VARCHAR(50) not null,
       ReversalLineNumber BIGINT,
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (PhysicalInventoryLineIdPhysicalInventoryDocumentNumber, ProductId, LocatorId, AttributeSetInstanceId),
      unique (LineNumber)
    );

    create table Locators (
        LocatorId VARCHAR(50) not null,
       Version BIGINT not null,
       WarehouseId VARCHAR(255) not null,
       ParentLocatorId VARCHAR(255),
       LocatorType VARCHAR(255),
       PriorityNumber VARCHAR(255),
       IsDefault TINYINT(1),
       X VARCHAR(255),
       Y VARCHAR(255),
       Z VARCHAR(255),
       Description VARCHAR(255),
       LocatorTypeId VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (LocatorId)
    );

    create table OrderRoles (
        OrderRoleIdOrderId VARCHAR(20) not null,
       OrderRoleIdPartyRoleIdPartyId VARCHAR(20) not null,
       OrderRoleIdPartyRoleIdRoleTypeId VARCHAR(20) not null,
       Version BIGINT not null,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (OrderRoleIdOrderId, OrderRoleIdPartyRoleIdPartyId, OrderRoleIdPartyRoleIdRoleTypeId)
    );

    create table OrderShipGroups (
        OrderShipGroupIdOrderId VARCHAR(20) not null,
       OrderShipGroupIdShipGroupSeqId DECIMAL(20,0) not null,
       Version BIGINT not null,
       ShipmentMethodTypeId VARCHAR(20),
       SupplierPartyId VARCHAR(20),
       VendorPartyId VARCHAR(20),
       CarrierPartyId VARCHAR(20),
       CarrierRoleTypeId VARCHAR(20),
       FacilityId VARCHAR(20),
       ContactMechId VARCHAR(20),
       TelecomContactMechId VARCHAR(20),
       TrackingNumber VARCHAR(60),
       ContactPartyId VARCHAR(255),
       VehiclePlateNumber VARCHAR(255),
       ShippingInstructions VARCHAR(255),
       MaySplit CHAR(1),
       GiftMessage VARCHAR(255),
       IsGift CHAR(1),
       ShipAfterDate DATETIME,
       ShipByDate DATETIME,
       EstimatedShipDate DATETIME,
       EstimatedDeliveryDate DATETIME,
       PickwaveId DECIMAL(20,0),
       NumberOfPackages INTEGER,
       NumberOfContainers INTEGER,
       NumberOfPakagesPerContainer INTEGER,
       OrderShipGroupStatusId VARCHAR(20),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (OrderShipGroupIdOrderId, OrderShipGroupIdShipGroupSeqId)
    );

    create table PartyRoles (
        PartyRoleIdPartyId VARCHAR(20) not null,
       PartyRoleIdRoleTypeId VARCHAR(20) not null,
       Version BIGINT not null,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (PartyRoleIdPartyId, PartyRoleIdRoleTypeId)
    );

    create table Picklists (
        PicklistId VARCHAR(20) not null,
       Version BIGINT not null,
       Description VARCHAR(255),
       FacilityId VARCHAR(20),
       ShipmentMethodTypeId VARCHAR(20),
       StatusId VARCHAR(20),
       PicklistDate DATETIME,
       PickwaveId DECIMAL(20,0),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (PicklistId)
    );

    create table PicklistRoles (
        PicklistRoleIdPicklistId VARCHAR(20) not null,
       PicklistRoleIdPartyRoleIdPartyId VARCHAR(20) not null,
       PicklistRoleIdPartyRoleIdRoleTypeId VARCHAR(20) not null,
       Version BIGINT not null,
       CreatedByUserLogin VARCHAR(250),
       LastModifiedByUserLogin VARCHAR(250),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (PicklistRoleIdPicklistId, PicklistRoleIdPartyRoleIdPartyId, PicklistRoleIdPartyRoleIdRoleTypeId)
    );

    create table PicklistBins (
        PicklistBinId VARCHAR(20) not null,
       Version BIGINT not null,
       PicklistId VARCHAR(20),
       BinLocationNumber DECIMAL(20,0),
       PrimaryOrderId VARCHAR(20),
       PrimaryShipGroupSeqId DECIMAL(20,0),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (PicklistBinId)
    );

    create table PicklistItems (
        PicklistBinId VARCHAR(20) not null,
       OrderId VARCHAR(20) not null,
       OrderItemSeqId VARCHAR(20) not null,
       ShipGroupSeqId DECIMAL(20,0) not null,
       ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       Version BIGINT not null,
       ItemStatusId VARCHAR(20),
       Quantity DECIMAL(18,6),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (PicklistBinId, OrderId, OrderItemSeqId, ShipGroupSeqId, ProductId, LocatorId, AttributeSetInstanceId)
    );

    create table Products (
        ProductId VARCHAR(60) not null,
       Version BIGINT not null,
       ProductTypeId VARCHAR(20),
       PrimaryProductCategoryId VARCHAR(20),
       ManufacturerPartyId VARCHAR(20),
       FacilityId VARCHAR(20),
       IntroductionDate DATETIME,
       ReleaseDate DATETIME,
       SupportDiscontinuationDate DATETIME,
       SalesDiscontinuationDate DATETIME,
       SalesDiscWhenNotAvail CHAR(1),
       InternalName VARCHAR(255),
       BrandName VARCHAR(100),
       Comments VARCHAR(255),
       ProductName VARCHAR(100),
       Description VARCHAR(255),
       PriceDetailText VARCHAR(255),
       SmallImageUrl VARCHAR(2000),
       MediumImageUrl VARCHAR(2000),
       LargeImageUrl VARCHAR(2000),
       DetailImageUrl VARCHAR(2000),
       OriginalImageUrl VARCHAR(2000),
       DetailScreen VARCHAR(255),
       InventoryMessage VARCHAR(255),
       InventoryItemTypeId VARCHAR(20),
       RequireInventory CHAR(1),
       QuantityUomId VARCHAR(20),
       QuantityIncluded DECIMAL(18,6),
       PiecesIncluded DECIMAL(20,0),
       RequireAmount CHAR(1),
       FixedAmount DECIMAL(18,2),
       AmountUomTypeId VARCHAR(20),
       WeightUomId VARCHAR(20),
       ShippingWeight DECIMAL(18,6),
       ProductWeight DECIMAL(18,6),
       HeightUomId VARCHAR(20),
       ProductHeight DECIMAL(18,6),
       ShippingHeight DECIMAL(18,6),
       WidthUomId VARCHAR(20),
       ProductWidth DECIMAL(18,6),
       ShippingWidth DECIMAL(18,6),
       DepthUomId VARCHAR(20),
       ProductDepth DECIMAL(18,6),
       ShippingDepth DECIMAL(18,6),
       DiameterUomId VARCHAR(20),
       ProductDiameter DECIMAL(18,6),
       ProductRating DECIMAL(18,6),
       RatingTypeEnum VARCHAR(20),
       Returnable CHAR(1),
       Taxable CHAR(1),
       ChargeShipping CHAR(1),
       AutoCreateKeywords CHAR(1),
       IncludeInPromotions CHAR(1),
       IsVirtual CHAR(1),
       IsVariant CHAR(1),
       VirtualVariantMethodEnum VARCHAR(20),
       InShippingBox CHAR(1),
       DefaultShipmentBoxTypeId VARCHAR(20),
       IsSerialNumbered TINYINT(1),
       IsManagedByLot TINYINT(1),
       AttributeSetId VARCHAR(255),
       AttributeSetInstanceId VARCHAR(255),
       Grade VARCHAR(20),
       Gsm DECIMAL(18,6),
       CoreDiameter DECIMAL(18,6),
       OutsideDiameter DECIMAL(18,6),
       MoisturePct DECIMAL(18,6),
       RollCnt VARCHAR(10),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ProductId)
    );

    create table ProductCategories (
        ProductCategoryId VARCHAR(20) not null,
       Version BIGINT not null,
       ProductCategoryTypeId VARCHAR(20),
       PrimaryParentCategoryId VARCHAR(20),
       CategoryName VARCHAR(100),
       Description VARCHAR(255),
       CategoryImageUrl VARCHAR(2000),
       DetailScreen VARCHAR(255),
       ShowInSelect TINYINT(1),
       AttributeSetId VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ProductCategoryId)
    );

    create table ProductCategoryMembers (
        ProductCategoryMemberIdProductCategoryId VARCHAR(20) not null,
       ProductCategoryMemberIdProductId VARCHAR(60) not null,
       Version BIGINT not null,
       ThruDate DATETIME,
       Comments VARCHAR(255),
       SequenceNum DECIMAL(20,0),
       Quantity DECIMAL(18,6),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ProductCategoryMemberIdProductCategoryId, ProductCategoryMemberIdProductId)
    );

    create table RejectionReasons (
        RejectionReasonId VARCHAR(60) not null,
       Version BIGINT not null,
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (RejectionReasonId)
    );

    create table RoleTypes (
        RoleTypeId VARCHAR(20) not null,
       Version BIGINT not null,
       ParentTypeId VARCHAR(20),
       HasTable CHAR(1),
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (RoleTypeId)
    );

    create table SellableInventoryItems (
        ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       Version BIGINT not null,
       SellableQuantity decimal(18,6),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       CommandId VARCHAR(255),
       primary key (ProductId, LocatorId, AttributeSetInstanceId)
    );

    create table SellableInventoryItemEntries (
        ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       EntrySeqId BIGINT not null,
       Version BIGINT not null,
       SellableQuantity decimal(18,6),
       SrcEventProductId VARCHAR(60),
       SrcEventLocatorId VARCHAR(50),
       SrcEventAttributeSetInstanceId VARCHAR(50),
       SrcEventEntrySeqId BIGINT,
       SrcEventInventoryPostingRuleId VARCHAR(50),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       CommandId VARCHAR(255),
       primary key (ProductId, LocatorId, AttributeSetInstanceId, EntrySeqId),
      unique (SrcEventProductId, SrcEventLocatorId, SrcEventAttributeSetInstanceId, SrcEventEntrySeqId, SrcEventInventoryPostingRuleId)
    );

    create table Shipments (
        ShipmentId VARCHAR(20) not null,
       Version BIGINT not null,
       ShipmentTypeId VARCHAR(20),
       StatusId VARCHAR(20),
       PrimaryOrderId VARCHAR(20),
       PrimaryReturnId VARCHAR(20),
       PrimaryShipGroupSeqId DECIMAL(20,0),
       PicklistBinId VARCHAR(20),
       BolNumber VARCHAR(60),
       SealNumber VARCHAR(60),
       VehicleId VARCHAR(60),
       ExternalOrderNumber VARCHAR(60),
       Carrier VARCHAR(60),
       DateShipped DATETIME,
       EstimatedReadyDate DATETIME,
       EstimatedShipDate DATETIME,
       EstimatedShipWorkEffId VARCHAR(20),
       EstimatedArrivalDate DATETIME,
       EstimatedArrivalWorkEffId VARCHAR(20),
       LatestCancelDate DATETIME,
       EstimatedShipCost DECIMAL(18,2),
       CurrencyUomId VARCHAR(20),
       HandlingInstructions VARCHAR(255),
       OriginFacilityId VARCHAR(20),
       DestinationFacilityId VARCHAR(20),
       OriginContactMechId VARCHAR(20),
       OriginTelecomNumberId VARCHAR(20),
       DestinationContactMechId VARCHAR(20),
       DestinationTelecomNumberId VARCHAR(20),
       PartyIdTo VARCHAR(20),
       PartyIdFrom VARCHAR(20),
       AdditionalShippingCharge DECIMAL(18,2),
       AddtlShippingChargeDesc VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ShipmentId)
    );

    create table ShipmentItems (
        ShipmentItemIdShipmentId VARCHAR(20) not null,
       ShipmentItemIdShipmentItemSeqId VARCHAR(20) not null,
       Version BIGINT not null,
       ProductId VARCHAR(60),
       AttributeSetInstanceId VARCHAR(255),
       Quantity DECIMAL(18,6) not null,
       ShipmentContentDescription VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ShipmentItemIdShipmentId, ShipmentItemIdShipmentItemSeqId)
    );

    create table ShipmentReceipts (
        ShipmentReceiptIdShipmentId VARCHAR(20) not null,
       ShipmentReceiptIdReceiptSeqId VARCHAR(20) not null,
       Version BIGINT not null,
       ProductId VARCHAR(60),
       AttributeSetInstanceId VARCHAR(255),
       LocatorId VARCHAR(255),
       ShipmentItemSeqId VARCHAR(20),
       ShipmentPackageSeqId VARCHAR(20),
       OrderId VARCHAR(20),
       OrderItemSeqId VARCHAR(20),
       ReturnId VARCHAR(20),
       ReturnItemSeqId VARCHAR(20),
       RejectionReasonId VARCHAR(60),
       DamageReasonId VARCHAR(60),
       ReceivedBy VARCHAR(250),
       DatetimeReceived DATETIME,
       ItemDescription VARCHAR(255),
       AcceptedQuantity DECIMAL(18,6) not null,
       RejectedQuantity DECIMAL(18,6) not null,
       DamagedQuantity DECIMAL(18,6) not null,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId)
    );

    create table ShipmentReceiptDamageStatusIds (
        ShipmentReceiptIdShipmentId VARCHAR(255) not null,
       ShipmentReceiptIdReceiptSeqId VARCHAR(255) not null,
       DamageStatusIdsItem VARCHAR(255) not null,
       primary key (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId, DamageStatusIdsItem)
    );

    create table ItemIssuances (
        ShipmentItemIssuanceIdShipmentId VARCHAR(20) not null,
       ShipmentItemIssuanceIdItemIssuanceSeqId VARCHAR(20) not null,
       Version BIGINT not null,
       OrderId VARCHAR(20),
       OrderItemSeqId VARCHAR(20),
       ShipGroupSeqId DECIMAL(20,0),
       ProductId VARCHAR(60),
       LocatorId VARCHAR(50),
       AttributeSetInstanceId VARCHAR(50),
       ShipmentItemSeqId VARCHAR(20),
       FixedAssetId VARCHAR(20),
       MaintHistSeqId VARCHAR(20),
       IssuedDateTime DATETIME,
       IssuedByUserLoginId VARCHAR(250),
       Quantity DECIMAL(18,6),
       CancelQuantity DECIMAL(18,6),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ShipmentItemIssuanceIdShipmentId, ShipmentItemIssuanceIdItemIssuanceSeqId)
    );

    create table ShipmentMethodTypes (
        ShipmentMethodTypeId VARCHAR(20) not null,
       Version BIGINT not null,
       Description VARCHAR(255),
       SequenceNum DECIMAL(20,0),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ShipmentMethodTypeId)
    );

    create table ShipmentPackages (
        ShipmentPackageIdShipmentId VARCHAR(20) not null,
       ShipmentPackageIdShipmentPackageSeqId VARCHAR(20) not null,
       Version BIGINT not null,
       ShipmentBoxTypeId VARCHAR(20),
       DateCreated DATETIME,
       BoxLength DECIMAL(18,6),
       BoxHeight DECIMAL(18,6),
       BoxWidth DECIMAL(18,6),
       DimensionUomId VARCHAR(20),
       Weight DECIMAL(18,6),
       WeightUomId VARCHAR(20),
       InsuredValue DECIMAL(18,2),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ShipmentPackageIdShipmentId, ShipmentPackageIdShipmentPackageSeqId)
    );

    create table ShipmentPackageContents (
        ShipmentPackageContentIdShipmentPackageIdShipmentId VARCHAR(20) not null,
       ShipmentPackageContentIdShipmentPackageIdShipmentPackageSeqId VARCHAR(20) not null,
       ShipmentPackageContentIdShipmentItemSeqId VARCHAR(20) not null,
       Version BIGINT not null,
       Quantity DECIMAL(18,6),
       SubProductId VARCHAR(20),
       SubProductQuantity DECIMAL(18,6),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ShipmentPackageContentIdShipmentPackageIdShipmentId, ShipmentPackageContentIdShipmentPackageIdShipmentPackageSeqId, ShipmentPackageContentIdShipmentItemSeqId)
    );

    create table ShipmentTypes (
        ShipmentTypeId VARCHAR(20) not null,
       Version BIGINT not null,
       ParentTypeId VARCHAR(20),
       HasTable CHAR(1),
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       CommandId VARCHAR(255),
       primary key (ShipmentTypeId)
    );

    create table StatusItems (
        StatusId VARCHAR(20) not null,
       Version BIGINT not null,
       StatusTypeId VARCHAR(20),
       StatusCode VARCHAR(60),
       SequenceId VARCHAR(20),
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       CommandId VARCHAR(255),
       primary key (StatusId)
    );

    create table SupplierProducts (
        SupplierProductIdProductId VARCHAR(60) not null,
       SupplierProductIdPartyId VARCHAR(20) not null,
       SupplierProductIdCurrencyUomId VARCHAR(20) not null,
       SupplierProductIdMinimumOrderQuantity DECIMAL(18,6) not null,
       Version BIGINT not null,
       AvailableThruDate DATETIME,
       SupplierPrefOrderId VARCHAR(20),
       SupplierRatingTypeId VARCHAR(20),
       StandardLeadTimeDays DECIMAL(18,6),
       ManufacturingLeadTimeDays DECIMAL(18,6),
       DeliveryLeadTimeDays DECIMAL(18,6),
       QuantityUomId VARCHAR(20),
       LastPrice DECIMAL(18,3),
       ShippingPrice DECIMAL(18,3),
       ExternalProductName VARCHAR(100),
       ExternalProductId VARCHAR(60),
       CanDropShip TINYINT(1),
       Comments VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (SupplierProductIdProductId, SupplierProductIdPartyId, SupplierProductIdCurrencyUomId, SupplierProductIdMinimumOrderQuantity)
    );

    create table Uoms (
        UomId VARCHAR(20) not null,
       Version BIGINT not null,
       UomTypeId VARCHAR(20),
       Abbreviation VARCHAR(60),
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (UomId)
    );

    create table UomConversions (
        UomConversionIdUomId VARCHAR(20) not null,
       UomConversionIdUomIdTo VARCHAR(20) not null,
       Version BIGINT not null,
       ConversionFactor DOUBLE,
       CustomMethodId VARCHAR(20),
       DecimalScale DECIMAL(20,0),
       RoundingMode VARCHAR(20),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (UomConversionIdUomId, UomConversionIdUomIdTo)
    );

    create table UomTypes (
        UomTypeId VARCHAR(20) not null,
       Version BIGINT not null,
       ParentTypeId VARCHAR(20),
       HasTable CHAR(1),
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       CommandId VARCHAR(255),
       primary key (UomTypeId)
    );

    create table Warehouses (
        WarehouseId VARCHAR(50) not null,
       Version BIGINT not null,
       WarehouseName VARCHAR(255),
       Description VARCHAR(255),
       IsInTransit TINYINT(1),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (WarehouseId)
    );

    create table OrderItemShipGrpInvReservations (
        OrderItemShipGrpInvResIdOrderId VARCHAR(20) not null,
       OrderItemShipGrpInvResIdShipGroupSeqId DECIMAL(20,0) not null,
       OrderItemShipGrpInvResIdOrderItemSeqId VARCHAR(20) not null,
       OrderItemShipGrpInvResIdProductId VARCHAR(60) not null,
       OrderItemShipGrpInvResIdLocatorId VARCHAR(50) not null,
       OrderItemShipGrpInvResIdAttributeSetInstanceId VARCHAR(50) not null,
       Version BIGINT not null,
       ReserveOrderEnumId VARCHAR(20),
       Quantity DECIMAL(18,6),
       QuantityNotAvailable DECIMAL(18,6),
       ReservedDatetime DATETIME,
       CreatedDatetime DATETIME,
       PromisedDatetime DATETIME,
       CurrentPromisedDate DATETIME,
       Priority CHAR(1),
       SequenceId DECIMAL(20,0),
       OldPickStartDate DATETIME,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (OrderItemShipGrpInvResIdOrderId, OrderItemShipGrpInvResIdShipGroupSeqId, OrderItemShipGrpInvResIdOrderItemSeqId, OrderItemShipGrpInvResIdProductId, OrderItemShipGrpInvResIdLocatorId, OrderItemShipGrpInvResIdAttributeSetInstanceId)
    );

    create table LocatorTypes (
        LocatorTypeId VARCHAR(50) not null,
       Version BIGINT not null,
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (LocatorTypeId)
    );

    create table Pickwaves (
        PickwaveId BIGINT not null,
       Version BIGINT not null,
       StatusId VARCHAR(20),
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (PickwaveId)
    );

    create table OrderItemShipGroupAssociations (
        OrderItemShipGroupAssociationIdOrderId VARCHAR(20) not null,
       OrderItemShipGroupAssociationIdOrderShipGroupShipGroupSeqId DECIMAL(20,0) not null,
       OrderItemShipGroupAssociationIdOrderItemSeqId VARCHAR(20) not null,
       Version BIGINT not null,
       Quantity DECIMAL(18,6),
       CancelQuantity DECIMAL(18,6),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (OrderItemShipGroupAssociationIdOrderId, OrderItemShipGroupAssociationIdOrderShipGroupShipGroupSeqId, OrderItemShipGroupAssociationIdOrderItemSeqId)
    );

    create table InOutEvents (
        DocumentNumber VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       DocumentStatusId VARCHAR(255),
       Posted TINYINT(1),
       Processed TINYINT(1),
       Processing VARCHAR(255),
       DocumentTypeId VARCHAR(255),
       Description VARCHAR(255),
       OrderId VARCHAR(255),
       DateOrdered DATETIME,
       IsPrinted TINYINT(1),
       MovementTypeId VARCHAR(255),
       MovementDate DATETIME,
       BusinessPartnerId VARCHAR(255),
       WarehouseId VARCHAR(255),
       POReference VARCHAR(255),
       FreightAmount decimal(18,6),
       ShipperId VARCHAR(255),
       ChargeAmount decimal(18,6),
       DatePrinted DATETIME,
       CreatedFrom VARCHAR(255),
       SalesRepresentativeId VARCHAR(255),
       NumberOfPackages INTEGER,
       PickDate DATETIME,
       ShipDate DATETIME,
       TrackingNumber VARCHAR(255),
       DateReceived DATETIME,
       IsInTransit TINYINT(1),
       IsApproved TINYINT(1),
       IsInDispute TINYINT(1),
       RmaDocumentNumber VARCHAR(255),
       ReversalDocumentNumber VARCHAR(255),
       Active TINYINT(1),
       IsPropertyDocumentStatusIdRemoved TINYINT(1),
       IsPropertyPostedRemoved TINYINT(1),
       IsPropertyProcessedRemoved TINYINT(1),
       IsPropertyProcessingRemoved TINYINT(1),
       IsPropertyDocumentTypeIdRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyOrderIdRemoved TINYINT(1),
       IsPropertyDateOrderedRemoved TINYINT(1),
       IsPropertyIsPrintedRemoved TINYINT(1),
       IsPropertyMovementTypeIdRemoved TINYINT(1),
       IsPropertyMovementDateRemoved TINYINT(1),
       IsPropertyBusinessPartnerIdRemoved TINYINT(1),
       IsPropertyWarehouseIdRemoved TINYINT(1),
       IsPropertyPOReferenceRemoved TINYINT(1),
       IsPropertyFreightAmountRemoved TINYINT(1),
       IsPropertyShipperIdRemoved TINYINT(1),
       IsPropertyChargeAmountRemoved TINYINT(1),
       IsPropertyDatePrintedRemoved TINYINT(1),
       IsPropertyCreatedFromRemoved TINYINT(1),
       IsPropertySalesRepresentativeIdRemoved TINYINT(1),
       IsPropertyNumberOfPackagesRemoved TINYINT(1),
       IsPropertyPickDateRemoved TINYINT(1),
       IsPropertyShipDateRemoved TINYINT(1),
       IsPropertyTrackingNumberRemoved TINYINT(1),
       IsPropertyDateReceivedRemoved TINYINT(1),
       IsPropertyIsInTransitRemoved TINYINT(1),
       IsPropertyIsApprovedRemoved TINYINT(1),
       IsPropertyIsInDisputeRemoved TINYINT(1),
       IsPropertyRmaDocumentNumberRemoved TINYINT(1),
       IsPropertyReversalDocumentNumberRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (DocumentNumber, Version)
    );

    create table InOutLineEvents (
        InOutLineIdInOutDocumentNumber VARCHAR(50) not null,
       InOutLineIdLineNumber VARCHAR(50) not null,
       InOutVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       LocatorId VARCHAR(255),
       ProductId VARCHAR(60),
       AttributeSetInstanceId VARCHAR(255),
       Description VARCHAR(255),
       QuantityUomId VARCHAR(255),
       MovementQuantity decimal(18,6),
       PickedQuantity decimal(18,6),
       IsInvoiced TINYINT(1),
       Processed TINYINT(1),
       RmaLineNumber VARCHAR(255),
       ReversalLineNumber VARCHAR(255),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyLocatorIdRemoved TINYINT(1),
       IsPropertyProductIdRemoved TINYINT(1),
       IsPropertyAttributeSetInstanceIdRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyQuantityUomIdRemoved TINYINT(1),
       IsPropertyMovementQuantityRemoved TINYINT(1),
       IsPropertyPickedQuantityRemoved TINYINT(1),
       IsPropertyIsInvoicedRemoved TINYINT(1),
       IsPropertyProcessedRemoved TINYINT(1),
       IsPropertyRmaLineNumberRemoved TINYINT(1),
       IsPropertyReversalLineNumberRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber, InOutVersion)
    );

    create table InOutLineStateEventDamageStatusIds (
        InOutLineIdInOutDocumentNumber VARCHAR(50) not null,
       InOutLineIdLineNumber VARCHAR(50) not null,
       InOutVersion BIGINT not null,
       DamageStatusIdsItem VARCHAR(255) not null,
       primary key (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber, InOutVersion, DamageStatusIdsItem)
    );

    create table InventoryItemEvents (
        ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       OnHandQuantity decimal(18,6),
       InTransitQuantity decimal(18,6),
       ReservedQuantity decimal(18,6),
       OccupiedQuantity decimal(18,6),
       VirtualQuantity decimal(18,6),
       IsPropertyOnHandQuantityRemoved TINYINT(1),
       IsPropertyInTransitQuantityRemoved TINYINT(1),
       IsPropertyReservedQuantityRemoved TINYINT(1),
       IsPropertyOccupiedQuantityRemoved TINYINT(1),
       IsPropertyVirtualQuantityRemoved TINYINT(1),
       primary key (ProductId, LocatorId, AttributeSetInstanceId, Version)
    );

    create table InventoryPostingRuleEvents (
        InventoryPostingRuleId VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       TriggerProductId VARCHAR(60),
       TriggerLocatorId VARCHAR(50),
       TriggerAttributeSetInstanceId VARCHAR(50),
       OutputProductId VARCHAR(60),
       OutputLocatorId VARCHAR(50),
       OutputAttributeSetInstanceId VARCHAR(50),
       TriggerAccountName VARCHAR(255),
       OutputAccountName VARCHAR(255),
       IsOutputNegated TINYINT(1),
       Active TINYINT(1),
       IsPropertyTriggerInventoryItemIdRemoved TINYINT(1),
       IsPropertyOutputInventoryItemIdRemoved TINYINT(1),
       IsPropertyTriggerAccountNameRemoved TINYINT(1),
       IsPropertyOutputAccountNameRemoved TINYINT(1),
       IsPropertyIsOutputNegatedRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (InventoryPostingRuleId, Version)
    );

    create table LocatorEvents (
        LocatorId VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       WarehouseId VARCHAR(255),
       ParentLocatorId VARCHAR(255),
       LocatorType VARCHAR(255),
       PriorityNumber VARCHAR(255),
       IsDefault TINYINT(1),
       X VARCHAR(255),
       Y VARCHAR(255),
       Z VARCHAR(255),
       Description VARCHAR(255),
       LocatorTypeId VARCHAR(255),
       Active TINYINT(1),
       IsPropertyWarehouseIdRemoved TINYINT(1),
       IsPropertyParentLocatorIdRemoved TINYINT(1),
       IsPropertyLocatorTypeRemoved TINYINT(1),
       IsPropertyPriorityNumberRemoved TINYINT(1),
       IsPropertyIsDefaultRemoved TINYINT(1),
       IsPropertyXRemoved TINYINT(1),
       IsPropertyYRemoved TINYINT(1),
       IsPropertyZRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyLocatorTypeIdRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (LocatorId, Version)
    );

    create table LocatorTypeEvents (
        LocatorTypeId VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Description VARCHAR(255),
       Active TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (LocatorTypeId, Version)
    );

    create table LotEvents (
        LotId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Quantity DECIMAL(18,6),
       ExpirationDate DATETIME,
       Active TINYINT(1),
       IsPropertyQuantityRemoved TINYINT(1),
       IsPropertyExpirationDateRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (LotId, Version)
    );

    create table MovementEvents (
        DocumentNumber VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       DocumentStatusId VARCHAR(255),
       MovementDate DATETIME,
       Posted TINYINT(1),
       Processed TINYINT(1),
       Processing VARCHAR(255),
       DateReceived DATETIME,
       DocumentTypeId VARCHAR(255),
       IsInTransit TINYINT(1),
       IsApproved TINYINT(1),
       ApprovalAmount decimal(18,6),
       ShipperId VARCHAR(255),
       SalesRepresentativeId VARCHAR(255),
       BusinessPartnerId VARCHAR(255),
       ChargeAmount decimal(18,6),
       CreateFrom VARCHAR(255),
       FreightAmount decimal(18,6),
       ReversalDocumentNumber VARCHAR(255),
       WarehouseIdFrom VARCHAR(255),
       WarehouseIdTo VARCHAR(255),
       Description VARCHAR(255),
       Active TINYINT(1),
       IsPropertyDocumentStatusIdRemoved TINYINT(1),
       IsPropertyMovementDateRemoved TINYINT(1),
       IsPropertyPostedRemoved TINYINT(1),
       IsPropertyProcessedRemoved TINYINT(1),
       IsPropertyProcessingRemoved TINYINT(1),
       IsPropertyDateReceivedRemoved TINYINT(1),
       IsPropertyDocumentTypeIdRemoved TINYINT(1),
       IsPropertyIsInTransitRemoved TINYINT(1),
       IsPropertyIsApprovedRemoved TINYINT(1),
       IsPropertyApprovalAmountRemoved TINYINT(1),
       IsPropertyShipperIdRemoved TINYINT(1),
       IsPropertySalesRepresentativeIdRemoved TINYINT(1),
       IsPropertyBusinessPartnerIdRemoved TINYINT(1),
       IsPropertyChargeAmountRemoved TINYINT(1),
       IsPropertyCreateFromRemoved TINYINT(1),
       IsPropertyFreightAmountRemoved TINYINT(1),
       IsPropertyReversalDocumentNumberRemoved TINYINT(1),
       IsPropertyWarehouseIdFromRemoved TINYINT(1),
       IsPropertyWarehouseIdToRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (DocumentNumber, Version)
    );

    create table MovementLineEvents (
        MovementLineIdMovementDocumentNumber VARCHAR(50) not null,
       MovementLineIdLineNumber VARCHAR(50) not null,
       MovementVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       MovementQuantity decimal(18,6),
       ProductId VARCHAR(60),
       LocatorIdFrom VARCHAR(255),
       LocatorIdTo VARCHAR(255),
       AttributeSetInstanceId VARCHAR(255),
       Processed TINYINT(1),
       ReversalLineNumber VARCHAR(255),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyMovementQuantityRemoved TINYINT(1),
       IsPropertyProductIdRemoved TINYINT(1),
       IsPropertyLocatorIdFromRemoved TINYINT(1),
       IsPropertyLocatorIdToRemoved TINYINT(1),
       IsPropertyAttributeSetInstanceIdRemoved TINYINT(1),
       IsPropertyProcessedRemoved TINYINT(1),
       IsPropertyReversalLineNumberRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (MovementLineIdMovementDocumentNumber, MovementLineIdLineNumber, MovementVersion)
    );

    create table MovementConfirmationEvents (
        DocumentNumber VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       DocumentStatusId VARCHAR(255),
       MovementDocumentNumber VARCHAR(255),
       IsApproved TINYINT(1),
       ApprovalAmount decimal(18,6),
       Processed TINYINT(1),
       Processing VARCHAR(255),
       DocumentTypeId VARCHAR(255),
       Description VARCHAR(255),
       Active TINYINT(1),
       IsPropertyDocumentStatusIdRemoved TINYINT(1),
       IsPropertyMovementDocumentNumberRemoved TINYINT(1),
       IsPropertyIsApprovedRemoved TINYINT(1),
       IsPropertyApprovalAmountRemoved TINYINT(1),
       IsPropertyProcessedRemoved TINYINT(1),
       IsPropertyProcessingRemoved TINYINT(1),
       IsPropertyDocumentTypeIdRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (DocumentNumber, Version)
    );

    create table MovementConfirmationLineEvents (
        MovementConfirmationLineIdMovementConfirmationDocumentNumber VARCHAR(50) not null,
       MovementConfirmationLineIdLineNumber VARCHAR(50) not null,
       MovementConfirmationVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       MovementLineNumber VARCHAR(255),
       TargetQuantity decimal(18,6),
       ConfirmedQuantity decimal(18,6),
       DifferenceQuantity decimal(18,6),
       ScrappedQuantity decimal(18,6),
       Description VARCHAR(255),
       Processed TINYINT(1),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyMovementLineNumberRemoved TINYINT(1),
       IsPropertyTargetQuantityRemoved TINYINT(1),
       IsPropertyConfirmedQuantityRemoved TINYINT(1),
       IsPropertyDifferenceQuantityRemoved TINYINT(1),
       IsPropertyScrappedQuantityRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyProcessedRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (MovementConfirmationLineIdMovementConfirmationDocumentNumber, MovementConfirmationLineIdLineNumber, MovementConfirmationVersion)
    );

    create table OrderEvents (
        OrderId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       OrderTypeId VARCHAR(20),
       OrderName VARCHAR(100),
       ExternalId VARCHAR(20),
       SalesChannelEnumId VARCHAR(20),
       OrderDate DATETIME,
       Priority CHAR(1),
       EntryDate DATETIME,
       PickSheetPrintedDate DATETIME,
       StatusId VARCHAR(20),
       CurrencyUomId VARCHAR(20),
       SyncStatusId VARCHAR(20),
       BillingAccountId VARCHAR(20),
       OriginFacilityId VARCHAR(20),
       WebSiteId VARCHAR(20),
       ProductStoreId VARCHAR(20),
       TerminalId VARCHAR(60),
       TransactionId VARCHAR(60),
       AutoOrderShoppingListId VARCHAR(20),
       NeedsInventoryIssuance CHAR(1),
       IsRushOrder CHAR(1),
       InternalCode VARCHAR(60),
       RemainingSubTotal DECIMAL(18,2),
       GrandTotal DECIMAL(18,2),
       InvoicePerShipment CHAR(1),
       Active TINYINT(1),
       IsPropertyOrderTypeIdRemoved TINYINT(1),
       IsPropertyOrderNameRemoved TINYINT(1),
       IsPropertyExternalIdRemoved TINYINT(1),
       IsPropertySalesChannelEnumIdRemoved TINYINT(1),
       IsPropertyOrderDateRemoved TINYINT(1),
       IsPropertyPriorityRemoved TINYINT(1),
       IsPropertyEntryDateRemoved TINYINT(1),
       IsPropertyPickSheetPrintedDateRemoved TINYINT(1),
       IsPropertyStatusIdRemoved TINYINT(1),
       IsPropertyCurrencyUomIdRemoved TINYINT(1),
       IsPropertySyncStatusIdRemoved TINYINT(1),
       IsPropertyBillingAccountIdRemoved TINYINT(1),
       IsPropertyOriginFacilityIdRemoved TINYINT(1),
       IsPropertyWebSiteIdRemoved TINYINT(1),
       IsPropertyProductStoreIdRemoved TINYINT(1),
       IsPropertyTerminalIdRemoved TINYINT(1),
       IsPropertyTransactionIdRemoved TINYINT(1),
       IsPropertyAutoOrderShoppingListIdRemoved TINYINT(1),
       IsPropertyNeedsInventoryIssuanceRemoved TINYINT(1),
       IsPropertyIsRushOrderRemoved TINYINT(1),
       IsPropertyInternalCodeRemoved TINYINT(1),
       IsPropertyRemainingSubTotalRemoved TINYINT(1),
       IsPropertyGrandTotalRemoved TINYINT(1),
       IsPropertyInvoicePerShipmentRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (OrderId, Version)
    );

    create table OrderRoleEvents (
        OrderRoleIdOrderId VARCHAR(20) not null,
       OrderRoleIdPartyRoleIdPartyId VARCHAR(20) not null,
       OrderRoleIdPartyRoleIdRoleTypeId VARCHAR(20) not null,
       OrderVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyActiveRemoved TINYINT(1),
       primary key (OrderRoleIdOrderId, OrderRoleIdPartyRoleIdPartyId, OrderRoleIdPartyRoleIdRoleTypeId, OrderVersion)
    );

    create table OrderItemEvents (
        OrderItemIdOrderId VARCHAR(20) not null,
       OrderItemIdOrderItemSeqId VARCHAR(20) not null,
       OrderVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ProductId VARCHAR(60),
       ExternalProductId VARCHAR(60),
       Quantity DECIMAL(18,6),
       CancelQuantity DECIMAL(18,6),
       SelectedAmount DECIMAL(18,6),
       ExternalId VARCHAR(20),
       OrderItemTypeId VARCHAR(20),
       OrderItemGroupSeqId VARCHAR(20),
       IsItemGroupPrimary CHAR(1),
       FromInventoryItemId VARCHAR(20),
       IsPromo CHAR(1),
       QuoteId VARCHAR(20),
       QuoteItemSeqId VARCHAR(20),
       ShoppingListId VARCHAR(20),
       ShoppingListItemSeqId VARCHAR(20),
       UnitPrice DECIMAL(18,3),
       UnitListPrice DECIMAL(18,3),
       UnitAverageCost DECIMAL(18,2),
       UnitRecurringPrice DECIMAL(18,2),
       IsModifiedPrice CHAR(1),
       RecurringFreqUomId VARCHAR(20),
       ItemDescription VARCHAR(255),
       Comments VARCHAR(255),
       CorrespondingPoId VARCHAR(20),
       StatusId VARCHAR(20),
       SyncStatusId VARCHAR(20),
       EstimatedShipDate DATETIME,
       EstimatedDeliveryDate DATETIME,
       AutoCancelDate DATETIME,
       DontCancelSetDate DATETIME,
       DontCancelSetBy VARCHAR(250),
       ShipBeforeDate DATETIME,
       ShipAfterDate DATETIME,
       CancelBackOrderDate DATETIME,
       OverrideGlAccountId VARCHAR(20),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyProductIdRemoved TINYINT(1),
       IsPropertyExternalProductIdRemoved TINYINT(1),
       IsPropertyQuantityRemoved TINYINT(1),
       IsPropertyCancelQuantityRemoved TINYINT(1),
       IsPropertySelectedAmountRemoved TINYINT(1),
       IsPropertyExternalIdRemoved TINYINT(1),
       IsPropertyOrderItemTypeIdRemoved TINYINT(1),
       IsPropertyOrderItemGroupSeqIdRemoved TINYINT(1),
       IsPropertyIsItemGroupPrimaryRemoved TINYINT(1),
       IsPropertyFromInventoryItemIdRemoved TINYINT(1),
       IsPropertyIsPromoRemoved TINYINT(1),
       IsPropertyQuoteIdRemoved TINYINT(1),
       IsPropertyQuoteItemSeqIdRemoved TINYINT(1),
       IsPropertyShoppingListIdRemoved TINYINT(1),
       IsPropertyShoppingListItemSeqIdRemoved TINYINT(1),
       IsPropertyUnitPriceRemoved TINYINT(1),
       IsPropertyUnitListPriceRemoved TINYINT(1),
       IsPropertyUnitAverageCostRemoved TINYINT(1),
       IsPropertyUnitRecurringPriceRemoved TINYINT(1),
       IsPropertyIsModifiedPriceRemoved TINYINT(1),
       IsPropertyRecurringFreqUomIdRemoved TINYINT(1),
       IsPropertyItemDescriptionRemoved TINYINT(1),
       IsPropertyCommentsRemoved TINYINT(1),
       IsPropertyCorrespondingPoIdRemoved TINYINT(1),
       IsPropertyStatusIdRemoved TINYINT(1),
       IsPropertySyncStatusIdRemoved TINYINT(1),
       IsPropertyEstimatedShipDateRemoved TINYINT(1),
       IsPropertyEstimatedDeliveryDateRemoved TINYINT(1),
       IsPropertyAutoCancelDateRemoved TINYINT(1),
       IsPropertyDontCancelSetDateRemoved TINYINT(1),
       IsPropertyDontCancelSetByRemoved TINYINT(1),
       IsPropertyShipBeforeDateRemoved TINYINT(1),
       IsPropertyShipAfterDateRemoved TINYINT(1),
       IsPropertyCancelBackOrderDateRemoved TINYINT(1),
       IsPropertyOverrideGlAccountIdRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (OrderItemIdOrderId, OrderItemIdOrderItemSeqId, OrderVersion)
    );

    create table OrderShipGroupEvents (
        OrderShipGroupIdOrderId VARCHAR(20) not null,
       OrderShipGroupIdShipGroupSeqId DECIMAL(20,0) not null,
       OrderVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ShipmentMethodTypeId VARCHAR(20),
       SupplierPartyId VARCHAR(20),
       VendorPartyId VARCHAR(20),
       CarrierPartyId VARCHAR(20),
       CarrierRoleTypeId VARCHAR(20),
       FacilityId VARCHAR(20),
       ContactMechId VARCHAR(20),
       TelecomContactMechId VARCHAR(20),
       TrackingNumber VARCHAR(60),
       ContactPartyId VARCHAR(255),
       VehiclePlateNumber VARCHAR(255),
       ShippingInstructions VARCHAR(255),
       MaySplit CHAR(1),
       GiftMessage VARCHAR(255),
       IsGift CHAR(1),
       ShipAfterDate DATETIME,
       ShipByDate DATETIME,
       EstimatedShipDate DATETIME,
       EstimatedDeliveryDate DATETIME,
       PickwaveId DECIMAL(20,0),
       NumberOfPackages INTEGER,
       NumberOfContainers INTEGER,
       NumberOfPakagesPerContainer INTEGER,
       OrderShipGroupStatusId VARCHAR(20),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyShipmentMethodTypeIdRemoved TINYINT(1),
       IsPropertySupplierPartyIdRemoved TINYINT(1),
       IsPropertyVendorPartyIdRemoved TINYINT(1),
       IsPropertyCarrierPartyIdRemoved TINYINT(1),
       IsPropertyCarrierRoleTypeIdRemoved TINYINT(1),
       IsPropertyFacilityIdRemoved TINYINT(1),
       IsPropertyContactMechIdRemoved TINYINT(1),
       IsPropertyTelecomContactMechIdRemoved TINYINT(1),
       IsPropertyTrackingNumberRemoved TINYINT(1),
       IsPropertyContactPartyIdRemoved TINYINT(1),
       IsPropertyVehiclePlateNumberRemoved TINYINT(1),
       IsPropertyShippingInstructionsRemoved TINYINT(1),
       IsPropertyMaySplitRemoved TINYINT(1),
       IsPropertyGiftMessageRemoved TINYINT(1),
       IsPropertyIsGiftRemoved TINYINT(1),
       IsPropertyShipAfterDateRemoved TINYINT(1),
       IsPropertyShipByDateRemoved TINYINT(1),
       IsPropertyEstimatedShipDateRemoved TINYINT(1),
       IsPropertyEstimatedDeliveryDateRemoved TINYINT(1),
       IsPropertyPickwaveIdRemoved TINYINT(1),
       IsPropertyNumberOfPackagesRemoved TINYINT(1),
       IsPropertyNumberOfContainersRemoved TINYINT(1),
       IsPropertyNumberOfPakagesPerContainerRemoved TINYINT(1),
       IsPropertyOrderShipGroupStatusIdRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (OrderShipGroupIdOrderId, OrderShipGroupIdShipGroupSeqId, OrderVersion)
    );

    create table OrderItemShipGroupAssociationEvents (
        OrderItemShipGroupAssociationIdOrderId VARCHAR(20) not null,
       OrderItemShipGroupAssociationIdOrderShipGroupShipGroupSeqId DECIMAL(20,0) not null,
       OrderItemShipGroupAssociationIdOrderItemSeqId VARCHAR(20) not null,
       OrderVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Quantity DECIMAL(18,6),
       CancelQuantity DECIMAL(18,6),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyQuantityRemoved TINYINT(1),
       IsPropertyCancelQuantityRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (OrderItemShipGroupAssociationIdOrderId, OrderItemShipGroupAssociationIdOrderShipGroupShipGroupSeqId, OrderItemShipGroupAssociationIdOrderItemSeqId, OrderVersion)
    );

    create table OrderItemShipGrpInvReservationEvents (
        OrderItemShipGrpInvResIdOrderId VARCHAR(20) not null,
       OrderItemShipGrpInvResIdShipGroupSeqId DECIMAL(20,0) not null,
       OrderItemShipGrpInvResIdOrderItemSeqId VARCHAR(20) not null,
       OrderItemShipGrpInvResIdProductId VARCHAR(60) not null,
       OrderItemShipGrpInvResIdLocatorId VARCHAR(50) not null,
       OrderItemShipGrpInvResIdAttributeSetInstanceId VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ReserveOrderEnumId VARCHAR(20),
       Quantity DECIMAL(18,6),
       QuantityNotAvailable DECIMAL(18,6),
       ReservedDatetime DATETIME,
       CreatedDatetime DATETIME,
       PromisedDatetime DATETIME,
       CurrentPromisedDate DATETIME,
       Priority CHAR(1),
       SequenceId DECIMAL(20,0),
       OldPickStartDate DATETIME,
       Active TINYINT(1),
       IsPropertyReserveOrderEnumIdRemoved TINYINT(1),
       IsPropertyQuantityRemoved TINYINT(1),
       IsPropertyQuantityNotAvailableRemoved TINYINT(1),
       IsPropertyReservedDatetimeRemoved TINYINT(1),
       IsPropertyCreatedDatetimeRemoved TINYINT(1),
       IsPropertyPromisedDatetimeRemoved TINYINT(1),
       IsPropertyCurrentPromisedDateRemoved TINYINT(1),
       IsPropertyPriorityRemoved TINYINT(1),
       IsPropertySequenceIdRemoved TINYINT(1),
       IsPropertyOldPickStartDateRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (OrderItemShipGrpInvResIdOrderId, OrderItemShipGrpInvResIdShipGroupSeqId, OrderItemShipGrpInvResIdOrderItemSeqId, OrderItemShipGrpInvResIdProductId, OrderItemShipGrpInvResIdLocatorId, OrderItemShipGrpInvResIdAttributeSetInstanceId, Version)
    );

    create table OrderShipmentEvents (
        OrderShipmentIdOrderId VARCHAR(20) not null,
       OrderShipmentIdOrderItemSeqId VARCHAR(20) not null,
       OrderShipmentIdShipGroupSeqId DECIMAL(20,0) not null,
       OrderShipmentIdShipmentId VARCHAR(20) not null,
       OrderShipmentIdShipmentItemSeqId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Quantity DECIMAL(18,6),
       Active TINYINT(1),
       IsPropertyQuantityRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (OrderShipmentIdOrderId, OrderShipmentIdOrderItemSeqId, OrderShipmentIdShipGroupSeqId, OrderShipmentIdShipmentId, OrderShipmentIdShipmentItemSeqId, Version)
    );

    create table OrganizationStructureEvents (
        IdOrganizationStructureTypeId VARCHAR(255) not null,
       IdParentId VARCHAR(255) not null,
       IdSubsidiaryId VARCHAR(255) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Active TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (IdOrganizationStructureTypeId, IdParentId, IdSubsidiaryId, Version)
    );

    create table OrganizationStructureTypeEvents (
        Id VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Description VARCHAR(255),
       Active TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (Id, Version)
    );

    create table PartyEvents (
        PartyId VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       PartyTypeId VARCHAR(20),
       PrimaryRoleTypeId VARCHAR(20),
       ExternalId VARCHAR(20),
       PreferredCurrencyUomId VARCHAR(20),
       Description LONGTEXT,
       OrganizationName VARCHAR(255),
       IsSummary TINYINT(1),
       Salutation VARCHAR(100),
       FirstName VARCHAR(100),
       MiddleName VARCHAR(100),
       LastName VARCHAR(100),
       PersonalTitle VARCHAR(100),
       Nickname VARCHAR(100),
       CardId VARCHAR(60),
       Active TINYINT(1),
       IsPropertyPartyTypeIdRemoved TINYINT(1),
       IsPropertyPrimaryRoleTypeIdRemoved TINYINT(1),
       IsPropertyExternalIdRemoved TINYINT(1),
       IsPropertyPreferredCurrencyUomIdRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyOrganizationNameRemoved TINYINT(1),
       IsPropertyIsSummaryRemoved TINYINT(1),
       IsPropertySalutationRemoved TINYINT(1),
       IsPropertyFirstNameRemoved TINYINT(1),
       IsPropertyMiddleNameRemoved TINYINT(1),
       IsPropertyLastNameRemoved TINYINT(1),
       IsPropertyPersonalTitleRemoved TINYINT(1),
       IsPropertyNicknameRemoved TINYINT(1),
       IsPropertyCardIdRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (PartyId, Version)
    );

    create table PartyRoleEvents (
        PartyRoleIdPartyId VARCHAR(20) not null,
       PartyRoleIdRoleTypeId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Active TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (PartyRoleIdPartyId, PartyRoleIdRoleTypeId, Version)
    );

    create table PhysicalInventoryEvents (
        DocumentNumber VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       DocumentStatusId VARCHAR(255),
       WarehouseId VARCHAR(255),
       LocatorIdPattern VARCHAR(255),
       ProductIdPattern VARCHAR(60),
       Posted TINYINT(1),
       Processed TINYINT(1),
       Processing VARCHAR(255),
       DocumentTypeId VARCHAR(255),
       MovementDate DATETIME,
       Description VARCHAR(255),
       IsApproved TINYINT(1),
       ApprovalAmount decimal(18,6),
       IsQuantityUpdated TINYINT(1),
       ReversalDocumentNumber VARCHAR(255),
       Active TINYINT(1),
       IsPropertyDocumentStatusIdRemoved TINYINT(1),
       IsPropertyWarehouseIdRemoved TINYINT(1),
       IsPropertyLocatorIdPatternRemoved TINYINT(1),
       IsPropertyProductIdPatternRemoved TINYINT(1),
       IsPropertyPostedRemoved TINYINT(1),
       IsPropertyProcessedRemoved TINYINT(1),
       IsPropertyProcessingRemoved TINYINT(1),
       IsPropertyDocumentTypeIdRemoved TINYINT(1),
       IsPropertyMovementDateRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyIsApprovedRemoved TINYINT(1),
       IsPropertyApprovalAmountRemoved TINYINT(1),
       IsPropertyIsQuantityUpdatedRemoved TINYINT(1),
       IsPropertyReversalDocumentNumberRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (DocumentNumber, Version)
    );

    create table PhysicalInventoryLineEvents (
        PhysicalInventoryLineIdPhysicalInventoryDocumentNumber VARCHAR(50) not null,
       ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       PhysicalInventoryVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       BookQuantity decimal(18,6),
       CountedQuantity decimal(18,6),
       Processed TINYINT(1),
       LineNumber VARCHAR(50),
       ReversalLineNumber BIGINT,
       Description VARCHAR(255),
       Version BIGINT not null,
       IsPropertyBookQuantityRemoved TINYINT(1),
       IsPropertyCountedQuantityRemoved TINYINT(1),
       IsPropertyProcessedRemoved TINYINT(1),
       IsPropertyLineNumberRemoved TINYINT(1),
       IsPropertyReversalLineNumberRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       primary key (PhysicalInventoryLineIdPhysicalInventoryDocumentNumber, ProductId, LocatorId, AttributeSetInstanceId, PhysicalInventoryVersion),
      unique (LineNumber)
    );

    create table PicklistEvents (
        PicklistId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Description VARCHAR(255),
       FacilityId VARCHAR(20),
       ShipmentMethodTypeId VARCHAR(20),
       StatusId VARCHAR(20),
       PicklistDate DATETIME,
       PickwaveId DECIMAL(20,0),
       Active TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyFacilityIdRemoved TINYINT(1),
       IsPropertyShipmentMethodTypeIdRemoved TINYINT(1),
       IsPropertyStatusIdRemoved TINYINT(1),
       IsPropertyPicklistDateRemoved TINYINT(1),
       IsPropertyPickwaveIdRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (PicklistId, Version)
    );

    create table PicklistRoleEvents (
        PicklistRoleIdPicklistId VARCHAR(20) not null,
       PicklistRoleIdPartyRoleIdPartyId VARCHAR(20) not null,
       PicklistRoleIdPartyRoleIdRoleTypeId VARCHAR(20) not null,
       PicklistVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedByUserLogin VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyActiveRemoved TINYINT(1),
       primary key (PicklistRoleIdPicklistId, PicklistRoleIdPartyRoleIdPartyId, PicklistRoleIdPartyRoleIdRoleTypeId, PicklistVersion)
    );

    create table PicklistBinEvents (
        PicklistBinId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       PicklistId VARCHAR(20),
       BinLocationNumber DECIMAL(20,0),
       PrimaryOrderId VARCHAR(20),
       PrimaryShipGroupSeqId DECIMAL(20,0),
       Active TINYINT(1),
       IsPropertyPicklistIdRemoved TINYINT(1),
       IsPropertyBinLocationNumberRemoved TINYINT(1),
       IsPropertyPrimaryOrderIdRemoved TINYINT(1),
       IsPropertyPrimaryShipGroupSeqIdRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (PicklistBinId, Version)
    );

    create table PicklistItemEvents (
        PicklistBinId VARCHAR(20) not null,
       OrderId VARCHAR(20) not null,
       OrderItemSeqId VARCHAR(20) not null,
       ShipGroupSeqId DECIMAL(20,0) not null,
       ProductId VARCHAR(60) not null,
       LocatorId VARCHAR(50) not null,
       AttributeSetInstanceId VARCHAR(50) not null,
       PicklistBinVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ItemStatusId VARCHAR(20),
       Quantity DECIMAL(18,6),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyItemStatusIdRemoved TINYINT(1),
       IsPropertyQuantityRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (PicklistBinId, OrderId, OrderItemSeqId, ShipGroupSeqId, ProductId, LocatorId, AttributeSetInstanceId, PicklistBinVersion)
    );

    create table PickwaveEvents (
        PickwaveId DECIMAL(20,0) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       StatusId VARCHAR(20),
       Description VARCHAR(255),
       Active TINYINT(1),
       IsPropertyStatusIdRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (PickwaveId, Version)
    );

    create table ProductEvents (
        ProductId VARCHAR(60) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ProductTypeId VARCHAR(20),
       PrimaryProductCategoryId VARCHAR(20),
       ManufacturerPartyId VARCHAR(20),
       FacilityId VARCHAR(20),
       IntroductionDate DATETIME,
       ReleaseDate DATETIME,
       SupportDiscontinuationDate DATETIME,
       SalesDiscontinuationDate DATETIME,
       SalesDiscWhenNotAvail CHAR(1),
       InternalName VARCHAR(255),
       BrandName VARCHAR(100),
       Comments VARCHAR(255),
       ProductName VARCHAR(100),
       Description VARCHAR(255),
       PriceDetailText VARCHAR(255),
       SmallImageUrl VARCHAR(2000),
       MediumImageUrl VARCHAR(2000),
       LargeImageUrl VARCHAR(2000),
       DetailImageUrl VARCHAR(2000),
       OriginalImageUrl VARCHAR(2000),
       DetailScreen VARCHAR(255),
       InventoryMessage VARCHAR(255),
       InventoryItemTypeId VARCHAR(20),
       RequireInventory CHAR(1),
       QuantityUomId VARCHAR(20),
       QuantityIncluded DECIMAL(18,6),
       PiecesIncluded DECIMAL(20,0),
       RequireAmount CHAR(1),
       FixedAmount DECIMAL(18,2),
       AmountUomTypeId VARCHAR(20),
       WeightUomId VARCHAR(20),
       ShippingWeight DECIMAL(18,6),
       ProductWeight DECIMAL(18,6),
       HeightUomId VARCHAR(20),
       ProductHeight DECIMAL(18,6),
       ShippingHeight DECIMAL(18,6),
       WidthUomId VARCHAR(20),
       ProductWidth DECIMAL(18,6),
       ShippingWidth DECIMAL(18,6),
       DepthUomId VARCHAR(20),
       ProductDepth DECIMAL(18,6),
       ShippingDepth DECIMAL(18,6),
       DiameterUomId VARCHAR(20),
       ProductDiameter DECIMAL(18,6),
       ProductRating DECIMAL(18,6),
       RatingTypeEnum VARCHAR(20),
       Returnable CHAR(1),
       Taxable CHAR(1),
       ChargeShipping CHAR(1),
       AutoCreateKeywords CHAR(1),
       IncludeInPromotions CHAR(1),
       IsVirtual CHAR(1),
       IsVariant CHAR(1),
       VirtualVariantMethodEnum VARCHAR(20),
       InShippingBox CHAR(1),
       DefaultShipmentBoxTypeId VARCHAR(20),
       IsSerialNumbered TINYINT(1),
       IsManagedByLot TINYINT(1),
       AttributeSetId VARCHAR(255),
       AttributeSetInstanceId VARCHAR(255),
       Grade VARCHAR(20),
       Gsm DECIMAL(18,6),
       CoreDiameter DECIMAL(18,6),
       OutsideDiameter DECIMAL(18,6),
       MoisturePct DECIMAL(18,6),
       RollCnt VARCHAR(10),
       Active TINYINT(1),
       IsPropertyProductTypeIdRemoved TINYINT(1),
       IsPropertyPrimaryProductCategoryIdRemoved TINYINT(1),
       IsPropertyManufacturerPartyIdRemoved TINYINT(1),
       IsPropertyFacilityIdRemoved TINYINT(1),
       IsPropertyIntroductionDateRemoved TINYINT(1),
       IsPropertyReleaseDateRemoved TINYINT(1),
       IsPropertySupportDiscontinuationDateRemoved TINYINT(1),
       IsPropertySalesDiscontinuationDateRemoved TINYINT(1),
       IsPropertySalesDiscWhenNotAvailRemoved TINYINT(1),
       IsPropertyInternalNameRemoved TINYINT(1),
       IsPropertyBrandNameRemoved TINYINT(1),
       IsPropertyCommentsRemoved TINYINT(1),
       IsPropertyProductNameRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyPriceDetailTextRemoved TINYINT(1),
       IsPropertySmallImageUrlRemoved TINYINT(1),
       IsPropertyMediumImageUrlRemoved TINYINT(1),
       IsPropertyLargeImageUrlRemoved TINYINT(1),
       IsPropertyDetailImageUrlRemoved TINYINT(1),
       IsPropertyOriginalImageUrlRemoved TINYINT(1),
       IsPropertyDetailScreenRemoved TINYINT(1),
       IsPropertyInventoryMessageRemoved TINYINT(1),
       IsPropertyInventoryItemTypeIdRemoved TINYINT(1),
       IsPropertyRequireInventoryRemoved TINYINT(1),
       IsPropertyQuantityUomIdRemoved TINYINT(1),
       IsPropertyQuantityIncludedRemoved TINYINT(1),
       IsPropertyPiecesIncludedRemoved TINYINT(1),
       IsPropertyRequireAmountRemoved TINYINT(1),
       IsPropertyFixedAmountRemoved TINYINT(1),
       IsPropertyAmountUomTypeIdRemoved TINYINT(1),
       IsPropertyWeightUomIdRemoved TINYINT(1),
       IsPropertyShippingWeightRemoved TINYINT(1),
       IsPropertyProductWeightRemoved TINYINT(1),
       IsPropertyHeightUomIdRemoved TINYINT(1),
       IsPropertyProductHeightRemoved TINYINT(1),
       IsPropertyShippingHeightRemoved TINYINT(1),
       IsPropertyWidthUomIdRemoved TINYINT(1),
       IsPropertyProductWidthRemoved TINYINT(1),
       IsPropertyShippingWidthRemoved TINYINT(1),
       IsPropertyDepthUomIdRemoved TINYINT(1),
       IsPropertyProductDepthRemoved TINYINT(1),
       IsPropertyShippingDepthRemoved TINYINT(1),
       IsPropertyDiameterUomIdRemoved TINYINT(1),
       IsPropertyProductDiameterRemoved TINYINT(1),
       IsPropertyProductRatingRemoved TINYINT(1),
       IsPropertyRatingTypeEnumRemoved TINYINT(1),
       IsPropertyReturnableRemoved TINYINT(1),
       IsPropertyTaxableRemoved TINYINT(1),
       IsPropertyChargeShippingRemoved TINYINT(1),
       IsPropertyAutoCreateKeywordsRemoved TINYINT(1),
       IsPropertyIncludeInPromotionsRemoved TINYINT(1),
       IsPropertyIsVirtualRemoved TINYINT(1),
       IsPropertyIsVariantRemoved TINYINT(1),
       IsPropertyVirtualVariantMethodEnumRemoved TINYINT(1),
       IsPropertyInShippingBoxRemoved TINYINT(1),
       IsPropertyDefaultShipmentBoxTypeIdRemoved TINYINT(1),
       IsPropertyIsSerialNumberedRemoved TINYINT(1),
       IsPropertyIsManagedByLotRemoved TINYINT(1),
       IsPropertyAttributeSetIdRemoved TINYINT(1),
       IsPropertyAttributeSetInstanceIdRemoved TINYINT(1),
       IsPropertyGradeRemoved TINYINT(1),
       IsPropertyGsmRemoved TINYINT(1),
       IsPropertyCoreDiameterRemoved TINYINT(1),
       IsPropertyOutsideDiameterRemoved TINYINT(1),
       IsPropertyMoisturePctRemoved TINYINT(1),
       IsPropertyRollCntRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ProductId, Version)
    );

    create table ProductCategoryEvents (
        ProductCategoryId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ProductCategoryTypeId VARCHAR(20),
       PrimaryParentCategoryId VARCHAR(20),
       CategoryName VARCHAR(100),
       Description VARCHAR(255),
       CategoryImageUrl VARCHAR(2000),
       DetailScreen VARCHAR(255),
       ShowInSelect TINYINT(1),
       AttributeSetId VARCHAR(255),
       Active TINYINT(1),
       IsPropertyProductCategoryTypeIdRemoved TINYINT(1),
       IsPropertyPrimaryParentCategoryIdRemoved TINYINT(1),
       IsPropertyCategoryNameRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyCategoryImageUrlRemoved TINYINT(1),
       IsPropertyDetailScreenRemoved TINYINT(1),
       IsPropertyShowInSelectRemoved TINYINT(1),
       IsPropertyAttributeSetIdRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ProductCategoryId, Version)
    );

    create table ProductCategoryMemberEvents (
        ProductCategoryMemberIdProductCategoryId VARCHAR(20) not null,
       ProductCategoryMemberIdProductId VARCHAR(60) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ThruDate DATETIME,
       Comments VARCHAR(255),
       SequenceNum DECIMAL(20,0),
       Quantity DECIMAL(18,6),
       Active TINYINT(1),
       IsPropertyThruDateRemoved TINYINT(1),
       IsPropertyCommentsRemoved TINYINT(1),
       IsPropertySequenceNumRemoved TINYINT(1),
       IsPropertyQuantityRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ProductCategoryMemberIdProductCategoryId, ProductCategoryMemberIdProductId, Version)
    );

    create table RejectionReasonEvents (
        RejectionReasonId VARCHAR(60) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Description VARCHAR(255),
       Active TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (RejectionReasonId, Version)
    );

    create table RoleTypeEvents (
        RoleTypeId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ParentTypeId VARCHAR(20),
       HasTable CHAR(1),
       Description VARCHAR(255),
       Active TINYINT(1),
       IsPropertyParentTypeIdRemoved TINYINT(1),
       IsPropertyHasTableRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (RoleTypeId, Version)
    );

    create table ShipmentEvents (
        ShipmentId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ShipmentTypeId VARCHAR(20),
       StatusId VARCHAR(20),
       PrimaryOrderId VARCHAR(20),
       PrimaryReturnId VARCHAR(20),
       PrimaryShipGroupSeqId DECIMAL(20,0),
       PicklistBinId VARCHAR(20),
       BolNumber VARCHAR(60),
       SealNumber VARCHAR(60),
       VehicleId VARCHAR(60),
       ExternalOrderNumber VARCHAR(60),
       Carrier VARCHAR(60),
       DateShipped DATETIME,
       EstimatedReadyDate DATETIME,
       EstimatedShipDate DATETIME,
       EstimatedShipWorkEffId VARCHAR(20),
       EstimatedArrivalDate DATETIME,
       EstimatedArrivalWorkEffId VARCHAR(20),
       LatestCancelDate DATETIME,
       EstimatedShipCost DECIMAL(18,2),
       CurrencyUomId VARCHAR(20),
       HandlingInstructions VARCHAR(255),
       OriginFacilityId VARCHAR(20),
       DestinationFacilityId VARCHAR(20),
       OriginContactMechId VARCHAR(20),
       OriginTelecomNumberId VARCHAR(20),
       DestinationContactMechId VARCHAR(20),
       DestinationTelecomNumberId VARCHAR(20),
       PartyIdTo VARCHAR(20),
       PartyIdFrom VARCHAR(20),
       AdditionalShippingCharge DECIMAL(18,2),
       AddtlShippingChargeDesc VARCHAR(255),
       Active TINYINT(1),
       IsPropertyShipmentTypeIdRemoved TINYINT(1),
       IsPropertyStatusIdRemoved TINYINT(1),
       IsPropertyPrimaryOrderIdRemoved TINYINT(1),
       IsPropertyPrimaryReturnIdRemoved TINYINT(1),
       IsPropertyPrimaryShipGroupSeqIdRemoved TINYINT(1),
       IsPropertyPicklistBinIdRemoved TINYINT(1),
       IsPropertyBolNumberRemoved TINYINT(1),
       IsPropertySealNumberRemoved TINYINT(1),
       IsPropertyVehicleIdRemoved TINYINT(1),
       IsPropertyExternalOrderNumberRemoved TINYINT(1),
       IsPropertyCarrierRemoved TINYINT(1),
       IsPropertyDateShippedRemoved TINYINT(1),
       IsPropertyEstimatedReadyDateRemoved TINYINT(1),
       IsPropertyEstimatedShipDateRemoved TINYINT(1),
       IsPropertyEstimatedShipWorkEffIdRemoved TINYINT(1),
       IsPropertyEstimatedArrivalDateRemoved TINYINT(1),
       IsPropertyEstimatedArrivalWorkEffIdRemoved TINYINT(1),
       IsPropertyLatestCancelDateRemoved TINYINT(1),
       IsPropertyEstimatedShipCostRemoved TINYINT(1),
       IsPropertyCurrencyUomIdRemoved TINYINT(1),
       IsPropertyHandlingInstructionsRemoved TINYINT(1),
       IsPropertyOriginFacilityIdRemoved TINYINT(1),
       IsPropertyDestinationFacilityIdRemoved TINYINT(1),
       IsPropertyOriginContactMechIdRemoved TINYINT(1),
       IsPropertyOriginTelecomNumberIdRemoved TINYINT(1),
       IsPropertyDestinationContactMechIdRemoved TINYINT(1),
       IsPropertyDestinationTelecomNumberIdRemoved TINYINT(1),
       IsPropertyPartyIdToRemoved TINYINT(1),
       IsPropertyPartyIdFromRemoved TINYINT(1),
       IsPropertyAdditionalShippingChargeRemoved TINYINT(1),
       IsPropertyAddtlShippingChargeDescRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ShipmentId, Version)
    );

    create table ShipmentItemEvents (
        ShipmentItemIdShipmentId VARCHAR(20) not null,
       ShipmentItemIdShipmentItemSeqId VARCHAR(20) not null,
       ShipmentVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ProductId VARCHAR(60),
       AttributeSetInstanceId VARCHAR(255),
       Quantity DECIMAL(18,6),
       ShipmentContentDescription VARCHAR(255),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyProductIdRemoved TINYINT(1),
       IsPropertyAttributeSetInstanceIdRemoved TINYINT(1),
       IsPropertyQuantityRemoved TINYINT(1),
       IsPropertyShipmentContentDescriptionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ShipmentItemIdShipmentId, ShipmentItemIdShipmentItemSeqId, ShipmentVersion)
    );

    create table ShipmentReceiptEvents (
        ShipmentReceiptIdShipmentId VARCHAR(20) not null,
       ShipmentReceiptIdReceiptSeqId VARCHAR(20) not null,
       ShipmentVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ProductId VARCHAR(60),
       AttributeSetInstanceId VARCHAR(255),
       LocatorId VARCHAR(255),
       ShipmentItemSeqId VARCHAR(20),
       ShipmentPackageSeqId VARCHAR(20),
       OrderId VARCHAR(20),
       OrderItemSeqId VARCHAR(20),
       ReturnId VARCHAR(20),
       ReturnItemSeqId VARCHAR(20),
       RejectionReasonId VARCHAR(60),
       DamageReasonId VARCHAR(60),
       ReceivedBy VARCHAR(250),
       DatetimeReceived DATETIME,
       ItemDescription VARCHAR(255),
       AcceptedQuantity DECIMAL(18,6),
       RejectedQuantity DECIMAL(18,6),
       DamagedQuantity DECIMAL(18,6),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyProductIdRemoved TINYINT(1),
       IsPropertyAttributeSetInstanceIdRemoved TINYINT(1),
       IsPropertyLocatorIdRemoved TINYINT(1),
       IsPropertyShipmentItemSeqIdRemoved TINYINT(1),
       IsPropertyShipmentPackageSeqIdRemoved TINYINT(1),
       IsPropertyOrderIdRemoved TINYINT(1),
       IsPropertyOrderItemSeqIdRemoved TINYINT(1),
       IsPropertyReturnIdRemoved TINYINT(1),
       IsPropertyReturnItemSeqIdRemoved TINYINT(1),
       IsPropertyRejectionReasonIdRemoved TINYINT(1),
       IsPropertyDamageReasonIdRemoved TINYINT(1),
       IsPropertyReceivedByRemoved TINYINT(1),
       IsPropertyDatetimeReceivedRemoved TINYINT(1),
       IsPropertyItemDescriptionRemoved TINYINT(1),
       IsPropertyAcceptedQuantityRemoved TINYINT(1),
       IsPropertyRejectedQuantityRemoved TINYINT(1),
       IsPropertyDamagedQuantityRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId, ShipmentVersion)
    );

    create table ShipmentReceiptStateEventDamageStatusIds (
        ShipmentReceiptIdShipmentId VARCHAR(255) not null,
       ShipmentReceiptIdReceiptSeqId VARCHAR(255) not null,
       ShipmentVersion BIGINT not null,
       DamageStatusIdsItem VARCHAR(255) not null,
       primary key (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId, ShipmentVersion, DamageStatusIdsItem)
    );

    create table ItemIssuanceEvents (
        ShipmentItemIssuanceIdShipmentId VARCHAR(20) not null,
       ShipmentItemIssuanceIdItemIssuanceSeqId VARCHAR(20) not null,
       ShipmentVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       OrderId VARCHAR(20),
       OrderItemSeqId VARCHAR(20),
       ShipGroupSeqId DECIMAL(20,0),
       ProductId VARCHAR(60),
       LocatorId VARCHAR(50),
       AttributeSetInstanceId VARCHAR(50),
       ShipmentItemSeqId VARCHAR(20),
       FixedAssetId VARCHAR(20),
       MaintHistSeqId VARCHAR(20),
       IssuedDateTime DATETIME,
       IssuedByUserLoginId VARCHAR(250),
       Quantity DECIMAL(18,6),
       CancelQuantity DECIMAL(18,6),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyOrderIdRemoved TINYINT(1),
       IsPropertyOrderItemSeqIdRemoved TINYINT(1),
       IsPropertyShipGroupSeqIdRemoved TINYINT(1),
       IsPropertyProductIdRemoved TINYINT(1),
       IsPropertyLocatorIdRemoved TINYINT(1),
       IsPropertyAttributeSetInstanceIdRemoved TINYINT(1),
       IsPropertyShipmentItemSeqIdRemoved TINYINT(1),
       IsPropertyFixedAssetIdRemoved TINYINT(1),
       IsPropertyMaintHistSeqIdRemoved TINYINT(1),
       IsPropertyIssuedDateTimeRemoved TINYINT(1),
       IsPropertyIssuedByUserLoginIdRemoved TINYINT(1),
       IsPropertyQuantityRemoved TINYINT(1),
       IsPropertyCancelQuantityRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ShipmentItemIssuanceIdShipmentId, ShipmentItemIssuanceIdItemIssuanceSeqId, ShipmentVersion)
    );

    create table ShipmentMethodTypeEvents (
        ShipmentMethodTypeId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Description VARCHAR(255),
       SequenceNum DECIMAL(20,0),
       Active TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertySequenceNumRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ShipmentMethodTypeId, Version)
    );

    create table ShipmentPackageEvents (
        ShipmentPackageIdShipmentId VARCHAR(20) not null,
       ShipmentPackageIdShipmentPackageSeqId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ShipmentBoxTypeId VARCHAR(20),
       DateCreated DATETIME,
       BoxLength DECIMAL(18,6),
       BoxHeight DECIMAL(18,6),
       BoxWidth DECIMAL(18,6),
       DimensionUomId VARCHAR(20),
       Weight DECIMAL(18,6),
       WeightUomId VARCHAR(20),
       InsuredValue DECIMAL(18,2),
       Active TINYINT(1),
       IsPropertyShipmentBoxTypeIdRemoved TINYINT(1),
       IsPropertyDateCreatedRemoved TINYINT(1),
       IsPropertyBoxLengthRemoved TINYINT(1),
       IsPropertyBoxHeightRemoved TINYINT(1),
       IsPropertyBoxWidthRemoved TINYINT(1),
       IsPropertyDimensionUomIdRemoved TINYINT(1),
       IsPropertyWeightRemoved TINYINT(1),
       IsPropertyWeightUomIdRemoved TINYINT(1),
       IsPropertyInsuredValueRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ShipmentPackageIdShipmentId, ShipmentPackageIdShipmentPackageSeqId, Version)
    );

    create table ShipmentPackageContentEvents (
        ShipmentPackageContentIdShipmentPackageIdShipmentId VARCHAR(20) not null,
       ShipmentPackageContentIdShipmentPackageIdShipmentPackageSeqId VARCHAR(20) not null,
       ShipmentPackageContentIdShipmentItemSeqId VARCHAR(20) not null,
       ShipmentPackageVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Quantity DECIMAL(18,6),
       SubProductId VARCHAR(20),
       SubProductQuantity DECIMAL(18,6),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyQuantityRemoved TINYINT(1),
       IsPropertySubProductIdRemoved TINYINT(1),
       IsPropertySubProductQuantityRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ShipmentPackageContentIdShipmentPackageIdShipmentId, ShipmentPackageContentIdShipmentPackageIdShipmentPackageSeqId, ShipmentPackageContentIdShipmentItemSeqId, ShipmentPackageVersion)
    );

    create table SupplierProductEvents (
        SupplierProductIdProductId VARCHAR(60) not null,
       SupplierProductIdPartyId VARCHAR(20) not null,
       SupplierProductIdCurrencyUomId VARCHAR(20) not null,
       SupplierProductIdMinimumOrderQuantity DECIMAL(18,6) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       AvailableThruDate DATETIME,
       SupplierPrefOrderId VARCHAR(20),
       SupplierRatingTypeId VARCHAR(20),
       StandardLeadTimeDays DECIMAL(18,6),
       ManufacturingLeadTimeDays DECIMAL(18,6),
       DeliveryLeadTimeDays DECIMAL(18,6),
       QuantityUomId VARCHAR(20),
       LastPrice DECIMAL(18,3),
       ShippingPrice DECIMAL(18,3),
       ExternalProductName VARCHAR(100),
       ExternalProductId VARCHAR(60),
       CanDropShip TINYINT(1),
       Comments VARCHAR(255),
       Active TINYINT(1),
       IsPropertyAvailableThruDateRemoved TINYINT(1),
       IsPropertySupplierPrefOrderIdRemoved TINYINT(1),
       IsPropertySupplierRatingTypeIdRemoved TINYINT(1),
       IsPropertyStandardLeadTimeDaysRemoved TINYINT(1),
       IsPropertyManufacturingLeadTimeDaysRemoved TINYINT(1),
       IsPropertyDeliveryLeadTimeDaysRemoved TINYINT(1),
       IsPropertyQuantityUomIdRemoved TINYINT(1),
       IsPropertyLastPriceRemoved TINYINT(1),
       IsPropertyShippingPriceRemoved TINYINT(1),
       IsPropertyExternalProductNameRemoved TINYINT(1),
       IsPropertyExternalProductIdRemoved TINYINT(1),
       IsPropertyCanDropShipRemoved TINYINT(1),
       IsPropertyCommentsRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (SupplierProductIdProductId, SupplierProductIdPartyId, SupplierProductIdCurrencyUomId, SupplierProductIdMinimumOrderQuantity, Version)
    );

    create table UomEvents (
        UomId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       UomTypeId VARCHAR(20),
       Abbreviation VARCHAR(60),
       Description VARCHAR(255),
       Active TINYINT(1),
       IsPropertyUomTypeIdRemoved TINYINT(1),
       IsPropertyAbbreviationRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (UomId, Version)
    );

    create table UomConversionEvents (
        UomConversionIdUomId VARCHAR(20) not null,
       UomConversionIdUomIdTo VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ConversionFactor DOUBLE,
       CustomMethodId VARCHAR(20),
       DecimalScale DECIMAL(20,0),
       RoundingMode VARCHAR(20),
       Active TINYINT(1),
       IsPropertyConversionFactorRemoved TINYINT(1),
       IsPropertyCustomMethodIdRemoved TINYINT(1),
       IsPropertyDecimalScaleRemoved TINYINT(1),
       IsPropertyRoundingModeRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (UomConversionIdUomId, UomConversionIdUomIdTo, Version)
    );

    create table WarehouseEvents (
        WarehouseId VARCHAR(50) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       WarehouseName VARCHAR(255),
       Description VARCHAR(255),
       IsInTransit TINYINT(1),
       Active TINYINT(1),
       IsPropertyWarehouseNameRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyIsInTransitRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (WarehouseId, Version)
    );

    create table GoodIdentificationTypes (
        GoodIdentificationTypeId VARCHAR(20) not null,
       Version BIGINT not null,
       ParentTypeId VARCHAR(20),
       HasTable CHAR(1),
       Description VARCHAR(255),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (GoodIdentificationTypeId)
    );

    create table GoodIdentificationTypeEvents (
        GoodIdentificationTypeId VARCHAR(20) not null,
       Version BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       ParentTypeId VARCHAR(20),
       HasTable CHAR(1),
       Description VARCHAR(255),
       Active TINYINT(1),
       IsPropertyParentTypeIdRemoved TINYINT(1),
       IsPropertyHasTableRemoved TINYINT(1),
       IsPropertyDescriptionRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (GoodIdentificationTypeId, Version)
    );

    create table GoodIdentifications (
        ProductGoodIdentificationIdProductId VARCHAR(60) not null,
       ProductGoodIdentificationIdGoodIdentificationTypeId VARCHAR(20) not null,
       Version BIGINT not null,
       IdValue VARCHAR(60) not null,
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ProductGoodIdentificationIdProductId, ProductGoodIdentificationIdGoodIdentificationTypeId)
    );

    create table GoodIdentificationEvents (
        ProductGoodIdentificationIdProductId VARCHAR(60) not null,
       ProductGoodIdentificationIdGoodIdentificationTypeId VARCHAR(20) not null,
       ProductVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       IdValue VARCHAR(60),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyIdValueRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ProductGoodIdentificationIdProductId, ProductGoodIdentificationIdGoodIdentificationTypeId, ProductVersion)
    );

    create table InOutImages (
        InOutImageIdInOutDocumentNumber VARCHAR(50) not null,
       InOutImageIdSequenceId VARCHAR(60) not null,
       Version BIGINT not null,
       Url VARCHAR(250),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (InOutImageIdInOutDocumentNumber, InOutImageIdSequenceId)
    );

    create table InOutImageEvents (
        InOutImageIdInOutDocumentNumber VARCHAR(50) not null,
       InOutImageIdSequenceId VARCHAR(60) not null,
       InOutVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Url VARCHAR(250),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyUrlRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (InOutImageIdInOutDocumentNumber, InOutImageIdSequenceId, InOutVersion)
    );

    create table InOutLineImages (
        InOutLineImageIdInOutDocumentNumber VARCHAR(50) not null,
       InOutLineImageIdInOutLineLineNumber VARCHAR(50) not null,
       InOutLineImageIdSequenceId VARCHAR(60) not null,
       Version BIGINT not null,
       Url VARCHAR(250),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (InOutLineImageIdInOutDocumentNumber, InOutLineImageIdInOutLineLineNumber, InOutLineImageIdSequenceId)
    );

    create table InOutLineImageEvents (
        InOutLineImageIdInOutDocumentNumber VARCHAR(50) not null,
       InOutLineImageIdInOutLineLineNumber VARCHAR(50) not null,
       InOutLineImageIdSequenceId VARCHAR(60) not null,
       InOutVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Url VARCHAR(250),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyUrlRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (InOutLineImageIdInOutDocumentNumber, InOutLineImageIdInOutLineLineNumber, InOutLineImageIdSequenceId, InOutVersion)
    );

    create table ShipmentImages (
        ShipmentImageIdShipmentId VARCHAR(20) not null,
       ShipmentImageIdSequenceId VARCHAR(60) not null,
       Version BIGINT not null,
       Url VARCHAR(250),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ShipmentImageIdShipmentId, ShipmentImageIdSequenceId)
    );

    create table ShipmentImageEvents (
        ShipmentImageIdShipmentId VARCHAR(20) not null,
       ShipmentImageIdSequenceId VARCHAR(60) not null,
       ShipmentVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Url VARCHAR(250),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyUrlRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ShipmentImageIdShipmentId, ShipmentImageIdSequenceId, ShipmentVersion)
    );

    create table ShipmentReceiptImages (
        ShipmentReceiptImageIdShipmentId VARCHAR(20) not null,
       ShipmentReceiptImageIdShipmentReceiptReceiptSeqId VARCHAR(20) not null,
       ShipmentReceiptImageIdSequenceId VARCHAR(60) not null,
       Version BIGINT not null,
       Url VARCHAR(250),
       CreatedBy VARCHAR(255),
       UpdatedBy VARCHAR(255),
       Active TINYINT(1),
       Deleted TINYINT(1),
       CreatedAt DATETIME,
       UpdatedAt DATETIME,
       primary key (ShipmentReceiptImageIdShipmentId, ShipmentReceiptImageIdShipmentReceiptReceiptSeqId, ShipmentReceiptImageIdSequenceId)
    );

    create table ShipmentReceiptImageEvents (
        ShipmentReceiptImageIdShipmentId VARCHAR(20) not null,
       ShipmentReceiptImageIdShipmentReceiptReceiptSeqId VARCHAR(20) not null,
       ShipmentReceiptImageIdSequenceId VARCHAR(60) not null,
       ShipmentVersion BIGINT not null,
       EventType VARCHAR(255) not null,
       CreatedBy VARCHAR(255),
       CreatedAt DATETIME,
       CommandId VARCHAR(255),
       Url VARCHAR(250),
       Active TINYINT(1),
       Version BIGINT not null,
       IsPropertyUrlRemoved TINYINT(1),
       IsPropertyActiveRemoved TINYINT(1),
       primary key (ShipmentReceiptImageIdShipmentId, ShipmentReceiptImageIdShipmentReceiptReceiptSeqId, ShipmentReceiptImageIdSequenceId, ShipmentVersion)
    );

    alter table AttributeSetInstanceStatusIds 
        add index (AttributeSetInstanceId), 
        add constraint FK6CFC352E46B90463 
        foreign key (AttributeSetInstanceId) 
        references AttributeSetInstances (AttributeSetInstanceId);

    alter table InOutLineDamageStatusIds 
        add index (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber), 
        add constraint FK9F1B674E77BC4BCB 
        foreign key (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber) 
        references InOutLines (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber);

    alter table ShipmentReceiptDamageStatusIds 
        add index (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId), 
        add constraint FKB9FCE6E151B2BEEA 
        foreign key (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId) 
        references ShipmentReceipts (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId);

    alter table InOutLineStateEventDamageStatusIds 
        add index (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber, InOutVersion), 
        add constraint FK5BAF3ED4782FA244 
        foreign key (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber, InOutVersion) 
        references InOutLineEvents (InOutLineIdInOutDocumentNumber, InOutLineIdLineNumber, InOutVersion);

    alter table ShipmentReceiptStateEventDamageStatusIds 
        add index (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId, ShipmentVersion), 
        add constraint FK4AE85BEE4BB9F015 
        foreign key (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId, ShipmentVersion) 
        references ShipmentReceiptEvents (ShipmentReceiptIdShipmentId, ShipmentReceiptIdReceiptSeqId, ShipmentVersion);

    create table nhibernate_hilo_table (
         next_val BIGINT 
    );

    insert into nhibernate_hilo_table values ( 1 );
